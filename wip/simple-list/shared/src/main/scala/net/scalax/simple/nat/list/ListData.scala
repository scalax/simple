package net.scalax.simple
package injection

import core._

trait ListData[+T] extends NumberParent {
  override val child: () => ListData[T]
}

trait ListDataPositive[+T] extends ListData[T] {
  def data: T
  override val child: () => ListData[T]
}
