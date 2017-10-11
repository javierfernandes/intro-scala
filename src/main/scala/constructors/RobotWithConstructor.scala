package constructors

class RobotWithConstructor(on:Boolean, material:String) {
	def printStatus() = {
	  println(material)
    }

	override def toString() = "un robot de " + material
}

object RobotWithConstructor {
	val robotDeAcero = new RobotWithConstructor(true, "acero") 
	val robotDeTitanio = new BetterRobot("titanio")
	
	def robots = List(robotDeAcero, robotDeTitanio)
}