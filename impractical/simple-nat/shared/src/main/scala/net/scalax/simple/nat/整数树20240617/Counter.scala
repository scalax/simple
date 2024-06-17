package net.scalax.simple.nat
package 整数树20240617

import net.scalax.simple.ghdmzsk.ghdmzsk

object Instance {

  trait Number {
    self =>

    def tailImpl1: Number | NumberZero.type
    def tailImpl2: Number | NumberZero.type

    def reverse: Number = new Number {
      override def tailImpl1: Number | NumberZero.type = self.tailImpl2
      override def tailImpl2: Number | NumberZero.type = self.tailImpl1
    }
  }

  val Number1: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(num1: () => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(num2: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(num3: () => ghdmzsk): ghdmzsk = new ghdmzsk with Number {

          override def tailImpl1: Number | NumberZero.type = num2().asInstanceOf[Number | NumberZero.type]
          override def tailImpl2: Number | NumberZero.type = num3().asInstanceOf[Number | NumberZero.type]

          override def inputGHDMZSK(num4: () => ghdmzsk): ghdmzsk =
            num1().inputGHDMZSK(() => num2().inputGHDMZSK(num4)).inputGHDMZSK(num3)
        }
      }
    }
  }

  lazy val NumberPositive: ghdmzsk = Number1.inputGHDMZSK(() => NumberPositive)

  val NumberZero: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(num1: () => ghdmzsk): ghdmzsk = num1()
  }

}
