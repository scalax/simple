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
  type Aux[Input, Sum, S <: AdtStatus, P] = TypeAdtApply[Input, Sum] { type State = S; type Poly = P }
  def apply[Input, Sum, S <: AdtStatus, P](input: Core2): TypeAdtApply.Aux[Input, Sum, S, P] =
    new TypeAdtApply[Any, Any](input).asInstanceOf[TypeAdtApply.Aux[Input, Sum, S, P]]
}

package impl {
  trait TypeAdtImplicitOptsPolyHigher extends HListTypeAdtPositiveLower {
    @inline implicit def hlistTypeAdtPositiveImplicit1[A, B, Tail <: AdtAlias.AdtNat, AdtConvertPoly](implicit
      adtConvert: AdtContext[A, B, AdtConvertPoly]
    ): TypeAdtApply.Aux[A, AdtAlias.AdtAppend[B, Tail], ConfirmSucceed, AdtConvertPoly] = TypeAdtApply(new Core2 {
      override def apply(c: () => Core2): Core2 =
        AdtConvertWrapper(result = AdtListZero(c), convert = adtConvert.asInstanceOf[AdtContext[Any, Any, Any]])
    })
  }

  trait HListTypeAdtPositiveLower extends LowerLevelPoly {
    @inline implicit def hlistTypeMappingPositiveImplicitLower[A, B, Status <: AdtStatus, AdtConvertPoly, Tail <: AdtAlias.AdtNat](implicit
      tailMapping: TypeAdtApply.Aux[A, Tail, Status, AdtConvertPoly]
    ): TypeAdtApply.Aux[A, AdtAlias.AdtAppend[B, Tail], Status, AdtConvertPoly] = TypeAdtApply(AdtListPositive(() => tailMapping.value))
  }

  trait LowerLevelPoly {
    private val failedValue: TypeAdtApply.Aux[Any, Any, ConfirmFailed, Any] = TypeAdtApply(AdtListException)

    implicit def adtFailedResult[I, Poly]: TypeAdtApply.Aux[I, AdtAlias.AdtZero, ConfirmFailed, Poly] =
      failedValue.asInstanceOf[TypeAdtApply.Aux[I, AdtAlias.AdtZero, ConfirmFailed, Poly]]
  }
}
