using LLVMSharp.Interop;
using System.Collections.Generic;
using System.Linq;

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
        private List<Dictionary<string, LLVMValueRef>> Locals { get; } = new();
        private Dictionary<string, LLVMValueRef> CurrentLocals => Locals[^1];

        public CodeGenContext()
        {
            Locals.Add(new Dictionary<string, LLVMValueRef>());
        }
        
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


        public void AddLocalBlock() => Locals.Add(new Dictionary<string, LLVMValueRef>());
        public void RemoveLocalBlock() => Locals.RemoveAt(Locals.Count - 1);
        public bool HasLocal(string name) => Locals.Any(t=> t.ContainsKey((name)));

        public void AddLocal(string name, LLVMValueRef value) => CurrentLocals.Add(name, value);

        public void SetLocal(string name, LLVMValueRef value) => CurrentLocals[name] = value;
        public void RemoveLocal(string name) => CurrentLocals.Remove(name);
        public LLVMValueRef GetLocal(string name)
        {
            foreach (var t in Locals)
            {
                if (t.TryGetValue(name, out LLVMValueRef value))
                    return value;
            }

            throw new IrGenException($"No local was found with name {name}");
        }
    }
}
