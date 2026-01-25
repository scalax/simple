package net.scalax.simple.codec
package to_list_generic

import net.scalax.simple.adt.nat.support.SimpleProductContextX

trait ModelLinkCommonF[F[_[_]]] extends ModelLink[F, F[({ type U1[X] = X })#U1]] {
  modelLinkCommonFSelf =>

  override def toIdentity(t: F[({ type U1[X] = X })#U1]): F[({ type U1[X] = X })#U1]   = t
  override def fromIdentity(t: F[({ type U1[X] = X })#U1]): F[({ type U1[X] = X })#U1] = t

  override def basedInstalled: SimpleProductContextX[F] = {
    val fromFunc: GenericAuxFrom[F] = new GenericAuxFrom[F] {
      override def fromModel[X[_]](collection: Any): F[X] = modelLinkCommonFSelf.FFromInstance(collection)
    }
    val toFunc: GenericAuxTo[F] = new GenericAuxTo[F] {
      override def toModel[X[_]](model: F[X]): Any = modelLinkCommonFSelf.FToInstance(model)
    }

    SimpleProductX[F].derived(fromFunc, toFunc, modelLinkCommonFSelf.size)
  }

  override def labelled: ModelLabelled[F] = ModelLabelled[F].derived(
    modelLinkCommonFSelf.compatLabelled,
    FromListByTheSameTypeGeneric[F].derived(modelLinkCommonFSelf.basedInstalled.simpleProduct1)
  )
  override def size: ModelSize[F] = ModelSize[F].derived(modelLinkCommonFSelf.compatLabelled)

  protected def compatLabelled: CompatLabelled[F] = CompatLabelled[F].instance(modelLinkCommonFSelf.compatNamed)
  protected def compatNamed: Any
  protected def FToInstance[T[_]](x: F[T]): Any
  protected def FFromInstance[T[_]](x: Any): F[T]
}
