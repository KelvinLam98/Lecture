package lectures.part2oop

object Exceptions extends App {

//  val x: String = null
//  x.length
//  //  println(x.length) this line crash with a noPointerExceptions
//  //1. throw exceptions
//  val y = throw new NullPointerException

  //  throwable classes extends the throwable class
  //  exception and error are the major throwable subtypes

  //2. catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you")
    else 1

  val potFail = try {
    getInt(false) //change true for error
  } catch {
    case e: NullPointerException => println("caught a runtime exceptions")
  } finally {
    //finally will executed no matter what
    //optional
    //does not influence the return type of this expression
    //use finally only for side effects
    println("final")
  }

  //3. how to define your own exceptions
//  class MyException extends Exception
//  val exception = new MyException
//
//  throw exception

  /*
    1. crash with out of memory error
    2. crash with stack overflow error
    3. pocket calculator - add, subtract, multiply, divide

      throw
        - OverflowException
        - UnderflowException
        - MathCalException
   */

//  val array = Array.ofDim(Int.MaxValue)
//  def infinite: Int = 1+infinite
//  val noLimit = infinite
  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCal {
    def add(x: Int, y: Int) = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def sub(x: Int, y: Int) = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def mul(x: Int, y: Int) = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def div(x: Int, y: Int) = {
      if (y == 0) throw new MathCalculationException
      else x/y
    }
  }

//  println(PocketCal.add(Int.MaxValue, 10))
  println(PocketCal.div(2, 0))

}
