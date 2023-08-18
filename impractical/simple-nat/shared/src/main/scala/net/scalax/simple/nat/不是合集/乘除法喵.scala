package net.scalax.simple.nat.不是合集

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
    lazy val num1GHDMZSK: ghdmzsk      = 统计.gen(合集.s3, num1GHDMZSKOther)(num1.Parent)
    lazy val num1GHDMZSKOther: ghdmzsk = 统计.gen(合集.s1, num1GHDMZSK)(num1.Sub)

    lazy val num2GHDMZSK: ghdmzsk      = 统计.gen(合集.s3, num2GHDMZSKOther)(num2.Parent)
    lazy val num2GHDMZSKOther: ghdmzsk = 统计.gen(合集.s3, num2GHDMZSK)(num2.Sub, deep = 3)

    lazy val num3GHDMZSK: ghdmzsk      = 统计.gen(合集.s3, num3GHDMZSKOther)(num3.Parent, deep = 3)
    lazy val num3GHDMZSKOther: ghdmzsk = 统计.gen(合集.s2, num3GHDMZSK)(num3.Sub)

    val execResultForInput: ghdmzsk = num1GHDMZSK.inputGHDMZSK(num2GHDMZSK).inputGHDMZSK(num3GHDMZSK)

    统计.confirm(execResultForInput, brokeNum = 200000)
  }

}
