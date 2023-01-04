package net.scalax.simple.adt
package impl

import net.scalax.simple.adt.{ConfirmSucceed, HelperIO, TypeAdt}

final class TakeTuple[T <: TypeAdt.Aux[_, _, ConfirmSucceed]] {
  type Target
}
object TakeTuple {
  type Aux[T <: TypeAdt.Aux[_, _, ConfirmSucceed], U] = TakeTuple[T] { type Target = U }
  @inline implicit def takeTupleImplicit[A, U]: Aux[TypeAdt.Aux[A, U, ConfirmSucceed], U] = null
}

final class FetchAdtApply[F[_] <: TypeAdt.Aux[_, _, ConfirmSucceed]] {
  @inline def input[T, V, Out](data: T)(implicit mapping: F[T], t: TakeTuple.Aux[F[T], V], helperIO: HelperIO.Aux[V, Out]): Out = {
    val adtGetter = new TypeAdtGetter
    helperIO.helper(adtGetter, mapping.asInstanceOf[TypeAdt[Any, Any]], data)
  }
}
object FetchAdtApply {
  @inline private val value: FetchAdtApply[TypeAdt.Aux[*, Any, ConfirmSucceed]] = new FetchAdtApply[TypeAdt.Aux[*, Any, ConfirmSucceed]]
  @inline def get[F[_] <: TypeAdt.Aux[_, _, ConfirmSucceed]]: FetchAdtApply[F]  = value.asInstanceOf[FetchAdtApply[F]]
}
