package net.scalax.simple.adt.implemention

import net.scalax.simple.ghdmzsk.ghdmzsk

import scala.collection.compat._

trait ghdmzsk1 extends ghdmzsk {
  override def apply(other: () => ghdmzsk): ghdmzsk = ghdmzsk(tail => other()(tail))
}
trait ghdmzskZero extends ghdmzsk {
  override def apply(g: () => ghdmzsk): ghdmzsk = g()
}

object UnapplyInstance {

  trait CountNatPositive[T1 <: TypeCounter, -T2 <: NatFunc] {
    type DataType
  }
  object CountNatPositive extends CountNatPositiveImplicitRaw1 {
    type Aux[T1 <: TypeCounter, -T2 <: NatFunc, DType] = CountNatPositive[T1, T2] {
      type DataType = DType
    }

    implicit def zeroGetTail[T2Tail <: NatFunc, Data]: CountNatPositive.Aux[PositiveTypeCounterZero, NatFuncPositive[Data, T2Tail], Data] =
      new CountNatPositive[PositiveTypeCounterZero, NatFuncPositive[Data, T2Tail]] {
        override type DataType = Data
      }
  }
  trait CountNatPositiveImplicitRaw1 {
    implicit def positiveGetTail[T1Tail <: TypeCounter, T2Tail <: NatFunc, Data, TempData](implicit
      somethig_not_used: CountNatPositive.Aux[T1Tail, T2Tail, Data]
    ): CountNatPositive.Aux[PositiveTypeCounter[T1Tail], NatFuncPositive[TempData, T2Tail], Data] =
      new CountNatPositive[PositiveTypeCounter[T1Tail], NatFuncPositive[TempData, T2Tail]] {
        override type DataType = Data
      }
  }

  sealed trait TypeCounter extends ghdmzsk
  case class PositiveTypeCounter[T <: TypeCounter](tail: T) extends TypeCounter with ghdmzsk1 {
    override def apply(g: () => ghdmzsk): ghdmzsk = super.apply(g)(() => tail)
  }
  class PositiveTypeCounterZero extends TypeCounter with ghdmzskZero
  object PositiveTypeCounterZero {
    val value: PositiveTypeCounterZero = new PositiveTypeCounterZero
  }

  class UnapplyFunc[T <: TypeCounter](tNumber: T) {
    def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CountNatPositive.Aux[T, U, Data]): Option[Data] =
      tNumber(() => u).asInstanceOf[NatFuncPositive[Data, NatFunc]].dataInstance
    def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CountNatPositive.Aux[T, U, Data]): Option[Data] = apply(u)
  }
  def UnapplyFunc[T <: TypeCounter](t: T): UnapplyFunc[T] = new UnapplyFunc(t)

}

trait DataInstance[Data] {
  def dataInstance: Option[Data]
  def isDefined: Boolean
}

trait NatFunc extends ghdmzsk
abstract case class NatFuncPositive[Data, T <: NatFunc](override val dataInstance: Option[Data])
    extends NatFunc
    with DataInstance[Data]
    with ghdmzsk1 {
  override def apply(g: () => ghdmzsk): ghdmzsk = super.apply(g)(() => tail)
  override val isDefined: Boolean               = dataInstance.isDefined
  def tail: T
}

object NatFunc {
  def success[D, T <: NatFunc](t: D, tail: T): NatFuncPositive[D, T] = {
    def tail1 = tail
    new NatFuncPositive[D, T](dataInstance = Some(t)) {
      override val tail: T = tail1
    }
  }
  def empty[D, T <: NatFunc](tail: T): NatFuncPositive[D, T] = {
    def tail1 = tail
    new NatFuncPositive[D, T](dataInstance = Option.empty) {
      override val tail: T = tail1
    }
  }

  val zero: NatFuncZero = NatFuncZero.value
}

final class IsFinishAndNothing {
  def default[T](t: => T): T           = t
  lazy val isEnded: IsFinishAndNothing = this
  def matchErrorAndNothing: Nothing    = throw new Exception("match error.")
}
object IsFinishAndNothing {
  lazy val value: IsFinishAndNothing = new IsFinishAndNothing
}

class NatFuncZero private (tailValue: () => NatFuncZero)
    extends NatFuncPositive[IsFinishAndNothing, NatFuncZero](dataInstance = Some(IsFinishAndNothing.value)) {
  override lazy val tail: NatFuncZero = tailValue()
}
object NatFuncZero {
  lazy val value: NatFuncZero = new NatFuncZero(() => value)
}

object Test extends App {

  type Ux1 = NatFuncPositive[
    Int,
    NatFuncPositive[List[String], NatFuncPositive[List[Long], NatFuncPositive[List[String], NatFuncPositive[String, NatFuncZero]]]]
  ]
  type Ux2 = NatFuncPositive[Int, NatFuncPositive[List[String], NatFuncPositive[List[Long], NatFuncPositive[List[String], NatFuncZero]]]]
  type Ux3 = NatFuncPositive[Int, NatFuncPositive[List[String], NatFuncPositive[List[Long], NatFuncZero]]]

  val p1: Ux1 = NatFunc.empty(NatFunc.empty(NatFunc.success(List(2L, 3L, 5L, 8L), NatFunc.empty(NatFunc.empty(NatFunc.zero)))))
  val p2: Ux2 = NatFunc.empty(NatFunc.empty(NatFunc.success(List(2L, 3L, 5L, 8L), NatFunc.empty(NatFunc.zero))))
  val p3: Ux3 = NatFunc.empty(NatFunc.empty(NatFunc.success(List(2L, 3L, 5L, 8L), NatFunc.zero)))
  val p4: Ux2 = NatFunc.empty(NatFunc.empty(NatFunc.empty(NatFunc.empty(NatFunc.zero))))
  val p5: Ux2 = NatFunc.empty(NatFunc.success(List("abc", "abcdefghij", "abcdefghijklmn"), NatFunc.empty(NatFunc.empty(NatFunc.zero))))

  val Options1 = UnapplyInstance.UnapplyFunc(UnapplyInstance.PositiveTypeCounterZero.value)
  val Options2 = UnapplyInstance.UnapplyFunc(UnapplyInstance.PositiveTypeCounter(UnapplyInstance.PositiveTypeCounterZero.value))
  val Options3 = UnapplyInstance.UnapplyFunc(
    UnapplyInstance.PositiveTypeCounter(UnapplyInstance.PositiveTypeCounter(UnapplyInstance.PositiveTypeCounterZero.value))
  )
  val Options4 = UnapplyInstance.UnapplyFunc(
    UnapplyInstance.PositiveTypeCounter(
      UnapplyInstance.PositiveTypeCounter(UnapplyInstance.PositiveTypeCounter(UnapplyInstance.PositiveTypeCounterZero.value))
    )
  )
  val Options5 = UnapplyInstance.UnapplyFunc(
    UnapplyInstance.PositiveTypeCounter(
      UnapplyInstance.PositiveTypeCounter(
        UnapplyInstance.PositiveTypeCounter(UnapplyInstance.PositiveTypeCounter(UnapplyInstance.PositiveTypeCounterZero.value))
      )
    )
  )
  val Options6 = UnapplyInstance.UnapplyFunc(
    UnapplyInstance.PositiveTypeCounter(
      UnapplyInstance.PositiveTypeCounter(
        UnapplyInstance.PositiveTypeCounter(
          UnapplyInstance.PositiveTypeCounter(UnapplyInstance.PositiveTypeCounter(UnapplyInstance.PositiveTypeCounterZero.value))
        )
      )
    )
  )
  val Options7 = UnapplyInstance.UnapplyFunc(
    UnapplyInstance.PositiveTypeCounter(
      UnapplyInstance.PositiveTypeCounter(
        UnapplyInstance.PositiveTypeCounter(
          UnapplyInstance.PositiveTypeCounter(
            UnapplyInstance.PositiveTypeCounter(UnapplyInstance.PositiveTypeCounter(UnapplyInstance.PositiveTypeCounterZero.value))
          )
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

}
