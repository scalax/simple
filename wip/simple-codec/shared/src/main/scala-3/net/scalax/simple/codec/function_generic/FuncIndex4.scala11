package net.scalax.simple.codec.function_generic

trait FuncIndex4[F[_[_]]] {
  def input[In1[_], In2[_], Out[_]](func3k: FunctionKCol.Func3K[In1, In2, Out]): (F[In1], F[In2]) => F[Out]
}

object FuncIndex4 {

  class DerivedApply[F[_[_]]] {
    def derived2(funcTyped3: FuncIndex3[F]): InnerApply[F] = new InnerApply[F](funcTyped3)
  }
  class InnerApply[F[_[_]]](g: FuncIndex3[F]) {
    def apply(n: FuncIndex1[F]): FuncIndex4[F] = new FuncIndex4[F] {
      override def input[In1[_], In2[_], Out[_]](func3k: FunctionKCol.Func3K[In1, In2, Out]): (F[In1], F[In2]) => F[Out] =
        n.input[In1, In2, Out](
          g.input[FunctionKCol.Func3K[In1, In2, Out]#Input](new FunctionKCol.Func1K[FunctionKCol.Func3K[In1, In2, Out]#Input] {
            override def input[T]: (In1[T], In2[T]) => Out[T] = (in1, in2) => func3k.input[T](in1, in2)
          })
        )
    }
  }

  def apply[F[_[_]]]: DerivedApply[F] = new DerivedApply[F]

}
