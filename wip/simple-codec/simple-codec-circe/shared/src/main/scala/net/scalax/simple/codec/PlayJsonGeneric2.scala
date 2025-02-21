package net.scalax.simple
package codec

import play.api.libs.json._
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._
import net.scalax.simple.codec.to_list_generic.{BasedInstalled, FoldFGenerc, SimpleProduct1, SimpleProduct4}

object PlayJsonGeneric2 {
  type Named[_] = String

  def writesModelImpl[F[_[_]]](model: F[cats.Id], g1: BasedInstalled[F], g: F[Writes]): JsValue = {
    val sp1: SimpleProduct1.Appender[F] = g1.simpleProduct1
    val sp4: SimpleProduct4.Appender[F] = SimpleProduct4[F].derived(g1.basedInstalled)
    val zip3Generic: Zip3Generic[F]     = Zip3Generic[F].derived(sp4)
    val foldFGenerc: FoldFGenerc[F]     = FoldFGenerc[F].derived(sp1)

    type NamedAndEnc[T] = (String, Writes[T], T)

    def folder: FoldFGenerc.FoldF[NamedAndEnc, List[(String, JsValue)]] = new FoldFGenerc.FoldF[NamedAndEnc, List[(String, JsValue)]] {
      override def fold[X1](in: (String, Writes[X1], X1), l: List[(String, JsValue)]): List[(String, JsValue)] = {
        val propertyName          = in._1
        val jsonInstance: JsValue = in._2.writes(in._3)
        (propertyName, jsonInstance) :: l
      }
    }

    def namedToList(m: F[NamedAndEnc]): List[(String, JsValue)] =
      foldFGenerc.foldLeft[NamedAndEnc, List[(String, JsValue)]](folder, m, zero = List.empty)

    def zipInstance1(m: F[cats.Id]): F[NamedAndEnc] = zip3Generic.zip[Named, Writes, cats.Id](g1.labelled.modelLabelled, g, m)

    JsObject(namedToList(zipInstance1(model)))
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
