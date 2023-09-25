package net.scalax.simple.nat.`整数树20230923-2`

object Number1 {

  // ========= Result
  case class NumACount(next: () => NumACount, precursor: () => NumBCount)
  case class NumBCount(next: () => NumBCount, precursor: () => NumACount)

  // ========== NumberA
  class NumAExecute(next: () => NumAExecute) {
    def method1(numA: NumAExecute, numB: NumBExecute): NumACount = numA.method1(next(), numB)
  }

  case class NumAExecutePositive(next: () => NumAExecute, precursor: () => NumBExecute) extends NumAExecute(next) {
    override def method1(numA: NumAExecute, numB: NumBExecute): NumACount = NumACount(
      next = () => next().method1(numA, NumBExecuteZero),
      precursor = () => precursor().method2(numB, NumAExecuteZero)
    )
  }

  lazy val NumAExecuteZero: NumAExecute = new NumAExecute(next = () => NumAExecuteZero)

  // ========== NumberB
  class NumBExecute(next: () => NumBExecute) {
    def method2(numB: NumBExecute, numA: NumAExecute): NumBCount = numB.method2(next(), numA)
  }

  case class NumBExecutePositive(next: () => NumBExecute, precursor: () => NumAExecute) extends NumBExecute(next) {
    override def method2(numB: NumBExecute, numA: NumAExecute): NumBCount = NumBCount(
      next = () => next().method2(numB, NumAExecuteZero),
      precursor = () => precursor().method1(numA, NumBExecuteZero)
    )
  }

  val NumBExecuteZero: NumBExecute = new NumBExecute(() => NumBExecuteZero)

}
