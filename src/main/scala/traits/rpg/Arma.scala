package traits.rpg

/**
 * @author jfernandes
 */
trait Arma {
  def atacar(personaje: Mortal) = {
    personaje.dañarse(potenciaAtaque())
  }
  def potenciaAtaque() : Int
}

class Hacha extends Arma {
  def potenciaAtaque(): Int = 10
}

class EspadaDelAugurio extends Arma {
  def potenciaAtaque(): Int = 12
}