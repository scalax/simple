package net.scalax.simple
package nat
package number36

import scala.annotation.tailrec
import ghdmzsk._

object RunTest1 {

  case class 分数(分子: Long, 分母: Long) {
    self =>
    def 除以(f: 分数): 分数   = 分数(分子 = (self.分子 + self.分母 * 2) * (f.分母 * 2), 分母 = (self.分母 * 2) * (f.分子 + f.分母 * 2))
    def 实际值: BigDecimal = BigDecimal(分子) / BigDecimal(分母)
  }

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

    lazy val build1: ghdmzsk = buildImpl(isFenmu = true, numLong = 分子, zero = () => build2)
    lazy val build2: ghdmzsk = buildImpl(isFenmu = false, numLong = 分母, zero = () => build1)

    build1
  }

  @tailrec
  def countImpl(
    num: () => ghdmzsk,
    current分子: Long,
    current分母: Long,
    exceptResult: BigDecimal,
    printlnSum: Int,
    speed: Long,
    countTimes: Long
  ): Unit = {
    val needPrintln: Boolean = countTimes % speed == 0

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
            current分子 = current分子 + 1,
            current分母 = current分母,
            exceptResult = exceptResult,
            printlnSum = if (needPrintln) printlnSum - 1 else printlnSum,
            speed = speed,
            countTimes = countTimes + 1
          )
        case num2: 乘除1.Num2 =>
          countImpl(
            () => num2.pre2,
            current分子 = current分子,
            current分母 = current分母 + 1,
            exceptResult = exceptResult,
            printlnSum = if (needPrintln) printlnSum - 1 else printlnSum,
            speed = speed,
            countTimes = countTimes + 1
          )
      }
    } else {
      println("== finished ==")
    }
  }

  def count(num: () => ghdmzsk, except1: BigDecimal, printlnSum: Int, speed: Long = 8000000): Unit =
    countImpl(num = num, current分子 = 1, current分母 = 1, exceptResult = except1, printlnSum = printlnSum, speed = speed, countTimes = 0)

  def main1(arr: Array[String]): Unit = {
    println('5'.toString * 1000)

    val 分子1: Long = 123
    val 分母1: Long = 4342
    val 分子2: Long = 328
    val 分母2: Long = 15

    val except1: 分数 = 分数(分子1, 分母1)
    val except2: 分数 = 分数(分子2, 分母2)

    val num1: ghdmzsk = build(分子 = 分子1, 分母 = 分母1)
    val num2: ghdmzsk = build(分子 = 分子2, 分母 = 分母2)

    val result1: () => ghdmzsk = () => num1.inputGHDMZSK(() => 乘除1.n1).inputGHDMZSK(() => num2.inputGHDMZSK(() => 乘除1.n2))

    count(() => num1, except1 = except1.实际值, printlnSum = 18)
    count(() => num2, except1 = except2.实际值, printlnSum = 18)
    count(result1, except1 = except1.除以(except2).实际值, printlnSum = 18)
    println("== finished 1 ==")

    // ===
    val 分子3: Long = 32
    val 分母3: Long = 982

    val except3: 分数   = except1.除以(except2)
    val except4: 分数   = 分数(分子3, 分母3)
    val num3: ghdmzsk = build(分子 = 分子3, 分母 = 分母3)

    val result2: () => ghdmzsk = () => result1().inputGHDMZSK(() => 乘除1.n1).inputGHDMZSK(() => num3.inputGHDMZSK(() => 乘除1.n2))

    count(result2, except1 = except3.除以(except4).实际值, printlnSum = 18, speed = 16000000)
    println("== finished 2 ==")

    // ===
    val except5: 分数 = except3.除以(except4)
    val except6: 分数 = except3

    val result3: () => ghdmzsk = () => result2().inputGHDMZSK(() => 乘除1.n1).inputGHDMZSK(() => result1().inputGHDMZSK(() => 乘除1.n2))
    count(result3, except1 = except5.除以(except6).实际值, printlnSum = 18, speed = 30000000)

    val result4: () => ghdmzsk = () => result2().inputGHDMZSK(() => 乘除1.n2).inputGHDMZSK(() => result1().inputGHDMZSK(() => 乘除1.n1))
    count(result4, except1 = except6.除以(except5).实际值, printlnSum = 18, speed = 30000000)
    println("== finished 3 ==")
  }

}
