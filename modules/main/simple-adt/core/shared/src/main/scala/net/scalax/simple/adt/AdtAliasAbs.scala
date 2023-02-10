package net.scalax.simple.adt
package impl

object Adt extends TypeAdtAlias with TypeAdtRuntimeApply {
  val Passed: TypeAdtAlias with TypeAdtRuntimeApply = this
  val Failed: TypeAdtAlias                          = this.asInstanceOf[TypeAdtAlias]

  class Adapter[Target, Poly](val value: Target)

  trait Context[In, Out, Poly] extends Any {
    def input(t: In): Out
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
