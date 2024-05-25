package net.scalax.simple
package ghdmzsk

trait ghdmzsk {
  def inputGHDMZSK(t: () => ghdmzsk): ghdmzsk
}

object ghdmzsk {
  def apply(func: (() => ghdmzsk) => ghdmzsk): ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(t: () => ghdmzsk): ghdmzsk = func(t)
  }
}

trait ghdmzskProperties1 extends ghdmzsk {
  val property1: () => ghdmzsk

  override def inputGHDMZSK(t: () => ghdmzsk): ghdmzsk = property1().inputGHDMZSK(t)
}

class ghdmzskPrefixImpl(override val property1: () => ghdmzsk) extends ghdmzskProperties1
case class ghdmzskPrefix(tail: () => ghdmzsk)                  extends ghdmzskPrefixImpl(property1 = tail)
