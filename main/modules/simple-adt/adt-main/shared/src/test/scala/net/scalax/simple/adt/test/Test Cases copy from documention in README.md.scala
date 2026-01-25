package net.scalax.simple.adt.test

import net.scalax.simple.test.Tag
import scala.collection.compat._

object `Test Cases copy from documention in README.md` {

  println("Test cases for doc started.")

  def `Common usage - compare with Scala sealed trait`[T](body: => T): T = body

  `Common usage - compare with Scala sealed trait` {
    {
      // sealed trait style
      import scala.util.Try

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
    }

    {
      {
        // simple-adt common style
        import net.scalax.simple.adt.{TypeAdt => Adt}
        import scala.util.Try

        def inputAdtDataSimple[T: Adt.CoProducts3[*, Int, String, Double]](t: T): Option[BigDecimal] = {
          val applyM = Adt.CoProduct3[Int, String, Double].instance(t)

          applyM
            .fold3(intValue => Some(BigDecimal(intValue)))
            .fold2(strValue => Try(BigDecimal(strValue)).toOption)
            .fold1(doubleValue => Some(BigDecimal(doubleValue)))
        }

        assert(inputAdtDataSimple(2).get == BigDecimal("2"))
        assert(inputAdtDataSimple("6").get == BigDecimal("6"))
        assert(inputAdtDataSimple(2.3620).get == BigDecimal("2.362"))
        assert(inputAdtDataSimple("error number") == None)
      }

      {
        // simple-adt match case style
        import net.scalax.simple.adt.{TypeAdt => Adt}
        import scala.util.Try

        def inputAdtDataSimple[T: Adt.CoProducts3[*, Int, String, Double]](t: T): Option[BigDecimal] = {
          val applyM = Adt.CoProduct3[Int, String, Double].instance(t)
          applyM match {
            case Adt.CoProduct1(intValue)    => Some(BigDecimal(intValue))
            case Adt.CoProduct2(strValue)    => Try(BigDecimal(strValue)).toOption
            case Adt.CoProduct3(doubleValue) => Some(BigDecimal(doubleValue))
          }
        }

        assert(inputAdtDataSimple(2).get == BigDecimal("2"))
        assert(inputAdtDataSimple("6").get == BigDecimal("6"))
        assert(inputAdtDataSimple(2.3620).get == BigDecimal("2.362"))
        assert(inputAdtDataSimple("error number") == None)
      }
    }
  }

  def `Usage of @djx314 Point 1`[T](body: => T): T = body

  `Usage of @djx314 Point 1` {
    {
      // simple-adt common style
      import net.scalax.simple.adt.{TypeAdt => Adt}

      def inputAdtData[T: Adt.CoProducts3[*, None.type, Some[Int], Option[Int]]](t: T): (String, Int) = {
        val applyM = Adt.CoProduct3[None.type, Some[Int], Option[Int]].instance(t)
        applyM
          .fold3(noneValue => ("None", -100))
          .fold2(intSome => ("Some", intSome.get + 1))
          .fold1(intOpt => ("Option", intOpt.map(_ + 2).getOrElse(-500)))
      }

      assert(inputAdtData(None) == ("None", -100))
      assert(inputAdtData(Option(2)) == ("Option", 2 + 2))
      assert(inputAdtData(Some(2)) == ("Some", 2 + 1))
      assert(inputAdtData(Option.empty[Int]) == ("Option", -500))
    }

    {
      // simple-adt match case style
      import net.scalax.simple.adt.{TypeAdt => Adt}

      def inputAdtData[T: Adt.CoProducts3[*, None.type, Some[Int], Option[Int]]](t: T): (String, Int) = {
        val applyM = Adt.CoProduct3[None.type, Some[Int], Option[Int]].instance(t)
        applyM match {
          case Adt.CoProduct1(noneValue) => ("None", -100)
          case Adt.CoProduct2(intSome)   => ("Some", intSome.get + 1)
          case Adt.CoProduct3(intOpt)    => ("Option", intOpt.map(_ + 2).getOrElse(-500))
        }
      }

      assert(inputAdtData(None) == ("None", -100))
      assert(inputAdtData(Option(2)) == ("Option", 2 + 2))
      assert(inputAdtData(Some(2)) == ("Some", 2 + 1))
      assert(inputAdtData(Option.empty[Int]) == ("Option", -500))
    }
  }

  def `Usage of @djx314 Point 2`[T](body: => T): T = body

  `Usage of @djx314 Point 2` {
    import net.scalax.simple.adt.{TypeAdt => Adt}

    def inputAdtData(t: (Adt.CoProduct3Apply[String, Int, Option[Long]] => Adt.CoProduct3[String, Int, Option[Long]])*): Seq[Long] = {
      val seq1 = for (u <- t) yield {
        val applyM = u(Adt.CoProduct3[String, Int, Option[Long]])
        applyM.fold3(t => Some(t.length.toLong)).fold2(t => Some(t.toLong)).fold1(identity)
      }

      seq1.collect { case Some(t) => t }
    }

    assert(inputAdtData(_.instance(2), _.instance("aabbcc"), _.instance(Option(4L))) == List(2L, 6L, 4L))

    assert(
      inputAdtData(_.instance(2), _.instance("aabbcc"), _.instance("aabbbcc")) == List(
        2: Long,
        "aabbcc".length: Long,
        "aabbbcc".length: Long
      )
    )
    assert(inputAdtData(_.instance(Some(2L)), _.instance(Some(3L)), _.instance(Some(4L))) == List(2L, 3L, 4L))
  }

  def `Usage of @MarchLiu Point 1`[T](body: => T): T = body

  `Usage of @MarchLiu Point 1` {
    import net.scalax.simple.adt.{TypeAdt => Adt}

    type Options3F[F[_], T, T1, T2, T3] = Adt.CoProducts3[F[T], T1, T2, T3]

    def inputAdtData[T: Options3F[Seq, *, Seq[String], Seq[Int], Seq[Option[Long]]]](t: T*): Seq[Long] = {
      val applyM = Adt.CoProduct3[Seq[String], Seq[Int], Seq[Option[Long]]].instance(t)

      applyM
        .fold3(stringSeq => stringSeq.map(t => t.length.toLong))
        .fold2(intSeq => intSeq.map(t => t.toLong))
        .fold1(longOptSeq => longOptSeq.collect { case Some(s) => s })
    }

    assert(inputAdtData("abc", "aabbcc", "aabbbcc") == List("abc".length: Long, "aabbcc".length: Long, "aabbbcc".length: Long))
    assert(inputAdtData(2, 3, 4) == List(2L, 3L, 4L))
    assert(inputAdtData(Some(2L), Some(3L), Some(4L)) == List(2L, 3L, 4L))
  }

  def `Usage of @MarchLiu Point 2`[T](body: => T): T = body

  `Usage of @MarchLiu Point 2` {
    import net.scalax.simple.adt.{TypeAdt => Adt}

    type Options2F[F[_], T, T1, T2] = Adt.CoProducts2[F[T], T1, T2]

    def countAdtData[T: Options2F[Seq, *, Seq[Option[Int]], Seq[String]]: Adt.CoProducts2[*, Option[Int], String]](t: T*): Int = {
      def foldableSeq: Adt.CoProduct2[Seq[Option[Int]], Seq[String]] = Adt.CoProduct2[Seq[Option[Int]], Seq[String]].instance(t)
      val applyM: Adt.CoProduct2Apply[Option[Int], String]           = Adt.CoProduct2[Option[Int], String]

      t.size match {
        case 0 => foldableSeq.fold2(emptyOptIntSeq => -100).fold1(emptyStringSeq => -500)
        case 1 =>
          val countValue: Int = applyM.instance(t.head).fold2(optInt => optInt.getOrElse(0)).fold1(str => str.length)
          countValue + 1
        case _ => foldableSeq.fold2(optIntSeq => optIntSeq.map(_.getOrElse(0)).sum).fold1(strSeq => strSeq.map(_.length).sum)
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

  def `Usage of @MarchLiu Point 3`[T](body: => T): T = body

  `Usage of @MarchLiu Point 3` {
    import net.scalax.simple.adt.{TypeAdt => Adt}

    def countAdtData[T: Adt.CoProducts2[*, Option[Int], String]](t: T*): List[Int] = {
      val funcApplyM = Adt.CoProduct2[Option[Int], String].typeOnly[T]

      val inputList = t.to(List)

      funcApplyM
        .fold2(func1 =>
          for (tItem <- inputList) yield {
            val tempVar: Option[Int] = func1.adtFunctionApply(tItem)
            tempVar.map(_ + 100).getOrElse(-100)
          }
        )
        .fold1(func2 => for (tItem <- inputList) yield func2.adtFunctionApply(tItem).length)
    }

    assert(countAdtData("abc", "aabbcc", "aabbbcc") == List("abc".length, "aabbcc".length, "aabbbcc".length))
    assert(countAdtData(Some(2), Some(3), Option.empty) == List(102, 103, -100))
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
