package fsis

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class functorTest extends AnyFlatSpec with Matchers {
  "ListFunctor lift method" should "generate a list of B from a list of A" in {
    val listFunctor = implicitly[Functor[List]]
    val listFunctorLift = listFunctor.lift(x => "hello_" + x)
    listFunctorLift(List(1, 2, 3)) shouldEqual List("hello_1", "hello_2", "hello_3")
  }

  "Function1Functor map method" should "apply two functions in sequence" in {
    val func1Functor = implicitly[Functor[Int => *]]
    val func1FunctorMap = func1Functor.map(_ * 2)(_ + 2)
    func1FunctorMap(5) shouldEqual 12
  }

  "Composing functor of list and functor of option" should "apply the map to inner option and then to list" in {
    val listWithOptionFunctor = Functor[List] compose Functor[Option]
    val xs: List[Option[Int]] = List(Some(1), None, Some(2))
    listWithOptionFunctor.map(xs)(_ + 1) shouldEqual List(Some(2), None, Some(3))
  }
}