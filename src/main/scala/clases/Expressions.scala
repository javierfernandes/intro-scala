package clases

/**
 * Implementación básica, se ve el uso de constructores
 */
object Expressions extends App {
  abstract class Expression {
    def value: Double
  }

  class Constant(val value: Double) extends Expression

  abstract class BinaryOperation(arg1: Expression, arg2: Expression) extends Expression

  class Addition(arg1: Expression, arg2: Expression) extends BinaryOperation(arg1, arg2) {
    override def value = arg1.value + arg2.value
  }

  object Product {
    def apply(v1: Double, v2: Double) = new Product(new Constant(v1), new Constant(v2))
  }

  class Product(arg1: Expression, arg2: Expression) extends BinaryOperation(arg1, arg2) {
    override def value = arg1.value * arg2.value

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

  val e3 = Product(2, 3)
  show(e3)

  // Desafío!!!
  // println((1 to 10) fold ???)
  
  def show(e: Expression) = println(e + " = " + e.value)

}
