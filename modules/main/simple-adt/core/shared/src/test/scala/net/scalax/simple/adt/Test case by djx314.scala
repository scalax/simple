package net.scalax.simple.adt
package test

import TypeAdt.{alias => adtAlias, get => getAdtApply}, adtAlias._
import scala.collection.compat._

import zio._
import zio.test._
import zio.test.Assertion._

/** @author
  *   djx314
  */
object TestCase1 extends ZIOSpecDefault {

  case class TempForData(typeName: String, value: Option[Int])
  def inputOptDat[T: TypeOptions3[*, None.type, Some[Int], Option[Int]]](t: T): TempForData = {
    type Tpe[T] = TypeOptions3[T, None.type, Some[Int], Option[Int]]
    val applyM = getAdtApply[Tpe]
    applyM.input(t).fold(n => TempForData("None", n), n => TempForData("Some", Some(n.get + 1)), n => TempForData("Option", n.map(_ + 2)))
  }

  override def spec: Spec[TestEnvironment with Scope, Any] = suite("Test case created by djx314")(
    test("Simple adt fold in test data.") {
      def assert1 = {
        val data     = None
        val foldData = inputOptDat(data)
        assert(foldData)(Assertion.equalTo(TempForData("None", data)))
      }

      def assert2 = {
        val data     = Option(2)
        val foldData = inputOptDat(data)
        assert(foldData)(Assertion.equalTo(TempForData("Option", Option(data.get + 2))))
      }

      def assert3 = {
        val data     = Some(6)
        val foldData = inputOptDat(data)
        assert(foldData)(Assertion.equalTo(TempForData("Some", Some(data.get + 1))))
      }

      try assert1 && assert2 && assert3
      catch {
        case _: StackOverflowError => assertNever("Not allow adt access.")
      }
    }
  )
}
