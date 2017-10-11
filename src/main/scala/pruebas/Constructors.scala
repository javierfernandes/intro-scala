package pruebas

/**
 * Agregamos la super clase (trait) Rectangular, que resuelve el pattern matching sin romper el encapsulamiento.
 */
object Constructors extends App {
  class Square(val size: Int) {
    var zaraza = 3
  }

  class ColorSquare(size: Int, val color: String) extends Square(size)

  val s = new Square(10)
  println(s)
  println(s.zaraza)
  
  val cs = new ColorSquare(1, "hola")
  println(cs)
  println(cs.color)
}
