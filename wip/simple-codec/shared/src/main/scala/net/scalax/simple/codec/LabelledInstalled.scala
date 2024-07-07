package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.SimpleProduct

trait LabelledInstalled[F[_[_]]] {
  def impl: LabelledInstalled.Impl[({ type TypeF[I[_]] = F[({ type FX[_] = I[String] })#FX] })#TypeF]
}

object LabelledInstalled {

  trait Impl[F[_[_]]] {
    def simpleLabelled(m: FromListByTheSameTypeGeneric[F]): F[LabelledInstalled.Named]

    def labelled(
      m: SimpleProduct.Appender[F]
    ): F[LabelledInstalled.Named] = {
      val fromList: FromListByTheSameTypeGeneric[F] = FromListByTheSameTypeGeneric[F].derived(m)
      simpleLabelled(fromList)
    }

    def listString: List[String]
    def modelSize: Int = listString.size
  }

  type Named[_] = String

  class DerivedApply[F[_[_]]] {
    type TypeF[I[_]] = F[({ type FX[_] = I[String] })#FX]

    def derived(implicit n: NamedImplicit[F[LabelledInstalled.Named]]): LabelledInstalled[F] = new LabelledInstalled[F] {
      override val impl: LabelledInstalled.Impl[TypeF] = new LabelledInstalled.Impl[TypeF] {
        override def simpleLabelled(fromList: FromListByTheSameTypeGeneric[TypeF]): TypeF[LabelledInstalled.Named] =
          fromList.fromListByTheSameType(listString)
        override val listString: List[String] = n.input
      }
    }

    def fromOther(o: LabelledInstalled.Impl[TypeF]): LabelledInstalled[F] = new LabelledInstalled[F] {
      override val impl: LabelledInstalled.Impl[TypeF] = o
    }
  }

  def apply[F[_[_]]]: DerivedApply[F] = new DerivedApply[F]

}
