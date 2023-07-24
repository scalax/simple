package net.scalax.simple
package adt

import temp._
import temp.{Status => TStatus}

/** TODO
  *
  * @author
  *   mars
  * @version 1.0.0
  * @since 2022/08/28
  *   02:48
  */
class TypeAdtApply[Input, Sum <: AdtNat, S <: TStatus](val value: Boolean => Input => ADTData[Sum, S])

object TypeAdtApply extends impl.TypeAdtImplicitOptsPolyHigher {
  def apply[Input, Sum <: AdtNat, S <: TypeAdt.Status, ST <: TStatus](
    value: Boolean => Input => ADTData[Sum, ST]
  ): TypeAdtApply[Input, Sum, ST] = new TypeAdtApply[Input, Sum, ST](value)
}

package impl {

  class AdapterContext[A, B, AdtConvertPoly](private val c: TypeAdt.Context[A, B, AdtConvertPoly])
      extends AnyVal
      with TypeAdt.Context[A, TypeAdt.Adapter[B, AdtConvertPoly], AdtConvertPoly] {
    override def input(t: A): TypeAdt.Adapter[B, AdtConvertPoly] = new TypeAdt.Adapter[B, AdtConvertPoly](c.input(t))
  }

  trait TypeAdtImplicitOptsPolyHigher extends HListTypeAdtPositiveLower1 {
    @inline implicit def hlistTypeAdtPositiveImplicit1[A, B, Tail <: AdtNat, AdtConvertPoly, ST <: TStatus](implicit
      adtConvert: TypeAdt.Context[A, B, AdtConvertPoly],
      tailMapping: TypeAdtApply[A, Tail, ST]
    ): TypeAdtApply[A, AdtNatData[TypeAdt.Adapter[B, AdtConvertPoly], Tail], TStatus.Passed] = {
      val adtConvertImpl = new AdapterContext(adtConvert)
      TypeAdtApply(isOk => i => ADTData.success(adtConvertImpl.input(i), tailMapping.value(true)(i)))
    }
  }

  trait HListTypeAdtPositiveLower1 extends HListTypeAdtPositiveLower2 {
    @inline implicit def hlistTypeAdtPositiveImplicit2[A, B, Tail <: AdtNat, ST <: TStatus](implicit
      adtConvert: TypeAdt.Context[A, B, DefaultAdtContext.type],
      tailMapping: TypeAdtApply[A, Tail, ST]
    ): TypeAdtApply[A, AdtNatData[B, Tail], TStatus.Passed] =
      TypeAdtApply(isOk => i => ADTData.success(adtConvert.input(i), tailMapping.value(true)(i)))
  }

  trait HListTypeAdtPositiveLower2 extends LowerLevelPoly {
    @inline implicit def hlistTypeMappingPositiveImplicitLower[A, B, Tail <: AdtNat, ST <: TStatus](implicit
      tailMapping: TypeAdtApply[A, Tail, ST]
    ): TypeAdtApply[A, AdtNatData[B, Tail], ST] = TypeAdtApply(isOk => i => ADTData.empty(tailMapping.value(isOk)(i)))
  }

  trait LowerLevelPoly {
    private object failedValue extends TypeAdtApply[Any, AdtNatZero, TStatus.NotFinished](value = isOk => i => ADTData.zero)
    private def failedValueImpl[T]: TypeAdtApply[T, AdtNatZero, TStatus.NotFinished] =
      failedValue.asInstanceOf[TypeAdtApply[T, AdtNatZero, TStatus.NotFinished]]

    implicit def adtFailedResult[I]: TypeAdtApply[I, AdtNatZero, TStatus.NotFinished] = failedValueImpl
  }

}
