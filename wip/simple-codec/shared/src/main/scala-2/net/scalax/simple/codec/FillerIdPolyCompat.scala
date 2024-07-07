package net.scalax.simple
package codec
package utils
package impl

import shapeless._

trait FillerIdPolyCompat {
  implicit def implicit1[H1, Tail <: HList](implicit h: H1, t: FillerId[Tail]): FillerId[H1 :: Tail] =
    new FillerId[H1 :: Tail] {
      override val value: H1 :: Tail = h :: t.value
    }

  implicit val implicit2: FillerId[HNil] = new FillerId[HNil] {
    override val value: HNil = HNil
  }
}
