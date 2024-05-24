package net.scalax.simple
package adt

import temp._
import impl.Adt.{Status => ADTStatus}
import net.scalax.simple.ghdmzsk.ghdmzsk

/** TODO
  *
  * @author
  *   mars
  * @version 1.0.0
  * @since 2022/08/28
  *   02:48
  */
object ADTFunctionImplicitFetch extends impl.TypeAdtImplicitOptsPolyHigher

package impl {

  trait TypeAdtImplicitOptsPolyHigher extends HListTypeAdtPositiveLower2 {
    @inline implicit def hlistTypeAdtPositiveImplicit1[A, B, Tail <: RuntimeNat, ST <: ADTStatus](implicit
      adtConvert: AdtFunction[A, B]
    ): ADTData[RuntimeData[AdtFunction[A, B], Tail], ST with ADTStatus.Passed.type] =
      ADTData.success(adtConvert)
  }

  trait HListTypeAdtPositiveLower2 {
    @inline implicit def hlistTypeMappingPositiveImplicitLower[A, B, Tail <: RuntimeNat, ST <: ADTStatus](implicit
      tailMapping: ADTData[Tail, ST]
    ): ADTData[RuntimeData[AdtFunction[A, B], Tail], ST] = ADTData.copyTail(tailMapping)
  }

}
