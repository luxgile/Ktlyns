using LLVMSharp.Interop;
using System;
using System.Collections.Generic;
using System.Linq;

namespace Kat
{
    /// <summary>
    /// Different types a field can be.
    /// </summary>
    public enum KPrimitiveType { Void, Int, Dec, Bool, Pointer, Array }
    public static class TypeTable
    {
        private static Dictionary<KPrimitiveType, LLVMTypeRef> typeTable = new();

        static TypeTable()
        {
            typeTable.Add(KPrimitiveType.Void, LLVMTypeRef.Void);
            typeTable.Add(KPrimitiveType.Int, LLVMTypeRef.Int32);
            typeTable.Add(KPrimitiveType.Dec, LLVMTypeRef.Double);
            typeTable.Add(KPrimitiveType.Bool, LLVMTypeRef.Int1);
            typeTable.Add(KPrimitiveType.Pointer, LLVMTypeRef.Int64);
        }

        public static LLVMTypeRef GetType(KPrimitiveType type) => typeTable[type];
        public static LLVMTypeRef GetType(string type) => typeTable[(KPrimitiveType)Enum.Parse(typeof(KPrimitiveType), type)];
        public static bool TryGetType(string type, out LLVMTypeRef value)
        {
            if (Enum.TryParse(typeof(KPrimitiveType), type, out object? valType))
                return typeTable.TryGetValue((KPrimitiveType)valType, out value);
            value = default;
            return false;
        }

        public static LLVMTypeRef CreateType(KId id, uint[] arrayLengths)
        {
            if (id.IdType != IdType.Type)
                throw new Exception("Id must be of type 'Type'");

            List<KPrimitiveType> typeList = GetTypeList(id.Name);
            //First type should always be the base type.
            int arrayLengthsIndex = 0;
            LLVMTypeRef lastTypeCreated = GetType(typeList[0]);
            for (int i = 1; i < typeList.Count; i++)
            {

                switch (typeList[i])
                {
                    case KPrimitiveType.Pointer:
                    lastTypeCreated = LLVMTypeRef.CreatePointer(lastTypeCreated, 0);
                    break;

                    case KPrimitiveType.Array:
                    lastTypeCreated = LLVMTypeRef.CreateArray(lastTypeCreated, arrayLengths.Length == 0 ? 1 : arrayLengths[arrayLengthsIndex]);
                    arrayLengthsIndex++;
                    break;
                }
            }

            return lastTypeCreated;
        }

        private static List<KPrimitiveType> GetTypeList(string typeName)
        {
            int baseTypeEndIndex = typeName.IndexOfAny(new char[] { '*', '[' });
            //Base type, no pointers nor arrays.
            if (baseTypeEndIndex == -1)
                return new List<KPrimitiveType>() { (KPrimitiveType)Enum.Parse(typeof(KPrimitiveType), typeName) };

            List<KPrimitiveType> typeList = new List<KPrimitiveType>();
            typeList.Add((KPrimitiveType)Enum.Parse(typeof(KPrimitiveType), typeName[0..baseTypeEndIndex]));
            while (baseTypeEndIndex < typeName.Length)
            {
                if (typeName[baseTypeEndIndex] == '*')
                    typeList.Add(KPrimitiveType.Pointer);
                else if (typeName[baseTypeEndIndex] == '[')
                {
                    typeList.Add(KPrimitiveType.Array);
                    //Consume ']'
                    baseTypeEndIndex++;
                }

                baseTypeEndIndex++;
            }
            return typeList;
        }

    }
}
