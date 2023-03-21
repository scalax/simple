package net.scalax.simple
package nat
package number11

object RunMain5 {

  def countNumber3(number: Number3): Int = number match {
    case Number3S(tail) => countNumber3(tail) + 1
    case Number3T       => 0
  }

  def nextNumber2(number: Number2): Number2 = number match {
    case Number2S(tail) => tail()
    case Number2T(tail) => tail()
  }

  def number1Gen(n: Int): Number1                   = if (n > 0) Number1S(number1Gen(n - 1)) else Number1T
  def number2Gen(n: Int, zero: => Number2): Number2 = if (n > 0) Number2T(() => number2Gen(n - 1, zero)) else zero

  def main(arr: Array[String]): Unit = {

    locally {
      for {
        i1 <- 15 to 25
        i2 <- 1 to 20
      } {
        val number1: Number1              = number1Gen(i1)
        lazy val number2Positive: Number2 = number2Gen(i2, number2Zero)
        lazy val number2Zero: Number2     = Number2S(() => number2Positive)

        val loopCount: Int = 100000

        // 有理数1
        val compareResult_1: BigDecimal = {
          var listResult: List[Int] = List.empty
          var currentNum: Number2   = number2Zero
          for (_ <- 0 to loopCount) {
            currentNum = nextNumber2(currentNum)

            locally {
              if (currentNum != number2Positive) {
                locally {
                  val currentCompareResult = countNumber3(currentNum.method2(number1))
                  listResult = currentCompareResult :: listResult
                }
              }
              if (currentNum != number2Zero) {
                locally {
                  val currentCompareResult = countNumber3(number1.method1(currentNum))
                  listResult = currentCompareResult :: listResult
                }
              }
            }

          }
          BigDecimal(listResult.sum) / BigDecimal(listResult.size)
        }
        // 验证
        assert(((BigDecimal(i1) * BigDecimal(i2)) - compareResult_1).abs < BigDecimal("0.001"))

        // 有理数2-与（有理数1对称）
        val compareResult_2: BigDecimal = {
          var listResult: List[Int] = List.empty
          var currentNum: Number2   = number2Zero
          for (_ <- 0 to loopCount) {
            currentNum = nextNumber2(currentNum)

            locally {
              if (currentNum != number2Positive) {
                locally {
                  val currentCompareResult = countNumber3(number1.method1(currentNum))
                  listResult = currentCompareResult :: listResult
                }
              }
              if (currentNum != number2Zero) {
                locally {
                  val currentCompareResult = countNumber3(currentNum.method2(number1))
                  listResult = currentCompareResult :: listResult
                }
              }
            }

          }
          BigDecimal(listResult.sum) / BigDecimal(listResult.size)
        }
        // 验证
        assert(((BigDecimal(i1) * BigDecimal(i2)) - compareResult_2).abs < BigDecimal("0.001"))

        // 上舍法
        val compareResult_3: Int = countNumber3(number2Zero.method2(number1))
        // 验证
        assert(compareResult_3 == (i1 * i2))

        // 下舍法
        val compareResult_4: Int = countNumber3(number1.method1(number2Positive))
        // 验证
        assert(compareResult_4 == (i1 * i2))

        println(
          (
            "i1 ->",
            i1,
            "i2 ->",
            i2,
            "i1 × i2 ->",
            BigDecimal(i1) * BigDecimal(i2),
            compareResult_1,
            compareResult_2,
            i1 * i2
          )
        )
      }
    }

    println("ii" * 100)
  }

}
