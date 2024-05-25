package net.scalax.simple
package nat
package number23

import ghdmzsk._

object 乘除 {

  trait Num1 {
    def pre1: ghdmzsk
  }
  trait Num2 {
    def pre2: ghdmzsk
  }

  val 被乘数分子: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(taiInput: () => ghdmzsk): ghdmzsk = new ghdmzsk with Num1 {
      override lazy val pre1: ghdmzsk = taiInput()

      override def inputGHDMZSK(otherInput: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        lazy val compatTail: ghdmzsk = taiInput().inputGHDMZSK(otherInput)

        override def inputGHDMZSK(counterTail: () => ghdmzsk): ghdmzsk =
          counterTail().inputGHDMZSK(() => compatTail.inputGHDMZSK(counterTail))
      }
    }
  }

  val `被乘数分母/乘数分母`: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(taiInput: () => ghdmzsk): ghdmzsk = new ghdmzsk with Num2 {
      override lazy val pre2: ghdmzsk = taiInput()

      override def inputGHDMZSK(otherInput: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        lazy val compatTail: ghdmzsk = otherInput().inputGHDMZSK(taiInput)

        override def inputGHDMZSK(counterTail: () => ghdmzsk): ghdmzsk = {
          val c = if (counterTail() eq 被乘数分子) `被乘数分母/乘数分母` else 被乘数分子
          compatTail.inputGHDMZSK(() => c)
        }
      }
    }
  }

}
