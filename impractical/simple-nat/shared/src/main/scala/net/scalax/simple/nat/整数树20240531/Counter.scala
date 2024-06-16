package net.scalax.simple.nat
package 整数树20240531

import net.scalax.simple.ghdmzsk.ghdmzsk

object Instance {

  trait Num1 {
    def tailImpl1: Num1 | Zero1.type
    def tailImpl2: Num2 | Zero2.type
  }

  trait Num2 {
    def tailImpl1: Num1 | Zero1.type
    def tailImpl2: Num2 | Zero2.type
  }

  lazy val Num1Impl1: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(tail1: () => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(tail2: () => ghdmzsk): ghdmzsk = new ghdmzsk with Num1 {

        override def tailImpl1: Num1 | Zero1.type = tail1().asInstanceOf[Num1 | Zero1.type]
        override def tailImpl2: Num2 | Zero2.type = tail2().asInstanceOf[Num2 | Zero2.type]

        override def inputGHDMZSK(num1: () => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(num2: () => ghdmzsk): ghdmzsk =
            Num1Impl1.inputGHDMZSK(() => tail1().inputGHDMZSK(num1).inputGHDMZSK(num2)).inputGHDMZSK(tail2)
        }
      }
    }
  }

  lazy val Num2Impl1: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(tail2: () => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(tail1: () => ghdmzsk): ghdmzsk = new ghdmzsk with Num2 {

        override def tailImpl1: Num1 | Zero1.type = tail1().asInstanceOf[Num1 | Zero1.type]
        override def tailImpl2: Num2 | Zero2.type = tail2().asInstanceOf[Num2 | Zero2.type]

        override def inputGHDMZSK(num2: () => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(num1: () => ghdmzsk): ghdmzsk =
            Num2Impl1.inputGHDMZSK(() => tail2().inputGHDMZSK(num2).inputGHDMZSK(num1)).inputGHDMZSK(tail1)
        }
      }
    }
  }

  lazy val Zero1: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(num1: () => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(num2: () => ghdmzsk): ghdmzsk = Num1Impl1.inputGHDMZSK(num1).inputGHDMZSK(num2)
    }
  }

  lazy val Zero2: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(num2: () => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(num1: () => ghdmzsk): ghdmzsk = Num2Impl1.inputGHDMZSK(num2).inputGHDMZSK(num1)
    }
  }

}
