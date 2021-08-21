package lectures.part1basic

object Expressions extends App{

  val x = 2 + 2 //expression
  println(x)
  val xIsEven = x % 2 == 0
  println(xIsEven)
  val xIsOdd = !xIsEven
  println(xIsOdd)

  println(2 + 3 - 4)
  // + - * / & | ^ << >> >>>

  println(1 == x)
  // == != > >= < <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3
  //-= *= /= and so on
  println(aVariable)

  //Instructions (DO) vs Expressions (value)

  // IF expression
  //val aCondition = true
  val aConditionValue = if(x > 3) "x is more than 3" else "x is less than or equal 3"
  println(aConditionValue)
  println(if(x == 3 )"x is equal to 3" else "x is not equal to 3")

  //do not use this method again
  var i = 0
  while (i < 10){
    println(i)
    i += 1
  }

  //val aWeirdValue: Unit
  val aWeirdValue = (aVariable = 3)
  print(aWeirdValue)

  //side effects: println(), whiles, reassigning of Vars

  //Code Blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "goodbye"
  }
  println(aCodeBlock)
  
}
