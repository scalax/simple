package net.scalax.simple
package adt

import temp._
import impl.Adt.{Status => ADTStatus}

/** TODO
  *
  * @author
  *   mars
  * @version 1.0.0
  * @since 2022/08/28
  *   02:48
  */
class TypeAdtApply[Input, Sum <: AdtNat, ST <: ADTStatus](val value: Input => ADTData[Sum, ST]) extends AnyVal

object TypeAdtApply extends impl.TypeAdtImplicitOptsPolyHigher

package impl {

  private object Helper {
    def adapterContext[A, B, AdtConvertPoly](
      c: TypeAdt.Context[A, B, AdtConvertPoly]
    ): TypeAdt.Context[A, TypeAdt.Adapter[B, AdtConvertPoly], AdtConvertPoly] =
      new TypeAdt.Context[A, TypeAdt.Adapter[B, AdtConvertPoly], AdtConvertPoly] {
        override def input(t: A): TypeAdt.Adapter[B, AdtConvertPoly] = new TypeAdt.Adapter[B, AdtConvertPoly](c.input(t))
      }

    private val failedValue: TypeAdtApply[Any, AdtNatZero, ADTStatus.NotFinished] =
      new TypeAdtApply[Any, AdtNatZero, ADTStatus.NotFinished](value = i => ADTData.zero(IsFinishAndNothing.value(i)))

    def failedValueImpl[T]: TypeAdtApply[T, AdtNatZero, ADTStatus.NotFinished] =
      failedValue.asInstanceOf[TypeAdtApply[T, AdtNatZero, ADTStatus.NotFinished]]
  }

  trait TypeAdtImplicitOptsPolyHigher extends HListTypeAdtPositiveLower1 {
    @inline implicit def hlistTypeAdtPositiveImplicit1[A, B, Tail <: AdtNat, AdtConvertPoly, ST <: ADTStatus](implicit
      adtConvert: TypeAdt.Context[A, B, AdtConvertPoly],
      tailMapping: TypeAdtApply[A, Tail, ST]
    ): TypeAdtApply[A, AdtNatPositive[TypeAdt.Adapter[B, AdtConvertPoly], Tail], ADTStatus.Passed] = {
      val adtConvertImpl = Helper.adapterContext(adtConvert)
      new TypeAdtApply(i => ADTData.success(adtConvertImpl.input(i), tailMapping.value(i)))
    }
  }

  trait HListTypeAdtPositiveLower1 extends HListTypeAdtPositiveLower2 {
    @inline implicit def hlistTypeAdtPositiveImplicit2[A, B, Tail <: AdtNat, ST <: ADTStatus](implicit
      adtConvert: TypeAdt.Context[A, B, DefaultAdtContext.type],
      tailMapping: TypeAdtApply[A, Tail, ST]
    ): TypeAdtApply[A, AdtNatPositive[B, Tail], ADTStatus.Passed] = new TypeAdtApply(i =>
      ADTData.success(adtConvert.input(i), tailMapping.value(i))
    )
  }

  trait HListTypeAdtPositiveLower2 extends LowerLevelPoly {
    @inline implicit def hlistTypeMappingPositiveImplicitLower[A, B, Tail <: AdtNat, ST <: ADTStatus](implicit
      tailMapping: TypeAdtApply[A, Tail, ST]
    ): TypeAdtApply[A, AdtNatPositive[B, Tail], ST] = new TypeAdtApply(i => ADTData.empty(tailMapping.value(i)))
  }

  trait LowerLevelPoly {
    implicit def adtFailedResult[I]: TypeAdtApply[I, AdtNatZero, ADTStatus.NotFinished] = Helper.failedValueImpl
  }

}
