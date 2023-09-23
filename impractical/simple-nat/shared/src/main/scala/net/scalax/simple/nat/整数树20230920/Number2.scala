package net.scalax.simple.nat.整数树20230920

object NENE喵A呜哇 {

  import Number1._

  def count1(numAbs: NumberAbs): Int = numAbs match {
    case NumberAPositive(numA, numB) => count1(numA) + count1(numB) + 1
    case NumberBPositive(numB, numA) => count1(numA) + count1(numB) - 1
    case NumberAZero                 => 0
    case NumberBZero                 => 0
  }

  def count2(numImplAbs: NumImplAbs): Int = numImplAbs match {
    case NumberAImpl(numA, numB) => count2(numA) + count2(numB) + 1
    case NumberBImpl(numB, numA) => count2(numA) + count2(numB) - 1
    case NumberAZeroImpl         => 0
    case NumberBZeroImpl         => 0
  }

  def main(arr: Array[String]): Unit = {
    val num1 = NumberAImpl(
      NumberBImpl(NumberAImpl(NumberBZeroImpl, NumberBZeroImpl), NumberBZeroImpl),
      NumberAImpl(NumberBZeroImpl, NumberBZeroImpl)
    )
    val num2 = NumberAImpl(NumberBImpl(NumberAImpl(num1, NumberBZeroImpl), NumberBZeroImpl), NumberAImpl(num1, NumberBZeroImpl))
    val num3 = NumberBImpl(NumberBImpl(NumberBImpl(NumberBZeroImpl, NumberBZeroImpl), NumberBZeroImpl), NumberBImpl(num1, NumberBZeroImpl))
    val num4 = NumberBImpl(NumberBImpl(NumberBImpl(num3, NumberBZeroImpl), NumberBZeroImpl), NumberBImpl(NumberBZeroImpl, num3))
    println(count2(num1))
    println(count2(num2))
    println(count2(num3))
    println(count2(num4))

    println("喵喵" + count1(num1.method1(num2, num4)))
  }

}
