package net.scalax.simple.codec

import shapeless._

object TypedHelper {

  def apply[Model]: CompatImpl5[Model] = new CompatImpl5[Model]

  class CompatImpl5[Model] {
    def build[H <: HList](implicit gen: Generic.Aux[Model, H]): SlickUtilsCompat.GenericInstance[Model, H] =
      new SlickUtilsCompat.GenericInstance[Model, H] {
        override val from: SlickUtilsCompat.FunctionOpt[H, Model] = new SlickUtilsCompat.FunctionOpt[H, Model] {
          override def apply(t: H): Model = gen.from(t)
        }
        override val to: SlickUtilsCompat.FunctionOpt[Model, H] = new SlickUtilsCompat.FunctionOpt[Model, H] {
          override def apply(t: Model): H = gen.to(t)
        }
      }
  }

}
