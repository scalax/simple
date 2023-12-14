package net.scalax.simple.codec

object impl {

  private sealed trait InnerHList {
    def ::[Head](h: Head): InnerHPositive[Head, InnerHList] = new InnerHPositive(h, this)
  }

  private class InnerHPositive[+H, +T <: InnerHList](val head: H, val tail: T) extends InnerHList {
    override def ::[Head](h: Head): InnerHPositive[Head, InnerHPositive[H, T]] = new InnerHPositive(h, this)
  }

  private sealed trait InnerHZero extends InnerHList {
    override def ::[Head](h: Head): InnerHPositive[Head, InnerHZero] = new InnerHPositive(h, InnerHZero)
  }

  private case object InnerHZero extends InnerHZero

  private type ::[+H, +T <: InnerHList] = InnerHPositive[H, T]

  trait Function3Generic[F[_[_]]] {
    self: Function2Generic[F] with Function2Generic[F] =>

    def function3[T1[_], T2[_], T3[_], TOut[_]](func: Function3Generic.Func3Func[T1, T2, T3, TOut])(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T3, TOut] = new Function2Generic.Func2Func[ZipType, T3, TOut] {
        override def apply[X](param1: T1[X] :: T2[X] :: InnerHZero, i2: T3[X]): TOut[X] =
          func(param1.head, param1.tail.head, i2)
      }
      val func3: Function2Generic.Func2Func[T1, T2, ZipType] = new Function2Generic.Func2Func[T1, T2, ZipType] {
        override def apply[X](t1: T1[X], t2: T2[X]): T1[X] :: T2[X] :: InnerHZero = t1 :: t2 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function2(func3)(t1, t2)
      self.function2(func2)(temp2, t3)
    }
  }
  object Function3Generic {
    trait Func3Func[T1[_], T2[_], T3[_], TOut[_]] {
      def apply[X](t1: T1[X], t2: T2[X], t3: T3[X]): TOut[X]
    }
  }

  trait Function4Generic[F[_[_]]] {
    self: Function2Generic[F] with Function3Generic[F] =>

    def function4[T1[_], T2[_], T3[_], T4[_], TOut[_]](func: Function4Generic.Func4Func[T1, T2, T3, T4, TOut])(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T4, TOut] = new Function2Generic.Func2Func[ZipType, T4, TOut] {
        override def apply[X](param1: T1[X] :: T2[X] :: T3[X] :: InnerHZero, i2: T4[X]): TOut[X] =
          func(param1.head, param1.tail.head, param1.tail.tail.head, i2)
      }
      val func3: Function3Generic.Func3Func[T1, T2, T3, ZipType] = new Function3Generic.Func3Func[T1, T2, T3, ZipType] {
        override def apply[X](t1: T1[X], t2: T2[X], t3: T3[X]): T1[X] :: T2[X] :: T3[X] :: InnerHZero = t1 :: t2 :: t3 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function3(func3)(t1, t2, t3)
      self.function2(func2)(temp2, t4)
    }
  }
  object Function4Generic {
    trait Func4Func[T1[_], T2[_], T3[_], T4[_], TOut[_]] {
      def apply[X](t1: T1[X], t2: T2[X], t3: T3[X], t4: T4[X]): TOut[X]
    }
  }

  trait Function5Generic[F[_[_]]] {
    self: Function2Generic[F] with Function4Generic[F] =>

    def function5[T1[_], T2[_], T3[_], T4[_], T5[_], TOut[_]](func: Function5Generic.Func5Func[T1, T2, T3, T4, T5, TOut])(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T5, TOut] = new Function2Generic.Func2Func[ZipType, T5, TOut] {
        override def apply[X](param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: InnerHZero, i2: T5[X]): TOut[X] =
          func(param1.head, param1.tail.head, param1.tail.tail.head, param1.tail.tail.tail.head, i2)
      }
      val func3: Function4Generic.Func4Func[T1, T2, T3, T4, ZipType] = new Function4Generic.Func4Func[T1, T2, T3, T4, ZipType] {
        override def apply[X](t1: T1[X], t2: T2[X], t3: T3[X], t4: T4[X]): T1[X] :: T2[X] :: T3[X] :: T4[X] :: InnerHZero =
          t1 :: t2 :: t3 :: t4 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function4(func3)(t1, t2, t3, t4)
      self.function2(func2)(temp2, t5)
    }
  }
  object Function5Generic {
    trait Func5Func[T1[_], T2[_], T3[_], T4[_], T5[_], TOut[_]] {
      def apply[X](t1: T1[X], t2: T2[X], t3: T3[X], t4: T4[X], t5: T5[X]): TOut[X]
    }
  }

  trait Function6Generic[F[_[_]]] {
    self: Function2Generic[F] with Function5Generic[F] =>

    def function6[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], TOut[_]](func: Function6Generic.Func6Func[T1, T2, T3, T4, T5, T6, TOut])(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T6, TOut] = new Function2Generic.Func2Func[ZipType, T6, TOut] {
        override def apply[X](param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: InnerHZero, i2: T6[X]): TOut[X] =
          func(param1.head, param1.tail.head, param1.tail.tail.head, param1.tail.tail.tail.head, param1.tail.tail.tail.tail.head, i2)
      }
      val func3: Function5Generic.Func5Func[T1, T2, T3, T4, T5, ZipType] = new Function5Generic.Func5Func[T1, T2, T3, T4, T5, ZipType] {
        override def apply[X](t1: T1[X], t2: T2[X], t3: T3[X], t4: T4[X], t5: T5[X]): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] ::
          InnerHZero = t1 :: t2 :: t3 :: t4 :: t5 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function5(func3)(t1, t2, t3, t4, t5)
      self.function2(func2)(temp2, t6)
    }
  }
  object Function6Generic {
    trait Func6Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], TOut[_]] {
      def apply[X](t1: T1[X], t2: T2[X], t3: T3[X], t4: T4[X], t5: T5[X], t6: T6[X]): TOut[X]
    }
  }

  trait Function7Generic[F[_[_]]] {
    self: Function2Generic[F] with Function6Generic[F] =>

    def function7[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], TOut[_]](
      func: Function7Generic.Func7Func[T1, T2, T3, T4, T5, T6, T7, TOut]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T7, TOut] = new Function2Generic.Func2Func[ZipType, T7, TOut] {
        override def apply[X](param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: InnerHZero, i2: T7[X]): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function6Generic.Func6Func[T1, T2, T3, T4, T5, T6, ZipType] =
        new Function6Generic.Func6Func[T1, T2, T3, T4, T5, T6, ZipType] {
          override def apply[X](
            t1: T1[X],
            t2: T2[X],
            t3: T3[X],
            t4: T4[X],
            t5: T5[X],
            t6: T6[X]
          ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: InnerHZero = t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: InnerHZero
        }
      val temp2: F[ZipType] = self.function6(func3)(t1, t2, t3, t4, t5, t6)
      self.function2(func2)(temp2, t7)
    }
  }
  object Function7Generic {
    trait Func7Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], TOut[_]] {
      def apply[X](t1: T1[X], t2: T2[X], t3: T3[X], t4: T4[X], t5: T5[X], t6: T6[X], t7: T7[X]): TOut[X]
    }
  }

  trait Function8Generic[F[_[_]]] {
    self: Function2Generic[F] with Function7Generic[F] =>

    def function8[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], TOut[_]](
      func: Function8Generic.Func8Func[T1, T2, T3, T4, T5, T6, T7, T8, TOut]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T8, TOut] = new Function2Generic.Func2Func[ZipType, T8, TOut] {
        override def apply[X](param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: InnerHZero, i2: T8[X]): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function7Generic.Func7Func[T1, T2, T3, T4, T5, T6, T7, ZipType] =
        new Function7Generic.Func7Func[T1, T2, T3, T4, T5, T6, T7, ZipType] {
          override def apply[X](
            t1: T1[X],
            t2: T2[X],
            t3: T3[X],
            t4: T4[X],
            t5: T5[X],
            t6: T6[X],
            t7: T7[X]
          ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: InnerHZero =
            t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: InnerHZero
        }
      val temp2: F[ZipType] = self.function7(func3)(t1, t2, t3, t4, t5, t6, t7)
      self.function2(func2)(temp2, t8)
    }
  }
  object Function8Generic {
    trait Func8Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], TOut[_]] {
      def apply[X](t1: T1[X], t2: T2[X], t3: T3[X], t4: T4[X], t5: T5[X], t6: T6[X], t7: T7[X], t8: T8[X]): TOut[X]
    }
  }

  trait Function9Generic[F[_[_]]] {
    self: Function2Generic[F] with Function8Generic[F] =>

    def function9[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], TOut[_]](
      func: Function9Generic.Func9Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, TOut]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T9, TOut] = new Function2Generic.Func2Func[ZipType, T9, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: InnerHZero,
          i2: T9[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function8Generic.Func8Func[T1, T2, T3, T4, T5, T6, T7, T8, ZipType] =
        new Function8Generic.Func8Func[T1, T2, T3, T4, T5, T6, T7, T8, ZipType] {
          override def apply[X](t1: T1[X], t2: T2[X], t3: T3[X], t4: T4[X], t5: T5[X], t6: T6[X], t7: T7[X], t8: T8[X])
            : T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: InnerHZero =
            t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: InnerHZero
        }
      val temp2: F[ZipType] = self.function8(func3)(t1, t2, t3, t4, t5, t6, t7, t8)
      self.function2(func2)(temp2, t9)
    }
  }
  object Function9Generic {
    trait Func9Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], TOut[_]] {
      def apply[X](t1: T1[X], t2: T2[X], t3: T3[X], t4: T4[X], t5: T5[X], t6: T6[X], t7: T7[X], t8: T8[X], t9: T9[X]): TOut[X]
    }
  }

  trait Function10Generic[F[_[_]]] {
    self: Function2Generic[F] with Function9Generic[F] =>

    def function10[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], TOut[_]](
      func: Function10Generic.Func10Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, TOut]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T10, TOut] = new Function2Generic.Func2Func[ZipType, T10, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: InnerHZero,
          i2: T10[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function9Generic.Func9Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, ZipType] =
        new Function9Generic.Func9Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, ZipType] {
          override def apply[X](t1: T1[X], t2: T2[X], t3: T3[X], t4: T4[X], t5: T5[X], t6: T6[X], t7: T7[X], t8: T8[X], t9: T9[X])
            : T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: InnerHZero =
            t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: InnerHZero
        }
      val temp2: F[ZipType] = self.function9(func3)(t1, t2, t3, t4, t5, t6, t7, t8, t9)
      self.function2(func2)(temp2, t10)
    }
  }
  object Function10Generic {
    trait Func10Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], TOut[_]] {
      def apply[X](t1: T1[X], t2: T2[X], t3: T3[X], t4: T4[X], t5: T5[X], t6: T6[X], t7: T7[X], t8: T8[X], t9: T9[X], t10: T10[X]): TOut[X]
    }
  }

  trait Function11Generic[F[_[_]]] {
    self: Function2Generic[F] with Function10Generic[F] =>

    def function11[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], TOut[_]](
      func: Function11Generic.Func11Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, TOut]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T11, TOut] = new Function2Generic.Func2Func[ZipType, T11, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: InnerHZero,
          i2: T11[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function10Generic.Func10Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, ZipType] =
        new Function10Generic.Func10Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, ZipType] {
          override def apply[X](
            t1: T1[X],
            t2: T2[X],
            t3: T3[X],
            t4: T4[X],
            t5: T5[X],
            t6: T6[X],
            t7: T7[X],
            t8: T8[X],
            t9: T9[X],
            t10: T10[X]
          ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: InnerHZero =
            t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: InnerHZero
        }
      val temp2: F[ZipType] = self.function10(func3)(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10)
      self.function2(func2)(temp2, t11)
    }
  }
  object Function11Generic {
    trait Func11Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X]
      ): TOut[X]
    }
  }

  trait Function12Generic[F[_[_]]] {
    self: Function2Generic[F] with Function11Generic[F] =>

    def function12[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], TOut[_]](
      func: Function12Generic.Func12Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, TOut]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T12, TOut] = new Function2Generic.Func2Func[ZipType, T12, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: InnerHZero,
          i2: T12[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function11Generic.Func11Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, ZipType] =
        new Function11Generic.Func11Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, ZipType] {
          override def apply[X](
            t1: T1[X],
            t2: T2[X],
            t3: T3[X],
            t4: T4[X],
            t5: T5[X],
            t6: T6[X],
            t7: T7[X],
            t8: T8[X],
            t9: T9[X],
            t10: T10[X],
            t11: T11[X]
          ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: InnerHZero =
            t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: InnerHZero
        }
      val temp2: F[ZipType] = self.function11(func3)(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11)
      self.function2(func2)(temp2, t12)
    }
  }
  object Function12Generic {
    trait Func12Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X]
      ): TOut[X]
    }
  }

  trait Function13Generic[F[_[_]]] {
    self: Function2Generic[F] with Function12Generic[F] =>

    def function13[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], TOut[_]](
      func: Function13Generic.Func13Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, TOut]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T13, TOut] = new Function2Generic.Func2Func[ZipType, T13, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: InnerHZero,
          i2: T13[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function12Generic.Func12Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, ZipType] =
        new Function12Generic.Func12Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, ZipType] {
          override def apply[X](
            t1: T1[X],
            t2: T2[X],
            t3: T3[X],
            t4: T4[X],
            t5: T5[X],
            t6: T6[X],
            t7: T7[X],
            t8: T8[X],
            t9: T9[X],
            t10: T10[X],
            t11: T11[X],
            t12: T12[X]
          ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: InnerHZero =
            t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: InnerHZero
        }
      val temp2: F[ZipType] = self.function12(func3)(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12)
      self.function2(func2)(temp2, t13)
    }
  }
  object Function13Generic {
    trait Func13Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X]
      ): TOut[X]
    }
  }

  trait Function14Generic[F[_[_]]] {
    self: Function2Generic[F] with Function13Generic[F] =>

    def function14[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], TOut[_]](
      func: Function14Generic.Func14Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, TOut]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T14, TOut] = new Function2Generic.Func2Func[ZipType, T14, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            InnerHZero,
          i2: T14[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function13Generic.Func13Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, ZipType] =
        new Function13Generic.Func13Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, ZipType] {
          override def apply[X](
            t1: T1[X],
            t2: T2[X],
            t3: T3[X],
            t4: T4[X],
            t5: T5[X],
            t6: T6[X],
            t7: T7[X],
            t8: T8[X],
            t9: T9[X],
            t10: T10[X],
            t11: T11[X],
            t12: T12[X],
            t13: T13[X]
          ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            InnerHZero = t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: InnerHZero
        }
      val temp2: F[ZipType] = self.function13(func3)(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13)
      self.function2(func2)(temp2, t14)
    }
  }
  object Function14Generic {
    trait Func14Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X]
      ): TOut[X]
    }
  }

  trait Function15Generic[F[_[_]]] {
    self: Function2Generic[F] with Function14Generic[F] =>

    def function15[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], TOut[_]](
      func: Function15Generic.Func15Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, TOut]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T15, TOut] = new Function2Generic.Func2Func[ZipType, T15, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: InnerHZero,
          i2: T15[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function14Generic.Func14Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, ZipType] =
        new Function14Generic.Func14Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, ZipType] {
          override def apply[X](
            t1: T1[X],
            t2: T2[X],
            t3: T3[X],
            t4: T4[X],
            t5: T5[X],
            t6: T6[X],
            t7: T7[X],
            t8: T8[X],
            t9: T9[X],
            t10: T10[X],
            t11: T11[X],
            t12: T12[X],
            t13: T13[X],
            t14: T14[X]
          ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: InnerHZero = t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: InnerHZero
        }
      val temp2: F[ZipType] = self.function14(func3)(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14)
      self.function2(func2)(temp2, t15)
    }
  }
  object Function15Generic {
    trait Func15Func[
      T1[_],
      T2[_],
      T3[_],
      T4[_],
      T5[_],
      T6[_],
      T7[_],
      T8[_],
      T9[_],
      T10[_],
      T11[_],
      T12[_],
      T13[_],
      T14[_],
      T15[_],
      TOut[_]
    ] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X]
      ): TOut[X]
    }
  }

  trait Function16Generic[F[_[_]]] {
    self: Function2Generic[F] with Function15Generic[F] =>

    def function16[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], TOut[_]](func: Function16Generic.Func16Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, TOut])(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T16, TOut] = new Function2Generic.Func2Func[ZipType, T16, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: InnerHZero,
          i2: T16[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function15Generic.Func15Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, ZipType] =
        new Function15Generic.Func15Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, ZipType] {
          override def apply[X](
            t1: T1[X],
            t2: T2[X],
            t3: T3[X],
            t4: T4[X],
            t5: T5[X],
            t6: T6[X],
            t7: T7[X],
            t8: T8[X],
            t9: T9[X],
            t10: T10[X],
            t11: T11[X],
            t12: T12[X],
            t13: T13[X],
            t14: T14[X],
            t15: T15[X]
          ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: InnerHZero =
            t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: InnerHZero
        }
      val temp2: F[ZipType] = self.function15(func3)(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15)
      self.function2(func2)(temp2, t16)
    }
  }
  object Function16Generic {
    trait Func16Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X]
      ): TOut[X]
    }
  }

  trait Function17Generic[F[_[_]]] {
    self: Function2Generic[F] with Function16Generic[F] =>

    def function17[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], TOut[_]](
      func: Function17Generic.Func17Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, TOut]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T17, TOut] = new Function2Generic.Func2Func[ZipType, T17, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: InnerHZero,
          i2: T17[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function16Generic.Func16Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, ZipType] =
        new Function16Generic.Func16Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, ZipType] {
          override def apply[X](
            t1: T1[X],
            t2: T2[X],
            t3: T3[X],
            t4: T4[X],
            t5: T5[X],
            t6: T6[X],
            t7: T7[X],
            t8: T8[X],
            t9: T9[X],
            t10: T10[X],
            t11: T11[X],
            t12: T12[X],
            t13: T13[X],
            t14: T14[X],
            t15: T15[X],
            t16: T16[X]
          ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: InnerHZero =
            t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: InnerHZero
        }
      val temp2: F[ZipType] = self.function16(func3)(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16)
      self.function2(func2)(temp2, t17)
    }
  }
  object Function17Generic {
    trait Func17Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X]
      ): TOut[X]
    }
  }

  trait Function18Generic[F[_[_]]] {
    self: Function2Generic[F] with Function17Generic[F] =>

    def function18[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], TOut[_]](
      func: Function18Generic.Func18Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, TOut]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T18, TOut] = new Function2Generic.Func2Func[ZipType, T18, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: InnerHZero,
          i2: T18[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function17Generic.Func17Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, ZipType] =
        new Function17Generic.Func17Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, ZipType] {
          override def apply[X](
            t1: T1[X],
            t2: T2[X],
            t3: T3[X],
            t4: T4[X],
            t5: T5[X],
            t6: T6[X],
            t7: T7[X],
            t8: T8[X],
            t9: T9[X],
            t10: T10[X],
            t11: T11[X],
            t12: T12[X],
            t13: T13[X],
            t14: T14[X],
            t15: T15[X],
            t16: T16[X],
            t17: T17[X]
          ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: InnerHZero =
            t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: InnerHZero
        }
      val temp2: F[ZipType] = self.function17(func3)(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17)
      self.function2(func2)(temp2, t18)
    }
  }
  object Function18Generic {
    trait Func18Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X]
      ): TOut[X]
    }
  }

  trait Function19Generic[F[_[_]]] {
    self: Function2Generic[F] with Function18Generic[F] =>

    def function19[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], TOut[_]](
      func: Function19Generic.Func19Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, TOut]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T19, TOut] = new Function2Generic.Func2Func[ZipType, T19, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: InnerHZero,
          i2: T19[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function18Generic.Func18Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, ZipType] =
        new Function18Generic.Func18Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, ZipType] {
          override def apply[X](
            t1: T1[X],
            t2: T2[X],
            t3: T3[X],
            t4: T4[X],
            t5: T5[X],
            t6: T6[X],
            t7: T7[X],
            t8: T8[X],
            t9: T9[X],
            t10: T10[X],
            t11: T11[X],
            t12: T12[X],
            t13: T13[X],
            t14: T14[X],
            t15: T15[X],
            t16: T16[X],
            t17: T17[X],
            t18: T18[X]
          ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: InnerHZero =
            t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: InnerHZero
        }
      val temp2: F[ZipType] = self.function18(func3)(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18)
      self.function2(func2)(temp2, t19)
    }
  }
  object Function19Generic {
    trait Func19Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X]
      ): TOut[X]
    }
  }

  trait Function20Generic[F[_[_]]] {
    self: Function2Generic[F] with Function19Generic[F] =>

    def function20[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], TOut[_]](
      func: Function20Generic.Func20Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, TOut]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19],
      t20: F[T20]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: T19[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T20, TOut] = new Function2Generic.Func2Func[ZipType, T20, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: InnerHZero,
          i2: T20[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3
        : Function19Generic.Func19Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, ZipType] =
        new Function19Generic.Func19Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, ZipType] {
          override def apply[X](
            t1: T1[X],
            t2: T2[X],
            t3: T3[X],
            t4: T4[X],
            t5: T5[X],
            t6: T6[X],
            t7: T7[X],
            t8: T8[X],
            t9: T9[X],
            t10: T10[X],
            t11: T11[X],
            t12: T12[X],
            t13: T13[X],
            t14: T14[X],
            t15: T15[X],
            t16: T16[X],
            t17: T17[X],
            t18: T18[X],
            t19: T19[X]
          ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: InnerHZero =
            t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: t19 :: InnerHZero
        }
      val temp2: F[ZipType] = self.function19(func3)(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19)
      self.function2(func2)(temp2, t20)
    }
  }
  object Function20Generic {
    trait Func20Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X],
        t20: T20[X]
      ): TOut[X]
    }
  }

  trait Function21Generic[F[_[_]]] {
    self: Function2Generic[F] with Function20Generic[F] =>

    def function21[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], TOut[_]](
      func: Function21Generic.Func21Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        TOut
      ]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19],
      t20: F[T20],
      t21: F[T21]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: T19[U] :: T20[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T21, TOut] = new Function2Generic.Func2Func[ZipType, T21, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: InnerHZero,
          i2: T21[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3
        : Function20Generic.Func20Func[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, ZipType] =
        new Function20Generic.Func20Func[
          T1,
          T2,
          T3,
          T4,
          T5,
          T6,
          T7,
          T8,
          T9,
          T10,
          T11,
          T12,
          T13,
          T14,
          T15,
          T16,
          T17,
          T18,
          T19,
          T20,
          ZipType
        ] {
          override def apply[X](
            t1: T1[X],
            t2: T2[X],
            t3: T3[X],
            t4: T4[X],
            t5: T5[X],
            t6: T6[X],
            t7: T7[X],
            t8: T8[X],
            t9: T9[X],
            t10: T10[X],
            t11: T11[X],
            t12: T12[X],
            t13: T13[X],
            t14: T14[X],
            t15: T15[X],
            t16: T16[X],
            t17: T17[X],
            t18: T18[X],
            t19: T19[X],
            t20: T20[X]
          ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: InnerHZero =
            t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: t19 :: t20 :: InnerHZero
        }
      val temp2: F[ZipType] =
        self.function20(func3)(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20)
      self.function2(func2)(temp2, t21)
    }
  }
  object Function21Generic {
    trait Func21Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X],
        t20: T20[X],
        t21: T21[X]
      ): TOut[X]
    }
  }

  trait Function22Generic[F[_[_]]] {
    self: Function2Generic[F] with Function21Generic[F] =>

    def function22[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], TOut[_]](
      func: Function22Generic.Func22Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        TOut
      ]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19],
      t20: F[T20],
      t21: F[T21],
      t22: F[T22]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: T19[U] :: T20[U] :: T21[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T22, TOut] = new Function2Generic.Func2Func[ZipType, T22, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: InnerHZero,
          i2: T22[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function21Generic.Func21Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        ZipType
      ] = new Function21Generic.Func21Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        ZipType
      ] {
        override def apply[X](
          t1: T1[X],
          t2: T2[X],
          t3: T3[X],
          t4: T4[X],
          t5: T5[X],
          t6: T6[X],
          t7: T7[X],
          t8: T8[X],
          t9: T9[X],
          t10: T10[X],
          t11: T11[X],
          t12: T12[X],
          t13: T13[X],
          t14: T14[X],
          t15: T15[X],
          t16: T16[X],
          t17: T17[X],
          t18: T18[X],
          t19: T19[X],
          t20: T20[X],
          t21: T21[X]
        ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
          T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: InnerHZero =
          t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: t19 :: t20 :: t21 :: InnerHZero
      }
      val temp2: F[ZipType] =
        self.function21(func3)(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21)
      self.function2(func2)(temp2, t22)
    }
  }
  object Function22Generic {
    trait Func22Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X],
        t20: T20[X],
        t21: T21[X],
        t22: T22[X]
      ): TOut[X]
    }
  }

  trait Function23Generic[F[_[_]]] {
    self: Function2Generic[F] with Function22Generic[F] =>

    def function23[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], TOut[_]](
      func: Function23Generic.Func23Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        TOut
      ]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19],
      t20: F[T20],
      t21: F[T21],
      t22: F[T22],
      t23: F[T23]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: T19[U] :: T20[U] :: T21[U] :: T22[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T23, TOut] = new Function2Generic.Func2Func[ZipType, T23, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: InnerHZero,
          i2: T23[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function22Generic.Func22Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        ZipType
      ] = new Function22Generic.Func22Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        ZipType
      ] {
        override def apply[X](
          t1: T1[X],
          t2: T2[X],
          t3: T3[X],
          t4: T4[X],
          t5: T5[X],
          t6: T6[X],
          t7: T7[X],
          t8: T8[X],
          t9: T9[X],
          t10: T10[X],
          t11: T11[X],
          t12: T12[X],
          t13: T13[X],
          t14: T14[X],
          t15: T15[X],
          t16: T16[X],
          t17: T17[X],
          t18: T18[X],
          t19: T19[X],
          t20: T20[X],
          t21: T21[X],
          t22: T22[X]
        ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
          T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: InnerHZero =
          t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: t19 :: t20 :: t21 :: t22 :: InnerHZero
      }
      val temp2: F[ZipType] =
        self.function22(func3)(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22)
      self.function2(func2)(temp2, t23)
    }
  }
  object Function23Generic {
    trait Func23Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X],
        t20: T20[X],
        t21: T21[X],
        t22: T22[X],
        t23: T23[X]
      ): TOut[X]
    }
  }

  trait Function24Generic[F[_[_]]] {
    self: Function2Generic[F] with Function23Generic[F] =>

    def function24[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], TOut[_]](
      func: Function24Generic.Func24Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        TOut
      ]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19],
      t20: F[T20],
      t21: F[T21],
      t22: F[T22],
      t23: F[T23],
      t24: F[T24]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: T19[U] :: T20[U] :: T21[U] :: T22[U] :: T23[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T24, TOut] = new Function2Generic.Func2Func[ZipType, T24, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: InnerHZero,
          i2: T24[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function23Generic.Func23Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        ZipType
      ] = new Function23Generic.Func23Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        ZipType
      ] {
        override def apply[X](
          t1: T1[X],
          t2: T2[X],
          t3: T3[X],
          t4: T4[X],
          t5: T5[X],
          t6: T6[X],
          t7: T7[X],
          t8: T8[X],
          t9: T9[X],
          t10: T10[X],
          t11: T11[X],
          t12: T12[X],
          t13: T13[X],
          t14: T14[X],
          t15: T15[X],
          t16: T16[X],
          t17: T17[X],
          t18: T18[X],
          t19: T19[X],
          t20: T20[X],
          t21: T21[X],
          t22: T22[X],
          t23: T23[X]
        ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
          T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: InnerHZero =
          t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: t19 :: t20 :: t21 :: t22 :: t23 :: InnerHZero
      }
      val temp2: F[ZipType] =
        self.function23(func3)(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22, t23)
      self.function2(func2)(temp2, t24)
    }
  }
  object Function24Generic {
    trait Func24Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X],
        t20: T20[X],
        t21: T21[X],
        t22: T22[X],
        t23: T23[X],
        t24: T24[X]
      ): TOut[X]
    }
  }

  trait Function25Generic[F[_[_]]] {
    self: Function2Generic[F] with Function24Generic[F] =>

    def function25[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], TOut[_]](
      func: Function25Generic.Func25Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        TOut
      ]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19],
      t20: F[T20],
      t21: F[T21],
      t22: F[T22],
      t23: F[T23],
      t24: F[T24],
      t25: F[T25]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: T19[U] :: T20[U] :: T21[U] :: T22[U] :: T23[U] :: T24[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T25, TOut] = new Function2Generic.Func2Func[ZipType, T25, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: InnerHZero,
          i2: T25[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function24Generic.Func24Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        ZipType
      ] = new Function24Generic.Func24Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        ZipType
      ] {
        override def apply[X](
          t1: T1[X],
          t2: T2[X],
          t3: T3[X],
          t4: T4[X],
          t5: T5[X],
          t6: T6[X],
          t7: T7[X],
          t8: T8[X],
          t9: T9[X],
          t10: T10[X],
          t11: T11[X],
          t12: T12[X],
          t13: T13[X],
          t14: T14[X],
          t15: T15[X],
          t16: T16[X],
          t17: T17[X],
          t18: T18[X],
          t19: T19[X],
          t20: T20[X],
          t21: T21[X],
          t22: T22[X],
          t23: T23[X],
          t24: T24[X]
        ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
          T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: InnerHZero =
          t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: t19 :: t20 :: t21 :: t22 :: t23 :: t24 :: InnerHZero
      }
      val temp2: F[ZipType] = self
        .function24(func3)(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22, t23, t24)
      self.function2(func2)(temp2, t25)
    }
  }
  object Function25Generic {
    trait Func25Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X],
        t20: T20[X],
        t21: T21[X],
        t22: T22[X],
        t23: T23[X],
        t24: T24[X],
        t25: T25[X]
      ): TOut[X]
    }
  }

  trait Function26Generic[F[_[_]]] {
    self: Function2Generic[F] with Function25Generic[F] =>

    def function26[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], TOut[_]](
      func: Function26Generic.Func26Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        TOut
      ]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19],
      t20: F[T20],
      t21: F[T21],
      t22: F[T22],
      t23: F[T23],
      t24: F[T24],
      t25: F[T25],
      t26: F[T26]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: T19[U] :: T20[U] :: T21[U] :: T22[U] :: T23[U] :: T24[U] :: T25[U] ::
        InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T26, TOut] = new Function2Generic.Func2Func[ZipType, T26, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] ::
            InnerHZero,
          i2: T26[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function25Generic.Func25Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        ZipType
      ] = new Function25Generic.Func25Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        ZipType
      ] {
        override def apply[X](
          t1: T1[X],
          t2: T2[X],
          t3: T3[X],
          t4: T4[X],
          t5: T5[X],
          t6: T6[X],
          t7: T7[X],
          t8: T8[X],
          t9: T9[X],
          t10: T10[X],
          t11: T11[X],
          t12: T12[X],
          t13: T13[X],
          t14: T14[X],
          t15: T15[X],
          t16: T16[X],
          t17: T17[X],
          t18: T18[X],
          t19: T19[X],
          t20: T20[X],
          t21: T21[X],
          t22: T22[X],
          t23: T23[X],
          t24: T24[X],
          t25: T25[X]
        ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
          T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] ::
          InnerHZero =
          t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: t19 :: t20 :: t21 :: t22 :: t23 :: t24 :: t25 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function25(func3)(
        t1,
        t2,
        t3,
        t4,
        t5,
        t6,
        t7,
        t8,
        t9,
        t10,
        t11,
        t12,
        t13,
        t14,
        t15,
        t16,
        t17,
        t18,
        t19,
        t20,
        t21,
        t22,
        t23,
        t24,
        t25
      )
      self.function2(func2)(temp2, t26)
    }
  }
  object Function26Generic {
    trait Func26Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X],
        t20: T20[X],
        t21: T21[X],
        t22: T22[X],
        t23: T23[X],
        t24: T24[X],
        t25: T25[X],
        t26: T26[X]
      ): TOut[X]
    }
  }

  trait Function27Generic[F[_[_]]] {
    self: Function2Generic[F] with Function26Generic[F] =>

    def function27[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], TOut[_]](
      func: Function27Generic.Func27Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        TOut
      ]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19],
      t20: F[T20],
      t21: F[T21],
      t22: F[T22],
      t23: F[T23],
      t24: F[T24],
      t25: F[T25],
      t26: F[T26],
      t27: F[T27]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: T19[U] :: T20[U] :: T21[U] :: T22[U] :: T23[U] :: T24[U] :: T25[U] ::
        T26[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T27, TOut] = new Function2Generic.Func2Func[ZipType, T27, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] ::
            T26[X] :: InnerHZero,
          i2: T27[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function26Generic.Func26Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        ZipType
      ] = new Function26Generic.Func26Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        ZipType
      ] {
        override def apply[X](
          t1: T1[X],
          t2: T2[X],
          t3: T3[X],
          t4: T4[X],
          t5: T5[X],
          t6: T6[X],
          t7: T7[X],
          t8: T8[X],
          t9: T9[X],
          t10: T10[X],
          t11: T11[X],
          t12: T12[X],
          t13: T13[X],
          t14: T14[X],
          t15: T15[X],
          t16: T16[X],
          t17: T17[X],
          t18: T18[X],
          t19: T19[X],
          t20: T20[X],
          t21: T21[X],
          t22: T22[X],
          t23: T23[X],
          t24: T24[X],
          t25: T25[X],
          t26: T26[X]
        ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
          T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] :: T26[X] ::
          InnerHZero =
          t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: t19 :: t20 :: t21 :: t22 :: t23 :: t24 :: t25 :: t26 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function26(func3)(
        t1,
        t2,
        t3,
        t4,
        t5,
        t6,
        t7,
        t8,
        t9,
        t10,
        t11,
        t12,
        t13,
        t14,
        t15,
        t16,
        t17,
        t18,
        t19,
        t20,
        t21,
        t22,
        t23,
        t24,
        t25,
        t26
      )
      self.function2(func2)(temp2, t27)
    }
  }
  object Function27Generic {
    trait Func27Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X],
        t20: T20[X],
        t21: T21[X],
        t22: T22[X],
        t23: T23[X],
        t24: T24[X],
        t25: T25[X],
        t26: T26[X],
        t27: T27[X]
      ): TOut[X]
    }
  }

  trait Function28Generic[F[_[_]]] {
    self: Function2Generic[F] with Function27Generic[F] =>

    def function28[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], TOut[_]](
      func: Function28Generic.Func28Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        TOut
      ]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19],
      t20: F[T20],
      t21: F[T21],
      t22: F[T22],
      t23: F[T23],
      t24: F[T24],
      t25: F[T25],
      t26: F[T26],
      t27: F[T27],
      t28: F[T28]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: T19[U] :: T20[U] :: T21[U] :: T22[U] :: T23[U] :: T24[U] :: T25[U] ::
        T26[U] :: T27[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T28, TOut] = new Function2Generic.Func2Func[ZipType, T28, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] ::
            T26[X] :: T27[X] :: InnerHZero,
          i2: T28[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function27Generic.Func27Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        ZipType
      ] = new Function27Generic.Func27Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        ZipType
      ] {
        override def apply[X](
          t1: T1[X],
          t2: T2[X],
          t3: T3[X],
          t4: T4[X],
          t5: T5[X],
          t6: T6[X],
          t7: T7[X],
          t8: T8[X],
          t9: T9[X],
          t10: T10[X],
          t11: T11[X],
          t12: T12[X],
          t13: T13[X],
          t14: T14[X],
          t15: T15[X],
          t16: T16[X],
          t17: T17[X],
          t18: T18[X],
          t19: T19[X],
          t20: T20[X],
          t21: T21[X],
          t22: T22[X],
          t23: T23[X],
          t24: T24[X],
          t25: T25[X],
          t26: T26[X],
          t27: T27[X]
        ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
          T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] :: T26[X] ::
          T27[X] :: InnerHZero =
          t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: t19 :: t20 :: t21 :: t22 :: t23 :: t24 :: t25 :: t26 :: t27 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function27(func3)(
        t1,
        t2,
        t3,
        t4,
        t5,
        t6,
        t7,
        t8,
        t9,
        t10,
        t11,
        t12,
        t13,
        t14,
        t15,
        t16,
        t17,
        t18,
        t19,
        t20,
        t21,
        t22,
        t23,
        t24,
        t25,
        t26,
        t27
      )
      self.function2(func2)(temp2, t28)
    }
  }
  object Function28Generic {
    trait Func28Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X],
        t20: T20[X],
        t21: T21[X],
        t22: T22[X],
        t23: T23[X],
        t24: T24[X],
        t25: T25[X],
        t26: T26[X],
        t27: T27[X],
        t28: T28[X]
      ): TOut[X]
    }
  }

  trait Function29Generic[F[_[_]]] {
    self: Function2Generic[F] with Function28Generic[F] =>

    def function29[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], TOut[_]](
      func: Function29Generic.Func29Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        TOut
      ]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19],
      t20: F[T20],
      t21: F[T21],
      t22: F[T22],
      t23: F[T23],
      t24: F[T24],
      t25: F[T25],
      t26: F[T26],
      t27: F[T27],
      t28: F[T28],
      t29: F[T29]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: T19[U] :: T20[U] :: T21[U] :: T22[U] :: T23[U] :: T24[U] :: T25[U] ::
        T26[U] :: T27[U] :: T28[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T29, TOut] = new Function2Generic.Func2Func[ZipType, T29, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] ::
            T26[X] :: T27[X] :: T28[X] :: InnerHZero,
          i2: T29[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function28Generic.Func28Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        ZipType
      ] = new Function28Generic.Func28Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        ZipType
      ] {
        override def apply[X](
          t1: T1[X],
          t2: T2[X],
          t3: T3[X],
          t4: T4[X],
          t5: T5[X],
          t6: T6[X],
          t7: T7[X],
          t8: T8[X],
          t9: T9[X],
          t10: T10[X],
          t11: T11[X],
          t12: T12[X],
          t13: T13[X],
          t14: T14[X],
          t15: T15[X],
          t16: T16[X],
          t17: T17[X],
          t18: T18[X],
          t19: T19[X],
          t20: T20[X],
          t21: T21[X],
          t22: T22[X],
          t23: T23[X],
          t24: T24[X],
          t25: T25[X],
          t26: T26[X],
          t27: T27[X],
          t28: T28[X]
        ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
          T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] :: T26[X] ::
          T27[X] :: T28[X] :: InnerHZero =
          t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: t19 :: t20 :: t21 :: t22 :: t23 :: t24 :: t25 :: t26 :: t27 :: t28 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function28(func3)(
        t1,
        t2,
        t3,
        t4,
        t5,
        t6,
        t7,
        t8,
        t9,
        t10,
        t11,
        t12,
        t13,
        t14,
        t15,
        t16,
        t17,
        t18,
        t19,
        t20,
        t21,
        t22,
        t23,
        t24,
        t25,
        t26,
        t27,
        t28
      )
      self.function2(func2)(temp2, t29)
    }
  }
  object Function29Generic {
    trait Func29Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X],
        t20: T20[X],
        t21: T21[X],
        t22: T22[X],
        t23: T23[X],
        t24: T24[X],
        t25: T25[X],
        t26: T26[X],
        t27: T27[X],
        t28: T28[X],
        t29: T29[X]
      ): TOut[X]
    }
  }

  trait Function30Generic[F[_[_]]] {
    self: Function2Generic[F] with Function29Generic[F] =>

    def function30[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], TOut[_]](
      func: Function30Generic.Func30Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        TOut
      ]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19],
      t20: F[T20],
      t21: F[T21],
      t22: F[T22],
      t23: F[T23],
      t24: F[T24],
      t25: F[T25],
      t26: F[T26],
      t27: F[T27],
      t28: F[T28],
      t29: F[T29],
      t30: F[T30]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: T19[U] :: T20[U] :: T21[U] :: T22[U] :: T23[U] :: T24[U] :: T25[U] ::
        T26[U] :: T27[U] :: T28[U] :: T29[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T30, TOut] = new Function2Generic.Func2Func[ZipType, T30, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] ::
            T26[X] :: T27[X] :: T28[X] :: T29[X] :: InnerHZero,
          i2: T30[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function29Generic.Func29Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        ZipType
      ] = new Function29Generic.Func29Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        ZipType
      ] {
        override def apply[X](
          t1: T1[X],
          t2: T2[X],
          t3: T3[X],
          t4: T4[X],
          t5: T5[X],
          t6: T6[X],
          t7: T7[X],
          t8: T8[X],
          t9: T9[X],
          t10: T10[X],
          t11: T11[X],
          t12: T12[X],
          t13: T13[X],
          t14: T14[X],
          t15: T15[X],
          t16: T16[X],
          t17: T17[X],
          t18: T18[X],
          t19: T19[X],
          t20: T20[X],
          t21: T21[X],
          t22: T22[X],
          t23: T23[X],
          t24: T24[X],
          t25: T25[X],
          t26: T26[X],
          t27: T27[X],
          t28: T28[X],
          t29: T29[X]
        ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
          T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] :: T26[X] ::
          T27[X] :: T28[X] :: T29[X] :: InnerHZero =
          t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: t19 :: t20 :: t21 :: t22 :: t23 :: t24 :: t25 :: t26 :: t27 :: t28 :: t29 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function29(func3)(
        t1,
        t2,
        t3,
        t4,
        t5,
        t6,
        t7,
        t8,
        t9,
        t10,
        t11,
        t12,
        t13,
        t14,
        t15,
        t16,
        t17,
        t18,
        t19,
        t20,
        t21,
        t22,
        t23,
        t24,
        t25,
        t26,
        t27,
        t28,
        t29
      )
      self.function2(func2)(temp2, t30)
    }
  }
  object Function30Generic {
    trait Func30Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X],
        t20: T20[X],
        t21: T21[X],
        t22: T22[X],
        t23: T23[X],
        t24: T24[X],
        t25: T25[X],
        t26: T26[X],
        t27: T27[X],
        t28: T28[X],
        t29: T29[X],
        t30: T30[X]
      ): TOut[X]
    }
  }

  trait Function31Generic[F[_[_]]] {
    self: Function2Generic[F] with Function30Generic[F] =>

    def function31[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], TOut[_]](
      func: Function31Generic.Func31Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        TOut
      ]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19],
      t20: F[T20],
      t21: F[T21],
      t22: F[T22],
      t23: F[T23],
      t24: F[T24],
      t25: F[T25],
      t26: F[T26],
      t27: F[T27],
      t28: F[T28],
      t29: F[T29],
      t30: F[T30],
      t31: F[T31]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: T19[U] :: T20[U] :: T21[U] :: T22[U] :: T23[U] :: T24[U] :: T25[U] ::
        T26[U] :: T27[U] :: T28[U] :: T29[U] :: T30[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T31, TOut] = new Function2Generic.Func2Func[ZipType, T31, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] ::
            T26[X] :: T27[X] :: T28[X] :: T29[X] :: T30[X] :: InnerHZero,
          i2: T31[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function30Generic.Func30Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        ZipType
      ] = new Function30Generic.Func30Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        ZipType
      ] {
        override def apply[X](
          t1: T1[X],
          t2: T2[X],
          t3: T3[X],
          t4: T4[X],
          t5: T5[X],
          t6: T6[X],
          t7: T7[X],
          t8: T8[X],
          t9: T9[X],
          t10: T10[X],
          t11: T11[X],
          t12: T12[X],
          t13: T13[X],
          t14: T14[X],
          t15: T15[X],
          t16: T16[X],
          t17: T17[X],
          t18: T18[X],
          t19: T19[X],
          t20: T20[X],
          t21: T21[X],
          t22: T22[X],
          t23: T23[X],
          t24: T24[X],
          t25: T25[X],
          t26: T26[X],
          t27: T27[X],
          t28: T28[X],
          t29: T29[X],
          t30: T30[X]
        ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
          T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] :: T26[X] ::
          T27[X] :: T28[X] :: T29[X] :: T30[X] :: InnerHZero =
          t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: t19 :: t20 :: t21 :: t22 :: t23 :: t24 :: t25 :: t26 :: t27 :: t28 :: t29 :: t30 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function30(func3)(
        t1,
        t2,
        t3,
        t4,
        t5,
        t6,
        t7,
        t8,
        t9,
        t10,
        t11,
        t12,
        t13,
        t14,
        t15,
        t16,
        t17,
        t18,
        t19,
        t20,
        t21,
        t22,
        t23,
        t24,
        t25,
        t26,
        t27,
        t28,
        t29,
        t30
      )
      self.function2(func2)(temp2, t31)
    }
  }
  object Function31Generic {
    trait Func31Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X],
        t20: T20[X],
        t21: T21[X],
        t22: T22[X],
        t23: T23[X],
        t24: T24[X],
        t25: T25[X],
        t26: T26[X],
        t27: T27[X],
        t28: T28[X],
        t29: T29[X],
        t30: T30[X],
        t31: T31[X]
      ): TOut[X]
    }
  }

  trait Function32Generic[F[_[_]]] {
    self: Function2Generic[F] with Function31Generic[F] =>

    def function32[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], TOut[
      _
    ]](
      func: Function32Generic.Func32Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        TOut
      ]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19],
      t20: F[T20],
      t21: F[T21],
      t22: F[T22],
      t23: F[T23],
      t24: F[T24],
      t25: F[T25],
      t26: F[T26],
      t27: F[T27],
      t28: F[T28],
      t29: F[T29],
      t30: F[T30],
      t31: F[T31],
      t32: F[T32]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: T19[U] :: T20[U] :: T21[U] :: T22[U] :: T23[U] :: T24[U] :: T25[U] ::
        T26[U] :: T27[U] :: T28[U] :: T29[U] :: T30[U] :: T31[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T32, TOut] = new Function2Generic.Func2Func[ZipType, T32, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] ::
            T26[X] :: T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: InnerHZero,
          i2: T32[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function31Generic.Func31Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        ZipType
      ] = new Function31Generic.Func31Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        ZipType
      ] {
        override def apply[X](
          t1: T1[X],
          t2: T2[X],
          t3: T3[X],
          t4: T4[X],
          t5: T5[X],
          t6: T6[X],
          t7: T7[X],
          t8: T8[X],
          t9: T9[X],
          t10: T10[X],
          t11: T11[X],
          t12: T12[X],
          t13: T13[X],
          t14: T14[X],
          t15: T15[X],
          t16: T16[X],
          t17: T17[X],
          t18: T18[X],
          t19: T19[X],
          t20: T20[X],
          t21: T21[X],
          t22: T22[X],
          t23: T23[X],
          t24: T24[X],
          t25: T25[X],
          t26: T26[X],
          t27: T27[X],
          t28: T28[X],
          t29: T29[X],
          t30: T30[X],
          t31: T31[X]
        ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
          T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] :: T26[X] ::
          T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: InnerHZero =
          t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: t19 :: t20 :: t21 :: t22 :: t23 :: t24 :: t25 :: t26 :: t27 :: t28 :: t29 :: t30 :: t31 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function31(func3)(
        t1,
        t2,
        t3,
        t4,
        t5,
        t6,
        t7,
        t8,
        t9,
        t10,
        t11,
        t12,
        t13,
        t14,
        t15,
        t16,
        t17,
        t18,
        t19,
        t20,
        t21,
        t22,
        t23,
        t24,
        t25,
        t26,
        t27,
        t28,
        t29,
        t30,
        t31
      )
      self.function2(func2)(temp2, t32)
    }
  }
  object Function32Generic {
    trait Func32Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], TOut[
      _
    ]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X],
        t20: T20[X],
        t21: T21[X],
        t22: T22[X],
        t23: T23[X],
        t24: T24[X],
        t25: T25[X],
        t26: T26[X],
        t27: T27[X],
        t28: T28[X],
        t29: T29[X],
        t30: T30[X],
        t31: T31[X],
        t32: T32[X]
      ): TOut[X]
    }
  }

  trait Function33Generic[F[_[_]]] {
    self: Function2Generic[F] with Function32Generic[F] =>

    def function33[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], TOut[_]](
      func: Function33Generic.Func33Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        TOut
      ]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19],
      t20: F[T20],
      t21: F[T21],
      t22: F[T22],
      t23: F[T23],
      t24: F[T24],
      t25: F[T25],
      t26: F[T26],
      t27: F[T27],
      t28: F[T28],
      t29: F[T29],
      t30: F[T30],
      t31: F[T31],
      t32: F[T32],
      t33: F[T33]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: T19[U] :: T20[U] :: T21[U] :: T22[U] :: T23[U] :: T24[U] :: T25[U] ::
        T26[U] :: T27[U] :: T28[U] :: T29[U] :: T30[U] :: T31[U] :: T32[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T33, TOut] = new Function2Generic.Func2Func[ZipType, T33, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] ::
            T26[X] :: T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: InnerHZero,
          i2: T33[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function32Generic.Func32Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        ZipType
      ] = new Function32Generic.Func32Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        ZipType
      ] {
        override def apply[X](
          t1: T1[X],
          t2: T2[X],
          t3: T3[X],
          t4: T4[X],
          t5: T5[X],
          t6: T6[X],
          t7: T7[X],
          t8: T8[X],
          t9: T9[X],
          t10: T10[X],
          t11: T11[X],
          t12: T12[X],
          t13: T13[X],
          t14: T14[X],
          t15: T15[X],
          t16: T16[X],
          t17: T17[X],
          t18: T18[X],
          t19: T19[X],
          t20: T20[X],
          t21: T21[X],
          t22: T22[X],
          t23: T23[X],
          t24: T24[X],
          t25: T25[X],
          t26: T26[X],
          t27: T27[X],
          t28: T28[X],
          t29: T29[X],
          t30: T30[X],
          t31: T31[X],
          t32: T32[X]
        ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
          T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] :: T26[X] ::
          T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: InnerHZero =
          t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: t19 :: t20 :: t21 :: t22 :: t23 :: t24 :: t25 :: t26 :: t27 :: t28 :: t29 :: t30 :: t31 :: t32 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function32(func3)(
        t1,
        t2,
        t3,
        t4,
        t5,
        t6,
        t7,
        t8,
        t9,
        t10,
        t11,
        t12,
        t13,
        t14,
        t15,
        t16,
        t17,
        t18,
        t19,
        t20,
        t21,
        t22,
        t23,
        t24,
        t25,
        t26,
        t27,
        t28,
        t29,
        t30,
        t31,
        t32
      )
      self.function2(func2)(temp2, t33)
    }
  }
  object Function33Generic {
    trait Func33Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X],
        t20: T20[X],
        t21: T21[X],
        t22: T22[X],
        t23: T23[X],
        t24: T24[X],
        t25: T25[X],
        t26: T26[X],
        t27: T27[X],
        t28: T28[X],
        t29: T29[X],
        t30: T30[X],
        t31: T31[X],
        t32: T32[X],
        t33: T33[X]
      ): TOut[X]
    }
  }

  trait Function34Generic[F[_[_]]] {
    self: Function2Generic[F] with Function33Generic[F] =>

    def function34[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], TOut[_]](
      func: Function34Generic.Func34Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        TOut
      ]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19],
      t20: F[T20],
      t21: F[T21],
      t22: F[T22],
      t23: F[T23],
      t24: F[T24],
      t25: F[T25],
      t26: F[T26],
      t27: F[T27],
      t28: F[T28],
      t29: F[T29],
      t30: F[T30],
      t31: F[T31],
      t32: F[T32],
      t33: F[T33],
      t34: F[T34]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: T19[U] :: T20[U] :: T21[U] :: T22[U] :: T23[U] :: T24[U] :: T25[U] ::
        T26[U] :: T27[U] :: T28[U] :: T29[U] :: T30[U] :: T31[U] :: T32[U] :: T33[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T34, TOut] = new Function2Generic.Func2Func[ZipType, T34, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] ::
            T26[X] :: T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: InnerHZero,
          i2: T34[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function33Generic.Func33Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        ZipType
      ] = new Function33Generic.Func33Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        ZipType
      ] {
        override def apply[X](
          t1: T1[X],
          t2: T2[X],
          t3: T3[X],
          t4: T4[X],
          t5: T5[X],
          t6: T6[X],
          t7: T7[X],
          t8: T8[X],
          t9: T9[X],
          t10: T10[X],
          t11: T11[X],
          t12: T12[X],
          t13: T13[X],
          t14: T14[X],
          t15: T15[X],
          t16: T16[X],
          t17: T17[X],
          t18: T18[X],
          t19: T19[X],
          t20: T20[X],
          t21: T21[X],
          t22: T22[X],
          t23: T23[X],
          t24: T24[X],
          t25: T25[X],
          t26: T26[X],
          t27: T27[X],
          t28: T28[X],
          t29: T29[X],
          t30: T30[X],
          t31: T31[X],
          t32: T32[X],
          t33: T33[X]
        ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
          T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] :: T26[X] ::
          T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: InnerHZero =
          t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: t19 :: t20 :: t21 :: t22 :: t23 :: t24 :: t25 :: t26 :: t27 :: t28 :: t29 :: t30 :: t31 :: t32 :: t33 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function33(func3)(
        t1,
        t2,
        t3,
        t4,
        t5,
        t6,
        t7,
        t8,
        t9,
        t10,
        t11,
        t12,
        t13,
        t14,
        t15,
        t16,
        t17,
        t18,
        t19,
        t20,
        t21,
        t22,
        t23,
        t24,
        t25,
        t26,
        t27,
        t28,
        t29,
        t30,
        t31,
        t32,
        t33
      )
      self.function2(func2)(temp2, t34)
    }
  }
  object Function34Generic {
    trait Func34Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X],
        t20: T20[X],
        t21: T21[X],
        t22: T22[X],
        t23: T23[X],
        t24: T24[X],
        t25: T25[X],
        t26: T26[X],
        t27: T27[X],
        t28: T28[X],
        t29: T29[X],
        t30: T30[X],
        t31: T31[X],
        t32: T32[X],
        t33: T33[X],
        t34: T34[X]
      ): TOut[X]
    }
  }

  trait Function35Generic[F[_[_]]] {
    self: Function2Generic[F] with Function34Generic[F] =>

    def function35[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], TOut[_]](
      func: Function35Generic.Func35Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        TOut
      ]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19],
      t20: F[T20],
      t21: F[T21],
      t22: F[T22],
      t23: F[T23],
      t24: F[T24],
      t25: F[T25],
      t26: F[T26],
      t27: F[T27],
      t28: F[T28],
      t29: F[T29],
      t30: F[T30],
      t31: F[T31],
      t32: F[T32],
      t33: F[T33],
      t34: F[T34],
      t35: F[T35]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: T19[U] :: T20[U] :: T21[U] :: T22[U] :: T23[U] :: T24[U] :: T25[U] ::
        T26[U] :: T27[U] :: T28[U] :: T29[U] :: T30[U] :: T31[U] :: T32[U] :: T33[U] :: T34[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T35, TOut] = new Function2Generic.Func2Func[ZipType, T35, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] ::
            T26[X] :: T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: InnerHZero,
          i2: T35[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function34Generic.Func34Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        ZipType
      ] = new Function34Generic.Func34Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        ZipType
      ] {
        override def apply[X](
          t1: T1[X],
          t2: T2[X],
          t3: T3[X],
          t4: T4[X],
          t5: T5[X],
          t6: T6[X],
          t7: T7[X],
          t8: T8[X],
          t9: T9[X],
          t10: T10[X],
          t11: T11[X],
          t12: T12[X],
          t13: T13[X],
          t14: T14[X],
          t15: T15[X],
          t16: T16[X],
          t17: T17[X],
          t18: T18[X],
          t19: T19[X],
          t20: T20[X],
          t21: T21[X],
          t22: T22[X],
          t23: T23[X],
          t24: T24[X],
          t25: T25[X],
          t26: T26[X],
          t27: T27[X],
          t28: T28[X],
          t29: T29[X],
          t30: T30[X],
          t31: T31[X],
          t32: T32[X],
          t33: T33[X],
          t34: T34[X]
        ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
          T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] :: T26[X] ::
          T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: InnerHZero =
          t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: t19 :: t20 :: t21 :: t22 :: t23 :: t24 :: t25 :: t26 :: t27 :: t28 :: t29 :: t30 :: t31 :: t32 :: t33 :: t34 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function34(func3)(
        t1,
        t2,
        t3,
        t4,
        t5,
        t6,
        t7,
        t8,
        t9,
        t10,
        t11,
        t12,
        t13,
        t14,
        t15,
        t16,
        t17,
        t18,
        t19,
        t20,
        t21,
        t22,
        t23,
        t24,
        t25,
        t26,
        t27,
        t28,
        t29,
        t30,
        t31,
        t32,
        t33,
        t34
      )
      self.function2(func2)(temp2, t35)
    }
  }
  object Function35Generic {
    trait Func35Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X],
        t20: T20[X],
        t21: T21[X],
        t22: T22[X],
        t23: T23[X],
        t24: T24[X],
        t25: T25[X],
        t26: T26[X],
        t27: T27[X],
        t28: T28[X],
        t29: T29[X],
        t30: T30[X],
        t31: T31[X],
        t32: T32[X],
        t33: T33[X],
        t34: T34[X],
        t35: T35[X]
      ): TOut[X]
    }
  }

  trait Function36Generic[F[_[_]]] {
    self: Function2Generic[F] with Function35Generic[F] =>

    def function36[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], T36[_], TOut[_]](
      func: Function36Generic.Func36Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        TOut
      ]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19],
      t20: F[T20],
      t21: F[T21],
      t22: F[T22],
      t23: F[T23],
      t24: F[T24],
      t25: F[T25],
      t26: F[T26],
      t27: F[T27],
      t28: F[T28],
      t29: F[T29],
      t30: F[T30],
      t31: F[T31],
      t32: F[T32],
      t33: F[T33],
      t34: F[T34],
      t35: F[T35],
      t36: F[T36]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: T19[U] :: T20[U] :: T21[U] :: T22[U] :: T23[U] :: T24[U] :: T25[U] ::
        T26[U] :: T27[U] :: T28[U] :: T29[U] :: T30[U] :: T31[U] :: T32[U] :: T33[U] :: T34[U] :: T35[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T36, TOut] = new Function2Generic.Func2Func[ZipType, T36, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] ::
            T26[X] :: T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: T35[X] :: InnerHZero,
          i2: T36[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function35Generic.Func35Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        ZipType
      ] = new Function35Generic.Func35Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        ZipType
      ] {
        override def apply[X](
          t1: T1[X],
          t2: T2[X],
          t3: T3[X],
          t4: T4[X],
          t5: T5[X],
          t6: T6[X],
          t7: T7[X],
          t8: T8[X],
          t9: T9[X],
          t10: T10[X],
          t11: T11[X],
          t12: T12[X],
          t13: T13[X],
          t14: T14[X],
          t15: T15[X],
          t16: T16[X],
          t17: T17[X],
          t18: T18[X],
          t19: T19[X],
          t20: T20[X],
          t21: T21[X],
          t22: T22[X],
          t23: T23[X],
          t24: T24[X],
          t25: T25[X],
          t26: T26[X],
          t27: T27[X],
          t28: T28[X],
          t29: T29[X],
          t30: T30[X],
          t31: T31[X],
          t32: T32[X],
          t33: T33[X],
          t34: T34[X],
          t35: T35[X]
        ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
          T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] :: T26[X] ::
          T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: T35[X] :: InnerHZero =
          t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: t19 :: t20 :: t21 :: t22 :: t23 :: t24 :: t25 :: t26 :: t27 :: t28 :: t29 :: t30 :: t31 :: t32 :: t33 :: t34 :: t35 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function35(func3)(
        t1,
        t2,
        t3,
        t4,
        t5,
        t6,
        t7,
        t8,
        t9,
        t10,
        t11,
        t12,
        t13,
        t14,
        t15,
        t16,
        t17,
        t18,
        t19,
        t20,
        t21,
        t22,
        t23,
        t24,
        t25,
        t26,
        t27,
        t28,
        t29,
        t30,
        t31,
        t32,
        t33,
        t34,
        t35
      )
      self.function2(func2)(temp2, t36)
    }
  }
  object Function36Generic {
    trait Func36Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], T36[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X],
        t20: T20[X],
        t21: T21[X],
        t22: T22[X],
        t23: T23[X],
        t24: T24[X],
        t25: T25[X],
        t26: T26[X],
        t27: T27[X],
        t28: T28[X],
        t29: T29[X],
        t30: T30[X],
        t31: T31[X],
        t32: T32[X],
        t33: T33[X],
        t34: T34[X],
        t35: T35[X],
        t36: T36[X]
      ): TOut[X]
    }
  }

  trait Function37Generic[F[_[_]]] {
    self: Function2Generic[F] with Function36Generic[F] =>

    def function37[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], T36[_], T37[_], TOut[_]](
      func: Function37Generic.Func37Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        TOut
      ]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19],
      t20: F[T20],
      t21: F[T21],
      t22: F[T22],
      t23: F[T23],
      t24: F[T24],
      t25: F[T25],
      t26: F[T26],
      t27: F[T27],
      t28: F[T28],
      t29: F[T29],
      t30: F[T30],
      t31: F[T31],
      t32: F[T32],
      t33: F[T33],
      t34: F[T34],
      t35: F[T35],
      t36: F[T36],
      t37: F[T37]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: T19[U] :: T20[U] :: T21[U] :: T22[U] :: T23[U] :: T24[U] :: T25[U] ::
        T26[U] :: T27[U] :: T28[U] :: T29[U] :: T30[U] :: T31[U] :: T32[U] :: T33[U] :: T34[U] :: T35[U] :: T36[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T37, TOut] = new Function2Generic.Func2Func[ZipType, T37, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] ::
            T26[X] :: T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: T35[X] :: T36[X] :: InnerHZero,
          i2: T37[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function36Generic.Func36Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        ZipType
      ] = new Function36Generic.Func36Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        ZipType
      ] {
        override def apply[X](
          t1: T1[X],
          t2: T2[X],
          t3: T3[X],
          t4: T4[X],
          t5: T5[X],
          t6: T6[X],
          t7: T7[X],
          t8: T8[X],
          t9: T9[X],
          t10: T10[X],
          t11: T11[X],
          t12: T12[X],
          t13: T13[X],
          t14: T14[X],
          t15: T15[X],
          t16: T16[X],
          t17: T17[X],
          t18: T18[X],
          t19: T19[X],
          t20: T20[X],
          t21: T21[X],
          t22: T22[X],
          t23: T23[X],
          t24: T24[X],
          t25: T25[X],
          t26: T26[X],
          t27: T27[X],
          t28: T28[X],
          t29: T29[X],
          t30: T30[X],
          t31: T31[X],
          t32: T32[X],
          t33: T33[X],
          t34: T34[X],
          t35: T35[X],
          t36: T36[X]
        ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
          T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] :: T26[X] ::
          T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: T35[X] :: T36[X] :: InnerHZero =
          t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: t19 :: t20 :: t21 :: t22 :: t23 :: t24 :: t25 :: t26 :: t27 :: t28 :: t29 :: t30 :: t31 :: t32 :: t33 :: t34 :: t35 :: t36 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function36(func3)(
        t1,
        t2,
        t3,
        t4,
        t5,
        t6,
        t7,
        t8,
        t9,
        t10,
        t11,
        t12,
        t13,
        t14,
        t15,
        t16,
        t17,
        t18,
        t19,
        t20,
        t21,
        t22,
        t23,
        t24,
        t25,
        t26,
        t27,
        t28,
        t29,
        t30,
        t31,
        t32,
        t33,
        t34,
        t35,
        t36
      )
      self.function2(func2)(temp2, t37)
    }
  }
  object Function37Generic {
    trait Func37Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], T36[_], T37[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X],
        t20: T20[X],
        t21: T21[X],
        t22: T22[X],
        t23: T23[X],
        t24: T24[X],
        t25: T25[X],
        t26: T26[X],
        t27: T27[X],
        t28: T28[X],
        t29: T29[X],
        t30: T30[X],
        t31: T31[X],
        t32: T32[X],
        t33: T33[X],
        t34: T34[X],
        t35: T35[X],
        t36: T36[X],
        t37: T37[X]
      ): TOut[X]
    }
  }

  trait Function38Generic[F[_[_]]] {
    self: Function2Generic[F] with Function37Generic[F] =>

    def function38[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], T36[_], T37[_], T38[_], TOut[_]](
      func: Function38Generic.Func38Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        TOut
      ]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19],
      t20: F[T20],
      t21: F[T21],
      t22: F[T22],
      t23: F[T23],
      t24: F[T24],
      t25: F[T25],
      t26: F[T26],
      t27: F[T27],
      t28: F[T28],
      t29: F[T29],
      t30: F[T30],
      t31: F[T31],
      t32: F[T32],
      t33: F[T33],
      t34: F[T34],
      t35: F[T35],
      t36: F[T36],
      t37: F[T37],
      t38: F[T38]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: T19[U] :: T20[U] :: T21[U] :: T22[U] :: T23[U] :: T24[U] :: T25[U] ::
        T26[U] :: T27[U] :: T28[U] :: T29[U] :: T30[U] :: T31[U] :: T32[U] :: T33[U] :: T34[U] :: T35[U] :: T36[U] :: T37[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T38, TOut] = new Function2Generic.Func2Func[ZipType, T38, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] ::
            T26[X] :: T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: T35[X] :: T36[X] :: T37[X] ::
            InnerHZero,
          i2: T38[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function37Generic.Func37Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        ZipType
      ] = new Function37Generic.Func37Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        ZipType
      ] {
        override def apply[X](
          t1: T1[X],
          t2: T2[X],
          t3: T3[X],
          t4: T4[X],
          t5: T5[X],
          t6: T6[X],
          t7: T7[X],
          t8: T8[X],
          t9: T9[X],
          t10: T10[X],
          t11: T11[X],
          t12: T12[X],
          t13: T13[X],
          t14: T14[X],
          t15: T15[X],
          t16: T16[X],
          t17: T17[X],
          t18: T18[X],
          t19: T19[X],
          t20: T20[X],
          t21: T21[X],
          t22: T22[X],
          t23: T23[X],
          t24: T24[X],
          t25: T25[X],
          t26: T26[X],
          t27: T27[X],
          t28: T28[X],
          t29: T29[X],
          t30: T30[X],
          t31: T31[X],
          t32: T32[X],
          t33: T33[X],
          t34: T34[X],
          t35: T35[X],
          t36: T36[X],
          t37: T37[X]
        ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
          T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] :: T26[X] ::
          T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: T35[X] :: T36[X] :: T37[X] :: InnerHZero =
          t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: t19 :: t20 :: t21 :: t22 :: t23 :: t24 :: t25 :: t26 :: t27 :: t28 :: t29 :: t30 :: t31 :: t32 :: t33 :: t34 :: t35 :: t36 :: t37 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function37(func3)(
        t1,
        t2,
        t3,
        t4,
        t5,
        t6,
        t7,
        t8,
        t9,
        t10,
        t11,
        t12,
        t13,
        t14,
        t15,
        t16,
        t17,
        t18,
        t19,
        t20,
        t21,
        t22,
        t23,
        t24,
        t25,
        t26,
        t27,
        t28,
        t29,
        t30,
        t31,
        t32,
        t33,
        t34,
        t35,
        t36,
        t37
      )
      self.function2(func2)(temp2, t38)
    }
  }
  object Function38Generic {
    trait Func38Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], T36[_], T37[_], T38[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X],
        t20: T20[X],
        t21: T21[X],
        t22: T22[X],
        t23: T23[X],
        t24: T24[X],
        t25: T25[X],
        t26: T26[X],
        t27: T27[X],
        t28: T28[X],
        t29: T29[X],
        t30: T30[X],
        t31: T31[X],
        t32: T32[X],
        t33: T33[X],
        t34: T34[X],
        t35: T35[X],
        t36: T36[X],
        t37: T37[X],
        t38: T38[X]
      ): TOut[X]
    }
  }

  trait Function39Generic[F[_[_]]] {
    self: Function2Generic[F] with Function38Generic[F] =>

    def function39[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], TOut[_]](
      func: Function39Generic.Func39Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        TOut
      ]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19],
      t20: F[T20],
      t21: F[T21],
      t22: F[T22],
      t23: F[T23],
      t24: F[T24],
      t25: F[T25],
      t26: F[T26],
      t27: F[T27],
      t28: F[T28],
      t29: F[T29],
      t30: F[T30],
      t31: F[T31],
      t32: F[T32],
      t33: F[T33],
      t34: F[T34],
      t35: F[T35],
      t36: F[T36],
      t37: F[T37],
      t38: F[T38],
      t39: F[T39]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: T19[U] :: T20[U] :: T21[U] :: T22[U] :: T23[U] :: T24[U] :: T25[U] ::
        T26[U] :: T27[U] :: T28[U] :: T29[U] :: T30[U] :: T31[U] :: T32[U] :: T33[U] :: T34[U] :: T35[U] :: T36[U] :: T37[U] :: T38[U] ::
        InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T39, TOut] = new Function2Generic.Func2Func[ZipType, T39, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] ::
            T26[X] :: T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: T35[X] :: T36[X] :: T37[X] ::
            T38[X] :: InnerHZero,
          i2: T39[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function38Generic.Func38Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        ZipType
      ] = new Function38Generic.Func38Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        ZipType
      ] {
        override def apply[X](
          t1: T1[X],
          t2: T2[X],
          t3: T3[X],
          t4: T4[X],
          t5: T5[X],
          t6: T6[X],
          t7: T7[X],
          t8: T8[X],
          t9: T9[X],
          t10: T10[X],
          t11: T11[X],
          t12: T12[X],
          t13: T13[X],
          t14: T14[X],
          t15: T15[X],
          t16: T16[X],
          t17: T17[X],
          t18: T18[X],
          t19: T19[X],
          t20: T20[X],
          t21: T21[X],
          t22: T22[X],
          t23: T23[X],
          t24: T24[X],
          t25: T25[X],
          t26: T26[X],
          t27: T27[X],
          t28: T28[X],
          t29: T29[X],
          t30: T30[X],
          t31: T31[X],
          t32: T32[X],
          t33: T33[X],
          t34: T34[X],
          t35: T35[X],
          t36: T36[X],
          t37: T37[X],
          t38: T38[X]
        ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
          T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] :: T26[X] ::
          T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: T35[X] :: T36[X] :: T37[X] :: T38[X] ::
          InnerHZero =
          t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: t19 :: t20 :: t21 :: t22 :: t23 :: t24 :: t25 :: t26 :: t27 :: t28 :: t29 :: t30 :: t31 :: t32 :: t33 :: t34 :: t35 :: t36 :: t37 :: t38 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function38(func3)(
        t1,
        t2,
        t3,
        t4,
        t5,
        t6,
        t7,
        t8,
        t9,
        t10,
        t11,
        t12,
        t13,
        t14,
        t15,
        t16,
        t17,
        t18,
        t19,
        t20,
        t21,
        t22,
        t23,
        t24,
        t25,
        t26,
        t27,
        t28,
        t29,
        t30,
        t31,
        t32,
        t33,
        t34,
        t35,
        t36,
        t37,
        t38
      )
      self.function2(func2)(temp2, t39)
    }
  }
  object Function39Generic {
    trait Func39Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X],
        t20: T20[X],
        t21: T21[X],
        t22: T22[X],
        t23: T23[X],
        t24: T24[X],
        t25: T25[X],
        t26: T26[X],
        t27: T27[X],
        t28: T28[X],
        t29: T29[X],
        t30: T30[X],
        t31: T31[X],
        t32: T32[X],
        t33: T33[X],
        t34: T34[X],
        t35: T35[X],
        t36: T36[X],
        t37: T37[X],
        t38: T38[X],
        t39: T39[X]
      ): TOut[X]
    }
  }

  trait Function40Generic[F[_[_]]] {
    self: Function2Generic[F] with Function39Generic[F] =>

    def function40[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], TOut[_]](
      func: Function40Generic.Func40Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        T40,
        TOut
      ]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19],
      t20: F[T20],
      t21: F[T21],
      t22: F[T22],
      t23: F[T23],
      t24: F[T24],
      t25: F[T25],
      t26: F[T26],
      t27: F[T27],
      t28: F[T28],
      t29: F[T29],
      t30: F[T30],
      t31: F[T31],
      t32: F[T32],
      t33: F[T33],
      t34: F[T34],
      t35: F[T35],
      t36: F[T36],
      t37: F[T37],
      t38: F[T38],
      t39: F[T39],
      t40: F[T40]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: T19[U] :: T20[U] :: T21[U] :: T22[U] :: T23[U] :: T24[U] :: T25[U] ::
        T26[U] :: T27[U] :: T28[U] :: T29[U] :: T30[U] :: T31[U] :: T32[U] :: T33[U] :: T34[U] :: T35[U] :: T36[U] :: T37[U] :: T38[U] ::
        T39[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T40, TOut] = new Function2Generic.Func2Func[ZipType, T40, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] ::
            T26[X] :: T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: T35[X] :: T36[X] :: T37[X] ::
            T38[X] :: T39[X] :: InnerHZero,
          i2: T40[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function39Generic.Func39Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        ZipType
      ] = new Function39Generic.Func39Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        ZipType
      ] {
        override def apply[X](
          t1: T1[X],
          t2: T2[X],
          t3: T3[X],
          t4: T4[X],
          t5: T5[X],
          t6: T6[X],
          t7: T7[X],
          t8: T8[X],
          t9: T9[X],
          t10: T10[X],
          t11: T11[X],
          t12: T12[X],
          t13: T13[X],
          t14: T14[X],
          t15: T15[X],
          t16: T16[X],
          t17: T17[X],
          t18: T18[X],
          t19: T19[X],
          t20: T20[X],
          t21: T21[X],
          t22: T22[X],
          t23: T23[X],
          t24: T24[X],
          t25: T25[X],
          t26: T26[X],
          t27: T27[X],
          t28: T28[X],
          t29: T29[X],
          t30: T30[X],
          t31: T31[X],
          t32: T32[X],
          t33: T33[X],
          t34: T34[X],
          t35: T35[X],
          t36: T36[X],
          t37: T37[X],
          t38: T38[X],
          t39: T39[X]
        ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
          T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] :: T26[X] ::
          T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: T35[X] :: T36[X] :: T37[X] :: T38[X] :: T39[X] ::
          InnerHZero =
          t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: t19 :: t20 :: t21 :: t22 :: t23 :: t24 :: t25 :: t26 :: t27 :: t28 :: t29 :: t30 :: t31 :: t32 :: t33 :: t34 :: t35 :: t36 :: t37 :: t38 :: t39 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function39(func3)(
        t1,
        t2,
        t3,
        t4,
        t5,
        t6,
        t7,
        t8,
        t9,
        t10,
        t11,
        t12,
        t13,
        t14,
        t15,
        t16,
        t17,
        t18,
        t19,
        t20,
        t21,
        t22,
        t23,
        t24,
        t25,
        t26,
        t27,
        t28,
        t29,
        t30,
        t31,
        t32,
        t33,
        t34,
        t35,
        t36,
        t37,
        t38,
        t39
      )
      self.function2(func2)(temp2, t40)
    }
  }
  object Function40Generic {
    trait Func40Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X],
        t20: T20[X],
        t21: T21[X],
        t22: T22[X],
        t23: T23[X],
        t24: T24[X],
        t25: T25[X],
        t26: T26[X],
        t27: T27[X],
        t28: T28[X],
        t29: T29[X],
        t30: T30[X],
        t31: T31[X],
        t32: T32[X],
        t33: T33[X],
        t34: T34[X],
        t35: T35[X],
        t36: T36[X],
        t37: T37[X],
        t38: T38[X],
        t39: T39[X],
        t40: T40[X]
      ): TOut[X]
    }
  }

  trait Function41Generic[F[_[_]]] {
    self: Function2Generic[F] with Function40Generic[F] =>

    def function41[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], T41[_], TOut[_]](
      func: Function41Generic.Func41Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        T40,
        T41,
        TOut
      ]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19],
      t20: F[T20],
      t21: F[T21],
      t22: F[T22],
      t23: F[T23],
      t24: F[T24],
      t25: F[T25],
      t26: F[T26],
      t27: F[T27],
      t28: F[T28],
      t29: F[T29],
      t30: F[T30],
      t31: F[T31],
      t32: F[T32],
      t33: F[T33],
      t34: F[T34],
      t35: F[T35],
      t36: F[T36],
      t37: F[T37],
      t38: F[T38],
      t39: F[T39],
      t40: F[T40],
      t41: F[T41]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: T19[U] :: T20[U] :: T21[U] :: T22[U] :: T23[U] :: T24[U] :: T25[U] ::
        T26[U] :: T27[U] :: T28[U] :: T29[U] :: T30[U] :: T31[U] :: T32[U] :: T33[U] :: T34[U] :: T35[U] :: T36[U] :: T37[U] :: T38[U] ::
        T39[U] :: T40[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T41, TOut] = new Function2Generic.Func2Func[ZipType, T41, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] ::
            T26[X] :: T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: T35[X] :: T36[X] :: T37[X] ::
            T38[X] :: T39[X] :: T40[X] :: InnerHZero,
          i2: T41[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function40Generic.Func40Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        T40,
        ZipType
      ] = new Function40Generic.Func40Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        T40,
        ZipType
      ] {
        override def apply[X](
          t1: T1[X],
          t2: T2[X],
          t3: T3[X],
          t4: T4[X],
          t5: T5[X],
          t6: T6[X],
          t7: T7[X],
          t8: T8[X],
          t9: T9[X],
          t10: T10[X],
          t11: T11[X],
          t12: T12[X],
          t13: T13[X],
          t14: T14[X],
          t15: T15[X],
          t16: T16[X],
          t17: T17[X],
          t18: T18[X],
          t19: T19[X],
          t20: T20[X],
          t21: T21[X],
          t22: T22[X],
          t23: T23[X],
          t24: T24[X],
          t25: T25[X],
          t26: T26[X],
          t27: T27[X],
          t28: T28[X],
          t29: T29[X],
          t30: T30[X],
          t31: T31[X],
          t32: T32[X],
          t33: T33[X],
          t34: T34[X],
          t35: T35[X],
          t36: T36[X],
          t37: T37[X],
          t38: T38[X],
          t39: T39[X],
          t40: T40[X]
        ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
          T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] :: T26[X] ::
          T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: T35[X] :: T36[X] :: T37[X] :: T38[X] :: T39[X] ::
          T40[X] :: InnerHZero =
          t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: t19 :: t20 :: t21 :: t22 :: t23 :: t24 :: t25 :: t26 :: t27 :: t28 :: t29 :: t30 :: t31 :: t32 :: t33 :: t34 :: t35 :: t36 :: t37 :: t38 :: t39 :: t40 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function40(func3)(
        t1,
        t2,
        t3,
        t4,
        t5,
        t6,
        t7,
        t8,
        t9,
        t10,
        t11,
        t12,
        t13,
        t14,
        t15,
        t16,
        t17,
        t18,
        t19,
        t20,
        t21,
        t22,
        t23,
        t24,
        t25,
        t26,
        t27,
        t28,
        t29,
        t30,
        t31,
        t32,
        t33,
        t34,
        t35,
        t36,
        t37,
        t38,
        t39,
        t40
      )
      self.function2(func2)(temp2, t41)
    }
  }
  object Function41Generic {
    trait Func41Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], T41[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X],
        t20: T20[X],
        t21: T21[X],
        t22: T22[X],
        t23: T23[X],
        t24: T24[X],
        t25: T25[X],
        t26: T26[X],
        t27: T27[X],
        t28: T28[X],
        t29: T29[X],
        t30: T30[X],
        t31: T31[X],
        t32: T32[X],
        t33: T33[X],
        t34: T34[X],
        t35: T35[X],
        t36: T36[X],
        t37: T37[X],
        t38: T38[X],
        t39: T39[X],
        t40: T40[X],
        t41: T41[X]
      ): TOut[X]
    }
  }

  trait Function42Generic[F[_[_]]] {
    self: Function2Generic[F] with Function41Generic[F] =>

    def function42[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], T41[_], T42[_], TOut[_]](
      func: Function42Generic.Func42Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        T40,
        T41,
        T42,
        TOut
      ]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19],
      t20: F[T20],
      t21: F[T21],
      t22: F[T22],
      t23: F[T23],
      t24: F[T24],
      t25: F[T25],
      t26: F[T26],
      t27: F[T27],
      t28: F[T28],
      t29: F[T29],
      t30: F[T30],
      t31: F[T31],
      t32: F[T32],
      t33: F[T33],
      t34: F[T34],
      t35: F[T35],
      t36: F[T36],
      t37: F[T37],
      t38: F[T38],
      t39: F[T39],
      t40: F[T40],
      t41: F[T41],
      t42: F[T42]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: T19[U] :: T20[U] :: T21[U] :: T22[U] :: T23[U] :: T24[U] :: T25[U] ::
        T26[U] :: T27[U] :: T28[U] :: T29[U] :: T30[U] :: T31[U] :: T32[U] :: T33[U] :: T34[U] :: T35[U] :: T36[U] :: T37[U] :: T38[U] ::
        T39[U] :: T40[U] :: T41[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T42, TOut] = new Function2Generic.Func2Func[ZipType, T42, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] ::
            T26[X] :: T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: T35[X] :: T36[X] :: T37[X] ::
            T38[X] :: T39[X] :: T40[X] :: T41[X] :: InnerHZero,
          i2: T42[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function41Generic.Func41Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        T40,
        T41,
        ZipType
      ] = new Function41Generic.Func41Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        T40,
        T41,
        ZipType
      ] {
        override def apply[X](
          t1: T1[X],
          t2: T2[X],
          t3: T3[X],
          t4: T4[X],
          t5: T5[X],
          t6: T6[X],
          t7: T7[X],
          t8: T8[X],
          t9: T9[X],
          t10: T10[X],
          t11: T11[X],
          t12: T12[X],
          t13: T13[X],
          t14: T14[X],
          t15: T15[X],
          t16: T16[X],
          t17: T17[X],
          t18: T18[X],
          t19: T19[X],
          t20: T20[X],
          t21: T21[X],
          t22: T22[X],
          t23: T23[X],
          t24: T24[X],
          t25: T25[X],
          t26: T26[X],
          t27: T27[X],
          t28: T28[X],
          t29: T29[X],
          t30: T30[X],
          t31: T31[X],
          t32: T32[X],
          t33: T33[X],
          t34: T34[X],
          t35: T35[X],
          t36: T36[X],
          t37: T37[X],
          t38: T38[X],
          t39: T39[X],
          t40: T40[X],
          t41: T41[X]
        ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
          T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] :: T26[X] ::
          T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: T35[X] :: T36[X] :: T37[X] :: T38[X] :: T39[X] ::
          T40[X] :: T41[X] :: InnerHZero =
          t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: t19 :: t20 :: t21 :: t22 :: t23 :: t24 :: t25 :: t26 :: t27 :: t28 :: t29 :: t30 :: t31 :: t32 :: t33 :: t34 :: t35 :: t36 :: t37 :: t38 :: t39 :: t40 :: t41 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function41(func3)(
        t1,
        t2,
        t3,
        t4,
        t5,
        t6,
        t7,
        t8,
        t9,
        t10,
        t11,
        t12,
        t13,
        t14,
        t15,
        t16,
        t17,
        t18,
        t19,
        t20,
        t21,
        t22,
        t23,
        t24,
        t25,
        t26,
        t27,
        t28,
        t29,
        t30,
        t31,
        t32,
        t33,
        t34,
        t35,
        t36,
        t37,
        t38,
        t39,
        t40,
        t41
      )
      self.function2(func2)(temp2, t42)
    }
  }
  object Function42Generic {
    trait Func42Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], T41[_], T42[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X],
        t20: T20[X],
        t21: T21[X],
        t22: T22[X],
        t23: T23[X],
        t24: T24[X],
        t25: T25[X],
        t26: T26[X],
        t27: T27[X],
        t28: T28[X],
        t29: T29[X],
        t30: T30[X],
        t31: T31[X],
        t32: T32[X],
        t33: T33[X],
        t34: T34[X],
        t35: T35[X],
        t36: T36[X],
        t37: T37[X],
        t38: T38[X],
        t39: T39[X],
        t40: T40[X],
        t41: T41[X],
        t42: T42[X]
      ): TOut[X]
    }
  }

  trait Function43Generic[F[_[_]]] {
    self: Function2Generic[F] with Function42Generic[F] =>

    def function43[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], T41[_], T42[_], T43[_], TOut[_]](
      func: Function43Generic.Func43Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        T40,
        T41,
        T42,
        T43,
        TOut
      ]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19],
      t20: F[T20],
      t21: F[T21],
      t22: F[T22],
      t23: F[T23],
      t24: F[T24],
      t25: F[T25],
      t26: F[T26],
      t27: F[T27],
      t28: F[T28],
      t29: F[T29],
      t30: F[T30],
      t31: F[T31],
      t32: F[T32],
      t33: F[T33],
      t34: F[T34],
      t35: F[T35],
      t36: F[T36],
      t37: F[T37],
      t38: F[T38],
      t39: F[T39],
      t40: F[T40],
      t41: F[T41],
      t42: F[T42],
      t43: F[T43]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: T19[U] :: T20[U] :: T21[U] :: T22[U] :: T23[U] :: T24[U] :: T25[U] ::
        T26[U] :: T27[U] :: T28[U] :: T29[U] :: T30[U] :: T31[U] :: T32[U] :: T33[U] :: T34[U] :: T35[U] :: T36[U] :: T37[U] :: T38[U] ::
        T39[U] :: T40[U] :: T41[U] :: T42[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T43, TOut] = new Function2Generic.Func2Func[ZipType, T43, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] ::
            T26[X] :: T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: T35[X] :: T36[X] :: T37[X] ::
            T38[X] :: T39[X] :: T40[X] :: T41[X] :: T42[X] :: InnerHZero,
          i2: T43[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function42Generic.Func42Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        T40,
        T41,
        T42,
        ZipType
      ] = new Function42Generic.Func42Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        T40,
        T41,
        T42,
        ZipType
      ] {
        override def apply[X](
          t1: T1[X],
          t2: T2[X],
          t3: T3[X],
          t4: T4[X],
          t5: T5[X],
          t6: T6[X],
          t7: T7[X],
          t8: T8[X],
          t9: T9[X],
          t10: T10[X],
          t11: T11[X],
          t12: T12[X],
          t13: T13[X],
          t14: T14[X],
          t15: T15[X],
          t16: T16[X],
          t17: T17[X],
          t18: T18[X],
          t19: T19[X],
          t20: T20[X],
          t21: T21[X],
          t22: T22[X],
          t23: T23[X],
          t24: T24[X],
          t25: T25[X],
          t26: T26[X],
          t27: T27[X],
          t28: T28[X],
          t29: T29[X],
          t30: T30[X],
          t31: T31[X],
          t32: T32[X],
          t33: T33[X],
          t34: T34[X],
          t35: T35[X],
          t36: T36[X],
          t37: T37[X],
          t38: T38[X],
          t39: T39[X],
          t40: T40[X],
          t41: T41[X],
          t42: T42[X]
        ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
          T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] :: T26[X] ::
          T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: T35[X] :: T36[X] :: T37[X] :: T38[X] :: T39[X] ::
          T40[X] :: T41[X] :: T42[X] :: InnerHZero =
          t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: t19 :: t20 :: t21 :: t22 :: t23 :: t24 :: t25 :: t26 :: t27 :: t28 :: t29 :: t30 :: t31 :: t32 :: t33 :: t34 :: t35 :: t36 :: t37 :: t38 :: t39 :: t40 :: t41 :: t42 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function42(func3)(
        t1,
        t2,
        t3,
        t4,
        t5,
        t6,
        t7,
        t8,
        t9,
        t10,
        t11,
        t12,
        t13,
        t14,
        t15,
        t16,
        t17,
        t18,
        t19,
        t20,
        t21,
        t22,
        t23,
        t24,
        t25,
        t26,
        t27,
        t28,
        t29,
        t30,
        t31,
        t32,
        t33,
        t34,
        t35,
        t36,
        t37,
        t38,
        t39,
        t40,
        t41,
        t42
      )
      self.function2(func2)(temp2, t43)
    }
  }
  object Function43Generic {
    trait Func43Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], T41[_], T42[_], T43[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X],
        t20: T20[X],
        t21: T21[X],
        t22: T22[X],
        t23: T23[X],
        t24: T24[X],
        t25: T25[X],
        t26: T26[X],
        t27: T27[X],
        t28: T28[X],
        t29: T29[X],
        t30: T30[X],
        t31: T31[X],
        t32: T32[X],
        t33: T33[X],
        t34: T34[X],
        t35: T35[X],
        t36: T36[X],
        t37: T37[X],
        t38: T38[X],
        t39: T39[X],
        t40: T40[X],
        t41: T41[X],
        t42: T42[X],
        t43: T43[X]
      ): TOut[X]
    }
  }

  trait Function44Generic[F[_[_]]] {
    self: Function2Generic[F] with Function43Generic[F] =>

    def function44[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], T41[_], T42[_], T43[_], T44[_], TOut[_]](
      func: Function44Generic.Func44Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        T40,
        T41,
        T42,
        T43,
        T44,
        TOut
      ]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19],
      t20: F[T20],
      t21: F[T21],
      t22: F[T22],
      t23: F[T23],
      t24: F[T24],
      t25: F[T25],
      t26: F[T26],
      t27: F[T27],
      t28: F[T28],
      t29: F[T29],
      t30: F[T30],
      t31: F[T31],
      t32: F[T32],
      t33: F[T33],
      t34: F[T34],
      t35: F[T35],
      t36: F[T36],
      t37: F[T37],
      t38: F[T38],
      t39: F[T39],
      t40: F[T40],
      t41: F[T41],
      t42: F[T42],
      t43: F[T43],
      t44: F[T44]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: T19[U] :: T20[U] :: T21[U] :: T22[U] :: T23[U] :: T24[U] :: T25[U] ::
        T26[U] :: T27[U] :: T28[U] :: T29[U] :: T30[U] :: T31[U] :: T32[U] :: T33[U] :: T34[U] :: T35[U] :: T36[U] :: T37[U] :: T38[U] ::
        T39[U] :: T40[U] :: T41[U] :: T42[U] :: T43[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T44, TOut] = new Function2Generic.Func2Func[ZipType, T44, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] ::
            T26[X] :: T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: T35[X] :: T36[X] :: T37[X] ::
            T38[X] :: T39[X] :: T40[X] :: T41[X] :: T42[X] :: T43[X] :: InnerHZero,
          i2: T44[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function43Generic.Func43Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        T40,
        T41,
        T42,
        T43,
        ZipType
      ] = new Function43Generic.Func43Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        T40,
        T41,
        T42,
        T43,
        ZipType
      ] {
        override def apply[X](
          t1: T1[X],
          t2: T2[X],
          t3: T3[X],
          t4: T4[X],
          t5: T5[X],
          t6: T6[X],
          t7: T7[X],
          t8: T8[X],
          t9: T9[X],
          t10: T10[X],
          t11: T11[X],
          t12: T12[X],
          t13: T13[X],
          t14: T14[X],
          t15: T15[X],
          t16: T16[X],
          t17: T17[X],
          t18: T18[X],
          t19: T19[X],
          t20: T20[X],
          t21: T21[X],
          t22: T22[X],
          t23: T23[X],
          t24: T24[X],
          t25: T25[X],
          t26: T26[X],
          t27: T27[X],
          t28: T28[X],
          t29: T29[X],
          t30: T30[X],
          t31: T31[X],
          t32: T32[X],
          t33: T33[X],
          t34: T34[X],
          t35: T35[X],
          t36: T36[X],
          t37: T37[X],
          t38: T38[X],
          t39: T39[X],
          t40: T40[X],
          t41: T41[X],
          t42: T42[X],
          t43: T43[X]
        ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
          T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] :: T26[X] ::
          T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: T35[X] :: T36[X] :: T37[X] :: T38[X] :: T39[X] ::
          T40[X] :: T41[X] :: T42[X] :: T43[X] :: InnerHZero =
          t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: t19 :: t20 :: t21 :: t22 :: t23 :: t24 :: t25 :: t26 :: t27 :: t28 :: t29 :: t30 :: t31 :: t32 :: t33 :: t34 :: t35 :: t36 :: t37 :: t38 :: t39 :: t40 :: t41 :: t42 :: t43 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function43(func3)(
        t1,
        t2,
        t3,
        t4,
        t5,
        t6,
        t7,
        t8,
        t9,
        t10,
        t11,
        t12,
        t13,
        t14,
        t15,
        t16,
        t17,
        t18,
        t19,
        t20,
        t21,
        t22,
        t23,
        t24,
        t25,
        t26,
        t27,
        t28,
        t29,
        t30,
        t31,
        t32,
        t33,
        t34,
        t35,
        t36,
        t37,
        t38,
        t39,
        t40,
        t41,
        t42,
        t43
      )
      self.function2(func2)(temp2, t44)
    }
  }
  object Function44Generic {
    trait Func44Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], T41[_], T42[_], T43[_], T44[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X],
        t20: T20[X],
        t21: T21[X],
        t22: T22[X],
        t23: T23[X],
        t24: T24[X],
        t25: T25[X],
        t26: T26[X],
        t27: T27[X],
        t28: T28[X],
        t29: T29[X],
        t30: T30[X],
        t31: T31[X],
        t32: T32[X],
        t33: T33[X],
        t34: T34[X],
        t35: T35[X],
        t36: T36[X],
        t37: T37[X],
        t38: T38[X],
        t39: T39[X],
        t40: T40[X],
        t41: T41[X],
        t42: T42[X],
        t43: T43[X],
        t44: T44[X]
      ): TOut[X]
    }
  }

  trait Function45Generic[F[_[_]]] {
    self: Function2Generic[F] with Function44Generic[F] =>

    def function45[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], T41[_], T42[_], T43[_], T44[_], T45[_], TOut[_]](
      func: Function45Generic.Func45Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        T40,
        T41,
        T42,
        T43,
        T44,
        T45,
        TOut
      ]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19],
      t20: F[T20],
      t21: F[T21],
      t22: F[T22],
      t23: F[T23],
      t24: F[T24],
      t25: F[T25],
      t26: F[T26],
      t27: F[T27],
      t28: F[T28],
      t29: F[T29],
      t30: F[T30],
      t31: F[T31],
      t32: F[T32],
      t33: F[T33],
      t34: F[T34],
      t35: F[T35],
      t36: F[T36],
      t37: F[T37],
      t38: F[T38],
      t39: F[T39],
      t40: F[T40],
      t41: F[T41],
      t42: F[T42],
      t43: F[T43],
      t44: F[T44],
      t45: F[T45]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: T19[U] :: T20[U] :: T21[U] :: T22[U] :: T23[U] :: T24[U] :: T25[U] ::
        T26[U] :: T27[U] :: T28[U] :: T29[U] :: T30[U] :: T31[U] :: T32[U] :: T33[U] :: T34[U] :: T35[U] :: T36[U] :: T37[U] :: T38[U] ::
        T39[U] :: T40[U] :: T41[U] :: T42[U] :: T43[U] :: T44[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T45, TOut] = new Function2Generic.Func2Func[ZipType, T45, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] ::
            T26[X] :: T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: T35[X] :: T36[X] :: T37[X] ::
            T38[X] :: T39[X] :: T40[X] :: T41[X] :: T42[X] :: T43[X] :: T44[X] :: InnerHZero,
          i2: T45[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function44Generic.Func44Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        T40,
        T41,
        T42,
        T43,
        T44,
        ZipType
      ] = new Function44Generic.Func44Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        T40,
        T41,
        T42,
        T43,
        T44,
        ZipType
      ] {
        override def apply[X](
          t1: T1[X],
          t2: T2[X],
          t3: T3[X],
          t4: T4[X],
          t5: T5[X],
          t6: T6[X],
          t7: T7[X],
          t8: T8[X],
          t9: T9[X],
          t10: T10[X],
          t11: T11[X],
          t12: T12[X],
          t13: T13[X],
          t14: T14[X],
          t15: T15[X],
          t16: T16[X],
          t17: T17[X],
          t18: T18[X],
          t19: T19[X],
          t20: T20[X],
          t21: T21[X],
          t22: T22[X],
          t23: T23[X],
          t24: T24[X],
          t25: T25[X],
          t26: T26[X],
          t27: T27[X],
          t28: T28[X],
          t29: T29[X],
          t30: T30[X],
          t31: T31[X],
          t32: T32[X],
          t33: T33[X],
          t34: T34[X],
          t35: T35[X],
          t36: T36[X],
          t37: T37[X],
          t38: T38[X],
          t39: T39[X],
          t40: T40[X],
          t41: T41[X],
          t42: T42[X],
          t43: T43[X],
          t44: T44[X]
        ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
          T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] :: T26[X] ::
          T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: T35[X] :: T36[X] :: T37[X] :: T38[X] :: T39[X] ::
          T40[X] :: T41[X] :: T42[X] :: T43[X] :: T44[X] :: InnerHZero =
          t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: t19 :: t20 :: t21 :: t22 :: t23 :: t24 :: t25 :: t26 :: t27 :: t28 :: t29 :: t30 :: t31 :: t32 :: t33 :: t34 :: t35 :: t36 :: t37 :: t38 :: t39 :: t40 :: t41 :: t42 :: t43 :: t44 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function44(func3)(
        t1,
        t2,
        t3,
        t4,
        t5,
        t6,
        t7,
        t8,
        t9,
        t10,
        t11,
        t12,
        t13,
        t14,
        t15,
        t16,
        t17,
        t18,
        t19,
        t20,
        t21,
        t22,
        t23,
        t24,
        t25,
        t26,
        t27,
        t28,
        t29,
        t30,
        t31,
        t32,
        t33,
        t34,
        t35,
        t36,
        t37,
        t38,
        t39,
        t40,
        t41,
        t42,
        t43,
        t44
      )
      self.function2(func2)(temp2, t45)
    }
  }
  object Function45Generic {
    trait Func45Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], T41[_], T42[_], T43[_], T44[_], T45[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X],
        t20: T20[X],
        t21: T21[X],
        t22: T22[X],
        t23: T23[X],
        t24: T24[X],
        t25: T25[X],
        t26: T26[X],
        t27: T27[X],
        t28: T28[X],
        t29: T29[X],
        t30: T30[X],
        t31: T31[X],
        t32: T32[X],
        t33: T33[X],
        t34: T34[X],
        t35: T35[X],
        t36: T36[X],
        t37: T37[X],
        t38: T38[X],
        t39: T39[X],
        t40: T40[X],
        t41: T41[X],
        t42: T42[X],
        t43: T43[X],
        t44: T44[X],
        t45: T45[X]
      ): TOut[X]
    }
  }

  trait Function46Generic[F[_[_]]] {
    self: Function2Generic[F] with Function45Generic[F] =>

    def function46[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], T41[_], T42[_], T43[_], T44[_], T45[_], T46[_], TOut[_]](
      func: Function46Generic.Func46Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        T40,
        T41,
        T42,
        T43,
        T44,
        T45,
        T46,
        TOut
      ]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19],
      t20: F[T20],
      t21: F[T21],
      t22: F[T22],
      t23: F[T23],
      t24: F[T24],
      t25: F[T25],
      t26: F[T26],
      t27: F[T27],
      t28: F[T28],
      t29: F[T29],
      t30: F[T30],
      t31: F[T31],
      t32: F[T32],
      t33: F[T33],
      t34: F[T34],
      t35: F[T35],
      t36: F[T36],
      t37: F[T37],
      t38: F[T38],
      t39: F[T39],
      t40: F[T40],
      t41: F[T41],
      t42: F[T42],
      t43: F[T43],
      t44: F[T44],
      t45: F[T45],
      t46: F[T46]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: T19[U] :: T20[U] :: T21[U] :: T22[U] :: T23[U] :: T24[U] :: T25[U] ::
        T26[U] :: T27[U] :: T28[U] :: T29[U] :: T30[U] :: T31[U] :: T32[U] :: T33[U] :: T34[U] :: T35[U] :: T36[U] :: T37[U] :: T38[U] ::
        T39[U] :: T40[U] :: T41[U] :: T42[U] :: T43[U] :: T44[U] :: T45[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T46, TOut] = new Function2Generic.Func2Func[ZipType, T46, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] ::
            T26[X] :: T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: T35[X] :: T36[X] :: T37[X] ::
            T38[X] :: T39[X] :: T40[X] :: T41[X] :: T42[X] :: T43[X] :: T44[X] :: T45[X] :: InnerHZero,
          i2: T46[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function45Generic.Func45Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        T40,
        T41,
        T42,
        T43,
        T44,
        T45,
        ZipType
      ] = new Function45Generic.Func45Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        T40,
        T41,
        T42,
        T43,
        T44,
        T45,
        ZipType
      ] {
        override def apply[X](
          t1: T1[X],
          t2: T2[X],
          t3: T3[X],
          t4: T4[X],
          t5: T5[X],
          t6: T6[X],
          t7: T7[X],
          t8: T8[X],
          t9: T9[X],
          t10: T10[X],
          t11: T11[X],
          t12: T12[X],
          t13: T13[X],
          t14: T14[X],
          t15: T15[X],
          t16: T16[X],
          t17: T17[X],
          t18: T18[X],
          t19: T19[X],
          t20: T20[X],
          t21: T21[X],
          t22: T22[X],
          t23: T23[X],
          t24: T24[X],
          t25: T25[X],
          t26: T26[X],
          t27: T27[X],
          t28: T28[X],
          t29: T29[X],
          t30: T30[X],
          t31: T31[X],
          t32: T32[X],
          t33: T33[X],
          t34: T34[X],
          t35: T35[X],
          t36: T36[X],
          t37: T37[X],
          t38: T38[X],
          t39: T39[X],
          t40: T40[X],
          t41: T41[X],
          t42: T42[X],
          t43: T43[X],
          t44: T44[X],
          t45: T45[X]
        ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
          T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] :: T26[X] ::
          T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: T35[X] :: T36[X] :: T37[X] :: T38[X] :: T39[X] ::
          T40[X] :: T41[X] :: T42[X] :: T43[X] :: T44[X] :: T45[X] :: InnerHZero =
          t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: t19 :: t20 :: t21 :: t22 :: t23 :: t24 :: t25 :: t26 :: t27 :: t28 :: t29 :: t30 :: t31 :: t32 :: t33 :: t34 :: t35 :: t36 :: t37 :: t38 :: t39 :: t40 :: t41 :: t42 :: t43 :: t44 :: t45 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function45(func3)(
        t1,
        t2,
        t3,
        t4,
        t5,
        t6,
        t7,
        t8,
        t9,
        t10,
        t11,
        t12,
        t13,
        t14,
        t15,
        t16,
        t17,
        t18,
        t19,
        t20,
        t21,
        t22,
        t23,
        t24,
        t25,
        t26,
        t27,
        t28,
        t29,
        t30,
        t31,
        t32,
        t33,
        t34,
        t35,
        t36,
        t37,
        t38,
        t39,
        t40,
        t41,
        t42,
        t43,
        t44,
        t45
      )
      self.function2(func2)(temp2, t46)
    }
  }
  object Function46Generic {
    trait Func46Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], T41[_], T42[_], T43[_], T44[_], T45[_], T46[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X],
        t20: T20[X],
        t21: T21[X],
        t22: T22[X],
        t23: T23[X],
        t24: T24[X],
        t25: T25[X],
        t26: T26[X],
        t27: T27[X],
        t28: T28[X],
        t29: T29[X],
        t30: T30[X],
        t31: T31[X],
        t32: T32[X],
        t33: T33[X],
        t34: T34[X],
        t35: T35[X],
        t36: T36[X],
        t37: T37[X],
        t38: T38[X],
        t39: T39[X],
        t40: T40[X],
        t41: T41[X],
        t42: T42[X],
        t43: T43[X],
        t44: T44[X],
        t45: T45[X],
        t46: T46[X]
      ): TOut[X]
    }
  }

  trait Function47Generic[F[_[_]]] {
    self: Function2Generic[F] with Function46Generic[F] =>

    def function47[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], T41[_], T42[_], T43[_], T44[_], T45[_], T46[_], T47[_], TOut[_]](
      func: Function47Generic.Func47Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        T40,
        T41,
        T42,
        T43,
        T44,
        T45,
        T46,
        T47,
        TOut
      ]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19],
      t20: F[T20],
      t21: F[T21],
      t22: F[T22],
      t23: F[T23],
      t24: F[T24],
      t25: F[T25],
      t26: F[T26],
      t27: F[T27],
      t28: F[T28],
      t29: F[T29],
      t30: F[T30],
      t31: F[T31],
      t32: F[T32],
      t33: F[T33],
      t34: F[T34],
      t35: F[T35],
      t36: F[T36],
      t37: F[T37],
      t38: F[T38],
      t39: F[T39],
      t40: F[T40],
      t41: F[T41],
      t42: F[T42],
      t43: F[T43],
      t44: F[T44],
      t45: F[T45],
      t46: F[T46],
      t47: F[T47]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: T19[U] :: T20[U] :: T21[U] :: T22[U] :: T23[U] :: T24[U] :: T25[U] ::
        T26[U] :: T27[U] :: T28[U] :: T29[U] :: T30[U] :: T31[U] :: T32[U] :: T33[U] :: T34[U] :: T35[U] :: T36[U] :: T37[U] :: T38[U] ::
        T39[U] :: T40[U] :: T41[U] :: T42[U] :: T43[U] :: T44[U] :: T45[U] :: T46[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T47, TOut] = new Function2Generic.Func2Func[ZipType, T47, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] ::
            T26[X] :: T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: T35[X] :: T36[X] :: T37[X] ::
            T38[X] :: T39[X] :: T40[X] :: T41[X] :: T42[X] :: T43[X] :: T44[X] :: T45[X] :: T46[X] :: InnerHZero,
          i2: T47[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function46Generic.Func46Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        T40,
        T41,
        T42,
        T43,
        T44,
        T45,
        T46,
        ZipType
      ] = new Function46Generic.Func46Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        T40,
        T41,
        T42,
        T43,
        T44,
        T45,
        T46,
        ZipType
      ] {
        override def apply[X](
          t1: T1[X],
          t2: T2[X],
          t3: T3[X],
          t4: T4[X],
          t5: T5[X],
          t6: T6[X],
          t7: T7[X],
          t8: T8[X],
          t9: T9[X],
          t10: T10[X],
          t11: T11[X],
          t12: T12[X],
          t13: T13[X],
          t14: T14[X],
          t15: T15[X],
          t16: T16[X],
          t17: T17[X],
          t18: T18[X],
          t19: T19[X],
          t20: T20[X],
          t21: T21[X],
          t22: T22[X],
          t23: T23[X],
          t24: T24[X],
          t25: T25[X],
          t26: T26[X],
          t27: T27[X],
          t28: T28[X],
          t29: T29[X],
          t30: T30[X],
          t31: T31[X],
          t32: T32[X],
          t33: T33[X],
          t34: T34[X],
          t35: T35[X],
          t36: T36[X],
          t37: T37[X],
          t38: T38[X],
          t39: T39[X],
          t40: T40[X],
          t41: T41[X],
          t42: T42[X],
          t43: T43[X],
          t44: T44[X],
          t45: T45[X],
          t46: T46[X]
        ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
          T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] :: T26[X] ::
          T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: T35[X] :: T36[X] :: T37[X] :: T38[X] :: T39[X] ::
          T40[X] :: T41[X] :: T42[X] :: T43[X] :: T44[X] :: T45[X] :: T46[X] :: InnerHZero =
          t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: t19 :: t20 :: t21 :: t22 :: t23 :: t24 :: t25 :: t26 :: t27 :: t28 :: t29 :: t30 :: t31 :: t32 :: t33 :: t34 :: t35 :: t36 :: t37 :: t38 :: t39 :: t40 :: t41 :: t42 :: t43 :: t44 :: t45 :: t46 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function46(func3)(
        t1,
        t2,
        t3,
        t4,
        t5,
        t6,
        t7,
        t8,
        t9,
        t10,
        t11,
        t12,
        t13,
        t14,
        t15,
        t16,
        t17,
        t18,
        t19,
        t20,
        t21,
        t22,
        t23,
        t24,
        t25,
        t26,
        t27,
        t28,
        t29,
        t30,
        t31,
        t32,
        t33,
        t34,
        t35,
        t36,
        t37,
        t38,
        t39,
        t40,
        t41,
        t42,
        t43,
        t44,
        t45,
        t46
      )
      self.function2(func2)(temp2, t47)
    }
  }
  object Function47Generic {
    trait Func47Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], T41[_], T42[_], T43[_], T44[_], T45[_], T46[_], T47[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X],
        t20: T20[X],
        t21: T21[X],
        t22: T22[X],
        t23: T23[X],
        t24: T24[X],
        t25: T25[X],
        t26: T26[X],
        t27: T27[X],
        t28: T28[X],
        t29: T29[X],
        t30: T30[X],
        t31: T31[X],
        t32: T32[X],
        t33: T33[X],
        t34: T34[X],
        t35: T35[X],
        t36: T36[X],
        t37: T37[X],
        t38: T38[X],
        t39: T39[X],
        t40: T40[X],
        t41: T41[X],
        t42: T42[X],
        t43: T43[X],
        t44: T44[X],
        t45: T45[X],
        t46: T46[X],
        t47: T47[X]
      ): TOut[X]
    }
  }

  trait Function48Generic[F[_[_]]] {
    self: Function2Generic[F] with Function47Generic[F] =>

    def function48[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], T41[_], T42[_], T43[_], T44[_], T45[_], T46[_], T47[_], T48[_], TOut[_]](
      func: Function48Generic.Func48Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        T40,
        T41,
        T42,
        T43,
        T44,
        T45,
        T46,
        T47,
        T48,
        TOut
      ]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19],
      t20: F[T20],
      t21: F[T21],
      t22: F[T22],
      t23: F[T23],
      t24: F[T24],
      t25: F[T25],
      t26: F[T26],
      t27: F[T27],
      t28: F[T28],
      t29: F[T29],
      t30: F[T30],
      t31: F[T31],
      t32: F[T32],
      t33: F[T33],
      t34: F[T34],
      t35: F[T35],
      t36: F[T36],
      t37: F[T37],
      t38: F[T38],
      t39: F[T39],
      t40: F[T40],
      t41: F[T41],
      t42: F[T42],
      t43: F[T43],
      t44: F[T44],
      t45: F[T45],
      t46: F[T46],
      t47: F[T47],
      t48: F[T48]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: T19[U] :: T20[U] :: T21[U] :: T22[U] :: T23[U] :: T24[U] :: T25[U] ::
        T26[U] :: T27[U] :: T28[U] :: T29[U] :: T30[U] :: T31[U] :: T32[U] :: T33[U] :: T34[U] :: T35[U] :: T36[U] :: T37[U] :: T38[U] ::
        T39[U] :: T40[U] :: T41[U] :: T42[U] :: T43[U] :: T44[U] :: T45[U] :: T46[U] :: T47[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T48, TOut] = new Function2Generic.Func2Func[ZipType, T48, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] ::
            T26[X] :: T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: T35[X] :: T36[X] :: T37[X] ::
            T38[X] :: T39[X] :: T40[X] :: T41[X] :: T42[X] :: T43[X] :: T44[X] :: T45[X] :: T46[X] :: T47[X] :: InnerHZero,
          i2: T48[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function47Generic.Func47Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        T40,
        T41,
        T42,
        T43,
        T44,
        T45,
        T46,
        T47,
        ZipType
      ] = new Function47Generic.Func47Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        T40,
        T41,
        T42,
        T43,
        T44,
        T45,
        T46,
        T47,
        ZipType
      ] {
        override def apply[X](
          t1: T1[X],
          t2: T2[X],
          t3: T3[X],
          t4: T4[X],
          t5: T5[X],
          t6: T6[X],
          t7: T7[X],
          t8: T8[X],
          t9: T9[X],
          t10: T10[X],
          t11: T11[X],
          t12: T12[X],
          t13: T13[X],
          t14: T14[X],
          t15: T15[X],
          t16: T16[X],
          t17: T17[X],
          t18: T18[X],
          t19: T19[X],
          t20: T20[X],
          t21: T21[X],
          t22: T22[X],
          t23: T23[X],
          t24: T24[X],
          t25: T25[X],
          t26: T26[X],
          t27: T27[X],
          t28: T28[X],
          t29: T29[X],
          t30: T30[X],
          t31: T31[X],
          t32: T32[X],
          t33: T33[X],
          t34: T34[X],
          t35: T35[X],
          t36: T36[X],
          t37: T37[X],
          t38: T38[X],
          t39: T39[X],
          t40: T40[X],
          t41: T41[X],
          t42: T42[X],
          t43: T43[X],
          t44: T44[X],
          t45: T45[X],
          t46: T46[X],
          t47: T47[X]
        ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
          T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] :: T26[X] ::
          T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: T35[X] :: T36[X] :: T37[X] :: T38[X] :: T39[X] ::
          T40[X] :: T41[X] :: T42[X] :: T43[X] :: T44[X] :: T45[X] :: T46[X] :: T47[X] :: InnerHZero =
          t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: t19 :: t20 :: t21 :: t22 :: t23 :: t24 :: t25 :: t26 :: t27 :: t28 :: t29 :: t30 :: t31 :: t32 :: t33 :: t34 :: t35 :: t36 :: t37 :: t38 :: t39 :: t40 :: t41 :: t42 :: t43 :: t44 :: t45 :: t46 :: t47 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function47(func3)(
        t1,
        t2,
        t3,
        t4,
        t5,
        t6,
        t7,
        t8,
        t9,
        t10,
        t11,
        t12,
        t13,
        t14,
        t15,
        t16,
        t17,
        t18,
        t19,
        t20,
        t21,
        t22,
        t23,
        t24,
        t25,
        t26,
        t27,
        t28,
        t29,
        t30,
        t31,
        t32,
        t33,
        t34,
        t35,
        t36,
        t37,
        t38,
        t39,
        t40,
        t41,
        t42,
        t43,
        t44,
        t45,
        t46,
        t47
      )
      self.function2(func2)(temp2, t48)
    }
  }
  object Function48Generic {
    trait Func48Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], T41[_], T42[_], T43[_], T44[_], T45[_], T46[_], T47[_], T48[_], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X],
        t20: T20[X],
        t21: T21[X],
        t22: T22[X],
        t23: T23[X],
        t24: T24[X],
        t25: T25[X],
        t26: T26[X],
        t27: T27[X],
        t28: T28[X],
        t29: T29[X],
        t30: T30[X],
        t31: T31[X],
        t32: T32[X],
        t33: T33[X],
        t34: T34[X],
        t35: T35[X],
        t36: T36[X],
        t37: T37[X],
        t38: T38[X],
        t39: T39[X],
        t40: T40[X],
        t41: T41[X],
        t42: T42[X],
        t43: T43[X],
        t44: T44[X],
        t45: T45[X],
        t46: T46[X],
        t47: T47[X],
        t48: T48[X]
      ): TOut[X]
    }
  }

  trait Function49Generic[F[_[_]]] {
    self: Function2Generic[F] with Function48Generic[F] =>

    def function49[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], T41[_], T42[_], T43[_], T44[_], T45[_], T46[_], T47[_], T48[_], T49[_], TOut[
      _
    ]](
      func: Function49Generic.Func49Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        T40,
        T41,
        T42,
        T43,
        T44,
        T45,
        T46,
        T47,
        T48,
        T49,
        TOut
      ]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19],
      t20: F[T20],
      t21: F[T21],
      t22: F[T22],
      t23: F[T23],
      t24: F[T24],
      t25: F[T25],
      t26: F[T26],
      t27: F[T27],
      t28: F[T28],
      t29: F[T29],
      t30: F[T30],
      t31: F[T31],
      t32: F[T32],
      t33: F[T33],
      t34: F[T34],
      t35: F[T35],
      t36: F[T36],
      t37: F[T37],
      t38: F[T38],
      t39: F[T39],
      t40: F[T40],
      t41: F[T41],
      t42: F[T42],
      t43: F[T43],
      t44: F[T44],
      t45: F[T45],
      t46: F[T46],
      t47: F[T47],
      t48: F[T48],
      t49: F[T49]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: T19[U] :: T20[U] :: T21[U] :: T22[U] :: T23[U] :: T24[U] :: T25[U] ::
        T26[U] :: T27[U] :: T28[U] :: T29[U] :: T30[U] :: T31[U] :: T32[U] :: T33[U] :: T34[U] :: T35[U] :: T36[U] :: T37[U] :: T38[U] ::
        T39[U] :: T40[U] :: T41[U] :: T42[U] :: T43[U] :: T44[U] :: T45[U] :: T46[U] :: T47[U] :: T48[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T49, TOut] = new Function2Generic.Func2Func[ZipType, T49, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] ::
            T26[X] :: T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: T35[X] :: T36[X] :: T37[X] ::
            T38[X] :: T39[X] :: T40[X] :: T41[X] :: T42[X] :: T43[X] :: T44[X] :: T45[X] :: T46[X] :: T47[X] :: T48[X] :: InnerHZero,
          i2: T49[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function48Generic.Func48Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        T40,
        T41,
        T42,
        T43,
        T44,
        T45,
        T46,
        T47,
        T48,
        ZipType
      ] = new Function48Generic.Func48Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        T40,
        T41,
        T42,
        T43,
        T44,
        T45,
        T46,
        T47,
        T48,
        ZipType
      ] {
        override def apply[X](
          t1: T1[X],
          t2: T2[X],
          t3: T3[X],
          t4: T4[X],
          t5: T5[X],
          t6: T6[X],
          t7: T7[X],
          t8: T8[X],
          t9: T9[X],
          t10: T10[X],
          t11: T11[X],
          t12: T12[X],
          t13: T13[X],
          t14: T14[X],
          t15: T15[X],
          t16: T16[X],
          t17: T17[X],
          t18: T18[X],
          t19: T19[X],
          t20: T20[X],
          t21: T21[X],
          t22: T22[X],
          t23: T23[X],
          t24: T24[X],
          t25: T25[X],
          t26: T26[X],
          t27: T27[X],
          t28: T28[X],
          t29: T29[X],
          t30: T30[X],
          t31: T31[X],
          t32: T32[X],
          t33: T33[X],
          t34: T34[X],
          t35: T35[X],
          t36: T36[X],
          t37: T37[X],
          t38: T38[X],
          t39: T39[X],
          t40: T40[X],
          t41: T41[X],
          t42: T42[X],
          t43: T43[X],
          t44: T44[X],
          t45: T45[X],
          t46: T46[X],
          t47: T47[X],
          t48: T48[X]
        ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
          T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] :: T26[X] ::
          T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: T35[X] :: T36[X] :: T37[X] :: T38[X] :: T39[X] ::
          T40[X] :: T41[X] :: T42[X] :: T43[X] :: T44[X] :: T45[X] :: T46[X] :: T47[X] :: T48[X] :: InnerHZero =
          t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: t19 :: t20 :: t21 :: t22 :: t23 :: t24 :: t25 :: t26 :: t27 :: t28 :: t29 :: t30 :: t31 :: t32 :: t33 :: t34 :: t35 :: t36 :: t37 :: t38 :: t39 :: t40 :: t41 :: t42 :: t43 :: t44 :: t45 :: t46 :: t47 :: t48 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function48(func3)(
        t1,
        t2,
        t3,
        t4,
        t5,
        t6,
        t7,
        t8,
        t9,
        t10,
        t11,
        t12,
        t13,
        t14,
        t15,
        t16,
        t17,
        t18,
        t19,
        t20,
        t21,
        t22,
        t23,
        t24,
        t25,
        t26,
        t27,
        t28,
        t29,
        t30,
        t31,
        t32,
        t33,
        t34,
        t35,
        t36,
        t37,
        t38,
        t39,
        t40,
        t41,
        t42,
        t43,
        t44,
        t45,
        t46,
        t47,
        t48
      )
      self.function2(func2)(temp2, t49)
    }
  }
  object Function49Generic {
    trait Func49Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], T41[_], T42[_], T43[_], T44[_], T45[_], T46[_], T47[_], T48[_], T49[_], TOut[
      _
    ]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X],
        t20: T20[X],
        t21: T21[X],
        t22: T22[X],
        t23: T23[X],
        t24: T24[X],
        t25: T25[X],
        t26: T26[X],
        t27: T27[X],
        t28: T28[X],
        t29: T29[X],
        t30: T30[X],
        t31: T31[X],
        t32: T32[X],
        t33: T33[X],
        t34: T34[X],
        t35: T35[X],
        t36: T36[X],
        t37: T37[X],
        t38: T38[X],
        t39: T39[X],
        t40: T40[X],
        t41: T41[X],
        t42: T42[X],
        t43: T43[X],
        t44: T44[X],
        t45: T45[X],
        t46: T46[X],
        t47: T47[X],
        t48: T48[X],
        t49: T49[X]
      ): TOut[X]
    }
  }

  trait Function50Generic[F[_[_]]] {
    self: Function2Generic[F] with Function49Generic[F] =>

    def function50[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], T41[_], T42[_], T43[_], T44[_], T45[_], T46[_], T47[_], T48[_], T49[_], T50[
      _
    ], TOut[_]](
      func: Function50Generic.Func50Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        T40,
        T41,
        T42,
        T43,
        T44,
        T45,
        T46,
        T47,
        T48,
        T49,
        T50,
        TOut
      ]
    )(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6],
      t7: F[T7],
      t8: F[T8],
      t9: F[T9],
      t10: F[T10],
      t11: F[T11],
      t12: F[T12],
      t13: F[T13],
      t14: F[T14],
      t15: F[T15],
      t16: F[T16],
      t17: F[T17],
      t18: F[T18],
      t19: F[T19],
      t20: F[T20],
      t21: F[T21],
      t22: F[T22],
      t23: F[T23],
      t24: F[T24],
      t25: F[T25],
      t26: F[T26],
      t27: F[T27],
      t28: F[T28],
      t29: F[T29],
      t30: F[T30],
      t31: F[T31],
      t32: F[T32],
      t33: F[T33],
      t34: F[T34],
      t35: F[T35],
      t36: F[T36],
      t37: F[T37],
      t38: F[T38],
      t39: F[T39],
      t40: F[T40],
      t41: F[T41],
      t42: F[T42],
      t43: F[T43],
      t44: F[T44],
      t45: F[T45],
      t46: F[T46],
      t47: F[T47],
      t48: F[T48],
      t49: F[T49],
      t50: F[T50]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: T6[U] :: T7[U] :: T8[U] :: T9[U] :: T10[U] :: T11[U] :: T12[U] ::
        T13[U] :: T14[U] :: T15[U] :: T16[U] :: T17[U] :: T18[U] :: T19[U] :: T20[U] :: T21[U] :: T22[U] :: T23[U] :: T24[U] :: T25[U] ::
        T26[U] :: T27[U] :: T28[U] :: T29[U] :: T30[U] :: T31[U] :: T32[U] :: T33[U] :: T34[U] :: T35[U] :: T36[U] :: T37[U] :: T38[U] ::
        T39[U] :: T40[U] :: T41[U] :: T42[U] :: T43[U] :: T44[U] :: T45[U] :: T46[U] :: T47[U] :: T48[U] :: T49[U] :: InnerHZero
      val func2: Function2Generic.Func2Func[ZipType, T50, TOut] = new Function2Generic.Func2Func[ZipType, T50, TOut] {
        override def apply[X](
          param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
            T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] ::
            T26[X] :: T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: T35[X] :: T36[X] :: T37[X] ::
            T38[X] :: T39[X] :: T40[X] :: T41[X] :: T42[X] :: T43[X] :: T44[X] :: T45[X] :: T46[X] :: T47[X] :: T48[X] :: T49[X] ::
            InnerHZero,
          i2: T50[X]
        ): TOut[X] =
          func(
            param1.head,
            param1.tail.head,
            param1.tail.tail.head,
            param1.tail.tail.tail.head,
            param1.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            param1.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.head,
            i2
          )
      }
      val func3: Function49Generic.Func49Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        T40,
        T41,
        T42,
        T43,
        T44,
        T45,
        T46,
        T47,
        T48,
        T49,
        ZipType
      ] = new Function49Generic.Func49Func[
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10,
        T11,
        T12,
        T13,
        T14,
        T15,
        T16,
        T17,
        T18,
        T19,
        T20,
        T21,
        T22,
        T23,
        T24,
        T25,
        T26,
        T27,
        T28,
        T29,
        T30,
        T31,
        T32,
        T33,
        T34,
        T35,
        T36,
        T37,
        T38,
        T39,
        T40,
        T41,
        T42,
        T43,
        T44,
        T45,
        T46,
        T47,
        T48,
        T49,
        ZipType
      ] {
        override def apply[X](
          t1: T1[X],
          t2: T2[X],
          t3: T3[X],
          t4: T4[X],
          t5: T5[X],
          t6: T6[X],
          t7: T7[X],
          t8: T8[X],
          t9: T9[X],
          t10: T10[X],
          t11: T11[X],
          t12: T12[X],
          t13: T13[X],
          t14: T14[X],
          t15: T15[X],
          t16: T16[X],
          t17: T17[X],
          t18: T18[X],
          t19: T19[X],
          t20: T20[X],
          t21: T21[X],
          t22: T22[X],
          t23: T23[X],
          t24: T24[X],
          t25: T25[X],
          t26: T26[X],
          t27: T27[X],
          t28: T28[X],
          t29: T29[X],
          t30: T30[X],
          t31: T31[X],
          t32: T32[X],
          t33: T33[X],
          t34: T34[X],
          t35: T35[X],
          t36: T36[X],
          t37: T37[X],
          t38: T38[X],
          t39: T39[X],
          t40: T40[X],
          t41: T41[X],
          t42: T42[X],
          t43: T43[X],
          t44: T44[X],
          t45: T45[X],
          t46: T46[X],
          t47: T47[X],
          t48: T48[X],
          t49: T49[X]
        ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: T10[X] :: T11[X] :: T12[X] :: T13[X] ::
          T14[X] :: T15[X] :: T16[X] :: T17[X] :: T18[X] :: T19[X] :: T20[X] :: T21[X] :: T22[X] :: T23[X] :: T24[X] :: T25[X] :: T26[X] ::
          T27[X] :: T28[X] :: T29[X] :: T30[X] :: T31[X] :: T32[X] :: T33[X] :: T34[X] :: T35[X] :: T36[X] :: T37[X] :: T38[X] :: T39[X] ::
          T40[X] :: T41[X] :: T42[X] :: T43[X] :: T44[X] :: T45[X] :: T46[X] :: T47[X] :: T48[X] :: T49[X] :: InnerHZero =
          t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: t10 :: t11 :: t12 :: t13 :: t14 :: t15 :: t16 :: t17 :: t18 :: t19 :: t20 :: t21 :: t22 :: t23 :: t24 :: t25 :: t26 :: t27 :: t28 :: t29 :: t30 :: t31 :: t32 :: t33 :: t34 :: t35 :: t36 :: t37 :: t38 :: t39 :: t40 :: t41 :: t42 :: t43 :: t44 :: t45 :: t46 :: t47 :: t48 :: t49 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function49(func3)(
        t1,
        t2,
        t3,
        t4,
        t5,
        t6,
        t7,
        t8,
        t9,
        t10,
        t11,
        t12,
        t13,
        t14,
        t15,
        t16,
        t17,
        t18,
        t19,
        t20,
        t21,
        t22,
        t23,
        t24,
        t25,
        t26,
        t27,
        t28,
        t29,
        t30,
        t31,
        t32,
        t33,
        t34,
        t35,
        t36,
        t37,
        t38,
        t39,
        t40,
        t41,
        t42,
        t43,
        t44,
        t45,
        t46,
        t47,
        t48,
        t49
      )
      self.function2(func2)(temp2, t50)
    }
  }
  object Function50Generic {
    trait Func50Func[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[_], T16[
      _
    ], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[_], T33[
      _
    ], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], T41[_], T42[_], T43[_], T44[_], T45[_], T46[_], T47[_], T48[_], T49[_], T50[
      _
    ], TOut[_]] {
      def apply[X](
        t1: T1[X],
        t2: T2[X],
        t3: T3[X],
        t4: T4[X],
        t5: T5[X],
        t6: T6[X],
        t7: T7[X],
        t8: T8[X],
        t9: T9[X],
        t10: T10[X],
        t11: T11[X],
        t12: T12[X],
        t13: T13[X],
        t14: T14[X],
        t15: T15[X],
        t16: T16[X],
        t17: T17[X],
        t18: T18[X],
        t19: T19[X],
        t20: T20[X],
        t21: T21[X],
        t22: T22[X],
        t23: T23[X],
        t24: T24[X],
        t25: T25[X],
        t26: T26[X],
        t27: T27[X],
        t28: T28[X],
        t29: T29[X],
        t30: T30[X],
        t31: T31[X],
        t32: T32[X],
        t33: T33[X],
        t34: T34[X],
        t35: T35[X],
        t36: T36[X],
        t37: T37[X],
        t38: T38[X],
        t39: T39[X],
        t40: T40[X],
        t41: T41[X],
        t42: T42[X],
        t43: T43[X],
        t44: T44[X],
        t45: T45[X],
        t46: T46[X],
        t47: T47[X],
        t48: T48[X],
        t49: T49[X],
        t50: T50[X]
      ): TOut[X]
    }
  }

  trait FunctionNGenericSumImpl[F[_[_]]]
      extends Function3Generic[F]
      with Function4Generic[F]
      with Function5Generic[F]
      with Function6Generic[F]
      with Function7Generic[F]
      with Function8Generic[F]
      with Function9Generic[F]
      with Function10Generic[F]
      with Function11Generic[F]
      with Function12Generic[F]
      with Function13Generic[F]
      with Function14Generic[F]
      with Function15Generic[F]
      with Function16Generic[F]
      with Function17Generic[F]
      with Function18Generic[F]
      with Function19Generic[F]
      with Function20Generic[F]
      with Function21Generic[F]
      with Function22Generic[F]
      with Function23Generic[F]
      with Function24Generic[F]
      with Function25Generic[F]
      with Function26Generic[F]
      with Function27Generic[F]
      with Function28Generic[F]
      with Function29Generic[F]
      with Function30Generic[F]
      with Function31Generic[F]
      with Function32Generic[F]
      with Function33Generic[F]
      with Function34Generic[F]
      with Function35Generic[F]
      with Function36Generic[F]
      with Function37Generic[F]
      with Function38Generic[F]
      with Function39Generic[F]
      with Function40Generic[F]
      with Function41Generic[F]
      with Function42Generic[F]
      with Function43Generic[F]
      with Function44Generic[F]
      with Function45Generic[F]
      with Function46Generic[F]
      with Function47Generic[F]
      with Function48Generic[F]
      with Function49Generic[F]
      with Function50Generic[F] {
    self: Function2Generic[F] =>
  }

}
