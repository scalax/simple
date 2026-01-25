
    package net.scalax.simple.adt
    package instance
    package support

    import AppendTailHelper2._

    trait ADTFoldApplyImpl1[Target0, T1] {
      FoldApplySelf =>

      def fold1[TargetOther0 >: Target0](param1: T1 => TargetOther0): TargetOther0
    }

    class CoProduct1[T1](foldImpl: AdtCoProduct.Use.One[T1])
      extends AdtCoProduct.Use.One[T1]
      with helper1.CoProduct1Helper[T1] {
      FoldApplySelf =>

      override def _foldCoProduct[TU](hFunc: T1 => TU, tFunc: AdtCoProduct.Use.One[T1] => TU): TU =
        FoldApplySelf.foldImpl._foldCoProduct[TU](hFunc, tFunc)

      def drop1: T1 = AdtCoProduct.Use.One.unapplyImpl(foldImpl)

      def map1[U1](func: T1 => U1): CoProduct1[U1] = {
        val valueR = func(AdtCoProduct.Use.One.unapplyImpl(foldImpl))
        val valueR2 = AdtCoProduct.Use.One.left[U1](valueR)
        new CoProduct1[U1](valueR2)
      }

      def tail: CoProduct1[T1] = FoldApplySelf

      @inline def fold[TargetOther0](param1: T1 => TargetOther0): TargetOther0 = {
        val v1 = FoldApplySelf.map1(param1)
        AdtCoProduct.Use.One.unapplyImpl(v1)
      }

      def fold1[TargetOther0](param1: T1 => TargetOther0): TargetOther0 = FoldApplySelf.fold(param1)

    }

    object CoProduct1 {
      //
    }

    
      trait ADTFoldApplyImpl2[
        Target0,
        T1,T2
      ] {
        FoldApplySelf =>

        def fold2[TargetOther2 >: Target0](param1: T1 => TargetOther2):
          ADTFoldApplyImpl1[TargetOther2,T2]
      }

      class CoProduct2[T1,T2](foldImpl: AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.One[T2]])
        extends AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.One[T2]]
        with helper1.CoProduct2Helper[T1,T2] {
        FoldApplySelf =>

        override def _foldCoProduct[Re](h: T1 => Re, t: AdtCoProduct.Use.One[T2] => Re): Re = foldImpl._foldCoProduct[Re](h, t)

        def drop1: Either[
          T1,
          CoProduct1[T2]
        ] = foldImpl._foldCoProduct[Either[T1, CoProduct1[T2]]](
          (i1: T1) => Left(i1),
          (i1: AdtCoProduct.Use.One[T2]) => Right(new CoProduct1[T2](i1))
        )

        def map1[U1](func: T1 => U1): CoProduct2[U1, T2] = {
          val valueR = AppendTail3.mapHead(foldImpl)(func)
          new CoProduct2[U1, T2](valueR)
        }

        def tail: CoProduct2[T2, T1] = {
          val valueR = AppendTailHelper2.appendByDefault(foldImpl)
          new CoProduct2[T2, T1](valueR)
        }

        @inline def fold[Target](param1: T1 => Target,param2: T2 => Target): Target = {
          val toTarget = AppendTail7[Target]
          val func = toTarget.ToTarget.take(AdtHList.UsePositive.append(param1: T1 => Target, AdtHList.UsePositive.append(param2: T2 => Target, AdtHList.zero)))
          func(foldImpl)
        }

        def fold2[TargetOther2](param1: T1 => TargetOther2):
          ADTFoldApplyImpl1[TargetOther2,T2] = 
        new ADTFoldApplyImpl1[TargetOther2, T2] {
          override def fold1[TargetOther1 >: TargetOther2](param2: T2 => TargetOther1): TargetOther1 = {
            FoldApplySelf.fold(param1,param2)
          }
        }
      

      }

      object CoProduct2 {
        //
      }
    

      trait ADTFoldApplyImpl3[
        Target0,
        T1,T2,T3
      ] {
        FoldApplySelf =>

        def fold3[TargetOther3 >: Target0](param1: T1 => TargetOther3):
          ADTFoldApplyImpl2[TargetOther3,T2,T3]
      }

      class CoProduct3[T1,T2,T3](foldImpl: AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.One[T3]]])
        extends AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.One[T3]]]
        with helper1.CoProduct3Helper[T1,T2,T3] {
        FoldApplySelf =>

        override def _foldCoProduct[Re](h: T1 => Re, t: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.One[T3]] => Re): Re = foldImpl._foldCoProduct[Re](h, t)

        def drop1: Either[
          T1,
          CoProduct2[T2,T3]
        ] = foldImpl._foldCoProduct[Either[T1, CoProduct2[T2,T3]]](
          (i1: T1) => Left(i1),
          (i1: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.One[T3]]) => Right(new CoProduct2[T2,T3](i1))
        )

        def map1[U1](func: T1 => U1): CoProduct3[U1, T2,T3] = {
          val valueR = AppendTail3.mapHead(foldImpl)(func)
          new CoProduct3[U1, T2,T3](valueR)
        }

        def tail: CoProduct3[T2,T3, T1] = {
          val valueR = AppendTailHelper2.appendByDefault(foldImpl)
          new CoProduct3[T2,T3, T1](valueR)
        }

        @inline def fold[Target](param1: T1 => Target,param2: T2 => Target,param3: T3 => Target): Target = {
          val toTarget = AppendTail7[Target]
          val func = toTarget.ToTarget.take(AdtHList.UsePositive.append(param1: T1 => Target, AdtHList.UsePositive.append(param2: T2 => Target, AdtHList.UsePositive.append(param3: T3 => Target, AdtHList.zero))))
          func(foldImpl)
        }

        def fold3[TargetOther3](param1: T1 => TargetOther3):
          ADTFoldApplyImpl2[TargetOther3,T2,T3] = 
        new ADTFoldApplyImpl2[TargetOther3,T2,T3] {
          override def fold2[TargetOther2 >: TargetOther3](
            param2: T2 => TargetOther2
          ): ADTFoldApplyImpl1[TargetOther2,T3] = 
        new ADTFoldApplyImpl1[TargetOther2, T3] {
          override def fold1[TargetOther1 >: TargetOther2](param3: T3 => TargetOther1): TargetOther1 = {
            FoldApplySelf.fold(param1,param2,param3)
          }
        }
      
        }
      

      }

      object CoProduct3 {
        //
      }
    

      trait ADTFoldApplyImpl4[
        Target0,
        T1,T2,T3,T4
      ] {
        FoldApplySelf =>

        def fold4[TargetOther4 >: Target0](param1: T1 => TargetOther4):
          ADTFoldApplyImpl3[TargetOther4,T2,T3,T4]
      }

      class CoProduct4[T1,T2,T3,T4](foldImpl: AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.One[T4]]]])
        extends AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.One[T4]]]]
        with helper1.CoProduct4Helper[T1,T2,T3,T4] {
        FoldApplySelf =>

        override def _foldCoProduct[Re](h: T1 => Re, t: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.One[T4]]] => Re): Re = foldImpl._foldCoProduct[Re](h, t)

        def drop1: Either[
          T1,
          CoProduct3[T2,T3,T4]
        ] = foldImpl._foldCoProduct[Either[T1, CoProduct3[T2,T3,T4]]](
          (i1: T1) => Left(i1),
          (i1: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.One[T4]]]) => Right(new CoProduct3[T2,T3,T4](i1))
        )

        def map1[U1](func: T1 => U1): CoProduct4[U1, T2,T3,T4] = {
          val valueR = AppendTail3.mapHead(foldImpl)(func)
          new CoProduct4[U1, T2,T3,T4](valueR)
        }

        def tail: CoProduct4[T2,T3,T4, T1] = {
          val valueR = AppendTailHelper2.appendByDefault(foldImpl)
          new CoProduct4[T2,T3,T4, T1](valueR)
        }

        @inline def fold[Target](param1: T1 => Target,param2: T2 => Target,param3: T3 => Target,param4: T4 => Target): Target = {
          val toTarget = AppendTail7[Target]
          val func = toTarget.ToTarget.take(AdtHList.UsePositive.append(param1: T1 => Target, AdtHList.UsePositive.append(param2: T2 => Target, AdtHList.UsePositive.append(param3: T3 => Target, AdtHList.UsePositive.append(param4: T4 => Target, AdtHList.zero)))))
          func(foldImpl)
        }

        def fold4[TargetOther4](param1: T1 => TargetOther4):
          ADTFoldApplyImpl3[TargetOther4,T2,T3,T4] = 
        new ADTFoldApplyImpl3[TargetOther4,T2,T3,T4] {
          override def fold3[TargetOther3 >: TargetOther4](
            param2: T2 => TargetOther3
          ): ADTFoldApplyImpl2[TargetOther3,T3,T4] = 
        new ADTFoldApplyImpl2[TargetOther3,T3,T4] {
          override def fold2[TargetOther2 >: TargetOther3](
            param3: T3 => TargetOther2
          ): ADTFoldApplyImpl1[TargetOther2,T4] = 
        new ADTFoldApplyImpl1[TargetOther2, T4] {
          override def fold1[TargetOther1 >: TargetOther2](param4: T4 => TargetOther1): TargetOther1 = {
            FoldApplySelf.fold(param1,param2,param3,param4)
          }
        }
      
        }
      
        }
      

      }

      object CoProduct4 {
        //
      }
    

      trait ADTFoldApplyImpl5[
        Target0,
        T1,T2,T3,T4,T5
      ] {
        FoldApplySelf =>

        def fold5[TargetOther5 >: Target0](param1: T1 => TargetOther5):
          ADTFoldApplyImpl4[TargetOther5,T2,T3,T4,T5]
      }

      class CoProduct5[T1,T2,T3,T4,T5](foldImpl: AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.One[T5]]]]])
        extends AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.One[T5]]]]]
        with helper1.CoProduct5Helper[T1,T2,T3,T4,T5] {
        FoldApplySelf =>

        override def _foldCoProduct[Re](h: T1 => Re, t: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.One[T5]]]] => Re): Re = foldImpl._foldCoProduct[Re](h, t)

        def drop1: Either[
          T1,
          CoProduct4[T2,T3,T4,T5]
        ] = foldImpl._foldCoProduct[Either[T1, CoProduct4[T2,T3,T4,T5]]](
          (i1: T1) => Left(i1),
          (i1: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.One[T5]]]]) => Right(new CoProduct4[T2,T3,T4,T5](i1))
        )

        def map1[U1](func: T1 => U1): CoProduct5[U1, T2,T3,T4,T5] = {
          val valueR = AppendTail3.mapHead(foldImpl)(func)
          new CoProduct5[U1, T2,T3,T4,T5](valueR)
        }

        def tail: CoProduct5[T2,T3,T4,T5, T1] = {
          val valueR = AppendTailHelper2.appendByDefault(foldImpl)
          new CoProduct5[T2,T3,T4,T5, T1](valueR)
        }

        @inline def fold[Target](param1: T1 => Target,param2: T2 => Target,param3: T3 => Target,param4: T4 => Target,param5: T5 => Target): Target = {
          val toTarget = AppendTail7[Target]
          val func = toTarget.ToTarget.take(AdtHList.UsePositive.append(param1: T1 => Target, AdtHList.UsePositive.append(param2: T2 => Target, AdtHList.UsePositive.append(param3: T3 => Target, AdtHList.UsePositive.append(param4: T4 => Target, AdtHList.UsePositive.append(param5: T5 => Target, AdtHList.zero))))))
          func(foldImpl)
        }

        def fold5[TargetOther5](param1: T1 => TargetOther5):
          ADTFoldApplyImpl4[TargetOther5,T2,T3,T4,T5] = 
        new ADTFoldApplyImpl4[TargetOther5,T2,T3,T4,T5] {
          override def fold4[TargetOther4 >: TargetOther5](
            param2: T2 => TargetOther4
          ): ADTFoldApplyImpl3[TargetOther4,T3,T4,T5] = 
        new ADTFoldApplyImpl3[TargetOther4,T3,T4,T5] {
          override def fold3[TargetOther3 >: TargetOther4](
            param3: T3 => TargetOther3
          ): ADTFoldApplyImpl2[TargetOther3,T4,T5] = 
        new ADTFoldApplyImpl2[TargetOther3,T4,T5] {
          override def fold2[TargetOther2 >: TargetOther3](
            param4: T4 => TargetOther2
          ): ADTFoldApplyImpl1[TargetOther2,T5] = 
        new ADTFoldApplyImpl1[TargetOther2, T5] {
          override def fold1[TargetOther1 >: TargetOther2](param5: T5 => TargetOther1): TargetOther1 = {
            FoldApplySelf.fold(param1,param2,param3,param4,param5)
          }
        }
      
        }
      
        }
      
        }
      

      }

      object CoProduct5 {
        //
      }
    

      trait ADTFoldApplyImpl6[
        Target0,
        T1,T2,T3,T4,T5,T6
      ] {
        FoldApplySelf =>

        def fold6[TargetOther6 >: Target0](param1: T1 => TargetOther6):
          ADTFoldApplyImpl5[TargetOther6,T2,T3,T4,T5,T6]
      }

      class CoProduct6[T1,T2,T3,T4,T5,T6](foldImpl: AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.One[T6]]]]]])
        extends AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.One[T6]]]]]]
        with helper1.CoProduct6Helper[T1,T2,T3,T4,T5,T6] {
        FoldApplySelf =>

        override def _foldCoProduct[Re](h: T1 => Re, t: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.One[T6]]]]] => Re): Re = foldImpl._foldCoProduct[Re](h, t)

        def drop1: Either[
          T1,
          CoProduct5[T2,T3,T4,T5,T6]
        ] = foldImpl._foldCoProduct[Either[T1, CoProduct5[T2,T3,T4,T5,T6]]](
          (i1: T1) => Left(i1),
          (i1: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.One[T6]]]]]) => Right(new CoProduct5[T2,T3,T4,T5,T6](i1))
        )

        def map1[U1](func: T1 => U1): CoProduct6[U1, T2,T3,T4,T5,T6] = {
          val valueR = AppendTail3.mapHead(foldImpl)(func)
          new CoProduct6[U1, T2,T3,T4,T5,T6](valueR)
        }

        def tail: CoProduct6[T2,T3,T4,T5,T6, T1] = {
          val valueR = AppendTailHelper2.appendByDefault(foldImpl)
          new CoProduct6[T2,T3,T4,T5,T6, T1](valueR)
        }

        @inline def fold[Target](param1: T1 => Target,param2: T2 => Target,param3: T3 => Target,param4: T4 => Target,param5: T5 => Target,param6: T6 => Target): Target = {
          val toTarget = AppendTail7[Target]
          val func = toTarget.ToTarget.take(AdtHList.UsePositive.append(param1: T1 => Target, AdtHList.UsePositive.append(param2: T2 => Target, AdtHList.UsePositive.append(param3: T3 => Target, AdtHList.UsePositive.append(param4: T4 => Target, AdtHList.UsePositive.append(param5: T5 => Target, AdtHList.UsePositive.append(param6: T6 => Target, AdtHList.zero)))))))
          func(foldImpl)
        }

        def fold6[TargetOther6](param1: T1 => TargetOther6):
          ADTFoldApplyImpl5[TargetOther6,T2,T3,T4,T5,T6] = 
        new ADTFoldApplyImpl5[TargetOther6,T2,T3,T4,T5,T6] {
          override def fold5[TargetOther5 >: TargetOther6](
            param2: T2 => TargetOther5
          ): ADTFoldApplyImpl4[TargetOther5,T3,T4,T5,T6] = 
        new ADTFoldApplyImpl4[TargetOther5,T3,T4,T5,T6] {
          override def fold4[TargetOther4 >: TargetOther5](
            param3: T3 => TargetOther4
          ): ADTFoldApplyImpl3[TargetOther4,T4,T5,T6] = 
        new ADTFoldApplyImpl3[TargetOther4,T4,T5,T6] {
          override def fold3[TargetOther3 >: TargetOther4](
            param4: T4 => TargetOther3
          ): ADTFoldApplyImpl2[TargetOther3,T5,T6] = 
        new ADTFoldApplyImpl2[TargetOther3,T5,T6] {
          override def fold2[TargetOther2 >: TargetOther3](
            param5: T5 => TargetOther2
          ): ADTFoldApplyImpl1[TargetOther2,T6] = 
        new ADTFoldApplyImpl1[TargetOther2, T6] {
          override def fold1[TargetOther1 >: TargetOther2](param6: T6 => TargetOther1): TargetOther1 = {
            FoldApplySelf.fold(param1,param2,param3,param4,param5,param6)
          }
        }
      
        }
      
        }
      
        }
      
        }
      

      }

      object CoProduct6 {
        //
      }
    

      trait ADTFoldApplyImpl7[
        Target0,
        T1,T2,T3,T4,T5,T6,T7
      ] {
        FoldApplySelf =>

        def fold7[TargetOther7 >: Target0](param1: T1 => TargetOther7):
          ADTFoldApplyImpl6[TargetOther7,T2,T3,T4,T5,T6,T7]
      }

      class CoProduct7[T1,T2,T3,T4,T5,T6,T7](foldImpl: AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.One[T7]]]]]]])
        extends AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.One[T7]]]]]]]
        with helper1.CoProduct7Helper[T1,T2,T3,T4,T5,T6,T7] {
        FoldApplySelf =>

        override def _foldCoProduct[Re](h: T1 => Re, t: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.One[T7]]]]]] => Re): Re = foldImpl._foldCoProduct[Re](h, t)

        def drop1: Either[
          T1,
          CoProduct6[T2,T3,T4,T5,T6,T7]
        ] = foldImpl._foldCoProduct[Either[T1, CoProduct6[T2,T3,T4,T5,T6,T7]]](
          (i1: T1) => Left(i1),
          (i1: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.One[T7]]]]]]) => Right(new CoProduct6[T2,T3,T4,T5,T6,T7](i1))
        )

        def map1[U1](func: T1 => U1): CoProduct7[U1, T2,T3,T4,T5,T6,T7] = {
          val valueR = AppendTail3.mapHead(foldImpl)(func)
          new CoProduct7[U1, T2,T3,T4,T5,T6,T7](valueR)
        }

        def tail: CoProduct7[T2,T3,T4,T5,T6,T7, T1] = {
          val valueR = AppendTailHelper2.appendByDefault(foldImpl)
          new CoProduct7[T2,T3,T4,T5,T6,T7, T1](valueR)
        }

        @inline def fold[Target](param1: T1 => Target,param2: T2 => Target,param3: T3 => Target,param4: T4 => Target,param5: T5 => Target,param6: T6 => Target,param7: T7 => Target): Target = {
          val toTarget = AppendTail7[Target]
          val func = toTarget.ToTarget.take(AdtHList.UsePositive.append(param1: T1 => Target, AdtHList.UsePositive.append(param2: T2 => Target, AdtHList.UsePositive.append(param3: T3 => Target, AdtHList.UsePositive.append(param4: T4 => Target, AdtHList.UsePositive.append(param5: T5 => Target, AdtHList.UsePositive.append(param6: T6 => Target, AdtHList.UsePositive.append(param7: T7 => Target, AdtHList.zero))))))))
          func(foldImpl)
        }

        def fold7[TargetOther7](param1: T1 => TargetOther7):
          ADTFoldApplyImpl6[TargetOther7,T2,T3,T4,T5,T6,T7] = 
        new ADTFoldApplyImpl6[TargetOther7,T2,T3,T4,T5,T6,T7] {
          override def fold6[TargetOther6 >: TargetOther7](
            param2: T2 => TargetOther6
          ): ADTFoldApplyImpl5[TargetOther6,T3,T4,T5,T6,T7] = 
        new ADTFoldApplyImpl5[TargetOther6,T3,T4,T5,T6,T7] {
          override def fold5[TargetOther5 >: TargetOther6](
            param3: T3 => TargetOther5
          ): ADTFoldApplyImpl4[TargetOther5,T4,T5,T6,T7] = 
        new ADTFoldApplyImpl4[TargetOther5,T4,T5,T6,T7] {
          override def fold4[TargetOther4 >: TargetOther5](
            param4: T4 => TargetOther4
          ): ADTFoldApplyImpl3[TargetOther4,T5,T6,T7] = 
        new ADTFoldApplyImpl3[TargetOther4,T5,T6,T7] {
          override def fold3[TargetOther3 >: TargetOther4](
            param5: T5 => TargetOther3
          ): ADTFoldApplyImpl2[TargetOther3,T6,T7] = 
        new ADTFoldApplyImpl2[TargetOther3,T6,T7] {
          override def fold2[TargetOther2 >: TargetOther3](
            param6: T6 => TargetOther2
          ): ADTFoldApplyImpl1[TargetOther2,T7] = 
        new ADTFoldApplyImpl1[TargetOther2, T7] {
          override def fold1[TargetOther1 >: TargetOther2](param7: T7 => TargetOther1): TargetOther1 = {
            FoldApplySelf.fold(param1,param2,param3,param4,param5,param6,param7)
          }
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      

      }

      object CoProduct7 {
        //
      }
    

      trait ADTFoldApplyImpl8[
        Target0,
        T1,T2,T3,T4,T5,T6,T7,T8
      ] {
        FoldApplySelf =>

        def fold8[TargetOther8 >: Target0](param1: T1 => TargetOther8):
          ADTFoldApplyImpl7[TargetOther8,T2,T3,T4,T5,T6,T7,T8]
      }

      class CoProduct8[T1,T2,T3,T4,T5,T6,T7,T8](foldImpl: AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.One[T8]]]]]]]])
        extends AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.One[T8]]]]]]]]
        with helper1.CoProduct8Helper[T1,T2,T3,T4,T5,T6,T7,T8] {
        FoldApplySelf =>

        override def _foldCoProduct[Re](h: T1 => Re, t: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.One[T8]]]]]]] => Re): Re = foldImpl._foldCoProduct[Re](h, t)

        def drop1: Either[
          T1,
          CoProduct7[T2,T3,T4,T5,T6,T7,T8]
        ] = foldImpl._foldCoProduct[Either[T1, CoProduct7[T2,T3,T4,T5,T6,T7,T8]]](
          (i1: T1) => Left(i1),
          (i1: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.One[T8]]]]]]]) => Right(new CoProduct7[T2,T3,T4,T5,T6,T7,T8](i1))
        )

        def map1[U1](func: T1 => U1): CoProduct8[U1, T2,T3,T4,T5,T6,T7,T8] = {
          val valueR = AppendTail3.mapHead(foldImpl)(func)
          new CoProduct8[U1, T2,T3,T4,T5,T6,T7,T8](valueR)
        }

        def tail: CoProduct8[T2,T3,T4,T5,T6,T7,T8, T1] = {
          val valueR = AppendTailHelper2.appendByDefault(foldImpl)
          new CoProduct8[T2,T3,T4,T5,T6,T7,T8, T1](valueR)
        }

        @inline def fold[Target](param1: T1 => Target,param2: T2 => Target,param3: T3 => Target,param4: T4 => Target,param5: T5 => Target,param6: T6 => Target,param7: T7 => Target,param8: T8 => Target): Target = {
          val toTarget = AppendTail7[Target]
          val func = toTarget.ToTarget.take(AdtHList.UsePositive.append(param1: T1 => Target, AdtHList.UsePositive.append(param2: T2 => Target, AdtHList.UsePositive.append(param3: T3 => Target, AdtHList.UsePositive.append(param4: T4 => Target, AdtHList.UsePositive.append(param5: T5 => Target, AdtHList.UsePositive.append(param6: T6 => Target, AdtHList.UsePositive.append(param7: T7 => Target, AdtHList.UsePositive.append(param8: T8 => Target, AdtHList.zero)))))))))
          func(foldImpl)
        }

        def fold8[TargetOther8](param1: T1 => TargetOther8):
          ADTFoldApplyImpl7[TargetOther8,T2,T3,T4,T5,T6,T7,T8] = 
        new ADTFoldApplyImpl7[TargetOther8,T2,T3,T4,T5,T6,T7,T8] {
          override def fold7[TargetOther7 >: TargetOther8](
            param2: T2 => TargetOther7
          ): ADTFoldApplyImpl6[TargetOther7,T3,T4,T5,T6,T7,T8] = 
        new ADTFoldApplyImpl6[TargetOther7,T3,T4,T5,T6,T7,T8] {
          override def fold6[TargetOther6 >: TargetOther7](
            param3: T3 => TargetOther6
          ): ADTFoldApplyImpl5[TargetOther6,T4,T5,T6,T7,T8] = 
        new ADTFoldApplyImpl5[TargetOther6,T4,T5,T6,T7,T8] {
          override def fold5[TargetOther5 >: TargetOther6](
            param4: T4 => TargetOther5
          ): ADTFoldApplyImpl4[TargetOther5,T5,T6,T7,T8] = 
        new ADTFoldApplyImpl4[TargetOther5,T5,T6,T7,T8] {
          override def fold4[TargetOther4 >: TargetOther5](
            param5: T5 => TargetOther4
          ): ADTFoldApplyImpl3[TargetOther4,T6,T7,T8] = 
        new ADTFoldApplyImpl3[TargetOther4,T6,T7,T8] {
          override def fold3[TargetOther3 >: TargetOther4](
            param6: T6 => TargetOther3
          ): ADTFoldApplyImpl2[TargetOther3,T7,T8] = 
        new ADTFoldApplyImpl2[TargetOther3,T7,T8] {
          override def fold2[TargetOther2 >: TargetOther3](
            param7: T7 => TargetOther2
          ): ADTFoldApplyImpl1[TargetOther2,T8] = 
        new ADTFoldApplyImpl1[TargetOther2, T8] {
          override def fold1[TargetOther1 >: TargetOther2](param8: T8 => TargetOther1): TargetOther1 = {
            FoldApplySelf.fold(param1,param2,param3,param4,param5,param6,param7,param8)
          }
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      

      }

      object CoProduct8 {
        //
      }
    

      trait ADTFoldApplyImpl9[
        Target0,
        T1,T2,T3,T4,T5,T6,T7,T8,T9
      ] {
        FoldApplySelf =>

        def fold9[TargetOther9 >: Target0](param1: T1 => TargetOther9):
          ADTFoldApplyImpl8[TargetOther9,T2,T3,T4,T5,T6,T7,T8,T9]
      }

      class CoProduct9[T1,T2,T3,T4,T5,T6,T7,T8,T9](foldImpl: AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.One[T9]]]]]]]]])
        extends AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.One[T9]]]]]]]]]
        with helper1.CoProduct9Helper[T1,T2,T3,T4,T5,T6,T7,T8,T9] {
        FoldApplySelf =>

        override def _foldCoProduct[Re](h: T1 => Re, t: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.One[T9]]]]]]]] => Re): Re = foldImpl._foldCoProduct[Re](h, t)

        def drop1: Either[
          T1,
          CoProduct8[T2,T3,T4,T5,T6,T7,T8,T9]
        ] = foldImpl._foldCoProduct[Either[T1, CoProduct8[T2,T3,T4,T5,T6,T7,T8,T9]]](
          (i1: T1) => Left(i1),
          (i1: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.One[T9]]]]]]]]) => Right(new CoProduct8[T2,T3,T4,T5,T6,T7,T8,T9](i1))
        )

        def map1[U1](func: T1 => U1): CoProduct9[U1, T2,T3,T4,T5,T6,T7,T8,T9] = {
          val valueR = AppendTail3.mapHead(foldImpl)(func)
          new CoProduct9[U1, T2,T3,T4,T5,T6,T7,T8,T9](valueR)
        }

        def tail: CoProduct9[T2,T3,T4,T5,T6,T7,T8,T9, T1] = {
          val valueR = AppendTailHelper2.appendByDefault(foldImpl)
          new CoProduct9[T2,T3,T4,T5,T6,T7,T8,T9, T1](valueR)
        }

        @inline def fold[Target](param1: T1 => Target,param2: T2 => Target,param3: T3 => Target,param4: T4 => Target,param5: T5 => Target,param6: T6 => Target,param7: T7 => Target,param8: T8 => Target,param9: T9 => Target): Target = {
          val toTarget = AppendTail7[Target]
          val func = toTarget.ToTarget.take(AdtHList.UsePositive.append(param1: T1 => Target, AdtHList.UsePositive.append(param2: T2 => Target, AdtHList.UsePositive.append(param3: T3 => Target, AdtHList.UsePositive.append(param4: T4 => Target, AdtHList.UsePositive.append(param5: T5 => Target, AdtHList.UsePositive.append(param6: T6 => Target, AdtHList.UsePositive.append(param7: T7 => Target, AdtHList.UsePositive.append(param8: T8 => Target, AdtHList.UsePositive.append(param9: T9 => Target, AdtHList.zero))))))))))
          func(foldImpl)
        }

        def fold9[TargetOther9](param1: T1 => TargetOther9):
          ADTFoldApplyImpl8[TargetOther9,T2,T3,T4,T5,T6,T7,T8,T9] = 
        new ADTFoldApplyImpl8[TargetOther9,T2,T3,T4,T5,T6,T7,T8,T9] {
          override def fold8[TargetOther8 >: TargetOther9](
            param2: T2 => TargetOther8
          ): ADTFoldApplyImpl7[TargetOther8,T3,T4,T5,T6,T7,T8,T9] = 
        new ADTFoldApplyImpl7[TargetOther8,T3,T4,T5,T6,T7,T8,T9] {
          override def fold7[TargetOther7 >: TargetOther8](
            param3: T3 => TargetOther7
          ): ADTFoldApplyImpl6[TargetOther7,T4,T5,T6,T7,T8,T9] = 
        new ADTFoldApplyImpl6[TargetOther7,T4,T5,T6,T7,T8,T9] {
          override def fold6[TargetOther6 >: TargetOther7](
            param4: T4 => TargetOther6
          ): ADTFoldApplyImpl5[TargetOther6,T5,T6,T7,T8,T9] = 
        new ADTFoldApplyImpl5[TargetOther6,T5,T6,T7,T8,T9] {
          override def fold5[TargetOther5 >: TargetOther6](
            param5: T5 => TargetOther5
          ): ADTFoldApplyImpl4[TargetOther5,T6,T7,T8,T9] = 
        new ADTFoldApplyImpl4[TargetOther5,T6,T7,T8,T9] {
          override def fold4[TargetOther4 >: TargetOther5](
            param6: T6 => TargetOther4
          ): ADTFoldApplyImpl3[TargetOther4,T7,T8,T9] = 
        new ADTFoldApplyImpl3[TargetOther4,T7,T8,T9] {
          override def fold3[TargetOther3 >: TargetOther4](
            param7: T7 => TargetOther3
          ): ADTFoldApplyImpl2[TargetOther3,T8,T9] = 
        new ADTFoldApplyImpl2[TargetOther3,T8,T9] {
          override def fold2[TargetOther2 >: TargetOther3](
            param8: T8 => TargetOther2
          ): ADTFoldApplyImpl1[TargetOther2,T9] = 
        new ADTFoldApplyImpl1[TargetOther2, T9] {
          override def fold1[TargetOther1 >: TargetOther2](param9: T9 => TargetOther1): TargetOther1 = {
            FoldApplySelf.fold(param1,param2,param3,param4,param5,param6,param7,param8,param9)
          }
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      

      }

      object CoProduct9 {
        //
      }
    

      trait ADTFoldApplyImpl10[
        Target0,
        T1,T2,T3,T4,T5,T6,T7,T8,T9,T10
      ] {
        FoldApplySelf =>

        def fold10[TargetOther10 >: Target0](param1: T1 => TargetOther10):
          ADTFoldApplyImpl9[TargetOther10,T2,T3,T4,T5,T6,T7,T8,T9,T10]
      }

      class CoProduct10[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10](foldImpl: AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.One[T10]]]]]]]]]])
        extends AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.One[T10]]]]]]]]]]
        with helper1.CoProduct10Helper[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10] {
        FoldApplySelf =>

        override def _foldCoProduct[Re](h: T1 => Re, t: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.One[T10]]]]]]]]] => Re): Re = foldImpl._foldCoProduct[Re](h, t)

        def drop1: Either[
          T1,
          CoProduct9[T2,T3,T4,T5,T6,T7,T8,T9,T10]
        ] = foldImpl._foldCoProduct[Either[T1, CoProduct9[T2,T3,T4,T5,T6,T7,T8,T9,T10]]](
          (i1: T1) => Left(i1),
          (i1: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.One[T10]]]]]]]]]) => Right(new CoProduct9[T2,T3,T4,T5,T6,T7,T8,T9,T10](i1))
        )

        def map1[U1](func: T1 => U1): CoProduct10[U1, T2,T3,T4,T5,T6,T7,T8,T9,T10] = {
          val valueR = AppendTail3.mapHead(foldImpl)(func)
          new CoProduct10[U1, T2,T3,T4,T5,T6,T7,T8,T9,T10](valueR)
        }

        def tail: CoProduct10[T2,T3,T4,T5,T6,T7,T8,T9,T10, T1] = {
          val valueR = AppendTailHelper2.appendByDefault(foldImpl)
          new CoProduct10[T2,T3,T4,T5,T6,T7,T8,T9,T10, T1](valueR)
        }

        @inline def fold[Target](param1: T1 => Target,param2: T2 => Target,param3: T3 => Target,param4: T4 => Target,param5: T5 => Target,param6: T6 => Target,param7: T7 => Target,param8: T8 => Target,param9: T9 => Target,param10: T10 => Target): Target = {
          val toTarget = AppendTail7[Target]
          val func = toTarget.ToTarget.take(AdtHList.UsePositive.append(param1: T1 => Target, AdtHList.UsePositive.append(param2: T2 => Target, AdtHList.UsePositive.append(param3: T3 => Target, AdtHList.UsePositive.append(param4: T4 => Target, AdtHList.UsePositive.append(param5: T5 => Target, AdtHList.UsePositive.append(param6: T6 => Target, AdtHList.UsePositive.append(param7: T7 => Target, AdtHList.UsePositive.append(param8: T8 => Target, AdtHList.UsePositive.append(param9: T9 => Target, AdtHList.UsePositive.append(param10: T10 => Target, AdtHList.zero)))))))))))
          func(foldImpl)
        }

        def fold10[TargetOther10](param1: T1 => TargetOther10):
          ADTFoldApplyImpl9[TargetOther10,T2,T3,T4,T5,T6,T7,T8,T9,T10] = 
        new ADTFoldApplyImpl9[TargetOther10,T2,T3,T4,T5,T6,T7,T8,T9,T10] {
          override def fold9[TargetOther9 >: TargetOther10](
            param2: T2 => TargetOther9
          ): ADTFoldApplyImpl8[TargetOther9,T3,T4,T5,T6,T7,T8,T9,T10] = 
        new ADTFoldApplyImpl8[TargetOther9,T3,T4,T5,T6,T7,T8,T9,T10] {
          override def fold8[TargetOther8 >: TargetOther9](
            param3: T3 => TargetOther8
          ): ADTFoldApplyImpl7[TargetOther8,T4,T5,T6,T7,T8,T9,T10] = 
        new ADTFoldApplyImpl7[TargetOther8,T4,T5,T6,T7,T8,T9,T10] {
          override def fold7[TargetOther7 >: TargetOther8](
            param4: T4 => TargetOther7
          ): ADTFoldApplyImpl6[TargetOther7,T5,T6,T7,T8,T9,T10] = 
        new ADTFoldApplyImpl6[TargetOther7,T5,T6,T7,T8,T9,T10] {
          override def fold6[TargetOther6 >: TargetOther7](
            param5: T5 => TargetOther6
          ): ADTFoldApplyImpl5[TargetOther6,T6,T7,T8,T9,T10] = 
        new ADTFoldApplyImpl5[TargetOther6,T6,T7,T8,T9,T10] {
          override def fold5[TargetOther5 >: TargetOther6](
            param6: T6 => TargetOther5
          ): ADTFoldApplyImpl4[TargetOther5,T7,T8,T9,T10] = 
        new ADTFoldApplyImpl4[TargetOther5,T7,T8,T9,T10] {
          override def fold4[TargetOther4 >: TargetOther5](
            param7: T7 => TargetOther4
          ): ADTFoldApplyImpl3[TargetOther4,T8,T9,T10] = 
        new ADTFoldApplyImpl3[TargetOther4,T8,T9,T10] {
          override def fold3[TargetOther3 >: TargetOther4](
            param8: T8 => TargetOther3
          ): ADTFoldApplyImpl2[TargetOther3,T9,T10] = 
        new ADTFoldApplyImpl2[TargetOther3,T9,T10] {
          override def fold2[TargetOther2 >: TargetOther3](
            param9: T9 => TargetOther2
          ): ADTFoldApplyImpl1[TargetOther2,T10] = 
        new ADTFoldApplyImpl1[TargetOther2, T10] {
          override def fold1[TargetOther1 >: TargetOther2](param10: T10 => TargetOther1): TargetOther1 = {
            FoldApplySelf.fold(param1,param2,param3,param4,param5,param6,param7,param8,param9,param10)
          }
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      

      }

      object CoProduct10 {
        //
      }
    

      trait ADTFoldApplyImpl11[
        Target0,
        T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11
      ] {
        FoldApplySelf =>

        def fold11[TargetOther11 >: Target0](param1: T1 => TargetOther11):
          ADTFoldApplyImpl10[TargetOther11,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11]
      }

      class CoProduct11[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11](foldImpl: AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.One[T11]]]]]]]]]]])
        extends AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.One[T11]]]]]]]]]]]
        with helper1.CoProduct11Helper[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11] {
        FoldApplySelf =>

        override def _foldCoProduct[Re](h: T1 => Re, t: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.One[T11]]]]]]]]]] => Re): Re = foldImpl._foldCoProduct[Re](h, t)

        def drop1: Either[
          T1,
          CoProduct10[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11]
        ] = foldImpl._foldCoProduct[Either[T1, CoProduct10[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11]]](
          (i1: T1) => Left(i1),
          (i1: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.One[T11]]]]]]]]]]) => Right(new CoProduct10[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11](i1))
        )

        def map1[U1](func: T1 => U1): CoProduct11[U1, T2,T3,T4,T5,T6,T7,T8,T9,T10,T11] = {
          val valueR = AppendTail3.mapHead(foldImpl)(func)
          new CoProduct11[U1, T2,T3,T4,T5,T6,T7,T8,T9,T10,T11](valueR)
        }

        def tail: CoProduct11[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11, T1] = {
          val valueR = AppendTailHelper2.appendByDefault(foldImpl)
          new CoProduct11[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11, T1](valueR)
        }

        @inline def fold[Target](param1: T1 => Target,param2: T2 => Target,param3: T3 => Target,param4: T4 => Target,param5: T5 => Target,param6: T6 => Target,param7: T7 => Target,param8: T8 => Target,param9: T9 => Target,param10: T10 => Target,param11: T11 => Target): Target = {
          val toTarget = AppendTail7[Target]
          val func = toTarget.ToTarget.take(AdtHList.UsePositive.append(param1: T1 => Target, AdtHList.UsePositive.append(param2: T2 => Target, AdtHList.UsePositive.append(param3: T3 => Target, AdtHList.UsePositive.append(param4: T4 => Target, AdtHList.UsePositive.append(param5: T5 => Target, AdtHList.UsePositive.append(param6: T6 => Target, AdtHList.UsePositive.append(param7: T7 => Target, AdtHList.UsePositive.append(param8: T8 => Target, AdtHList.UsePositive.append(param9: T9 => Target, AdtHList.UsePositive.append(param10: T10 => Target, AdtHList.UsePositive.append(param11: T11 => Target, AdtHList.zero))))))))))))
          func(foldImpl)
        }

        def fold11[TargetOther11](param1: T1 => TargetOther11):
          ADTFoldApplyImpl10[TargetOther11,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11] = 
        new ADTFoldApplyImpl10[TargetOther11,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11] {
          override def fold10[TargetOther10 >: TargetOther11](
            param2: T2 => TargetOther10
          ): ADTFoldApplyImpl9[TargetOther10,T3,T4,T5,T6,T7,T8,T9,T10,T11] = 
        new ADTFoldApplyImpl9[TargetOther10,T3,T4,T5,T6,T7,T8,T9,T10,T11] {
          override def fold9[TargetOther9 >: TargetOther10](
            param3: T3 => TargetOther9
          ): ADTFoldApplyImpl8[TargetOther9,T4,T5,T6,T7,T8,T9,T10,T11] = 
        new ADTFoldApplyImpl8[TargetOther9,T4,T5,T6,T7,T8,T9,T10,T11] {
          override def fold8[TargetOther8 >: TargetOther9](
            param4: T4 => TargetOther8
          ): ADTFoldApplyImpl7[TargetOther8,T5,T6,T7,T8,T9,T10,T11] = 
        new ADTFoldApplyImpl7[TargetOther8,T5,T6,T7,T8,T9,T10,T11] {
          override def fold7[TargetOther7 >: TargetOther8](
            param5: T5 => TargetOther7
          ): ADTFoldApplyImpl6[TargetOther7,T6,T7,T8,T9,T10,T11] = 
        new ADTFoldApplyImpl6[TargetOther7,T6,T7,T8,T9,T10,T11] {
          override def fold6[TargetOther6 >: TargetOther7](
            param6: T6 => TargetOther6
          ): ADTFoldApplyImpl5[TargetOther6,T7,T8,T9,T10,T11] = 
        new ADTFoldApplyImpl5[TargetOther6,T7,T8,T9,T10,T11] {
          override def fold5[TargetOther5 >: TargetOther6](
            param7: T7 => TargetOther5
          ): ADTFoldApplyImpl4[TargetOther5,T8,T9,T10,T11] = 
        new ADTFoldApplyImpl4[TargetOther5,T8,T9,T10,T11] {
          override def fold4[TargetOther4 >: TargetOther5](
            param8: T8 => TargetOther4
          ): ADTFoldApplyImpl3[TargetOther4,T9,T10,T11] = 
        new ADTFoldApplyImpl3[TargetOther4,T9,T10,T11] {
          override def fold3[TargetOther3 >: TargetOther4](
            param9: T9 => TargetOther3
          ): ADTFoldApplyImpl2[TargetOther3,T10,T11] = 
        new ADTFoldApplyImpl2[TargetOther3,T10,T11] {
          override def fold2[TargetOther2 >: TargetOther3](
            param10: T10 => TargetOther2
          ): ADTFoldApplyImpl1[TargetOther2,T11] = 
        new ADTFoldApplyImpl1[TargetOther2, T11] {
          override def fold1[TargetOther1 >: TargetOther2](param11: T11 => TargetOther1): TargetOther1 = {
            FoldApplySelf.fold(param1,param2,param3,param4,param5,param6,param7,param8,param9,param10,param11)
          }
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      

      }

      object CoProduct11 {
        //
      }
    

      trait ADTFoldApplyImpl12[
        Target0,
        T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12
      ] {
        FoldApplySelf =>

        def fold12[TargetOther12 >: Target0](param1: T1 => TargetOther12):
          ADTFoldApplyImpl11[TargetOther12,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12]
      }

      class CoProduct12[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12](foldImpl: AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.One[T12]]]]]]]]]]]])
        extends AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.One[T12]]]]]]]]]]]]
        with helper1.CoProduct12Helper[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12] {
        FoldApplySelf =>

        override def _foldCoProduct[Re](h: T1 => Re, t: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.One[T12]]]]]]]]]]] => Re): Re = foldImpl._foldCoProduct[Re](h, t)

        def drop1: Either[
          T1,
          CoProduct11[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12]
        ] = foldImpl._foldCoProduct[Either[T1, CoProduct11[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12]]](
          (i1: T1) => Left(i1),
          (i1: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.One[T12]]]]]]]]]]]) => Right(new CoProduct11[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12](i1))
        )

        def map1[U1](func: T1 => U1): CoProduct12[U1, T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12] = {
          val valueR = AppendTail3.mapHead(foldImpl)(func)
          new CoProduct12[U1, T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12](valueR)
        }

        def tail: CoProduct12[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12, T1] = {
          val valueR = AppendTailHelper2.appendByDefault(foldImpl)
          new CoProduct12[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12, T1](valueR)
        }

        @inline def fold[Target](param1: T1 => Target,param2: T2 => Target,param3: T3 => Target,param4: T4 => Target,param5: T5 => Target,param6: T6 => Target,param7: T7 => Target,param8: T8 => Target,param9: T9 => Target,param10: T10 => Target,param11: T11 => Target,param12: T12 => Target): Target = {
          val toTarget = AppendTail7[Target]
          val func = toTarget.ToTarget.take(AdtHList.UsePositive.append(param1: T1 => Target, AdtHList.UsePositive.append(param2: T2 => Target, AdtHList.UsePositive.append(param3: T3 => Target, AdtHList.UsePositive.append(param4: T4 => Target, AdtHList.UsePositive.append(param5: T5 => Target, AdtHList.UsePositive.append(param6: T6 => Target, AdtHList.UsePositive.append(param7: T7 => Target, AdtHList.UsePositive.append(param8: T8 => Target, AdtHList.UsePositive.append(param9: T9 => Target, AdtHList.UsePositive.append(param10: T10 => Target, AdtHList.UsePositive.append(param11: T11 => Target, AdtHList.UsePositive.append(param12: T12 => Target, AdtHList.zero)))))))))))))
          func(foldImpl)
        }

        def fold12[TargetOther12](param1: T1 => TargetOther12):
          ADTFoldApplyImpl11[TargetOther12,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12] = 
        new ADTFoldApplyImpl11[TargetOther12,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12] {
          override def fold11[TargetOther11 >: TargetOther12](
            param2: T2 => TargetOther11
          ): ADTFoldApplyImpl10[TargetOther11,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12] = 
        new ADTFoldApplyImpl10[TargetOther11,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12] {
          override def fold10[TargetOther10 >: TargetOther11](
            param3: T3 => TargetOther10
          ): ADTFoldApplyImpl9[TargetOther10,T4,T5,T6,T7,T8,T9,T10,T11,T12] = 
        new ADTFoldApplyImpl9[TargetOther10,T4,T5,T6,T7,T8,T9,T10,T11,T12] {
          override def fold9[TargetOther9 >: TargetOther10](
            param4: T4 => TargetOther9
          ): ADTFoldApplyImpl8[TargetOther9,T5,T6,T7,T8,T9,T10,T11,T12] = 
        new ADTFoldApplyImpl8[TargetOther9,T5,T6,T7,T8,T9,T10,T11,T12] {
          override def fold8[TargetOther8 >: TargetOther9](
            param5: T5 => TargetOther8
          ): ADTFoldApplyImpl7[TargetOther8,T6,T7,T8,T9,T10,T11,T12] = 
        new ADTFoldApplyImpl7[TargetOther8,T6,T7,T8,T9,T10,T11,T12] {
          override def fold7[TargetOther7 >: TargetOther8](
            param6: T6 => TargetOther7
          ): ADTFoldApplyImpl6[TargetOther7,T7,T8,T9,T10,T11,T12] = 
        new ADTFoldApplyImpl6[TargetOther7,T7,T8,T9,T10,T11,T12] {
          override def fold6[TargetOther6 >: TargetOther7](
            param7: T7 => TargetOther6
          ): ADTFoldApplyImpl5[TargetOther6,T8,T9,T10,T11,T12] = 
        new ADTFoldApplyImpl5[TargetOther6,T8,T9,T10,T11,T12] {
          override def fold5[TargetOther5 >: TargetOther6](
            param8: T8 => TargetOther5
          ): ADTFoldApplyImpl4[TargetOther5,T9,T10,T11,T12] = 
        new ADTFoldApplyImpl4[TargetOther5,T9,T10,T11,T12] {
          override def fold4[TargetOther4 >: TargetOther5](
            param9: T9 => TargetOther4
          ): ADTFoldApplyImpl3[TargetOther4,T10,T11,T12] = 
        new ADTFoldApplyImpl3[TargetOther4,T10,T11,T12] {
          override def fold3[TargetOther3 >: TargetOther4](
            param10: T10 => TargetOther3
          ): ADTFoldApplyImpl2[TargetOther3,T11,T12] = 
        new ADTFoldApplyImpl2[TargetOther3,T11,T12] {
          override def fold2[TargetOther2 >: TargetOther3](
            param11: T11 => TargetOther2
          ): ADTFoldApplyImpl1[TargetOther2,T12] = 
        new ADTFoldApplyImpl1[TargetOther2, T12] {
          override def fold1[TargetOther1 >: TargetOther2](param12: T12 => TargetOther1): TargetOther1 = {
            FoldApplySelf.fold(param1,param2,param3,param4,param5,param6,param7,param8,param9,param10,param11,param12)
          }
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      

      }

      object CoProduct12 {
        //
      }
    

      trait ADTFoldApplyImpl13[
        Target0,
        T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13
      ] {
        FoldApplySelf =>

        def fold13[TargetOther13 >: Target0](param1: T1 => TargetOther13):
          ADTFoldApplyImpl12[TargetOther13,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13]
      }

      class CoProduct13[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13](foldImpl: AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.One[T13]]]]]]]]]]]]])
        extends AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.One[T13]]]]]]]]]]]]]
        with helper1.CoProduct13Helper[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13] {
        FoldApplySelf =>

        override def _foldCoProduct[Re](h: T1 => Re, t: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.One[T13]]]]]]]]]]]] => Re): Re = foldImpl._foldCoProduct[Re](h, t)

        def drop1: Either[
          T1,
          CoProduct12[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13]
        ] = foldImpl._foldCoProduct[Either[T1, CoProduct12[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13]]](
          (i1: T1) => Left(i1),
          (i1: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.One[T13]]]]]]]]]]]]) => Right(new CoProduct12[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13](i1))
        )

        def map1[U1](func: T1 => U1): CoProduct13[U1, T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13] = {
          val valueR = AppendTail3.mapHead(foldImpl)(func)
          new CoProduct13[U1, T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13](valueR)
        }

        def tail: CoProduct13[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13, T1] = {
          val valueR = AppendTailHelper2.appendByDefault(foldImpl)
          new CoProduct13[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13, T1](valueR)
        }

        @inline def fold[Target](param1: T1 => Target,param2: T2 => Target,param3: T3 => Target,param4: T4 => Target,param5: T5 => Target,param6: T6 => Target,param7: T7 => Target,param8: T8 => Target,param9: T9 => Target,param10: T10 => Target,param11: T11 => Target,param12: T12 => Target,param13: T13 => Target): Target = {
          val toTarget = AppendTail7[Target]
          val func = toTarget.ToTarget.take(AdtHList.UsePositive.append(param1: T1 => Target, AdtHList.UsePositive.append(param2: T2 => Target, AdtHList.UsePositive.append(param3: T3 => Target, AdtHList.UsePositive.append(param4: T4 => Target, AdtHList.UsePositive.append(param5: T5 => Target, AdtHList.UsePositive.append(param6: T6 => Target, AdtHList.UsePositive.append(param7: T7 => Target, AdtHList.UsePositive.append(param8: T8 => Target, AdtHList.UsePositive.append(param9: T9 => Target, AdtHList.UsePositive.append(param10: T10 => Target, AdtHList.UsePositive.append(param11: T11 => Target, AdtHList.UsePositive.append(param12: T12 => Target, AdtHList.UsePositive.append(param13: T13 => Target, AdtHList.zero))))))))))))))
          func(foldImpl)
        }

        def fold13[TargetOther13](param1: T1 => TargetOther13):
          ADTFoldApplyImpl12[TargetOther13,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13] = 
        new ADTFoldApplyImpl12[TargetOther13,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13] {
          override def fold12[TargetOther12 >: TargetOther13](
            param2: T2 => TargetOther12
          ): ADTFoldApplyImpl11[TargetOther12,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13] = 
        new ADTFoldApplyImpl11[TargetOther12,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13] {
          override def fold11[TargetOther11 >: TargetOther12](
            param3: T3 => TargetOther11
          ): ADTFoldApplyImpl10[TargetOther11,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13] = 
        new ADTFoldApplyImpl10[TargetOther11,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13] {
          override def fold10[TargetOther10 >: TargetOther11](
            param4: T4 => TargetOther10
          ): ADTFoldApplyImpl9[TargetOther10,T5,T6,T7,T8,T9,T10,T11,T12,T13] = 
        new ADTFoldApplyImpl9[TargetOther10,T5,T6,T7,T8,T9,T10,T11,T12,T13] {
          override def fold9[TargetOther9 >: TargetOther10](
            param5: T5 => TargetOther9
          ): ADTFoldApplyImpl8[TargetOther9,T6,T7,T8,T9,T10,T11,T12,T13] = 
        new ADTFoldApplyImpl8[TargetOther9,T6,T7,T8,T9,T10,T11,T12,T13] {
          override def fold8[TargetOther8 >: TargetOther9](
            param6: T6 => TargetOther8
          ): ADTFoldApplyImpl7[TargetOther8,T7,T8,T9,T10,T11,T12,T13] = 
        new ADTFoldApplyImpl7[TargetOther8,T7,T8,T9,T10,T11,T12,T13] {
          override def fold7[TargetOther7 >: TargetOther8](
            param7: T7 => TargetOther7
          ): ADTFoldApplyImpl6[TargetOther7,T8,T9,T10,T11,T12,T13] = 
        new ADTFoldApplyImpl6[TargetOther7,T8,T9,T10,T11,T12,T13] {
          override def fold6[TargetOther6 >: TargetOther7](
            param8: T8 => TargetOther6
          ): ADTFoldApplyImpl5[TargetOther6,T9,T10,T11,T12,T13] = 
        new ADTFoldApplyImpl5[TargetOther6,T9,T10,T11,T12,T13] {
          override def fold5[TargetOther5 >: TargetOther6](
            param9: T9 => TargetOther5
          ): ADTFoldApplyImpl4[TargetOther5,T10,T11,T12,T13] = 
        new ADTFoldApplyImpl4[TargetOther5,T10,T11,T12,T13] {
          override def fold4[TargetOther4 >: TargetOther5](
            param10: T10 => TargetOther4
          ): ADTFoldApplyImpl3[TargetOther4,T11,T12,T13] = 
        new ADTFoldApplyImpl3[TargetOther4,T11,T12,T13] {
          override def fold3[TargetOther3 >: TargetOther4](
            param11: T11 => TargetOther3
          ): ADTFoldApplyImpl2[TargetOther3,T12,T13] = 
        new ADTFoldApplyImpl2[TargetOther3,T12,T13] {
          override def fold2[TargetOther2 >: TargetOther3](
            param12: T12 => TargetOther2
          ): ADTFoldApplyImpl1[TargetOther2,T13] = 
        new ADTFoldApplyImpl1[TargetOther2, T13] {
          override def fold1[TargetOther1 >: TargetOther2](param13: T13 => TargetOther1): TargetOther1 = {
            FoldApplySelf.fold(param1,param2,param3,param4,param5,param6,param7,param8,param9,param10,param11,param12,param13)
          }
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      

      }

      object CoProduct13 {
        //
      }
    

      trait ADTFoldApplyImpl14[
        Target0,
        T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14
      ] {
        FoldApplySelf =>

        def fold14[TargetOther14 >: Target0](param1: T1 => TargetOther14):
          ADTFoldApplyImpl13[TargetOther14,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14]
      }

      class CoProduct14[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14](foldImpl: AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.One[T14]]]]]]]]]]]]]])
        extends AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.One[T14]]]]]]]]]]]]]]
        with helper1.CoProduct14Helper[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14] {
        FoldApplySelf =>

        override def _foldCoProduct[Re](h: T1 => Re, t: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.One[T14]]]]]]]]]]]]] => Re): Re = foldImpl._foldCoProduct[Re](h, t)

        def drop1: Either[
          T1,
          CoProduct13[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14]
        ] = foldImpl._foldCoProduct[Either[T1, CoProduct13[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14]]](
          (i1: T1) => Left(i1),
          (i1: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.One[T14]]]]]]]]]]]]]) => Right(new CoProduct13[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14](i1))
        )

        def map1[U1](func: T1 => U1): CoProduct14[U1, T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14] = {
          val valueR = AppendTail3.mapHead(foldImpl)(func)
          new CoProduct14[U1, T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14](valueR)
        }

        def tail: CoProduct14[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14, T1] = {
          val valueR = AppendTailHelper2.appendByDefault(foldImpl)
          new CoProduct14[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14, T1](valueR)
        }

        @inline def fold[Target](param1: T1 => Target,param2: T2 => Target,param3: T3 => Target,param4: T4 => Target,param5: T5 => Target,param6: T6 => Target,param7: T7 => Target,param8: T8 => Target,param9: T9 => Target,param10: T10 => Target,param11: T11 => Target,param12: T12 => Target,param13: T13 => Target,param14: T14 => Target): Target = {
          val toTarget = AppendTail7[Target]
          val func = toTarget.ToTarget.take(AdtHList.UsePositive.append(param1: T1 => Target, AdtHList.UsePositive.append(param2: T2 => Target, AdtHList.UsePositive.append(param3: T3 => Target, AdtHList.UsePositive.append(param4: T4 => Target, AdtHList.UsePositive.append(param5: T5 => Target, AdtHList.UsePositive.append(param6: T6 => Target, AdtHList.UsePositive.append(param7: T7 => Target, AdtHList.UsePositive.append(param8: T8 => Target, AdtHList.UsePositive.append(param9: T9 => Target, AdtHList.UsePositive.append(param10: T10 => Target, AdtHList.UsePositive.append(param11: T11 => Target, AdtHList.UsePositive.append(param12: T12 => Target, AdtHList.UsePositive.append(param13: T13 => Target, AdtHList.UsePositive.append(param14: T14 => Target, AdtHList.zero)))))))))))))))
          func(foldImpl)
        }

        def fold14[TargetOther14](param1: T1 => TargetOther14):
          ADTFoldApplyImpl13[TargetOther14,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14] = 
        new ADTFoldApplyImpl13[TargetOther14,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14] {
          override def fold13[TargetOther13 >: TargetOther14](
            param2: T2 => TargetOther13
          ): ADTFoldApplyImpl12[TargetOther13,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14] = 
        new ADTFoldApplyImpl12[TargetOther13,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14] {
          override def fold12[TargetOther12 >: TargetOther13](
            param3: T3 => TargetOther12
          ): ADTFoldApplyImpl11[TargetOther12,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14] = 
        new ADTFoldApplyImpl11[TargetOther12,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14] {
          override def fold11[TargetOther11 >: TargetOther12](
            param4: T4 => TargetOther11
          ): ADTFoldApplyImpl10[TargetOther11,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14] = 
        new ADTFoldApplyImpl10[TargetOther11,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14] {
          override def fold10[TargetOther10 >: TargetOther11](
            param5: T5 => TargetOther10
          ): ADTFoldApplyImpl9[TargetOther10,T6,T7,T8,T9,T10,T11,T12,T13,T14] = 
        new ADTFoldApplyImpl9[TargetOther10,T6,T7,T8,T9,T10,T11,T12,T13,T14] {
          override def fold9[TargetOther9 >: TargetOther10](
            param6: T6 => TargetOther9
          ): ADTFoldApplyImpl8[TargetOther9,T7,T8,T9,T10,T11,T12,T13,T14] = 
        new ADTFoldApplyImpl8[TargetOther9,T7,T8,T9,T10,T11,T12,T13,T14] {
          override def fold8[TargetOther8 >: TargetOther9](
            param7: T7 => TargetOther8
          ): ADTFoldApplyImpl7[TargetOther8,T8,T9,T10,T11,T12,T13,T14] = 
        new ADTFoldApplyImpl7[TargetOther8,T8,T9,T10,T11,T12,T13,T14] {
          override def fold7[TargetOther7 >: TargetOther8](
            param8: T8 => TargetOther7
          ): ADTFoldApplyImpl6[TargetOther7,T9,T10,T11,T12,T13,T14] = 
        new ADTFoldApplyImpl6[TargetOther7,T9,T10,T11,T12,T13,T14] {
          override def fold6[TargetOther6 >: TargetOther7](
            param9: T9 => TargetOther6
          ): ADTFoldApplyImpl5[TargetOther6,T10,T11,T12,T13,T14] = 
        new ADTFoldApplyImpl5[TargetOther6,T10,T11,T12,T13,T14] {
          override def fold5[TargetOther5 >: TargetOther6](
            param10: T10 => TargetOther5
          ): ADTFoldApplyImpl4[TargetOther5,T11,T12,T13,T14] = 
        new ADTFoldApplyImpl4[TargetOther5,T11,T12,T13,T14] {
          override def fold4[TargetOther4 >: TargetOther5](
            param11: T11 => TargetOther4
          ): ADTFoldApplyImpl3[TargetOther4,T12,T13,T14] = 
        new ADTFoldApplyImpl3[TargetOther4,T12,T13,T14] {
          override def fold3[TargetOther3 >: TargetOther4](
            param12: T12 => TargetOther3
          ): ADTFoldApplyImpl2[TargetOther3,T13,T14] = 
        new ADTFoldApplyImpl2[TargetOther3,T13,T14] {
          override def fold2[TargetOther2 >: TargetOther3](
            param13: T13 => TargetOther2
          ): ADTFoldApplyImpl1[TargetOther2,T14] = 
        new ADTFoldApplyImpl1[TargetOther2, T14] {
          override def fold1[TargetOther1 >: TargetOther2](param14: T14 => TargetOther1): TargetOther1 = {
            FoldApplySelf.fold(param1,param2,param3,param4,param5,param6,param7,param8,param9,param10,param11,param12,param13,param14)
          }
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      

      }

      object CoProduct14 {
        //
      }
    

      trait ADTFoldApplyImpl15[
        Target0,
        T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15
      ] {
        FoldApplySelf =>

        def fold15[TargetOther15 >: Target0](param1: T1 => TargetOther15):
          ADTFoldApplyImpl14[TargetOther15,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15]
      }

      class CoProduct15[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15](foldImpl: AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.One[T15]]]]]]]]]]]]]]])
        extends AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.One[T15]]]]]]]]]]]]]]]
        with helper1.CoProduct15Helper[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] {
        FoldApplySelf =>

        override def _foldCoProduct[Re](h: T1 => Re, t: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.One[T15]]]]]]]]]]]]]] => Re): Re = foldImpl._foldCoProduct[Re](h, t)

        def drop1: Either[
          T1,
          CoProduct14[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15]
        ] = foldImpl._foldCoProduct[Either[T1, CoProduct14[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15]]](
          (i1: T1) => Left(i1),
          (i1: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.One[T15]]]]]]]]]]]]]]) => Right(new CoProduct14[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15](i1))
        )

        def map1[U1](func: T1 => U1): CoProduct15[U1, T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] = {
          val valueR = AppendTail3.mapHead(foldImpl)(func)
          new CoProduct15[U1, T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15](valueR)
        }

        def tail: CoProduct15[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15, T1] = {
          val valueR = AppendTailHelper2.appendByDefault(foldImpl)
          new CoProduct15[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15, T1](valueR)
        }

        @inline def fold[Target](param1: T1 => Target,param2: T2 => Target,param3: T3 => Target,param4: T4 => Target,param5: T5 => Target,param6: T6 => Target,param7: T7 => Target,param8: T8 => Target,param9: T9 => Target,param10: T10 => Target,param11: T11 => Target,param12: T12 => Target,param13: T13 => Target,param14: T14 => Target,param15: T15 => Target): Target = {
          val toTarget = AppendTail7[Target]
          val func = toTarget.ToTarget.take(AdtHList.UsePositive.append(param1: T1 => Target, AdtHList.UsePositive.append(param2: T2 => Target, AdtHList.UsePositive.append(param3: T3 => Target, AdtHList.UsePositive.append(param4: T4 => Target, AdtHList.UsePositive.append(param5: T5 => Target, AdtHList.UsePositive.append(param6: T6 => Target, AdtHList.UsePositive.append(param7: T7 => Target, AdtHList.UsePositive.append(param8: T8 => Target, AdtHList.UsePositive.append(param9: T9 => Target, AdtHList.UsePositive.append(param10: T10 => Target, AdtHList.UsePositive.append(param11: T11 => Target, AdtHList.UsePositive.append(param12: T12 => Target, AdtHList.UsePositive.append(param13: T13 => Target, AdtHList.UsePositive.append(param14: T14 => Target, AdtHList.UsePositive.append(param15: T15 => Target, AdtHList.zero))))))))))))))))
          func(foldImpl)
        }

        def fold15[TargetOther15](param1: T1 => TargetOther15):
          ADTFoldApplyImpl14[TargetOther15,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] = 
        new ADTFoldApplyImpl14[TargetOther15,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] {
          override def fold14[TargetOther14 >: TargetOther15](
            param2: T2 => TargetOther14
          ): ADTFoldApplyImpl13[TargetOther14,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] = 
        new ADTFoldApplyImpl13[TargetOther14,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] {
          override def fold13[TargetOther13 >: TargetOther14](
            param3: T3 => TargetOther13
          ): ADTFoldApplyImpl12[TargetOther13,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] = 
        new ADTFoldApplyImpl12[TargetOther13,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] {
          override def fold12[TargetOther12 >: TargetOther13](
            param4: T4 => TargetOther12
          ): ADTFoldApplyImpl11[TargetOther12,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] = 
        new ADTFoldApplyImpl11[TargetOther12,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] {
          override def fold11[TargetOther11 >: TargetOther12](
            param5: T5 => TargetOther11
          ): ADTFoldApplyImpl10[TargetOther11,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] = 
        new ADTFoldApplyImpl10[TargetOther11,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15] {
          override def fold10[TargetOther10 >: TargetOther11](
            param6: T6 => TargetOther10
          ): ADTFoldApplyImpl9[TargetOther10,T7,T8,T9,T10,T11,T12,T13,T14,T15] = 
        new ADTFoldApplyImpl9[TargetOther10,T7,T8,T9,T10,T11,T12,T13,T14,T15] {
          override def fold9[TargetOther9 >: TargetOther10](
            param7: T7 => TargetOther9
          ): ADTFoldApplyImpl8[TargetOther9,T8,T9,T10,T11,T12,T13,T14,T15] = 
        new ADTFoldApplyImpl8[TargetOther9,T8,T9,T10,T11,T12,T13,T14,T15] {
          override def fold8[TargetOther8 >: TargetOther9](
            param8: T8 => TargetOther8
          ): ADTFoldApplyImpl7[TargetOther8,T9,T10,T11,T12,T13,T14,T15] = 
        new ADTFoldApplyImpl7[TargetOther8,T9,T10,T11,T12,T13,T14,T15] {
          override def fold7[TargetOther7 >: TargetOther8](
            param9: T9 => TargetOther7
          ): ADTFoldApplyImpl6[TargetOther7,T10,T11,T12,T13,T14,T15] = 
        new ADTFoldApplyImpl6[TargetOther7,T10,T11,T12,T13,T14,T15] {
          override def fold6[TargetOther6 >: TargetOther7](
            param10: T10 => TargetOther6
          ): ADTFoldApplyImpl5[TargetOther6,T11,T12,T13,T14,T15] = 
        new ADTFoldApplyImpl5[TargetOther6,T11,T12,T13,T14,T15] {
          override def fold5[TargetOther5 >: TargetOther6](
            param11: T11 => TargetOther5
          ): ADTFoldApplyImpl4[TargetOther5,T12,T13,T14,T15] = 
        new ADTFoldApplyImpl4[TargetOther5,T12,T13,T14,T15] {
          override def fold4[TargetOther4 >: TargetOther5](
            param12: T12 => TargetOther4
          ): ADTFoldApplyImpl3[TargetOther4,T13,T14,T15] = 
        new ADTFoldApplyImpl3[TargetOther4,T13,T14,T15] {
          override def fold3[TargetOther3 >: TargetOther4](
            param13: T13 => TargetOther3
          ): ADTFoldApplyImpl2[TargetOther3,T14,T15] = 
        new ADTFoldApplyImpl2[TargetOther3,T14,T15] {
          override def fold2[TargetOther2 >: TargetOther3](
            param14: T14 => TargetOther2
          ): ADTFoldApplyImpl1[TargetOther2,T15] = 
        new ADTFoldApplyImpl1[TargetOther2, T15] {
          override def fold1[TargetOther1 >: TargetOther2](param15: T15 => TargetOther1): TargetOther1 = {
            FoldApplySelf.fold(param1,param2,param3,param4,param5,param6,param7,param8,param9,param10,param11,param12,param13,param14,param15)
          }
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      

      }

      object CoProduct15 {
        //
      }
    

      trait ADTFoldApplyImpl16[
        Target0,
        T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16
      ] {
        FoldApplySelf =>

        def fold16[TargetOther16 >: Target0](param1: T1 => TargetOther16):
          ADTFoldApplyImpl15[TargetOther16,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16]
      }

      class CoProduct16[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16](foldImpl: AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.Positive[T15, AdtCoProduct.Use.One[T16]]]]]]]]]]]]]]]])
        extends AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.Positive[T15, AdtCoProduct.Use.One[T16]]]]]]]]]]]]]]]]
        with helper1.CoProduct16Helper[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] {
        FoldApplySelf =>

        override def _foldCoProduct[Re](h: T1 => Re, t: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.Positive[T15, AdtCoProduct.Use.One[T16]]]]]]]]]]]]]]] => Re): Re = foldImpl._foldCoProduct[Re](h, t)

        def drop1: Either[
          T1,
          CoProduct15[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16]
        ] = foldImpl._foldCoProduct[Either[T1, CoProduct15[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16]]](
          (i1: T1) => Left(i1),
          (i1: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.Positive[T15, AdtCoProduct.Use.One[T16]]]]]]]]]]]]]]]) => Right(new CoProduct15[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16](i1))
        )

        def map1[U1](func: T1 => U1): CoProduct16[U1, T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] = {
          val valueR = AppendTail3.mapHead(foldImpl)(func)
          new CoProduct16[U1, T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16](valueR)
        }

        def tail: CoProduct16[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16, T1] = {
          val valueR = AppendTailHelper2.appendByDefault(foldImpl)
          new CoProduct16[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16, T1](valueR)
        }

        @inline def fold[Target](param1: T1 => Target,param2: T2 => Target,param3: T3 => Target,param4: T4 => Target,param5: T5 => Target,param6: T6 => Target,param7: T7 => Target,param8: T8 => Target,param9: T9 => Target,param10: T10 => Target,param11: T11 => Target,param12: T12 => Target,param13: T13 => Target,param14: T14 => Target,param15: T15 => Target,param16: T16 => Target): Target = {
          val toTarget = AppendTail7[Target]
          val func = toTarget.ToTarget.take(AdtHList.UsePositive.append(param1: T1 => Target, AdtHList.UsePositive.append(param2: T2 => Target, AdtHList.UsePositive.append(param3: T3 => Target, AdtHList.UsePositive.append(param4: T4 => Target, AdtHList.UsePositive.append(param5: T5 => Target, AdtHList.UsePositive.append(param6: T6 => Target, AdtHList.UsePositive.append(param7: T7 => Target, AdtHList.UsePositive.append(param8: T8 => Target, AdtHList.UsePositive.append(param9: T9 => Target, AdtHList.UsePositive.append(param10: T10 => Target, AdtHList.UsePositive.append(param11: T11 => Target, AdtHList.UsePositive.append(param12: T12 => Target, AdtHList.UsePositive.append(param13: T13 => Target, AdtHList.UsePositive.append(param14: T14 => Target, AdtHList.UsePositive.append(param15: T15 => Target, AdtHList.UsePositive.append(param16: T16 => Target, AdtHList.zero)))))))))))))))))
          func(foldImpl)
        }

        def fold16[TargetOther16](param1: T1 => TargetOther16):
          ADTFoldApplyImpl15[TargetOther16,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] = 
        new ADTFoldApplyImpl15[TargetOther16,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] {
          override def fold15[TargetOther15 >: TargetOther16](
            param2: T2 => TargetOther15
          ): ADTFoldApplyImpl14[TargetOther15,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] = 
        new ADTFoldApplyImpl14[TargetOther15,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] {
          override def fold14[TargetOther14 >: TargetOther15](
            param3: T3 => TargetOther14
          ): ADTFoldApplyImpl13[TargetOther14,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] = 
        new ADTFoldApplyImpl13[TargetOther14,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] {
          override def fold13[TargetOther13 >: TargetOther14](
            param4: T4 => TargetOther13
          ): ADTFoldApplyImpl12[TargetOther13,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] = 
        new ADTFoldApplyImpl12[TargetOther13,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] {
          override def fold12[TargetOther12 >: TargetOther13](
            param5: T5 => TargetOther12
          ): ADTFoldApplyImpl11[TargetOther12,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] = 
        new ADTFoldApplyImpl11[TargetOther12,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] {
          override def fold11[TargetOther11 >: TargetOther12](
            param6: T6 => TargetOther11
          ): ADTFoldApplyImpl10[TargetOther11,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] = 
        new ADTFoldApplyImpl10[TargetOther11,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16] {
          override def fold10[TargetOther10 >: TargetOther11](
            param7: T7 => TargetOther10
          ): ADTFoldApplyImpl9[TargetOther10,T8,T9,T10,T11,T12,T13,T14,T15,T16] = 
        new ADTFoldApplyImpl9[TargetOther10,T8,T9,T10,T11,T12,T13,T14,T15,T16] {
          override def fold9[TargetOther9 >: TargetOther10](
            param8: T8 => TargetOther9
          ): ADTFoldApplyImpl8[TargetOther9,T9,T10,T11,T12,T13,T14,T15,T16] = 
        new ADTFoldApplyImpl8[TargetOther9,T9,T10,T11,T12,T13,T14,T15,T16] {
          override def fold8[TargetOther8 >: TargetOther9](
            param9: T9 => TargetOther8
          ): ADTFoldApplyImpl7[TargetOther8,T10,T11,T12,T13,T14,T15,T16] = 
        new ADTFoldApplyImpl7[TargetOther8,T10,T11,T12,T13,T14,T15,T16] {
          override def fold7[TargetOther7 >: TargetOther8](
            param10: T10 => TargetOther7
          ): ADTFoldApplyImpl6[TargetOther7,T11,T12,T13,T14,T15,T16] = 
        new ADTFoldApplyImpl6[TargetOther7,T11,T12,T13,T14,T15,T16] {
          override def fold6[TargetOther6 >: TargetOther7](
            param11: T11 => TargetOther6
          ): ADTFoldApplyImpl5[TargetOther6,T12,T13,T14,T15,T16] = 
        new ADTFoldApplyImpl5[TargetOther6,T12,T13,T14,T15,T16] {
          override def fold5[TargetOther5 >: TargetOther6](
            param12: T12 => TargetOther5
          ): ADTFoldApplyImpl4[TargetOther5,T13,T14,T15,T16] = 
        new ADTFoldApplyImpl4[TargetOther5,T13,T14,T15,T16] {
          override def fold4[TargetOther4 >: TargetOther5](
            param13: T13 => TargetOther4
          ): ADTFoldApplyImpl3[TargetOther4,T14,T15,T16] = 
        new ADTFoldApplyImpl3[TargetOther4,T14,T15,T16] {
          override def fold3[TargetOther3 >: TargetOther4](
            param14: T14 => TargetOther3
          ): ADTFoldApplyImpl2[TargetOther3,T15,T16] = 
        new ADTFoldApplyImpl2[TargetOther3,T15,T16] {
          override def fold2[TargetOther2 >: TargetOther3](
            param15: T15 => TargetOther2
          ): ADTFoldApplyImpl1[TargetOther2,T16] = 
        new ADTFoldApplyImpl1[TargetOther2, T16] {
          override def fold1[TargetOther1 >: TargetOther2](param16: T16 => TargetOther1): TargetOther1 = {
            FoldApplySelf.fold(param1,param2,param3,param4,param5,param6,param7,param8,param9,param10,param11,param12,param13,param14,param15,param16)
          }
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      

      }

      object CoProduct16 {
        //
      }
    

      trait ADTFoldApplyImpl17[
        Target0,
        T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17
      ] {
        FoldApplySelf =>

        def fold17[TargetOther17 >: Target0](param1: T1 => TargetOther17):
          ADTFoldApplyImpl16[TargetOther17,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17]
      }

      class CoProduct17[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17](foldImpl: AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.Positive[T15, AdtCoProduct.Use.Positive[T16, AdtCoProduct.Use.One[T17]]]]]]]]]]]]]]]]])
        extends AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.Positive[T15, AdtCoProduct.Use.Positive[T16, AdtCoProduct.Use.One[T17]]]]]]]]]]]]]]]]]
        with helper1.CoProduct17Helper[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] {
        FoldApplySelf =>

        override def _foldCoProduct[Re](h: T1 => Re, t: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.Positive[T15, AdtCoProduct.Use.Positive[T16, AdtCoProduct.Use.One[T17]]]]]]]]]]]]]]]] => Re): Re = foldImpl._foldCoProduct[Re](h, t)

        def drop1: Either[
          T1,
          CoProduct16[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17]
        ] = foldImpl._foldCoProduct[Either[T1, CoProduct16[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17]]](
          (i1: T1) => Left(i1),
          (i1: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.Positive[T15, AdtCoProduct.Use.Positive[T16, AdtCoProduct.Use.One[T17]]]]]]]]]]]]]]]]) => Right(new CoProduct16[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17](i1))
        )

        def map1[U1](func: T1 => U1): CoProduct17[U1, T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] = {
          val valueR = AppendTail3.mapHead(foldImpl)(func)
          new CoProduct17[U1, T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17](valueR)
        }

        def tail: CoProduct17[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17, T1] = {
          val valueR = AppendTailHelper2.appendByDefault(foldImpl)
          new CoProduct17[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17, T1](valueR)
        }

        @inline def fold[Target](param1: T1 => Target,param2: T2 => Target,param3: T3 => Target,param4: T4 => Target,param5: T5 => Target,param6: T6 => Target,param7: T7 => Target,param8: T8 => Target,param9: T9 => Target,param10: T10 => Target,param11: T11 => Target,param12: T12 => Target,param13: T13 => Target,param14: T14 => Target,param15: T15 => Target,param16: T16 => Target,param17: T17 => Target): Target = {
          val toTarget = AppendTail7[Target]
          val func = toTarget.ToTarget.take(AdtHList.UsePositive.append(param1: T1 => Target, AdtHList.UsePositive.append(param2: T2 => Target, AdtHList.UsePositive.append(param3: T3 => Target, AdtHList.UsePositive.append(param4: T4 => Target, AdtHList.UsePositive.append(param5: T5 => Target, AdtHList.UsePositive.append(param6: T6 => Target, AdtHList.UsePositive.append(param7: T7 => Target, AdtHList.UsePositive.append(param8: T8 => Target, AdtHList.UsePositive.append(param9: T9 => Target, AdtHList.UsePositive.append(param10: T10 => Target, AdtHList.UsePositive.append(param11: T11 => Target, AdtHList.UsePositive.append(param12: T12 => Target, AdtHList.UsePositive.append(param13: T13 => Target, AdtHList.UsePositive.append(param14: T14 => Target, AdtHList.UsePositive.append(param15: T15 => Target, AdtHList.UsePositive.append(param16: T16 => Target, AdtHList.UsePositive.append(param17: T17 => Target, AdtHList.zero))))))))))))))))))
          func(foldImpl)
        }

        def fold17[TargetOther17](param1: T1 => TargetOther17):
          ADTFoldApplyImpl16[TargetOther17,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] = 
        new ADTFoldApplyImpl16[TargetOther17,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] {
          override def fold16[TargetOther16 >: TargetOther17](
            param2: T2 => TargetOther16
          ): ADTFoldApplyImpl15[TargetOther16,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] = 
        new ADTFoldApplyImpl15[TargetOther16,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] {
          override def fold15[TargetOther15 >: TargetOther16](
            param3: T3 => TargetOther15
          ): ADTFoldApplyImpl14[TargetOther15,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] = 
        new ADTFoldApplyImpl14[TargetOther15,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] {
          override def fold14[TargetOther14 >: TargetOther15](
            param4: T4 => TargetOther14
          ): ADTFoldApplyImpl13[TargetOther14,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] = 
        new ADTFoldApplyImpl13[TargetOther14,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] {
          override def fold13[TargetOther13 >: TargetOther14](
            param5: T5 => TargetOther13
          ): ADTFoldApplyImpl12[TargetOther13,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] = 
        new ADTFoldApplyImpl12[TargetOther13,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] {
          override def fold12[TargetOther12 >: TargetOther13](
            param6: T6 => TargetOther12
          ): ADTFoldApplyImpl11[TargetOther12,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] = 
        new ADTFoldApplyImpl11[TargetOther12,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] {
          override def fold11[TargetOther11 >: TargetOther12](
            param7: T7 => TargetOther11
          ): ADTFoldApplyImpl10[TargetOther11,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] = 
        new ADTFoldApplyImpl10[TargetOther11,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17] {
          override def fold10[TargetOther10 >: TargetOther11](
            param8: T8 => TargetOther10
          ): ADTFoldApplyImpl9[TargetOther10,T9,T10,T11,T12,T13,T14,T15,T16,T17] = 
        new ADTFoldApplyImpl9[TargetOther10,T9,T10,T11,T12,T13,T14,T15,T16,T17] {
          override def fold9[TargetOther9 >: TargetOther10](
            param9: T9 => TargetOther9
          ): ADTFoldApplyImpl8[TargetOther9,T10,T11,T12,T13,T14,T15,T16,T17] = 
        new ADTFoldApplyImpl8[TargetOther9,T10,T11,T12,T13,T14,T15,T16,T17] {
          override def fold8[TargetOther8 >: TargetOther9](
            param10: T10 => TargetOther8
          ): ADTFoldApplyImpl7[TargetOther8,T11,T12,T13,T14,T15,T16,T17] = 
        new ADTFoldApplyImpl7[TargetOther8,T11,T12,T13,T14,T15,T16,T17] {
          override def fold7[TargetOther7 >: TargetOther8](
            param11: T11 => TargetOther7
          ): ADTFoldApplyImpl6[TargetOther7,T12,T13,T14,T15,T16,T17] = 
        new ADTFoldApplyImpl6[TargetOther7,T12,T13,T14,T15,T16,T17] {
          override def fold6[TargetOther6 >: TargetOther7](
            param12: T12 => TargetOther6
          ): ADTFoldApplyImpl5[TargetOther6,T13,T14,T15,T16,T17] = 
        new ADTFoldApplyImpl5[TargetOther6,T13,T14,T15,T16,T17] {
          override def fold5[TargetOther5 >: TargetOther6](
            param13: T13 => TargetOther5
          ): ADTFoldApplyImpl4[TargetOther5,T14,T15,T16,T17] = 
        new ADTFoldApplyImpl4[TargetOther5,T14,T15,T16,T17] {
          override def fold4[TargetOther4 >: TargetOther5](
            param14: T14 => TargetOther4
          ): ADTFoldApplyImpl3[TargetOther4,T15,T16,T17] = 
        new ADTFoldApplyImpl3[TargetOther4,T15,T16,T17] {
          override def fold3[TargetOther3 >: TargetOther4](
            param15: T15 => TargetOther3
          ): ADTFoldApplyImpl2[TargetOther3,T16,T17] = 
        new ADTFoldApplyImpl2[TargetOther3,T16,T17] {
          override def fold2[TargetOther2 >: TargetOther3](
            param16: T16 => TargetOther2
          ): ADTFoldApplyImpl1[TargetOther2,T17] = 
        new ADTFoldApplyImpl1[TargetOther2, T17] {
          override def fold1[TargetOther1 >: TargetOther2](param17: T17 => TargetOther1): TargetOther1 = {
            FoldApplySelf.fold(param1,param2,param3,param4,param5,param6,param7,param8,param9,param10,param11,param12,param13,param14,param15,param16,param17)
          }
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      

      }

      object CoProduct17 {
        //
      }
    

      trait ADTFoldApplyImpl18[
        Target0,
        T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18
      ] {
        FoldApplySelf =>

        def fold18[TargetOther18 >: Target0](param1: T1 => TargetOther18):
          ADTFoldApplyImpl17[TargetOther18,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]
      }

      class CoProduct18[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18](foldImpl: AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.Positive[T15, AdtCoProduct.Use.Positive[T16, AdtCoProduct.Use.Positive[T17, AdtCoProduct.Use.One[T18]]]]]]]]]]]]]]]]]])
        extends AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.Positive[T15, AdtCoProduct.Use.Positive[T16, AdtCoProduct.Use.Positive[T17, AdtCoProduct.Use.One[T18]]]]]]]]]]]]]]]]]]
        with helper1.CoProduct18Helper[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] {
        FoldApplySelf =>

        override def _foldCoProduct[Re](h: T1 => Re, t: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.Positive[T15, AdtCoProduct.Use.Positive[T16, AdtCoProduct.Use.Positive[T17, AdtCoProduct.Use.One[T18]]]]]]]]]]]]]]]]] => Re): Re = foldImpl._foldCoProduct[Re](h, t)

        def drop1: Either[
          T1,
          CoProduct17[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]
        ] = foldImpl._foldCoProduct[Either[T1, CoProduct17[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]]](
          (i1: T1) => Left(i1),
          (i1: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.Positive[T15, AdtCoProduct.Use.Positive[T16, AdtCoProduct.Use.Positive[T17, AdtCoProduct.Use.One[T18]]]]]]]]]]]]]]]]]) => Right(new CoProduct17[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18](i1))
        )

        def map1[U1](func: T1 => U1): CoProduct18[U1, T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] = {
          val valueR = AppendTail3.mapHead(foldImpl)(func)
          new CoProduct18[U1, T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18](valueR)
        }

        def tail: CoProduct18[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18, T1] = {
          val valueR = AppendTailHelper2.appendByDefault(foldImpl)
          new CoProduct18[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18, T1](valueR)
        }

        @inline def fold[Target](param1: T1 => Target,param2: T2 => Target,param3: T3 => Target,param4: T4 => Target,param5: T5 => Target,param6: T6 => Target,param7: T7 => Target,param8: T8 => Target,param9: T9 => Target,param10: T10 => Target,param11: T11 => Target,param12: T12 => Target,param13: T13 => Target,param14: T14 => Target,param15: T15 => Target,param16: T16 => Target,param17: T17 => Target,param18: T18 => Target): Target = {
          val toTarget = AppendTail7[Target]
          val func = toTarget.ToTarget.take(AdtHList.UsePositive.append(param1: T1 => Target, AdtHList.UsePositive.append(param2: T2 => Target, AdtHList.UsePositive.append(param3: T3 => Target, AdtHList.UsePositive.append(param4: T4 => Target, AdtHList.UsePositive.append(param5: T5 => Target, AdtHList.UsePositive.append(param6: T6 => Target, AdtHList.UsePositive.append(param7: T7 => Target, AdtHList.UsePositive.append(param8: T8 => Target, AdtHList.UsePositive.append(param9: T9 => Target, AdtHList.UsePositive.append(param10: T10 => Target, AdtHList.UsePositive.append(param11: T11 => Target, AdtHList.UsePositive.append(param12: T12 => Target, AdtHList.UsePositive.append(param13: T13 => Target, AdtHList.UsePositive.append(param14: T14 => Target, AdtHList.UsePositive.append(param15: T15 => Target, AdtHList.UsePositive.append(param16: T16 => Target, AdtHList.UsePositive.append(param17: T17 => Target, AdtHList.UsePositive.append(param18: T18 => Target, AdtHList.zero)))))))))))))))))))
          func(foldImpl)
        }

        def fold18[TargetOther18](param1: T1 => TargetOther18):
          ADTFoldApplyImpl17[TargetOther18,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] = 
        new ADTFoldApplyImpl17[TargetOther18,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] {
          override def fold17[TargetOther17 >: TargetOther18](
            param2: T2 => TargetOther17
          ): ADTFoldApplyImpl16[TargetOther17,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] = 
        new ADTFoldApplyImpl16[TargetOther17,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] {
          override def fold16[TargetOther16 >: TargetOther17](
            param3: T3 => TargetOther16
          ): ADTFoldApplyImpl15[TargetOther16,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] = 
        new ADTFoldApplyImpl15[TargetOther16,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] {
          override def fold15[TargetOther15 >: TargetOther16](
            param4: T4 => TargetOther15
          ): ADTFoldApplyImpl14[TargetOther15,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] = 
        new ADTFoldApplyImpl14[TargetOther15,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] {
          override def fold14[TargetOther14 >: TargetOther15](
            param5: T5 => TargetOther14
          ): ADTFoldApplyImpl13[TargetOther14,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] = 
        new ADTFoldApplyImpl13[TargetOther14,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] {
          override def fold13[TargetOther13 >: TargetOther14](
            param6: T6 => TargetOther13
          ): ADTFoldApplyImpl12[TargetOther13,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] = 
        new ADTFoldApplyImpl12[TargetOther13,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] {
          override def fold12[TargetOther12 >: TargetOther13](
            param7: T7 => TargetOther12
          ): ADTFoldApplyImpl11[TargetOther12,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] = 
        new ADTFoldApplyImpl11[TargetOther12,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] {
          override def fold11[TargetOther11 >: TargetOther12](
            param8: T8 => TargetOther11
          ): ADTFoldApplyImpl10[TargetOther11,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] = 
        new ADTFoldApplyImpl10[TargetOther11,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18] {
          override def fold10[TargetOther10 >: TargetOther11](
            param9: T9 => TargetOther10
          ): ADTFoldApplyImpl9[TargetOther10,T10,T11,T12,T13,T14,T15,T16,T17,T18] = 
        new ADTFoldApplyImpl9[TargetOther10,T10,T11,T12,T13,T14,T15,T16,T17,T18] {
          override def fold9[TargetOther9 >: TargetOther10](
            param10: T10 => TargetOther9
          ): ADTFoldApplyImpl8[TargetOther9,T11,T12,T13,T14,T15,T16,T17,T18] = 
        new ADTFoldApplyImpl8[TargetOther9,T11,T12,T13,T14,T15,T16,T17,T18] {
          override def fold8[TargetOther8 >: TargetOther9](
            param11: T11 => TargetOther8
          ): ADTFoldApplyImpl7[TargetOther8,T12,T13,T14,T15,T16,T17,T18] = 
        new ADTFoldApplyImpl7[TargetOther8,T12,T13,T14,T15,T16,T17,T18] {
          override def fold7[TargetOther7 >: TargetOther8](
            param12: T12 => TargetOther7
          ): ADTFoldApplyImpl6[TargetOther7,T13,T14,T15,T16,T17,T18] = 
        new ADTFoldApplyImpl6[TargetOther7,T13,T14,T15,T16,T17,T18] {
          override def fold6[TargetOther6 >: TargetOther7](
            param13: T13 => TargetOther6
          ): ADTFoldApplyImpl5[TargetOther6,T14,T15,T16,T17,T18] = 
        new ADTFoldApplyImpl5[TargetOther6,T14,T15,T16,T17,T18] {
          override def fold5[TargetOther5 >: TargetOther6](
            param14: T14 => TargetOther5
          ): ADTFoldApplyImpl4[TargetOther5,T15,T16,T17,T18] = 
        new ADTFoldApplyImpl4[TargetOther5,T15,T16,T17,T18] {
          override def fold4[TargetOther4 >: TargetOther5](
            param15: T15 => TargetOther4
          ): ADTFoldApplyImpl3[TargetOther4,T16,T17,T18] = 
        new ADTFoldApplyImpl3[TargetOther4,T16,T17,T18] {
          override def fold3[TargetOther3 >: TargetOther4](
            param16: T16 => TargetOther3
          ): ADTFoldApplyImpl2[TargetOther3,T17,T18] = 
        new ADTFoldApplyImpl2[TargetOther3,T17,T18] {
          override def fold2[TargetOther2 >: TargetOther3](
            param17: T17 => TargetOther2
          ): ADTFoldApplyImpl1[TargetOther2,T18] = 
        new ADTFoldApplyImpl1[TargetOther2, T18] {
          override def fold1[TargetOther1 >: TargetOther2](param18: T18 => TargetOther1): TargetOther1 = {
            FoldApplySelf.fold(param1,param2,param3,param4,param5,param6,param7,param8,param9,param10,param11,param12,param13,param14,param15,param16,param17,param18)
          }
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      

      }

      object CoProduct18 {
        //
      }
    

      trait ADTFoldApplyImpl19[
        Target0,
        T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19
      ] {
        FoldApplySelf =>

        def fold19[TargetOther19 >: Target0](param1: T1 => TargetOther19):
          ADTFoldApplyImpl18[TargetOther19,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]
      }

      class CoProduct19[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19](foldImpl: AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.Positive[T15, AdtCoProduct.Use.Positive[T16, AdtCoProduct.Use.Positive[T17, AdtCoProduct.Use.Positive[T18, AdtCoProduct.Use.One[T19]]]]]]]]]]]]]]]]]]])
        extends AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.Positive[T15, AdtCoProduct.Use.Positive[T16, AdtCoProduct.Use.Positive[T17, AdtCoProduct.Use.Positive[T18, AdtCoProduct.Use.One[T19]]]]]]]]]]]]]]]]]]]
        with helper1.CoProduct19Helper[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] {
        FoldApplySelf =>

        override def _foldCoProduct[Re](h: T1 => Re, t: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.Positive[T15, AdtCoProduct.Use.Positive[T16, AdtCoProduct.Use.Positive[T17, AdtCoProduct.Use.Positive[T18, AdtCoProduct.Use.One[T19]]]]]]]]]]]]]]]]]] => Re): Re = foldImpl._foldCoProduct[Re](h, t)

        def drop1: Either[
          T1,
          CoProduct18[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]
        ] = foldImpl._foldCoProduct[Either[T1, CoProduct18[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]]](
          (i1: T1) => Left(i1),
          (i1: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.Positive[T15, AdtCoProduct.Use.Positive[T16, AdtCoProduct.Use.Positive[T17, AdtCoProduct.Use.Positive[T18, AdtCoProduct.Use.One[T19]]]]]]]]]]]]]]]]]]) => Right(new CoProduct18[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19](i1))
        )

        def map1[U1](func: T1 => U1): CoProduct19[U1, T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = {
          val valueR = AppendTail3.mapHead(foldImpl)(func)
          new CoProduct19[U1, T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19](valueR)
        }

        def tail: CoProduct19[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19, T1] = {
          val valueR = AppendTailHelper2.appendByDefault(foldImpl)
          new CoProduct19[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19, T1](valueR)
        }

        @inline def fold[Target](param1: T1 => Target,param2: T2 => Target,param3: T3 => Target,param4: T4 => Target,param5: T5 => Target,param6: T6 => Target,param7: T7 => Target,param8: T8 => Target,param9: T9 => Target,param10: T10 => Target,param11: T11 => Target,param12: T12 => Target,param13: T13 => Target,param14: T14 => Target,param15: T15 => Target,param16: T16 => Target,param17: T17 => Target,param18: T18 => Target,param19: T19 => Target): Target = {
          val toTarget = AppendTail7[Target]
          val func = toTarget.ToTarget.take(AdtHList.UsePositive.append(param1: T1 => Target, AdtHList.UsePositive.append(param2: T2 => Target, AdtHList.UsePositive.append(param3: T3 => Target, AdtHList.UsePositive.append(param4: T4 => Target, AdtHList.UsePositive.append(param5: T5 => Target, AdtHList.UsePositive.append(param6: T6 => Target, AdtHList.UsePositive.append(param7: T7 => Target, AdtHList.UsePositive.append(param8: T8 => Target, AdtHList.UsePositive.append(param9: T9 => Target, AdtHList.UsePositive.append(param10: T10 => Target, AdtHList.UsePositive.append(param11: T11 => Target, AdtHList.UsePositive.append(param12: T12 => Target, AdtHList.UsePositive.append(param13: T13 => Target, AdtHList.UsePositive.append(param14: T14 => Target, AdtHList.UsePositive.append(param15: T15 => Target, AdtHList.UsePositive.append(param16: T16 => Target, AdtHList.UsePositive.append(param17: T17 => Target, AdtHList.UsePositive.append(param18: T18 => Target, AdtHList.UsePositive.append(param19: T19 => Target, AdtHList.zero))))))))))))))))))))
          func(foldImpl)
        }

        def fold19[TargetOther19](param1: T1 => TargetOther19):
          ADTFoldApplyImpl18[TargetOther19,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = 
        new ADTFoldApplyImpl18[TargetOther19,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] {
          override def fold18[TargetOther18 >: TargetOther19](
            param2: T2 => TargetOther18
          ): ADTFoldApplyImpl17[TargetOther18,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = 
        new ADTFoldApplyImpl17[TargetOther18,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] {
          override def fold17[TargetOther17 >: TargetOther18](
            param3: T3 => TargetOther17
          ): ADTFoldApplyImpl16[TargetOther17,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = 
        new ADTFoldApplyImpl16[TargetOther17,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] {
          override def fold16[TargetOther16 >: TargetOther17](
            param4: T4 => TargetOther16
          ): ADTFoldApplyImpl15[TargetOther16,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = 
        new ADTFoldApplyImpl15[TargetOther16,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] {
          override def fold15[TargetOther15 >: TargetOther16](
            param5: T5 => TargetOther15
          ): ADTFoldApplyImpl14[TargetOther15,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = 
        new ADTFoldApplyImpl14[TargetOther15,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] {
          override def fold14[TargetOther14 >: TargetOther15](
            param6: T6 => TargetOther14
          ): ADTFoldApplyImpl13[TargetOther14,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = 
        new ADTFoldApplyImpl13[TargetOther14,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] {
          override def fold13[TargetOther13 >: TargetOther14](
            param7: T7 => TargetOther13
          ): ADTFoldApplyImpl12[TargetOther13,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = 
        new ADTFoldApplyImpl12[TargetOther13,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] {
          override def fold12[TargetOther12 >: TargetOther13](
            param8: T8 => TargetOther12
          ): ADTFoldApplyImpl11[TargetOther12,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = 
        new ADTFoldApplyImpl11[TargetOther12,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] {
          override def fold11[TargetOther11 >: TargetOther12](
            param9: T9 => TargetOther11
          ): ADTFoldApplyImpl10[TargetOther11,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = 
        new ADTFoldApplyImpl10[TargetOther11,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19] {
          override def fold10[TargetOther10 >: TargetOther11](
            param10: T10 => TargetOther10
          ): ADTFoldApplyImpl9[TargetOther10,T11,T12,T13,T14,T15,T16,T17,T18,T19] = 
        new ADTFoldApplyImpl9[TargetOther10,T11,T12,T13,T14,T15,T16,T17,T18,T19] {
          override def fold9[TargetOther9 >: TargetOther10](
            param11: T11 => TargetOther9
          ): ADTFoldApplyImpl8[TargetOther9,T12,T13,T14,T15,T16,T17,T18,T19] = 
        new ADTFoldApplyImpl8[TargetOther9,T12,T13,T14,T15,T16,T17,T18,T19] {
          override def fold8[TargetOther8 >: TargetOther9](
            param12: T12 => TargetOther8
          ): ADTFoldApplyImpl7[TargetOther8,T13,T14,T15,T16,T17,T18,T19] = 
        new ADTFoldApplyImpl7[TargetOther8,T13,T14,T15,T16,T17,T18,T19] {
          override def fold7[TargetOther7 >: TargetOther8](
            param13: T13 => TargetOther7
          ): ADTFoldApplyImpl6[TargetOther7,T14,T15,T16,T17,T18,T19] = 
        new ADTFoldApplyImpl6[TargetOther7,T14,T15,T16,T17,T18,T19] {
          override def fold6[TargetOther6 >: TargetOther7](
            param14: T14 => TargetOther6
          ): ADTFoldApplyImpl5[TargetOther6,T15,T16,T17,T18,T19] = 
        new ADTFoldApplyImpl5[TargetOther6,T15,T16,T17,T18,T19] {
          override def fold5[TargetOther5 >: TargetOther6](
            param15: T15 => TargetOther5
          ): ADTFoldApplyImpl4[TargetOther5,T16,T17,T18,T19] = 
        new ADTFoldApplyImpl4[TargetOther5,T16,T17,T18,T19] {
          override def fold4[TargetOther4 >: TargetOther5](
            param16: T16 => TargetOther4
          ): ADTFoldApplyImpl3[TargetOther4,T17,T18,T19] = 
        new ADTFoldApplyImpl3[TargetOther4,T17,T18,T19] {
          override def fold3[TargetOther3 >: TargetOther4](
            param17: T17 => TargetOther3
          ): ADTFoldApplyImpl2[TargetOther3,T18,T19] = 
        new ADTFoldApplyImpl2[TargetOther3,T18,T19] {
          override def fold2[TargetOther2 >: TargetOther3](
            param18: T18 => TargetOther2
          ): ADTFoldApplyImpl1[TargetOther2,T19] = 
        new ADTFoldApplyImpl1[TargetOther2, T19] {
          override def fold1[TargetOther1 >: TargetOther2](param19: T19 => TargetOther1): TargetOther1 = {
            FoldApplySelf.fold(param1,param2,param3,param4,param5,param6,param7,param8,param9,param10,param11,param12,param13,param14,param15,param16,param17,param18,param19)
          }
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      

      }

      object CoProduct19 {
        //
      }
    

      trait ADTFoldApplyImpl20[
        Target0,
        T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20
      ] {
        FoldApplySelf =>

        def fold20[TargetOther20 >: Target0](param1: T1 => TargetOther20):
          ADTFoldApplyImpl19[TargetOther20,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]
      }

      class CoProduct20[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20](foldImpl: AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.Positive[T15, AdtCoProduct.Use.Positive[T16, AdtCoProduct.Use.Positive[T17, AdtCoProduct.Use.Positive[T18, AdtCoProduct.Use.Positive[T19, AdtCoProduct.Use.One[T20]]]]]]]]]]]]]]]]]]]])
        extends AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.Positive[T15, AdtCoProduct.Use.Positive[T16, AdtCoProduct.Use.Positive[T17, AdtCoProduct.Use.Positive[T18, AdtCoProduct.Use.Positive[T19, AdtCoProduct.Use.One[T20]]]]]]]]]]]]]]]]]]]]
        with helper1.CoProduct20Helper[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] {
        FoldApplySelf =>

        override def _foldCoProduct[Re](h: T1 => Re, t: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.Positive[T15, AdtCoProduct.Use.Positive[T16, AdtCoProduct.Use.Positive[T17, AdtCoProduct.Use.Positive[T18, AdtCoProduct.Use.Positive[T19, AdtCoProduct.Use.One[T20]]]]]]]]]]]]]]]]]]] => Re): Re = foldImpl._foldCoProduct[Re](h, t)

        def drop1: Either[
          T1,
          CoProduct19[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]
        ] = foldImpl._foldCoProduct[Either[T1, CoProduct19[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]]](
          (i1: T1) => Left(i1),
          (i1: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.Positive[T15, AdtCoProduct.Use.Positive[T16, AdtCoProduct.Use.Positive[T17, AdtCoProduct.Use.Positive[T18, AdtCoProduct.Use.Positive[T19, AdtCoProduct.Use.One[T20]]]]]]]]]]]]]]]]]]]) => Right(new CoProduct19[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20](i1))
        )

        def map1[U1](func: T1 => U1): CoProduct20[U1, T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = {
          val valueR = AppendTail3.mapHead(foldImpl)(func)
          new CoProduct20[U1, T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20](valueR)
        }

        def tail: CoProduct20[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20, T1] = {
          val valueR = AppendTailHelper2.appendByDefault(foldImpl)
          new CoProduct20[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20, T1](valueR)
        }

        @inline def fold[Target](param1: T1 => Target,param2: T2 => Target,param3: T3 => Target,param4: T4 => Target,param5: T5 => Target,param6: T6 => Target,param7: T7 => Target,param8: T8 => Target,param9: T9 => Target,param10: T10 => Target,param11: T11 => Target,param12: T12 => Target,param13: T13 => Target,param14: T14 => Target,param15: T15 => Target,param16: T16 => Target,param17: T17 => Target,param18: T18 => Target,param19: T19 => Target,param20: T20 => Target): Target = {
          val toTarget = AppendTail7[Target]
          val func = toTarget.ToTarget.take(AdtHList.UsePositive.append(param1: T1 => Target, AdtHList.UsePositive.append(param2: T2 => Target, AdtHList.UsePositive.append(param3: T3 => Target, AdtHList.UsePositive.append(param4: T4 => Target, AdtHList.UsePositive.append(param5: T5 => Target, AdtHList.UsePositive.append(param6: T6 => Target, AdtHList.UsePositive.append(param7: T7 => Target, AdtHList.UsePositive.append(param8: T8 => Target, AdtHList.UsePositive.append(param9: T9 => Target, AdtHList.UsePositive.append(param10: T10 => Target, AdtHList.UsePositive.append(param11: T11 => Target, AdtHList.UsePositive.append(param12: T12 => Target, AdtHList.UsePositive.append(param13: T13 => Target, AdtHList.UsePositive.append(param14: T14 => Target, AdtHList.UsePositive.append(param15: T15 => Target, AdtHList.UsePositive.append(param16: T16 => Target, AdtHList.UsePositive.append(param17: T17 => Target, AdtHList.UsePositive.append(param18: T18 => Target, AdtHList.UsePositive.append(param19: T19 => Target, AdtHList.UsePositive.append(param20: T20 => Target, AdtHList.zero)))))))))))))))))))))
          func(foldImpl)
        }

        def fold20[TargetOther20](param1: T1 => TargetOther20):
          ADTFoldApplyImpl19[TargetOther20,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = 
        new ADTFoldApplyImpl19[TargetOther20,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] {
          override def fold19[TargetOther19 >: TargetOther20](
            param2: T2 => TargetOther19
          ): ADTFoldApplyImpl18[TargetOther19,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = 
        new ADTFoldApplyImpl18[TargetOther19,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] {
          override def fold18[TargetOther18 >: TargetOther19](
            param3: T3 => TargetOther18
          ): ADTFoldApplyImpl17[TargetOther18,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = 
        new ADTFoldApplyImpl17[TargetOther18,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] {
          override def fold17[TargetOther17 >: TargetOther18](
            param4: T4 => TargetOther17
          ): ADTFoldApplyImpl16[TargetOther17,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = 
        new ADTFoldApplyImpl16[TargetOther17,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] {
          override def fold16[TargetOther16 >: TargetOther17](
            param5: T5 => TargetOther16
          ): ADTFoldApplyImpl15[TargetOther16,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = 
        new ADTFoldApplyImpl15[TargetOther16,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] {
          override def fold15[TargetOther15 >: TargetOther16](
            param6: T6 => TargetOther15
          ): ADTFoldApplyImpl14[TargetOther15,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = 
        new ADTFoldApplyImpl14[TargetOther15,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] {
          override def fold14[TargetOther14 >: TargetOther15](
            param7: T7 => TargetOther14
          ): ADTFoldApplyImpl13[TargetOther14,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = 
        new ADTFoldApplyImpl13[TargetOther14,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] {
          override def fold13[TargetOther13 >: TargetOther14](
            param8: T8 => TargetOther13
          ): ADTFoldApplyImpl12[TargetOther13,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = 
        new ADTFoldApplyImpl12[TargetOther13,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] {
          override def fold12[TargetOther12 >: TargetOther13](
            param9: T9 => TargetOther12
          ): ADTFoldApplyImpl11[TargetOther12,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = 
        new ADTFoldApplyImpl11[TargetOther12,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] {
          override def fold11[TargetOther11 >: TargetOther12](
            param10: T10 => TargetOther11
          ): ADTFoldApplyImpl10[TargetOther11,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] = 
        new ADTFoldApplyImpl10[TargetOther11,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20] {
          override def fold10[TargetOther10 >: TargetOther11](
            param11: T11 => TargetOther10
          ): ADTFoldApplyImpl9[TargetOther10,T12,T13,T14,T15,T16,T17,T18,T19,T20] = 
        new ADTFoldApplyImpl9[TargetOther10,T12,T13,T14,T15,T16,T17,T18,T19,T20] {
          override def fold9[TargetOther9 >: TargetOther10](
            param12: T12 => TargetOther9
          ): ADTFoldApplyImpl8[TargetOther9,T13,T14,T15,T16,T17,T18,T19,T20] = 
        new ADTFoldApplyImpl8[TargetOther9,T13,T14,T15,T16,T17,T18,T19,T20] {
          override def fold8[TargetOther8 >: TargetOther9](
            param13: T13 => TargetOther8
          ): ADTFoldApplyImpl7[TargetOther8,T14,T15,T16,T17,T18,T19,T20] = 
        new ADTFoldApplyImpl7[TargetOther8,T14,T15,T16,T17,T18,T19,T20] {
          override def fold7[TargetOther7 >: TargetOther8](
            param14: T14 => TargetOther7
          ): ADTFoldApplyImpl6[TargetOther7,T15,T16,T17,T18,T19,T20] = 
        new ADTFoldApplyImpl6[TargetOther7,T15,T16,T17,T18,T19,T20] {
          override def fold6[TargetOther6 >: TargetOther7](
            param15: T15 => TargetOther6
          ): ADTFoldApplyImpl5[TargetOther6,T16,T17,T18,T19,T20] = 
        new ADTFoldApplyImpl5[TargetOther6,T16,T17,T18,T19,T20] {
          override def fold5[TargetOther5 >: TargetOther6](
            param16: T16 => TargetOther5
          ): ADTFoldApplyImpl4[TargetOther5,T17,T18,T19,T20] = 
        new ADTFoldApplyImpl4[TargetOther5,T17,T18,T19,T20] {
          override def fold4[TargetOther4 >: TargetOther5](
            param17: T17 => TargetOther4
          ): ADTFoldApplyImpl3[TargetOther4,T18,T19,T20] = 
        new ADTFoldApplyImpl3[TargetOther4,T18,T19,T20] {
          override def fold3[TargetOther3 >: TargetOther4](
            param18: T18 => TargetOther3
          ): ADTFoldApplyImpl2[TargetOther3,T19,T20] = 
        new ADTFoldApplyImpl2[TargetOther3,T19,T20] {
          override def fold2[TargetOther2 >: TargetOther3](
            param19: T19 => TargetOther2
          ): ADTFoldApplyImpl1[TargetOther2,T20] = 
        new ADTFoldApplyImpl1[TargetOther2, T20] {
          override def fold1[TargetOther1 >: TargetOther2](param20: T20 => TargetOther1): TargetOther1 = {
            FoldApplySelf.fold(param1,param2,param3,param4,param5,param6,param7,param8,param9,param10,param11,param12,param13,param14,param15,param16,param17,param18,param19,param20)
          }
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      

      }

      object CoProduct20 {
        //
      }
    

      trait ADTFoldApplyImpl21[
        Target0,
        T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21
      ] {
        FoldApplySelf =>

        def fold21[TargetOther21 >: Target0](param1: T1 => TargetOther21):
          ADTFoldApplyImpl20[TargetOther21,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]
      }

      class CoProduct21[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21](foldImpl: AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.Positive[T15, AdtCoProduct.Use.Positive[T16, AdtCoProduct.Use.Positive[T17, AdtCoProduct.Use.Positive[T18, AdtCoProduct.Use.Positive[T19, AdtCoProduct.Use.Positive[T20, AdtCoProduct.Use.One[T21]]]]]]]]]]]]]]]]]]]]])
        extends AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.Positive[T15, AdtCoProduct.Use.Positive[T16, AdtCoProduct.Use.Positive[T17, AdtCoProduct.Use.Positive[T18, AdtCoProduct.Use.Positive[T19, AdtCoProduct.Use.Positive[T20, AdtCoProduct.Use.One[T21]]]]]]]]]]]]]]]]]]]]]
        with helper1.CoProduct21Helper[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] {
        FoldApplySelf =>

        override def _foldCoProduct[Re](h: T1 => Re, t: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.Positive[T15, AdtCoProduct.Use.Positive[T16, AdtCoProduct.Use.Positive[T17, AdtCoProduct.Use.Positive[T18, AdtCoProduct.Use.Positive[T19, AdtCoProduct.Use.Positive[T20, AdtCoProduct.Use.One[T21]]]]]]]]]]]]]]]]]]]] => Re): Re = foldImpl._foldCoProduct[Re](h, t)

        def drop1: Either[
          T1,
          CoProduct20[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]
        ] = foldImpl._foldCoProduct[Either[T1, CoProduct20[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]]](
          (i1: T1) => Left(i1),
          (i1: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.Positive[T15, AdtCoProduct.Use.Positive[T16, AdtCoProduct.Use.Positive[T17, AdtCoProduct.Use.Positive[T18, AdtCoProduct.Use.Positive[T19, AdtCoProduct.Use.Positive[T20, AdtCoProduct.Use.One[T21]]]]]]]]]]]]]]]]]]]]) => Right(new CoProduct20[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21](i1))
        )

        def map1[U1](func: T1 => U1): CoProduct21[U1, T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = {
          val valueR = AppendTail3.mapHead(foldImpl)(func)
          new CoProduct21[U1, T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21](valueR)
        }

        def tail: CoProduct21[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21, T1] = {
          val valueR = AppendTailHelper2.appendByDefault(foldImpl)
          new CoProduct21[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21, T1](valueR)
        }

        @inline def fold[Target](param1: T1 => Target,param2: T2 => Target,param3: T3 => Target,param4: T4 => Target,param5: T5 => Target,param6: T6 => Target,param7: T7 => Target,param8: T8 => Target,param9: T9 => Target,param10: T10 => Target,param11: T11 => Target,param12: T12 => Target,param13: T13 => Target,param14: T14 => Target,param15: T15 => Target,param16: T16 => Target,param17: T17 => Target,param18: T18 => Target,param19: T19 => Target,param20: T20 => Target,param21: T21 => Target): Target = {
          val toTarget = AppendTail7[Target]
          val func = toTarget.ToTarget.take(AdtHList.UsePositive.append(param1: T1 => Target, AdtHList.UsePositive.append(param2: T2 => Target, AdtHList.UsePositive.append(param3: T3 => Target, AdtHList.UsePositive.append(param4: T4 => Target, AdtHList.UsePositive.append(param5: T5 => Target, AdtHList.UsePositive.append(param6: T6 => Target, AdtHList.UsePositive.append(param7: T7 => Target, AdtHList.UsePositive.append(param8: T8 => Target, AdtHList.UsePositive.append(param9: T9 => Target, AdtHList.UsePositive.append(param10: T10 => Target, AdtHList.UsePositive.append(param11: T11 => Target, AdtHList.UsePositive.append(param12: T12 => Target, AdtHList.UsePositive.append(param13: T13 => Target, AdtHList.UsePositive.append(param14: T14 => Target, AdtHList.UsePositive.append(param15: T15 => Target, AdtHList.UsePositive.append(param16: T16 => Target, AdtHList.UsePositive.append(param17: T17 => Target, AdtHList.UsePositive.append(param18: T18 => Target, AdtHList.UsePositive.append(param19: T19 => Target, AdtHList.UsePositive.append(param20: T20 => Target, AdtHList.UsePositive.append(param21: T21 => Target, AdtHList.zero))))))))))))))))))))))
          func(foldImpl)
        }

        def fold21[TargetOther21](param1: T1 => TargetOther21):
          ADTFoldApplyImpl20[TargetOther21,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = 
        new ADTFoldApplyImpl20[TargetOther21,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] {
          override def fold20[TargetOther20 >: TargetOther21](
            param2: T2 => TargetOther20
          ): ADTFoldApplyImpl19[TargetOther20,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = 
        new ADTFoldApplyImpl19[TargetOther20,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] {
          override def fold19[TargetOther19 >: TargetOther20](
            param3: T3 => TargetOther19
          ): ADTFoldApplyImpl18[TargetOther19,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = 
        new ADTFoldApplyImpl18[TargetOther19,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] {
          override def fold18[TargetOther18 >: TargetOther19](
            param4: T4 => TargetOther18
          ): ADTFoldApplyImpl17[TargetOther18,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = 
        new ADTFoldApplyImpl17[TargetOther18,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] {
          override def fold17[TargetOther17 >: TargetOther18](
            param5: T5 => TargetOther17
          ): ADTFoldApplyImpl16[TargetOther17,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = 
        new ADTFoldApplyImpl16[TargetOther17,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] {
          override def fold16[TargetOther16 >: TargetOther17](
            param6: T6 => TargetOther16
          ): ADTFoldApplyImpl15[TargetOther16,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = 
        new ADTFoldApplyImpl15[TargetOther16,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] {
          override def fold15[TargetOther15 >: TargetOther16](
            param7: T7 => TargetOther15
          ): ADTFoldApplyImpl14[TargetOther15,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = 
        new ADTFoldApplyImpl14[TargetOther15,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] {
          override def fold14[TargetOther14 >: TargetOther15](
            param8: T8 => TargetOther14
          ): ADTFoldApplyImpl13[TargetOther14,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = 
        new ADTFoldApplyImpl13[TargetOther14,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] {
          override def fold13[TargetOther13 >: TargetOther14](
            param9: T9 => TargetOther13
          ): ADTFoldApplyImpl12[TargetOther13,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = 
        new ADTFoldApplyImpl12[TargetOther13,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] {
          override def fold12[TargetOther12 >: TargetOther13](
            param10: T10 => TargetOther12
          ): ADTFoldApplyImpl11[TargetOther12,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = 
        new ADTFoldApplyImpl11[TargetOther12,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] {
          override def fold11[TargetOther11 >: TargetOther12](
            param11: T11 => TargetOther11
          ): ADTFoldApplyImpl10[TargetOther11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] = 
        new ADTFoldApplyImpl10[TargetOther11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21] {
          override def fold10[TargetOther10 >: TargetOther11](
            param12: T12 => TargetOther10
          ): ADTFoldApplyImpl9[TargetOther10,T13,T14,T15,T16,T17,T18,T19,T20,T21] = 
        new ADTFoldApplyImpl9[TargetOther10,T13,T14,T15,T16,T17,T18,T19,T20,T21] {
          override def fold9[TargetOther9 >: TargetOther10](
            param13: T13 => TargetOther9
          ): ADTFoldApplyImpl8[TargetOther9,T14,T15,T16,T17,T18,T19,T20,T21] = 
        new ADTFoldApplyImpl8[TargetOther9,T14,T15,T16,T17,T18,T19,T20,T21] {
          override def fold8[TargetOther8 >: TargetOther9](
            param14: T14 => TargetOther8
          ): ADTFoldApplyImpl7[TargetOther8,T15,T16,T17,T18,T19,T20,T21] = 
        new ADTFoldApplyImpl7[TargetOther8,T15,T16,T17,T18,T19,T20,T21] {
          override def fold7[TargetOther7 >: TargetOther8](
            param15: T15 => TargetOther7
          ): ADTFoldApplyImpl6[TargetOther7,T16,T17,T18,T19,T20,T21] = 
        new ADTFoldApplyImpl6[TargetOther7,T16,T17,T18,T19,T20,T21] {
          override def fold6[TargetOther6 >: TargetOther7](
            param16: T16 => TargetOther6
          ): ADTFoldApplyImpl5[TargetOther6,T17,T18,T19,T20,T21] = 
        new ADTFoldApplyImpl5[TargetOther6,T17,T18,T19,T20,T21] {
          override def fold5[TargetOther5 >: TargetOther6](
            param17: T17 => TargetOther5
          ): ADTFoldApplyImpl4[TargetOther5,T18,T19,T20,T21] = 
        new ADTFoldApplyImpl4[TargetOther5,T18,T19,T20,T21] {
          override def fold4[TargetOther4 >: TargetOther5](
            param18: T18 => TargetOther4
          ): ADTFoldApplyImpl3[TargetOther4,T19,T20,T21] = 
        new ADTFoldApplyImpl3[TargetOther4,T19,T20,T21] {
          override def fold3[TargetOther3 >: TargetOther4](
            param19: T19 => TargetOther3
          ): ADTFoldApplyImpl2[TargetOther3,T20,T21] = 
        new ADTFoldApplyImpl2[TargetOther3,T20,T21] {
          override def fold2[TargetOther2 >: TargetOther3](
            param20: T20 => TargetOther2
          ): ADTFoldApplyImpl1[TargetOther2,T21] = 
        new ADTFoldApplyImpl1[TargetOther2, T21] {
          override def fold1[TargetOther1 >: TargetOther2](param21: T21 => TargetOther1): TargetOther1 = {
            FoldApplySelf.fold(param1,param2,param3,param4,param5,param6,param7,param8,param9,param10,param11,param12,param13,param14,param15,param16,param17,param18,param19,param20,param21)
          }
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      

      }

      object CoProduct21 {
        //
      }
    

      trait ADTFoldApplyImpl22[
        Target0,
        T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22
      ] {
        FoldApplySelf =>

        def fold22[TargetOther22 >: Target0](param1: T1 => TargetOther22):
          ADTFoldApplyImpl21[TargetOther22,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]
      }

      class CoProduct22[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22](foldImpl: AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.Positive[T15, AdtCoProduct.Use.Positive[T16, AdtCoProduct.Use.Positive[T17, AdtCoProduct.Use.Positive[T18, AdtCoProduct.Use.Positive[T19, AdtCoProduct.Use.Positive[T20, AdtCoProduct.Use.Positive[T21, AdtCoProduct.Use.One[T22]]]]]]]]]]]]]]]]]]]]]])
        extends AdtCoProduct.Use.Positive[T1, AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.Positive[T15, AdtCoProduct.Use.Positive[T16, AdtCoProduct.Use.Positive[T17, AdtCoProduct.Use.Positive[T18, AdtCoProduct.Use.Positive[T19, AdtCoProduct.Use.Positive[T20, AdtCoProduct.Use.Positive[T21, AdtCoProduct.Use.One[T22]]]]]]]]]]]]]]]]]]]]]]
        with helper1.CoProduct22Helper[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] {
        FoldApplySelf =>

        override def _foldCoProduct[Re](h: T1 => Re, t: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.Positive[T15, AdtCoProduct.Use.Positive[T16, AdtCoProduct.Use.Positive[T17, AdtCoProduct.Use.Positive[T18, AdtCoProduct.Use.Positive[T19, AdtCoProduct.Use.Positive[T20, AdtCoProduct.Use.Positive[T21, AdtCoProduct.Use.One[T22]]]]]]]]]]]]]]]]]]]]] => Re): Re = foldImpl._foldCoProduct[Re](h, t)

        def drop1: Either[
          T1,
          CoProduct21[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]
        ] = foldImpl._foldCoProduct[Either[T1, CoProduct21[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]]](
          (i1: T1) => Left(i1),
          (i1: AdtCoProduct.Use.Positive[T2, AdtCoProduct.Use.Positive[T3, AdtCoProduct.Use.Positive[T4, AdtCoProduct.Use.Positive[T5, AdtCoProduct.Use.Positive[T6, AdtCoProduct.Use.Positive[T7, AdtCoProduct.Use.Positive[T8, AdtCoProduct.Use.Positive[T9, AdtCoProduct.Use.Positive[T10, AdtCoProduct.Use.Positive[T11, AdtCoProduct.Use.Positive[T12, AdtCoProduct.Use.Positive[T13, AdtCoProduct.Use.Positive[T14, AdtCoProduct.Use.Positive[T15, AdtCoProduct.Use.Positive[T16, AdtCoProduct.Use.Positive[T17, AdtCoProduct.Use.Positive[T18, AdtCoProduct.Use.Positive[T19, AdtCoProduct.Use.Positive[T20, AdtCoProduct.Use.Positive[T21, AdtCoProduct.Use.One[T22]]]]]]]]]]]]]]]]]]]]]) => Right(new CoProduct21[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22](i1))
        )

        def map1[U1](func: T1 => U1): CoProduct22[U1, T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = {
          val valueR = AppendTail3.mapHead(foldImpl)(func)
          new CoProduct22[U1, T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22](valueR)
        }

        def tail: CoProduct22[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22, T1] = {
          val valueR = AppendTailHelper2.appendByDefault(foldImpl)
          new CoProduct22[T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22, T1](valueR)
        }

        @inline def fold[Target](param1: T1 => Target,param2: T2 => Target,param3: T3 => Target,param4: T4 => Target,param5: T5 => Target,param6: T6 => Target,param7: T7 => Target,param8: T8 => Target,param9: T9 => Target,param10: T10 => Target,param11: T11 => Target,param12: T12 => Target,param13: T13 => Target,param14: T14 => Target,param15: T15 => Target,param16: T16 => Target,param17: T17 => Target,param18: T18 => Target,param19: T19 => Target,param20: T20 => Target,param21: T21 => Target,param22: T22 => Target): Target = {
          val toTarget = AppendTail7[Target]
          val func = toTarget.ToTarget.take(AdtHList.UsePositive.append(param1: T1 => Target, AdtHList.UsePositive.append(param2: T2 => Target, AdtHList.UsePositive.append(param3: T3 => Target, AdtHList.UsePositive.append(param4: T4 => Target, AdtHList.UsePositive.append(param5: T5 => Target, AdtHList.UsePositive.append(param6: T6 => Target, AdtHList.UsePositive.append(param7: T7 => Target, AdtHList.UsePositive.append(param8: T8 => Target, AdtHList.UsePositive.append(param9: T9 => Target, AdtHList.UsePositive.append(param10: T10 => Target, AdtHList.UsePositive.append(param11: T11 => Target, AdtHList.UsePositive.append(param12: T12 => Target, AdtHList.UsePositive.append(param13: T13 => Target, AdtHList.UsePositive.append(param14: T14 => Target, AdtHList.UsePositive.append(param15: T15 => Target, AdtHList.UsePositive.append(param16: T16 => Target, AdtHList.UsePositive.append(param17: T17 => Target, AdtHList.UsePositive.append(param18: T18 => Target, AdtHList.UsePositive.append(param19: T19 => Target, AdtHList.UsePositive.append(param20: T20 => Target, AdtHList.UsePositive.append(param21: T21 => Target, AdtHList.UsePositive.append(param22: T22 => Target, AdtHList.zero)))))))))))))))))))))))
          func(foldImpl)
        }

        def fold22[TargetOther22](param1: T1 => TargetOther22):
          ADTFoldApplyImpl21[TargetOther22,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = 
        new ADTFoldApplyImpl21[TargetOther22,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] {
          override def fold21[TargetOther21 >: TargetOther22](
            param2: T2 => TargetOther21
          ): ADTFoldApplyImpl20[TargetOther21,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = 
        new ADTFoldApplyImpl20[TargetOther21,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] {
          override def fold20[TargetOther20 >: TargetOther21](
            param3: T3 => TargetOther20
          ): ADTFoldApplyImpl19[TargetOther20,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = 
        new ADTFoldApplyImpl19[TargetOther20,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] {
          override def fold19[TargetOther19 >: TargetOther20](
            param4: T4 => TargetOther19
          ): ADTFoldApplyImpl18[TargetOther19,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = 
        new ADTFoldApplyImpl18[TargetOther19,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] {
          override def fold18[TargetOther18 >: TargetOther19](
            param5: T5 => TargetOther18
          ): ADTFoldApplyImpl17[TargetOther18,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = 
        new ADTFoldApplyImpl17[TargetOther18,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] {
          override def fold17[TargetOther17 >: TargetOther18](
            param6: T6 => TargetOther17
          ): ADTFoldApplyImpl16[TargetOther17,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = 
        new ADTFoldApplyImpl16[TargetOther17,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] {
          override def fold16[TargetOther16 >: TargetOther17](
            param7: T7 => TargetOther16
          ): ADTFoldApplyImpl15[TargetOther16,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = 
        new ADTFoldApplyImpl15[TargetOther16,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] {
          override def fold15[TargetOther15 >: TargetOther16](
            param8: T8 => TargetOther15
          ): ADTFoldApplyImpl14[TargetOther15,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = 
        new ADTFoldApplyImpl14[TargetOther15,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] {
          override def fold14[TargetOther14 >: TargetOther15](
            param9: T9 => TargetOther14
          ): ADTFoldApplyImpl13[TargetOther14,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = 
        new ADTFoldApplyImpl13[TargetOther14,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] {
          override def fold13[TargetOther13 >: TargetOther14](
            param10: T10 => TargetOther13
          ): ADTFoldApplyImpl12[TargetOther13,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = 
        new ADTFoldApplyImpl12[TargetOther13,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] {
          override def fold12[TargetOther12 >: TargetOther13](
            param11: T11 => TargetOther12
          ): ADTFoldApplyImpl11[TargetOther12,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = 
        new ADTFoldApplyImpl11[TargetOther12,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] {
          override def fold11[TargetOther11 >: TargetOther12](
            param12: T12 => TargetOther11
          ): ADTFoldApplyImpl10[TargetOther11,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] = 
        new ADTFoldApplyImpl10[TargetOther11,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22] {
          override def fold10[TargetOther10 >: TargetOther11](
            param13: T13 => TargetOther10
          ): ADTFoldApplyImpl9[TargetOther10,T14,T15,T16,T17,T18,T19,T20,T21,T22] = 
        new ADTFoldApplyImpl9[TargetOther10,T14,T15,T16,T17,T18,T19,T20,T21,T22] {
          override def fold9[TargetOther9 >: TargetOther10](
            param14: T14 => TargetOther9
          ): ADTFoldApplyImpl8[TargetOther9,T15,T16,T17,T18,T19,T20,T21,T22] = 
        new ADTFoldApplyImpl8[TargetOther9,T15,T16,T17,T18,T19,T20,T21,T22] {
          override def fold8[TargetOther8 >: TargetOther9](
            param15: T15 => TargetOther8
          ): ADTFoldApplyImpl7[TargetOther8,T16,T17,T18,T19,T20,T21,T22] = 
        new ADTFoldApplyImpl7[TargetOther8,T16,T17,T18,T19,T20,T21,T22] {
          override def fold7[TargetOther7 >: TargetOther8](
            param16: T16 => TargetOther7
          ): ADTFoldApplyImpl6[TargetOther7,T17,T18,T19,T20,T21,T22] = 
        new ADTFoldApplyImpl6[TargetOther7,T17,T18,T19,T20,T21,T22] {
          override def fold6[TargetOther6 >: TargetOther7](
            param17: T17 => TargetOther6
          ): ADTFoldApplyImpl5[TargetOther6,T18,T19,T20,T21,T22] = 
        new ADTFoldApplyImpl5[TargetOther6,T18,T19,T20,T21,T22] {
          override def fold5[TargetOther5 >: TargetOther6](
            param18: T18 => TargetOther5
          ): ADTFoldApplyImpl4[TargetOther5,T19,T20,T21,T22] = 
        new ADTFoldApplyImpl4[TargetOther5,T19,T20,T21,T22] {
          override def fold4[TargetOther4 >: TargetOther5](
            param19: T19 => TargetOther4
          ): ADTFoldApplyImpl3[TargetOther4,T20,T21,T22] = 
        new ADTFoldApplyImpl3[TargetOther4,T20,T21,T22] {
          override def fold3[TargetOther3 >: TargetOther4](
            param20: T20 => TargetOther3
          ): ADTFoldApplyImpl2[TargetOther3,T21,T22] = 
        new ADTFoldApplyImpl2[TargetOther3,T21,T22] {
          override def fold2[TargetOther2 >: TargetOther3](
            param21: T21 => TargetOther2
          ): ADTFoldApplyImpl1[TargetOther2,T22] = 
        new ADTFoldApplyImpl1[TargetOther2, T22] {
          override def fold1[TargetOther1 >: TargetOther2](param22: T22 => TargetOther1): TargetOther1 = {
            FoldApplySelf.fold(param1,param2,param3,param4,param5,param6,param7,param8,param9,param10,param11,param12,param13,param14,param15,param16,param17,param18,param19,param20,param21,param22)
          }
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      
        }
      

      }

      object CoProduct22 {
        //
      }
    
  