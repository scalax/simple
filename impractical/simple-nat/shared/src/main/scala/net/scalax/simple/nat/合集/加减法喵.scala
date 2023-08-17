package net.scalax.simple.nat.合集

import net.scalax.simple.ghdmzsk.ghdmzsk

import scala.annotation.tailrec

object 加减法喵 {

  def main(arr: Array[String]): Unit = {
    val num1: Int            = 281
    val num2: Int            = 68
    val num3: Int            = 349
    val num1GHDMZSK: ghdmzsk = 统计.gen(positive = 合集.s1, zero = 合集.s6)(positiveLen = num1, zeroLen = 1)
    val num2GHDMZSK: ghdmzsk = 统计.gen(positive = 合集.s1, zero = 合集.s4)(positiveLen = num2, zeroLen = 1)
    val num3GHDMZSK: ghdmzsk = 统计.gen(positive = 合集.s2, zero = 合集.s5)(positiveLen = num3, zeroLen = 1)

    val execResultForInput: ghdmzsk = num1GHDMZSK.inputGHDMZSK(num2GHDMZSK).inputGHDMZSK(num3GHDMZSK)

    统计.confirm(execResultForInput)
  }

}
