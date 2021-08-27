package lectures.part3fp

import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App {

  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("SUPER FAILURE"))

  println(aSuccess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("No String for you")

  //try objects via the apply method
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)

  val anotherPotentialFailure = Try {
    //code might not be working
  }

  //utilities
  println(potentialFailure.isSuccess)

  //orElse
  def backupMethod(): String = "A valid result"
  val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))

  //IF you design the API
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException)
  def betterBackupMethod(): Try[String] = Success("A Valid result")
  val betterFallBack = betterUnsafeMethod() orElse betterBackupMethod()

  //map, filter and flatmap
  println(aSuccess.map(_*2))
  println(aSuccess.flatMap(x => Success(x*10)))
  println(aSuccess.filter(_ > 10))

  val hostname = "localhost"
  val port = "8080"
  def renderHTML(page: String) = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) "<html>...</html>"
      else throw new RuntimeException("Connection interrupted")
    }
    def getSafe(url: String): Try[String] = Try(get(url))
  }
  object HttpServices {
    val random = new Random(System.nanoTime())
    def getConnection(host: String, port: String): Connection =
      if(random.nextBoolean()) new Connection
      else throw new RuntimeException("Someone else took the port")

    def getSafeConnection(host: String, port: String): Try[Connection] = Try(getConnection(host, port))
  }
  val possibleConnection = HttpServices.getSafeConnection(hostname, port)
  val possibleHTML = possibleConnection.flatMap(connection => connection.getSafe("/home"))
  possibleHTML.foreach(renderHTML)

  //shorthand version
  HttpServices.getSafeConnection(hostname, port)
    .flatMap(connection => connection.getSafe("/home"))
    .foreach(renderHTML)

  for {
    connection <- HttpServices.getSafeConnection(hostname, port)
    html <- connection.getSafe("/home")

  } renderHTML(html)
}
