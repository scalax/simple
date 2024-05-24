package net.scalax.simple
package adt

/** TODO
  *
  * @author
  *   mars
  * @version 1.0.0
  * @since 2022/08/28
  *   02:48
  */
object ADTFunctionImplicitFetch extends AdtExtension with impl.TypeAdtImplicitOptsPolyHigher

package impl {

  trait TypeAdtImplicitOptsPolyHigher extends HListTypeAdtPositiveLower2 {
    @inline implicit def hlistTypeAdtPositiveImplicit1[A, B, Tail <: RuntimeNat, ST <: AdtExtension](implicit
      adtConvert: AdtFunction[A, B]
    ): ADTData[RuntimeData[AdtFunction[A, B], Tail], ST with AdtExtension.Passed.type] =
      ADTData.success(adtConvert)
  }

  trait HListTypeAdtPositiveLower2 {
    @inline implicit def hlistTypeMappingPositiveImplicitLower[A, B, Tail <: RuntimeNat, ST <: AdtExtension](implicit
      tailMapping: ADTData[Tail, ST]
    ): ADTData[RuntimeData[AdtFunction[A, B], Tail], ST] = ADTData.copyTail(tailMapping)
  }

}
