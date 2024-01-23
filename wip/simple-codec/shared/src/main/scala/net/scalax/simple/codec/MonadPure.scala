package net.scalax.simple.codec

trait MonadAdd[M[_, _]] {
  def zip[A, B, S, T](ma: M[A, B], ms: M[S, T]): M[(A, S), (B, T)]
  def to[A, B, S, T](m1: M[A, B])(in1: A => S, in2: B => T)(in3: S => A, in4: T => B): M[S, T]
  def zero: M[Unit, Unit]
}

trait MonadAdd1[M[_]] {
  def zip[A, B](ma: M[A], ms: M[B]): M[(A, B)]
  def to[A, B](m1: M[A])(in1: A => B)(out1: B => A): M[B]
  def zero: M[Unit]
}
