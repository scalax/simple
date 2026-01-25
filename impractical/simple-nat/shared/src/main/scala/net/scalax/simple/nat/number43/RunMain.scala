package net.scalax.simple
package nat
package number43

import scala.annotation.tailrec
import ghdmzsk._

object RunTest1 {

  def build(分子: Long, 分母: Long): ghdmzsk = {
    def buildImpl(isFenmu: Boolean, numLong: Long, zero: () => ghdmzsk): ghdmzsk = {
      if (numLong > 0) {
        if (isFenmu) {
          Num43.Append2.tailToLeft.inputGHDMZSK(() => buildImpl(isFenmu = isFenmu, numLong = numLong - 1, zero))
        } else {
          Num43.Append2.tailToRight.inputGHDMZSK(() => buildImpl(isFenmu = isFenmu, numLong = numLong - 1, zero))
        }
      } else {
        zero()
      }
    }

    lazy val build2_1: ghdmzsk = buildImpl(isFenmu = false, numLong = 分子, zero = () => build2_2)
    lazy val build2_2: ghdmzsk = buildImpl(isFenmu = true, numLong = 分母, zero = () => build2_1)

    build2_1
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
        case num1: Num43.Num1 =>
          countImpl(
            () => num1.pre1,
            current分子 = current分子,
            current分母 = current分母 + 1,
            exceptResult = exceptResult,
            printlnSum = if (needPrintln) printlnSum - 1 else printlnSum,
            speed = speed
          )
        case num2: Num43.Num2 =>
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

  def main(arr: Array[String]): Unit = {
    println("== start 1 ==")

    val 分子1: Long = 17
    val 分母1: Long = 12

    val 分子2: Long = 11
    val 分母2: Long = 3

    val 分子3: Long = 79
    val 分母3: Long = 65

    val 分子4: Long = 81
    val 分母4: Long = 93

    val num1: ghdmzsk          = build(分子 = 分母1, 分母 = 分子1)
    val num1Except: BigDecimal = BigDecimal(分子1) / BigDecimal(分母1)
    count(() => num1, except = num1Except, printlnSum = 5)

    val num2: ghdmzsk          = build(分子 = 分母2, 分母 = 分子2)
    val num2Except: BigDecimal = BigDecimal(分子2) / BigDecimal(分母2)
    count(() => num2, except = num2Except, printlnSum = 5)

    val num3: ghdmzsk          = build(分子 = 分母3, 分母 = 分子3)
    val num3Except: BigDecimal = BigDecimal(分子3) / BigDecimal(分母3)
    count(() => num3, except = num3Except, printlnSum = 5)

    val num4: ghdmzsk          = build(分子 = 分母4, 分母 = 分子4)
    val num4Except: BigDecimal = BigDecimal(分子4) / BigDecimal(分母4)
    count(() => num4, except = num4Except, printlnSum = 5)

    val result1: ghdmzsk = Num43.Append1.tailToRightInstance
      .inputGHDMZSK(() => num1)
      .inputGHDMZSK(() => num2)
      .inputGHDMZSK(() => num3)
      .inputGHDMZSK(() => num4)
      .inputGHDMZSK(() => Num43.Append1.tailToLeftInstance)
    val result1Except: BigDecimal = num1Except * num2Except * num3Except * num4Except
    count(() => result1, except = result1Except, printlnSum = 5)

    val result2: ghdmzsk = Num43.Append1.tailToRightInstance
      .inputGHDMZSK(() => num1)
      .inputGHDMZSK(() => result1)
      .inputGHDMZSK(() => num3)
      .inputGHDMZSK(() => result1)
      .inputGHDMZSK(() => Num43.Append1.tailToLeftInstance)
    val result2Except: BigDecimal = num1Except * result1Except * num3Except * result1Except
    count(() => result2, except = result2Except, printlnSum = 5)

    val result3: ghdmzsk = Num43.Append1.tailToRightInstance
      .inputGHDMZSK(() => result1)
      .inputGHDMZSK(() => result2)
      .inputGHDMZSK(() => num3)
      .inputGHDMZSK(() => num4)
      .inputGHDMZSK(() => Num43.Append1.tailToLeftInstance)
    val result3Except: BigDecimal = result1Except * result2Except * num3Except * num4Except
    count(() => result3, except = result3Except, printlnSum = 20)

    println("== finished 1 ==")
  }

}
