package net.scalax.simple
package codec
package aa

import io.circe._
import io.circe.syntax._
import net.scalax.simple.codec.to_list_generic.{FillIdentity, ModelLink}

case class CatName[F[_]](id1: F[Int], str1: F[Option[String]], uClass1: F[Option[Long]], name1: F[String], namexu1: F[String])

object CatName {
  type Named[_] = String

  implicit val deco2_1: ModelLink.F[CatName] = ModelLink.F[CatName].derived

  val intOptEncoder: Encoder[Int]             = Encoder[String].contramap((u: Int) => u.toString)
  implicit val modelEncoder: CatName[Encoder] = FillIdentity.F[Encoder, CatName].derived.copy(id1 = intOptEncoder)
  implicit val modelDecoder: CatName[Decoder] = FillIdentity.F[Decoder, CatName].derived

  implicit val jsonLabelled: SimpleJsonCodecLabelled.F[CatName] =
    SimpleJsonCodecLabelled.F[CatName].derived.codec.update(_.copy[Named](id1 = "miaomiao id"))
}

object CirceText1 {

  import CirceGen.F._

  val modelInstance: CatName[cats.Id] = CatName[cats.Id](
    id1 = 8594,
    str1 = Option("sdfwerwfweher迷雾日哦"),
    uClass1 = Option.empty,
    name1 = "xxiwerwjkl",
    namexu1 = "jerokwjoe收代理费加沃尔"
  )

  final def main(args: Array[String]): Unit = {
    println(modelInstance.asJson.spaces2)
    println(parser.parse(modelInstance.asJson.spaces2).flatMap(_.as[CatName[cats.Id]]))
  }

}
