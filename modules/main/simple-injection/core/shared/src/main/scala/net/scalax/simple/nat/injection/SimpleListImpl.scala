package net.scalax.simple.nat.injection

trait SimpleListNeedFutureImpl[+T] extends LengthNeedFuture {
  override def future: SimpleListNeedPassImpl[T]
}

trait SimpleListNeedFutureZero[+T] extends LengthNeedFutureS with SimpleListNeedFutureImpl[T] {
  override def future: SimpleListNeedPassImpl[T]
}

trait SimpleListNeedPassImpl[+T] extends LengthNeedPass {
  override def pass: SimpleListNeedFutureImpl[T]
  def data: T
}

trait SimpleListCurrentImpl[+T] extends SimpleListNeedFutureImpl[T] with SimpleListNeedPassImpl[T] with LengthCurrent {
  override def data: T
  override def pass: SimpleListNeedFutureImpl[T]
  override def future: SimpleListNeedPassImpl[T]
}
