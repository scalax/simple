package net.scalax.simple.nat.`整数树20230923-2`

import net.scalax.simple.nat.合集1.合集

object Number1 {

  // ========= ResultA
  class NumACount(next: () => NumACount) extends 合集.NumCount(next)

  case class NumACountPositive(next: () => NumACount, precursor: NumBCount) extends NumACount(next)

  private class NumACountZeroImpl(next: () => NumACountZeroImpl) extends NumACount(next)
  private lazy val NumACountZeroImpl: NumACountZeroImpl = new NumACountZeroImpl(next = () => NumACountZeroImpl)
  val NumACountZero: NumACount                          = NumACountZeroImpl

  // ========= ResultB
  class NumBCount(next: () => NumBCount) extends 合集.NumCount(next)

  case class NumBCountPositive(next: () => NumBCount, precursor: NumACount) extends NumBCount(next)

  private class NumBCountZeroImpl(next: () => NumBCountZeroImpl) extends NumBCount(next)
  private lazy val NumBCountZeroImpl: NumBCountZeroImpl = new NumBCountZeroImpl(next = () => NumBCountZeroImpl)
  val NumBCountZero: NumBCount                          = NumBCountZeroImpl

  // ========== NumberA
  abstract class NumAExecute(next: () => NumAExecute) extends NumACount(next = next) {
    def method1(numA: NumAExecute, numB: NumBExecute): NumACount
  }

  case class NumAExecutePositive(next: () => NumAExecute, precursor: NumBExecute) extends NumAExecute(next) {
    override def method1(numA1: NumAExecute, numB1: NumBExecute): NumACount =
      NumACountPositive(next = () => next().method1(numA1, NumBExecuteZeroImpl), precursor = precursor.method2(numB1, NumAExecuteZerpImpl))
  }

  private class NumAExecuteZerpImpl(next: () => NumAExecuteZerpImpl) extends NumAExecute(next) {
    override def method1(numA1: NumAExecute, numB1: NumBExecute): NumACount = {
      val needEnd1: Boolean = next() == NumAExecuteZerpImpl
      val needEnd2: Boolean = numA1 == NumAExecuteZerpImpl
      val needEnd3: Boolean = numB1 == NumBExecuteZeroImpl
      if (needEnd1 && needEnd2 && needEnd3) {
        NumACountZero
      } else {
        numA1.method1(next(), numB1)
      }
    }
  }
  private lazy val NumAExecuteZerpImpl: NumAExecuteZerpImpl = new NumAExecuteZerpImpl(next = () => NumAExecuteZerpImpl)
  val NumAExecuteZerp: NumAExecute                          = NumAExecuteZerpImpl

  // ========== NumberB
  abstract class NumBExecute(next: () => NumBExecute) extends NumBCount(next) {
    def method2(numB: NumBExecute, numA: NumAExecute): NumBCount
  }

  case class NumBExecutePositive(next: () => NumBExecute, precursor: NumAExecute) extends NumBExecute(next) {
    override def method2(numB1: NumBExecute, numA1: NumAExecute): NumBCount =
      NumBCountPositive(next = () => next().method2(numB1, NumAExecuteZerpImpl), precursor = precursor.method1(numA1, NumBExecuteZeroImpl))
  }

  private class NumBExecuteZeroImpl(next: () => NumBExecuteZeroImpl) extends NumBExecute(next) {
    override def method2(numB1: NumBExecute, numA1: NumAExecute): NumBCount = {
      val needEnd1: Boolean = next() == NumBExecuteZeroImpl
      val needEnd2: Boolean = numB1 == NumBExecuteZeroImpl
      val needEnd3: Boolean = numA1 == NumAExecuteZerpImpl
      if (needEnd1 && needEnd2 && needEnd3) {
        NumBCountZero
      } else {
        numB1.method2(next(), numA1)
      }
    }
  }
  private lazy val NumBExecuteZeroImpl: NumBExecuteZeroImpl = new NumBExecuteZeroImpl(next = () => NumBExecuteZeroImpl)
  val NumBExecuteZero: NumBExecute                          = NumBExecuteZeroImpl

}
