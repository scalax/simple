package net.scalax.simple.nat.injection

trait ListData[+T] extends NumberParent

trait ListDataPositive[+T] extends ListData[T] with NumberChild {
  def data: T
  override val tail: () => ListData[T]
}
