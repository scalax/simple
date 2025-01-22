package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.SimpleProduct3

trait IndexModel[F[_[_]]] {
  def model: F[({ type Id[_] = Int })#Id]
}

object IndexModel {

  class DerivedApply[F[_[_]]] {

    def derived(p: SimpleProduct3.NotHList.Appender[F]): IndexModel[F] = {
      val fromList = FromListByTheSameTypeGeneric[F].derived(p)
      val fromInt  = fromList.fromListByTheSameType[Int, Int](takeHead = identity, takeTail = t => t + 1)
      val modelInt: F[({ type IntId[_] = Int })#IntId] = fromInt(0)

      new IndexModel[F] {
        override def model: F[({ type Id[_] = Int })#Id] = modelInt
      }
    }

  }

  def apply[F[_[_]]]: DerivedApply[F] = new DerivedApply[F] {
    //
  }

}
