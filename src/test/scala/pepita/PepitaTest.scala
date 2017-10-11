package pepita

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import Pepita1.Golondrina

class PepitaTest extends FlatSpec with Matchers {

  "pepita" should "nacer con energia 100" in {
    val pepita = new Golondrina("pepita")
    pepita.energia should equal(100)
  }

  it should "perder energia cuando vuela" in {
    val pepita = new Golondrina("pepita")
    pepita vola 20
    pepita.energia should equal(20)
  }

  it should "no tener energia negativa" in {
    a[Throwable] should be thrownBy {
      val pepita = new Golondrina("pepita")
      pepita vola 30
    }
  }
}