package net.scalax.simple.nat.injection
package test

import scala.collection.compat._

import zio._
import zio.test._
import zio.test.Assertion._

object HelloWorldSpec extends ZIOSpecDefault {

  def spec: Spec[TestEnvironment with Scope, Any] = suite("HelloWorldSpec")(
    test("sayHello correctly displays output") {
      val aa = List("11", "33", "22")
      val bb = SimpleZero.add("11").add("33").add("22")

      val assert1 = assert(bb.to(List))(Assertion.equalTo(aa))
      val assert2 = assert(bb.size)(Assertion.equalTo(aa.size))
      val assert3 = assert(bb.length)(Assertion.equalTo(aa.length))
      val assert4 = assert(bb.to(List).toString)(Assertion.equalTo(aa.toString))
      val assert5 = assert(bb(2))(Assertion.equalTo(aa(2)))

      val x =
        bb.asInstanceOf[SimplePositive[String]]
          .tail()
          .asInstanceOf[SimplePositive[String]]
          .tail()
          .asInstanceOf[SimplePositive[String]]
          .tail()

      val assert6 = assert(SimpleZero == x)(Assertion.equalTo(true))
      val assert7 = assert(x(2))(Assertion.equalTo(aa(2)))
      val assert8 = assert(x.size)(Assertion.equalTo(0))
      val assert9 = assert(x.length)(Assertion.equalTo(aa.size))

      assert1 && assert2 && assert3 && assert4 && assert5 && assert6 && assert7 && assert8 && assert9
    },
    test("sayHello correctly displays output11") {
      val aa = List("11", "33", "22")
      val bb = SimpleList(aa: _*)

      val assert1 = assert(bb.to(List))(Assertion.equalTo(aa))
      val assert2 = assert(bb.size)(Assertion.equalTo(aa.size))
      val assert3 = assert(bb.length)(Assertion.equalTo(aa.length))
      val assert4 = assert(bb.to(List).toString)(Assertion.equalTo(aa.toString))
      val assert5 = assert(bb(2))(Assertion.equalTo(aa(2)))

      val x =
        bb.asInstanceOf[SimplePositive[String]]
          .tail()
          .asInstanceOf[SimplePositive[String]]
          .tail()
          .asInstanceOf[SimplePositive[String]]
          .tail()

      val assert6 = assert(SimpleZero == x)(Assertion.equalTo(true))
      val assert7 = assert(x(2))(Assertion.equalTo(aa(2)))
      val assert8 = assert(x.size)(Assertion.equalTo(0))
      val assert9 = assert(x.length)(Assertion.equalTo(aa.size))

      assert1 && assert2 && assert3 && assert4 && assert5 && assert6 && assert7 && assert8 && assert9
    }
  )
}
