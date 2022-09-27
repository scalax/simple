package net.scalax.simple.nat.adt.impl

import net.scalax.simple.nat.adt.{ConfirmSucceed, HelperIO, TypeAdt}

final class TakeTuple[T <: TypeAdt[_, _, ConfirmSucceed]] {
  type Target
}
object TakeTuple {
  type Aux[T <: TypeAdt[_, _, ConfirmSucceed], U] = TakeTuple[T] { type Target = U }
  @inline implicit def takeTupleImplicit[A, U]: Aux[TypeAdt[A, U, ConfirmSucceed], U] = null
}

final class FetchAdtApply[F[_] <: TypeAdt[_, _, ConfirmSucceed]] {
  @inline def input[T, V, Out](data: T)(implicit mapping: F[T], t: TakeTuple.Aux[F[T], V], helperIO: HelperIO.Aux[V, Out]): Out =
    helperIO.helper(mapping.index, data)
}
object FetchAdtApply {
  @inline private val value: FetchAdtApply[TypeAdt[*, Any, ConfirmSucceed]] = new FetchAdtApply[TypeAdt[*, Any, ConfirmSucceed]]
  @inline def get[F[_] <: TypeAdt[_, _, ConfirmSucceed]]: FetchAdtApply[F]  = value.asInstanceOf[FetchAdtApply[F]]
}
