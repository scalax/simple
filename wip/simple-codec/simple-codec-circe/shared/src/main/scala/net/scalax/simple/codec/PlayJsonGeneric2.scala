package net.scalax.simple
package codec

import play.api.libs.json._
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._
import net.scalax.simple.codec.to_list_generic.SimpleProduct3

object PlayJsonGeneric2 {
  type Named[_] = String

  def writesModelImpl[F[_[_]]](model: F[cats.Id], simpleProduct3: SimpleProduct3.Appender[F], named: F[Named], g: F[Writes]): JsValue = {

    trait EncodeJson[Name, Enc, Id] {
      def toJson(n: Name, enc: Enc, id: Id, l: List[(String, JsValue)]): List[(String, JsValue)]
    }

    val appender: SimpleProduct3.AppendMonad[EncodeJson] = new SimpleProduct3.AppendMonad[EncodeJson] {
      override def zip[A1, B1, C1, A2, B2, C2, A3, B3, C3](
        c: SimpleProduct3.ConvertF3[A1, B1, C1, A2, B2, C2, A3, B3, C3],
        ma: EncodeJson[A1, A2, A3],
        mb: EncodeJson[B1, B2, B3]
      ): EncodeJson[C1, C2, C3] = new EncodeJson[C1, C2, C3] {
        override def toJson(n: C1, enc: C2, id: C3, l: List[(String, JsValue)]): List[(String, JsValue)] = {
          val list1 = mb.toJson(c.takeTail1(n), c.takeTail2(enc), c.takeTail3(id), l)
          ma.toJson(c.takeHead1(n), c.takeHead2(enc), c.takeHead3(id), list1)
        }
      }

      override def zero[N1, N2, N3](n1: N1, n2: N2, n3: N3): EncodeJson[N1, N2, N3] = new EncodeJson[N1, N2, N3] {
        override def toJson(n: N1, enc: N2, id: N3, l: List[(String, JsValue)]): List[(String, JsValue)] = l
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
      simpleProduct3.toHList1[EncodeJson, Named, Writes, cats.Id](appender)(typeGen)

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
