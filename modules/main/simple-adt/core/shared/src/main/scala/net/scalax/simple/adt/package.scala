package net.scalax.simple

package object adt {

  import impl._

  object TypeAdt extends TypeAdtAlias {
    @inline final def instance[F[_] <: TypeAdtApply.Aux[_, _, ConfirmSucceed]]: FetchAdtApply[F] = FetchAdtApply.get
  }

}
