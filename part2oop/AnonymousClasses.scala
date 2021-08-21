package lectures.part2oop
//???
object AnonymousClasses extends App {

  trait Animal {
    def eat: Unit = "animal eat"
  }

  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("haha")
  }

  println(funnyAnimal.getClass)
  funnyAnimal.eat

  /*
      equivalent with

      class AnonymousClasses$$anon$1 extends Animal{
        override def eat: Unit = println("haha")
        }

      val funnyAnimal: Animal = new AnonymousClasses$$anon$1
   */

  class Person(name: String){
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help you")
  }

  val jim = new Person("Jim"){
    override def sayHi: Unit = println(s"Hi, Jim here")
  }

}
