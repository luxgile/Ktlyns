using LLVMSharp.Interop;
using LLVMSharp;
using System.Collections.Generic;
using System;

namespace Kat
{
    public class IRGenException : System.Exception
    {
        public IRGenException(string msg) : base(msg) { }
    }

    public abstract class KNode
    {
        public virtual LLVMValueRef GenLhs(CodeGenContext context) { throw new NotImplementedException(); }
        public virtual LLVMValueRef GenRhs(CodeGenContext context) { throw new NotImplementedException(); }
    }

    public abstract class KExpr : KNode
    {
    }

    public class KCustomExpr : KExpr
    {
        public Func<LLVMValueRef> LhsGen;
        public Func<LLVMValueRef> RhsGen;

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
        public override LLVMValueRef GenLhs(CodeGenContext context)
        {
            return Expr.GenRhs(context);
        }
    }

    public class KDec : KExpr
    {
        public double Value { get; set; }
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
        public override LLVMValueRef GenLhs(CodeGenContext context)
        {
            throw new IRGenException("Bool cannot be generated as LHS");
        }
        public override LLVMValueRef GenRhs(CodeGenContext context)
        {
            return LLVMValueRef.CreateConstInt(LLVMTypeRef.Int1, Value ? 1u : 0u, true);
        }
    }

    public class KStr : KExpr
    {
        public string Value { get; set; }
        public override LLVMValueRef GenLhs(CodeGenContext context)
        {
            throw new IRGenException("String cannot be generated as LHS");
        }
        public override LLVMValueRef GenRhs(CodeGenContext context)
        {
            //TODO: Add string support.
            return context.builder.BuildGlobalString(Value);
        }
    }

    public class KId : KExpr
    {
        public IdType IdType { get; set; }
        public string Name { get; set; }

        //Positive number is ammount of *, negative &
        public int PtrCount { get; set; }

        private KId retTypeCached;

        public KId(KId id)
        {
            Name = id.Name;
            IdType = id.IdType;
        }
        public KId(string name, IdType idType)
        {
            Name = name;
            IdType = idType;
        }

        public override LLVMValueRef GenLhs(CodeGenContext context)
        {
            if (!context.HasLocal(Name))
                throw new IRGenException($"Undeclared variable {Name}.");

            LLVMValueRef value = context.GetLocal(Name);
            return ApplyPtrCount(context, value, PtrCount - 1);
        }
        public override LLVMValueRef GenRhs(CodeGenContext context)
        {
            if (!context.HasLocal(Name))
                throw new IRGenException($"Undeclared variable {Name}.");

            LLVMValueRef value = context.GetLocal(Name);
            return ApplyPtrCount(context, value, PtrCount);
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

        public KIdAcc(KId id) : base(id.Name, id.IdType) { }

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
            return context.builder.BuildInBoundsGEP(array, new LLVMValueRef[] { LLVMValueRef.CreateConstInt(LLVMTypeRef.Int32, 0), indexValue });
        }
    }

    public class KMethod : KExpr
    {
        public KId Id { get; set; }
        public List<KExpr> Args { get; set; }

        public override LLVMValueRef GenRhs(CodeGenContext context)
        {
            LLVMValueRef function = context.module.GetNamedFunction(Id.Name);
            if (function.IsNull)
                throw new IRGenException($"No function with name {Id.Name} found.");

            List<LLVMValueRef> argsValues = new List<LLVMValueRef>();
            foreach (var arg in Args)
                argsValues.Add(arg.GenRhs(context));

            return context.builder.BuildCall(function, argsValues.ToArray(), Id.Name);
        }
    }

    public class KUnaryOp : KExpr
    {
        public ExprType Op { get; set; }
        public KExpr Rhs { get; set; }

        private static LLVMValueRef dummyInt0 = LLVMValueRef.CreateConstInt(LLVMTypeRef.Int32, 0, false);
        private static LLVMValueRef dummyInt1 = LLVMValueRef.CreateConstInt(LLVMTypeRef.Int1, 1, false);
        private static LLVMValueRef dummyDec0 = LLVMValueRef.CreateConstReal(LLVMTypeRef.Float, 0);

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
        public KId Lhs { get; set; }
        public KExpr Rhs { get; set; }
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
            //if (lhs.TypeOf.Kind == LLVMTypeKind.LLVMPointerTypeKind)
            //{
            //    //Convert pointer to address and address into value
            //    lhs = context.builder.BuildLoad(lhs, Lhs.Name);
            //    //lhs = context.builder.BuildIntToPtr(lhs_Adr, LLVMTypeRef.CreatePointer(TypeTable.GetType(GetReturnType(context)), 0));
            //}

            return IRGenAPI.StoreValue(context, lhs, rhs);
        }
    }

    public class KRet : KExpr
    {
        public KExpr expr;
        public override LLVMValueRef GenRhs(CodeGenContext context)
        {
            if (expr == null) return context.builder.BuildRetVoid();
            return context.builder.BuildRet(expr.GenRhs(context));
        }
    }

    public class KBlock : KStmt
    {
        public List<KStmt> Statements { get; set; } = new List<KStmt>();
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
        public KId Ret { get; set; }
        public KId Id { get; set; }
        public KExpr Assignment { get; set; }

        /// <summary>
        /// Used for arrays
        /// </summary>
        public uint[] ArrayLengths { get; set; }

        public KVarDecl(CodeGenContext context, KId id)
        {
            Id = id;
            //TODO: This should be scoped, otherwise can't use variables with same name in different methods
            //context.Fields.Add(Id.Name, this);
        }
        public override LLVMValueRef GenLhs(CodeGenContext context)
        {
            LLVMTypeRef fieldType = TypeTable.CreateType(Ret, ArrayLengths);
            LLVMValueRef pointer = IRGenAPI.AllocateField(context, fieldType, Id.Name);

            //We store the pointer in the field pool
            context.SetLocal(Id.Name, pointer);

            //Assign cannot be null, but with arrays there's no need to assign anything.
            if (fieldType.ArrayLength == 0 && Assignment != null)
            {
                KAssign assign = new KAssign() { Lhs = Id, Rhs = Assignment };
                assign.GenRhs(context);
            }

            return pointer;
        }
    }

    public class KMthdDecl : KStmt
    {
        public KId Ret { get; set; }
        public KId Id { get; set; }
        public List<KVarDecl> Args { get; set; } = new List<KVarDecl>();
        public KBlock Block { get; set; }

        private LLVMValueRef func;
        private bool isDefined;
        private bool needsBlock;

        public KMthdDecl(CodeGenContext context, KId id, bool needsBlock)
        {
            Id = id;
            this.needsBlock = needsBlock;
            context.Methods.Add(Id.Name, this);
        }

        public void Define(CodeGenContext context)
        {
            List<LLVMTypeRef> argTypes = new();
            for (int i = 0; i < Args.Count; i++)
            {
                KVarDecl arg = Args[i];
                argTypes.Add(TypeTable.CreateType(arg.Ret, new uint[] { }));
            }
            LLVMTypeRef fType = LLVMTypeRef.CreateFunction(TypeTable.GetType(Ret.Name), argTypes.ToArray());
            func = context.module.AddFunction(Id.Name, fType);
            for (int i = 0; i < Args.Count; i++)
                func.Params[i].Name = Args[i].Id.Name;
            isDefined = true;
        }

        public override LLVMValueRef GenLhs(CodeGenContext context)
        {
            if (!isDefined)
                throw new IRGenException("Method has not been defined before generating block.");

            if (!needsBlock)
                return default;

            //Call this when the function it's defined
            LLVMBasicBlockRef block = func.AppendBasicBlock("entry");

            context.SetFunc(func);
            context.builder.PositionAtEnd(block);

            for (int i = 0; i < Args.Count; i++)
            {
                KVarDecl arg = Args[i];
                KVarDecl argCopy = new KVarDecl(context, arg.Id) 
                { 
                    Ret = arg.Ret
                    , ArrayLengths = arg.ArrayLengths
                    , Assignment = new KCustomExpr() { LhsGen = () => func.Params[i], RhsGen = () => func.Params[i] } 
                };
                argCopy.GenLhs(context);
            }

            if (Block == null) throw new IRGenException("Error while creating method declaration. Block is null.");
            Block.GenLhs(context);

            context.ClearFunc();
            return func;
        }
    }
}
