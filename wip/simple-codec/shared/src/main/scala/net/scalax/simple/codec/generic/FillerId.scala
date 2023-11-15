package net.scalax.simple
package codec
package utils
package impl

trait FillerId[H, Poly] {
  def value: H
}

object FillerId extends FillerIdPolyCompat
