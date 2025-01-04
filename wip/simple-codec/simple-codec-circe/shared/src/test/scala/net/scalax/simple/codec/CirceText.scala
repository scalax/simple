package net.scalax.simple
package codec
package aa

import io.circe._
import io.circe.syntax._
import net.scalax.simple.codec.to_list_generic.AppenderFromSize
import net.scalax.simple.codec.generic.SimpleFromProduct
import net.scalax.simple.codec.ModelSize
import CirceGeneric2._
import net.scalax.simple.codec.to_list_generic.SimpleProduct3

case class CatName[F[_]](name: F[Int], str: F[Option[String]], uClass: F[Option[Long]], name11: F[String], namexu: F[String])

object CirceText1 {

  val simpleGen1 = SimpleFromProduct[CatName].derived

  implicit val deco2_1: AppenderFromSize[CatName]                  = AppenderFromSize[CatName].derived(simpleGen1.generic)
  implicit val namedLabel: CompatLabelled[CatName]                 = CompatLabelled[CatName].derived(simpleGen1.generic)
  implicit val modelSize: ModelSize[CatName]                       = implicitly[CompatLabelled[CatName]].toModelSize
  implicit val appender: SimpleProduct3.NotHList.Appender[CatName] = implicitly[AppenderFromSize[CatName]].inputModelSizeF(implicitly)
  implicit val modelLabelled: ModelLabelled[CatName]               = implicitly[CompatLabelled[CatName]].toLabelled(implicitly)

  implicit lazy val modelEncoder: CatName[Encoder] = CatName[Encoder](implicitly, implicitly, implicitly, implicitly, implicitly)
  implicit lazy val modelDecoder: CatName[Decoder] = CatName[Decoder](implicitly, implicitly, implicitly, implicitly, implicitly)

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
