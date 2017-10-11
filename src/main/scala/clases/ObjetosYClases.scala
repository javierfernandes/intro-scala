package clases

import Expressions.{ Constant, Expression, Product, show }

object ObjetosYClases extends App {
  val e1 = new Product(Foo, new Constant(2))

  new Foo
  new Foo

  show(e1)
}

object Foo extends Expression {
  var instanceCount = 0

  def incInstances = instanceCount += 1

  override def value = instanceCount
}

class Foo {
  Foo.incInstances
}
