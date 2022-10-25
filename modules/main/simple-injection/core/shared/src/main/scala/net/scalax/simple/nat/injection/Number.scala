package net.scalax.simple.nat.injection

trait Number1S
trait Number1T extends Number1S {
  val tail: () => Number1S
}

trait NeedFuture {
  val future: () => NeedPass
}
trait NeedPass {
  val pass: () => NeedFuture
}

trait Current extends NeedFuture with NeedPass {
  override val future: () => NeedPass
  override val pass: () => NeedFuture

}

trait Number3SS extends Number1S with NeedFuture {
  override val future: () => Number3TS
}
trait Number3TS extends Number1S with NeedPass {
  override val pass: () => Number3SS
}
trait Number3ST extends Number1T with Number3SS {
  override val tail: () => Number1S
  override val future: () => Number3TS
}
trait Number3TT extends Number1T with Number3TS {
  override val tail: () => Number1S
  override val pass: () => Number3SS
}

trait Number3Current extends Number3ST with Number3TT {
  override val tail: () => Number1S
  override val future: () => Number3TT
  override val pass: () => Number3SS
}
