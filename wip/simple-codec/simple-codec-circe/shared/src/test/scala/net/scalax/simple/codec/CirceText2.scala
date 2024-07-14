package net.scalax.simple.codec

import io.circe._
import io.circe.syntax._
import net.scalax.simple.codec.to_list_generic.{SimpleProduct, SimpleProduct2, ToListByTheSameTypeGeneric}
import net.scalax.simple.codec.generic.SimpleFromProduct
import CirceGeneric2._
import net.scalax.simple.codec

case class CatName[F[_]](name: F[Int], str: F[Option[String]], uClass: F[Option[Long]], name11: F[String], namexu: F[String])

object CirceText2 {

  type Named[_] = String

  def simpleGen1[I[_]] = SimpleFromProduct[CatName, I].derived

  implicit val deco2_1: SimpleProduct.AppenderImpl[CatName] =
    SimpleProduct.Appender[CatName].derived(simpleGen1[({ type AnyF[_] = Any })#AnyF].generic)

  type FAlias[UX[_]] = CatName[({ type U1[T] = UX[String] })#U1]

  implicit def li1222Encoder(implicit v: SimpleProduct.Appender[FAlias]): FAlias[Encoder] = {
    val simpleFillE: SimpleFill[FAlias] = SimpleFill[FAlias].derived(v)

    simpleFillE.fill[({ type E[T] = Encoder[String] })#E](new SimpleFill.FillI[({ type E[T] = Encoder[String] })#E] {
      override def fill[T]: Encoder[String] = Encoder[String]
    })
  }

  implicit def li1222Decoder(implicit v: SimpleProduct.Appender[FAlias]): FAlias[Decoder] = {
    val simpleFillE: SimpleFill[FAlias] = SimpleFill[FAlias].derived(v)

    simpleFillE.fill[({ type E[T] = Decoder[String] })#E](new SimpleFill.FillI[({ type E[T] = Decoder[String] })#E] {
      override def fill[T]: Decoder[String] = Decoder[String]
    })
  }

  implicit lazy val basedInstalled2: SimpleProduct.AppenderImpl[FAlias] = ToItera[CatName].derived.to[String]

  implicit lazy val caseClassNameEncoder: Encoder[CatName[Named]] = encodeModel[FAlias]
  implicit lazy val caseClassNameDecoder: Decoder[CatName[Named]] = decodeModel[FAlias]

  val namedModel: CatName[Named] = {
    val fromList = implicitly[SimpleProduct.AppenderImpl[FAlias]]
    CompatLabelled.toLabelled(fromList, fromList).modelLabelled
  }

  final def main(args: Array[String]): Unit = {
    println(namedModel.asJson.spaces2)
    println(parser.parse(namedModel.asJson.spaces2).right.flatMap(_.as[CatName[Named]]))
  }

  /** { "name" : 8594, "str" : "sdfwerwfweher迷雾日哦", "uClass" : null, "name11" : "xxiwerwjkl", "namexu" : "jerokwjoe收代理费加沃尔" }
    */

  /** { "name" : "name", "str" : "str", "uClass" : "uClass", "name11" : "name11", "namexu" : "namexu" }
    */

}
