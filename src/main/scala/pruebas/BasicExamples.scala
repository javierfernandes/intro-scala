package pruebas

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec

class BasicExamples extends FlatSpec with ShouldMatchers {
  var unaVar: String = null   // hay que inicializar la var para que compile

  "variables" should "initialize" in {
    unaVar should equal (null)
  }

}