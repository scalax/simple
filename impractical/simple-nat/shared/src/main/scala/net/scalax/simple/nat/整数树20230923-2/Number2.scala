package net.scalax.simple.nat.`整数树20230923-2`

object NENE喵A呜哇 {

  import Number1._

  def count1Impl1(numAbs: NumAImpls): Int = numAbs match {
    case NumberAImpl(numA, numB) => count1Impl1(numA) + count1Impl2(numB) + 1
    case NumberAZeroImpl         => 0
  }

  def count1Impl2(numBbs: NumBImpls): Int = numBbs match {
    case NumberBImpl(numB, numA) => count1Impl1(numA) + count1Impl2(numB) - 1
    case NumberBZeroImpl         => 0
  }

  def count2Impl1(numImplAbs: NumberA): Int = numImplAbs match {
    case NumberAPositive(numA, numB) => count2Impl1(numA) + count2Impl2(numB) + 1
    case NumberAZero                 => 0
  }

  def count2Impl2(numImplAbs: NumberB): Int = numImplAbs match {
    case NumberBPositive(numB, numA) => count2Impl1(numA) + count2Impl2(numB) - 1
    case NumberBZero                 => 0
  }

  def main1(arr: Array[String]): Unit = {
    val num1 = NumberAImpl(
      NumberAImpl(NumberAZeroImpl, NumberBZeroImpl),
      NumberBImpl(NumberBZeroImpl, NumberAImpl(NumberAZeroImpl, NumberBZeroImpl))
    )
    val num2 = NumberAImpl(NumberAImpl(num1, NumberBZeroImpl), NumberBImpl(NumberBZeroImpl, NumberAImpl(num1, NumberBZeroImpl)))
    val num3 = NumberBImpl(NumberBImpl(NumberBImpl(NumberBZeroImpl, NumberAZeroImpl), NumberAZeroImpl), NumberAImpl(num1, NumberBZeroImpl))
    val num4 =
      NumberBImpl(
        NumberBImpl(NumberBImpl(num3, NumberAZeroImpl), NumberAZeroImpl),
        NumberAImpl(
          NumberAZeroImpl,
          NumberBImpl(
            NumberBImpl(
              NumberBImpl(NumberBImpl(NumberBImpl(NumberBImpl(num3, NumberAZeroImpl), NumberAZeroImpl), NumberAZeroImpl), NumberAZeroImpl),
              NumberAZeroImpl
            ),
            NumberAZeroImpl
          )
        )
      )
    println("Need-1: " + count1Impl1(num1))
    println("Need-2: " + count1Impl1(num2))
    println(count1Impl2(num3))
    println("Need-3: " + count1Impl2(num4))

    println("Result-4: " + count2Impl1(num1.method1(num2, num4)))
  }

}
