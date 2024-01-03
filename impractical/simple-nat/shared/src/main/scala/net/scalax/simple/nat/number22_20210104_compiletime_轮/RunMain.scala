package net.scalax.simple.nat.number22

import scala.annotation.tailrec

object RunTest1 {

  def build(分子: Long, 分母: Long): Either[Number1, Number1] = {
    def buildImpl(isFenmu: Boolean, numLong: Long, zero: () => Either[Number1, Number1]): Either[Number1, Number1] = {
      if (numLong > 0) {
        if (isFenmu) {
          Number1.input1(() => buildImpl(isFenmu = isFenmu, numLong = numLong - 1, zero))
        } else {
          Number1.input2(() => buildImpl(isFenmu = isFenmu, numLong = numLong - 1, zero))
        }
      } else {
        zero()
      }
    }

    lazy val build1: Either[Number1, Number1] = buildImpl(isFenmu = false, numLong = 分子, zero = () => build2)
    lazy val build2: Either[Number1, Number1] = buildImpl(isFenmu = true, numLong = 分母, zero = () => build1)

    build1
  }

  @tailrec
  def countImpl(
    num: () => Either[Number1, Number1],
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
        case Left(num) =>
          countImpl(
            num.tail,
            current分子 = current分子,
            current分母 = current分母 + 1,
            exceptResult = exceptResult,
            printlnSum = if (needPrintln) printlnSum - 1 else printlnSum,
            speed = speed
          )
        case Right(num) =>
          countImpl(
            num.tail,
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

  def count(num: () => Either[Number1, Number1], except1: BigDecimal, except2: BigDecimal, printlnSum: Int, speed: Long = 800000): Unit =
    countImpl(num = num, current分子 = 1, current分母 = 1, exceptResult = except1 / except2, printlnSum = printlnSum, speed = speed)

  def main(arr: Array[String]): Unit = {
    val 分子1: Long = 123
    val 分母1: Long = 4342
    val 分子2: Long = 328
    val 分母2: Long = 15

    val except1: BigDecimal = BigDecimal(分子1) / BigDecimal(分母1)
    val except2: BigDecimal = BigDecimal(分子2) / BigDecimal(分母2)

    val num1: Either[Number1, Number1] = build(分子 = 分子1, 分母 = 分母1)
    val num2: Either[Number1, Number1] = build(分子 = 分子2, 分母 = 分母2)

    val result1: () => Either[Number1, Number1] = () => num1.fold(num => num.input(Right(num2)), num => num.input(Right(num2)))

    count(result1, except1 = except1, except2 = except2, printlnSum = 10, speed = 3000000)

    // ===
    val 分子3: Long = 32
    val 分母3: Long = 982

    val except3: BigDecimal = except1 / except2
    val except4: BigDecimal = BigDecimal(分子3) / BigDecimal(分母3)

    val num3: Either[Number1, Number1] = build(分子 = 分子3, 分母 = 分母3)

    val result2: () => Either[Number1, Number1] = () => result1().fold(num => num.input(Right(num3)), num => num.input(Right(num3)))

    count(result2, except1 = except3, except2 = except4, printlnSum = 10, speed = 600000)

    // ===
    val except5: BigDecimal = except3 / except4
    val except6: BigDecimal = except3

    val result3: () => Either[Number1, Number1] = () =>
      result2().fold(num => num.input(Right(result1())), num => num.input(Right(result1())))
    count(result3, except1 = except5, except2 = except6, printlnSum = 18, speed = 30000)

    val result4: () => Either[Number1, Number1] = () =>
      result2().fold(num => num.input(Right(result1())), num => num.input(Left(result1())))
    count(result4, except1 = except6, except2 = except5, printlnSum = 18, speed = 30000)
  }

}
