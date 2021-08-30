package lectures.part2oop

object CaseClasses extends App {

  /*
    equals, hashCode, toString
    for data object
   */

  case class Person(name: String, age: Int)

  //1. class parameters are fields
  //without case cannot
  val jim = new Person("Jim", 34)
  println(jim.name)

  //2. sensible toString
  //println(instance) = println(instance.toString)
  println(jim.toString)
  println(jim)

  //3. equals and hashCode implemented out of the box (OOTB)
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  //4. copy method
  val jim3 = jim.copy(age=21)
  println(jim3)

  //5. case classes have companion object (create automatically)
  val thePerson = Person
  val mary = Person("Mary", 25)
  val kel = Person.apply("kel", 21)

  //6. case classes are serializable (distribute system)

  //7. case classes have extractor patterns = use in PATTERN MATCHING (will learn later)

  case object UK {
    def name: String = "The UK of GB and NI"
  } //not important

}
