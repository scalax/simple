package net.scalax.simple.adt
package impl

object Adt extends TypeAdtAlias with TypeAdtRuntimeApply {

  class Adapter[Target, Poly](val value: Target)
  object Adapter {
    def apply[Target, Poly](t: Target): Adapter[Target, Poly] = new Adapter(t)
  }
  type TypeClass[F[_], T] = Adapter[(T, F[T]), TypeClassAdtContext.type]

  trait Context[In, Out, Poly] extends Any {
    def input(t: In): Out
  }

  object Context {
    def apply[In, Out, Poly](func: In => Out): Context[In, Out, Poly] = new Context[In, Out, Poly] {
      def input(t: In): Out = func(t)
    }
  }

  sealed trait Status

  object Status {
    class Passed extends Status
    class Failed extends Status
  }

}

trait AdtAliasAbs {
  type AdtZero
  type AdtNat
  type AdtAppend[A, Tail <: AdtNat] <: AdtNat
}
