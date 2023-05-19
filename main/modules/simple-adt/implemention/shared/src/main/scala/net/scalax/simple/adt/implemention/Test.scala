package net.scalax.simple.adt.implemention

import scala.collection.compat._

trait FoldContext[+Result] {
  def option: Option[Result]
  def overrideOnce[U >: Result](d: => Option[U]): FoldContext[U]
}
object FoldContext {
  val empty: FoldContext[Nothing] = EmptyFoldContext

  private object EmptyFoldContext extends FoldContext[Nothing] {
    override val option: None.type = None
    override def overrideOnce[U](d: => Option[U]): FoldContext[U] = {
      val v = for (dValue <- d) yield new FinishedFoldContext(dValue)
      v.getOrElse(this)
    }
  }
  private class FinishedFoldContext[+Result](val value: Result) extends FoldContext[Result] {
    override def option: Some[Result]                                       = Some(value)
    override def overrideOnce[U >: Result](d: => Option[U]): FoldContext[U] = this
  }
}

trait NatFunc
trait NatFuncPositive[Data, T <: NatFunc] extends NatFunc {
  def tail: T
  def foldImpl[Result](d: Data => Result): Option[Result]
}

final class IsFinishAndNothing private (tail: () => IsFinishAndNothing) {
  lazy val isFinishAndNothing: IsFinishAndNothing = tail()
}
object IsFinishAndNothing {
  lazy val value: IsFinishAndNothing = new IsFinishAndNothing(() => value)
}

case class LeftFunc[Data, T <: NatFunc](override val tail: T) extends NatFuncPositive[Data, T] {
  override def foldImpl[Result](d: Data => Result): None.type = None
}
case class RightFunc[Data, T <: NatFunc](data: Data, override val tail: T) extends NatFuncPositive[Data, T] {
  override def foldImpl[Result](d: Data => Result): Some[Result] = Some(d(data))
}

final class NatFuncZero private (tailValue: () => NatFuncZero) extends NatFuncPositive[IsFinishAndNothing, NatFuncZero] {
  override lazy val tail: NatFuncZero                                          = tailValue()
  override def foldImpl[Result](d: IsFinishAndNothing => Result): Some[Result] = Some(d(IsFinishAndNothing.value))
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

  val p1: Ux1 = LeftFunc(LeftFunc(RightFunc(List(2L, 3L, 5L, 8L), LeftFunc(LeftFunc(NatFuncZero.value)))))
  val p2: Ux2 = LeftFunc(LeftFunc(RightFunc(List(2L, 3L, 5L, 8L), LeftFunc(NatFuncZero.value))))
  val p3: Ux3 = LeftFunc(LeftFunc(RightFunc(List(2L, 3L, 5L, 8L), NatFuncZero.value)))
  val p4: Ux2 = LeftFunc(LeftFunc(LeftFunc(LeftFunc(NatFuncZero.value))))
  val p5: Ux2 = LeftFunc(RightFunc(List("abc", "abcdefghij", "abcdefghijklmn"), LeftFunc(LeftFunc(NatFuncZero.value))))

  val t1 = FoldContext.empty
    .overrideOnce(p1.foldImpl(t => List(t)))
    .overrideOnce(p1.tail.foldImpl(t => t.map(_.size + 1)))
    .overrideOnce(p1.tail.tail.foldImpl(t => t.map(_.toInt * 2)))
    .overrideOnce(p1.tail.tail.tail.foldImpl(t => t.map(_.size * 5)))
    .overrideOnce(p1.tail.tail.tail.tail.foldImpl(t => t.to(List).map(_.toInt * 2)))
    .overrideOnce(
      p1.tail.tail.tail.tail.tail.foldImpl(
        { t =>
          t.isFinishAndNothing
          List.empty
        }
      )
    )
    .overrideOnce(
      p1.tail.tail.tail.tail.tail.tail.foldImpl(
        { t =>
          t.isFinishAndNothing
          List.empty
        }
      )
    )
    .option

  val t2 = FoldContext.empty
    .overrideOnce(p2.foldImpl(t => List(t)))
    .overrideOnce(p2.tail.foldImpl(t => t.map(_.size + 1)))
    .overrideOnce(p2.tail.tail.foldImpl(t => t.map(_.toInt * 2)))
    .overrideOnce(p2.tail.tail.tail.foldImpl(t => t.map(_.size * 5)))
    .option

  val t3 = FoldContext.empty
    .overrideOnce(p3.foldImpl(t => List(t)))
    .overrideOnce(p3.tail.foldImpl(t => t.map(_.size + 1)))
    .overrideOnce(p3.tail.tail.foldImpl(t => t.map(_.toInt * 2)))
    .option

  val t4 = FoldContext.empty
    .overrideOnce(p4.foldImpl(t => List(t)))
    .overrideOnce(p4.tail.foldImpl(t => t.map(_.size + 1)))
    .overrideOnce(p4.tail.tail.foldImpl(t => t.map(_.toInt * 2)))
    .overrideOnce(p4.tail.tail.tail.foldImpl(t => t.map(_.size * 5)))
    .option

  val t5 = FoldContext.empty
    .overrideOnce(p5.foldImpl(t => List(t)))
    .overrideOnce(p5.tail.foldImpl(t => t.map(_.size + 1)))
    .overrideOnce(p5.tail.tail.foldImpl(t => t.map(_.toInt * 2)))
    .overrideOnce(p5.tail.tail.tail.foldImpl(t => t.map(_.size * 5)))
    .option

  println(t1) // Some(List(4, 6, 10, 16))
  println(t2) // Some(List(4, 6, 10, 16))
  println(t3) // Some(List(4, 6, 10, 16))
  println(t4) // None
  println(t5) // Some(List(4, 11, 15))

}
