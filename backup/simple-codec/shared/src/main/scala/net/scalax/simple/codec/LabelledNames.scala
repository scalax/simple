package net.scalax.simple
package codec

import scala.collection.compat._

trait LabelledNames[F[_[_]]] {
  def names: List[String]
}
object LabelledNames extends impl.LabelledNamesImplExtra {
  def apply[F[_[_]]]: LabelledNamesImpl[F] = new LabelledNamesImpl[F]

  class LabelledNamesImpl[F[_[_]]] extends LabelledNamesImplImpl[F] {
    def build(model: LabelledInstance[F])(implicit cv: ContextO[F]#StringF <:< Product): LabelledNames[F] = new LabelledNames[F] {
      override val names: List[String] = model.model.productIterator.asInstanceOf[Iterator[String]].to(List)
    }
  }
}
