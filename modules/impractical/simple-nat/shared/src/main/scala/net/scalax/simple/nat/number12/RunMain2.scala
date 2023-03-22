package net.scalax.simple.nat.number12

import net.scalax.simple.core.Core2

object RunMain2 extends App {

  for {
    i1 <- 1 to 12
    i2 <- 1 to 12
  } yield {
    var tag1: Long = 0
    var tag2: Long = 0

    def num1(n1: Int, zero: Core2): Core2 = if (n1 > 0) {
      val tail = num1(n1 - 1, zero)
      Core2(other => other()(() => tail))
    } else zero

    def num2(n1: Int, func: () => Unit, zero: Core2): Core2 = if (n1 > 0) {
      val tail = num2(n1 - 1, func, zero)
      Core2 { other =>
        func()
        tail(other)
      }
    } else zero

    lazy val numPositive1: Core2 = num1(i1, numZero1)
    lazy val numZero1: Core2 = Core2 { other =>
      tag1 = tag1 + 1
      numPositive1(other)
    }

    lazy val numPositive2: Core2 = num2(i2, () => tag2 = tag2 + 1, numZero2)
    lazy val numZero2: Core2     = Core2(other => other()(() => numPositive2))

    val result0: BigDecimal = BigDecimal(i1 * i2)
    val cha: BigDecimal     = BigDecimal("0.08")

    def count(c: () => Core2): BigDecimal = {
      tag1 = 0
      tag2 = 0
      try
        c()
      catch {
        case e: StackOverflowError =>
      }
      BigDecimal(tag2) / BigDecimal(tag1)
    }

    val result1: BigDecimal = count(() => numPositive1(() => numPositive2))
    val result2: BigDecimal = count(() => numPositive2(() => numPositive1))
    val result3: BigDecimal = count(() => numPositive1(() => numZero2))
    val result4: BigDecimal = count(() => numZero2(() => numPositive1))
    val result5: BigDecimal = count(() => numZero1(() => numPositive2))
    val result6: BigDecimal = count(() => numPositive2(() => numZero1))
    val result7: BigDecimal = count(() => numZero1(() => numZero2))
    val result8: BigDecimal = count(() => numZero2(() => numZero1))

    println(i1, i2, result0, result1, result2, result3, result4, result5, result6, result7, result8)

    assert((result0 - result1).abs < cha)
    assert((result0 - result2).abs < cha)
    assert((result0 - result3).abs < cha)
    assert((result0 - result4).abs < cha)
    assert((result0 - result5).abs < cha)
    assert((result0 - result6).abs < cha)
    assert((result0 - result7).abs < cha)
    assert((result0 - result8).abs < cha)
  }

}
