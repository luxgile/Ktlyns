using NUnit.Framework;

namespace Kat.Tests
{
    public class DecMathTests
    {
        KCompiler compiler = new KCompiler();

        [Test]
        public void Add()
        {
            int result = compiler.CompileAndRun(TestUtils.CreateSource("Dec a = 5.1 + 4.3; if(a > 9.3 && a < 9.5) {ret 1;} ret 0;"));
            Assert.AreEqual(1, result);
        }

        [Test]
        public void Substract()
        {
            int result = compiler.CompileAndRun(TestUtils.CreateSource("Dec a = 5.1 - 4.3; if(a > 0.7 && a < 0.9) {ret 1;} ret 0;"));
            Assert.AreEqual(1, result);
        }

        [Test]
        public void Multiply()
        {
            int result = compiler.CompileAndRun(TestUtils.CreateSource("Dec a = 2.5 * 4.0; if(a > 9.9 && a < 10.1) {ret 1;} ret 0;"));
            Assert.AreEqual(1, result);
        }

        [Test]
        public void Divide()
        {
            int result = compiler.CompileAndRun(TestUtils.CreateSource("Dec a = 9.0 / 2.0; if(a > 4.4 && a < 4.6) {ret 1;} ret 0;"));
            Assert.AreEqual(1, result);
        }
    }
}