package net.scalax.simple.nat.injection

import impl._
import scala.collection.compat._

trait ListData[+T] extends ListSize {
  def resetPass[D >: T](t: SimpleListNeedPass[D]): SimpleListNeedFuture[D]
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
        if (dt.isDefined) {
          curr += 1
          dt.get
        } else
          throw new NoSuchElementException
      }
    }
  }
}

object ListData {
  def apply[T](elems: T*): ListData[T]      = ListDataImpl(elems: _*)
  def unapplySeq[T](u: ListData[T]): Seq[T] = u.to(Seq)
}
trait ListDataPositive[+T] extends ListData[T] with ListSizePositive {
  override def resetPass[D >: T](needPass: SimpleListNeedPass[D]): SimpleListNeedFuture[D] = {
    val tail1 = tail
    lazy val simpleInner: SimpleInner[D] = new SimpleInner[D](data) {
      override val tail: () => SimpleListNeedFuture[D] = () => tail1().resetPass(simpleInner)
      override val future: () => SimpleListNeedPass[D] = () => needPass
    }
    simpleInner
  }
  def data: T
  override val tail: () => ListData[T]
  override def get(i: Int): Option[T] = {
    if (i == index)
      Option(data)
    else if (i < index)
      tail().get(i)
    else Option.empty
  }
}

trait ListDataZero[+T] extends ListData[T] with ListSizeZero {
  override def resetPass[D >: T](needPass: SimpleListNeedPass[D]): SimpleListNeedFuture[D] = new SimpleZeroImpl[D] {
    override val future: () => SimpleListNeedPass[D] = () => needPass
  }
  override def get(i: Int): Option[T] = Option.empty
}
