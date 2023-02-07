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
class TypeAdtApply[Input, Sum](val value: Core2)

object TypeAdtApply extends impl.TypeAdtImplicitOptsPolyHigher {
  type Aux[Input, Sum, S <: AdtStatus] = TypeAdtApply[Input, Sum] { type State = S }
  def apply[Input, Sum, S <: AdtStatus, P](input: Core2): TypeAdtApply.Aux[Input, Sum, S] =
    new TypeAdtApply[Any, Any](input).asInstanceOf[TypeAdtApply.Aux[Input, Sum, S]]
}

package impl {

  class AdapterContext[A, B, AdtConvertPoly](private val c: AdtContext[A, B, AdtConvertPoly])
      extends AnyVal
      with AdtContext[A, AdtAdapter[B, AdtConvertPoly], AdtConvertPoly] {
    override def input(t: A): AdtAdapter[B, AdtConvertPoly] = new AdtAdapter[B, AdtConvertPoly](c.input(t))
  }

  trait TypeAdtImplicitOptsPolyHigher extends HListTypeAdtPositiveLower1 {
    @inline implicit def hlistTypeAdtPositiveImplicit1[A, B, Tail <: AdtAlias.AdtNat, AdtConvertPoly](implicit
      adtConvert: AdtContext[A, B, AdtConvertPoly]
    ): TypeAdtApply.Aux[A, AdtAlias.AdtAppend[AdtAdapter[B, AdtConvertPoly], Tail], AdtStatus.Passed] = {
      val adtConvertImpl = new AdapterContext(adtConvert)
      val number = new Core2 {
        override def apply(c: () => Core2): Core2 =
          AdtConvertWrapper(result = AdtListZero(c), convert = adtConvertImpl.asInstanceOf[AdtContext[Any, Any, Any]])
      }
      TypeAdtApply(number)
    }
  }

  trait HListTypeAdtPositiveLower1 extends HListTypeAdtPositiveLower2 {
    @inline implicit def hlistTypeAdtPositiveImplicit2[A, B, Tail <: AdtAlias.AdtNat, AdtConvertPoly](implicit
      adtConvert: AdtContext[A, B, DefaultAdtContext.type]
    ): TypeAdtApply.Aux[A, AdtAlias.AdtAppend[B, Tail], AdtStatus.Passed] = TypeAdtApply(new Core2 {
      override def apply(c: () => Core2): Core2 =
        AdtConvertWrapper(result = AdtListZero(c), convert = adtConvert.asInstanceOf[AdtContext[Any, Any, Any]])
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
