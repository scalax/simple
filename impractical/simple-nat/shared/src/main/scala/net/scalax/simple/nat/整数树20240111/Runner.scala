package 整数树20240111

object Runner {

  // 倒模，起个轮廓
  case class Number1(tail1: () => Number1, tail2: () => Number2)
  case class Number2(tail1: () => Number1, tail2: () => Number2)

  lazy val number1Zero: Number1 = Number1(tail1 = () => number1Zero, tail2 = () => number2Zero)
  lazy val number2Zero: Number2 = Number2(tail1 = () => number1Zero, tail2 = () => number2Zero)

}
