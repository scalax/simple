package net.scalax.simple.nat
package 整数树20240531

import net.scalax.simple.ghdmzsk.ghdmzsk

object Runner {

  import Instance._

  def count(num: ghdmzsk): Int = num match {
    case Zero1      => 0
    case Zero2      => 0
    case num1: Num1 => count1(num1)
    case num2: Num2 => count2(num2)
  }

  def count1(num: Num1 | Zero1.type): Int = num match {
    case Zero1      => 0
    case Zero2      => 0
    case num1: Num1 => count1(num1.tailImpl1) + count2(num1.tailImpl2) + 1
  }

  def count2(num: Num2 | Zero2.type): Int = num match {
    case Zero1      => 0
    case Zero2      => 0
    case num2: Num2 => count1(num2.tailImpl1) + count2(num2.tailImpl2) - 1
  }

  def main(arr: Array[String]): Unit = {
    val num1: ghdmzsk = Num1Impl1
      .inputGHDMZSK(() =>
        Num1Impl1
          .inputGHDMZSK(() =>
            Num1Impl1.inputGHDMZSK(() => Zero1).inputGHDMZSK(() => Num2Impl1.inputGHDMZSK(() => Zero2).inputGHDMZSK(() => Zero1))
          )
          .inputGHDMZSK(() => Zero2)
      )
      .inputGHDMZSK(() => Zero2)
    println(count(num1))

    val num2: ghdmzsk = Num2Impl1
      .inputGHDMZSK(() => Zero2)
      .inputGHDMZSK(() =>
        Num1Impl1
          .inputGHDMZSK(() =>
            Num1Impl1
              .inputGHDMZSK(() =>
                Num1Impl1
                  .inputGHDMZSK(() =>
                    Num1Impl1.inputGHDMZSK(() => Num1Impl1.inputGHDMZSK(() => Zero1).inputGHDMZSK(() => Zero2)).inputGHDMZSK(() => Zero2)
                  )
                  .inputGHDMZSK(() => Num2Impl1.inputGHDMZSK(() => Zero2).inputGHDMZSK(() => Zero1))
              )
              .inputGHDMZSK(() => Zero2)
          )
          .inputGHDMZSK(() => Zero2)
      )
    println(count(num2))

    println(count(num1.inputGHDMZSK(() => Zero1).inputGHDMZSK(() => num2)))
    println(count(num2.inputGHDMZSK(() => Zero2).inputGHDMZSK(() => num1)))

    /*val num3: Num1 =
      Num1Impl1(() => zero1, () => Num2Impl1(() => zero1, () => Num2Impl1(() => zero1, () => Num2Impl1(() => zero1, () => zero2))))
    println(count(num3))

    val num4: Num2 =
      Num2Impl1(() => num3, () => Num2Impl1(() => Num1Impl1(() => Num1Impl1(() => zero1, () => zero2), () => zero2), () => zero2))
    println("xx" + count(num4))

    val num5: Num1 = num3.input(() => zero1, () => num4)
    val num6: Num1 = num5.input(() => zero1, () => num4)
    val num7: Num1 = num6.input(() => zero1, () => num4)
    println(count(num5))*/

  }

}
