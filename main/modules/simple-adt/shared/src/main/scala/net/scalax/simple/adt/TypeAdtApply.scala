package net.scalax.simple
package adt

import temp._
import impl.Adt.{Status => ADTStatus}
import net.scalax.simple.adt.nat.AdtNat

/** TODO
  *
  * @author
  *   mars
  * @version 1.0.0
  * @since 2022/08/28
  *   02:48
  */
class TypeAdtApply[Input, Sum <: AdtNat, ST <: ADTStatus](val value: Input => ADTData[Sum, ST]) extends AnyVal

object TypeAdtApply extends impl.TypeAdtImplicitOptsPolyHigher {
  implicit def identityImplicit[S <: AdtNat, ST <: ADTStatus]: TypeAdtApply[ADTData[S, ST], S, ST] =
    new TypeAdtApply[ADTData[S, ST], S, ST](identity)
}

object ADTFunctionImplicitFetch extends impl.TypeAdtImplicitOptsPolyHigher

package impl {
  import net.scalax.simple.adt.nat.{AdtNatPositive, AdtNatZero}

  trait TypeAdtImplicitOptsPolyHigher extends HListTypeAdtPositiveLower1 {
    @inline implicit def hlistTypeAdtPositiveImplicit1[A, B, Tail <: AdtNat, AdtConvertPoly, ST <: ADTStatus](implicit
      adtConvert: TypeAdt.Context[A, B, AdtConvertPoly]
    ): ADTData[AdtNatPositive[TypeAdt.Context[A, B, AdtConvertPoly], Tail], ST with ADTStatus.Passed.type] =
      ADTData.success(adtConvert, null)
  }

  trait HListTypeAdtPositiveLower1 extends HListTypeAdtPositiveLower2 {
    @inline implicit def hlistTypeAdtPositiveImplicit2[A, B, Tail <: AdtNat, ST <: ADTStatus](implicit
      adtConvert: TypeAdt.Context[A, B, DefaultAdtContext.type]
    ): ADTData[AdtNatPositive[TypeAdt.Context[A, B, DefaultAdtContext.type], Tail], ST with ADTStatus.Passed.type] =
      ADTData.success(adtConvert, null)
  }

  trait HListTypeAdtPositiveLower2 extends LowerLevelPoly {
    @inline implicit def hlistTypeMappingPositiveImplicitLower[A, B, Tail <: AdtNat, ST <: ADTStatus](implicit
      tailMapping: ADTData[Tail, ST]
    ): ADTData[AdtNatPositive[TypeAdt.Context[A, B, DefaultAdtContext.type], Tail], ST] = ADTData.empty(tailMapping)
  }

  trait LowerLevelPoly {
    implicit def adtFailedResult[ST <: ADTStatus]: ADTData[AdtNatZero, ST with ADTStatus.NotFinished.type] =
      ADTData.zero[ST](IsFinishAndNothing.value(null))
  }
}
