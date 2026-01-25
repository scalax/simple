package net.scalax.simple
package codec

import net.scalax.simple.codec.to_list_generic.{BasedInstalledLabelled, PojoInstance}

trait SimpleJsonEncodeLabelled[F[_[_]]] {
  SimpleJsonEncodeLabelledSelf =>

  def jsonEncodeLabelled: F[({ type NamedF[_] = String })#NamedF]

  def encode: SimpleJsonCodecLabelled.Updater[F[({ type NamedF[_] = String })#NamedF], SimpleJsonEncodeLabelled[F]] =
    new SimpleJsonCodecLabelled.Updater[F[({ type NamedF[_] = String })#NamedF], SimpleJsonEncodeLabelled[F]] {
      override def update(
        m: F[({ type NamedF[_] = String })#NamedF] => F[({ type NamedF[_] = String })#NamedF]
      ): SimpleJsonEncodeLabelled[F] = new SimpleJsonEncodeLabelled[F] {
        override def jsonEncodeLabelled: F[({ type NamedF[_] = String })#NamedF] = m(SimpleJsonEncodeLabelledSelf.jsonEncodeLabelled)
      }
    }
}

trait SimpleJsonDecodeLabelled[F[_[_]]] {
  SimpleJsonDecodeLabelledSelf =>

  def jsonDecodeLabelled: F[({ type NamedF[_] = String })#NamedF]

  def decode: SimpleJsonCodecLabelled.Updater[F[({ type NamedF[_] = String })#NamedF], SimpleJsonDecodeLabelled[F]] =
    new SimpleJsonCodecLabelled.Updater[F[({ type NamedF[_] = String })#NamedF], SimpleJsonDecodeLabelled[F]] {
      override def update(
        m: F[({ type NamedF[_] = String })#NamedF] => F[({ type NamedF[_] = String })#NamedF]
      ): SimpleJsonDecodeLabelled[F] = new SimpleJsonDecodeLabelled[F] {
        override def jsonDecodeLabelled: F[({ type NamedF[_] = String })#NamedF] = m(SimpleJsonDecodeLabelledSelf.jsonDecodeLabelled)
      }
    }
}

trait SimpleJsonCodecLabelled[F[_[_]]] extends SimpleJsonEncodeLabelled[F] with SimpleJsonDecodeLabelled[F] {
  SimpleJsonCodecLabelledSelf =>

  override def jsonEncodeLabelled: F[({ type NamedF[_] = String })#NamedF]
  override def jsonDecodeLabelled: F[({ type NamedF[_] = String })#NamedF]

  override def encode: SimpleJsonCodecLabelled.Updater[F[({ type NamedF[_] = String })#NamedF], SimpleJsonCodecLabelled[F]] =
    new SimpleJsonCodecLabelled.Updater[F[({ type NamedF[_] = String })#NamedF], SimpleJsonCodecLabelled[F]] {
      override def update(
        m: F[({ type NamedF[_] = String })#NamedF] => F[({ type NamedF[_] = String })#NamedF]
      ): SimpleJsonCodecLabelled[F] = new SimpleJsonCodecLabelled[F] {
        override def jsonEncodeLabelled: F[({ type NamedF[_] = String })#NamedF] = m(SimpleJsonCodecLabelledSelf.jsonEncodeLabelled)
        override def jsonDecodeLabelled: F[({ type NamedF[_] = String })#NamedF] = SimpleJsonCodecLabelledSelf.jsonDecodeLabelled
      }
    }

  override def decode: SimpleJsonCodecLabelled.Updater[F[({ type NamedF[_] = String })#NamedF], SimpleJsonCodecLabelled[F]] =
    new SimpleJsonCodecLabelled.Updater[F[({ type NamedF[_] = String })#NamedF], SimpleJsonCodecLabelled[F]] {
      override def update(
        m: F[({ type NamedF[_] = String })#NamedF] => F[({ type NamedF[_] = String })#NamedF]
      ): SimpleJsonCodecLabelled[F] = new SimpleJsonCodecLabelled[F] {
        override def jsonEncodeLabelled: F[({ type NamedF[_] = String })#NamedF] = m(SimpleJsonCodecLabelledSelf.jsonEncodeLabelled)
        override def jsonDecodeLabelled: F[({ type NamedF[_] = String })#NamedF] = SimpleJsonCodecLabelledSelf.jsonDecodeLabelled
      }
    }

  def codec: SimpleJsonCodecLabelled.Updater[F[({ type NamedF[_] = String })#NamedF], SimpleJsonCodecLabelled[F]] =
    new SimpleJsonCodecLabelled.Updater[F[({ type NamedF[_] = String })#NamedF], SimpleJsonCodecLabelled[F]] {
      override def update(
        m: F[({ type NamedF[_] = String })#NamedF] => F[({ type NamedF[_] = String })#NamedF]
      ): SimpleJsonCodecLabelled[F] = new SimpleJsonCodecLabelled[F] {
        override def jsonEncodeLabelled: F[({ type NamedF[_] = String })#NamedF] = m(SimpleJsonCodecLabelledSelf.jsonEncodeLabelled)
        override def jsonDecodeLabelled: F[({ type NamedF[_] = String })#NamedF] = m(SimpleJsonCodecLabelledSelf.jsonDecodeLabelled)
      }
    }
}

object SimpleJsonCodecLabelled {

  trait Updater[T, +U] {
    def update(m: T => T): U
  }

  class Builder[F[_[_]]] {
    type Target = SimpleJsonCodecLabelled[F]

    def derived(implicit bi: BasedInstalledLabelled[F]): SimpleJsonCodecLabelled[F] = new SimpleJsonCodecLabelled[F] {
      override def jsonEncodeLabelled: F[({ type NamedF[_] = String })#NamedF] = bi.labelled.modelLabelled
      override def jsonDecodeLabelled: F[({ type NamedF[_] = String })#NamedF] = bi.labelled.modelLabelled
    }

    def implicitly(implicit nModel: F[({ type NamedF[_] = String })#NamedF]): SimpleJsonCodecLabelled[F] = new SimpleJsonCodecLabelled[F] {
      override def jsonEncodeLabelled: F[({ type NamedF[_] = String })#NamedF] = nModel
      override def jsonDecodeLabelled: F[({ type NamedF[_] = String })#NamedF] = nModel
    }
  }

  type F[F[_[_]]] = SimpleJsonCodecLabelled[F]

  object F {
    def apply[ModelF[_[_]]]: Builder[ModelF] = new Builder[ModelF]
  }

}

trait SimpleJsonCodecLabelledPojo[Model] extends SimpleJsonCodecLabelled[({ type TR[UMF[_]] = PojoInstance[UMF, Model] })#TR] {
  PojoSelf =>

  override def encode
    : SimpleJsonCodecLabelled.Updater[PojoInstance[({ type NamedF[_] = String })#NamedF, Model], SimpleJsonCodecLabelledPojo[
      Model
    ]] =
    new SimpleJsonCodecLabelled.Updater[PojoInstance[({ type NamedF[_] = String })#NamedF, Model], SimpleJsonCodecLabelledPojo[Model]] {
      override def update(
        m: PojoInstance[({ type NamedF[_] = String })#NamedF, Model] => PojoInstance[({ type NamedF[_] = String })#NamedF, Model]
      ): SimpleJsonCodecLabelledPojo[Model] = new SimpleJsonCodecLabelledPojo[Model] {
        override def jsonEncodeLabelled: PojoInstance[({ type NamedF[_] = String })#NamedF, Model] = m(PojoSelf.jsonEncodeLabelled)
        override def jsonDecodeLabelled: PojoInstance[({ type NamedF[_] = String })#NamedF, Model] = PojoSelf.jsonDecodeLabelled
      }
    }

  override def decode
    : SimpleJsonCodecLabelled.Updater[PojoInstance[({ type NamedF[_] = String })#NamedF, Model], SimpleJsonCodecLabelledPojo[
      Model
    ]] =
    new SimpleJsonCodecLabelled.Updater[PojoInstance[({ type NamedF[_] = String })#NamedF, Model], SimpleJsonCodecLabelledPojo[Model]] {
      override def update(
        m: PojoInstance[({ type NamedF[_] = String })#NamedF, Model] => PojoInstance[({ type NamedF[_] = String })#NamedF, Model]
      ): SimpleJsonCodecLabelledPojo[Model] = new SimpleJsonCodecLabelledPojo[Model] {
        override def jsonEncodeLabelled: PojoInstance[({ type NamedF[_] = String })#NamedF, Model] = m(PojoSelf.jsonEncodeLabelled)
        override def jsonDecodeLabelled: PojoInstance[({ type NamedF[_] = String })#NamedF, Model] = PojoSelf.jsonDecodeLabelled
      }
    }

  override def codec
    : SimpleJsonCodecLabelled.Updater[PojoInstance[({ type NamedF[_] = String })#NamedF, Model], SimpleJsonCodecLabelledPojo[Model]] =
    new SimpleJsonCodecLabelled.Updater[PojoInstance[({ type NamedF[_] = String })#NamedF, Model], SimpleJsonCodecLabelledPojo[Model]] {
      override def update(
        m: PojoInstance[({ type NamedF[_] = String })#NamedF, Model] => PojoInstance[({ type NamedF[_] = String })#NamedF, Model]
      ): SimpleJsonCodecLabelledPojo[Model] = new SimpleJsonCodecLabelledPojo[Model] {
        override def jsonEncodeLabelled: PojoInstance[({ type NamedF[_] = String })#NamedF, Model] = m(PojoSelf.jsonEncodeLabelled)
        override def jsonDecodeLabelled: PojoInstance[({ type NamedF[_] = String })#NamedF, Model] = m(PojoSelf.jsonDecodeLabelled)
      }
    }
}

object SimpleJsonCodecLabelledPojo {
  def derived[Model](implicit
    blabelled: BasedInstalledLabelled[({ type TR[UMF[_]] = PojoInstance[UMF, Model] })#TR]
  ): SimpleJsonCodecLabelledPojo[Model] =
    new SimpleJsonCodecLabelledPojo[Model] {
      override def jsonEncodeLabelled: PojoInstance[({ type NamedF[_] = String })#NamedF, Model] = blabelled.labelled.modelLabelled
      override def jsonDecodeLabelled: PojoInstance[({ type NamedF[_] = String })#NamedF, Model] = blabelled.labelled.modelLabelled
    }
}
