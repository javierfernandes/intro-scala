package clases

/**
 * Ejemplos para el manejo de colecciones, funciones de orden superor, funciones parciales, aplicación parcial.
 */
object Expressions3 extends App {
  
  abstract class Expression {
    def value: Double
    def show = println(this + " = " + this.value)
    def foreach(f: Constant => Unit)
    def preorder(f: PartialFunction[Expression, Expression]): Expression
  }

  case class Constant(val value: Double) extends Expression {
    override def toString = value.toString
    def foreach(f: Constant => Unit) = f(this)
    def preorder(f: PartialFunction[Expression, Expression]) =
      if (f.isDefinedAt(this))
        f(this)
      else
        this
  }

  abstract class BinaryOperation(arg1: Expression, arg2: Expression) extends Expression {
    def create(arg1: Expression, arg2: Expression): BinaryOperation
    def foreach(f: Constant => Unit) = { arg1 foreach f; arg2 foreach f }

    def preorder(f: PartialFunction[Expression, Expression]) = {
      def eval(arg: Expression) =
        if (f isDefinedAt arg)
          f(arg preorder f)
        else
          arg preorder f

      create(eval(arg1), eval(arg2))
    }
  }

  case class Addition(arg1: Expression, arg2: Expression) extends BinaryOperation(arg1, arg2) {
    def value = arg1.value + arg2.value
    def create(arg1: Expression, arg2: Expression) = Addition(arg1, arg2)
    override def toString = "(" + arg1 + " + " + arg2 + ")"
  }

  case class Product(arg1: Expression, arg2: Expression) extends BinaryOperation(arg1, arg2) {
    def value = arg1.value * arg2.value
    def create(arg1: Expression, arg2: Expression) = Product(arg1, arg2)
    override def toString = "(" + arg1 + " * " + arg2 + ")"
  }

  // *******************************************************
  // ** Classes 
  // *******************************************************

  val two = Constant(2)
  val three = Constant(3)
  val e1 = Addition(two, three)
  val e2 = Product(three, e1)

  def show(e: Expression) = println(e + " = " + e.value)

  val expressions = List(two, three, e1, e2)

  //  expressions.map({ x => show(x) })
  //  expressions.map { x => show(x) }
  //  expressions map { x => show(x) }
  //  expressions map ( x => show(x) )
  //  
  //  expressions.map(show)
  //  expressions map show

  //   expressions.map(x => x.show)
  //   expressions.map(_.show)
  //   expressions map (_.show)

  // println(expressions.map(_.value))
  //    println(expressions.filter(_.value < 10))
  //    println(expressions.filter(x => x.value < 10 && x.value >= 5))

  //  println(expressions.collect {
  //    case Constant(x) => "una constante " + x
  //    case s: Addition if s.value >= 5 => "una suma grande " + s.value
  //    // case e: Product => "otro producto"
  //  })
  //
  //  // def choose(x:Expression):String
  //  val choose: PartialFunction[Expression, String] = {
  //    case Constant(x) => "una constante " + x
  //    case s: Addition if s.value >= 5 => "una suma grande " + s.value
  //    case e: Product => "otro producto"
  //  }
  //  
  //  println(expressions collect choose)

//  def plus(x: Expression)(y: Expression) = Addition(x, y)
//  def plus(x:Expression, y:Expression) = Addition(x,y)
//  println(expressions map plus(two))

//  println(e2)
//  // e2 foreach { println}
//  println(e2 preorder {
//    case Product(a, b) => Product(b, a)
//    case Addition(a, b) => Addition(b, a)
//  })
}

