package lectures.part1basic

object Call extends App{
  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())
  calledByName{
    System.nanoTime()+10
  }

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  printFirst(34, infinite())

}
