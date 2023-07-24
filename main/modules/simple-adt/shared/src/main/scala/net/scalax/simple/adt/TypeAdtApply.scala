package net.scalax.simple
package adt

import net.scalax.simple.ghdmzsk.ghdmzsk
import implemention._
import temp._

/** TODO
  *
  * @author
  *   mars
  * @version 1.0.0
  * @since 2022/08/28
  *   02:48
  */
class TypeAdtApply[Input, Sum <: AdtNat](val value: Boolean => Input => ADTData[Sum]) {
  type State <: TypeAdt.Status
}

object TypeAdtApply extends impl.TypeAdtImplicitOptsPolyHigher {
  type Aux[Input, Sum <: AdtNat, S <: TypeAdt.Status] = TypeAdtApply[Input, Sum] { type State = S }
  def apply[Input, Sum <: AdtNat, S <: TypeAdt.Status](value: Boolean => Input => ADTData[Sum]): Aux[Input, Sum, S] =
    new TypeAdtApply[Input, Sum](value) {
      override type State = S
    }
}

package impl {

  class AdapterContext[A, B, AdtConvertPoly](private val c: TypeAdt.Context[A, B, AdtConvertPoly])
      extends AnyVal
      with TypeAdt.Context[A, TypeAdt.Adapter[B, AdtConvertPoly], AdtConvertPoly] {
    override def input(t: A): TypeAdt.Adapter[B, AdtConvertPoly] = new TypeAdt.Adapter[B, AdtConvertPoly](c.input(t))
  }

  trait TypeAdtImplicitOptsPolyHigher extends HListTypeAdtPositiveLower1 {
    @inline implicit def hlistTypeAdtPositiveImplicit1[A, B, Tail <: AdtNat, AdtConvertPoly, Status <: TypeAdt.Status](implicit
      adtConvert: TypeAdt.Context[A, B, AdtConvertPoly],
      tailMapping: TypeAdtApply.Aux[A, Tail, Status]
    ): TypeAdtApply.Aux[A, AdtNatData[TypeAdt.Adapter[B, AdtConvertPoly], Tail], TypeAdt.Status.Passed] = {
      val adtConvertImpl = new AdapterContext(adtConvert)
      TypeAdtApply(isOk => i => ADTData.success(adtConvertImpl.input(i), tailMapping.value(true)(i)))
    }
  }

  trait HListTypeAdtPositiveLower1 extends HListTypeAdtPositiveLower2 {
    @inline implicit def hlistTypeAdtPositiveImplicit2[A, B, Tail <: AdtNat, Status <: TypeAdt.Status](implicit
      adtConvert: TypeAdt.Context[A, B, DefaultAdtContext.type],
      tailMapping: TypeAdtApply.Aux[A, Tail, Status]
    ): TypeAdtApply.Aux[A, AdtNatData[B, Tail], TypeAdt.Status.Passed] =
      TypeAdtApply(isOk => i => ADTData.success(adtConvert.input(i), tailMapping.value(true)(i)))
  }

  trait HListTypeAdtPositiveLower2 extends LowerLevelPoly {
    @inline implicit def hlistTypeMappingPositiveImplicitLower[A, B, Status <: TypeAdt.Status, Tail <: AdtNat](implicit
      tailMapping: TypeAdtApply.Aux[A, Tail, Status]
    ): TypeAdtApply.Aux[A, AdtNatData[B, Tail], Status] =
      TypeAdtApply(isOk => i => ADTData.empty(tailMapping.value(isOk)(i)))
  }

  trait LowerLevelPoly {
    private object failedValue extends TypeAdtApply[Any, AdtNatZero](value = isOk => i => ADTData.zero) {
      override type State = Adt.Status.Failed
    }
    private def failedValueImpl[T]: TypeAdtApply.Aux[T, AdtNatZero, Adt.Status.Failed] =
      failedValue.asInstanceOf[TypeAdtApply.Aux[T, AdtNatZero, Adt.Status.Failed]]

    implicit def adtFailedResult[I]: TypeAdtApply.Aux[I, AdtNatZero, Adt.Status.Failed] = failedValueImpl
  }

}
