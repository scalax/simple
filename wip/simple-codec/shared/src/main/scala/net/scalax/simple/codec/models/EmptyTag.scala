package net.scalax.simple
package codec

import shapeless._

trait EmptyTag[T]

object EmptyTag {
  def apply[T]: EmptyTag[T] = any.asInstanceOf[EmptyTag[T]]

  private val any: EmptyTag[Any] = {
    object a extends EmptyTag[Any]
    a
  }

  implicit def defaultEmptyTagApply[T]: EmptyTag[T] = EmptyTag[T]
}

trait ValueW[T] {
  val value: T
}

object ValueW {
  def apply[T](t: T): ValueW[T] = new ValueW[T] {
    override val value: T = t
  }

  private val emptyValue: ValueW[HNil] = ValueW(HNil)

  implicit def HListPositive[H, T <: HList](implicit h: H, t: ValueW[T]): ValueW[H :: T] = ValueW(h :: t.value)
  implicit val HListZero: ValueW[HNil]                                                   = emptyValue
}
