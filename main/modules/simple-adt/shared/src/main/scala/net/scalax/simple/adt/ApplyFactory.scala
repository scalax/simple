package net.scalax.simple.adt
package temp

trait ApplyFactory[N1[_] <: RuntimeNat, N2 <: RuntimeNat] {
  type NatModelType            = ADTData[N2, ADTPassedFunction.type]
  type NatModelTypeFunction[D] = N1[D]

  trait InstanceGet[D1Type] {
    def instance[ADTExtension](implicit
      v: ADTData[NatModelTypeFunction[D1Type], ADTExtension with ADTTypeParameterFetch.type]
    ): ADTData[NatModelTypeFunction[D1Type], ADTExtension with ADTTypeParameterFetch.type] = v
  }

  def apply[D, ADTExtension](d: D)(implicit v: ADTData[NatModelTypeFunction[D], ADTExtension with ADTTypeParameterFetch.type]): NatModelType
  def typeOnly[D]: InstanceGet[D] = new InstanceGet[D] {
    //
  }
}
