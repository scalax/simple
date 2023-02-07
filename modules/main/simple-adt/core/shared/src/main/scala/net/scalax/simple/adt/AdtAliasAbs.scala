package net.scalax.simple.adt
package impl

object Adt extends TypeAdtAlias[AdtStatus.Passed] with TypeAdtRuntimeApply with TempAlias {
  val Passed: TypeAdtAlias[AdtStatus.Passed] with TempAlias with TypeAdtRuntimeApply = this
  val Failed: TypeAdtAlias[AdtStatus.Failed] with TempAlias = this.asInstanceOf[TypeAdtAlias[AdtStatus.Failed] with TempAlias]
}

trait TempAlias {
  type WithContext[T, Poly] = AdtAdapter[T, Poly]
}

trait AdtAliasAbs {
  type AdtZero
  type AdtNat
  type AdtAppend[A, Tail <: AdtNat] <: AdtNat
}
