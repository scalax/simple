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

object ADTFunctionImplicitFetch {

  import net.scalax.simple.adt.nat.{AdtNatPositive, AdtNatZero}

  private object Helper {
    def adapterContext[A, B, AdtConvertPoly](
      c: TypeAdt.Context[A, B, AdtConvertPoly]
    ): TypeAdt.Context[A, TypeAdt.Adapter[B, AdtConvertPoly], AdtConvertPoly] =
      new TypeAdt.Context[A, TypeAdt.Adapter[B, AdtConvertPoly], AdtConvertPoly] {
        override def input(t: A): TypeAdt.Adapter[B, AdtConvertPoly] = new TypeAdt.Adapter[B, AdtConvertPoly](c.input(t))
      }

    private val failedValue: TypeAdtApply[Any, AdtNatZero, ADTStatus.NotFinished.type] =
      new TypeAdtApply[Any, AdtNatZero, ADTStatus.NotFinished.type](value = i => ADTData.zero(IsFinishAndNothing.value(i)))

    def failedValueImpl[T]: TypeAdtApply[T, AdtNatZero, ADTStatus.NotFinished.type] =
      failedValue.asInstanceOf[TypeAdtApply[T, AdtNatZero, ADTStatus.NotFinished.type]]
  }

  trait TypeAdtImplicitOptsPolyHigher extends HListTypeAdtPositiveLower1 {
    @inline implicit def hlistTypeAdtPositiveImplicit1[A, B, Tail <: AdtNat, AdtConvertPoly, ST <: ADTStatus](implicit
      adtConvert: TypeAdt.Context[A, B, AdtConvertPoly],
      tailMapping: ADTData[Tail, ST]
    ): ADTData[AdtNatPositive[TypeAdt.Context[A, B, AdtConvertPoly], Tail], ST] = {
      val adtConvertImpl = Helper.adapterContext(adtConvert)
      ADTData.success(adtConvertImpl, tailMapping)
    }
  }

  trait HListTypeAdtPositiveLower1 extends HListTypeAdtPositiveLower2 {
    @inline implicit def hlistTypeAdtPositiveImplicit2[A, B, Tail <: AdtNat, ST <: ADTStatus](implicit
      adtConvert: TypeAdt.Context[A, B, DefaultAdtContext.type],
      tailMapping: TypeAdtApply[A, Tail, ST]
    ): TypeAdtApply[A, AdtNatPositive[B, Tail], ADTStatus.Passed.type] = new TypeAdtApply(i =>
      ADTData.success(adtConvert.input(i), tailMapping.value(i))
    )
  }

  trait HListTypeAdtPositiveLower2 extends LowerLevelPoly {
    @inline implicit def hlistTypeMappingPositiveImplicitLower[A, B, Tail <: AdtNat, ST <: ADTStatus](implicit
      tailMapping: TypeAdtApply[A, Tail, ST]
    ): TypeAdtApply[A, AdtNatPositive[B, Tail], ST] = new TypeAdtApply(i => ADTData.empty(tailMapping.value(i)))
  }

  trait LowerLevelPoly {
    implicit def adtFailedResult[I]: TypeAdtApply[I, AdtNatZero, ADTStatus.NotFinished.type] = Helper.failedValueImpl
  }

}
