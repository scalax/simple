package net.scalax.simple.codec

trait FillFuncInstance[F[_[_]]] {
  def fill[I[_]](identityGetter: IdentityGetter.FGen[I]): F[I]
}

object FillFuncInstance {
  trait Impl1[F[_[_]]] extends FillFuncInstance[F] {
    def setter[I[_]]: SetToIdentity[F, I]
    override def fill[I[_]](identityGetter: IdentityGetter.FGen[I]): F[I] = setter[I].model(identityGetter)
  }
}
