package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.{ToDecoderGeneric, ToDecoderGeneric1}

trait BasedInstalled[F[_[_]]] {
  def labelled: LabelledInstalled[F]
  def funcion50: Function50Generic[F]
  def decode: ToDecoderGeneric[F]
  def decode1: ToDecoderGeneric1[F]
}

object BasedInstalled {

  class DerivedApply[F[_[_]]] {
    def derived(
      compatLabelledInstalled: CompatLabelledInstalled[F],
      mapper: Function50Generic[F],
      decode: ToDecoderGeneric[F],
      decode1: ToDecoderGeneric1[F]
    ): BasedInstalled[F] = {
      val l1 = LabelledInstalled[F].derived(compatLabelledInstalled, mapper)
      derived(l1, mapper, decode, decode1)
    }

    def derived(
      labelledInstalled: LabelledInstalled[F],
      mapper: Function50Generic[F],
      decode: ToDecoderGeneric[F],
      decode1: ToDecoderGeneric1[F]
    ): BasedInstalled[F] = {
      val l1          = labelledInstalled
      val decodeImpl  = decode
      val decode1Impl = decode1

      new BasedInstalled[F] {
        override def labelled: LabelledInstalled[F]  = l1
        override def funcion50: Function50Generic[F] = mapper
        override def decode: ToDecoderGeneric[F]     = decodeImpl
        override def decode1: ToDecoderGeneric1[F]   = decode1Impl
      }
    }
  }

  def apply[F[_[_]]]: DerivedApply[F] = new DerivedApply[F]

}
