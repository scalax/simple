package net.scalax.simple.nat.`整数树20230923-2`

object NENE喵A呜哇 {

  import Number1._

  def countExecuteA(numImplAbs: () => NumAExecute): Int = numImplAbs() match {
    case NumAExecutePositive(numA, numB) => countExecuteA(numA) + countExecuteB(numB) + 1
    case NumAExecuteZero                 => 0
  }

  def countExecuteB(numImplAbs: () => NumBExecute): Int = numImplAbs() match {
    case NumBExecutePositive(numB, numA) => countExecuteA(numA) + countExecuteB(numB) - 1
    case NumBExecuteZero                 => 0
  }

  def countResultA(numImplAbs: () => NumACount): Int = {
    val tempInstance =
      try
        Option(numImplAbs())
      catch {
        case e: StackOverflowError => Option.empty
      }

    tempInstance
      .map { case NumACount(numA, numB) =>
        countResultA(numA) + countResultB(numB) + 1
      }
      .getOrElse(0)
  }

  def countResultB(numImplAbs: () => NumBCount): Int = {
    val tempInstance =
      try
        Option(numImplAbs())
      catch {
        case e: StackOverflowError => Option.empty
      }

    tempInstance
      .map { case NumBCount(numB, numA) =>
        countResultA(numA) + countResultB(numB) - 1
      }
      .getOrElse(0)
  }

  def main1(arr: Array[String]): Unit = {
    val num1 = NumAExecutePositive(
      () => NumAExecuteZero,
      () =>
        NumBExecutePositive(
          () =>
            NumBExecutePositive(
              () => NumBExecutePositive(() => NumBExecutePositive(() => NumBExecuteZero, () => NumAExecuteZero), () => NumAExecuteZero),
              () => NumAExecuteZero
            ),
          () => NumAExecutePositive(() => NumAExecuteZero, () => NumBExecutePositive(() => NumBExecuteZero, () => NumAExecuteZero))
        )
    )
    val num2 =
      NumAExecutePositive(
        () =>
          NumAExecutePositive(
            () =>
              NumAExecutePositive(
                () =>
                  NumAExecutePositive(
                    () =>
                      NumAExecutePositive(
                        () =>
                          NumAExecutePositive(
                            () =>
                              NumAExecutePositive(
                                () =>
                                  NumAExecutePositive(
                                    () => NumAExecuteZero,
                                    () => NumBExecutePositive(() => NumBExecuteZero, () => NumAExecuteZero)
                                  ),
                                () =>
                                  NumBExecutePositive(
                                    () => NumBExecuteZero,
                                    () => NumAExecutePositive(() => NumAExecuteZero, () => NumBExecuteZero)
                                  )
                              ),
                            () => NumBExecuteZero
                          ),
                        () => NumBExecuteZero
                      ),
                    () => NumBExecuteZero
                  ),
                () => NumBExecuteZero
              ),
            () => NumBExecuteZero
          ),
        () => NumBExecuteZero
      )
    val num3 =
      NumBExecutePositive(
        () => NumBExecutePositive(() => NumBExecutePositive(() => NumBExecuteZero, () => NumAExecuteZero), () => NumAExecuteZero),
        () => NumAExecutePositive(() => num1, () => NumBExecuteZero)
      )
    val num4 =
      NumBExecutePositive(
        () =>
          NumBExecutePositive(
            () => NumBExecutePositive(() => NumBExecutePositive(() => NumBExecuteZero, () => num2), () => num1),
            () => NumAExecuteZero
          ),
        () =>
          NumAExecutePositive(
            () => num1,
            () =>
              NumBExecutePositive(
                () =>
                  NumBExecutePositive(
                    () => NumBExecutePositive(() => NumBExecutePositive(() => num3, () => NumAExecuteZero), () => NumAExecuteZero),
                    () => NumAExecuteZero
                  ),
                () => NumAExecuteZero
              )
          )
      )

    println("Need-1: " + countExecuteA(() => num1))
    println("Need-2: " + countExecuteA(() => num2))
    println("Not-Need-1: " + countExecuteB(() => num3))
    println("Need-3: " + countExecuteB(() => num4))
    println("Result-4: " + countResultA(() => num1.method1(num2, num4)))

    assert(
      countExecuteA(() => num1) + countExecuteA(() => num2) + countExecuteB(() => num4) == countResultA(() => num1.method1(num2, num4))
    )
  }

}
