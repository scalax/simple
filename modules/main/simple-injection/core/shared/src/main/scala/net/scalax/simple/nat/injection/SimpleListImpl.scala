package net.scalax.simple.nat.injection

trait SimpleListSImpl[+T] extends LengthNumber1 {
  override def num2: SimpleListAddImpl[T]
  def get(i: Int): Option[T] = num2.get(i)
}

trait SimpleListZero[+T] extends LengthNumber1S with SimpleListSImpl[T] {
  override def num2: SimpleListAddImpl[T]
  override def get(i: Int): Option[T] = Option.empty
}

trait SimpleListAddImpl[+T] extends LengthNumber2 {
  override def num1: SimpleListSImpl[T]
  def data: T
  def get(i: Int): Option[T] = if (i == index) Option(data) else Option.empty
}

trait SimpleListImpl[+T] extends SimpleListSImpl[T] with SimpleListAddImpl[T] with SimpleLengthNumber {
  override def data: T
  override def num1: SimpleListSImpl[T]
  override def num2: SimpleListAddImpl[T]
  override def get(i: Int): Option[T] =
    if (i == index) Option(data)
    else if (i < index)
      num1.get(i)
    else num2.get(i)
}
