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

    public abstract class KExpr : KNode { public virtual KValType GetReturnType() => KValType.Void; }
    public abstract class KStmt : KNode { }
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
        public override KValType GetReturnType() => KValType.Dec;
        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            return LLVMValueRef.CreateConstReal(LLVMTypeRef.Double, Value);
        }
    }

    public class KInt : KExpr
    {
        public int Value { get; set; }
        public override KValType GetReturnType() => KValType.Int;
        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            return LLVMValueRef.CreateConstInt(LLVMTypeRef.Int32, (ulong)Value, true);
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
        public string Name { get; set; }
        public override KValType GetReturnType()
        {
            return Enum.Parse<KValType>(KVarDecl.Fields[Name].Ret.Name);
        }
        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            if (!context.HasLocal(Name))
                throw new IRGenException($"Undeclared variable {Name}.");

            LLVMValueRef local = context.GetLocal(Name);

            //Check if it's an argument. If it is then it's the value
            if (local.Kind == LLVMValueKind.LLVMArgumentValueKind)
                return local;

            //If not, load the pointer value.
            return context.builder.BuildLoad(local, Name + "*");
            //return default;
        }
    }

    public class KMethod : KExpr
    {
        public KId Id { get; set; }
        public List<KExpr> Args { get; set; }
        public override KValType GetReturnType()
        {
            return Enum.Parse<KValType>(KMthdDecl.Methods[Id.Name].Ret.Name);
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
        public override KValType GetReturnType() => Rhs.GetReturnType();

        private static LLVMValueRef dummyInt = LLVMValueRef.CreateConstInt(LLVMTypeRef.Int32, 0, false);
        private static LLVMValueRef dummyDec = LLVMValueRef.CreateConstReal(LLVMTypeRef.Float, 0);

        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            KValType retType = GetReturnType();
            if (retType != KValType.Int && retType != KValType.Dec)
                throw new IRGenException($"Cannot create a unary operation with type '{retType}'.");

            return Op switch
            {
                ExprType.Add => BuildBinOp(retType == KValType.Int ? LLVMOpcode.LLVMAdd : LLVMOpcode.LLVMFAdd),
                ExprType.Sub => BuildBinOp(retType == KValType.Int ? LLVMOpcode.LLVMSub : LLVMOpcode.LLVMFSub),
                _ => throw new IRGenException("Invalid operator"),
            };
            LLVMValueRef BuildBinOp(LLVMOpcode code) => context.builder.BuildBinOp(code, retType == KValType.Int ? dummyInt : dummyDec, Rhs.CodeGen(context));
        }
    }

    public class KBinOp : KExpr
    {
        public ExprType Op { get; set; }
        public KExpr Lhs { get; set; }
        public KExpr Rhs { get; set; }
        public override KValType GetReturnType() => Lhs.GetReturnType();
        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            KValType retType = GetReturnType();
            if (retType != KValType.Int && retType != KValType.Dec)
                throw new IRGenException($"Cannot create a binary operation with type '{retType}'.");

            return Op switch
            {
                ExprType.Add => BuildBinOp(retType == KValType.Int ? LLVMOpcode.LLVMAdd : LLVMOpcode.LLVMFAdd),
                ExprType.Sub => BuildBinOp(retType == KValType.Int ? LLVMOpcode.LLVMSub : LLVMOpcode.LLVMFSub),
                ExprType.Mult => BuildBinOp(retType == KValType.Int ? LLVMOpcode.LLVMMul : LLVMOpcode.LLVMFMul),
                ExprType.Div => BuildBinOp(retType == KValType.Int ? LLVMOpcode.LLVMSDiv : LLVMOpcode.LLVMFDiv),
                _ => throw new IRGenException("Invalid operator"),
            };
            LLVMValueRef BuildBinOp(LLVMOpcode code) => context.builder.BuildBinOp(code, Lhs.CodeGen(context), Rhs.CodeGen(context));
        }
    }

    public class KAssign : KExpr
    {
        public KId Lhs { get; set; }
        public KExpr Rhs { get; set; }
        public override KValType GetReturnType()
        {
            return Lhs.GetReturnType();
        }
        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            if (!context.HasLocal(Lhs.Name))
                throw new IRGenException($"Undeclared variable {Lhs.Name}.");
            return context.builder.BuildStore(Rhs.CodeGen(context), context.GetLocal(Lhs.Name));
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

        public static Dictionary<string, KVarDecl> Fields = new();
        public KVarDecl(KId id)
        {
            Id = id;
            //TODO: This should be scoped, otherwise can't use variables with same name in different methods
            Fields.Add(Id.Name, this);
        }
        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            //This creates an empty pointer of predefined type.
            LLVMValueRef pointer = context.builder.BuildAlloca(TypeTable.GetType(Ret.Name), Id.Name);

            //We store the pointer
            context.SetLocal(Id.Name, pointer);

            if (Assignment != null)
            {
                KAssign assign = new KAssign() { Lhs = Id, Rhs = Assignment };
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

        public static Dictionary<string, KMthdDecl> Methods = new();

        public KMthdDecl(KId id, bool needsBlock)
        {
            Id = id;
            this.needsBlock = needsBlock;
            Methods.Add(Id.Name, this);
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
            return func;
        }
    }
}
