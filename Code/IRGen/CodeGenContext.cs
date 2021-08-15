using LLVMSharp.Interop;
using System.Collections.Generic;

namespace Kat
{
    public class CodeGenContext
    {
        public Stack<LLVMBasicBlockRef> blocks = new();
        public Dictionary<string, LLVMValueRef> locals = new();
        public LLVMBuilderRef builder;
        public LLVMModuleRef module;

        public CodeGenContext(string name)
        {
            module = LLVMModuleRef.CreateWithName(name);
            builder = LLVMBuilderRef.Create(module.Context);
        }
    }
}
