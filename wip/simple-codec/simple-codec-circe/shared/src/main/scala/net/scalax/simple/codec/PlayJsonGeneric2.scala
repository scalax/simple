package net.scalax.simple
package codec

import play.api.libs.json._
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._
import net.scalax.simple.adt.nat.support.{ABCFunc, SimpleProduct3, SimpleProductContextX}
import net.scalax.simple.codec.utils.ByNameImplicit

object PlayJsonGeneric2 {
  type Named[_] = String

  trait EncodeJson[Name, Enc, Id] {
    def toJson(n: Name, enc: Enc, id: Id, l: List[(String, JsValue)]): List[(String, JsValue)]
  }

  def writesModelImpl[F[_[_]]](
    simpleProduct3: SimpleProduct3.ProductAdapter[F],
    named: F[Named],
    g: () => F[Writes]
  ): F[cats.Id] => JsValue = (model: F[cats.Id]) => {
    val appender: SimpleProduct3.SimpleAppender[EncodeJson] = new SimpleProduct3.SimpleAppender[EncodeJson] {
      override def append[A1, A2, A3, B1, B2, B3, C1, C2, C3](
        cxF1: ABCFunc[A1, B1, C1],
        cxF2: ABCFunc[A2, B2, C2],
        cxF3: ABCFunc[A3, B3, C3]
      )(
        ma: EncodeJson[A1, A2, A3],
        mb: EncodeJson[B1, B2, B3]
      ): EncodeJson[C1, C2, C3] = new EncodeJson[C1, C2, C3] {
        override def toJson(n: C1, enc: C2, id: C3, l: List[(String, JsValue)]): List[(String, JsValue)] = {
          val list1 = mb.toJson(cxF1.takeTail(n), cxF2.takeTail(enc), cxF3.takeTail(id), l)
          ma.toJson(cxF1.takeHead(n), cxF2.takeHead(enc), cxF3.takeHead(id), list1)
        }
      }

      override def zero[N1, N2, N3](n1: N1, n2: N2, n3: N3): EncodeJson[N1, N2, N3] = new EncodeJson[N1, N2, N3] {
        override def toJson(n: N1, enc: N2, id: N3, l: List[(String, JsValue)]): List[(String, JsValue)] = l
      }
    }

    val typeGen: SimpleProduct3.TypeGen[EncodeJson, Named, Writes, cats.Id] =
      new SimpleProduct3.TypeGen[EncodeJson, Named, Writes, cats.Id] {
        override def gen[T]: EncodeJson[String, Writes[T], T] = new EncodeJson[String, Writes[T], T] {
          override def toJson(n: String, enc: Writes[T], id: T, l: List[(String, JsValue)]): List[(String, JsValue)] =
            (n, enc.writes(id)) :: l
        }
      }

    val encodeFunc: EncodeJson[F[Named], F[Writes], F[cats.Id]] =
      simpleProduct3.append[EncodeJson, Named, Writes, cats.Id](typeGen, appender)

    val list: List[(String, JsValue)] = encodeFunc.toJson(named, g(), model, List.empty)
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
