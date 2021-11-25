using System.Runtime.InteropServices;
using System;
using System.IO;
using System.Runtime.CompilerServices;
using System.Reflection;
using System.Diagnostics;

namespace Kat
{
    internal sealed class Program
    {
        private static unsafe void Main(string[] args)
        {
            if (Debugger.IsAttached)
            {
                Console.WriteLine("Running from IDE, overriding arguments.");
                args = new string[] { "run", "../../../script1.k_at" };
            }

            if (args.Length == 0)
                PrintHelp();
            else
            {
                DoCommand(args[0], args[1..]);
            }

            if (Debugger.IsAttached)
                Console.ReadKey();
        }

        private static void PrintHelp()
        {
            Console.WriteLine("Write 'build <filenames>' to compile a group of files.");
        }

        private static void PrintVersion()
        {
            Console.WriteLine("Ktlyns version: 0.1.1");
        }

        private static void DoCommand(string cmd, string[] args)
        {
            if (args.Length > 0)
            {
                if (cmd == "build")
                {
                    string scriptFile = File.ReadAllText(args[0]);
                    KCompiler compiler = new KCompiler() { PrintIR = true };
                    int result = compiler.CompileToFile(scriptFile);
                    Console.WriteLine("Program result: " + result);
                }
                if (cmd == "run")
                {
                    string source = null;
                    for (int i = 0; i < args.Length; i++)
                        source += File.ReadAllText(args[i]) + "\n";
                    KCompiler compiler = new KCompiler() { PrintIR = true, PrintParseTree = false};
                    int result = compiler.CompileAndRun(source);
                    Console.WriteLine("Program result: " + result);
                }
            }
            else
            {
                if (cmd == "help")
                    PrintHelp();
                else if (cmd == "version")
                    PrintVersion();
                else
                {
                    Console.WriteLine($"Command {cmd} is not recognized. Use 'help' to get a list of available commands.");
                }
            }
        }
    }
}