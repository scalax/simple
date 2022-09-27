package net.scalax.simple.nat.adt
package impl

trait TypeAdtImplicitOptsPolyHigher {
  @inline def get[F[_] <: TypeAdt[_, _, ConfirmSucceed]]: FetchAdtApply[F] = FetchAdtApply.get
}
