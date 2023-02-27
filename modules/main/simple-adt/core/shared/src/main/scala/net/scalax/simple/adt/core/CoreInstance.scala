package net.scalax.simple
package adt

object CoreInstance {
  // ===
  type Core2 = core.Core2
  def Core2(func: (() => Core2) => Core2): Core2 = new Core2 {
    override def input(v1: => Core2): Core2 = func(() => v1)
  }

  // ===
  val AdtListPositive: Core2  = Core2(tail => Core2(foldList => foldList()(tail)))
  val AdtListZero: Core2      = Core2(otherFoldList => otherFoldList())
  val AdtListException: Core2 = Core2(foldList => foldList()(() => AdtListException)) // countNumReverse(() => AdtListException)

  // ===
  val FoldListPositive: Core2 = AdtListPositive
  val FoldListZero: Core2     = Core2(foldList => FoldListZero(foldList))
}
