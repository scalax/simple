package net.scalax.simple
package nat
package number11

object RunMain1 {

  def countNumber3(number: Number3): Int = number match {
    case Number3S(tail) => countNumber3(tail) + 1
    case Number3T       => 0
  }

  def nextNumber2(number: Number2): Number2 = number match {
    case Number2S(tail) => tail()
    case Number2T(tail) => tail()
  }

  def number1Gen(n: Int): Number1                   = if (n > 0) Number1S(number1Gen(n - 1)) else Number1T
  def number2Gen(n: Int, zero: => Number2): Number2 = if (n > 0) Number2S(() => number2Gen(n - 1, zero)) else zero

  def main(arr: Array[String]): Unit = {
    locally {
      for {
        i1 <- 1 to 20
        i2 <- 1 to 20
      } {
        val number1: Number1              = number1Gen(i1)
        lazy val number2Positive: Number2 = number2Gen(i2, number2Zero)
        lazy val number2Zero: Number2     = Number2T(() => number2Positive)

        val result: BigDecimal = BigDecimal(i1) / BigDecimal(i2)

        val loopCount: Int = 100000

        val compareResult_1: BigDecimal = {
          var currentNum: Number2 = number2Positive
          var list: List[Int]     = List.empty[Int]
          for (_ <- 0 to loopCount) {
            currentNum = nextNumber2(currentNum)
            if (!currentNum.isInstanceOf[Number2T]) {
              locally {
                val currentCompareResult = countNumber3(currentNum.method2(number1))
                list = currentCompareResult :: list
              }
              locally {
                val currentCompareResult = countNumber3(number1.method1(nextNumber2(currentNum)))
                list = currentCompareResult :: list
              }
            }
          }
          BigDecimal(list.sum) / BigDecimal(list.size)
        }

        val compareResult_2: BigDecimal = {
          var currentNum: Number2 = number2Positive
          var list: List[Int]     = List.empty[Int]
          for (_ <- 0 to loopCount) {
            currentNum = nextNumber2(currentNum)
            if (!currentNum.isInstanceOf[Number2T]) {
              locally {
                val currentCompareResult = countNumber3(number1.method1(currentNum))
                list = currentCompareResult :: list
              }
              locally {
                val currentCompareResult = countNumber3(nextNumber2(currentNum).method2(number1))
                list = currentCompareResult :: list
              }
            }
          }
          BigDecimal(list.sum) / BigDecimal(list.size)
        }

        println(("aa", i1, i2, result, compareResult_1, compareResult_2))
        assert((result - compareResult_1).abs < BigDecimal("0.0001"))
        assert((result - compareResult_2).abs < BigDecimal("0.0001"))
        assert(countNumber3(number1.method1(number2Zero)) == ((i1 + i2 - 1) / i2))
        assert(countNumber3(number2Positive.method2(number1)) == (i1 / i2))
      }
    }
  }

}
