package net.scalax.simple.nat.injection

import scala.collection.compat.*

trait ListDataInit[+T] extends ListData[T] with ListSize {
  def get(i: Int): Option[T]
  def to[C1](factory: scala.collection.compat.Factory[T, C1]): C1 = factory.fromSpecific(iterator)
  def iterator: IterableOnce[T] = {
    val currentSelf = this
    var curr: Int   = 0

    def size1: Int = size

    new Iterator[T] {
      override def size: Int = size1

      override def hasNext: Boolean = curr < size1

      override def next(): T = {
        val dt = currentSelf.get(curr)
        if dt.isDefined then {
          curr += 1
          dt.get
        } else throw new NoSuchElementException
      }
    }
  }
}
object ListDataInit {
  def unapplySeq[T](u: ListDataInit[T]): Seq[T] = u.to(Seq)
}

trait ListDataInitPositive[+T] extends ListDataInit[T] with ListDataPositive[T] with ListSizePositive {
  override def data: T
  override val tail: () => ListDataInit[T]
  override def get(i: Int): Option[T] = {
    if i == index then Option(data)
    else if i < index then tail().get(i)
    else Option.empty
  }
}

trait ListDataInitZero[+T] extends ListDataInit[T] with ListSizeZero {
  override def get(i: Int): Option[T] = Option.empty
}
