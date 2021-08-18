using LLVMSharp.Interop;
using System.Collections.Generic;

namespace Kat
{
    public class CodeGenContext
    {
        public Stack<LLVMBasicBlockRef> blocks = new();
        public LLVMBuilderRef builder;
        public LLVMModuleRef module;

        private Dictionary<string, LLVMValueRef> Locals { get; } = new();

        public CodeGenContext(string name)
        {
            module = LLVMModuleRef.CreateWithName(name);
            builder = LLVMBuilderRef.Create(module.Context);
        }

        public bool HasLocal(string name) => Locals.ContainsKey(name);
        public void AddLocal(string name, LLVMValueRef value) => Locals.Add(name, value);
        public void SetLocal(string name, LLVMValueRef value) => Locals[name] = value;
        public void RemoveLocal(string name) => Locals.Remove(name);
        public LLVMValueRef GetLocal(string name) => Locals[name];
    }
}
