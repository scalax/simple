package net.scalax.simple.nat.number21

import scala.annotation.tailrec

object RunTest1 {

  def build(分子: Long, 分母: Long): `有理数` = {
    def buildImpl(isFenmu: Boolean, numLong: Long, zero: () => `有理数`): `有理数` = {
      if (numLong > 0) {
        `有理数`(tail = () => buildImpl(isFenmu = isFenmu, numLong = numLong - 1, zero), 是否分母 = isFenmu)
      } else {
        zero()
      }
    }

    lazy val build1: `有理数` = buildImpl(isFenmu = false, numLong = 分子, zero = () => build2)
    lazy val build2: `有理数` = buildImpl(isFenmu = true, numLong = 分母, zero = () => build1)

    build1
  }

  @tailrec
  def countImpl(num: () => `有理数`, current分子: Long, current分母: Long, exceptResult: BigDecimal, printlnSum: Int, speed: Long): Unit = {
    val needPrintln: Boolean = (current分子 + current分母) % speed == 0

    val current: BigDecimal = BigDecimal(current分子) / BigDecimal(current分母)

    if (needPrintln) {
      println(s"except: $exceptResult, current: $current分子 / $current分母 = $current")
    }

    val currentNum = num()

    if (printlnSum > 0) {
      if (currentNum.是否分母) {
        countImpl(
          currentNum.tail,
          current分子 = current分子,
          current分母 = current分母 + 1,
          exceptResult = exceptResult,
          printlnSum = if (needPrintln) printlnSum - 1 else printlnSum,
          speed = speed
        )
      } else {
        countImpl(
          currentNum.tail,
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

  def count(num: () => `有理数`, except1: BigDecimal, except2: BigDecimal, printlnSum: Int, speed: Long = 800000): Unit =
    countImpl(num = num, current分子 = 1, current分母 = 1, exceptResult = except1 / except2, printlnSum = printlnSum, speed = speed)

  def main(arr: Array[String]): Unit = {
    val 分子1: Long = 123
    val 分母1: Long = 4342
    val 分子2: Long = 328
    val 分母2: Long = 15

    val except1: BigDecimal = BigDecimal(分子1) / BigDecimal(分母1)
    val except2: BigDecimal = BigDecimal(分子2) / BigDecimal(分母2)

    val num1: `有理数` = build(分子 = 分子1, 分母 = 分母1)
    val num2: `有理数` = build(分子 = 分子2, 分母 = 分母2)

    val result1: () => `有理数` = () => num1.`除以`(() => num2, false)

    count(result1, except1 = except1, except2 = except2, printlnSum = 10, speed = 3000000)

    // ===
    val 分子3: Long = 32
    val 分母3: Long = 982

    val except3: BigDecimal = except1 / except2
    val except4: BigDecimal = BigDecimal(分子3) / BigDecimal(分母3)

    val num3: `有理数` = build(分子 = 分子3, 分母 = 分母3)

    val result2: () => `有理数` = () => result1().`除以`(() => num3, false)

    count(result2, except1 = except3, except2 = except4, printlnSum = 10, speed = 600000)

    // ===
    val except5: BigDecimal = except3 / except4
    val except6: BigDecimal = except3

    val result3: () => `有理数` = () => result2().`除以`(result1, false)
    count(result3, except1 = except5, except2 = except6, printlnSum = 18, speed = 30000)

    val result4: () => `有理数` = () => result2().`除以`(result1, true)
    count(result4, except1 = except6, except2 = except5, printlnSum = 18, speed = 30000)
  }

}
