package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.{ToDecoderGeneric, ToDecoderGeneric1, ToDecoderGeneric2222}

trait BasedInstalled[F[_[_]]] {
  def labelled: F[CompatLabelledInstalled.CompatNamed]
  def decode: ToDecoderGeneric[F]
  def decode2222: ToDecoderGeneric2222[F]
}

object BasedInstalled {

  class DerivedApply[F[_[_]]] {
    def derived(
      labelledInstalled: F[CompatLabelledInstalled.CompatNamed],
      decode: ToDecoderGeneric[F],
      decode2222: ToDecoderGeneric2222[F]
    ): BasedInstalled[F] = {
      val l1             = labelledInstalled
      val decodeImpl     = decode
      val decode2222Impl = decode2222

      new BasedInstalled[F] {
        override def labelled: F[CompatLabelledInstalled.CompatNamed] = l1
        override def decode: ToDecoderGeneric[F]                      = decodeImpl
        override def decode2222: ToDecoderGeneric2222[F]              = decode2222Impl
      }
    }
  }

  def apply[F[_[_]]]: DerivedApply[F] = new DerivedApply[F]

}
