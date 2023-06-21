package net.scalax.simple
package codec

final class PropertyTag[T] {
  override val toString: String = "PropertyTag for empty value."
}

object PropertyTag {
  private val empty: PropertyTag[Any] = new PropertyTag[Any]
  def value[T]: PropertyTag[T]        = empty.asInstanceOf[PropertyTag[T]]
}
