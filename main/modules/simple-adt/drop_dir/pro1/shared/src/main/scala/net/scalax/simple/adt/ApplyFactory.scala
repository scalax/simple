package net.scalax.simple.adt
package temp

trait ApplyFactory[N1[_] <: RuntimeNat, N2 <: RuntimeNat] {
  type NatModelType            = ADTData[N2, ADTPassedFunction.type]
  type NatModelTypeFunction[D] = N1[D]

  def apply[D](d: D)(implicit v: ADTData[NatModelTypeFunction[D], ADTPassedFunction.type with ADTTypeParameterFetch.type]): NatModelType

  def typeOnly[D](implicit
    v: ADTData[NatModelTypeFunction[D], ADTPassedFunction.type with ADTTypeParameterFetch.type]
  ): ADTData[NatModelTypeFunction[D], ADTPassedFunction.type with ADTTypeParameterFetch.type] = v

}
