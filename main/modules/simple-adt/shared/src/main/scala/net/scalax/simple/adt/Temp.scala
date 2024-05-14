package net.scalax.simple.adt
package temp

import net.scalax.simple.adt.implemention.ADTGHDMZSK
import net.scalax.simple.ghdmzsk.ghdmzsk
import impl.Adt.{Status => ADTStatus}
import net.scalax.simple.adt.nat.{AdtNat, AdtNatPositive, AdtNatZero}
import core._

import scala.annotation.meta.param

trait ToGHDMZSK[+N <: AdtNat] {
  def toGHDMZSK: N
}

trait ADTData[+N <: AdtNat, S <: ADTStatus] extends ToGHDMZSK[N] {
  override def toGHDMZSK: N
}

object ADTData {
  def success[D, T <: AdtNat, S <: ADTStatus](data: D): ADTData[AdtNatPositive[D, T], S] = {
    val data1 = data

    new ADTData[AdtNatPositive[D, T], S] {
      override val toGHDMZSK: AdtNatPositive[D, T] = new AdtNatPositive[D, T] {
        override def data: Either[D, T] = Left(data1)
      }
    }
  }

  def copyTail[D, T <: AdtNat, S <: ADTStatus](tail: T): ADTData[AdtNatPositive[D, T], S] = new ADTData[AdtNatPositive[D, T], S] {
    override val toGHDMZSK: AdtNatPositive[D, T] = new AdtNatPositive[D, T] {
      override def data: Either[D, T] = Right(tail)
    }
  }

  def zero[ST <: ADTStatus](isFinishAndNothing: IsFinishAndNothing): ADTData[AdtNatZero, ST with ADTStatus.NotFinished.type] =
    new ADTData[AdtNatZero, ST with ADTStatus.NotFinished.type] {
      override lazy val toGHDMZSK: AdtNatZero = new AdtNatZero {
        //
      }
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
