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
using IParseTreeListener = Antlr4.Runtime.Tree.IParseTreeListener;
using IToken = Antlr4.Runtime.IToken;

/// <summary>
/// This interface defines a complete listener for a parse tree produced by
/// <see cref="KtlynsParser"/>.
/// </summary>
[System.CodeDom.Compiler.GeneratedCode("ANTLR", "4.9.2")]
[System.CLSCompliant(false)]
public interface IKtlynsListener : IParseTreeListener {
	/// <summary>
	/// Enter a parse tree produced by <see cref="KtlynsParser.program"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterProgram([NotNull] KtlynsParser.ProgramContext context);
	/// <summary>
	/// Exit a parse tree produced by <see cref="KtlynsParser.program"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitProgram([NotNull] KtlynsParser.ProgramContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RBlockStmts</c>
	/// labeled alternative in <see cref="KtlynsParser.block"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRBlockStmts([NotNull] KtlynsParser.RBlockStmtsContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RBlockStmts</c>
	/// labeled alternative in <see cref="KtlynsParser.block"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRBlockStmts([NotNull] KtlynsParser.RBlockStmtsContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RBlockEmpty</c>
	/// labeled alternative in <see cref="KtlynsParser.block"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRBlockEmpty([NotNull] KtlynsParser.RBlockEmptyContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RBlockEmpty</c>
	/// labeled alternative in <see cref="KtlynsParser.block"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRBlockEmpty([NotNull] KtlynsParser.RBlockEmptyContext context);
	/// <summary>
	/// Enter a parse tree produced by <see cref="KtlynsParser.statements"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterStatements([NotNull] KtlynsParser.StatementsContext context);
	/// <summary>
	/// Exit a parse tree produced by <see cref="KtlynsParser.statements"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitStatements([NotNull] KtlynsParser.StatementsContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RStatement</c>
	/// labeled alternative in <see cref="KtlynsParser.statement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRStatement([NotNull] KtlynsParser.RStatementContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RStatement</c>
	/// labeled alternative in <see cref="KtlynsParser.statement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRStatement([NotNull] KtlynsParser.RStatementContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RStatementVarDecl</c>
	/// labeled alternative in <see cref="KtlynsParser.statement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRStatementVarDecl([NotNull] KtlynsParser.RStatementVarDeclContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RStatementVarDecl</c>
	/// labeled alternative in <see cref="KtlynsParser.statement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRStatementVarDecl([NotNull] KtlynsParser.RStatementVarDeclContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RStatementIfElse</c>
	/// labeled alternative in <see cref="KtlynsParser.statement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRStatementIfElse([NotNull] KtlynsParser.RStatementIfElseContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RStatementIfElse</c>
	/// labeled alternative in <see cref="KtlynsParser.statement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRStatementIfElse([NotNull] KtlynsParser.RStatementIfElseContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RStatementMthDecl</c>
	/// labeled alternative in <see cref="KtlynsParser.statement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRStatementMthDecl([NotNull] KtlynsParser.RStatementMthDeclContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RStatementMthDecl</c>
	/// labeled alternative in <see cref="KtlynsParser.statement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRStatementMthDecl([NotNull] KtlynsParser.RStatementMthDeclContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RStatementExMthDecl</c>
	/// labeled alternative in <see cref="KtlynsParser.statement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRStatementExMthDecl([NotNull] KtlynsParser.RStatementExMthDeclContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RStatementExMthDecl</c>
	/// labeled alternative in <see cref="KtlynsParser.statement"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRStatementExMthDecl([NotNull] KtlynsParser.RStatementExMthDeclContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RIfElse</c>
	/// labeled alternative in <see cref="KtlynsParser.if_else_decl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRIfElse([NotNull] KtlynsParser.RIfElseContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RIfElse</c>
	/// labeled alternative in <see cref="KtlynsParser.if_else_decl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRIfElse([NotNull] KtlynsParser.RIfElseContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RVarDecl</c>
	/// labeled alternative in <see cref="KtlynsParser.var_decl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRVarDecl([NotNull] KtlynsParser.RVarDeclContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RVarDecl</c>
	/// labeled alternative in <see cref="KtlynsParser.var_decl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRVarDecl([NotNull] KtlynsParser.RVarDeclContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RVarDeclExpr</c>
	/// labeled alternative in <see cref="KtlynsParser.var_decl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRVarDeclExpr([NotNull] KtlynsParser.RVarDeclExprContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RVarDeclExpr</c>
	/// labeled alternative in <see cref="KtlynsParser.var_decl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRVarDeclExpr([NotNull] KtlynsParser.RVarDeclExprContext context);
	/// <summary>
	/// Enter a parse tree produced by <see cref="KtlynsParser.mth_decl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterMth_decl([NotNull] KtlynsParser.Mth_declContext context);
	/// <summary>
	/// Exit a parse tree produced by <see cref="KtlynsParser.mth_decl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitMth_decl([NotNull] KtlynsParser.Mth_declContext context);
	/// <summary>
	/// Enter a parse tree produced by <see cref="KtlynsParser.ex_mth_decl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterEx_mth_decl([NotNull] KtlynsParser.Ex_mth_declContext context);
	/// <summary>
	/// Exit a parse tree produced by <see cref="KtlynsParser.ex_mth_decl"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitEx_mth_decl([NotNull] KtlynsParser.Ex_mth_declContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RMthVoid</c>
	/// labeled alternative in <see cref="KtlynsParser.mth"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRMthVoid([NotNull] KtlynsParser.RMthVoidContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RMthVoid</c>
	/// labeled alternative in <see cref="KtlynsParser.mth"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRMthVoid([NotNull] KtlynsParser.RMthVoidContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RMthType</c>
	/// labeled alternative in <see cref="KtlynsParser.mth"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRMthType([NotNull] KtlynsParser.RMthTypeContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RMthType</c>
	/// labeled alternative in <see cref="KtlynsParser.mth"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRMthType([NotNull] KtlynsParser.RMthTypeContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RExprUnary</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRExprUnary([NotNull] KtlynsParser.RExprUnaryContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RExprUnary</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRExprUnary([NotNull] KtlynsParser.RExprUnaryContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RExprBinDiv</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRExprBinDiv([NotNull] KtlynsParser.RExprBinDivContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RExprBinDiv</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRExprBinDiv([NotNull] KtlynsParser.RExprBinDivContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RExprBinAdd</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRExprBinAdd([NotNull] KtlynsParser.RExprBinAddContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RExprBinAdd</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRExprBinAdd([NotNull] KtlynsParser.RExprBinAddContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RExprBinSub</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRExprBinSub([NotNull] KtlynsParser.RExprBinSubContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RExprBinSub</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRExprBinSub([NotNull] KtlynsParser.RExprBinSubContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RExprAssign</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRExprAssign([NotNull] KtlynsParser.RExprAssignContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RExprAssign</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRExprAssign([NotNull] KtlynsParser.RExprAssignContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RExprCall</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRExprCall([NotNull] KtlynsParser.RExprCallContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RExprCall</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRExprCall([NotNull] KtlynsParser.RExprCallContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RExprBinMult</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRExprBinMult([NotNull] KtlynsParser.RExprBinMultContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RExprBinMult</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRExprBinMult([NotNull] KtlynsParser.RExprBinMultContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RExprReturn</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRExprReturn([NotNull] KtlynsParser.RExprReturnContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RExprReturn</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRExprReturn([NotNull] KtlynsParser.RExprReturnContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RExprString</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRExprString([NotNull] KtlynsParser.RExprStringContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RExprString</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRExprString([NotNull] KtlynsParser.RExprStringContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RExprGroup</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRExprGroup([NotNull] KtlynsParser.RExprGroupContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RExprGroup</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRExprGroup([NotNull] KtlynsParser.RExprGroupContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RExprId</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRExprId([NotNull] KtlynsParser.RExprIdContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RExprId</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRExprId([NotNull] KtlynsParser.RExprIdContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RUnaryFactor</c>
	/// labeled alternative in <see cref="KtlynsParser.unary"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRUnaryFactor([NotNull] KtlynsParser.RUnaryFactorContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RUnaryFactor</c>
	/// labeled alternative in <see cref="KtlynsParser.unary"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRUnaryFactor([NotNull] KtlynsParser.RUnaryFactorContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RUnaryMinus</c>
	/// labeled alternative in <see cref="KtlynsParser.unary"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRUnaryMinus([NotNull] KtlynsParser.RUnaryMinusContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RUnaryMinus</c>
	/// labeled alternative in <see cref="KtlynsParser.unary"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRUnaryMinus([NotNull] KtlynsParser.RUnaryMinusContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RUnaryNot</c>
	/// labeled alternative in <see cref="KtlynsParser.unary"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRUnaryNot([NotNull] KtlynsParser.RUnaryNotContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RUnaryNot</c>
	/// labeled alternative in <see cref="KtlynsParser.unary"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRUnaryNot([NotNull] KtlynsParser.RUnaryNotContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RUnaryAddress</c>
	/// labeled alternative in <see cref="KtlynsParser.unary"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRUnaryAddress([NotNull] KtlynsParser.RUnaryAddressContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RUnaryAddress</c>
	/// labeled alternative in <see cref="KtlynsParser.unary"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRUnaryAddress([NotNull] KtlynsParser.RUnaryAddressContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RFactorInt</c>
	/// labeled alternative in <see cref="KtlynsParser.factor"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRFactorInt([NotNull] KtlynsParser.RFactorIntContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RFactorInt</c>
	/// labeled alternative in <see cref="KtlynsParser.factor"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRFactorInt([NotNull] KtlynsParser.RFactorIntContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RFactorDec</c>
	/// labeled alternative in <see cref="KtlynsParser.factor"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRFactorDec([NotNull] KtlynsParser.RFactorDecContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RFactorDec</c>
	/// labeled alternative in <see cref="KtlynsParser.factor"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRFactorDec([NotNull] KtlynsParser.RFactorDecContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RFactorTrue</c>
	/// labeled alternative in <see cref="KtlynsParser.factor"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRFactorTrue([NotNull] KtlynsParser.RFactorTrueContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RFactorTrue</c>
	/// labeled alternative in <see cref="KtlynsParser.factor"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRFactorTrue([NotNull] KtlynsParser.RFactorTrueContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RFactorFalse</c>
	/// labeled alternative in <see cref="KtlynsParser.factor"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRFactorFalse([NotNull] KtlynsParser.RFactorFalseContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RFactorFalse</c>
	/// labeled alternative in <see cref="KtlynsParser.factor"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRFactorFalse([NotNull] KtlynsParser.RFactorFalseContext context);
	/// <summary>
	/// Enter a parse tree produced by <see cref="KtlynsParser.string"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterString([NotNull] KtlynsParser.StringContext context);
	/// <summary>
	/// Exit a parse tree produced by <see cref="KtlynsParser.string"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitString([NotNull] KtlynsParser.StringContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RIDArray</c>
	/// labeled alternative in <see cref="KtlynsParser.id"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRIDArray([NotNull] KtlynsParser.RIDArrayContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RIDArray</c>
	/// labeled alternative in <see cref="KtlynsParser.id"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRIDArray([NotNull] KtlynsParser.RIDArrayContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RIDSimple</c>
	/// labeled alternative in <see cref="KtlynsParser.id"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRIDSimple([NotNull] KtlynsParser.RIDSimpleContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RIDSimple</c>
	/// labeled alternative in <see cref="KtlynsParser.id"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRIDSimple([NotNull] KtlynsParser.RIDSimpleContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RCallArgsAdd</c>
	/// labeled alternative in <see cref="KtlynsParser.call_args"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRCallArgsAdd([NotNull] KtlynsParser.RCallArgsAddContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RCallArgsAdd</c>
	/// labeled alternative in <see cref="KtlynsParser.call_args"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRCallArgsAdd([NotNull] KtlynsParser.RCallArgsAddContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RCallArgsExpr</c>
	/// labeled alternative in <see cref="KtlynsParser.call_args"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRCallArgsExpr([NotNull] KtlynsParser.RCallArgsExprContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RCallArgsExpr</c>
	/// labeled alternative in <see cref="KtlynsParser.call_args"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRCallArgsExpr([NotNull] KtlynsParser.RCallArgsExprContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RCallArgs</c>
	/// labeled alternative in <see cref="KtlynsParser.call_args"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRCallArgs([NotNull] KtlynsParser.RCallArgsContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RCallArgs</c>
	/// labeled alternative in <see cref="KtlynsParser.call_args"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRCallArgs([NotNull] KtlynsParser.RCallArgsContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RMthDeclArg</c>
	/// labeled alternative in <see cref="KtlynsParser.mth_decl_arg"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRMthDeclArg([NotNull] KtlynsParser.RMthDeclArgContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RMthDeclArg</c>
	/// labeled alternative in <see cref="KtlynsParser.mth_decl_arg"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRMthDeclArg([NotNull] KtlynsParser.RMthDeclArgContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RMthDeclArgAdd</c>
	/// labeled alternative in <see cref="KtlynsParser.mth_decl_arg"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRMthDeclArgAdd([NotNull] KtlynsParser.RMthDeclArgAddContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RMthDeclArgAdd</c>
	/// labeled alternative in <see cref="KtlynsParser.mth_decl_arg"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRMthDeclArgAdd([NotNull] KtlynsParser.RMthDeclArgAddContext context);
	/// <summary>
	/// Enter a parse tree produced by the <c>RMthDeclArgVar</c>
	/// labeled alternative in <see cref="KtlynsParser.mth_decl_arg"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void EnterRMthDeclArgVar([NotNull] KtlynsParser.RMthDeclArgVarContext context);
	/// <summary>
	/// Exit a parse tree produced by the <c>RMthDeclArgVar</c>
	/// labeled alternative in <see cref="KtlynsParser.mth_decl_arg"/>.
	/// </summary>
	/// <param name="context">The parse tree.</param>
	void ExitRMthDeclArgVar([NotNull] KtlynsParser.RMthDeclArgVarContext context);
}
