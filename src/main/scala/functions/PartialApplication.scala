package functions

object PartialApplication extends App {
  val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

  val f = esPar
  println(numbers filter f)
  println(numbers filter curry(divide)(2))
  println(numbers filter esPar)

  def esPar: Int => Boolean = (divideOrig: (Int, Int) => Boolean) $ 2 // divide $ 2

  implicit def asPartialApplicableFunction[A, B, C](f: (A, B) => C): PartialApplicableFunction[A, B, C] =
    new PartialApplicableFunction(f);

  class PartialApplicableFunction[A, B, C](f: (A, B) => C) {
    def $(a: A): B => C = curry(f)(a)
  }

  def curry[A, B, C](f: (A, B) => C): A => (B => C) = { a => { b => f(a, b) } }
  def divideOrig(x: Int, y: Int): Boolean = y % x == 0
  val divide: (Int, Int) => Boolean = { (x, y) => y % x == 0 }
}