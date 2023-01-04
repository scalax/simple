package net.scalax.simple.adt
package impl

import core._

trait TypeAdtImplicitOptsPolyHigher extends HListTypeAdtPositive {
  @inline final def get[F[_] <: TypeAdt.Aux[_, _, ConfirmSucceed]]: FetchAdtApply[F] = FetchAdtApply.get
}

trait HListTypeAdtPositive extends HListTypeAdtPositiveLower {
  @inline implicit def hlistTypeAdtPositiveImplicit1[B <: A, A, Tail <: NumberCount[_]]
    : TypeAdt.Aux[B, NumberCountChild[A, Tail], ConfirmSucceed] = TypeAdt(new AdtListZero {
    override def method1(m: FoldList): FoldList = {
      m.asInstanceOf[TypeAdtGetter].runGetter
      super.method1(m)
    }
  })
}
trait HListTypeAdtPositiveLower extends LowerLevelPoly {
  @inline implicit def hlistTypeMappingPositiveImplicitLower[A, B, Tail <: NumberCount[_]](implicit
    tailMapping: TypeAdt.Aux[B, Tail, ConfirmSucceed]
  ): TypeAdt.Aux[B, NumberCountChild[A, Tail], ConfirmSucceed] = TypeAdt(new AdtListPositive(tailMapping.value))
}
