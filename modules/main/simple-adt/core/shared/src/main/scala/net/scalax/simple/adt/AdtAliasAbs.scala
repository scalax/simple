package net.scalax.simple.adt
package impl

object Adt extends TypeAdtAlias[AdtStatus.Passed] with TypeAdtRuntimeApply {
  val Passed: TypeAdtAlias[AdtStatus.Passed] with TypeAdtRuntimeApply = this
  val Failed: TypeAdtAlias[AdtStatus.Failed]                          = this.asInstanceOf[TypeAdtAlias[AdtStatus.Failed]]
}

trait AdtAliasAbs {
  type AdtZero
  type AdtNat
  type AdtAppend[A, Tail <: AdtNat] <: AdtNat
}
