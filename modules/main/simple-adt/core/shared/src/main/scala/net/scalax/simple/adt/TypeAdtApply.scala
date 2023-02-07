package net.scalax.simple.adt

import CoreInstance._

/** TODO
  *
  * @author
  *   mars
  * @version 1.0.0
  * @since 2022/08/28
  *   02:48
  */
class TypeAdtApply[Input, Sum](val value: Core2) {
  type State <: AdtStatus
}

object TypeAdtApply extends impl.TypeAdtImplicitOptsPolyHigher {
  type Aux[Input, Sum, S <: AdtStatus] = TypeAdtApply[Input, Sum] { type State = S }
  def apply[Input, Sum, S <: AdtStatus, P](input: Core2): TypeAdtApply.Aux[Input, Sum, S] =
    new TypeAdtApply[Any, Any](input).asInstanceOf[TypeAdtApply.Aux[Input, Sum, S]]
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
    ): TypeAdtApply.Aux[A, AdtAlias.AdtAppend[TypeAdt.Adapter[B, AdtConvertPoly], Tail], AdtStatus.Passed] = {
      val adtConvertImpl = new AdapterContext(adtConvert)
      val number = new Core2 {
        override def apply(c: () => Core2): Core2 =
          AdtConvertWrapper(result = AdtListZero(c), convert = adtConvertImpl.asInstanceOf[TypeAdt.Context[Any, Any, Any]])
      }
      TypeAdtApply(number)
    }
  }

  trait HListTypeAdtPositiveLower1 extends HListTypeAdtPositiveLower2 {
    @inline implicit def hlistTypeAdtPositiveImplicit2[A, B, Tail <: AdtAlias.AdtNat, AdtConvertPoly](implicit
      adtConvert: TypeAdt.Context[A, B, DefaultAdtContext.type]
    ): TypeAdtApply.Aux[A, AdtAlias.AdtAppend[B, Tail], AdtStatus.Passed] = TypeAdtApply(new Core2 {
      override def apply(c: () => Core2): Core2 =
        AdtConvertWrapper(result = AdtListZero(c), convert = adtConvert.asInstanceOf[TypeAdt.Context[Any, Any, Any]])
    })
  }

  trait HListTypeAdtPositiveLower2 extends LowerLevelPoly {
    @inline implicit def hlistTypeMappingPositiveImplicitLower[A, B, Status <: AdtStatus, Tail <: AdtAlias.AdtNat](implicit
      tailMapping: TypeAdtApply.Aux[A, Tail, Status]
    ): TypeAdtApply.Aux[A, AdtAlias.AdtAppend[B, Tail], Status] = TypeAdtApply(AdtListPositive(() => tailMapping.value))
  }

  trait LowerLevelPoly {
    private val failedValue: TypeAdtApply.Aux[Any, Any, AdtStatus.Failed] = TypeAdtApply(AdtListException)

    implicit def adtFailedResult[I]: TypeAdtApply.Aux[I, AdtAlias.AdtZero, AdtStatus.Failed] =
      failedValue.asInstanceOf[TypeAdtApply.Aux[I, AdtAlias.AdtZero, AdtStatus.Failed]]
  }

}
