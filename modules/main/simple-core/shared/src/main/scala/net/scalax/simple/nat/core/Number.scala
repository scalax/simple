package net.scalax.simple.nat.core

trait NumberParent {
  val child: () => NumberParent
}

trait NeedFuture {
  val future: () => NeedPass
}
trait NeedPass {
  val pass: () => NeedFuture
}

abstract class YYZero extends NumberChild with NeedFuture with NeedPass {
  override val tail: () => YYZero
  override val future: () => YYZero
}

object YYZero {
  lazy val value: YYZero = new YYZero {
    override val tail: () => YYZero   = () => value
    override val future: () => YYZero = () => value
  }
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
