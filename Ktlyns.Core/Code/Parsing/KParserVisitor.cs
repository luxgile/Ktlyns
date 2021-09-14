#define DEBUG_KPARSING

using Antlr4.Runtime.Misc;
using Antlr4.Runtime.Tree;
using System;
using System.Collections.Generic;
using System.Linq;
using static KtlynsParser;

namespace Kat
{
    public enum ParsingResult { None, Success, Failed }
    public class KParserVisitor : KtlynsBaseVisitor<ParsingResult>
    {
        public KBlock Root { get; private set; }

        private ParsingState state = new ParsingState();
        public List<ParserException> Errors { get; private set; } = new List<ParserException>();

        public CodeGenContext GetIRGenContext() => state.GenContext;

        private ParsingResult Safe(Func<ParsingResult> f)
        {
            ParsingResult result;
            try
            {
                result = f();
            }
            catch (ParserException e)
            {
                result = ParsingResult.Failed;
                Errors.Add(e);
            }
            return result;
        }

        public override ParsingResult VisitTerminal(ITerminalNode node)
        {
            return base.VisitTerminal(node);
        }

        //Program
        public override ParsingResult VisitProgram([NotNull] ProgramContext context)
        {
            Safe(() => VisitChildren(context));
            Root = context.statements().Block;
            var exceptions = state.ReportPromises();
            Errors.AddRange(exceptions);
            return ParsingResult.Success;
        }

        //Block
        public override ParsingResult VisitRBlockStmts([NotNull] RBlockStmtsContext context)
        {
            VisitChildren(context);
            context.Block = context.statements().Block;
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRBlockEmpty([NotNull] RBlockEmptyContext context)
        {
            VisitChildren(context);
            context.Block = new KBlock();
            return ParsingResult.Success;
        }

        //Statements
        public override ParsingResult VisitStatements([NotNull] StatementsContext context)
        {
            VisitChildren(context);
            context.Block = new KBlock() { Statements = new List<KStmt>(context.statement().Select(x => x.Stmt).ToArray()) };
            return ParsingResult.Success;
        }

        //Statement
        public override ParsingResult VisitRStatement([NotNull] RStatementContext context)
        {
            Safe(() => VisitChildren(context));
            context.Stmt = new KExprStmt() { Expr = context.expr().Expr };
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRStatementVarDecl([NotNull] RStatementVarDeclContext context)
        {
            Safe(() => VisitChildren(context));
            context.Stmt = context.var_decl().Stmt;
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRStatementArrDecl([NotNull] RStatementArrDeclContext context)
        {
            Safe(() => VisitChildren(context));
            context.Stmt = context.arr_decl().Stmt;
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRStatementMthDecl([NotNull] RStatementMthDeclContext context)
        {
            Safe(() => VisitChildren(context));
            context.Stmt = context.mth_decl().Stmt;
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRStatementExMthDecl([NotNull] RStatementExMthDeclContext context)
        {
            Safe(() => VisitChildren(context));
            context.Stmt = context.ex_mth_decl().Stmt;
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRStatementIfElse([NotNull] RStatementIfElseContext context)
        {
            Safe(() => VisitChildren(context));
            context.Stmt = context.if_else_decl().Stmt;
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRStatementLoop([NotNull] RStatementLoopContext context)
        {
            Safe(() => VisitChildren(context));
            context.Stmt = context.loop_decl().Stmt;
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRStatementBreak([NotNull] RStatementBreakContext context)
        {
            context.Stmt = new KLoopBreak();
            return ParsingResult.Success;
        }

        //If else
        public override ParsingResult VisitRIfElse([NotNull] RIfElseContext context)
        {
            Safe(() => VisitChildren(context));
            KBlock ifBlock = new KBlock();
            if (context.block(0) != null)
                ifBlock = context.block(0).Block;
            else if (context.statement(0) != null)
                ifBlock = new KBlock() { Statements = new List<KStmt>() { context.statement(0).Stmt } };

            KBlock elseBlock = null;
            if (context.block(1) != null)
                elseBlock = context.block(1).Block;
            else if (context.statement(1) != null)
                elseBlock = new KBlock() { Statements = new List<KStmt>() { context.statement(1).Stmt } };

            context.Stmt = new KIfElse() { Condition = context.expr().Expr, IfBlock = ifBlock, ElseBlock = elseBlock };
            return ParsingResult.Success;
        }

        //Loops
        public override ParsingResult VisitRLoopOne([NotNull] RLoopOneContext context)
        {
            Safe(() => VisitChildren(context));
            context.Stmt = new KLoop() { Block = context.block().Block, Expr1 = context.expr().Expr };
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRLoopTwo([NotNull] RLoopTwoContext context)
        {
            Safe(() => VisitChildren(context));
            context.Stmt = new KLoop() { Block = context.block().Block, Expr1 = context.expr(0).Expr, Expr2 = context.expr(1).Expr };
            return ParsingResult.Success;
        }

        //Var Decl
        public override ParsingResult VisitRVarDeclExpr([NotNull] RVarDeclExprContext context)
        {
            Safe(() => VisitChildren(context));
            KId retType = context.id(0).Id;
            retType.IdType = IdType.Type;

            KId identifier = context.id(1).Id;
            if (state.TryGetId(identifier.Name, out IdData idData))
                throw ParseErrorLib.IdDeclared(idData.name, context.Start.Line, context.Start.Column);
            state.AddId(identifier.Name, IdType.Field);
            context.Stmt = new KVarDecl(state.GenContext, identifier) { Ret = context.id(0).Id, Assignment = context.expr().Expr };
            return ParsingResult.Success;
        }

        //Array Decl
        public override ParsingResult VisitRArrDeclExpr([NotNull] RArrDeclExprContext context)
        {
            Safe(() => VisitChildren(context));
            KId id = context.id(1).Id;
            if (state.TryGetId(id.Name, out IdData idData))
                throw ParseErrorLib.IdDeclared(idData.name, context.Start.Line, context.Start.Column);
            state.AddId(id.Name, IdType.Field);
            context.Stmt = new KVarDecl(state.GenContext, id) { Ret = context.id(0).Id, Assignment = context.expr().Expr, ArrayLengths = new uint[] { uint.Parse(context.INT().GetText()) } };
            return ParsingResult.Success;
        }

        //Mth Decl
        public override ParsingResult VisitMth_decl([NotNull] Mth_declContext context)
        {
            state.PushBlock();

            VisitChildren(context);

            state.PopBlock();

            KId type = context.mth().Id;
            KId id = context.id().Id;
            List<KVarDecl> args = context.mth_decl_arg().Decls;
            KBlock block = context.block().Block;

            if (state.TryGetId(id.Name, out IdData data))
                throw ParseErrorLib.IdDeclared(data.name, context.Start.Line, context.Start.Column);

            state.AddId(id.Name, IdType.Method);

            context.Stmt = new KMthdDecl(state.GenContext, id, true) { Ret = type, Args = args, Block = block };

            return ParsingResult.Success;
        }

        //External Mth Decl
        public override ParsingResult VisitEx_mth_decl([NotNull] Ex_mth_declContext context)
        {
            VisitChildren(context);

            KId type = context.mth().Id;
            KId id = context.id().Id;
            List<KVarDecl> args = context.mth_decl_arg().Decls;

            if (state.TryGetId(id.Name, out IdData data))
                throw ParseErrorLib.IdDeclared(data.name, context.Start.Line, context.Start.Column);

            state.AddId(id.Name, IdType.Method);

            context.Stmt = new KMthdDecl(state.GenContext, id, false) { Ret = type, Args = args };

            return ParsingResult.Success;
        }

        //Mth
        public override ParsingResult VisitRMthVoid([NotNull] RMthVoidContext context)
        {
            VisitChildren(context);
            context.Id = new KId("Void", IdType.Method);
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRMthType([NotNull] RMthTypeContext context)
        {
            VisitChildren(context);
            context.Id = context.id().Id;
            return ParsingResult.Success;
        }

        //Expr
        public override ParsingResult VisitRExprString([NotNull] RExprStringContext context)
        {
            VisitChildren(context);
            context.Expr = context.@string().Str;
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRExprId([NotNull] RExprIdContext context)
        {
            VisitChildren(context);
            KId id = context.id().Id;
            if (!state.TryGetId(id.Name, out _))
                throw ParseErrorLib.IdNotDeclared(id.Name, context.Start.Line, context.Start.Column);
            context.Expr = id;
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRExprAssign([NotNull] RExprAssignContext context)
        {
            VisitChildren(context);
            KId id = context.id().Id;
            if (!state.TryGetId(id.Name, out _))
                throw ParseErrorLib.IdNotDeclared(id.Name, context.Start.Line, context.Start.Column);
            context.Expr = new KAssign() { Lhs = id, Rhs = context.expr().Expr };
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRExprCall([NotNull] RExprCallContext context)
        {
            VisitChildren(context);
            KId id = context.id().Id;
            state.AddPromise(id.Name, IdType.Method, ParseErrorLib.IdNotDeclared(id.Name, context.Start.Line, context.Start.Column));
            context.Expr = new KMethod() { Id = id, Args = context.call_args().Exprs };
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRExprGroup([NotNull] RExprGroupContext context)
        {
            VisitChildren(context);
            context.Expr = context.expr().Expr;
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRExprUnary([NotNull] RExprUnaryContext context)
        {
            VisitChildren(context);
            context.Expr = context.unary().Expr;
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRExprReturn([NotNull] RExprReturnContext context)
        {
            VisitChildren(context);
            context.Expr = new KRet() { expr = context.expr()?.Expr };
            return ParsingResult.Success;
        }
        //public override ParsingResult VisitRExprArrAcc([NotNull] RExprArrAccContext context)
        //{

        //}
        private ParsingResult CreateBinOp(ExprContext ctx, ExprType exprType)
        {
            VisitChildren(ctx);
            ctx.Expr = new KBinOp() { Lhs = ctx.GetRuleContext<ExprContext>(0).Expr, Rhs = ctx.GetRuleContext<ExprContext>(1).Expr, Op = exprType };
            return ParsingResult.Success;
        }

        //TODO: Might need to check if LHS and RHS are actually from supported types.
        public override ParsingResult VisitRExprBinMult([NotNull] RExprBinMultContext context) => CreateBinOp(context, ExprType.Mult);
        public override ParsingResult VisitRExprBinDiv([NotNull] RExprBinDivContext context) => CreateBinOp(context, ExprType.Div);
        public override ParsingResult VisitRExprBinAdd([NotNull] RExprBinAddContext context) => CreateBinOp(context, ExprType.Add);
        public override ParsingResult VisitRExprBinSub([NotNull] RExprBinSubContext context) => CreateBinOp(context, ExprType.Sub);
        public override ParsingResult VisitRExprBinEq([NotNull] RExprBinEqContext context) => CreateBinOp(context, ExprType.Eq);
        public override ParsingResult VisitRExprBinNEq([NotNull] RExprBinNEqContext context) => CreateBinOp(context, ExprType.NEq);
        public override ParsingResult VisitRExprBinGreat([NotNull] RExprBinGreatContext context) => CreateBinOp(context, ExprType.Great);
        public override ParsingResult VisitRExprBinEGreat([NotNull] RExprBinEGreatContext context) => CreateBinOp(context, ExprType.EGreat);
        public override ParsingResult VisitRExprBinLess([NotNull] RExprBinLessContext context) => CreateBinOp(context, ExprType.Less);
        public override ParsingResult VisitRExprBinELess([NotNull] RExprBinELessContext context) => CreateBinOp(context, ExprType.ELess);
        public override ParsingResult VisitRExprBinAnd([NotNull] RExprBinAndContext context) => CreateBinOp(context, ExprType.And);
        public override ParsingResult VisitRExprBinOr([NotNull] RExprBinOrContext context) => CreateBinOp(context, ExprType.Or);

        //Unary
        public override ParsingResult VisitRUnaryFactor([NotNull] RUnaryFactorContext context)
        {
            VisitChildren(context);
            context.Expr = context.factor().Expr;
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRUnaryMinus([NotNull] RUnaryMinusContext context)
        {
            VisitChildren(context);
            context.Expr = new KUnaryOp() { Op = ExprType.Sub, Rhs = context.factor().Expr };
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRUnaryNot([NotNull] RUnaryNotContext context)
        {
            VisitChildren(context);
            context.Expr = new KUnaryOp() { Op = ExprType.Not, Rhs = context.factor().Expr };
            return ParsingResult.Success;
        }

        //Numbers
        public override ParsingResult VisitRFactorInt([NotNull] RFactorIntContext context)
        {
            VisitChildren(context);
            context.Expr = new KInt() { Value = int.Parse(context.GetText()) };
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRFactorDec([NotNull] RFactorDecContext context)
        {
            VisitChildren(context);
            string text = context.GetText();
            text = text.Replace('.', ',');
            context.Expr = new KDec() { Value = double.Parse(text) };
            return ParsingResult.Success;
        }

        //String
        public override ParsingResult VisitString([NotNull] StringContext context)
        {
            VisitChildren(context);
            context.Str = new KStr() { Value = context.GetText() };
            return ParsingResult.Success;
        }

        //Bool literals
        public override ParsingResult VisitRFactorTrue([NotNull] RFactorTrueContext context)
        {
            VisitChildren(context);
            context.Expr = new KBool() { Value = true };
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRFactorFalse([NotNull] RFactorFalseContext context)
        {
            VisitChildren(context);
            context.Expr = new KBool() { Value = false };
            return ParsingResult.Success;
        }

        //ID
        public override ParsingResult VisitRIDSimple([NotNull] RIDSimpleContext context)
        {
            VisitChildren(context);
            string text = context.ID().ToString();

            if (TypeTable.TryGetType(text, out _)) context.Id = new KId(text, IdType.Type);
            else context.Id = new KId(text, IdType.Field) { PtrCount = 1 };

            return ParsingResult.Success;
        }
        public override ParsingResult VisitRIDArray([NotNull] RIDArrayContext context)
        {
            Safe(() => VisitChildren(context));
            context.Id = new KIdAcc(context.id().Id) { Index = context.expr().Expr };
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRIDAddress([NotNull] RIDAddressContext context)
        {
            VisitChildren(context);
            context.Id = new KId(context.id().Id) { PtrCount = -context.AMP().Length + 1 };
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRIDPointer([NotNull] RIDPointerContext context)
        {
            VisitChildren(context);
            context.Id = new KId(context.id().Id) { PtrCount = context.STAR().Length + 1 };
            return ParsingResult.Success;
        }

        //Call Args
        public override ParsingResult VisitRCallArgs([NotNull] RCallArgsContext context)
        {
            VisitChildren(context);
            context.Exprs = new List<KExpr>();
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRCallArgsExpr([NotNull] RCallArgsExprContext context)
        {
            VisitChildren(context);
            context.Exprs = new List<KExpr>() { context.expr().Expr };
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRCallArgsAdd([NotNull] RCallArgsAddContext context)
        {
            VisitChildren(context);
            context.call_args().Exprs.Add(context.expr().Expr);
            return ParsingResult.Success;
        }

        //Mth Decl Args
        public override ParsingResult VisitRMthDeclArg([NotNull] RMthDeclArgContext context)
        {
            VisitChildren(context);
            context.Decls = new List<KVarDecl>();
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRMthDeclArgVar([NotNull] RMthDeclArgVarContext context)
        {
            VisitChildren(context);
            context.Decls = new List<KVarDecl>() { (KVarDecl)context.var_decl().Stmt };
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRMthDeclArgAdd([NotNull] RMthDeclArgAddContext context)
        {
            VisitChildren(context);
            context.mth_decl_arg().Decls.Add((KVarDecl)context.var_decl().Stmt);
            return ParsingResult.Success;
        }
    }
}