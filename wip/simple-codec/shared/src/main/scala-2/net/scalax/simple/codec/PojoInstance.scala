package net.scalax.simple.codec
package to_list_generic

import shapeless.::

trait PojoInstance[U[_], Model] {
  def instance: Any
}

object PojoInstance {

  implicit def hlistAppendFetch[U[_], T, Tail <: shapeless.HList](implicit
    h: U[T],
    tailInstance: PojoInstance[U, Tail]
  ): PojoInstance[U, T :: Tail] = new PojoInstance[U, T :: Tail] {
    override val instance: Any = h :: tailInstance.instance.asInstanceOf[shapeless.HList]
  }
  implicit def hlistZeroFetch[U[_]]: PojoInstance[U, shapeless.HNil] = new PojoInstance[U, shapeless.HNil] {
    override val instance: Any = shapeless.HNil
  }

  def instance[E[_], Model](n: Any): PojoInstance[E, Model] = new PojoInstance[E, Model] {
    override val instance: Any = n
  }

  def derived[Model, E[_], H <: shapeless.HList](implicit
    x: shapeless.Generic.Aux[Model, H],
    n: PojoInstance[E, H]
  ): PojoInstance[E, Model] = n.asInstanceOf[PojoInstance[E, Model]]

}
