using LLVMSharp.Interop;
using System;
using System.Collections.Generic;
using System.Linq;

namespace Kat
{
    public record KTypeData(string Name, KPrimitiveType InternalType, uint Length, KTypeData SubType, LLVMTypeRef LLVMType)
    {
        public bool HasSubType => SubType != null;
        public static KTypeData VoidType { get; } = new KTypeData("Void", KPrimitiveType.Void, 0, null, LLVMTypeRef.Void);
        public static KTypeData DecType { get; } = new KTypeData("Dec", KPrimitiveType.Dec, 1, null, LLVMTypeRef.Double);
        public static KTypeData IntType { get; } = new KTypeData("Int", KPrimitiveType.Int, 1, null, LLVMTypeRef.Int32);
        public static KTypeData BoolType { get; } = new KTypeData("Bool", KPrimitiveType.Bool, 1, null, LLVMTypeRef.Int1);
        public static KTypeData CharType { get; } = new KTypeData("Char", KPrimitiveType.Char, 1, null, LLVMTypeRef.Int16);
        public static KTypeData MetaType { get; } = new KTypeData("Type", KPrimitiveType.Type, 1, null, LLVMTypeRef.Void);
        public static KTypeData UndefinedType { get; } = new KTypeData("Undefined", KPrimitiveType.Void, 0, null, LLVMTypeRef.Void);

        public static KTypeData CreateArray(KTypeData type, uint length) => new(type.Name + "[]", KPrimitiveType.Compound, length, type
            , LLVMTypeRef.CreateArray(type.LLVMType, length));
        public static KTypeData CreatePointer(KTypeData type) => new(type.Name + "*", KPrimitiveType.Pointer, 1, type
            , LLVMTypeRef.CreatePointer(type.LLVMType, 0));
        public static KTypeData CreateString(uint length) => new("String", KPrimitiveType.String, length, null
            , LLVMTypeRef.CreateArray(CharType.LLVMType, length));
        public static KTypeData CreateInt(uint bits) => new("Int" + bits, KPrimitiveType.Int, 1, null, LLVMTypeRef.CreateInt(bits));
    }

    /// <summary>
    /// Different types a field can be.
    /// </summary>
    public enum KPrimitiveType { Void, Int, Dec, Bool, Char, String, Pointer, Compound, Type }
    public static class TypeTable
    {
        private static Dictionary<KPrimitiveType, KTypeData> typeTable = new();

        static TypeTable()
        {
            typeTable.Add(KPrimitiveType.Void, KTypeData.VoidType);
            typeTable.Add(KPrimitiveType.Int, KTypeData.IntType);
            typeTable.Add(KPrimitiveType.Dec, KTypeData.DecType);
            typeTable.Add(KPrimitiveType.Char, KTypeData.CharType);
            typeTable.Add(KPrimitiveType.Bool, KTypeData.BoolType);
        }

        public static KTypeData GetType(KPrimitiveType type) => typeTable[type];
        public static KTypeData GetType(string type) => typeTable[(KPrimitiveType)Enum.Parse(typeof(KPrimitiveType), type)];
        public static bool TryGetType(string type, out KTypeData value)
        {
            if (Enum.TryParse(typeof(KPrimitiveType), type, out object? valType))
                return typeTable.TryGetValue((KPrimitiveType)valType, out value);
            value = default;
            return false;
        }

        public static LLVMTypeRef CreateFunctionType(KTypeData returnType, bool varadic, params KTypeData[] paramTypes)
        {
            LLVMTypeRef retTypeRef = returnType.LLVMType;
            LLVMTypeRef[] paramTypeRefs = new LLVMTypeRef[paramTypes.Length];
            for (int i = 0; i < paramTypes.Length; i++)
                paramTypeRefs[i] = paramTypes[i].LLVMType;
            return LLVMTypeRef.CreateFunction(retTypeRef, paramTypeRefs, varadic);
        }

        public static KTypeData CreateTypeFromName(string name, KTypeData assignment)
        {
            List<KPrimitiveType> typeList = GetTypeList(name);
            //First type should always be the base type.
            if (typeList[0] == KPrimitiveType.String)
                return KTypeData.CreateString(assignment.Length);

            KTypeData lastTypeCreated = GetType(typeList[0]);
            KTypeData currentAssign = assignment;
            for (int i = 1; i < typeList.Count; i++)
            {
                switch (typeList[i])
                {
                    case KPrimitiveType.Pointer:
                        lastTypeCreated = KTypeData.CreatePointer(lastTypeCreated);
                        break;

                    case KPrimitiveType.Compound:
                        lastTypeCreated = KTypeData.CreateArray(lastTypeCreated, currentAssign.Length);
                        currentAssign = currentAssign.SubType;
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
                    typeList.Add(KPrimitiveType.Compound);
                    //Consume ']'
                    baseTypeEndIndex++;
                }

                baseTypeEndIndex++;
            }
            return typeList;
        }

    }
}
