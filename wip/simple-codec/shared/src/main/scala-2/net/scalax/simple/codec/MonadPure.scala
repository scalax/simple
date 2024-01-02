package net.scalax.simple.codec

trait MonadAdd[T[_]] {
  def flatMap[U, X](m: T[U], a: U => T[X]): T[X]
  def map[U, X](m: T[U], a: U => X): T[X]
}
