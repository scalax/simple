package net.scalax.simple.codec

trait MonadAdd[M[_, _]] {
  def zip[A, B, S, T](ma: M[A, B], ms: M[S, T]): M[(A, S), (B, T)]
  def to[A, B, S, T](m1: M[A, B])(in1: A => S, in2: B => T)(out1: S => A, out2: T => B): M[S, T]
  def zero: M[Unit, Unit]
}
