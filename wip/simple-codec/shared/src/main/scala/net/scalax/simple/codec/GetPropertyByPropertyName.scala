package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.{BasedInstalledLabelled, BasedInstalledSimpleProduct}

trait GetPropertyByPropertyName[F[_[_]]] {
  def getPropertyImpl[T[_]](proName: String): F[T] => Any
  def getProperty[T[_], U](proName: String): F[T] => T[U] = {
    val pa: F[T] => Any = getPropertyImpl[T](proName)
    pa.asInstanceOf[F[T] => T[U]]
  }
}

object GetPropertyByPropertyName {
  trait Getter[F[_[_]], T] {
    def input[U[_]](m: F[U]): U[T]
  }

  class Builder[F[_[_]]] {
    def derived(appender1: BasedInstalledSimpleProduct[F], labelled: BasedInstalledLabelled[F]): GetPropertyByPropertyName[F] =
      new GetPropertyByPropertyName[F] {
        override def getPropertyImpl[T[_]](proName: String): F[T] => Any = (ft: F[T]) => {
          val s1 = appender1.basedInstalled.simpleProduct1

          val getP = GetPropertyByIndex[F].derived(s1)
          val inP  = IndexOfPropertyName[F].derived(s1)

          val indexOfName: Int = inP.ofName(proName, labelled.labelled.modelLabelled)

          getP.byIndex[T](indexOfName)(ft)
        }
      }
  }

  def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
