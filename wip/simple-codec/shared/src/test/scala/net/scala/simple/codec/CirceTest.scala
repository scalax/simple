package net.scalax.simple
package codec

import io.circe._
import io.circe.syntax._
import cats.effect._
import net.scalax.simple.codec.LabelledInstalled.ToNamed
import net.scalax.simple.codec.to_list_generic.ToListGenerc
import net.scalax.simple.codec.unzip_generic.{Func50Generic, Func50GenericImpl}
import net.scalax.simple.codec.generic.SimpleFromProduct

case class CatName[F[_]](name: F[Int], str: F[Option[String]], uClass: F[Option[Long]], name11: F[String], namexu: F[String])

trait IOApp1 {
  def run(args: List[String]): IO[ExitCode]
}

object xxbb1 extends IOApp1 {

  def encodeModel[F[_[_]]](implicit
    g: FillIdentity[F, Encoder],
    g1: LabelledInstalled[F],
    function050Generic: Function50Generic[F],
    toList: ToListGenerc[F]
  ): Encoder[F[cats.Id]] = {
    val prepareEncoder = function050Generic.function3[Encoder, ({ type U1[T] = String })#U1, cats.Id, ({ type U1[T] = (String, Json) })#U1](
      new Function3Apply[Encoder, ({ type U1[T] = String })#U1, cats.Id, ({ type U1[T] = (String, Json) })#U1] {
        override def apply[X](i1: Encoder[X], i2: String, i3: X): (String, Json) = i2 -> i1(i3)
      }
    ) _

    Encoder.instance[F[cats.Id]] { m =>
      val jsonList1 = prepareEncoder(g.model, g1.model, m)
      Json.fromJsonObject(JsonObject.fromIterable(toList.toList(jsonList1)))
    }
  }

  type EncoderAux[_]      = Encoder[String]
  type EncoderModelAux[_] = String
  def encodeModelName[F[_[_]]](implicit
    modelEn: FillIdentity[F, EncoderAux],
    g: LabelledInstalled[F],
    g1: Function50Generic[F],
    lNames: ToListGenerc[F]
  ): Encoder[F[EncoderModelAux]] = {
    type FAlias[UX[_]] = F[({ type U1[T] = UX[String] })#U1]

    val li1: FillIdentity[FAlias, Encoder] = new FillIdentity[FAlias, Encoder] {
      override def model: FAlias[Encoder] = modelEn.model
    }

    val li: LabelledInstalled[FAlias] = new LabelledInstalled[FAlias] {
      override def model: FAlias[ToNamed] = g.model
    }
    val gen: Function50Generic[FAlias] = new Func50GenericImpl[FAlias] {
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
    val to1: ToListGenerc[FAlias] = new ToListGenerc[FAlias] {
      override def toList[TU](input: FAlias[({ type U1[X] = TU })#U1]): List[TU] = lNames.toList[TU](input)
    }

    encodeModel(li1, li, gen, to1)
  }

  def simpleGen1[I[_]] = SimpleFromProduct[CatName, I].derived

  implicit val im111: Function50Generic[CatName] = new Func50Generic.Impl[CatName] {
    override def impl1[In1[_]] = _.derived2(simpleGen1[cats.Id].generic, simpleGen1[In1].generic)(_.generic)
    override def impl2[In1[_], In2[_], In3[_]] =
      _.derived2(simpleGen1[cats.Id].generic, simpleGen1[In1].generic, simpleGen1[In2].generic, simpleGen1[In3].generic)(_.generic)
  }
  implicit val im2: ToListGenerc[CatName] = new ToListGenerc.Impl[CatName] {
    override def impl[U] = _.derived2(simpleGen1[({ type U1[_] = U })#U1].generic)(_.generic)
  }

  implicit val compatLabelledInstalled: CompatLabelledInstalled[CatName] =
    CompatLabelledInstalled[CatName].derived(simpleGen1[CompatLabelledInstalled.ToNamed].generic)

  implicit val labelledInstalled: LabelledInstalled[CatName] = LabelledInstalled[CatName].derived

  implicit val modelEncoder: FillIdentity[CatName, Encoder] =
    FillIdentity[CatName, Encoder].derived2(simpleGen1[Encoder].generic)(_.generic)
  implicit val modelEncoder2: FillIdentity[CatName, EncoderAux] =
    FillIdentity[CatName, EncoderAux].derived2(simpleGen1[EncoderAux].generic)(_.generic)

  implicit val caseClassEncoder: Encoder[CatName[cats.Id]]             = encodeModel
  implicit val caseClassNameEncoder: Encoder[CatName[EncoderModelAux]] = encodeModelName

  val modelInstance: CatName[cats.Id] = CatName[cats.Id](
    name = 8594,
    str = Option("sdfwerwfweher迷雾日哦"),
    uClass = Option.empty,
    name11 = "xxiwerwjkl",
    namexu = "jerokwjoe收代理费加沃尔"
  )

  final override def run(args: List[String]): IO[ExitCode] = {
    for {
      _ <- IO(println(modelInstance.asJson.spaces2))
      _ <- IO(println(labelledInstalled.model.asJson.spaces2))
    } yield {
      //
    }
  }.map(_ => ExitCode.Success)

  /** { "name" : 8594, "str" : "sdfwerwfweher迷雾日哦", "uClass" : null, "name11" : "xxiwerwjkl", "namexu" : "jerokwjoe收代理费加沃尔" }
    */

  /** { "name" : "name", "str" : "str", "uClass" : "uClass", "name11" : "name11", "namexu" : "namexu" }
    */
}
