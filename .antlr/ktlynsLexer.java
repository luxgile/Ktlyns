// Generated from d:\Development\K@\Ktlyns\Ktlyns.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class KtlynsLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, DEC=2, INT=3, PLUS=4, MINUS=5, SLASH=6, STAR=7, STR=8, LPRN=9, RPRN=10, 
		LBRC=11, RBRC=12, LARR=13, RARR=14, COMMA=15, DOT=16, SDOT=17, EQ=18, 
		IF=19, ELSE=20, AT=21, RET=22, AND=23, OR=24, NOT=25, EQEQ=26, NEQEQ=27, 
		GREAT=28, EQGREAT=29, LESS=30, EQLESS=31, METHOD=32, ID=33;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WS", "DEC", "INT", "PLUS", "MINUS", "SLASH", "STAR", "STR", "LPRN", 
			"RPRN", "LBRC", "RBRC", "LARR", "RARR", "COMMA", "DOT", "SDOT", "EQ", 
			"IF", "ELSE", "AT", "RET", "AND", "OR", "NOT", "EQEQ", "NEQEQ", "GREAT", 
			"EQGREAT", "LESS", "EQLESS", "METHOD", "ID"
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


	public KtlynsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Ktlyns.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2#\u00d6\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\6\2G\n\2\r\2\16\2H\3\2\3\2\3\3\6\3N\n\3\r\3\16\3O\3\3"+
		"\3\3\6\3T\n\3\r\3\16\3U\3\4\6\4Y\n\4\r\4\16\4Z\3\5\3\5\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\7\tg\n\t\f\t\16\tj\13\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f"+
		"\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3"+
		"\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3"+
		"\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3"+
		"\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3!\3!\3"+
		"!\3!\3!\3!\3!\3\"\3\"\7\"\u00d2\n\"\f\"\16\"\u00d5\13\"\2\2#\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#\3\2\7\5\2\13\f\17\17\"\"\3\2\62;\4\2$$``\4\2C\\c|\5\2\62;C\\c|\2\u00db"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\3F\3\2\2\2\5M\3\2\2"+
		"\2\7X\3\2\2\2\t\\\3\2\2\2\13^\3\2\2\2\r`\3\2\2\2\17b\3\2\2\2\21d\3\2\2"+
		"\2\23m\3\2\2\2\25o\3\2\2\2\27q\3\2\2\2\31s\3\2\2\2\33u\3\2\2\2\35w\3\2"+
		"\2\2\37y\3\2\2\2!{\3\2\2\2#}\3\2\2\2%\177\3\2\2\2\'\u0081\3\2\2\2)\u0084"+
		"\3\2\2\2+\u0089\3\2\2\2-\u008b\3\2\2\2/\u008f\3\2\2\2\61\u0093\3\2\2\2"+
		"\63\u0096\3\2\2\2\65\u009a\3\2\2\2\67\u00a1\3\2\2\29\u00ac\3\2\2\2;\u00b2"+
		"\3\2\2\2=\u00bb\3\2\2\2?\u00c0\3\2\2\2A\u00c8\3\2\2\2C\u00cf\3\2\2\2E"+
		"G\t\2\2\2FE\3\2\2\2GH\3\2\2\2HF\3\2\2\2HI\3\2\2\2IJ\3\2\2\2JK\b\2\2\2"+
		"K\4\3\2\2\2LN\t\3\2\2ML\3\2\2\2NO\3\2\2\2OM\3\2\2\2OP\3\2\2\2PQ\3\2\2"+
		"\2QS\7\60\2\2RT\t\3\2\2SR\3\2\2\2TU\3\2\2\2US\3\2\2\2UV\3\2\2\2V\6\3\2"+
		"\2\2WY\t\3\2\2XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\b\3\2\2\2\\]\7"+
		"-\2\2]\n\3\2\2\2^_\7/\2\2_\f\3\2\2\2`a\7\61\2\2a\16\3\2\2\2bc\7,\2\2c"+
		"\20\3\2\2\2dh\7$\2\2eg\t\4\2\2fe\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2"+
		"ik\3\2\2\2jh\3\2\2\2kl\7$\2\2l\22\3\2\2\2mn\7*\2\2n\24\3\2\2\2op\7+\2"+
		"\2p\26\3\2\2\2qr\7}\2\2r\30\3\2\2\2st\7\177\2\2t\32\3\2\2\2uv\7>\2\2v"+
		"\34\3\2\2\2wx\7@\2\2x\36\3\2\2\2yz\7.\2\2z \3\2\2\2{|\7\60\2\2|\"\3\2"+
		"\2\2}~\7=\2\2~$\3\2\2\2\177\u0080\7?\2\2\u0080&\3\2\2\2\u0081\u0082\7"+
		"k\2\2\u0082\u0083\7h\2\2\u0083(\3\2\2\2\u0084\u0085\7g\2\2\u0085\u0086"+
		"\7n\2\2\u0086\u0087\7u\2\2\u0087\u0088\7g\2\2\u0088*\3\2\2\2\u0089\u008a"+
		"\7B\2\2\u008a,\3\2\2\2\u008b\u008c\7t\2\2\u008c\u008d\7g\2\2\u008d\u008e"+
		"\7v\2\2\u008e.\3\2\2\2\u008f\u0090\7c\2\2\u0090\u0091\7p\2\2\u0091\u0092"+
		"\7f\2\2\u0092\60\3\2\2\2\u0093\u0094\7q\2\2\u0094\u0095\7t\2\2\u0095\62"+
		"\3\2\2\2\u0096\u0097\7p\2\2\u0097\u0098\7q\2\2\u0098\u0099\7v\2\2\u0099"+
		"\64\3\2\2\2\u009a\u009b\7g\2\2\u009b\u009c\7s\2\2\u009c\u009d\7w\2\2\u009d"+
		"\u009e\7c\2\2\u009e\u009f\7n\2\2\u009f\u00a0\7u\2\2\u00a0\66\3\2\2\2\u00a1"+
		"\u00a2\7p\2\2\u00a2\u00a3\7q\2\2\u00a3\u00a4\7v\2\2\u00a4\u00a5\7\"\2"+
		"\2\u00a5\u00a6\7g\2\2\u00a6\u00a7\7s\2\2\u00a7\u00a8\7w\2\2\u00a8\u00a9"+
		"\7c\2\2\u00a9\u00aa\7n\2\2\u00aa\u00ab\7u\2\2\u00ab8\3\2\2\2\u00ac\u00ad"+
		"\7i\2\2\u00ad\u00ae\7t\2\2\u00ae\u00af\7g\2\2\u00af\u00b0\7c\2\2\u00b0"+
		"\u00b1\7v\2\2\u00b1:\3\2\2\2\u00b2\u00b3\7g\2\2\u00b3\u00b4\7s\2\2\u00b4"+
		"\u00b5\7\"\2\2\u00b5\u00b6\7i\2\2\u00b6\u00b7\7t\2\2\u00b7\u00b8\7g\2"+
		"\2\u00b8\u00b9\7c\2\2\u00b9\u00ba\7v\2\2\u00ba<\3\2\2\2\u00bb\u00bc\7"+
		"n\2\2\u00bc\u00bd\7g\2\2\u00bd\u00be\7u\2\2\u00be\u00bf\7u\2\2\u00bf>"+
		"\3\2\2\2\u00c0\u00c1\7g\2\2\u00c1\u00c2\7s\2\2\u00c2\u00c3\7\"\2\2\u00c3"+
		"\u00c4\7n\2\2\u00c4\u00c5\7g\2\2\u00c5\u00c6\7u\2\2\u00c6\u00c7\7u\2\2"+
		"\u00c7@\3\2\2\2\u00c8\u00c9\7o\2\2\u00c9\u00ca\7g\2\2\u00ca\u00cb\7v\2"+
		"\2\u00cb\u00cc\7j\2\2\u00cc\u00cd\7q\2\2\u00cd\u00ce\7f\2\2\u00ceB\3\2"+
		"\2\2\u00cf\u00d3\t\5\2\2\u00d0\u00d2\t\6\2\2\u00d1\u00d0\3\2\2\2\u00d2"+
		"\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4D\3\2\2\2"+
		"\u00d5\u00d3\3\2\2\2\t\2HOUZh\u00d3\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}