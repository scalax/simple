package net.scalax.simple.adt
package nat
package support

object CodegenHelper {

  class AppCtx[Col, App[_, _ <: Col] <: Col] {
    type AppendCoProduct[
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
      Tail1 <: Col
    ] = App[T1, Tail1]
  }

  type AppendAny[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, Tail1 <: Any] = Any

}
