package net.scalax.simple.core

trait Core3_1[M[_], G[_]] {
  def apply[T]: M[T] => G[T]
}

trait Core3_2[F[_]] {
  def apply[A, B]: F[A] => F[B]
}
