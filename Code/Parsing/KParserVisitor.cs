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

        private ParsingState state = new();
        public List<ParserException> Errors { get; private set; } = new List<ParserException>();

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
        public override ParsingResult VisitRStatementMthDecl([NotNull] RStatementMthDeclContext context)
        {
            Safe(() => VisitChildren(context));
            context.Stmt = context.mth_decl().Stmt;
            return ParsingResult.Success;
        }

        //Var Decl
        public override ParsingResult VisitRVarDecl([NotNull] RVarDeclContext context)
        {
            VisitChildren(context);
            var identifier = context.id(1).Id;
            if (state.TryGetId(identifier.Name, out IdData idData))
                throw ParseErrorLib.IdDeclared(idData.name, context.Start.Line, context.Start.Column);
            state.AddId(identifier.Name, IdType.Field);
            context.Stmt = new KVarDecl() { Type = context.id(0).Id, Id = identifier };
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRVarDeclExpr([NotNull] RVarDeclExprContext context)
        {
            Safe(() => VisitChildren(context));
            var identifier = context.id(1).Id;
            if (state.TryGetId(identifier.Name, out IdData idData))
                throw ParseErrorLib.IdDeclared(idData.name, context.Start.Line, context.Start.Column);
            state.AddId(identifier.Name, IdType.Field);
            context.Stmt = new KVarDecl() { Type = context.id(0).Id, Id = identifier, Assignment = context.expr().Expr };
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

            context.Stmt = new KMthdDecl() { Type = type, Id = id, Args = args, Block = block };

            return ParsingResult.Success;
        }

        //Mth
        public override ParsingResult VisitRMthVoid([NotNull] RMthVoidContext context)
        {
            VisitChildren(context);
            context.Id = new KId() { Name = "Void" };
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
        private static KBinOp CreateBinOp(ExprContext ctx, ExprType exprType)
            => new KBinOp() { Lhs = ctx.GetRuleContext<ExprContext>(0).Expr, Rhs = ctx.GetRuleContext<ExprContext>(1).Expr, Op = exprType };
        public override ParsingResult VisitRExprBinMult([NotNull] RExprBinMultContext context)
        {
            VisitChildren(context);
            context.Expr = CreateBinOp(context, ExprType.Mult);
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRExprBinDiv([NotNull] RExprBinDivContext context)
        {
            VisitChildren(context);
            context.Expr = CreateBinOp(context, ExprType.Div);
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRExprBinAdd([NotNull] RExprBinAddContext context)
        {
            VisitChildren(context);
            context.Expr = CreateBinOp(context, ExprType.Add);
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRExprBinSub([NotNull] RExprBinSubContext context)
        {
            VisitChildren(context);
            context.Expr = CreateBinOp(context, ExprType.Sub);
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRExprReturn([NotNull] RExprReturnContext context)
        {
            VisitChildren(context);
            context.Expr = new KRet() { expr = context.expr()?.Expr };
            return ParsingResult.Success;
        }

        public override ParsingResult VisitUnary([NotNull] UnaryContext context)
        {
            VisitChildren(context);
            if (context.MINUS() != null)
                context.Expr = new KUnaryOp() { Op = ExprType.Sub, Rhs = context.number().Expr };
            else
                context.Expr = context.number().Expr;

            return ParsingResult.Success;
        }

        //Number
        public override ParsingResult VisitRNumberInt([NotNull] RNumberIntContext context)
        {
            VisitChildren(context);
            context.Expr = new KInt() { Value = int.Parse(context.GetText()) };
            return ParsingResult.Success;
        }
        public override ParsingResult VisitRNumberDec([NotNull] RNumberDecContext context)
        {
            VisitChildren(context);
            context.Expr = new KDec() { Value = double.Parse(context.GetText()) };
            return ParsingResult.Success;
        }

        //String
        public override ParsingResult VisitString([NotNull] StringContext context)
        {
            VisitChildren(context);
            context.Str = new KStr() { Value = context.GetText() };
            return ParsingResult.Success;
        }

        //ID
        public override ParsingResult VisitId([NotNull] IdContext context)
        {
            VisitChildren(context);
            string text = context.ID().ToString();
            context.Id = new KId() { Name = text };
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


//program
//	locals[KBlock Root]:
//	x1 = statements {$Root = $x1.Block; };
//block
//	returns[KBlock Block]:
//	LBRC x1 = statements RBRC	{$Block = $x1.Block;}
//	| LBRC RBRC {$Block = new()};
//statements
//	returns[KBlock Block]:
//	x1 = statement                      {$Block = new() { Statements = new($x1.Stmt) }; }
//	| x1 = statements x2 = statement    {$x1.Block.Statements.Add($x2.Stmt); };

//statement
//	returns[KStmt Stmt]:
//	x1 = expr SDOT
//{$Stmt = new KExprStmt() { Expr = $x1.Expr }; }
//	| x1 = var_decl SDOT
//{$Stmt = $x1.Stmt; }
//	| x1 = mth_decl         {$Stmt = $x1.Stmt; };

//var_decl
//	returns[KStmt Stmt]:
//	x1 = id x2 = id                 {$Stmt = new KVarDecl() { Type = $x1.Id, Id = $x2.Id }; }
//	| x1 = id x2 = id EQ x3 = expr	{$Stmt = new KVarDecl() { Type = $x1.Id, Id = $x2.Id, Assignment = $x3.Expr };
//		};

//mth_decl
//	returns[KStmt Stmt]:
//	x1 = mth x2 = id LPRN x3 = mth_decl_arg RPRN x4 = block {$Stmt = new KMthDecl() { Type = $x1.Id, Id = $x2.Id, Args = $x3.Decls, Block = $x4.Block };
//		};

//mth
//	returns[KId Id]:
//	METHOD
//{$Id = new KId() { Name = "Void" }; }
//	| METHOD LARR x1 = id RARR	{$Id = $x1.Id;};

//expr
//	returns[KExpr Expr]:
//	x1 = number                         {$Expr = $x1.Expr; }
//	| x1 = string                       {$Expr = $x1.Str; }
//	| x1 = id                           {$Expr = $x1.Id; }
//	| x1 = id EQ x2 = expr				{$Expr = new KAssign() { Lhs = $x1.Id, Rhs = $x2.Expr }; }
//	| x1 = id LPRN x2 = call_args RPRN	{$Expr = new KMethod() { Id = $x1.Id, Args = $x2.Exprs }; }
//	| x1 = expr x2 = op x3 = expr       {$Expr = new KBinOp() { Op = $x2.type, Lhs = $x1.Expr, Rhs = $x3.Expr }; }
//	| LPRN x1 = expr RPRN
//{$Expr = $x1.Expr; };

//number
//	returns[KExpr Expr]:
//	INT
//{$Expr = new KInt { Value = ulong.Parse($INT.text) }; }
//	| DEC   {$Expr = new KDec { Value = double.Parse($DEC.text) }; };

//string
//	returns[KStr Str]:
//	STR
//{$Str = new KStr() { Value = $STR.text }; };

//id
//	returns[KId Id]:
//	ID
//{$Id = new KId() { Name = $ID.text }; };

//call_args
//	returns[List < KExpr > Exprs]:
//										{ $Exprs = new(); }
//	| x1 = expr                         { $Exprs = new(); $Exprs.Add($x1.Expr); }
//	| x1 = call_args COMMA x2 = expr	{ $x1.Exprs.Add($x2.Expr); };

//mth_decl_arg
//	returns[List < KVarDecl > Decls]:
//											{$Decls = new(); }
//	| x1 = var_decl                         {$Decls = new(); $Decls.Add((KVarDecl)$x1.Expr)}
//	| x1 = mth_decl_arg COMMA x2 = var_decl	{$x1.Decls.Add((KVarDecl)$x2.Expr)};
