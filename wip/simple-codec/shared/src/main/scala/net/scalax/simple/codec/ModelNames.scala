package net.scalax.simple.codec

import scala.collection.compat._

trait ModelNames[F[_[_]]] {
  def names: List[String]
}

object ModelNames extends ModelNameImplicitImpl
