package net.scalax.simple.adt
package temp

import net.scalax.simple.adt.AdtExtension

import scala.annotation.meta.param

final class IsFinishAndNothing(@(transient @param) obj: Any) {
  def default[T](t: => T): T               = t
  def isEnded: IsFinishAndNothing          = this
  def matchErrorAndThrowException: Nothing = throw new MatchError(obj)
}
object IsFinishAndNothing {
  def value(obj: Any): IsFinishAndNothing = new IsFinishAndNothing(obj)
}

trait ApplyFactory[N1[_] <: RuntimeNat, N2 <: RuntimeNat] {
  type NatModelType            = ADTData[N2, AdtExtension.Passed.type]
  type NatModelTypeFunction[D] = N1[D]

  trait InstanceGet[D1Type] {
    def instance[T <: AdtExtension](implicit
      v: ADTData[NatModelTypeFunction[D1Type], T with ADTFunctionImplicitFetch.type]
    ): ADTData[NatModelTypeFunction[D1Type], T with ADTFunctionImplicitFetch.type] = v
  }

  def apply[D, T <: AdtExtension](d: D)(implicit v: ADTData[NatModelTypeFunction[D], T with ADTFunctionImplicitFetch.type]): NatModelType
  def typeOnly[D]: InstanceGet[D] = new InstanceGet[D] {
    //
  }
}
