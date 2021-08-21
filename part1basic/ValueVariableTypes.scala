package lectures.part1basic

object ValueVariableTypes extends App{
  //val
  val x = 42
  println(x)

  // VAL ARE IMMUTABLE
  // COMPILER CAN INFER TYPES

  val aString: String = "hello"
  val anotherString = "goodbye"
  println(aString)
  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 10000
  val aLong: Long = 1000000000
  val aFloat: Float = 2.0456f
  val aDouble: Double = 3.12

  //variables
  var aVariable: Int = 21
  aVariable = 5 // side effects (not encourage)
}
