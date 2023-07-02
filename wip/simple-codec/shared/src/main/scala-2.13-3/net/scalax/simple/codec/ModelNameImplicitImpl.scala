package net.scalax.simple.codec

trait ModelNameImplicitImpl {
  type AuxS[_] = PropertyTag[Any]
  def generic[F[_[_]] <: Product](implicit emptyModel: F[AuxS]): ModelNames[F] = {
    val l: List[String] = emptyModel.productElementNames.to(List)
    new ModelNames[F] {
      override val names: List[String] = l
    }
  }
}
