using NUnit.Framework;

namespace Kat.Tests
{
    public class PointerTests
    {
        KCompiler compiler = new KCompiler();


        [Test]
        public void PointerDeclaration()
        {
            int result = compiler.CompileAndRun(TestUtils.CreateSource("Int a = 3; Int* aptr = &a; ret a;"));
            Assert.AreEqual(3, result);
        }

        [Test]
        public void PointerAssigment()
        {
            int result = compiler.CompileAndRun(TestUtils.CreateSource("Int a = 3; Int* aptr = &a; *aptr = 2; ret a;"));
            Assert.AreEqual(2, result);
        }

        [Test]
        public void PointerDerreference()
        {
            int result = compiler.CompileAndRun(TestUtils.CreateSource("Int a = 3; Int* aptr = &a; *aptr = *aptr + 1; ret a;"));
            Assert.AreEqual(4, result);
        }
    }
}
