package net.scalax.simple.codec

trait IndexModel[F[_[_]]] {
  def model: F[({ type Id[_] = Int })#Id]
}

object IndexModel {

  class Builder[F[_[_]]] {
    def derived(fromList: FromListByTheSameTypeGeneric[F]): IndexModel[F] = {
      val fromInt = fromList.fromListByTheSameType[Int, Int](takeHead = identity, takeTail = t => t + 1)
      val modelInt: F[({ type IntId[_] = Int })#IntId] = fromInt(0)

      new IndexModel[F] {
        override val model: F[({ type Id[_] = Int })#Id] = modelInt
      }
    }

    @inline def implicitly(implicit modelSize: IndexModel[F]): IndexModel[F] = modelSize
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
