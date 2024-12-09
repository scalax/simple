package net.scalax.simple.codec

import net.scalax.simple.codec.generic.SimpleNamed
import utils.SimpleP

trait CompatLabelled[F[_[_]]] {
  def modelLabelled: CompatLabelled.NamedType
}

object CompatLabelled {
  type NamedType = Tuple

  extension [F[_[_]]](compat: CompatLabelled[F]) {
    def toLabelled(simpleProduct: SimpleP.Appender[F]): ModelLabelled[F] = new ModelLabelled[F] {
      override def modelLabelled: F[({ type M1[_] = String })#M1] = {
        val fromListGeneric = FromListByTheSameTypeGeneric[F].derived(simpleProduct)
        val fromList = fromListGeneric.fromListByTheSameType[String, Tuple](
          takeHead = h => h.asInstanceOf[*:[String, Tuple]].head,
          takeTail = h => h.asInstanceOf[*:[String, Tuple]].tail
        )
        fromList(compat.modelLabelled)
      }
    }
  }

  extension [F[_[_]]](compat: CompatLabelled[F]) {
    def toModelSize: ModelSize[F] = new ModelSize[F] {
      override def modelSize: Int = compat.modelLabelled.productArity
    }
  }

  /*def toLabelled[F[_[_]]](simpleProduct: SimpleP.Appender[F], compat: CompatLabelled[F]): ModelLabelled[F] = new ModelLabelled[F] {
    override def modelLabelled: F[({ type M1[_] = String })#M1] = {
      val fromListGeneric = FromListByTheSameTypeGeneric[F].derived(simpleProduct)
      val fromList = fromListGeneric.fromListByTheSameType[String, Tuple](
        takeHead = h => h.asInstanceOf[*:[String, Tuple]].head,
        takeTail = h => h.asInstanceOf[*:[String, Tuple]].tail
      )
      fromList(compat.modelLabelled)
    }
  }

  def toModelSize[F[_[_]]](compat: CompatLabelled[F]): ModelSize[F] = new ModelSize[F] {
    override def modelSize: Int = compat.modelLabelled.productArity
  }*/

  trait Apply[F[_[_]]] {
    def derived(simpleNamed: SimpleNamed[F[({ type AnyF[_] = Any })#AnyF]]): CompatLabelled[F] = new CompatLabelled[F] {
      override val modelLabelled: CompatLabelled.NamedType = simpleNamed.labelled.asInstanceOf[CompatLabelled.NamedType]
    }
  }

  def apply[F[_[_]]]: Apply[F] = new Apply[F] {
    //
  }
}
