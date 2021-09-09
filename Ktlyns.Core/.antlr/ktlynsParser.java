// Generated from d:\Development\K@\Ktlyns\Ktlyns.Core\Ktlyns.g4 by ANTLR 4.8
 
	using Kat; 
	using System.Collections.Generic;
	
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class KtlynsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, WS=3, DEC=4, INT=5, TRUE=6, FALSE=7, PLUS=8, MINUS=9, 
		SLASH=10, STAR=11, AMP=12, STR=13, LPRN=14, RPRN=15, LBRC=16, RBRC=17, 
		COMMA=18, DOT=19, SDOT=20, EQ=21, IF=22, ELSE=23, AT=24, RET=25, AND=26, 
		OR=27, NOT=28, EQEQ=29, NEQEQ=30, GREAT=31, EQGREAT=32, LESS=33, EQLESS=34, 
		METHOD=35, EXTERNAL=36, ID=37, COMMENT=38, LINE_COMMENT=39;
	public static final int
		RULE_program = 0, RULE_block = 1, RULE_statements = 2, RULE_statement = 3, 
		RULE_if_else_decl = 4, RULE_var_decl = 5, RULE_mth_decl = 6, RULE_ex_mth_decl = 7, 
		RULE_mth = 8, RULE_expr = 9, RULE_unary = 10, RULE_factor = 11, RULE_string = 12, 
		RULE_id = 13, RULE_call_args = 14, RULE_mth_decl_arg = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "block", "statements", "statement", "if_else_decl", "var_decl", 
			"mth_decl", "ex_mth_decl", "mth", "expr", "unary", "factor", "string", 
			"id", "call_args", "mth_decl_arg"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'['", "']'", null, null, null, "'true'", "'false'", "'+'", "'-'", 
			"'/'", "'*'", "'&'", null, "'('", "')'", "'{'", "'}'", "','", "'.'", 
			"';'", "'='", "'if'", "'else'", "'@'", "'ret'", "'&&'", "'||'", "'!'", 
			"'=='", "'!='", "'>'", "'>='", "'<'", "'<='", "'method'", "'ext'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "WS", "DEC", "INT", "TRUE", "FALSE", "PLUS", "MINUS", 
			"SLASH", "STAR", "AMP", "STR", "LPRN", "RPRN", "LBRC", "RBRC", "COMMA", 
			"DOT", "SDOT", "EQ", "IF", "ELSE", "AT", "RET", "AND", "OR", "NOT", "EQEQ", 
			"NEQEQ", "GREAT", "EQGREAT", "LESS", "EQLESS", "METHOD", "EXTERNAL", 
			"ID", "COMMENT", "LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Ktlyns.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public KtlynsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			statements();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public KBlock Block;
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	 
		public BlockContext() { }
		public void copyFrom(BlockContext ctx) {
			super.copyFrom(ctx);
			this.Block = ctx.Block;
		}
	}
	public static class RBlockEmptyContext extends BlockContext {
		public TerminalNode LBRC() { return getToken(KtlynsParser.LBRC, 0); }
		public TerminalNode RBRC() { return getToken(KtlynsParser.RBRC, 0); }
		public RBlockEmptyContext(BlockContext ctx) { copyFrom(ctx); }
	}
	public static class RBlockStmtsContext extends BlockContext {
		public TerminalNode LBRC() { return getToken(KtlynsParser.LBRC, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode RBRC() { return getToken(KtlynsParser.RBRC, 0); }
		public RBlockStmtsContext(BlockContext ctx) { copyFrom(ctx); }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		try {
			setState(40);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new RBlockStmtsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				match(LBRC);
				setState(35);
				statements();
				setState(36);
				match(RBRC);
				}
				break;
			case 2:
				_localctx = new RBlockEmptyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(38);
				match(LBRC);
				setState(39);
				match(RBRC);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementsContext extends ParserRuleContext {
		public KBlock Block;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(42);
				statement();
				}
				}
				setState(45); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEC) | (1L << INT) | (1L << TRUE) | (1L << FALSE) | (1L << MINUS) | (1L << AMP) | (1L << STR) | (1L << LPRN) | (1L << IF) | (1L << RET) | (1L << NOT) | (1L << METHOD) | (1L << EXTERNAL) | (1L << ID))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public KStmt Stmt;
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
			this.Stmt = ctx.Stmt;
		}
	}
	public static class RStatementContext extends StatementContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SDOT() { return getToken(KtlynsParser.SDOT, 0); }
		public RStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class RStatementIfElseContext extends StatementContext {
		public If_else_declContext if_else_decl() {
			return getRuleContext(If_else_declContext.class,0);
		}
		public RStatementIfElseContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class RStatementVarDeclContext extends StatementContext {
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public TerminalNode SDOT() { return getToken(KtlynsParser.SDOT, 0); }
		public RStatementVarDeclContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class RStatementMthDeclContext extends StatementContext {
		public Mth_declContext mth_decl() {
			return getRuleContext(Mth_declContext.class,0);
		}
		public RStatementMthDeclContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class RStatementExMthDeclContext extends StatementContext {
		public Ex_mth_declContext ex_mth_decl() {
			return getRuleContext(Ex_mth_declContext.class,0);
		}
		public TerminalNode SDOT() { return getToken(KtlynsParser.SDOT, 0); }
		public RStatementExMthDeclContext(StatementContext ctx) { copyFrom(ctx); }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		try {
			setState(58);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new RStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				expr(0);
				setState(48);
				match(SDOT);
				}
				break;
			case 2:
				_localctx = new RStatementVarDeclContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				var_decl();
				setState(51);
				match(SDOT);
				}
				break;
			case 3:
				_localctx = new RStatementIfElseContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(53);
				if_else_decl();
				}
				break;
			case 4:
				_localctx = new RStatementMthDeclContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(54);
				mth_decl();
				}
				break;
			case 5:
				_localctx = new RStatementExMthDeclContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(55);
				ex_mth_decl();
				setState(56);
				match(SDOT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_else_declContext extends ParserRuleContext {
		public KStmt Stmt;
		public If_else_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_else_decl; }
	 
		public If_else_declContext() { }
		public void copyFrom(If_else_declContext ctx) {
			super.copyFrom(ctx);
			this.Stmt = ctx.Stmt;
		}
	}
	public static class RIfElseContext extends If_else_declContext {
		public TerminalNode IF() { return getToken(KtlynsParser.IF, 0); }
		public TerminalNode LPRN() { return getToken(KtlynsParser.LPRN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPRN() { return getToken(KtlynsParser.RPRN, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(KtlynsParser.ELSE, 0); }
		public RIfElseContext(If_else_declContext ctx) { copyFrom(ctx); }
	}

	public final If_else_declContext if_else_decl() throws RecognitionException {
		If_else_declContext _localctx = new If_else_declContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_if_else_decl);
		try {
			_localctx = new RIfElseContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(IF);
			setState(61);
			match(LPRN);
			setState(62);
			expr(0);
			setState(63);
			match(RPRN);
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRC:
				{
				setState(64);
				block();
				}
				break;
			case DEC:
			case INT:
			case TRUE:
			case FALSE:
			case MINUS:
			case AMP:
			case STR:
			case LPRN:
			case IF:
			case RET:
			case NOT:
			case METHOD:
			case EXTERNAL:
			case ID:
				{
				setState(65);
				statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(68);
				match(ELSE);
				setState(71);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LBRC:
					{
					setState(69);
					block();
					}
					break;
				case DEC:
				case INT:
				case TRUE:
				case FALSE:
				case MINUS:
				case AMP:
				case STR:
				case LPRN:
				case IF:
				case RET:
				case NOT:
				case METHOD:
				case EXTERNAL:
				case ID:
					{
					setState(70);
					statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_declContext extends ParserRuleContext {
		public KStmt Stmt;
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
	 
		public Var_declContext() { }
		public void copyFrom(Var_declContext ctx) {
			super.copyFrom(ctx);
			this.Stmt = ctx.Stmt;
		}
	}
	public static class RVarDeclExprContext extends Var_declContext {
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public TerminalNode EQ() { return getToken(KtlynsParser.EQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RVarDeclExprContext(Var_declContext ctx) { copyFrom(ctx); }
	}
	public static class RVarDeclContext extends Var_declContext {
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public RVarDeclContext(Var_declContext ctx) { copyFrom(ctx); }
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_var_decl);
		try {
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new RVarDeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				id(0);
				setState(76);
				id(0);
				}
				break;
			case 2:
				_localctx = new RVarDeclExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				id(0);
				setState(79);
				id(0);
				setState(80);
				match(EQ);
				setState(81);
				expr(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Mth_declContext extends ParserRuleContext {
		public KStmt Stmt;
		public MthContext mth() {
			return getRuleContext(MthContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode LPRN() { return getToken(KtlynsParser.LPRN, 0); }
		public Mth_decl_argContext mth_decl_arg() {
			return getRuleContext(Mth_decl_argContext.class,0);
		}
		public TerminalNode RPRN() { return getToken(KtlynsParser.RPRN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Mth_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mth_decl; }
	}

	public final Mth_declContext mth_decl() throws RecognitionException {
		Mth_declContext _localctx = new Mth_declContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_mth_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			mth();
			setState(86);
			id(0);
			setState(87);
			match(LPRN);
			setState(88);
			mth_decl_arg(0);
			setState(89);
			match(RPRN);
			setState(90);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ex_mth_declContext extends ParserRuleContext {
		public KStmt Stmt;
		public TerminalNode EXTERNAL() { return getToken(KtlynsParser.EXTERNAL, 0); }
		public MthContext mth() {
			return getRuleContext(MthContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode LPRN() { return getToken(KtlynsParser.LPRN, 0); }
		public Mth_decl_argContext mth_decl_arg() {
			return getRuleContext(Mth_decl_argContext.class,0);
		}
		public TerminalNode RPRN() { return getToken(KtlynsParser.RPRN, 0); }
		public Ex_mth_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ex_mth_decl; }
	}

	public final Ex_mth_declContext ex_mth_decl() throws RecognitionException {
		Ex_mth_declContext _localctx = new Ex_mth_declContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ex_mth_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(EXTERNAL);
			setState(93);
			mth();
			setState(94);
			id(0);
			setState(95);
			match(LPRN);
			setState(96);
			mth_decl_arg(0);
			setState(97);
			match(RPRN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MthContext extends ParserRuleContext {
		public KId Id;
		public MthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mth; }
	 
		public MthContext() { }
		public void copyFrom(MthContext ctx) {
			super.copyFrom(ctx);
			this.Id = ctx.Id;
		}
	}
	public static class RMthVoidContext extends MthContext {
		public TerminalNode METHOD() { return getToken(KtlynsParser.METHOD, 0); }
		public RMthVoidContext(MthContext ctx) { copyFrom(ctx); }
	}
	public static class RMthTypeContext extends MthContext {
		public TerminalNode METHOD() { return getToken(KtlynsParser.METHOD, 0); }
		public TerminalNode LESS() { return getToken(KtlynsParser.LESS, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode GREAT() { return getToken(KtlynsParser.GREAT, 0); }
		public RMthTypeContext(MthContext ctx) { copyFrom(ctx); }
	}

	public final MthContext mth() throws RecognitionException {
		MthContext _localctx = new MthContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_mth);
		try {
			setState(105);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new RMthVoidContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				match(METHOD);
				}
				break;
			case 2:
				_localctx = new RMthTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				match(METHOD);
				setState(101);
				match(LESS);
				setState(102);
				id(0);
				setState(103);
				match(GREAT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public KExpr Expr;
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
			this.Expr = ctx.Expr;
		}
	}
	public static class RExprUnaryContext extends ExprContext {
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public RExprUnaryContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class RExprBinAddContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(KtlynsParser.PLUS, 0); }
		public RExprBinAddContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class RExprBinSubContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MINUS() { return getToken(KtlynsParser.MINUS, 0); }
		public RExprBinSubContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class RExprBinEGreatContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQGREAT() { return getToken(KtlynsParser.EQGREAT, 0); }
		public RExprBinEGreatContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class RExprCallContext extends ExprContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode LPRN() { return getToken(KtlynsParser.LPRN, 0); }
		public Call_argsContext call_args() {
			return getRuleContext(Call_argsContext.class,0);
		}
		public TerminalNode RPRN() { return getToken(KtlynsParser.RPRN, 0); }
		public RExprCallContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class RExprReturnContext extends ExprContext {
		public TerminalNode RET() { return getToken(KtlynsParser.RET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RExprReturnContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class RExprIdContext extends ExprContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public RExprIdContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class RExprBinLessContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LESS() { return getToken(KtlynsParser.LESS, 0); }
		public RExprBinLessContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class RExprBinDivContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode SLASH() { return getToken(KtlynsParser.SLASH, 0); }
		public RExprBinDivContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class RExprAssignContext extends ExprContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode EQ() { return getToken(KtlynsParser.EQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RExprAssignContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class RExprBinEqContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQEQ() { return getToken(KtlynsParser.EQEQ, 0); }
		public RExprBinEqContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class RExprBinELessContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQLESS() { return getToken(KtlynsParser.EQLESS, 0); }
		public RExprBinELessContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class RExprBinMultContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode STAR() { return getToken(KtlynsParser.STAR, 0); }
		public RExprBinMultContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class RExprBinGreatContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode GREAT() { return getToken(KtlynsParser.GREAT, 0); }
		public RExprBinGreatContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class RExprStringContext extends ExprContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public RExprStringContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class RExprGroupContext extends ExprContext {
		public TerminalNode LPRN() { return getToken(KtlynsParser.LPRN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPRN() { return getToken(KtlynsParser.RPRN, 0); }
		public RExprGroupContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class RExprBinNEqContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode NEQEQ() { return getToken(KtlynsParser.NEQEQ, 0); }
		public RExprBinNEqContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				_localctx = new RExprStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(108);
				string();
				}
				break;
			case 2:
				{
				_localctx = new RExprIdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(109);
				id(0);
				}
				break;
			case 3:
				{
				_localctx = new RExprCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(110);
				id(0);
				setState(111);
				match(LPRN);
				setState(112);
				call_args(0);
				setState(113);
				match(RPRN);
				}
				break;
			case 4:
				{
				_localctx = new RExprGroupContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(115);
				match(LPRN);
				setState(116);
				expr(0);
				setState(117);
				match(RPRN);
				}
				break;
			case 5:
				{
				_localctx = new RExprUnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(119);
				unary();
				}
				break;
			case 6:
				{
				_localctx = new RExprAssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(120);
				id(0);
				setState(121);
				match(EQ);
				setState(122);
				expr(2);
				}
				break;
			case 7:
				{
				_localctx = new RExprReturnContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(124);
				match(RET);
				setState(126);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(125);
					expr(0);
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(162);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(160);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new RExprBinMultContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(130);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(131);
						match(STAR);
						setState(132);
						expr(13);
						}
						break;
					case 2:
						{
						_localctx = new RExprBinDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(133);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(134);
						match(SLASH);
						setState(135);
						expr(12);
						}
						break;
					case 3:
						{
						_localctx = new RExprBinAddContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(136);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(137);
						match(PLUS);
						setState(138);
						expr(11);
						}
						break;
					case 4:
						{
						_localctx = new RExprBinSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(139);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(140);
						match(MINUS);
						setState(141);
						expr(10);
						}
						break;
					case 5:
						{
						_localctx = new RExprBinEqContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(142);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(143);
						match(EQEQ);
						setState(144);
						expr(9);
						}
						break;
					case 6:
						{
						_localctx = new RExprBinNEqContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(145);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(146);
						match(NEQEQ);
						setState(147);
						expr(8);
						}
						break;
					case 7:
						{
						_localctx = new RExprBinGreatContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(148);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(149);
						match(GREAT);
						setState(150);
						expr(7);
						}
						break;
					case 8:
						{
						_localctx = new RExprBinEGreatContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(151);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(152);
						match(EQGREAT);
						setState(153);
						expr(6);
						}
						break;
					case 9:
						{
						_localctx = new RExprBinLessContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(154);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(155);
						match(LESS);
						setState(156);
						expr(5);
						}
						break;
					case 10:
						{
						_localctx = new RExprBinELessContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(157);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(158);
						match(EQLESS);
						setState(159);
						expr(4);
						}
						break;
					}
					} 
				}
				setState(164);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryContext extends ParserRuleContext {
		public KExpr Expr;
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
	 
		public UnaryContext() { }
		public void copyFrom(UnaryContext ctx) {
			super.copyFrom(ctx);
			this.Expr = ctx.Expr;
		}
	}
	public static class RUnaryAddressContext extends UnaryContext {
		public TerminalNode AMP() { return getToken(KtlynsParser.AMP, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public RUnaryAddressContext(UnaryContext ctx) { copyFrom(ctx); }
	}
	public static class RUnaryNotContext extends UnaryContext {
		public TerminalNode NOT() { return getToken(KtlynsParser.NOT, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public RUnaryNotContext(UnaryContext ctx) { copyFrom(ctx); }
	}
	public static class RUnaryFactorContext extends UnaryContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public RUnaryFactorContext(UnaryContext ctx) { copyFrom(ctx); }
	}
	public static class RUnaryMinusContext extends UnaryContext {
		public TerminalNode MINUS() { return getToken(KtlynsParser.MINUS, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public RUnaryMinusContext(UnaryContext ctx) { copyFrom(ctx); }
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_unary);
		try {
			setState(172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DEC:
			case INT:
			case TRUE:
			case FALSE:
				_localctx = new RUnaryFactorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				factor();
				}
				break;
			case MINUS:
				_localctx = new RUnaryMinusContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				match(MINUS);
				setState(167);
				factor();
				}
				break;
			case NOT:
				_localctx = new RUnaryNotContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(168);
				match(NOT);
				setState(169);
				factor();
				}
				break;
			case AMP:
				_localctx = new RUnaryAddressContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(170);
				match(AMP);
				setState(171);
				id(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public KExpr Expr;
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	 
		public FactorContext() { }
		public void copyFrom(FactorContext ctx) {
			super.copyFrom(ctx);
			this.Expr = ctx.Expr;
		}
	}
	public static class RFactorIntContext extends FactorContext {
		public TerminalNode INT() { return getToken(KtlynsParser.INT, 0); }
		public RFactorIntContext(FactorContext ctx) { copyFrom(ctx); }
	}
	public static class RFactorFalseContext extends FactorContext {
		public TerminalNode FALSE() { return getToken(KtlynsParser.FALSE, 0); }
		public RFactorFalseContext(FactorContext ctx) { copyFrom(ctx); }
	}
	public static class RFactorDecContext extends FactorContext {
		public TerminalNode DEC() { return getToken(KtlynsParser.DEC, 0); }
		public RFactorDecContext(FactorContext ctx) { copyFrom(ctx); }
	}
	public static class RFactorTrueContext extends FactorContext {
		public TerminalNode TRUE() { return getToken(KtlynsParser.TRUE, 0); }
		public RFactorTrueContext(FactorContext ctx) { copyFrom(ctx); }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_factor);
		try {
			setState(178);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new RFactorIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				match(INT);
				}
				break;
			case DEC:
				_localctx = new RFactorDecContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				match(DEC);
				}
				break;
			case TRUE:
				_localctx = new RFactorTrueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(176);
				match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new RFactorFalseContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(177);
				match(FALSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringContext extends ParserRuleContext {
		public KStr Str;
		public TerminalNode STR() { return getToken(KtlynsParser.STR, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(STR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdContext extends ParserRuleContext {
		public KId Id;
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
	 
		public IdContext() { }
		public void copyFrom(IdContext ctx) {
			super.copyFrom(ctx);
			this.Id = ctx.Id;
		}
	}
	public static class RIDArrayContext extends IdContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode INT() { return getToken(KtlynsParser.INT, 0); }
		public RIDArrayContext(IdContext ctx) { copyFrom(ctx); }
	}
	public static class RIDSimpleContext extends IdContext {
		public TerminalNode ID() { return getToken(KtlynsParser.ID, 0); }
		public RIDSimpleContext(IdContext ctx) { copyFrom(ctx); }
	}

	public final IdContext id() throws RecognitionException {
		return id(0);
	}

	private IdContext id(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		IdContext _localctx = new IdContext(_ctx, _parentState);
		IdContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_id, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new RIDSimpleContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(183);
			match(ID);
			}
			_ctx.stop = _input.LT(-1);
			setState(193);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RIDArrayContext(new IdContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_id);
					setState(185);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(186);
					match(T__0);
					setState(188);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==INT) {
						{
						setState(187);
						match(INT);
						}
					}

					setState(190);
					match(T__1);
					}
					} 
				}
				setState(195);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Call_argsContext extends ParserRuleContext {
		public List<KExpr> Exprs;
		public Call_argsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_args; }
	 
		public Call_argsContext() { }
		public void copyFrom(Call_argsContext ctx) {
			super.copyFrom(ctx);
			this.Exprs = ctx.Exprs;
		}
	}
	public static class RCallArgsAddContext extends Call_argsContext {
		public Call_argsContext call_args() {
			return getRuleContext(Call_argsContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(KtlynsParser.COMMA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RCallArgsAddContext(Call_argsContext ctx) { copyFrom(ctx); }
	}
	public static class RCallArgsExprContext extends Call_argsContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RCallArgsExprContext(Call_argsContext ctx) { copyFrom(ctx); }
	}
	public static class RCallArgsContext extends Call_argsContext {
		public RCallArgsContext(Call_argsContext ctx) { copyFrom(ctx); }
	}

	public final Call_argsContext call_args() throws RecognitionException {
		return call_args(0);
	}

	private Call_argsContext call_args(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Call_argsContext _localctx = new Call_argsContext(_ctx, _parentState);
		Call_argsContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_call_args, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				_localctx = new RCallArgsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				}
				break;
			case 2:
				{
				_localctx = new RCallArgsExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(197);
				expr(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(205);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RCallArgsAddContext(new Call_argsContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_call_args);
					setState(200);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(201);
					match(COMMA);
					setState(202);
					expr(0);
					}
					} 
				}
				setState(207);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Mth_decl_argContext extends ParserRuleContext {
		public List<KVarDecl> Decls;
		public Mth_decl_argContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mth_decl_arg; }
	 
		public Mth_decl_argContext() { }
		public void copyFrom(Mth_decl_argContext ctx) {
			super.copyFrom(ctx);
			this.Decls = ctx.Decls;
		}
	}
	public static class RMthDeclArgContext extends Mth_decl_argContext {
		public RMthDeclArgContext(Mth_decl_argContext ctx) { copyFrom(ctx); }
	}
	public static class RMthDeclArgAddContext extends Mth_decl_argContext {
		public Mth_decl_argContext mth_decl_arg() {
			return getRuleContext(Mth_decl_argContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(KtlynsParser.COMMA, 0); }
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public RMthDeclArgAddContext(Mth_decl_argContext ctx) { copyFrom(ctx); }
	}
	public static class RMthDeclArgVarContext extends Mth_decl_argContext {
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public RMthDeclArgVarContext(Mth_decl_argContext ctx) { copyFrom(ctx); }
	}

	public final Mth_decl_argContext mth_decl_arg() throws RecognitionException {
		return mth_decl_arg(0);
	}

	private Mth_decl_argContext mth_decl_arg(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Mth_decl_argContext _localctx = new Mth_decl_argContext(_ctx, _parentState);
		Mth_decl_argContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_mth_decl_arg, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				_localctx = new RMthDeclArgContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				}
				break;
			case 2:
				{
				_localctx = new RMthDeclArgVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(209);
				var_decl();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(217);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RMthDeclArgAddContext(new Mth_decl_argContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_mth_decl_arg);
					setState(212);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(213);
					match(COMMA);
					setState(214);
					var_decl();
					}
					} 
				}
				setState(219);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 13:
			return id_sempred((IdContext)_localctx, predIndex);
		case 14:
			return call_args_sempred((Call_argsContext)_localctx, predIndex);
		case 15:
			return mth_decl_arg_sempred((Mth_decl_argContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 6);
		case 7:
			return precpred(_ctx, 5);
		case 8:
			return precpred(_ctx, 4);
		case 9:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean id_sempred(IdContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean call_args_sempred(Call_argsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean mth_decl_arg_sempred(Mth_decl_argContext _localctx, int predIndex) {
		switch (predIndex) {
		case 12:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u00df\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\5\3+\n\3\3\4\6\4.\n\4\r\4\16\4/\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5=\n\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6E\n\6"+
		"\3\6\3\6\3\6\5\6J\n\6\5\6L\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7V\n"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\5\nl\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0081\n\13\5\13\u0083"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\7\13\u00a3\n\13\f\13\16\13\u00a6\13\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\5\f\u00af\n\f\3\r\3\r\3\r\3\r\5\r\u00b5\n\r\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\5\17\u00bf\n\17\3\17\7\17\u00c2\n\17\f\17\16"+
		"\17\u00c5\13\17\3\20\3\20\5\20\u00c9\n\20\3\20\3\20\3\20\7\20\u00ce\n"+
		"\20\f\20\16\20\u00d1\13\20\3\21\3\21\5\21\u00d5\n\21\3\21\3\21\3\21\7"+
		"\21\u00da\n\21\f\21\16\21\u00dd\13\21\3\21\2\6\24\34\36 \22\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \2\2\2\u00f6\2\"\3\2\2\2\4*\3\2\2\2\6-\3"+
		"\2\2\2\b<\3\2\2\2\n>\3\2\2\2\fU\3\2\2\2\16W\3\2\2\2\20^\3\2\2\2\22k\3"+
		"\2\2\2\24\u0082\3\2\2\2\26\u00ae\3\2\2\2\30\u00b4\3\2\2\2\32\u00b6\3\2"+
		"\2\2\34\u00b8\3\2\2\2\36\u00c8\3\2\2\2 \u00d4\3\2\2\2\"#\5\6\4\2#\3\3"+
		"\2\2\2$%\7\22\2\2%&\5\6\4\2&\'\7\23\2\2\'+\3\2\2\2()\7\22\2\2)+\7\23\2"+
		"\2*$\3\2\2\2*(\3\2\2\2+\5\3\2\2\2,.\5\b\5\2-,\3\2\2\2./\3\2\2\2/-\3\2"+
		"\2\2/\60\3\2\2\2\60\7\3\2\2\2\61\62\5\24\13\2\62\63\7\26\2\2\63=\3\2\2"+
		"\2\64\65\5\f\7\2\65\66\7\26\2\2\66=\3\2\2\2\67=\5\n\6\28=\5\16\b\29:\5"+
		"\20\t\2:;\7\26\2\2;=\3\2\2\2<\61\3\2\2\2<\64\3\2\2\2<\67\3\2\2\2<8\3\2"+
		"\2\2<9\3\2\2\2=\t\3\2\2\2>?\7\30\2\2?@\7\20\2\2@A\5\24\13\2AD\7\21\2\2"+
		"BE\5\4\3\2CE\5\b\5\2DB\3\2\2\2DC\3\2\2\2EK\3\2\2\2FI\7\31\2\2GJ\5\4\3"+
		"\2HJ\5\b\5\2IG\3\2\2\2IH\3\2\2\2JL\3\2\2\2KF\3\2\2\2KL\3\2\2\2L\13\3\2"+
		"\2\2MN\5\34\17\2NO\5\34\17\2OV\3\2\2\2PQ\5\34\17\2QR\5\34\17\2RS\7\27"+
		"\2\2ST\5\24\13\2TV\3\2\2\2UM\3\2\2\2UP\3\2\2\2V\r\3\2\2\2WX\5\22\n\2X"+
		"Y\5\34\17\2YZ\7\20\2\2Z[\5 \21\2[\\\7\21\2\2\\]\5\4\3\2]\17\3\2\2\2^_"+
		"\7&\2\2_`\5\22\n\2`a\5\34\17\2ab\7\20\2\2bc\5 \21\2cd\7\21\2\2d\21\3\2"+
		"\2\2el\7%\2\2fg\7%\2\2gh\7#\2\2hi\5\34\17\2ij\7!\2\2jl\3\2\2\2ke\3\2\2"+
		"\2kf\3\2\2\2l\23\3\2\2\2mn\b\13\1\2n\u0083\5\32\16\2o\u0083\5\34\17\2"+
		"pq\5\34\17\2qr\7\20\2\2rs\5\36\20\2st\7\21\2\2t\u0083\3\2\2\2uv\7\20\2"+
		"\2vw\5\24\13\2wx\7\21\2\2x\u0083\3\2\2\2y\u0083\5\26\f\2z{\5\34\17\2{"+
		"|\7\27\2\2|}\5\24\13\4}\u0083\3\2\2\2~\u0080\7\33\2\2\177\u0081\5\24\13"+
		"\2\u0080\177\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0083\3\2\2\2\u0082m\3"+
		"\2\2\2\u0082o\3\2\2\2\u0082p\3\2\2\2\u0082u\3\2\2\2\u0082y\3\2\2\2\u0082"+
		"z\3\2\2\2\u0082~\3\2\2\2\u0083\u00a4\3\2\2\2\u0084\u0085\f\16\2\2\u0085"+
		"\u0086\7\r\2\2\u0086\u00a3\5\24\13\17\u0087\u0088\f\r\2\2\u0088\u0089"+
		"\7\f\2\2\u0089\u00a3\5\24\13\16\u008a\u008b\f\f\2\2\u008b\u008c\7\n\2"+
		"\2\u008c\u00a3\5\24\13\r\u008d\u008e\f\13\2\2\u008e\u008f\7\13\2\2\u008f"+
		"\u00a3\5\24\13\f\u0090\u0091\f\n\2\2\u0091\u0092\7\37\2\2\u0092\u00a3"+
		"\5\24\13\13\u0093\u0094\f\t\2\2\u0094\u0095\7 \2\2\u0095\u00a3\5\24\13"+
		"\n\u0096\u0097\f\b\2\2\u0097\u0098\7!\2\2\u0098\u00a3\5\24\13\t\u0099"+
		"\u009a\f\7\2\2\u009a\u009b\7\"\2\2\u009b\u00a3\5\24\13\b\u009c\u009d\f"+
		"\6\2\2\u009d\u009e\7#\2\2\u009e\u00a3\5\24\13\7\u009f\u00a0\f\5\2\2\u00a0"+
		"\u00a1\7$\2\2\u00a1\u00a3\5\24\13\6\u00a2\u0084\3\2\2\2\u00a2\u0087\3"+
		"\2\2\2\u00a2\u008a\3\2\2\2\u00a2\u008d\3\2\2\2\u00a2\u0090\3\2\2\2\u00a2"+
		"\u0093\3\2\2\2\u00a2\u0096\3\2\2\2\u00a2\u0099\3\2\2\2\u00a2\u009c\3\2"+
		"\2\2\u00a2\u009f\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4"+
		"\u00a5\3\2\2\2\u00a5\25\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00af\5\30\r"+
		"\2\u00a8\u00a9\7\13\2\2\u00a9\u00af\5\30\r\2\u00aa\u00ab\7\36\2\2\u00ab"+
		"\u00af\5\30\r\2\u00ac\u00ad\7\16\2\2\u00ad\u00af\5\34\17\2\u00ae\u00a7"+
		"\3\2\2\2\u00ae\u00a8\3\2\2\2\u00ae\u00aa\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af"+
		"\27\3\2\2\2\u00b0\u00b5\7\7\2\2\u00b1\u00b5\7\6\2\2\u00b2\u00b5\7\b\2"+
		"\2\u00b3\u00b5\7\t\2\2\u00b4\u00b0\3\2\2\2\u00b4\u00b1\3\2\2\2\u00b4\u00b2"+
		"\3\2\2\2\u00b4\u00b3\3\2\2\2\u00b5\31\3\2\2\2\u00b6\u00b7\7\17\2\2\u00b7"+
		"\33\3\2\2\2\u00b8\u00b9\b\17\1\2\u00b9\u00ba\7\'\2\2\u00ba\u00c3\3\2\2"+
		"\2\u00bb\u00bc\f\4\2\2\u00bc\u00be\7\3\2\2\u00bd\u00bf\7\7\2\2\u00be\u00bd"+
		"\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c2\7\4\2\2\u00c1"+
		"\u00bb\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2"+
		"\2\2\u00c4\35\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c9\b\20\1\2\u00c7\u00c9"+
		"\5\24\13\2\u00c8\u00c6\3\2\2\2\u00c8\u00c7\3\2\2\2\u00c9\u00cf\3\2\2\2"+
		"\u00ca\u00cb\f\3\2\2\u00cb\u00cc\7\24\2\2\u00cc\u00ce\5\24\13\2\u00cd"+
		"\u00ca\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2"+
		"\2\2\u00d0\37\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d5\b\21\1\2\u00d3\u00d5"+
		"\5\f\7\2\u00d4\u00d2\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5\u00db\3\2\2\2\u00d6"+
		"\u00d7\f\3\2\2\u00d7\u00d8\7\24\2\2\u00d8\u00da\5\f\7\2\u00d9\u00d6\3"+
		"\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc"+
		"!\3\2\2\2\u00dd\u00db\3\2\2\2\26*/<DIKUk\u0080\u0082\u00a2\u00a4\u00ae"+
		"\u00b4\u00be\u00c3\u00c8\u00cf\u00d4\u00db";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}