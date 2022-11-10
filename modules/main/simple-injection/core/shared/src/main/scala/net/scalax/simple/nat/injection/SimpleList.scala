package net.scalax.simple.nat.injection

trait SimpleList[+T] extends NumberParent with ListData[T] {
  override def isEmpty: Boolean = super.isEmpty
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
  def unapplySeq[T](u: SimpleList[T]): Seq[T] = ListData.unapplySeq(u)
}

abstract class SimpleZero[+T] extends SimpleList[T] with ListSizeZero with ListDataZero[T] {
  override val dataStruct: Option[(T, SimpleList[T])] = Option.empty
  override def cut: SimpleList[T]                     = SimpleZero
  override def equals(obj: Any): Boolean = obj match {
    case t: SimpleList[_] => t.isEmpty
    case _                => false
  }
}

case object SimpleZero extends SimpleZero[Nothing] with impl.SimpleZeroImplObject

abstract class SimplePositive[+T](override val data: T) extends SimpleList[T] with NumberChild with ListDataPositive[T] {
  override val tail: () => SimpleList[T]
  override def dataStruct: Option[(T, SimpleList[T])] = Option((data, tail()))
}
object SimplePositive {
  def unapply[T](u: SimpleList[T]): Option[(T, SimpleList[T])] = u.dataStruct
}

trait SimpleListNeedFuture[+T] extends LengthNeedFuture with SimpleList[T] with Number3SS {
  override val future: () => SimpleListNeedPass[T]
}
trait SimpleListNeedPass[+T] extends LengthNeedPass with SimpleList[T] with Number3TS {
  override val tail: () => SimpleListNeedFuture[T]
}
