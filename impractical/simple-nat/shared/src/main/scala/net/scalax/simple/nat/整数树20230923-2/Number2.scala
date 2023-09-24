package net.scalax.simple.nat.`整数树20230923-2`

object NENE喵A呜哇 {

  import Number1._

  def countExecuteA(numImplAbs: NumAExecute): Int = numImplAbs match {
    case NumAExecutePositive(numA, numB) => countExecuteA(numA()) + countExecuteB(numB) + 1
    case NumAExecuteZerp                 => 0
  }

  def countExecuteB(numImplAbs: NumBExecute): Int = numImplAbs match {
    case NumBExecutePositive(numB, numA) => countExecuteA(numA) + countExecuteB(numB()) - 1
    case NumBExecuteZero                 => 0
  }

  def countResultA(numImplAbs: NumACount): Int = numImplAbs match {
    case NumACountPositive(numA, numB) => countResultA(numA()) + countResultB(numB) + 1
    case NumACountZero                 => 0
  }

  def countResultB(numImplAbs: NumBCount): Int = numImplAbs match {
    case NumBCountPositive(numB, numA) => countResultA(numA) + countResultB(numB()) - 1
    case NumBCountZero                 => 0
  }

  def main(arr: Array[String]): Unit = {
    val num1 = NumAExecutePositive(
      () => NumAExecutePositive(() => NumAExecuteZerp, NumBExecuteZero),
      NumBExecutePositive(() => NumBExecuteZero, NumAExecutePositive(() => NumAExecuteZerp, NumBExecuteZero))
    )
    val num2 =
      NumAExecutePositive(
        () => NumAExecutePositive(() => num1, NumBExecutePositive(() => NumBExecuteZero, num1)),
        NumBExecutePositive(() => NumBExecuteZero, NumAExecutePositive(() => num1, NumBExecuteZero))
      )
    val num3 =
      NumBExecutePositive(
        () => NumBExecutePositive(() => NumBExecutePositive(() => NumBExecuteZero, NumAExecuteZerp), NumAExecuteZerp),
        NumAExecutePositive(() => num1, NumBExecuteZero)
      )
    val num4 =
      NumBExecutePositive(
        () => NumBExecutePositive(() => NumBExecutePositive(() => num3, NumAExecuteZerp), NumAExecuteZerp),
        NumAExecutePositive(
          () => NumAExecuteZerp,
          NumBExecutePositive(
            () =>
              NumBExecutePositive(
                () => NumBExecutePositive(() => NumBExecutePositive(() => num3, NumAExecuteZerp), NumAExecuteZerp),
                NumAExecuteZerp
              ),
            NumAExecuteZerp
          )
        )
      )
    println("Need-1: " + countExecuteA(num1))
    println("Need-2: " + countExecuteA(num2))
    println(countExecuteB(num3))
    println("Need-3: " + countExecuteB(num4))

    println("Result-4: " + countResultA(num1.method1(num2, num4)))

    assert(countExecuteA(num1) + countExecuteA(num2) + countExecuteB(num4) == countResultA(num1.method1(num2, num4)))
  }

}
