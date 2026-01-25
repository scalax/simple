package net.scalax.simple.codec
package utils

trait HListLikeCol {
  HListLikeColSelf =>

  protected def instance: Tuple

  def runtimeLength: Int     = HListLikeColSelf.instance.productArity
  def runtimeList: List[Any] = HListLikeColSelf.instance.toList
  def isEmpty: Boolean       = HListLikeColSelf.runtimeLength == 0

  def unsafeHead: Any = HListLikeColSelf.instance.head

  def unsafeTail: HListLikeCol = HListLikeColSelf.instance match {
    case h *: t =>
      new HListLikeCol {
        override def instance: Tuple = t
      }
  }

}

object HListLikeCol {
  def apply(h: Tuple): HListLikeCol = new HListLikeCol {
    override protected def instance: Tuple = h
  }
}
