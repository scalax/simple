package net.scalax.simple
package codec
package impl

trait LabelledNamesImplExtra {
  class LabelledNamesImpl[F[_[_]]] {
    def generic(implicit u: NoneModelFiller[F], cv: F[ContextI#Tag] <:< Product): LabelledNames[F] = new LabelledNames[F] {
      override val names: List[String] = u.instance.productElementNames.to(List)
    }
  }
}
