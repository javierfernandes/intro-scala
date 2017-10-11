package functions

object Function {
  
  // Completa
  def min(i: Int, j: Int): Int = {
    return if (i > j)
      i
    else
      j
  }

  // Sin tipo de retorno
  def min2(i: Int, j: Int) = {
    if (i > j)
      i
    else
      j
  }

  // 1 linea
  def sayHello = println("Hello")

  // 1 parametro
  def sayHello(s: String) = println("Hello " + s)
  
  
  
  def main(args: Array[String]) {
    val f = Function;

    println(f.min(3, 5))
    
    // sin parametros, no hace faltan los paréntesis
    f.sayHello
    f.sayHello("Lars")
    
    // 1 parametro -> puedo sacar los puntos
    f sayHello "Lars"
    
    // jugando con funciones locales
    
    def toUpper(s:String) = {
      s.toUpperCase()
    }
    
    def toLower(s:String) = {
      s.toLowerCase()
    }
    
    var func = toUpper _
    println(func.apply("hOlA"))
    
    func = toLower _
    println(func.apply("hOlA"))
  }

}
