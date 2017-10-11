package pepita

import scala.collection.mutable.ArrayBuffer

object Pepita2 extends App {
  object Alpiste {
    val energia = 10
  }

  object Golondrina {
    val golondrinas = new ArrayBuffer[Golondrina]()
    def nuevaGolondrina(golo: Golondrina) = { golondrinas += golo }
  }

  import Golondrina._
  case class Golondrina(nombre: String, var energia: Int = 100) {
    nuevaGolondrina(this)

    def vola(metros: Int) = { energia -= metros * 10 }
    def come(comida: { def energia: Int }) = { energia += comida.energia }
  }

  def estaViva(g: Golondrina) = g.energia >= 0

  val pepita = Golondrina("pepita")
  val alpiste = Alpiste
  pepita come alpiste
  pepita vola 5
  println(pepita.energia)

  pepita come Golondrina("pepe")
  println(pepita.energia)

  println(golondrinas)
  golondrinas foreach { g => g vola 15 }
  println(golondrinas)

  println(golondrinas map { _.nombre })
  println(golondrinas filter estaViva)
  println(golondrinas exists estaViva)
  println(golondrinas forall estaViva)
  println(golondrinas find estaViva)
}

