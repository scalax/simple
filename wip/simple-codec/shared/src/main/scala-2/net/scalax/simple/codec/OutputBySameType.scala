package net.scalax.simple.codec

import shapeless._

trait OutputBySameType[F[_[_]], OutputType, I[_] >: OutputType <: OutputType] {
  def model(input: F[I]): List[OutputType]
}

object OutputBySameType {

  trait ToListImpl[-H, +T] {
    def instance(m: H): List[T]
  }
  object ToListImpl {
    implicit def aImplicit1[H1 <: HList, T](implicit hTail: ToListImpl[H1, T]): ToListImpl[T :: H1, T] = new ToListImpl[T :: H1, T] {
      override def instance(m: T :: H1): List[T] = m.head :: hTail.instance(m.tail)
    }
    implicit def bImplicit2[T]: ToListImpl[HNil, T] = new ToListImpl[HNil, T] {
      override def instance(m: HNil): List[T] = List.empty
    }
  }

  class DerivedApply[
    F[_[_]],
    I[_] >: OutputType <: OutputType,
    ModelType >: F[I] <: F[I],
    OutputType
  ] {

    def derived[H1](implicit
      generic: Generic.Aux[ModelType, H1],
      toListImpl: ToListImpl[H1, OutputType]
    ): OutputBySameType[F, OutputType, I] = new OutputBySameType[F, OutputType, I] {
      override def model(input: F[I]): List[OutputType] = toListImpl.instance(generic.to(input))
    }

    object law {
      def apply[ModelTypeImpl >: ModelType <: ModelType, OutputTypeImpl >: OutputType <: OutputType]
        : DerivedApply[F, I, ModelTypeImpl, OutputTypeImpl] = new DerivedApply[F, I, ModelTypeImpl, OutputTypeImpl]
    }
  }

  def apply[F[_[_]], OutputType, I[_] >: OutputType <: OutputType]: DerivedApply[F, I, F[I], OutputType] =
    new DerivedApply[F, I, F[I], OutputType]

}
