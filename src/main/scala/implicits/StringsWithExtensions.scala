package implicits

object StringsWithExtensions extends App {
  import Implicits._
  
  println("hola.mundo".splitIntoLines)
}


object Implicits {
  implicit def stringExtensions(base: String): StringExtensions = 
    new StringExtensions(base)
}


class StringExtensions(base: String) {
  def splitIntoLines = base.replaceAll("\\.", ".\n").replaceAll("\n ", "\n")
}
