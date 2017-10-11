package clases

/**
 * Sobrecarga de operadores
 */
object Expressions4 extends App {
  abstract class Expression {
    def value: Double
    def show = println(this + " = " + this.value)
    def +(e:Expression) = Addition(this,e)
    def *(e:Expression) = Product(this,e)
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
  val e1 = two + three
  val e2 = three * e1

  List(two, three, e1, e2) map { e => println(e + " = " + e.value) }
}

