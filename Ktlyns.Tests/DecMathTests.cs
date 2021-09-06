using NUnit.Framework;

namespace Kat.Tests
{
    public class DecMathTests
    {
        KCompiler compiler = new KCompiler();

        [Test]
        public void Add()
        {
            int result = compiler.CompileAndRun("method<Int> Main() { ret 5.0 + 4.0; } ");
            Assert.AreEqual(9, result);
        }

        //[Test]
        //public void Substract()
        //{
        //    //Won't compile as keys from last test are not being reset.
        //    int result = compiler.CompileAndRun("method<Int> Main() { ret 12 - 4; } ");
        //    Assert.AreEqual(8, result);
        //}

        //[Test]
        //public void Multiply()
        //{
        //    //Won't compile as keys from last test are not being reset.
        //    int result = compiler.CompileAndRun("method<Int> Main() { ret 4 * 4; } ");
        //    Assert.AreEqual(16, result);
        //}

        //[Test]
        //public void Divide()
        //{
        //    //Won't compile as keys from last test are not being reset.
        //    int result = compiler.CompileAndRun("method<Int> Main() { ret 8 / 2; } ");
        //    Assert.AreEqual(4, result);
        //}
    }
}