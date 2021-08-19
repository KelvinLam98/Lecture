package lectures.part2oop


object OObasic extends App {

  val person = new Person("John", 26)
  println(person.x)
  person.greet("Daniel")

  val author = new Writer("Kelvin", "Lam", 1998)
  val novel = new Novel("Jungle", 2021, author)

  println(novel.authorAge)
  println(author.fullname)
  println(novel.isWrittenBy(author))

  val counter = new Counter
  counter.increment.print
  counter.increment.increment.increment.print
  counter.decrement(5).print
}

//constructor
class Person(name: String , val age: Int) {
  val x = 21
  println(5)

  //method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  //overloading
  def greet(): Unit = println(s"Hi, I am $name")

  //multiple constructor
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}

/*
Novel and a Writer

Writer: first name, surname, year
  - method fullname
Novel: name, year of release, author
  - authorAge
  - isWrittenBy (author)
  - copy (new year of release = new instance of Novel
 */

class Writer(firstName: String, surname: String, val year: Int){
  def fullname: String = firstName + " " + surname
}

class Novel(name: String, year: Int, author: Writer){
  def authorAge: Int = year - author.year
  def isWrittenBy(author: Writer): Boolean = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)

}
/*
Counter class
  - receives an int value
  - method current count
  - method to increment/decrement => mew Counter
  - overload inc/dec to receive an amount
 */

class Counter(val count: Int = 0){
  def increment = {
    println("Increment")
    new Counter(count + 1)
  }

  def decrement = {
    println("Increment")
    new Counter(count - 1)
  }
  def increment(n: Int): Counter = {
    if (n<=0) this
    else increment.increment(n-1)
  }
  def decrement(n: Int): Counter = {
    if (n<=0) this
    else decrement.decrement(n-1)
  }
  def print = println(count)

}


