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
using IErrorNode = Antlr4.Runtime.Tree.IErrorNode;
using ITerminalNode = Antlr4.Runtime.Tree.ITerminalNode;
using IToken = Antlr4.Runtime.IToken;
using ParserRuleContext = Antlr4.Runtime.ParserRuleContext;

/// <summary>
/// This class provides an empty implementation of <see cref="IKtlynsListener"/>,
/// which can be extended to create a listener which only needs to handle a subset
/// of the available methods.
/// </summary>
[System.CodeDom.Compiler.GeneratedCode("ANTLR", "4.9.2")]
[System.Diagnostics.DebuggerNonUserCode]
[System.CLSCompliant(false)]
public partial class KtlynsBaseListener : IKtlynsListener {
	/// <summary>
	/// Enter a parse tree produced by <see cref="KtlynsParser.program"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterProgram([NotNull] KtlynsParser.ProgramContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="KtlynsParser.program"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitProgram([NotNull] KtlynsParser.ProgramContext context) { }
	/// <summary>
	/// Enter a parse tree produced by the <c>RBlockStmts</c>
	/// labeled alternative in <see cref="KtlynsParser.block"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterRBlockStmts([NotNull] KtlynsParser.RBlockStmtsContext context) { }
	/// <summary>
	/// Exit a parse tree produced by the <c>RBlockStmts</c>
	/// labeled alternative in <see cref="KtlynsParser.block"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitRBlockStmts([NotNull] KtlynsParser.RBlockStmtsContext context) { }
	/// <summary>
	/// Enter a parse tree produced by the <c>RBlockEmpty</c>
	/// labeled alternative in <see cref="KtlynsParser.block"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterRBlockEmpty([NotNull] KtlynsParser.RBlockEmptyContext context) { }
	/// <summary>
	/// Exit a parse tree produced by the <c>RBlockEmpty</c>
	/// labeled alternative in <see cref="KtlynsParser.block"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitRBlockEmpty([NotNull] KtlynsParser.RBlockEmptyContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="KtlynsParser.statements"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterStatements([NotNull] KtlynsParser.StatementsContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="KtlynsParser.statements"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitStatements([NotNull] KtlynsParser.StatementsContext context) { }
	/// <summary>
	/// Enter a parse tree produced by the <c>RStatement</c>
	/// labeled alternative in <see cref="KtlynsParser.statement"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterRStatement([NotNull] KtlynsParser.RStatementContext context) { }
	/// <summary>
	/// Exit a parse tree produced by the <c>RStatement</c>
	/// labeled alternative in <see cref="KtlynsParser.statement"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitRStatement([NotNull] KtlynsParser.RStatementContext context) { }
	/// <summary>
	/// Enter a parse tree produced by the <c>RStatementVarDecl</c>
	/// labeled alternative in <see cref="KtlynsParser.statement"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterRStatementVarDecl([NotNull] KtlynsParser.RStatementVarDeclContext context) { }
	/// <summary>
	/// Exit a parse tree produced by the <c>RStatementVarDecl</c>
	/// labeled alternative in <see cref="KtlynsParser.statement"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitRStatementVarDecl([NotNull] KtlynsParser.RStatementVarDeclContext context) { }
	/// <summary>
	/// Enter a parse tree produced by the <c>RStatementMthDecl</c>
	/// labeled alternative in <see cref="KtlynsParser.statement"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterRStatementMthDecl([NotNull] KtlynsParser.RStatementMthDeclContext context) { }
	/// <summary>
	/// Exit a parse tree produced by the <c>RStatementMthDecl</c>
	/// labeled alternative in <see cref="KtlynsParser.statement"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitRStatementMthDecl([NotNull] KtlynsParser.RStatementMthDeclContext context) { }
	/// <summary>
	/// Enter a parse tree produced by the <c>RStatementExMthDecl</c>
	/// labeled alternative in <see cref="KtlynsParser.statement"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterRStatementExMthDecl([NotNull] KtlynsParser.RStatementExMthDeclContext context) { }
	/// <summary>
	/// Exit a parse tree produced by the <c>RStatementExMthDecl</c>
	/// labeled alternative in <see cref="KtlynsParser.statement"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitRStatementExMthDecl([NotNull] KtlynsParser.RStatementExMthDeclContext context) { }
	/// <summary>
	/// Enter a parse tree produced by the <c>RVarDecl</c>
	/// labeled alternative in <see cref="KtlynsParser.var_decl"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterRVarDecl([NotNull] KtlynsParser.RVarDeclContext context) { }
	/// <summary>
	/// Exit a parse tree produced by the <c>RVarDecl</c>
	/// labeled alternative in <see cref="KtlynsParser.var_decl"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitRVarDecl([NotNull] KtlynsParser.RVarDeclContext context) { }
	/// <summary>
	/// Enter a parse tree produced by the <c>RVarDeclExpr</c>
	/// labeled alternative in <see cref="KtlynsParser.var_decl"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterRVarDeclExpr([NotNull] KtlynsParser.RVarDeclExprContext context) { }
	/// <summary>
	/// Exit a parse tree produced by the <c>RVarDeclExpr</c>
	/// labeled alternative in <see cref="KtlynsParser.var_decl"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitRVarDeclExpr([NotNull] KtlynsParser.RVarDeclExprContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="KtlynsParser.mth_decl"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterMth_decl([NotNull] KtlynsParser.Mth_declContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="KtlynsParser.mth_decl"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitMth_decl([NotNull] KtlynsParser.Mth_declContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="KtlynsParser.ex_mth_decl"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterEx_mth_decl([NotNull] KtlynsParser.Ex_mth_declContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="KtlynsParser.ex_mth_decl"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitEx_mth_decl([NotNull] KtlynsParser.Ex_mth_declContext context) { }
	/// <summary>
	/// Enter a parse tree produced by the <c>RMthVoid</c>
	/// labeled alternative in <see cref="KtlynsParser.mth"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterRMthVoid([NotNull] KtlynsParser.RMthVoidContext context) { }
	/// <summary>
	/// Exit a parse tree produced by the <c>RMthVoid</c>
	/// labeled alternative in <see cref="KtlynsParser.mth"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitRMthVoid([NotNull] KtlynsParser.RMthVoidContext context) { }
	/// <summary>
	/// Enter a parse tree produced by the <c>RMthType</c>
	/// labeled alternative in <see cref="KtlynsParser.mth"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterRMthType([NotNull] KtlynsParser.RMthTypeContext context) { }
	/// <summary>
	/// Exit a parse tree produced by the <c>RMthType</c>
	/// labeled alternative in <see cref="KtlynsParser.mth"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitRMthType([NotNull] KtlynsParser.RMthTypeContext context) { }
	/// <summary>
	/// Enter a parse tree produced by the <c>RExprUnary</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterRExprUnary([NotNull] KtlynsParser.RExprUnaryContext context) { }
	/// <summary>
	/// Exit a parse tree produced by the <c>RExprUnary</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitRExprUnary([NotNull] KtlynsParser.RExprUnaryContext context) { }
	/// <summary>
	/// Enter a parse tree produced by the <c>RExprBinDiv</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterRExprBinDiv([NotNull] KtlynsParser.RExprBinDivContext context) { }
	/// <summary>
	/// Exit a parse tree produced by the <c>RExprBinDiv</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitRExprBinDiv([NotNull] KtlynsParser.RExprBinDivContext context) { }
	/// <summary>
	/// Enter a parse tree produced by the <c>RExprBinAdd</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterRExprBinAdd([NotNull] KtlynsParser.RExprBinAddContext context) { }
	/// <summary>
	/// Exit a parse tree produced by the <c>RExprBinAdd</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitRExprBinAdd([NotNull] KtlynsParser.RExprBinAddContext context) { }
	/// <summary>
	/// Enter a parse tree produced by the <c>RExprBinSub</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterRExprBinSub([NotNull] KtlynsParser.RExprBinSubContext context) { }
	/// <summary>
	/// Exit a parse tree produced by the <c>RExprBinSub</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitRExprBinSub([NotNull] KtlynsParser.RExprBinSubContext context) { }
	/// <summary>
	/// Enter a parse tree produced by the <c>RExprAssign</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterRExprAssign([NotNull] KtlynsParser.RExprAssignContext context) { }
	/// <summary>
	/// Exit a parse tree produced by the <c>RExprAssign</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitRExprAssign([NotNull] KtlynsParser.RExprAssignContext context) { }
	/// <summary>
	/// Enter a parse tree produced by the <c>RExprCall</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterRExprCall([NotNull] KtlynsParser.RExprCallContext context) { }
	/// <summary>
	/// Exit a parse tree produced by the <c>RExprCall</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitRExprCall([NotNull] KtlynsParser.RExprCallContext context) { }
	/// <summary>
	/// Enter a parse tree produced by the <c>RExprBinMult</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterRExprBinMult([NotNull] KtlynsParser.RExprBinMultContext context) { }
	/// <summary>
	/// Exit a parse tree produced by the <c>RExprBinMult</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitRExprBinMult([NotNull] KtlynsParser.RExprBinMultContext context) { }
	/// <summary>
	/// Enter a parse tree produced by the <c>RExprReturn</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterRExprReturn([NotNull] KtlynsParser.RExprReturnContext context) { }
	/// <summary>
	/// Exit a parse tree produced by the <c>RExprReturn</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitRExprReturn([NotNull] KtlynsParser.RExprReturnContext context) { }
	/// <summary>
	/// Enter a parse tree produced by the <c>RExprString</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterRExprString([NotNull] KtlynsParser.RExprStringContext context) { }
	/// <summary>
	/// Exit a parse tree produced by the <c>RExprString</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitRExprString([NotNull] KtlynsParser.RExprStringContext context) { }
	/// <summary>
	/// Enter a parse tree produced by the <c>RExprGroup</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterRExprGroup([NotNull] KtlynsParser.RExprGroupContext context) { }
	/// <summary>
	/// Exit a parse tree produced by the <c>RExprGroup</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitRExprGroup([NotNull] KtlynsParser.RExprGroupContext context) { }
	/// <summary>
	/// Enter a parse tree produced by the <c>RExprId</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterRExprId([NotNull] KtlynsParser.RExprIdContext context) { }
	/// <summary>
	/// Exit a parse tree produced by the <c>RExprId</c>
	/// labeled alternative in <see cref="KtlynsParser.expr"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitRExprId([NotNull] KtlynsParser.RExprIdContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="KtlynsParser.unary"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterUnary([NotNull] KtlynsParser.UnaryContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="KtlynsParser.unary"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitUnary([NotNull] KtlynsParser.UnaryContext context) { }
	/// <summary>
	/// Enter a parse tree produced by the <c>RNumberInt</c>
	/// labeled alternative in <see cref="KtlynsParser.number"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterRNumberInt([NotNull] KtlynsParser.RNumberIntContext context) { }
	/// <summary>
	/// Exit a parse tree produced by the <c>RNumberInt</c>
	/// labeled alternative in <see cref="KtlynsParser.number"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitRNumberInt([NotNull] KtlynsParser.RNumberIntContext context) { }
	/// <summary>
	/// Enter a parse tree produced by the <c>RNumberDec</c>
	/// labeled alternative in <see cref="KtlynsParser.number"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterRNumberDec([NotNull] KtlynsParser.RNumberDecContext context) { }
	/// <summary>
	/// Exit a parse tree produced by the <c>RNumberDec</c>
	/// labeled alternative in <see cref="KtlynsParser.number"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitRNumberDec([NotNull] KtlynsParser.RNumberDecContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="KtlynsParser.string"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterString([NotNull] KtlynsParser.StringContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="KtlynsParser.string"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitString([NotNull] KtlynsParser.StringContext context) { }
	/// <summary>
	/// Enter a parse tree produced by <see cref="KtlynsParser.id"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterId([NotNull] KtlynsParser.IdContext context) { }
	/// <summary>
	/// Exit a parse tree produced by <see cref="KtlynsParser.id"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitId([NotNull] KtlynsParser.IdContext context) { }
	/// <summary>
	/// Enter a parse tree produced by the <c>RCallArgsAdd</c>
	/// labeled alternative in <see cref="KtlynsParser.call_args"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterRCallArgsAdd([NotNull] KtlynsParser.RCallArgsAddContext context) { }
	/// <summary>
	/// Exit a parse tree produced by the <c>RCallArgsAdd</c>
	/// labeled alternative in <see cref="KtlynsParser.call_args"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitRCallArgsAdd([NotNull] KtlynsParser.RCallArgsAddContext context) { }
	/// <summary>
	/// Enter a parse tree produced by the <c>RCallArgsExpr</c>
	/// labeled alternative in <see cref="KtlynsParser.call_args"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterRCallArgsExpr([NotNull] KtlynsParser.RCallArgsExprContext context) { }
	/// <summary>
	/// Exit a parse tree produced by the <c>RCallArgsExpr</c>
	/// labeled alternative in <see cref="KtlynsParser.call_args"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitRCallArgsExpr([NotNull] KtlynsParser.RCallArgsExprContext context) { }
	/// <summary>
	/// Enter a parse tree produced by the <c>RCallArgs</c>
	/// labeled alternative in <see cref="KtlynsParser.call_args"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterRCallArgs([NotNull] KtlynsParser.RCallArgsContext context) { }
	/// <summary>
	/// Exit a parse tree produced by the <c>RCallArgs</c>
	/// labeled alternative in <see cref="KtlynsParser.call_args"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitRCallArgs([NotNull] KtlynsParser.RCallArgsContext context) { }
	/// <summary>
	/// Enter a parse tree produced by the <c>RMthDeclArg</c>
	/// labeled alternative in <see cref="KtlynsParser.mth_decl_arg"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterRMthDeclArg([NotNull] KtlynsParser.RMthDeclArgContext context) { }
	/// <summary>
	/// Exit a parse tree produced by the <c>RMthDeclArg</c>
	/// labeled alternative in <see cref="KtlynsParser.mth_decl_arg"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitRMthDeclArg([NotNull] KtlynsParser.RMthDeclArgContext context) { }
	/// <summary>
	/// Enter a parse tree produced by the <c>RMthDeclArgAdd</c>
	/// labeled alternative in <see cref="KtlynsParser.mth_decl_arg"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterRMthDeclArgAdd([NotNull] KtlynsParser.RMthDeclArgAddContext context) { }
	/// <summary>
	/// Exit a parse tree produced by the <c>RMthDeclArgAdd</c>
	/// labeled alternative in <see cref="KtlynsParser.mth_decl_arg"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitRMthDeclArgAdd([NotNull] KtlynsParser.RMthDeclArgAddContext context) { }
	/// <summary>
	/// Enter a parse tree produced by the <c>RMthDeclArgVar</c>
	/// labeled alternative in <see cref="KtlynsParser.mth_decl_arg"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void EnterRMthDeclArgVar([NotNull] KtlynsParser.RMthDeclArgVarContext context) { }
	/// <summary>
	/// Exit a parse tree produced by the <c>RMthDeclArgVar</c>
	/// labeled alternative in <see cref="KtlynsParser.mth_decl_arg"/>.
	/// <para>The default implementation does nothing.</para>
	/// </summary>
	/// <param name="context">The parse tree.</param>
	public virtual void ExitRMthDeclArgVar([NotNull] KtlynsParser.RMthDeclArgVarContext context) { }

	/// <inheritdoc/>
	/// <remarks>The default implementation does nothing.</remarks>
	public virtual void EnterEveryRule([NotNull] ParserRuleContext context) { }
	/// <inheritdoc/>
	/// <remarks>The default implementation does nothing.</remarks>
	public virtual void ExitEveryRule([NotNull] ParserRuleContext context) { }
	/// <inheritdoc/>
	/// <remarks>The default implementation does nothing.</remarks>
	public virtual void VisitTerminal([NotNull] ITerminalNode node) { }
	/// <inheritdoc/>
	/// <remarks>The default implementation does nothing.</remarks>
	public virtual void VisitErrorNode([NotNull] IErrorNode node) { }
}
