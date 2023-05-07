package net.scalax.simple.adt.implemention

import net.scalax.simple.adt.factory.AdtCoreFactory
import net.scalax.simple.ghdmzsk.ghdmzsk

sealed trait CoProductFunc[Result]

object CoProductFunc {
  class BuildContext[U] {
    def appendSuccess[Data, T <: CoProductFunc[U]](data: Data): CoProductFuncPositive[Data, T, U] = new RightFunc[Data, T, U](data)
    def appendFailed[Data, T <: CoProductFunc[U]](tail: T): CoProductFuncPositive[Data, T, U]     = new LeftFunc[Data, T, U](tail)
    def end: CoProductFunc[U]                                                                     = new EmptyEnd[U]
  }

  def context[T]: BuildContext[T] = new BuildContext[T]
}

sealed trait CoProductFuncPositive[Data, T <: CoProductFunc[Result], Result] extends CoProductFunc[Result] {
  def foldImpl(d: Data => Result): T
}
sealed trait CoProductFuncZero[Result] extends CoProductFunc[Result] {
  def default(d: => Result): Result
  def option: Option[Result]
}

class LeftFunc[Data, T <: CoProductFunc[Result], Result](val tail: T) extends CoProductFuncPositive[Data, T, Result] {
  override def foldImpl(d: Data => Result): T = tail
}
class RightFunc[Data, T <: CoProductFunc[Result], Result](val data: Data) extends CoProductFuncPositive[Data, T, Result] {
  override def foldImpl(d: Data => Result): T = new EndFunc[Data, T, Result](d(data)).asInstanceOf[T]
}
class EndFunc[Data, T <: CoProductFunc[Result], Result](val result: Result)
    extends CoProductFuncPositive[Data, T, Result]
    with CoProductFuncZero[Result] {
  override def foldImpl(d: Data => Result): T = this.asInstanceOf[T]
  override def default(d: => Result): Result  = result
  override def option: Some[Result]           = Some(result)
}
class EmptyEnd[Result] extends CoProductFuncZero[Result] {
  override def default(d: => Result): Result = d
  override def option: None.type             = None
}

object Test extends App {

  type Ux1 = CoProductFuncPositive[
    Int,
    CoProductFuncPositive[
      List[String],
      CoProductFuncPositive[List[Long], CoProductFuncPositive[List[String], CoProductFuncZero[List[Int]], List[Int]], List[Int]],
      List[Int]
    ],
    List[Int]
  ]

  val bContext = CoProductFunc.context[List[Int]]

  val p: Ux1 = bContext.appendFailed(bContext.appendFailed(bContext.appendSuccess(List(2L, 3L, 5L, 8L))))

  val t =
    p.foldImpl(t => List(t)).foldImpl(t => t.map(_.size + 1)).foldImpl(t => t.map(_.toInt * 2)).foldImpl(t => t.map(_.size * 5)).option

  println(t)

}
