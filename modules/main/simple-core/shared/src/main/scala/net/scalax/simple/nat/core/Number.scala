package net.scalax.simple.nat.core

trait NumberParent
trait NumberChild extends NumberParent {
  val tail: () => NumberParent
}

trait NeedFuture {
  val future: () => NeedPass
}
trait NeedPass {
  val tail: () => NeedFuture
}

trait Current extends NeedFuture with NeedPass {
  override val future: () => NeedPass
  override val tail: () => NeedFuture

}

trait Number3SS extends NeedFuture with NumberParent {
  override val future: () => Number3TS
}
trait Number3TS extends NumberChild with NeedPass {
  override val tail: () => Number3SS
}
trait Number3ST extends Current with Number3TS with Number3SS {
  override val tail: () => Number3SS
  override val future: () => Number3TS
}
