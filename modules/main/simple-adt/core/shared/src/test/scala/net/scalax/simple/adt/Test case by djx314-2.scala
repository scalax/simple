package net.scalax.simple.adt.test

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
object TestCase2 extends ZIOSpecDefault {

  object JsonAdtPoly {
    implicit def jsonAdtPolyImplicit[In: Encoder]: Adt.Context[In, Json, JsonAdtPoly.type] = {
      val encoder = Encoder[In]
      new Adt.Context[In, Json, JsonAdtPoly.type] {
        override def input(t: In): Json = encoder(t)
      }
    }
  }

  def inputAdtData[T: Adt.Options3[*, None.type, Option[Int], Adt.Adapter[Json, JsonAdtPoly.type]]](t: T): Json = {
    val applyM = Adt.Options3[None.type, Option[Int], Adt.Adapter[Json, JsonAdtPoly.type]](t)
    applyM.fold(n => Json.fromString("Null Tag"), n => n.map(_ + 1).asJson, n => n.value)
  }

  override def spec: Spec[TestEnvironment with Scope, Any] = suite("Test case created by djx314-2")(
    test("Simple adt fold in test data.") {
      val baseValue = 2

      def assert1 = {
        val data     = None
        val foldData = inputAdtData(data)
        assert(foldData)(Assertion.equalTo("Null Tag".asJson))
      }

      def assert2 = {
        val data     = Option(baseValue)
        val foldData = inputAdtData(data)
        assert(foldData)(Assertion.equalTo(Json.fromInt(2 + 1)))
      }

      def assert3 = {
        val data     = Some(baseValue)
        val foldData = inputAdtData(data)
        assert(foldData)(Assertion.equalTo(Json.fromInt(2 + 1)))
      }

      def assert4 = {
        val data     = Some("joisrjweohrjiew hrio")
        val foldData = inputAdtData(data)
        assert(foldData)(Assertion.equalTo(Json.fromString("joisrjweohrjiew hrio")))
      }

      try assert1 && assert2 && assert3 && assert4
      catch {
        case _: StackOverflowError => assertNever("Not allow adt access.")
      }
    }
  )
}
