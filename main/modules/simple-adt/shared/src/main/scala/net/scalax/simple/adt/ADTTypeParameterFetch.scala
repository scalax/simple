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
object ADTTypeParameterFetch extends impl.HListTypeAdtPositiveLower2 {
  @inline implicit def hlistTypeAdtPositiveImplicit1[A, B, Tail <: RuntimeNat, ADTExtension](implicit
    adtConvert: AdtFunction[A, B]
  ): ADTData[RuntimeData[AdtFunction[A, B], Tail], ADTExtension with ADTPassedFunction.type] =
    ADTData.success(adtConvert)
}

package impl {

  trait HListTypeAdtPositiveLower2 {
    @inline implicit def hlistTypeMappingPositiveImplicitLower[A, B, Tail <: RuntimeNat, ADTExtension](implicit
      tailMapping: ADTData[Tail, ADTExtension]
    ): ADTData[RuntimeData[AdtFunction[A, B], Tail], ADTExtension] = ADTData.copyTail(tailMapping)
  }

}
