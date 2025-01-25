package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.SimpleProduct1

trait IndexModel[F[_[_]]] {
  def model: F[({ type Id[_] = Int })#Id]
}

object IndexModel {

  class Builder[F[_[_]]] {
    def derived(p: SimpleProduct1.Appender[F]): IndexModel[F] = {
      val fromList = FromListByTheSameTypeGeneric[F].derived(p)
      val fromInt  = fromList.fromListByTheSameType[Int, Int](takeHead = identity, takeTail = t => t + 1)
      val modelInt: F[({ type IntId[_] = Int })#IntId] = fromInt(0)

      new IndexModel[F] {
        override val model: F[({ type Id[_] = Int })#Id] = modelInt
      }
    }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
