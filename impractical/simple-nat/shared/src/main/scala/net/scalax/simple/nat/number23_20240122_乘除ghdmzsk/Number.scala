package net.scalax.simple
package nat
package number23

import ghdmzsk._

object 乘除 {

  lazy val 被乘数分子: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(tail: () => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(other: () => ghdmzsk): ghdmzsk = {
        被乘数分子.inputGHDMZSK(() => tail().inputGHDMZSK(other))
      }
    }
  }

  lazy val `被乘数分母/乘数分母`: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(tail: () => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(other: () => ghdmzsk): ghdmzsk = {
        other().inputGHDMZSK(tail)
      }
    }
  }

  lazy val 乘数分子: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(tail: () => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(other: () => ghdmzsk): ghdmzsk = {
        `被乘数分母/乘数分母`.inputGHDMZSK(() => tail().inputGHDMZSK(other))
      }
    }
  }

}
