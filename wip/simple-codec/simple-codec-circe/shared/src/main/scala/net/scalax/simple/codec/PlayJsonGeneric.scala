package net.scalax.simple
package codec

import play.api.libs.json._
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._
import net.scalax.simple.codec.to_list_generic.{BasedInstalledSimpleProduct, ModelLink, PojoInstance}
import net.scalax.simple.codec.utils.ByNameImplicit
import net.scalax.simple.adt.nat.support.{SimpleProduct3, SimpleProductContextX}

object PlayJsonGeneric {

  object F {
    implicit def encodeModelF[F[_[_]]](implicit
      g: ByNameImplicit[F[Writes]],
      g1: BasedInstalledSimpleProduct[F],
      sjn: SimpleJsonEncodeLabelled[F]
    ): Writes[F[({ type IDF[T] = T })#IDF]] = Writes(
      PlayJsonGeneric2.writesModelImpl[F](simpleProduct3 = g1.basedInstalled.simpleProduct3, sjn.jsonEncodeLabelled, () => g.value)
    )
  }

  object Pojo {
    implicit def encodeModelPojo[Model](implicit
      g1: ModelGet[({ type F[X[_]] = PojoInstance[X, Model] })#F, Model],
      basedInstalled: BasedInstalledSimpleProduct[({ type F[X[_]] = PojoInstance[X, Model] })#F],
      g: ByNameImplicit[PojoInstance[Writes, Model]],
      sjn: SimpleJsonEncodeLabelled[({ type F[X[_]] = PojoInstance[X, Model] })#F]
    ): Writes[Model] = {
      val w1: Writes[PojoInstance[({ type IDF[T] = T })#IDF, Model]] = F.encodeModelF[({ type F[X[_]] = PojoInstance[X, Model] })#F]
      w1.contramap[Model](g1.toIdentity)
    }
  }

}
