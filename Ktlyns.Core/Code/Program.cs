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
            string scriptFile = File.ReadAllText(@"D:\Development\K@\Ktlyns\script.k_at");
            KCompiler compiler = new KCompiler();
            int result = compiler.CompileAndRun(scriptFile);
            Console.WriteLine("Result: " + result);
        }
    }

}