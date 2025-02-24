package net.scalax.simple
package codec

import io.circe._
import io.circe.syntax._
import net.scalax.simple.codec.to_list_generic.SimpleProduct3

object CirceGeneric {
  type Named[_] = String

  def encodeModelImpl[F[_[_]]](model: F[cats.Id], sp3: SimpleProduct3.Appender[F], named: F[Named], g: F[Encoder]): Json = {
    trait EncodeJson[Name, Enc, Model] {
      def toJson(n: Name, enc: Enc, id: Model, l: List[(String, Json)]): List[(String, Json)]
    }

    val appender: SimpleProduct3.AppendMonad[EncodeJson] = new SimpleProduct3.AppendMonad[EncodeJson] {
      override def zip[A, B, C, S, T, U](ma: EncodeJson[A, B, C], ms: EncodeJson[S, T, U]): EncodeJson[(A, S), (B, T), (C, U)] =
        new EncodeJson[(A, S), (B, T), (C, U)] {
          override def toJson(n: (A, S), enc: (B, T), id: (C, U), l: List[(String, Json)]): List[(String, Json)] =
            ma.toJson(n._1, enc._1, id._1, ms.toJson(n._2, enc._2, id._2, l))
        }

      override def to[A, B, C, S, T, U](
        m1: EncodeJson[A, B, C]
      )(in1: A => S, in2: B => T, in3: C => U)(in4: S => A, in5: T => B, in6: U => C): EncodeJson[S, T, U] = new EncodeJson[S, T, U] {
        override def toJson(n: S, enc: T, id: U, l: List[(String, Json)]): List[(String, Json)] = m1.toJson(in4(n), in5(enc), in6(id), l)
      }

      override def zero: EncodeJson[SimpleZero, SimpleZero, SimpleZero] = new EncodeJson[SimpleZero, SimpleZero, SimpleZero] {
        override def toJson(n: SimpleZero, enc: SimpleZero, id: SimpleZero, l: List[(String, Json)]): List[(String, Json)] = l
      }
    }

    val typeGen: SimpleProduct3.TypeGen[EncodeJson, Named, Encoder, cats.Id] =
      new SimpleProduct3.TypeGen[EncodeJson, Named, Encoder, cats.Id] {
        override def apply[T]: EncodeJson[String, Encoder[T], T] = new EncodeJson[String, Encoder[T], T] {
          override def toJson(n: String, enc: Encoder[T], id: T, l: List[(String, Json)]): List[(String, Json)] = (n, enc(id)) :: l
        }
      }

    val modeToJson: EncodeJson[F[Named], F[Encoder], F[cats.Id]] = sp3.toHList[EncodeJson, Named, Encoder, cats.Id](appender, typeGen)

    val list: List[(String, Json)] = modeToJson.toJson(named, g, model, List.empty)
    Json.fromJsonObject(JsonObject.fromIterable(list))
  }

  def decodeModelImpl[F[_[_]]](
    hCursor: HCursor,
    sp3: SimpleProduct3.Appender[F],
    named: F[Named],
    g: F[Decoder]
  ): Decoder.Result[F[cats.Id]] = {
    trait DecodeJson[Name, Dec, Model] {
      def fromJson(n: Name, enc: Dec): Decoder.Result[Model]
    }

    val appender: SimpleProduct3.AppendMonad[DecodeJson] = new SimpleProduct3.AppendMonad[DecodeJson] {
      override def zip[A, B, C, S, T, U](ma: DecodeJson[A, B, C], ms: DecodeJson[S, T, U]): DecodeJson[(A, S), (B, T), (C, U)] =
        new DecodeJson[(A, S), (B, T), (C, U)] {
          override def fromJson(n: (A, S), enc: (B, T)): Decoder.Result[(C, U)] = for {
            t1 <- ma.fromJson(n._1, enc._1)
            t2 <- ms.fromJson(n._2, enc._2)
          } yield (t1, t2)
        }

      override def to[A, B, C, S, T, U](
        m1: DecodeJson[A, B, C]
      )(in1: A => S, in2: B => T, in3: C => U)(in4: S => A, in5: T => B, in6: U => C): DecodeJson[S, T, U] = new DecodeJson[S, T, U] {
        override def fromJson(n: S, enc: T): Decoder.Result[U] = for (t <- m1.fromJson(in4(n), in5(enc))) yield in3(t)
      }

      override def zero: DecodeJson[SimpleZero, SimpleZero, SimpleZero] = new DecodeJson[SimpleZero, SimpleZero, SimpleZero] {
        override def fromJson(n: SimpleZero, enc: SimpleZero): Decoder.Result[SimpleZero] = Right(SimpleZero.value)
      }
    }

    val typeGen: SimpleProduct3.TypeGen[DecodeJson, Named, Decoder, cats.Id] =
      new SimpleProduct3.TypeGen[DecodeJson, Named, Decoder, cats.Id] {
        override def apply[T]: DecodeJson[String, Decoder[T], T] = new DecodeJson[String, Decoder[T], T] {
          override def fromJson(n: String, dec: Decoder[T]): Decoder.Result[T] = hCursor.downField(n).as(dec)
        }
      }

    val decoderFunc: DecodeJson[F[Named], F[Decoder], F[cats.Id]] = sp3.toHList(appender, typeGen)

    decoderFunc.fromJson(named, g)
  }

}
