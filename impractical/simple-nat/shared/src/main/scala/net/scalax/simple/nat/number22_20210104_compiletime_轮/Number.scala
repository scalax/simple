package net.scalax.simple.nat.number22

abstract class Number1(val tail: () => Either[Number1, Number1]) {
  def input(other: () => Either[Either[Number1, Number1], Either[Number1, Number1]]): Either[Number1, Number1]
}

object Number1 {
  def input1(inputParam: () => Either[Number1, Number1]): Either[Number1, Number1] = Left(new Number1(inputParam) {
    override def input(otherParam: () => Either[Either[Number1, Number1], Either[Number1, Number1]]): Either[Number1, Number1] =
      otherParam().fold(
        otherImpl => otherImpl.fold(other => other.input(() => Right(tail())), other => other.input(() => Right(tail()))),
        otherImpl => otherImpl.fold(other => other.input(() => Left(tail())), other => other.input(() => Left(tail())))
      )
  })

  def input2(inputParam: () => Either[Number1, Number1]): Either[Number1, Number1] = Right(new Number1(inputParam) {
    override def input(
      otherParam: () => Either[Either[Number1, Number1], Either[Number1, Number1]]
    ): Either[Number1, Number1] = otherParam().fold(
      otherImpl =>
        Number1.input1(() => tail().fold(tail_in => tail_in.input(() => Left(otherImpl)), tail_in => tail_in.input(() => Left(otherImpl)))),
      otherImpl =>
        Number1.input2(() =>
          tail().fold(tail_in => tail_in.input(() => Right(otherImpl)), tail_in => tail_in.input(() => Right(otherImpl)))
        )
    )
  })
}
