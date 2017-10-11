package implicits

import scala.util.Random

trait Medio {
  type Publicador = { def publicar: Unit }
  
  implicit def publicador(e: Evento): Publicador
}

class MedioObjetivo extends Medio {
  def publicador(e: Evento) = new {
    def publicar = println(s"Informamos que sucedio ${e}")
  }
}

class MedioSubjetivo extends Medio {
  def publicador(e: Evento) = new {
    def publicar = println(s"${gustaONoGusta} que haya sucedido: ${e}")
    
    def gustaONoGusta = if (new Random().nextBoolean) "Me gusta" else "No me gusta"
  }
}

