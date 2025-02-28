package net.scalax.simple.codec
package to_list_generic

trait ModelLinkPojo[Model] extends ModelLink[({ type F[X[_]] = PojoInstance[X, Model] })#F, Model] {
  modelLinkCommonFSelf =>

  override def toIdentity(t: Model): PojoInstance[({ type U1[X] = X })#U1, Model] =
    PojoInstance.instance[({ type U1[X] = X })#U1, Model](genericTo(t))
  override def fromIdentity(t: PojoInstance[({ type U1[X] = X })#U1, Model]): Model = genericFrom(t.instance)

  override def basedInstalled: SimpleProductX[({ type F[X[_]] = PojoInstance[X, Model] })#F] = {
    val fromFunc: GenericAuxFrom[({ type F[X[_]] = PojoInstance[X, Model] })#F] =
      new GenericAuxFrom[({ type F[X[_]] = PojoInstance[X, Model] })#F] {
        override def fromModel[X[_]](collection: Any): PojoInstance[X, Model] = PojoInstance.instance[X, Model](collection)
      }
    val toFunc: GenericAuxTo[({ type F[X[_]] = PojoInstance[X, Model] })#F] =
      new GenericAuxTo[({ type F[X[_]] = PojoInstance[X, Model] })#F] {
        override def toModel[X[_]](model: PojoInstance[X, Model]): Any = model.instance
      }

    AppenderFromSize.tran[({ type F[X[_]] = PojoInstance[X, Model] })#F](fromFunc, toFunc, modelLinkCommonFSelf.size)
  }

  override def labelled: ModelLabelled[({ type F[X[_]] = PojoInstance[X, Model] })#F] =
    ModelLabelled[({ type F[X[_]] = PojoInstance[X, Model] })#F].instance(
      PojoInstance.instance[({ type Str[_] = String })#Str, Model](modelLinkCommonFSelf.compatLabelled.compatLabelled)
    )

  override def size: ModelSize[({ type F[X[_]] = PojoInstance[X, Model] })#F] =
    ModelSize[({ type F[X[_]] = PojoInstance[X, Model] })#F].derived(modelLinkCommonFSelf.compatLabelled)

  override def simpleProduct1: SimpleProduct1.Appender[({ type F[X[_]] = PojoInstance[X, Model] })#F] = super.simpleProduct1
  override def fromListByTheSameTypeGeneric: FromListByTheSameTypeGeneric[({ type F[X[_]] = PojoInstance[X, Model] })#F] =
    super.fromListByTheSameTypeGeneric

  protected def compatLabelled: CompatLabelled[({ type F[X[_]] = PojoInstance[X, Model] })#F] =
    CompatLabelled[({ type F[X[_]] = PojoInstance[X, Model] })#F].instance(modelLinkCommonFSelf.compatNamed)
  protected def compatNamed: Any
  protected def genericFrom(t: Any): Model
  protected def genericTo(t: Model): Any
}

object ModelLinkPojo {
  import scala.deriving.Mirror

  inline def derived[Model <: Product](using g: Mirror.ProductOf[Model]): ModelLinkPojo[Model] = {
    val namedModel = scala.compiletime.constValueTuple[g.MirroredElemLabels]

    new ModelLinkPojo[Model] {
      override val compatNamed: Any           = namedModel
      override def genericTo(x: Model): Any   = Tuple.fromProduct(x.asInstanceOf)
      override def genericFrom(x: Any): Model = g.fromTuple(x.asInstanceOf[g.MirroredElemTypes]).asInstanceOf[Model]
    }
  }

}
