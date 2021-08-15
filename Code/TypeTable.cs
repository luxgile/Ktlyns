using LLVMSharp.Interop;
using System.Collections.Generic;

namespace Kat
{
    public static class TypeTable
    {
        private static Dictionary<string, LLVMTypeRef> typeTable = new();

        static TypeTable()
        {
            typeTable.Add("Void", LLVMTypeRef.Void);
            typeTable.Add("Int", LLVMTypeRef.Int32);
            typeTable.Add("Dec", LLVMTypeRef.Int32);
        }

        public static LLVMTypeRef GetType(string type) => typeTable[type];
    }
}
