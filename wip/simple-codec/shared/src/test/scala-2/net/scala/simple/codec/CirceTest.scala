package net.scalax.simple
package codec

import io.circe._
import io.circe.syntax._
import cats.effect._

case class CatNameScala2[F[_]](name: F[Int], str: F[Option[String]], uClass: F[Option[Long]], name11: F[String], namexu: F[String])

object scala2xbb11 extends IOApp {

  type StrU[_]          = String
  type UFAliasF[T11[_]] = CatNameScala2[({ type U1[T] = T11[StrU[T]] })#U1]
  object UFAliasF {
    def apply[T111[_]](
      name: T111[String],
      str: T111[String],
      uClass: T111[String],
      name11: T111[String],
      namexu: T111[String]
    ): UFAliasF[T111] =
      CatNameScala2[({ type U1[T] = T111[StrU[T]] })#U1](name = name, str = str, uClass = uClass, name11 = name11, namexu = namexu)
  }

  implicit val im1: SymbolLabelledInstalled[CatNameScala2] = SymbolLabelledInstalled[CatNameScala2].derived
  implicit val im2: LabelledInstalled[CatNameScala2]       = LabelledInstalled[CatNameScala2].derived
  implicit val im3: FillIdentity[CatNameScala2, Encoder]   = FillIdentity[CatNameScala2, Encoder].derived
  implicit val im4: CirceEncoderImplicit[CatNameScala2]    = CirceEncoderImplicit[CatNameScala2].derived
  println(im2.model)

  // implicit val uuj1 = SymbolLabelledInstalled[UFAliasF].derived

  val modelInstance: CatNameScala2[cats.Id] = CatNameScala2[cats.Id](
    name = 8594,
    str = Option("sdfwerwfweher迷雾日哦"),
    uClass = Option.empty,
    name11 = "xxiwerwjkl",
    namexu = "jerokwjoe收代理费加沃尔"
  )

  implicit val im5: Encoder[CatNameScala2[cats.Id]] = im4.model

  final override def run(args: List[String]): IO[ExitCode] = {
    for {
      _ <- IO(println(modelInstance.asJson.spaces2))
      // _ <- IO(println(modelNameProperty.model.asJson.spaces2))
    } yield {
      //
    }
  }.map(_ => ExitCode.Success)

  /** { "name" : 8594, "str" : "sdfwerwfweher迷雾日哦", "uClass" : null, "name11" : "xxiwerwjkl", "namexu" : "jerokwjoe收代理费加沃尔" }
    */

  /** { "name" : "name", "str" : "str", "uClass" : "uClass", "name11" : "name11", "namexu" : "namexu" }
    */
}
