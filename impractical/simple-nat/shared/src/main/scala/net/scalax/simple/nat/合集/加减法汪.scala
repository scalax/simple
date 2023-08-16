package net.scalax.simple.nat.合集

import net.scalax.simple.ghdmzsk.ghdmzsk

import scala.annotation.tailrec

object 加减法汪 {

  def main(arr: Array[String]): Unit = {
    val num1: Int            = 281
    val num2: Int            = 68
    val num3: Int            = 349
    val num1GHDMZSK: ghdmzsk = 统计.gen(合集.s3, 合集.s7, num1)
    val num2GHDMZSK: ghdmzsk = 统计.gen(合集.s3, 合集.s6, num2)
    val num3GHDMZSK: ghdmzsk = 统计.gen(合集.s5, 合集.s2, num3)

    val execResultForInput: ghdmzsk = num1GHDMZSK.inputGHDMZSK(num2GHDMZSK).inputGHDMZSK(num3GHDMZSK)

    统计.confirm(execResultForInput)
  }

}
