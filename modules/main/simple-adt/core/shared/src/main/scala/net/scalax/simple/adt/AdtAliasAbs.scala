package net.scalax.simple.adt

import impl.AliasInstance.{target => Instance, FailedAlias, SucceedAlias}

object AdtAliasBuilder {
  val ExceptSucceed: { type Context[P] = SucceedAlias[P] } = null
  val ExceptFailed: { type Context[P] = FailedAlias[P] }   = null

  def value[T]: T = Instance
}

package impl {

  object AliasInstance extends TypeAdtAlias[AdtStatus, Any] with TypeAdtRuntimeApply[Any] {
    def target[T]: T = AliasInstance.asInstanceOf[T]

    type SucceedAlias[P] = TypeAdtAlias[ConfirmSucceed, P] with TypeAdtRuntimeApply[P]
    type FailedAlias[P]  = TypeAdtAlias[ConfirmFailed, P]
  }

  trait AdtAliasAbs {
    type AdtZero
    type AdtNat
    type AdtAppend[A, Tail <: AdtNat] <: AdtNat
  }

}
