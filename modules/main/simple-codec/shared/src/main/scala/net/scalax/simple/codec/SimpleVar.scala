package net.scalax.simple
package codec

import scala.collection.compat._

class SimpleVar[T] {
  private var tempValue: Option[T] = Option.empty
  def value_=(t: T): Unit          = tempValue = Some(t)
  def value: T                     = tempValue.get
}

object SimpleVar {
  def apply[T](t: T): SimpleVar[T] = {
    val v = new SimpleVar[T]
    v.value = t
    v
  }
}
