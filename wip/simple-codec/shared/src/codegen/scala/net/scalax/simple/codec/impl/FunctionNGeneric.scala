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

  trait Function3GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function3[T1[_], T2[_], T3[_], TOut[_]](func: Function3Apply[T1, T2, T3, TOut])(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: InnerHZero
      val func2: Function2Apply[ZipType, T3, TOut] = new Function2Apply[ZipType, T3, TOut] {
        override def apply[X](param1: T1[X] :: T2[X] :: InnerHZero, i2: T3[X]): TOut[X] =
          func(param1.head, param1.tail.head, i2)
      }
      val func3: Function2Apply[T1, T2, ZipType] = new Function2Apply[T1, T2, ZipType] {
        override def apply[X](t1: T1[X], t2: T2[X]): T1[X] :: T2[X] :: InnerHZero = t1 :: t2 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function2(func3)(t1, t2)
      self.function2(func2)(temp2, t3)
    }
  }

  trait Function4GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function4[T1[_], T2[_], T3[_], T4[_], TOut[_]](func: Function4Apply[T1, T2, T3, T4, TOut])(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: InnerHZero
      val func2: Function2Apply[ZipType, T4, TOut] = new Function2Apply[ZipType, T4, TOut] {
        override def apply[X](param1: T1[X] :: T2[X] :: T3[X] :: InnerHZero, i2: T4[X]): TOut[X] =
          func(param1.head, param1.tail.head, param1.tail.tail.head, i2)
      }
      val func3: Function3Apply[T1, T2, T3, ZipType] = new Function3Apply[T1, T2, T3, ZipType] {
        override def apply[X](t1: T1[X], t2: T2[X], t3: T3[X]): T1[X] :: T2[X] :: T3[X] :: InnerHZero = t1 :: t2 :: t3 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function3(func3)(t1, t2, t3)
      self.function2(func2)(temp2, t4)
    }
  }

  trait Function5GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function5[T1[_], T2[_], T3[_], T4[_], T5[_], TOut[_]](func: Function5Apply[T1, T2, T3, T4, T5, TOut])(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: InnerHZero
      val func2: Function2Apply[ZipType, T5, TOut] = new Function2Apply[ZipType, T5, TOut] {
        override def apply[X](param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: InnerHZero, i2: T5[X]): TOut[X] =
          func(param1.head, param1.tail.head, param1.tail.tail.head, param1.tail.tail.tail.head, i2)
      }
      val func3: Function4Apply[T1, T2, T3, T4, ZipType] = new Function4Apply[T1, T2, T3, T4, ZipType] {
        override def apply[X](t1: T1[X], t2: T2[X], t3: T3[X], t4: T4[X]): T1[X] :: T2[X] :: T3[X] :: T4[X] :: InnerHZero =
          t1 :: t2 :: t3 :: t4 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function4(func3)(t1, t2, t3, t4)
      self.function2(func2)(temp2, t5)
    }
  }

  trait Function6GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function6[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], TOut[_]](func: Function6Apply[T1, T2, T3, T4, T5, T6, TOut])(
      t1: F[T1],
      t2: F[T2],
      t3: F[T3],
      t4: F[T4],
      t5: F[T5],
      t6: F[T6]
    ): F[TOut] = {
      type ZipType[U] = T1[U] :: T2[U] :: T3[U] :: T4[U] :: T5[U] :: InnerHZero
      val func2: Function2Apply[ZipType, T6, TOut] = new Function2Apply[ZipType, T6, TOut] {
        override def apply[X](param1: T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: InnerHZero, i2: T6[X]): TOut[X] =
          func(param1.head, param1.tail.head, param1.tail.tail.head, param1.tail.tail.tail.head, param1.tail.tail.tail.tail.head, i2)
      }
      val func3: Function5Apply[T1, T2, T3, T4, T5, ZipType] = new Function5Apply[T1, T2, T3, T4, T5, ZipType] {
        override def apply[X](t1: T1[X], t2: T2[X], t3: T3[X], t4: T4[X], t5: T5[X]): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] ::
          InnerHZero = t1 :: t2 :: t3 :: t4 :: t5 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function5(func3)(t1, t2, t3, t4, t5)
      self.function2(func2)(temp2, t6)
    }
  }

  trait Function7GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function7[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], TOut[_]](
      func: Function7Apply[T1, T2, T3, T4, T5, T6, T7, TOut]
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
      val func2: Function2Apply[ZipType, T7, TOut] = new Function2Apply[ZipType, T7, TOut] {
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
      val func3: Function6Apply[T1, T2, T3, T4, T5, T6, ZipType] = new Function6Apply[T1, T2, T3, T4, T5, T6, ZipType] {
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

  trait Function8GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function8[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], TOut[_]](
      func: Function8Apply[T1, T2, T3, T4, T5, T6, T7, T8, TOut]
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
      val func2: Function2Apply[ZipType, T8, TOut] = new Function2Apply[ZipType, T8, TOut] {
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
      val func3: Function7Apply[T1, T2, T3, T4, T5, T6, T7, ZipType] = new Function7Apply[T1, T2, T3, T4, T5, T6, T7, ZipType] {
        override def apply[X](
          t1: T1[X],
          t2: T2[X],
          t3: T3[X],
          t4: T4[X],
          t5: T5[X],
          t6: T6[X],
          t7: T7[X]
        ): T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: InnerHZero = t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function7(func3)(t1, t2, t3, t4, t5, t6, t7)
      self.function2(func2)(temp2, t8)
    }
  }

  trait Function9GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function9[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], TOut[_]](
      func: Function9Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, TOut]
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
      val func2: Function2Apply[ZipType, T9, TOut] = new Function2Apply[ZipType, T9, TOut] {
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
      val func3: Function8Apply[T1, T2, T3, T4, T5, T6, T7, T8, ZipType] = new Function8Apply[T1, T2, T3, T4, T5, T6, T7, T8, ZipType] {
        override def apply[X](t1: T1[X], t2: T2[X], t3: T3[X], t4: T4[X], t5: T5[X], t6: T6[X], t7: T7[X], t8: T8[X])
          : T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: InnerHZero =
          t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: InnerHZero
      }
      val temp2: F[ZipType] = self.function8(func3)(t1, t2, t3, t4, t5, t6, t7, t8)
      self.function2(func2)(temp2, t9)
    }
  }

  trait Function10GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function10[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], TOut[_]](
      func: Function10Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, TOut]
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
      val func2: Function2Apply[ZipType, T10, TOut] = new Function2Apply[ZipType, T10, TOut] {
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
      val func3: Function9Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, ZipType] =
        new Function9Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, ZipType] {
          override def apply[X](t1: T1[X], t2: T2[X], t3: T3[X], t4: T4[X], t5: T5[X], t6: T6[X], t7: T7[X], t8: T8[X], t9: T9[X])
            : T1[X] :: T2[X] :: T3[X] :: T4[X] :: T5[X] :: T6[X] :: T7[X] :: T8[X] :: T9[X] :: InnerHZero =
            t1 :: t2 :: t3 :: t4 :: t5 :: t6 :: t7 :: t8 :: t9 :: InnerHZero
        }
      val temp2: F[ZipType] = self.function9(func3)(t1, t2, t3, t4, t5, t6, t7, t8, t9)
      self.function2(func2)(temp2, t10)
    }
  }

  trait Function11GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function11[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], TOut[_]](
      func: Function11Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, TOut]
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
      val func2: Function2Apply[ZipType, T11, TOut] = new Function2Apply[ZipType, T11, TOut] {
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
      val func3: Function10Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, ZipType] =
        new Function10Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, ZipType] {
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

  trait Function12GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function12[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], TOut[_]](
      func: Function12Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, TOut]
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
      val func2: Function2Apply[ZipType, T12, TOut] = new Function2Apply[ZipType, T12, TOut] {
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
      val func3: Function11Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, ZipType] =
        new Function11Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, ZipType] {
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

  trait Function13GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function13[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], TOut[_]](
      func: Function13Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, TOut]
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
      val func2: Function2Apply[ZipType, T13, TOut] = new Function2Apply[ZipType, T13, TOut] {
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
      val func3: Function12Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, ZipType] =
        new Function12Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, ZipType] {
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

  trait Function14GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function14[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], TOut[_]](
      func: Function14Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, TOut]
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
      val func2: Function2Apply[ZipType, T14, TOut] = new Function2Apply[ZipType, T14, TOut] {
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
      val func3: Function13Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, ZipType] =
        new Function13Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, ZipType] {
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

  trait Function15GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function15[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], TOut[_]](func: Function15Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, TOut])(
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
      val func2: Function2Apply[ZipType, T15, TOut] = new Function2Apply[ZipType, T15, TOut] {
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
      val func3: Function14Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, ZipType] =
        new Function14Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, ZipType] {
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

  trait Function16GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function16[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], TOut[_]](func: Function16Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, TOut])(
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
      val func2: Function2Apply[ZipType, T16, TOut] = new Function2Apply[ZipType, T16, TOut] {
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
      val func3: Function15Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, ZipType] =
        new Function15Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, ZipType] {
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

  trait Function17GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function17[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], TOut[_]](func: Function17Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, TOut])(
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
      val func2: Function2Apply[ZipType, T17, TOut] = new Function2Apply[ZipType, T17, TOut] {
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
      val func3: Function16Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, ZipType] =
        new Function16Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, ZipType] {
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

  trait Function18GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function18[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], TOut[_]](
      func: Function18Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, TOut]
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
      val func2: Function2Apply[ZipType, T18, TOut] = new Function2Apply[ZipType, T18, TOut] {
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
      val func3: Function17Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, ZipType] =
        new Function17Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, ZipType] {
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

  trait Function19GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function19[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], TOut[_]](
      func: Function19Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, TOut]
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
      val func2: Function2Apply[ZipType, T19, TOut] = new Function2Apply[ZipType, T19, TOut] {
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
      val func3: Function18Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, ZipType] =
        new Function18Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, ZipType] {
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

  trait Function20GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function20[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], T20[_], TOut[_]](
      func: Function20Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, TOut]
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
      val func2: Function2Apply[ZipType, T20, TOut] = new Function2Apply[ZipType, T20, TOut] {
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
      val func3: Function19Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, ZipType] =
        new Function19Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, ZipType] {
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

  trait Function21GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function21[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], T20[_], T21[_], TOut[_]](
      func: Function21Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, TOut]
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
      val func2: Function2Apply[ZipType, T21, TOut] = new Function2Apply[ZipType, T21, TOut] {
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
      val func3: Function20Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, ZipType] =
        new Function20Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, ZipType] {
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

  trait Function22GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function22[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], TOut[_]](
      func: Function22Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, TOut]
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
      val func2: Function2Apply[ZipType, T22, TOut] = new Function2Apply[ZipType, T22, TOut] {
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
      val func3: Function21Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, ZipType] =
        new Function21Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, ZipType] {
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

  trait Function23GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function23[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], TOut[_]](
      func: Function23Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, TOut]
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
      val func2: Function2Apply[ZipType, T23, TOut] = new Function2Apply[ZipType, T23, TOut] {
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
      val func3
        : Function22Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, ZipType] =
        new Function22Apply[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, ZipType] {
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

  trait Function24GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function24[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], TOut[_]](
      func: Function24Apply[
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
      val func2: Function2Apply[ZipType, T24, TOut] = new Function2Apply[ZipType, T24, TOut] {
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
      val func3: Function23Apply[
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
      ] = new Function23Apply[
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

  trait Function25GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function25[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], TOut[_]](
      func: Function25Apply[
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
      val func2: Function2Apply[ZipType, T25, TOut] = new Function2Apply[ZipType, T25, TOut] {
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
      val func3: Function24Apply[
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
      ] = new Function24Apply[
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

  trait Function26GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function26[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], TOut[_]](
      func: Function26Apply[
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
      val func2: Function2Apply[ZipType, T26, TOut] = new Function2Apply[ZipType, T26, TOut] {
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
      val func3: Function25Apply[
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
      ] = new Function25Apply[
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

  trait Function27GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function27[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], TOut[_]](
      func: Function27Apply[
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
      val func2: Function2Apply[ZipType, T27, TOut] = new Function2Apply[ZipType, T27, TOut] {
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
      val func3: Function26Apply[
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
      ] = new Function26Apply[
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

  trait Function28GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function28[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], TOut[_]](
      func: Function28Apply[
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
      val func2: Function2Apply[ZipType, T28, TOut] = new Function2Apply[ZipType, T28, TOut] {
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
      val func3: Function27Apply[
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
      ] = new Function27Apply[
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

  trait Function29GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function29[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], TOut[_]](
      func: Function29Apply[
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
      val func2: Function2Apply[ZipType, T29, TOut] = new Function2Apply[ZipType, T29, TOut] {
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
      val func3: Function28Apply[
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
      ] = new Function28Apply[
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

  trait Function30GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function30[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], TOut[_]](
      func: Function30Apply[
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
      val func2: Function2Apply[ZipType, T30, TOut] = new Function2Apply[ZipType, T30, TOut] {
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
      val func3: Function29Apply[
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
      ] = new Function29Apply[
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

  trait Function31GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function31[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], TOut[
      _
    ]](
      func: Function31Apply[
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
      val func2: Function2Apply[ZipType, T31, TOut] = new Function2Apply[ZipType, T31, TOut] {
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
      val func3: Function30Apply[
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
      ] = new Function30Apply[
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

  trait Function32GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function32[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[
      _
    ], TOut[_]](
      func: Function32Apply[
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
      val func2: Function2Apply[ZipType, T32, TOut] = new Function2Apply[ZipType, T32, TOut] {
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
      val func3: Function31Apply[
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
      ] = new Function31Apply[
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

  trait Function33GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function33[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[
      _
    ], T33[_], TOut[_]](
      func: Function33Apply[
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
      val func2: Function2Apply[ZipType, T33, TOut] = new Function2Apply[ZipType, T33, TOut] {
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
      val func3: Function32Apply[
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
      ] = new Function32Apply[
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

  trait Function34GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function34[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[
      _
    ], T33[_], T34[_], TOut[_]](
      func: Function34Apply[
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
      val func2: Function2Apply[ZipType, T34, TOut] = new Function2Apply[ZipType, T34, TOut] {
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
      val func3: Function33Apply[
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
      ] = new Function33Apply[
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

  trait Function35GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function35[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[
      _
    ], T33[_], T34[_], T35[_], TOut[_]](
      func: Function35Apply[
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
      val func2: Function2Apply[ZipType, T35, TOut] = new Function2Apply[ZipType, T35, TOut] {
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
      val func3: Function34Apply[
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
      ] = new Function34Apply[
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

  trait Function36GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function36[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[
      _
    ], T33[_], T34[_], T35[_], T36[_], TOut[_]](
      func: Function36Apply[
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
      val func2: Function2Apply[ZipType, T36, TOut] = new Function2Apply[ZipType, T36, TOut] {
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
      val func3: Function35Apply[
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
      ] = new Function35Apply[
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

  trait Function37GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function37[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[
      _
    ], T33[_], T34[_], T35[_], T36[_], T37[_], TOut[_]](
      func: Function37Apply[
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
      val func2: Function2Apply[ZipType, T37, TOut] = new Function2Apply[ZipType, T37, TOut] {
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
      val func3: Function36Apply[
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
      ] = new Function36Apply[
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

  trait Function38GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function38[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[
      _
    ], T33[_], T34[_], T35[_], T36[_], T37[_], T38[_], TOut[_]](
      func: Function38Apply[
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
      val func2: Function2Apply[ZipType, T38, TOut] = new Function2Apply[ZipType, T38, TOut] {
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
      val func3: Function37Apply[
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
      ] = new Function37Apply[
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

  trait Function39GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function39[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[
      _
    ], T33[_], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], TOut[_]](
      func: Function39Apply[
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
      val func2: Function2Apply[ZipType, T39, TOut] = new Function2Apply[ZipType, T39, TOut] {
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
      val func3: Function38Apply[
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
      ] = new Function38Apply[
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

  trait Function40GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function40[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[
      _
    ], T33[_], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], TOut[_]](
      func: Function40Apply[
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
      val func2: Function2Apply[ZipType, T40, TOut] = new Function2Apply[ZipType, T40, TOut] {
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
      val func3: Function39Apply[
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
      ] = new Function39Apply[
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

  trait Function41GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function41[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[
      _
    ], T33[_], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], T41[_], TOut[_]](
      func: Function41Apply[
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
      val func2: Function2Apply[ZipType, T41, TOut] = new Function2Apply[ZipType, T41, TOut] {
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
      val func3: Function40Apply[
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
      ] = new Function40Apply[
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

  trait Function42GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function42[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[
      _
    ], T33[_], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], T41[_], T42[_], TOut[_]](
      func: Function42Apply[
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
      val func2: Function2Apply[ZipType, T42, TOut] = new Function2Apply[ZipType, T42, TOut] {
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
      val func3: Function41Apply[
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
      ] = new Function41Apply[
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

  trait Function43GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function43[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[
      _
    ], T33[_], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], T41[_], T42[_], T43[_], TOut[_]](
      func: Function43Apply[
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
      val func2: Function2Apply[ZipType, T43, TOut] = new Function2Apply[ZipType, T43, TOut] {
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
      val func3: Function42Apply[
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
      ] = new Function42Apply[
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

  trait Function44GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function44[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[
      _
    ], T33[_], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], T41[_], T42[_], T43[_], T44[_], TOut[_]](
      func: Function44Apply[
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
      val func2: Function2Apply[ZipType, T44, TOut] = new Function2Apply[ZipType, T44, TOut] {
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
      val func3: Function43Apply[
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
      ] = new Function43Apply[
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

  trait Function45GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function45[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[
      _
    ], T33[_], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], T41[_], T42[_], T43[_], T44[_], T45[_], TOut[_]](
      func: Function45Apply[
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
      val func2: Function2Apply[ZipType, T45, TOut] = new Function2Apply[ZipType, T45, TOut] {
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
      val func3: Function44Apply[
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
      ] = new Function44Apply[
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

  trait Function46GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function46[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[
      _
    ], T33[_], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], T41[_], T42[_], T43[_], T44[_], T45[_], T46[_], TOut[_]](
      func: Function46Apply[
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
      val func2: Function2Apply[ZipType, T46, TOut] = new Function2Apply[ZipType, T46, TOut] {
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
      val func3: Function45Apply[
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
      ] = new Function45Apply[
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

  trait Function47GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function47[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[
      _
    ], T33[_], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], T41[_], T42[_], T43[_], T44[_], T45[_], T46[_], T47[_], TOut[_]](
      func: Function47Apply[
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
      val func2: Function2Apply[ZipType, T47, TOut] = new Function2Apply[ZipType, T47, TOut] {
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
      val func3: Function46Apply[
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
      ] = new Function46Apply[
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

  trait Function48GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function48[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[
      _
    ], T33[_], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], T41[_], T42[_], T43[_], T44[_], T45[_], T46[_], T47[_], T48[_], TOut[
      _
    ]](
      func: Function48Apply[
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
      val func2: Function2Apply[ZipType, T48, TOut] = new Function2Apply[ZipType, T48, TOut] {
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
      val func3: Function47Apply[
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
      ] = new Function47Apply[
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

  trait Function49GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function49[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[
      _
    ], T33[_], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], T41[_], T42[_], T43[_], T44[_], T45[_], T46[_], T47[_], T48[_], T49[
      _
    ], TOut[_]](
      func: Function49Apply[
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
      val func2: Function2Apply[ZipType, T49, TOut] = new Function2Apply[ZipType, T49, TOut] {
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
      val func3: Function48Apply[
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
      ] = new Function48Apply[
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

  trait Function50GenericImpl[F[_[_]]] extends Function50Generic[F] {
    self =>

    override def function50[T1[_], T2[_], T3[_], T4[_], T5[_], T6[_], T7[_], T8[_], T9[_], T10[_], T11[_], T12[_], T13[_], T14[_], T15[
      _
    ], T16[_], T17[_], T18[_], T19[_], T20[_], T21[_], T22[_], T23[_], T24[_], T25[_], T26[_], T27[_], T28[_], T29[_], T30[_], T31[_], T32[
      _
    ], T33[_], T34[_], T35[_], T36[_], T37[_], T38[_], T39[_], T40[_], T41[_], T42[_], T43[_], T44[_], T45[_], T46[_], T47[_], T48[_], T49[
      _
    ], T50[_], TOut[_]](
      func: Function50Apply[
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
      val func2: Function2Apply[ZipType, T50, TOut] = new Function2Apply[ZipType, T50, TOut] {
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
      val func3: Function49Apply[
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
      ] = new Function49Apply[
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

  trait FunctionNGenericSumImpl[F[_[_]]]
      extends Function50Generic[F]
      with impl.Function3GenericImpl[F]
      with impl.Function4GenericImpl[F]
      with impl.Function5GenericImpl[F]
      with impl.Function6GenericImpl[F]
      with impl.Function7GenericImpl[F]
      with impl.Function8GenericImpl[F]
      with impl.Function9GenericImpl[F]
      with impl.Function10GenericImpl[F]
      with impl.Function11GenericImpl[F]
      with impl.Function12GenericImpl[F]
      with impl.Function13GenericImpl[F]
      with impl.Function14GenericImpl[F]
      with impl.Function15GenericImpl[F]
      with impl.Function16GenericImpl[F]
      with impl.Function17GenericImpl[F]
      with impl.Function18GenericImpl[F]
      with impl.Function19GenericImpl[F]
      with impl.Function20GenericImpl[F]
      with impl.Function21GenericImpl[F]
      with impl.Function22GenericImpl[F]
      with impl.Function23GenericImpl[F]
      with impl.Function24GenericImpl[F]
      with impl.Function25GenericImpl[F]
      with impl.Function26GenericImpl[F]
      with impl.Function27GenericImpl[F]
      with impl.Function28GenericImpl[F]
      with impl.Function29GenericImpl[F]
      with impl.Function30GenericImpl[F]
      with impl.Function31GenericImpl[F]
      with impl.Function32GenericImpl[F]
      with impl.Function33GenericImpl[F]
      with impl.Function34GenericImpl[F]
      with impl.Function35GenericImpl[F]
      with impl.Function36GenericImpl[F]
      with impl.Function37GenericImpl[F]
      with impl.Function38GenericImpl[F]
      with impl.Function39GenericImpl[F]
      with impl.Function40GenericImpl[F]
      with impl.Function41GenericImpl[F]
      with impl.Function42GenericImpl[F]
      with impl.Function43GenericImpl[F]
      with impl.Function44GenericImpl[F]
      with impl.Function45GenericImpl[F]
      with impl.Function46GenericImpl[F]
      with impl.Function47GenericImpl[F]
      with impl.Function48GenericImpl[F]
      with impl.Function49GenericImpl[F]
      with impl.Function50GenericImpl[F]

}
