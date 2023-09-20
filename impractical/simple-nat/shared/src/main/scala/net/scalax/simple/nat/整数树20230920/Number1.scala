package net.scalax.simple.nat.整数树20230920

object Number1 {

  trait NumberAbs
  case class NumberA(numA: NumberA, numB: NumberB) extends NumberAbs
  case class NumberB(numB: NumberB, numA: NumberA) extends NumberAbs

  trait NumImplAbs {
    def method1(numA: NumImplAbs, numB: NumImplAbs): NumberAbs
  }

  case class NumberAImpl(numA: NumberAImpl, numB: NumberBImpl) extends NumImplAbs {
    override def method1(num2: NumImplAbs, num3: NumImplAbs): NumberA = NumberA(numA.method1(numA, numB), numB.method1(numA, numB))
  }

  case class NumberBImpl(numB: NumberBImpl, numA: NumberAImpl) extends NumImplAbs {
    override def method1(num2: NumImplAbs, num3: NumImplAbs): NumberB = NumberB(numB.method1(numA, numB), numA.method1(numA, numB))
  }

  case class NumberAZeroImplAbstraction(bZero: () => NumberBZeroImplAbstraction) extends NumImplAbs {
    override def method1(num2: NumImplAbs, num3: NumImplAbs): NumberAbs = num2.method1(num3, bZero())
  }

  case class NumberBZeroImplAbstraction(aZero: () => NumberAZeroImplAbstraction) extends NumImplAbs {
    override def method1(num2: NumImplAbs, num3: NumImplAbs): NumberAbs = num2.method1(num3, aZero())
  }

  lazy val NumberAZeroImpl: NumberAZeroImplAbstraction = NumberAZeroImplAbstraction(() => NumberBZeroImpl)
  lazy val NumberBZeroImpl: NumberBZeroImplAbstraction = NumberBZeroImplAbstraction(() => NumberAZeroImpl)

}
