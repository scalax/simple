package net.scalax.simple.adt.implemention

import scala.collection.compat._

trait FoldContext[+Result] {
  def option: Option[Result]
  def overrideOnce[D, U >: Result](d: DataInstance[D])(func: D => U): FoldContext[U]
}
object FoldContext {
  val empty: FoldContext[Nothing] = EmptyFoldContext

  private object EmptyFoldContext extends FoldContext[Nothing] {
    override val option: None.type = None
    override def overrideOnce[D, U](d: DataInstance[D])(func: D => U): FoldContext[U] = {
      val v = for (dValue <- d.dataInstance) yield new FinishedFoldContext(func(dValue))
      v.getOrElse(this)
    }
  }
  private class FinishedFoldContext[+Result](val value: Result) extends FoldContext[Result] {
    override def option: Some[Result]                                                           = Some(value)
    override def overrideOnce[D, U >: Result](d: DataInstance[D])(func: D => U): FoldContext[U] = this
  }
}

trait DataInstance[Data] {
  def dataInstance: Option[Data]
  def isDefined: Boolean
}

trait NatFunc
abstract case class NatFuncPositive[Data, +T <: NatFunc](override val dataInstance: Option[Data]) extends NatFunc with DataInstance[Data] {
  override val isDefined: Boolean = dataInstance.isDefined
  def tail: T
}

object NatFunc {
  def success[D, T <: NatFunc](t: D, tail: T): NatFuncPositive[D, T] = new NatFuncPositiveSuccess(data = t, tail = tail)
  def successValue[D, T <: NatFunc](t: D): NatFuncPositive[D, T]     = new NatFuncPositiveSuccessImpl(data = t)
  def empty[D, T <: NatFunc](tail: T): NatFuncPositive[D, T]         = new NatFuncPositiveEmpty(tail = tail)
  private def emptyInstance[T <: NatFunc]: T                         = emptyNone.asInstanceOf[T]
  val zero: NatFuncZero                                              = NatFuncZero.value

  private class NatFuncPositiveSuccess[Data, +T <: NatFunc](data: Data, override val tail: T)
      extends NatFuncPositive[Data, T](dataInstance = Some(data)) {
    override val isDefined: Boolean = true
  }
  private class NatFuncPositiveSuccessImpl[Data, +T <: NatFunc](data: Data)
      extends NatFuncPositiveSuccess[Data, T](data = data, tail = emptyNone.asInstanceOf[T]) {
    override val isDefined: Boolean = true
  }
  private class NatFuncPositiveEmpty[Data, +T <: NatFunc](override val tail: T)
      extends NatFuncPositive[Data, T](dataInstance = Option.empty) {
    override val isDefined: Boolean = false
  }

  private lazy val emptyNone: NatFuncPositive[Any, NatFunc] = new NatFuncPositive[Any, NatFunc](dataInstance = None) {
    override lazy val tail: NatFunc = emptyNone
    override val isDefined: Boolean = false
  }
}

final class IsFinishAndNothing {
  def matchErrorAndNothing: Nothing = throw new Exception("match error.")
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

  val t1 = FoldContext.empty
    .overrideOnce(p1)(t => List(t))
    .overrideOnce(p1.tail)(t => t.map(_.size + 1))
    .overrideOnce(p1.tail.tail)(t => t.map(_.toInt * 2))
    .overrideOnce(p1.tail.tail.tail)(t => t.map(_.size * 5))
    .overrideOnce(p1.tail.tail.tail.tail)(t => t.to(List).map(_.toInt * 2))
    .overrideOnce(p1.tail.tail.tail.tail.tail) { t =>
      def doneSomething: Nothing = t.matchErrorAndNothing
      List.empty
    }
    .overrideOnce(p1.tail.tail.tail.tail.tail.tail) { t =>
      def doneSomething: Nothing = t.matchErrorAndNothing
      List.empty
    }
    .option

  val t2 = FoldContext.empty
    .overrideOnce(p2)(t => List(t))
    .overrideOnce(p2.tail)(t => t.map(_.size + 1))
    .overrideOnce(p2.tail.tail)(t => t.map(_.toInt * 2))
    .overrideOnce(p2.tail.tail.tail)(t => t.map(_.size * 5))
    .option

  val t3 = FoldContext.empty
    .overrideOnce(p3)(t => List(t))
    .overrideOnce(p3.tail)(t => t.map(_.size + 1))
    .overrideOnce(p3.tail.tail)(t => t.map(_.toInt * 2))
    .option

  val t4 = FoldContext.empty
    .overrideOnce(p4)(t => List(t))
    .overrideOnce(p4.tail)(t => t.map(_.size + 1))
    .overrideOnce(p4.tail.tail)(t => t.map(_.toInt * 2))
    .overrideOnce(p4.tail.tail.tail)(t => t.map(_.size * 5))
    .option

  val t5 = FoldContext.empty
    .overrideOnce(p5)(t => List(t))
    .overrideOnce(p5.tail)(t => t.map(_.size + 1))
    .overrideOnce(p5.tail.tail)(t => t.map(_.toInt * 2))
    .overrideOnce(p5.tail.tail.tail)(t => t.map(_.size * 5))
    .option

  println(t1) // Some(List(4, 6, 10, 16))
  println(t2) // Some(List(4, 6, 10, 16))
  println(t3) // Some(List(4, 6, 10, 16))
  println(t4) // None
  println(t5) // Some(List(4, 11, 15))

}
