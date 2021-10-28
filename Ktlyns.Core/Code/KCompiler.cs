using Antlr4.Runtime;
using Antlr4.Runtime.Tree;
using LLVMSharp.Interop;
using System;
using System.Diagnostics;
using System.Text;

namespace Kat
{
    public unsafe class KCompiler
    {
        public uint Version { get; } = 1;
        public bool DebugCompilation { get; set; } = false;

        public KCompiler()
        {
            //int result = LLVM.LoadLibraryPermanently(new MarshaledString("Katime.dll".AsSpan()).Value);
        }

        private void CreateParser(string source, out KtlynsParser parser, out KErrorListener errorListener)
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
            parser = new KtlynsParser(tokens);
            errorListener = new KErrorListener();
            parser.Profile = true;
            parser.AddErrorListener(errorListener);
            parser.Interpreter.PredictionMode = Antlr4.Runtime.Atn.PredictionMode.LL_EXACT_AMBIG_DETECTION;
        }

        public int CompileAndRun(string source)
        {
            CreateParser(source, out KtlynsParser parser, out KErrorListener errorListener);
            IParseTree tree = parser.program();

            if (DebugCompilation)
                PrettyPrint2(tree, parser);

            if (errorListener.HasErrors)
                return -1;

            KParserVisitor visitor = new KParserVisitor();
            visitor.Visit(tree);
            KNode root = visitor.Root;

            //if (visitor.Errors.Count > 0)
            //{
            //    for (int i = 0; i < visitor.Errors.Count; i++) Console.WriteLine(visitor.Errors[i]);
            //    return -1;
            //}

            KLLVMGen compiler = new KLLVMGen() { LogIR = DebugCompilation };
            return compiler.CompileAndRun(root, visitor.GetIRGenContext());
        }

        public int CompileToFile(string source)
        {
            CreateParser(source, out KtlynsParser parser, out KErrorListener errorListener);
            IParseTree tree = parser.program();

            if (DebugCompilation)
                PrettyPrint2(tree, parser);

            //if (errorListener.HasErrors)
            //    return -1;

            KParserVisitor visitor = new KParserVisitor();
            visitor.Visit(tree);
            KNode root = visitor.Root;

            //if (visitor.Errors.Count > 0)
            //{
            //    for (int i = 0; i < visitor.Errors.Count; i++) Console.WriteLine(visitor.Errors[i]);
            //    return -1;
            //}

            KLLVMGen compiler = new KLLVMGen() { LogIR = DebugCompilation };
            var module = compiler.CompileModule(root, visitor.GetIRGenContext());
            module.WriteBitcodeToFile("script.bc");
            Process.Start("cmd.exe", "/K llc script.bc -filetype=obj -march=x86");
            Process.Start("cmd.exe", "/K gcc script.obj");
            Process.Start("cmd.exe", "/K a.exe");
            //After printing the file, use
            //module.PrintToFile("script.ll");
            //llc script.bc -filetype=obj -march=x86
            //gcc script.obj
            //./a.out
            //Then an executable should have been created
            return 0;
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
