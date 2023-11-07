package net.scalax.simple.codec

import net.scalax.simple.codec.generic.SimpleFromProduct
import scala.deriving.Mirror
import scala.compiletime._

trait LabelledInstalled[F[_[_]]] {
  def model: F[LabelledInstalled.ToNamed]
}

object LabelledInstalled {

  trait LabelledGeneric[Model] {
    inline def generic(using l: Mirror.ProductOf[Model]): l.MirroredElemLabels = constValueTuple[l.MirroredElemLabels]
    def law[ModelImpl >: Model <: Model]: LabelledGeneric[ModelImpl]           = LabelledGeneric[ModelImpl]
  }
  object LabelledGeneric {
    def apply[T]: LabelledGeneric[T] = new LabelledGeneric[T] {
      //
    }
  }

  type ToNamed[_] = String

  class DerivedApply[F[_[_]]] {
    def derived2[HTypeTemp](
      genericType: LabelledGeneric[F[LabelledInstalled.ToNamed]] => HTypeTemp
    ): InnerApply1[HTypeTemp] = new InnerApply1[HTypeTemp](genericType(LabelledGeneric[F[LabelledInstalled.ToNamed]]))

    class InnerApply1[HTemp](genericType: HTemp) {
      def apply(t: SimpleFrom[F[LabelledInstalled.ToNamed], HTemp]): LabelledInstalled[F] =
        new LabelledInstalled[F] {
          val model: F[LabelledInstalled.ToNamed] = t.from(genericType)
        }
    }
  }

  def apply[F[_[_]]]: DerivedApply[F] = new DerivedApply[F]

}
