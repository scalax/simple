package net.scalax.simple.nat.合集

import net.scalax.simple.ghdmzsk.ghdmzsk

import scala.annotation.tailrec

object 乘除法喵 {

  def main(arr: Array[String]): Unit = {
    object num1 {
      val Parent: Int = 42
      val Sub: Int    = 16
    }
    object num2 {
      val Parent: Int = 105
      val Sub: Int    = 5
    }
    object num3 {
      val Parent: Int = 4
      val Sub: Int    = 32
    }
    val num1GHDMZSK: ghdmzsk = 统计.gen(positive = 合集.s6, zero = 合集.s1)(positiveLen = num1.Parent, zeroLen = num1.Sub)
    val num2GHDMZSK: ghdmzsk = 统计.gen(positive = 合集.s6, zero = 合集.s4)(positiveLen = num2.Parent, zeroLen = num2.Sub)
    val num3GHDMZSK: ghdmzsk = 统计.gen(positive = 合集.s4, zero = 合集.s2)(positiveLen = num3.Parent, zeroLen = num3.Sub)

    val execResultForInput: ghdmzsk = num1GHDMZSK.inputGHDMZSK(num2GHDMZSK).inputGHDMZSK(num3GHDMZSK)

    统计.confirm(execResultForInput)
  }

}
