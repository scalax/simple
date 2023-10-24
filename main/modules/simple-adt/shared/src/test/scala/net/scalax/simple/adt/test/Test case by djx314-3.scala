package net.scalax.simple.adt
package test

import net.scalax.simple.adt.{TypeAdt => Adt}
import io.circe._
import io.circe.syntax._
import scala.collection.compat._
import net.scalax.simple.test.SimpleCompat._

import zio._
import zio.test._
import zio.test.Assertion._

/** @author
  *   djx314
  */
object TestCase3 extends ZIOSpecDefault {

  def inputAdtData[S <: Adt.Status, T: Encoder: Adt.CoProductsX2[*, S, Int, Option[Int]]](t: T)(implicit
    cv: S <:< Adt.Status.NotFinished
  ): Json =
    t.asJson

  override def spec: Spec[TestEnvironment with Scope, Any] = suite("Test case created by djx314-2")(
    test("Simple adt fold in test data.") {

      def asserts = TestResult.allSuccesses(
        {

          val data = None
          // Compile Failed
          // inputAdtData(data)
          assertTrue(true)

        }, {

          val data = Option(2)
          // Compile Failed
          // inputAdtData(data)
          assertTrue(true)

        }, {

          val data = Some(2)
          // Compile Failed
          // inputAdtData(data)
          assertTrue(true)

        }, {

          val data = 2
          // Compile Failed
          // inputAdtData(data)
          assertTrue(true)

        }, {

          val data     = 2L
          val foldData = inputAdtData(data)
          assertTrue(true)
          assert(foldData)(Assertion.equalTo(2L.asJson))

        }, {

          val baseValue = "joisrjweohrjiew hrio"
          val data      = Some(baseValue)
          val foldData  = inputAdtData(data)
          assert(foldData)(Assertion.equalTo(baseValue.asJson))

        }
      )

      try asserts
      catch {
        case _: StackOverflowError => assertNever("Not allow adt access.")
      }
    }
  )
}
