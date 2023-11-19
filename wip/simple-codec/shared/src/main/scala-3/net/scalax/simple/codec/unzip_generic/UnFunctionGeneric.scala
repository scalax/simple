package net.scalax.simple.codec

trait UnFunctionGeneric[F[_[_]]] {
  def unfunction[T1[_], T2[_]](from: F[UnFunctionGeneric.UnFunctionType[T1, T2]#UNFun]): F[T1] => F[T2]
}

object UnFunctionGeneric {
  class UnFunctionType[T1[_], T2[_]] {
    type UNFun[T] = T1[T] => T2[T]
  }

  trait Impl[F[_[_]]] extends UnFunctionGeneric[F] {
    type FuncImpl[T1[_], T2[_]] = UnFunctionType[T1, T2]
    def impl[T1[_], T2[_]]: (DerivedApply[F, T1, T2] => (F[UnFunctionGeneric.UnFunctionType[T1, T2]#UNFun] => (F[T1] => F[T2])))
    override def unfunction[T1[_], T2[_]](from: F[UnFunctionGeneric.UnFunctionType[T1, T2]#UNFun]): F[T1] => F[T2] =
      impl[T1, T2](UnFunctionGeneric[F, T1, T2])(from)
  }

  type MatchT1[u <: Tuple] <: Tuple = u match {
    case (h1 => h3) *: t => h1 *: MatchT1[t]
    case EmptyTuple      => EmptyTuple
  }
  type MatchT2[u <: Tuple] <: Tuple = u match {
    case (h1 => h3) *: t => h3 *: MatchT2[t]
    case EmptyTuple      => EmptyTuple
  }

  trait Func1ModelTrans[Input, -F1, +F3] {
    def input(i: Input): F1 => F3
  }

  object Func1ModelTrans {
    val instanceAny: Func1ModelTrans[Tuple, Tuple, Tuple] = new Func1ModelTrans[Tuple, Tuple, Tuple] { self =>
      override def input(i: Tuple): Tuple => Tuple = i match {
        case (hFunc: (Any => Any)) *: tailFunc =>
          _.match { case hData *: tailData =>
            hFunc(hData) *: self.input(tailFunc)(tailData)
          }
        case EmptyTuple => identity[Tuple]
      }
    }

    def instance[Input, F1, F3]: Func1ModelTrans[Input, F1, F3] = instanceAny.asInstanceOf
  }

  trait Func1ModelTransGeneric[Input, T1, T2] {
    def generic: Func1ModelTrans[Input, T1, T2] = Func1ModelTrans.instance
  }
  object Func1ModelTransGeneric {
    def apply[I, T1, T2]: Func1ModelTransGeneric[I, T1, T2] = new Func1ModelTransGeneric[I, T1, T2] {
      //
    }
  }

  class DerivedApply[F[_[_]], In1[_], In2[_]] {
    def derived2[H1 <: Tuple](generic1: SimpleTo[F[UnFunctionGeneric.UnFunctionType[In1, In2]#UNFun], H1]): InnerApply1[F, In1, In2, H1] =
      new InnerApply1[F, In1, In2, H1](generic1)
  }
  class InnerApply1[F[_[_]], In1[_], In2[_], H1 <: Tuple](generic: SimpleTo[F[UnFunctionGeneric.UnFunctionType[In1, In2]#UNFun], H1]) {
    def apply(
      func1: Func1ModelTransGeneric[H1, MatchT1[H1], MatchT2[H1]] => Func1ModelTrans[H1, MatchT1[H1], MatchT2[H1]]
    ): InnerApply2[F, In1, In2, H1, MatchT1[H1], MatchT2[H1]] =
      new InnerApply2[F, In1, In2, H1, MatchT1[H1], MatchT2[H1]](
        generic = generic,
        funcTrans = func1(Func1ModelTransGeneric[H1, MatchT1[H1], MatchT2[H1]])
      )
  }
  class InnerApply2[F[_[_]], In1[_], In2[_], H1, H2, H3](
    generic: SimpleTo[F[UnFunctionGeneric.UnFunctionType[In1, In2]#UNFun], H1],
    funcTrans: Func1ModelTrans[H1, H2, H3]
  ) {
    def apply(
      g1: SimpleTo[F[In1], H2],
      g2: SimpleFrom[F[In2], H3]
    ): F[UnFunctionGeneric.UnFunctionType[In1, In2]#UNFun] => (F[In1] => F[In2]) = { input => f1 =>
      g2.from(funcTrans.input(generic.to(input))(g1.to(f1)))
    }
  }

  def apply[F[_[_]], In1[_], In2[_]]: DerivedApply[F, In1, In2] = new DerivedApply[F, In1, In2]

}
