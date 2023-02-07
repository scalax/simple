package net.scalax.simple.adt
package impl

object Adt extends TypeAdtAlias[AdtStatus.Passed] with TypeAdtRuntimeApply {
  val Passed: TypeAdtAlias[AdtStatus.Passed] with TypeAdtRuntimeApply = this
  val Failed: TypeAdtAlias[AdtStatus.Failed]                          = this.asInstanceOf[TypeAdtAlias[AdtStatus.Failed]]

  class Adapter[Target, Poly](val value: Target)

  trait Context[In, Out, Poly] extends Any {
    def input(t: In): Out
  }
}

trait AdtAliasAbs {
  type AdtZero
  type AdtNat
  type AdtAppend[A, Tail <: AdtNat] <: AdtNat
}
