package net.scalax.simple.nat.injection

trait ListData[+T] extends ListSize {
  def get(i: Int): Option[T]
}
trait ListDataPositive[+T] extends ListData[T] with ListSizePositive {
  def data: T
  override val tail: () => ListData[T]
  override def get(i: Int): Option[T] = {
    assert(i <= index)

    if (i == index)
      Option(data)
    else
      tail().get(i)
  }
}
trait ListDataZero[+T] extends ListData[T] with ListSizeZero {
  override def get(i: Int): Option[T] = Option.empty
}
