package net.scalax.simple.adt

import net.scalax.simple.core.Core2

object CoreInstance {
  private def Core2(func: (() => Core2) => Core2): Core2 = new Core2 {
    override def apply(v1: () => Core2): Core2 = func(v1)
  }

  type AdtList = Core2
  val AdtListPositive: AdtList = Core2(tail => Core2(foldList => foldList.apply().apply(() => tail())))
  class AdtListZero extends AdtList {
    override def apply(otherFoldList: () => Core2): Core2 = otherFoldList()
  }
  object AdtList {
    lazy val exception: Core2 = AdtListPositive(() => exception)
  }

  // ===
  type FoldList = Core2
  class FoldListPositive(tail: () => FoldList) extends FoldList {
    override def apply(adtList: () => FoldList): FoldList = adtList.apply().apply(() => tail())
  }
  object FoldListPositive {
    def apply(func: (() => Core2) => FoldListPositive): Core2 = Core2(func)
  }

  val FoldListZero: Core2 = Core2(tail => Core2(foldList => tail.apply().apply(() => foldList())))

  object FoldList {
    lazy val zero: Core2 = FoldListZero(() => zero)
  }
}
