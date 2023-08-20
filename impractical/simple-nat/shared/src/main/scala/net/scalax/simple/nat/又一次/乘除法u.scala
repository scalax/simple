package net.scalax.simple.nat.又一次

import net.scalax.simple.ghdmzsk.ghdmzsk

object 嘿嘿嘿嘿 {
  val NC: NumberCollection.type = NumberCollection
  val CF: CountFunction.type    = CountFunction

  def main(arr: Array[String]): Unit = {
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
    lazy val num1GHDMZSK: ghdmzsk =
      CF.gen(leftBuilder = NC.y.b, rightBuilder = NC.y.a)(leftLength = num1.Parent, rightLength = num1.Sub)(selfNumber = num1GHDMZSK)
    lazy val num2GHDMZSK: ghdmzsk =
      CF.gen(leftBuilder = NC.y.a, rightBuilder = NC.x.b)(leftLength = num2.Parent, rightLength = num2.Sub)(selfNumber = num2GHDMZSK)
    lazy val num3GHDMZSK: ghdmzsk =
      CF.gen(leftBuilder = NC.y.b, rightBuilder = NC.x.a)(leftLength = num3.Parent, rightLength = num3.Sub)(selfNumber = num3GHDMZSK)

    val brokeNum: Int = 200000
    val maxCount: Int = 800000
    CountFunction.confirm(num1GHDMZSK.inputGHDMZSK(num2GHDMZSK).inputGHDMZSK(num3GHDMZSK), brokeNum = brokeNum, maxCount = maxCount)
    CountFunction.confirm(num1GHDMZSK.inputGHDMZSK(num3GHDMZSK).inputGHDMZSK(num2GHDMZSK), brokeNum = brokeNum, maxCount = maxCount)
    CountFunction.confirm(num2GHDMZSK.inputGHDMZSK(num1GHDMZSK).inputGHDMZSK(num3GHDMZSK), brokeNum = brokeNum, maxCount = maxCount)
    CountFunction.confirm(num2GHDMZSK.inputGHDMZSK(num3GHDMZSK).inputGHDMZSK(num1GHDMZSK), brokeNum = brokeNum, maxCount = maxCount)
    CountFunction.confirm(num3GHDMZSK.inputGHDMZSK(num1GHDMZSK).inputGHDMZSK(num2GHDMZSK), brokeNum = brokeNum, maxCount = maxCount)
    CountFunction.confirm(num3GHDMZSK.inputGHDMZSK(num2GHDMZSK).inputGHDMZSK(num1GHDMZSK), brokeNum = brokeNum, maxCount = maxCount)
    println("===验证完毕===")
  }

}
