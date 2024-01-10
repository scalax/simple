package net.scalax.simple
package codec11

import io.circe._
import io.circe.syntax._
import cats.effect._
import cats.~>
import net.scalax.simple.codec.{CompatLabelledInstalled, FillIdentity, IOApp1, LabelledInstalled}
import net.scalax.simple.codec.generic.SimpleFromProduct
import net.scalax.simple.codec.unzip_generic.Func50Generic
import codec.Function50Generic
import net.scalax.simple.codec.to_list_generic.{ToDecoderGeneric, ToListGenerc}

case class CatNameScala11[F[_]](name: F[Int], str: F[Option[String]], uClass: F[Option[Long]], name11: F[String], namexu: F[String])

trait IOApp_1 {
  def run(args: List[String]): IO[ExitCode]
}

object TempTest11 extends IOApp_1 {

  type UFAliasF[T11[_]] = CatNameScala11[({ type U1[_] = T11[String] })#U1]

  def simpleGen1[I[_]] = SimpleFromProduct[CatNameScala11, I].derived

  implicit val im111: Function50Generic[CatNameScala11] = new Func50Generic.Impl[CatNameScala11] {
    override def impl1[In1[_]] = _.derived2(simpleGen1[cats.Id].generic, simpleGen1[In1].generic)(_.generic)
    override def impl2[In1[_], In2[_], In3[_]] =
      _.derived2(simpleGen1[cats.Id].generic, simpleGen1[In1].generic, simpleGen1[In2].generic, simpleGen1[In3].generic)(_.generic)
  }

  implicit val im1: CompatLabelledInstalled[CatNameScala11] =
    CompatLabelledInstalled[CatNameScala11].derived(simpleGen1[CompatLabelledInstalled.ToNamed].generic)
  val deco1: ToDecoderGeneric[CatNameScala11] = new ToDecoderGeneric.Impl[CatNameScala11] {
    override def impl[M1[_], M2[_], M3[_]] =
      _.derived2(simpleGen1[cats.Id].generic, simpleGen1[M3].generic, simpleGen1[M1].generic)(
        _.generic
      )
  }
  implicit val userNamedGeneric1: LabelledInstalled[CatNameScala11] = LabelledInstalled[CatNameScala11].derived
  implicit val im3: FillIdentity[CatNameScala11, Encoder] =
    FillIdentity[CatNameScala11, Encoder].derived2(simpleGen1[Encoder].generic)(_.generic)

  final override def run(args: List[String]): IO[ExitCode] = {
    for {
      _ <- IO(println(im1.model))
      // _ <- IO(println(modelInstance.asJson.spaces2))
      // _ <- IO(println(modelNameProperty.asJson.spaces2))
    } yield {
      //
    }
  }.map(_ => ExitCode.Success)

  /** { "name" : 8594, "str" : "sdfwerwfweher迷雾日哦", "uClass" : null, "name11" : "xxiwerwjkl", "namexu" : "jerokwjoe收代理费加沃尔" }
    */

  /** { "name" : "name", "str" : "str", "uClass" : "uClass", "name11" : "name11", "namexu" : "namexu" }
    */

}
