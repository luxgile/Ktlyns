using LLVMSharp.Interop;
using System;
using System.Collections.Generic;

namespace Kat
{
    public enum KValType { Void, Int, Dec, Bool }
    public enum KIdType { Regular, Pointer, Array }
    public static class TypeTable
    {
        private static Dictionary<KValType, LLVMTypeRef> typeTable = new();

        static TypeTable()
        {
            typeTable.Add(KValType.Void, LLVMTypeRef.Void);
            typeTable.Add(KValType.Int, LLVMTypeRef.Int32);
            typeTable.Add(KValType.Dec, LLVMTypeRef.Double);
            typeTable.Add(KValType.Bool, LLVMTypeRef.Int1);
        }

        public static LLVMTypeRef GetType(KValType type) => typeTable[type];
        public static LLVMTypeRef GetType(string type) => typeTable[(KValType)Enum.Parse(typeof(KValType), type)];
        public static bool TryGetType(string type, out LLVMTypeRef value)
        {
            if (Enum.TryParse(typeof(KValType), type, out object? valType))
                return typeTable.TryGetValue((KValType)valType, out value);
            value = default;
            return false;
        }
    }
}
