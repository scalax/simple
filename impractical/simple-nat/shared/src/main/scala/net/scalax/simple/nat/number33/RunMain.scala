package net.scalax.simple
package nat
package number33

import scala.annotation.tailrec
import ghdmzsk._

object RunTest1 {

  def build(分子: Long, 分母: Long): ghdmzsk = {
    def buildImpl(isFenmu: Boolean, numLong: Long, zero: () => ghdmzsk): ghdmzsk = {
      if (numLong > 0) {
        if (isFenmu) {
          乘除1.n1.inputGHDMZSK(() => buildImpl(isFenmu = isFenmu, numLong = numLong - 1, zero))
        } else {
          乘除1.n2.inputGHDMZSK(() => buildImpl(isFenmu = isFenmu, numLong = numLong - 1, zero))
        }
      } else {
        zero()
      }
    }

    lazy val build1: ghdmzsk = buildImpl(isFenmu = false, numLong = 分子, zero = () => build2)
    lazy val build2: ghdmzsk = buildImpl(isFenmu = true, numLong = 分母, zero = () => build1)

    build1
  }

  @tailrec
  def countImpl(
    num: () => ghdmzsk,
    current分子: Long,
    current分母: Long,
    exceptResult: BigDecimal,
    printlnSum: Int,
    speed: Long
  ): Unit = {
    val needPrintln: Boolean = (current分子 + current分母) % speed == 0

    val current: BigDecimal = BigDecimal(current分子) / BigDecimal(current分母)

    if (needPrintln) {
      println(s"except: $exceptResult, current: $current分子 / $current分母 = $current")
    }

    val currentNum = num()

    if (printlnSum > 0) {
      currentNum match {
        case num1: 乘除1.Num1 =>
          countImpl(
            () => num1.pre1,
            current分子 = current分子,
            current分母 = current分母 + 1,
            exceptResult = exceptResult,
            printlnSum = if (needPrintln) printlnSum - 1 else printlnSum,
            speed = speed
          )
        case num2: 乘除1.Num2 =>
          countImpl(
            () => num2.pre2,
            current分子 = current分子 + 1,
            current分母 = current分母,
            exceptResult = exceptResult,
            printlnSum = if (needPrintln) printlnSum - 1 else printlnSum,
            speed = speed
          )
      }
    } else {
      println("== finished ==")
    }
  }

  def count(num: () => ghdmzsk, except: BigDecimal, printlnSum: Int, speed: Long = 8000000): Unit =
    countImpl(num = num, current分子 = 1, current分母 = 1, exceptResult = except, printlnSum = printlnSum, speed = speed)

  def main1(arr: Array[String]): Unit = {

    val 分子1: Long = 4
    val 分母1: Long = 1

    val 分子2: Long = 2
    val 分母2: Long = 1

    val except1: BigDecimal = BigDecimal(分子1) / BigDecimal(分母1)

    // val result1: ghdmzsk = num1.inputGHDMZSK(() => 乘除1.n2).inputGHDMZSK(() => num1.inputGHDMZSK(() => 乘除1.n1))
    /*.inputGHDMZSK(() => 乘除1.n1)
      .inputGHDMZSK(() => num1.inputGHDMZSK(() => 乘除1.n2))
      .inputGHDMZSK(() => 乘除1.n1)
      .inputGHDMZSK(() => num1.inputGHDMZSK(() => 乘除1.n2))
      .inputGHDMZSK(() => 乘除1.n1)
      .inputGHDMZSK(() => num1.inputGHDMZSK(() => 乘除1.n2))*/

    val num1: ghdmzsk     = build(分子 = 分子1, 分母 = 分母1)
    val num1Impl: ghdmzsk = num1.inputGHDMZSK(() => 乘除1.n2)
    lazy val num1Count: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(t: () => ghdmzsk): ghdmzsk = num1Impl.inputGHDMZSK(() => num1Count.inputGHDMZSK(t))
    }

    val num2: ghdmzsk           = build(分子 = 分子2, 分母 = 分母2)
    val num2Impl: ghdmzsk       = num2.inputGHDMZSK(() => 乘除1.n1)
    lazy val num2Count: ghdmzsk = num2Impl.inputGHDMZSK(() => num2Count)

    val result1: ghdmzsk = num1Impl.inputGHDMZSK(() => num2Impl)

    // val result1: ghdmzsk = num1Count.inputGHDMZSK(() => num2Count)

    // count(() => num1, except = except1, printlnSum = 10)
    count(() => result1, except = except1, printlnSum = 5)
    println("== finished 1 ==")

  }

}
