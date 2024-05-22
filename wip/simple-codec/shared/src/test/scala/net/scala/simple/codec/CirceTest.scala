package net.scalax.simple
package codec

import io.circe._
import io.circe.syntax._
import cats.effect._
import net.scalax.simple.codec.to_list_generic.{SimpleProduct, SimpleProduct2, ToListByTheSameTypeGeneric}
import net.scalax.simple.codec.generic.SimpleFromProduct

case class CatName[F[_]](name: F[Int], str: F[Option[String]], uClass: F[Option[Long]], name11: F[String], namexu: F[String])

trait IOApp1 {
  def run(args: List[String]): IO[ExitCode]
}

object xxbb1 extends IOApp1 {

  def encodeModelImpl[F[_[_]]](implicit
    g: F[Encoder],
    g1: SimpleProduct.Appender[F],
    named: F[LabelledInstalled.Named]
  ): Encoder[F[cats.Id]] = {
    val toList: ToListByTheSameTypeGeneric[F] = ToListByTheSameTypeGeneric[F].derived(g1)
    val zipGeneric: ZipGeneric[F]             = ZipGeneric[F].derived(g1)
    val mapGenerc: MapGenerc[F]               = MapGenerc[F].derived(g1)

    Encoder.instance[F[cats.Id]] { m =>
      val zip1 = zipGeneric.zip(m, g)
      val map1 = mapGenerc.map[({ type U1[T1] = (T1, Encoder[T1]) })#U1, ({ type U1[T1] = Json })#U1](
        new MapGenerc.MapFunction[({ type U1[T1] = (T1, Encoder[T1]) })#U1, ({ type U1[T1] = Json })#U1] {
          override def map[X1]: ((X1, Encoder[X1])) => Json = s => s._2(s._1)
        }
      )(zip1)
      val zip2  = zipGeneric.zip[({ type U1[T1] = String })#U1, ({ type U1[T1] = Json })#U1](named, map1)
      val list1 = toList.toListByTheSameType[(String, Json)](zip2)
      Json.fromJsonObject(JsonObject.fromIterable(list1))
    }
  }

  def encodeModel[F[_[_]]](implicit
    g: F[Encoder],
    g1: SimpleProduct.Appender[F],
    named: NamedImplicit[F[LabelledInstalled.Named]]
  ): Encoder[F[cats.Id]] = {
    val labelledInstalled = LabelledInstalled[F].derived(g1, named)
    encodeModelImpl(g, g1, labelledInstalled.labelled)
  }

  def decodeModelImpl[F[_[_]]](implicit
    g: F[Decoder],
    g1: SimpleProduct.Appender[F],
    named: F[LabelledInstalled.Named]
  ): Decoder[F[cats.Id]] = {
    val zipGeneric: ZipGeneric[F]          = ZipGeneric[F].derived(g1)
    val mapGenerc: MapGenerc[F]            = MapGenerc[F].derived(g1)
    val decode: SimpleProduct2.Appender[F] = SimpleProduct2.Appender[F].derived(g1)

    val zip1 = zipGeneric.zip[EncoderModelAux, Decoder](named, g)
    val map1 = mapGenerc.map[({ type U1[T1] = (String, Decoder[T1]) })#U1, ({ type U1[T1] = HCursor => Decoder.Result[T1] })#U1](
      new MapGenerc.MapFunction[({ type U1[T1] = (String, Decoder[T1]) })#U1, ({ type U1[T1] = HCursor => Decoder.Result[T1] })#U1] {
        override def map[X1]: ((String, Decoder[X1])) => HCursor => Decoder.Result[X1] =
          (nameDecoder: (String, Decoder[X1])) => (hcursor: HCursor) => hcursor.downField(nameDecoder._1).as(nameDecoder._2)
      }
    )(zip1)

    type Func[A, B] = A => Decoder.Result[B]
    val monadAdd: SimpleProduct2.AppendMonad[Func] = new SimpleProduct2.AppendMonad[Func] {
      override def zip[A, B, S, T](ma: A => Decoder.Result[B], ms: S => Decoder.Result[T]): ((A, S)) => Decoder.Result[(B, T)] = as =>
        for {
          b <- ma(as._1).right
          t <- ms(as._2).right
        } yield (b, t)

      override def to[A, B, S, T](m1: A => Decoder.Result[B])(in1: A => S, in2: B => T)(in3: S => A, in4: T => B): S => Decoder.Result[T] =
        s => m1(in3(s)).right.map(in2)
      override def zero: Unit => Decoder.Result[Unit] = s => Right(s)
    }

    def toDecoder(hCursor: HCursor): SimpleProduct2.TypeGen[Func, ({ type U1[T1] = HCursor => Decoder.Result[T1] })#U1, cats.Id] =
      new SimpleProduct2.TypeGen[Func, ({ type U1[T1] = HCursor => Decoder.Result[T1] })#U1, cats.Id] {
        override def apply[T]: (HCursor => Decoder.Result[T]) => Decoder.Result[T] = s => s(hCursor)
      }
    def contextWith(hCursor: HCursor): F[({ type U1[T1] = HCursor => Decoder.Result[T1] })#U1] => Decoder.Result[F[cats.Id]] = {
      decode.toHList[Func, ({ type U1[T1] = HCursor => Decoder.Result[T1] })#U1, cats.Id](monadAdd)(toDecoder(hCursor))
    }

    Decoder.instance[F[cats.Id]](hCursor => contextWith(hCursor)(map1))
  }

  def decodeModel[F[_[_]]](implicit
    g: F[Decoder],
    g1: SimpleProduct.Appender[F],
    named: NamedImplicit[F[LabelledInstalled.Named]]
  ): Decoder[F[cats.Id]] = {
    val labelledInstalled = LabelledInstalled[F].derived(g1, named)
    decodeModelImpl(g, g1, labelledInstalled.labelled)
  }

  type EncoderAux[_]      = Encoder[String]
  type DecoderAux[_]      = Decoder[String]
  type EncoderModelAux[_] = String

  def simpleGen1[I[_]] = SimpleFromProduct[CatName, I].derived

  implicit lazy val deco2_1: SimpleProduct.Appender[CatName] = new SimpleProduct.Appender.Impl[CatName] {
    override def impl[M1[_, _, _], M2[_], M3[_], M4[_]] =
      _.derived2(simpleGen1[cats.Id].generic, simpleGen1[M2].generic, simpleGen1[M3].generic, simpleGen1[M4].generic)(_.generic)
  }

  type FAlias[UX[_]] = CatName[({ type U1[T] = UX[String] })#U1]

  implicit lazy val modelEncoder: CatName[Encoder] =
    FillIdentity[CatName, Encoder].derived2(simpleGen1[Encoder].generic)(_.generic)
  implicit lazy val modelDecoder: CatName[Decoder] =
    FillIdentity[CatName, Decoder].derived2(simpleGen1[Decoder].generic)(_.generic)

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

  implicit lazy val caseClassEncoder: Encoder[CatName[cats.Id]]             = encodeModel
  implicit lazy val caseClassDecoder: Decoder[CatName[cats.Id]]             = decodeModel
  implicit lazy val caseClassNameEncoder: Encoder[CatName[EncoderModelAux]] = encodeModel[FAlias]
  implicit lazy val caseClassNameDecoder: Decoder[CatName[EncoderModelAux]] = decodeModel[FAlias]

  val modelInstance: CatName[cats.Id] = CatName[cats.Id](
    name = 8594,
    str = Option("sdfwerwfweher迷雾日哦"),
    uClass = Option.empty,
    name11 = "xxiwerwjkl",
    namexu = "jerokwjoe收代理费加沃尔"
  )

  val namedModel: CatName[EncoderModelAux] = LabelledInstalled[FAlias].derived(basedInstalled2, implicitly).labelled

  final override def run(args: List[String]): IO[ExitCode] = {
    for {
      _ <- IO(println(modelInstance.asJson.spaces2))
      _ <- IO(println(namedModel.asJson.spaces2))
      _ <- IO(println(parser.parse(modelInstance.asJson.spaces2).right.flatMap(_.as[CatName[cats.Id]])))
      _ <- IO(println(parser.parse(namedModel.asJson.spaces2).right.flatMap(_.as[CatName[cats.Id]])))
      _ <- IO(println(parser.parse(namedModel.asJson.spaces2).right.flatMap(_.as[CatName[EncoderModelAux]])))
      _ <- IO(println(parser.parse(modelInstance.asJson.spaces2).right.flatMap(_.as[CatName[EncoderModelAux]])))
    } yield {
      //
    }
  }.map(_ => ExitCode.Success)

  /** { "name" : 8594, "str" : "sdfwerwfweher迷雾日哦", "uClass" : null, "name11" : "xxiwerwjkl", "namexu" : "jerokwjoe收代理费加沃尔" }
    */

  /** { "name" : "name", "str" : "str", "uClass" : "uClass", "name11" : "name11", "namexu" : "namexu" }
    */
}
