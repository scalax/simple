package net.scalax.simple.nat.injection

trait NeedFutureS extends NeedFuture {
  def future: NeedPass
}

trait NeedPassS extends NeedPass {
  def pass: NeedFuture
}
