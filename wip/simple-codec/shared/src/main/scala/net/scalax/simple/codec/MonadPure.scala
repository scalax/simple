package net.scalax.simple.codec

trait MonadAdd[T[_]] {
  def zip[U, X](m1: T[U], m2: T[X]): T[(U, X)]
  def map[U, X](param: T[U])(func: U => X): T[X]
  def unit: T[Unit]
}
