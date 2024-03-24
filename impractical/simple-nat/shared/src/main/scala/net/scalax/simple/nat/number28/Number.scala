package net.scalax.simple
package nat
package number28

import ghdmzsk._

object 乘除 {

  trait Num1 {
    def pre1: ghdmzsk
  }

  trait Num2 {
    def pre2: ghdmzsk
  }

  val 被乘数分子: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(tailInput: () => ghdmzsk): ghdmzsk = new ghdmzsk with Num1 {
      lazy val pre1: ghdmzsk = tailInput()

      override def inputGHDMZSK(otherInput: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(counterTail1: () => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(counterTail2: () => ghdmzsk): ghdmzsk = {
            counterTail1().inputGHDMZSK(() => tailInput().inputGHDMZSK(otherInput).inputGHDMZSK(counterTail1).inputGHDMZSK(counterTail2))
          }
        }
      }
    }
  }

  val `被乘数分母/乘数分母`: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(tailInput: () => ghdmzsk): ghdmzsk = new ghdmzsk with Num2 {
      override lazy val pre2: ghdmzsk = tailInput()

      override def inputGHDMZSK(otherInput: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(counterTail1: () => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(counterTail2: () => ghdmzsk): ghdmzsk = {
            otherInput().inputGHDMZSK(tailInput).inputGHDMZSK(counterTail2).inputGHDMZSK(counterTail1)
          }
        }
      }
    }
  }

}
