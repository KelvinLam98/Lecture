package lectures.part2oop

object AbstractDataTypes extends App{

  /*
    trait
    1. can inherit multiple times
    2. can add trait to object
    3. do not contain any constructor
    4. do not have any implementation code
    5. stackable, super calls will be dynamically bound?
   */

  /*
    abstract class
    1. do not support multiple inherits
    2. do not allow to add to object
    3. can contain constructor
    4. can have implementation code
    5. not stackable, super calls are statically bound?
   */

  /*
      1. traits cannot have constructor
      2. multiple traits can inherit by the same class
      3. traits = behavior, abstract class = "thing"
   */

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
//  Display Output
//  val dog = new Dog
//  val croc = new Crocodile
//  croc.eat
//  croc.eat(dog)


  abstract class School {
    val studentType: String
    def study: Unit
  }

  class Primary extends School with Standard {
    override val studentType: String = "Primary Students"

    override def study: Unit = println(s"$studentType is study in primary school")

    def study(school: School): Unit = println(s"This $studentType is ${school.studentType}")

  }

  class StandardOne extends School {
    override val studentType: String = "Standard One Students "

    override def study: Unit = println(s"$studentType is learning addition of number")
  }

  trait Standard {
    def study(school: School): Unit
  }

  val primary = new Primary
  val standardOne = new StandardOne
  println(primary.studentType)
  primary.study
  primary.study(standardOne)


}
