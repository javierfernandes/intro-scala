package functions

object HigherOrder extends App {
  val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

  println(numbers map { x => x * 2 })
  
  println(numbers map { _ * 2 }) // map numbers (*2)
  println(for (n <- numbers) yield n * 2)

  val f = esPar
  println(numbers filter f)
  println(numbers filter divide(2))
  println(numbers filter esPar)

  val esPar: Int => Boolean = divide(2)

  def divide(x: Int)(y: Int) = y % x == 0

  val a = new Accumulator();
  numbers foreach a.add
  println(a.suma)

  // Fold
  numbers reduce { (x, y) => x + y }
  numbers reduce { _ + _ }
  (numbers fold 0) { _ + _ }
}

class Accumulator {
  var cant = 0
  var suma = 0

  def add(x: Int) = {
    suma += x
    cant += 1
  }
}