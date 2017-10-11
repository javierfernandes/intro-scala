package patternMatching

/**
 * La clase rectangle utilizada para hacer pattern matching tanto de cuadrados como rectángulos.
 */
object Figures2 extends App {
  val s = Circle(1)
  s match {
    case Rectangle(1, 1) => println("Nico tiene razón")
    case _               => println("Vamos al recreo")
  }

  println(combinar(Square(3), Square(4)))
  println(combinar(Rectangle(3, 5), Square(4)))
  println(combinar(Square(3), Rectangle(4, 5)))
  println(combinar(Rectangle(2, 3), Rectangle(4, 5)))
  println(combinar(Circle(2), Circle(3)))
  println(combinar(Square(3), Circle(3)))

  def combinar(s: Any, t: Any) = (s, t) match {
    case (Circle(d1), Circle(d2))               => Circle(d1 + d2)
    case (Rectangle(h1, w1), Rectangle(h2, w2)) => Rectangle(h1 + h2, w1 + w2)
  }

  case class Square(size: Int) {}

  class Rectangle(val height: Int, val wide: Int) {
    override def toString() = "Rectangle(" + height + "," + wide + ")"
  }
  object Rectangle {
    def apply(height: Int, wide: Int) = new Rectangle(height, wide)
    def unapply(f: Any): Option[(Int, Int)] = f match {
      case Square(s)    => Some(s, s)
      case r: Rectangle => Some(r.height, r.wide)
      case _            => None
    }
  }

  class Circle(val radius: Int) {
    override def toString() = "Circle(radius=" + radius + ")"
  }
  object Circle {
    def apply(diameter: Int) = new Circle(diameter / 2);
    def unapply(c: Circle): Option[(Int)] = Some(c.radius * 2)
  }
}
