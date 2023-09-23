package net.scalax.simple.nat.合集1

object 乘除法喵 {

  def main1(arr: Array[String]): Unit = {
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
    lazy val num1GHDMZSK: 合集.InputNum =
      统计.gen(leftBuilder = t => 合集.InputNum6(t), rightBuilder = t => 合集.InputNum1(t))(leftLength = num1.Parent, rightLength = num1.Sub)(
        num1GHDMZSK
      )
    lazy val num2GHDMZSK: 合集.InputNum =
      统计.gen(leftBuilder = t => 合集.InputNum6(t), rightBuilder = t => 合集.InputNum4(t))(leftLength = num2.Parent, rightLength = num2.Sub)(
        num2GHDMZSK
      )
    lazy val num3GHDMZSK: 合集.InputNum =
      统计.gen(leftBuilder = t => 合集.InputNum4(t), rightBuilder = t => 合集.InputNum2(t))(leftLength = num3.Parent, rightLength = num3.Sub)(
        num3GHDMZSK
      )

    val execResultForInput: 统计.NumCount = num1GHDMZSK.input(num2GHDMZSK, num3GHDMZSK)

    统计.confirm(() => execResultForInput, brokeNum = 300000)
  }

}
