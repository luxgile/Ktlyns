using System.Runtime.InteropServices;
using System;
using System.IO;
using System.Runtime.CompilerServices;

namespace Kat
{
    internal sealed class Program
    {
        [DllImport("katime.dll")]
        public unsafe static extern void PrintString(char* a);


        private static unsafe void Main(string[] args)
        {
            // char[] c = "Hello World".ToCharArray();
            // fixed (char* a = c)
            // {
            //     PrintString(a);
            //     PrintString(a);
            // }

            string scriptFile = File.ReadAllText(@"D:\Development\K@\Ktlyns\Ktlyns.Core\script.k_at");
            KCompiler compiler = new KCompiler() { DebugCompilation = true };
            //int result = compiler.CompileAndRun(scriptFile);
            int result = compiler.CompileToFile(scriptFile);
            Console.WriteLine("Program result: " + result);
        }
    }
}