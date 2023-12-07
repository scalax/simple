package net.scalax.simple.codec

import shapeless._

trait UnFunctionGeneric[F[_[_]]] {
  def unfunction[T1, T2](func: T1 => T2): F[UnFunctionGeneric.Context[T1]#F] => F[UnFunctionGeneric.Context[T2]#F]
}

object UnFunctionGeneric {
  class Context[T] {
    type F[_] = T
  }

  trait HListFuncMap[In, Out, -HListIn, +HListOut] {
    def input(io: In => Out): HListIn => HListOut
  }
  object HListFuncMap {
    implicit def implicit1[In, Out, HListIn <: HList, HListOut <: HList](implicit
      tailImpl: HListFuncMap[In, Out, HListIn, HListOut]
    ): HListFuncMap[In, Out, In :: HListIn, Out :: HListOut] =
      new HListFuncMap[In, Out, In :: HListIn, Out :: HListOut] {
        override def input(io: In => Out): (In :: HListIn) => (Out :: HListOut) = { in =>
          io(in.head) :: tailImpl.input(io)(in.tail)
        }
      }

    private val identityHNil: HNil => HNil = identity[HNil]
    implicit def implicit2[In, Out]: HListFuncMap[In, Out, HNil, HNil] =
      new HListFuncMap[In, Out, HNil, HNil] {
        override def input(io: In => Out): HNil => HNil = identityHNil
      }
  }

  trait HListFuncMapGeneric[In, Out, HListIn, HListOut] {
    def generic(implicit io: HListFuncMap[In, Out, HListIn, HListOut]): HListFuncMap[In, Out, HListIn, HListOut] = io
  }
  object HListFuncMapGeneric {
    def apply[In, Out, HListIn, HListOut]: HListFuncMapGeneric[In, Out, HListIn, HListOut] =
      new HListFuncMapGeneric[In, Out, HListIn, HListOut] {
        //
      }
  }

  trait SimpleFuncion2Impl[In, Out, F[_[_]]] {
    self =>
    def func: In => Out
    def derived2[Target1, Target2](
      simpleTo: SimpleTo[F[UnFunctionGeneric.Context[In]#F], Target1],
      simpleFrom: SimpleFrom[F[UnFunctionGeneric.Context[Out]#F], Target2]
    ): FuncInnerApply1[F, In, Out, Target1, Target2] =
      new FuncInnerApply1[F, In, Out, Target1, Target2](
        f1 = func,
        simpleTo = simpleTo,
        simpleFrom = simpleFrom
      )
  }

  class FuncInnerApply1[F[_[_]], In, Out, Target1, Target2](
    f1: In => Out,
    simpleTo: SimpleTo[F[UnFunctionGeneric.Context[In]#F], Target1],
    simpleFrom: SimpleFrom[F[UnFunctionGeneric.Context[Out]#F], Target2]
  ) {
    def apply(
      genericFunc: HListFuncMapGeneric[In, Out, Target1, Target2] => HListFuncMap[In, Out, Target1, Target2]
    ): F[UnFunctionGeneric.Context[In]#F] => F[UnFunctionGeneric.Context[Out]#F] = { f =>
      val temp = genericFunc(HListFuncMapGeneric[In, Out, Target1, Target2])
      simpleFrom.from(temp.input(f1)(simpleTo.to(f)))
    }
  }

  trait Impl[F[_[_]]] extends UnFunctionGeneric[F] {
    def impl[T1, T2]: SimpleFuncion2Impl[T1, T2, F] => (F[UnFunctionGeneric.Context[T1]#F] => F[UnFunctionGeneric.Context[T2]#F])
    override def unfunction[T1, T2](from: T1 => T2): F[UnFunctionGeneric.Context[T1]#F] => F[UnFunctionGeneric.Context[T2]#F] =
      impl[T1, T2](new SimpleFuncion2Impl[T1, T2, F] {
        override val func: T1 => T2 = from
      })
  }

}
