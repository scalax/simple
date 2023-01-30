package net.scalax.simple.adt.test

import net.scalax.simple.adt.{TypeAdt => Adt}
import scala.collection.compat._

import zio._
import zio.test._
import zio.test.Assertion._

/** @author
  *   djx314
  */
object TestCase1 extends ZIOSpecDefault {

  case class TempForData(typeName: String, value: Option[Int])
  def inputOptData[T: Adt.Options3[*, None.type, Some[Int], Option[Int]]](t: T): TempForData = {
    val applyM = Adt.Options3[None.type, Some[Int], Option[Int]](t)
    applyM.fold(n => TempForData("None", n), n => TempForData("Some", Some(n.get + 1)), n => TempForData("Option", n.map(_ + 2)))
  }

  override def spec: Spec[TestEnvironment with Scope, Any] = suite("Test case created by djx314")(
    test("Simple adt fold in test data.") {
      val baseValue = 2

      def assert1 = {
        val data     = None
        val foldData = inputOptData(data)
        assert(foldData)(Assertion.equalTo(TempForData("None", data)))
      }

      def assert2 = {
        val data     = Option(baseValue)
        val foldData = inputOptData(data)
        assert(foldData)(Assertion.equalTo(TempForData("Option", Option(baseValue + 2))))
      }

      def assert3 = {
        val data     = Some(baseValue)
        val foldData = inputOptData(data)
        assert(foldData)(Assertion.equalTo(TempForData("Some", Some(baseValue + 1))))
      }

      try assert1 && assert2 && assert3
      catch {
        case _: StackOverflowError => assertNever("Not allow adt access.")
      }
    }
  )
}
