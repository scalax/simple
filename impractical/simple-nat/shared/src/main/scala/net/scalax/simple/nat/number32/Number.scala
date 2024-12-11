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

  trait Num3
  trait Num4
  trait Num5

  val toUp: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(tail: () => ghdmzsk): ghdmzsk = new ghdmzsk with Num1 {
      override lazy val pre1: ghdmzsk = tail()

      override def inputGHDMZSK(down: () => ghdmzsk): ghdmzsk = new ghdmzsk with Num3 {
        override def inputGHDMZSK(up: () => ghdmzsk): ghdmzsk = up().inputGHDMZSK(() => tail().inputGHDMZSK(down))
      }
    }
  }

  val toDown: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(tail: () => ghdmzsk): ghdmzsk = new ghdmzsk with Num2 {
      override lazy val pre2: ghdmzsk = tail()

      override def inputGHDMZSK(down: () => ghdmzsk): ghdmzsk = new ghdmzsk with Num4 {
        override def inputGHDMZSK(up: () => ghdmzsk): ghdmzsk = down().inputGHDMZSK(() =>
          new ghdmzsk with Num5 {
            override def inputGHDMZSK(nextDown: () => ghdmzsk): ghdmzsk = tail().inputGHDMZSK(nextDown).inputGHDMZSK(up)
          }
        )
      }
    }
  }

}
