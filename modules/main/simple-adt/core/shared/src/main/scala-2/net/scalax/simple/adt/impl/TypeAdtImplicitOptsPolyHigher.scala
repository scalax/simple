package net.scalax.simple.adt
package impl

import CoreInstance._

trait TypeAdtImplicitOptsPolyHigher extends HListTypeAdtPositiveLower {
  @inline implicit def hlistTypeAdtPositiveImplicit1[B <: A, A, Tail <: NumberCount[_], AdtConvertPoly](implicit
    adtConvert: AdtConvert[A, B, AdtConvertPoly]
  ): TypeAdtApply.Aux[B, NumberCountChild[A, Tail], ConfirmSucceed, AdtConvertPoly] = TypeAdtApply(new Core2 {
    override def apply(c: () => Core2): Core2 =
      AdtConvertWrapper(result = AdtListZero(c), convert = adtConvert.asInstanceOf[AdtConvert[Any, Any, Any]])
  })
}

trait HListTypeAdtPositiveLower extends LowerLevelPoly {
  @inline implicit def hlistTypeMappingPositiveImplicitLower[A, B, AdtConvertPoly, Tail <: NumberCount[_]](implicit
    tailMapping: TypeAdtApply.Aux[B, Tail, ConfirmSucceed, AdtConvertPoly]
  ): TypeAdtApply.Aux[B, NumberCountChild[A, Tail], ConfirmSucceed, AdtConvertPoly] = TypeAdtApply(AdtListPositive(() => tailMapping.value))
}
