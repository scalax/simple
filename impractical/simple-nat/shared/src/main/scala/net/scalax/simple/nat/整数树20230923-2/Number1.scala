package net.scalax.simple.nat.`整数树20230923-2`

object Number1 {

  trait NumberA
  trait NumberB
  case class NumberAPositive(numA: NumberA, numB: NumberB) extends NumberA
  case class NumberBPositive(numB: NumberB, numA: NumberA) extends NumberB
  case object NumberAZero                                  extends NumberA
  case object NumberBZero                                  extends NumberB

  trait NumAImpls {
    def method1(numA: NumAImpls, numB: NumBImpls): NumberA
  }

  case class NumberAImpl(numA: NumAImpls, numB: NumBImpls) extends NumAImpls {
    override def method1(numA1: NumAImpls, numB1: NumBImpls): NumberA =
      NumberAPositive(numA.method1(numA1, NumberBZeroImpl), numB.method2(numB1, NumberAZeroImpl))
  }
  case class NumberAZeroImplAbstraction(bZero: () => NumberAZeroImplAbstraction) extends NumAImpls {
    override def method1(numA1: NumAImpls, numB1: NumBImpls): NumberA = {
      val needEnd1: Boolean = bZero() == NumberAZeroImpl || bZero() == NumberBZeroImpl
      val needEnd2: Boolean = numA1 == NumberAZeroImpl || numA1 == NumberBZeroImpl
      val needEnd3: Boolean = numB1 == NumberAZeroImpl || numB1 == NumberBZeroImpl
      if (needEnd1 && needEnd2 && needEnd3) {
        NumberAZero
      } else {
        numA1.method1(bZero(), numB1)
      }
    }
  }

  trait NumBImpls {
    def method2(numB: NumBImpls, numA: NumAImpls): NumberB
  }

  case class NumberBImpl(numB: NumBImpls, numA: NumAImpls) extends NumBImpls {
    override def method2(numB1: NumBImpls, numA1: NumAImpls): NumberB =
      NumberBPositive(numB.method2(numB1, NumberAZeroImpl), numA.method1(numA1, NumberBZeroImpl))
  }

  case class NumberBZeroImplAbstraction(aZero: () => NumberBZeroImplAbstraction) extends NumBImpls {
    override def method2(numB1: NumBImpls, numA1: NumAImpls): NumberB = {
      val needEnd1: Boolean = aZero() == NumberAZeroImpl || aZero() == NumberBZeroImpl
      val needEnd2: Boolean = numB1 == NumberAZeroImpl || numB1 == NumberBZeroImpl
      val needEnd3: Boolean = numA1 == NumberAZeroImpl || numA1 == NumberBZeroImpl
      if (needEnd1 && needEnd2 && needEnd3) {
        NumberBZero
      } else {
        numB1.method2(aZero(), numA1)
      }
    }
  }

  lazy val NumberAZeroImpl: NumberAZeroImplAbstraction = NumberAZeroImplAbstraction(() => NumberAZeroImpl)
  lazy val NumberBZeroImpl: NumberBZeroImplAbstraction = NumberBZeroImplAbstraction(() => NumberBZeroImpl)

}
