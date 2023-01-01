package net.scalax.simple.adt
package impl

import core._

trait TypeAdtImplicitOptsPolyHigher extends HListTypeAdtPositive {
  @inline final def get[F[_] <: TypeAdt.Aux[_, _, ConfirmSucceed]]: FetchAdtApply[F] = FetchAdtApply.get
}

trait HListTypeAdtPositive extends HListTypeAdtPositiveLower {
  @inline implicit def hlistTypeAdtPositiveImplicit1[B <: A, A, Tail <: NumberCount[_]]
    : TypeAdt.Aux[B, NumberCountChild[A, Tail], ConfirmSucceed] = new TypeAdt[B, NumberCountChild[A, Tail]] {
    type State = ConfirmSucceed
    override def input(value: Any): AdtList = new AdtListZero(value)
  }
}
trait HListTypeAdtPositiveLower extends LowerLevelPoly {
  @inline implicit def hlistTypeMappingPositiveImplicitLower[A, B, Tail <: NumberCount[_]](implicit
    tailMapping: TypeAdt.Aux[B, Tail, ConfirmSucceed]
  ): TypeAdt.Aux[B, NumberCountChild[A, Tail], ConfirmSucceed] = new TypeAdt[B, NumberCountChild[A, Tail]] {
    type State = ConfirmSucceed
    override def input(value: Any): AdtList = new AdtListPositive(tailMapping.input(value))
  }
}
