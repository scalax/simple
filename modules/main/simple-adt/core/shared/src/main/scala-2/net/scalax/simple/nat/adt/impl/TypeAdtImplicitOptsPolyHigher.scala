package net.scalax.simple.nat.adt.impl

import net.scalax.simple.nat.adt.TypeAdt

trait TypeAdtImplicitOptsPolyHigher {
  @inline def get[F[_] <: TypeAdt[_, _]]: FetchAdtApply[F] = FetchAdtApply.get
}
