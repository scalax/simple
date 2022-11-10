package net.scalax.simple.nat.injection

import impl._

trait ListDataImpl[+T] extends ListData[T] {
  def toSimpleList: SimpleList[T]
}
object ListDataImpl {
  def apply[T](elems: T*): ListDataImpl[T] = {
    var init: ListDataImpl[T] = ListDataZeroImpl
    for (e <- elems) {
      val curr = init
      init = ListDataPositiveImpl(() => curr, e)
    }
    init
  }
  def unapplySeq[T](u: ListDataImpl[T]): Seq[T] = ListData.unapplySeq(u)
}

case class ListDataPositiveImpl[+T](override val tail: () => ListData[T], override val data: T)
    extends ListDataPositive[T]
    with ListDataImpl[T] {
  override def toSimpleList: SimpleList[T] = {
    val tail1                                 = tail
    lazy val listPre: SimpleListNeedFuture[T] = tail1().resetPass(listCurr)
    lazy val listCurr: SimpleOut[T] = new SimpleOut(data) {
      override val tail: () => SimpleListNeedFuture[T] = () => listPre
    }
    listCurr
  }
}
case object ListDataZeroImpl extends ListDataZero[Nothing] with ListDataImpl[Nothing] {
  override def toSimpleList: SimpleList[Nothing] = SimpleZero
}
