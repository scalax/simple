# simple-adt

## Import
This module is available for both JVM and Scala.js. You could add it in your `build.sbt`.
``` sbt
// For JVM projects
libraryDependencies += "net.scalax.simple" %% "simple-adt" % "latest.version"
```
``` sbt
// For Scala.js projects, or JS/JVM cross projects
libraryDependencies += "net.scalax.simple" %%% "simple-adt" % "latest.version"
```
For scala2, you can add the compiler plugin `kind-projector`.
``` sbt
addCompilerPlugin("org.typelevel" % "kind-projector" % "0.13.2" cross CrossVersion.full)
```
For scala3, you can add the scalac option.
``` sbt
scalacOptions += "-Ykind-projector"
```

Usage in [Test Case](./core/shared/src/test/scala-no-js/net/scalax/simple/adt/test/TestCaseForDoc.scala)
## Usage of [@djx314](https://github.com/djx314)
### Point 1
Match type by `Adt.OptionsX`(The type will be match first if it's declaring first).
``` scala
import net.scalax.simple.adt.{TypeAdt => Adt}

def inputAdtData[T: Adt.Options3[*, None.type, Some[Int], Option[Int]]](t: T): (String, Option[Int]) = {
  val applyM = Adt.Options3[None.type, Some[Int], Option[Int]](t)
  applyM.fold(noneValue => ("None", noneValue), intSome => ("Some", Some(intSome.get + 1)), intOpt => ("Option", intOpt.map(_ + 2)))
}

assert(inputAdtData(None) == ("None", None))
assert(inputAdtData(Option(2)) == ("Option", Some(4)))
assert(inputAdtData(Some(2)) == ("Some", Some(3)))
```

### Point 2
Match type with custom rules by `Adt.Adapter`.
``` scala
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
    noneValue => "Null Tag".asJson,
    intOpt => intOpt.map(_ + 1).asJson,
    { (n: Adt.Adapter[Json, JsonAdtPoly.type]) =>
      n.value: Json
    }
  )
}

assert(inputAdtData(None) == "Null Tag".asJson)
assert(inputAdtData(Some(2)) == 3.asJson)
// Use Adt.Adapter that find the io.circe.Encoder for String
assert(inputAdtData("My Name") == "My Name".asJson)
// Use Adt.Adapter that find the io.circe.Encoder for JsonObject
assert(inputAdtData(JsonObject.empty) == Map.empty[String, String].asJson)
// Bypass compiler judgment
assert(inputAdtData(Adt.Adapter[Json, JsonAdtPoly.type]("Test Adapter".asJson)) == "Test Adapter".asJson)
```

### Point 3
Exclue special types.
``` scala
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
```

## Usage of [@MarchLiu](https://marchliu.github.io/)
Related project: [scala-workers/commons-lang3-bridge](https://github.com/scala-workers/commons-lang3-bridge)

### Point 1
Match type for parameter list.
``` scala
import net.scalax.simple.adt.{TypeAdt => Adt}

type Options3F[F[_], T, T1, T2, T3] = Adt.Options3[F[T], T1, T2, T3]

def inputAdtData[T: Options3F[Seq, *, Seq[String], Seq[Int], Seq[Option[Long]]]](t: T*): Seq[Option[Long]] = {
  val applyM = Adt.Options3[Seq[String], Seq[Int], Seq[Option[Long]]](t)
  applyM.fold(
    stringSeq => stringSeq.map(t => Some(t.length.toLong)),
    intSeq => intSeq.map(t => Some(t.toLong)),
    longOptSeq => longOptSeq
  )
}

assert(inputAdtData("abc", "aabbcc", "aabbbcc") == List("abc", "aabbcc", "aabbbcc").map(t => Some(t.length.toLong)))
assert(inputAdtData(2, 3, 4) == List(Some(2L), Some(3L), Some(4L)))
assert(inputAdtData(Some(2L), Some(3L), Some(4L)) == List(Some(2L), Some(3L), Some(4L)))
```

### Point 2
Match one type twice to do different things.
``` scala
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

assert(countAdtData("abc", "aabbcc", "aabbbcc") == 16)
assert(countAdtData(Some(2), Some(3), Option.empty) == 5)

// Point what type you want to route to
assert(countAdtData[Option[Int]]() == -100)
assert(countAdtData[String]() == -500)

assert(countAdtData(Some(2)) == (2 + 1))
assert(countAdtData(Option.empty) == (0 + 1))
assert(countAdtData("Option.empty") == (12 + 1))
assert(countAdtData(Option.empty, Option.empty, Option.empty) == 0)
```
