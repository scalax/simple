package net.scalax.simple.nat.合集1

object 合集 {

  sealed trait InputNum {
    def input(num2: InputNum, num3: InputNum): 统计.NumCount
  }

  case class InputNum1(num1: () => InputNum) extends InputNum {
    def input(num2: InputNum, num3: InputNum): 统计.NumCount = 统计.NumCountLeft(() => num1().input(num2, num3))
  }

  case class InputNum2(num1: () => InputNum) extends InputNum {
    def input(num2: InputNum, num3: InputNum): 统计.NumCount = 统计.NumCountRight(() => num1().input(num2, num3))
  }

  case class InputNum3(num1: () => InputNum) extends InputNum {
    def input(num2: InputNum, num3: InputNum): 统计.NumCount = num3.input(num1(), num2)
  }

  case class InputNum4(num1: () => InputNum) extends InputNum {
    def input(num2: InputNum, num3: InputNum): 统计.NumCount = num3.input(num2, num1())
  }

  case class InputNum5(num1: () => InputNum) extends InputNum {
    def input(num2: InputNum, num3: InputNum): 统计.NumCount = num2.input(num3, num1())
  }

  case class InputNum6(num1: () => InputNum) extends InputNum {
    def input(num2: InputNum, num3: InputNum): 统计.NumCount = num2.input(num1(), num3)
  }

  case class InputNum7(num1: () => InputNum) extends InputNum {
    def input(num2: InputNum, num3: InputNum): 统计.NumCount = 统计.NumCountLeft(() => num2.input(num1(), num3))
  }

}
