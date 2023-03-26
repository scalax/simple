package net.scalax.simple
package codec
package impl

import shapeless3.deriving.*

trait GenericBuilderImpl:

  inline given [T](using g: K0.ProductGeneric[T]): GenericBuilder[T] = new GenericBuilder[T]:
    override def value: T =
      val fillerValue: impl2.FillerId[T] = impl2.FillerId.fillerIdGen
      fillerValue.value

end GenericBuilderImpl

package impl2:

  trait FillerId[A]:
    def value: A
  end FillerId

  object FillerId:

    given [A](using a: => A): FillerId[A] with
      override def value: A = a

    private val unitId = new FillerId[Unit]:
      override val value: Unit = ()
    end unitId

    given FillerId[Unit] = unitId

    given fillerIdGen[A](using inst: K0.ProductInstances[FillerId, A]): FillerId[A] with
      override def value: A = inst.construct([t] => (ma: FillerId[t]) => ma.value)

  end FillerId

end impl2
