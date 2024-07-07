package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.SimpleProduct

trait LabelledInstalled[F[_[_]]] extends LabelledInstalled.Impl[({ type TypeF[I[_]] = F[({ type FX[_] = I[String] })#FX] })#TypeF] {

  override def simpleLabelled(
    fromList: FromListByTheSameTypeGeneric[({ type TypeF[I[_]] = F[({ type FX[_] = I[String] })#FX] })#TypeF]
  ): F[LabelledInstalled.Named]

  override def modelSize: Int

  def fromSimpleProduct(p: SimpleProduct.Appender[F]): F[LabelledInstalled.Named] = {
    val it       = ToItera[F].derived(p).to[String]
    val fromList = FromListByTheSameTypeGeneric[({ type TypeF[I[_]] = F[({ type FX[_] = I[String] })#FX] })#TypeF].derived(it)
    simpleLabelled(fromList)
  }

}

object LabelledInstalled {

  type Named[_] = String

  trait Impl[F[_[_]]] {
    def simpleLabelled(fromList: FromListByTheSameTypeGeneric[F]): F[LabelledInstalled.Named]

    def modelSize: Int
  }

  class DerivedApply[F[_[_]]] {

    type TypeF[I[_]] = F[({ type FX[_] = I[String] })#FX]

    private def initFromList(l: List[String]): LabelledInstalled[F] = new LabelledInstalled[F] {
      override def simpleLabelled(fromList: FromListByTheSameTypeGeneric[TypeF]): F[LabelledInstalled.Named] =
        fromList.fromListByTheSameType(l)
      override val modelSize: Int = l.size
    }

    def derived(implicit n: NamedImplicit[F[LabelledInstalled.Named]]): LabelledInstalled[F] = initFromList(n.input)

    def fromOther(o: LabelledInstalled.Impl[TypeF]): LabelledInstalled[F] = new LabelledInstalled[F] {
      override def simpleLabelled(fromList: FromListByTheSameTypeGeneric[TypeF]): F[LabelledInstalled.Named] =
        o.simpleLabelled(fromList)
      override val modelSize: Int = o.modelSize
    }

  }

  def apply[F[_[_]]]: DerivedApply[F] = new DerivedApply[F]

}
