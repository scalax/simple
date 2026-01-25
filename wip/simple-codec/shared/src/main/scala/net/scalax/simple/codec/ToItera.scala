package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.{BasedInstalledLabelled, BasedInstalledModelSized, BasedInstalledSimpleProduct, ModelLink}
import net.scalax.simple.adt.nat.support.{SimpleProduct1, SimpleProductContextX, SimpleProductIt10Codengen}

trait ToItera[F[_[_]]] {
  toIteraSelf =>

  @inline def to[T](
    simpleProductX: SimpleProductContextX[F]
  ): SimpleProductContextX[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] =
    SimpleProductIt10Codengen.toItera[F, T](simpleProductX)

  def toBasedInstalled[T](
    oldInstanlled: BasedInstalledSimpleProduct[F] with BasedInstalledLabelled[F] with BasedInstalledModelSized[F]
  ): BasedInstalledSimpleProduct[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1]
    with BasedInstalledLabelled[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1]
    with BasedInstalledModelSized[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] =
    new BasedInstalledSimpleProduct[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1]
      with BasedInstalledLabelled[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1]
      with BasedInstalledModelSized[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] {
      override def basedInstalled: SimpleProductContextX[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] =
        toIteraSelf.to[T](oldInstanlled.basedInstalled)
      override def labelled: ModelLabelled[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] =
        ModelLabelled[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1].instance(oldInstanlled.labelled.modelLabelled)
      override def size: ModelSize[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] =
        ModelSize[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1].instance(oldInstanlled.size.modelSize)
    }

  def toModelLink[T](
    oldInstanlled: ModelLink[F, F[({ type X1[U] = U })#X1]]
  ): ModelLink[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1, F[({ type X1[_] = T })#X1]] =
    new ModelLink[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1, F[({ type X1[_] = T })#X1]] {
      override def basedInstalled: SimpleProductContextX[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] =
        toIteraSelf.to[T](oldInstanlled.basedInstalled)
      override def labelled: ModelLabelled[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] =
        ModelLabelled[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1].instance(oldInstanlled.labelled.modelLabelled)
      override def size: ModelSize[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1] =
        ModelSize[({ type F1[TX[_]] = F[({ type T1[_] = TX[T] })#T1] })#F1].instance(oldInstanlled.size.modelSize)

      override def toIdentity(t: F[({ type X1[_] = T })#X1]): F[({ type X1[_] = T })#X1]   = t
      override def fromIdentity(t: F[({ type X1[_] = T })#X1]): F[({ type X1[_] = T })#X1] = t
    }
}

object ToItera {

  class Builder[F[_[_]]] {
    @inline def derived: ToItera[F] = new ToItera[F] {
      //
    }
  }

  @inline def apply[F[_[_]]]: Builder[F] = new Builder[F]

}
