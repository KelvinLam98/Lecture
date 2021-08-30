package lectures.part3fp

object HOFsCurries extends App {

  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n-1, f(x))

  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne,13,5))

  //println(nTimes(function, number of loop, value of x)
  val mul2 = (x: Int) => x * 2
  println(nTimes(mul2,10,5))

  def nTimesBetter(f: Int => Int, n: Int): (Int => Int)  =
    if (n <= 0) (x:Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))

  val add = nTimesBetter(plusOne, 10)
  println(add(2))

  val mul = nTimesBetter(mul2, 10)
  println(mul(1))

  def superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3)
  println(add3)
  println(superAdder)
  println(add3(10))
  println(superAdder(3)(10))

  def curriedFormatter(c: String)(x:Double): String = c.format(x)

  val standard: (Double => String) = curriedFormatter("%4.2f")
  val precise: (Double => String) = curriedFormatter("%10.8f")

  println(standard(Math.PI))
  println(precise(Math.PI))

  def toCurry(f: (Int, Int) => Int): (Int => Int => Int) =
    x => y => f(x,y)

  def fromCurry(f: (Int => Int => Int)): (Int, Int) => Int =
    (x,y) => f(x)(y)

  def compose[A,B,T](f: A => B, g: T => A): T => B =
    x => f(g(x))

  def compose2[A,B,C](f: A => B, g: B => C): A => C =
    x => g(f(x))

  def superAdder2: (Int => Int => Int) = toCurry(_ + _)
  def add4 = superAdder2(4)
  println(add4(17))

  val simpleAdder = fromCurry(superAdder)
  println(simpleAdder(4,17))

  val add2 = (x: Int) => x + 2
  val times3 = (x: Int) => x * 3

  val composed = compose(add2, times3)
  val ordered = compose2(add2, times3)

  println(composed(4))
  println(ordered(4))

}
