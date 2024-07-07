package net.scalax.simple.codec

trait ModelSize[F[_[_]]] {
  def modelSize: Int
}

object ModelSize {
  implicit def implicit1[F[_[_]]](implicit la: LabelledInstalled[F]): ModelSize[F] = new ModelSize[F] {
    override def modelSize: Int = la.modelSize
  }
}
