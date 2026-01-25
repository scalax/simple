package net.scalax.simple.codec

import net.scalax.simple.codec.to_list_generic.{BasedInstalledSimpleProduct, PojoInstance}
import shapeless.HList

trait ForAnn[F[_[_]], Ann] {
  def annInstance: F[({ type U11[_] = Option[Ann] })#U11]
}

object ForAnn {

  trait ModelBuilder[Model, Ann] {
    def derived[Out <: shapeless.HList](implicit
      sa: shapeless.Annotations.Aux[Ann, Model, Out],
      simplePro: BasedInstalledSimpleProduct[({ type F1[U[_]] = PojoInstance[U, Model] })#F1]
    ): ForAnn[({ type U11[A1[_]] = PojoInstance[A1, Model] })#U11, Ann] = {
      val fromList: FromListByTheSameTypeGeneric[({ type F1[U[_]] = PojoInstance[U, Model] })#F1] =
        FromListByTheSameTypeGeneric[({ type F1[U[_]] = PojoInstance[U, Model] })#F1].derived(simplePro.basedInstalled.simpleProduct1)

      val annIns: shapeless.HList = sa.apply().asInstanceOf[shapeless.HList]

      val toModel = fromList.fromListByTheSameType[Option[Ann], shapeless.HList](
        takeHead = t => t.asInstanceOf[shapeless.::[Option[Ann], HList]].head,
        takeTail = t => t.asInstanceOf[shapeless.::[Any, HList]].tail
      )

      new ForAnn[({ type U11[A1[_]] = PojoInstance[A1, Model] })#U11, Ann] {
        override val annInstance: PojoInstance[({ type U11[_] = Option[Ann] })#U11, Model] = toModel(annIns)
      }
    }
  }

  type Pojo[Model, Ann] = ForAnn[({ type U11[A1[_]] = PojoInstance[A1, Model] })#U11, Ann]
  def Pojo[Model, Ann]: ModelBuilder[Model, Ann] = new ModelBuilder[Model, Ann] {
    //
  }

}
