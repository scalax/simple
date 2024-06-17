package net.scalax.simple.nat
package 整数树20240617

import net.scalax.simple.ghdmzsk.ghdmzsk

object Runner {

  import Instance._

  def count1(num: Any): Int = num match {
    case NumberZero   => 0
    case num1: Number => count1(num1.tailImpl1) + count2(num1.tailImpl2) + 1
  }

  def count2(num: Any): Int = num match {
    case NumberZero => 0
    case num2: Number =>
      val num2Impl = num2.reverse
      count1(num2Impl.tailImpl1) + count2(num2Impl.tailImpl2) - 1
  }

  val Num1Impl1: ghdmzsk = NumberPositive
  val Num2Impl1: ghdmzsk = NumberPositive
  val Zero1: ghdmzsk     = NumberZero
  val Zero2: ghdmzsk     = NumberZero

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
    println(count1(num1))

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
    println(count2(num2))

    println("// ===")
    println(count1(num1.inputGHDMZSK(() => num1)))
    println(count1(num1.inputGHDMZSK(() => num1).inputGHDMZSK(() => num1)))
    println(count1(num1.inputGHDMZSK(() => num1).inputGHDMZSK(() => num1).inputGHDMZSK(() => num1)))

    println("// ===")
    println(count2(num2.inputGHDMZSK(() => num2)))
    println(count2(num2.inputGHDMZSK(() => num2).inputGHDMZSK(() => num2)))
    println(count2(num2.inputGHDMZSK(() => num2).inputGHDMZSK(() => num2).inputGHDMZSK(() => num2)))

  }

}
