package lectures.part1basic

object StringOps extends App{

  val str: String = "Hello, I am learning Scala"

  println(str.charAt(0)) //first position
  println(str.charAt(1))
  println(str.charAt(2))
  println(str.charAt(3))
  println(str.charAt(4))

  println(str.substring(7,11)) //range 7 to 11 include space

  println(str.split(" ").toList)

  println(str.startsWith("Hello"))

  println(str.replace(" ", "-"))

  println(str.toUpperCase())

  println(str.length)

  println(str.reverse)

  println(str.take(2))

  val aNumberString = "21"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString:+ 'z')

  //s-interpolator
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old"
  val AnotherGreeting = s"Hello, my name is $name and I am ${age + 1} years old"
  println(greeting)
  println(AnotherGreeting)

  //f-interpolator
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  println(myth)

  //raw-interpolator
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  println(raw"$escaped")
}
