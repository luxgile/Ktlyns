//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     ANTLR Version: 4.9.2
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

// Generated from Ktlyns.g4 by ANTLR 4.9.2

// Unreachable code detected
#pragma warning disable 0162
// The variable '...' is assigned but its value is never used
#pragma warning disable 0219
// Missing XML comment for publicly visible type or member '...'
#pragma warning disable 1591
// Ambiguous reference in cref attribute
#pragma warning disable 419

 
	using Kat; 
	using System.Collections.Generic;
	
using Antlr4.Runtime.Misc;
using Antlr4.Runtime.Tree;
using IToken = Antlr4.Runtime.IToken;

/// <summary>
/// This interface defines a complete generic visitor for a parse tree produced
/// by <see cref="KtlynsParser"/>.
/// </summary>
/// <typeparam name="Result">The return type of the visit operation.</typeparam>
[System.CodeDom.Compiler.GeneratedCode("ANTLR", "4.9.2")]
[System.CLSCompliant(false)]
public interface IKtlynsVisitor<Result> : IParseTreeVisitor<Result> {
	/// <summary>
	/// Visit a parse tree produced by <see cref="KtlynsParser.program"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitProgram([NotNull] KtlynsParser.ProgramContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RBlockStmts</c>
	/// labeled alternative in <see cref="KtlynsParser.block"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRBlockStmts([NotNull] KtlynsParser.RBlockStmtsContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RBlockEmpty</c>
	/// labeled alternative in <see cref="KtlynsParser.block"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRBlockEmpty([NotNull] KtlynsParser.RBlockEmptyContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="KtlynsParser.statements"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitStatements([NotNull] KtlynsParser.StatementsContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RStatement</c>
	/// labeled alternative in <see cref="KtlynsParser.statement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRStatement([NotNull] KtlynsParser.RStatementContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RStatementVarDecl</c>
	/// labeled alternative in <see cref="KtlynsParser.statement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRStatementVarDecl([NotNull] KtlynsParser.RStatementVarDeclContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RStatementArrDecl</c>
	/// labeled alternative in <see cref="KtlynsParser.statement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRStatementArrDecl([NotNull] KtlynsParser.RStatementArrDeclContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RStatementIfElse</c>
	/// labeled alternative in <see cref="KtlynsParser.statement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRStatementIfElse([NotNull] KtlynsParser.RStatementIfElseContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RStatementLoop</c>
	/// labeled alternative in <see cref="KtlynsParser.statement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRStatementLoop([NotNull] KtlynsParser.RStatementLoopContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RStatementBreak</c>
	/// labeled alternative in <see cref="KtlynsParser.statement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRStatementBreak([NotNull] KtlynsParser.RStatementBreakContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RStatementMthDecl</c>
	/// labeled alternative in <see cref="KtlynsParser.statement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRStatementMthDecl([NotNull] KtlynsParser.RStatementMthDeclContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RStatementExMthDecl</c>
	/// labeled alternative in <see cref="KtlynsParser.statement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRStatementExMthDecl([NotNull] KtlynsParser.RStatementExMthDeclContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RIfElse</c>
	/// labeled alternative in <see cref="KtlynsParser.if_else_decl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRIfElse([NotNull] KtlynsParser.RIfElseContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RLoopOne</c>
	/// labeled alternative in <see cref="KtlynsParser.loop_decl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRLoopOne([NotNull] KtlynsParser.RLoopOneContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RLoopTwo</c>
	/// labeled alternative in <see cref="KtlynsParser.loop_decl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRLoopTwo([NotNull] KtlynsParser.RLoopTwoContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RVarDeclExpr</c>
	/// labeled alternative in <see cref="KtlynsParser.var_decl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRVarDeclExpr([NotNull] KtlynsParser.RVarDeclExprContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RArrDeclExpr</c>
	/// labeled alternative in <see cref="KtlynsParser.arr_decl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRArrDeclExpr([NotNull] KtlynsParser.RArrDeclExprContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="KtlynsParser.mth_decl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitMth_decl([NotNull] KtlynsParser.Mth_declContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="KtlynsParser.ex_mth_decl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitEx_mth_decl([NotNull] KtlynsParser.Ex_mth_declContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RMthVoid</c>
	/// labeled alternative in <see cref="KtlynsParser.mth"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRMthVoid([NotNull] KtlynsParser.RMthVoidContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RMthType</c>
	/// labeled alternative in <see cref="KtlynsParser.mth"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRMthType([NotNull] KtlynsParser.RMthTypeContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RExprUnary</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRExprUnary([NotNull] KtlynsParser.RExprUnaryContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RExprBinAdd</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRExprBinAdd([NotNull] KtlynsParser.RExprBinAddContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RExprBinSub</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRExprBinSub([NotNull] KtlynsParser.RExprBinSubContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RExprBinEGreat</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRExprBinEGreat([NotNull] KtlynsParser.RExprBinEGreatContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RExprCall</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRExprCall([NotNull] KtlynsParser.RExprCallContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RExprReturn</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRExprReturn([NotNull] KtlynsParser.RExprReturnContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RExprId</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRExprId([NotNull] KtlynsParser.RExprIdContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RExprBinLess</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRExprBinLess([NotNull] KtlynsParser.RExprBinLessContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RExprBinAnd</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRExprBinAnd([NotNull] KtlynsParser.RExprBinAndContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RExprBinDiv</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRExprBinDiv([NotNull] KtlynsParser.RExprBinDivContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RExprAssign</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRExprAssign([NotNull] KtlynsParser.RExprAssignContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RExprBinEq</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRExprBinEq([NotNull] KtlynsParser.RExprBinEqContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RExprBinELess</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRExprBinELess([NotNull] KtlynsParser.RExprBinELessContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RExprBinOr</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRExprBinOr([NotNull] KtlynsParser.RExprBinOrContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RExprBinMult</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRExprBinMult([NotNull] KtlynsParser.RExprBinMultContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RExprBinGreat</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRExprBinGreat([NotNull] KtlynsParser.RExprBinGreatContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RExprString</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRExprString([NotNull] KtlynsParser.RExprStringContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RExprGroup</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRExprGroup([NotNull] KtlynsParser.RExprGroupContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RExprBinNEq</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRExprBinNEq([NotNull] KtlynsParser.RExprBinNEqContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RUnaryFactor</c>
	/// labeled alternative in <see cref="KtlynsParser.unary"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRUnaryFactor([NotNull] KtlynsParser.RUnaryFactorContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RUnaryMinus</c>
	/// labeled alternative in <see cref="KtlynsParser.unary"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRUnaryMinus([NotNull] KtlynsParser.RUnaryMinusContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RUnaryNot</c>
	/// labeled alternative in <see cref="KtlynsParser.unary"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRUnaryNot([NotNull] KtlynsParser.RUnaryNotContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RFactorInt</c>
	/// labeled alternative in <see cref="KtlynsParser.factor"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRFactorInt([NotNull] KtlynsParser.RFactorIntContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RFactorDec</c>
	/// labeled alternative in <see cref="KtlynsParser.factor"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRFactorDec([NotNull] KtlynsParser.RFactorDecContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RFactorTrue</c>
	/// labeled alternative in <see cref="KtlynsParser.factor"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRFactorTrue([NotNull] KtlynsParser.RFactorTrueContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RFactorFalse</c>
	/// labeled alternative in <see cref="KtlynsParser.factor"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRFactorFalse([NotNull] KtlynsParser.RFactorFalseContext context);
	/// <summary>
	/// Visit a parse tree produced by <see cref="KtlynsParser.string"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitString([NotNull] KtlynsParser.StringContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RIDPointer</c>
	/// labeled alternative in <see cref="KtlynsParser.id"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRIDPointer([NotNull] KtlynsParser.RIDPointerContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RIDArray</c>
	/// labeled alternative in <see cref="KtlynsParser.id"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRIDArray([NotNull] KtlynsParser.RIDArrayContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RIDSimple</c>
	/// labeled alternative in <see cref="KtlynsParser.id"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRIDSimple([NotNull] KtlynsParser.RIDSimpleContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RIDAddress</c>
	/// labeled alternative in <see cref="KtlynsParser.id"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRIDAddress([NotNull] KtlynsParser.RIDAddressContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RCallArgsAdd</c>
	/// labeled alternative in <see cref="KtlynsParser.call_args"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRCallArgsAdd([NotNull] KtlynsParser.RCallArgsAddContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RCallArgsExpr</c>
	/// labeled alternative in <see cref="KtlynsParser.call_args"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRCallArgsExpr([NotNull] KtlynsParser.RCallArgsExprContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RCallArgs</c>
	/// labeled alternative in <see cref="KtlynsParser.call_args"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRCallArgs([NotNull] KtlynsParser.RCallArgsContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RMthDeclArg</c>
	/// labeled alternative in <see cref="KtlynsParser.mth_decl_arg"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRMthDeclArg([NotNull] KtlynsParser.RMthDeclArgContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RMthDeclArgAdd</c>
	/// labeled alternative in <see cref="KtlynsParser.mth_decl_arg"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRMthDeclArgAdd([NotNull] KtlynsParser.RMthDeclArgAddContext context);
	/// <summary>
	/// Visit a parse tree produced by the <c>RMthDeclArgVar</c>
	/// labeled alternative in <see cref="KtlynsParser.mth_decl_arg"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	/// <return>The visitor result.</return>
	Result VisitRMthDeclArgVar([NotNull] KtlynsParser.RMthDeclArgVarContext context);
}
