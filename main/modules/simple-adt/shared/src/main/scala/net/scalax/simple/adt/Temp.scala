package net.scalax.simple.adt
package temp

import net.scalax.simple.ghdmzsk.ghdmzsk
import impl.Adt.{Status => ADTStatus}

import scala.annotation.meta.param

trait ToGHDMZSK[+N <: RuntimeNat] {
  def toGHDMZSK: ghdmzsk
}

trait ADTData[+N <: RuntimeNat, S <: ADTStatus] extends ToGHDMZSK[N] {
  override def toGHDMZSK: ghdmzsk
}

object ADTData {

  def success[D, T <: RuntimeNat, S <: ADTStatus](data: D): ADTData[RuntimeData[D, T], S] = new ADTData[RuntimeData[D, T], S] {
    override val toGHDMZSK: ghdmzsk = builder.coproducter.success(data)
  }

  def copyTail[D, T <: RuntimeNat, S <: ADTStatus](tailGHDMZSK: ADTData[T, S]): ADTData[RuntimeData[D, T], S] =
    new ADTData[RuntimeData[D, T], S] {
      override val toGHDMZSK: ghdmzsk = builder.coproducter.appender.inputGHDMZSK(() => tailGHDMZSK.toGHDMZSK)
    }

  def zero[ST <: ADTStatus](isFinishAndNothing: IsFinishAndNothing): ADTData[RuntimeZero, ST with ADTStatus.NotFinished.type] =
    new ADTData[RuntimeZero, ST with ADTStatus.NotFinished.type] {
      override lazy val toGHDMZSK: ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(t: () => ghdmzsk): ghdmzsk = ???
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

trait ApplyFactory[N1[_] <: RuntimeNat, N2 <: RuntimeNat] {
  type NatModelType            = ADTData[N2, ADTStatus.Passed.type]
  type NatModelTypeFunction[D] = N1[D]

  def apply[D, T <: ADTStatus](d: D)(implicit v: ADTData[N1[D], T with ADTFunctionImplicitFetch.type]): NatModelType
}
