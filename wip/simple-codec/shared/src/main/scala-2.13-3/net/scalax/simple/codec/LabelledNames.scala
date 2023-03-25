package net.scalax.simple
package codec
package impl

trait LabelledNamesImplExtra {
  def fill[F[_[_]]](implicit u: NoneModelFiller[F], cv: ContextO[F]#NoneF <:< Product): LabelledNames[F] = new LabelledNames[F] {
    override val names: List[String] = u.instance.productElementNames.to(List)
  }
}
