package net.scalax.simple
package core

trait NumberParent {
  val child: () => NumberParent
}

object NumberParent {
  def isZero(parent: NumberParent): Boolean = parent eq parent.child()
}

trait NeedFuture {
  val future: () => NeedPass
}

trait NeedPass {
  val pass: () => NeedFuture
}
