using LLVMSharp.Interop;

namespace Kat
{
    public static class IRGenAPI
    {
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
                return context.builder.BuildAlloca(fieldType, name);
            }
        }

        public static LLVMValueRef CreatePointerFromValue(CodeGenContext context, LLVMValueRef value)
        {
            var pointerType = LLVMTypeRef.CreatePointer(value.TypeOf.ElementType, 0);
            var pointerValue = context.builder.BuildAlloca(pointerType, "tmp_ptr");
            context.builder.BuildStore(value, pointerValue);
            return context.builder.BuildLoad(pointerValue);
        }
        public static LLVMValueRef GetValueFromPointer(CodeGenContext context, LLVMValueRef pointer, string name)
        {
            return context.builder.BuildLoad(pointer, name + "_value");
        }
    }
}
