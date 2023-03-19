package net.scalax.simple.adt.test

object `Test Cases copy from documention in README.md` {

  println("Test cases for doc started.")

  def assert(value: => Boolean): Unit = {
    val result = {
      try value
      catch {
        case _: Throwable => false
      }
    }

    if (!result) throw new Exception("Error Assert")
  }

  def `Common usage - compare with Scala sealed trait`[T](body: => T): T = body

  `Common usage - compare with Scala sealed trait` {
    import scala.util.Try

    // sealed trait style
    sealed trait AdtData
    case class IntAdtData(intValue: Int)           extends AdtData
    case class StringAdtData(strValue: String)     extends AdtData
    case class DoubleAdtData(decimalValue: Double) extends AdtData

    def inputAdtDataSealedTrait(adtData: AdtData): Option[BigDecimal] = adtData match {
      case IntAdtData(intValue)       => Some(BigDecimal(intValue))
      case StringAdtData(strValue)    => Try(BigDecimal(strValue)).toOption
      case DoubleAdtData(doubleValue) => Some(BigDecimal(doubleValue))
    }

    assert(inputAdtDataSealedTrait(IntAdtData(2)).get == BigDecimal("2"))
    assert(inputAdtDataSealedTrait(StringAdtData("6")).get == BigDecimal("6"))
    assert(inputAdtDataSealedTrait(DoubleAdtData(2.3620)).get == BigDecimal("2.362"))
    assert(inputAdtDataSealedTrait(StringAdtData("error number")) == None)

    // simple-adt style
    import net.scalax.simple.adt.{TypeAdt => Adt}
    def inputAdtDataSimple[T: Adt.Options3[*, Int, String, Double]](t: T): Option[BigDecimal] = {
      val applyM = Adt.Options3[Int, String, Double](t)
      applyM.fold(
        intValue => Some(BigDecimal(intValue)),
        strValue => Try(BigDecimal(strValue)).toOption,
        doubleValue => Some(BigDecimal(doubleValue))
      )
    }

    assert(inputAdtDataSimple(2).get == BigDecimal("2"))
    assert(inputAdtDataSimple("6").get == BigDecimal("6"))
    assert(inputAdtDataSimple(2.3620).get == BigDecimal("2.362"))
    assert(inputAdtDataSimple("error number") == None)
  }

  def `Usage of @djx314 Point 1`[T](body: => T): T = body

  `Usage of @djx314 Point 1` {
    import net.scalax.simple.adt.{TypeAdt => Adt}

    def inputAdtData[T: Adt.Options3[*, None.type, Some[Int], Option[Int]]](t: T): (String, Int) = {
      val applyM = Adt.Options3[None.type, Some[Int], Option[Int]](t)
      applyM.fold(
        noneValue => ("None", -100),
        intSome => ("Some", intSome.get + 1),
        intOpt => ("Option", intOpt.map(_ + 2).getOrElse(-500))
      )
    }

    assert(inputAdtData(None) == ("None", -100))
    assert(inputAdtData(Option(2)) == ("Option", 2 + 2))
    assert(inputAdtData(Some(2)) == ("Some", 2 + 1))
    assert(inputAdtData(Option.empty[Int]) == ("Option", -500))
  }

  def `Usage of @djx314 Point 2`[T](body: => T): T = body

  `Usage of @djx314 Point 2` {
    import net.scalax.simple.adt.{TypeAdt => Adt}
    import io.circe._
    import io.circe.syntax._

    def inputAdtData[T: Adt.Options3[*, None.type, Option[Int], Adt.Implicitly[Encoder[T]]]](t: T): Json = {
      val applyM = Adt.Options3[None.type, Option[Int], Adt.Implicitly[Encoder[T]]](t)
      applyM.fold(
        noneValue => "Null Tag".asJson,
        intOpt => intOpt.map(_ + 1).asJson,
        { case Adt.Adapter(encoder) => encoder(t) }
      )
    }

    assert(inputAdtData(None) == "Null Tag".asJson)
    assert(inputAdtData(Some(2)) == (2 + 1).asJson)
    // Match Encoder[String] by Type Class matching.
    assert(inputAdtData("My Name") == "My Name".asJson)
    // Match Encoder[JsonObject] by Type Class matching.
    assert(inputAdtData(JsonObject.empty) == Map.empty[String, String].asJson)
  }

  def `Usage of @djx314 Point 3`[T](body: => T): T = body

  `Usage of @djx314 Point 3` {
    import net.scalax.simple.adt.{TypeAdt => Adt}
    import io.circe._
    import io.circe.syntax._

    object JsonAdtPoly {
      implicit def jsonAdtPolyImplicit[In: Encoder, Poly]: Adt.Context[In, Json, Poly] = {
        val encoder = Encoder[In]
        Adt.Context(t => encoder(t))
      }
    }

    def inputAdtData[T: Adt.Options3[*, None.type, Option[Int], Adt.Adapter[Json, JsonAdtPoly.type]]](t: T): Json = {
      val applyM = Adt.Options3[None.type, Option[Int], Adt.Adapter[Json, JsonAdtPoly.type]](t)
      applyM.fold(
        noneValue => "Null Tag".asJson,
        intOpt => intOpt.map(_ + 1).asJson,
        { case Adt.Adapter(jsonValue) => jsonValue }
      )
    }

    assert(inputAdtData(None) == "Null Tag".asJson)
    assert(inputAdtData(Some(2)) == (2 + 1).asJson)
    // Use Adt.Adapter that find the io.circe.Encoder for String
    assert(inputAdtData("My Name") == "My Name".asJson)
    // Use Adt.Adapter that find the io.circe.Encoder for JsonObject
    assert(inputAdtData(JsonObject.empty) == Map.empty[String, String].asJson)
    // Bypass compiler judgment
    assert(inputAdtData(Adt.Adapter[Json, JsonAdtPoly.type]("Test Adapter".asJson)) == "Test Adapter".asJson)
  }

  def `Usage of @djx314 Point 4`[T](body: => T): T = body

  `Usage of @djx314 Point 4` {
    import net.scalax.simple.adt.{TypeAdt => Adt}
    import io.circe._
    import io.circe.syntax._

    def inputAdtData[S <: Adt.Status, T: Encoder: Adt.OptionsX2[*, S, Int, Option[Int]]](t: T)(implicit cv: S <:< Adt.Status.Failed): Json =
      t.asJson

    // inputAdtData(None)              // Compile Failed
    // inputAdtData(??? : Some[Int])   // Compile Failed
    // inputAdtData(??? : Option[Int]) // Compile Failed
    // inputAdtData(2)                 // Compile Failed

    assert(inputAdtData(2L) == 2.asJson)
    assert(inputAdtData(Some("Tom")) == "Tom".asJson)
  }

  def `Usage of @MarchLiu Point 1`[T](body: => T): T = body

  `Usage of @MarchLiu Point 1` {
    import net.scalax.simple.adt.{TypeAdt => Adt}

    type Options3F[F[_], T, T1, T2, T3] = Adt.Options3[F[T], T1, T2, T3]

    def inputAdtData[T: Options3F[Seq, *, Seq[String], Seq[Int], Seq[Option[Long]]]](t: T*): Seq[Long] = {
      val applyM = Adt.Options3[Seq[String], Seq[Int], Seq[Option[Long]]](t)
      applyM.fold(
        stringSeq => stringSeq.map(t => t.length.toLong),
        intSeq => intSeq.map(t => t.toLong),
        longOptSeq => longOptSeq.collect { case Some(s) => s }
      )
    }

    assert(inputAdtData("abc", "aabbcc", "aabbbcc") == List("abc".length: Long, "aabbcc".length: Long, "aabbbcc".length: Long))
    assert(inputAdtData(2, 3, 4) == List(2L, 3L, 4L))
    assert(inputAdtData(Some(2L), Some(3L), Some(4L)) == List(2L, 3L, 4L))
  }

  def `Usage of @MarchLiu Point 2`[T](body: => T): T = body

  `Usage of @MarchLiu Point 2` {
    import net.scalax.simple.adt.{TypeAdt => Adt}

    type Options2F[F[_], T, T1, T2] = Adt.Options2[F[T], T1, T2]

    def countAdtData[T: Options2F[Seq, *, Seq[Option[Int]], Seq[String]]: Adt.Options2[*, Option[Int], String]](t: T*): Int = {
      def applyMSeq       = Adt.Options2[Seq[Option[Int]], Seq[String]](t)
      def applyM(elem: T) = Adt.Options2[Option[Int], String](elem)

      t.size match {
        case 0 => applyMSeq.fold(emptyOptIntSeq => -100, emptyStringSeq => -500)
        case 1 =>
          val countValue: Int = applyM(t.head).fold(optInt => optInt.getOrElse(0), str => str.length)
          countValue + 1
        case _ => applyMSeq.fold(optIntSeq => optIntSeq.map(_.getOrElse(0)).sum, strSeq => strSeq.map(_.length).sum)
      }
    }

    assert(countAdtData("abc", "aabbcc", "aabbbcc") == ("abc".length + "aabbcc".length + "aabbbcc".length))
    assert(countAdtData(Some(2), Some(3), Option.empty) == (2 + 3 + 0))

    // Point what type you want to route to
    assert(countAdtData[Option[Int]]() == -100)
    assert(countAdtData[String]() == -500)

    assert(countAdtData(Some(2)) == (2 + 1))
    assert(countAdtData(Option.empty) == (0 + 1))
    assert(countAdtData("Option.empty") == (12 + 1))
    assert(countAdtData(Option.empty, Option.empty, Option.empty) == (0 + 0 + 0))
  }

}

import zio._
import zio.test._
import zio.test.Assertion._
object ZioTestCaseForDoc extends ZIOSpecDefault {
  override def spec: Spec[TestEnvironment with Scope, Any] = suite("Test case for doc in README.md")(
    test("Confirm Doc")(
      assert(`Test Cases copy from documention in README.md`)(Assertion.equalTo(`Test Cases copy from documention in README.md`))
    )
  )
}
