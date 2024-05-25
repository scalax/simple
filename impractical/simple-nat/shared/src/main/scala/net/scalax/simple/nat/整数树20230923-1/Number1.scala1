package net.scalax.simple.nat.`整数树20230923-1`

trait Number1_1 {
  def method1(num2: Number2_1): Number3_1
}
case class Number1_1S(tail1: Number1_1) extends Number1_1 {
  override def method1(num2: Number2_1): Number3_1 = Number1_1U.IF(tail1)()(num2)()(Number3_1S(() => tail1.method1(num2)))
}
case class Number1_1T(tail1: Number1_1, tail2: Number1_2) extends Number1_1 {
  override def method1(num2: Number2_1): Number3_1 = Number1_1U.IF(tail1)(tail2)(num2)()(Number3_1S(() => num2.method3(tail1, tail2)))
}
case class Number1_1U(tail1: () => Number1_1, tail2: () => Number1_2) extends Number1_1 {
  override def method1(num2: Number2_1): Number3_1 = Number1_1U.IF(tail1())(tail2())(num2)()(num2.method3(tail1(), tail2()))
}
object Number1_1U {
  def IF(inputs1: Number1_1*)(inputs2: Number1_2*)(inputs3: Number2_1*)(inputs4: Number2_2*)(default: Number3_1): Number3_1 = {
    val bol1 = inputs1.forall(t => t == Number1_1U.Value)
    val bol2 = inputs2.forall(t => t == Number1_2U.Value)
    val bol3 = inputs3.forall(t => t == Number2_1U.Value)
    val bol4 = inputs4.forall(t => t == Number2_2U.Value)
    if (bol1 && bol2 && bol3 && bol4) Number3_1U.Value else default
  }

  lazy val Value: Number1_1U = Number1_1U(tail1 = () => Number1_1U.Value, tail2 = () => Number1_2U.Value)
}

trait Number1_2 {
  def method2(num2_1: Number2_1, num2_2: Number2_2): Number3_2
}
case class Number1_2S(tail2: Number1_2) extends Number1_2 {
  override def method2(num2_1: Number2_1, num2_2: Number2_2): Number3_2 =
    Number1_2U.IF()(tail2)(num2_1)(num2_2)(Number3_2S(() => tail2.method2(num2_1, num2_2)))
}
case class Number1_2T(tail2: Number1_2, tail1: Number1_1) extends Number1_2 {
  override def method2(num2_1: Number2_1, num2_2: Number2_2): Number3_2 =
    Number1_2U.IF(tail1)(tail2)(num2_1)(num2_2)(Number3_2T(() => num2_2.method4(tail2), () => tail1.method1(num2_1)))
}
case class Number1_2U(tail2: () => Number1_2, tail1: () => Number1_1) extends Number1_2 {
  override def method2(num2_1: Number2_1, num2_2: Number2_2): Number3_2 = Number1_2U.IF(tail1())(tail2())(num2_1)(num2_2)(
    Number3_2T(() => num2_2.method4(tail2()), () => Number3_1S(() => tail1().method1(num2_1)))
  )
}
object Number1_2U {
  def IF(inputs1: Number1_1*)(inputs2: Number1_2*)(inputs3: Number2_1*)(inputs4: Number2_2*)(default: Number3_2): Number3_2 = {
    val bol1 = inputs1.forall(t => t == Number1_1U.Value)
    val bol2 = inputs2.forall(t => t == Number1_2U.Value)
    val bol3 = inputs3.forall(t => t == Number2_1U.Value)
    val bol4 = inputs4.forall(t => t == Number2_2U.Value)
    if (bol1 && bol2 && bol3 && bol4) Number3_2U.Value else default
  }

  lazy val Value: Number1_2U = Number1_2U(tail2 = () => Number1_2U.Value, tail1 = () => Number1_1U.Value)
}

// ====
trait Number2_1 {
  def method3(num1_1: Number1_1, num1_2: Number1_2): Number3_1
}
case class Number2_1S(tail1: Number2_1) extends Number2_1 {
  override def method3(num1_1: Number1_1, num1_2: Number1_2): Number3_1 =
    Number2_1U.IF(num1_1)(num1_2)(tail1)()(Number3_1S(() => tail1.method3(num1_1, num1_2)))
}
case class Number2_1T(tail1: Number2_1, tail2: Number2_2) extends Number2_1 {
  override def method3(num1_1: Number1_1, num1_2: Number1_2): Number3_1 =
    Number2_1U.IF(num1_1)(num1_2)(tail1)(tail2)(Number3_1T(() => num1_1.method1(tail1), () => tail2.method4(num1_2)))
}
case class Number2_1U(tail1: () => Number2_1, tail2: () => Number2_2) extends Number2_1 {
  override def method3(num1_1: Number1_1, num1_2: Number1_2): Number3_1 = Number2_1U.IF(num1_1)(num1_2)(tail1())(tail2())(
    Number3_1T(() => num1_1.method1(tail1()), () => Number3_2S(() => tail2().method4(num1_2)))
  )
}
object Number2_1U {
  def IF(inputs1: Number1_1*)(inputs2: Number1_2*)(inputs3: Number2_1*)(inputs4: Number2_2*)(default: Number3_1): Number3_1 = {
    val bol1 = inputs1.forall(t => t == Number1_1U.Value)
    val bol2 = inputs2.forall(t => t == Number1_2U.Value)
    val bol3 = inputs3.forall(t => t == Number2_1U.Value)
    val bol4 = inputs4.forall(t => t == Number2_2U.Value)
    if (bol1 && bol2 && bol3 && bol4) Number3_1U.Value else default
  }

  val Value: Number2_1U = Number2_1U(tail1 = () => Number2_1U.Value, tail2 = () => Number2_2U.Value)
}

trait Number2_2 {
  def method4(num1_2: Number1_2): Number3_2
}
case class Number2_2S(tail2: Number2_2) extends Number2_2 {
  override def method4(num1_2: Number1_2): Number3_2 = Number2_2U.IF()(num1_2)()(tail2)(Number3_2S(() => tail2.method4(num1_2)))
}
case class Number2_2T(tail2: Number2_2, tail1: Number2_1) extends Number2_2 {
  override def method4(num1_2: Number1_2): Number3_2 = Number2_2U.IF()(num1_2)(tail1)(tail2)(Number3_2S(() => num1_2.method2(tail1, tail2)))
}
case class Number2_2U(tail2: () => Number2_2, tail1: () => Number2_1) extends Number2_2 {
  override def method4(num1_2: Number1_2): Number3_2 = Number2_2U.IF()(num1_2)(tail1())(tail2())(num1_2.method2(tail1(), tail2()))
}
object Number2_2U {
  def IF(inputs1: Number1_1*)(inputs2: Number1_2*)(inputs3: Number2_1*)(inputs4: Number2_2*)(default: Number3_2): Number3_2 = {
    val bol1 = inputs1.forall(t => t == Number1_1U.Value)
    val bol2 = inputs2.forall(t => t == Number1_2U.Value)
    val bol3 = inputs3.forall(t => t == Number2_1U.Value)
    val bol4 = inputs4.forall(t => t == Number2_2U.Value)
    if (bol1 && bol2 && bol3 && bol4) Number3_2U.Value else default
  }

  val Value: Number2_2U = Number2_2U(tail2 = () => Number2_2U.Value, tail1 = () => Number2_1U.Value)
}

// ====
trait Number3_1
case class Number3_1S(tail1: () => Number3_1)                         extends Number3_1
case class Number3_1T(tail1: () => Number3_1, tail2: () => Number3_2) extends Number3_1
object Number3_1U {
  val Value: Number3_1S = Number3_1S(() => Value)
}

trait Number3_2
case class Number3_2S(tail2: () => Number3_2)                         extends Number3_2
case class Number3_2T(tail2: () => Number3_2, tail1: () => Number3_1) extends Number3_2
object Number3_2U {
  val Value: Number3_2S = Number3_2S(() => Value)
}
