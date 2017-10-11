package genericTypes

class Deporte(val nombre: String, var duracionPartido: Int) {
}

object Deporte {
  val futbol = new Deporte("futbol", 90)
  val basket = new Deporte("basket", 40)
  val autos = new Deporte("automovilismo", 120)
}

trait CasiDeportista {
  def correr(minutos: Int) 
  def saltar(minutos: Int) 
}

class Deportista(val nombre: String, val deporte: Deporte) 
extends CasiDeportista {
  def correr(minutos: Int) {}
  def saltar(minutos: Int) {}
  def practicarHabilidades(minutos: Int) {}
}

class Futbolista(nombre: String) extends Deportista(nombre, Deporte.futbol) {
  var gradoPrecisionPases: Int = 25
}

class Arquero(nombre: String) extends Futbolista(nombre) {
  var fuerzaEnLosBrazos: Int = 8
}

class Automovilista(nombre: String) extends Deportista(nombre, Deporte.autos) {
  var marcaQueSueleConducir: String = null 
}




class Par[T](val izq: T, val der: T) {
  def parInverso = new Par(der,izq)
  def includes(something: T) = (izq == something) || (der == something)
}
//[U >: T]





class Entrenador {
}
