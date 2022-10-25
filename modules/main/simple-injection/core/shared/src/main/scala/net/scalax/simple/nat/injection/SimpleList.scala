package net.scalax.simple.nat.injection

import scala.collection.compat._

trait SimpleList[+T] extends Number1S with ListData[T] {
  override def isEmpty: Boolean = super.isEmpty
  def getSelf: SimpleList[T]
  def dataStruct: Option[(T, SimpleList[T])]
  override def get(i: Int): Option[T]
  override def size: Int
  def length: Int
  def add[D >: T](d: D): SimpleList[D]
  def cut: SimpleList[T]
  def to[C1](factory: scala.collection.compat.Factory[T, C1]): C1 = factory.fromSpecific(iterator)
  def iterator: IterableOnce[T] = {
    val currentSelf = this
    var curr: Int   = 0

    def size1: Int = size

    new Iterator[T] {
      override def size: Int        = size1
      override def hasNext: Boolean = curr < size1

      override def next(): T = {
        val dt = currentSelf.get(curr)
        if (dt.isDefined) {
          curr += 1
          dt.get
        } else
          throw new NoSuchElementException
      }
    }
  }

  @throws[IndexOutOfBoundsException]
  def apply(n: Int): T = {
    if (n < 0) throw new IndexOutOfBoundsException(n.toString)
    val skipped = this.get(n)
    if (skipped.isEmpty) throw new IndexOutOfBoundsException(n.toString)
    skipped.get
  }
}

object SimpleList {
  def apply[T](elems: T*): SimpleList[T] = {
    var init: SimpleList[T] = SimpleZero
    for (e <- elems) init = init.add(e)
    init
  }
  def unapplySeq[T](u: SimpleList[T]): Seq[T] = u.to(Seq)
}

abstract class SimpleZero[+T] extends SimpleList[T] with ListSizeZero {
  override val dataStruct: Option[(T, SimpleList[T])] = Option.empty
  override def cut: SimpleList[T]                     = SimpleZero
  override def equals(obj: Any): Boolean = obj match {
    case t: SimpleList[_] => t.isEmpty
    case _                => false
  }
}

case object SimpleZero extends SimpleZero[Nothing] with impl.SimpleZeroImplObject

abstract class SimplePositive[+T](override val data: T) extends SimpleList[T] with Number1T with ListDataPositive[T] {
  override val tail: () => SimpleList[T]
  override def dataStruct: Option[(T, SimpleList[T])] = Option((data, tail()))
}
object SimplePositive {
  def unapply[T](u: SimpleList[T]): Option[(T, SimpleList[T])] = u.dataStruct
}

trait SimpleListNeedFuture[+T] extends LengthNeedFuture with SimpleList[T] with Number3SS {
  override val future: () => SimpleListNeedPass[T]
  def resetPass[D >: T](t: SimpleListNeedPass[D]): SimpleListNeedFuture[D]
}
abstract class SimpleListNeedPass[+T](data: T) extends SimplePositive[T](data) with LengthNeedPass with Number3TT {
  override val pass: () => SimpleListNeedFuture[T]
  override val tail: () => SimpleListNeedFuture[T] = () => pass()
}
