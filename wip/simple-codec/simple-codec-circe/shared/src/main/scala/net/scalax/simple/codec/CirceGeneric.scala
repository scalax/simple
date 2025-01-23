package net.scalax.simple
package codec

import io.circe._
import io.circe.syntax._
import net.scalax.simple.codec.to_list_generic.{
  ConvertM1,
  ConvertM2,
  ConvertM3,
  SimpleProduct1,
  SimpleProduct2,
  SimpleProduct3,
  ToListByTheSameTypeGeneric
}
import net.scalax.simple.codec.utils.SimpleP

object CirceGeneric {
  type Named[_] = String

  def encodeModelImpl[F[_[_]]](implicit
    g: F[Encoder],
    g1: SimpleProduct3.NotHList.Appender[F],
    named: F[Named]
  ): Encoder[F[cats.Id]] = {
    val sp3: SimpleP.Appender[F]              = ConvertM3.AppendMonad.Appender.to3[F](g1)
    val sp1: SimpleProduct1.Appender[F]       = ConvertM1.Appender.to1[F](g1)
    val sp2: SimpleProduct2.Appender[F]       = ConvertM2.AppendMonad.Appender.to2[F](g1)
    val toList: ToListByTheSameTypeGeneric[F] = ToListByTheSameTypeGeneric[F].derived(sp1)
    val zipGeneric: ZipGeneric[F]             = ZipGeneric[F].derived(sp3)
    val mapGenerc: MapGenerc[F]               = MapGenerc[F].derived(sp2)

    Encoder.instance[F[cats.Id]] { m =>
      val zip1 = zipGeneric.zip(m, g)
      val map1 = mapGenerc.map[({ type U1[T1] = (T1, Encoder[T1]) })#U1, ({ type U1[T1] = Json })#U1](
        new MapGenerc.MapFunction[({ type U1[T1] = (T1, Encoder[T1]) })#U1, ({ type U1[T1] = Json })#U1] {
          override def map[X1]: ((X1, Encoder[X1])) => Json = s => s._2(s._1)
        }
      )(zip1)
      val zip2  = zipGeneric.zip[({ type U1[T1] = String })#U1, ({ type U1[T1] = Json })#U1](named, map1)
      val list1 = toList.toListByTheSameType[(String, Json), List[(String, Json)]](zero = List.empty, append = (tail, h) => h :: tail)(zip2)
      Json.fromJsonObject(JsonObject.fromIterable(list1))
    }
  }

  def decodeModelImpl[F[_[_]]](implicit
    g: F[Decoder],
    g1: SimpleProduct3.NotHList.Appender[F],
    named: F[Named]
  ): Decoder[F[cats.Id]] = {
    val sp3: SimpleP.Appender[F]           = ConvertM3.AppendMonad.Appender.to3[F](g1)
    val sp2: SimpleProduct2.Appender[F]    = ConvertM2.AppendMonad.Appender.to2[F](g1)
    val zipGeneric: ZipGeneric[F]          = ZipGeneric[F].derived(sp3)
    val mapGenerc: MapGenerc[F]            = MapGenerc[F].derived(sp2)
    val decode: SimpleProduct2.Appender[F] = ConvertM2.AppendMonad.Appender.to2[F](g1)

    val zip1 = zipGeneric.zip[Named, Decoder](named, g)
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

}
