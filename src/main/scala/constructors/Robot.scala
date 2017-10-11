package constructors

class Robot {
	val material = "steel"
		
	def compararCon (r:RobotWithConstructor) = println("Soy el mejor")
	def compararCon (r:BetterRobot) = println("Sigo siendo el mejor")
}