package net.scalax.simple
package adt

object CoreInstance {
  // ===
  type Core2 = core.Core2
  def Core2(func: (() => Core2) => Core2): Core2 = new Core2 {
    override def apply(v1: () => Core2): Core2 = func(v1)
  }

  // ===
  private val countNum        = Core2(tail => Core2(foldList => tail.apply().apply(() => foldList())))
  private val countNumReverse = Core2(tail => Core2(foldList => countNum(foldList)(tail)))

  // ===
  val AdtListPositive: Core2  = countNumReverse
  val AdtListZero: Core2      = Core2(otherFoldList => otherFoldList())
  val AdtListException: Core2 = countNumReverse(() => AdtListException)

  // ===
  val FoldListPositive: Core2 = countNumReverse
  val FoldListZero: Core2     = countNum(() => FoldListZero)
}
