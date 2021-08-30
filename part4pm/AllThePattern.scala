package lectures.part4pm

import exercises.{Cons, Empty, MyList}

object AllThePattern extends App {
  //constant
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "a number"
    case "Scala" => "THE Scala"
    case true => "The Truth"
    case AllThePattern => "A singleton object"
  }

  val matchAnything = x match {
    case _ =>
  }
  //variable
  val matchVariable = x match {
    case something => s"I've found $something"
  }
  //tuple
  val aTuple = (1,2)
  val matchATuple = aTuple match {
    case (1,1) =>
    case (something, 2) => s"I've found $something"
  }
  //can be nested
  val nestedTuple = (1,(2,3))
  val matchNestedTuple = nestedTuple match {
    case (_, (2, v)) =>
  }
  //case classes - constructor pattern
  val aList: MyList[Int] = Cons(1, Cons(2, Empty))
  val matchAList = aList match {
    case Empty =>
    case Cons(head, Cons(subhead, subtail)) =>
  }
  //list patterns
  val aStandardList = List(1,2,3,4)
  val aStandardListMatching = aStandardList match {
    case List (1, _, _, _) => //extractor - advanced
    case List (1, _*) => // list of arbitrary length - advanced
    case 1 :: List (_) => //infix pattern
    case List(1,2,3) :+ 42 => //infix pattern
  }
  //type specifiers
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] =>
    case _ =>
  }

  //name binding
  val nameBindingMatch = aList match {
    case nonEmptyList @ Cons(_, _) =>
    case Cons(1, rest @ Cons(2, _)) =>
  }

  //multi pattern
  val multiPattern = aList match {
    case Empty | Cons(0,1) =>
  }

  //if guards
  val secondElementSpecial = aList match {
    case Cons(_, Cons(specialElement, _)) if specialElement % 2 == 0 =>
  }

  val numbers = List(1,2,3)
  val numberMatch = numbers match {
    case listOfString :List[String] => "a list of strings"
    case listOfNumbers: List[Int] => "a list of numbers"
    case _ => ""
  }
  println(numberMatch)

}
