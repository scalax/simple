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
    override def inputGHDMZSK(taiInput: () => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(otherInput: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(tail: () => ghdmzsk): ghdmzsk = new ghdmzsk with Num1 {
          override def pre1: ghdmzsk = tail()
          override def inputGHDMZSK(other: () => ghdmzsk): ghdmzsk = {
            otherInput().inputGHDMZSK(() => tail().inputGHDMZSK(other))
          }
        }
      }
    }
  }

  val `被乘数分母/乘数分母`: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(taiInput: () => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(otherInput: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(tail: () => ghdmzsk): ghdmzsk = new ghdmzsk with Num2 {
          override def pre2: ghdmzsk = tail()
          override def inputGHDMZSK(other: () => ghdmzsk): ghdmzsk = {
            (other().inputGHDMZSK(tail)).inputGHDMZSK(otherInput)
          }
        }
      }
    }
  }

  lazy val numInput1: ghdmzsk = 被乘数分子.inputGHDMZSK(() => numInput2)

  lazy val numInput2: ghdmzsk = `被乘数分母/乘数分母`.inputGHDMZSK(() => numInput1)

}
