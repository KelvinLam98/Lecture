package lectures.part3fp

import scala.jdk.Accumulator

object TuplesAndMaps extends App {
  // tuples = finite ordered "lists"
  val aTuple = Tuple2(2, "hello Scala")
  println(aTuple._1)
  println(aTuple._2)

  println(aTuple.copy(_2 = "by"))
  println(aTuple.swap)

  // Maps - keys -> value
  val aMap: Map[String, Int] = Map()
  val phoneBook = Map(("Jim", 555), "Daniel" -> 789).withDefaultValue("Name or number is not in the list")
  // a -> b is sugar for (a,b)
  println(phoneBook)

  //map ops
  println(phoneBook.contains("Jim"))
  println(phoneBook("kel"))

  // add a pairing
  val newPairing = "Mary" -> 687
  val newPhoneBook = phoneBook + newPairing
  println(newPhoneBook)

  //functioals on maps
  // map, flatmap and filter
  println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))

  //filter keys
  //  println(phoneBook.filterKeys(x => x.startsWith("J")))

  // mapValues
  //  println(phoneBook.mapValues((number => "o245_" + number)))

  //conversions to other collections
  println(phoneBook.toList)
  println(List(("Daniel", 345)).toMap)
  val names = List("Bob", "James", "Angela", "Daniel", "Kel")
  println(names.groupBy(name => name.charAt(0)))

  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))

    val unfriended = removeAux(network(person), network)
    unfriended - person

  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Bob"), "Mary")

  println(network)
  println(friend(network, "Bob", "Mary"))
  println(unfriend(friend(network, "Bob", "Mary"), "Bob", "Mary"))
  println(remove(friend(network, "Bob", "Mary"), "Bob"))

  //jim, bob, mary
  val people = add(add(add(empty, "Bob"), "Mary"), "Jim")
  val human = add(add(add(empty, "James"), "John"), "Kel")
  val jimBob = friend(people, "Bob", "Jim")
  val textNet = friend(people, "Bob", "Mary")

  println(textNet)

  def nFriends(network: Map[String, Set[String]], person: String): Int =
    if (!network.contains(person)) 0
    else network(person).size
  println(nFriends(textNet, "Bob"))

  def mostFriends(network: Map[String, Set[String]], person: String): String =
    network.maxBy(pair => pair._2.size)._1

  println(mostFriends(textNet, " "))

  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int =
    network.count(pair => pair._2.isEmpty)
  println(nPeopleWithNoFriends(textNet))

  def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      if(discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head
        if (person == target) true
        else if (consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail)
        else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person))
      }
    }
    bfs(b, Set(), network(a) + a)
  }
  println(socialConnection(textNet, "Mary", "Bob"))
}