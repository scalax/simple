package net.scalax.simple.codec
package to_list_generic

trait FillIdentity[T] {
  def value: T
}

object FillIdentity {
  import shapeless3.deriving.*

  given [A1](using a: => A1): FillIdentity[A1] with {
    override def value: A1 = a
  }

  given monoidGen[A2](using inst: K0.ProductInstances[FillIdentity, A2]): FillIdentity[A2] with {
    override def value: A2 = inst.construct([t] => (ma: FillIdentity[t]) => ma.value)
  }

  class ModelFBuilder[T] {
    inline def derived(using generic: K0.ProductGeneric[T]): T = {
      val fillIdentity: FillIdentity[T] = FillIdentity.monoidGen[T]
      fillIdentity.value
    }
  }

  class ModelPojoBuilder[E[_], Model] {
    inline def derived(using
      g: scala.deriving.Mirror.ProductOf[Model],
      inst: K0.ProductInstances[FillIdentity, Tuple.Map[g.MirroredElemTypes, E]]
    ): PojoInstance[E, Model] = {
      val fillIdentity: FillIdentity[Tuple.Map[g.MirroredElemTypes, E]] = FillIdentity.monoidGen[Tuple.Map[g.MirroredElemTypes, E]]

      new PojoInstance[E, Model] {
        override def instance: Any = fillIdentity.value
      }
    }
  }

  object F {
    def apply[U[_], FMM[_[_]]]: ModelFBuilder[FMM[U]] = new ModelFBuilder[FMM[U]]
  }
  type F[U[_], FMM[_[_]]] = FMM[U]

  object Pojo {
    def apply[U[_], Model]: ModelPojoBuilder[U, Model] = new ModelPojoBuilder[U, Model]
  }
  type Pojo[U[_], Model] = PojoInstance[U, Model]

}
