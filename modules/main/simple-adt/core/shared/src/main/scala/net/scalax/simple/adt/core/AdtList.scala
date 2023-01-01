package net.scalax.simple.adt.core

trait AdtList {
  def method1[T](m: FoldList[T], fold: Nothing => T): T
}
class AdtListPositive(tail: AdtList) extends AdtList {
  override def method1[T](m: FoldList[T], fold: Nothing => T): T = m.method2(tail)
}
class AdtListZero(value: Any) extends AdtList {
  override def method1[T](m: FoldList[T], fold: Nothing => T): T = fold.asInstanceOf[Any => T](value)
}
class AdtListException(tail: () => AdtList) extends AdtList {
  override def method1[T](m: FoldList[T], fold: Nothing => T): T = m.method2(tail())
}
object AdtList {
  lazy val exception: AdtList = new AdtListException(() => exception)
}

// ====
trait FoldList[T] {
  def method2(m: AdtList): T
}
class FoldListPositive[T](tail: FoldList[T], fold: Nothing => T) extends FoldList[T] {
  override def method2(m: AdtList): T = m.method1(tail, fold)
}
class FoldListZero[T](tail: () => FoldList[T]) extends FoldList[T] {
  override def method2(m: AdtList): T = tail().method2(m)
}
object FoldList {
  lazy val zeroImpl: FoldList[Any] = new FoldListZero[Any](() => zeroImpl)
  def zero[T]: FoldList[T]         = zeroImpl.asInstanceOf[FoldList[T]]
}
