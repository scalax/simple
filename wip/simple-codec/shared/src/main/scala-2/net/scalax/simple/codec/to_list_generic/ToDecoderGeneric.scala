package net.scalax.simple.codec
package to_list_generic

import shapeless._

trait ToDecoderGeneric[F[_[_]]] {
  def toHList[M1[_], M2[_, _], M3[_]](monad: MonadAdd[M2])(func: ToDecoderGeneric.FuncImpl[M1, M2, M3]): M2[F[M1], F[M3]]
}

object ToDecoderGeneric {
  type IdImpl[T] = T
  trait FuncImpl[M1[_], M2[_, _], M3[_]] {
    def apply[T]: M2[M1[T], M3[T]]
  }

  trait HListFuncMapGeneric[Source1, Target1, Target2, M1[_], M2[_, _], M3[_]] {
    def output(monad: MonadAdd[M2])(func: FuncImpl[M1, M2, M3])(o1: Target1): M2[Target2]
  }
  object HListFuncMapGeneric {
    implicit def implicit1[T1, Source1 <: HList, HL1 <: HList, HL2 <: HList, M1[_], M2[_], M3[_]](implicit
      tail: HListFuncMapGeneric[Source1, HL1, HL2, M1, M2, M3]
    ): HListFuncMapGeneric[T1 :: Source1, M1[T1] :: HL1, M3[T1] :: HL2, M1, M2, M3] =
      new HListFuncMapGeneric[T1 :: Source1, M1[T1] :: HL1, M3[T1] :: HL2, M1, M2, M3] {
        override def output(o: MonadAdd[M2])(func: FuncImpl[M1, M2, M3])(o1: M1[T1] :: HL1): M2[M3[T1] :: HL2] = {
          val m1 = o.zip(tail.output(o)(func)(o1.tail), func(o1.head))
          o.reverse_map(m1)(hl => hl.tail -> hl.head)
        }
      }
    implicit def implicit2[M1[_], M2[_], M3[_]]: HListFuncMapGeneric[HNil, HNil, HNil, M1, M2, M3] =
      new HListFuncMapGeneric[HNil, HNil, HNil, M1, M2, M3] {
        override def output(o: MonadAdd[M2])(func: FuncImpl[M1, M2, M3])(o1: HNil): M2[HNil] = o.reverse_map(o.unit)(_ => ())
      }
  }

  trait HListFuncMapGenericGen[Source1, M1[_], M2[_], M3[_]] {
    def generic[Target1, Target2](implicit
      i: HListFuncMapGeneric[Source1, Target1, Target2, M1, M2, M3]
    ): HListFuncMapGeneric[Source1, Target1, Target2, M1, M2, M3] = i
  }
  object HListFuncMapGenericGen {
    def apply[Source1, M1[_], M2[_], M3[_]]: HListFuncMapGenericGen[Source1, M1, M2, M3] = new HListFuncMapGenericGen[Source1, M1, M2, M3] {
      //
    }
  }

  // ===
  class SimpleFuncion1Impl[F[_[_]], M1[_], M2[_], M3[_]] {
    self =>
    def derived2[Source1, Target1, Target2](
      simpleTo1: SimpleTo[F[IdImpl], Source1],
      simpleFrom2: SimpleTo[F[M3], Target2],
      simpleTo3: SimpleTo[F[M1], Target1]
    ): FuncInnerApply1[F, M1, M2, M3, Source1, Target1, Target2] =
      new FuncInnerApply1[F, M1, M2, M3, Source1, Target1, Target2](simpleTo1, simpleFrom2, simpleTo3)
  }

  class FuncInnerApply1[F[_[_]], M1[_], M2[_], M3[_], Source1, Target1, Target2](
    simpleTo1: SimpleTo[F[IdImpl], Source1],
    simpleFrom2: SimpleTo[F[M3], Target2],
    simpleTo3: SimpleTo[F[M1], Target1]
  ) {
    def apply(
      genericFunc: HListFuncMapGenericGen[Source1, M1, M2, M3] => HListFuncMapGeneric[Source1, Target1, Target2, M1, M2, M3]
    ): MonadAdd[M2] => FuncImpl[M1, M2, M3] => F[M1] => M2[F[M3]] = { monad => func => model =>
      monad.reverse_map(genericFunc(HListFuncMapGenericGen[Source1, M1, M2, M3]).output(monad)(func)(simpleTo3.to(model)))(simpleFrom2.to)
    }
  }

  trait Impl[F[_[_]]] extends ToDecoderGeneric[F] {
    def impl[M1[_], M2[_], M3[_]]: SimpleFuncion1Impl[F, M1, M2, M3] => (MonadAdd[M2] => FuncImpl[M1, M2, M3] => F[M1] => M2[F[M3]])
    override def toHList[M1[_], M2[_], M3[_]](monad: MonadAdd[M2])(func: FuncImpl[M1, M2, M3])(
      input: F[M1]
    ): M2[F[M3]] =
      impl[M1, M2, M3](new SimpleFuncion1Impl[F, M1, M2, M3])(monad)(func)(input)
  }
}
