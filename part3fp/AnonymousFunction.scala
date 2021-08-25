package lectures.part3fp

object AnonymousFunction extends App {

  // anonymous function (LAMBDA)
  val doubler = (x: Int) => x * 2
  println(doubler(3))

  //MOAR syntactic sugar, each underscore equal to each parameter
  val add3: (Int, Int, Int) => Int = _ + _ + _ + 3
  println(add3(1,2,3))

  val mul3: (Int, Int, Int) => Int = (a,b,c) => a * b * c
  println(mul3(2,2,3))

  val emp = () => 3
  println(emp)    //cannot write like this when comes to lamda
  println(emp())

  //can also use curly braces
  val intConvert = { (str: String) =>
    str.toInt
  }
  println(intConvert(s"${doubler(5)}"))

}
