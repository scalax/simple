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

    println("// ===")
    println(count1(num1)) // 2
    println(count2(num2)) // 3

    println("// ===")
    println(count1(num1.inputGHDMZSK(() => num1)))                                                   // 4
    println(count1(num1.inputGHDMZSK(() => num1).inputGHDMZSK(() => num1)))                          // 6
    println(count1(num1.inputGHDMZSK(() => num1).inputGHDMZSK(() => num1).inputGHDMZSK(() => num1))) // 8

    println("// ===")
    println(count2(num2.inputGHDMZSK(() => num2)))                                                   // 6
    println(count2(num2.inputGHDMZSK(() => num2).inputGHDMZSK(() => num2)))                          // 9
    println(count2(num2.inputGHDMZSK(() => num2).inputGHDMZSK(() => num2).inputGHDMZSK(() => num2))) // 12

    println("// ===")
    println(count1(num1))                                                                            // 2
    println(count1(num2))                                                                            // -3
    println(count1(num1.inputGHDMZSK(() => num2)))                                                   // -1
    println(count1(num1.inputGHDMZSK(() => num2).inputGHDMZSK(() => num2).inputGHDMZSK(() => num2))) // -7

    println("// ===")
    println(count2(num1))                                                                                                     // -2
    println(count2(num2))                                                                                                     // 3
    println(count2(num2.inputGHDMZSK(() => num1).inputGHDMZSK(() => num2).inputGHDMZSK(() => num2).inputGHDMZSK(() => num1))) // 5
    println(count2(num2.inputGHDMZSK(() => num1)))                                                                            // 1

  }

}
