package lectures.part2oop

object Generics extends App {

  class MyList[+A]{
    //use the type A
    def add[B >: A ](element: B): MyList[B] = ???
  }
  class MyMap[Key, Value]
  val listOfIntegers = new MyList[Int]
  val listOfString = new MyList[String]

  //generic method
  object MyList {
    def empty[A]: MyList[A] = ???

  }
  val emptyListOfIntegers = MyList.empty[Int]

  //variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  //Yes, List[Cat] extendss List [Animal] = COVARIANT
  //Class Animal is used by Class Cat
  class CovariantList[+A]
  val animal:Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  //No, INVARIANT LIST
  class InvariantList[A]
  val invariantList: InvariantList[Animal] = new InvariantList[Animal]

  //Hell, no , CONTRAVARIANT
  //opposite of COVARIANT
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  //bound types
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)
  /*
    class Cage
  val cage = new Cage(new Dog)
   */
}
