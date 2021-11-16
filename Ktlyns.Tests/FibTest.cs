using NUnit.Framework;

namespace Kat.Tests
{
    public class FibTest
    {
        private KCompiler compiler = new KCompiler();

        [Test]
        public void RunFib()
        {
            int result = compiler.CompileAndRun(
                @"
mth main() : Int
{
    ret fib(9);
}

mth fib(Int n) : Int
{
    if (n <= 1)
        ret n;
    ret fib(n - 1) + fib(n - 2);
}
                ");
            Assert.AreEqual(34, result);
        }
    }
}
