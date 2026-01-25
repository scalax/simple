package net.scalax.simple.codec

import slick.lifted.{MappedProjection, ShapedValue}

object ShapedValueCompat {
  def mapToPro[T, U, Model](
    sv: ShapedValue[T, U],
    from: Model => U,
    to: U => Model,
    modelClassTag: scala.reflect.ClassTag[Model]
  ): MappedProjection[Model] = {
    sv.<>[Model](f = to, g = from.andThen(Some.apply))(modelClassTag)
  }
}
