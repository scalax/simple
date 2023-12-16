package net.scalax.simple.adt
package temp

import net.scalax.simple.adt.implemention.ADTGHDMZSK
import net.scalax.simple.ghdmzsk.ghdmzsk
import impl.Adt.Status
import net.scalax.simple.adt.nat.{AdtNat, AdtNatPositive, AdtNatZero}

import scala.annotation.meta.param

trait ToGHDMZSK {
  def toGHDMZSK: ghdmzsk
}

trait ADTData[+N <: AdtNat, S <: Status] extends ToGHDMZSK {
  override def toGHDMZSK: ghdmzsk
}

object ADTData {
  def success[D, T <: AdtNat, S <: Status](data: D, tail: ADTData[T, S]): ADTData[AdtNatPositive[D, T], Status.Passed] =
    new ADTData[AdtNatPositive[D, T], Status.Passed] {
      override val toGHDMZSK: ghdmzsk = ADTGHDMZSK.a1VImpl(data).inputGHDMZSK(() => tail.toGHDMZSK)
    }
  def empty[D, T <: AdtNat, S <: Status](tail: ADTData[T, S]): ADTData[AdtNatPositive[D, T], S] = new ADTData[AdtNatPositive[D, T], S] {
    override val toGHDMZSK: ghdmzsk = ADTGHDMZSK.a1Impl1.inputGHDMZSK(() => tail.toGHDMZSK)
  }
  def zero(isFinishAndNothing: IsFinishAndNothing): ADTData[AdtNatZero, Status.NotFinished] = new ADTData[AdtNatZero, Status.NotFinished] {
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

trait ApplyFactory[N <: AdtNat] {
  def apply[D, S <: Status](d: D)(implicit v: TypeAdtApply[D, N, S]): ADTData[N, S] = v.value(d)
}

object ApplyFactory {
  private val any: ApplyFactory[AdtNat] = new ApplyFactory[AdtNat] {
    //
  }
  private def factoryApply[N <: AdtNat]: ApplyFactory[N] = any.asInstanceOf[ApplyFactory[N]]

  def build[N <: AdtNat]: ApplyFactory[N] = factoryApply
}
