package net.scalax.simple
package codec

trait EmptyTag[T]

object EmptyTag {
  def value[T]: EmptyTag[T] = anyTag.asInstanceOf[EmptyTag[T]]

  private object anyTag extends EmptyTag[Any]
}
