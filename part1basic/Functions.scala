package lectures.part1basic

object Functions extends App{
//encourage write return type
  def aFunction(a: String, b: Int) = {
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

  def greeting(name: String, age: Int): String =
    "Hi, my name is " + name + " and I am " + age + " years old. "
    println(greeting("Kelvin", 21))

  def factorial(n: Int): Int =
    if (n <= 0) 1
    else n * factorial(n-1)
  println(factorial(5))

  def fibonacci(n: Int): Int =
    if (n <= 2) 1
    else fibonacci(n-1) + fibonacci(n-2)

  println(fibonacci(8))

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t<=1) true
      else n % t != 0 && isPrimeUntil(t = 1)

    isPrimeUntil(n/2)
  }
  println(isPrime(3))
  println(isPrime(30))
  println(isPrime(1237))

  def add(n: Int): Int = {
    def addition(x: Int, y: Int): Int = x + y
    addition(n, n*2)
  }
  println(add(3))
}
