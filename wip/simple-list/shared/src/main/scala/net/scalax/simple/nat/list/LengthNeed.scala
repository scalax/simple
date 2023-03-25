package net.scalax.simple
package injection

import core._

trait LengthNeedFuture extends NeedFuture {
  override val future: () => LengthNeedPass
}

trait LengthNeedPass extends NeedPass {
  def length: Int
  override val pass: () => LengthNeedFuture
}

trait LengthCurrent extends LengthNeedFuture with LengthNeedPass {
  override val future: () => LengthNeedPass
  override val pass: () => LengthNeedFuture
  override def length: Int = future().length
}
