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

  def `Usage of @djx314 Point 1`[T](body: => T): T = body

  `Usage of @djx314 Point 1` {
    import net.scalax.simple.adt.{TypeAdt => Adt}

    def inputAdtData[T: Adt.Options3[*, None.type, Some[Int], Option[Int]]](t: T): (String, Option[Int]) = {
      val applyM = Adt.Options3[None.type, Some[Int], Option[Int]](t)
      applyM.fold(n => ("None", n), n => ("Some", Some(n.get + 1)), n => ("Option", n.map(_ + 2)))
    }

    assert(inputAdtData(None) == ("None", None))
    assert(inputAdtData(Option(2)) == ("Option", Some(4)))
    assert(inputAdtData(Some(2)) == ("Some", Some(3)))
  }

  def `Usage of @djx314 Point 2`[T](body: => T): T = body

  `Usage of @djx314 Point 2` {
    import net.scalax.simple.adt.{TypeAdt => Adt}
    import io.circe._
    import io.circe.syntax._

    object JsonAdtPoly {
      implicit def jsonAdtPolyImplicit[In: Encoder]: Adt.Context[In, Json, JsonAdtPoly.type] = {
        val encoder = Encoder[In]
        Adt.Context(t => encoder(t))
      }
    }

    def inputAdtData[T: Adt.Options3[*, None.type, Option[Int], Adt.Adapter[Json, JsonAdtPoly.type]]](t: T): Json = {
      val applyM = Adt.Options3[None.type, Option[Int], Adt.Adapter[Json, JsonAdtPoly.type]](t)
      applyM.fold(
        n => "Null Tag".asJson,
        n => n.map(_ + 1).asJson,
        { (n: Adt.Adapter[Json, JsonAdtPoly.type]) =>
          n.value: Json
        }
      )
    }

    assert(inputAdtData(None) == "Null Tag".asJson)
    assert(inputAdtData(Some(2)) == 3.asJson)
    // Use Adt.Adapter that find the io.circe.Encoder for String.
    assert(inputAdtData("My Name") == "My Name".asJson)
    // Bypass compiler judgment
    assert(inputAdtData(Adt.Adapter[Json, JsonAdtPoly.type]("Test Adapter".asJson)) == "Test Adapter".asJson)
  }

  def `Usage of @djx314 Point 3`[T](body: => T): T = body

  `Usage of @djx314 Point 3` {
    import net.scalax.simple.adt.{TypeAdt => Adt}
    import io.circe._
    import io.circe.syntax._

    def inputAdtData[S <: Adt.Status, T: Encoder: Adt.OptionsX2[*, S, Int, Option[Int]]](t: T)(implicit cv: S <:< Adt.Status.Failed): Json =
      t.asJson

    // inputAdtData(None)              // Compile Failed
    // inputAdtData(??? : Some[Int])   // Compile Failed
    // inputAdtData(??? : Option[Int]) // Compile Failed
    // inputAdtData(2)                 // Compile Failed

    locally {
      val foldData = inputAdtData(2L)
      assert(foldData == 2.asJson)
    }

    locally {
      val foldData = inputAdtData(Some("Tom"))
      assert(foldData == "Tom".asJson)
    }
  }

  def `Usage of @MarchLiu Point 1`[T](body: => T): T = body

  `Usage of @MarchLiu Point 1` {
    import net.scalax.simple.adt.{TypeAdt => Adt}

    type Options3F[F[_], T, T1, T2, T3] = Adt.Options3[F[T], T1, T2, T3]

    def inputAdtData[T: Options3F[Seq, *, Seq[String], Seq[Int], Seq[Option[Long]]]](t: T*): Seq[Option[Long]] = {
      val applyM = Adt.Options3[Seq[String], Seq[Int], Seq[Option[Long]]](t)
      applyM.fold(
        t1 => t1.map(t => Some(t.length.toLong)),
        t2 => t2.map(t => Some(t.toLong)),
        t3 => t3
      )
    }

    assert(inputAdtData("abc", "aabbcc", "aabbbcc") == List("abc", "aabbcc", "aabbbcc").map(t => Some(t.length.toLong)))
    assert(inputAdtData(2, 3, 4) == List(Some(2L), Some(3L), Some(4L)))
    assert(inputAdtData(Some(2L), Some(3L), Some(4L)) == List(Some(2L), Some(3L), Some(4L)))
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
