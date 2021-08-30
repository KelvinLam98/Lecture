package lectures.part4pm

import scala.util.Random

object PatternMatching extends App {

  //switch on steroids
  val random = new Random
  val x = random.nextInt(10)
  val description = x match {
    case 1 => "this ONE"
    case 2 => "double or nothing"
    case 3 => "third time is the charm"
    case _ => "something else"
    //make sure close with other case (wild card)
    //can accept all type of parameter here like string and int
  }
  println(x)
  println(description)

  // 1. Decompose values
  case class Person(name: String, age: Int)

  val bob = Person("bob", 20)
  val greeting = bob match {
    case Person(n, a) if a < 21 => s"$n is $a years old"
    case Person(n, a) => s"$n is $a years old"
    case _ => "Stranger"
  }
  println(greeting)

  // sealed hierarchies
  sealed class Animal

  case class Dog(breed: String) extends Animal

  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Terra Nova")
  animal match {
    case Dog(someBreed) => println(s"Matched a dog of the $someBreed breed")
  }

  //match evrything
  val isEven = x match {
    case n if n % 2 == 0 => true
    case _ => false
  }

  trait Expr

  case class Number(n: Int) extends Expr

  case class Sum(e1: Expr, e2: Expr) extends Expr

  case class Prod(e1: Expr, e2: Expr) extends Expr

  def show(e: Expr): String = e match {
    case Number(n) => s"$n"
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
    case Prod(e1, e2) => {
      def maybeShowParentheses(exp: Expr) = exp match {
        case Prod(_, _) => show(exp)
        case Number(_) => show(exp)
        case _ => "(" + show(exp) + ")"
      }
      maybeShowParentheses(e1) + " * " + maybeShowParentheses(e2)
    }
    case _ => "Nothing to show"
  }

  println(show(Sum(Number(2), Number(3))))
  println(show(Sum(Sum(Number(2), Number(3)), Number(4))))
  println(show(Prod(Sum(Number(2), Number(3)), Number(4))))
  println(show(Sum(Prod(Number(2), Number(3)), Number(4))))

}
