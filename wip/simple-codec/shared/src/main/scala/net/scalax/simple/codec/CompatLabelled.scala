package net.scalax.simple.codec

import net.scalax.simple.adt.nat.support.ExtractProductUtil

trait CompatLabelled[F[_[_]]] {
  def compatLabelled: Any
}

object CompatLabelled {
  private val proAbs = ExtractProductUtil.extraAbstraction.scalaVersionCompat

  class Builder[F[_[_]]] {
    def instance(t: Any): CompatLabelled[F] = new CompatLabelled[F] {
      override val compatLabelled: Any = t
    }

    def toLabelled(fromListGeneric: FromListByTheSameTypeGeneric[F], compatModel: CompatLabelled[F]): F[({ type M1[_] = String })#M1] = {
      val fromList = fromListGeneric.fromListByTheSameType[String, Any](
        takeHead = h => proAbs.labelledItemToString(proAbs.hListFunc.takeHead(h): Any),
        takeTail = h => proAbs.hListFunc.takeTail(h): Any
      )

      fromList(compatModel.compatLabelled)
    }

    def toLobelledSize(compat: CompatLabelled[F]): Int = proAbs.runtimeCountSize(compat.compatLabelled)
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
