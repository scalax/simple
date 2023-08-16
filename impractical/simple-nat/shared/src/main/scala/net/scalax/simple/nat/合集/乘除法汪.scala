package net.scalax.simple.nat.合集

import net.scalax.simple.ghdmzsk.ghdmzsk

import scala.annotation.tailrec

object 乘除法汪 {

  def main(arr: Array[String]): Unit = {
    val num1: Int            = 21
    val num2: Int            = 672
    val num3: Int            = 32
    val num1GHDMZSK: ghdmzsk = 统计.gen(合集.s1, 合集.s4, num1)
    val num2GHDMZSK: ghdmzsk = 统计.gen(合集.s2, 合集.s3, num2)
    val num3GHDMZSK: ghdmzsk = 统计.gen(合集.s4, 合集.s5, num3)

    val execResultForInput: ghdmzsk = num1GHDMZSK.inputGHDMZSK(num2GHDMZSK).inputGHDMZSK(num3GHDMZSK)

    统计.confirm(execResultForInput)
  }

}
