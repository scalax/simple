package net.scalax.simple.codec
package utils

import shapeless._

trait HListLikeCol {
  HListLikeColSelf =>

  protected def instance: shapeless.HList

  def runtimeLength: Int     = HListLikeColSelf.instance.runtimeLength
  def runtimeList: List[Any] = HListLikeColSelf.instance.runtimeList
  def isEmpty: Boolean       = HListLikeColSelf.runtimeLength == 0

  def unsafeHead: Any = HListLikeColSelf.instance match {
    case h :: t => h
  }

  def unsafeTail: HListLikeCol = HListLikeColSelf.instance match {
    case h :: t =>
      new HListLikeCol {
        override def instance: shapeless.HList = t
      }
  }

}

object HListLikeCol {
  def apply(h: shapeless.HList): HListLikeCol = new HListLikeCol {
    override protected def instance: HList = h
  }
}
