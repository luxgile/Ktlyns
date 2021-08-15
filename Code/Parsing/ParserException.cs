using System;

namespace Kat
{
    public class ParserException : System.Exception
    {
        public ParserException(uint id, string file, int line, int c, string msg) : base(msg)
        {
            Id = id;
            File = file ?? throw new ArgumentNullException(nameof(file));
            Line = line;
            Column = c;
        }

        public uint Id { get; init; }
        public string File { get; init; }
        public int Line { get; init; }
        public int Column { get; init; }

        public override string ToString()
        {
            return $"{File}({Line}:{Column}) - [KT{Id}]: {Message}";
        }
    }

    public static class ParseErrorLib
    {
        private static string temp_filename = "script.k_at";
        public static ParserException IdDeclared(string id, int line, int c) 
            => new(0, temp_filename, line, c, $"Identifier '{id}' has already been declared.");
        public static ParserException IdNotDeclared(string id, int line, int c) 
            => new(1, temp_filename, line, c, $"Identifier '{id}' is not defined.");
    }
}
