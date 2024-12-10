package net.scalax.simple
package nat
package number32

import ghdmzsk._

object 乘除1 {

  trait Num1 {
    def pre1: ghdmzsk
  }

  trait Num2 {
    def pre2: ghdmzsk
  }

  val keep: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(tail: () => ghdmzsk): ghdmzsk = new ghdmzsk with Num1 {
      override lazy val pre1: ghdmzsk = tail()

      override def inputGHDMZSK(after: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(before: () => ghdmzsk): ghdmzsk = before().inputGHDMZSK(() => tail().inputGHDMZSK(after))
      }
    }
  }

  val reverse: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(tail: () => ghdmzsk): ghdmzsk = new ghdmzsk with Num2 {
      override lazy val pre2: ghdmzsk = tail()

      override def inputGHDMZSK(after: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(before: () => ghdmzsk): ghdmzsk = after().inputGHDMZSK(() => tail().inputGHDMZSK(before))
      }
    }
  }

}
