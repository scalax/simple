package net.scalax.simple
package codec

trait FillIdentity[F[_[_]], I[_], Poly] {
  def modelImplement: F[FillIdentity.WithPoly[I, Poly]#Type]
  def model(mapGenerc: MapGenerc[F]): F[I] = FillIdentity.toModel(mapGenerc)(modelImplement)
}

object FillIdentity {
  type D[F[_[_]], I[_]] = FillIdentity[F, I, DefaultModelImplement.type]

  class WithPoly[I[_], P] {
    type Type[T] = ModelImplement[P, I[T]]
  }

  def toModel[F[_[_]], I[_], Poly](mapGenerc: MapGenerc[F]): F[WithPoly[I, Poly]#Type] => F[I] = { instance =>
    val mapper = mapGenerc.map[WithPoly[I, Poly]#Type, I](new MapGenerc.MapFunction[WithPoly[I, Poly]#Type, I] {
      override def map[X1]: ModelImplement[Poly, I[X1]] => I[X1] = m => m.value
    })

    mapper(instance)
  }

  def fromModel[F[_[_]], I[_], Poly](mapGenerc: MapGenerc[F]): F[I] => F[WithPoly[I, Poly]#Type] = { instance =>
    val mapper = mapGenerc.map[I, WithPoly[I, Poly]#Type](new MapGenerc.MapFunction[I, WithPoly[I, Poly]#Type] {
      override def map[X1]: I[X1] => ModelImplement[Poly, I[X1]] = m => new ModelImplement[Poly, I[X1]](m)
    })

    mapper(instance)
  }

  // ===

  trait FillIdentityGeneric[H1] {
    def generic(implicit
      h: utils.impl.FillerId[H1]
    ): utils.impl.FillerId[H1] = h
  }
  object FillIdentityGeneric {
    def apply[H1]: FillIdentityGeneric[H1] = new FillIdentityGeneric[H1] {
      //
    }
  }

  /*class DerivedApply[F[_[_]], I[_], Poly] {
    def derived2[H1](generic1: SimpleFrom[F[WithPoly[I, Poly]#Type], H1]): InnerApply2[F, I, H1, Poly] =
      new InnerApply2[F, I, H1, Poly](generic1)

    def summon(implicit model: FillIdentity[F, I, Poly]): FillIdentity[F, I, Poly] = model
  }

  class InnerApply2[F[_[_]], I[_], H1, P](simpleFrom: SimpleFrom[F[WithPoly[I, P]#Type], H1]) {
    def apply(f: FillIdentityGeneric[H1] => utils.impl.FillerId[H1]): FillIdentity[F, I, P] = new FillIdentity[F, I, P] {
      override val modelImplement: F[WithPoly[I, P]#Type] = simpleFrom.from(f(FillIdentityGeneric[H1]).value)
    }
  }

  def applyPoly[F[_[_]], I[_], Poly]: DerivedApply[F, I, Poly]             = new DerivedApply[F, I, Poly]
  def apply[F[_[_]], I[_]]: DerivedApply[F, I, DefaultModelImplement.type] = applyPoly[F, I, DefaultModelImplement.type]*/

}
