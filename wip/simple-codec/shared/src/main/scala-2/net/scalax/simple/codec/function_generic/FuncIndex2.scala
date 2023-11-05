package net.scalax.simple.codec.function_generic

trait FuncIndex2[F[_[_]]] {
  def input[In1[_], In2[_]](
    func2k: F[FunctionKCol.Func2K[In1, In2]#Input],
    func3k: F[FunctionKCol.Func3K[FunctionKCol.Func2K[In1, In2]#Input, In1, In2]#Input]
  ): F[In1] => F[In2]
}

object FuncIndex2 {

  class DerivedApply[F[_[_]]] {
    def derived(funcTyped3: FuncIndex1[F]): FuncIndex2[F] = new FuncIndex2[F] {
      def input[In1[_], In2[_]](
        func2k: F[FunctionKCol.Func2K[In1, In2]#Input],
        func3k: F[FunctionKCol.Func3K[FunctionKCol.Func2K[In1, In2]#Input, In1, In2]#Input]
      ): F[In1] => F[In2] = (f1: F[In1]) => funcTyped3.input[FunctionKCol.Func2K[In1, In2]#Input, In1, In2](func3k)(func2k, f1)
    }
  }

  def apply[F[_[_]]]: DerivedApply[F] = new DerivedApply[F]

}
