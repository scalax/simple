package net.scalax.simple.nat
package test

import adt.TypeAdt.{alias => adtAlias, get => getAdtApply}, adtAlias._
import net.scalax.simple.nat.adt.impl.FetchAdtApply
import scala.collection.compat._

import zio._
import zio.test._
import zio.test.Assertion._

object HelloWorldSpec extends ZIOSpecDefault {

  case class TempForData(typeIndex: Int, typeName: String, value: Option[Int])
  def inputOptDat[T: TypeOptions3[*, None.type, Some[Int], Option[Int]]](t: T): TempForData = {
    type Tpe[T] = TypeOptions3[T, None.type, Some[Int], Option[Int]]
    val applyM                       = getAdtApply[Tpe]
    val typeIndex                    = implicitly[Tpe[T]].index
    val value: (String, Option[Int]) = applyM.input(t).fold(n => ("None", n), n => ("Some", Some(n.get + 1)), n => ("Option", n.map(_ + 2)))
    TempForData(typeIndex = typeIndex, typeName = value._1, value = value._2)
  }

  def spec = suite("HelloWorldSpec")(
    test("sayHello correctly displays output") {
      def assert1 = {
        val data     = None
        val foldData = inputOptDat(data)
        assert(foldData)(Assertion.equalTo(TempForData(3, "None", data)))
      }

      def assert2 = {
        val data     = Option(2)
        val foldData = inputOptDat(data)
        assert(foldData)(Assertion.equalTo(TempForData(1, "Option", Option(data.get + 2))))
      }

      def assert3 = {
        val data     = Some(6)
        val foldData = inputOptDat(data)
        assert(foldData)(Assertion.equalTo(TempForData(2, "Some", Option(data.get + 1))))
      }

      assert1 && assert2 && assert3
    }
  )
}
