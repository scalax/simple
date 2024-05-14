package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.SimpleProduct

trait LabelledInstalled[F[_[_]]] {
  def labelled: F[LabelledInstalled.Named]
}

object LabelledInstalled {

  type Named[_] = String

  class DerivedApply[F[_[_]]] {
    def derived(m: SimpleProduct.Appender[F], n: NamedImplicit[F[NamedImplicit.Named]]): LabelledInstalled[F] =
      new LabelledInstalled[F] {
        override val labelled: F[Named] = {
          val listString                                = n.input[F](implicitly[F[NamedImplicit.Named] =:= F[NamedImplicit.Named]], m)
          val fromList: FromListByTheSameTypeGeneric[F] = FromListByTheSameTypeGeneric[F].derived(m)
          fromList.fromListByTheSameType(listString)
        }
      }
  }

  def apply[F[_[_]]]: DerivedApply[F] = new DerivedApply[F]

}
