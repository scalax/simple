package net.scalax.simple.nat.number12

import net.scalax.simple.ghdmzsk.ghdmzsk

object RunMain1 extends App {

  for {
    i1 <- 1 to 20
    i2 <- 1 to 20
  } yield {
    var tag1: Long = 0
    var tag2: Long = 0

    def num1(n1: Int, zero: ghdmzsk): ghdmzsk = if (n1 > 0)
      Number.number2(() => num1(n1 - 1, zero))
    else zero

    lazy val numPositive1: ghdmzsk = num1(i1, numZero1)
    lazy val numZero1: ghdmzsk = Number.number1 { () =>
      tag1 = tag1 + 1
      numPositive1
    }

    lazy val numPositive2: ghdmzsk = num1(i2, numZero2)
    lazy val numZero2: ghdmzsk = Number.number1 { () =>
      tag2 = tag2 + 1
      numPositive2
    }

    val result0: BigDecimal = BigDecimal(i1) / BigDecimal(i2)
    val cha: BigDecimal     = BigDecimal("0.008")

    def count(c: () => ghdmzsk): BigDecimal = {
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
