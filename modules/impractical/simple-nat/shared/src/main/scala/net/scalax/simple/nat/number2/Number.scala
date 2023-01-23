package net.scalax.simple
package nat
package number2

object Number {

  type Core2 = core.Core2

  def Core2(t: (() => Core2) => Core2): Core2 = new Core2 {
    override def apply(v1: () => Core2): Core2 = t(v1)
  }

  val S: Core2      = Core2(tail1 => tail1())
  val SCount: Core2 = Core2(tail1 => PosotiveCount(tail1))

  def SZero: Core2 = S(() => SZero)

  case class PosotiveCount(tail: () => Core2) extends Core2 {
    override def apply(t: () => Core2): Core2 = throw new Exception
  }

}
