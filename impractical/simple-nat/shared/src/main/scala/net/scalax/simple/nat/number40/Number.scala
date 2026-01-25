package net.scalax.simple
package nat
package number40

object Num40 {

  trait Num0
  object Num0 {
    case class Append1(tail: () => Num0) extends Num0
    case class Append2(tail: () => Num0) extends Num0
  }

  trait Num1 {
    def append(other: Num1): Num0
  }
  object Num1 {
    case class Append1(tail: () => Num1) extends Num1 {
      override def append(other: Num1): Num0 = Num0.Append1(() => other.append(tail()))
    }
    case class Append2(tail: () => Num1) extends Num1 {
      override def append(other: Num1): Num0 = Num0.Append2(() => other.append(tail()))
    }

    lazy val zero1: Append1 = Append1(() => zero2)
    lazy val zero2: Append2 = Append2(() => zero1)
  }

}
