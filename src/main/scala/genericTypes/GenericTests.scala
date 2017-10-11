package genericTypes

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec
import scala.collection.mutable.ListBuffer


class GenericTests extends FlatSpec with ShouldMatchers {
  "simple generic type" should "do the proper checks" in {
    new Par(3,4).izq + 5 should equal (8)
//    new Par(3,4).includes("pepe")
    new Par(3,4).includes(5) should equal (false)
  }
  
  "generic types" should "work properly wrt inheritance" in {
    val dimaria = new Futbolista("Angel Di Maria")
    val masche = new Futbolista("Javier Mascherano")
    val rojo = new Futbolista("Marcos Rojo")
    val trapito = new Arquero("Marcelo Barovero")
    val luifa = new Deportista("Luis Scola", Deporte.basket)
    val lole = new Automovilista("Carlos Reutemann")
    val niki = new Automovilista("Niki Lauda")
    
    val parauto = new Par[CasiDeportista] (luifa, lole)
    
//    val parfut = new Par[Futbolista](rojo, trapito)
    
//    val pardep: Par[Deportista] = parfut
    
  }

}