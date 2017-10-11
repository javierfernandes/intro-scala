package clases

/**
 * Incorpora el uso de case classes
 */
object Expressions2 extends App {
  abstract class Expression {
    def value: Double
    def show = println(this + " = " + this.value)
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

  val two = new Constant(2)
  val three = new Constant(3)
  val e1 = new Addition(two, three)
  show(e1)

  val e2 = new Product(three, e1)
  show(e2)

  def show(e: Expression) = println(e + " = " + e.value)
}

