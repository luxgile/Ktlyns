using System;
using System.IO;
using System.Runtime.InteropServices;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;
using LLVMSharp.Interop;
using System.Linq;
using Antlr4.Runtime.Misc;
using System.Collections.Generic;
using System.Text;

namespace Kat
{
    internal sealed class Program
    {
        [DllImport("Katime.dll")]
        public static extern void Print(string s);

        private static unsafe void Main(string[] args)
        {
            LLVM.LoadLibraryPermanently(new MarshaledString("Katime.dll".AsSpan()).Value);

            string scriptFile = File.ReadAllText(@"D:\Development\K@\Ktlyns\script.k_at");
            Console.WriteLine("> SCRIPT: \n ----------");
            Console.Write(scriptFile);
            Console.WriteLine("\n");

            ICharStream stream = CharStreams.fromString(scriptFile);
            KtlynsLexer lexer = new KtlynsLexer(stream);
            //lexer.AddErrorListener(new KErrorListener());

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            KtlynsParser parser = new KtlynsParser(tokens);
            parser.AddErrorListener(new KErrorListener());

            IParseTree tree = parser.program();
            //PrettyPrint(tree, parser);
            KParserVisitor visitor = new KParserVisitor();
            ParsingResult result = visitor.Visit(tree);
            KNode root = visitor.Root;

            if (visitor.Errors.Count > 0)
            {
                for (int i = 0; i < visitor.Errors.Count; i++) Console.WriteLine(visitor.Errors[i]);
                return;
            }

            KCompiler compiler = new KCompiler();
            compiler.Compile(root);
        }
        private static void PrettyPrint(IParseTree tree, Parser parser)
        {
            int indent = 0;
            string s = StringNode(tree);
            Console.Write(s.Replace("(?m)^\\s+$", "").Replace("\\r?\\n\\r?\\n", "\n"));
            string StringNode(IParseTree t)
            {
                if (t.ChildCount == 0) return Utils.EscapeWhitespace(Trees.GetNodeText(t, parser), false);
                StringBuilder sb = new StringBuilder();
                IndentLevel(sb, indent);
                indent++;
                string s = Utils.EscapeWhitespace(Trees.GetNodeText(t, parser), false);
                sb.Append(s + ' ');
                for (int i = 0; i < t.ChildCount; i++)
                    sb.Append(StringNode(t.GetChild(i)));
                indent--;
                IndentLevel(sb, indent);
                return sb.ToString();
            }

            void IndentLevel(StringBuilder sb, int indent)
            {
                if (indent > 0)
                {
                    sb.Append("\n");
                    for (int cnt = 0; cnt < indent; cnt++)
                        sb.Append(" ");
                }
            }
        }
    }

}