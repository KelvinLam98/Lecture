package lectures.part4pm

object PatternsEverywhere extends App {

  try {
    //code
  } catch {
    case e: RuntimeException => "runtime"
    case npe: NullPointerException => "npe"
    case _ => "something else"
  }

  val list = List(1, 2, 3, 4)
  val evenOnes = for {
    x <- list if x % 2 == 0
  } yield 10 * x

  val tuples = List((1, 2), (3, 4))
  val filterTuples = for {
    (first, second) <- tuples
  } yield first * second

  val tuple = (1, 2, 3)
  val (a, b, c) = tuple
  println(b)

  val head :: tail = list
  println(head)
  println(tail)

  val mappedList = list.map {
    case v if v % 2 == 0 => v + " is even"
    case 1 => " the one"
    case _ => "something else"
  }

  val mappedList2 = list.map { x => x match {
      case v if v % 2 == 0 => v + "is even"
      case 1 => "the one"
      case _ => "something else"
    }
  }
  println(mappedList)
}
