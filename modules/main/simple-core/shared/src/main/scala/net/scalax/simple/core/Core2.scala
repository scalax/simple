package net.scalax.simple.core

trait Core2 extends ((() => Core2) => Core2) {
  override def apply(t: () => Core2): Core2
}

object Core2 {
  def apply(func: (() => Core2) => Core2): Core2 = new Core2 {
    override def apply(t: () => Core2): Core2 = func(t)
  }
}
