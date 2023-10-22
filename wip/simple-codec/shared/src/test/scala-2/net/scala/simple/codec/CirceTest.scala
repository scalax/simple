package net.scalax.simple
package codec

import io.circe._
import io.circe.syntax._
import cats.effect._

case class CatNameScala2[F[_]](name: F[Int], str: F[Option[String]], uClass: F[Option[Long]], name11: F[String], namexu: F[String])

object scala2xbb11 extends IOApp {

  type UFAliasF[T11[_]] = CatNameScala2[({ type U1[_] = T11[String] })#U1]

  implicit val im1: SymbolLabelledInstalled[CatNameScala2] = SymbolLabelledInstalled[CatNameScala2].derived
  implicit val im2: LabelledInstalled[CatNameScala2]       = LabelledInstalled[CatNameScala2].derived
  implicit val im3: FillIdentity[CatNameScala2, Encoder]   = FillIdentity[CatNameScala2, Encoder].derived
  implicit val im4: CirceEncoderImplicit[CatNameScala2]    = CirceEncoderImplicit[CatNameScala2].derived

  type U1[_] = Encoder[String]
  type U2[_] = String
  implicit val uuj2: LabelledInstalled[UFAliasF]     = LabelledInstalled[UFAliasF].instance(LabelledInstalled[CatNameScala2].summon.model)
  implicit val uuj3: FillIdentity[UFAliasF, Encoder] = FillIdentity[UFAliasF, Encoder].law[CatNameScala2[U1]].derived
  implicit val uuj4: CirceEncoderImplicit[UFAliasF] =
    CirceEncoderImplicit[UFAliasF].law[CatNameScala2[LabelledInstalled.ToNamed], CatNameScala2[U1], CatNameScala2[U2]].derived
  implicit val uuj6: FillIdentity[UFAliasF, cats.Id] =
    FillIdentity[UFAliasF, cats.Id].instance(LabelledInstalled[CatNameScala2].summon.model)

  val modelNameProperty: CatNameScala2[U2] = uuj2.model
  val modelInstance: CatNameScala2[cats.Id] = CatNameScala2[cats.Id](
    name = 8594,
    str = Option("sdfwerwfweher迷雾日哦"),
    uClass = Option.empty,
    name11 = "xxiwerwjkl",
    namexu = "jerokwjoe收代理费加沃尔"
  )

  implicit val im5: Encoder[CatNameScala2[cats.Id]] = im4.model
  implicit val uuj5: Encoder[CatNameScala2[U2]]     = uuj4.model

  final override def run(args: List[String]): IO[ExitCode] = {
    for {
      _ <- IO(println(modelInstance.asJson.spaces2))
      _ <- IO(println(modelNameProperty.asJson.spaces2))
    } yield {
      //
    }
  }.map(_ => ExitCode.Success)

  /** { "name" : 8594, "str" : "sdfwerwfweher迷雾日哦", "uClass" : null, "name11" : "xxiwerwjkl", "namexu" : "jerokwjoe收代理费加沃尔" }
    */

  /** { "name" : "name", "str" : "str", "uClass" : "uClass", "name11" : "name11", "namexu" : "namexu" }
    */

}
