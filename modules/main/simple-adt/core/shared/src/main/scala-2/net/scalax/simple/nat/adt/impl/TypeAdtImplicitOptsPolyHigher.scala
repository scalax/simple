package net.scalax.simple.adt
package impl

trait TypeAdtImplicitOptsPolyHigher extends HListTypeAdtPositive {
  @inline final def lift[A, B, T <: AdtStatus](typeAdt: TypeAdt[A, B]): TypeAdt.Aux[A, B, T] = typeAdt.asInstanceOf[TypeAdt.Aux[A, B, T]]
  @inline final def get[F[_] <: TypeAdt.Aux[_, _, ConfirmSucceed]]: FetchAdtApply[F]         = FetchAdtApply.get
}

trait HListTypeAdtPositive extends HListTypeAdtPositiveLower {
  @inline implicit def hlistTypeAdtPositiveImplicit1[B <: A, A, Tail <: NumberCount[_]]
    : TypeAdt.Aux[B, NumberCountChild[A, Tail], ConfirmSucceed] = TypeAdt.lift(new TypeAdt(1))
}
trait HListTypeAdtPositiveLower extends LowerLevelPoly {
  @inline implicit def hlistTypeMappingPositiveImplicitLower[A, B, Tail <: NumberCount[_]](implicit
    tailMapping: TypeAdt.Aux[B, Tail, ConfirmSucceed]
  ): TypeAdt.Aux[B, NumberCountChild[A, Tail], ConfirmSucceed] = TypeAdt.lift(new TypeAdt(tailMapping.index + 1))
}
