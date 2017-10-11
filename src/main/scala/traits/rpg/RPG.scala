package traits.rpg

object RPG extends App {
  
  val personaje = new Personaje
  personaje.arma = new Hacha
  personaje.dañarse(10)
  
  val orco = new Orco(new EspadaDelAugurio)
  
  orco.atacar(personaje)
  personaje.atacar(orco)

  println(personaje.energia)
  println(orco.energia)
}