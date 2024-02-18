package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.{ToDecoderGeneric, ToDecoderGeneric1, ToDecoderGeneric2222}

trait BasedInstalled[F[_[_]]] {
  def labelled: F[LabelledInstalled.Named]
  def decode: ToDecoderGeneric[F]
  def decode1: ToDecoderGeneric1[F]
  def decode2222: ToDecoderGeneric2222[F]
}

object BasedInstalled {

  class DerivedApply[F[_[_]]] {
    def derived(
      compatLabelledInstalled: CompatLabelledInstalled[F],
      decode: ToDecoderGeneric[F],
      decode2222: ToDecoderGeneric2222[F]
    ): BasedInstalled[F] = {
      val l1 = LabelledInstalled[F].derived(compatLabelledInstalled, decode)
      derived(l1, decode, decode2222)
    }

    def derived(
      labelledInstalled: LabelledInstalled[F],
      decode: ToDecoderGeneric[F],
      decode2222: ToDecoderGeneric2222[F]
    ): BasedInstalled[F] = {
      val l1             = labelledInstalled
      val decodeImpl     = decode
      val decode1Impl    = ToDecoderGeneric1.fromGeneric2[F](decode, labelledInstalled.model)
      val decode2222Impl = decode2222

      new BasedInstalled[F] {
        override def labelled: F[LabelledInstalled.Named] = l1.model
        override def decode: ToDecoderGeneric[F]          = decodeImpl
        override def decode1: ToDecoderGeneric1[F]        = decode1Impl
        override def decode2222: ToDecoderGeneric2222[F]  = decode2222Impl
      }
    }
  }

  def apply[F[_[_]]]: DerivedApply[F] = new DerivedApply[F]

}
