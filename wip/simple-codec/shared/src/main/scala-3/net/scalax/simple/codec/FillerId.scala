package net.scalax.simple
package codec
package utils
package impl

import shapeless3.deriving.*

/*trait GenericBuilder[Model, PolyInstance] {
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

end GenericBuilderImpl*/

trait FillerId[A, PolyInstance]:
  def value: A
end FillerId

object FillerId:

  given [A1, PolyInstance](using a: => ModelImplement[PolyInstance, A1]): FillerId[A1, PolyInstance] with {
    override def value: A1 = a.value
  }

  given [PolyInstance]: FillerId[Unit, PolyInstance] with {
    override val value: Unit = ()
  }

  given [A2, PolyInstance](using inst: K0.ProductInstances[[x] =>> FillerId[x, PolyInstance], A2]): FillerId[A2, PolyInstance] with {
    override def value: A2 = inst.construct([t] => (ma: FillerId[t, PolyInstance]) => ma.value)
  }

end FillerId
