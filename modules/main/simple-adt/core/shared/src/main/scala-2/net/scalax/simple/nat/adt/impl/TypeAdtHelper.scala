package net.scalax.simple.nat.adt.impl

import net.scalax.simple.nat.adt.{HelperIO, TypeAdt}

final class TakeTuple[T <: TypeAdt[_, _]] {
  type Target
}
object TakeTuple {
  type Aux[T <: TypeAdt[_, _], U] = TakeTuple[T] { type Target = U }
  @inline implicit def takeTupleImplicit[A, U]: Aux[TypeAdt[A, U], U] = null
}

final class FetchAdtApply[F[_] <: TypeAdt[_, _]] {
  @inline def input[T, V, Out](data: T)(implicit mapping: F[T], t: TakeTuple.Aux[F[T], V], helperIO: HelperIO.Aux[V, Out]): Out =
    helperIO.helper(mapping.index, data)
}
object FetchAdtApply {
  @inline private val value: FetchAdtApply[TypeAdt[*, Any]] = new FetchAdtApply[TypeAdt[*, Any]]
  @inline def get[F[_] <: TypeAdt[_, _]]: FetchAdtApply[F]  = value.asInstanceOf[FetchAdtApply[F]]
}
