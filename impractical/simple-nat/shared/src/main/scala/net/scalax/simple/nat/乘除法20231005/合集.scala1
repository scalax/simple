package net.scalax.simple.nat.`乘除法20231005`

import net.scalax.simple.adt.{TypeAdt => Adt}

object 合集 {

  val setter1 = Adt.CoProducts2[NumCountLeft, NumCountRight]
  val setter2 = Adt.CoProducts2[InputNumLeft, InputNumRight]

  // Result
  case class NumCountLeft(tail: () => Adt.CoProduct2[NumCountLeft, NumCountRight])
  case class NumCountRight(tail: () => Adt.CoProduct2[NumCountLeft, NumCountRight])

  abstract class InputNumLeft(num1: () => Adt.CoProduct2[InputNumLeft, InputNumRight]) extends NumCountLeft(num1) {
    def input(
      num2: Adt.CoProduct2[InputNumLeft, InputNumRight],
      num3: Adt.CoProduct2[InputNumLeft, InputNumRight]
    ): Adt.CoProduct2[NumCountLeft, NumCountRight]
  }
  abstract class InputNumRight(num1: () => Adt.CoProduct2[InputNumLeft, InputNumRight]) extends NumCountRight(num1) {
    def input(
      num2: Adt.CoProduct2[InputNumLeft, InputNumRight],
      num3: Adt.CoProduct2[InputNumLeft, InputNumRight]
    ): Adt.CoProduct2[NumCountLeft, NumCountRight]
  }

  class InputNum1(num1: () => Adt.CoProduct2[InputNumLeft, InputNumRight]) extends InputNumLeft(num1) {
    def input(
      num2: Adt.CoProduct2[InputNumLeft, InputNumRight],
      num3: Adt.CoProduct2[InputNumLeft, InputNumRight]
    ): Adt.CoProduct2[NumCountLeft, NumCountRight] = setter1(
      NumCountLeft(() => num1().fold(a => a.input(num2, num3), a => a.input(num2, num3)))
    )
  }

  class InputNum3(num1: () => Adt.CoProduct2[InputNumLeft, InputNumRight]) extends InputNumLeft(num1) {
    def input(
      num2: Adt.CoProduct2[InputNumLeft, InputNumRight],
      num3: Adt.CoProduct2[InputNumLeft, InputNumRight]
    ): Adt.CoProduct2[NumCountLeft, NumCountRight] = num3.fold(a => a.input(num2, num1()), a => a.input(num2, num1()))
  }

  class InputNum5(num1: () => Adt.CoProduct2[InputNumLeft, InputNumRight]) extends InputNumLeft(num1) {
    def input(
      num2: Adt.CoProduct2[InputNumLeft, InputNumRight],
      num3: Adt.CoProduct2[InputNumLeft, InputNumRight]
    ): Adt.CoProduct2[NumCountLeft, NumCountRight] = num2.fold(a => a.input(num1(), num3), a => a.input(num1(), num3))
  }

  class InputNum2(num1: () => Adt.CoProduct2[InputNumLeft, InputNumRight]) extends InputNumRight(num1) {
    def input(
      num2: Adt.CoProduct2[InputNumLeft, InputNumRight],
      num3: Adt.CoProduct2[InputNumLeft, InputNumRight]
    ): Adt.CoProduct2[NumCountLeft, NumCountRight] = setter1(
      NumCountRight(() => num1().fold(a => a.input(num2, num3), a => a.input(num2, num3)))
    )
  }

  class InputNum4(num1: () => Adt.CoProduct2[InputNumLeft, InputNumRight]) extends InputNumRight(num1) {
    def input(
      num2: Adt.CoProduct2[InputNumLeft, InputNumRight],
      num3: Adt.CoProduct2[InputNumLeft, InputNumRight]
    ): Adt.CoProduct2[NumCountLeft, NumCountRight] = num2.fold(a => a.input(num1(), num3), a => a.input(num1(), num3))
  }

  class InputNum6(num1: () => Adt.CoProduct2[InputNumLeft, InputNumRight]) extends InputNumRight(num1) {
    def input(
      num2: Adt.CoProduct2[InputNumLeft, InputNumRight],
      num3: Adt.CoProduct2[InputNumLeft, InputNumRight]
    ): Adt.CoProduct2[NumCountLeft, NumCountRight] = num3.fold(a => a.input(num2, num1()), a => a.input(num2, num1()))
  }

  type InputNum = Adt.CoProduct2[InputNumLeft, InputNumRight]

}
