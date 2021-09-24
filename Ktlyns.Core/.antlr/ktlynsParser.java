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
		WS=1, DEC=2, INT=3, TRUE=4, FALSE=5, PLUS=6, MINUS=7, SLASH=8, STAR=9, 
		AMP=10, STR=11, LPRN=12, RPRN=13, LBRC=14, RBRC=15, LBKT=16, RBKT=17, 
		COMMA=18, DOT=19, SDOT=20, EQ=21, IF=22, ELSE=23, AT=24, RET=25, BREAK=26, 
		AND=27, OR=28, NOT=29, EQEQ=30, NEQEQ=31, GREAT=32, EQGREAT=33, LESS=34, 
		EQLESS=35, METHOD=36, EXTERNAL=37, ID=38, COMMENT=39, LINE_COMMENT=40;
	public static final int
		RULE_program = 0, RULE_block = 1, RULE_statements = 2, RULE_statement = 3, 
		RULE_if_else_decl = 4, RULE_loop_decl = 5, RULE_var_decl = 6, RULE_arr_decl = 7, 
		RULE_mth_decl = 8, RULE_ex_mth_decl = 9, RULE_mth = 10, RULE_expr = 11, 
		RULE_unary = 12, RULE_factor = 13, RULE_string = 14, RULE_id = 15, RULE_call_args = 16, 
		RULE_mth_decl_arg = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "block", "statements", "statement", "if_else_decl", "loop_decl", 
			"var_decl", "arr_decl", "mth_decl", "ex_mth_decl", "mth", "expr", "unary", 
			"factor", "string", "id", "call_args", "mth_decl_arg"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'true'", "'false'", "'+'", "'-'", "'/'", "'*'", 
			"'&'", null, "'('", "')'", "'{'", "'}'", "'['", "']'", "','", "'.'", 
			"';'", "'='", "'if'", "'else'", "'@'", "'ret'", "'break'", "'&&'", "'||'", 
			"'!'", "'=='", "'!='", "'>'", "'>='", "'<'", "'<='", "'method'", "'ext'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "DEC", "INT", "TRUE", "FALSE", "PLUS", "MINUS", "SLASH", 
			"STAR", "AMP", "STR", "LPRN", "RPRN", "LBRC", "RBRC", "LBKT", "RBKT", 
			"COMMA", "DOT", "SDOT", "EQ", "IF", "ELSE", "AT", "RET", "BREAK", "AND", 
			"OR", "NOT", "EQEQ", "NEQEQ", "GREAT", "EQGREAT", "LESS", "EQLESS", "METHOD", 
			"EXTERNAL", "ID", "COMMENT", "LINE_COMMENT"
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
			setState(36);
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
			setState(44);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new RBlockStmtsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				match(LBRC);
				setState(39);
				statements();
				setState(40);
				match(RBRC);
				}
				break;
			case 2:
				_localctx = new RBlockEmptyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				match(LBRC);
				setState(43);
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
			setState(47); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(46);
				statement();
				}
				}
				setState(49); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEC) | (1L << INT) | (1L << TRUE) | (1L << FALSE) | (1L << MINUS) | (1L << STAR) | (1L << AMP) | (1L << STR) | (1L << LPRN) | (1L << IF) | (1L << AT) | (1L << RET) | (1L << BREAK) | (1L << NOT) | (1L << METHOD) | (1L << EXTERNAL) | (1L << ID))) != 0) );
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
	public static class RStatementArrDeclContext extends StatementContext {
		public Arr_declContext arr_decl() {
			return getRuleContext(Arr_declContext.class,0);
		}
		public TerminalNode SDOT() { return getToken(KtlynsParser.SDOT, 0); }
		public RStatementArrDeclContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class RStatementLoopContext extends StatementContext {
		public Loop_declContext loop_decl() {
			return getRuleContext(Loop_declContext.class,0);
		}
		public RStatementLoopContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class RStatementIfElseContext extends StatementContext {
		public If_else_declContext if_else_decl() {
			return getRuleContext(If_else_declContext.class,0);
		}
		public RStatementIfElseContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class RStatementBreakContext extends StatementContext {
		public TerminalNode BREAK() { return getToken(KtlynsParser.BREAK, 0); }
		public TerminalNode SDOT() { return getToken(KtlynsParser.SDOT, 0); }
		public RStatementBreakContext(StatementContext ctx) { copyFrom(ctx); }
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
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new RStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				expr(0);
				setState(52);
				match(SDOT);
				}
				break;
			case 2:
				_localctx = new RStatementVarDeclContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				var_decl();
				setState(55);
				match(SDOT);
				}
				break;
			case 3:
				_localctx = new RStatementArrDeclContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(57);
				arr_decl();
				setState(58);
				match(SDOT);
				}
				break;
			case 4:
				_localctx = new RStatementIfElseContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(60);
				if_else_decl();
				}
				break;
			case 5:
				_localctx = new RStatementLoopContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(61);
				loop_decl();
				}
				break;
			case 6:
				_localctx = new RStatementBreakContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(62);
				match(BREAK);
				setState(63);
				match(SDOT);
				}
				break;
			case 7:
				_localctx = new RStatementMthDeclContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(64);
				mth_decl();
				}
				break;
			case 8:
				_localctx = new RStatementExMthDeclContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(65);
				ex_mth_decl();
				setState(66);
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
			setState(70);
			match(IF);
			setState(71);
			match(LPRN);
			setState(72);
			expr(0);
			setState(73);
			match(RPRN);
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRC:
				{
				setState(74);
				block();
				}
				break;
			case DEC:
			case INT:
			case TRUE:
			case FALSE:
			case MINUS:
			case STAR:
			case AMP:
			case STR:
			case LPRN:
			case IF:
			case AT:
			case RET:
			case BREAK:
			case NOT:
			case METHOD:
			case EXTERNAL:
			case ID:
				{
				setState(75);
				statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(78);
				match(ELSE);
				setState(81);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LBRC:
					{
					setState(79);
					block();
					}
					break;
				case DEC:
				case INT:
				case TRUE:
				case FALSE:
				case MINUS:
				case STAR:
				case AMP:
				case STR:
				case LPRN:
				case IF:
				case AT:
				case RET:
				case BREAK:
				case NOT:
				case METHOD:
				case EXTERNAL:
				case ID:
					{
					setState(80);
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

	public static class Loop_declContext extends ParserRuleContext {
		public KStmt Stmt;
		public Loop_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop_decl; }
	 
		public Loop_declContext() { }
		public void copyFrom(Loop_declContext ctx) {
			super.copyFrom(ctx);
			this.Stmt = ctx.Stmt;
		}
	}
	public static class RLoopTwoContext extends Loop_declContext {
		public TerminalNode AT() { return getToken(KtlynsParser.AT, 0); }
		public TerminalNode LPRN() { return getToken(KtlynsParser.LPRN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(KtlynsParser.COMMA, 0); }
		public TerminalNode RPRN() { return getToken(KtlynsParser.RPRN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public RLoopTwoContext(Loop_declContext ctx) { copyFrom(ctx); }
	}
	public static class RLoopOneContext extends Loop_declContext {
		public TerminalNode AT() { return getToken(KtlynsParser.AT, 0); }
		public TerminalNode LPRN() { return getToken(KtlynsParser.LPRN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPRN() { return getToken(KtlynsParser.RPRN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public RLoopOneContext(Loop_declContext ctx) { copyFrom(ctx); }
	}

	public final Loop_declContext loop_decl() throws RecognitionException {
		Loop_declContext _localctx = new Loop_declContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_loop_decl);
		try {
			setState(99);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new RLoopOneContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				match(AT);
				setState(86);
				match(LPRN);
				setState(87);
				expr(0);
				setState(88);
				match(RPRN);
				setState(89);
				block();
				}
				break;
			case 2:
				_localctx = new RLoopTwoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				match(AT);
				setState(92);
				match(LPRN);
				setState(93);
				expr(0);
				setState(94);
				match(COMMA);
				setState(95);
				expr(0);
				setState(96);
				match(RPRN);
				setState(97);
				block();
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
		enterRule(_localctx, 12, RULE_var_decl);
		try {
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new RVarDeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				id(0);
				setState(102);
				id(0);
				}
				break;
			case 2:
				_localctx = new RVarDeclExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				id(0);
				setState(105);
				id(0);
				setState(106);
				match(EQ);
				setState(107);
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

	public static class Arr_declContext extends ParserRuleContext {
		public KStmt Stmt;
		public Arr_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arr_decl; }
	 
		public Arr_declContext() { }
		public void copyFrom(Arr_declContext ctx) {
			super.copyFrom(ctx);
			this.Stmt = ctx.Stmt;
		}
	}
	public static class RArrDeclExprContext extends Arr_declContext {
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public TerminalNode EQ() { return getToken(KtlynsParser.EQ, 0); }
		public TerminalNode LBKT() { return getToken(KtlynsParser.LBKT, 0); }
		public TerminalNode INT() { return getToken(KtlynsParser.INT, 0); }
		public TerminalNode RBKT() { return getToken(KtlynsParser.RBKT, 0); }
		public TerminalNode LPRN() { return getToken(KtlynsParser.LPRN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPRN() { return getToken(KtlynsParser.RPRN, 0); }
		public RArrDeclExprContext(Arr_declContext ctx) { copyFrom(ctx); }
	}

	public final Arr_declContext arr_decl() throws RecognitionException {
		Arr_declContext _localctx = new Arr_declContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_arr_decl);
		try {
			_localctx = new RArrDeclExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			id(0);
			setState(112);
			id(0);
			setState(113);
			match(EQ);
			setState(114);
			match(LBKT);
			setState(115);
			match(INT);
			setState(116);
			match(RBKT);
			setState(117);
			match(LPRN);
			setState(118);
			expr(0);
			setState(119);
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
		enterRule(_localctx, 16, RULE_mth_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			mth();
			setState(122);
			id(0);
			setState(123);
			match(LPRN);
			setState(124);
			mth_decl_arg(0);
			setState(125);
			match(RPRN);
			setState(126);
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
		enterRule(_localctx, 18, RULE_ex_mth_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(EXTERNAL);
			setState(129);
			mth();
			setState(130);
			id(0);
			setState(131);
			match(LPRN);
			setState(132);
			mth_decl_arg(0);
			setState(133);
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
		enterRule(_localctx, 20, RULE_mth);
		try {
			setState(141);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new RMthVoidContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				match(METHOD);
				}
				break;
			case 2:
				_localctx = new RMthTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				match(METHOD);
				setState(137);
				match(LESS);
				setState(138);
				id(0);
				setState(139);
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
	public static class RExprBinAndContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(KtlynsParser.AND, 0); }
		public RExprBinAndContext(ExprContext ctx) { copyFrom(ctx); }
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
	public static class RExprBinOrContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(KtlynsParser.OR, 0); }
		public RExprBinOrContext(ExprContext ctx) { copyFrom(ctx); }
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				_localctx = new RExprStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(144);
				string();
				}
				break;
			case 2:
				{
				_localctx = new RExprIdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(145);
				id(0);
				}
				break;
			case 3:
				{
				_localctx = new RExprCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(146);
				id(0);
				setState(147);
				match(LPRN);
				setState(148);
				call_args(0);
				setState(149);
				match(RPRN);
				}
				break;
			case 4:
				{
				_localctx = new RExprGroupContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(151);
				match(LPRN);
				setState(152);
				expr(0);
				setState(153);
				match(RPRN);
				}
				break;
			case 5:
				{
				_localctx = new RExprUnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(155);
				unary();
				}
				break;
			case 6:
				{
				_localctx = new RExprAssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(156);
				id(0);
				setState(157);
				match(EQ);
				setState(158);
				expr(2);
				}
				break;
			case 7:
				{
				_localctx = new RExprReturnContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(160);
				match(RET);
				setState(162);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(161);
					expr(0);
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(204);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(202);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new RExprBinMultContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(166);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(167);
						match(STAR);
						setState(168);
						expr(15);
						}
						break;
					case 2:
						{
						_localctx = new RExprBinDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(169);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(170);
						match(SLASH);
						setState(171);
						expr(14);
						}
						break;
					case 3:
						{
						_localctx = new RExprBinAddContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(172);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(173);
						match(PLUS);
						setState(174);
						expr(13);
						}
						break;
					case 4:
						{
						_localctx = new RExprBinSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(175);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(176);
						match(MINUS);
						setState(177);
						expr(12);
						}
						break;
					case 5:
						{
						_localctx = new RExprBinEqContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(178);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(179);
						match(EQEQ);
						setState(180);
						expr(11);
						}
						break;
					case 6:
						{
						_localctx = new RExprBinNEqContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(181);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(182);
						match(NEQEQ);
						setState(183);
						expr(10);
						}
						break;
					case 7:
						{
						_localctx = new RExprBinGreatContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(184);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(185);
						match(GREAT);
						setState(186);
						expr(9);
						}
						break;
					case 8:
						{
						_localctx = new RExprBinEGreatContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(187);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(188);
						match(EQGREAT);
						setState(189);
						expr(8);
						}
						break;
					case 9:
						{
						_localctx = new RExprBinLessContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(190);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(191);
						match(LESS);
						setState(192);
						expr(7);
						}
						break;
					case 10:
						{
						_localctx = new RExprBinELessContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(193);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(194);
						match(EQLESS);
						setState(195);
						expr(6);
						}
						break;
					case 11:
						{
						_localctx = new RExprBinAndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(196);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(197);
						match(AND);
						setState(198);
						expr(5);
						}
						break;
					case 12:
						{
						_localctx = new RExprBinOrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(199);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(200);
						match(OR);
						setState(201);
						expr(4);
						}
						break;
					}
					} 
				}
				setState(206);
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
		enterRule(_localctx, 24, RULE_unary);
		try {
			setState(212);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DEC:
			case INT:
			case TRUE:
			case FALSE:
				_localctx = new RUnaryFactorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(207);
				factor();
				}
				break;
			case MINUS:
				_localctx = new RUnaryMinusContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(208);
				match(MINUS);
				setState(209);
				factor();
				}
				break;
			case NOT:
				_localctx = new RUnaryNotContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(210);
				match(NOT);
				setState(211);
				factor();
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
		enterRule(_localctx, 26, RULE_factor);
		try {
			setState(218);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new RFactorIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(214);
				match(INT);
				}
				break;
			case DEC:
				_localctx = new RFactorDecContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(215);
				match(DEC);
				}
				break;
			case TRUE:
				_localctx = new RFactorTrueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(216);
				match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new RFactorFalseContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(217);
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
		enterRule(_localctx, 28, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
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
	public static class RIDPointerContext extends IdContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public List<TerminalNode> STAR() { return getTokens(KtlynsParser.STAR); }
		public TerminalNode STAR(int i) {
			return getToken(KtlynsParser.STAR, i);
		}
		public RIDPointerContext(IdContext ctx) { copyFrom(ctx); }
	}
	public static class RIDArrayContext extends IdContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode LBKT() { return getToken(KtlynsParser.LBKT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBKT() { return getToken(KtlynsParser.RBKT, 0); }
		public RIDArrayContext(IdContext ctx) { copyFrom(ctx); }
	}
	public static class RIDSimpleContext extends IdContext {
		public TerminalNode ID() { return getToken(KtlynsParser.ID, 0); }
		public RIDSimpleContext(IdContext ctx) { copyFrom(ctx); }
	}
	public static class RIDAddressContext extends IdContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public List<TerminalNode> AMP() { return getTokens(KtlynsParser.AMP); }
		public TerminalNode AMP(int i) {
			return getToken(KtlynsParser.AMP, i);
		}
		public RIDAddressContext(IdContext ctx) { copyFrom(ctx); }
	}

	public final IdContext id() throws RecognitionException {
		return id(0);
	}

	private IdContext id(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		IdContext _localctx = new IdContext(_ctx, _parentState);
		IdContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_id, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				_localctx = new RIDSimpleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(223);
				match(ID);
				}
				break;
			case AMP:
				{
				_localctx = new RIDAddressContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(225); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(224);
						match(AMP);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(227); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(229);
				id(2);
				}
				break;
			case STAR:
				{
				_localctx = new RIDPointerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(231); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(230);
						match(STAR);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(233); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(235);
				id(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(245);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RIDArrayContext(new IdContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_id);
					setState(238);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(239);
					match(LBKT);
					setState(240);
					expr(0);
					setState(241);
					match(RBKT);
					}
					} 
				}
				setState(247);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_call_args, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
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
				setState(249);
				expr(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(257);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RCallArgsAddContext(new Call_argsContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_call_args);
					setState(252);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(253);
					match(COMMA);
					setState(254);
					expr(0);
					}
					} 
				}
				setState(259);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_mth_decl_arg, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
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
				setState(261);
				var_decl();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(269);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RMthDeclArgAddContext(new Mth_decl_argContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_mth_decl_arg);
					setState(264);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(265);
					match(COMMA);
					setState(266);
					var_decl();
					}
					} 
				}
				setState(271);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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
		case 11:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 15:
			return id_sempred((IdContext)_localctx, predIndex);
		case 16:
			return call_args_sempred((Call_argsContext)_localctx, predIndex);
		case 17:
			return mth_decl_arg_sempred((Mth_decl_argContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 14);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 7);
		case 8:
			return precpred(_ctx, 6);
		case 9:
			return precpred(_ctx, 5);
		case 10:
			return precpred(_ctx, 4);
		case 11:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean id_sempred(IdContext _localctx, int predIndex) {
		switch (predIndex) {
		case 12:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean call_args_sempred(Call_argsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 13:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean mth_decl_arg_sempred(Mth_decl_argContext _localctx, int predIndex) {
		switch (predIndex) {
		case 14:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u0113\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3/\n\3\3\4\6\4\62\n\4\r\4"+
		"\16\4\63\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\5\5G\n\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6O\n\6\3\6\3\6\3\6\5\6T\n\6"+
		"\5\6V\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7"+
		"f\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bp\n\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0090\n\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00a5\n\r\5"+
		"\r\u00a7\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\7\r\u00cd\n\r\f\r\16\r\u00d0\13\r\3\16\3\16\3\16\3\16"+
		"\3\16\5\16\u00d7\n\16\3\17\3\17\3\17\3\17\5\17\u00dd\n\17\3\20\3\20\3"+
		"\21\3\21\3\21\6\21\u00e4\n\21\r\21\16\21\u00e5\3\21\3\21\6\21\u00ea\n"+
		"\21\r\21\16\21\u00eb\3\21\5\21\u00ef\n\21\3\21\3\21\3\21\3\21\3\21\7\21"+
		"\u00f6\n\21\f\21\16\21\u00f9\13\21\3\22\3\22\5\22\u00fd\n\22\3\22\3\22"+
		"\3\22\7\22\u0102\n\22\f\22\16\22\u0105\13\22\3\23\3\23\5\23\u0109\n\23"+
		"\3\23\3\23\3\23\7\23\u010e\n\23\f\23\16\23\u0111\13\23\3\23\2\6\30 \""+
		"$\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\2\2\u0130\2&\3\2\2\2"+
		"\4.\3\2\2\2\6\61\3\2\2\2\bF\3\2\2\2\nH\3\2\2\2\fe\3\2\2\2\16o\3\2\2\2"+
		"\20q\3\2\2\2\22{\3\2\2\2\24\u0082\3\2\2\2\26\u008f\3\2\2\2\30\u00a6\3"+
		"\2\2\2\32\u00d6\3\2\2\2\34\u00dc\3\2\2\2\36\u00de\3\2\2\2 \u00ee\3\2\2"+
		"\2\"\u00fc\3\2\2\2$\u0108\3\2\2\2&\'\5\6\4\2\'\3\3\2\2\2()\7\20\2\2)*"+
		"\5\6\4\2*+\7\21\2\2+/\3\2\2\2,-\7\20\2\2-/\7\21\2\2.(\3\2\2\2.,\3\2\2"+
		"\2/\5\3\2\2\2\60\62\5\b\5\2\61\60\3\2\2\2\62\63\3\2\2\2\63\61\3\2\2\2"+
		"\63\64\3\2\2\2\64\7\3\2\2\2\65\66\5\30\r\2\66\67\7\26\2\2\67G\3\2\2\2"+
		"89\5\16\b\29:\7\26\2\2:G\3\2\2\2;<\5\20\t\2<=\7\26\2\2=G\3\2\2\2>G\5\n"+
		"\6\2?G\5\f\7\2@A\7\34\2\2AG\7\26\2\2BG\5\22\n\2CD\5\24\13\2DE\7\26\2\2"+
		"EG\3\2\2\2F\65\3\2\2\2F8\3\2\2\2F;\3\2\2\2F>\3\2\2\2F?\3\2\2\2F@\3\2\2"+
		"\2FB\3\2\2\2FC\3\2\2\2G\t\3\2\2\2HI\7\30\2\2IJ\7\16\2\2JK\5\30\r\2KN\7"+
		"\17\2\2LO\5\4\3\2MO\5\b\5\2NL\3\2\2\2NM\3\2\2\2OU\3\2\2\2PS\7\31\2\2Q"+
		"T\5\4\3\2RT\5\b\5\2SQ\3\2\2\2SR\3\2\2\2TV\3\2\2\2UP\3\2\2\2UV\3\2\2\2"+
		"V\13\3\2\2\2WX\7\32\2\2XY\7\16\2\2YZ\5\30\r\2Z[\7\17\2\2[\\\5\4\3\2\\"+
		"f\3\2\2\2]^\7\32\2\2^_\7\16\2\2_`\5\30\r\2`a\7\24\2\2ab\5\30\r\2bc\7\17"+
		"\2\2cd\5\4\3\2df\3\2\2\2eW\3\2\2\2e]\3\2\2\2f\r\3\2\2\2gh\5 \21\2hi\5"+
		" \21\2ip\3\2\2\2jk\5 \21\2kl\5 \21\2lm\7\27\2\2mn\5\30\r\2np\3\2\2\2o"+
		"g\3\2\2\2oj\3\2\2\2p\17\3\2\2\2qr\5 \21\2rs\5 \21\2st\7\27\2\2tu\7\22"+
		"\2\2uv\7\5\2\2vw\7\23\2\2wx\7\16\2\2xy\5\30\r\2yz\7\17\2\2z\21\3\2\2\2"+
		"{|\5\26\f\2|}\5 \21\2}~\7\16\2\2~\177\5$\23\2\177\u0080\7\17\2\2\u0080"+
		"\u0081\5\4\3\2\u0081\23\3\2\2\2\u0082\u0083\7\'\2\2\u0083\u0084\5\26\f"+
		"\2\u0084\u0085\5 \21\2\u0085\u0086\7\16\2\2\u0086\u0087\5$\23\2\u0087"+
		"\u0088\7\17\2\2\u0088\25\3\2\2\2\u0089\u0090\7&\2\2\u008a\u008b\7&\2\2"+
		"\u008b\u008c\7$\2\2\u008c\u008d\5 \21\2\u008d\u008e\7\"\2\2\u008e\u0090"+
		"\3\2\2\2\u008f\u0089\3\2\2\2\u008f\u008a\3\2\2\2\u0090\27\3\2\2\2\u0091"+
		"\u0092\b\r\1\2\u0092\u00a7\5\36\20\2\u0093\u00a7\5 \21\2\u0094\u0095\5"+
		" \21\2\u0095\u0096\7\16\2\2\u0096\u0097\5\"\22\2\u0097\u0098\7\17\2\2"+
		"\u0098\u00a7\3\2\2\2\u0099\u009a\7\16\2\2\u009a\u009b\5\30\r\2\u009b\u009c"+
		"\7\17\2\2\u009c\u00a7\3\2\2\2\u009d\u00a7\5\32\16\2\u009e\u009f\5 \21"+
		"\2\u009f\u00a0\7\27\2\2\u00a0\u00a1\5\30\r\4\u00a1\u00a7\3\2\2\2\u00a2"+
		"\u00a4\7\33\2\2\u00a3\u00a5\5\30\r\2\u00a4\u00a3\3\2\2\2\u00a4\u00a5\3"+
		"\2\2\2\u00a5\u00a7\3\2\2\2\u00a6\u0091\3\2\2\2\u00a6\u0093\3\2\2\2\u00a6"+
		"\u0094\3\2\2\2\u00a6\u0099\3\2\2\2\u00a6\u009d\3\2\2\2\u00a6\u009e\3\2"+
		"\2\2\u00a6\u00a2\3\2\2\2\u00a7\u00ce\3\2\2\2\u00a8\u00a9\f\20\2\2\u00a9"+
		"\u00aa\7\13\2\2\u00aa\u00cd\5\30\r\21\u00ab\u00ac\f\17\2\2\u00ac\u00ad"+
		"\7\n\2\2\u00ad\u00cd\5\30\r\20\u00ae\u00af\f\16\2\2\u00af\u00b0\7\b\2"+
		"\2\u00b0\u00cd\5\30\r\17\u00b1\u00b2\f\r\2\2\u00b2\u00b3\7\t\2\2\u00b3"+
		"\u00cd\5\30\r\16\u00b4\u00b5\f\f\2\2\u00b5\u00b6\7 \2\2\u00b6\u00cd\5"+
		"\30\r\r\u00b7\u00b8\f\13\2\2\u00b8\u00b9\7!\2\2\u00b9\u00cd\5\30\r\f\u00ba"+
		"\u00bb\f\n\2\2\u00bb\u00bc\7\"\2\2\u00bc\u00cd\5\30\r\13\u00bd\u00be\f"+
		"\t\2\2\u00be\u00bf\7#\2\2\u00bf\u00cd\5\30\r\n\u00c0\u00c1\f\b\2\2\u00c1"+
		"\u00c2\7$\2\2\u00c2\u00cd\5\30\r\t\u00c3\u00c4\f\7\2\2\u00c4\u00c5\7%"+
		"\2\2\u00c5\u00cd\5\30\r\b\u00c6\u00c7\f\6\2\2\u00c7\u00c8\7\35\2\2\u00c8"+
		"\u00cd\5\30\r\7\u00c9\u00ca\f\5\2\2\u00ca\u00cb\7\36\2\2\u00cb\u00cd\5"+
		"\30\r\6\u00cc\u00a8\3\2\2\2\u00cc\u00ab\3\2\2\2\u00cc\u00ae\3\2\2\2\u00cc"+
		"\u00b1\3\2\2\2\u00cc\u00b4\3\2\2\2\u00cc\u00b7\3\2\2\2\u00cc\u00ba\3\2"+
		"\2\2\u00cc\u00bd\3\2\2\2\u00cc\u00c0\3\2\2\2\u00cc\u00c3\3\2\2\2\u00cc"+
		"\u00c6\3\2\2\2\u00cc\u00c9\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2"+
		"\2\2\u00ce\u00cf\3\2\2\2\u00cf\31\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d7"+
		"\5\34\17\2\u00d2\u00d3\7\t\2\2\u00d3\u00d7\5\34\17\2\u00d4\u00d5\7\37"+
		"\2\2\u00d5\u00d7\5\34\17\2\u00d6\u00d1\3\2\2\2\u00d6\u00d2\3\2\2\2\u00d6"+
		"\u00d4\3\2\2\2\u00d7\33\3\2\2\2\u00d8\u00dd\7\5\2\2\u00d9\u00dd\7\4\2"+
		"\2\u00da\u00dd\7\6\2\2\u00db\u00dd\7\7\2\2\u00dc\u00d8\3\2\2\2\u00dc\u00d9"+
		"\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00db\3\2\2\2\u00dd\35\3\2\2\2\u00de"+
		"\u00df\7\r\2\2\u00df\37\3\2\2\2\u00e0\u00e1\b\21\1\2\u00e1\u00ef\7(\2"+
		"\2\u00e2\u00e4\7\f\2\2\u00e3\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e3"+
		"\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00ef\5 \21\4\u00e8"+
		"\u00ea\7\13\2\2\u00e9\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00e9\3"+
		"\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ef\5 \21\3\u00ee"+
		"\u00e0\3\2\2\2\u00ee\u00e3\3\2\2\2\u00ee\u00e9\3\2\2\2\u00ef\u00f7\3\2"+
		"\2\2\u00f0\u00f1\f\5\2\2\u00f1\u00f2\7\22\2\2\u00f2\u00f3\5\30\r\2\u00f3"+
		"\u00f4\7\23\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00f0\3\2\2\2\u00f6\u00f9\3"+
		"\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8!\3\2\2\2\u00f9\u00f7"+
		"\3\2\2\2\u00fa\u00fd\b\22\1\2\u00fb\u00fd\5\30\r\2\u00fc\u00fa\3\2\2\2"+
		"\u00fc\u00fb\3\2\2\2\u00fd\u0103\3\2\2\2\u00fe\u00ff\f\3\2\2\u00ff\u0100"+
		"\7\24\2\2\u0100\u0102\5\30\r\2\u0101\u00fe\3\2\2\2\u0102\u0105\3\2\2\2"+
		"\u0103\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104#\3\2\2\2\u0105\u0103\3"+
		"\2\2\2\u0106\u0109\b\23\1\2\u0107\u0109\5\16\b\2\u0108\u0106\3\2\2\2\u0108"+
		"\u0107\3\2\2\2\u0109\u010f\3\2\2\2\u010a\u010b\f\3\2\2\u010b\u010c\7\24"+
		"\2\2\u010c\u010e\5\16\b\2\u010d\u010a\3\2\2\2\u010e\u0111\3\2\2\2\u010f"+
		"\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110%\3\2\2\2\u0111\u010f\3\2\2\2"+
		"\31.\63FNSUeo\u008f\u00a4\u00a6\u00cc\u00ce\u00d6\u00dc\u00e5\u00eb\u00ee"+
		"\u00f7\u00fc\u0103\u0108\u010f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}