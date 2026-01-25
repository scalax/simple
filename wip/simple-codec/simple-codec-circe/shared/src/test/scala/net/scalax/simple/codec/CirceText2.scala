package net.scalax.simple.codec

import io.circe._
import io.circe.syntax._
import net.scalax.simple.codec.to_list_generic.{BasedInstalledLabelled, BasedInstalledSimpleProduct, ModelLink, ModelLinkCommonF}

case class CatName[F[_]](id2: F[Int], str2: F[Option[String]], uClass2: F[Option[Long]], name112: F[String], namexu2: F[String])

object CatName {
  type FAlias[UX[_]] = CatName[({ type U1[_] = UX[String] })#U1]
  implicit val modelLinkF: ModelLink.F[CatName]                        = ModelLink.F[CatName].derived
  implicit val namedModel_catName2: ModelLink[FAlias, FAlias[cats.Id]] = ToItera[CatName].derived.toModelLink[String](implicitly)

  implicit val jsonLabelled: SimpleJsonCodecLabelled.F[FAlias] =
    SimpleJsonCodecLabelled.F[FAlias].implicitly(implicitly[BasedInstalledLabelled[CatName]].labelled.modelLabelled)

  implicit val li1222Encoder: FAlias[Encoder] = {
    val v: BasedInstalledSimpleProduct[FAlias] = implicitly
    val simpleFillE: SimpleFill[FAlias]        = SimpleFill[FAlias].derived(v.basedInstalled.simpleProduct1)

    simpleFillE.fill[({ type E[T] = Encoder[String] })#E](new SimpleFill.FillI[({ type E[T] = Encoder[String] })#E] {
      override def fill[T]: Encoder[String] = Encoder[String]
    })
  }

  implicit val li1222Decoder: FAlias[Decoder] = {
    val v: BasedInstalledSimpleProduct[FAlias] = implicitly
    val simpleFillE: SimpleFill[FAlias]        = SimpleFill[FAlias].derived(v.basedInstalled.simpleProduct1)

    simpleFillE.fill[({ type E[T] = Decoder[String] })#E](new SimpleFill.FillI[({ type E[T] = Decoder[String] })#E] {
      override def fill[T]: Decoder[String] = Decoder[String]
    })
  }
}

object CirceText2 {

  type FAlias[UX[_]] = CatName[({ type U1[_] = UX[String] })#U1]

  import CirceGen.F._

  val namedMode: FAlias[cats.Id] = ModelLink.F[FAlias].implicitly.labelled.modelLabelled

  final def main(args: Array[String]): Unit = {
    println(namedMode.asJson.spaces2)
    println(parser.parse(namedMode.asJson.spaces2).flatMap(_.as[FAlias[cats.Id]]))
  }

}
