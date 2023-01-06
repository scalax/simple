package net.scalax.simple
package adt

object CoreInstance {
  // ===
  type Core2 = core.Core2
  def Core2(func: (() => Core2) => Core2): Core2 = new Core2 {
    override def apply(v1: () => Core2): Core2 = func(v1)
  }

  // ===
  val AdtListPositive: Core2       = Core2(tail => Core2(foldList => foldList.apply().apply(() => tail())))
  val AdtListZero: Core2           = Core2(otherFoldList => otherFoldList())
  lazy val AdtListException: Core2 = AdtListPositive(() => AdtListException)

  // ===
  val FoldListPositive: Core2         = Core2(tail => Core2(adtList => adtList.apply().apply(() => tail())))
  private val FoldListZeroImpl: Core2 = Core2(tail => Core2(foldList => tail.apply().apply(() => foldList())))
  lazy val FoldListZero: Core2        = FoldListZeroImpl(() => FoldListZero)
}
