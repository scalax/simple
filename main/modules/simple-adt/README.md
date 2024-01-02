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

## Usage
[Source File](./core/shared/src/test/scala-no-js/net/scalax/simple/adt/test/Test%20Cases%20copy%20from%20documention%20in%20README.md.scala)

### Common Usage
``` scala
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
```
``` scala
// simple-adt common style
import net.scalax.simple.adt.{TypeAdt => Adt}
import scala.util.Try

def inputAdtDataSimple[T: Adt.CoProducts3[*, Int, String, Double]](t: T): Option[BigDecimal] = {
  val applyM = Adt.CoProduct3[Int, String, Double](t)
  Tag.assertType(Tag(applyM), Tag[Adt.CoProduct3[Int, String, Double]]) // Confirm Type
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
```

``` scala
// simple-adt match case style
import net.scalax.simple.adt.{TypeAdt => Adt}
import scala.util.Try

def inputAdtDataSimple[T: Adt.CoProducts3[*, Int, String, Double]](t: T): Option[BigDecimal] = {
  val applyM = Adt.CoProduct3[Int, String, Double](t)
  Tag.assertType(Tag(applyM), Tag[Adt.CoProduct3[Int, String, Double]]) // Confirm Type
  applyM match {
    case Adt.CoProduct1(intValue)    => Some(BigDecimal(intValue))
    case Adt.CoProduct2(strValue)    => Try(BigDecimal(strValue)).toOption
    case Adt.CoProduct3(doubleValue) => Some(BigDecimal(doubleValue))
    case Adt.CoProduct4(empty)       => empty.matchErrorAndThrowException // Keep safe for API changed
    case Adt.CoProduct5(empty)       => empty.matchErrorAndThrowException
    case Adt.CoProduct6(empty)       => empty.matchErrorAndThrowException
  }
}

assert(inputAdtDataSimple(2).get == BigDecimal("2"))
assert(inputAdtDataSimple("6").get == BigDecimal("6"))
assert(inputAdtDataSimple(2.3620).get == BigDecimal("2.362"))
assert(inputAdtDataSimple("error number") == None)
```

### Usage of [@djx314](https://github.com/djx314)
#### Point 1
Match type by `Adt.CoProductsX`(The type will be match first if it's declaring first).
``` scala
// simple-adt common style
import net.scalax.simple.adt.{TypeAdt => Adt}

def inputAdtData[T: Adt.CoProducts3[*, None.type, Some[Int], Option[Int]]](t: T): (String, Int) = {
  val applyM = Adt.CoProduct3[None.type, Some[Int], Option[Int]](t)
  Tag.assertType(Tag(applyM), Tag[Adt.CoProduct3[None.type, Some[Int], Option[Int]]]) // Confirm Type
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
```

``` scala
// simple-adt match case style
import net.scalax.simple.adt.{TypeAdt => Adt}

def inputAdtData[T: Adt.CoProducts3[*, None.type, Some[Int], Option[Int]]](t: T): (String, Int) = {
  val applyM = Adt.CoProduct3[None.type, Some[Int], Option[Int]](t)
  Tag.assertType(Tag(applyM), Tag[Adt.CoProduct3[None.type, Some[Int], Option[Int]]]) // Confirm Type
  applyM match {
    case Adt.CoProduct1(noneValue) => ("None", -100)
    case Adt.CoProduct2(intSome)   => ("Some", intSome.get + 1)
    case Adt.CoProduct3(intOpt)    => ("Option", intOpt.map(_ + 2).getOrElse(-500))
    case Adt.CoProduct4(empty)     => empty.matchErrorAndThrowException // Keep safe for API changed
    case Adt.CoProduct5(empty)     => empty.matchErrorAndThrowException
    case Adt.CoProduct6(empty)     => empty.matchErrorAndThrowException
  }
}

assert(inputAdtData(None) == ("None", -100))
assert(inputAdtData(Option(2)) == ("Option", 2 + 2))
assert(inputAdtData(Some(2)) == ("Some", 2 + 1))
assert(inputAdtData(Option.empty[Int]) == ("Option", -500))
```

#### Point 2
Match type with Type Class.
``` scala
// simple-adt common style
import net.scalax.simple.adt.{TypeAdt => Adt}
import io.circe._
import io.circe.syntax._

def inputAdtData[T: Adt.CoProducts3[*, None.type, Option[Int], Adt.Implicitly[Encoder[T]]]](t: T): Json = {
  val applyM = Adt.CoProduct3[None.type, Option[Int], Adt.Implicitly[Encoder[T]]](t)
  Tag.assertType(Tag(applyM), Tag[Adt.CoProduct3[None.type, Option[Int], Adt.Implicitly[Encoder[T]]]]) // Confirm Type
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
```

``` scala
// simple-adt match case style
import net.scalax.simple.adt.{TypeAdt => Adt}
import io.circe._
import io.circe.syntax._

def inputAdtData[T: Adt.CoProducts3[*, None.type, Option[Int], Adt.Implicitly[Encoder[T]]]](t: T): Json = {
  val applyM = Adt.CoProduct3[None.type, Option[Int], Adt.Implicitly[Encoder[T]]](t)
  Tag.assertType(Tag(applyM), Tag[Adt.CoProduct3[None.type, Option[Int], Adt.Implicitly[Encoder[T]]]]) // Confirm Type
  applyM match {
    case Adt.CoProduct1(noneValue)            => "Null Tag".asJson
    case Adt.CoProduct2(intOpt)               => intOpt.map(_ + 1).asJson
    case Adt.CoProduct3(Adt.Adapter(encoder)) => encoder(t)
    case Adt.CoProduct4(empty)                => empty.matchErrorAndThrowException // Keep safe for API changed
    case Adt.CoProduct5(empty)                => empty.matchErrorAndThrowException
    case Adt.CoProduct6(empty)                => empty.matchErrorAndThrowException
  }
}

assert(inputAdtData(None) == "Null Tag".asJson)
assert(inputAdtData(Some(2)) == (2 + 1).asJson)
// Match Encoder[String] by Type Class matching.
assert(inputAdtData("My Name") == "My Name".asJson)
// Match Encoder[JsonObject] by Type Class matching.
assert(inputAdtData(JsonObject.empty) == Map.empty[String, String].asJson)
```

#### Point 3
Match type with custom rules when the usage of Type Class([Point 2](#point-2)) is not enough.
``` scala
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

def inputAdtData[T: Adt.CoProducts4[*, None.type, Option[Int], Adt.Implicitly[Encoder[T]], WithEncoder]](t: T): Json = {
  val applyM = Adt.CoProducts4[None.type, Option[Int], Adt.Implicitly[Encoder[T]], WithEncoder](t)
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
```

#### Point 4
Exclue special types.
``` scala
import net.scalax.simple.adt.{TypeAdt => Adt}
import io.circe._
import io.circe.syntax._

def inputAdtData[S <: Adt.Status, T: Encoder: Adt.CoProductsX2[*, S, Int, Option[Int]]](t: T)(implicit cv: S <:< Adt.Status.Failed): Json =
  t.asJson

// inputAdtData(None)              // Compile Failed
// inputAdtData(??? : Some[Int])   // Compile Failed
// inputAdtData(??? : Option[Int]) // Compile Failed
// inputAdtData(2)                 // Compile Failed

assert(inputAdtData(2L) == 2.asJson)
assert(inputAdtData(Some("Tom")) == "Tom".asJson)
```

#### Point 5
Usage of `match case` style only.
``` scala
import net.scalax.simple.adt.{TypeAdt => Adt}
import io.circe.{Encoder, Json}
import io.circe.syntax._

def inputAdtData[S <: Adt.Status, T: Encoder: Adt.CoProductsX2[*, S, Int, Option[Int]]](t: T): Json = {
  val applyM = Adt.CoProducts2[Int, Option[Int]](t)
  applyM: Adt.CoProductX2[S, Int, Option[Int]] // Confirm Type
  applyM match {
    case Adt.CoProduct1(intData) => (intData + 10000).asJson
    case Adt.CoProduct2(optData) =>
      val opt = for (intData <- optData) yield intData + 20000
      opt.asJson
    case Adt.CoProduct3(other) => other.default(t.asJson) // For match failed
    case Adt.CoProduct4(other) => other.default(t.asJson)
    case Adt.CoProduct5(other) => other.default(t.asJson)
    case Adt.CoProduct6(other) => other.default(t.asJson)
  }
}

assert(inputAdtData(None) == None.asJson)
assert(inputAdtData(Some(5): Some[Int]) == (5 + 20000).asJson)
assert(inputAdtData(Some(8): Option[Int]) == (8 + 20000).asJson)
assert(inputAdtData(2) == (2 + 10000).asJson)
assert(inputAdtData(2L) == 2.asJson)
assert(inputAdtData(Some("Tom")) == "Tom".asJson)
```

### Usage of [@MarchLiu](https://marchliu.github.io/)
Related project: [scala-workers/commons-lang3-bridge](https://github.com/scala-workers/commons-lang3-bridge)

#### Point 1
Match type for parameter list.
``` scala
import net.scalax.simple.adt.{TypeAdt => Adt}

type Options3F[F[_], T, T1, T2, T3] = Adt.CoProducts3[F[T], T1, T2, T3]

def inputAdtData[T: Options3F[Seq, *, Seq[String], Seq[Int], Seq[Option[Long]]]](t: T*): Seq[Long] = {
  val applyM = Adt.CoProducts3[Seq[String], Seq[Int], Seq[Option[Long]]](t)
  applyM.fold(
    stringSeq => stringSeq.map(t => t.length.toLong),
    intSeq => intSeq.map(t => t.toLong),
    longOptSeq => longOptSeq.collect { case Some(s) => s }
  )
}

assert(inputAdtData("abc", "aabbcc", "aabbbcc") == List("abc".length: Long, "aabbcc".length: Long, "aabbbcc".length: Long))
assert(inputAdtData(2, 3, 4) == List(2L, 3L, 4L))
assert(inputAdtData(Some(2L), Some(3L), Some(4L)) == List(2L, 3L, 4L))
```

#### Point 2
Match one type twice to do different things.
``` scala
import net.scalax.simple.adt.{TypeAdt => Adt}

type Options2F[F[_], T, T1, T2] = Adt.CoProducts2[F[T], T1, T2]

def countAdtData[T: Options2F[Seq, *, Seq[Option[Int]], Seq[String]]: Adt.CoProducts2[*, Option[Int], String]](t: T*): Int = {
  def applyMSeq       = Adt.CoProducts2[Seq[Option[Int]], Seq[String]](t)
  def applyM(elem: T) = Adt.CoProducts2[Option[Int], String](elem)

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
```
