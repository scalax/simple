package net.scalax.simple
package injection

import core._

trait SimpleList[+T] extends NumberParent with ListDataReset[T] with ListDataInit[T] {
  override val child: () => SimpleList[T]
  def isEmpty: Boolean = NumberParent.isZero(this)

  def getSelf: SimpleList[T]
  def dataStruct: Option[(T, SimpleList[T])]
  override def get(i: Int): Option[T]
  override def size: Int
  def length: Int
  def add[D >: T](d: D): SimpleList[D]
  def cut: SimpleList[T]

  @throws[IndexOutOfBoundsException]
  def apply(n: Int): T = {
    if (n < 0) throw new IndexOutOfBoundsException(n.toString)
    val skipped = this.get(n)
    if (skipped.isEmpty) throw new IndexOutOfBoundsException(n.toString)
    skipped.get
  }
}

object SimpleList {
  def apply[T](elems: T*): SimpleList[T]      = ListDataImpl(elems: _*).toSimpleList
  def unapplySeq[T](u: SimpleList[T]): Seq[T] = ListDataInit.unapplySeq(u)
}

abstract class SimpleZero[+T] extends SimpleList[T] with NumberParent with ListDataResetZero[T] with ListDataInitZero[T] {
  override val dataStruct: Option[(T, SimpleList[T])] = Option.empty
  override def cut: SimpleList[T]                     = SimpleZero.value
  override def equals(obj: Any): Boolean = obj match {
    case t: SimpleList[_] => t.isEmpty
    case _                => false
  }
}

case object SimpleZero {
  lazy val value: SimpleZero[Nothing] = new SimpleZero[Nothing] with impl.SimpleZeroImplObject {
    override val child: () => SimpleList[Nothing] = () => value
  }
}

abstract class SimplePositive[+T](override val data: T)
    extends SimpleList[T]
    with NumberParent
    with ListDataResetPositive[T]
    with ListDataInitPositive[T] {
  override val child: () => SimpleList[T]
  override def dataStruct: Option[(T, SimpleList[T])] = Option((data, child()))
}
object SimplePositive {
  def unapply[T](u: SimpleList[T]): Option[(T, SimpleList[T])] = u.dataStruct
}

trait SimpleListNeedFuture[+T] extends LengthNeedFuture with SimpleList[T] {
  override val future: () => SimpleListNeedPass[T]
}
trait SimpleListNeedPass[+T] extends LengthNeedPass with SimpleList[T] {
  override val pass: () => SimpleListNeedFuture[T]
  override val child: () => SimpleList[T]
}
