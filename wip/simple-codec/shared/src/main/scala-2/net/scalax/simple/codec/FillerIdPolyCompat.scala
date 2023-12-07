package net.scalax.simple
package codec
package utils
package impl

import shapeless._

trait FillerIdPolyCompat {
  implicit def implicit1[H1, Tail <: HList, P](implicit h: ModelImplement[P, H1], t: FillerId[Tail, P]): FillerId[H1 :: Tail, P] =
    new FillerId[H1 :: Tail, P] {
      override val value: H1 :: Tail = h.value :: t.value
    }

  implicit def implicit2[P]: FillerId[HNil, P] = new FillerId[HNil, P] {
    override val value: HNil = HNil
  }
}
