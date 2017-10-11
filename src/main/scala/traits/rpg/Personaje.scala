package traits.rpg

/**
 * @author jfernandes
 */
class Personaje extends Mortal with Atacante {
  var itinerario : Set[Objeto] = Set()
  def energiaMaxima(): Int = 100
  
  def recoger(o : Objeto) { itinerario += o }
  def soltar(o : Objeto) { itinerario -= o }
  
}

trait Equipable {}

class Objeto

trait Mortal {
  var energia : Int = energiaMaxima
  
  def curarse(cuanto:Int) { energia += cuanto }
  def dañarse(cuanto:Int) { energia -= cuanto }
  
  def energiaMaxima() : Int
  
}

class Orco(a : Arma) extends Mortal with Atacante {
  arma = a
  
  def energiaMaxima(): Int = 40
  
}

trait Atacante {
  var arma : Arma = _
  def atacar(personaje: Mortal) = {
    arma.atacar(personaje)
  }
}