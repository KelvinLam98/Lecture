package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 21){

    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    //question 1
    def +(nickname: String): Person = new Person(s"$name ($nickname)", favoriteMovie)
    def unary_! : String = s"$name, what the heck?!"
    //unary only allow + - ! ~
    //question 2
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    //question 4
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"
    //question 3
    def learns(thing: String) = s"$name is learning $thing"
    def learnScala = this learns "Scala"

  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary.likes("Insidious"))
  //infix notation = operator notation (syntactic sugar)


  //"operators" in Scala as '+' is function name
  val tom = new Person("Tom", "Fight Club")
  println(mary + mary)
  println(mary.+(tom))

  println(!mary)
  println(mary.unary_!)

  //postfix notation (without parameter)
  println(mary.isAlive)
  println(mary isAlive)

  //apply
  println(mary.apply())
  println(mary())

  /*
      1.  Overload the + operator
          mary + "the rockstar" => new person "Mary (the rockstar)"

      2.  Add an age to the Person class
          Add a unary + operator => new person with the age + 1
          +mary => mary with the age increment

      3.  Add a "learns" method in the Person class => "Mary learns Scala"
          Add a learnScala method, calls learns method with "Scala"
          Use it in postfix notation

      4.  Overload the apply method
          mary.apply(2) => "Mary watched Inception 2 times
   */

  println((mary + "the RockStar")())
  println((mary + "the RockStar").apply())

  println((+mary).age)
  println((mary.unary_+).age)

  println(mary learnScala)

  println(mary apply(2))
  println(mary(5))

}
