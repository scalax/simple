package net.scalax.simple.nat.injection

trait LengthNeedFuture extends NeedFutureS {
  def size: Int
  override def future: LengthNeedPass
}
trait LengthNeedFutureS extends LengthNeedFuture {
  override def future: LengthNeedPass
  override def size: Int = 0
}

trait LengthNeedPass extends NeedPassS {
  def index: Int = pass.size
  override def pass: LengthNeedFuture
}

trait LengthCurrent extends LengthNeedFuture with LengthNeedPass {
  override def future: LengthNeedPass
  override def pass: LengthNeedFuture
  override def size: Int  = pass.size + 1
  override def index: Int = future.index - 1
}

trait SimpleLengthCurrent extends LengthCurrent {
  override def index: Int = size - 1
}
