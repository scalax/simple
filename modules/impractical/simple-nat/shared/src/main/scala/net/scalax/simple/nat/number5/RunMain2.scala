package net.scalax.simple
package nat
package number5

object RunMain2 {

  def countNumber3(number: Number3): Int = number match {
    case Number3S(tail) => countNumber3(tail) + 1
    case Number3T       => 0
  }

  def nextNumber2_1(number: Number2): Number2 = number match {
    case Number2S(tail) => tail()
    case Number2T(tail) => nextNumber2_1(tail())
  }

  def nextNumber2_2(number: Number2): Number2 = (number match {
    case Number2S(tail) => tail()
    case Number2T(tail) => tail()
  }) match {
    case current @ Number2S(_) => current
    case Number2T(tail)        => tail()
  }

  def number1Gen(n: Int): Number1                   = if (n > 0) Number1S(number1Gen(n - 1)) else Number1T
  def number2Gen(n: Int, zero: => Number2): Number2 = if (n > 0) Number2T(() => number2Gen(n - 1, zero)) else zero

  def main(arr: Array[String]): Unit = {
    locally {
      for {
        i1 <- 1 to 20
        i2 <- 1 to 20
      } {
        val number1: Number1              = number1Gen(i1)
        lazy val number2Positive: Number2 = number2Gen(i2, number2Zero)
        lazy val number2Zero: Number2     = Number2S(() => number2Positive)

        val result: Int = i1 * i2

        val loopCount: Int = 50000

        val compareResult_1: Int = {
          var currentNum: Number2 = number2Positive
          var list: List[Int]     = List.empty[Int]
          for (_ <- 0 to loopCount) {
            val currentCompareResult = countNumber3(number1.method1(currentNum))
            list = currentCompareResult :: list
            currentNum = nextNumber2_1(currentNum)
          }
          list.max
        }

        val compareResult_2: BigDecimal = {
          var currentNum: Number2 = number2Positive
          var list: List[Int]     = List.empty[Int]
          for (_ <- 0 to loopCount) {
            val currentCompareResult = countNumber3(currentNum.method2(number1))
            list = currentCompareResult :: list
            currentNum = nextNumber2_2(currentNum)
          }
          list.min
        }

        println(i1, i2, result, compareResult_1, compareResult_2)
        assert(result == compareResult_1)
        assert(result == compareResult_2)
        assert(countNumber3(number1.method1(number2Positive)) == i1 * i2)
        assert(countNumber3(number2Zero.method2(number1)) == i1 * i2)
      }
    }
  }

}
