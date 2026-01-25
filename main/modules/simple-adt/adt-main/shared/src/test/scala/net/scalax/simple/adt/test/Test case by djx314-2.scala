package net.scalax.simple.adt.test

import net.scalax.simple.adt.{TypeAdt => Adt}
import scala.collection.compat._
import net.scalax.simple.test.SimpleCompat._

import zio._
import zio.test._
import zio.test.Assertion._

/** @author
  *   djx314
  */
object TestCase2 extends ZIOSpecDefault {

  case class TempForData(typeName: String, value: Option[Int])
  def inputAdtData(
    t: Adt.CoProduct3Apply[None.type, Some[Int], Option[Int]] => Adt.CoProduct3[None.type, Some[Int], Option[Int]]
  ): TempForData = {
    val applyM = t(Adt.CoProduct3[None.type, Some[Int], Option[Int]])

    applyM
      .fold3(n => TempForData("None", n))
      .fold2(n => TempForData("Some", Some(n.get + 1)))
      .fold1(n => TempForData("Option", n.map(_ + 2)))
  }

  override def spec: Spec[TestEnvironment with Scope, Any] = suite("Test case created by djx314-1")(
    test("Simple adt fold in test data.") {
      val baseValue = 2

      def asserts = TestResult.allSuccesses(
        {

          val data     = None
          val foldData = inputAdtData(_.instance(data))
          assert(foldData)(Assertion.equalTo(TempForData("None", data)))

        }, {

          val data     = Option(baseValue)
          val foldData = inputAdtData(_.instance(data))
          assert(foldData)(Assertion.equalTo(TempForData("Option", Option(baseValue + 2))))

        }, {

          val data     = Some(baseValue)
          val foldData = inputAdtData(_.instance(data))
          assert(foldData)(Assertion.equalTo(TempForData("Some", Some(baseValue + 1))))

        }
      )

      try asserts
      catch {
        case _: StackOverflowError => assertNever("Not allow adt access.")
      }
    }
  )
}
