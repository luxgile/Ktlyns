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
method<Int> Main()
{
    ret Fib(9);
}

method<Int> Fib(Int n)
{
    if (n <= 1)
        ret n;
    ret Fib(n - 1) + Fib(n - 2);
}
                ");
            Assert.AreEqual(34, result);
        }
    }
}
