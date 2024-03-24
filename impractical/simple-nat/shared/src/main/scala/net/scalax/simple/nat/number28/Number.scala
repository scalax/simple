package net.scalax.simple
package nat
package number28

import ghdmzsk._

object 乘除1 {

  trait Num1 {
    def pre1: ghdmzsk
  }

  trait Num2 {
    def pre2: ghdmzsk
  }

  val 被乘数分子: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(numTail1: () => ghdmzsk): ghdmzsk = new ghdmzsk with Num1 {
      lazy val pre1: ghdmzsk = numTail1()

      override def inputGHDMZSK(numTail2: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(counterTail1: () => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(counterTail2: () => ghdmzsk): ghdmzsk = {
            counterTail1().inputGHDMZSK(() => numTail1().inputGHDMZSK(numTail2).inputGHDMZSK(counterTail1).inputGHDMZSK(counterTail2))
          }
        }
      }
    }
  }

  val `被乘数分母/乘数分母`: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(numTail1: () => ghdmzsk): ghdmzsk = new ghdmzsk with Num2 {
      override lazy val pre2: ghdmzsk = numTail1()

      override def inputGHDMZSK(numTail2: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(counterTail1: () => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(counterTail2: () => ghdmzsk): ghdmzsk = {
            numTail2().inputGHDMZSK(numTail1).inputGHDMZSK(counterTail2).inputGHDMZSK(counterTail1)
          }
        }
      }
    }
  }

}
