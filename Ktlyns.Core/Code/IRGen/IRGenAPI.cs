using LLVMSharp.Interop;
using System;

namespace Kat
{
    public static class IRGenAPI
    {
        public static bool DebugIR { get; set; } = false;

        public static LLVMValueRef Int32Zero { get; } = LLVMValueRef.CreateConstInt(LLVMTypeRef.Int32, 0, false);
        private static string MemCpyName { get; } = "llvm.memcpy.p0i8.p0i8.i64";
        private static LLVMValueRef MemCpyFn { get; set; }

        public static void GenDebugDefines(CodeGenContext context)
        {
            //LLVMTypeRef func = LLVMTypeRef.CreateFunction(LLVMTypeRef.Void, new LLVMTypeRef[] { });
            //context.module.AddFunction("llvm.dbg.addr", func);
        }

        public static void GenLLVMUtils(CodeGenContext context)
        {
            //LLVMTypeRef funcType = TypeTable.CreateFunctionType(KTypeData.VoidType,
            //    new KTypeData[]
            //    {
            //        KTypeData.CreatePointer(KTypeData.CreateInt(8)),
            //        KTypeData.CreatePointer(KTypeData.CreateInt(8)),
            //        KTypeData.CreateInt(64),
            //        KTypeData.BoolType,
            //    });
            //MemCpyFn = context.module.AddFunction(MemCpyName, funcType);

            KMthdDecl printfMth = new KMthdDecl(context, new KId("printf", IdType.Method, KTypeData.UndefinedType), false)
            {
                IsVaradic = true,
                Type = new KType(KTypeData.CreateInt(32)),
                Args = new() { new KVarDecl(context, new KId("c", IdType.Field, KTypeData.UndefinedType)) { Type = new KType(KTypeData.CreatePointer(KTypeData.CreateInt(8))) } },
            };
            printfMth.IRSetup(context);
            printfMth.Define(context);

            KMthdDecl customPrintfMth = new KMthdDecl(context, new KId("print", IdType.Method, KTypeData.UndefinedType), true)
            {
                Type = new KType(KTypeData.CreateInt(32)),
                Args = new() { new KVarDecl(context, new KId("c", IdType.Field, KTypeData.CreatePointer(KTypeData.CharType)) { PtrCount = 1 }) { Type = new KType(KTypeData.CreatePointer(KTypeData.CharType)) } },
                Block = new()
                {
                    Statements = new()
                    {
                        new KExprStmt() { Expr = new KRet(new KMethod(new KId("printf", IdType.Method, KTypeData.UndefinedType), new() 
                        { 
                            new KCustomExpr() { RhsGen = () => 
                            {
                                LLVMValueRef str = context.builder.BuildGlobalString("%ls\n");
                                return context.builder.BuildInBoundsGEP(str, new[] { Int32Zero, Int32Zero });
                            } }, new KCustomExpr() { LhsGen = () => context.CurrentFunc.Params[0], RhsGen = () => context.CurrentFunc.Params[0] } })) }
                    }
                }
            };
            customPrintfMth.IRSetup(context);
            customPrintfMth.Define(context);
            customPrintfMth.GenLhs(context);
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
            LLVMTypeRef pointerType = LLVMTypeRef.CreatePointer(value.TypeOf, 0);
            LLVMValueRef pointerValue = context.builder.BuildAlloca(pointerType, "tmp_ptr");
            context.builder.BuildStore(value, pointerValue);
            return context.builder.BuildLoad(pointerValue);
        }
        public static LLVMValueRef GetValueFromPointer(CodeGenContext context, LLVMValueRef pointer, string name)
        {
            return context.builder.BuildLoad(pointer, name + "_value");
        }

        public static LLVMValueRef StoreValue(CodeGenContext context, LLVMValueRef pointer, LLVMValueRef value)
        {
            LLVMTypeRef pointerType = pointer.TypeOf;
            if (pointerType.Kind != LLVMTypeKind.LLVMPointerTypeKind)
                throw new IrGenException("Pointer is needed to store a value.");
            return context.builder.BuildStore(value, pointer);
        }

        public static void CopyMemory(CodeGenContext context, LLVMValueRef dest, LLVMValueRef source, uint byteLength)
        {
            if (dest.TypeOf.Kind != LLVMTypeKind.LLVMPointerTypeKind || source.TypeOf.Kind != LLVMTypeKind.LLVMPointerTypeKind)
                throw new IrGenException("A and B need to be pointer types");

            context.builder.BuildCall(MemCpyFn, new LLVMValueRef[] { dest, source
                , LLVMValueRef.CreateConstInt(LLVMTypeRef.Int64, byteLength)
                , LLVMValueRef.CreateConstInt(KTypeData.BoolType.LLVMType, 0) });
        }
    }
}
