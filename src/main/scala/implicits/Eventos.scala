package implicits

trait Evento

class EstrenoCine(titulo: String) extends Evento {
	override def toString = s"Estrena Pelicula: ${titulo}"
}


class NotaDeportes(descripcion: String) extends Evento {
	override def toString = s"Deportes: ${descripcion}"
}
