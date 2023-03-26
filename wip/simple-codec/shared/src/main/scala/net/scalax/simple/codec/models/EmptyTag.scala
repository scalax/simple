package net.scalax.simple
package codec

trait EmptyTag[T]

object EmptyTag {
  def apply[T]: EmptyTag[T] = any.asInstanceOf[EmptyTag[T]]

  private val any: EmptyTag[Any] = {
    object a extends EmptyTag[Any]
    a
  }

  implicit def defaultEmptyTagApply[T]: EmptyTag[T] = EmptyTag[T]
}
