package net.scalax.simple.adt.implemention

import scala.collection.compat._

trait FoldContext[Result] {
  def default(d: => Result): Result
  def option: Option[Result]
  def overrideOnce(d: => Result): FoldContext[Result]
}
object FoldContext {
  def init[Result]: FoldContext[Result] = new EmptyFoldContext
}

class EmptyFoldContext[Result] extends FoldContext[Result] {
  override def default(d: => Result): Result                   = d
  override def option: None.type                               = None
  override def overrideOnce(d: => Result): FoldContext[Result] = new FinishedFoldContext(d)
}
class FinishedFoldContext[Result](val value: Result) extends FoldContext[Result] {
  override def default(d: => Result): Result                   = value
  override def option: Some[Result]                            = Some(value)
  override def overrideOnce(d: => Result): FoldContext[Result] = this
}

trait NatFunc
trait NatFuncPositive[Data, T <: NatFunc] extends NatFunc {
  def foldImpl[Result](d: Data => Result, fc: FoldContext[Result]): (T, FoldContext[Result])
}

class IsFinishAndNothing {
  lazy val isFinishAndNothing: IsFinishAndNothing = this
}
object IsFinishAndNothing extends IsFinishAndNothing

case class LeftFunc[Data, T <: NatFunc](tail: T) extends NatFuncPositive[Data, T] {
  override def foldImpl[Result](d: Data => Result, fc: FoldContext[Result]): (T, FoldContext[Result]) = (tail, fc)
}
case class RightFunc[Data, T <: NatFunc](data: Data, tail: T) extends NatFuncPositive[Data, T] {
  override def foldImpl[Result](d: Data => Result, fc: FoldContext[Result]): (T, FoldContext[Result]) = (tail, fc.overrideOnce(d(data)))
}
class NatFuncZero extends NatFuncPositive[IsFinishAndNothing.type, NatFuncZero] {
  def foldImpl[Result](d: IsFinishAndNothing.type => Result, fc: FoldContext[Result]): (NatFuncZero, FoldContext[Result]) =
    (this, fc.overrideOnce(d(IsFinishAndNothing)))
}
object NatFuncZero extends NatFuncZero

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
    val (p1_1, p1_2) = (p1, FoldContext.init[List[Int]])
    val (p2_1, p2_2) = p1_1.foldImpl(t => List(t), p1_2)
    val (p3_1, p3_2) = p2_1.foldImpl(t => t.map(_.size + 1), p2_2)
    val (p4_1, p4_2) = p3_1.foldImpl(t => t.map(_.toInt * 2), p3_2)
    val (p5_1, p5_2) = p4_1.foldImpl(t => t.map(_.size * 5), p4_2)
    val (p6_1, p6_2) = p5_1.foldImpl(t => t.to(List).map(_.toInt * 2), p5_2)
    val (p7_1, p7_2) = p6_1.foldImpl(
      { t =>
        t.isFinishAndNothing
        List.empty
      },
      p6_2
    )
    val (p8_1, p8_2) = p7_1.foldImpl(
      { t =>
        t.isFinishAndNothing
        List.empty
      },
      p7_2
    )
    p8_2.option
  }

  val t2 = {
    val (p1_1, p1_2) = (p2, FoldContext.init[List[Int]])
    val (p2_1, p2_2) = p1_1.foldImpl(t => List(t), p1_2)
    val (p3_1, p3_2) = p2_1.foldImpl(t => t.map(_.size + 1), p2_2)
    val (p4_1, p4_2) = p3_1.foldImpl(t => t.map(_.toInt * 2), p3_2)
    val (p5_1, p5_2) = p4_1.foldImpl(t => t.map(_.size * 5), p4_2)
    p5_2.option
  }

  val t3 = {
    val (p1_1, p1_2) = (p3, FoldContext.init[List[Int]])
    val (p2_1, p2_2) = p1_1.foldImpl(t => List(t), p1_2)
    val (p3_1, p3_2) = p2_1.foldImpl(t => t.map(_.size + 1), p2_2)
    val (p4_1, p4_2) = p3_1.foldImpl(t => t.map(_.toInt * 2), p3_2)
    p4_2.option
  }

  val t4 = {
    val (p1_1, p1_2) = (p4, FoldContext.init[List[Int]])
    val (p2_1, p2_2) = p1_1.foldImpl(t => List(t), p1_2)
    val (p3_1, p3_2) = p2_1.foldImpl(t => t.map(_.size + 1), p2_2)
    val (p4_1, p4_2) = p3_1.foldImpl(t => t.map(_.toInt * 2), p3_2)
    val (p5_1, p5_2) = p4_1.foldImpl(t => t.map(_.size * 5), p4_2)
    p5_2.option
  }

  val t5 = {
    val (p1_1, p1_2) = (p5, FoldContext.init[List[Int]])
    val (p2_1, p2_2) = p1_1.foldImpl(t => List(t), p1_2)
    val (p3_1, p3_2) = p2_1.foldImpl(t => t.map(_.size + 1), p2_2)
    val (p4_1, p4_2) = p3_1.foldImpl(t => t.map(_.toInt * 2), p3_2)
    val (p5_1, p5_2) = p4_1.foldImpl(t => t.map(_.size * 5), p4_2)
    p5_2.option
  }

  println(t1) // Some(List(4, 6, 10, 16))
  println(t2) // Some(List(4, 6, 10, 16))
  println(t3) // Some(List(4, 6, 10, 16))
  println(t4) // None
  println(t5) // Some(List(4, 11, 15))

}
