package lectures.part2oop

//import exercises._  - this is for import all files in exercises file
import exercises.{ForPackage, ForPackaging => TryPackage}

import java.sql
import java.util.Date
import java.sql.{Date => sDate}

object PackagingAndImports extends App{

  // package members are accessible by their own name
  val writer = new Writer("Daniel", "Rock", 2010)

  // import the package, can also "new exercises.ForPackage"
  val forPackage = new ForPackage

  // packages are hierarchy
  // matching folder structure

  //package object
  sayHello
  println(speed)

  // imports
  val forPackaging = new TryPackage

  val date = new Date //first import date
  val sqlDate = new sDate(115, 0, 4)
  println(sqlDate)
}
