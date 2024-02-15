package net.scalax.simple
package codec

import io.circe._
import io.circe.syntax._
import cats.effect._
import net.scalax.simple.codec
import net.scalax.simple.codec.LabelledInstalled.ToNamed
import net.scalax.simple.codec.to_list_generic.{ToDecoderGeneric, ToDecoderGeneric1, ToListGeneric}
import net.scalax.simple.codec.unzip_generic.{Func50Generic, Func50GenericImpl}
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
    val prepareEncoder = g1.funcion50.function3[Encoder, ({ type U1[T] = String })#U1, cats.Id, ({ type U1[T] = (String, Json) })#U1](
      new Function3Apply[Encoder, ({ type U1[T] = String })#U1, cats.Id, ({ type U1[T] = (String, Json) })#U1] {
        override def apply[X](i1: Encoder[X], i2: String, i3: X): (String, Json) = i2 -> i1(i3)
      }
    ) _

    val toList: ToListGeneric[F] = ToListGeneric[F].derived(g1)

    Encoder.instance[F[cats.Id]] { m =>
      val jsonList1 = prepareEncoder(g.model, g1.labelled.model, m)
      Json.fromJsonObject(JsonObject.fromIterable(toList.toList(jsonList1)))
    }
  }

  type EncoderAux[_]      = Encoder[String]
  type EncoderModelAux[_] = String

  def simpleGen1[I[_]] = SimpleFromProduct[CatName, I].derived

  lazy val im111: Function50Generic[CatName] = new Func50Generic.Impl[CatName] {
    override def impl1[In1[_]] = _.derived2(simpleGen1[cats.Id].generic, simpleGen1[In1].generic)(_.generic)
    override def impl2[In1[_], In2[_], In3[_]] =
      _.derived2(simpleGen1[cats.Id].generic, simpleGen1[In1].generic, simpleGen1[In2].generic, simpleGen1[In3].generic)(_.generic)
  }

  lazy val compatLabelledInstalled: CompatLabelledInstalled[CatName] =
    CompatLabelledInstalled[CatName].derived(simpleGen1[CompatLabelledInstalled.ToNamed].generic)

  lazy val deco1_1: ToDecoderGeneric[CatName] = new ToDecoderGeneric.Impl[CatName] {
    override def impl[M1[_], M2[_, _], M3[_]] =
      _.derived2(simpleGen1[cats.Id].generic, simpleGen1[M1].generic, simpleGen1[M3].generic)(_.generic)
  }
  lazy val deco2_1: ToDecoderGeneric1[CatName] = new ToDecoderGeneric1.Impl[CatName] {
    override def impl[M1[_], M2[_]] = _.derived2(simpleGen1[cats.Id].generic, simpleGen1[M1].generic)(_.generic)
  }

  type FAlias[UX[_]] = CatName[({ type U1[T] = UX[String] })#U1]
  lazy val li11: LabelledInstalled[FAlias] = LabelledInstalled[FAlias].instance(implicitly[BasedInstalled[CatName]].labelled.model)
  lazy val gen11: Function50Generic[FAlias] = new Func50GenericImpl[FAlias] {
    val g1: Function50Generic[CatName] = implicitly[BasedInstalled[CatName]].funcion50

    override def function0[T[_]](func1: Function0Apply[T]): FAlias[T] =
      g1.function0[({ type U1[XX] = T[String] })#U1](new Function0Apply[({ type U1[XX] = T[String] })#U1] {
        override def apply[X1]: T[String] = func1.apply[String]
      })
    override def function2[S[_], T[_], U[_]](func1: Function2Apply[S, T, U])(f1: FAlias[S], f2: FAlias[T]): FAlias[U] =
      g1.function2[({ type U1[_] = S[String] })#U1, ({ type U1[_] = T[String] })#U1, ({ type U1[_] = U[String] })#U1](
        new Function2Apply[({ type U1[_] = S[String] })#U1, ({ type U1[_] = T[String] })#U1, ({ type U1[_] = U[String] })#U1] {
          override def apply[X1](i1: S[String], i2: T[String]): U[String] = func1.apply[String](i1, i2)
        }
      )(f1, f2)
  }
  lazy val deco2_1_1: ToDecoderGeneric[FAlias] = new ToDecoderGeneric[FAlias] {
    private val toDecoderCatName = implicitly[BasedInstalled[CatName]].decode

    override def toHList[M2[_, _], M1[_], M3[_]](
      monad: MonadAdd[M2]
    )(
      func: ToDecoderGeneric.FuncImpl[M2, M1, M3]
    ): M2[CatName[({ type U1[X] = M1[String] })#U1], CatName[({ type U1[X] = M3[String] })#U1]] =
      toDecoderCatName.toHList[M2, ({ type U1[X] = M1[String] })#U1, ({ type U1[X] = M3[String] })#U1](monad)(
        new ToDecoderGeneric.FuncImpl[M2, ({ type U1[X] = M1[String] })#U1, ({ type U1[X] = M3[String] })#U1] {
          override def apply[T]: M2[M1[String], M3[String]] = func[String]
        }
      )
  }
  lazy val deco2_1_2: ToDecoderGeneric1[FAlias] = new ToDecoderGeneric1[FAlias] {
    private val toDecoderCatName = implicitly[BasedInstalled[CatName]].decode1

    override def toHList1[M2[_], M1[_]](
      monad: MonadAdd1[M2]
    )(func: ToDecoderGeneric1.FuncImpl1[M1, M2]): M2[CatName[({ type U1[X] = M1[String] })#U1]] =
      toDecoderCatName.toHList1[M2, ({ type U1[X] = M1[String] })#U1](monad)(
        new ToDecoderGeneric1.FuncImpl1[({ type U1[X] = M1[String] })#U1, M2] {
          override def apply[T]: M2[M1[String]] = func[String]
        }
      )
  }

  implicit lazy val modelEncoder: FillIdentity[CatName, Encoder] =
    FillIdentity[CatName, Encoder].derived2(simpleGen1[Encoder].generic)(_.generic)
  implicit lazy val modelEncoder2: FillIdentity[CatName, EncoderAux] =
    FillIdentity[CatName, EncoderAux].derived2(simpleGen1[EncoderAux].generic)(_.generic)

  implicit lazy val basedInstalled1: BasedInstalled[CatName] =
    BasedInstalled[CatName].derived(compatLabelledInstalled, im111, deco1_1, deco2_1)
  implicit lazy val basedInstalled2: BasedInstalled[FAlias] = BasedInstalled[FAlias].derived(li11, gen11, deco2_1_1, deco2_1_2)

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

  val namedModel: CatName[EncoderModelAux] = implicitly[BasedInstalled[CatName]].labelled.model

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
