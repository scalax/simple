package net.scalax.simple.codec
package to_list_generic

trait ModelLink[F[_[_]], Model] extends BasedInstalled[F] {
  def toIdentity(t: Model): F[({ type U1[X] = X })#U1]
  def fromIdentity(t: F[({ type U1[X] = X })#U1]): Model

  override def basedInstalled: SimpleProductX[F]
  override def labelled: ModelLabelled[F]
  override def size: ModelSize[F]

  override def simpleProduct1: SimpleProduct1.Appender[F]                    = super.simpleProduct1
  override def fromListByTheSameTypeGeneric: FromListByTheSameTypeGeneric[F] = super.fromListByTheSameTypeGeneric
}

object ModelLink {

  class Builder[F[_[_]], Model] {
    def implicitly(implicit x: ModelLink[F, Model]): ModelLink[F, Model] = x
  }

  def apply[F[_[_]], Model] = new Builder[F, Model]

}
