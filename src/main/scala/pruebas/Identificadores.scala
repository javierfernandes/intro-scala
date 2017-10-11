package pruebas

object Identificadores extends App {
  val `mi variable con nombre loco` = 3
  
  object `a ver Scala` {
	  def imprimite(v:Any) = println(v)     
  }
  
  `a ver Scala` imprimite `mi variable con nombre loco`
  `a ver Scala`.imprimite(`mi variable con nombre loco`)
}