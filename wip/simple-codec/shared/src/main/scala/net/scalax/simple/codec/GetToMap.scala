package net.scalax.simple
package codec

import scala.collection.compat._

trait GetToMap[F[_[_]]] {
  def output[H[_]](model: F[H]): Map[String, Any]
}

object GetToMap {
  def apply[F[_[_]]]: GetToMapImpl[F] = new GetToMapImpl[F]

  class GetToMapImpl[F[_[_]]] {
    def generic(implicit getter: Getter[F], labelledNames: LabelledNames[F]): GetToMap[F] = new GetToMap[F] {
      override def output[H[_]](model: F[H]): Map[String, Any] = Map.from(labelledNames.names.zip(getter.output(model)))
    }
  }
}
