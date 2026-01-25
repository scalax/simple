package net.scalax.simple.adt
package instance
package support

object AppendTail7 {

  trait Ctx1[Target] {
    trait ToTarget[ProInstance1 <: AdtHList, ProInstance2 <: AdtCoProduct.Use.Positive[_, _]]
        extends SimpleAppenderAlias.AppenderAlias[
          ({ type Func2[X1 <: AdtHList, X2 <: AdtCoProduct.Use.Positive[_, _]] = (X1, X2) => Target })#Func2,
          AdtHList,
          AdtCoProduct.Use.Positive[_, _],
          ({ type Append1[TItem, Tail <: AdtHList] = AdtHList.UsePositive[TItem => Target, Tail] })#Append1,
          AdtCoProduct.Use.Positive,
          ProInstance1,
          ProInstance2
        ] { AppendAdtSelf =>
      override def next[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22]
        : ToTarget[AdtHList.UsePositive[T1 => Target, ProInstance1], AdtCoProduct.Use.Positive[T1, ProInstance2]] =
        new ToTarget[AdtHList.UsePositive[T1 => Target, ProInstance1], AdtCoProduct.Use.Positive[T1, ProInstance2]] {
          override def current: (AdtHList.UsePositive[T1 => Target, ProInstance1], AdtCoProduct.Use.Positive[T1, ProInstance2]) => Target =
            (
              param: AdtHList.UsePositive[T1 => Target, ProInstance1],
              c: AdtCoProduct.Use.Positive[T1, ProInstance2]
            ) => {
              c._foldCoProduct[Target]((x1: T1) => param.head(x1), (pro2: ProInstance2) => AppendAdtSelf.current(param.tail, pro2))
            }

        }
    }

    object ToTarget {
      def take[A <: AdtHList, B <: AdtCoProduct.Use.Positive[_, _]](a: A)(implicit k: ToTarget[A, B]): B => Target = (b: B) =>
        k.current(a, b)

      implicit def positiveImplicit[Item, ProInstance1 <: AdtHList, ProInstance2 <: AdtCoProduct.Use.Positive[_, _]](implicit
        tail: ToTarget[ProInstance1, ProInstance2]
      ): ToTarget[AdtHList.UsePositive[Item => Target, ProInstance1], AdtCoProduct.Use.Positive[Item, ProInstance2]] =
        tail
          .next[Item, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]
          .asInstanceOf[ToTarget[AdtHList.UsePositive[Item => Target, ProInstance1], AdtCoProduct.Use.Positive[Item, ProInstance2]]]

      implicit def zeroImplicit[Item]: ToTarget[AdtHList.UsePositive[Item => Target, AdtHList], AdtCoProduct.Use.One[Item]] =
        new ToTarget[AdtHList.UsePositive[Item => Target, AdtHList], AdtCoProduct.Use.One[Item]] {
          override def current: (AdtHList.UsePositive[Item => Target, AdtHList], AdtCoProduct.Use.One[Item]) => Target =
            (a: AdtHList.Positive[Item => Target, AdtHList], b: AdtCoProduct.Use.One[Item]) => {
              a.head(AdtCoProduct.Use.One.unapplyImpl(b))
            }
        }

    }

  }

  val ctxAny: Ctx1[Any] = new Ctx1[Any] {
    //
  }
  def ctxBuild[T]: Ctx1[T] = ctxAny.asInstanceOf[Ctx1[T]]

  def apply[T]: Ctx1[T] = ctxBuild[T]

}
