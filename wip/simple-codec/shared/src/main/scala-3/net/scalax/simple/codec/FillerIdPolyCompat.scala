package net.scalax.simple
package codec
package utils
package impl

import shapeless3.deriving.*

trait FillerIdPolyCompat:

  given [A1](using a: => A1): FillerId[A1] with {
    override def value: A1 = a
  }

  given [A2](using inst: K0.ProductInstances[[x] =>> FillerId[x], A2]): FillerId[A2] with {
    override def value: A2 = inst.construct([t] => (ma: FillerId[t]) => ma.value)
  }

end FillerIdPolyCompat
