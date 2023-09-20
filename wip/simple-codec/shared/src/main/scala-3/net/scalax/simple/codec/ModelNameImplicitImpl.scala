package net.scalax.simple.codec

object TypedHelper:

  def apply[P <: Product]: CompatImpl5[P] = new CompatImpl5[P]

  class CompatImpl5[Model <: Product]:

    def build(using m: scala.deriving.Mirror.ProductOf[Model]): SlickUtilsCompat.GenericInstance[Model, m.MirroredElemTypes] =
      new SlickUtilsCompat.GenericInstance[Model, m.MirroredElemTypes]:
        override val from: SlickUtilsCompat.FunctionOpt[m.MirroredElemTypes, Model] = t => m.fromTuple(t)
        override val to: SlickUtilsCompat.FunctionOpt[Model, m.MirroredElemTypes]   = t => Tuple.fromProductTyped(t)
      end new
    end build

  end CompatImpl5

end TypedHelper
