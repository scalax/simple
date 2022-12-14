package net.scalax.simple.injection

import impl._

trait ListDataImpl[+T] extends ListData[T] with ListDataReset[T] {
  override val child: () => ListDataImpl[T]
  def toSimpleList: SimpleList[T]
}
object ListDataImpl {
  def apply[T](elems: T*): ListDataImpl[T] = {
    var init: ListDataImpl[T] = zero
    for (e <- elems) {
      val curr = init
      init = ListDataPositiveImpl(() => curr, e)
    }
    init
  }

  lazy val zero: ListDataImpl[Nothing] = new ListDataZeroImpl {
    override val child: () => ListDataImpl[Nothing] = () => zero
  }
}

case class ListDataPositiveImpl[+T](override val child: () => ListDataImpl[T], override val data: T)
    extends ListDataPositive[T]
    with ListDataResetPositive[T]
    with ListDataImpl[T] {
  override def toSimpleList: SimpleList[T] = {
    val tail1                                 = child
    lazy val listPre: SimpleListNeedFuture[T] = tail1().resetPass(listCurr)
    lazy val listCurr: SimpleOut[T] = new SimpleOut(data) {
      override val pass: () => SimpleListNeedFuture[T] = () => listPre
    }
    listCurr
  }
}
trait ListDataZeroImpl extends ListDataImpl[Nothing] with ListDataResetZero[Nothing] {
  override val child: () => ListDataImpl[Nothing]
  override def toSimpleList: SimpleList[Nothing] = SimpleZero.value
}
