package net.scalax.simple.nat
package 整数树20240531

import net.scalax.simple.ghdmzsk.ghdmzsk

case class Num2Impl1(tail1: () => Num1, tail2: () => Num2) extends Num2 {
  override def input(num1: () => Num1, num2: () => Num2): Num1 | Num2 = Num2Impl1(tail1 = () => tail1().input(num1, num2), tail2 = tail2)
}

case class Num1Impl2(tail2: () => Num2) extends Num1 {
  override def input(num1: () => Num1, num2: () => Num2): Num1 | Num2 =
    if (num2() eq ZeroInstance.zero2) ZeroInstance.zero2 else num2().input(num1, tail2)
}

case class Num2Impl2(tail1: () => Num1) extends Num2 {
  override def input(num1: () => Num1, num2: () => Num2): Num1 | Num2 =
    if (num1() eq ZeroInstance.zero1) ZeroInstance.zero1 else num1().input(tail1, num2)
}

object Instance {

  lazy val Num1Impl1: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(tail1: () => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(tail2: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(num1: () => ghdmzsk): ghdmzsk = new ghdmzsk {
          override def inputGHDMZSK(num2: () => ghdmzsk): ghdmzsk =
            Num1Impl1.inputGHDMZSK(tail1).inputGHDMZSK(() => tail2().inputGHDMZSK(num1).inputGHDMZSK(num2))
        }
      }
    }
  }

  lazy val zero1: Num1 = Num1Impl2(tail2 = () => zero2)
  lazy val zero2: Num2 = Num2Impl2(tail1 = () => zero1)

}
