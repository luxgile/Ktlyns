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

using System;
using System.IO;
using System.Text;
using Antlr4.Runtime;
using Antlr4.Runtime.Atn;
using Antlr4.Runtime.Misc;
using DFA = Antlr4.Runtime.Dfa.DFA;

[System.CodeDom.Compiler.GeneratedCode("ANTLR", "4.9.2")]
[System.CLSCompliant(false)]
public partial class KtlynsLexer : Lexer {
	protected static DFA[] decisionToDFA;
	protected static PredictionContextCache sharedContextCache = new PredictionContextCache();
	public const int
		WS=1, DEC=2, INT=3, PLUS=4, MINUS=5, SLASH=6, STAR=7, STR=8, LPRN=9, RPRN=10, 
		LBRC=11, RBRC=12, LARR=13, RARR=14, COMMA=15, DOT=16, SDOT=17, EQ=18, 
		IF=19, ELSE=20, AT=21, RET=22, AND=23, OR=24, NOT=25, EQEQ=26, NEQEQ=27, 
		GREAT=28, EQGREAT=29, LESS=30, EQLESS=31, METHOD=32, ID=33;
	public static string[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static string[] modeNames = {
		"DEFAULT_MODE"
	};

	public static readonly string[] ruleNames = {
		"WS", "DEC", "INT", "PLUS", "MINUS", "SLASH", "STAR", "STR", "LPRN", "RPRN", 
		"LBRC", "RBRC", "LARR", "RARR", "COMMA", "DOT", "SDOT", "EQ", "IF", "ELSE", 
		"AT", "RET", "AND", "OR", "NOT", "EQEQ", "NEQEQ", "GREAT", "EQGREAT", 
		"LESS", "EQLESS", "METHOD", "ID"
	};


	public KtlynsLexer(ICharStream input)
	: this(input, Console.Out, Console.Error) { }

	public KtlynsLexer(ICharStream input, TextWriter output, TextWriter errorOutput)
	: base(input, output, errorOutput)
	{
		Interpreter = new LexerATNSimulator(this, _ATN, decisionToDFA, sharedContextCache);
	}

	private static readonly string[] _LiteralNames = {
		null, null, null, null, "'+'", "'-'", "'/'", "'*'", null, "'('", "')'", 
		"'{'", "'}'", "'<'", "'>'", "','", "'.'", "';'", "'='", "'if'", "'else'", 
		"'@'", "'ret'", "'and'", "'or'", "'not'", "'equals'", "'not equals'", 
		"'great'", "'eq great'", "'less'", "'eq less'", "'method'"
	};
	private static readonly string[] _SymbolicNames = {
		null, "WS", "DEC", "INT", "PLUS", "MINUS", "SLASH", "STAR", "STR", "LPRN", 
		"RPRN", "LBRC", "RBRC", "LARR", "RARR", "COMMA", "DOT", "SDOT", "EQ", 
		"IF", "ELSE", "AT", "RET", "AND", "OR", "NOT", "EQEQ", "NEQEQ", "GREAT", 
		"EQGREAT", "LESS", "EQLESS", "METHOD", "ID"
	};
	public static readonly IVocabulary DefaultVocabulary = new Vocabulary(_LiteralNames, _SymbolicNames);

	[NotNull]
	public override IVocabulary Vocabulary
	{
		get
		{
			return DefaultVocabulary;
		}
	}

	public override string GrammarFileName { get { return "Ktlyns.g4"; } }

	public override string[] RuleNames { get { return ruleNames; } }

	public override string[] ChannelNames { get { return channelNames; } }

	public override string[] ModeNames { get { return modeNames; } }

	public override string SerializedAtn { get { return new string(_serializedATN); } }

	static KtlynsLexer() {
		decisionToDFA = new DFA[_ATN.NumberOfDecisions];
		for (int i = 0; i < _ATN.NumberOfDecisions; i++) {
			decisionToDFA[i] = new DFA(_ATN.GetDecisionState(i), i);
		}
	}
	private static char[] _serializedATN = {
		'\x3', '\x608B', '\xA72A', '\x8133', '\xB9ED', '\x417C', '\x3BE7', '\x7786', 
		'\x5964', '\x2', '#', '\xD6', '\b', '\x1', '\x4', '\x2', '\t', '\x2', 
		'\x4', '\x3', '\t', '\x3', '\x4', '\x4', '\t', '\x4', '\x4', '\x5', '\t', 
		'\x5', '\x4', '\x6', '\t', '\x6', '\x4', '\a', '\t', '\a', '\x4', '\b', 
		'\t', '\b', '\x4', '\t', '\t', '\t', '\x4', '\n', '\t', '\n', '\x4', '\v', 
		'\t', '\v', '\x4', '\f', '\t', '\f', '\x4', '\r', '\t', '\r', '\x4', '\xE', 
		'\t', '\xE', '\x4', '\xF', '\t', '\xF', '\x4', '\x10', '\t', '\x10', '\x4', 
		'\x11', '\t', '\x11', '\x4', '\x12', '\t', '\x12', '\x4', '\x13', '\t', 
		'\x13', '\x4', '\x14', '\t', '\x14', '\x4', '\x15', '\t', '\x15', '\x4', 
		'\x16', '\t', '\x16', '\x4', '\x17', '\t', '\x17', '\x4', '\x18', '\t', 
		'\x18', '\x4', '\x19', '\t', '\x19', '\x4', '\x1A', '\t', '\x1A', '\x4', 
		'\x1B', '\t', '\x1B', '\x4', '\x1C', '\t', '\x1C', '\x4', '\x1D', '\t', 
		'\x1D', '\x4', '\x1E', '\t', '\x1E', '\x4', '\x1F', '\t', '\x1F', '\x4', 
		' ', '\t', ' ', '\x4', '!', '\t', '!', '\x4', '\"', '\t', '\"', '\x3', 
		'\x2', '\x6', '\x2', 'G', '\n', '\x2', '\r', '\x2', '\xE', '\x2', 'H', 
		'\x3', '\x2', '\x3', '\x2', '\x3', '\x3', '\x6', '\x3', 'N', '\n', '\x3', 
		'\r', '\x3', '\xE', '\x3', 'O', '\x3', '\x3', '\x3', '\x3', '\x6', '\x3', 
		'T', '\n', '\x3', '\r', '\x3', '\xE', '\x3', 'U', '\x3', '\x4', '\x6', 
		'\x4', 'Y', '\n', '\x4', '\r', '\x4', '\xE', '\x4', 'Z', '\x3', '\x5', 
		'\x3', '\x5', '\x3', '\x6', '\x3', '\x6', '\x3', '\a', '\x3', '\a', '\x3', 
		'\b', '\x3', '\b', '\x3', '\t', '\x3', '\t', '\a', '\t', 'g', '\n', '\t', 
		'\f', '\t', '\xE', '\t', 'j', '\v', '\t', '\x3', '\t', '\x3', '\t', '\x3', 
		'\n', '\x3', '\n', '\x3', '\v', '\x3', '\v', '\x3', '\f', '\x3', '\f', 
		'\x3', '\r', '\x3', '\r', '\x3', '\xE', '\x3', '\xE', '\x3', '\xF', '\x3', 
		'\xF', '\x3', '\x10', '\x3', '\x10', '\x3', '\x11', '\x3', '\x11', '\x3', 
		'\x12', '\x3', '\x12', '\x3', '\x13', '\x3', '\x13', '\x3', '\x14', '\x3', 
		'\x14', '\x3', '\x14', '\x3', '\x15', '\x3', '\x15', '\x3', '\x15', '\x3', 
		'\x15', '\x3', '\x15', '\x3', '\x16', '\x3', '\x16', '\x3', '\x17', '\x3', 
		'\x17', '\x3', '\x17', '\x3', '\x17', '\x3', '\x18', '\x3', '\x18', '\x3', 
		'\x18', '\x3', '\x18', '\x3', '\x19', '\x3', '\x19', '\x3', '\x19', '\x3', 
		'\x1A', '\x3', '\x1A', '\x3', '\x1A', '\x3', '\x1A', '\x3', '\x1B', '\x3', 
		'\x1B', '\x3', '\x1B', '\x3', '\x1B', '\x3', '\x1B', '\x3', '\x1B', '\x3', 
		'\x1B', '\x3', '\x1C', '\x3', '\x1C', '\x3', '\x1C', '\x3', '\x1C', '\x3', 
		'\x1C', '\x3', '\x1C', '\x3', '\x1C', '\x3', '\x1C', '\x3', '\x1C', '\x3', 
		'\x1C', '\x3', '\x1C', '\x3', '\x1D', '\x3', '\x1D', '\x3', '\x1D', '\x3', 
		'\x1D', '\x3', '\x1D', '\x3', '\x1D', '\x3', '\x1E', '\x3', '\x1E', '\x3', 
		'\x1E', '\x3', '\x1E', '\x3', '\x1E', '\x3', '\x1E', '\x3', '\x1E', '\x3', 
		'\x1E', '\x3', '\x1E', '\x3', '\x1F', '\x3', '\x1F', '\x3', '\x1F', '\x3', 
		'\x1F', '\x3', '\x1F', '\x3', ' ', '\x3', ' ', '\x3', ' ', '\x3', ' ', 
		'\x3', ' ', '\x3', ' ', '\x3', ' ', '\x3', ' ', '\x3', '!', '\x3', '!', 
		'\x3', '!', '\x3', '!', '\x3', '!', '\x3', '!', '\x3', '!', '\x3', '\"', 
		'\x3', '\"', '\a', '\"', '\xD2', '\n', '\"', '\f', '\"', '\xE', '\"', 
		'\xD5', '\v', '\"', '\x2', '\x2', '#', '\x3', '\x3', '\x5', '\x4', '\a', 
		'\x5', '\t', '\x6', '\v', '\a', '\r', '\b', '\xF', '\t', '\x11', '\n', 
		'\x13', '\v', '\x15', '\f', '\x17', '\r', '\x19', '\xE', '\x1B', '\xF', 
		'\x1D', '\x10', '\x1F', '\x11', '!', '\x12', '#', '\x13', '%', '\x14', 
		'\'', '\x15', ')', '\x16', '+', '\x17', '-', '\x18', '/', '\x19', '\x31', 
		'\x1A', '\x33', '\x1B', '\x35', '\x1C', '\x37', '\x1D', '\x39', '\x1E', 
		';', '\x1F', '=', ' ', '?', '!', '\x41', '\"', '\x43', '#', '\x3', '\x2', 
		'\a', '\x5', '\x2', '\v', '\f', '\xF', '\xF', '\"', '\"', '\x3', '\x2', 
		'\x32', ';', '\x4', '\x2', '$', '$', '`', '`', '\x4', '\x2', '\x43', '\\', 
		'\x63', '|', '\x5', '\x2', '\x32', ';', '\x43', '\\', '\x63', '|', '\x2', 
		'\xDB', '\x2', '\x3', '\x3', '\x2', '\x2', '\x2', '\x2', '\x5', '\x3', 
		'\x2', '\x2', '\x2', '\x2', '\a', '\x3', '\x2', '\x2', '\x2', '\x2', '\t', 
		'\x3', '\x2', '\x2', '\x2', '\x2', '\v', '\x3', '\x2', '\x2', '\x2', '\x2', 
		'\r', '\x3', '\x2', '\x2', '\x2', '\x2', '\xF', '\x3', '\x2', '\x2', '\x2', 
		'\x2', '\x11', '\x3', '\x2', '\x2', '\x2', '\x2', '\x13', '\x3', '\x2', 
		'\x2', '\x2', '\x2', '\x15', '\x3', '\x2', '\x2', '\x2', '\x2', '\x17', 
		'\x3', '\x2', '\x2', '\x2', '\x2', '\x19', '\x3', '\x2', '\x2', '\x2', 
		'\x2', '\x1B', '\x3', '\x2', '\x2', '\x2', '\x2', '\x1D', '\x3', '\x2', 
		'\x2', '\x2', '\x2', '\x1F', '\x3', '\x2', '\x2', '\x2', '\x2', '!', '\x3', 
		'\x2', '\x2', '\x2', '\x2', '#', '\x3', '\x2', '\x2', '\x2', '\x2', '%', 
		'\x3', '\x2', '\x2', '\x2', '\x2', '\'', '\x3', '\x2', '\x2', '\x2', '\x2', 
		')', '\x3', '\x2', '\x2', '\x2', '\x2', '+', '\x3', '\x2', '\x2', '\x2', 
		'\x2', '-', '\x3', '\x2', '\x2', '\x2', '\x2', '/', '\x3', '\x2', '\x2', 
		'\x2', '\x2', '\x31', '\x3', '\x2', '\x2', '\x2', '\x2', '\x33', '\x3', 
		'\x2', '\x2', '\x2', '\x2', '\x35', '\x3', '\x2', '\x2', '\x2', '\x2', 
		'\x37', '\x3', '\x2', '\x2', '\x2', '\x2', '\x39', '\x3', '\x2', '\x2', 
		'\x2', '\x2', ';', '\x3', '\x2', '\x2', '\x2', '\x2', '=', '\x3', '\x2', 
		'\x2', '\x2', '\x2', '?', '\x3', '\x2', '\x2', '\x2', '\x2', '\x41', '\x3', 
		'\x2', '\x2', '\x2', '\x2', '\x43', '\x3', '\x2', '\x2', '\x2', '\x3', 
		'\x46', '\x3', '\x2', '\x2', '\x2', '\x5', 'M', '\x3', '\x2', '\x2', '\x2', 
		'\a', 'X', '\x3', '\x2', '\x2', '\x2', '\t', '\\', '\x3', '\x2', '\x2', 
		'\x2', '\v', '^', '\x3', '\x2', '\x2', '\x2', '\r', '`', '\x3', '\x2', 
		'\x2', '\x2', '\xF', '\x62', '\x3', '\x2', '\x2', '\x2', '\x11', '\x64', 
		'\x3', '\x2', '\x2', '\x2', '\x13', 'm', '\x3', '\x2', '\x2', '\x2', '\x15', 
		'o', '\x3', '\x2', '\x2', '\x2', '\x17', 'q', '\x3', '\x2', '\x2', '\x2', 
		'\x19', 's', '\x3', '\x2', '\x2', '\x2', '\x1B', 'u', '\x3', '\x2', '\x2', 
		'\x2', '\x1D', 'w', '\x3', '\x2', '\x2', '\x2', '\x1F', 'y', '\x3', '\x2', 
		'\x2', '\x2', '!', '{', '\x3', '\x2', '\x2', '\x2', '#', '}', '\x3', '\x2', 
		'\x2', '\x2', '%', '\x7F', '\x3', '\x2', '\x2', '\x2', '\'', '\x81', '\x3', 
		'\x2', '\x2', '\x2', ')', '\x84', '\x3', '\x2', '\x2', '\x2', '+', '\x89', 
		'\x3', '\x2', '\x2', '\x2', '-', '\x8B', '\x3', '\x2', '\x2', '\x2', '/', 
		'\x8F', '\x3', '\x2', '\x2', '\x2', '\x31', '\x93', '\x3', '\x2', '\x2', 
		'\x2', '\x33', '\x96', '\x3', '\x2', '\x2', '\x2', '\x35', '\x9A', '\x3', 
		'\x2', '\x2', '\x2', '\x37', '\xA1', '\x3', '\x2', '\x2', '\x2', '\x39', 
		'\xAC', '\x3', '\x2', '\x2', '\x2', ';', '\xB2', '\x3', '\x2', '\x2', 
		'\x2', '=', '\xBB', '\x3', '\x2', '\x2', '\x2', '?', '\xC0', '\x3', '\x2', 
		'\x2', '\x2', '\x41', '\xC8', '\x3', '\x2', '\x2', '\x2', '\x43', '\xCF', 
		'\x3', '\x2', '\x2', '\x2', '\x45', 'G', '\t', '\x2', '\x2', '\x2', '\x46', 
		'\x45', '\x3', '\x2', '\x2', '\x2', 'G', 'H', '\x3', '\x2', '\x2', '\x2', 
		'H', '\x46', '\x3', '\x2', '\x2', '\x2', 'H', 'I', '\x3', '\x2', '\x2', 
		'\x2', 'I', 'J', '\x3', '\x2', '\x2', '\x2', 'J', 'K', '\b', '\x2', '\x2', 
		'\x2', 'K', '\x4', '\x3', '\x2', '\x2', '\x2', 'L', 'N', '\t', '\x3', 
		'\x2', '\x2', 'M', 'L', '\x3', '\x2', '\x2', '\x2', 'N', 'O', '\x3', '\x2', 
		'\x2', '\x2', 'O', 'M', '\x3', '\x2', '\x2', '\x2', 'O', 'P', '\x3', '\x2', 
		'\x2', '\x2', 'P', 'Q', '\x3', '\x2', '\x2', '\x2', 'Q', 'S', '\a', '\x30', 
		'\x2', '\x2', 'R', 'T', '\t', '\x3', '\x2', '\x2', 'S', 'R', '\x3', '\x2', 
		'\x2', '\x2', 'T', 'U', '\x3', '\x2', '\x2', '\x2', 'U', 'S', '\x3', '\x2', 
		'\x2', '\x2', 'U', 'V', '\x3', '\x2', '\x2', '\x2', 'V', '\x6', '\x3', 
		'\x2', '\x2', '\x2', 'W', 'Y', '\t', '\x3', '\x2', '\x2', 'X', 'W', '\x3', 
		'\x2', '\x2', '\x2', 'Y', 'Z', '\x3', '\x2', '\x2', '\x2', 'Z', 'X', '\x3', 
		'\x2', '\x2', '\x2', 'Z', '[', '\x3', '\x2', '\x2', '\x2', '[', '\b', 
		'\x3', '\x2', '\x2', '\x2', '\\', ']', '\a', '-', '\x2', '\x2', ']', '\n', 
		'\x3', '\x2', '\x2', '\x2', '^', '_', '\a', '/', '\x2', '\x2', '_', '\f', 
		'\x3', '\x2', '\x2', '\x2', '`', '\x61', '\a', '\x31', '\x2', '\x2', '\x61', 
		'\xE', '\x3', '\x2', '\x2', '\x2', '\x62', '\x63', '\a', ',', '\x2', '\x2', 
		'\x63', '\x10', '\x3', '\x2', '\x2', '\x2', '\x64', 'h', '\a', '$', '\x2', 
		'\x2', '\x65', 'g', '\t', '\x4', '\x2', '\x2', '\x66', '\x65', '\x3', 
		'\x2', '\x2', '\x2', 'g', 'j', '\x3', '\x2', '\x2', '\x2', 'h', '\x66', 
		'\x3', '\x2', '\x2', '\x2', 'h', 'i', '\x3', '\x2', '\x2', '\x2', 'i', 
		'k', '\x3', '\x2', '\x2', '\x2', 'j', 'h', '\x3', '\x2', '\x2', '\x2', 
		'k', 'l', '\a', '$', '\x2', '\x2', 'l', '\x12', '\x3', '\x2', '\x2', '\x2', 
		'm', 'n', '\a', '*', '\x2', '\x2', 'n', '\x14', '\x3', '\x2', '\x2', '\x2', 
		'o', 'p', '\a', '+', '\x2', '\x2', 'p', '\x16', '\x3', '\x2', '\x2', '\x2', 
		'q', 'r', '\a', '}', '\x2', '\x2', 'r', '\x18', '\x3', '\x2', '\x2', '\x2', 
		's', 't', '\a', '\x7F', '\x2', '\x2', 't', '\x1A', '\x3', '\x2', '\x2', 
		'\x2', 'u', 'v', '\a', '>', '\x2', '\x2', 'v', '\x1C', '\x3', '\x2', '\x2', 
		'\x2', 'w', 'x', '\a', '@', '\x2', '\x2', 'x', '\x1E', '\x3', '\x2', '\x2', 
		'\x2', 'y', 'z', '\a', '.', '\x2', '\x2', 'z', ' ', '\x3', '\x2', '\x2', 
		'\x2', '{', '|', '\a', '\x30', '\x2', '\x2', '|', '\"', '\x3', '\x2', 
		'\x2', '\x2', '}', '~', '\a', '=', '\x2', '\x2', '~', '$', '\x3', '\x2', 
		'\x2', '\x2', '\x7F', '\x80', '\a', '?', '\x2', '\x2', '\x80', '&', '\x3', 
		'\x2', '\x2', '\x2', '\x81', '\x82', '\a', 'k', '\x2', '\x2', '\x82', 
		'\x83', '\a', 'h', '\x2', '\x2', '\x83', '(', '\x3', '\x2', '\x2', '\x2', 
		'\x84', '\x85', '\a', 'g', '\x2', '\x2', '\x85', '\x86', '\a', 'n', '\x2', 
		'\x2', '\x86', '\x87', '\a', 'u', '\x2', '\x2', '\x87', '\x88', '\a', 
		'g', '\x2', '\x2', '\x88', '*', '\x3', '\x2', '\x2', '\x2', '\x89', '\x8A', 
		'\a', '\x42', '\x2', '\x2', '\x8A', ',', '\x3', '\x2', '\x2', '\x2', '\x8B', 
		'\x8C', '\a', 't', '\x2', '\x2', '\x8C', '\x8D', '\a', 'g', '\x2', '\x2', 
		'\x8D', '\x8E', '\a', 'v', '\x2', '\x2', '\x8E', '.', '\x3', '\x2', '\x2', 
		'\x2', '\x8F', '\x90', '\a', '\x63', '\x2', '\x2', '\x90', '\x91', '\a', 
		'p', '\x2', '\x2', '\x91', '\x92', '\a', '\x66', '\x2', '\x2', '\x92', 
		'\x30', '\x3', '\x2', '\x2', '\x2', '\x93', '\x94', '\a', 'q', '\x2', 
		'\x2', '\x94', '\x95', '\a', 't', '\x2', '\x2', '\x95', '\x32', '\x3', 
		'\x2', '\x2', '\x2', '\x96', '\x97', '\a', 'p', '\x2', '\x2', '\x97', 
		'\x98', '\a', 'q', '\x2', '\x2', '\x98', '\x99', '\a', 'v', '\x2', '\x2', 
		'\x99', '\x34', '\x3', '\x2', '\x2', '\x2', '\x9A', '\x9B', '\a', 'g', 
		'\x2', '\x2', '\x9B', '\x9C', '\a', 's', '\x2', '\x2', '\x9C', '\x9D', 
		'\a', 'w', '\x2', '\x2', '\x9D', '\x9E', '\a', '\x63', '\x2', '\x2', '\x9E', 
		'\x9F', '\a', 'n', '\x2', '\x2', '\x9F', '\xA0', '\a', 'u', '\x2', '\x2', 
		'\xA0', '\x36', '\x3', '\x2', '\x2', '\x2', '\xA1', '\xA2', '\a', 'p', 
		'\x2', '\x2', '\xA2', '\xA3', '\a', 'q', '\x2', '\x2', '\xA3', '\xA4', 
		'\a', 'v', '\x2', '\x2', '\xA4', '\xA5', '\a', '\"', '\x2', '\x2', '\xA5', 
		'\xA6', '\a', 'g', '\x2', '\x2', '\xA6', '\xA7', '\a', 's', '\x2', '\x2', 
		'\xA7', '\xA8', '\a', 'w', '\x2', '\x2', '\xA8', '\xA9', '\a', '\x63', 
		'\x2', '\x2', '\xA9', '\xAA', '\a', 'n', '\x2', '\x2', '\xAA', '\xAB', 
		'\a', 'u', '\x2', '\x2', '\xAB', '\x38', '\x3', '\x2', '\x2', '\x2', '\xAC', 
		'\xAD', '\a', 'i', '\x2', '\x2', '\xAD', '\xAE', '\a', 't', '\x2', '\x2', 
		'\xAE', '\xAF', '\a', 'g', '\x2', '\x2', '\xAF', '\xB0', '\a', '\x63', 
		'\x2', '\x2', '\xB0', '\xB1', '\a', 'v', '\x2', '\x2', '\xB1', ':', '\x3', 
		'\x2', '\x2', '\x2', '\xB2', '\xB3', '\a', 'g', '\x2', '\x2', '\xB3', 
		'\xB4', '\a', 's', '\x2', '\x2', '\xB4', '\xB5', '\a', '\"', '\x2', '\x2', 
		'\xB5', '\xB6', '\a', 'i', '\x2', '\x2', '\xB6', '\xB7', '\a', 't', '\x2', 
		'\x2', '\xB7', '\xB8', '\a', 'g', '\x2', '\x2', '\xB8', '\xB9', '\a', 
		'\x63', '\x2', '\x2', '\xB9', '\xBA', '\a', 'v', '\x2', '\x2', '\xBA', 
		'<', '\x3', '\x2', '\x2', '\x2', '\xBB', '\xBC', '\a', 'n', '\x2', '\x2', 
		'\xBC', '\xBD', '\a', 'g', '\x2', '\x2', '\xBD', '\xBE', '\a', 'u', '\x2', 
		'\x2', '\xBE', '\xBF', '\a', 'u', '\x2', '\x2', '\xBF', '>', '\x3', '\x2', 
		'\x2', '\x2', '\xC0', '\xC1', '\a', 'g', '\x2', '\x2', '\xC1', '\xC2', 
		'\a', 's', '\x2', '\x2', '\xC2', '\xC3', '\a', '\"', '\x2', '\x2', '\xC3', 
		'\xC4', '\a', 'n', '\x2', '\x2', '\xC4', '\xC5', '\a', 'g', '\x2', '\x2', 
		'\xC5', '\xC6', '\a', 'u', '\x2', '\x2', '\xC6', '\xC7', '\a', 'u', '\x2', 
		'\x2', '\xC7', '@', '\x3', '\x2', '\x2', '\x2', '\xC8', '\xC9', '\a', 
		'o', '\x2', '\x2', '\xC9', '\xCA', '\a', 'g', '\x2', '\x2', '\xCA', '\xCB', 
		'\a', 'v', '\x2', '\x2', '\xCB', '\xCC', '\a', 'j', '\x2', '\x2', '\xCC', 
		'\xCD', '\a', 'q', '\x2', '\x2', '\xCD', '\xCE', '\a', '\x66', '\x2', 
		'\x2', '\xCE', '\x42', '\x3', '\x2', '\x2', '\x2', '\xCF', '\xD3', '\t', 
		'\x5', '\x2', '\x2', '\xD0', '\xD2', '\t', '\x6', '\x2', '\x2', '\xD1', 
		'\xD0', '\x3', '\x2', '\x2', '\x2', '\xD2', '\xD5', '\x3', '\x2', '\x2', 
		'\x2', '\xD3', '\xD1', '\x3', '\x2', '\x2', '\x2', '\xD3', '\xD4', '\x3', 
		'\x2', '\x2', '\x2', '\xD4', '\x44', '\x3', '\x2', '\x2', '\x2', '\xD5', 
		'\xD3', '\x3', '\x2', '\x2', '\x2', '\t', '\x2', 'H', 'O', 'U', 'Z', 'h', 
		'\xD3', '\x3', '\b', '\x2', '\x2',
	};

	public static readonly ATN _ATN =
		new ATNDeserializer().Deserialize(_serializedATN);


}