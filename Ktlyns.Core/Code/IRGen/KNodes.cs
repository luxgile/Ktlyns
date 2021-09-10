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
        public abstract LLVMValueRef CodeGen(CodeGenContext context);
    }

    public abstract class KExpr : KNode
    {
        public virtual KValType GetReturnType(CodeGenContext context) => KValType.Void;
        public virtual bool IsPointer { get; } = false;
    }

    public abstract class KStmt : KNode { }

    public class KIfElse : KStmt
    {
        public KExpr Condition { get; set; }
        public KBlock IfBlock { get; set; }
        public KBlock ElseBlock { get; set; }
        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            //Right now all blocks need to return a value, they can't go back to the parent block. So once you are inside an if you can't get out of it without returning and exiting the method.

            bool hasElse = ElseBlock != null;

            LLVMBasicBlockRef ifBlock = context.CurrentFunc.AppendBasicBlock("if_block");
            LLVMBasicBlockRef elseBlock = default;

            if (hasElse)
                elseBlock = context.CurrentFunc.AppendBasicBlock("else_block");

            LLVMBasicBlockRef afterBlock = context.CurrentFunc.AppendBasicBlock("after_block");

            LLVMValueRef branch = context.builder.BuildCondBr(Condition.CodeGen(context), ifBlock, hasElse ? elseBlock : afterBlock);

            context.builder.PositionAtEnd(ifBlock);
            context.blocks.Push(ifBlock);
            IfBlock.CodeGen(context);
            context.builder.BuildBr(afterBlock);
            context.blocks.Pop();

            if (hasElse)
            {
                context.builder.PositionAtEnd(elseBlock);
                context.blocks.Push(elseBlock);
                ElseBlock.CodeGen(context);
                context.builder.BuildBr(afterBlock);
                context.blocks.Pop();
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

        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            if(Expr1 != null)
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
            LLVMBasicBlockRef afterBlock = context.CurrentFunc.AppendBasicBlock("after_block");

            context.builder.BuildBr(condBlock);

            context.builder.PositionAtEnd(condBlock);
            context.builder.BuildCondBr(Expr1.CodeGen(context), loopBlock, afterBlock);

            context.builder.PositionAtEnd(loopBlock);
            context.blocks.Push(loopBlock);
            Block.CodeGen(context);
            context.blocks.Pop();
            context.builder.BuildBr(condBlock);

            context.builder.PositionAtEnd(afterBlock);
            return default;
        }

        private LLVMValueRef CodeGenOnlyIteration(CodeGenContext context)
        {
            LLVMBasicBlockRef condBlock = context.CurrentFunc.AppendBasicBlock("loop_cond");
            LLVMBasicBlockRef loopBlock = context.CurrentFunc.AppendBasicBlock("loop_block");
            LLVMBasicBlockRef afterBlock = context.CurrentFunc.AppendBasicBlock("after_block");

            //Here we are assuming that expr1 is less than expr2 and both are ints.
            LLVMValueRef min = Expr1.CodeGen(context);
            LLVMValueRef max = Expr2.CodeGen(context);

            //Loop counter, starts at min
            LLVMValueRef count = context.builder.BuildAlloca(LLVMTypeRef.Int32, "i");
            context.builder.BuildStore(min, count);

            context.builder.BuildBr(condBlock);

            context.builder.PositionAtEnd(condBlock);
            LLVMValueRef compare = context.builder.BuildICmp(LLVMIntPredicate.LLVMIntSLT, context.builder.BuildLoad(count), max);
            context.builder.BuildCondBr(compare, loopBlock, afterBlock);

            context.builder.PositionAtEnd(loopBlock);
            context.blocks.Push(loopBlock);
            Block.CodeGen(context);
            context.builder.BuildStore(context.builder.BuildAdd(context.builder.BuildLoad(count), Dummy1), count);
            context.blocks.Pop();
            context.builder.BuildBr(condBlock);

            context.builder.PositionAtEnd(afterBlock);
            return default;
        }
    }

    public class KExprStmt : KStmt
    {
        public KExpr Expr { get; set; }
        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            return Expr.CodeGen(context);
        }
    }

    public class KDec : KExpr
    {
        public double Value { get; set; }
        public override KValType GetReturnType(CodeGenContext context) => KValType.Dec;
        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            return LLVMValueRef.CreateConstReal(LLVMTypeRef.Double, Value);
        }
    }

    public class KInt : KExpr
    {
        public int Value { get; set; }
        public override KValType GetReturnType(CodeGenContext context) => KValType.Int;
        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            return LLVMValueRef.CreateConstInt(LLVMTypeRef.Int32, (ulong)Value, true);
        }
    }

    public class KBool : KExpr
    {
        public bool Value { get; set; }
        public override KValType GetReturnType(CodeGenContext context) => KValType.Bool;
        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            return LLVMValueRef.CreateConstInt(LLVMTypeRef.Int1, Value ? 1u : 0u, true);
        }
    }

    public class KStr : KExpr
    {
        public string Value { get; set; }
        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            //TODO: Add string support.
            return context.builder.BuildGlobalString(Value);
        }
    }

    public class KId : KExpr
    {
        public KIdType Type { get; init; }
        public IdType IdType { get; init; }
        public string Name { get; set; }

        public override bool IsPointer => retTypeCached != null ? retTypeCached.IsPointer : Type == KIdType.Pointer;

        private KId retTypeCached;

        public KId(string name, IdType idType, KIdType type)
        {
            Name = name;
            IdType = idType;
            Type = type;
        }

        public override KValType GetReturnType(CodeGenContext context)
        {
            if (retTypeCached == null)
                retTypeCached = context.Fields[Name].Ret;
            return Enum.Parse<KValType>(retTypeCached.Name);
        }
        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            if (!context.HasLocal(Name))
                throw new IRGenException($"Undeclared variable {Name}.");

            LLVMValueRef local = context.GetLocal(Name);

            //Check if it's an argument. If it is then it's the value
            if (local.Kind == LLVMValueKind.LLVMArgumentValueKind)
                return local;

            if (IsPointer)
            {
                //If pointer, load the address and the value of the address
                local = context.builder.BuildLoad(local, Name + "_address");
                local = context.builder.BuildIntToPtr(local, LLVMTypeRef.CreatePointer(TypeTable.GetType(GetReturnType(context)), 0));
            }

            //If not, load the value.
            return context.builder.BuildLoad(local, Name + "_value");
        }
    }

    public class KAddress : KExpr
    {
        public KId Id { get; set; }
        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            return context.builder.BuildPtrToInt(context.GetLocal(Id.Name), LLVMTypeRef.Int64);
        }
    }

    public class KMethod : KExpr
    {
        public KId Id { get; set; }
        public List<KExpr> Args { get; set; }
        public override KValType GetReturnType(CodeGenContext context)
        {
            return Enum.Parse<KValType>(context.Methods[Id.Name].Ret.Name);
        }

        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            LLVMValueRef function = context.module.GetNamedFunction(Id.Name);
            if (function.IsNull)
                throw new IRGenException($"No function with name {Id.Name} found.");

            List<LLVMValueRef> argsValues = new List<LLVMValueRef>();
            foreach (var arg in Args)
                argsValues.Add(arg.CodeGen(context));

            return context.builder.BuildCall(function, argsValues.ToArray(), Id.Name);
        }
    }

    public class KUnaryOp : KExpr
    {
        public ExprType Op { get; set; }
        public KExpr Rhs { get; set; }
        public override KValType GetReturnType(CodeGenContext context) => Rhs.GetReturnType(context);

        private static LLVMValueRef dummyInt0 = LLVMValueRef.CreateConstInt(LLVMTypeRef.Int32, 0, false);
        private static LLVMValueRef dummyInt1 = LLVMValueRef.CreateConstInt(LLVMTypeRef.Int1, 1, false);
        private static LLVMValueRef dummyDec0 = LLVMValueRef.CreateConstReal(LLVMTypeRef.Float, 0);

        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            KValType retType = GetReturnType(context);
            if (Op != ExprType.Not && retType != KValType.Int && retType != KValType.Dec)
                throw new IRGenException($"Cannot create a unary operation with type '{retType}'.");

            return Op switch
            {
                ExprType.Add => BuildBinOp(retType == KValType.Int ? LLVMOpcode.LLVMAdd : LLVMOpcode.LLVMFAdd),
                ExprType.Sub => BuildBinOp(retType == KValType.Int ? LLVMOpcode.LLVMSub : LLVMOpcode.LLVMFSub),
                ExprType.Not => BuildNotOp(),
                _ => throw new IRGenException("Invalid operator"),
            };
            LLVMValueRef BuildBinOp(LLVMOpcode code) => context.builder.BuildBinOp(code, retType == KValType.Int ? dummyInt0 : dummyDec0, Rhs.CodeGen(context), code.ToString().ToLower());
            LLVMValueRef BuildNotOp() => context.builder.BuildBinOp(LLVMOpcode.LLVMSub, dummyInt1, Rhs.CodeGen(context), "not_op");
        }
    }

    public class KBinOp : KExpr
    {
        public ExprType Op { get; set; }
        public KExpr Lhs { get; set; }
        public KExpr Rhs { get; set; }
        public override KValType GetReturnType(CodeGenContext context) => Lhs.GetReturnType(context);
        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            KValType retType = GetReturnType(context);
            if (retType != KValType.Int && retType != KValType.Dec)
                throw new IRGenException($"Cannot create a binary operation with type '{retType}'.");

            return Op switch
            {
                ExprType.Add => BuildBinOp(retType == KValType.Int ? LLVMOpcode.LLVMAdd : LLVMOpcode.LLVMFAdd),
                ExprType.Sub => BuildBinOp(retType == KValType.Int ? LLVMOpcode.LLVMSub : LLVMOpcode.LLVMFSub),
                ExprType.Mult => BuildBinOp(retType == KValType.Int ? LLVMOpcode.LLVMMul : LLVMOpcode.LLVMFMul),
                ExprType.Div => BuildBinOp(retType == KValType.Int ? LLVMOpcode.LLVMSDiv : LLVMOpcode.LLVMFDiv),
                ExprType.Eq => retType == KValType.Int ? BuildBinICmp(LLVMIntPredicate.LLVMIntEQ) : BuildBinFCmp(LLVMRealPredicate.LLVMRealOEQ),
                ExprType.NEq => retType == KValType.Int ? BuildBinICmp(LLVMIntPredicate.LLVMIntNE) : BuildBinFCmp(LLVMRealPredicate.LLVMRealONE),
                ExprType.Less => retType == KValType.Int ? BuildBinICmp(LLVMIntPredicate.LLVMIntSLT) : BuildBinFCmp(LLVMRealPredicate.LLVMRealOLT),
                ExprType.ELess => retType == KValType.Int ? BuildBinICmp(LLVMIntPredicate.LLVMIntSLE) : BuildBinFCmp(LLVMRealPredicate.LLVMRealOLE),
                ExprType.Great => retType == KValType.Int ? BuildBinICmp(LLVMIntPredicate.LLVMIntSGT) : BuildBinFCmp(LLVMRealPredicate.LLVMRealOGT),
                ExprType.EGreat => retType == KValType.Int ? BuildBinICmp(LLVMIntPredicate.LLVMIntSGE) : BuildBinFCmp(LLVMRealPredicate.LLVMRealOGE),
                ExprType.And => BuildBinOp(LLVMOpcode.LLVMAnd),
                ExprType.Or => BuildBinOp(LLVMOpcode.LLVMOr),
                _ => throw new IRGenException("Invalid operator"),
            };
            LLVMValueRef BuildBinOp(LLVMOpcode code) => context.builder.BuildBinOp(code, Lhs.CodeGen(context), Rhs.CodeGen(context));
            LLVMValueRef BuildBinICmp(LLVMIntPredicate predicate) => context.builder.BuildICmp(predicate, Lhs.CodeGen(context), Rhs.CodeGen(context));
            LLVMValueRef BuildBinFCmp(LLVMRealPredicate predicate) => context.builder.BuildFCmp(predicate, Lhs.CodeGen(context), Rhs.CodeGen(context));
        }
    }

    public class KAssign : KExpr
    {
        public KId Lhs { get; set; }
        public KExpr Rhs { get; set; }
        public bool ToPointer { get; set; }
        public override KValType GetReturnType(CodeGenContext context)
        {
            return Lhs.GetReturnType(context);
        }
        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            if (!context.HasLocal(Lhs.Name))
                throw new IRGenException($"Undeclared variable {Lhs.Name}.");

            //Loads value into address
            LLVMValueRef lhs = context.GetLocal(Lhs.Name);
            LLVMValueRef rhs = Rhs.CodeGen(context);
            if (ToPointer)
            {
                //Convert pointer to address and address into value
                LLVMValueRef lhs_Adr = context.builder.BuildLoad(lhs, Lhs.Name + "_address");
                lhs = context.builder.BuildIntToPtr(lhs_Adr, LLVMTypeRef.CreatePointer(TypeTable.GetType(GetReturnType(context)), 0));
            }

            return context.builder.BuildStore(rhs, lhs);
        }
    }

    public class KRet : KExpr
    {
        public KExpr expr;
        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            if (expr == null) return context.builder.BuildRetVoid();
            return context.builder.BuildRet(expr.CodeGen(context));
        }
    }

    public class KBlock : KExpr
    {
        public List<KStmt> Statements { get; set; } = new List<KStmt>();
        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            LLVMValueRef last = default;
            foreach (var stm in Statements)
                last = stm.CodeGen(context);
            return last;
        }
    }

    public class KVarDecl : KStmt
    {
        public KId Ret { get; set; }
        public KId Id { get; set; }
        public KExpr Assignment { get; set; }

        public KVarDecl(CodeGenContext context, KId id)
        {
            Id = id;
            //TODO: This should be scoped, otherwise can't use variables with same name in different methods
            context.Fields.Add(Id.Name, this);
        }
        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            //This creates an empty pointer of predefined type.
            LLVMTypeRef type = Ret.Type == KIdType.Pointer ? LLVMTypeRef.Int64 : TypeTable.GetType(Ret.Name);
            LLVMValueRef pointer = context.builder.BuildAlloca(type, Id.Name);

            //We store the pointer
            context.SetLocal(Id.Name, pointer);

            if (Assignment != null)
            {
                KAssign assign = new KAssign() { Lhs = Id, Rhs = Assignment, ToPointer = false };
                assign.CodeGen(context);
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
                argTypes.Add(TypeTable.GetType(arg.Ret.Name));
            }
            LLVMTypeRef fType = LLVMTypeRef.CreateFunction(TypeTable.GetType(Ret.Name), argTypes.ToArray());
            func = context.module.AddFunction(Id.Name, fType);
            for (int i = 0; i < Args.Count; i++)
                func.Params[i].Name = Args[i].Id.Name;
            isDefined = true;
        }

        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            if (!isDefined)
                throw new IRGenException("Method has not been defined before generating block.");

            if (!needsBlock)
                return default;

            //Call this when the function it's defined
            LLVMBasicBlockRef block = func.AppendBasicBlock("entry");

            context.SetFunc(func);
            context.builder.PositionAtEnd(block);
            context.blocks.Push(block);

            for (int i = 0; i < Args.Count; i++)
            {
                KVarDecl arg = Args[i];
                arg.CodeGen(context);
                context.SetLocal(func.Params[i].Name, func.Params[i]);
            }

            if (Block == null) throw new IRGenException("Error while creating method declaration. Block is null.");
            Block.CodeGen(context);

            context.blocks.Pop();
            context.ClearFunc();
            return func;
        }
    }
}
