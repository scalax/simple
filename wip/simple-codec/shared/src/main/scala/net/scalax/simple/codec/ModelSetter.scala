package net.scalax.simple.codec

import scala.collection.compat._

trait ModelSetter[F[_[_]]] {
  def input[U[_]](data: List[Any]): F[U]
}

object ModelSetter extends ModelSetterImplicitImpl
