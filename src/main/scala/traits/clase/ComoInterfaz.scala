package traits.clase

case class Raza(var salud:Int) {
  def recibirDanio(d:Int) {
    salud -= d
  } 
}

class Mago extends Raza(100) {
  def hacerMagia() {
    new Magia
  }
}
class Proyectil(var danio:Int)
class Magia extends Proyectil(10)

class Enano extends Raza(150) {
  def forjarArma() = { new Hacha }
} 

class Humano extends Raza(80)

class Hacha

trait Inmortal extends Raza {
  override def recibirDanio(d:Int) {
  }
}

trait Rey {
  def movilizarTropas(a:List[Raza])   
}

trait Guerrero {
  def atacar(a:Raza) {
    a.salud -= this.poderDeAtaque
  }

  def poderDeAtaque : Int
}

trait Clerigo {
  def calmar(a:List[Raza])
}

trait Ladron {}

trait ConPoderDeAtaqueDefault {
  def poderDeAtaque = 10
}

trait ConPoderDeAtaqueVariable {
  var poderDeAtaque = 10
}

class Arma
case class Hachas(var peso:Int) extends Arma
case class Espada(var peso:Int) extends Arma
case class BolaDeMagia(var potencia:Int, var duracion:Int) extends Arma
class Cuchillo(var filo:Int) extends Arma
object Cuchillo {
  
  def unapply(cuchillo:Cuchillo) : Option[Int] = {
    return Some(cuchillo.filo)
  }
}

object Ejemplo extends App {
  val enanoGuerrero = new Enano with Guerrero {
    override def poderDeAtaque = 23
  }
  
  val magoGuerrero = new Mago with ConPoderDeAtaqueDefault with Guerrero
  
  val clerigoGuerrero = new Humano with Guerrero with ConPoderDeAtaqueVariable 
  clerigoGuerrero.poderDeAtaque = 30
  
  val inmortal = new Humano with Inmortal
  inmortal.recibirDanio(23)
  println(inmortal salud)
  
  val l = List(new Hachas(10), new Espada(20), new BolaDeMagia(10, 5), new Cuchillo(23))
  l.foreach { a =>
    a match {
      case Hachas(peso) => println("un hacha de peso " + peso)
      case Espada(peso) => println("una espada de peso " + peso)
      case BolaDeMagia(potencia, duracion) => println("una bola de magia de potencia " + potencia + " y duracion " + duracion)
      case Cuchillo(23) => println("Cuchillo de filo 23")
      case _ => 
    }
  }

}