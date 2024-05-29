package net.scalax.simple
package codec
package aa

import io.circe._
import io.circe.syntax._
import net.scalax.simple.codec.to_list_generic.{SimpleProduct, SimpleProduct2, ToListByTheSameTypeGeneric}
import net.scalax.simple.codec.generic.SimpleFromProduct

import CirceGeneric2._

case class CatName[F[_]](name: F[Int], str: F[Option[String]], uClass: F[Option[Long]], name11: F[String], namexu: F[String])

object CirceText1 {

  def simpleGen1[I[_]] = SimpleFromProduct[CatName, I].derived

  implicit lazy val deco2_1: SimpleProduct.Appender[CatName] = new SimpleProduct.Appender.Impl[CatName] {
    override def impl[M1[_, _, _], M2[_], M3[_], M4[_]] =
      _.derived2(simpleGen1[cats.Id].generic, simpleGen1[M2].generic, simpleGen1[M3].generic, simpleGen1[M4].generic)(_.generic)
  }

  implicit lazy val modelEncoder: CatName[Encoder] =
    FillIdentity[CatName, Encoder].derived2(simpleGen1[Encoder].generic)(_.generic)
  implicit lazy val modelDecoder: CatName[Decoder] =
    FillIdentity[CatName, Decoder].derived2(simpleGen1[Decoder].generic)(_.generic)

  implicit lazy val caseClassEncoder: Encoder[CatName[cats.Id]] = encodeModel
  implicit lazy val caseClassDecoder: Decoder[CatName[cats.Id]] = decodeModel

  val modelInstance: CatName[cats.Id] = CatName[cats.Id](
    name = 8594,
    str = Option("sdfwerwfweher迷雾日哦"),
    uClass = Option.empty,
    name11 = "xxiwerwjkl",
    namexu = "jerokwjoe收代理费加沃尔"
  )

  final def main(args: Array[String]): Unit = {
    println(modelInstance.asJson.spaces2)
    println(parser.parse(modelInstance.asJson.spaces2).right.flatMap(_.as[CatName[cats.Id]]))
  }

  /** { "name" : 8594, "str" : "sdfwerwfweher迷雾日哦", "uClass" : null, "name11" : "xxiwerwjkl", "namexu" : "jerokwjoe收代理费加沃尔" }
    */

  /** { "name" : "name", "str" : "str", "uClass" : "uClass", "name11" : "name11", "namexu" : "namexu" }
    */

}
