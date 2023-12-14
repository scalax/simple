package net.scalax.simple.codec

trait Function0Generic[F[_[_]]] {
  def function0[T[_]](func: Function0Generic.Func0Func[T]): F[T]
}
object Function0Generic {
  trait Func0Func[T[_]] {
    def apply[U]: T[U]
  }
}

trait Function1Generic[F[_[_]]] {
  self: Function0Generic[F] with Function2Generic[F] =>

  def function1[T1[_], T2[_]](func1: Function1Generic.Func1Func[T1, T2])(f1: F[T1]): F[T2] = {
    type Func1[X] = T1[X] => T2[X]
    val func2 = new Function2Generic.Func2Func[Func1, T1, T2] {
      override def apply[X](i1: T1[X] => T2[X], i2: T1[X]): T2[X] = i1(i2)
    }
    val temp2: (F[Func1], F[T1]) => F[T2] = function2[Func1, T1, T2](func2)
    val func3: Function0Generic.Func0Func[Func1] = new Function0Generic.Func0Func[Func1] {
      override def apply[U]: T1[U] => T2[U] = t => func1(t)
    }
    val temp3: F[Func1] = self.function0[Func1](func3)
    temp2(temp3, f1)
  }
}
object Function1Generic {
  trait Func1Func[T1[_], T2[_]] {
    def apply[U](i: T1[U]): T2[U]
  }
}

trait Function2Generic[F[_[_]]] {
  def function2[T1[_], T2[_], T3[_]](func: Function2Generic.Func2Func[T1, T2, T3])(f1: F[T1], f2: F[T2]): F[T3]
}
object Function2Generic {
  trait Func2Func[T1[_], T2[_], T3[_]] {
    def apply[U](i1: T1[U], i2: T2[U]): T3[U]
  }
}

trait FunctionNGenericSum[F[_[_]]]
    extends Function0Generic[F]
    with Function1Generic[F]
    with Function2Generic[F]
    with impl.FunctionNGenericSumImpl[F]

/*trait Function3Generic[F[_[_]]] {
  self: Function2Generic[F] =>
  def function3[T1[_], T2[_], T3[_], TT[_]](func1: Function3Generic.Func3Func[T1, T2, T3, TT])(f1: F[T1], f2: F[T2], f3: F[T3]): F[TT] = {
    type Zip2[X] = (T1[X], T2[X])
    val func2: Function2Generic.Func2Func[Zip2, T3, TT] = new Function2Generic.Func2Func[Zip2, T3, TT] {
      override def apply[U](i1: (T1[U], T2[U]), i2: T3[U]): TT[U] = func1(i1._1, i1._2, i2)
    }
    val temp2: (F[Zip2], F[T3]) => F[TT] = self.function2[Zip2, T3, TT](func2)
    val func3: Function2Generic.Func2Func[T1, T2, Zip2] = new Function2Generic.Func2Func[T1, T2, Zip2] {
      override def apply[U](i1: T1[U], i2: T2[U]): (T1[U], T2[U]) = (i1, i2)
    }
    val temp3: (F[T1], F[T2]) => F[Zip2] = self.function2[T1, T2, Zip2](func3)
    temp2(temp3(f1, f2), f3)
  }
}
object Function3Generic {
  trait Func3Func[T1[_], T2[_], T3[_], TT[_]] {
    def apply[U](i1: T1[U], i2: T2[U], i3: T3[U]): TT[U]
  }
}

trait Function4Generic[F[_[_]]] {
  self: Function2Generic[F] =>
  def function3[T1[_], T2[_], T3[_], T4[_], TT[_]](
    func1: Function4Generic.Func4Func[T1, T2, T3, T4, TT]
  )(f1: F[T1], f2: F[T2], f3: F[T3], f4: F[T4]): F[TT] = {
    type Zip3[X] = (T1[X], T2[X], T3[X])
    val func2: Function2Generic.Func2Func[Zip3, T4, TT] = new Function2Generic.Func2Func[Zip3, T4, TT] {
      override def apply[U](i1: (T1[U], T2[U], T3[U]), i2: T4[U]): TT[U] = func1(i1._1, i1._2, i1._3, i2)
    }
    val temp2: (F[Zip3], F[T4]) => F[TT] = self.function2[Zip3, T4, TT](func2)
    type Zip2[X] = (T1[X], T2[X])
    val func3: Function2Generic.Func2Func[Zip2, T3, Zip3] = new Function2Generic.Func2Func[Zip2, T3, Zip3] {
      override def apply[U](i1: (T1[U], T2[U]), i2: T3[U]): (T1[U], T2[U], T3[U]) = (i1._1, i1._2, i2)
    }
    val temp3: (F[Zip2], F[T3]) => F[Zip3] = self.function2[Zip2, T3, Zip3](func3)
    val func4: Function2Generic.Func2Func[T1, T2, Zip2] = new Function2Generic.Func2Func[T1, T2, Zip2] {
      override def apply[U](i1: T1[U], i2: T2[U]): (T1[U], T2[U]) = (i1, i2)
    }
    val temp4: (F[T1], F[T2]) => F[Zip2] = self.function2[T1, T2, Zip2](func4)
    temp2(temp3(temp4(f1, f2), f3), f4)
  }
}
object Function4Generic {
  trait Func4Func[T1[_], T2[_], T3[_], T4[_], TT[_]] {
    def apply[U](i1: T1[U], i2: T2[U], i3: T3[U], i4: T4[U]): TT[U]
  }
}*/
