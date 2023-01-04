package net.scalax.simple
package adt

import core.Core2

object CoreInstance {
  private def Core2(func: (() => Core2) => Core2): Core2 = new Core2 {
    override def apply(v1: () => Core2): Core2 = func(v1)
  }

  // ===
  type AdtList = Core2
  val AdtListPositive: Core2 = Core2(tail => Core2(foldList => foldList.apply().apply(() => tail())))
  class AdtListZero extends Core2 {
    override def apply(otherFoldList: () => Core2): Core2 = otherFoldList()
  }
  lazy val AdtListException: Core2 = AdtListPositive(() => AdtListException)

  // ===
  type FoldList = Core2
  class FoldListPositive(tail: () => Core2) extends Core2 {
    override def apply(adtList: () => Core2): Core2 = adtList.apply().apply(() => tail())
  }
  object FoldListPositive {
    def apply(func: (() => Core2) => FoldListPositive): Core2 = Core2(func)
  }

  private val FoldListZeroImpl: Core2 = Core2(tail => Core2(foldList => tail.apply().apply(() => foldList())))

  lazy val FoldListZero: Core2 = FoldListZeroImpl(() => FoldListZero)

}
