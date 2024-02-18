package net.scalax.simple
package codec

import io.circe._
import io.circe.syntax._
import cats.effect._
import net.scalax.simple.codec.to_list_generic.{ToDecoderGeneric, ToDecoderGeneric2222, ToListGeneric}
import net.scalax.simple.codec.generic.SimpleFromProduct

case class CatName[F[_]](name: F[Int], str: F[Option[String]], uClass: F[Option[Long]], name11: F[String], namexu: F[String])

trait IOApp1 {
  def run(args: List[String]): IO[ExitCode]
}

object xxbb1 extends IOApp {

  def encodeModel[F[_[_]]](implicit
    g: FillIdentity[F, Encoder],
    g1: BasedInstalled[F]
  ): Encoder[F[cats.Id]] = {
    val toList: ToListGeneric[F]  = ToListGeneric[F].derived(g1)
    val zipGeneric: ZipGeneric[F] = ZipGeneric[F].derived(g1)
    val mapGenerc: MapGenerc[F]   = MapGenerc[F].derived(g1)

    Encoder.instance[F[cats.Id]] { m =>
      val zip1 = zipGeneric.zip(m, g.model)
      val map1 = mapGenerc.map[({ type U1[T1] = (T1, Encoder[T1]) })#U1, ({ type U1[T1] = Json })#U1](
        new MapGenerc.MapImpl[({ type U1[T1] = (T1, Encoder[T1]) })#U1, ({ type U1[T1] = Json })#U1] {
          override def map[X1]: ((X1, Encoder[X1])) => Json = s => s._2(s._1)
        }
      )(zip1)
      val zip2  = zipGeneric.zip[({ type U1[T1] = String })#U1, ({ type U1[T1] = Json })#U1](g1.labelled, map1)
      val list1 = toList.toList[(String, Json)](zip2)
      Json.fromJsonObject(JsonObject.fromIterable(list1))
    }
  }

  type EncoderAux[_]      = Encoder[String]
  type EncoderModelAux[_] = String

  def simpleGen1[I[_]] = SimpleFromProduct[CatName, I].derived

  lazy val compatLabelledInstalled: CompatLabelledInstalled[CatName] =
    CompatLabelledInstalled[CatName].derived(simpleGen1[CompatLabelledInstalled.CompatNamed].generic)

  lazy val deco1_1: ToDecoderGeneric[CatName] = new ToDecoderGeneric.Impl[CatName] {
    override def impl[M1[_, _], M2[_], M3[_]] =
      _.derived2(simpleGen1[cats.Id].generic, simpleGen1[M2].generic, simpleGen1[M3].generic)(_.generic)
  }
  lazy val deco2_1: ToDecoderGeneric2222[CatName] = new ToDecoderGeneric2222.Impl[CatName] {
    override def impl[M1[_, _, _], M2[_], M3[_], M4[_]] =
      _.derived2(simpleGen1[cats.Id].generic, simpleGen1[M2].generic, simpleGen1[M3].generic, simpleGen1[M4].generic)(_.generic)
  }

  type FAlias[UX[_]] = CatName[({ type U1[T] = UX[String] })#U1]
  lazy val li11: LabelledInstalled[FAlias] = LabelledInstalled[FAlias].instance(implicitly[BasedInstalled[CatName]].labelled)

  lazy val deco2_1_1: ToDecoderGeneric[FAlias] = new ToDecoderGeneric[FAlias] {
    private val toDecoderCatName = implicitly[BasedInstalled[CatName]].decode

    override def toHList[M2[_, _], M1[_], M3[_]](
      monad: MonadAdd1111[M2]
    )(
      func: ToDecoderGeneric.FuncImpl[M2, M1, M3]
    ): M2[CatName[({ type U1[X] = M1[String] })#U1], CatName[({ type U1[X] = M3[String] })#U1]] =
      toDecoderCatName.toHList[M2, ({ type U1[X] = M1[String] })#U1, ({ type U1[X] = M3[String] })#U1](monad)(
        new ToDecoderGeneric.FuncImpl[M2, ({ type U1[X] = M1[String] })#U1, ({ type U1[X] = M3[String] })#U1] {
          override def apply[T]: M2[M1[String], M3[String]] = func[String]
        }
      )
  }
  lazy val deco2_1_2: ToDecoderGeneric2222[FAlias] = new ToDecoderGeneric2222[FAlias] {
    private val toDecoderCatName = implicitly[BasedInstalled[CatName]].decode2222

    override def toHList[M1[_, _, _], M2[_], M3[_], M4[_]](
      monad: MonadAdd[M1]
    )(
      func: ToDecoderGeneric2222.FuncImpl[M1, M2, M3, M4]
    ): M1[CatName[({ type U1[X] = M2[String] })#U1], CatName[({ type U1[X] = M3[String] })#U1], CatName[({ type U1[X] = M4[String] })#U1]] =
      toDecoderCatName.toHList[M1, ({ type U1[X] = M2[String] })#U1, ({ type U1[X] = M3[String] })#U1, ({ type U1[X] = M4[String] })#U1](
        monad
      )(
        new ToDecoderGeneric2222.FuncImpl[
          M1,
          ({ type U1[X] = M2[String] })#U1,
          ({ type U1[X] = M3[String] })#U1,
          ({ type U1[X] = M4[String] })#U1
        ] {
          override def apply[T]: M1[M2[String], M3[String], M4[String]] = func[String]
        }
      )
  }

  implicit lazy val modelEncoder: FillIdentity[CatName, Encoder] =
    FillIdentity[CatName, Encoder].derived2(simpleGen1[Encoder].generic)(_.generic)
  implicit lazy val modelEncoder2: FillIdentity[CatName, EncoderAux] =
    FillIdentity[CatName, EncoderAux].derived2(simpleGen1[EncoderAux].generic)(_.generic)

  implicit lazy val basedInstalled1: BasedInstalled[CatName] =
    BasedInstalled[CatName].derived(compatLabelledInstalled, deco1_1, deco2_1)
  implicit lazy val basedInstalled2: BasedInstalled[FAlias] = BasedInstalled[FAlias].derived(li11, deco2_1_1, deco2_1_2)

  implicit lazy val li1222: FillIdentity[FAlias, Encoder] =
    FillIdentity[FAlias, Encoder].derived2(simpleGen1[EncoderAux].generic)(_.generic)

  implicit lazy val caseClassEncoder: Encoder[CatName[cats.Id]]             = encodeModel
  implicit lazy val caseClassNameEncoder: Encoder[CatName[EncoderModelAux]] = encodeModel[FAlias]

  val modelInstance: CatName[cats.Id] = CatName[cats.Id](
    name = 8594,
    str = Option("sdfwerwfweher迷雾日哦"),
    uClass = Option.empty,
    name11 = "xxiwerwjkl",
    namexu = "jerokwjoe收代理费加沃尔"
  )

  val namedModel: CatName[EncoderModelAux] = implicitly[BasedInstalled[CatName]].labelled

  final override def run(args: List[String]): IO[ExitCode] = {
    for {
      _ <- IO(println(modelInstance.asJson.spaces2))
      _ <- IO(println(namedModel.asJson.spaces2))
    } yield {
      //
    }
  }.map(_ => ExitCode.Success)

  /** { "name" : 8594, "str" : "sdfwerwfweher迷雾日哦", "uClass" : null, "name11" : "xxiwerwjkl", "namexu" : "jerokwjoe收代理费加沃尔" }
    */

  /** { "name" : "name", "str" : "str", "uClass" : "uClass", "name11" : "name11", "namexu" : "namexu" }
    */
}
