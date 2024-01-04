package net.scalax.simple.codec.unzip_generic

import net.scalax.simple.codec.{SimpleFrom, SimpleTo}
import shapeless._

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

  trait Func1TupleTrans[Input, +F1, +F3] {
    def toTuple(i: Input): (F1, F3)
  }

  object Func1TupleTrans {
    implicit def implicit1[F1, F3, HFTailInput <: HList, HFTail1 <: HList, HFTail2 <: HList](implicit
      cv: Func1TupleTrans[HFTailInput, HFTail1, HFTail2]
    ): Func1TupleTrans[(F1, F3) :: HFTailInput, F1 :: HFTail1, F3 :: HFTail2] =
      new Func1TupleTrans[(F1, F3) :: HFTailInput, F1 :: HFTail1, F3 :: HFTail2] {
        override def toTuple(i: (F1, F3) :: HFTailInput): (F1 :: HFTail1, F3 :: HFTail2) = {
          val (tail1, tail2) = cv.toTuple(i.tail)
          (i.head._1 :: tail1, i.head._2 :: tail2)
        }
      }

    implicit val implicit2: Func1TupleTrans[HNil, HNil, HNil] = new Func1TupleTrans[HNil, HNil, HNil] {
      private val tempHNil: (HNil, HNil) = (HNil, HNil)

      override def toTuple(i: HNil): (HNil, HNil) = tempHNil
    }
  }

  trait Func1TupleExtra[Input, -F1, -F3] {
    def fromTuple(i: (F1, F3)): Input
  }

  object Func1TupleExtra {
    implicit def implicit1[F1, F3, HFTailInput <: HList, HFTail1 <: HList, HFTail2 <: HList](implicit
      cv: Func1TupleExtra[HFTailInput, HFTail1, HFTail2]
    ): Func1TupleExtra[(F1, F3) :: HFTailInput, F1 :: HFTail1, F3 :: HFTail2] =
      new Func1TupleExtra[(F1, F3) :: HFTailInput, F1 :: HFTail1, F3 :: HFTail2] {
        override def fromTuple(i: (F1 :: HFTail1, F3 :: HFTail2)): (F1, F3) :: HFTailInput =
          (i._1.head, i._2.head) :: cv.fromTuple(i._1.tail, i._2.tail)
      }

    implicit val implicit2: Func1TupleExtra[HNil, HNil, HNil] = new Func1TupleExtra[HNil, HNil, HNil] {
      override def fromTuple(i: (HNil, HNil)): HNil = i._1
    }
  }

  trait Func1TupleTransGeneric[Input] {
    def generic[I1, I2](implicit
      i1: Func1TupleTrans[Input, I1, I2],
      i2: Func1TupleExtra[Input, I1, I2]
    ): Func1TupleTrans[Input, I1, I2] with Func1TupleExtra[Input, I1, I2] = new Func1TupleTrans[Input, I1, I2]
      with Func1TupleExtra[Input, I1, I2] {
      override def toTuple(i: Input): (I1, I2)   = i1.toTuple(i)
      override def fromTuple(i: (I1, I2)): Input = i2.fromTuple(i)
    }
  }
  object Func1TupleTransGeneric {
    def apply[I]: Func1TupleTransGeneric[I] = new Func1TupleTransGeneric[I] {
      //
    }
  }

  class DerivedApply[F[_[_]], In1[_], In2[_]] {
    def derived2[H1](
      generic1: SimpleTo[F[ZipCommonGen.ZipType[In1, In2]#Zip], H1] with SimpleFrom[F[ZipCommonGen.ZipType[In1, In2]#Zip], H1]
    ): InnerApply1[F, In1, In2, H1] =
      new InnerApply1[F, In1, In2, H1](generic1, generic1)
  }
  class InnerApply1[F[_[_]], In1[_], In2[_], H1](
    genericTo: SimpleTo[F[ZipCommonGen.ZipType[In1, In2]#Zip], H1],
    genericFrom: SimpleFrom[F[ZipCommonGen.ZipType[In1, In2]#Zip], H1]
  ) {
    def apply[H2, H3](
      func1: Func1TupleTransGeneric[H1] => (Func1TupleTrans[H1, H2, H3] with Func1TupleExtra[H1, H2, H3])
    ): InnerApply2[F, In1, In2, H1, H2, H3] = {
      val temp = func1(Func1TupleTransGeneric[H1])
      new InnerApply2[F, In1, In2, H1, H2, H3](genericTo = genericTo, genericFrom = genericFrom, tupleTo = temp, tupleFrom = temp)
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
