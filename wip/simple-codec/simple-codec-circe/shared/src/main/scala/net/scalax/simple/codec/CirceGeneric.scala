package net.scalax.simple
package codec

import io.circe.Decoder.Result
import io.circe._
import io.circe.syntax._
import net.scalax.simple.codec.to_list_generic.{BasedInstalled, FoldFGenerc, SimpleProduct1, SimpleProduct2, SimpleProduct3, SimpleProduct4}

object CirceGeneric {
  type Named[_] = String

  def encodeModelImpl[F[_[_]]](model: F[cats.Id], g1: BasedInstalled[F], g: F[Encoder]): Json = {
    val sp1: SimpleProduct1.Appender[F] = g1.simpleProduct1
    val sp4: SimpleProduct4.Appender[F] = SimpleProduct4[F].derived(g1.basedInstalled)
    val zip3Generic: Zip3Generic[F]     = Zip3Generic[F].derived(sp4)
    val foldFGenerc: FoldFGenerc[F]     = FoldFGenerc[F].derived(sp1)

    type NamedAndEnc[T] = (String, Encoder[T], T)

    def folder: FoldFGenerc.FoldF[NamedAndEnc, List[(String, Json)]] = new FoldFGenerc.FoldF[NamedAndEnc, List[(String, Json)]] {
      override def fold[X1](in: (String, Encoder[X1], X1), l: List[(String, Json)]): List[(String, Json)] = {
        val propertyName       = in._1
        val jsonInstance: Json = in._2(in._3)
        (propertyName, jsonInstance) :: l
      }
    }

    def namedToList(m: F[NamedAndEnc]): List[(String, Json)] =
      foldFGenerc.foldLeft[NamedAndEnc, List[(String, Json)]](folder, m, zero = List.empty)

    def zipInstance1(m: F[cats.Id]): F[NamedAndEnc] = zip3Generic.zip[Named, Encoder, cats.Id](g1.labelled.modelLabelled, g, m)

    Json.fromJsonObject(JsonObject.fromIterable(namedToList(zipInstance1(model))))
  }

  def decodeModelImpl[F[_[_]]](hCursor: HCursor, g1: BasedInstalled[F], g: F[Decoder]): Decoder.Result[F[cats.Id]] = {
    val sp2: SimpleProduct2.Appender[F] = SimpleProduct2[F].derived(g1.basedInstalled)
    val sp3: SimpleProduct3.Appender[F] = SimpleProduct3[F].derived(g1.basedInstalled)
    val zipGeneric: ZipGeneric[F]       = ZipGeneric[F].derived(sp3)
    val mapGenerc: MapGenerc[F]         = MapGenerc[F].derived(sp2)

    type NamedPair[T] = (String, Decoder[T])

    val zip1: F[NamedPair] = zipGeneric.zip[Named, Decoder](g1.labelled.modelLabelled, g)
    val mapFunc = new MapGenerc.MapFunction[NamedPair, Decoder.Result] {
      override def map[X1](nameDecoder: (String, Decoder[X1])): Decoder.Result[X1] = hCursor.downField(nameDecoder._1).as(nameDecoder._2)
    }
    val resultF1: F[Decoder.Result] = mapGenerc.map[NamedPair, Decoder.Result](mapFunc)(zip1)

    trait InputX[T1, T2] {
      def input(t: T1): Decoder.Result[T2]
    }

    val monadAdd: SimpleProduct2.AppendMonad[InputX] = new SimpleProduct2.AppendMonad[InputX] {
      override def zip[A, B, S, T](ma: InputX[A, B], ms: InputX[S, T]): InputX[(A, S), (B, T)] = new InputX[(A, S), (B, T)] {
        override def input(t: (A, S)): Decoder.Result[(B, T)] = for {
          b <- ma.input(t._1)
          t <- ms.input(t._2)
        } yield (b, t)
      }

      override def to[A, B, S, T](m1: InputX[A, B])(in1: A => S, in2: B => T)(in3: S => A, in4: T => B): InputX[S, T] = new InputX[S, T] {
        def input(t: S): Decoder.Result[T] = for (x1 <- m1.input(in3(t)).right) yield in2(x1)
      }

      override def zero: InputX[SimpleZero, SimpleZero] = s => Right(s)
    }

    val toDecoder: SimpleProduct2.TypeGen[InputX, Decoder.Result, cats.Id] = new SimpleProduct2.TypeGen[InputX, Decoder.Result, cats.Id] {
      override def apply[T]: InputX[Decoder.Result[T], T] = new InputX[Decoder.Result[T], T] {
        override def input(t: Result[T]): Result[T] = t
      }
    }

    val func = sp2.toHList[InputX, Decoder.Result, cats.Id](monadAdd)(toDecoder)

    func.input(resultF1)
  }

}
