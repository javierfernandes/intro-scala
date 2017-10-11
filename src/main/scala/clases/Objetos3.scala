package clases

import scala.collection.mutable.ListBuffer

/**
 * @author jfernandes
 */
class Objetos3 {
  
  def main(args: Array[String]): Unit = {
    val pepita = new Golondrina(energia = 100)
    val pepona = new Golondrina(energia = 200)
    
    val voladores = ListBuffer(pepita, pepona, new Superman)
    voladores += pepita
    
    val bloqueEnergia : (Golondrina)=>Int = { g:Golondrina => g energia }
    
//    val energias = voladores map bloqueEnergia
    
//    voladores filter { g => g.energia > 100 }
    
//    voladores map(_ energia) sum
    
    voladores.foreach { g => g.volar(10) }
    
//    val suma = voladores.foldLeft(0) { _ + _.energia }
    
//    val golondrinas = voladores.filter { v => v.isInstanceOf[Golondrina] } 
    
    val golondrinas = voladores collect { case g:Golondrina => g }
    
  }
  
}

class Golondrina(var energia : Int, var altura : Int = 10) extends Volador {
  var potenciaDeVuelo : Double = _
  
  this.inicializarPotencia()
  
  def inicializarPotencia() {
    potenciaDeVuelo = altura * 1.3
  }
  
  def volar(kms:Int) {
    energia -= kms
  }
  def poneHuevo() {}  
}

trait Volador {
  def volar(kms:Int)
}

class SuperGolodrina(e:Int) extends Golondrina(e) {
  
  override def volar(kms:Int) {
    energia -= kms / 3
  }
  
}

class Superman extends Volador {
  def volar(kms: Int): Unit = {
    println("tan ta taaaaan")
  }
}






