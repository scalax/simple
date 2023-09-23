package net.scalax.simple.nat.`整数树20230923-2`

object Number1 {

  // ========= Result
  trait NumberA
  trait NumberB
  case class NumberAPositive(next: NumberA, precursor: NumberB) extends NumberA
  case class NumberBPositive(next: NumberB, precursor: NumberA) extends NumberB
  case class NumberAZeroAbstraction(next: () => NumberA)        extends NumberA
  lazy val NumberAZero: NumberA = NumberAZeroAbstraction(next = () => NumberAZero)
  case class NumberBZeroAbstraction(next: () => NumberB) extends NumberB
  lazy val NumberBZero: NumberB = NumberBZeroAbstraction(next = () => NumberBZero)

  // ========== NumberA
  trait NumAImpls {
    def method1(numA: NumAImpls, numB: NumBImpls): NumberA
  }

  case class NumberAImpl(next: NumAImpls, precursor: NumBImpls) extends NumAImpls {
    override def method1(numA1: NumAImpls, numB1: NumBImpls): NumberA =
      NumberAPositive(next = next.method1(numA1, NumberBZeroImpl), precursor = precursor.method2(numB1, NumberAZeroImpl))
  }
  case class NumberAZeroImplAbstraction(next: () => NumAImpls) extends NumAImpls {
    override def method1(numA1: NumAImpls, numB1: NumBImpls): NumberA = {
      val needEnd1: Boolean = next() == NumberAZeroImpl
      val needEnd2: Boolean = numA1 == NumberAZeroImpl
      val needEnd3: Boolean = numB1 == NumberBZeroImpl
      if (needEnd1 && needEnd2 && needEnd3) {
        NumberAZero
      } else {
        numA1.method1(next(), numB1)
      }
    }
  }

  lazy val NumberAZeroImpl: NumberAZeroImplAbstraction = NumberAZeroImplAbstraction(next = () => NumberAZeroImpl)

  // ========== NumberB
  trait NumBImpls {
    def method2(numB: NumBImpls, numA: NumAImpls): NumberB
  }

  case class NumberBImpl(next: NumBImpls, precursor: NumAImpls) extends NumBImpls {
    override def method2(numB1: NumBImpls, numA1: NumAImpls): NumberB =
      NumberBPositive(next = next.method2(numB1, NumberAZeroImpl), precursor = precursor.method1(numA1, NumberBZeroImpl))
  }
  case class NumberBZeroImplAbstraction(next: () => NumBImpls) extends NumBImpls {
    override def method2(numB1: NumBImpls, numA1: NumAImpls): NumberB = {
      val needEnd1: Boolean = next() == NumberBZeroImpl
      val needEnd2: Boolean = numB1 == NumberBZeroImpl
      val needEnd3: Boolean = numA1 == NumberAZeroImpl
      if (needEnd1 && needEnd2 && needEnd3) {
        NumberBZero
      } else {
        numB1.method2(next(), numA1)
      }
    }
  }

  lazy val NumberBZeroImpl: NumberBZeroImplAbstraction = NumberBZeroImplAbstraction(next = () => NumberBZeroImpl)

}
