package net.scalax.simple.injection

import impl._
import scala.collection.compat._

trait ListDataReset[+T] extends ListData[T] {
  override val child: () => ListDataReset[T]
  def resetPass[D >: T](t: SimpleListNeedPass[D]): SimpleListNeedFuture[D]
}

trait ListDataResetPositive[+T] extends ListDataPositive[T] with ListDataReset[T] {
  override def resetPass[D >: T](needPass: SimpleListNeedPass[D]): SimpleListNeedFuture[D] = {
    val tail1 = child
    lazy val simpleInner: SimpleInner[D] = new SimpleInner[D](data) {
      override val pass: () => SimpleListNeedFuture[D] = () => tail1().resetPass(simpleInner)
      override val future: () => SimpleListNeedPass[D] = () => needPass
    }
    simpleInner
  }
  override def data: T
  override val child: () => ListDataReset[T]
}

trait ListDataResetZero[+T] extends ListData[T] with ListDataReset[T] {
  override def resetPass[D >: T](needPass: SimpleListNeedPass[D]): SimpleListNeedFuture[D] = {
    lazy val zero: SimpleZeroImpl[D] = new SimpleZeroImpl[D] {
      override val child: () => SimpleList[D]          = () => zero
      override val future: () => SimpleListNeedPass[D] = () => needPass
    }
    zero
  }
}
