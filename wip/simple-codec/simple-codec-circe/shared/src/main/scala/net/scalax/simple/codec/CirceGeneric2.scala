package net.scalax.simple.codec

import io.circe._
import net.scalax.simple.codec.to_list_generic.{BasedInstalled, ModelLink, PojoInstance, SimpleProduct3}
import net.scalax.simple.codec.utils.ByNameImplicit

object CirceGeneric2 {
  type Named[_] = String

  implicit def encodeModel[F[_[_]]](implicit g: F[Encoder], g1: ModelLink[F, F[cats.Id]]): Encoder[F[cats.Id]] =
    Encoder.instance[F[cats.Id]] { m =>
      val sp3: SimpleProduct3.Appender[F] = SimpleProduct3[F].derived(g1.basedInstalled)
      val named: F[Named]                 = g1.labelled.modelLabelled

      CirceGeneric.encodeModelImpl[F](m, sp3, named = named, g)
    }

  implicit def decodeModel[F[_[_]]](implicit g: F[Decoder], g1: ModelLink[F, F[cats.Id]]): Decoder[F[cats.Id]] =
    Decoder.instance[F[cats.Id]] { h =>
      val sp3: SimpleProduct3.Appender[F] = SimpleProduct3[F].derived(g1.basedInstalled)
      val named: F[Named]                 = g1.labelled.modelLabelled

      CirceGeneric.decodeModelImpl[F](h, sp3, named, g)
    }

  implicit def encodePojo[Model](implicit
    g1: ModelGetSet[({ type F[X[_]] = PojoInstance[X, Model] })#F, Model],
    basedInstalled: BasedInstalled[({ type F[X[_]] = PojoInstance[X, Model] })#F],
    g: ByNameImplicit[PojoInstance[Encoder, Model]]
  ): Encoder[Model] = Encoder.instance[Model] { m =>
    val sp3: SimpleProduct3.Appender[({ type F[X[_]] = PojoInstance[X, Model] })#F] =
      SimpleProduct3[({ type F[X[_]] = PojoInstance[X, Model] })#F].derived(basedInstalled.basedInstalled)
    val named: PojoInstance[Named, Model] = basedInstalled.labelled.modelLabelled

    CirceGeneric.encodeModelImpl[({ type F[X[_]] = PojoInstance[X, Model] })#F](g1.toIdentity(m), sp3, named = named, g.value)
  }

  implicit def decodePojo[Model](implicit
    g1: ModelGetSet[({ type F[X[_]] = PojoInstance[X, Model] })#F, Model],
    basedInstalled: BasedInstalled[({ type F[X[_]] = PojoInstance[X, Model] })#F],
    g: ByNameImplicit[PojoInstance[Decoder, Model]]
  ): Decoder[Model] = Decoder.instance[Model] { h =>
    val sp3: SimpleProduct3.Appender[({ type F[X[_]] = PojoInstance[X, Model] })#F] =
      SimpleProduct3[({ type F[X[_]] = PojoInstance[X, Model] })#F].derived(basedInstalled.basedInstalled)
    val named: PojoInstance[Named, Model] = basedInstalled.labelled.modelLabelled

    val r1 = CirceGeneric.decodeModelImpl[({ type F[X[_]] = PojoInstance[X, Model] })#F](h, sp3, named = named, g.value)
    for (m <- r1) yield g1.fromIdentity(m)
  }

}
