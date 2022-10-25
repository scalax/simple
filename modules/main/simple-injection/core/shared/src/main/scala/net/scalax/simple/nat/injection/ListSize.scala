package net.scalax.simple.nat.injection

trait ListSize extends Number1S {
  def isEmpty: Boolean = size == 0
  def size: Int
}
trait ListSizePositive extends ListSize with Number1T {
  override val tail: () => ListSize
  override def size: Int = tail().size + 1
  def index: Int         = size - 1
}
trait ListSizeZero extends ListSize {
  override val size: Int = 0
}
