package net.scalax.simple.codec

import net.scalax.simple.codec.generic.SimpleFromProduct
import scala.deriving.Mirror
import scala.compiletime._

trait SymbolLabelledInstalled[F[_[_]]] {
  def model: F[SymbolLabelledInstalled.ToNamedSymbol]
}

object SymbolLabelledInstalled {

  trait LabelledGeneric[Model] {
    inline def generic(using l: Mirror.ProductOf[Model]): l.MirroredElemLabels = constValueTuple[l.MirroredElemLabels]
    def law[ModelImpl >: Model <: Model]: LabelledGeneric[ModelImpl]           = LabelledGeneric[ModelImpl]
  }
  object LabelledGeneric {
    def apply[T]: LabelledGeneric[T] = new LabelledGeneric[T] {
      //
    }
  }

  type ToNamedSymbol[_] = String

  class DerivedApply[F[_[_]]] {
    def derived2[HTypeTemp](
      genericType: LabelledGeneric[F[SymbolLabelledInstalled.ToNamedSymbol]] => HTypeTemp
    ): InnerApply1[HTypeTemp] = new InnerApply1[HTypeTemp](genericType(LabelledGeneric[F[SymbolLabelledInstalled.ToNamedSymbol]]))

    class InnerApply1[HTemp](genericType: HTemp) {
      def apply(t: SimpleFrom[F[SymbolLabelledInstalled.ToNamedSymbol], HTemp]): SymbolLabelledInstalled[F] =
        new SymbolLabelledInstalled[F] {
          def model: F[SymbolLabelledInstalled.ToNamedSymbol] = t.from(genericType)
        }
    }
  }

  def apply[F[_[_]]]: DerivedApply[F] = new DerivedApply[F]

}
