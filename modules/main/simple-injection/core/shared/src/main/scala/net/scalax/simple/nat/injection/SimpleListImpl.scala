package net.scalax.simple.nat.injection

trait SimpleListNeedFutureImpl[+T] extends LengthNeedFuture {
  override def future: SimpleListNeedPassImpl[T]
  def get(i: Int): Option[T] = future.get(i)
}

trait SimpleListNeedFutureZero[+T] extends LengthNeedFutureS with SimpleListNeedFutureImpl[T] {
  override def future: SimpleListNeedPassImpl[T]
  override def get(i: Int): Option[T] = Option.empty
}

trait SimpleListNeedPassImpl[+T] extends LengthNeedPass {
  override def pass: SimpleListNeedFutureImpl[T]
  def data: T
  def get(i: Int): Option[T] = if (i == index) Option(data) else Option.empty
}

trait SimpleListCurrentImpl[+T] extends SimpleListNeedFutureImpl[T] with SimpleListNeedPassImpl[T] with SimpleLengthCurrent {
  override def data: T
  override def pass: SimpleListNeedFutureImpl[T]
  override def future: SimpleListNeedPassImpl[T]
  override def get(i: Int): Option[T] =
    if (i == index) Option(data)
    else if (i < index)
      pass.get(i)
    else future.get(i)
}
