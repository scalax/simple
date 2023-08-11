package net.scalax.simple.adt.test

import net.scalax.simple.test.Tag

object `Test Cases copy from documention in README.md` {

  println("Test cases for doc started.")

  def assert(value: => Boolean): Unit = {
    val result =
      try value
      catch {
        case _: Throwable => false
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

    trait WithEncoder {
      type T
      def model: T
      def encode: Encoder[T]
    }

    object WithEncoder {
      def apply[U](t: U)(en: Encoder[U]): WithEncoder = new WithEncoder {
        override type T = U
        override def model: U           = t
        override def encode: Encoder[U] = en
      }
    }

    def inputAdtData[T: Adt.Options4[*, None.type, Option[Int], Adt.Implicitly[Encoder[T]], WithEncoder]](t: T): Json = {
      val applyM = Adt.Options4[None.type, Option[Int], Adt.Implicitly[Encoder[T]], WithEncoder](t)
      applyM.fold(
        noneValue => "Null Tag".asJson,
        intOpt => intOpt.map(_ + 1).asJson,
        { case Adt.Adapter(encoder) => encoder(t) },
        withEncoder => withEncoder.encode(withEncoder.model)
      )
    }

    assert(inputAdtData(None) == "Null Tag".asJson)
    assert(inputAdtData(Some(2)) == (2 + 1).asJson)
    assert(inputAdtData(JsonObject.empty.asJson) == Map.empty[String, String].asJson)
    // Bypass compiler judgment
    assert(inputAdtData(WithEncoder("My Name")(Encoder[String].contramap(t => t + " appended"))) == "My Name appended".asJson)
  }

  def `Usage of @djx314 Point 4`[T](body: => T): T = body

  `Usage of @djx314 Point 4` {
    import net.scalax.simple.adt.{TypeAdt => Adt}
    import io.circe._
    import io.circe.syntax._

    def inputAdtData[S <: Adt.Status, T: Encoder: Adt.OptionsX2[*, S, Int, Option[Int]]](t: T)(implicit
      cv: S <:< Adt.Status.NotFinished
    ): Json = t.asJson

    // inputAdtData(None)              // Compile Failed
    // inputAdtData(??? : Some[Int])   // Compile Failed
    // inputAdtData(??? : Option[Int]) // Compile Failed
    // inputAdtData(2)                 // Compile Failed

    assert(inputAdtData(2L) == 2.asJson)
    assert(inputAdtData(Some("Tom")) == "Tom".asJson)
  }

  def `Usage of @djx314 Point 5`[T](body: => T): T = body

  `Usage of @djx314 Point 5` {
    {
      import net.scalax.simple.adt.{TypeAdt => Adt}
      import scala.util.Try
      def inputAdtDataSimple[T: Adt.Options3[*, Int, String, Double]](t: T): Option[BigDecimal] = {
        val applyM = Adt.Options3[Int, String, Double](t)
        Tag.assertType(Tag(applyM), Tag[Adt.Option3[Int, String, Double]]) // Confirm Type
        applyM match {
          case Adt.Option1(intValue)    => Some(BigDecimal(intValue))
          case Adt.Option2(strValue)    => Try(BigDecimal(strValue)).toOption
          case Adt.Option3(doubleValue) => Some(BigDecimal(doubleValue))
          case Adt.Option4(empty)       => empty.matchErrorAndNothing // Keep safe for API changed
          case Adt.Option5(empty)       => empty.matchErrorAndNothing
          case Adt.Option6(empty)       => empty.matchErrorAndNothing
        }
      }

      assert(inputAdtDataSimple(2).get == BigDecimal("2"))
      assert(inputAdtDataSimple("6").get == BigDecimal("6"))
      assert(inputAdtDataSimple(2.3620).get == BigDecimal("2.362"))
      assert(inputAdtDataSimple("error number") == None)
    }

    {
      import net.scalax.simple.adt.{TypeAdt => Adt}

      def inputAdtData[T: Adt.Options3[*, None.type, Some[Int], Option[Int]]](t: T): (String, Int) = {
        val applyM = Adt.Options3[None.type, Some[Int], Option[Int]](t)
        Tag.assertType(Tag(applyM), Tag[Adt.Option3[None.type, Some[Int], Option[Int]]]) // Confirm Type
        applyM match {
          case Adt.Option1(noneValue) => ("None", -100)
          case Adt.Option2(intSome)   => ("Some", intSome.get + 1)
          case Adt.Option3(intOpt)    => ("Option", intOpt.map(_ + 2).getOrElse(-500))
          case Adt.Option4(empty)     => empty.matchErrorAndNothing // Keep safe for API changed
          case Adt.Option5(empty)     => empty.matchErrorAndNothing
          case Adt.Option6(empty)     => empty.matchErrorAndNothing
        }
      }

      assert(inputAdtData(None) == ("None", -100))
      assert(inputAdtData(Option(2)) == ("Option", 2 + 2))
      assert(inputAdtData(Some(2)) == ("Some", 2 + 1))
      assert(inputAdtData(Option.empty[Int]) == ("Option", -500))
    }

    {
      import net.scalax.simple.adt.{TypeAdt => Adt}
      import io.circe._
      import io.circe.syntax._

      def inputAdtData[T: Adt.Options3[*, None.type, Option[Int], Adt.Implicitly[Encoder[T]]]](t: T): Json = {
        val applyM = Adt.Options3[None.type, Option[Int], Adt.Implicitly[Encoder[T]]](t)
        Tag.assertType(Tag(applyM), Tag[Adt.Option3[None.type, Option[Int], Adt.Implicitly[Encoder[T]]]]) // Confirm Type
        applyM match {
          case Adt.Option1(noneValue)            => "Null Tag".asJson
          case Adt.Option2(intOpt)               => intOpt.map(_ + 1).asJson
          case Adt.Option3(Adt.Adapter(encoder)) => encoder(t)
          case Adt.Option4(empty)                => empty.matchErrorAndNothing // Keep safe for API changed
          case Adt.Option5(empty)                => empty.matchErrorAndNothing
          case Adt.Option6(empty)                => empty.matchErrorAndNothing
        }
      }

      assert(inputAdtData(None) == "Null Tag".asJson)
      assert(inputAdtData(Some(2)) == (2 + 1).asJson)
      // Match Encoder[String] by Type Class matching.
      assert(inputAdtData("My Name") == "My Name".asJson)
      // Match Encoder[JsonObject] by Type Class matching.
      assert(inputAdtData(JsonObject.empty) == Map.empty[String, String].asJson)
    }

    {
      import net.scalax.simple.adt.{TypeAdt => Adt}
      import io.circe.{Encoder, Json}
      import io.circe.syntax._

      def inputAdtData[S <: Adt.Status, T: Encoder: Adt.OptionsX2[*, S, Int, Option[Int]]](t: T): Json = {
        val applyM = Adt.Options2[Int, Option[Int]](t)
        Tag.assertType(Tag(applyM), Tag[Adt.OptionX2[S, Int, Option[Int]]]) // Confirm Type
        applyM match {
          case Adt.Option1(intData) => (intData + 10000).asJson
          case Adt.Option2(optData) =>
            val opt = for (intData <- optData) yield intData + 20000
            opt.asJson
          case Adt.Option3(other) => other.default(t.asJson) // For match failed
          case Adt.Option4(other) => other.default(t.asJson)
          case Adt.Option5(other) => other.default(t.asJson)
          case Adt.Option6(other) => other.default(t.asJson)
        }
      }

      assert(inputAdtData(None) == None.asJson)
      assert(inputAdtData(Some(5): Some[Int]) == (5 + 20000).asJson)
      assert(inputAdtData(Some(8): Option[Int]) == (8 + 20000).asJson)
      assert(inputAdtData(2) == (2 + 10000).asJson)
      assert(inputAdtData(2L) == 2.asJson)
      assert(inputAdtData(Some("Tom")) == "Tom".asJson)
    }
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
    test("Confirm Doc") {
      assert(`Test Cases copy from documention in README.md`)(Assertion.equalTo(`Test Cases copy from documention in README.md`))
    }
  )
}
