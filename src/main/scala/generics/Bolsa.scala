package generics

import scala.collection.mutable.ListBuffer

class Bolsa[T] (contenido : T) {

  def obtenerContenido() : T = contenido
  
}



class Mascota(var nombre : String) {}
class Perro(s:String) extends Mascota(s) {}
class Gato(s:String) extends Mascota(s) {}




object Ma extends App {
  
  val bolsaPerro = new Bolsa(new Perro("colita"))  
  pedirElNombre(bolsaPerro)
  
//  val bolsaGato = new Bolsa(new Gato("michi"))  
//  pedirElNombre(bolsaGato)
  
  def pedirElNombre(bolsa : Bolsa[Perro]) {
    println(bolsa.obtenerContenido().nombre)
  }
  
}