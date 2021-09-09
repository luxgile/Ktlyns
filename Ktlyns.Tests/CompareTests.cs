using NUnit.Framework;

namespace Kat.Tests
{
    public class CompareTests
    {
        private KCompiler compiler = new KCompiler();

        [Test]
        public void Equals()
        {
            int result = compiler.CompileAndRun(TestUtils.CreateSource("Bool a = 1 == 1; if(a) {ret 1;} ret 0;"));
            Assert.AreEqual(1, result);
        }

        [Test]
        public void NotEquals()
        {
            int result = compiler.CompileAndRun(TestUtils.CreateSource("Bool a = 1 != 2; if(a) {ret 1;} ret 0;"));
            Assert.AreEqual(1, result);
        }

        [Test]
        public void Less()
        {
            int result = compiler.CompileAndRun(TestUtils.CreateSource("Bool a = 1 < 2; if(a) {ret 1;} ret 0;"));
            Assert.AreEqual(1, result);
        }

        [Test]
        public void LessEquals1()
        {
            int result = compiler.CompileAndRun(TestUtils.CreateSource("Bool a = 1 <= 2; if(a) {ret 1;} ret 0;"));
            Assert.AreEqual(1, result);
        }

        [Test]
        public void LessEquals2()
        {
            int result = compiler.CompileAndRun(TestUtils.CreateSource("Bool a = 2 <= 2; if(a) {ret 1;} ret 0;"));
            Assert.AreEqual(1, result);
        }

        [Test]
        public void Great()
        {
            int result = compiler.CompileAndRun(TestUtils.CreateSource("Bool a = 3 > 2; if(a) {ret 1;} ret 0;"));
            Assert.AreEqual(1, result);
        }

        [Test]
        public void GreatEquals1()
        {
            int result = compiler.CompileAndRun(TestUtils.CreateSource("Bool a = 3 >= 2; if(a) {ret 1;} ret 0;"));
            Assert.AreEqual(1, result);
        }

        [Test]
        public void GreatEquals2()
        {
            int result = compiler.CompileAndRun(TestUtils.CreateSource("Bool a = 3 >= 3; if(a) {ret 1;} ret 0;"));
            Assert.AreEqual(1, result);
        }
    }
}
