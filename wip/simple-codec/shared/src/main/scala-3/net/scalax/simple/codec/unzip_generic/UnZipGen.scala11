package net.scalax.simple.codec.unzip_generic

import net.scalax.simple.codec.{SimpleFrom, SimpleTo}

trait UnZipGen[F[_[_]]] {
  def unzip[T1[_], T2[_]](from: F[ZipCommonGen.ZipType[T1, T2]#Zip]): (F[T1], F[T2])
}
trait ZipGen[F[_[_]]] {
  def zip[T1[_], T2[_]](f1: F[T1], f2: F[T2]): F[ZipCommonGen.ZipType[T1, T2]#Zip]
}

trait ZipCommonGen[F[_[_]]] extends UnZipGen[F] with ZipGen[F] {
  override def unzip[T1[_], T2[_]](from: F[ZipCommonGen.ZipType[T1, T2]#Zip]): (F[T1], F[T2])
  override def zip[T1[_], T2[_]](f1: F[T1], f2: F[T2]): F[ZipCommonGen.ZipType[T1, T2]#Zip]
}

object ZipCommonGen {
  class ZipType[T1[_], T2[_]] {
    type Zip[T] = (T1[T], T2[T])
  }

  trait Impl[F[_[_]]] extends ZipCommonGen[F] {
    type FuncImpl[T1[_], T2[_]] = ZipType[T1, T2]
    def impl[T1[_], T2[_]]
      : DerivedApply[F, T1, T2] => Func1TupleTrans[F[ZipCommonGen.ZipType[T1, T2]#Zip], F[T1], F[T2]] with Func1TupleExtra[F[
        ZipCommonGen.ZipType[T1, T2]#Zip
      ], F[T1], F[T2]]

    override def unzip[T1[_], T2[_]](from: F[ZipCommonGen.ZipType[T1, T2]#Zip]): (F[T1], F[T2]) =
      impl[T1, T2](ZipCommonGen[F, T1, T2]).toTuple(from)
    override def zip[T1[_], T2[_]](f1: F[T1], f2: F[T2]): F[ZipCommonGen.ZipType[T1, T2]#Zip] =
      impl[T1, T2](ZipCommonGen[F, T1, T2]).fromTuple(f1, f2)
  }

  type MatchT1[u <: Tuple] <: Tuple = u match {
    case (h1 *: h3 *: EmptyTuple) *: t => h1 *: MatchT1[t]
    case EmptyTuple                    => EmptyTuple
  }
  type MatchT2[u <: Tuple] <: Tuple = u match {
    case (h1 *: h3 *: EmptyTuple) *: t => h3 *: MatchT2[t]
    case EmptyTuple                    => EmptyTuple
  }

  trait Func1TupleTrans[Input, +F1, +F3] {
    def toTuple(i: Input): (F1, F3)
  }

  object Func1TupleTrans {
    val instanceAny: Func1TupleTrans[Tuple, Tuple, Tuple] = new Func1TupleTrans[Tuple, Tuple, Tuple] {
      self =>
      override def toTuple(i: Tuple): (Tuple, Tuple) = i match {
        case (h1Data *: h2Data) *: tailFunc =>
          val temp = self.toTuple(tailFunc)
          (h1Data *: temp._1, h2Data *: temp._2)
        case EmptyTuple => (EmptyTuple, EmptyTuple)
      }
    }

    def instance[Input, F1, F3]: Func1TupleTrans[Input, F1, F3] = instanceAny.asInstanceOf
  }

  trait Func1TupleExtra[Input, -F1, -F3] {
    def fromTuple(i: (F1, F3)): Input
  }

  object Func1TupleExtra {
    val instanceAny: Func1TupleExtra[Tuple, Tuple, Tuple] = new Func1TupleExtra[Tuple, Tuple, Tuple] {
      self =>
      def fromTuple(i: (Tuple, Tuple)): Tuple = i match {
        case (h1 *: tail1) *: (h2 *: tail2) *: EmptyTuple =>
          (h1 -> h2) *: self.fromTuple(tail1 -> tail2)
        case EmptyTuple *: EmptyTuple *: EmptyTuple => EmptyTuple
      }
    }

    def instance[Input, F1, F3]: Func1TupleExtra[Input, F1, F3] = instanceAny.asInstanceOf
  }

  trait Func1TupleTransGeneric[Input <: Tuple] {
    def generic: Func1TupleTrans[Input, MatchT1[Input], MatchT2[Input]] with Func1TupleExtra[Input, MatchT1[Input], MatchT2[Input]] =
      new Func1TupleTrans[Input, MatchT1[Input], MatchT2[Input]] with Func1TupleExtra[Input, MatchT1[Input], MatchT2[Input]] {
        override def toTuple(i: Input): (MatchT1[Input], MatchT2[Input]) =
          Func1TupleTrans.instance[Input, MatchT1[Input], MatchT2[Input]].toTuple(i)
        override def fromTuple(i: (MatchT1[Input], MatchT2[Input])): Input =
          Func1TupleExtra.instance[Input, MatchT1[Input], MatchT2[Input]].fromTuple(i)
      }
  }
  object Func1TupleTransGeneric {
    def apply[I <: Tuple]: Func1TupleTransGeneric[I] = new Func1TupleTransGeneric[I] {
      //
    }
  }

  class DerivedApply[F[_[_]], In1[_], In2[_]] {
    def derived2[H1 <: Tuple](
      generic1: SimpleTo[F[ZipCommonGen.ZipType[In1, In2]#Zip], H1] with SimpleFrom[F[ZipCommonGen.ZipType[In1, In2]#Zip], H1]
    ): InnerApply1[F, In1, In2, H1] =
      new InnerApply1[F, In1, In2, H1](generic1, generic1)
  }
  class InnerApply1[F[_[_]], In1[_], In2[_], H1 <: Tuple](
    genericTo: SimpleTo[F[ZipCommonGen.ZipType[In1, In2]#Zip], H1],
    genericFrom: SimpleFrom[F[ZipCommonGen.ZipType[In1, In2]#Zip], H1]
  ) {
    def apply(
      func1: Func1TupleTransGeneric[H1] => (Func1TupleTrans[H1, MatchT1[H1], MatchT2[H1]] with Func1TupleExtra[
        H1,
        MatchT1[H1],
        MatchT2[H1]
      ])
    ): InnerApply2[F, In1, In2, H1, MatchT1[H1], MatchT2[H1]] = {
      val temp = func1(Func1TupleTransGeneric[H1])
      new InnerApply2[F, In1, In2, H1, MatchT1[H1], MatchT2[H1]](
        genericTo = genericTo,
        genericFrom = genericFrom,
        tupleTo = temp,
        tupleFrom = temp
      )
    }
  }
  class InnerApply2[F[_[_]], In1[_], In2[_], H1, H2, H3](
    genericTo: SimpleTo[F[ZipCommonGen.ZipType[In1, In2]#Zip], H1],
    genericFrom: SimpleFrom[F[ZipCommonGen.ZipType[In1, In2]#Zip], H1],
    tupleTo: Func1TupleTrans[H1, H2, H3],
    tupleFrom: Func1TupleExtra[H1, H2, H3]
  ) {
    def apply(
      g1: SimpleTo[F[In1], H2] with SimpleFrom[F[In1], H2],
      g2: SimpleTo[F[In2], H3] with SimpleFrom[F[In2], H3]
    ): Func1TupleTrans[F[ZipCommonGen.ZipType[In1, In2]#Zip], F[In1], F[In2]]
      with Func1TupleExtra[F[ZipCommonGen.ZipType[In1, In2]#Zip], F[In1], F[In2]] =
      new Func1TupleTrans[F[ZipCommonGen.ZipType[In1, In2]#Zip], F[In1], F[In2]]
        with Func1TupleExtra[F[ZipCommonGen.ZipType[In1, In2]#Zip], F[In1], F[In2]] {
        override def toTuple(i: F[ZipCommonGen.ZipType[In1, In2]#Zip]): (F[In1], F[In2]) = {
          val (h2, h3) = tupleTo.toTuple(genericTo.to(i))
          (g1.from(h2), g2.from(h3))
        }
        override def fromTuple(i: (F[In1], F[In2])): F[ZipCommonGen.ZipType[In1, In2]#Zip] = {
          val temp2 = g1.to(i._1)
          val temp3 = g2.to(i._2)
          genericFrom.from(tupleFrom.fromTuple(temp2 -> temp3))
        }
      }
  }

  def apply[F[_[_]], In1[_], In2[_]]: DerivedApply[F, In1, In2] = new DerivedApply[F, In1, In2]

}
