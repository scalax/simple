package net.scalax.simple
package codec
package utils

trait AnyItemInstalller[F[_[_]]] {
  def generic(implicit v: GenericBuilder.Aux[F[ContextI#AnyF], AnyItemInstalller.type]): F[ContextI#AnyF] =
    TypeParameterBuilder[F].poly[AnyItemInstalller.type].build[ContextI#AnyF].generic
}

object AnyItemInstalller {

  trait InnerAnyItemInstalller {
    def getAndNext: Any
  }

  def fromSeq[F[_[_]]](n: Seq[Any]): AnyItemInstalller[F] = new AnyItemInstalller[F] with InnerAnyItemInstalller {
    private var tempValue: Seq[Any] = n
    override def getAndNext: Any = {
      val result: Any = tempValue.head
      tempValue = tempValue.tail
      result
    }
  }

  implicit def getByName[F[_[_]], PolyInstance, M](implicit v: AnyItemInstalller[F]): ModelImplement[PolyInstance, M] = v match {
    case n: InnerAnyItemInstalller => new ModelImplement[PolyInstance, M](n.getAndNext.asInstanceOf[M])
  }

}
