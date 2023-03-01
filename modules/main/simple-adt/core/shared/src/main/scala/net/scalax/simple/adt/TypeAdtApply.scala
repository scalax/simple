package net.scalax.simple
package adt

import nat.number9._
import core.Core2

/** TODO
  *
  * @author
  *   mars
  * @version 1.0.0
  * @since 2022/08/28
  *   02:48
  */
class TypeAdtApply[Input, Sum <: AdtAlias.AdtNat](val value: Number1) {
  type State <: TypeAdt.Status
}

object TypeAdtApply extends impl.TypeAdtImplicitOptsPolyHigher {
  type Aux[Input, Sum <: AdtAlias.AdtNat, S <: TypeAdt.Status] = TypeAdtApply[Input, Sum] { type State = S }
  def apply[Input, Sum <: AdtAlias.AdtNat, S <: TypeAdt.Status](input: Number1): TypeAdtApply.Aux[Input, Sum, S] =
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
      val num1 = new Number1T {
        override def input(num2: => Core2): Number2 = new Number2S(num2.asInstanceOf[Number2]) with Adt.Context[Any, Any, Any] {
          def input(t: Any): Any = adtConvertImpl.input(t.asInstanceOf[A])
        }
      }
      TypeAdtApply(num1)
    }
  }

  trait HListTypeAdtPositiveLower1 extends HListTypeAdtPositiveLower2 {
    @inline implicit def hlistTypeAdtPositiveImplicit2[A, B, Tail <: AdtAlias.AdtNat](implicit
      adtConvert: TypeAdt.Context[A, B, DefaultAdtContext.type]
    ): TypeAdtApply.Aux[A, AdtAlias.AdtAppend[B, Tail], TypeAdt.Status.Passed] = {
      val num1 = new Number1T {
        override def input(num2: => Core2): Number2 = new Number2S(num2.asInstanceOf[Number2]) with Adt.Context[Any, Any, Any] {
          def input(t: Any): Any = adtConvert.input(t.asInstanceOf[A])
        }
      }
      TypeAdtApply(num1)
    }
  }

  trait HListTypeAdtPositiveLower2 extends LowerLevelPoly {
    @inline implicit def hlistTypeMappingPositiveImplicitLower[A, B, Status <: TypeAdt.Status, Tail <: AdtAlias.AdtNat](implicit
      tailMapping: TypeAdtApply.Aux[A, Tail, Status]
    ): TypeAdtApply.Aux[A, AdtAlias.AdtAppend[B, Tail], Status] = TypeAdtApply(Number1S(tailMapping.value))
  }

  trait LowerLevelPoly {
    private val failedValue: TypeAdtApply.Aux[Any, AdtAlias.AdtNat, Adt.Status.Failed] = TypeAdtApply(new Number1T)

    implicit def adtFailedResult[I]: TypeAdtApply.Aux[I, AdtAlias.AdtZero, Adt.Status.Failed] =
      failedValue.asInstanceOf[TypeAdtApply.Aux[I, AdtAlias.AdtZero, Adt.Status.Failed]]
  }

}
