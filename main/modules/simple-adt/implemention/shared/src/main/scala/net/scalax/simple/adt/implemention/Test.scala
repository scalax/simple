package net.scalax.simple.adt.implemention

import net.scalax.simple.ghdmzsk.ghdmzsk

import scala.collection.compat._

trait ghdmzsk1 extends ghdmzsk {
  override def inputGHDMZSK(other: => ghdmzsk): ghdmzsk = ghdmzsk(tail => other.inputGHDMZSK(tail()))
}
trait ghdmzskZero extends ghdmzsk {
  override def inputGHDMZSK(g: => ghdmzsk): ghdmzsk = g
}

object UnapplyInstance {

  trait CountNatPositive[T1 <: TypeCounter, -T2 <: NatFunc] {
    type DataType
  }
  object CountNatPositive {
    type Aux[T1 <: UnapplyFunc, -T2 <: NatFunc, DType] = CountNatPositive[T1, T2] {
      type DataType = DType
    }
  }

  sealed trait TypeCounter extends ghdmzsk
  trait PositiveTypeCounter[T <: TypeCounter] extends TypeCounter with ghdmzsk1 {
    def tail: T
    override def inputGHDMZSK(g: => ghdmzsk): ghdmzsk = super.inputGHDMZSK(g).inputGHDMZSK(tail)
  }
  trait PositiveTypeCounterZero extends TypeCounter with ghdmzskZero

  sealed trait UnapplyFunc extends TypeCounter {
    self =>
    type ThisType <: UnapplyFunc
    protected def extraPositive[Data](u: NatFunc)(needAlreadyOk: Boolean): Option[Data] = {
      val positive: NatFuncPositive[Data, NatFunc] = inputGHDMZSK(u).asInstanceOf[NatFuncPositive[Data, NatFunc]]
      if (needAlreadyOk) positive.dataInstance.filterNot(_ => positive.isAlreadyOk) else positive.dataInstance
    }
    def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CountNatPositive.Aux[ThisType, U, Data]): Option[Data] =
      extraPositive(u)(needAlreadyOk = false)
    def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CountNatPositive.Aux[ThisType, U, Data]): Option[Data] =
      extraPositive(u)(needAlreadyOk = true)
  }

  trait UnapplyFuncPositive[Tail <: UnapplyFunc] extends UnapplyFunc {
    self =>
    override type ThisType <: UnapplyFuncPositive[Tail]
  }
  object UnapplyFuncPositive {
    type Aux[Tail <: UnapplyFunc, T <: UnapplyFunc] = UnapplyFuncPositive[Tail] { type ThisType = T }
  }

  class UnapplyFuncZero extends PositiveTypeCounterZero with UnapplyFuncPositive[UnapplyFuncZero] {
    override type ThisType = UnapplyFuncZero
    override def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CountNatPositive.Aux[ThisType, U, Data]): Option[Data] =
      super.apply(u)
    override def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CountNatPositive.Aux[ThisType, U, Data]): Option[Data] =
      super.unapply(u)
  }
  object UnapplyFuncZero {
    val value: UnapplyFuncZero = new UnapplyFuncZero

    implicit def zeroGetTail[T2Tail <: NatFunc, Data]: CountNatPositive.Aux[UnapplyFuncZero, NatFuncPositive[Data, T2Tail], Data] =
      new CountNatPositive[UnapplyFuncZero, NatFuncPositive[Data, T2Tail]] {
        override type DataType = Data
      }
  }

}

trait DataInstance[Data] {
  def dataInstance: Option[Data]
  def isDefined: Boolean
}

trait NatFunc extends ghdmzsk {
  def isAlreadyOk: Boolean
}
abstract case class NatFuncPositive[Data, T <: NatFunc](override val dataInstance: Option[Data])
    extends NatFunc
    with DataInstance[Data]
    with ghdmzsk1 {
  override def inputGHDMZSK(g: => ghdmzsk): ghdmzsk = super.inputGHDMZSK(g).inputGHDMZSK(tail)
  override val isDefined: Boolean                   = dataInstance.isDefined
  override def isAlreadyOk: Boolean
  def tail: T
}

object NatFunc {
  def success[D, T <: NatFunc](t: D, isAlreadyOk: Boolean, tail: T): NatFuncPositive[D, T] = {
    val tail1        = tail
    val isAlreadyOk1 = isAlreadyOk
    new NatFuncPositive[D, T](dataInstance = Some(t)) {
      override val tail: T              = tail1
      override val isAlreadyOk: Boolean = isAlreadyOk1
    }
  }
  def empty[D, T <: NatFunc](isAlreadyOk: Boolean, tail: T): NatFuncPositive[D, T] = {
    val tail1        = tail
    val isAlreadyOk1 = isAlreadyOk
    new NatFuncPositive[D, T](dataInstance = Option.empty) {
      override val tail: T              = tail1
      override val isAlreadyOk: Boolean = isAlreadyOk1
    }
  }

  def zeroFromIsOk(isOk: Boolean): NatFuncZero = if (isOk) NatFuncZero.valueIsAlreadyOk else NatFuncZero.valueIsNotOk
}

final class IsFinishAndNothing {
  def default[T](t: => T): T           = t
  lazy val isEnded: IsFinishAndNothing = this
  def matchErrorAndNothing: Nothing    = throw new Exception("match error.")
}
object IsFinishAndNothing {
  lazy val value: IsFinishAndNothing = new IsFinishAndNothing
}

class NatFuncZero private (tailValue: () => NatFuncZero, override val isAlreadyOk: Boolean)
    extends NatFuncPositive[IsFinishAndNothing, NatFuncZero](dataInstance = Some(IsFinishAndNothing.value)) {
  override lazy val tail: NatFuncZero = tailValue()
}
object NatFuncZero {
  lazy val valueIsAlreadyOk: NatFuncZero = new NatFuncZero(() => valueIsAlreadyOk, isAlreadyOk = true)
  lazy val valueIsNotOk: NatFuncZero     = new NatFuncZero(() => valueIsAlreadyOk, isAlreadyOk = false) // 这里的Tail一定已经被取值了，因为到了Zero就已经是“取值了”
}
