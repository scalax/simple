package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.ToDecoderGeneric

trait BasedInstallUtils[F[_[_]]] {
  def installed: BasedInstalled[F]

  def zip[S[_], T[_]]: (F[S], F[T]) => F[({ type K1[X] = (S[X], T[X]) })#K1] = {
    val decode: ToDecoderGeneric[F] = installed.decode
    ???
  }
}
