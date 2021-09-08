using NUnit.Framework;

namespace Kat.Tests
{
    public class IfTests
    {
        KCompiler compiler = new KCompiler();

        [Test]
        public void IfOnly()
        {
            int result = compiler.CompileAndRun("method<Int> Main() { Int c = 0; Bool a = true; if (a) { c = 1; } ret c; } ");
            Assert.AreEqual(1, result);
        }

        [Test]
        public void IfOnly2()
        {
            int result = compiler.CompileAndRun("method<Int> Main() { Int c = 0; Bool a = false; if (a) { c = 1; } ret c; } ");
            Assert.AreEqual(0, result);
        }
    }
}
