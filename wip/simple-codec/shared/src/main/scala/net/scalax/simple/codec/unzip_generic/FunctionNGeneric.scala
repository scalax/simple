package net.scalax.simple.codec

trait Function0Generic[F[_[_]]] {
  def function0[T[_]](func: Function0Apply[T]): F[T]
}

trait Function1Generic[F[_[_]]] {
  self: Function0Generic[F] with Function2Generic[F] =>

  def function1[T1[_], T2[_]](func1: Function1Apply[T1, T2])(f1: F[T1]): F[T2] = {
    type Func1[X] = T1[X] => T2[X]
    val func2 = new Function2Apply[Func1, T1, T2] {
      override def apply[X](i1: T1[X] => T2[X], i2: T1[X]): T2[X] = i1(i2)
    }
    val temp2: (F[Func1], F[T1]) => F[T2] = function2[Func1, T1, T2](func2)
    val func3: Function0Apply[Func1] = new Function0Apply[Func1] {
      override def apply[U]: T1[U] => T2[U] = t => func1(t)
    }
    val temp3: F[Func1] = self.function0[Func1](func3)
    temp2(temp3, f1)
  }
}

trait Function2Generic[F[_[_]]] {
  def function2[T1[_], T2[_], T3[_]](func: Function2Apply[T1, T2, T3])(f1: F[T1], f2: F[T2]): F[T3]
}

trait FunctionNGenericSum[F[_[_]]]
    extends Function50Generic[F]
    with Function0Generic[F]
    with Function1Generic[F]
    with Function2Generic[F]
    with impl.FunctionNGenericSumImpl[F]
