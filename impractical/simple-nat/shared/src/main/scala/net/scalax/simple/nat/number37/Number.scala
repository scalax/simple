package net.scalax.simple
package nat
package number37

import ghdmzsk._

object 乘除1 {

  trait Num1 {
    def pre1: ghdmzsk
  }

  trait Num2 {
    def pre2: ghdmzsk
  }

  val nm1: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(a: () => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(b: () => ghdmzsk): ghdmzsk = new ghdmzsk with Num1 {
        override lazy val pre1: ghdmzsk = b()

        override def inputGHDMZSK(c: () => ghdmzsk): ghdmzsk = a().inputGHDMZSK(() => b().inputGHDMZSK(c))
      }
    }
  }

  val nm2: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(a: () => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(b: () => ghdmzsk): ghdmzsk = new ghdmzsk with Num2 {
        override lazy val pre2: ghdmzsk = b()

        override def inputGHDMZSK(c: () => ghdmzsk): ghdmzsk = a().inputGHDMZSK(() => c().inputGHDMZSK(b))
      }
    }
  }

  val n1: ghdmzsk = nm1.inputGHDMZSK(() => n1)
  val n2: ghdmzsk = nm2.inputGHDMZSK(() => n2)

}
