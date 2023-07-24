package net.scalax.simple.adt
package temp

import net.scalax.simple.adt.implemention.Disscure
import net.scalax.simple.ghdmzsk.ghdmzsk

trait AdtNat
trait AdtNatPositive[+T <: AdtNat]   extends AdtNat
class AdtNatData[Head, +T <: AdtNat] extends AdtNatPositive[T]
class AdtNatZero                     extends AdtNatPositive[AdtNatZero]

trait ToGHDMZSK {
  def toGHDMZSK: ghdmzsk
}

sealed trait Status
object Status {
  class Passed extends Status
  object Passed

  class NotFinished extends Status
  object NotFinished
}

trait ADTData[+N <: AdtNat, S <: Status] extends ToGHDMZSK {
  override def toGHDMZSK: ghdmzsk
}

object ADTData {
  def success[D, T <: AdtNat, S <: Status](data: D, tail: ADTData[T, S]): ADTData[AdtNatData[D, T], Status.Passed] =
    new ADTData[AdtNatData[D, T], Status.Passed] {
      override val toGHDMZSK: ghdmzsk = Disscure.a1VImpl(data).inputGHDMZSK(tail.toGHDMZSK)
    }
  def empty[D, T <: AdtNat, S <: Status](tail: ADTData[T, S]): ADTData[AdtNatData[D, T], S] = new ADTData[AdtNatData[D, T], S] {
    override val toGHDMZSK: ghdmzsk = Disscure.a1Impl1.inputGHDMZSK(tail.toGHDMZSK)
  }
  lazy val zero: ADTData[AdtNatZero, Status.NotFinished] = new ADTData[AdtNatZero, Status.NotFinished] {
    override lazy val toGHDMZSK: ghdmzsk = Disscure.a1VImpl(IsFinishAndNothing.value).inputGHDMZSK(zero.toGHDMZSK)
  }
}

final class IsFinishAndNothing {
  def default[T](t: => T): T           = t
  lazy val isEnded: IsFinishAndNothing = this
  def matchErrorAndNothing: Nothing    = throw new Exception("match error.")
}
object IsFinishAndNothing {
  lazy val value: IsFinishAndNothing = new IsFinishAndNothing
}
