package net.scalax.simple.nat.injection

trait NeedFuture {
  def future: NeedPass
}

trait NeedPass {
  def pass: NeedFuture
}
