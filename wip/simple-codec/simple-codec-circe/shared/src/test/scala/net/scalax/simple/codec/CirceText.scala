package net.scalax.simple
package codec
package aa

import io.circe._
import io.circe.syntax._
import net.scalax.simple.codec.to_list_generic.{FillIdentity, ModelLink, ModelLinkCommonF}
import CirceGeneric2._

case class CatName[F[_]](id2: F[Int], str2: F[Option[String]], uClass2: F[Option[Long]], name2: F[String], namexu: F[String])

object CirceText1 {

  implicit val deco2_1: ModelLink[CatName, CatName[cats.Id]] = ModelLinkCommonF[CatName].derived

  implicit val modelEncoder: CatName[Encoder] = FillIdentity[CatName[Encoder]].derived
  implicit val modelDecoder: CatName[Decoder] = FillIdentity[CatName[Decoder]].derived

  implicit val caseClassEncoder: Encoder[CatName[cats.Id]] = encodeModel
  implicit val caseClassDecoder: Decoder[CatName[cats.Id]] = decodeModel

  val modelInstance: CatName[cats.Id] = CatName[cats.Id](
    id2 = 8594,
    str2 = Option("sdfwerwfweher迷雾日哦"),
    uClass2 = Option.empty,
    name2 = "xxiwerwjkl",
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
