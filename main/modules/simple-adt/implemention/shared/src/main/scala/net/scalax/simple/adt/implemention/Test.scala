package net.scalax.simple.adt.implemention

import scala.collection.compat._

trait FoldContext[+Result] {
  def option: Option[Result]
  def overrideOnce[U >: Result](d: => Option[U]): FoldContext[U]
}

object EmptyFoldContext extends FoldContext[Nothing] {
  override val option: None.type = None
  override def overrideOnce[U >: Nothing](d: => Option[U]): FoldContext[U] = {
    val v = for (dValue <- d) yield new FinishedFoldContext(dValue)
    v.getOrElse(this)
  }
}
class FinishedFoldContext[+Result](val value: Result) extends FoldContext[Result] {
  override def option: Some[Result]                                       = Some(value)
  override def overrideOnce[U >: Result](d: => Option[U]): FoldContext[U] = this
}

trait NatFunc
trait NatFuncPositive[Data, T <: NatFunc] extends NatFunc {
  def tail: T
  def foldImpl[Result](d: Data => Result): Option[Result]
}

class IsFinishAndNothing {
  lazy val isFinishAndNothing: IsFinishAndNothing = IsFinishAndNothing
}
object IsFinishAndNothing extends IsFinishAndNothing

case class LeftFunc[Data, T <: NatFunc](override val tail: T) extends NatFuncPositive[Data, T] {
  override def foldImpl[Result](d: Data => Result): None.type = None
}
case class RightFunc[Data, T <: NatFunc](data: Data, override val tail: T) extends NatFuncPositive[Data, T] {
  override def foldImpl[Result](d: Data => Result): Some[Result] = Some(d(data))
}
trait NatFuncZero extends NatFuncPositive[IsFinishAndNothing.type, NatFuncZero] {
  override def tail: NatFuncZero
  def foldImpl[Result](d: IsFinishAndNothing.type => Result): Some[Result] = Some(d(IsFinishAndNothing))
}
object NatFuncZero extends NatFuncZero {
  override lazy val tail: NatFuncZero = NatFuncZero
}

object Test extends App {

  type Ux1 = NatFuncPositive[
    Int,
    NatFuncPositive[List[String], NatFuncPositive[List[Long], NatFuncPositive[List[String], NatFuncPositive[String, NatFuncZero]]]]
  ]
  type Ux2 = NatFuncPositive[Int, NatFuncPositive[List[String], NatFuncPositive[List[Long], NatFuncPositive[List[String], NatFuncZero]]]]
  type Ux3 = NatFuncPositive[Int, NatFuncPositive[List[String], NatFuncPositive[List[Long], NatFuncZero]]]

  val p1: Ux1 = LeftFunc(LeftFunc(RightFunc(List(2L, 3L, 5L, 8L), LeftFunc(LeftFunc(NatFuncZero)))))
  val p2: Ux2 = LeftFunc(LeftFunc(RightFunc(List(2L, 3L, 5L, 8L), LeftFunc(NatFuncZero))))
  val p3: Ux3 = LeftFunc(LeftFunc(RightFunc(List(2L, 3L, 5L, 8L), NatFuncZero)))
  val p4: Ux2 = LeftFunc(LeftFunc(LeftFunc(LeftFunc(NatFuncZero))))
  val p5: Ux2 = LeftFunc(RightFunc(List("abc", "abcdefghij", "abcdefghijklmn"), LeftFunc(LeftFunc(NatFuncZero))))

  val t1 = {
    val p1_1 = EmptyFoldContext
    val p2_1 = p1_1.overrideOnce(p1.foldImpl(t => List(t)))
    val p3_1 = p2_1.overrideOnce(p1.tail.foldImpl(t => t.map(_.size + 1)))
    val p4_1 = p3_1.overrideOnce(p1.tail.tail.foldImpl(t => t.map(_.toInt * 2)))
    val p5_1 = p4_1.overrideOnce(p1.tail.tail.tail.foldImpl(t => t.map(_.size * 5)))
    val p6_1 = p5_1.overrideOnce(p1.tail.tail.tail.tail.foldImpl(t => t.to(List).map(_.toInt * 2)))
    val p7_1 = p6_1.overrideOnce(
      p1.tail.tail.tail.tail.tail.foldImpl(
        { t =>
          t.isFinishAndNothing
          List.empty
        }
      )
    )
    val p8_1 = p7_1.overrideOnce(
      p1.tail.tail.tail.tail.tail.tail.foldImpl(
        { t =>
          t.isFinishAndNothing
          List.empty
        }
      )
    )
    p8_1.option
  }

  val t2 = {
    val p1_1 = EmptyFoldContext
    val p2_1 = p1_1.overrideOnce(p2.foldImpl(t => List(t)))
    val p3_1 = p2_1.overrideOnce(p2.tail.foldImpl(t => t.map(_.size + 1)))
    val p4_1 = p3_1.overrideOnce(p2.tail.tail.foldImpl(t => t.map(_.toInt * 2)))
    val p5_1 = p4_1.overrideOnce(p2.tail.tail.tail.foldImpl(t => t.map(_.size * 5)))
    p5_1.option
  }

  val t3 = {
    val p1_1 = EmptyFoldContext
    val p2_1 = p1_1.overrideOnce(p3.foldImpl(t => List(t)))
    val p3_1 = p2_1.overrideOnce(p3.tail.foldImpl(t => t.map(_.size + 1)))
    val p4_1 = p3_1.overrideOnce(p3.tail.tail.foldImpl(t => t.map(_.toInt * 2)))
    p4_1.option
  }

  val t4 = {
    val p1_1 = EmptyFoldContext
    val p2_1 = p1_1.overrideOnce(p4.foldImpl(t => List(t)))
    val p3_1 = p2_1.overrideOnce(p4.tail.foldImpl(t => t.map(_.size + 1)))
    val p4_1 = p3_1.overrideOnce(p4.tail.tail.foldImpl(t => t.map(_.toInt * 2)))
    val p5_1 = p4_1.overrideOnce(p4.tail.tail.tail.foldImpl(t => t.map(_.size * 5)))
    p5_1.option
  }

  val t5 = {
    val p1_1 = EmptyFoldContext
    val p2_1 = p1_1.overrideOnce(p5.foldImpl(t => List(t)))
    val p3_1 = p2_1.overrideOnce(p5.tail.foldImpl(t => t.map(_.size + 1)))
    val p4_1 = p3_1.overrideOnce(p5.tail.tail.foldImpl(t => t.map(_.toInt * 2)))
    val p5_1 = p4_1.overrideOnce(p5.tail.tail.tail.foldImpl(t => t.map(_.size * 5)))
    p5_1.option
  }

  println(t1) // Some(List(4, 6, 10, 16))
  println(t2) // Some(List(4, 6, 10, 16))
  println(t3) // Some(List(4, 6, 10, 16))
  println(t4) // None
  println(t5) // Some(List(4, 11, 15))

}
