package net.scalax.simple.nat.整数树20230920

object Number1 {

  sealed trait NumberAbs
  trait NumberA                                                extends NumberAbs
  trait NumberB                                                extends NumberAbs
  case class NumberAPositive(numA: NumberAbs, numB: NumberAbs) extends NumberA
  case class NumberBPositive(numB: NumberAbs, numA: NumberAbs) extends NumberB
  case object NumberAZero                                      extends NumberA
  case object NumberBZero                                      extends NumberB

  trait NumImplAbs {
    def method1(numA: NumImplAbs, numB: NumImplAbs): NumberAbs
  }

  case class NumberAImpl(numA: NumImplAbs, numB: NumImplAbs) extends NumImplAbs {
    override def method1(num2: NumImplAbs, num3: NumImplAbs): NumberAbs =
      NumberAPositive(numA.method1(num2, NumberAZeroImpl), numB.method1(num3, NumberBZeroImpl))
  }

  case class NumberBImpl(numB: NumImplAbs, numA: NumImplAbs) extends NumImplAbs {
    override def method1(num2: NumImplAbs, num3: NumImplAbs): NumberAbs =
      NumberBPositive(numA.method1(num2, NumberAZeroImpl), numB.method1(num3, NumberBZeroImpl))
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
        num2.method1(num3, aZero())
      }
    }
  }

  lazy val NumberAZeroImpl: NumberAZeroImplAbstraction = NumberAZeroImplAbstraction(() => NumberBZeroImpl)
  lazy val NumberBZeroImpl: NumberBZeroImplAbstraction = NumberBZeroImplAbstraction(() => NumberAZeroImpl)

}
