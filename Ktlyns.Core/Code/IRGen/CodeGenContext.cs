using LLVMSharp.Interop;
using System.Collections.Generic;

namespace Kat
{
    public class CodeGenContext
    {
        public LLVMBuilderRef builder;
        public LLVMModuleRef module;

        public Dictionary<string, KMthdDecl> Methods { get; } = new();
        public Dictionary<string, KVarDecl> Fields { get; } = new();
        public LLVMValueRef CurrentFunc { get; private set; }
        public LLVMBasicBlockRef CurrentLoopBlock { get; private set; }
        public LLVMBasicBlockRef ExitLoopBlock { get; private set; }
        public bool PathCompleted { get; set; }

        private Dictionary<string, LLVMValueRef> Locals { get; } = new();


        public void InitializeLLVMModules(string moduleName)
        {
            module = LLVMModuleRef.CreateWithName(moduleName);
            builder = LLVMBuilderRef.Create(module.Context);
        }

        public void SetFunc(LLVMValueRef func)
        {
            if (func.IsAFunction.IsNull)
                throw new System.Exception("LLVM Value passed is not a function");

            CurrentFunc = func;
        }

        public void ClearFunc()
        {
            CurrentFunc = default;
        }

        public void SetBlocks(LLVMBasicBlockRef current, LLVMBasicBlockRef next)
        {
            CurrentLoopBlock = current;
            ExitLoopBlock = next;
        }
        public void ClearBlocks()
        {
            CurrentLoopBlock = default;
            ExitLoopBlock = default;
        }

        public bool HasLocal(string name) => Locals.ContainsKey(name);
        public void AddLocal(string name, LLVMValueRef value) => Locals.Add(name, value);
        public void SetLocal(string name, LLVMValueRef value) => Locals[name] = value;
        public void RemoveLocal(string name) => Locals.Remove(name);
        public LLVMValueRef GetLocal(string name) => Locals[name];
    }
}
