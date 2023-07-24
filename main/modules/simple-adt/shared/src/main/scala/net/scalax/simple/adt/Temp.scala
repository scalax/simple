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

trait ADTData[+N <: AdtNat] extends ToGHDMZSK {
  override def toGHDMZSK: ghdmzsk
}

object ADTData {
  def success[D, T <: AdtNat](data: D, tail: ADTData[T]): ADTData[AdtNatData[D, T]] = new ADTData[AdtNatData[D, T]] {
    override val toGHDMZSK: ghdmzsk = Disscure.a1VImpl(data).inputGHDMZSK(tail.toGHDMZSK)
  }
  def empty[D, T <: AdtNat](tail: ADTData[T]): ADTData[AdtNatData[D, T]] = new ADTData[AdtNatData[D, T]] {
    override val toGHDMZSK: ghdmzsk = Disscure.a1Impl1.inputGHDMZSK(tail.toGHDMZSK)
  }
  lazy val zero: ADTData[AdtNatZero] = new ADTData[AdtNatZero] {
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
