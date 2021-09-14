using LLVMSharp.Interop;
using System;
using System.Runtime.InteropServices;

namespace Kat
{
    [UnmanagedFunctionPointer(CallingConvention.Cdecl)]
    public delegate int MainDelegate();

    public class KLLVMGen
    {
        public bool LogIR { get; set; }

        public int CompileAndRun(KNode root, CodeGenContext context)
        {
            context.InitializeLLVMModules("main_source");
            try
            {
                foreach (var method in context.Methods)
                    method.Value.Define(context);
                root.GenLhs(context);
            }
            catch (Exception e) { Console.WriteLine($"Exception while generating IR: {e}"); return -1; }

            LLVM.LinkInMCJIT();

            LLVM.InitializeX86TargetMC();
            LLVM.InitializeX86Target();
            LLVM.InitializeX86TargetInfo();
            LLVM.InitializeX86AsmParser();
            LLVM.InitializeX86AsmPrinter();

            LLVMMCJITCompilerOptions options = new LLVMMCJITCompilerOptions { NoFramePointerElim = 1 };
            if (!context.module.TryCreateMCJITCompiler(out LLVMExecutionEngineRef engine, ref options, out string error))
            {
                Console.WriteLine($"Error: {error}");
                return -1;
            }

            if (LogIR)
            {
                Console.WriteLine("\n\n> IR CODE:\n----------");
                context.module.Dump();
            }

            LLVMValueRef func = context.module.GetNamedFunction("Main");
            MainDelegate mainFunc = (MainDelegate)Marshal.GetDelegateForFunctionPointer(engine.GetPointerToGlobal(func), typeof(MainDelegate));
            int a = -1;
            try
            {
                a = mainFunc();
            }
            catch (Exception e)
            {
                Console.WriteLine($"Program failed. Exception {e}");
            }

            context.builder.Dispose();
            engine.Dispose();

            return a;
        }
    }
}
