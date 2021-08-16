using System;
using System.Collections.Generic;
using System.Linq;

namespace Kat
{
    public enum IdType { Field, Method }
    public struct IdData : IEquatable<IdData>
    {
        public string name;
        public IdType type;
        public IdData(string id, IdType type) : this() { name = id; this.type = type; }

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
            private HashSet<IdData> locals = new HashSet<IdData>();

            public bool TryGetId(string id, out IdData data)
            {
                IdData tmp = new() { name = id };
                return locals.TryGetValue(tmp, out data);
            }

            public void AddId(IdData idData)
            {
                locals.Add(idData);
            }
        }

        private Stack<LocalScope> localStack = new Stack<LocalScope>();
        private List<IdPromise> promises = new List<IdPromise>();

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

        public void AddId(string id, IdType type)
        {
            IdData data = new IdData() { name = id, type = type };
            RemovePromise(data);
            localStack.Peek().AddId(data);
        }

        public void AddPromise(string id, IdType type, ParserException exception)
        {
            if (!TryGetId(id, out _))
                promises.Add(new IdPromise() { Data = new IdData() { name = id, type = type }, Exception = exception });
        }

        private void RemovePromise(IdData data)
        {
            for (int i = 0; i < promises.Count; i++)
            {
                if (promises[i].Data.Equals(data))
                {
                    promises.RemoveAt(i);
                    return;
                }
            }
        }

        public ParserException[] ReportPromises()
        {
            return promises.Select(x => x.Exception).ToArray();
        }
    }
}
