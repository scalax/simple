package net.scalax.simple.adt
package test

import net.scalax.simple.adt.{TypeAdt => Adt}
import io.circe._
import io.circe.syntax._
import scala.collection.compat._

import zio._
import zio.test._
import zio.test.Assertion._

/** @author
  *   djx314
  */
object TestCase3 extends ZIOSpecDefault {

  def inputAdtData[T: Encoder: Adt.Failed.Options2[*, Int, Option[Int]]](t: T): Json = t.asJson

  override def spec: Spec[TestEnvironment with Scope, Any] = suite("Test case created by djx314-2")(
    test("Simple adt fold in test data.") {
      val baseValue = 2

      def assert1 = {
        val data     = None
        val foldData = inputAdtData(data)
        assert(foldData)(Assertion.equalTo(data.asJson))
      }

      def assert2 = {
        val data     = Option(baseValue)
        val foldData = inputAdtData(data)
        assert(foldData)(Assertion.equalTo(baseValue.asJson))
      }

      def assert3 = {
        val data     = Some(baseValue)
        val foldData = inputAdtData(data)
        assert(foldData)(Assertion.equalTo(baseValue.asJson))
      }

      /*def assert4 = {
        val baseValue = "joisrjweohrjiew hrio"
        val data      = Some(baseValue)
        val foldData  = inputAdtData(data)
        assert(foldData)(Assertion.equalTo(baseValue.asJson))
      }*/

      try assert1 && assert2 && assert3 // && assert4
      catch {
        case _: StackOverflowError => assertNever("Not allow adt access.")
      }
    }
  )
}
