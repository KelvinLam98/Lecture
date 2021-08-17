package lectures

object Functions extends App{

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  println(aParameterlessFunction)

  def aRepeatFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatFunction(aString, n-1)
  }

  println(aRepeatFunction("hello", 2))

  def aFunctionWithSideEffect(aString: String): Unit = println(aString)

  println(aFunctionWithSideEffect("Hello"))

  def aBigFunction(n: Int): Int ={
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)
  }
  println(aBigFunction(3))


}
