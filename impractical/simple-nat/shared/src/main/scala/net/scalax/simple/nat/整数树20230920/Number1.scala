package net.scalax.simple.nat.整数树20230920

object Number1 {

  sealed trait NumberAbs
  trait NumberA                                            extends NumberAbs
  trait NumberB                                            extends NumberAbs
  case class NumberAPositive(numA: NumberA, numB: NumberB) extends NumberA
  case class NumberBPositive(numB: NumberB, numA: NumberA) extends NumberB
  case object NumberAZero                                  extends NumberA
  case object NumberBZero                                  extends NumberB

  trait NumImplAbs {
    def method1(numA: NumImplAbs, numB: NumImplAbs): NumberAbs
  }

  case class NumberAImpl(numA: NumberAImpl, numB: NumberBImpl) extends NumImplAbs {
    override def method1(num2: NumImplAbs, num3: NumImplAbs): NumberA = NumberAPositive(numA.method1(numA, numB), numB.method1(numA, numB))
  }

  case class NumberBImpl(numB: NumberBImpl, numA: NumberAImpl) extends NumImplAbs {
    override def method1(num2: NumImplAbs, num3: NumImplAbs): NumberB = NumberBPositive(numB.method1(numA, numB), numA.method1(numA, numB))
  }

  case class NumberAZeroImplAbstraction(bZero: () => NumberBZeroImplAbstraction) extends NumImplAbs {
    override def method1(num2: NumImplAbs, num3: NumImplAbs): NumberAbs = {
      val needEnd1: Boolean = bZero() == NumberAZeroImpl || bZero() == NumberBZeroImpl
      val needEnd2: Boolean = num2 == NumberAZeroImpl || num2 == NumberBZeroImpl
      val needEnd3: Boolean = num3 == NumberAZeroImpl || num3 == NumberBZeroImpl
      if (needEnd1 && needEnd2 && needEnd3) {
        NumberAZero
      } else {
        num2.method1(num3, bZero())
      }
    }
  }

  case class NumberBZeroImplAbstraction(aZero: () => NumberAZeroImplAbstraction) extends NumImplAbs {
    override def method1(num2: NumImplAbs, num3: NumImplAbs): NumberAbs = {
      val needEnd1: Boolean = aZero() == NumberAZeroImpl || aZero() == NumberBZeroImpl
      val needEnd2: Boolean = num2 == NumberAZeroImpl || num2 == NumberBZeroImpl
      val needEnd3: Boolean = num3 == NumberAZeroImpl || num3 == NumberBZeroImpl
      if (needEnd1 && needEnd2 && needEnd3) {
        NumberBZero
      } else {
        num2.method1(aZero(), num3)
      }
    }
  }

  lazy val NumberAZeroImpl: NumberAZeroImplAbstraction = NumberAZeroImplAbstraction(() => NumberBZeroImpl)
  lazy val NumberBZeroImpl: NumberBZeroImplAbstraction = NumberBZeroImplAbstraction(() => NumberAZeroImpl)

}
