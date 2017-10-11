package pruebas

object XML extends App {
  val authors = List("Odersky", "Maradona")
  val version = 2.1
  val b = <book>
            <title>The Scala Language Specification</title>
            <version>{ version }</version>
            <authors>
              { for (a <- authors) yield <author>{ a }</author> }
            </authors>
          </book>

  println(b.getClass)
  println(b)
}