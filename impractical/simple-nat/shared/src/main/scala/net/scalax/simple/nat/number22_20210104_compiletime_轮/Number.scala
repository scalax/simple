package net.scalax.simple.nat.number22

abstract class Number1(val tail: () => Either[Number1, Number1]) {
  val input: Either[Either[Number1, Number1], Either[Number1, Number1]] => Either[Number1, Number1]
}

object Number1 {
  def input1(inputParam: () => Either[Number1, Number1]): Number1 = new Number1(inputParam) {
    override val input: Either[Either[Number1, Number1], Either[Number1, Number1]] => Either[Number1, Number1] = otherParam =>
      otherParam.fold(
        otherImpl => otherImpl.fold(other => other.input(Right(tail())), other => other.input(Right(tail()))),
        otherImpl => otherImpl.fold(other => other.input(Left(tail())), other => other.input(Left(tail())))
      )
  }

  def input2(inputParam: () => Either[Number1, Number1]): Number1 = new Number1(inputParam) {
    override val input: Either[Either[Number1, Number1], Either[Number1, Number1]] => Either[Number1, Number1] = otherParam =>
      otherParam.fold(
        otherImpl =>
          Left(Number1.input._1(() => tail().fold(tail_in => tail_in.input(Left(otherImpl)), tail_in => tail_in.input(Left(otherImpl))))),
        otherImpl =>
          Right(Number1.input._2(() => tail().fold(tail_in => tail_in.input(Right(otherImpl)), tail_in => tail_in.input(Right(otherImpl)))))
      )
  }

  val input: Tuple2[(() => Either[Number1, Number1]) => Number1, (() => Either[Number1, Number1]) => Number1] =
    Tuple2(i1 => input1(i1), i1 => input2(i1))
}
