package net.scalax.simple
package codec
package func_circe_test

import io.circe._
import io.circe.syntax._
import net.scalax.simple.adt.nat.support.ABCFunc
import net.scalax.simple.codec.to_list_generic.{FillIdentity, ModelLink}

case class FuncCirceTestImpl1[T, F[_]](str1: F[Option[T]])
object FuncCirceTestImpl1 {
  implicit def impl1EncoderGiven[T](implicit en: Encoder[T]): FuncCirceTestImpl1[T, Encoder] = FuncCirceTestImpl1(implicitly)
  implicit def impl1DecoderGiven[T](implicit en: Decoder[T]): FuncCirceTestImpl1[T, Decoder] = FuncCirceTestImpl1(implicitly)
}
case class FuncCirceTestImpl2[F[_]](id1: F[Int], uClass1: F[Option[Long]], name1: F[String], namexu1: F[String])

case class FuncCirceTest[T, F[_]](id1: F[Int], str1: F[Option[T]], uClass1: F[Option[Long]], name1: F[String], namexu1: F[String])
object FuncCirceTest {

  def abcFromTo[T, F[_]]: ABCFunc[FuncCirceTestImpl1[T, F], FuncCirceTestImpl2[F], FuncCirceTest[T, F]] =
    new ABCFunc[FuncCirceTestImpl1[T, F], FuncCirceTestImpl2[F], FuncCirceTest[T, F]] {
      override def takeHead(m: FuncCirceTest[T, F]): FuncCirceTestImpl1[T, F] = FuncCirceTestImpl1[T, F](str1 = m.str1)
      override def takeTail(m: FuncCirceTest[T, F]): FuncCirceTestImpl2[F] =
        FuncCirceTestImpl2[F](id1 = m.id1, uClass1 = m.uClass1, name1 = m.name1, namexu1 = m.namexu1)
      override def append(h: FuncCirceTestImpl1[T, F], t: FuncCirceTestImpl2[F]): FuncCirceTest[T, F] =
        FuncCirceTest[T, F](id1 = t.id1, str1 = h.str1, uClass1 = t.uClass1, name1 = t.name1, namexu1 = t.namexu1)
    }

  implicit def deco2_1[T]: ModelLink.F[({ type U[X[_]] = FuncCirceTest[T, X] })#U] =
    ModelLink.F[({ type U[X[_]] = FuncCirceTest[T, X] })#U].derived

  val impl2EncoderGiven: FuncCirceTestImpl2[Encoder] = FillIdentity.F[Encoder, FuncCirceTestImpl2].derived
  val impl2DecoderGiven: FuncCirceTestImpl2[Decoder] = FillIdentity.F[Decoder, FuncCirceTestImpl2].derived
  implicit def jsonLabelled[T]: SimpleJsonCodecLabelled.F[({ type X1[U[_]] = FuncCirceTest[T, U] })#X1] =
    SimpleJsonCodecLabelled.F[({ type X1[U[_]] = FuncCirceTest[T, U] })#X1].derived
  implicit def impl0EncoderGiven[T](implicit u: FuncCirceTestImpl1[T, Encoder]): FuncCirceTest[T, Encoder] =
    abcFromTo[T, Encoder].append(implicitly, impl2EncoderGiven)
  implicit def impl0DecoderGiven[T](implicit u: FuncCirceTestImpl1[T, Decoder]): FuncCirceTest[T, Decoder] =
    abcFromTo[T, Decoder].append(implicitly, impl2DecoderGiven)

}

object FuncCirceTest1 {

  import CirceGen.F._

  type UTest[F[_]] = FuncCirceTest[String, F]

  val modelInstance: UTest[cats.Id] = FuncCirceTest[String, cats.Id](
    id1 = 8594,
    str1 = Option("1111111111111111111111111111222"),
    uClass1 = Option.empty,
    name1 = "xxiwerwjkl",
    namexu1 = "jerokwjoe收代理费加沃尔"
  )

  final def main(args: Array[String]): Unit = {
    println(modelInstance.asJson.spaces2)
    println(parser.parse(modelInstance.asJson.spaces2).flatMap(_.as[UTest[cats.Id]]))
  }

}
