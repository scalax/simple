package net.scalax.simple.codec.function_generic

trait FuncIndex5[F[_[_]]] {
  def input[In1[_], In2[_]](func3k: FunctionKCol.Func2K[In1, In2]): F[In1] => F[In2]
}

object FuncIndex5 {

  class DerivedApply[F[_[_]]] {
    def derived2(funcTyped3: FuncIndex3[F]): InnerApply[F] = new InnerApply[F](funcTyped3)
  }
  class InnerApply[F[_[_]]](g: FuncIndex3[F]) {
    def apply(n: FuncIndex2[F]): FuncIndex5[F] = new FuncIndex5[F] {
      override def input[In1[_], In2[_]](func2k: FunctionKCol.Func2K[In1, In2]): F[In1] => F[In2] = n.input[In1, In2](
        g.input[FunctionKCol.Func2K[In1, In2]#Input](new FunctionKCol.Func1K[FunctionKCol.Func2K[In1, In2]#Input] {
          override def input[T]: In1[T] => In2[T] = func2k.input[T]
        }),
        g.input[FunctionKCol.Func3K[FunctionKCol.Func2K[In1, In2]#Input, In1, In2]#Input](
          new FunctionKCol.Func1K[FunctionKCol.Func3K[FunctionKCol.Func2K[In1, In2]#Input, In1, In2]#Input] {
            override def input[T]: (In1[T] => In2[T], In1[T]) => In2[T] = (func1, in1) => func1(in1)
          }
        )
      )
    }
  }

  def apply[F[_[_]]]: DerivedApply[F] = new DerivedApply[F]

}
