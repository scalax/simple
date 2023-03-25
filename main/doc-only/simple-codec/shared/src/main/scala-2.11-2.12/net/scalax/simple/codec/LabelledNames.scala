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

  def fill[F[_[_]]](implicit u: DefaultSymbolicLabelling.Aux[ContextO[F]#NoneF, _ <: HList]): LabelledNames[F] = new LabelledNames[F] {
    override val names: List[String] = symbolHListToList(u.apply())
  }
}
