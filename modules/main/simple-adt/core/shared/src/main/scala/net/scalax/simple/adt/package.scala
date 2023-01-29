package net.scalax.simple

package object adt {

  import impl._

  object TypeAdt {
    @inline final def apply[F[_] <: TypeAdtApply.Aux[_, _, ConfirmSucceed]]: FetchAdtApply[F] = FetchAdtApply.get
    @inline val alias: TypeAdtAlias                                                           = TypeAdtAlias
  }

}
