package clases

object ClassesTestApplication extends App {
  //	val robot = new RobotWithConstructor(true, "steel")
  //	robot.printStatus()
  //	
  //	val robot2 = new RobotWithAuxiliaryConstructor()
  //	robot2.printStatus()
  //
  //	val robot3 = new BetterRobot("Titanium")
  //	robot3.printStatus()
  //	
  //	println(List.range(1:Int, 100, (2*): Int=>Int))
  //	
  //	RobotWithConstructor.robots.foreach(new Robot().compararCon) 
  //	
  //	println(pruebas.Test2)

  //	val robot = new Robot();
  //	var uno = new RobotWithConstructor(true, "steel")
  //	robot compararCon uno 
  //	
  //	uno = new BetterRobot("acero")
  //	robot compararCon uno

  val s = Square(1)
  s.length = 3
  println(s.length)
  println(s)

 // println(combinar(new Circle, Rectangle(4, 1)))

  def combinar(s: Any, t: Any) = (s,t) match {
    case (Square(w), Square(u)) => Square (w+u) 
    case (Rectangle(a, b), Rectangle(c,d)) => Rectangle (a+c, b+d)
    case (Rectangle(a, b), Square(u)) => Rectangle (a+u, b+u)
    case (Square(w), Rectangle(c,d)) => Rectangle (w+c, w+d)
    case (Circle(w), Rectangle(c,d)) => Rectangle (w+c, w+d)
  }
}

class Persona (var nombre : String , telefono : Int){
	def ==(p: Persona) : Boolean = this.nombre == p.nombre
}
