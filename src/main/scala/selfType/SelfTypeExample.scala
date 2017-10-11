package selfType

object SelfTypeExample extends App {
  abstract class Figure {
    type Self = this.type
    
    def isBigger(other:Self):Boolean
  }
  
  case class Circle(radius:Int) extends Figure {
    override def isBigger(other:Self) = radius > other.radius
  }
  
  case class Square(side:Int) extends Figure {
    override def isBigger(other:Self) = side > other.side
  }


  // println (new Circle(3).isBigger(new Circle(2)))
}