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
Match type by `TypeOptionsX`(The type will be match first if it's declaring first).
``` scala
import net.scalax.simple.adt.{TypeAdt => Adt}

def inputOptData[T: Adt.Options3[*, None.type, Some[Int], Option[Int]]](t: T): TempForData = {
  val applyM = Adt.instance[Adt.Options3[*, None.type, Some[Int], Option[Int]]]
  applyM.input(t).fold(n => TempForData("None", n), n => TempForData("Some", Some(n.get + 1)), n => TempForData("Option", n.map(_ + 2)))
}

assert(inputOptDat(None) == TempForData("None", None))
assert(inputOptDat(Option(2)) == TempForData("Option", Some(4)))
assert(inputOptDat(Some(2)) == TempForData("Some", Some(3)))
```

## Usage of [@MarchLiu](https://marchliu.github.io/)
Related project: [scala-workers/commons-lang3-bridge](https://github.com/scala-workers/commons-lang3-bridge)

Match type for parameter list.
``` scala
import net.scalax.simple.adt.{TypeAdt => Adt}

type SeqTpe[S] = Adt.Options3[Seq[S], Seq[String], Seq[Int], Seq[Option[Long]]]
def inputOptData[T: SeqTpe](t: T*): Seq[Option[Long]] = {
  type Tpe[S] = Adt.Options3[S, Seq[String], Seq[Int], Seq[Option[Long]]] // Note: Tpe[*] is different from SeqTpe[*]
  val applyM = Adt.instance[Tpe]
  applyM
    .input(t)
    .fold(
      t1 => t1.map(t => Some(t.length.toLong)),
      t2 => t2.map(t => Some(t.toLong)),
      t3 => t3
    )
}

assert(inputOptData("abc", "aabbcc", "aabbbcc") == List("abc", "aabbcc", "aabbbcc").map(t => Some(t.length.toLong)))
assert(inputOptData(2, 3, 4) == List(2, 3, 4).map(_.toLong))
```