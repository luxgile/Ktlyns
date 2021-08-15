// Generated from d:\Development\K@\Ktlyns\Ktlyns.g4 by ANTLR 4.8
 
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
		WS=1, DEC=2, INT=3, PLUS=4, MINUS=5, SLASH=6, STAR=7, STR=8, LPRN=9, RPRN=10, 
		LBRC=11, RBRC=12, LARR=13, RARR=14, COMMA=15, DOT=16, SDOT=17, EQ=18, 
		IF=19, ELSE=20, AT=21, RET=22, AND=23, OR=24, NOT=25, EQEQ=26, NEQEQ=27, 
		GREAT=28, EQGREAT=29, LESS=30, EQLESS=31, METHOD=32, ID=33;
	public static final int
		RULE_program = 0, RULE_block = 1, RULE_statements = 2, RULE_statement = 3, 
		RULE_var_decl = 4, RULE_mth_decl = 5, RULE_mth = 6, RULE_expr = 7, RULE_unary = 8, 
		RULE_number = 9, RULE_string = 10, RULE_id = 11, RULE_call_args = 12, 
		RULE_mth_decl_arg = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "block", "statements", "statement", "var_decl", "mth_decl", 
			"mth", "expr", "unary", "number", "string", "id", "call_args", "mth_decl_arg"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'+'", "'-'", "'/'", "'*'", null, "'('", "')'", 
			"'{'", "'}'", "'<'", "'>'", "','", "'.'", "';'", "'='", "'if'", "'else'", 
			"'@'", "'ret'", "'and'", "'or'", "'not'", "'equals'", "'not equals'", 
			"'great'", "'eq great'", "'less'", "'eq less'", "'method'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "DEC", "INT", "PLUS", "MINUS", "SLASH", "STAR", "STR", "LPRN", 
			"RPRN", "LBRC", "RBRC", "LARR", "RARR", "COMMA", "DOT", "SDOT", "EQ", 
			"IF", "ELSE", "AT", "RET", "AND", "OR", "NOT", "EQEQ", "NEQEQ", "GREAT", 
			"EQGREAT", "LESS", "EQLESS", "METHOD", "ID"
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
			setState(28);
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
			setState(36);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new RBlockStmtsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				match(LBRC);
				setState(31);
				statements();
				setState(32);
				match(RBRC);
				}
				break;
			case 2:
				_localctx = new RBlockEmptyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(34);
				match(LBRC);
				setState(35);
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
			setState(39); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(38);
				statement();
				}
				}
				setState(41); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEC) | (1L << INT) | (1L << MINUS) | (1L << STR) | (1L << LPRN) | (1L << RET) | (1L << METHOD) | (1L << ID))) != 0) );
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

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		try {
			setState(50);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new RStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				expr(0);
				setState(44);
				match(SDOT);
				}
				break;
			case 2:
				_localctx = new RStatementVarDeclContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				var_decl();
				setState(47);
				match(SDOT);
				}
				break;
			case 3:
				_localctx = new RStatementMthDeclContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(49);
				mth_decl();
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
		enterRule(_localctx, 8, RULE_var_decl);
		try {
			setState(60);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new RVarDeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				id();
				setState(53);
				id();
				}
				break;
			case 2:
				_localctx = new RVarDeclExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				id();
				setState(56);
				id();
				setState(57);
				match(EQ);
				setState(58);
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
		enterRule(_localctx, 10, RULE_mth_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			mth();
			setState(63);
			id();
			setState(64);
			match(LPRN);
			setState(65);
			mth_decl_arg(0);
			setState(66);
			match(RPRN);
			setState(67);
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
		public TerminalNode LARR() { return getToken(KtlynsParser.LARR, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode RARR() { return getToken(KtlynsParser.RARR, 0); }
		public RMthTypeContext(MthContext ctx) { copyFrom(ctx); }
	}

	public final MthContext mth() throws RecognitionException {
		MthContext _localctx = new MthContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_mth);
		try {
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new RMthVoidContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				match(METHOD);
				}
				break;
			case 2:
				_localctx = new RMthTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				match(METHOD);
				setState(71);
				match(LARR);
				setState(72);
				id();
				setState(73);
				match(RARR);
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
	public static class RExprReturnContext extends ExprContext {
		public TerminalNode RET() { return getToken(KtlynsParser.RET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RExprReturnContext(ExprContext ctx) { copyFrom(ctx); }
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
	public static class RExprIdContext extends ExprContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public RExprIdContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new RExprStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(78);
				string();
				}
				break;
			case 2:
				{
				_localctx = new RExprIdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(79);
				id();
				}
				break;
			case 3:
				{
				_localctx = new RExprAssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(80);
				id();
				setState(81);
				match(EQ);
				setState(82);
				expr(9);
				}
				break;
			case 4:
				{
				_localctx = new RExprCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(84);
				id();
				setState(85);
				match(LPRN);
				setState(86);
				call_args(0);
				setState(87);
				match(RPRN);
				}
				break;
			case 5:
				{
				_localctx = new RExprGroupContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(89);
				match(LPRN);
				setState(90);
				expr(0);
				setState(91);
				match(RPRN);
				}
				break;
			case 6:
				{
				_localctx = new RExprUnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(93);
				unary();
				}
				break;
			case 7:
				{
				_localctx = new RExprReturnContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(94);
				match(RET);
				setState(96);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(95);
					expr(0);
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(114);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(112);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new RExprBinMultContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(100);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(101);
						match(STAR);
						setState(102);
						expr(6);
						}
						break;
					case 2:
						{
						_localctx = new RExprBinDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(103);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(104);
						match(SLASH);
						setState(105);
						expr(5);
						}
						break;
					case 3:
						{
						_localctx = new RExprBinAddContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(106);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(107);
						match(PLUS);
						setState(108);
						expr(4);
						}
						break;
					case 4:
						{
						_localctx = new RExprBinSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(109);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(110);
						match(MINUS);
						setState(111);
						expr(3);
						}
						break;
					}
					} 
				}
				setState(116);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(KtlynsParser.MINUS, 0); }
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_unary);
		try {
			setState(120);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DEC:
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				number();
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				match(MINUS);
				setState(119);
				number();
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

	public static class NumberContext extends ParserRuleContext {
		public KExpr Expr;
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
	 
		public NumberContext() { }
		public void copyFrom(NumberContext ctx) {
			super.copyFrom(ctx);
			this.Expr = ctx.Expr;
		}
	}
	public static class RNumberDecContext extends NumberContext {
		public TerminalNode DEC() { return getToken(KtlynsParser.DEC, 0); }
		public RNumberDecContext(NumberContext ctx) { copyFrom(ctx); }
	}
	public static class RNumberIntContext extends NumberContext {
		public TerminalNode INT() { return getToken(KtlynsParser.INT, 0); }
		public RNumberIntContext(NumberContext ctx) { copyFrom(ctx); }
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_number);
		try {
			setState(124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new RNumberIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				match(INT);
				}
				break;
			case DEC:
				_localctx = new RNumberDecContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				match(DEC);
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
		enterRule(_localctx, 20, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
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
		public TerminalNode ID() { return getToken(KtlynsParser.ID, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(ID);
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_call_args, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
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
				setState(131);
				expr(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(139);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RCallArgsAddContext(new Call_argsContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_call_args);
					setState(134);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(135);
					match(COMMA);
					setState(136);
					expr(0);
					}
					} 
				}
				setState(141);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_mth_decl_arg, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
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
				setState(143);
				var_decl();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(151);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RMthDeclArgAddContext(new Mth_decl_argContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_mth_decl_arg);
					setState(146);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(147);
					match(COMMA);
					setState(148);
					var_decl();
					}
					} 
				}
				setState(153);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
		case 7:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 12:
			return call_args_sempred((Call_argsContext)_localctx, predIndex);
		case 13:
			return mth_decl_arg_sempred((Mth_decl_argContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean call_args_sempred(Call_argsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean mth_decl_arg_sempred(Mth_decl_argContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\u009d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\5\3\'\n\3\3\4\6\4*\n\4\r\4\16\4+\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\65"+
		"\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6?\n\6\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\b\3\b\5\bN\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tc\n\t\5\te\n\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\ts\n\t\f\t\16\tv\13\t\3\n\3"+
		"\n\3\n\5\n{\n\n\3\13\3\13\5\13\177\n\13\3\f\3\f\3\r\3\r\3\16\3\16\5\16"+
		"\u0087\n\16\3\16\3\16\3\16\7\16\u008c\n\16\f\16\16\16\u008f\13\16\3\17"+
		"\3\17\5\17\u0093\n\17\3\17\3\17\3\17\7\17\u0098\n\17\f\17\16\17\u009b"+
		"\13\17\3\17\2\5\20\32\34\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\2\2"+
		"\u00a5\2\36\3\2\2\2\4&\3\2\2\2\6)\3\2\2\2\b\64\3\2\2\2\n>\3\2\2\2\f@\3"+
		"\2\2\2\16M\3\2\2\2\20d\3\2\2\2\22z\3\2\2\2\24~\3\2\2\2\26\u0080\3\2\2"+
		"\2\30\u0082\3\2\2\2\32\u0086\3\2\2\2\34\u0092\3\2\2\2\36\37\5\6\4\2\37"+
		"\3\3\2\2\2 !\7\r\2\2!\"\5\6\4\2\"#\7\16\2\2#\'\3\2\2\2$%\7\r\2\2%\'\7"+
		"\16\2\2& \3\2\2\2&$\3\2\2\2\'\5\3\2\2\2(*\5\b\5\2)(\3\2\2\2*+\3\2\2\2"+
		"+)\3\2\2\2+,\3\2\2\2,\7\3\2\2\2-.\5\20\t\2./\7\23\2\2/\65\3\2\2\2\60\61"+
		"\5\n\6\2\61\62\7\23\2\2\62\65\3\2\2\2\63\65\5\f\7\2\64-\3\2\2\2\64\60"+
		"\3\2\2\2\64\63\3\2\2\2\65\t\3\2\2\2\66\67\5\30\r\2\678\5\30\r\28?\3\2"+
		"\2\29:\5\30\r\2:;\5\30\r\2;<\7\24\2\2<=\5\20\t\2=?\3\2\2\2>\66\3\2\2\2"+
		">9\3\2\2\2?\13\3\2\2\2@A\5\16\b\2AB\5\30\r\2BC\7\13\2\2CD\5\34\17\2DE"+
		"\7\f\2\2EF\5\4\3\2F\r\3\2\2\2GN\7\"\2\2HI\7\"\2\2IJ\7\17\2\2JK\5\30\r"+
		"\2KL\7\20\2\2LN\3\2\2\2MG\3\2\2\2MH\3\2\2\2N\17\3\2\2\2OP\b\t\1\2Pe\5"+
		"\26\f\2Qe\5\30\r\2RS\5\30\r\2ST\7\24\2\2TU\5\20\t\13Ue\3\2\2\2VW\5\30"+
		"\r\2WX\7\13\2\2XY\5\32\16\2YZ\7\f\2\2Ze\3\2\2\2[\\\7\13\2\2\\]\5\20\t"+
		"\2]^\7\f\2\2^e\3\2\2\2_e\5\22\n\2`b\7\30\2\2ac\5\20\t\2ba\3\2\2\2bc\3"+
		"\2\2\2ce\3\2\2\2dO\3\2\2\2dQ\3\2\2\2dR\3\2\2\2dV\3\2\2\2d[\3\2\2\2d_\3"+
		"\2\2\2d`\3\2\2\2et\3\2\2\2fg\f\7\2\2gh\7\t\2\2hs\5\20\t\bij\f\6\2\2jk"+
		"\7\b\2\2ks\5\20\t\7lm\f\5\2\2mn\7\6\2\2ns\5\20\t\6op\f\4\2\2pq\7\7\2\2"+
		"qs\5\20\t\5rf\3\2\2\2ri\3\2\2\2rl\3\2\2\2ro\3\2\2\2sv\3\2\2\2tr\3\2\2"+
		"\2tu\3\2\2\2u\21\3\2\2\2vt\3\2\2\2w{\5\24\13\2xy\7\7\2\2y{\5\24\13\2z"+
		"w\3\2\2\2zx\3\2\2\2{\23\3\2\2\2|\177\7\5\2\2}\177\7\4\2\2~|\3\2\2\2~}"+
		"\3\2\2\2\177\25\3\2\2\2\u0080\u0081\7\n\2\2\u0081\27\3\2\2\2\u0082\u0083"+
		"\7#\2\2\u0083\31\3\2\2\2\u0084\u0087\b\16\1\2\u0085\u0087\5\20\t\2\u0086"+
		"\u0084\3\2\2\2\u0086\u0085\3\2\2\2\u0087\u008d\3\2\2\2\u0088\u0089\f\3"+
		"\2\2\u0089\u008a\7\21\2\2\u008a\u008c\5\20\t\2\u008b\u0088\3\2\2\2\u008c"+
		"\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\33\3\2\2"+
		"\2\u008f\u008d\3\2\2\2\u0090\u0093\b\17\1\2\u0091\u0093\5\n\6\2\u0092"+
		"\u0090\3\2\2\2\u0092\u0091\3\2\2\2\u0093\u0099\3\2\2\2\u0094\u0095\f\3"+
		"\2\2\u0095\u0096\7\21\2\2\u0096\u0098\5\n\6\2\u0097\u0094\3\2\2\2\u0098"+
		"\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\35\3\2\2"+
		"\2\u009b\u0099\3\2\2\2\21&+\64>Mbdrtz~\u0086\u008d\u0092\u0099";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}