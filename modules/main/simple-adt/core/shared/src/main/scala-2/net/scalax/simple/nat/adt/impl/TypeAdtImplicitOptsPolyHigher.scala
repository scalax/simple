package net.scalax.simple.nat.adt
package impl

import shapeless._
import shapeless.ops.nat.ToInt
import shapeless.ops.hlist.ToSized

trait TypeAdtImplicitOptsPolyHigher extends HListTypeAdtPositive {
  @inline final def lift[A, B, T <: AdtStatus](typeAdt: TypeAdt[A, B]): TypeAdt.Aux[A, B, T] = typeAdt.asInstanceOf[TypeAdt.Aux[A, B, T]]
  @inline final def get[F[_] <: TypeAdt.Aux[_, _, ConfirmSucceed]]: FetchAdtApply[F]         = FetchAdtApply.get
}

trait HListTypeAdtPositive extends HListTypeAdtPositiveLower {
  type TuSizedAux[L <: HList, IType] = ToSized[L, Array[*]] { type N = IType }

  @inline implicit def hlistTypeAdtPositiveImplicit1[B <: A, A, Tail <: HList, IntType <: Nat](implicit
    toSized: TuSizedAux[A :: Tail, IntType],
    toInt: ToInt[IntType]
  ): TypeAdt.Aux[B, A :: Tail, ConfirmSucceed] = TypeAdt.lift(new TypeAdt(toInt()))
}
trait HListTypeAdtPositiveLower extends LowerLevelPoly {
  @inline implicit def hlistTypeMappingPositiveImplicitLower[A, B, Tail <: HList](implicit
    tailMapping: TypeAdt.Aux[B, Tail, ConfirmSucceed]
  ): TypeAdt.Aux[B, A :: Tail, ConfirmSucceed] = tailMapping.asInstanceOf[TypeAdt.Aux[B, A :: Tail, ConfirmSucceed]]
}
