package net.scalax.simple.nat.injection

trait NeedFutureS extends NeedFuture {
  def future: NeedPassS
}

trait NeedPassS extends NeedPass {
  def pass: NeedFutureS
}
