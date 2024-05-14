package net.scalax.simple.adt
package nat

trait AdtNat
trait AdtNatPositive[+Head, +T <: AdtNat] extends AdtNat {
  def data: Either[Head, T]
}
trait AdtNatZero extends AdtNat
