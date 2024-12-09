package net.scalax.simple.codec

import io.circe._
import io.circe.syntax._
import net.scalax.simple.codec.to_list_generic.AppenderFromSize
import net.scalax.simple.codec.generic.SimpleFromProduct
import CirceGeneric2._
import net.scalax.simple.codec.utils.SimpleP

case class CatName[F[_]](name: F[Int], str: F[Option[String]], uClass: F[Option[Long]], name11: F[String], namexu: F[String])

object CirceText2 {

  type Named[_] = String

  val simpleGen1 = SimpleFromProduct[CatName].derived

  implicit val deco2_1: AppenderFromSize[CatName]            = AppenderFromSize[CatName].derived(simpleGen1.generic)
  implicit val namedLabel: CompatLabelled[CatName]           = CompatLabelled[CatName].derived(simpleGen1.generic)
  implicit val modelSize: ModelSize[CatName]                 = implicitly[CompatLabelled[CatName]].toModelSize
  implicit val appender: SimpleP.Appender[CatName]           = implicitly[AppenderFromSize[CatName]].inputModelSizeF(implicitly)
  implicit val modelLabelled_catName: ModelLabelled[CatName] = implicitly[CompatLabelled[CatName]].toLabelled(implicitly)

  type FAlias[UX[_]] = CatName[({ type U1[T] = UX[String] })#U1]

  implicit def li1222Encoder(implicit v: SimpleP.Appender[FAlias]): FAlias[Encoder] = {
    val simpleFillE: SimpleFill[FAlias] = SimpleFill[FAlias].derived(v)

    simpleFillE.fill[({ type E[T] = Encoder[String] })#E](new SimpleFill.FillI[({ type E[T] = Encoder[String] })#E] {
      override def fill[T]: Encoder[String] = Encoder[String]
    })
  }

  implicit def li1222Decoder(implicit v: SimpleP.Appender[FAlias]): FAlias[Decoder] = {
    val simpleFillE: SimpleFill[FAlias] = SimpleFill[FAlias].derived(v)

    simpleFillE.fill[({ type E[T] = Decoder[String] })#E](new SimpleFill.FillI[({ type E[T] = Decoder[String] })#E] {
      override def fill[T]: Decoder[String] = Decoder[String]
    })
  }

  implicit val namedModel_catName2: ModelLabelled[FAlias] = new ModelLabelled[FAlias] {
    override def modelLabelled: CatName[Named] = implicitly[ModelLabelled[CatName]].modelLabelled
  }
  implicit lazy val basedInstalled2: SimpleP.Appender[FAlias] = ToItera[CatName].derived.to[String]

  implicit lazy val caseClassNameEncoder: Encoder[CatName[Named]] = encodeModel[FAlias]
  implicit lazy val caseClassNameDecoder: Decoder[CatName[Named]] = decodeModel[FAlias]

  val namedMode: CatName[Named] = namedModel_catName2.modelLabelled

  final def main1(args: Array[String]): Unit = {
    println(namedMode.asJson.spaces2)
    println(parser.parse(namedMode.asJson.spaces2).right.flatMap(_.as[CatName[Named]]))
  }

  /** { "name" : 8594, "str" : "sdfwerwfweher迷雾日哦", "uClass" : null, "name11" : "xxiwerwjkl", "namexu" : "jerokwjoe收代理费加沃尔" }
    */

  /** { "name" : "name", "str" : "str", "uClass" : "uClass", "name11" : "name11", "namexu" : "namexu" }
    */

}
