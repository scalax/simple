package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.ToDecoderGeneric

trait LabelledInstalled[F[_[_]]] {
  def model: F[LabelledInstalled.ToNamed]
}

object LabelledInstalled {

  type ToNamed[_] = String

  class DerivedApply[F[_[_]]] {
    def derived(implicit compatLabelledInstalled: CompatLabelledInstalled[F], mapper: ToDecoderGeneric[F]): LabelledInstalled[F] = {
      /*val func1 = new Function1Apply[CompatLabelledInstalled.ToNamed, ToNamed] {
        override def apply[U](in: Symbol): String = in.name
      }
      instance(mapper.function1[CompatLabelledInstalled.ToNamed, ToNamed](func1)(compatLabelledInstalled.model))*/
      ???
    }

    def instance(model: F[ToNamed]): LabelledInstalled[F] = {
      val model1 = model
      new LabelledInstalled[F] {
        override val model: F[ToNamed] = model1
      }
    }

    def summon(implicit model: LabelledInstalled[F]): LabelledInstalled[F] = model
  }

  def apply[F[_[_]]]: DerivedApply[F] = new DerivedApply[F]

}
