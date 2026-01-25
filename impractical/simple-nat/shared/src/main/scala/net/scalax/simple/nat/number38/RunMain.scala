package net.scalax.simple
package nat
package number38

import scala.annotation.tailrec
import ghdmzsk._

object RunTest1 {

  trait TempVar {
    val build1: ghdmzsk
    val build2: ghdmzsk
  }

  def build(分子: Long, 分母: Long): ghdmzsk = {
    def buildImpl(isFenmu: Boolean, numLong: Long, zero: () => ghdmzsk): ghdmzsk = {
      if (numLong > 0) {
        if (isFenmu) {
          乘除1.nm2.inputGHDMZSK(() => buildImpl(isFenmu = isFenmu, numLong = numLong - 1, zero))
        } else {
          乘除1.nm1.inputGHDMZSK(() => buildImpl(isFenmu = isFenmu, numLong = numLong - 1, zero))
        }
      } else {
        zero()
      }
    }

    lazy val build2_1: ghdmzsk = buildImpl(isFenmu = false, numLong = 分子, zero = () => build2_2)
    lazy val build2_2: ghdmzsk = buildImpl(isFenmu = true, numLong = 分母, zero = () => build2_1)

    val tempVar: TempVar = new TempVar {
      TempVarSelf =>
      override val build1: ghdmzsk = buildImpl(isFenmu = false, numLong = 分子, zero = () => TempVarSelf.build2)
      override val build2: ghdmzsk = buildImpl(isFenmu = true, numLong = 分母, zero = () => TempVarSelf.build1)
    }

    var build1_1: ghdmzsk = null
    var build1_2: ghdmzsk = null
    build1_1 = buildImpl(isFenmu = false, numLong = 分子, zero = () => build1_2)
    build1_2 = buildImpl(isFenmu = true, numLong = 分母, zero = () => build1_1)

    tempVar.build1
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
        case num1: 乘除1.Num2 =>
          countImpl(
            () => num1.pre2,
            current分子 = current分子,
            current分母 = current分母 + 1,
            exceptResult = exceptResult,
            printlnSum = if (needPrintln) printlnSum - 1 else printlnSum,
            speed = speed
          )
        case num2: 乘除1.Num1 =>
          countImpl(
            () => num2.pre1,
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

    println("== start 1 ==")

    val 分子1: Long = 17
    val 分母1: Long = 12

    val 分子2: Long = 11
    val 分母2: Long = 3

    val num1: ghdmzsk          = build(分子 = 分子1, 分母 = 分母1)
    val num1Except: BigDecimal = BigDecimal(分子1) / BigDecimal(分母1)
    count(() => num1, except = num1Except, printlnSum = 5)

    val num2: ghdmzsk          = build(分子 = 分子2, 分母 = 分母2)
    val num2Except: BigDecimal = BigDecimal(分子2) / BigDecimal(分母2)
    count(() => num2, except = num2Except, printlnSum = 5)

    val result1: ghdmzsk          = num1.inputGHDMZSK(() => num2)
    val result1Except: BigDecimal = (num1Except + num2Except) / 2
    count(() => result1, except = result1Except, printlnSum = 5)

    val result2: ghdmzsk          = num1.inputGHDMZSK(() => result1)
    val result2Except: BigDecimal = (num1Except + result1Except) / 2
    count(() => result2, except = result2Except, printlnSum = 5, speed = 100000)

    println("== finished 1 ==")

  }

}
