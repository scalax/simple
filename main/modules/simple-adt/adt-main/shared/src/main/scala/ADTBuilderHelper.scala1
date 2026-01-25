package net.scalax.simple.adt
package instance

import support.SimpleAppenderAlias

object ADTBuilderHelperImplicit {

  trait ApFunc[T, Tail1 <: AdtHList, Tail2 <: AdtCoProduct]
      extends SimpleAppenderAlias.AppenderAlias[
        ({ type XM[U1 <: AdtHList, U2 <: AdtCoProduct] = (U1, U2) => T })#XM,
        AdtHList,
        AdtCoProduct,
        ({ type OutPut[I1, X <: AdtHList] = AdtHList.UsePositive[I1 => T, X] })#OutPut,
        AdtCoProduct.UsePositive,
        Tail1,
        Tail2
      ] { ApFuncSelf =>
    override def next[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22]
      : ApFunc[T, AdtHList.UsePositive[T1 => T, Tail1], AdtCoProduct.UsePositive[T1, Tail2]] =
      new ApFunc[T, AdtHList.UsePositive[T1 => T, Tail1], AdtCoProduct.UsePositive[T1, Tail2]] {
        override def current: (AdtHList.UsePositive[T1 => T, Tail1], AdtCoProduct.UsePositive[T1, Tail2]) => T =
          (t1Func: AdtHList.UsePositive[T1 => T, Tail1], t2: AdtCoProduct.UsePositive[T1, Tail2]) => {
            t2._foldCoProduct[T]((t1: T1) => t1Func.head(t1), (tail2: Tail2) => ApFuncSelf.current(t1Func.tail, tail2))
          }
      }
  }

  trait NeedCoProduct[N <: AdtCoProduct, Target] {
    type HelperTarget <: AdtHList
    def apFunc: ApFunc[Target, HelperTarget, N]
    def helperTargetValue: HelperTarget
    def model(n: N): Target = apFunc.current(helperTargetValue, n)
  }

  object NeedCoProduct {
    implicit def implicit1[X1 <: Target, Target, OutHList <: AdtCoProduct](implicit
      tail: NeedCoProduct[OutHList, Target]
    ): NeedCoProduct[AdtCoProduct.UsePositive[X1, OutHList], Target] =
      new NeedCoProduct[AdtCoProduct.UsePositive[X1, OutHList], Target] {
        override type HelperTarget = AdtHList.UsePositive[X1 => Target, tail.HelperTarget]
        override def apFunc: ApFunc[Target, AdtHList.UsePositive[X1 => Target, tail.HelperTarget], AdtCoProduct.UsePositive[X1, OutHList]] =
          tail.apFunc.next[X1, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]
        override def helperTargetValue: AdtHList.UsePositive[X1 => Target, tail.HelperTarget] =
          AdtHList.UsePositive.append(identity: X1 => Target, tail.helperTargetValue)
      }

    implicit def implicit2[X1 <: Target, Target]: NeedCoProduct[AdtCoProduct.UseOne[X1], Target] =
      new NeedCoProduct[AdtCoProduct.UseOne[X1], Target] {
        override type HelperTarget = AdtHList.UsePositive[X1 => Target, AdtHList]
        override def apFunc: ApFunc[Target, AdtHList.UsePositive[X1 => Target, AdtHList], AdtCoProduct.UseOne[X1]] =
          new ApFunc[Target, AdtHList.UsePositive[X1 => Target, AdtHList], AdtCoProduct.UseOne[X1]] {
            override def current: (AdtHList.UsePositive[X1 => Target, AdtHList], AdtCoProduct.UseOne[X1]) => Target =
              (h: AdtHList.UsePositive[X1 => Target, AdtHList], co: AdtCoProduct.UseOne[X1]) => {
                h.head(co.value)
              }
          }
        override def helperTargetValue: AdtHList.UsePositive[X1 => Target, AdtHList] =
          AdtHList.UsePositive.append(identity: X1 => Target, AdtHList.zero)
      }
  }

  trait Apply[Target] {
    def input[X1 <: Target, In <: AdtCoProduct](u: AdtCoProduct.UsePositive[X1, In])(implicit
      au: NeedCoProduct[AdtCoProduct.UsePositive[X1, In], Target]
    ): Target = au.model(u)
  }

  private val applyAny1: Apply[Any] = new Apply[Any] {
    //
  }

  private def applyAny2[T]: Apply[T] = applyAny1.asInstanceOf[Apply[T]]

  def apply[T]: Apply[T]                                                                                       = applyAny2[T]
  @inline def toValue[H, T <: AdtCoProduct](m: AdtCoProduct.UsePositive[H, T]): AdtCoProduct.UsePositive[H, T] = m

}
