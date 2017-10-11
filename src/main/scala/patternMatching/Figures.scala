package patternMatching

/**
 * Apply/unapply de circle en un pattern matching mezclado con square y rectangle.
 */
object Figures extends App {

  println(combinar(Cuadrado(3), Cuadrado(4)))
  println(combinar(Rectangulo(3, 5), Cuadrado(4)))
  println(combinar(Cuadrado(3), Rectangulo(4, 5)))
  println(combinar(Rectangulo(2, 3), Rectangulo(4, 5)))
  println(combinar(Circulo(2), Circulo(4)))
  println(combinar(Circulo(0), Circulo(3)))
  println(combinar(Circulo(2), Rectangulo(3, 4)))

  def combinar(s: Any, t: Any) = (s, t) match {
    
    case (Cuadrado(s1), Cuadrado(s2)) => Cuadrado(s1 + s2)
    case (Rectangulo(h1, w1), Rectangulo(h2, w2)) => Rectangulo(h1 + h2, w1 + w2)
    case (Rectangulo(h, w), Cuadrado(s)) => Rectangulo(h + s, w + s)
    case (Cuadrado(s), Rectangulo(h, w)) => Rectangulo(h + s, w + s)
    case (Circulo(d1), Circulo(d2)) => Circulo(d1 + d2)
    case _ => "Naranja"

  }

  case class Cuadrado(tamanio: Int)
  case class Rectangulo(alto: Int, ancho: Int)

  class Circulo(val radio: Int) {
    override def toString() = "Circle(radius=" + radio + ")"
  }

  object Circulo {
    def apply(diametro: Int) = new Circulo(diametro / 2)
    def unapply(c: Circulo): Option[Int] =
      if (c.radio > 0)
        Some(c.radio * 2)
      else
        None
  }
}


