package implicits

object Main extends App {
  new Redaccion(new MedioSubjetivo).publicarEventos
}

class Redaccion(medio: Medio) {
  import medio._

  def eventos = List(
    new EstrenoCine("El Hobbit"),
    new NotaDeportes("River Campeon")
  )

  def publicarEventos = eventos.foreach(e => e.publicar)
}
