package net.scalax.simple
package adt
package impl

object Adt extends TypeAdtAlias with TypeAdtRuntimeApply with TypeAdtAliasModel with TypeAdtAliasModelUnapply {

  class Adapter[Target, Poly](val value: Target)
  object Adapter {
    def apply[Target, Poly](t: Target): Adapter[Target, Poly]               = new Adapter(t)
    def unapply[Target, Poly](adapter: Adapter[Target, Poly]): Some[Target] = Some(adapter.value)
  }
  type Implicitly[T] = Adapter[T, ImplicitlyAdtContext.type]

  trait Context[In, Out, Poly] extends Any {
    def input(t: In): Out
  }
  object Context {
    def apply[In, Out, Poly](func: In => Out): Context[In, Out, Poly] = new Context[In, Out, Poly] {
      def input(t: In): Out = func(t)
    }
  }

  type Status = temp.Status
  object Status {
    type Passed      = temp.Status.Passed
    type NotFinished = temp.Status.NotFinished
  }

}
