package net.scalax.simple.nat.不是合集

import net.scalax.simple.ghdmzsk.ghdmzsk

object 乘除法跑我 {

  def main1(arr: Array[String]): Unit = {
    object num1 {
      val Parent: Int = 105
      val Sub: Int    = 5
    }
    object num2 {
      val Parent: Int = 4
      val Sub: Int    = 32
    }
    object num3 {
      val Parent: Int = 42
      val Sub: Int    = 16
    }
    lazy val num1GHDMZSK: ghdmzsk      = 统计.gen(合集.y.b, () => num1GHDMZSKOther)(numberLen = num1.Parent)
    lazy val num1GHDMZSKOther: ghdmzsk = 统计.gen(合集.y.a, () => num1GHDMZSK)(numberLen = num1.Sub)

    lazy val num2GHDMZSK: ghdmzsk      = 统计.gen(合集.y.a, () => num2GHDMZSKOther)(numberLen = num2.Parent)
    lazy val num2GHDMZSKOther: ghdmzsk = 统计.gen(合集.x.b, () => num2GHDMZSK)(numberLen = num2.Sub)

    lazy val num3GHDMZSK: ghdmzsk      = 统计.gen(合集.y.b, () => num3GHDMZSKOther)(numberLen = num3.Parent)
    lazy val num3GHDMZSKOther: ghdmzsk = 统计.gen(合集.x.a, () => num3GHDMZSK)(numberLen = num3.Sub)

    统计.confirm(num1GHDMZSK.inputGHDMZSK(() => num2GHDMZSK).inputGHDMZSK(() => num3GHDMZSK), brokeNum = 200000)
    统计.confirm(num1GHDMZSK.inputGHDMZSK(() => num3GHDMZSK).inputGHDMZSK(() => num2GHDMZSK), brokeNum = 200000)
    统计.confirm(num2GHDMZSK.inputGHDMZSK(() => num1GHDMZSK).inputGHDMZSK(() => num3GHDMZSK), brokeNum = 200000)
    统计.confirm(num2GHDMZSK.inputGHDMZSK(() => num3GHDMZSK).inputGHDMZSK(() => num1GHDMZSK), brokeNum = 200000)
    统计.confirm(num3GHDMZSK.inputGHDMZSK(() => num1GHDMZSK).inputGHDMZSK(() => num2GHDMZSK), brokeNum = 200000)
    统计.confirm(num3GHDMZSK.inputGHDMZSK(() => num2GHDMZSK).inputGHDMZSK(() => num1GHDMZSK), brokeNum = 200000)
    println("===验证完毕===")
  }

}
