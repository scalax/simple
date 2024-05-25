package net.scalax.simple.nat.乘除法20231026

import net.scalax.simple.adt.{TypeAdt => Adt}

object 合集 {

  val setterCount = Adt.CoProducts2[NumCountLeft, NumCountRight]
  val setterLeft  = Adt.CoProducts2[InputNum1Left, InputNum2Left]
  val setterRight = Adt.CoProducts2[InputNum1Right, InputNum2Right]

  // Result
  case class NumCountLeft(tail: () => Adt.CoProduct2[NumCountLeft, NumCountRight])
  case class NumCountRight(tail: () => Adt.CoProduct2[NumCountLeft, NumCountRight])

  class InputNum1Left(tail: () => Adt.CoProduct2[InputNum1Left, InputNum2Left]) {
    def input1(other: Adt.CoProduct2[InputNum1Right, InputNum2Right]): Adt.CoProduct2[NumCountLeft, NumCountRight] = tail().fold(
      n1 =>
        other.fold(
          u1 => setterCount(NumCountLeft(() => n1.input1(setterRight(u1)))),
          u2 => setterCount(NumCountLeft(() => n1.input1(setterRight(u2))))
        ),
      n2 =>
        other.fold(
          u1 => setterCount(NumCountLeft(() => n2.input2(setterRight(u1)))),
          u2 => setterCount(NumCountLeft(() => n2.input2(setterRight(u2))))
        )
    )
  }

  class InputNum2Left(tail: () => Adt.CoProduct2[InputNum1Left, InputNum2Left]) {
    def input2(other: Adt.CoProduct2[InputNum1Right, InputNum2Right]): Adt.CoProduct2[NumCountLeft, NumCountRight] = tail().fold(
      n1 => other.fold(u1 => u1.input3(setterLeft(n1)), u2 => u2.input4(setterLeft(n1))),
      n2 => other.fold(u1 => u1.input3(setterLeft(n2)), u2 => u2.input4(setterLeft(n2)))
    )
  }

  class InputNum1Right(tail: () => Adt.CoProduct2[InputNum1Right, InputNum2Right]) {
    def input3(other: Adt.CoProduct2[InputNum1Left, InputNum2Left]): Adt.CoProduct2[NumCountLeft, NumCountRight] = tail().fold(
      n1 => other.fold(u1 => u1.input1(setterRight(n1)), u2 => u2.input2(setterRight(n1))),
      n2 => other.fold(u1 => u1.input1(setterRight(n2)), u2 => u2.input2(setterRight(n2)))
    )
  }

  class InputNum2Right(tail: () => Adt.CoProduct2[InputNum1Right, InputNum2Right]) {
    def input4(other: Adt.CoProduct2[InputNum1Left, InputNum2Left]): Adt.CoProduct2[NumCountLeft, NumCountRight] = tail().fold(
      n1 =>
        other.fold(
          u1 => setterCount(NumCountRight(() => n1.input3(setterLeft(u1)))),
          u2 => setterCount(NumCountRight(() => n1.input3(setterLeft(u2))))
        ),
      n2 =>
        other.fold(
          u1 => setterCount(NumCountRight(() => n2.input4(setterLeft(u1)))),
          u2 => setterCount(NumCountRight(() => n2.input4(setterLeft(u2))))
        )
    )
  }

}
