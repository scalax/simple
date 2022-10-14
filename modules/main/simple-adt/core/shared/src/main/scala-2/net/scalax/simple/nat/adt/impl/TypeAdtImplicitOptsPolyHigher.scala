package net.scalax.simple.nat.adt
package impl

import shapeless._
import shapeless.ops.nat.ToInt
import shapeless.ops.hlist.ToSized

trait TypeAdtImplicitOptsPolyHigher extends HListTypeAdtPositive {
  @inline def get[F[_] <: TypeAdt[_, _, ConfirmSucceed]]: FetchAdtApply[F] = FetchAdtApply.get
}

trait HListTypeAdtPositive extends HListTypeAdtPositiveLower {
  type TuSizedAux[L <: HList, IType] = ToSized[L, Array[*]] { type N = IType }

  @inline implicit def hlistTypeAdtPositiveImplicit1[B <: A, A, Tail <: HList, IntType <: Nat](implicit
    toSized: TuSizedAux[A :: Tail, IntType],
    toInt: ToInt[IntType]
  ): TypeAdt[B, A :: Tail, ConfirmSucceed] = new TypeAdt(toInt())
}
trait HListTypeAdtPositiveLower {
  @inline implicit def hlistTypeMappingPositiveImplicitLower[A, B, Tail <: HList](implicit
    tailMapping: TypeAdt[B, Tail, ConfirmSucceed]
  ): TypeAdt[B, A :: Tail, ConfirmSucceed] = tailMapping.asInstanceOf[TypeAdt[B, A :: Tail, ConfirmSucceed]]
}
