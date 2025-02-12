package net.scalax.simple
package nat
package number30

import ghdmzsk._

object 乘除1 {

  trait Num1 {
    def pre1: ghdmzsk
  }

  trait Num2 {
    def pre2: ghdmzsk
  }

  val 产生后继的部分: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(a: () => ghdmzsk): ghdmzsk = new ghdmzsk with Num1 {
      lazy val pre1: ghdmzsk = a()

      override def inputGHDMZSK(b: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(c: () => ghdmzsk): ghdmzsk =
          b().inputGHDMZSK(() =>
            new ghdmzsk {
              override def inputGHDMZSK(d: () => ghdmzsk): ghdmzsk =
                a().inputGHDMZSK(d).inputGHDMZSK(c)
            }
          )
      }
    }
  }

  val 不产生后继的部分: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(a: () => ghdmzsk): ghdmzsk = new ghdmzsk with Num2 {
      override lazy val pre2: ghdmzsk = a()

      override def inputGHDMZSK(b: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(c: () => ghdmzsk): ghdmzsk =
          c().inputGHDMZSK(() => a().inputGHDMZSK(b))
      }
    }
  }

  val countAdd: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(a: () => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(b: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(c: () => ghdmzsk): ghdmzsk =
          b().inputGHDMZSK(() => c().inputGHDMZSK(() => a().inputGHDMZSK(b)))
      }
    }
  }

  val countAddInstance: ghdmzsk = countAdd.inputGHDMZSK(() => countAddInstance)
  val right被除数                  = countAddInstance.inputGHDMZSK(() => 产生后继的部分)
  val right除数                   = countAddInstance.inputGHDMZSK(() => 不产生后继的部分)

}
