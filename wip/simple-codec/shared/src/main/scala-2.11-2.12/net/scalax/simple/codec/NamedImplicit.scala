package net.scalax.simple
package codec

import shapeless._
import to_list_generic._

trait NamedImplicit {
  def names: HList
}

object NamedImplicit {
  type Named[_] = String

  implicit def getImplicit[F[_[_]]](implicit named: DefaultSymbolicLabelling.Aux[F[Named], _ <: HList]): NamedImplicit = new NamedImplicit {
    override def names: HList = named.apply()
  }

  def toNamedModel[F[_[_]]](m: ToDecoderGeneric2222[F], n: NamedImplicit): F[Named] = {
    def toList(l: HList): List[String] = l match {
      case head :: tail => head.asInstanceOf[String] :: toList(l.asInstanceOf[shapeless.::[_, _ <: HList]].tail)
      case HNil         => List.empty
    }

    val de1: ToDecoderGeneric[F]  = ToDecoderGeneric[F].fromInstance(m)
    val de2: ToDecoderGeneric1[F] = ToDecoderGeneric1[F].fromInstance(de1)

    ???
  }
}
