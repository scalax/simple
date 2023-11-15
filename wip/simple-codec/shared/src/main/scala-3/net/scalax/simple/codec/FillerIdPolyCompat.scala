package net.scalax.simple
package codec
package utils
package impl

import shapeless3.deriving.*

trait FillerIdPolyCompat:

  given [A1, PolyInstance](using a: => ModelImplement[PolyInstance, A1]): FillerId[A1, PolyInstance] with {
    override def value: A1 = a.value
  }

  given [PolyInstance]: FillerId[Unit, PolyInstance] with {
    override val value: Unit = ()
  }

  given [A2, PolyInstance](using inst: K0.ProductInstances[[x] =>> FillerId[x, PolyInstance], A2]): FillerId[A2, PolyInstance] with {
    override def value: A2 = inst.construct([t] => (ma: FillerId[t, PolyInstance]) => ma.value)
  }

end FillerIdPolyCompat
