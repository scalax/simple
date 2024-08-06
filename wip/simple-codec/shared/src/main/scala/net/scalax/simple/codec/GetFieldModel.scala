package net.scalax.simple.codec

import utils.SimpleP

trait GetFieldModel[F[_[_]]] {
  def getFieldModel[I[_]]: F[({ type XI[t] = F[I] => I[t] })#XI]
}

object GetFieldModel {

  class DerivedApply[F[_[_]] <: Product] {

    def derived(
      p: SimpleP.Appender[F],
      indexModel: IndexModel[F]
    ): GetFieldModel[F] = {
      val mapGeneric = MapGenerc[F].derived(p)

      new GetFieldModel[F] {
        override def getFieldModel[I[_]]: F[({ type XI[t] = F[I] => I[t] })#XI] = {
          val mapper = new MapGenerc.MapFunction[({ type U1[_] = Int })#U1, ({ type XI[t] = F[I] => I[t] })#XI] {
            def map[X1]: Int => F[I] => I[X1] = n => model => model.productElement(n).asInstanceOf[I[X1]]
          }

          mapGeneric.map[({ type U1[_] = Int })#U1, ({ type XI[t] = F[I] => I[t] })#XI](mapper)(indexModel.model)
        }
      }
    }

  }

  def apply[F[_[_]] <: Product]: DerivedApply[F] = new DerivedApply[F] {
    //
  }

}
