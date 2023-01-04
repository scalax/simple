package net.scalax.simple.adt.core

trait AdtList {
  def method1(m: FoldList): FoldList
}
class AdtListPositive(tail: AdtList) extends AdtList {
  override def method1(m: FoldList): FoldList = m.method2(tail)
}
abstract class AdtListZero extends AdtList {
  override def method1(m: FoldList): FoldList
}
class AdtListException(tail: () => AdtList) extends AdtList {
  override def method1(m: FoldList): FoldList = m.method2(tail())
}
object AdtList {
  lazy val exception: AdtList = new AdtListException(() => exception)
}

// ====
trait FoldList {
  def method2(m: AdtList): FoldList
}
class FoldListPositive(tail: FoldList) extends FoldList {
  override def method2(m: AdtList): FoldList = m.method1(tail)
}
class FoldListZero(tail: () => FoldList) extends FoldList {
  override def method2(m: AdtList): FoldList = tail().method2(m)
}
object FoldList {
  lazy val zero: FoldList = new FoldListZero(() => zero)
}
