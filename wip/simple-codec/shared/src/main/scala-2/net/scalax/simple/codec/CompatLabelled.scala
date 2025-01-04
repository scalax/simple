package net.scalax.simple.codec

import net.scalax.simple.codec.generic.SimpleNamed
import shapeless.HList
import utils.SimpleP
import net.scalax.simple.codec.to_list_generic.{ConvertM3, SimpleProduct3}

trait CompatLabelled[F[_[_]]] {
  def modelLabelled: CompatLabelled.NamedType
}

object CompatLabelled {
  type NamedType = HList

  implicit class CompatLabelledExtra1[F[_[_]]](val compat: CompatLabelled[F]) extends AnyVal {
    def toLabelled(simpleProduct: SimpleProduct3.NotHList.Appender[F]): ModelLabelled[F] = new ModelLabelled[F] {
      override def modelLabelled: F[({ type M1[_] = String })#M1] = {
        val sp3: SimpleP.Appender[F] = ConvertM3.AppendMonad.Appender.to3[F](simpleProduct)
        val fromListGeneric          = FromListByTheSameTypeGeneric[F].derived(sp3)
        val fromList = fromListGeneric.fromListByTheSameType[String, HList](
          takeHead = h => h.asInstanceOf[shapeless.::[Symbol, shapeless.HList]].head.name,
          takeTail = h => h.asInstanceOf[shapeless.::[Symbol, shapeless.HList]].tail
        )
        fromList(compat.modelLabelled)
      }
    }
  }

  implicit class CompatLabelledExtra2[F[_[_]]](val compat: CompatLabelled[F]) extends AnyVal {
    def toModelSize: ModelSize[F] = new ModelSize[F] {
      override def modelSize: Int = compat.modelLabelled.runtimeLength
    }
  }

  /*def toLabelled[F[_[_]]](simpleProduct: SimpleP.Appender[F], compat: CompatLabelled[F]): ModelLabelled[F] = new ModelLabelled[F] {
    override def modelLabelled: F[({ type M1[_] = String })#M1] = {
      val fromListGeneric = FromListByTheSameTypeGeneric[F].derived(simpleProduct)
      val fromList = fromListGeneric.fromListByTheSameType[String, HList](
        takeHead = h => h.asInstanceOf[shapeless.::[Symbol, shapeless.HList]].head.name,
        takeTail = h => h.asInstanceOf[shapeless.::[Symbol, shapeless.HList]].tail
      )
      fromList(compat.modelLabelled)
    }
  }

  def toModelSize[F[_[_]]](compat: CompatLabelled[F]): ModelSize[F] = new ModelSize[F] {
    override def modelSize: Int = compat.modelLabelled.runtimeLength
  }*/

  trait Apply[F[_[_]]] {
    def derived(
      simpleNamed: SimpleNamed[F[({ type AnyF[_] = Any })#AnyF]]
    ): CompatLabelled[F] = new CompatLabelled[F] {
      override val modelLabelled: CompatLabelled.NamedType = simpleNamed.labelled
    }
  }

  def apply[F[_[_]]]: Apply[F] = new Apply[F] {
    //
  }
}
