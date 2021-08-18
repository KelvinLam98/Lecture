package lectures.chapter2

object DefaultArgs extends App{

  def trFact(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else trFact(n-1, n*acc)

  val fact10 = trFact(10, 2)

  def saveOnePicture(format: String = "jpg", width: Int, height: Int): Unit = println("save one picture")

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1000): Unit = println("save picture")
  saveOnePicture("jpg", 800, 600 ) //must stat three value to prevent system to confused
  savePicture(width = 800 ) //can stat one, two or three values and the sequence no need to follow

  println(trFact(5))

}
