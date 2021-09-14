using Antlr4.Runtime;
using Antlr4.Runtime.Tree;
using LLVMSharp.Interop;
using System;
using System.Text;

namespace Kat
{
    public unsafe class KCompiler
    {
        public bool DebugCompilation { get; set; } = false;

        public KCompiler()
        {
            LLVM.LoadLibraryPermanently(new MarshaledString("Katime.dll".AsSpan()).Value);
        }

        public int CompileAndRun(string source)
        {
            if (DebugCompilation)
            {
                Console.WriteLine("> SCRIPT: \n ----------");
                Console.Write(source);
                Console.WriteLine("\n");
            }

            ICharStream stream = CharStreams.fromString(source);
            KtlynsLexer lexer = new KtlynsLexer(stream);

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            KtlynsParser parser = new KtlynsParser(tokens);
            KErrorListener errorListener = new KErrorListener();
            parser.Profile = true;
            parser.AddErrorListener(errorListener);
            parser.Interpreter.PredictionMode = Antlr4.Runtime.Atn.PredictionMode.LL_EXACT_AMBIG_DETECTION;

            IParseTree tree = parser.program();

            if (DebugCompilation)
                PrettyPrint2(tree, parser);

            if (errorListener.HasErrors)
                return -1;

            KParserVisitor visitor = new KParserVisitor();
            visitor.Visit(tree);
            KNode root = visitor.Root;

            if (visitor.Errors.Count > 0)
            {
                for (int i = 0; i < visitor.Errors.Count; i++) Console.WriteLine(visitor.Errors[i]);
                return -1;
            }

            KLLVMGen compiler = new KLLVMGen() { LogIR = DebugCompilation };
            return compiler.CompileAndRun(root, visitor.GetIRGenContext());
        }

        private static void PrettyPrint2(IParseTree tree, Parser parser)
        {
            int indent = 0;
            StringBuilder sb = new StringBuilder();
            PrintNode(tree);
            Console.Write(sb);
            void PrintNode(IParseTree node)
            {
                for (int i = 0; i < indent; i++)
                    sb.Append("  |");
                sb.Append(Trees.GetNodeText(node, parser));
                sb.Append('\n');
                indent++;
                for (int i = 0; i < node.ChildCount; i++)
                    PrintNode(node.GetChild(i));
                indent--;
            }
        }
    }
}
