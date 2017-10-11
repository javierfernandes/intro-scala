package collections

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec
import scala.collection.mutable.Set
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Buffer

class CollectionBasicBehaviorExamples extends FlatSpec with ShouldMatchers {
  val numerines = Set(3,5,8)

  val n3 = Some(3)
  val n5 = Some(5)
  val nx = None
  val n2 = Some(2)

  "equals and find" should "work as expected" in {
    numerines.exists(a => a % 2 == 0) should equal (true)  
    numerines.exists(_ % 2 == 0) should equal (true)
    
    def esPar(a:Int) = { 
      a % 2 == 0 
    }
    numerines.exists(esPar) should equal (true)
    
    numerines.exists(_ % 6 == 0) should equal (false)

    numerines.find(_ % 2 == 0) should equal (Some(8))
    numerines.find(_ % 2 == 0).map(_ + 9) should equal (Some(17))
    numerines.find(_ % 6 == 0) should equal (None)
    
    numerines.filter(n => n > 6).map(n => n + 9) should equal (Set(17))
  }

  "options" should "combine happily" in {
    n3++n5++nx++n2 should equal (List(3,5,2))
    n3++n5++nx++n2 should have size (3)
    n3++n5++nx++n2 should contain (5)
    n3++n5++nx++n2 should not contain (8)
    List()++n3 should equal (List(3))
    n3++List() should equal (List(3))
    None++n3++n5 should equal (List(3,5))
    n3.toList should equal (List(3))
    None.toList should equal (List())
    n3 +: (n5 +: List()) should equal (List(n3,n5))
  }
  
  "fold" should "combine happily" in {
     (List(3,5,2) :\ 0) (_+_) should equal (10)
     (List(3,5,2) :\ 0) ((a,b) => a + b) should equal (10)
     List(3,5,2).sum should equal (10)
  }
  
  "lists" should "construct as expected" in {
    List(4,5) :+ 3 should equal (List(4,5,3))
    3 +: List(4,5) should equal (List(3,4,5))
    3 :: List(4,5) should equal (List(3,4,5))
    3 :: 4 :: 5 :: Nil should equal (List(3,4,5))
    List(1,2) ::: List(3) should equal (List(1,2,3))
    List(1,2) ::: Nil should equal (List(1,2))
  }
  
  "generic collections" should "check elements" in {
    var estrings: Buffer[String] = null
//    estrings = new ListBuffer[Int]   // claro, no compila
    estrings = new ListBuffer[String]
//    estrings += 1   // claro, no compila
    estrings += "hola"
    estrings += "samigos"
    estrings.size should equal (2)
    estrings.isEmpty should equal (false)
    estrings.indexOf("samigos") should equal (1)
    estrings(0) should equal ("hola")
  }
  
  
}





















