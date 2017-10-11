package clases

case class Square(wide:Int) {
  private var l = 1;
  def sup = wide * wide;

  def length = l;

  def length_=(s: Int) = {
    require(s > 0)
    this.l = s
  }
}

case class Rectangle(height: Int, wide: Int) {
  def sup = height * wide
}

class Circle(val radius:Int) {
  
}

object Circle {
  def apply(diameter: Int) = new Circle(diameter/2);
  def unapply(c:Circle): Option[(Int)] = Some(c.radius * 2)
} 

object SquaresApp extends App {
  
  println(new Circle(2) match {
    case Circle(r) => r * 2
  })
  
}
