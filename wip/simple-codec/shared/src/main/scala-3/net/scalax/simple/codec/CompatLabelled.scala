package net.scalax.simple.codec

trait CompatLabelled[F[_[_]]] {
  def compatLabelled: Any
}

object CompatLabelled {

  class Builder[F[_[_]]] {
    def instance(t: Any): CompatLabelled[F] = new CompatLabelled[F] {
      override val compatLabelled: Any = t
    }

    def toLabelled(fromListGeneric: FromListByTheSameTypeGeneric[F], compatModel: CompatLabelled[F]): F[({ type M1[_] = String })#M1] = {
      val fromList = fromListGeneric.fromListByTheSameType[String, Any](
        takeHead = h => h.asInstanceOf[String *: Tuple].head,
        takeTail = h => h.asInstanceOf[String *: Tuple].tail
      )
      fromList(compatModel.compatLabelled)
    }

    def toLobelledSize(compat: CompatLabelled[F]): Int = compat.compatLabelled.asInstanceOf[Product].productArity
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]
}
