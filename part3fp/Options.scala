package lectures.part3fp

import scala.util.Random

object Options extends App {

  val first: Option[Int] = Some(4)
  val noOptions: Option[Int] = None

  def unsafeMethod(): String = null
  val result = Option(unsafeMethod())
  println(result)

  //chained method
  def backupMethod(): String = "A valid result"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

  def betterUnsafe(): Option[String] = None
  def betterBackup():  Option[String] = Some("A valid result")
  val betterChained = betterUnsafe() orElse betterBackup()

  println(first.isEmpty)
  println(first.get)  //not good way to use

  //map, flatmap, filter
  println(first.map(_ * 2))
  println(first.filter(x => x < 10))
  println(first.flatMap(x => Option(x * 10)))

  val config: Map[String, String] = Map(
    "host" -> "176.45.36.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected"
  }

  object Connection {
    val random = new Random(System.nanoTime())
    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }
  val host = config.get("host")
  val port = config.get("port")
  /*
      if (h != null)
        if (p != null)
          return Connection.apply(h,p)

      return null
   */
  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h,p)))
  /*
      if(c!=null)
        return c.connect
      return null
   */
  val connectionStatus = connection.map(c => c.connect)
  //if (connectionStatus == null) println(None) else print(Some(connectionStatus.get))
  println(connectionStatus)
  /*
  if (status != null)
    println(status)
   */
  connectionStatus.foreach(println)

  //chained calls
  config.get("host")
    .flatMap(host => config.get("port")
      .flatMap(port => Connection(host, port))
        .map(connection => connection.connect))
    .foreach(println)

  //for-comprehnsion
  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect
  forConnectionStatus.foreach(println)
}
