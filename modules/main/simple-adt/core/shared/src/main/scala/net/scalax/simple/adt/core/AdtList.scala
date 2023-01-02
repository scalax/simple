package net.scalax.simple.adt.core

trait AdtList {
  def method1(m: FoldList): Any
}
class AdtListPositive(tail: AdtList) extends AdtList {
  override def method1(m: FoldList): Any = m.method2(tail)
}
abstract class AdtListZero extends AdtList {
  override def method1(m: FoldList): Any
}
class AdtListException(tail: () => AdtList) extends AdtList {
  override def method1(m: FoldList): Any = m.method2(tail())
}
object AdtList {
  lazy val exception: AdtList = new AdtListException(() => exception)
}

// ====
trait FoldList {
  def method2(m: AdtList): Any
}
class FoldListPositive(tail: FoldList) extends FoldList {
  override def method2(m: AdtList): Any = m.method1(tail)
}
class FoldListZero(tail: () => FoldList) extends FoldList {
  override def method2(m: AdtList): Any = tail().method2(m)
}
object FoldList {
  lazy val zero: FoldList = new FoldListZero(() => zero)
}
