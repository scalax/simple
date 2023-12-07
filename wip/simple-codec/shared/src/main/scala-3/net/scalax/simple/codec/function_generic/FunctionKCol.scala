package net.scalax.simple.codec.function_generic

object FunctionKCol {
  trait Func1K[In1[_]] {
    def input[T]: In1[T]
    type Input[T] = In1[T]
  }

  trait Func2K[In1[_], In2[_]] {
    def input[T]: In1[T] => In2[T]

    type Input[T] = In1[T] => In2[T]
  }

  trait Func3K[In1[_], In2[_], In3[_]] {
    def input[T]: (In1[T], In2[T]) => In3[T]
    type Input[T] = (In1[T], In2[T]) => In3[T]
  }
}
