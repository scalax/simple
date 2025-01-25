package net.scalax.simple.codec

import io.circe._
import io.circe.syntax._
import net.scalax.simple.codec.to_list_generic.{AppenderFromSize, SimpleProduct1, SimpleProductX}
import net.scalax.simple.codec.generic.SimpleFromProduct
import CirceGeneric2._

case class CatName[F[_]](name: F[Int], str: F[Option[String]], uClass: F[Option[Long]], name11: F[String], namexu: F[String])

object CirceText2 {

  type Named[_] = String

  val simpleGen1 = SimpleFromProduct[CatName].derived

  implicit val deco2_1: AppenderFromSize[CatName]            = AppenderFromSize[CatName].derived(simpleGen1.generic)
  implicit val namedLabel: CompatLabelled[CatName]           = CompatLabelled[CatName].derived(simpleGen1.generic)
  implicit val modelSize: ModelSize[CatName]                 = ModelSize[CatName].derived(implicitly)
  implicit val appender: SimpleProductX[CatName]             = SimpleProductX[CatName].derived(implicitly, implicitly)
  implicit val appender1: SimpleProduct1.Appender[CatName]   = SimpleProduct1[CatName].derived(implicitly)
  implicit val modelLabelled_catName: ModelLabelled[CatName] = ModelLabelled[CatName].derived(implicitly, implicitly)

  type FAlias[UX[_]] = CatName[({ type U1[T] = UX[String] })#U1]

  implicit def li1222Encoder(implicit v: SimpleProduct1.Appender[FAlias]): FAlias[Encoder] = {
    val simpleFillE: SimpleFill[FAlias] = SimpleFill[FAlias].derived(v)

    simpleFillE.fill[({ type E[T] = Encoder[String] })#E](new SimpleFill.FillI[({ type E[T] = Encoder[String] })#E] {
      override def fill[T]: Encoder[String] = Encoder[String]
    })
  }

  implicit def li1222Decoder(implicit v: SimpleProduct1.Appender[FAlias]): FAlias[Decoder] = {
    val simpleFillE: SimpleFill[FAlias] = SimpleFill[FAlias].derived(v)

    simpleFillE.fill[({ type E[T] = Decoder[String] })#E](new SimpleFill.FillI[({ type E[T] = Decoder[String] })#E] {
      override def fill[T]: Decoder[String] = Decoder[String]
    })
  }

  implicit val namedModel_catName2: ModelLabelled[FAlias] = new ModelLabelled[FAlias] {
    override def modelLabelled: CatName[Named] = implicitly[ModelLabelled[CatName]].modelLabelled
  }
  implicit val basedInstalled2: SimpleProductX[FAlias] = ToItera[CatName].derived.to[String](implicitly)

  implicit val appender2M1: SimpleProduct1.Appender[FAlias] = SimpleProduct1[FAlias].derived(implicitly)

  implicit val caseClassNameEncoder: Encoder[CatName[Named]] = encodeModel[FAlias]
  implicit val caseClassNameDecoder: Decoder[CatName[Named]] = decodeModel[FAlias]
  val namedMode: CatName[Named]                              = ModelLabelled[FAlias].implicitly.modelLabelled

  final def main(args: Array[String]): Unit = {
    println(namedMode.asJson.spaces2)
    println(parser.parse(namedMode.asJson.spaces2).right.flatMap(_.as[CatName[Named]]))
  }

  /** { "name" : 8594, "str" : "sdfwerwfweher迷雾日哦", "uClass" : null, "name11" : "xxiwerwjkl", "namexu" : "jerokwjoe收代理费加沃尔" }
    */

  /** { "name" : "name", "str" : "str", "uClass" : "uClass", "name11" : "name11", "namexu" : "namexu" }
    */

}
