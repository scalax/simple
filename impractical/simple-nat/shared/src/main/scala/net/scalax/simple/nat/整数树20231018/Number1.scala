/*
package net.scalax.simple.nat.整数树20231018

object Number1 {

  // ========= Result
  case class NumACount(next: () => NumACount, precursor: () => NumBCount)
  case class NumBCount(next: () => NumBCount, precursor: () => NumACount)

  // ========== NumberA
  class NumAExecute(next: () => NumAExecute, precursor: () => NumBExecute) extends NumACount(next = next, precursor = precursor) {
    def method1(numA: NumAExecute, numB: NumBExecute): NumACount = numA.method1(next(), numB)
  }

  class NumAExecutePositive(next: () => NumAExecute, precursor: () => NumBExecute) extends NumAExecute(next = next, precursor = precursor) {
    override def method1(numB: NumAExecute): NumACount = NumACount(
      next = () => next().method1(numA, NumBExecuteZero),
      precursor = () => precursor().method2(numB, NumAExecuteZero)
    )
  }

  lazy val NumAExecuteZero: NumAExecute = new NumAExecute(next = () => NumAExecuteZero, precursor = () => NumBExecuteZero)

  // ========== NumberB
  class NumBExecute(next: () => NumBExecute, precursor: () => NumAExecute) extends NumBCount(next = next, precursor = precursor) {
    def method2(numB: NumBExecute, numA: NumAExecute): NumBCount = numB.method2(next(), numA)
  }

  class NumBExecutePositive(next: () => NumBExecute, precursor: () => NumAExecute) extends NumBExecute(next = next, precursor = precursor) {
    override def method2(numB: NumBExecute, numA: NumAExecute): NumBCount = NumBCount(
      next = () => next().method2(numB, NumAExecuteZero),
      precursor = () => precursor().method1(numA, NumBExecuteZero)
    )
  }

  lazy val NumBExecuteZero: NumBExecute = new NumBExecute(() => NumBExecuteZero, precursor = () => NumAExecuteZero)

}
 */
