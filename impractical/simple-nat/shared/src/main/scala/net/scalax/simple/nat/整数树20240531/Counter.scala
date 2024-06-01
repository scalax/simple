package net.scalax.simple.nat
package 整数树20240531

import net.scalax.simple.ghdmzsk.ghdmzsk

object Instance {

  trait Num1 {
    def tailImpl1: Num1
    def tailImpl2: Num2
  }

  trait Num2 {
    def tailImpl1: Num1
    def tailImpl2: Num2
  }

  lazy val Num1Impl1: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(tail1: () => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(tail2: () => ghdmzsk): ghdmzsk = new ghdmzsk with Num1 {
        override def tailImpl1: Num1 = tail1().asInstanceOf[Num1]
        override def tailImpl2: Num2 = tail2().asInstanceOf[Num2]

        override def inputGHDMZSK(num1: () => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(num2: () => ghdmzsk): ghdmzsk =
            Num1Impl1.inputGHDMZSK(tail1).inputGHDMZSK(() => tail2().inputGHDMZSK(num1).inputGHDMZSK(num2))
        }
      }
    }
  }

  lazy val Num2Impl1: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(tail1: () => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(tail2: () => ghdmzsk): ghdmzsk = new ghdmzsk with Num2 {
        override def tailImpl1: Num1 = tail1().asInstanceOf[Num1]
        override def tailImpl2: Num2 = tail2().asInstanceOf[Num2]

        override def inputGHDMZSK(num1: () => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(num2: () => ghdmzsk): ghdmzsk =
            Num2Impl1.inputGHDMZSK(() => tail1().inputGHDMZSK(num1).inputGHDMZSK(num2)).inputGHDMZSK(tail2)
        }
      }
    }
  }

  lazy val zero1Impl1: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(tail2: () => ghdmzsk): ghdmzsk = new ghdmzsk with Num1 with Num2 {
      override def tailImpl1: Num1 = this.asInstanceOf[Num1]
      override def tailImpl2: Num2 = tail2().asInstanceOf[Num2]

      override def inputGHDMZSK(num1: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(num2: () => ghdmzsk): ghdmzsk =
          if (num2() eq Zero2) num2() else num2().inputGHDMZSK(num1).inputGHDMZSK(tail2)
      }
    }
  }

  lazy val zero2Impl1: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(tail1: () => ghdmzsk): ghdmzsk = new ghdmzsk with Num1 with Num2 {
      override def tailImpl1: Num1 = tail1().asInstanceOf[Num1]
      override def tailImpl2: Num2 = this.asInstanceOf[Num2]

      override def inputGHDMZSK(num1: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(num2: () => ghdmzsk): ghdmzsk =
          if (num1() eq Zero1) num1() else num1().inputGHDMZSK(tail1).inputGHDMZSK(num2)
      }
    }
  }

  lazy val Zero1: ghdmzsk = zero1Impl1.inputGHDMZSK(() => Zero2)
  lazy val Zero2: ghdmzsk = zero2Impl1.inputGHDMZSK(() => Zero1)

}
