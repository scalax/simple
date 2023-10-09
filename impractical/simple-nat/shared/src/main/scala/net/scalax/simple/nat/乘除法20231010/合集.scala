package net.scalax.simple.nat.乘除法20231010

import net.scalax.simple.adt.{TypeAdt => Adt}

object 合集 {

  val setter1 = Adt.CoProducts2[NumCountLeft, NumCountRight]
  val setter2 = Adt.CoProducts2[InputNumLeft, InputNumRight]

  // Result
  case class NumCountLeft(tail: () => Adt.CoProduct2[NumCountLeft, NumCountRight])
  case class NumCountRight(tail: () => Adt.CoProduct2[NumCountLeft, NumCountRight])

  abstract class InputNumLeft(num1: () => Adt.CoProduct2[InputNumLeft, InputNumRight]) extends NumCountLeft(num1) {
    def input(other: Map[Int, Adt.CoProduct2[InputNumLeft, InputNumRight]]): Adt.CoProduct2[NumCountLeft, NumCountRight]
  }
  abstract class InputNumRight(num1: () => Adt.CoProduct2[InputNumLeft, InputNumRight]) extends NumCountRight(num1) {
    def input(other: Map[Int, Adt.CoProduct2[InputNumLeft, InputNumRight]]): Adt.CoProduct2[NumCountLeft, NumCountRight]
  }

  class InputNum1(num1: () => Adt.CoProduct2[InputNumLeft, InputNumRight]) extends InputNumLeft(num1) {
    def input(other: Map[Int, Adt.CoProduct2[InputNumLeft, InputNumRight]]): Adt.CoProduct2[NumCountLeft, NumCountRight] = setter1(
      NumCountLeft(() => num1().fold(a => a.input(other), a => a.input(other)))
    )
  }

  class InputNum2(num1: () => Adt.CoProduct2[InputNumLeft, InputNumRight]) extends InputNumRight(num1) {
    def input(other: Map[Int, Adt.CoProduct2[InputNumLeft, InputNumRight]]): Adt.CoProduct2[NumCountLeft, NumCountRight] =
      other(2).fold(a => a.input(other + ((1, num1()))), a => a.input(other + ((1, num1()))))
  }

  class InputNum3(num2: () => Adt.CoProduct2[InputNumLeft, InputNumRight]) extends InputNumLeft(num2) {
    def input(other: Map[Int, Adt.CoProduct2[InputNumLeft, InputNumRight]]): Adt.CoProduct2[NumCountLeft, NumCountRight] =
      other(1).fold(a => a.input(other + ((2, num2()))), a => a.input(other + ((2, num2()))))
  }

  class InputNum4(num2: () => Adt.CoProduct2[InputNumLeft, InputNumRight]) extends InputNumRight(num2) {
    def input(other: Map[Int, Adt.CoProduct2[InputNumLeft, InputNumRight]]): Adt.CoProduct2[NumCountLeft, NumCountRight] =
      other(3).fold(a => a.input(other + ((2, num2()))), a => a.input(other + ((2, num2()))))
  }

  class InputNum5(num3: () => Adt.CoProduct2[InputNumLeft, InputNumRight]) extends InputNumLeft(num3) {
    def input(other: Map[Int, Adt.CoProduct2[InputNumLeft, InputNumRight]]): Adt.CoProduct2[NumCountLeft, NumCountRight] =
      other(2).fold(a => a.input(other + ((3, num3()))), a => a.input(other + ((3, num3()))))
  }

  class InputNum6(num3: () => Adt.CoProduct2[InputNumLeft, InputNumRight]) extends InputNumRight(num3) {
    def input(other: Map[Int, Adt.CoProduct2[InputNumLeft, InputNumRight]]): Adt.CoProduct2[NumCountLeft, NumCountRight] = setter1(
      NumCountRight(() => num3().fold(a => a.input(other), a => a.input(other)))
    )
  }

  type InputNum = Adt.CoProduct2[InputNumLeft, InputNumRight]

}
