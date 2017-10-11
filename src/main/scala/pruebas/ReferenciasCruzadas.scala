package pruebas

object ReferenciasCruzadas extends App {
  class MyClass(_methods: => Seq[MyMethod]) {
    def methods = _methods 
  }
  class MyMethod(_cl: => MyClass) {
    def cl = _cl
  }
  
  val a: MyClass = new MyClass(Seq(new MyMethod(a)))
  
  println(a)
  println(a.methods)
  println(a.methods(0).cl)
}