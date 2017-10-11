package patternMatching

/**
 * Agregamos la super clase (trait) Rectangular, que resuelve el pattern matching sin romper el encapsulamiento.
 */
object Figures3 extends App {
  println(combinar(Square(3), Square(4)))
  println(combinar(Rectangle(3, 5), Square(4)))
  println(combinar(Square(3), Rectangle(4, 5)))
  println(combinar(Rectangle(2, 3), Rectangle(4, 5)))
  println(combinar(Circle(2), Circle(3)))

  def combinar(s: Any, t: Any) = (s, t) match {
    case (Rectangular(h1, w1), Rectangular(h2, w2)) => Rectangle(h1 + h2, w1 + w2)
    case (Circle(d1), Circle(d2)) => Circle(d1 + d2)
  }

  case class Square(size: Int) extends Rectangular {
    def height = size
    def width = size
  }

  case class Rectangle(val height: Int, val width: Int) extends Rectangular

  class Circle(val radius: Int) {
    override def toString() = s"Circle(radius=$radius)"
  }
  object Circle {
    def apply(diameter: Int) = new Circle(diameter / 2);
    def unapply(c: Circle): Option[(Int)] = Some(c.radius * 2)
  }
  
  trait Rectangular {
    def height: Int
    def width: Int
  }
  object Rectangular {
	  def unapply(f: Rectangular): Option[(Int, Int)] = Some(f.height, f.width)
  }
}
