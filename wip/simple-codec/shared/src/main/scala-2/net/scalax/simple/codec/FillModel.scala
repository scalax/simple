package net.scalax.simple.codec

trait FillFuncInstance[F[_[_]]] {
  def fill[I[_]](identityGetter: IdentityGetter.FGen[I]): F[I]
}

abstract class FillFuncInstanceImpl1[F[_[_]]](val getter: FillIdentity[F, IdentityGetter]) extends FillFuncInstance[F]
