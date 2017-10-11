package constructors

class RobotWithAuxiliaryConstructor(on: Boolean, val material: String) {
  def printStatus() = {
    println(on)
    println(material)
  }

  def this() = this(true, "Steel");
}
