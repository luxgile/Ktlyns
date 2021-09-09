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

        [Test]
        public void IfElse1()
        {
            int result = compiler.CompileAndRun("method<Int> Main() { Int c = 0; Bool a = true; if (a) { c = 1; } else { c = 2; } ret c; } ");
            Assert.AreEqual(1, result);
        }

        [Test]
        public void IfElse2()
        {
            int result = compiler.CompileAndRun("method<Int> Main() { Int c = 0; Bool a = false; if (a) { c = 1; } else { c = 2; } ret c; } ");
            Assert.AreEqual(2, result);
        }

        [Test]
        public void IfRet1()
        {
            int result = compiler.CompileAndRun("method<Int> Main() { Bool a = true; if (a) { ret 1; } ret 0; } ");
            Assert.AreEqual(1, result);
        }

        [Test]
        public void IfRet2()
        {
            int result = compiler.CompileAndRun("method<Int> Main() { Bool a = false; if (a) { ret 1; } else { ret 2; } ret 0; } ");
            Assert.AreEqual(2, result);
        }
    }
}
