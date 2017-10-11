package pepita

import scala.collection.mutable.ArrayBuffer

object Pepita1 extends App {

  case class Golondrina(var nombre: String, var energia: Int = 100) {
    def come(comida: { def energia: Int }) = energia += comida.energia
    def vola(metros: Int) = energia -= metros * 4

    override def toString: String = nombre
  }

  trait Comida {
    def energia: Int
  }

  trait Bebida {
    def energia: Int
  }

  object CocaCola extends Bebida {
    def energia = 400
  }

  object Alpiste {
    def energia = 100
  }

  val pepita = new Golondrina("pepita")
  val pepona = new Golondrina("pepona", 200)

  pepita come Alpiste
  pepita come CocaCola

  val golondrinas = ArrayBuffer(pepita, pepona)
  golondrinas foreach { gol =>
    gol vola 100
    println(gol.energia)
  }

  // val energiaPositiva = { gol: Golondrina => gol.energia > 0 }
  def energiaPositiva(gol: Golondrina) = gol.energia > 0

  println(golondrinas filter energiaPositiva)
  println(golondrinas forall energiaPositiva)
  println(golondrinas exists energiaPositiva)
  (golondrinas find energiaPositiva) match {
    case Some(golondrina) => println(golondrina + " tiene energia positiva")
    case None             => println("ninguno tiene energia positiva")
  }

  // println(golondrinas map { gol => gol.energia })
  println(golondrinas map { _.energia })

  pepita match {
    case Golondrina(nombre, energia) => println(nombre + " es una Golondrina con energia " + energia)
  }
  
  println(Alpiste.getClass)
}
