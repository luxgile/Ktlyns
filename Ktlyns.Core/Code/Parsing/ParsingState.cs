using System;
using System.Collections.Generic;
using System.Linq;

namespace Kat
{
    /// <summary>
    /// Type of ID: Field, Method or Type
    /// </summary>
    public enum IdType { Field, Method, Type, Class }
    public struct IdData : IEquatable<IdData>
    {
        public string name;
        public IdType type;
        public KTypeData typeData;
        public IdData(string id, IdType type, KTypeData typeData) : this()
        {
            name = id;
            this.type = type;
            this.typeData = typeData;
        }

        public bool Equals(IdData other) => name.Equals(other.name);
        public override bool Equals(object obj) => obj is IdData && Equals((IdData)obj);

        public override int GetHashCode() => HashCode.Combine(name);

        public static bool operator ==(IdData left, IdData right) => left.Equals(right);
        public static bool operator !=(IdData left, IdData right) => !(left == right);
    }
    public class IdPromise
    {
        public IdData Data { get; init; }
        public ParserException Exception { get; init; }
    }
    public class ParsingState
    {
        public class LocalScope
        {
            public HashSet<IdData> Locals { get; } = new HashSet<IdData>();

            public bool TryGetId(string id, out IdData data)
            {
                IdData tmp = new() { name = id };
                return Locals.TryGetValue(tmp, out data);
            }

            public void AddId(IdData idData)
            {
                Locals.Add(idData);
            }
        }

        private Stack<LocalScope> localStack = new Stack<LocalScope>();
        private List<IdPromise> promises = new List<IdPromise>();

        public CodeGenContext GenContext { get; private set; } = new CodeGenContext();
        public LocalScope CurrentScope => localStack.Peek();

        public ParsingState()
        {
            //Push global block.
            PushBlock();
        }


        public void PushBlock()
        {
            localStack.Push(new LocalScope());
        }

        public void PopBlock()
        {
            localStack.Pop();
        }

        public bool TryGetId(string id, out IdData idData)
        {
            foreach (var local in localStack)
            {
                if (local.TryGetId(id, out idData))
                    return true;
            }
            idData = default;
            return false;
        }

        public void AddId(string id, IdType type, KTypeData typeData)
        {
            IdData data = new IdData(id, type, typeData);
            RemovePromise(data);
            localStack.Peek().AddId(data);
        }

        public void AddPromise(string id, IdType type, KTypeData typeData, ParserException exception)
        {
            if (!TryGetId(id, out _))
                promises.Add(new IdPromise() { Data = new IdData(id, type, typeData), Exception = exception });
        }

        private void RemovePromise(IdData data)
        {
            for (int i = 0; i < promises.Count; i++)
            {
                if (promises[i].Data.Equals(data))
                {
                    promises.RemoveAt(i);
                    i--;
                }
            }
        }

        public ParserException[] ReportPromises()
        {
            return promises.Select(x => x.Exception).ToArray();
        }
    }
}
