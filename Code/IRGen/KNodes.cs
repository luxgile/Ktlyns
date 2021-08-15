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

    public abstract class KExpr : KNode { }
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
        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            return LLVMValueRef.CreateConstReal(LLVMTypeRef.Double, Value);
        }
    }

    public class KInt : KExpr
    {
        public int Value { get; set; }
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
            return context.builder.BuildGlobalString(Value);
        }
    }

    public class KId : KExpr
    {
        public string Name { get; set; }
        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            if (!context.locals.ContainsKey(Name))
                throw new IRGenException($"Undeclared variable {Name}.");
            return context.builder.BuildLoad(context.locals[Name], "id");
        }
    }

    public class KMethod : KExpr
    {
        public KId Id { get; set; }
        public List<KExpr> Args { get; set; }
        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            LLVMValueRef function = context.module.GetNamedFunction(Id.Name);
            if (function.IsNull)
                throw new IRGenException($"No function with name {Id.Name} found.");

            List<LLVMValueRef> argsValues = new List<LLVMValueRef>();
            foreach (var arg in Args)
                argsValues.Add(arg.CodeGen(context));

            return context.builder.BuildCall(function, argsValues.ToArray(), "tmpcall");
        }
    }

    public class KUnaryOp : KExpr
    {
        public ExprType Op { get; set; }
        public KExpr Rhs { get; set; }
        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            return Op switch
            {
                ExprType.Add => BuildBinOp(LLVMOpcode.LLVMAdd),
                ExprType.Sub => BuildBinOp(LLVMOpcode.LLVMSub),
                _ => throw new IRGenException("Invalid operator"),
            };
            LLVMValueRef BuildBinOp(LLVMOpcode code) => context.builder.BuildBinOp(code, LLVMValueRef.CreateConstInt(LLVMTypeRef.Int32, 0, false), Rhs.CodeGen(context));
        }
    }

    public class KBinOp : KExpr
    {
        public ExprType Op { get; set; }
        public KExpr Lhs { get; set; }
        public KExpr Rhs { get; set; }
        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            //TODO: Add support for floats
            return Op switch
            {
                ExprType.Add => BuildBinOp(LLVMOpcode.LLVMAdd),
                ExprType.Sub => BuildBinOp(LLVMOpcode.LLVMSub),
                ExprType.Mult => BuildBinOp(LLVMOpcode.LLVMMul),
                ExprType.Div => BuildBinOp(LLVMOpcode.LLVMSDiv),
                _ => throw new IRGenException("Invalid operator"),
            };
            LLVMValueRef BuildBinOp(LLVMOpcode code) => context.builder.BuildBinOp(code, Lhs.CodeGen(context), Rhs.CodeGen(context));
        }
    }

    public class KAssign : KExpr
    {
        public KId Lhs { get; set; }
        public KExpr Rhs { get; set; }
        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            if (!context.locals.ContainsKey(Lhs.Name))
                throw new IRGenException($"Undeclared variable {Lhs.Name}.");
            return context.builder.BuildStore(Rhs.CodeGen(context), context.locals[Lhs.Name]);
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
        public KId Type { get; set; }
        public KId Id { get; set; }
        public KExpr Assignment { get; set; }
        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            LLVMValueRef alloc = context.builder.BuildAlloca(TypeTable.GetType(Type.Name), Id.Name);
            context.locals[Id.Name] = alloc;
            if (Assignment != null)
            {
                KAssign assign = new KAssign() { Lhs = Id, Rhs = Assignment };
                assign.CodeGen(context);
            }
            return alloc;
        }
    }

    public class KMthdDecl : KStmt
    {
        public KId Type { get; set; }
        public KId Id { get; set; }
        public List<KVarDecl> Args { get; set; } = new List<KVarDecl>();
        public KBlock Block { get; set; }

        private LLVMValueRef func;
        private bool isDefined;

        public static List<KMthdDecl> Methods = new();

        public KMthdDecl()
        {
            Methods.Add(this);
        }

        public void Define(CodeGenContext context)
        {
            List<LLVMTypeRef> argTypes = new();
            foreach (var arg in Args)
                argTypes.Add(TypeTable.GetType(arg.Type.Name));

            LLVMTypeRef fType = LLVMTypeRef.CreateFunction(TypeTable.GetType(Type.Name), argTypes.ToArray());
            func = context.module.AddFunction(Id.Name, fType);
            isDefined = true;
        }

        public override LLVMValueRef CodeGen(CodeGenContext context)
        {
            if (!isDefined)
                throw new IRGenException("Method has not been defined before generating block.");

            //Call this when the function it's defined
            LLVMBasicBlockRef block = func.AppendBasicBlock("entry");
            context.builder.PositionAtEnd(block);
            context.blocks.Push(block);

            foreach (var arg in Args)
                arg.CodeGen(context);

            if (Block == null) throw new IRGenException("Error while creating method declaration. Block is null.");
            Block.CodeGen(context);

            context.blocks.Pop();
            return func;
        }
    }
}
