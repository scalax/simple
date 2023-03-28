package net.scalax.simple
package codec
package impl

import shapeless._
import scala.collection.compat._

trait LabelledNamesImplExtra {
  private def symbolHListToList(h: HList): List[String] = h match {
    case head :: tail => head.asInstanceOf[Symbol].name :: symbolHListToList(tail)
    case HNil         => List.empty
  }

  class LabelledNamesImplImpl[F[_[_]]] extends LabelledNamesImplImpl11[F, F[ContextI#NoneF]]

  trait LabelledNamesImplImpl11[F[_[_]], Model] {
    def generic[H <: HList](implicit u: DefaultSymbolicLabelling.Aux[Model, H]): LabelledNames[F] = new LabelledNames[F] {
      override val names: List[String] = symbolHListToList(u.apply())
    }
  }
}
