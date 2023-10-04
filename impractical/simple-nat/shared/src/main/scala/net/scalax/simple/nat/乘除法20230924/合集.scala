package net.scalax.simple.nat.合集1

import net.scalax.simple.adt.{TypeAdt => Adt}

object 合集 {

  val setter1 = Adt.CoProducts2[NumCountLeft, NumCountRight]

  // Result
  case class NumCountLeft(tail: () => Adt.CoProduct2[NumCountLeft, NumCountRight])
  case class NumCountRight(tail: () => Adt.CoProduct2[NumCountLeft, NumCountRight])

  abstract class InputNumLeft(tail: () => Adt.CoProduct2[InputNumLeft, InputNumRight])
      extends NumCountLeft(tail = () => tail().fold(a => setter1(a), a => setter1(a)))
  abstract class InputNumRight(tail: () => Adt.CoProduct2[InputNumLeft, InputNumRight])
      extends NumCountRight(tail = () => tail().fold(a => setter1(a), a => setter1(a)))

  trait CLeft
  trait CRight

  // NUMAB
  abstract class InputNum(tail: () => InputNum) {
    def input(num2: InputNum, num3: InputNum): Adt.CoProduct2[NumCountLeft, NumCountRight]
  }

  case class InputNum1(num1: () => InputNum) extends InputNum(num1) with CLeft {
    def input(num2: InputNum, num3: InputNum): Adt.CoProduct2[NumCountLeft, NumCountRight] =
      Adt.CoProducts2[NumCountLeft, NumCountRight](NumCountLeft(() => num1().input(num2, num3)))
  }

  case class InputNum2(num1: () => InputNum) extends InputNum(num1) with CRight {
    def input(num2: InputNum, num3: InputNum): Adt.CoProduct2[NumCountLeft, NumCountRight] =
      Adt.CoProducts2[NumCountLeft, NumCountRight](NumCountRight(() => num1().input(num2, num3)))
  }

  case class InputNum3(num1: () => InputNum) extends InputNum(num1) with CLeft {
    def input(num2: InputNum, num3: InputNum): Adt.CoProduct2[NumCountLeft, NumCountRight] = num3.input(num2, num1())
  }

  case class InputNum4(num1: () => InputNum) extends InputNum(num1) with CRight {
    def input(num2: InputNum, num3: InputNum): Adt.CoProduct2[NumCountLeft, NumCountRight] = num2.input(num1(), num3)
  }

  case class InputNum5(num1: () => InputNum) extends InputNum(num1) with CLeft {
    def input(num2: InputNum, num3: InputNum): Adt.CoProduct2[NumCountLeft, NumCountRight] = num2.input(num1(), num3)
  }

  case class InputNum6(num1: () => InputNum) extends InputNum(num1) with CRight {
    def input(num2: InputNum, num3: InputNum): Adt.CoProduct2[NumCountLeft, NumCountRight] = num3.input(num2, num1())
  }

}
