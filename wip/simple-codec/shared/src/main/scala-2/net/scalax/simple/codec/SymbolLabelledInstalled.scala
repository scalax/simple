package net.scalax.simple.codec

import shapeless._

trait LabelledInstalled[F[_[_]]] {
  def model: F[LabelledInstalled.ToNamed]
}

object LabelledInstalled {
  trait SymbolHListToStringHList[-H1, +H2] {
    def to(h1: H1): H2
  }

  object SymbolHListToStringHList {
    implicit def implicit1[H1 <: HList, H2 <: HList](implicit
      cv: SymbolHListToStringHList[H1, H2]
    ): SymbolHListToStringHList[Symbol :: H1, String :: H2] = new SymbolHListToStringHList[Symbol :: H1, String :: H2] {
      override def to(h1: Symbol :: H1): String :: H2 = h1.head.name :: cv.to(h1.tail)
    }

    implicit val implicit2: SymbolHListToStringHList[HNil, HNil] = new SymbolHListToStringHList[HNil, HNil] {
      override def to(h: HNil): HNil = h
    }
  }

  trait LabelledGeneric[Model] {
    def generic[H1, H2](implicit l: DefaultSymbolicLabelling.Aux[Model, H1], mapper: SymbolHListToStringHList[H1, H2]): H2 =
      mapper.to(l.apply())
    def law[ModelImpl >: Model <: Model]: LabelledGeneric[ModelImpl] = LabelledGeneric[ModelImpl]
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
          def model: F[LabelledInstalled.ToNamed] = t.from(genericType)
        }
    }

    def instance(model: F[ToNamed]): LabelledInstalled[F] = {
      val model1 = model
      new LabelledInstalled[F] {
        override def model: F[ToNamed] = model1
      }
    }

    def summon(implicit model: LabelledInstalled[F]): LabelledInstalled[F] = model
  }

  def apply[F[_[_]]]: DerivedApply[F] = new DerivedApply[F]

}
