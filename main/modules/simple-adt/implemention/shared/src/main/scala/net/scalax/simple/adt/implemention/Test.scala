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
    def needAlreadyOk: Boolean
    def extraPositive[Data](u: NatFunc): NatFuncPositive[Data, NatFunc] = inputGHDMZSK(u).asInstanceOf[NatFuncPositive[Data, NatFunc]]
    def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CountNatPositive.Aux[ThisType, U, Data]): Option[Data] = {
      val positive: NatFuncPositive[Data, NatFunc] = extraPositive(u)
      if (needAlreadyOk) positive.dataInstance.filterNot(_ => positive.isAlreadyOk) else positive.dataInstance
    }
    def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CountNatPositive.Aux[ThisType, U, Data]): Option[Data] = apply(u)
    def CaseFirst: UnapplyFunc.Aux[ThisType]
  }
  object UnapplyFunc {
    type Aux[T <: UnapplyFunc] = UnapplyFunc { type ThisType = T }
  }

  trait UnapplyFuncPositive[Tail <: UnapplyFunc] extends UnapplyFunc {
    self =>
    override type ThisType <: UnapplyFuncPositive[Tail]
    // override def tail: Tail
    override def CaseFirst: UnapplyFuncPositive.Aux[Tail, ThisType]
  }
  object UnapplyFuncPositive {
    type Aux[Tail <: UnapplyFunc, T <: UnapplyFunc] = UnapplyFuncPositive[Tail] { type ThisType = T }
  }

  trait UnapplyFuncZero extends PositiveTypeCounterZero with UnapplyFuncPositive[UnapplyFuncZero] {
    override type ThisType = UnapplyFuncZero
    override def CaseFirst: UnapplyFuncZero
    override def unapply[U <: NatFunc, Data](u: U)(implicit
      somethig_not_used: CountNatPositive.Aux[UnapplyFuncZero, U, Data]
    ): Option[Data] = apply(u)
  }
  object UnapplyFuncZero {
    private lazy val aImpl: UnapplyFuncZero = new UnapplyFuncZero {
      override val needAlreadyOk: Boolean          = true
      override lazy val CaseFirst: UnapplyFuncZero = aImpl
    }

    private lazy val tempValue: UnapplyFuncZero = new UnapplyFuncZero {
      override val needAlreadyOk: Boolean = false
      override lazy val CaseFirst: UnapplyFuncZero = {
        aImpl.CaseFirst
        aImpl
      }
    }

    val value: UnapplyFuncZero = {
      tempValue.CaseFirst
      tempValue
    }

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

object Test extends App {

  type Ux1 = NatFuncPositive[
    Int,
    NatFuncPositive[List[String], NatFuncPositive[List[Long], NatFuncPositive[List[String], NatFuncPositive[String, NatFuncZero]]]]
  ]
  type Ux2 = NatFuncPositive[Int, NatFuncPositive[List[String], NatFuncPositive[List[Long], NatFuncPositive[List[String], NatFuncZero]]]]
  type Ux3 = NatFuncPositive[Int, NatFuncPositive[List[String], NatFuncPositive[List[Long], NatFuncZero]]]

  /*
  val p1: Ux1 = NatFunc.empty(NatFunc.empty(NatFunc.success(List(2L, 3L, 5L, 8L), NatFunc.empty(NatFunc.empty(NatFunc.zero)))))
  val p2: Ux2 = NatFunc.empty(NatFunc.empty(NatFunc.success(List(2L, 3L, 5L, 8L), NatFunc.empty(NatFunc.zero))))
  val p3: Ux3 = NatFunc.empty(NatFunc.empty(NatFunc.success(List(2L, 3L, 5L, 8L), NatFunc.zero)))
  val p4: Ux2 = NatFunc.empty(NatFunc.empty(NatFunc.empty(NatFunc.empty(NatFunc.zero))))
  val p5: Ux2 = NatFunc.empty(NatFunc.success(List("abc", "abcdefghij", "abcdefghijklmn"), NatFunc.empty(NatFunc.empty(NatFunc.zero))))

  val Options1 = UnapplyInstance.UnapplyFuncZero.value
  val Options2 = UnapplyInstance.UnapplyFuncPositive(UnapplyInstance.UnapplyFuncZero.value)
  val Options3 = UnapplyInstance.UnapplyFuncPositive(UnapplyInstance.UnapplyFuncPositive(UnapplyInstance.UnapplyFuncZero.value))
  val Options4 = UnapplyInstance.UnapplyFuncPositive(
    UnapplyInstance.UnapplyFuncPositive(UnapplyInstance.UnapplyFuncPositive(UnapplyInstance.UnapplyFuncZero.value))
  )
  val Options5 = UnapplyInstance.UnapplyFuncPositive(
    UnapplyInstance.UnapplyFuncPositive(
      UnapplyInstance.UnapplyFuncPositive(UnapplyInstance.UnapplyFuncPositive(UnapplyInstance.UnapplyFuncZero.value))
    )
  )
  val Options6 = UnapplyInstance.UnapplyFuncPositive(
    UnapplyInstance.UnapplyFuncPositive(
      UnapplyInstance.UnapplyFuncPositive(
        UnapplyInstance.UnapplyFuncPositive(UnapplyInstance.UnapplyFuncPositive(UnapplyInstance.UnapplyFuncZero.value))
      )
    )
  )
  val Options7 = UnapplyInstance.UnapplyFuncPositive(
    UnapplyInstance.UnapplyFuncPositive(
      UnapplyInstance.UnapplyFuncPositive(
        UnapplyInstance.UnapplyFuncPositive(
          UnapplyInstance.UnapplyFuncPositive(UnapplyInstance.UnapplyFuncPositive(UnapplyInstance.UnapplyFuncZero.value))
        )
      )
    )
  )

  val preT1 = p1 match {
    case Options1(t) => List(t)
    case Options2(t) => t.map(_.size + 1)
    case Options3(t) => t.map(_.toInt * 2)
    case Options4(t) => t.map(_.size * 5)
    case Options5(t) => t.to(List).map(_.toInt * 2)
    case Options6(t) => t.matchErrorAndNothing
    case Options7(t) => t.matchErrorAndNothing
  }

  val t1: List[Int] = preT1

  val preT2 = p2 match {
    case Options1(t) => List(t)
    case Options2(t) => t.map(_.size + 1)
    case Options3(t) => t.map(_.toInt * 2)
    case Options4(t) => t.map(_.size * 5)
    case Options5(t) => t.matchErrorAndNothing
    case Options6(t) => t.matchErrorAndNothing
  }

  val t2: List[Int] = preT2

  val preT3 = p3 match {
    case Options1(t) => List(t)
    case Options2(t) => t.map(_.size + 1)
    case Options3(t) => t.map(_.toInt * 2)
    case Options4(t) => t.matchErrorAndNothing
    case Options5(t) => t.matchErrorAndNothing
  }

  val t3: List[Int] = preT3

  val preT4 = p4 match {
    case Options1(t) => Some(List(t))
    case Options2(t) => Some(t.map(_.size + 1))
    case Options3(t) => Some(t.map(_.toInt * 2))
    case Options4(t) => Some(t.map(_.size * 5))
    case Options5(t) =>
      t.isEnded
      Option.empty
    case Options6(t) =>
      t.isEnded
      Option.empty
  }

  val t4: Option[List[Int]] = preT4

  val preT5 = p5 match {
    case Options1(t) => List(t)
    case Options2(t) => t.map(_.size + 1)
    case Options3(t) => t.map(_.toInt * 2)
    case Options4(t) => t.map(_.size * 5)
    case Options5(t) => t.matchErrorAndNothing
    case Options6(t) => t.matchErrorAndNothing
  }

  val t5: List[Int] = preT5

  println(t1) // Some(List(4, 6, 10, 16))
  println(t2) // Some(List(4, 6, 10, 16))
  println(t3) // Some(List(4, 6, 10, 16))
  println(t4) // None
  println(t5) // Some(List(4, 11, 15))
   */

}
