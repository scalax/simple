package net.scalax.simple
package codec

import play.api.libs.json._
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._
import net.scalax.simple.codec.to_list_generic.{BasedInstalled, SimpleProduct3}

object PlayJsonGeneric2 {
  type Named[_] = String

  def writesModelImpl[F[_[_]]](model: F[cats.Id], simpleProduct3: SimpleProduct3.Appender[F], named: F[Named], g: F[Writes]): JsValue = {

    trait EncodeJson[Name, Enc, Id] {
      def toJson(n: Name, enc: Enc, id: Id, l: List[(String, JsValue)]): List[(String, JsValue)]
    }

    val appender: SimpleProduct3.AppendMonad[EncodeJson] = new SimpleProduct3.AppendMonad[EncodeJson] {
      override def zip[A, B, C, S, T, U](ma: EncodeJson[A, B, C], ms: EncodeJson[S, T, U]): EncodeJson[(A, S), (B, T), (C, U)] =
        new EncodeJson[(A, S), (B, T), (C, U)] {
          override def toJson(n: (A, S), enc: (B, T), id: (C, U), l: List[(String, JsValue)]): List[(String, JsValue)] =
            ma.toJson(n._1, enc._1, id._1, ms.toJson(n._2, enc._2, id._2, l))
        }

      override def to[A, B, C, S, T, U](
        m1: EncodeJson[A, B, C]
      )(in1: A => S, in2: B => T, in3: C => U)(in4: S => A, in5: T => B, in6: U => C): EncodeJson[S, T, U] = new EncodeJson[S, T, U] {
        def toJson(n: S, enc: T, id: U, l: List[(String, JsValue)]): List[(String, JsValue)] = m1.toJson(in4(n), in5(enc), in6(id), l)
      }

      override def zero: EncodeJson[SimpleZero, SimpleZero, SimpleZero] = new EncodeJson[SimpleZero, SimpleZero, SimpleZero] {
        def toJson(n: SimpleZero, enc: SimpleZero, id: SimpleZero, l: List[(String, JsValue)]): List[(String, JsValue)] = l
      }
    }

    val typeGen: SimpleProduct3.TypeGen[EncodeJson, Named, Writes, cats.Id] =
      new SimpleProduct3.TypeGen[EncodeJson, Named, Writes, cats.Id] {
        override def apply[T]: EncodeJson[String, Writes[T], T] = new EncodeJson[String, Writes[T], T] {
          override def toJson(n: String, enc: Writes[T], id: T, l: List[(String, JsValue)]): List[(String, JsValue)] =
            (n, enc.writes(id)) :: l
        }
      }

    val modeToJson: EncodeJson[F[Named], F[Writes], F[cats.Id]] =
      simpleProduct3.toHList[EncodeJson, Named, Writes, cats.Id](appender, typeGen)

    val list: List[(String, JsValue)] = modeToJson.toJson(named, g, model, List.empty)
    JsObject(list)
  }

  /*def decodeModelImpl[F[_[_]]](g1: BasedInstalled[F], g: F[Decoder]): Decoder[F[cats.Id]] = {
    val sp2: SimpleProduct2.Appender[F] = SimpleProduct2[F].derived(g1.basedInstalled)
    val sp3: SimpleProduct3.Appender[F] = SimpleProduct3[F].derived(g1.basedInstalled)
    val zipGeneric: ZipGeneric[F]       = ZipGeneric[F].derived(sp3)
    val mapGenerc: MapGenerc[F]         = MapGenerc[F].derived(sp2)

    val zip1 = zipGeneric.zip[Named, Decoder](g1.labelled.modelLabelled, g)
    val map1 = mapGenerc.map[({ type U1[T1] = (String, Decoder[T1]) })#U1, ({ type U1[T1] = HCursor => Decoder.Result[T1] })#U1](
      new MapGenerc.MapFunction[({ type U1[T1] = (String, Decoder[T1]) })#U1, ({ type U1[T1] = HCursor => Decoder.Result[T1] })#U1] {
        override def map[X1](nameDecoder: (String, Decoder[X1])): HCursor => Decoder.Result[X1] =
          hcursor => hcursor.downField(nameDecoder._1).as(nameDecoder._2)
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
      override def zero: SimpleZero => Decoder.Result[SimpleZero] = s => Right(s)
    }

    def toDecoder(hCursor: HCursor): SimpleProduct2.TypeGen[Func, ({ type U1[T1] = HCursor => Decoder.Result[T1] })#U1, cats.Id] =
      new SimpleProduct2.TypeGen[Func, ({ type U1[T1] = HCursor => Decoder.Result[T1] })#U1, cats.Id] {
        override def apply[T]: (HCursor => Decoder.Result[T]) => Decoder.Result[T] = s => s(hCursor)
      }
    def contextWith(hCursor: HCursor): F[({ type U1[T1] = HCursor => Decoder.Result[T1] })#U1] => Decoder.Result[F[cats.Id]] = {
      sp2.toHList[Func, ({ type U1[T1] = HCursor => Decoder.Result[T1] })#U1, cats.Id](monadAdd)(toDecoder(hCursor))
    }

    Decoder.instance[F[cats.Id]](hCursor => contextWith(hCursor)(map1))
  }*/

}
