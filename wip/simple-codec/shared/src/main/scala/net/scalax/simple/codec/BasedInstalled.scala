package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.ToDecoderGeneric2222

trait BasedInstalled[F[_[_]]] {
  def labelled: F[CompatLabelledInstalled.CompatNamed]
  def decode2222: ToDecoderGeneric2222[F]
}

object BasedInstalled {

  class DerivedApply[F[_[_]]] {
    def derived(
      labelledInstalled: F[CompatLabelledInstalled.CompatNamed],
      decode2222: ToDecoderGeneric2222[F]
    ): BasedInstalled[F] = {
      val decode2222Impl = decode2222

      new BasedInstalled[F] {
        override def labelled: F[CompatLabelledInstalled.CompatNamed] = labelledInstalled
        override def decode2222: ToDecoderGeneric2222[F]              = decode2222Impl
      }
    }
  }

  def apply[F[_[_]]]: DerivedApply[F] = new DerivedApply[F]

}
