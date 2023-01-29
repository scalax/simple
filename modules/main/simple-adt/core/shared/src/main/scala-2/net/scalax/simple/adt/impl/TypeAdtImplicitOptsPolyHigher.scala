package net.scalax.simple.adt
package impl

import CoreInstance._

trait TypeAdtImplicitOptsPolyHigher extends HListTypeAdtPositiveLower {
  @inline implicit def hlistTypeAdtPositiveImplicit1[B <: A, A, Tail <: NumberCount[_]]
    : TypeAdtApply.Aux[B, NumberCountChild[A, Tail], ConfirmSucceed] = TypeAdtApply(AdtListZero)
}
trait HListTypeAdtPositiveLower extends LowerLevelPoly {
  @inline implicit def hlistTypeMappingPositiveImplicitLower[A, B, Tail <: NumberCount[_]](implicit
    tailMapping: TypeAdtApply.Aux[B, Tail, ConfirmSucceed]
  ): TypeAdtApply.Aux[B, NumberCountChild[A, Tail], ConfirmSucceed] = TypeAdtApply(AdtListPositive(() => tailMapping.value))
}
