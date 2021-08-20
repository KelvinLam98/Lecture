package lectures.part2oop

object AbstractDataTypes extends App{

  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "dog"
    def eat: Unit = println("Dog eat")
  }

  trait ColdBlooded

  trait Carnivore{
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    val creatureType: String = "croc"
    def eat: Unit = println("croc eat")
    def eat(animal: Animal) :Unit = println(s"Croc eat ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat
  croc.eat(dog)

  /*
      1. traits cannot have constructor
      2. multiple traits can inherit by the same class
      3. traits = behavior, abstract class = "thing"
   */


}
