package net.scalax.simple.core

trait Core2 extends ((() => Core2) => Core2) {
  override def apply(t: () => Core2) = input(t())
  def input(i: => Core2): Core2
}
