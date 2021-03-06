namespace Kat.Tests
{
    public class TestUtils
    {
        private const string Source = "mth main() : Int { #CODE# }";
        /// <summary>
        /// Creates a main method with the source specified inside the method.
        /// </summary>
        public static string CreateSource(string source) => Source.Replace("#CODE#", source);
    }
}
