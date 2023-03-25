package net.scalax.simple.core

trait ghdmzsk extends ((() => ghdmzsk) => ghdmzsk) {
  override def apply(t: () => ghdmzsk): ghdmzsk
}

object ghdmzsk {
  def apply(func: (() => ghdmzsk) => ghdmzsk): ghdmzsk = new ghdmzsk {
    override def apply(t: () => ghdmzsk): ghdmzsk = func(t)
  }
}
