package net.scalax.simple.codec

import shapeless._

trait ModelNameImplicitImpl {

  private def symbolHListToList(h: HList): List[String] = h match {
    case head :: tail => head.asInstanceOf[Symbol].name :: symbolHListToList(tail)
    case HNil         => List.empty
  }

  type AuxS[_] = PropertyTag[Any]

  def generic[F[_[_]] <: Product](emptyModel: F[AuxS])(implicit u: DefaultSymbolicLabelling.Aux[F[AuxS], _ <: HList]): ModelNames[F] = {
    val l = symbolHListToList(u.apply())
    new ModelNames[F] {
      override val names: List[String] = l
    }
  }

}
