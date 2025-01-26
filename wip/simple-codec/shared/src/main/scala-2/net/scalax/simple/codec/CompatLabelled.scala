package net.scalax.simple.codec

import net.scalax.simple.codec.generic.SimpleNamed
import shapeless.HList
import net.scalax.simple.codec.to_list_generic.SimpleProduct1

trait CompatLabelled[F[_[_]]] {
  def compatLabelled: CompatLabelled.NamedType
}

object CompatLabelled {
  type NamedType = HList

  class Builder[F[_[_]]] {
    def derived(simpleNamed: SimpleNamed[F[({ type AnyF[_] = Any })#AnyF]]): CompatLabelled[F] = new CompatLabelled[F] {
      override val compatLabelled: CompatLabelled.NamedType = simpleNamed.labelled
    }

    def toLabelled(fromListGeneric: FromListByTheSameTypeGeneric[F], compatModel: CompatLabelled[F]): F[({ type M1[_] = String })#M1] = {
      val fromList = fromListGeneric.fromListByTheSameType[String, CompatLabelled.NamedType](
        takeHead = h => h.asInstanceOf[shapeless.::[Symbol, shapeless.HList]].head.name,
        takeTail = h => h.asInstanceOf[shapeless.::[Symbol, shapeless.HList]].tail
      )
      fromList(compatModel.compatLabelled)
    }

    def toLobelledSize(compat: CompatLabelled[F]): Int = compat.compatLabelled.runtimeLength
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]
}
