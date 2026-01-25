package net.scalax.simple
package codec

import io.circe.Decoder.Result
import io.circe._
import io.circe.syntax._
import net.scalax.simple.adt.nat.support.{ABCFunc, SimpleProduct3}

object CirceGeneric {
  type Named[_] = String

  private trait EncodeJson[Name, Enc, Model] {
    def toJson(n: Name, enc: Enc, id: Model, l: List[(String, Json)]): List[(String, Json)]
  }

  def encodeModelImpl[F[_[_]]](
    simpleProduct3: SimpleProduct3.ProductAdapter[F],
    nameLabelled: F[Named],
    encoderModel: () => F[Encoder]
  ): F[({ type IDF[T] = T })#IDF] => Json = (model: F[({ type IDF[T] = T })#IDF]) => {
    val appender: SimpleProduct3.SimpleAppender[EncodeJson] = new SimpleProduct3.SimpleAppender[EncodeJson] {
      override def append[A1, A2, A3, B1, B2, B3, C1, C2, C3](
        cxF1: ABCFunc[A1, B1, C1],
        cxF2: ABCFunc[A2, B2, C2],
        cxF3: ABCFunc[A3, B3, C3]
      )(
        ma: EncodeJson[A1, A2, A3],
        mb: EncodeJson[B1, B2, B3]
      ): EncodeJson[C1, C2, C3] = new EncodeJson[C1, C2, C3] {
        override def toJson(n: C1, enc: C2, id: C3, l: List[(String, Json)]): List[(String, Json)] = {
          val list1 = mb.toJson(cxF1.takeTail(n), cxF2.takeTail(enc), cxF3.takeTail(id), l)
          ma.toJson(cxF1.takeHead(n), cxF2.takeHead(enc), cxF3.takeHead(id), list1)
        }
      }
      override def zero[N1, N2, N3](n1: N1, n2: N2, n3: N3): EncodeJson[N1, N2, N3] = new EncodeJson[N1, N2, N3] {
        override def toJson(n: N1, enc: N2, id: N3, l: List[(String, Json)]): List[(String, Json)] = l
      }
    }

    val typeGen: SimpleProduct3.TypeGen[EncodeJson, Named, Encoder, ({ type IDF[T] = T })#IDF] =
      new SimpleProduct3.TypeGen[EncodeJson, Named, Encoder, ({ type IDF[T] = T })#IDF] {
        override def gen[T]: EncodeJson[String, Encoder[T], T] = new EncodeJson[String, Encoder[T], T] {
          override def toJson(n: String, enc: Encoder[T], id: T, l: List[(String, Json)]): List[(String, Json)] = (n, enc(id)) :: l
        }
      }

    val encodeFunc: EncodeJson[F[Named], F[Encoder], F[({ type IDF[T] = T })#IDF]] =
      simpleProduct3.append[EncodeJson, Named, Encoder, ({ type IDF[T] = T })#IDF](typeGen, appender)

    val list: List[(String, Json)] = encodeFunc.toJson(nameLabelled, encoderModel(), model, List.empty)
    Json.fromJsonObject(JsonObject.fromIterable(list))
  }

  private trait DecodeJson[Name, Dec, Model] {
    def fromJson(n: Name, enc: Dec): Decoder.Result[Model]
  }

  def decodeModelImpl[F[_[_]]](
    sp3: SimpleProduct3.ProductAdapter[F],
    named: F[Named],
    g: () => F[Decoder]
  ): HCursor => Decoder.Result[F[cats.Id]] = (hCursor: HCursor) => {
    val appender: SimpleProduct3.SimpleAppender[DecodeJson] = new SimpleProduct3.SimpleAppender[DecodeJson] {
      override def append[A1, A2, A3, B1, B2, B3, C1, C2, C3](
        cxF1: ABCFunc[A1, B1, C1],
        cxF2: ABCFunc[A2, B2, C2],
        cxF3: ABCFunc[A3, B3, C3]
      )(
        ma: DecodeJson[A1, A2, A3],
        mb: DecodeJson[B1, B2, B3]
      ): DecodeJson[C1, C2, C3] = new DecodeJson[C1, C2, C3] {
        override def fromJson(n: C1, enc: C2): Result[C3] = for {
          t1 <- ma.fromJson(cxF1.takeHead(n), cxF2.takeHead(enc))
          t2 <- mb.fromJson(cxF1.takeTail(n), cxF2.takeTail(enc))
        } yield cxF3.append(t1, t2)
      }
      override def zero[N1, N2, N3](n1: N1, n2: N2, n3: N3): DecodeJson[N1, N2, N3] = new DecodeJson[N1, N2, N3] {
        override def fromJson(n: N1, enc: N2): Result[N3] = Right(n3)
      }
    }

    val typeGen: SimpleProduct3.TypeGen[DecodeJson, Named, Decoder, cats.Id] =
      new SimpleProduct3.TypeGen[DecodeJson, Named, Decoder, cats.Id] {
        override def gen[T]: DecodeJson[String, Decoder[T], T] = new DecodeJson[String, Decoder[T], T] {
          override def fromJson(n: String, dec: Decoder[T]): Decoder.Result[T] = hCursor.downField(n).as(dec)
        }
      }

    val decoderFunc: DecodeJson[F[Named], F[Decoder], F[cats.Id]] = sp3.append(typeGen, appender)

    decoderFunc.fromJson(named, g())
  }

}
