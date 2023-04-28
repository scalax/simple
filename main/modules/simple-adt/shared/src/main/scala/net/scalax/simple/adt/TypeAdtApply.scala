package net.scalax.simple
package adt

import implemention.AdtNumber
import net.scalax.simple.ghdmzsk.ghdmzsk

/** TODO
  *
  * @author
  *   mars
  * @version 1.0.0
  * @since 2022/08/28
  *   02:48
  */
class TypeAdtApply[Input, Sum <: AdtAlias.AdtNat](val value: VarSetting[TypeAdt.Context[Any, Any, Any]] => ghdmzsk) {
  type State <: TypeAdt.Status
}

object TypeAdtApply extends impl.TypeAdtImplicitOptsPolyHigher {
  type Aux[Input, Sum <: AdtAlias.AdtNat, S <: TypeAdt.Status] = TypeAdtApply[Input, Sum] { type State = S }
  def apply[Input, Sum <: AdtAlias.AdtNat, S <: TypeAdt.Status](
    input: VarSetting[TypeAdt.Context[Any, Any, Any]] => ghdmzsk
  ): TypeAdtApply.Aux[Input, Sum, S] =
    new TypeAdtApply[Any, AdtAlias.AdtNat](input).asInstanceOf[TypeAdtApply.Aux[Input, Sum, S]]
}

package impl {

  class AdapterContext[A, B, AdtConvertPoly](private val c: TypeAdt.Context[A, B, AdtConvertPoly])
      extends AnyVal
      with TypeAdt.Context[A, TypeAdt.Adapter[B, AdtConvertPoly], AdtConvertPoly] {
    override def input(t: A): TypeAdt.Adapter[B, AdtConvertPoly] = new TypeAdt.Adapter[B, AdtConvertPoly](c.input(t))
  }

  trait TypeAdtImplicitOptsPolyHigher extends HListTypeAdtPositiveLower1 {
    @inline implicit def hlistTypeAdtPositiveImplicit1[A, B, Tail <: AdtAlias.AdtNat, AdtConvertPoly](implicit
      adtConvert: TypeAdt.Context[A, B, AdtConvertPoly]
    ): TypeAdtApply.Aux[A, AdtAlias.AdtAppend[TypeAdt.Adapter[B, AdtConvertPoly], Tail], TypeAdt.Status.Passed] = {
      val adtConvertImpl = new AdapterContext(adtConvert)
      TypeAdtApply(setting => AdtNumber.NumberA.setZero(() => setting.value = adtConvertImpl.asInstanceOf[TypeAdt.Context[Any, Any, Any]]))
    }
  }

  trait HListTypeAdtPositiveLower1 extends HListTypeAdtPositiveLower2 {
    @inline implicit def hlistTypeAdtPositiveImplicit2[A, B, Tail <: AdtAlias.AdtNat](implicit
      adtConvert: TypeAdt.Context[A, B, DefaultAdtContext.type]
    ): TypeAdtApply.Aux[A, AdtAlias.AdtAppend[B, Tail], TypeAdt.Status.Passed] =
      TypeAdtApply(setting => AdtNumber.NumberA.setZero(() => setting.value = adtConvert.asInstanceOf[TypeAdt.Context[Any, Any, Any]]))
  }

  trait HListTypeAdtPositiveLower2 extends LowerLevelPoly {
    @inline implicit def hlistTypeMappingPositiveImplicitLower[A, B, Status <: TypeAdt.Status, Tail <: AdtAlias.AdtNat](implicit
      tailMapping: TypeAdtApply.Aux[A, Tail, Status]
    ): TypeAdtApply.Aux[A, AdtAlias.AdtAppend[B, Tail], Status] =
      TypeAdtApply(setting => AdtNumber.NumberA.Positive(() => tailMapping.value(setting)))
  }

  trait LowerLevelPoly {
    private object failedValue extends TypeAdtApply[Any, AdtAlias.AdtZero](value = setting => AdtNumber.NumberA.Zero) {
      override type State = Adt.Status.Failed
    }
    private def failedValueImpl[T]: TypeAdtApply.Aux[T, AdtAlias.AdtZero, Adt.Status.Failed] =
      failedValue.asInstanceOf[TypeAdtApply.Aux[T, AdtAlias.AdtZero, Adt.Status.Failed]]

    implicit def adtFailedResult[I]: TypeAdtApply.Aux[I, AdtAlias.AdtZero, Adt.Status.Failed] = failedValueImpl
  }

}
