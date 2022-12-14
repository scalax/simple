package net.scalax.simple
package geshu

import core.Core2

object NumberImpl {

  def Core2(t: (() => Core2) => Core2): Core2 = new Core2 {
    override def apply(v1: () => Core2): Core2 = t(v1)
  }

  private var innerState: Int = null.asInstanceOf[Int]
  def 当前状态: Int               = innerState
  def 更新状态: Unit = this.synchronized {
    innerState = innerState + 1
  }
  def 重置状态: Unit = this.synchronized {
    innerState = 0
  }

  val S: Core2 = Core2(tail => Core2(number => Append(() => tail()(() => number()))))
  val T: Core2 = Core2(tail => Core2(number => tail()(() => number())))
  val U: Core2 = Core2(tail => Core2(number => Append(() => number()(() => tail()))))
  val V: Core2 = Core2(tail => Core2(number => number()(() => tail())))

  val Append: Core2 = Core2 { v =>
    更新状态
    v()
  }

}
