package net.scalax.simple.codec
package to_list_generic

trait PojoInstance[U[_], Model] {
  def instance: Any
}

object PojoInstance {

  /*implicit def hlistAppendFetch[U[_], T, Tail <: shapeless.HList](implicit
    h: U[T],
    tailInstance: PojoInstance[U, Tail]
  ): PojoInstance[U, T :: Tail] = new PojoInstance[U, T :: Tail] {
    override val instance: Any = h :: tailInstance.instance.asInstanceOf[shapeless.HList]
  }
  implicit def hlistZeroFetch[U[_]]: PojoInstance[U, shapeless.HNil] = new PojoInstance[U, shapeless.HNil] {
    override val instance: Any = shapeless.HNil
  }*/

  class Builder[U[_], Model] {
    def instance(n: Any): PojoInstance[U, Model] = new PojoInstance[U, Model] {
      override val instance: Any = n
    }

    /*def fill[H <: shapeless.HList](implicit x: shapeless.Generic.Aux[Model, H], n: PojoInstance[U, H]): PojoInstance[U, Model] =
      n.asInstanceOf[PojoInstance[U, Model]]*/
  }

  private val builderImplImpl: Builder[({ type X[_] = Any })#X, Any] = new Builder[({ type X[_] = Any })#X, Any]
  private def builderImpl[U[_], Model]: Builder[U, Model]            = builderImplImpl.asInstanceOf[Builder[U, Model]]

  def apply[U[_], Model]: Builder[U, Model] = builderImpl[U, Model]

}
