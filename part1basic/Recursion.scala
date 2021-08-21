package lectures.part1basic

import scala.annotation.tailrec
import scala.jdk.Accumulator

object Recursion extends  App{

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)
      result
    }

  println(factorial(10))

  def anotherFactorial(n: Int): Int = {
    @tailrec
    def factHelper(x: Int, accumulator: Int): Int =
      if (x <= 1) accumulator
      else factHelper(x-1, x * accumulator) //For loop, TAIL RECURSIVE = use recursive call as the LAST expression

    factHelper(n,1)
  }

  println(anotherFactorial(10))

  def test(x: Int): Int = {
    @tailrec
    def testHelper(y: Int, z: Int): Int = {
      if (y <= 1) z
      else testHelper(y-1, y+z )
    }

    testHelper(x, 1)

  }
  println(test(8))

  /*
    anotherFactorial(10) = factHelper(10, 1)
    = factHelper(9,10 * 1)
    = factHelper(8,9 * 10 * 1)
    ...
    = factHelper(2, 3 * 4 * .. * 10 * 1)
    = factHelper(1, 2 * 3 * 4 * .. * 10 * 1)
   */

  @tailrec
  def concatenateTailrec(aString: String, n: Int, accumulator:String): String =
    if (n <= 0) accumulator
    else concatenateTailrec(aString, n-1, aString + accumulator)

  println(concatenateTailrec("hello ", 3, "bye"))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      if(!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t-1, n%t != 0 && isStillPrime)
    println(n/2)
    isPrimeTailrec(n/2, isStillPrime = true)

  }
  println(isPrime(2003))
  println(isPrime(30))

  def fibonacci (n: Int): Int = {
    def fiboTailRec(i: Int, last: Int, nextToLast: Int): Int =
      if (i >= n) last
      else fiboTailRec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fiboTailRec(2, 1,1)
  }

  println(fibonacci(2))
  println(fibonacci(8))

}


