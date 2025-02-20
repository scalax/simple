package net.scalax.simple
package codec
package aa

import io.circe._
import io.circe.syntax._
import net.scalax.simple.codec.to_list_generic.{FillIdentity, ModelLink, ModelLinkCommonF}

case class CatName[F[_]](id1: F[Int], str1: F[Option[String]], uClass1: F[Option[Long]], name1: F[String], namexu1: F[String])

object CatName {
  implicit val deco2_1: ModelLink[CatName, CatName[cats.Id]] = ModelLinkCommonF[CatName].derived

  implicit val modelEncoder: CatName[Encoder] = FillIdentity[CatName[Encoder]].derived
  implicit val modelDecoder: CatName[Decoder] = FillIdentity[CatName[Decoder]].derived
}

object CirceText1 {

  import CirceGeneric2._

  val modelInstance: CatName[cats.Id] = CatName[cats.Id](
    id1 = 8594,
    str1 = Option("sdfwerwfweher迷雾日哦"),
    uClass1 = Option.empty,
    name1 = "xxiwerwjkl",
    namexu1 = "jerokwjoe收代理费加沃尔"
  )

  final def main(args: Array[String]): Unit = {
    println(modelInstance.asJson.spaces2)
    println(parser.parse(modelInstance.asJson.spaces2).right.flatMap(_.as[CatName[cats.Id]]))
  }

}
