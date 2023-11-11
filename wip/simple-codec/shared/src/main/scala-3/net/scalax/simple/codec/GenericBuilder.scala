package net.scalax.simple
package codec
package utils
package impl

import shapeless3.deriving.*

trait GenericBuilder[Model, PolyInstance] {
  def value: Model
}

object GenericBuilder {
  type Aux[Model, PolyInstance] = GenericBuilder[Model, PolyInstance with DefaultGenericBuilder.type]
}

object DefaultGenericBuilder extends impl.GenericBuilderImpl

trait GenericBuilderImpl:

  inline given [T, PolyInstance](using g: K0.ProductGeneric[T]): GenericBuilder[T, PolyInstance] = new GenericBuilder[T, PolyInstance]:
    override def value: T =
      val fillerValue: impl2.FillerId[T, PolyInstance] = impl2.FillerId.fillerIdGen
      fillerValue.value

end GenericBuilderImpl

package impl2:

  trait FillerId[A, PolyInstance]:
    def value: A
  end FillerId

  object FillerId:

    given [A, PolyInstance](using a: => ModelImplement[PolyInstance, A]): FillerId[A, PolyInstance] with {
      override def value: A = a.value
    }

    given [PolyInstance]: FillerId[Unit, PolyInstance] with {
      override val value: Unit = ()
    }

    given fillerIdGen[A, PolyInstance](using inst: K0.ProductInstances[[x] =>> FillerId[x, PolyInstance], A]): FillerId[A, PolyInstance]
    with {
      override def value: A = inst.construct([t] => (ma: FillerId[t, PolyInstance]) => ma.value)
    }

  end FillerId

end impl2
