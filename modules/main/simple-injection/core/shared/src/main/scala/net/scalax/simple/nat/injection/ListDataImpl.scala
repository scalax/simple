package net.scalax.simple.nat.injection

import impl._

trait ListDataImpl[+T] extends ListData[T] with ListDataReset[T] {
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
}

case class ListDataPositiveImpl[+T](override val tail: () => ListDataImpl[T], override val data: T)
    extends ListDataPositive[T]
    with ListDataResetPositive[T]
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
case object ListDataZeroImpl extends ListDataImpl[Nothing] with ListDataResetZero[Nothing] {
  override def toSimpleList: SimpleList[Nothing] = SimpleZero
}
