package patternMatching

/**
 * Apply/unapply de circle en un pattern matching mezclado con square y rectangle.
 */
object Figures4 extends App {
  abstract class Figure {
    def area: Double
  }
  case class Square(val size: Int) extends Figure {
    def area = size * size
  }
  case class Rectangle(height: Int, wide: Int) extends Figure {
    def area = height * wide
  }

  case class Circle(val radius: Int) extends Figure {
    def area = 3.14159 * radius * radius
  }

  val l: List[Figure] = List(Square(1), Rectangle(2, 3), Circle(4))
  println(l map { x => x.area })

  def fun(fig: Figure) = "Figure"
  def fun(fig: Square) = "Square"

  println(l map { x => fun(x)})

  val s:Square = Square(1)
  val f:Figure = s
  println(fun(s))
  println(fun(f))
  println(s == f)
}
