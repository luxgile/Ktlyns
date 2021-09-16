using Antlr4.Runtime;
using Antlr4.Runtime.Atn;
using Antlr4.Runtime.Dfa;
using Antlr4.Runtime.Misc;
using Antlr4.Runtime.Sharpen;
using System;
using System.IO;

namespace Kat
{
    public class KErrorListener : DiagnosticErrorListener
    {
        public bool HasWarnings { get; set; }
        public bool HasErrors { get; set; }

        public override void ReportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, bool exact, BitSet ambigAlts, ATNConfigSet configs)
        {
            HasWarnings = true;
            Console.WriteLine($"Warning: Ambiguity found: {GetDecisionDescription(recognizer, dfa)}. Conflicting Alts: {GetConflictingAlts(ambigAlts, configs)}. Input: {((ITokenStream)recognizer.InputStream).GetText(Interval.Of(startIndex, stopIndex))}");
            for (int i = 1; i <= ambigAlts.Cardinality(); i++)
            {
                Console.WriteLine(recognizer.RuleNames[ambigAlts.NextSetBit(i)]);
            }
        }

        public override void ReportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, SimulatorState conflictState)
        {
            HasWarnings = true;
            Console.WriteLine($"Warning: Attempting Full Context: {GetDecisionDescription(recognizer, dfa)}. Input: {((ITokenStream)recognizer.InputStream).GetText(Interval.Of(startIndex, stopIndex))}");
        }

        public override void ReportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, SimulatorState acceptState)
        {
            HasWarnings = true;
            Console.WriteLine($"Warning: Context Sensitivity");
        }

        public override void SyntaxError(TextWriter output, IRecognizer recognizer, IToken offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
        {
            HasErrors = true;
            Console.WriteLine($"Error: {msg}");
        }
    }
}
