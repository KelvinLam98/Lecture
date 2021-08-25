package lectures.part2oop

object Object extends App {

  object Person{
    //"static" level functionality
    val eyes= 2
    def fly: Boolean = false

    //factory method, use apply to make thing easier
    def apply(mother: Person, father: Person): Person = new Person("Bob")
  }

  class Person(val name: String) {
    //instance-level functionality
  }
  //object and class are companions

  println(Person.eyes)
  println(Person.fly)

  // Scala object is singleton instance
  val mary = Person
  val john = Person
  println(mary == john)
  //true because mary and john pointing to same instances

  val kel = new Person("Kelvin")
  val jim = new Person("Jimmy")
  println(kel == jim)
  //false because kel and jim are two different instances

  val bob = Person(kel, jim) //Person(kel, jim) or Person.apply(kel, jim) also can

  //Scala Application = Scala Object
  //def main(args: Array[String]): Unit but normally use extends App


}
