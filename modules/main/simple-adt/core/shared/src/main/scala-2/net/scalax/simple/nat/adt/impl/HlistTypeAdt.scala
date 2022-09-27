package net.scalax.simple.nat.adt.impl

import net.scalax.simple.nat.adt.{ConfirmSucceed, TypeAdt}

sealed trait HListTypeAdt

final class HListTypeAdtPositive[Current, Tail <: HListTypeAdt] extends HListTypeAdt
object HListTypeAdtPositive extends HListTypeAdtPositiveLower {
  @inline implicit def hlistTypeAdtPositiveImplicit1[B <: A, A, Tail <: HListTypeAdt]
    : TypeAdt[B, HListTypeAdtPositive[A, Tail], ConfirmSucceed] =
    new TypeAdt(1)
}
trait HListTypeAdtPositiveLower {
  @inline implicit def hlistTypeMappingPositiveImplicitLower[A, B, Tail <: HListTypeAdt](implicit
    tailMapping: TypeAdt[B, Tail, ConfirmSucceed]
  ): TypeAdt[B, HListTypeAdtPositive[A, Tail], ConfirmSucceed] = new TypeAdt(tailMapping.index + 1)
}

final class HListTypeAdtZero extends HListTypeAdt
