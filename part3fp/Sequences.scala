package lectures.part3fp

import javafx.print.Collation

import scala.reflect.internal.util.Collections
import scala.util.Random

object Sequences extends App {

  //seq
  val aSequence= Seq(1,2,3,4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(7,5,6))
  println(aSequence.sorted)

  //range
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  (1 to 10).foreach(x => println("Hello"))

  //list
  val aList = List(1,2,3)
  val prepended = 42 +: aList :+ 89
  println(prepended)

  val apple5 = List.fill(5)("apple")
  println(apple5)
  println(aList.mkString("-|-"))

  //array
  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[String](3)
  threeElements.foreach(println)

  //mutation
  numbers(2) = 0
  threeElements(0) = "5"
  println(numbers.mkString(" "))
  println(threeElements.mkString(" "))

  //arrays and seq
  val numberSeq: Seq[Int] = numbers  //implicit conversion
  println(numberSeq)

  //vectors
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  // vectors vs lists
  val maxRuns = 1000
  val maxCapacity = 10000000
  def getWriteTime(collection: Seq[Int]): Double ={
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), 0)
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / maxRuns
  }
  val numberList = (1 to maxCapacity).toList
  val numberVector = (1 to maxCapacity).toVector

  //
  println(getWriteTime(numberList))
  //
  println(getWriteTime(numberVector))
}
