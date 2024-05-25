package net.scalax.simple.nat.乘除法20231027

import net.scalax.simple.adt.{TypeAdt => Adt}

object 乘除法喵 {

  import 合集._

  def main1(arr: Array[String]): Unit = {

    object num1 {
      val Parent: Int = 547
      val Sub: Int    = 24
    }
    object num2 {
      val Parent: Int = 485
      val Sub: Int    = 711
    }

    lazy val num1GHDMZSK: Either[InputNum1Left, InputNum2Left] =
      统计.genLeft(leftLength = num1.Sub, rightLength = num1.Parent)(() => num1GHDMZSK)
    lazy val num2GHDMZSK: Either[InputNum1Right, InputNum2Right] =
      统计.genRight(leftLength = num2.Sub, rightLength = num2.Parent)(() => num2GHDMZSK)

    val execResultForInput: Either[NumCountLeft, NumCountRight] =
      num1GHDMZSK.fold(n1 => n1.input1(num2GHDMZSK), n2 => n2.input2(num2GHDMZSK))

    val bigDecimal1: BigDecimal = BigDecimal(num1.Parent) / BigDecimal(num1.Sub)
    val bigDecimal2: BigDecimal = BigDecimal(num2.Parent) / BigDecimal(num2.Sub)
    统计.confirm(forConfirm = () => execResultForInput, except = bigDecimal1 * bigDecimal2)

    println("2000" * 100)

  }

}
