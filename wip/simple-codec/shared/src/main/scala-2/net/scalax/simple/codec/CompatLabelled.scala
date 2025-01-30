package net.scalax.simple.codec

trait CompatLabelled[F[_[_]]] {
  def compatLabelled: Any
}

object CompatLabelled {

  class Builder[F[_[_]]] {
    /*def derived(simpleNamed: DefaultSymbolicLabelling.Aux[F[({ type AnyF[_] = Any })#AnyF], _ <: HList]): CompatLabelled[F] =
      new CompatLabelled[F] {
        override val compatLabelled: Any = simpleNamed.apply()
      }*/

    def toLabelled(fromListGeneric: FromListByTheSameTypeGeneric[F], compatModel: CompatLabelled[F]): F[({ type M1[_] = String })#M1] = {
      val fromList = fromListGeneric.fromListByTheSameType[String, Any](
        takeHead = h => h.asInstanceOf[shapeless.::[Symbol, shapeless.HList]].head.name,
        takeTail = h => h.asInstanceOf[shapeless.::[Symbol, shapeless.HList]].tail
      )
      fromList(compatModel.compatLabelled)
    }

    def toLobelledSize(compat: CompatLabelled[F]): Int = compat.compatLabelled.asInstanceOf[shapeless.HList].runtimeLength
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]
}
