package net.scalax.simple
package adt

import net.scalax.simple.ghdmzsk.ghdmzsk
import implemention._

/** TODO
  *
  * @author
  *   mars
  * @version 1.0.0
  * @since 2022/08/28
  *   02:48
  */
class TypeAdtApply[Input, Sum <: NatFunc](val value: Input => Sum) {
  type State <: TypeAdt.Status
}

object TypeAdtApply extends impl.TypeAdtImplicitOptsPolyHigher {
  type Aux[Input, Sum <: NatFunc, S <: TypeAdt.Status] = TypeAdtApply[Input, Sum] { type State = S }
  def apply[Input, Sum <: NatFunc, S <: TypeAdt.Status](value: Input => Sum): Aux[Input, Sum, S] =
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
    @inline implicit def hlistTypeAdtPositiveImplicit1[A, B, Tail <: NatFunc, AdtConvertPoly](implicit
      adtConvert: TypeAdt.Context[A, B, AdtConvertPoly]
    ): TypeAdtApply.Aux[A, NatFuncPositive[TypeAdt.Adapter[B, AdtConvertPoly], Tail], TypeAdt.Status.Passed] = {
      val adtConvertImpl = new AdapterContext(adtConvert)
      TypeAdtApply(i => NatFunc.successValue(adtConvertImpl.input(i)))
    }
  }

  trait HListTypeAdtPositiveLower1 extends HListTypeAdtPositiveLower2 {
    @inline implicit def hlistTypeAdtPositiveImplicit2[A, B, Tail <: NatFunc](implicit
      adtConvert: TypeAdt.Context[A, B, DefaultAdtContext.type]
    ): TypeAdtApply.Aux[A, NatFuncPositive[B, Tail], TypeAdt.Status.Passed] =
      TypeAdtApply(i => NatFunc.successValue(adtConvert.input(i)))
  }

  trait HListTypeAdtPositiveLower2 extends LowerLevelPoly {
    @inline implicit def hlistTypeMappingPositiveImplicitLower[A, B, Status <: TypeAdt.Status, Tail <: NatFunc](implicit
      tailMapping: TypeAdtApply.Aux[A, Tail, Status]
    ): TypeAdtApply.Aux[A, NatFuncPositive[B, Tail], Status] =
      TypeAdtApply(i => NatFunc.empty(tailMapping.value(i)))
  }

  trait LowerLevelPoly {
    private object failedValue extends TypeAdtApply[Any, NatFuncZero](value = i => NatFunc.zero) {
      override type State = Adt.Status.Failed
    }
    private def failedValueImpl[T]: TypeAdtApply.Aux[T, NatFuncZero, Adt.Status.Failed] =
      failedValue.asInstanceOf[TypeAdtApply.Aux[T, NatFuncZero, Adt.Status.Failed]]

    implicit def adtFailedResult[I]: TypeAdtApply.Aux[I, NatFuncZero, Adt.Status.Failed] = failedValueImpl
  }

}
