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
		RULE_if_else_decl = 4, RULE_loop_decl = 5, RULE_var_decl = 6, RULE_mth_decl = 7, 
		RULE_ex_mth_decl = 8, RULE_mth = 9, RULE_expr = 10, RULE_unary = 11, RULE_factor = 12, 
		RULE_string = 13, RULE_id = 14, RULE_call_args = 15, RULE_mth_decl_arg = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "block", "statements", "statement", "if_else_decl", "loop_decl", 
			"var_decl", "mth_decl", "ex_mth_decl", "mth", "expr", "unary", "factor", 
			"string", "id", "call_args", "mth_decl_arg"
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
			setState(34);
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
			setState(42);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new RBlockStmtsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				match(LBRC);
				setState(37);
				statements();
				setState(38);
				match(RBRC);
				}
				break;
			case 2:
				_localctx = new RBlockEmptyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				match(LBRC);
				setState(41);
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
			setState(45); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(44);
				statement();
				}
				}
				setState(47); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DEC) | (1L << INT) | (1L << TRUE) | (1L << FALSE) | (1L << MINUS) | (1L << AMP) | (1L << STR) | (1L << LPRN) | (1L << IF) | (1L << AT) | (1L << RET) | (1L << NOT) | (1L << METHOD) | (1L << EXTERNAL) | (1L << ID))) != 0) );
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
			setState(61);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new RStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				expr(0);
				setState(50);
				match(SDOT);
				}
				break;
			case 2:
				_localctx = new RStatementVarDeclContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				var_decl();
				setState(53);
				match(SDOT);
				}
				break;
			case 3:
				_localctx = new RStatementIfElseContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(55);
				if_else_decl();
				}
				break;
			case 4:
				_localctx = new RStatementLoopContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(56);
				loop_decl();
				}
				break;
			case 5:
				_localctx = new RStatementMthDeclContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(57);
				mth_decl();
				}
				break;
			case 6:
				_localctx = new RStatementExMthDeclContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(58);
				ex_mth_decl();
				setState(59);
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
			setState(63);
			match(IF);
			setState(64);
			match(LPRN);
			setState(65);
			expr(0);
			setState(66);
			match(RPRN);
			setState(69);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRC:
				{
				setState(67);
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
			case AT:
			case RET:
			case NOT:
			case METHOD:
			case EXTERNAL:
			case ID:
				{
				setState(68);
				statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(71);
				match(ELSE);
				setState(74);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LBRC:
					{
					setState(72);
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
				case AT:
				case RET:
				case NOT:
				case METHOD:
				case EXTERNAL:
				case ID:
					{
					setState(73);
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
			setState(92);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new RLoopOneContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				match(AT);
				setState(79);
				match(LPRN);
				setState(80);
				expr(0);
				setState(81);
				match(RPRN);
				setState(82);
				block();
				}
				break;
			case 2:
				_localctx = new RLoopTwoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				match(AT);
				setState(85);
				match(LPRN);
				setState(86);
				expr(0);
				setState(87);
				match(COMMA);
				setState(88);
				expr(0);
				setState(89);
				match(RPRN);
				setState(90);
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
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new RVarDeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				id(0);
				setState(95);
				id(0);
				}
				break;
			case 2:
				_localctx = new RVarDeclExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				id(0);
				setState(98);
				id(0);
				setState(99);
				match(EQ);
				setState(100);
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
		enterRule(_localctx, 14, RULE_mth_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			mth();
			setState(105);
			id(0);
			setState(106);
			match(LPRN);
			setState(107);
			mth_decl_arg(0);
			setState(108);
			match(RPRN);
			setState(109);
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
		enterRule(_localctx, 16, RULE_ex_mth_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(EXTERNAL);
			setState(112);
			mth();
			setState(113);
			id(0);
			setState(114);
			match(LPRN);
			setState(115);
			mth_decl_arg(0);
			setState(116);
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
		enterRule(_localctx, 18, RULE_mth);
		try {
			setState(124);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new RMthVoidContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				match(METHOD);
				}
				break;
			case 2:
				_localctx = new RMthTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
				match(METHOD);
				setState(120);
				match(LESS);
				setState(121);
				id(0);
				setState(122);
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				_localctx = new RExprStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(127);
				string();
				}
				break;
			case 2:
				{
				_localctx = new RExprIdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(128);
				id(0);
				}
				break;
			case 3:
				{
				_localctx = new RExprCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(129);
				id(0);
				setState(130);
				match(LPRN);
				setState(131);
				call_args(0);
				setState(132);
				match(RPRN);
				}
				break;
			case 4:
				{
				_localctx = new RExprGroupContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(134);
				match(LPRN);
				setState(135);
				expr(0);
				setState(136);
				match(RPRN);
				}
				break;
			case 5:
				{
				_localctx = new RExprUnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(138);
				unary();
				}
				break;
			case 6:
				{
				_localctx = new RExprAssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(139);
				id(0);
				setState(140);
				match(EQ);
				setState(141);
				expr(2);
				}
				break;
			case 7:
				{
				_localctx = new RExprReturnContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(143);
				match(RET);
				setState(145);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(144);
					expr(0);
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(187);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(185);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new RExprBinMultContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(149);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(150);
						match(STAR);
						setState(151);
						expr(15);
						}
						break;
					case 2:
						{
						_localctx = new RExprBinDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(152);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(153);
						match(SLASH);
						setState(154);
						expr(14);
						}
						break;
					case 3:
						{
						_localctx = new RExprBinAddContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(155);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(156);
						match(PLUS);
						setState(157);
						expr(13);
						}
						break;
					case 4:
						{
						_localctx = new RExprBinSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(158);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(159);
						match(MINUS);
						setState(160);
						expr(12);
						}
						break;
					case 5:
						{
						_localctx = new RExprBinEqContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(161);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(162);
						match(EQEQ);
						setState(163);
						expr(11);
						}
						break;
					case 6:
						{
						_localctx = new RExprBinNEqContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(164);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(165);
						match(NEQEQ);
						setState(166);
						expr(10);
						}
						break;
					case 7:
						{
						_localctx = new RExprBinGreatContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(167);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(168);
						match(GREAT);
						setState(169);
						expr(9);
						}
						break;
					case 8:
						{
						_localctx = new RExprBinEGreatContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(170);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(171);
						match(EQGREAT);
						setState(172);
						expr(8);
						}
						break;
					case 9:
						{
						_localctx = new RExprBinLessContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(173);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(174);
						match(LESS);
						setState(175);
						expr(7);
						}
						break;
					case 10:
						{
						_localctx = new RExprBinELessContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(176);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(177);
						match(EQLESS);
						setState(178);
						expr(6);
						}
						break;
					case 11:
						{
						_localctx = new RExprBinAndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(179);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(180);
						match(AND);
						setState(181);
						expr(5);
						}
						break;
					case 12:
						{
						_localctx = new RExprBinOrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(182);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(183);
						match(OR);
						setState(184);
						expr(4);
						}
						break;
					}
					} 
				}
				setState(189);
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
		enterRule(_localctx, 22, RULE_unary);
		try {
			setState(197);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DEC:
			case INT:
			case TRUE:
			case FALSE:
				_localctx = new RUnaryFactorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				factor();
				}
				break;
			case MINUS:
				_localctx = new RUnaryMinusContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
				match(MINUS);
				setState(192);
				factor();
				}
				break;
			case NOT:
				_localctx = new RUnaryNotContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(193);
				match(NOT);
				setState(194);
				factor();
				}
				break;
			case AMP:
				_localctx = new RUnaryAddressContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(195);
				match(AMP);
				setState(196);
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
		enterRule(_localctx, 24, RULE_factor);
		try {
			setState(203);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new RFactorIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(199);
				match(INT);
				}
				break;
			case DEC:
				_localctx = new RFactorDecContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(200);
				match(DEC);
				}
				break;
			case TRUE:
				_localctx = new RFactorTrueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(201);
				match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new RFactorFalseContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(202);
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
		enterRule(_localctx, 26, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_id, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new RIDSimpleContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(208);
			match(ID);
			}
			_ctx.stop = _input.LT(-1);
			setState(218);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RIDArrayContext(new IdContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_id);
					setState(210);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(211);
					match(T__0);
					setState(213);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==INT) {
						{
						setState(212);
						match(INT);
						}
					}

					setState(215);
					match(T__1);
					}
					} 
				}
				setState(220);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_call_args, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
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
				setState(222);
				expr(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(230);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RCallArgsAddContext(new Call_argsContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_call_args);
					setState(225);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(226);
					match(COMMA);
					setState(227);
					expr(0);
					}
					} 
				}
				setState(232);
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
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_mth_decl_arg, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
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
				setState(234);
				var_decl();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(242);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RMthDeclArgAddContext(new Mth_decl_argContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_mth_decl_arg);
					setState(237);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(238);
					match(COMMA);
					setState(239);
					var_decl();
					}
					} 
				}
				setState(244);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 14:
			return id_sempred((IdContext)_localctx, predIndex);
		case 15:
			return call_args_sempred((Call_argsContext)_localctx, predIndex);
		case 16:
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
			return precpred(_ctx, 2);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u00f8\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3-\n\3\3\4\6\4\60\n\4\r\4\16\4\61\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5@\n\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\5\6H\n\6\3\6\3\6\3\6\5\6M\n\6\5\6O\n\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7_\n\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\5\bi\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\3\13\5\13\177\n\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0094\n\f\5"+
		"\f\u0096\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\7\f\u00bc\n\f\f\f\16\f\u00bf\13\f\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\5\r\u00c8\n\r\3\16\3\16\3\16\3\16\5\16\u00ce\n\16\3\17\3\17\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\5\20\u00d8\n\20\3\20\7\20\u00db\n\20\f\20"+
		"\16\20\u00de\13\20\3\21\3\21\5\21\u00e2\n\21\3\21\3\21\3\21\7\21\u00e7"+
		"\n\21\f\21\16\21\u00ea\13\21\3\22\3\22\5\22\u00ee\n\22\3\22\3\22\3\22"+
		"\7\22\u00f3\n\22\f\22\16\22\u00f6\13\22\3\22\2\6\26\36 \"\23\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"\2\2\2\u0112\2$\3\2\2\2\4,\3\2\2\2\6/"+
		"\3\2\2\2\b?\3\2\2\2\nA\3\2\2\2\f^\3\2\2\2\16h\3\2\2\2\20j\3\2\2\2\22q"+
		"\3\2\2\2\24~\3\2\2\2\26\u0095\3\2\2\2\30\u00c7\3\2\2\2\32\u00cd\3\2\2"+
		"\2\34\u00cf\3\2\2\2\36\u00d1\3\2\2\2 \u00e1\3\2\2\2\"\u00ed\3\2\2\2$%"+
		"\5\6\4\2%\3\3\2\2\2&\'\7\22\2\2\'(\5\6\4\2()\7\23\2\2)-\3\2\2\2*+\7\22"+
		"\2\2+-\7\23\2\2,&\3\2\2\2,*\3\2\2\2-\5\3\2\2\2.\60\5\b\5\2/.\3\2\2\2\60"+
		"\61\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\7\3\2\2\2\63\64\5\26\f\2\64\65"+
		"\7\26\2\2\65@\3\2\2\2\66\67\5\16\b\2\678\7\26\2\28@\3\2\2\29@\5\n\6\2"+
		":@\5\f\7\2;@\5\20\t\2<=\5\22\n\2=>\7\26\2\2>@\3\2\2\2?\63\3\2\2\2?\66"+
		"\3\2\2\2?9\3\2\2\2?:\3\2\2\2?;\3\2\2\2?<\3\2\2\2@\t\3\2\2\2AB\7\30\2\2"+
		"BC\7\20\2\2CD\5\26\f\2DG\7\21\2\2EH\5\4\3\2FH\5\b\5\2GE\3\2\2\2GF\3\2"+
		"\2\2HN\3\2\2\2IL\7\31\2\2JM\5\4\3\2KM\5\b\5\2LJ\3\2\2\2LK\3\2\2\2MO\3"+
		"\2\2\2NI\3\2\2\2NO\3\2\2\2O\13\3\2\2\2PQ\7\32\2\2QR\7\20\2\2RS\5\26\f"+
		"\2ST\7\21\2\2TU\5\4\3\2U_\3\2\2\2VW\7\32\2\2WX\7\20\2\2XY\5\26\f\2YZ\7"+
		"\24\2\2Z[\5\26\f\2[\\\7\21\2\2\\]\5\4\3\2]_\3\2\2\2^P\3\2\2\2^V\3\2\2"+
		"\2_\r\3\2\2\2`a\5\36\20\2ab\5\36\20\2bi\3\2\2\2cd\5\36\20\2de\5\36\20"+
		"\2ef\7\27\2\2fg\5\26\f\2gi\3\2\2\2h`\3\2\2\2hc\3\2\2\2i\17\3\2\2\2jk\5"+
		"\24\13\2kl\5\36\20\2lm\7\20\2\2mn\5\"\22\2no\7\21\2\2op\5\4\3\2p\21\3"+
		"\2\2\2qr\7&\2\2rs\5\24\13\2st\5\36\20\2tu\7\20\2\2uv\5\"\22\2vw\7\21\2"+
		"\2w\23\3\2\2\2x\177\7%\2\2yz\7%\2\2z{\7#\2\2{|\5\36\20\2|}\7!\2\2}\177"+
		"\3\2\2\2~x\3\2\2\2~y\3\2\2\2\177\25\3\2\2\2\u0080\u0081\b\f\1\2\u0081"+
		"\u0096\5\34\17\2\u0082\u0096\5\36\20\2\u0083\u0084\5\36\20\2\u0084\u0085"+
		"\7\20\2\2\u0085\u0086\5 \21\2\u0086\u0087\7\21\2\2\u0087\u0096\3\2\2\2"+
		"\u0088\u0089\7\20\2\2\u0089\u008a\5\26\f\2\u008a\u008b\7\21\2\2\u008b"+
		"\u0096\3\2\2\2\u008c\u0096\5\30\r\2\u008d\u008e\5\36\20\2\u008e\u008f"+
		"\7\27\2\2\u008f\u0090\5\26\f\4\u0090\u0096\3\2\2\2\u0091\u0093\7\33\2"+
		"\2\u0092\u0094\5\26\f\2\u0093\u0092\3\2\2\2\u0093\u0094\3\2\2\2\u0094"+
		"\u0096\3\2\2\2\u0095\u0080\3\2\2\2\u0095\u0082\3\2\2\2\u0095\u0083\3\2"+
		"\2\2\u0095\u0088\3\2\2\2\u0095\u008c\3\2\2\2\u0095\u008d\3\2\2\2\u0095"+
		"\u0091\3\2\2\2\u0096\u00bd\3\2\2\2\u0097\u0098\f\20\2\2\u0098\u0099\7"+
		"\r\2\2\u0099\u00bc\5\26\f\21\u009a\u009b\f\17\2\2\u009b\u009c\7\f\2\2"+
		"\u009c\u00bc\5\26\f\20\u009d\u009e\f\16\2\2\u009e\u009f\7\n\2\2\u009f"+
		"\u00bc\5\26\f\17\u00a0\u00a1\f\r\2\2\u00a1\u00a2\7\13\2\2\u00a2\u00bc"+
		"\5\26\f\16\u00a3\u00a4\f\f\2\2\u00a4\u00a5\7\37\2\2\u00a5\u00bc\5\26\f"+
		"\r\u00a6\u00a7\f\13\2\2\u00a7\u00a8\7 \2\2\u00a8\u00bc\5\26\f\f\u00a9"+
		"\u00aa\f\n\2\2\u00aa\u00ab\7!\2\2\u00ab\u00bc\5\26\f\13\u00ac\u00ad\f"+
		"\t\2\2\u00ad\u00ae\7\"\2\2\u00ae\u00bc\5\26\f\n\u00af\u00b0\f\b\2\2\u00b0"+
		"\u00b1\7#\2\2\u00b1\u00bc\5\26\f\t\u00b2\u00b3\f\7\2\2\u00b3\u00b4\7$"+
		"\2\2\u00b4\u00bc\5\26\f\b\u00b5\u00b6\f\6\2\2\u00b6\u00b7\7\34\2\2\u00b7"+
		"\u00bc\5\26\f\7\u00b8\u00b9\f\5\2\2\u00b9\u00ba\7\35\2\2\u00ba\u00bc\5"+
		"\26\f\6\u00bb\u0097\3\2\2\2\u00bb\u009a\3\2\2\2\u00bb\u009d\3\2\2\2\u00bb"+
		"\u00a0\3\2\2\2\u00bb\u00a3\3\2\2\2\u00bb\u00a6\3\2\2\2\u00bb\u00a9\3\2"+
		"\2\2\u00bb\u00ac\3\2\2\2\u00bb\u00af\3\2\2\2\u00bb\u00b2\3\2\2\2\u00bb"+
		"\u00b5\3\2\2\2\u00bb\u00b8\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2"+
		"\2\2\u00bd\u00be\3\2\2\2\u00be\27\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c8"+
		"\5\32\16\2\u00c1\u00c2\7\13\2\2\u00c2\u00c8\5\32\16\2\u00c3\u00c4\7\36"+
		"\2\2\u00c4\u00c8\5\32\16\2\u00c5\u00c6\7\16\2\2\u00c6\u00c8\5\36\20\2"+
		"\u00c7\u00c0\3\2\2\2\u00c7\u00c1\3\2\2\2\u00c7\u00c3\3\2\2\2\u00c7\u00c5"+
		"\3\2\2\2\u00c8\31\3\2\2\2\u00c9\u00ce\7\7\2\2\u00ca\u00ce\7\6\2\2\u00cb"+
		"\u00ce\7\b\2\2\u00cc\u00ce\7\t\2\2\u00cd\u00c9\3\2\2\2\u00cd\u00ca\3\2"+
		"\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00cc\3\2\2\2\u00ce\33\3\2\2\2\u00cf\u00d0"+
		"\7\17\2\2\u00d0\35\3\2\2\2\u00d1\u00d2\b\20\1\2\u00d2\u00d3\7\'\2\2\u00d3"+
		"\u00dc\3\2\2\2\u00d4\u00d5\f\4\2\2\u00d5\u00d7\7\3\2\2\u00d6\u00d8\7\7"+
		"\2\2\u00d7\u00d6\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9"+
		"\u00db\7\4\2\2\u00da\u00d4\3\2\2\2\u00db\u00de\3\2\2\2\u00dc\u00da\3\2"+
		"\2\2\u00dc\u00dd\3\2\2\2\u00dd\37\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\u00e2"+
		"\b\21\1\2\u00e0\u00e2\5\26\f\2\u00e1\u00df\3\2\2\2\u00e1\u00e0\3\2\2\2"+
		"\u00e2\u00e8\3\2\2\2\u00e3\u00e4\f\3\2\2\u00e4\u00e5\7\24\2\2\u00e5\u00e7"+
		"\5\26\f\2\u00e6\u00e3\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2"+
		"\u00e8\u00e9\3\2\2\2\u00e9!\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00ee\b"+
		"\22\1\2\u00ec\u00ee\5\16\b\2\u00ed\u00eb\3\2\2\2\u00ed\u00ec\3\2\2\2\u00ee"+
		"\u00f4\3\2\2\2\u00ef\u00f0\f\3\2\2\u00f0\u00f1\7\24\2\2\u00f1\u00f3\5"+
		"\16\b\2\u00f2\u00ef\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4"+
		"\u00f5\3\2\2\2\u00f5#\3\2\2\2\u00f6\u00f4\3\2\2\2\27,\61?GLN^h~\u0093"+
		"\u0095\u00bb\u00bd\u00c7\u00cd\u00d7\u00dc\u00e1\u00e8\u00ed\u00f4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}