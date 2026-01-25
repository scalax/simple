package net.scalax.simple.adt
package instance
package support

import net.scalax.simple.append.support.collectioncount22.typeparameter22.SimpleAppender

object SimpleAppenderAlias {

  type AppendAny[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, Tail1 <: Any] = Any

  trait AppenderAlias[M[_ <: Pro1, _ <: Pro2], Pro1, Pro2, AppendPro1[_, _ <: Pro1] <: Pro1, AppendPro2[
    _,
    _ <: Pro2
  ] <: Pro2, ProInstance1 <: Pro1, ProInstance2 <: Pro2]
      extends SimpleAppender[
        ({
          type KM1[
            T1 <: Pro1,
            T2 <: Pro2,
            T3 <: Any,
            T4 <: Any,
            T5 <: Any,
            T6 <: Any,
            T7 <: Any,
            T8 <: Any,
            T9 <: Any,
            T10 <: Any,
            T11 <: Any,
            T12 <: Any,
            T13 <: Any,
            T14 <: Any,
            T15 <: Any,
            T16 <: Any,
            T17 <: Any,
            T18 <: Any,
            T19 <: Any,
            T20 <: Any,
            T21 <: Any,
            T22 <: Any
          ] = M[T1, T2]
        })#KM1,
        Pro1,
        Pro2,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        ({
          type Ty1[
            T1,
            T2,
            T3,
            T4,
            T5,
            T6,
            T7,
            T8,
            T9,
            T10,
            T11,
            T12,
            T13,
            T14,
            T15,
            T16,
            T17,
            T18,
            T19,
            T20,
            T21,
            T22,
            Tail1 <: Pro1
          ] = AppendPro1[T1, Tail1]
        })#Ty1,
        ({
          type Ty2[
            T1,
            T2,
            T3,
            T4,
            T5,
            T6,
            T7,
            T8,
            T9,
            T10,
            T11,
            T12,
            T13,
            T14,
            T15,
            T16,
            T17,
            T18,
            T19,
            T20,
            T21,
            T22,
            Tail2 <: Pro2
          ] = AppendPro2[T1, Tail2]
        })#Ty2,
        AppendAny,
        AppendAny,
        AppendAny,
        AppendAny,
        AppendAny,
        AppendAny,
        AppendAny,
        AppendAny,
        AppendAny,
        AppendAny,
        AppendAny,
        AppendAny,
        AppendAny,
        AppendAny,
        AppendAny,
        AppendAny,
        AppendAny,
        AppendAny,
        AppendAny,
        AppendAny,
        ProInstance1,
        ProInstance2,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any
      ] {
    override def next[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22]
      : AppenderAlias[M, Pro1, Pro2, AppendPro1, AppendPro2, AppendPro1[T1, ProInstance1], AppendPro2[T1, ProInstance2]]
  }

}
