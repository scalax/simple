package net.scalax.simple
package codec
package impl

trait LabelledNamesImplExtra {
  trait LabelledNamesImplImpl[F[_[_]]] {
    def generic(implicit u: EmptyTagModelFiller[F], cv: F[ContextI#EmptyTagF] <:< Product): LabelledNames[F] = new LabelledNames[F] {
      override val names: List[String] = u.instance.productElementNames.to(List)
    }
    def distage(u: EmptyTagModelFiller[F])(implicit cv: F[ContextI#EmptyTagF] <:< Product): LabelledNames[F] = new LabelledNames[F] {
      override val names: List[String] = u.instance.productElementNames.to(List)
    }
  }
}
