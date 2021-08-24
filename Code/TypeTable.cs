using LLVMSharp.Interop;
using System;
using System.Collections.Generic;

namespace Kat
{
    public enum KValType { Void, Int, Dec, Pointer }
    public static class TypeTable
    {
        private static Dictionary<KValType, LLVMTypeRef> typeTable = new();

        static TypeTable()
        {
            typeTable.Add(KValType.Void, LLVMTypeRef.Void);
            typeTable.Add(KValType.Int, LLVMTypeRef.Int32);
            typeTable.Add(KValType.Dec, LLVMTypeRef.Double);
        }

        public static LLVMTypeRef GetType(KValType type) => typeTable[type];
        public static LLVMTypeRef GetType(string type) => typeTable[(KValType)Enum.Parse(typeof(KValType), type)];
    }
}
