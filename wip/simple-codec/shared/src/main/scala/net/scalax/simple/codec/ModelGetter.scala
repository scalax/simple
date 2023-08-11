package net.scalax.simple.codec

import scala.collection.compat._

trait ModelGetter[U] {
  def data(model: U): List[Any]
}

object ModelGetter {
  def generic[U <: Product]: ModelGetter[U] = new ModelGetter[U] {
    override def data(model: U): List[Any] = model.productIterator.to(List)
  }
}
