package lectures.part2oop

object Inheritance extends App {
  //add final in front of super class to :-
  //limit the override from the subclasses(e.g: final class Animal)

  //add final in front of method (e.g: final def eat)

  //seal the class to prevent extension in other files (e.g: sealed class Animal)
  class Animal {
    val creatureType = "wild"
    def eat = println("eating...")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("cat eat")
    }
  }

  val cat = new Cat
  cat.crunch

  //constructor
  class Person(name: String, age: Int){
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int) extends Person(name, age){
    def test = println(name + " is " + age + " years old")
  }
  val adult = new Adult("Jacky", 22)
  adult.test

  //overriding
  class Dog extends Animal {
    //super is used to call the function in super class(parent)
    super.eat
    //override val creatureType: String = "dog is domestic"
    override def eat = println("dog eat")
  }
  val dog= new Dog
  dog.eat
  println(dog.creatureType)

  class Shark(override val creatureType: String) extends Animal {
    override def eat = println(s"Shark eat")
  }
  //type substitution
  val unknownAnimal: Animal = new Shark("K9")
  unknownAnimal.eat



}
