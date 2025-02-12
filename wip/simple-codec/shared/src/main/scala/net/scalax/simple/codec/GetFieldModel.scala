package net.scalax.simple.codec

trait GetFieldModel[F[_[_]]] {
  def getFieldModel[I[_]]: F[({ type XI[t] = F[I] => I[t] })#XI]
}

object GetFieldModel {

  class Builder[F[_[_]] <: Product] {

    def derived(
      p: MapGenerc[F],
      indexModel: IndexModel[F]
    ): GetFieldModel[F] = new GetFieldModel[F] {
      override def getFieldModel[I[_]]: F[({ type XI[t] = F[I] => I[t] })#XI] = {
        val mapper = new MapGenerc.MapFunction[({ type U1[_] = Int })#U1, ({ type XI[t] = F[I] => I[t] })#XI] {
          def map[X1](n: Int): F[I] => I[X1] = model => model.productElement(n).asInstanceOf[I[X1]]
        }

        p.map[({ type U1[_] = Int })#U1, ({ type XI[t] = F[I] => I[t] })#XI](mapper)(indexModel.model)
      }
    }

  }

  def apply[F[_[_]] <: Product]: Builder[F] = new Builder[F] {
    //
  }

}
