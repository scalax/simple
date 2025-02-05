package net.scalax.simple.codec

import io.circe._
import io.circe.syntax._
import net.scalax.simple.codec.to_list_generic.{BasedInstalled, ModelLink, ModelLinkCommonF}
import CirceGeneric2._

case class CatName[F[_]](name: F[Int], str: F[Option[String]], uClass: F[Option[Long]], name11: F[String], namexu: F[String])

object CirceText2 {

  implicit val deco2_1: ModelLink[CatName, CatName[cats.Id]] = ModelLinkCommonF[CatName].derived

  type FAlias[UX[_]] = CatName[({ type U1[T] = UX[String] })#U1]

  implicit def li1222Encoder(implicit v: BasedInstalled[FAlias]): FAlias[Encoder] = {
    val simpleFillE: SimpleFill[FAlias] = SimpleFill[FAlias].derived(v.simpleProduct1)

    simpleFillE.fill[({ type E[T] = Encoder[String] })#E](new SimpleFill.FillI[({ type E[T] = Encoder[String] })#E] {
      override def fill[T]: Encoder[String] = Encoder[String]
    })
  }

  implicit def li1222Decoder(implicit v: BasedInstalled[FAlias]): FAlias[Decoder] = {
    val simpleFillE: SimpleFill[FAlias] = SimpleFill[FAlias].derived(v.simpleProduct1)

    simpleFillE.fill[({ type E[T] = Decoder[String] })#E](new SimpleFill.FillI[({ type E[T] = Decoder[String] })#E] {
      override def fill[T]: Decoder[String] = Decoder[String]
    })
  }

  implicit val namedModel_catName2: ModelLink[FAlias, FAlias[cats.Id]] = ToItera[CatName].derived.toModelLink[String](implicitly)

  implicit val caseClassNameEncoder: Encoder[FAlias[cats.Id]] = encodeModel[FAlias]
  implicit val caseClassNameDecoder: Decoder[FAlias[cats.Id]] = decodeModel[FAlias]
  val namedMode: FAlias[cats.Id]                              = ModelLink[FAlias, FAlias[cats.Id]].implicitly.labelled.modelLabelled

  final def main(args: Array[String]): Unit = {
    println(namedMode.asJson.spaces2)
    println(parser.parse(namedMode.asJson.spaces2).right.flatMap(_.as[FAlias[cats.Id]]))
  }

  /** { "name" : 8594, "str" : "sdfwerwfweher迷雾日哦", "uClass" : null, "name11" : "xxiwerwjkl", "namexu" : "jerokwjoe收代理费加沃尔" }
    */

  /** { "name" : "name", "str" : "str", "uClass" : "uClass", "name11" : "name11", "namexu" : "namexu" }
    */

}
