using LLVMSharp.Interop;

namespace Kat
{
    public static class IRGenAPI
    {
        public static bool DebugIR { get; set; } = true;

        public static void GenDebugDefines(CodeGenContext context)
        {
            LLVMTypeRef func = LLVMTypeRef.CreateFunction(LLVMTypeRef.Void, new LLVMTypeRef[] { });
            context.module.AddFunction("llvm.dbg.addr", func);
        }

        /// <summary>
        /// Allocates a field of the specified type and returns a pointer of the allocated field.
        /// </summary>
        public static LLVMValueRef AllocateField(CodeGenContext context, LLVMTypeRef fieldType, string name)
        {
            if (fieldType.ArrayLength > 0)
            {
                return context.builder.BuildArrayAlloca(fieldType, default, name);
                //TODO: Autodefine default value for the array based in assignment
            }
            else
            {
                //This creates an empty pointer of predefined type.
                LLVMValueRef value = context.builder.BuildAlloca(fieldType, name);
                return value;
            }
        }

        public static LLVMValueRef CreatePointerFromValue(CodeGenContext context, LLVMValueRef value)
        {
            LLVMTypeRef pointerType = LLVMTypeRef.CreatePointer(value.TypeOf.ElementType, 0);
            LLVMValueRef pointerValue = context.builder.BuildAlloca(pointerType, "tmp_ptr");
            context.builder.BuildStore(value, pointerValue);
            return context.builder.BuildLoad(pointerValue);
        }
        public static LLVMValueRef GetValueFromPointer(CodeGenContext context, LLVMValueRef pointer, string name)
        {
            return context.builder.BuildLoad(pointer, name + "_value");
        }
    }
}
