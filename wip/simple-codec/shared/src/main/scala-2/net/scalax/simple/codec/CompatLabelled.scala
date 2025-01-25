package net.scalax.simple.codec

import net.scalax.simple.codec.generic.SimpleNamed
import shapeless.HList
import net.scalax.simple.codec.to_list_generic.SimpleProduct1

trait CompatLabelled[F[_[_]]] {
  def modelLabelled: CompatLabelled.NamedType
}

object CompatLabelled {
  type NamedType = HList

  class Builder[F[_[_]]] {
    def derived(simpleNamed: SimpleNamed[F[({ type AnyF[_] = Any })#AnyF]]): CompatLabelled[F] = new CompatLabelled[F] {
      override val modelLabelled: CompatLabelled.NamedType = simpleNamed.labelled
    }

    def toLabelled(
      simpleProduct: SimpleProduct1.Appender[F],
      compatModel: CompatLabelled[F]
    ): F[({ type M1[_] = String })#M1] = {
      val fromListGeneric = FromListByTheSameTypeGeneric[F].derived(simpleProduct)
      val fromList = fromListGeneric.fromListByTheSameType[String, CompatLabelled.NamedType](
        takeHead = h => h.asInstanceOf[shapeless.::[Symbol, shapeless.HList]].head.name,
        takeTail = h => h.asInstanceOf[shapeless.::[Symbol, shapeless.HList]].tail
      )
      fromList(compatModel.modelLabelled)
    }

    def toLobelledSize(compat: CompatLabelled[F]): Int = compat.modelLabelled.runtimeLength
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]
}
