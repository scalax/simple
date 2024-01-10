package net.scalax.simple.codec

trait MonadAdd[T[_]] {
  def zip[U, X](m1: T[U], m2: T[X]): T[(U, X)]
  def reverse_map[U, X](param: T[U])(func: X => U): T[X]
  def unit: T[Unit]
}
