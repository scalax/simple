package net.scalax.simple.adt

import impl.AliasInstance.{target => Instance, AliasInstance => Alias, StatusBuilder => Status}

object AdtAliasBuilder {
  val ExceptSucceed: Status[ConfirmSucceed] = Status[ConfirmSucceed]
  val ExceptFailed: Status[ConfirmFailed]   = Status[ConfirmFailed]
  def Status[S <: AdtStatus]: Status[S]     = null

  def value[S <: AdtStatus, Poly]: Alias[S, Poly] = Instance
}

package impl {

  object AliasInstance extends TypeAdtAlias[AdtStatus, Any] with TypeAdtRuntimeApply[Any] {
    type StatusBuilder[S <: AdtStatus] = { type Context[P] = Alias[S, P] }
    def target[T]: T = AliasInstance.asInstanceOf[T]
    type AliasInstance[S <: AdtStatus, P] = TypeAdtAlias[S, P] with TypeAdtRuntimeApply[P]
  }

  trait AdtAliasAbs {
    type AdtZero
    type AdtNat
    type AdtAppend[A, Tail <: AdtNat] <: AdtNat
  }

}
