package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.{ToDecoderGeneric, ToDecoderGeneric2222}

trait BasedInstalled[F[_[_]]] {
  def labelled: F[({ type X1[_] = String })#X1]
  def decode2222: ToDecoderGeneric2222[F]
}

object BasedInstalled {

  class DerivedApply[F[_[_]]] {
    def derived(
      labelledInstalled: F[CompatLabelledInstalled.CompatNamed],
      decode2222: ToDecoderGeneric2222[F]
    ): BasedInstalled[F] = {
      val l1             = labelledInstalled
      val decode2222Impl = decode2222
      val lModel = LabelledInstalled[F].fromInstance(l1, MapGenerc[F].fromInstance(ToDecoderGeneric[F].fromInstance(decode2222Impl)))

      new BasedInstalled[F] {
        override def labelled: F[({ type X1[_] = String })#X1] = lModel.model
        override def decode2222: ToDecoderGeneric2222[F]       = decode2222Impl
      }
    }
  }

  def apply[F[_[_]]]: DerivedApply[F] = new DerivedApply[F]

}
