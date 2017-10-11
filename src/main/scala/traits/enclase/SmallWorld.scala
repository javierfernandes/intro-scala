package smallworld

abstract class Raza(var salud:Int)

class Humano extends Raza(100) {
  
}
class Enano extends Raza(150) {
  def forjarEspada() {
    println("Forjo una espada")
  }
}

trait Mago {
  def mana : Int
  def hizoMagia : Unit
  
  def hacerMagia() {
    if (mana > 0) {
    	println("hago magia")
      hizoMagia
    }
  }
}

trait ManaConsumible {
    var _mana : Int = 100
    def mana = _mana
    def hizoMagia {
      _mana -= 10
    }
}

trait ManaInfinito {
  def mana = Int.MaxValue
  def hizoMagia {
  }
}

trait Guerrero {
  def atacar(a:Raza) {
    a.salud -= 10
  }
}

trait MagoPower {

  def superPoder() {
     this.hacerMagia()
     this.hacerMagia()
     this.hacerMagia()
  }
  def hacerMagia()
}


object Mixins extends App {
  val enanoMago = new Enano with ManaConsumible with Mago 
  val humano = new Humano with Mago with ManaInfinito
  
  val power = new Humano with MagoPower with Mago with ManaInfinito
  
  val l = List(humano, enanoMago)
  
  l.foreach { m => m.hacerMagia() }
  
  l map { _.mana }
  
}