package net.scalax.simple.nat.injection

import impl._
import scala.collection.compat._

trait ListDataReset[+T] extends ListData[T] {
  def resetPass[D >: T](t: SimpleListNeedPass[D]): SimpleListNeedFuture[D]
}

trait ListDataResetPositive[+T] extends ListDataPositive[T] with ListDataReset[T] {
  override def resetPass[D >: T](needPass: SimpleListNeedPass[D]): SimpleListNeedFuture[D] = {
    val tail1 = tail
    lazy val simpleInner: SimpleInner[D] = new SimpleInner[D](data) {
      override val tail: () => SimpleListNeedFuture[D] = () => tail1().resetPass(simpleInner)
      override val future: () => SimpleListNeedPass[D] = () => needPass
    }
    simpleInner
  }
  override def data: T
  override val tail: () => ListDataReset[T]
}

trait ListDataResetZero[+T] extends ListData[T] with ListDataReset[T] {
  override def resetPass[D >: T](needPass: SimpleListNeedPass[D]): SimpleListNeedFuture[D] = new SimpleZeroImpl[D] {
    override val future: () => SimpleListNeedPass[D] = () => needPass
  }
}
