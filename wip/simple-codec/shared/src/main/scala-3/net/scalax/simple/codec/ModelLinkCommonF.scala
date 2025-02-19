package net.scalax.simple.codec
package to_list_generic

trait ModelLinkCommonF[F[_[_]]] extends ModelLink[F, F[({ type U1[X] = X })#U1]] {
  modelLinkCommonFSelf =>

  override def toIdentity(t: F[({ type U1[X] = X })#U1]): F[({ type U1[X] = X })#U1]   = t
  override def fromIdentity(t: F[({ type U1[X] = X })#U1]): F[({ type U1[X] = X })#U1] = t

  override def basedInstalled: SimpleProductX[F] = {
    val fromFunc: GenericAuxFrom[F] = new GenericAuxFrom[F] {
      override def fromModel[X[_]](collection: Any): F[X] = modelLinkCommonFSelf.FFromInstance(collection)
    }
    val toFunc: GenericAuxTo[F] = new GenericAuxTo[F] {
      override def toModel[X[_]](model: F[X]): Any = modelLinkCommonFSelf.FToInstance(model)
    }

    AppenderFromSize.tran[F](fromFunc, toFunc, modelLinkCommonFSelf.size)
  }

  override def labelled: ModelLabelled[F] =
    ModelLabelled[F].derived(modelLinkCommonFSelf.compatLabelled, modelLinkCommonFSelf.fromListByTheSameTypeGeneric)
  override def size: ModelSize[F] = ModelSize[F].derived(modelLinkCommonFSelf.compatLabelled)

  override def simpleProduct1: SimpleProduct1.Appender[F]                    = super.simpleProduct1
  override def fromListByTheSameTypeGeneric: FromListByTheSameTypeGeneric[F] = super.fromListByTheSameTypeGeneric

  protected def compatLabelled: CompatLabelled[F] = CompatLabelled[F].instance(modelLinkCommonFSelf.compatNamed)
  protected def compatNamed: Any
  protected def FToInstance[T[_]](x: F[T]): Any
  protected def FFromInstance[T[_]](x: Any): F[T]
}

object ModelLinkCommonF {
  import scala.deriving.Mirror

  class Builder[F[_[_]] <: Product] {
    inline def derived(using g: Mirror.ProductOf[F[({ type U1[_] = Any })#U1]]): ModelLinkCommonF[F] = {
      val namedModel = scala.compiletime.constValueTuple[g.MirroredElemLabels]

      new ModelLinkCommonF[F] {
        override val compatNamed: Any                  = namedModel
        override def FToInstance[T[_]](x: F[T]): Any   = Tuple.fromProduct(x.asInstanceOf)
        override def FFromInstance[T[_]](x: Any): F[T] = g.fromTuple(x.asInstanceOf[g.MirroredElemTypes]).asInstanceOf[F[T]]
      }
    }
  }

  def apply[F[_[_]] <: Product]: Builder[F] = new Builder[F]

}
