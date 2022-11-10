package net.scalax.simple.nat.injection

trait LengthNeedFuture extends NeedFuture {
  override val future: () => LengthNeedPass
}

trait LengthNeedPass extends NeedPass {
  def length: Int
  override val tail: () => LengthNeedFuture
}

trait LengthCurrent extends Current with LengthNeedFuture with LengthNeedPass {
  override val future: () => LengthNeedPass
  override val tail: () => LengthNeedFuture
  override def length: Int = future().length
}
