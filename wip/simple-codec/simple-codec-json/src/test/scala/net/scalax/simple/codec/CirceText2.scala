package net.scalax.simple.codec

import io.circe._
import io.circe.syntax._
import cats.effect._
import net.scalax.simple.codec.to_list_generic.{SimpleProduct, SimpleProduct2, ToListByTheSameTypeGeneric}
import net.scalax.simple.codec.generic.SimpleFromProduct

import CirceGeneric2._

case class CatName[F[_]](name: F[Int], str: F[Option[String]], uClass: F[Option[Long]], name11: F[String], namexu: F[String])

object CirceText2 extends IOApp {

  def simpleGen1[I[_]] = SimpleFromProduct[CatName, I].derived

  implicit lazy val deco2_1: SimpleProduct.Appender[CatName] = new SimpleProduct.Appender.Impl[CatName] {
    override def impl[M1[_, _, _], M2[_], M3[_], M4[_]] =
      _.derived2(simpleGen1[cats.Id].generic, simpleGen1[M2].generic, simpleGen1[M3].generic, simpleGen1[M4].generic)(_.generic)
  }

  type FAlias[UX[_]] = CatName[({ type U1[T] = UX[String] })#U1]

  implicit def li1222Encoder(implicit v: SimpleProduct.Appender[FAlias]): FAlias[Encoder] = {
    val simpleFillE: SimpleFill[FAlias] = SimpleFill[FAlias].derived(v)

    simpleFillE.fill[({ type E[T] = Encoder[String] })#E](new SimpleFill.FillI[({ type E[T] = Encoder[String] })#E] {
      override def fill[T]: Encoder[String] = Encoder[String]
    })
  }

  implicit def li1222Decoder(implicit v: SimpleProduct.Appender[FAlias]): FAlias[Decoder] = {
    val simpleFillE: SimpleFill[FAlias] = SimpleFill[FAlias].derived(v)

    simpleFillE.fill[({ type E[T] = Decoder[String] })#E](new SimpleFill.FillI[({ type E[T] = Decoder[String] })#E] {
      override def fill[T]: Decoder[String] = Decoder[String]
    })
  }

  implicit lazy val basedInstalled2: SimpleProduct.Appender[FAlias] = ToItera[CatName].derived.to[String]

  implicit lazy val caseClassNameEncoder: Encoder[CatName[LabelledInstalled.Named]] = encodeModel[FAlias]
  implicit lazy val caseClassNameDecoder: Decoder[CatName[LabelledInstalled.Named]] = decodeModel[FAlias]

  val namedModel: CatName[LabelledInstalled.Named] = LabelledInstalled[FAlias].derived(basedInstalled2, implicitly).labelled

  final override def run(args: List[String]): IO[ExitCode] = {
    for {
      _ <- IO(println(namedModel.asJson.spaces2))
      _ <- IO(println(parser.parse(namedModel.asJson.spaces2).right.flatMap(_.as[CatName[LabelledInstalled.Named]])))
    } yield {
      //
    }
  }.map(_ => ExitCode.Success)

  /** { "name" : 8594, "str" : "sdfwerwfweher迷雾日哦", "uClass" : null, "name11" : "xxiwerwjkl", "namexu" : "jerokwjoe收代理费加沃尔" }
    */

  /** { "name" : "name", "str" : "str", "uClass" : "uClass", "name11" : "name11", "namexu" : "namexu" }
    */

}
