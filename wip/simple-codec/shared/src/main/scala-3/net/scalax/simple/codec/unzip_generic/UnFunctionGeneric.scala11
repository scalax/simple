package net.scalax.simple.codec

trait UnFunctionGeneric[F[_[_]]] {
  def unfunction[T1, T2](func: T1 => T2): F[UnFunctionGeneric.Context[T1]#F] => F[UnFunctionGeneric.Context[T2]#F]
}

object UnFunctionGeneric {
  class Context[T] {
    type F[_] = T
  }

  trait HListFuncMap[In, Out, HListIn] {
    type HListOut
    def input(io: In => Out): HListIn => HListOut
  }
  object HListFuncMap {
    type Aux[In, Out, HListIn, HO] = HListFuncMap[In, Out, HListIn] {
      type HListOut = HO
    }
    type ToOut[HIn, InType, OutType] <: Tuple = HIn match {
      case InType *: tail1 => OutType *: ToOut[tail1, InType, OutType]
      case EmptyTuple      => EmptyTuple
    }
    private val instanceAny: HListFuncMap.Aux[Any, Any, Tuple, Tuple] = new HListFuncMap[Any, Any, Tuple] {
      self =>
      override type HListOut = Tuple

      override def input(io: Any => Any): Tuple => Tuple = _.match {
        case h1 *: tail1 => io(h1) *: self.input(io)(tail1)
        case EmptyTuple  => EmptyTuple
      }
    }
    def instance[In, Out, InH]: HListFuncMap.Aux[In, Out, InH, ToOut[InH, In, Out]] = instanceAny.asInstanceOf
  }

  trait HListFuncMapGeneric[In, Out, HListIn] {
    def generic: HListFuncMap.Aux[In, Out, HListIn, HListFuncMap.ToOut[HListIn, In, Out]] = HListFuncMap.instance
  }
  object HListFuncMapGeneric {
    def apply[In, Out, HListIn]: HListFuncMapGeneric[In, Out, HListIn] =
      new HListFuncMapGeneric[In, Out, HListIn] {
        //
      }
  }

  trait SimpleFuncion2Impl[In, Out, F[_[_]]] {
    self =>
    def func: In => Out
    def derived2[Target1](
      simpleTo: SimpleTo[F[UnFunctionGeneric.Context[In]#F], Target1],
      simpleFrom: SimpleFrom[F[UnFunctionGeneric.Context[Out]#F], HListFuncMap.ToOut[Target1, In, Out]]
    ): FuncInnerApply1[F, In, Out, Target1] =
      new FuncInnerApply1[F, In, Out, Target1](f1 = func, simpleTo = simpleTo, simpleFrom = simpleFrom)
  }

  class FuncInnerApply1[F[_[_]], In, Out, Target1](
    f1: In => Out,
    simpleTo: SimpleTo[F[UnFunctionGeneric.Context[In]#F], Target1],
    simpleFrom: SimpleFrom[F[UnFunctionGeneric.Context[Out]#F], HListFuncMap.ToOut[Target1, In, Out]]
  ) {
    def apply(
      genericFunc: HListFuncMapGeneric[In, Out, Target1] => HListFuncMap.Aux[
        In,
        Out,
        Target1,
        HListFuncMap.ToOut[Target1, In, Out]
      ]
    ): F[UnFunctionGeneric.Context[In]#F] => F[UnFunctionGeneric.Context[Out]#F] = { f =>
      val temp = genericFunc(HListFuncMapGeneric[In, Out, Target1])
      simpleFrom.from(temp.input(f1)(simpleTo.to(f)))
    }
  }

  class FuncInnerApply2[F[_[_]], In, Out, Target2](
    f1: F[UnFunctionGeneric.Context[In]#F] => Target2
  ) {
    def apply(
      simpleFrom: SimpleFrom[F[UnFunctionGeneric.Context[Out]#F], Target2]
    ): F[UnFunctionGeneric.Context[In]#F] => F[UnFunctionGeneric.Context[Out]#F] = f => simpleFrom.from(f1(f))
  }

  trait Impl[F[_[_]]] extends UnFunctionGeneric[F] {
    def impl[T1, T2]: SimpleFuncion2Impl[T1, T2, F] => (F[UnFunctionGeneric.Context[T1]#F] => F[UnFunctionGeneric.Context[T2]#F])
    override def unfunction[T1, T2](from: T1 => T2): F[UnFunctionGeneric.Context[T1]#F] => F[UnFunctionGeneric.Context[T2]#F] =
      impl[T1, T2](new SimpleFuncion2Impl[T1, T2, F] {
        override val func: T1 => T2 = from
      })
  }

}
