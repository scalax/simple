package net.scalax.simple.nat.injection

trait SimpleList[T] {
  def dataStruct: Option[(T, SimpleList[T])]
  def get(i: Int): Option[T]
  def size: Int
  def add(d: T): SimpleList[T]
}
object SimpleList {
  def apply[T](elems: T*): SimpleList[T] = {
    var init: SimpleList[T] = SimpleZero()
    for (e <- elems) init = init.add(e)
    init
  }
  def unapplySeq[T](u: SimpleList[T]): Seq[T] = {
    var seq: Seq[T]       = Seq.empty
    var u1: SimpleList[T] = u
    while (u1.dataStruct.isDefined) {
      val current = u1.dataStruct.get
      seq = current._1 +: seq
      u1 = current._2
    }
    seq
  }
}

abstract class SimpleZero[T] extends SimpleList[T] {
  override val dataStruct: Option[(T, SimpleList[T])] = Option.empty
}
class SimpleZeroSingleton[T] extends SimpleZero[T] with impl.SimpleZeroImplObject[T]
object SimpleZero {
  def apply[T](): SimpleList[T]                = new SimpleZeroSingleton
  def unapply(u: SimpleList[Nothing]): Boolean = u.dataStruct.isEmpty
}

abstract class SimplePositive[T](data: T) extends SimpleList[T] {
  def tail: SimpleList[T]
  override def dataStruct: Option[(T, SimpleList[T])] = Option((data, tail))
}
object SimplePositive {
  def unapply[T](u: SimpleList[T]): Option[(T, SimpleList[T])] = u.dataStruct
}

trait SimpleListNeedFuture[T] extends SimpleListNeedFutureImpl[T] with SimpleList[T] {
  override def future: SimpleListNeedPass[T]

  // def addNext: T => SimpleListNeedFuture[T]

}
trait SimpleListNeedPass[T] extends SimpleListNeedPassImpl[T] with SimpleList[T] {
  override def pass: SimpleListNeedFuture[T]

  // def addPre: T => SimpleNeedPass[T]

}
