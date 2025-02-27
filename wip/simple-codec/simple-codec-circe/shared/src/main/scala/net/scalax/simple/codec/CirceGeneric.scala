package net.scalax.simple
package codec

import io.circe.Decoder.Result
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
      override def zip[A1, B1, C1, A2, B2, C2, A3, B3, C3](
        c: SimpleProduct3.ConvertF3[A1, B1, C1, A2, B2, C2, A3, B3, C3],
        ma: EncodeJson[A1, A2, A3],
        mb: EncodeJson[B1, B2, B3]
      ): EncodeJson[C1, C2, C3] = new EncodeJson[C1, C2, C3] {
        override def toJson(n: C1, enc: C2, id: C3, l: List[(String, Json)]): List[(String, Json)] = {
          val list1 = mb.toJson(c.takeTail1(n), c.takeTail2(enc), c.takeTail3(id), l)
          ma.toJson(c.takeHead1(n), c.takeHead2(enc), c.takeHead3(id), list1)
        }
      }
      override def zero[N1, N2, N3](n1: N1, n2: N2, n3: N3): EncodeJson[N1, N2, N3] = new EncodeJson[N1, N2, N3] {
        override def toJson(n: N1, enc: N2, id: N3, l: List[(String, Json)]): List[(String, Json)] = l
      }
    }

    val typeGen: SimpleProduct3.TypeGen[EncodeJson, Named, Encoder, cats.Id] =
      new SimpleProduct3.TypeGen[EncodeJson, Named, Encoder, cats.Id] {
        override def apply[T]: EncodeJson[String, Encoder[T], T] = new EncodeJson[String, Encoder[T], T] {
          override def toJson(n: String, enc: Encoder[T], id: T, l: List[(String, Json)]): List[(String, Json)] = (n, enc(id)) :: l
        }
      }

    val modeToJson: EncodeJson[F[Named], F[Encoder], F[cats.Id]] = sp3.toHList1[EncodeJson, Named, Encoder, cats.Id](appender)(typeGen)

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
      /*override def zip[A, B, C, S, T, U](ma: DecodeJson[A, B, C], ms: DecodeJson[S, T, U]): DecodeJson[(A, S), (B, T), (C, U)] =
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
      }*/

      override def zip[A1, B1, C1, A2, B2, C2, A3, B3, C3](
        c: SimpleProduct3.ConvertF3[A1, B1, C1, A2, B2, C2, A3, B3, C3],
        ma: DecodeJson[A1, A2, A3],
        mb: DecodeJson[B1, B2, B3]
      ): DecodeJson[C1, C2, C3] = new DecodeJson[C1, C2, C3] {
        override def fromJson(n: C1, enc: C2): Result[C3] = for {
          t1 <- ma.fromJson(c.takeHead1(n), c.takeHead2(enc))
          t2 <- mb.fromJson(c.takeTail1(n), c.takeTail2(enc))
        } yield c.from3(t1, t2)
      }
      override def zero[N1, N2, N3](n1: N1, n2: N2, n3: N3): DecodeJson[N1, N2, N3] = new DecodeJson[N1, N2, N3] {
        override def fromJson(n: N1, enc: N2): Result[N3] = Right(n3)
      }
    }

    val typeGen: SimpleProduct3.TypeGen[DecodeJson, Named, Decoder, cats.Id] =
      new SimpleProduct3.TypeGen[DecodeJson, Named, Decoder, cats.Id] {
        override def apply[T]: DecodeJson[String, Decoder[T], T] = new DecodeJson[String, Decoder[T], T] {
          override def fromJson(n: String, dec: Decoder[T]): Decoder.Result[T] = hCursor.downField(n).as(dec)
        }
      }

    val decoderFunc: DecodeJson[F[Named], F[Decoder], F[cats.Id]] = sp3.toHList1(appender)(typeGen)

    decoderFunc.fromJson(named, g)
  }

}
