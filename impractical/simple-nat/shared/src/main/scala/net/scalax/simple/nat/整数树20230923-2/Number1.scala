package net.scalax.simple.nat.`整数树20230923-2`

import net.scalax.simple.nat.合集1.合集

object Number1 {

  // ========= ResultA
  class NumACount(next: () => NumACount)                                          extends 合集.NumCount(next)
  case class NumACountPositive(next: () => NumACount, precursor: () => NumBCount) extends NumACount(next)

  // ========= ResultB
  class NumBCount(next: () => NumBCount)                                          extends 合集.NumCount(next)
  case class NumBCountPositive(next: () => NumBCount, precursor: () => NumACount) extends NumBCount(next)

  // ========== NumberA
  class NumAExecute(next: () => NumAExecute) extends NumACount(next = next) {
    def method1(numA: NumAExecute, numB: NumBExecute): NumACount = numA.method1(next(), numB)
  }

  case class NumAExecutePositive(next: () => NumAExecute, precursor: () => NumBExecute) extends NumAExecute(next) {
    override def method1(numA: NumAExecute, numB: NumBExecute): NumACount = NumACountPositive(
      next = () => next().method1(numA, NumBExecuteZero),
      precursor = () => precursor().method2(numB, NumAExecuteZero)
    )
  }

  lazy val NumAExecuteZero: NumAExecute = new NumAExecute(next = () => NumAExecuteZero)

  // ========== NumberB
  class NumBExecute(next: () => NumBExecute) extends NumBCount(next) {
    def method2(numB: NumBExecute, numA: NumAExecute): NumBCount = numB.method2(next(), numA)
  }

  case class NumBExecutePositive(next: () => NumBExecute, precursor: () => NumAExecute) extends NumBExecute(next) {
    override def method2(numB: NumBExecute, numA: NumAExecute): NumBCount = NumBCountPositive(
      next = () => next().method2(numB, NumAExecuteZero),
      precursor = () => precursor().method1(numA, NumBExecuteZero)
    )
  }

  val NumBExecuteZero: NumBExecute = new NumBExecute(() => NumBExecuteZero)

}
