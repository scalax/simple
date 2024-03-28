package net.scalax.simple.adt
package temp

import net.scalax.simple.adt.implemention.ADTGHDMZSK
import net.scalax.simple.ghdmzsk.ghdmzsk
import impl.Adt.{Status => ADTStatus}
import net.scalax.simple.adt.nat.{AdtNat, AdtNatPositive, AdtNatZero}

import scala.annotation.meta.param

trait ToGHDMZSK {
  def toGHDMZSK: ghdmzsk
}

trait ADTData[+N <: AdtNat, S <: ADTStatus] extends ToGHDMZSK {
  override def toGHDMZSK: ghdmzsk
}

object ADTData {
  def success[D, T <: AdtNat, S <: ADTStatus](data: D, tail: ADTData[T, S]): ADTData[AdtNatPositive[D, T], S] =
    new ADTData[AdtNatPositive[D, T], S] {
      override val toGHDMZSK: ghdmzsk = ADTGHDMZSK.a1VImpl(data).inputGHDMZSK(() => tail.toGHDMZSK)
    }
  def empty[D, T <: AdtNat, S <: ADTStatus](tail: ADTData[T, S]): ADTData[AdtNatPositive[D, T], S] = new ADTData[AdtNatPositive[D, T], S] {
    override val toGHDMZSK: ghdmzsk = ADTGHDMZSK.a1Impl1.inputGHDMZSK(() => tail.toGHDMZSK)
  }
  def zero[ST <: ADTStatus](isFinishAndNothing: IsFinishAndNothing): ADTData[AdtNatZero, ST with ADTStatus.NotFinished.type] =
    new ADTData[AdtNatZero, ST with ADTStatus.NotFinished.type] {
      override lazy val toGHDMZSK: ghdmzsk = ADTGHDMZSK.a1VImpl(isFinishAndNothing).inputGHDMZSK(() => zero(isFinishAndNothing).toGHDMZSK)
    }
}

final class IsFinishAndNothing(@(transient @param) obj: Any) {
  def default[T](t: => T): T               = t
  def isEnded: IsFinishAndNothing          = this
  def matchErrorAndThrowException: Nothing = throw new MatchError(obj)
}
object IsFinishAndNothing {
  def value(obj: Any): IsFinishAndNothing = new IsFinishAndNothing(obj)
}

trait ApplyFactory[N1[_] <: AdtNat, N2 <: AdtNat] {
  protected def cv[D, T <: ADTStatus](a: D, b: ADTData[N1[D], T with ADTFunctionImplicitFetch.type]): ADTData[N2, ADTStatus.Passed.type]
  def apply[D, T <: ADTStatus](d: D)(implicit v: ADTData[N1[D], T with ADTFunctionImplicitFetch.type]): ADTData[N2, ADTStatus.Passed.type] =
    cv[D, T](d, v)
}
