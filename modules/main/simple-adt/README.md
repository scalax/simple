# simple-adt

## Import
This module is available for both JVM and Scala.js. You could add it in your `build.sbt`.
``` sbt
// For JVM projects
libraryDependencies += "net.scalax.simple" %% "simple-adt" % "0.0.1-M1"
```
``` sbt
// For Scala.js projects, or JS/JVM cross projects
libraryDependencies += "net.scalax.simple" %%% "simple-adt" % "0.0.1-M1"
```
For scala2, you can add the compiler plugin `kind-projector`.
``` sbt
addCompilerPlugin("org.typelevel" % "kind-projector" % "0.13.2" cross CrossVersion.full)
```
For scala3, you can add the scalac option.
``` sbt
scalacOptions += "-Ykind-projector"
```

## Usage of [@djx314](https://github.com/djx314)
Match type by `Adt.OptionsX`(The type will be match first if it's declaring first).
``` scala
import net.scalax.simple.adt.{TypeAdt => Adt}

def inputAdtData[T: Adt.Options3[*, None.type, Some[Int], Option[Int]]](t: T): TempForData = {
  val applyM = Adt.Options3[None.type, Some[Int], Option[Int]](t)
  applyM.fold(n => TempForData("None", n), n => TempForData("Some", Some(n.get + 1)), n => TempForData("Option", n.map(_ + 2)))
}

assert(inputAdtData(None) == TempForData("None", None))
assert(inputAdtData(Option(2)) == TempForData("Option", Some(4)))
assert(inputAdtData(Some(2)) == TempForData("Some", Some(3)))
```

Match type with custom rules by `Adt.WithContext`.
``` scala
import net.scalax.simple.adt.{TypeAdt => Adt}
import io.circe._
import io.circe.syntax._

object JsonAdtPoly {
  implicit def jsonAdtPolyImplicit[In: Encoder]: AdtContext[In, Json, JsonAdtPoly.type] = {
    val encoder = Encoder[In]
    new AdtContext[In, Json, JsonAdtPoly.type] {
      override def input(t: In): Json = encoder(t)
    }
  }
}

def inputAdtData[T: Adt.Options3[*, None.type, Option[Int], Adt.WithContext[Json, JsonAdtPoly.type]]](t: T): Json = {
  val applyM = Adt.Options3[None.type, Option[Int], Adt.WithContext[Json, JsonAdtPoly.type]](t)
  applyM.fold(n => Json.fromString("Null Tag"), n => n.map(_ + 1).asJson, n => n.value)
}

assert(inputAdtData(None) == "Null Tag".asJson)
assert(inputAdtData(Some(2)) == 3.asJson)
assert(inputAdtData("My Name") == "My Name".asJson)
```

## Usage of [@MarchLiu](https://marchliu.github.io/)
Related project: [scala-workers/commons-lang3-bridge](https://github.com/scala-workers/commons-lang3-bridge)

Match type for parameter list.
``` scala
import net.scalax.simple.adt.{TypeAdt => Adt}

type SeqTpe[T] = Adt.Options3[Seq[T], Seq[String], Seq[Int], Seq[Option[Long]]]
def inputAdtData[T: SeqTpe](t: T*): Seq[Option[Long]] = {
  val applyM = Adt.Options3[Seq[String], Seq[Int], Seq[Option[Long]]](t)
  applyM
    .fold(
      t1 => t1.map(t => Some(t.length.toLong)),
      t2 => t2.map(t => Some(t.toLong)),
      t3 => t3
    )
}

assert(inputAdtData("abc", "aabbcc", "aabbbcc") == List("abc", "aabbcc", "aabbbcc").map(t => Some(t.length.toLong)))
assert(inputAdtData(2, 3, 4) == List(2, 3, 4).map(_.toLong))
```