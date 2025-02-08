package net.scalax.simple.codec

import io.circe._
import io.circe.syntax._
import net.scalax.simple.codec.to_list_generic.{ModelLink, ModelLinkPojo, PojoInstance}
import CirceGeneric2._

case class CatNameTest3(id3: Int, str3: Option[String], uClass3: Option[Long], name113: String, namexu3: String)

object CirceText3 {

  implicit val deco2_1: ModelLink[({ type F[X[_]] = PojoInstance[X, CatNameTest3] })#F, CatNameTest3] = ModelLinkPojo[CatNameTest3].derived

  implicit val modelEncoder: PojoInstance[Encoder, CatNameTest3] = PojoInstance[Encoder, CatNameTest3].fill
  implicit val modelDecoder: PojoInstance[Decoder, CatNameTest3] = PojoInstance[Decoder, CatNameTest3].fill

  implicit val caseClassEncoder: Encoder[CatNameTest3] = encodePojo
  implicit val caseClassDecoder: Decoder[CatNameTest3] = decodePojo

  val modelInstance: CatNameTest3 = CatNameTest3(
    id3 = 8594,
    str3 = Option("aaTest3"),
    uClass3 = Option.empty,
    name113 = "xxiwerwjkl",
    namexu3 = "jerokwjoe收代理Test3"
  )

  final def main(args: Array[String]): Unit = {
    println(modelInstance.asJson.spaces2)
    println(parser.parse(modelInstance.asJson.spaces2).right.flatMap(_.as[CatNameTest3]))
  }

  /** { "name" : 8594, "str" : "sdfwerwfweher迷雾日哦", "uClass" : null, "name11" : "xxiwerwjkl", "namexu" : "jerokwjoe收代理费加沃尔" }
    */

  /** { "name" : "name", "str" : "str", "uClass" : "uClass", "name11" : "name11", "namexu" : "namexu" }
    */

}
