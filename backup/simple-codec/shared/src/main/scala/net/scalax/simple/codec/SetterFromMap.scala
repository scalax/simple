package net.scalax.simple
package codec

import scala.collection.compat._

trait SetterFromMap[F[_[_]]] {
  def set[H[_]](model: Map[String, Any]): F[H]
}

object SetterFromMap {
  def apply[F[_[_]]]: SetterFromMapImpl[F] = new SetterFromMapImpl[F]

  class SetterFromMapImpl[F[_[_]]] {
    def generic(implicit setter: Setter[F], labelledNames: LabelledNames[F]): SetterFromMap[F] = new SetterFromMap[F] {
      override def set[H[_]](data: Map[String, Any]): F[H] = setter.input(for (keyNames <- labelledNames.names) yield data(keyNames))
    }
  }
}
