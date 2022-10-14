package net.scalax.simple.nat.injection

trait LengthNeedFuture extends NeedFutureS {
  override def future: LengthNeedPass

  def size: Int

}
trait LengthNeedFutureS extends LengthNeedFuture {
  override def future: LengthNeedPass
}

trait LengthNeedPass extends NeedPassS {
  def length: Int
  def index: Int
  override def pass: LengthNeedFuture
}

trait LengthCurrent extends LengthNeedFuture with LengthNeedPass {
  override def future: LengthNeedPass
  override def pass: LengthNeedFuture
  override def size: Int   = pass.size + 1
  override def index: Int  = future.index - 1
  override def length: Int = future.length
}
