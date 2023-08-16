package net.scalax.simple.nat.合集

import net.scalax.simple.ghdmzsk.ghdmzsk

import scala.annotation.tailrec

object 乘除法喵 {

  def main(arr: Array[String]): Unit = {
    val num1: Int            = 672
    val num2: Int            = 21
    val num3: Int            = 32
    val num1GHDMZSK: ghdmzsk = 统计.gen(合集.s6, 合集.s1, num1)
    val num2GHDMZSK: ghdmzsk = 统计.gen(合集.s6, 合集.s4, num2)
    val num3GHDMZSK: ghdmzsk = 统计.gen(合集.s4, 合集.s2, num3)

    val execResultForInput: ghdmzsk = num1GHDMZSK.inputGHDMZSK(num2GHDMZSK).inputGHDMZSK(num3GHDMZSK)

    统计.confirm(execResultForInput)
  }

}
