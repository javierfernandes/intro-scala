package clases

/**
 * Implicit conversions.
 */
object Expressions5 extends App {
  abstract class Expression {
    def value: Double
    def show = println(this + " = " + this.value)
    def +(e: Expression) = Addition(this, e)
    def *(e: Expression) = Product(this, e)
  }

  case class Constant(val value: Double) extends Expression {
    override def toString = value.toString
  }

  abstract class BinaryOperation(arg1: Expression, arg2: Expression) extends Expression
  case class Addition(arg1: Expression, arg2: Expression) extends BinaryOperation(arg1, arg2) {
    def value = arg1.value + arg2.value
    override def toString = "(" + arg1 + " + " + arg2 + ")"
  }

  case class Product(arg1: Expression, arg2: Expression) extends BinaryOperation(arg1, arg2) {
    def value = arg1.value * arg2.value
    override def toString = "(" + arg1 + " * " + arg2 + ")"

  }

  // *******************************************************
  // ** Tests 
  // *******************************************************

  implicit def asExpression(x: Int): Expression = Constant(x)

  val x: Expression = 2
  val y: Expression = 3

  val expressions: List[Expression] = List(
    x,
    x + y,
    2 * x,
    x + y * 4,
    (x + y) * 4,
    2 * 3)

  expressions map { x => x.show }

  println(expressions.foldLeft(0.0)({ _ + _.value }))

  object T extends ((Double,Expression) => Double) {
    override def apply(acum: Double, e: Expression) = acum + e.value 
  }
  
  println(expressions.foldLeft(0.0)(T))  
}

