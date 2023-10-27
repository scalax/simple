package net.scalax.simple.nat.乘除法20231027

object 合集 {

  // Result
  case class NumCountLeft(tail: () => Either[NumCountLeft, NumCountRight])
  case class NumCountRight(tail: () => Either[NumCountLeft, NumCountRight])

  class InputNum1Left(tail: () => Either[InputNum1Left, InputNum2Left]) {
    def input1(other: Either[InputNum1Right, InputNum2Right]): Either[NumCountLeft, NumCountRight] = tail().fold(
      n1 =>
        other.fold(
          u1 => Left(NumCountLeft(() => n1.input1(Left(u1)))),
          u2 => Left(NumCountLeft(() => n1.input1(Right(u2))))
        ),
      n2 =>
        other.fold(
          u1 => Left(NumCountLeft(() => n2.input2(Left(u1)))),
          u2 => Left(NumCountLeft(() => n2.input2(Right(u2))))
        )
    )
  }

  class InputNum2Left(tail: () => Either[InputNum1Left, InputNum2Left]) {
    def input2(other: Either[InputNum1Right, InputNum2Right]): Either[NumCountLeft, NumCountRight] = tail().fold(
      n1 => other.fold(u1 => u1.input3(Left(n1)), u2 => u2.input4(Left(n1))),
      n2 => other.fold(u1 => u1.input3(Right(n2)), u2 => u2.input4(Right(n2)))
    )
  }

  class InputNum1Right(tail: () => Either[InputNum1Right, InputNum2Right]) {
    def input3(other: Either[InputNum1Left, InputNum2Left]): Either[NumCountLeft, NumCountRight] = tail().fold(
      n1 => other.fold(u1 => u1.input1(Left(n1)), u2 => u2.input2(Left(n1))),
      n2 => other.fold(u1 => u1.input1(Right(n2)), u2 => u2.input2(Right(n2)))
    )
  }

  class InputNum2Right(tail: () => Either[InputNum1Right, InputNum2Right]) {
    def input4(other: Either[InputNum1Left, InputNum2Left]): Either[NumCountLeft, NumCountRight] = tail().fold(
      n1 =>
        other.fold(
          u1 => Right(NumCountRight(() => n1.input3(Left(u1)))),
          u2 => Right(NumCountRight(() => n1.input3(Right(u2))))
        ),
      n2 =>
        other.fold(
          u1 => Right(NumCountRight(() => n2.input4(Left(u1)))),
          u2 => Right(NumCountRight(() => n2.input4(Right(u2))))
        )
    )
  }

}
