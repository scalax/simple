package net.scalax.simple
package codec

final class PropertyTag[T] {
  override val toString: String = "PropertyTag for empty value."
}

object PropertyTag {
  type AnyAux[T] = PropertyTag[Any]
  private val empty: PropertyTag[Any]                                                     = new PropertyTag[Any]
  def genericAny[F[_[_]]](implicit setter: ModelSetter[F[PropertyTag.AnyAux]]): F[AnyAux] = setter.inputSingleton(empty)
  def generic[F[_[_]]](implicit proAnyAux: F[AnyAux]): F[PropertyTag]                     = proAnyAux.asInstanceOf[F[PropertyTag]]
}
