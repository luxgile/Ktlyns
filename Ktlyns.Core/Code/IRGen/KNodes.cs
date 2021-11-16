using LLVMSharp.Interop;
using LLVMSharp;
using System.Collections.Generic;
using System;
using System.Linq;

namespace Kat
{

    public class IRGenException : System.Exception
    {
        public IRGenException(string msg) : base(msg) { }
    }

    public abstract class KNode
    {
        public virtual void IRSetup(CodeGenContext context) { }
        public virtual LLVMValueRef GenLhs(CodeGenContext context) { throw new NotImplementedException(); }
        public virtual LLVMValueRef GenRhs(CodeGenContext context) { throw new NotImplementedException(); }
    }

    public abstract class KExpr : KNode
    {
        public virtual KTypeData TypeData { get; private set; }
        public KExpr(KTypeData type) { TypeData = type; }
        public void SetType(KTypeData type)
        {
            TypeData = type;
        }
    }

    public class KCustomExpr : KExpr
    {
        public Func<LLVMValueRef> LhsGen;
        public Func<LLVMValueRef> RhsGen;
        public KCustomExpr() : base(KTypeData.VoidType) { }
        public override LLVMValueRef GenLhs(CodeGenContext context)
        {
            return LhsGen();
        }
        public override LLVMValueRef GenRhs(CodeGenContext context)
        {
            return RhsGen();
        }
    }

    public abstract class KStmt : KNode
    {
        //Statements only have lhs generation
        public sealed override LLVMValueRef GenRhs(CodeGenContext context)
        {
            return GenLhs(context);
        }
    }

    public class KIfElse : KStmt
    {
        public KExpr Condition { get; set; }
        public KBlock IfBlock { get; set; }
        public KBlock ElseBlock { get; set; }
        public override void IRSetup(CodeGenContext context)
        {
            base.IRSetup(context);

            Condition.IRSetup(context);
            IfBlock.IRSetup(context);
            ElseBlock?.IRSetup(context);
        }
        public override LLVMValueRef GenLhs(CodeGenContext context)
        {
            //Right now all blocks need to return a value, they can't go back to the parent block. So once you are inside an if you can't get out of it without returning and exiting the method.

            bool hasElse = ElseBlock != null;

            LLVMBasicBlockRef ifBlock = context.CurrentFunc.AppendBasicBlock("if_block");
            LLVMBasicBlockRef elseBlock = default;

            if (hasElse)
                elseBlock = context.CurrentFunc.AppendBasicBlock("else_block");

            LLVMBasicBlockRef afterBlock = context.CurrentFunc.AppendBasicBlock("if_after_block");

            LLVMValueRef branch = context.builder.BuildCondBr(Condition.GenRhs(context), ifBlock, hasElse ? elseBlock : afterBlock);

            context.builder.PositionAtEnd(ifBlock);
            IfBlock.GenLhs(context);

            //if (!context.PathCompleted)
            context.builder.BuildBr(afterBlock);

            if (hasElse)
            {
                context.builder.PositionAtEnd(elseBlock);
                ElseBlock.GenLhs(context);
                context.builder.BuildBr(afterBlock);
            }

            context.builder.PositionAtEnd(afterBlock);

            return branch;
        }
    }

    public class KLoop : KStmt
    {
        public KExpr Expr1 { get; set; }
        public KExpr Expr2 { get; set; }
        public KBlock Block { get; set; }

        private static LLVMValueRef Dummy1 = LLVMValueRef.CreateConstInt(LLVMTypeRef.Int32, 1u);

        public override void IRSetup(CodeGenContext context)
        {
            base.IRSetup(context);

            Expr1.IRSetup(context);
            Expr2?.IRSetup(context);
            Block.IRSetup(context);
        }

        public override LLVMValueRef GenLhs(CodeGenContext context)
        {
            if (Expr1 != null)
            {
                if (Expr2 == null)
                    return CodeGenOnlyConditional(context);
                else
                    return CodeGenOnlyIteration(context);
            }

            throw new IRGenException("Cannot create a loop without any expressions.");
        }

        private LLVMValueRef CodeGenOnlyConditional(CodeGenContext context)
        {
            LLVMBasicBlockRef condBlock = context.CurrentFunc.AppendBasicBlock("loop_cond");
            LLVMBasicBlockRef loopBlock = context.CurrentFunc.AppendBasicBlock("loop_block");
            LLVMBasicBlockRef afterBlock = context.CurrentFunc.AppendBasicBlock("loop_after_block");

            context.builder.BuildBr(condBlock);

            context.SetBlocks(loopBlock, afterBlock);
            //Conditional block
            context.builder.PositionAtEnd(condBlock);
            context.builder.BuildCondBr(Expr1.GenRhs(context), loopBlock, afterBlock);

            //Loop block
            context.builder.PositionAtEnd(loopBlock);
            Block.GenRhs(context);
            //if (!context.PathCompleted)
            context.builder.BuildBr(condBlock);

            context.PathCompleted = false;

            context.builder.PositionAtEnd(afterBlock);
            return default;
        }

        private LLVMValueRef CodeGenOnlyIteration(CodeGenContext context)
        {
            LLVMBasicBlockRef condBlock = context.CurrentFunc.AppendBasicBlock("loop_cond");
            LLVMBasicBlockRef loopBlock = context.CurrentFunc.AppendBasicBlock("loop_block");
            LLVMBasicBlockRef afterBlock = context.CurrentFunc.AppendBasicBlock("loop_after_block");

            //Here we are assuming that expr1 is less than expr2 and both are ints.
            LLVMValueRef min = Expr1.GenRhs(context);
            LLVMValueRef max = Expr2.GenRhs(context);

            //Loop counter, starts at min
            LLVMValueRef count = context.builder.BuildAlloca(LLVMTypeRef.Int32, "i");
            context.builder.BuildStore(min, count);

            context.builder.BuildBr(condBlock);

            //Conditional block
            context.SetBlocks(loopBlock, afterBlock);
            context.builder.PositionAtEnd(condBlock);
            LLVMValueRef compare = context.builder.BuildICmp(LLVMIntPredicate.LLVMIntSLT, context.builder.BuildLoad(count), max);
            context.builder.BuildCondBr(compare, loopBlock, afterBlock);

            //Loop block
            context.builder.PositionAtEnd(loopBlock);
            Block.GenLhs(context);
            context.builder.BuildStore(context.builder.BuildAdd(context.builder.BuildLoad(count), Dummy1), count);
            if (!context.PathCompleted)
                context.builder.BuildBr(condBlock);

            context.PathCompleted = false;

            context.builder.PositionAtEnd(afterBlock);
            return default;
        }
    }

    public class KLoopBreak : KStmt
    {
        public override LLVMValueRef GenLhs(CodeGenContext context)
        {
            context.PathCompleted = true;
            return context.builder.BuildBr(context.ExitLoopBlock);
        }
    }

    public class KExprStmt : KStmt
    {
        public KExpr Expr { get; set; }
        public override void IRSetup(CodeGenContext context)
        {
            base.IRSetup(context);

            Expr.IRSetup(context);
        }
        public override LLVMValueRef GenLhs(CodeGenContext context)
        {
            return Expr.GenRhs(context);
        }
    }

    public class KDec : KExpr
    {
        public double Value { get; set; }
        public KDec() : base(KTypeData.DecType) { }
        public override LLVMValueRef GenLhs(CodeGenContext context)
        {
            throw new IRGenException("Decimal numbers cannot be generated as LHS");
        }
        public override LLVMValueRef GenRhs(CodeGenContext context)
        {
            return LLVMValueRef.CreateConstReal(LLVMTypeRef.Double, Value);
        }
    }

    public class KInt : KExpr
    {
        public int Value { get; set; }
        public KInt() : base(KTypeData.IntType) { }
        public override LLVMValueRef GenLhs(CodeGenContext context)
        {
            throw new IRGenException("Int numbers cannot be generated as LHS");
        }
        public override LLVMValueRef GenRhs(CodeGenContext context)
        {
            return LLVMValueRef.CreateConstInt(LLVMTypeRef.Int32, (ulong)Value, true);
        }
    }

    public class KBool : KExpr
    {
        public bool Value { get; set; }
        public KBool() : base(KTypeData.BoolType) { }
        public override LLVMValueRef GenLhs(CodeGenContext context)
        {
            throw new IRGenException("Bool cannot be generated as LHS");
        }
        public override LLVMValueRef GenRhs(CodeGenContext context)
        {
            return LLVMValueRef.CreateConstInt(LLVMTypeRef.Int1, Value ? 1u : 0u, true);
        }
    }

    public class KChar : KExpr
    {
        public char Value { get; init; }
        public KChar(char value) : base(KTypeData.CharType) { Value = value; }
        public override LLVMValueRef GenLhs(CodeGenContext context)
        {
            throw new IRGenException("Char cannot be generated as LHS");
        }
        public override LLVMValueRef GenRhs(CodeGenContext context)
        {
            return LLVMValueRef.CreateConstInt(LLVMTypeRef.Int16, Value, true);
        }
    }
    public class KStr : KExpr
    {
        public string Value { get; init; }

        public KStr(string value) : base(KTypeData.CreateArray(KTypeData.CharType, (uint)value.Length + 1))
        {
            Value = value + "\0";
        }

        public override LLVMValueRef GenLhs(CodeGenContext context)
        {
            throw new IRGenException("String cannot be generated as LHS");
        }
        public override LLVMValueRef GenRhs(CodeGenContext context)
        {
            //PrintString is only printing the first character.
            return LLVMValueRef.CreateConstArray(KTypeData.CharType.LLVMType
                , Value.Select(x => LLVMValueRef.CreateConstInt(KTypeData.CharType.LLVMType, x, false)).ToArray());
        }
    }

    public class KType : KExpr
    {
        public KTypeData StoredType { get; private set; }

        public KType(KTypeData storedType) : base(KTypeData.MetaType)
        {
            StoredType = storedType;
        }
    }

    public class KId : KExpr
    {
        public IdType IdType { get; set; }
        public string Name { get; set; }

        //Positive number is ammount of *, negative &
        public int PtrCount { get; set; }

        public KId(KId id) : this(id.Name, id.IdType, id.TypeData) { }
        public KId(string name, IdType idType, KTypeData typeData) : base(typeData)
        {
            Name = name;
            IdType = idType;
        }

        public override void IRSetup(CodeGenContext context)
        {
            base.IRSetup(context);

            if (context.Fields.TryGetValue(Name, out _))
                IdType = IdType.Field;
            else if (context.Methods.TryGetValue(Name, out _))
                IdType = IdType.Method;
            else if (TypeTable.TryGetType(Name, out _))
                IdType = IdType.Type;
        }

        public override LLVMValueRef GenLhs(CodeGenContext context)
        {
            return IdType switch
            {
                IdType.Field => GetField(context, -1),
                IdType.Method => GetMethod(context),
                _ => throw new IRGenException("Not valid type for ID"),
            };
        }
        public override LLVMValueRef GenRhs(CodeGenContext context)
        {
            return IdType switch
            {
                IdType.Field => GetField(context, 0),
                IdType.Method => GetMethod(context),
                _ => throw new IRGenException("Not valid type for ID"),
            };
        }

        private LLVMValueRef GetField(CodeGenContext context, int ptrDif)
        {
            if (!context.HasLocal(Name))
                throw new IRGenException($"Undeclared variable {Name}.");

            LLVMValueRef value = context.GetLocal(Name);

            if (value.Kind == LLVMValueKind.LLVMArgumentValueKind)
                return value;

            return ApplyPtrCount(context, value, PtrCount + ptrDif);
        }
        private LLVMValueRef GetMethod(CodeGenContext context)
        {
            if (!context.Methods.TryGetValue(Name, out KMthdDecl mth))
                throw new IRGenException($"Undeclared method {Name}.");

            //TODO: Probably here we need to create a new value or type for the function pointer
            return mth.Func;
        }

        protected LLVMValueRef ApplyPtrCount(CodeGenContext context, LLVMValueRef value, int valuePtr)
        {
            int currPtrCount = valuePtr;
            while (currPtrCount != 0)
            {
                if (currPtrCount > 0) { value = IRGenAPI.GetValueFromPointer(context, value, Name); currPtrCount--; }
                else if (currPtrCount < 0) { value = IRGenAPI.CreatePointerFromValue(context, value); currPtrCount++; }
            }

            return value;
        }
    }

    public class KIdAcc : KId
    {
        public KExpr Index { get; set; }

        public KIdAcc(KId id) : base(id.Name, id.IdType, id.TypeData) { }

        public override void IRSetup(CodeGenContext context)
        {
            base.IRSetup(context);

            Index.IRSetup(context);
        }

        public override LLVMValueRef GenRhs(CodeGenContext context)
        {
            LLVMValueRef value = GetGEP(context);
            value = ApplyPtrCount(context, value, PtrCount);
            return value;
        }
        public override LLVMValueRef GenLhs(CodeGenContext context)
        {
            LLVMValueRef value = context.builder.BuildLoad(GetGEP(context));
            return ApplyPtrCount(context, value, PtrCount);
        }

        public LLVMValueRef GetGEP(CodeGenContext context)
        {
            LLVMValueRef array = context.GetLocal(Name);
            LLVMValueRef indexValue = Index.GenRhs(context);
            return context.builder.BuildInBoundsGEP(array, new LLVMValueRef[] { IRGenAPI.Int32Zero, indexValue });
        }
    }

    public class KMethod : KExpr
    {
        public KId Id { get; init; }
        public List<KExpr> Args { get; init; }
        public KMethod(KId id, List<KExpr> args) : base(id.TypeData)
        {
            Id = id;
            Args = args;
        }

        public override void IRSetup(CodeGenContext context)
        {
            base.IRSetup(context);

            Id.IRSetup(context);
            foreach (KExpr expr in Args)
                expr.IRSetup(context);
        }

        public override LLVMValueRef GenRhs(CodeGenContext context)
        {
            LLVMValueRef function = context.module.GetNamedFunction(Id.Name);

            if (function.Handle == IntPtr.Zero) // Need to find a way to check if a function was found.
            {
                function = Id.GenRhs(context);
                if (function.Handle == IntPtr.Zero)
                    throw new IRGenException($"No function with name {Id.Name} found.");
            }

            List<LLVMValueRef> argsValues = new List<LLVMValueRef>();
            foreach (var arg in Args)
                argsValues.Add(arg.GenRhs(context));

            context.Methods.TryGetValue(Id.Name, out KMthdDecl mth);
            return context.builder.BuildCall(function, argsValues.ToArray(), mth.Type.StoredType.InternalType == KPrimitiveType.Void ? null : Id.Name);
        }
    }

    public class KUnaryOp : KExpr
    {
        public ExprType Op { get; init; }
        public KExpr Rhs { get; init; }

        private static LLVMValueRef dummyInt0 = LLVMValueRef.CreateConstInt(LLVMTypeRef.Int32, 0, false);
        private static LLVMValueRef dummyInt1 = LLVMValueRef.CreateConstInt(LLVMTypeRef.Int1, 1, false);
        private static LLVMValueRef dummyDec0 = LLVMValueRef.CreateConstReal(LLVMTypeRef.Float, 0);

        public KUnaryOp(ExprType op, KExpr rhs) : base(rhs.TypeData) { Op = op; Rhs = rhs; }

        public override void IRSetup(CodeGenContext context)
        {
            base.IRSetup(context);

            Rhs.IRSetup(context);
        }

        public override LLVMValueRef GenRhs(CodeGenContext context)
        {
            LLVMValueRef rhs = Rhs.GenRhs(context);
            bool isInt = rhs.TypeOf.IntWidth > 1;

            return Op switch
            {
                ExprType.Add => BuildBinOp(isInt ? LLVMOpcode.LLVMAdd : LLVMOpcode.LLVMFAdd),
                ExprType.Sub => BuildBinOp(isInt ? LLVMOpcode.LLVMSub : LLVMOpcode.LLVMFSub),
                ExprType.Not => BuildNotOp(),
                _ => throw new IRGenException("Invalid operator"),
            };
            LLVMValueRef BuildBinOp(LLVMOpcode code) => context.builder.BuildBinOp(code, isInt ? dummyInt0 : dummyDec0, Rhs.GenRhs(context), code.ToString().ToLower());
            LLVMValueRef BuildNotOp() => context.builder.BuildBinOp(LLVMOpcode.LLVMSub, dummyInt1, Rhs.GenRhs(context), "not_op");
        }
    }

    public class KBinOp : KExpr
    {
        public ExprType Op { get; set; }
        public KExpr Lhs { get; set; }
        public KExpr Rhs { get; set; }

        public KBinOp(ExprType op, KExpr lhs, KExpr rhs) : base(lhs.TypeData)
        {
            Op = op;
            Lhs = lhs;
            Rhs = rhs;
        }
        public override void IRSetup(CodeGenContext context)
        {
            base.IRSetup(context);

            Lhs.IRSetup(context);
            Rhs.IRSetup(context);
        }

        public override LLVMValueRef GenRhs(CodeGenContext context)
        {
            LLVMValueRef lhs = Lhs.GenRhs(context);
            LLVMValueRef rhs = Rhs.GenRhs(context);
            bool isInt = lhs.TypeOf.IntWidth > 1;

            return Op switch
            {
                ExprType.Add => BuildBinOp(isInt ? LLVMOpcode.LLVMAdd : LLVMOpcode.LLVMFAdd),
                ExprType.Sub => BuildBinOp(isInt ? LLVMOpcode.LLVMSub : LLVMOpcode.LLVMFSub),
                ExprType.Mult => BuildBinOp(isInt ? LLVMOpcode.LLVMMul : LLVMOpcode.LLVMFMul),
                ExprType.Div => BuildBinOp(isInt ? LLVMOpcode.LLVMSDiv : LLVMOpcode.LLVMFDiv),
                ExprType.Eq => isInt ? BuildBinICmp(LLVMIntPredicate.LLVMIntEQ) : BuildBinFCmp(LLVMRealPredicate.LLVMRealOEQ),
                ExprType.NEq => isInt ? BuildBinICmp(LLVMIntPredicate.LLVMIntNE) : BuildBinFCmp(LLVMRealPredicate.LLVMRealONE),
                ExprType.Less => isInt ? BuildBinICmp(LLVMIntPredicate.LLVMIntSLT) : BuildBinFCmp(LLVMRealPredicate.LLVMRealOLT),
                ExprType.ELess => isInt ? BuildBinICmp(LLVMIntPredicate.LLVMIntSLE) : BuildBinFCmp(LLVMRealPredicate.LLVMRealOLE),
                ExprType.Great => isInt ? BuildBinICmp(LLVMIntPredicate.LLVMIntSGT) : BuildBinFCmp(LLVMRealPredicate.LLVMRealOGT),
                ExprType.EGreat => isInt ? BuildBinICmp(LLVMIntPredicate.LLVMIntSGE) : BuildBinFCmp(LLVMRealPredicate.LLVMRealOGE),
                ExprType.And => BuildBinOp(LLVMOpcode.LLVMAnd),
                ExprType.Or => BuildBinOp(LLVMOpcode.LLVMOr),
                _ => throw new IRGenException("Invalid operator"),
            };
            LLVMValueRef BuildBinOp(LLVMOpcode code) => context.builder.BuildBinOp(code, lhs, rhs);
            LLVMValueRef BuildBinICmp(LLVMIntPredicate predicate) => context.builder.BuildICmp(predicate, lhs, rhs);
            LLVMValueRef BuildBinFCmp(LLVMRealPredicate predicate) => context.builder.BuildFCmp(predicate, lhs, rhs);
        }
    }

    public class KAssign : KExpr
    {
        public KId Lhs { get; init; }
        public KExpr Rhs { get; init; }

        public KAssign(KId lhs, KExpr rhs) : base(lhs.TypeData)
        {
            Lhs = lhs;
            Rhs = rhs;
        }

        public override void IRSetup(CodeGenContext context)
        {
            base.IRSetup(context);

            Lhs.IRSetup(context);
            Rhs.IRSetup(context);
        }

        public override LLVMValueRef GenRhs(CodeGenContext context)
        {
            if (!context.HasLocal(Lhs.Name))
                throw new IRGenException($"Undeclared variable {Lhs.Name}.");

            //Lhs always must be a pointer
            LLVMValueRef lhs;
            if (Lhs is KIdAcc acc)
                lhs = acc.GetGEP(context);
            else
                lhs = Lhs.GenLhs(context);

            //Rhs is always the value to add to the pointer
            LLVMValueRef rhs = Rhs.GenRhs(context);

            //If both are arrays, then copy the memory from one to the other
            if (lhs.TypeOf.ElementType.ArrayLength > 0 && rhs.TypeOf.ElementType.ArrayLength > 0)
            {
                LLVMValueRef destBitCast = context.builder.BuildBitCast(lhs, KTypeData.CreatePointer(KTypeData.CreateInt(8)).LLVMType);
                LLVMValueRef sourceBitCast = context.builder.BuildBitCast(rhs, KTypeData.CreatePointer(KTypeData.CreateInt(8)).LLVMType);
                IRGenAPI.CopyMemory(context, destBitCast, sourceBitCast, rhs.TypeOf.ElementType.ArrayLength * rhs.TypeOf.ElementType.ElementType.IntWidth);
            }

            return IRGenAPI.StoreValue(context, lhs, rhs);
        }
    }
    public class KCast : KExpr
    {
        public KExpr Expr { get; init; }
        public KType Cast { get; init; }
        public KCast(KExpr expr, KType cast) : base(cast.StoredType)
        {
            Expr = expr;
            Cast = cast;
        }

        public override void IRSetup(CodeGenContext context)
        {
            base.IRSetup(context);

            Expr.IRSetup(context);
            Cast.IRSetup(context);
        }

        //Cast is not being called
        public override LLVMValueRef GenRhs(CodeGenContext context)
        {
            LLVMValueRef value = Expr.GenRhs(context);

            //ERROR: Both of these are undefined.
            if (Expr.TypeData.Name == Cast.TypeData.Name)
                return value;

            if (Expr.TypeData.InternalType == KPrimitiveType.String &&
            Cast.StoredType.InternalType == KPrimitiveType.Pointer)
                return context.builder.BuildInBoundsGEP(value, new[] { IRGenAPI.Int32Zero, IRGenAPI.Int32Zero });
            return context.builder.BuildCast(GetCode(), value, Cast.StoredType.LLVMType);
        }

        private LLVMOpcode GetCode()
        {
            LLVMTypeRef from = Expr.TypeData.LLVMType;
            LLVMTypeRef to = Cast.StoredType.LLVMType;
            if (from.Kind == LLVMTypeKind.LLVMIntegerTypeKind
                && to.Kind == LLVMTypeKind.LLVMIntegerTypeKind)
            {
                if (from.IntWidth < to.IntWidth)
                    return LLVMOpcode.LLVMTrunc;
                return LLVMOpcode.LLVMZExt;
            }

            //TODO: No clue how to compare between floats
            //if(from.Kind == LLVMTypeKind.LLVMFloatTypeKind
            //    && to.Kind == LLVMTypeKind.LLVMFloatTypeKind)
            //{

            //}

            if (from.Kind == LLVMTypeKind.LLVMIntegerTypeKind && to.Kind == LLVMTypeKind.LLVMFloatTypeKind) return LLVMOpcode.LLVMSIToFP;
            if (from.Kind == LLVMTypeKind.LLVMFloatTypeKind && to.Kind == LLVMTypeKind.LLVMIntegerTypeKind) return LLVMOpcode.LLVMFPToSI;
            if (to.Kind == LLVMTypeKind.LLVMPointerTypeKind) return LLVMOpcode.LLVMBitCast;

            throw new IRGenException($"{Cast} not supported as cast.");
        }
    }

    public class KRet : KExpr
    {
        public KExpr Expr { get; init; }
        public KRet(KExpr expr) : base(expr == null ? KTypeData.VoidType : expr.TypeData)
        {
            Expr = expr;
        }
        public override void IRSetup(CodeGenContext context)
        {
            base.IRSetup(context);

            Expr?.IRSetup(context);
        }
        public override LLVMValueRef GenRhs(CodeGenContext context)
        {
            if (Expr == null) return context.builder.BuildRetVoid();
            return context.builder.BuildRet(Expr.GenRhs(context));
        }
    }

    public class KBlock : KStmt
    {
        public List<KStmt> Statements { get; set; } = new List<KStmt>();
        public override void IRSetup(CodeGenContext context)
        {
            base.IRSetup(context);

            foreach (var stmt in Statements)
                stmt.IRSetup(context);
        }
        public override LLVMValueRef GenLhs(CodeGenContext context)
        {
            LLVMValueRef last = default;
            foreach (var stm in Statements)
                last = stm.GenLhs(context);
            return last;
        }
    }

    public class KVarDecl : KStmt
    {
        public KType Type { get; set; }
        public KId Id { get; set; }
        public KExpr Assignment { get; set; }

        public override void IRSetup(CodeGenContext context)
        {
            base.IRSetup(context);

            Type.IRSetup(context);
            Id.IRSetup(context);
            Assignment?.IRSetup(context);
        }

        public KVarDecl(CodeGenContext context, KId id)
        {
            Id = id;
            //TODO: This should be scoped, otherwise can't use variables with same name in different methods
            //context.Fields.Add(Id.Name, this);
        }
        public override LLVMValueRef GenLhs(CodeGenContext context)
        {
            LLVMValueRef pointer = IRGenAPI.AllocateField(context, Type.StoredType.LLVMType, Id.Name);

            //We store the pointer in the field pool
            context.SetLocal(Id.Name, pointer);

            //Assign cannot be null, but with arrays there's no need to assign anything.
            if (Assignment != null)
            {
                KAssign assign = new KAssign(Id, Assignment);
                assign.GenRhs(context);
            }

            return pointer;
        }
    }
    public class KMthVarDecl : KVarDecl
    {
        public KId[] ParamTypes { get; set; }

        public override void IRSetup(CodeGenContext context)
        {
            base.IRSetup(context);
        }

        public KMthVarDecl(CodeGenContext context, KId id) : base(context, id)
        {
        }
        public override LLVMValueRef GenLhs(CodeGenContext context)
        {
            LLVMTypeRef funcType = TypeTable.CreateFunctionType(Type.TypeData, false, ParamTypes.Select(x => x.TypeData).ToArray());
            LLVMTypeRef funcPointerType = LLVMTypeRef.CreatePointer(funcType, 0);
            LLVMValueRef pointer = IRGenAPI.AllocateField(context, funcPointerType, Id.Name);

            //We store the pointer in the field pool
            context.SetLocal(Id.Name, pointer);

            //Assign cannot be null, but with arrays there's no need to assign anything.
            KAssign assign = new KAssign(Id, Assignment);
            assign.GenRhs(context);

            return pointer;
        }
    }

    public class KMthdDecl : KStmt
    {
        public KType Type { get; set; }
        public KId Id { get; set; }
        public List<KVarDecl> Args { get; set; } = new List<KVarDecl>();
        public KBlock Block { get; set; }

        public bool IsVaradic { get; set; }

        public LLVMValueRef Func { get; private set; }
        private bool isDefined;
        private bool needsBlock;

        public KMthdDecl(CodeGenContext context, KId id, bool needsBlock)
        {
            Id = id;
            this.needsBlock = needsBlock;
            context.Methods.Add(Id.Name, this);
        }

        public override void IRSetup(CodeGenContext context)
        {
            base.IRSetup(context);

            Type.IRSetup(context);
            Id.IRSetup(context);
            Args.ForEach(x => x.IRSetup(context));
            Block?.IRSetup(context);
        }

        public void Define(CodeGenContext context)
        {
            List<KTypeData> argTypes = new();
            for (int i = 0; i < Args.Count; i++)
            {
                KVarDecl arg = Args[i];
                argTypes.Add(arg.Type.StoredType);
            }
            LLVMTypeRef fType = TypeTable.CreateFunctionType(Type.StoredType, IsVaradic, argTypes.ToArray());
            LLVMValueRef func = context.module.AddFunction(Id.Name, fType);
            //if (!needsBlock)
            //    func.DLLStorageClass = LLVMDLLStorageClass.LLVMDLLImportStorageClass;
            Func = func;

            for (int i = 0; i < Args.Count; i++)
                Func.Params[i].Name = Args[i].Id.Name;
            isDefined = true;
        }

        public override LLVMValueRef GenLhs(CodeGenContext context)
        {
            if (!isDefined)
                throw new IRGenException("Method has not been defined before generating block.");

            if (!needsBlock)
                return default;

            //Call this when the function it's defined
            LLVMBasicBlockRef block = Func.AppendBasicBlock("entry");

            context.SetFunc(Func);
            context.builder.PositionAtEnd(block);

            for (int i = 0; i < Args.Count; i++)
            {
                context.AddLocal(Args[i].Id.Name, Func.Params[i]);
                //KVarDecl arg = Args[i];
                //KVarDecl argCopy = new KVarDecl(context, arg.Id)
                //{
                //    Type = arg.Type,
                //    Assignment = new KCustomExpr() { LhsGen = () => Func.Params[i], RhsGen = () => Func.Params[i] }
                //};
                //argCopy.GenLhs(context);
            }

            if (Block == null) throw new IRGenException("Error while creating method declaration. Block is null.");
            Block.GenLhs(context);

            context.ClearFunc();
            return Func;
        }
    }
}
