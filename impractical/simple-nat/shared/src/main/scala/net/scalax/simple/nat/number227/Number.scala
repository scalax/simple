package net.scalax.simple
package nat
package number27

import ghdmzsk._

object 乘除 {


  trait ghdmzskPre1 extends ghdmzsk {
    def tail: ghdmzsk
    override def inputGHDMZSK(t: () => ghdmzsk): ghdmzsk
  }

  val 被乘数分子: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(tailInput: () => ghdmzsk): ghdmzsk = new ghdmzsk   {
      lazy val tail1: ghdmzsk = tailInput()

      override def inputGHDMZSK(otherInput: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        lazy val compatTail: ghdmzsk = tailInput().inputGHDMZSK(otherInput)

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
