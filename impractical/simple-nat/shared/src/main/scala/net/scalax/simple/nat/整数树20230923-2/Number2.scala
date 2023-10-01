package net.scalax.simple.nat.`整数树20230923-2`

object NENE喵A呜哇 {

  import Number1._

  def countResultA(numImplAbs: () => NumACount): Int = {
    val tempInstance =
      try
        Option(numImplAbs())
      catch {
        case e: StackOverflowError => Option.empty
      }

    tempInstance
      .map {
        case NumAExecuteZero => 0
        case NumACount(numA, numB) =>
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
      .map {
        case NumBExecuteZero => 0
        case NumBCount(numB, numA) =>
          countResultA(numA) + countResultB(numB) - 1
      }
      .getOrElse(0)
  }

  def main(arr: Array[String]): Unit = {
    val num1 = new NumAExecutePositive(
      () => NumAExecuteZero,
      () =>
        new NumBExecutePositive(
          () =>
            new NumBExecutePositive(
              () =>
                new NumBExecutePositive(() => new NumBExecutePositive(() => NumBExecuteZero, () => NumAExecuteZero), () => NumAExecuteZero),
              () => NumAExecuteZero
            ),
          () => new NumAExecutePositive(() => NumAExecuteZero, () => new NumBExecutePositive(() => NumBExecuteZero, () => NumAExecuteZero))
        )
    )
    val num2 =
      new NumAExecutePositive(
        () =>
          new NumAExecutePositive(
            () =>
              new NumAExecutePositive(
                () =>
                  new NumAExecutePositive(
                    () =>
                      new NumAExecutePositive(
                        () =>
                          new NumAExecutePositive(
                            () =>
                              new NumAExecutePositive(
                                () =>
                                  new NumAExecutePositive(
                                    () => NumAExecuteZero,
                                    () => new NumBExecutePositive(() => NumBExecuteZero, () => NumAExecuteZero)
                                  ),
                                () =>
                                  new NumBExecutePositive(
                                    () => NumBExecuteZero,
                                    () => new NumAExecutePositive(() => NumAExecuteZero, () => NumBExecuteZero)
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
      new NumBExecutePositive(
        () => new NumBExecutePositive(() => new NumBExecutePositive(() => NumBExecuteZero, () => NumAExecuteZero), () => NumAExecuteZero),
        () => new NumAExecutePositive(() => num1, () => NumBExecuteZero)
      )
    val num4 =
      new NumBExecutePositive(
        () =>
          new NumBExecutePositive(
            () => new NumBExecutePositive(() => new NumBExecutePositive(() => NumBExecuteZero, () => num2), () => num1),
            () => NumAExecuteZero
          ),
        () =>
          new NumAExecutePositive(
            () => num1,
            () =>
              new NumBExecutePositive(
                () =>
                  new NumBExecutePositive(
                    () => new NumBExecutePositive(() => new NumBExecutePositive(() => num3, () => NumAExecuteZero), () => NumAExecuteZero),
                    () => NumAExecuteZero
                  ),
                () => NumAExecuteZero
              )
          )
      )

    println("Need-1: " + countResultA(() => num1))
    println("Need-2: " + countResultA(() => num2))
    println("Not-Need-1: " + countResultB(() => num3))
    println("Need-3: " + countResultB(() => num4))
    println("Result-4: " + countResultA(() => num1.method1(num2, num4)))

    assert(
      countResultA(() => num1) + countResultA(() => num2) + countResultB(() => num4) == countResultA(() => num1.method1(num2, num4))
    )
  }

}
