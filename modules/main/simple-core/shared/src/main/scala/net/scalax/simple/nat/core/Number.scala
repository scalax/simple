package net.scalax.simple.nat.core

trait NumberParent {
  val child: () => NumberParent
}

object NumberParent {
  def isZero(input: NumberParent): Boolean = input.child() eq input
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

/*trait Number3 extends Current with NumberParent {
  override val future: () => NeedPass
  override val pass: () => NeedFuture
  override val child: () => Number3
}*/
