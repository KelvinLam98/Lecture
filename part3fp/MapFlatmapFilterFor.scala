package lectures.part3fp

object MapFlatmapFilterFor extends  App {

  val list = List(1,2,3)

  println(list.head)
  println(list.tail)

  println(list.map(_ + 1))
  println(list.map(_ +  " is a number"))

  println(list.filter(_ % 2 != 0 ))

  val toPair = (x: Int)=> List(x, x*2)
  println(list.flatMap(toPair))

  val numbers = List(1,2,3,4)
  val chars = List('a','b','c','d')
  val colors = List("Black", "White")

  val combinations = numbers.flatMap(n => chars.map(c=> "" + c + n + "-" + colors))
  println(combinations)

  list.foreach(println)

  val forCombinations = for {
    n <- numbers if n % 2 == 0
    c <- chars if c == 'a'
    color <- colors
  } yield "" + c + n + "-" + color
  println(list)
  println(forCombinations)

  for {
    n <- numbers
  }println(n)

  list.map { x =>
    x * 2
  }


}
