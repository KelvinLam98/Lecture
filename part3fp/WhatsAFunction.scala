package lectures.part3fp

object WhatsAFunction extends App {

  // DREAM: use functions as first class elements
  // problem: oop

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }
  println(doubler(2))

  //function type = Function[A, B]
  val stringToIntConverter = new Function[String, Int] {
    override def apply(string: String): Int = string.toInt
  }
  println(stringToIntConverter("5")+doubler(2))

  //Function types Function2[A, B, R] == (A, B) => R
  val adder: ((Int,Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  //All scala functions are object

  def concatenator: (String, String) => String = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }
  println("Hello","Scala")

  //Funtion1[Int, Function1[Int, Int]
  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(v1: Int): Int => Int = new Function1[Int, Int] {
      override def apply(v2: Int): Int = v1 + v2
    }
  }
  val adder3 = superAdder(3)
  println(adder3(4))
  println(superAdder(3)(4))

}

trait MyFunction[A, B] {
  def apply(element: A): B
}

/*
    1. define a function which take 2 strings and concatenates them
    2. transform the MyPredicate and MyTransformer into function types
    3. define a function which takes an int and returns another function which
    take an int and returns an int
      - what's the type of this function
      -how to do it
 */


