package net.scalax.simple.adt
package temp

import net.scalax.simple.adt.AdtExtension

trait ApplyFactory[N1[_] <: RuntimeNat, N2 <: RuntimeNat] {
  type NatModelType            = ADTData[N2, AdtExtension.Passed.type]
  type NatModelTypeFunction[D] = N1[D]

  trait InstanceGet[D1Type] {
    def instance[T <: AdtExtension](implicit
      v: ADTData[NatModelTypeFunction[D1Type], T with ADTTypeParameterFetch.type]
    ): ADTData[NatModelTypeFunction[D1Type], T with ADTTypeParameterFetch.type] = v
  }

  def apply[D, T <: AdtExtension](d: D)(implicit v: ADTData[NatModelTypeFunction[D], T with ADTTypeParameterFetch.type]): NatModelType
  def typeOnly[D]: InstanceGet[D] = new InstanceGet[D] {
    //
  }
}
