
    package net.scalax.simple.adt
    package nat
    package support

    trait NatNext5[HListLike, AppLike[_, _ <: HListLike] <: HListLike, HZero <: HListLike] {
      NatNext5Self =>

      val extraAbstraction: NatNext4[HListLike, AppLike, HZero]

      final def genSimpleProduct[F[_[_]]](
        length: Int,
        toModel: HListLike => F[({ type AnyF[_] = Any })#AnyF],
        fromModel: F[({ type AnyF[_] = Any })#AnyF] => HListLike
      ): SimpleProductContextX[F] = {
        val autalLen: Int = length - 1

        new SimpleProductContextX[F] {
          
      override final def simpleProduct1: SimpleProduct1.ProductAdapter[F] = new SimpleProduct1.ProductAdapter[F] {
        override final def append[M[_], N1[_]](
          tpGen: SimpleProduct1.TypeGen[M, N1],
          sAppender: SimpleProduct1.SimpleAppender[M]
        ): M[F[N1]] = {
          val ap1 = NatNext5Self.extraAbstraction.Impl2.Support1[M, N1](
              simpleAppender = sAppender,
              typeGen = tpGen
            ).asInstanceOf[
              NatNext1.Support1[
                M,
                HListLike,
                AppLike,
                HListLike
              ]
            ]

          @scala.annotation.tailrec
          def appendImpl1(len: Int, model: NatNext1.Support1[
            M,
            HListLike,
            AppLike,
            HListLike
          ]): NatNext1.Support1[
            M,
            HListLike,
            AppLike,
            HListLike
          ] = {
            if (len > 0) {
              val nextModel = model.next[Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any].asInstanceOf[
                NatNext1.Support1[
                  M,
                  HListLike,
                  AppLike,
                  HListLike
                ]
              ]
              appendImpl1(len - 1, nextModel)
            } else
              model
          }

          def simpleFunc1[U[_]]: ABCFunc[U[Any], HListLike, F[U]] = new ABCFunc[U[Any], HListLike, F[U]] {
            override def takeHead(m: F[U]): U[Any] =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeHead[U[Any], HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[U[Any], HListLike]]
              )
            override def takeTail(m: F[U]): HListLike =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeTail[Any, HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[Any, HListLike]]
              )
            override def append(a: U[Any], b: HListLike): F[U] =
              toModel(NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.append[U[Any], HListLike](a, b)).asInstanceOf[F[U]]
          }

          sAppender.append[
            N1[Any],
            HListLike,
            F[N1]
          ](simpleFunc1[N1])(tpGen.gen[Any], appendImpl1(autalLen, ap1).current)
        }
      }
    

      override final def simpleProduct2: SimpleProduct2.ProductAdapter[F] = new SimpleProduct2.ProductAdapter[F] {
        override final def append[M[_,_], N1[_],N2[_]](
          tpGen: SimpleProduct2.TypeGen[M, N1,N2],
          sAppender: SimpleProduct2.SimpleAppender[M]
        ): M[F[N1],F[N2]] = {
          val ap1 = NatNext5Self.extraAbstraction.Impl2.Support2[M, N1,N2](
              simpleAppender = sAppender,
              typeGen = tpGen
            ).asInstanceOf[
              NatNext1.Support2[
                M,
                HListLike,HListLike,
                AppLike,AppLike,
                HListLike,HListLike
              ]
            ]

          @scala.annotation.tailrec
          def appendImpl1(len: Int, model: NatNext1.Support2[
            M,
            HListLike,HListLike,
            AppLike,AppLike,
            HListLike,HListLike
          ]): NatNext1.Support2[
            M,
            HListLike,HListLike,
            AppLike,AppLike,
            HListLike,HListLike
          ] = {
            if (len > 0) {
              val nextModel = model.next[Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any].asInstanceOf[
                NatNext1.Support2[
                  M,
                  HListLike,HListLike,
                  AppLike,AppLike,
                  HListLike,HListLike
                ]
              ]
              appendImpl1(len - 1, nextModel)
            } else
              model
          }

          def simpleFunc1[U[_]]: ABCFunc[U[Any], HListLike, F[U]] = new ABCFunc[U[Any], HListLike, F[U]] {
            override def takeHead(m: F[U]): U[Any] =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeHead[U[Any], HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[U[Any], HListLike]]
              )
            override def takeTail(m: F[U]): HListLike =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeTail[Any, HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[Any, HListLike]]
              )
            override def append(a: U[Any], b: HListLike): F[U] =
              toModel(NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.append[U[Any], HListLike](a, b)).asInstanceOf[F[U]]
          }

          sAppender.append[
            N1[Any],N2[Any],
            HListLike,HListLike,
            F[N1],F[N2]
          ](simpleFunc1[N1],simpleFunc1[N2])(tpGen.gen[Any], appendImpl1(autalLen, ap1).current)
        }
      }
    

      override final def simpleProduct3: SimpleProduct3.ProductAdapter[F] = new SimpleProduct3.ProductAdapter[F] {
        override final def append[M[_,_,_], N1[_],N2[_],N3[_]](
          tpGen: SimpleProduct3.TypeGen[M, N1,N2,N3],
          sAppender: SimpleProduct3.SimpleAppender[M]
        ): M[F[N1],F[N2],F[N3]] = {
          val ap1 = NatNext5Self.extraAbstraction.Impl2.Support3[M, N1,N2,N3](
              simpleAppender = sAppender,
              typeGen = tpGen
            ).asInstanceOf[
              NatNext1.Support3[
                M,
                HListLike,HListLike,HListLike,
                AppLike,AppLike,AppLike,
                HListLike,HListLike,HListLike
              ]
            ]

          @scala.annotation.tailrec
          def appendImpl1(len: Int, model: NatNext1.Support3[
            M,
            HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike
          ]): NatNext1.Support3[
            M,
            HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike
          ] = {
            if (len > 0) {
              val nextModel = model.next[Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any].asInstanceOf[
                NatNext1.Support3[
                  M,
                  HListLike,HListLike,HListLike,
                  AppLike,AppLike,AppLike,
                  HListLike,HListLike,HListLike
                ]
              ]
              appendImpl1(len - 1, nextModel)
            } else
              model
          }

          def simpleFunc1[U[_]]: ABCFunc[U[Any], HListLike, F[U]] = new ABCFunc[U[Any], HListLike, F[U]] {
            override def takeHead(m: F[U]): U[Any] =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeHead[U[Any], HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[U[Any], HListLike]]
              )
            override def takeTail(m: F[U]): HListLike =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeTail[Any, HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[Any, HListLike]]
              )
            override def append(a: U[Any], b: HListLike): F[U] =
              toModel(NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.append[U[Any], HListLike](a, b)).asInstanceOf[F[U]]
          }

          sAppender.append[
            N1[Any],N2[Any],N3[Any],
            HListLike,HListLike,HListLike,
            F[N1],F[N2],F[N3]
          ](simpleFunc1[N1],simpleFunc1[N2],simpleFunc1[N3])(tpGen.gen[Any], appendImpl1(autalLen, ap1).current)
        }
      }
    

      override final def simpleProduct4: SimpleProduct4.ProductAdapter[F] = new SimpleProduct4.ProductAdapter[F] {
        override final def append[M[_,_,_,_], N1[_],N2[_],N3[_],N4[_]](
          tpGen: SimpleProduct4.TypeGen[M, N1,N2,N3,N4],
          sAppender: SimpleProduct4.SimpleAppender[M]
        ): M[F[N1],F[N2],F[N3],F[N4]] = {
          val ap1 = NatNext5Self.extraAbstraction.Impl2.Support4[M, N1,N2,N3,N4](
              simpleAppender = sAppender,
              typeGen = tpGen
            ).asInstanceOf[
              NatNext1.Support4[
                M,
                HListLike,HListLike,HListLike,HListLike,
                AppLike,AppLike,AppLike,AppLike,
                HListLike,HListLike,HListLike,HListLike
              ]
            ]

          @scala.annotation.tailrec
          def appendImpl1(len: Int, model: NatNext1.Support4[
            M,
            HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike
          ]): NatNext1.Support4[
            M,
            HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike
          ] = {
            if (len > 0) {
              val nextModel = model.next[Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any].asInstanceOf[
                NatNext1.Support4[
                  M,
                  HListLike,HListLike,HListLike,HListLike,
                  AppLike,AppLike,AppLike,AppLike,
                  HListLike,HListLike,HListLike,HListLike
                ]
              ]
              appendImpl1(len - 1, nextModel)
            } else
              model
          }

          def simpleFunc1[U[_]]: ABCFunc[U[Any], HListLike, F[U]] = new ABCFunc[U[Any], HListLike, F[U]] {
            override def takeHead(m: F[U]): U[Any] =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeHead[U[Any], HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[U[Any], HListLike]]
              )
            override def takeTail(m: F[U]): HListLike =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeTail[Any, HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[Any, HListLike]]
              )
            override def append(a: U[Any], b: HListLike): F[U] =
              toModel(NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.append[U[Any], HListLike](a, b)).asInstanceOf[F[U]]
          }

          sAppender.append[
            N1[Any],N2[Any],N3[Any],N4[Any],
            HListLike,HListLike,HListLike,HListLike,
            F[N1],F[N2],F[N3],F[N4]
          ](simpleFunc1[N1],simpleFunc1[N2],simpleFunc1[N3],simpleFunc1[N4])(tpGen.gen[Any], appendImpl1(autalLen, ap1).current)
        }
      }
    

      override final def simpleProduct5: SimpleProduct5.ProductAdapter[F] = new SimpleProduct5.ProductAdapter[F] {
        override final def append[M[_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_]](
          tpGen: SimpleProduct5.TypeGen[M, N1,N2,N3,N4,N5],
          sAppender: SimpleProduct5.SimpleAppender[M]
        ): M[F[N1],F[N2],F[N3],F[N4],F[N5]] = {
          val ap1 = NatNext5Self.extraAbstraction.Impl2.Support5[M, N1,N2,N3,N4,N5](
              simpleAppender = sAppender,
              typeGen = tpGen
            ).asInstanceOf[
              NatNext1.Support5[
                M,
                HListLike,HListLike,HListLike,HListLike,HListLike,
                AppLike,AppLike,AppLike,AppLike,AppLike,
                HListLike,HListLike,HListLike,HListLike,HListLike
              ]
            ]

          @scala.annotation.tailrec
          def appendImpl1(len: Int, model: NatNext1.Support5[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike
          ]): NatNext1.Support5[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike
          ] = {
            if (len > 0) {
              val nextModel = model.next[Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any].asInstanceOf[
                NatNext1.Support5[
                  M,
                  HListLike,HListLike,HListLike,HListLike,HListLike,
                  AppLike,AppLike,AppLike,AppLike,AppLike,
                  HListLike,HListLike,HListLike,HListLike,HListLike
                ]
              ]
              appendImpl1(len - 1, nextModel)
            } else
              model
          }

          def simpleFunc1[U[_]]: ABCFunc[U[Any], HListLike, F[U]] = new ABCFunc[U[Any], HListLike, F[U]] {
            override def takeHead(m: F[U]): U[Any] =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeHead[U[Any], HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[U[Any], HListLike]]
              )
            override def takeTail(m: F[U]): HListLike =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeTail[Any, HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[Any, HListLike]]
              )
            override def append(a: U[Any], b: HListLike): F[U] =
              toModel(NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.append[U[Any], HListLike](a, b)).asInstanceOf[F[U]]
          }

          sAppender.append[
            N1[Any],N2[Any],N3[Any],N4[Any],N5[Any],
            HListLike,HListLike,HListLike,HListLike,HListLike,
            F[N1],F[N2],F[N3],F[N4],F[N5]
          ](simpleFunc1[N1],simpleFunc1[N2],simpleFunc1[N3],simpleFunc1[N4],simpleFunc1[N5])(tpGen.gen[Any], appendImpl1(autalLen, ap1).current)
        }
      }
    

      override final def simpleProduct6: SimpleProduct6.ProductAdapter[F] = new SimpleProduct6.ProductAdapter[F] {
        override final def append[M[_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_]](
          tpGen: SimpleProduct6.TypeGen[M, N1,N2,N3,N4,N5,N6],
          sAppender: SimpleProduct6.SimpleAppender[M]
        ): M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6]] = {
          val ap1 = NatNext5Self.extraAbstraction.Impl2.Support6[M, N1,N2,N3,N4,N5,N6](
              simpleAppender = sAppender,
              typeGen = tpGen
            ).asInstanceOf[
              NatNext1.Support6[
                M,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
              ]
            ]

          @scala.annotation.tailrec
          def appendImpl1(len: Int, model: NatNext1.Support6[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ]): NatNext1.Support6[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ] = {
            if (len > 0) {
              val nextModel = model.next[Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any].asInstanceOf[
                NatNext1.Support6[
                  M,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                  AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
                ]
              ]
              appendImpl1(len - 1, nextModel)
            } else
              model
          }

          def simpleFunc1[U[_]]: ABCFunc[U[Any], HListLike, F[U]] = new ABCFunc[U[Any], HListLike, F[U]] {
            override def takeHead(m: F[U]): U[Any] =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeHead[U[Any], HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[U[Any], HListLike]]
              )
            override def takeTail(m: F[U]): HListLike =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeTail[Any, HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[Any, HListLike]]
              )
            override def append(a: U[Any], b: HListLike): F[U] =
              toModel(NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.append[U[Any], HListLike](a, b)).asInstanceOf[F[U]]
          }

          sAppender.append[
            N1[Any],N2[Any],N3[Any],N4[Any],N5[Any],N6[Any],
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            F[N1],F[N2],F[N3],F[N4],F[N5],F[N6]
          ](simpleFunc1[N1],simpleFunc1[N2],simpleFunc1[N3],simpleFunc1[N4],simpleFunc1[N5],simpleFunc1[N6])(tpGen.gen[Any], appendImpl1(autalLen, ap1).current)
        }
      }
    

      override final def simpleProduct7: SimpleProduct7.ProductAdapter[F] = new SimpleProduct7.ProductAdapter[F] {
        override final def append[M[_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_]](
          tpGen: SimpleProduct7.TypeGen[M, N1,N2,N3,N4,N5,N6,N7],
          sAppender: SimpleProduct7.SimpleAppender[M]
        ): M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7]] = {
          val ap1 = NatNext5Self.extraAbstraction.Impl2.Support7[M, N1,N2,N3,N4,N5,N6,N7](
              simpleAppender = sAppender,
              typeGen = tpGen
            ).asInstanceOf[
              NatNext1.Support7[
                M,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
              ]
            ]

          @scala.annotation.tailrec
          def appendImpl1(len: Int, model: NatNext1.Support7[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ]): NatNext1.Support7[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ] = {
            if (len > 0) {
              val nextModel = model.next[Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any].asInstanceOf[
                NatNext1.Support7[
                  M,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                  AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
                ]
              ]
              appendImpl1(len - 1, nextModel)
            } else
              model
          }

          def simpleFunc1[U[_]]: ABCFunc[U[Any], HListLike, F[U]] = new ABCFunc[U[Any], HListLike, F[U]] {
            override def takeHead(m: F[U]): U[Any] =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeHead[U[Any], HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[U[Any], HListLike]]
              )
            override def takeTail(m: F[U]): HListLike =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeTail[Any, HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[Any, HListLike]]
              )
            override def append(a: U[Any], b: HListLike): F[U] =
              toModel(NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.append[U[Any], HListLike](a, b)).asInstanceOf[F[U]]
          }

          sAppender.append[
            N1[Any],N2[Any],N3[Any],N4[Any],N5[Any],N6[Any],N7[Any],
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7]
          ](simpleFunc1[N1],simpleFunc1[N2],simpleFunc1[N3],simpleFunc1[N4],simpleFunc1[N5],simpleFunc1[N6],simpleFunc1[N7])(tpGen.gen[Any], appendImpl1(autalLen, ap1).current)
        }
      }
    

      override final def simpleProduct8: SimpleProduct8.ProductAdapter[F] = new SimpleProduct8.ProductAdapter[F] {
        override final def append[M[_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_]](
          tpGen: SimpleProduct8.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8],
          sAppender: SimpleProduct8.SimpleAppender[M]
        ): M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8]] = {
          val ap1 = NatNext5Self.extraAbstraction.Impl2.Support8[M, N1,N2,N3,N4,N5,N6,N7,N8](
              simpleAppender = sAppender,
              typeGen = tpGen
            ).asInstanceOf[
              NatNext1.Support8[
                M,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
              ]
            ]

          @scala.annotation.tailrec
          def appendImpl1(len: Int, model: NatNext1.Support8[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ]): NatNext1.Support8[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ] = {
            if (len > 0) {
              val nextModel = model.next[Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any].asInstanceOf[
                NatNext1.Support8[
                  M,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                  AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
                ]
              ]
              appendImpl1(len - 1, nextModel)
            } else
              model
          }

          def simpleFunc1[U[_]]: ABCFunc[U[Any], HListLike, F[U]] = new ABCFunc[U[Any], HListLike, F[U]] {
            override def takeHead(m: F[U]): U[Any] =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeHead[U[Any], HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[U[Any], HListLike]]
              )
            override def takeTail(m: F[U]): HListLike =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeTail[Any, HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[Any, HListLike]]
              )
            override def append(a: U[Any], b: HListLike): F[U] =
              toModel(NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.append[U[Any], HListLike](a, b)).asInstanceOf[F[U]]
          }

          sAppender.append[
            N1[Any],N2[Any],N3[Any],N4[Any],N5[Any],N6[Any],N7[Any],N8[Any],
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8]
          ](simpleFunc1[N1],simpleFunc1[N2],simpleFunc1[N3],simpleFunc1[N4],simpleFunc1[N5],simpleFunc1[N6],simpleFunc1[N7],simpleFunc1[N8])(tpGen.gen[Any], appendImpl1(autalLen, ap1).current)
        }
      }
    

      override final def simpleProduct9: SimpleProduct9.ProductAdapter[F] = new SimpleProduct9.ProductAdapter[F] {
        override final def append[M[_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_]](
          tpGen: SimpleProduct9.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9],
          sAppender: SimpleProduct9.SimpleAppender[M]
        ): M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9]] = {
          val ap1 = NatNext5Self.extraAbstraction.Impl2.Support9[M, N1,N2,N3,N4,N5,N6,N7,N8,N9](
              simpleAppender = sAppender,
              typeGen = tpGen
            ).asInstanceOf[
              NatNext1.Support9[
                M,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
              ]
            ]

          @scala.annotation.tailrec
          def appendImpl1(len: Int, model: NatNext1.Support9[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ]): NatNext1.Support9[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ] = {
            if (len > 0) {
              val nextModel = model.next[Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any].asInstanceOf[
                NatNext1.Support9[
                  M,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                  AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
                ]
              ]
              appendImpl1(len - 1, nextModel)
            } else
              model
          }

          def simpleFunc1[U[_]]: ABCFunc[U[Any], HListLike, F[U]] = new ABCFunc[U[Any], HListLike, F[U]] {
            override def takeHead(m: F[U]): U[Any] =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeHead[U[Any], HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[U[Any], HListLike]]
              )
            override def takeTail(m: F[U]): HListLike =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeTail[Any, HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[Any, HListLike]]
              )
            override def append(a: U[Any], b: HListLike): F[U] =
              toModel(NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.append[U[Any], HListLike](a, b)).asInstanceOf[F[U]]
          }

          sAppender.append[
            N1[Any],N2[Any],N3[Any],N4[Any],N5[Any],N6[Any],N7[Any],N8[Any],N9[Any],
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9]
          ](simpleFunc1[N1],simpleFunc1[N2],simpleFunc1[N3],simpleFunc1[N4],simpleFunc1[N5],simpleFunc1[N6],simpleFunc1[N7],simpleFunc1[N8],simpleFunc1[N9])(tpGen.gen[Any], appendImpl1(autalLen, ap1).current)
        }
      }
    

      override final def simpleProduct10: SimpleProduct10.ProductAdapter[F] = new SimpleProduct10.ProductAdapter[F] {
        override final def append[M[_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_]](
          tpGen: SimpleProduct10.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10],
          sAppender: SimpleProduct10.SimpleAppender[M]
        ): M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10]] = {
          val ap1 = NatNext5Self.extraAbstraction.Impl2.Support10[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10](
              simpleAppender = sAppender,
              typeGen = tpGen
            ).asInstanceOf[
              NatNext1.Support10[
                M,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
              ]
            ]

          @scala.annotation.tailrec
          def appendImpl1(len: Int, model: NatNext1.Support10[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ]): NatNext1.Support10[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ] = {
            if (len > 0) {
              val nextModel = model.next[Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any].asInstanceOf[
                NatNext1.Support10[
                  M,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                  AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
                ]
              ]
              appendImpl1(len - 1, nextModel)
            } else
              model
          }

          def simpleFunc1[U[_]]: ABCFunc[U[Any], HListLike, F[U]] = new ABCFunc[U[Any], HListLike, F[U]] {
            override def takeHead(m: F[U]): U[Any] =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeHead[U[Any], HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[U[Any], HListLike]]
              )
            override def takeTail(m: F[U]): HListLike =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeTail[Any, HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[Any, HListLike]]
              )
            override def append(a: U[Any], b: HListLike): F[U] =
              toModel(NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.append[U[Any], HListLike](a, b)).asInstanceOf[F[U]]
          }

          sAppender.append[
            N1[Any],N2[Any],N3[Any],N4[Any],N5[Any],N6[Any],N7[Any],N8[Any],N9[Any],N10[Any],
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10]
          ](simpleFunc1[N1],simpleFunc1[N2],simpleFunc1[N3],simpleFunc1[N4],simpleFunc1[N5],simpleFunc1[N6],simpleFunc1[N7],simpleFunc1[N8],simpleFunc1[N9],simpleFunc1[N10])(tpGen.gen[Any], appendImpl1(autalLen, ap1).current)
        }
      }
    

      override final def simpleProduct11: SimpleProduct11.ProductAdapter[F] = new SimpleProduct11.ProductAdapter[F] {
        override final def append[M[_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_]](
          tpGen: SimpleProduct11.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11],
          sAppender: SimpleProduct11.SimpleAppender[M]
        ): M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11]] = {
          val ap1 = NatNext5Self.extraAbstraction.Impl2.Support11[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11](
              simpleAppender = sAppender,
              typeGen = tpGen
            ).asInstanceOf[
              NatNext1.Support11[
                M,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
              ]
            ]

          @scala.annotation.tailrec
          def appendImpl1(len: Int, model: NatNext1.Support11[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ]): NatNext1.Support11[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ] = {
            if (len > 0) {
              val nextModel = model.next[Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any].asInstanceOf[
                NatNext1.Support11[
                  M,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                  AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
                ]
              ]
              appendImpl1(len - 1, nextModel)
            } else
              model
          }

          def simpleFunc1[U[_]]: ABCFunc[U[Any], HListLike, F[U]] = new ABCFunc[U[Any], HListLike, F[U]] {
            override def takeHead(m: F[U]): U[Any] =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeHead[U[Any], HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[U[Any], HListLike]]
              )
            override def takeTail(m: F[U]): HListLike =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeTail[Any, HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[Any, HListLike]]
              )
            override def append(a: U[Any], b: HListLike): F[U] =
              toModel(NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.append[U[Any], HListLike](a, b)).asInstanceOf[F[U]]
          }

          sAppender.append[
            N1[Any],N2[Any],N3[Any],N4[Any],N5[Any],N6[Any],N7[Any],N8[Any],N9[Any],N10[Any],N11[Any],
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11]
          ](simpleFunc1[N1],simpleFunc1[N2],simpleFunc1[N3],simpleFunc1[N4],simpleFunc1[N5],simpleFunc1[N6],simpleFunc1[N7],simpleFunc1[N8],simpleFunc1[N9],simpleFunc1[N10],simpleFunc1[N11])(tpGen.gen[Any], appendImpl1(autalLen, ap1).current)
        }
      }
    

      override final def simpleProduct12: SimpleProduct12.ProductAdapter[F] = new SimpleProduct12.ProductAdapter[F] {
        override final def append[M[_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_]](
          tpGen: SimpleProduct12.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12],
          sAppender: SimpleProduct12.SimpleAppender[M]
        ): M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12]] = {
          val ap1 = NatNext5Self.extraAbstraction.Impl2.Support12[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12](
              simpleAppender = sAppender,
              typeGen = tpGen
            ).asInstanceOf[
              NatNext1.Support12[
                M,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
              ]
            ]

          @scala.annotation.tailrec
          def appendImpl1(len: Int, model: NatNext1.Support12[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ]): NatNext1.Support12[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ] = {
            if (len > 0) {
              val nextModel = model.next[Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any].asInstanceOf[
                NatNext1.Support12[
                  M,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                  AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
                ]
              ]
              appendImpl1(len - 1, nextModel)
            } else
              model
          }

          def simpleFunc1[U[_]]: ABCFunc[U[Any], HListLike, F[U]] = new ABCFunc[U[Any], HListLike, F[U]] {
            override def takeHead(m: F[U]): U[Any] =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeHead[U[Any], HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[U[Any], HListLike]]
              )
            override def takeTail(m: F[U]): HListLike =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeTail[Any, HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[Any, HListLike]]
              )
            override def append(a: U[Any], b: HListLike): F[U] =
              toModel(NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.append[U[Any], HListLike](a, b)).asInstanceOf[F[U]]
          }

          sAppender.append[
            N1[Any],N2[Any],N3[Any],N4[Any],N5[Any],N6[Any],N7[Any],N8[Any],N9[Any],N10[Any],N11[Any],N12[Any],
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12]
          ](simpleFunc1[N1],simpleFunc1[N2],simpleFunc1[N3],simpleFunc1[N4],simpleFunc1[N5],simpleFunc1[N6],simpleFunc1[N7],simpleFunc1[N8],simpleFunc1[N9],simpleFunc1[N10],simpleFunc1[N11],simpleFunc1[N12])(tpGen.gen[Any], appendImpl1(autalLen, ap1).current)
        }
      }
    

      override final def simpleProduct13: SimpleProduct13.ProductAdapter[F] = new SimpleProduct13.ProductAdapter[F] {
        override final def append[M[_,_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_]](
          tpGen: SimpleProduct13.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13],
          sAppender: SimpleProduct13.SimpleAppender[M]
        ): M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12],F[N13]] = {
          val ap1 = NatNext5Self.extraAbstraction.Impl2.Support13[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13](
              simpleAppender = sAppender,
              typeGen = tpGen
            ).asInstanceOf[
              NatNext1.Support13[
                M,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
              ]
            ]

          @scala.annotation.tailrec
          def appendImpl1(len: Int, model: NatNext1.Support13[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ]): NatNext1.Support13[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ] = {
            if (len > 0) {
              val nextModel = model.next[Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any].asInstanceOf[
                NatNext1.Support13[
                  M,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                  AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
                ]
              ]
              appendImpl1(len - 1, nextModel)
            } else
              model
          }

          def simpleFunc1[U[_]]: ABCFunc[U[Any], HListLike, F[U]] = new ABCFunc[U[Any], HListLike, F[U]] {
            override def takeHead(m: F[U]): U[Any] =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeHead[U[Any], HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[U[Any], HListLike]]
              )
            override def takeTail(m: F[U]): HListLike =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeTail[Any, HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[Any, HListLike]]
              )
            override def append(a: U[Any], b: HListLike): F[U] =
              toModel(NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.append[U[Any], HListLike](a, b)).asInstanceOf[F[U]]
          }

          sAppender.append[
            N1[Any],N2[Any],N3[Any],N4[Any],N5[Any],N6[Any],N7[Any],N8[Any],N9[Any],N10[Any],N11[Any],N12[Any],N13[Any],
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12],F[N13]
          ](simpleFunc1[N1],simpleFunc1[N2],simpleFunc1[N3],simpleFunc1[N4],simpleFunc1[N5],simpleFunc1[N6],simpleFunc1[N7],simpleFunc1[N8],simpleFunc1[N9],simpleFunc1[N10],simpleFunc1[N11],simpleFunc1[N12],simpleFunc1[N13])(tpGen.gen[Any], appendImpl1(autalLen, ap1).current)
        }
      }
    

      override final def simpleProduct14: SimpleProduct14.ProductAdapter[F] = new SimpleProduct14.ProductAdapter[F] {
        override final def append[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_]](
          tpGen: SimpleProduct14.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14],
          sAppender: SimpleProduct14.SimpleAppender[M]
        ): M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12],F[N13],F[N14]] = {
          val ap1 = NatNext5Self.extraAbstraction.Impl2.Support14[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14](
              simpleAppender = sAppender,
              typeGen = tpGen
            ).asInstanceOf[
              NatNext1.Support14[
                M,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
              ]
            ]

          @scala.annotation.tailrec
          def appendImpl1(len: Int, model: NatNext1.Support14[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ]): NatNext1.Support14[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ] = {
            if (len > 0) {
              val nextModel = model.next[Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any].asInstanceOf[
                NatNext1.Support14[
                  M,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                  AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
                ]
              ]
              appendImpl1(len - 1, nextModel)
            } else
              model
          }

          def simpleFunc1[U[_]]: ABCFunc[U[Any], HListLike, F[U]] = new ABCFunc[U[Any], HListLike, F[U]] {
            override def takeHead(m: F[U]): U[Any] =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeHead[U[Any], HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[U[Any], HListLike]]
              )
            override def takeTail(m: F[U]): HListLike =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeTail[Any, HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[Any, HListLike]]
              )
            override def append(a: U[Any], b: HListLike): F[U] =
              toModel(NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.append[U[Any], HListLike](a, b)).asInstanceOf[F[U]]
          }

          sAppender.append[
            N1[Any],N2[Any],N3[Any],N4[Any],N5[Any],N6[Any],N7[Any],N8[Any],N9[Any],N10[Any],N11[Any],N12[Any],N13[Any],N14[Any],
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12],F[N13],F[N14]
          ](simpleFunc1[N1],simpleFunc1[N2],simpleFunc1[N3],simpleFunc1[N4],simpleFunc1[N5],simpleFunc1[N6],simpleFunc1[N7],simpleFunc1[N8],simpleFunc1[N9],simpleFunc1[N10],simpleFunc1[N11],simpleFunc1[N12],simpleFunc1[N13],simpleFunc1[N14])(tpGen.gen[Any], appendImpl1(autalLen, ap1).current)
        }
      }
    

      override final def simpleProduct15: SimpleProduct15.ProductAdapter[F] = new SimpleProduct15.ProductAdapter[F] {
        override final def append[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_]](
          tpGen: SimpleProduct15.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15],
          sAppender: SimpleProduct15.SimpleAppender[M]
        ): M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12],F[N13],F[N14],F[N15]] = {
          val ap1 = NatNext5Self.extraAbstraction.Impl2.Support15[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15](
              simpleAppender = sAppender,
              typeGen = tpGen
            ).asInstanceOf[
              NatNext1.Support15[
                M,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
              ]
            ]

          @scala.annotation.tailrec
          def appendImpl1(len: Int, model: NatNext1.Support15[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ]): NatNext1.Support15[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ] = {
            if (len > 0) {
              val nextModel = model.next[Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any].asInstanceOf[
                NatNext1.Support15[
                  M,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                  AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
                ]
              ]
              appendImpl1(len - 1, nextModel)
            } else
              model
          }

          def simpleFunc1[U[_]]: ABCFunc[U[Any], HListLike, F[U]] = new ABCFunc[U[Any], HListLike, F[U]] {
            override def takeHead(m: F[U]): U[Any] =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeHead[U[Any], HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[U[Any], HListLike]]
              )
            override def takeTail(m: F[U]): HListLike =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeTail[Any, HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[Any, HListLike]]
              )
            override def append(a: U[Any], b: HListLike): F[U] =
              toModel(NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.append[U[Any], HListLike](a, b)).asInstanceOf[F[U]]
          }

          sAppender.append[
            N1[Any],N2[Any],N3[Any],N4[Any],N5[Any],N6[Any],N7[Any],N8[Any],N9[Any],N10[Any],N11[Any],N12[Any],N13[Any],N14[Any],N15[Any],
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12],F[N13],F[N14],F[N15]
          ](simpleFunc1[N1],simpleFunc1[N2],simpleFunc1[N3],simpleFunc1[N4],simpleFunc1[N5],simpleFunc1[N6],simpleFunc1[N7],simpleFunc1[N8],simpleFunc1[N9],simpleFunc1[N10],simpleFunc1[N11],simpleFunc1[N12],simpleFunc1[N13],simpleFunc1[N14],simpleFunc1[N15])(tpGen.gen[Any], appendImpl1(autalLen, ap1).current)
        }
      }
    

      override final def simpleProduct16: SimpleProduct16.ProductAdapter[F] = new SimpleProduct16.ProductAdapter[F] {
        override final def append[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_],N16[_]](
          tpGen: SimpleProduct16.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16],
          sAppender: SimpleProduct16.SimpleAppender[M]
        ): M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12],F[N13],F[N14],F[N15],F[N16]] = {
          val ap1 = NatNext5Self.extraAbstraction.Impl2.Support16[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16](
              simpleAppender = sAppender,
              typeGen = tpGen
            ).asInstanceOf[
              NatNext1.Support16[
                M,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
              ]
            ]

          @scala.annotation.tailrec
          def appendImpl1(len: Int, model: NatNext1.Support16[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ]): NatNext1.Support16[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ] = {
            if (len > 0) {
              val nextModel = model.next[Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any].asInstanceOf[
                NatNext1.Support16[
                  M,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                  AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
                ]
              ]
              appendImpl1(len - 1, nextModel)
            } else
              model
          }

          def simpleFunc1[U[_]]: ABCFunc[U[Any], HListLike, F[U]] = new ABCFunc[U[Any], HListLike, F[U]] {
            override def takeHead(m: F[U]): U[Any] =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeHead[U[Any], HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[U[Any], HListLike]]
              )
            override def takeTail(m: F[U]): HListLike =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeTail[Any, HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[Any, HListLike]]
              )
            override def append(a: U[Any], b: HListLike): F[U] =
              toModel(NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.append[U[Any], HListLike](a, b)).asInstanceOf[F[U]]
          }

          sAppender.append[
            N1[Any],N2[Any],N3[Any],N4[Any],N5[Any],N6[Any],N7[Any],N8[Any],N9[Any],N10[Any],N11[Any],N12[Any],N13[Any],N14[Any],N15[Any],N16[Any],
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12],F[N13],F[N14],F[N15],F[N16]
          ](simpleFunc1[N1],simpleFunc1[N2],simpleFunc1[N3],simpleFunc1[N4],simpleFunc1[N5],simpleFunc1[N6],simpleFunc1[N7],simpleFunc1[N8],simpleFunc1[N9],simpleFunc1[N10],simpleFunc1[N11],simpleFunc1[N12],simpleFunc1[N13],simpleFunc1[N14],simpleFunc1[N15],simpleFunc1[N16])(tpGen.gen[Any], appendImpl1(autalLen, ap1).current)
        }
      }
    

      override final def simpleProduct17: SimpleProduct17.ProductAdapter[F] = new SimpleProduct17.ProductAdapter[F] {
        override final def append[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_],N16[_],N17[_]](
          tpGen: SimpleProduct17.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17],
          sAppender: SimpleProduct17.SimpleAppender[M]
        ): M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12],F[N13],F[N14],F[N15],F[N16],F[N17]] = {
          val ap1 = NatNext5Self.extraAbstraction.Impl2.Support17[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17](
              simpleAppender = sAppender,
              typeGen = tpGen
            ).asInstanceOf[
              NatNext1.Support17[
                M,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
              ]
            ]

          @scala.annotation.tailrec
          def appendImpl1(len: Int, model: NatNext1.Support17[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ]): NatNext1.Support17[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ] = {
            if (len > 0) {
              val nextModel = model.next[Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any].asInstanceOf[
                NatNext1.Support17[
                  M,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                  AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
                ]
              ]
              appendImpl1(len - 1, nextModel)
            } else
              model
          }

          def simpleFunc1[U[_]]: ABCFunc[U[Any], HListLike, F[U]] = new ABCFunc[U[Any], HListLike, F[U]] {
            override def takeHead(m: F[U]): U[Any] =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeHead[U[Any], HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[U[Any], HListLike]]
              )
            override def takeTail(m: F[U]): HListLike =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeTail[Any, HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[Any, HListLike]]
              )
            override def append(a: U[Any], b: HListLike): F[U] =
              toModel(NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.append[U[Any], HListLike](a, b)).asInstanceOf[F[U]]
          }

          sAppender.append[
            N1[Any],N2[Any],N3[Any],N4[Any],N5[Any],N6[Any],N7[Any],N8[Any],N9[Any],N10[Any],N11[Any],N12[Any],N13[Any],N14[Any],N15[Any],N16[Any],N17[Any],
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12],F[N13],F[N14],F[N15],F[N16],F[N17]
          ](simpleFunc1[N1],simpleFunc1[N2],simpleFunc1[N3],simpleFunc1[N4],simpleFunc1[N5],simpleFunc1[N6],simpleFunc1[N7],simpleFunc1[N8],simpleFunc1[N9],simpleFunc1[N10],simpleFunc1[N11],simpleFunc1[N12],simpleFunc1[N13],simpleFunc1[N14],simpleFunc1[N15],simpleFunc1[N16],simpleFunc1[N17])(tpGen.gen[Any], appendImpl1(autalLen, ap1).current)
        }
      }
    

      override final def simpleProduct18: SimpleProduct18.ProductAdapter[F] = new SimpleProduct18.ProductAdapter[F] {
        override final def append[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_],N16[_],N17[_],N18[_]](
          tpGen: SimpleProduct18.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18],
          sAppender: SimpleProduct18.SimpleAppender[M]
        ): M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12],F[N13],F[N14],F[N15],F[N16],F[N17],F[N18]] = {
          val ap1 = NatNext5Self.extraAbstraction.Impl2.Support18[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18](
              simpleAppender = sAppender,
              typeGen = tpGen
            ).asInstanceOf[
              NatNext1.Support18[
                M,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
              ]
            ]

          @scala.annotation.tailrec
          def appendImpl1(len: Int, model: NatNext1.Support18[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ]): NatNext1.Support18[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ] = {
            if (len > 0) {
              val nextModel = model.next[Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any].asInstanceOf[
                NatNext1.Support18[
                  M,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                  AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
                ]
              ]
              appendImpl1(len - 1, nextModel)
            } else
              model
          }

          def simpleFunc1[U[_]]: ABCFunc[U[Any], HListLike, F[U]] = new ABCFunc[U[Any], HListLike, F[U]] {
            override def takeHead(m: F[U]): U[Any] =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeHead[U[Any], HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[U[Any], HListLike]]
              )
            override def takeTail(m: F[U]): HListLike =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeTail[Any, HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[Any, HListLike]]
              )
            override def append(a: U[Any], b: HListLike): F[U] =
              toModel(NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.append[U[Any], HListLike](a, b)).asInstanceOf[F[U]]
          }

          sAppender.append[
            N1[Any],N2[Any],N3[Any],N4[Any],N5[Any],N6[Any],N7[Any],N8[Any],N9[Any],N10[Any],N11[Any],N12[Any],N13[Any],N14[Any],N15[Any],N16[Any],N17[Any],N18[Any],
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12],F[N13],F[N14],F[N15],F[N16],F[N17],F[N18]
          ](simpleFunc1[N1],simpleFunc1[N2],simpleFunc1[N3],simpleFunc1[N4],simpleFunc1[N5],simpleFunc1[N6],simpleFunc1[N7],simpleFunc1[N8],simpleFunc1[N9],simpleFunc1[N10],simpleFunc1[N11],simpleFunc1[N12],simpleFunc1[N13],simpleFunc1[N14],simpleFunc1[N15],simpleFunc1[N16],simpleFunc1[N17],simpleFunc1[N18])(tpGen.gen[Any], appendImpl1(autalLen, ap1).current)
        }
      }
    

      override final def simpleProduct19: SimpleProduct19.ProductAdapter[F] = new SimpleProduct19.ProductAdapter[F] {
        override final def append[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_],N16[_],N17[_],N18[_],N19[_]](
          tpGen: SimpleProduct19.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18,N19],
          sAppender: SimpleProduct19.SimpleAppender[M]
        ): M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12],F[N13],F[N14],F[N15],F[N16],F[N17],F[N18],F[N19]] = {
          val ap1 = NatNext5Self.extraAbstraction.Impl2.Support19[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18,N19](
              simpleAppender = sAppender,
              typeGen = tpGen
            ).asInstanceOf[
              NatNext1.Support19[
                M,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
              ]
            ]

          @scala.annotation.tailrec
          def appendImpl1(len: Int, model: NatNext1.Support19[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ]): NatNext1.Support19[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ] = {
            if (len > 0) {
              val nextModel = model.next[Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any].asInstanceOf[
                NatNext1.Support19[
                  M,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                  AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
                ]
              ]
              appendImpl1(len - 1, nextModel)
            } else
              model
          }

          def simpleFunc1[U[_]]: ABCFunc[U[Any], HListLike, F[U]] = new ABCFunc[U[Any], HListLike, F[U]] {
            override def takeHead(m: F[U]): U[Any] =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeHead[U[Any], HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[U[Any], HListLike]]
              )
            override def takeTail(m: F[U]): HListLike =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeTail[Any, HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[Any, HListLike]]
              )
            override def append(a: U[Any], b: HListLike): F[U] =
              toModel(NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.append[U[Any], HListLike](a, b)).asInstanceOf[F[U]]
          }

          sAppender.append[
            N1[Any],N2[Any],N3[Any],N4[Any],N5[Any],N6[Any],N7[Any],N8[Any],N9[Any],N10[Any],N11[Any],N12[Any],N13[Any],N14[Any],N15[Any],N16[Any],N17[Any],N18[Any],N19[Any],
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12],F[N13],F[N14],F[N15],F[N16],F[N17],F[N18],F[N19]
          ](simpleFunc1[N1],simpleFunc1[N2],simpleFunc1[N3],simpleFunc1[N4],simpleFunc1[N5],simpleFunc1[N6],simpleFunc1[N7],simpleFunc1[N8],simpleFunc1[N9],simpleFunc1[N10],simpleFunc1[N11],simpleFunc1[N12],simpleFunc1[N13],simpleFunc1[N14],simpleFunc1[N15],simpleFunc1[N16],simpleFunc1[N17],simpleFunc1[N18],simpleFunc1[N19])(tpGen.gen[Any], appendImpl1(autalLen, ap1).current)
        }
      }
    

      override final def simpleProduct20: SimpleProduct20.ProductAdapter[F] = new SimpleProduct20.ProductAdapter[F] {
        override final def append[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_],N16[_],N17[_],N18[_],N19[_],N20[_]](
          tpGen: SimpleProduct20.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18,N19,N20],
          sAppender: SimpleProduct20.SimpleAppender[M]
        ): M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12],F[N13],F[N14],F[N15],F[N16],F[N17],F[N18],F[N19],F[N20]] = {
          val ap1 = NatNext5Self.extraAbstraction.Impl2.Support20[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18,N19,N20](
              simpleAppender = sAppender,
              typeGen = tpGen
            ).asInstanceOf[
              NatNext1.Support20[
                M,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
              ]
            ]

          @scala.annotation.tailrec
          def appendImpl1(len: Int, model: NatNext1.Support20[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ]): NatNext1.Support20[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ] = {
            if (len > 0) {
              val nextModel = model.next[Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any].asInstanceOf[
                NatNext1.Support20[
                  M,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                  AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
                ]
              ]
              appendImpl1(len - 1, nextModel)
            } else
              model
          }

          def simpleFunc1[U[_]]: ABCFunc[U[Any], HListLike, F[U]] = new ABCFunc[U[Any], HListLike, F[U]] {
            override def takeHead(m: F[U]): U[Any] =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeHead[U[Any], HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[U[Any], HListLike]]
              )
            override def takeTail(m: F[U]): HListLike =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeTail[Any, HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[Any, HListLike]]
              )
            override def append(a: U[Any], b: HListLike): F[U] =
              toModel(NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.append[U[Any], HListLike](a, b)).asInstanceOf[F[U]]
          }

          sAppender.append[
            N1[Any],N2[Any],N3[Any],N4[Any],N5[Any],N6[Any],N7[Any],N8[Any],N9[Any],N10[Any],N11[Any],N12[Any],N13[Any],N14[Any],N15[Any],N16[Any],N17[Any],N18[Any],N19[Any],N20[Any],
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12],F[N13],F[N14],F[N15],F[N16],F[N17],F[N18],F[N19],F[N20]
          ](simpleFunc1[N1],simpleFunc1[N2],simpleFunc1[N3],simpleFunc1[N4],simpleFunc1[N5],simpleFunc1[N6],simpleFunc1[N7],simpleFunc1[N8],simpleFunc1[N9],simpleFunc1[N10],simpleFunc1[N11],simpleFunc1[N12],simpleFunc1[N13],simpleFunc1[N14],simpleFunc1[N15],simpleFunc1[N16],simpleFunc1[N17],simpleFunc1[N18],simpleFunc1[N19],simpleFunc1[N20])(tpGen.gen[Any], appendImpl1(autalLen, ap1).current)
        }
      }
    

      override final def simpleProduct21: SimpleProduct21.ProductAdapter[F] = new SimpleProduct21.ProductAdapter[F] {
        override final def append[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_],N16[_],N17[_],N18[_],N19[_],N20[_],N21[_]](
          tpGen: SimpleProduct21.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18,N19,N20,N21],
          sAppender: SimpleProduct21.SimpleAppender[M]
        ): M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12],F[N13],F[N14],F[N15],F[N16],F[N17],F[N18],F[N19],F[N20],F[N21]] = {
          val ap1 = NatNext5Self.extraAbstraction.Impl2.Support21[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18,N19,N20,N21](
              simpleAppender = sAppender,
              typeGen = tpGen
            ).asInstanceOf[
              NatNext1.Support21[
                M,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
              ]
            ]

          @scala.annotation.tailrec
          def appendImpl1(len: Int, model: NatNext1.Support21[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ]): NatNext1.Support21[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ] = {
            if (len > 0) {
              val nextModel = model.next[Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any].asInstanceOf[
                NatNext1.Support21[
                  M,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                  AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
                ]
              ]
              appendImpl1(len - 1, nextModel)
            } else
              model
          }

          def simpleFunc1[U[_]]: ABCFunc[U[Any], HListLike, F[U]] = new ABCFunc[U[Any], HListLike, F[U]] {
            override def takeHead(m: F[U]): U[Any] =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeHead[U[Any], HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[U[Any], HListLike]]
              )
            override def takeTail(m: F[U]): HListLike =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeTail[Any, HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[Any, HListLike]]
              )
            override def append(a: U[Any], b: HListLike): F[U] =
              toModel(NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.append[U[Any], HListLike](a, b)).asInstanceOf[F[U]]
          }

          sAppender.append[
            N1[Any],N2[Any],N3[Any],N4[Any],N5[Any],N6[Any],N7[Any],N8[Any],N9[Any],N10[Any],N11[Any],N12[Any],N13[Any],N14[Any],N15[Any],N16[Any],N17[Any],N18[Any],N19[Any],N20[Any],N21[Any],
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12],F[N13],F[N14],F[N15],F[N16],F[N17],F[N18],F[N19],F[N20],F[N21]
          ](simpleFunc1[N1],simpleFunc1[N2],simpleFunc1[N3],simpleFunc1[N4],simpleFunc1[N5],simpleFunc1[N6],simpleFunc1[N7],simpleFunc1[N8],simpleFunc1[N9],simpleFunc1[N10],simpleFunc1[N11],simpleFunc1[N12],simpleFunc1[N13],simpleFunc1[N14],simpleFunc1[N15],simpleFunc1[N16],simpleFunc1[N17],simpleFunc1[N18],simpleFunc1[N19],simpleFunc1[N20],simpleFunc1[N21])(tpGen.gen[Any], appendImpl1(autalLen, ap1).current)
        }
      }
    

      override final def simpleProduct22: SimpleProduct22.ProductAdapter[F] = new SimpleProduct22.ProductAdapter[F] {
        override final def append[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_],N16[_],N17[_],N18[_],N19[_],N20[_],N21[_],N22[_]](
          tpGen: SimpleProduct22.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18,N19,N20,N21,N22],
          sAppender: SimpleProduct22.SimpleAppender[M]
        ): M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12],F[N13],F[N14],F[N15],F[N16],F[N17],F[N18],F[N19],F[N20],F[N21],F[N22]] = {
          val ap1 = NatNext5Self.extraAbstraction.Impl2.Support22[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18,N19,N20,N21,N22](
              simpleAppender = sAppender,
              typeGen = tpGen
            ).asInstanceOf[
              NatNext1.Support22[
                M,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
              ]
            ]

          @scala.annotation.tailrec
          def appendImpl1(len: Int, model: NatNext1.Support22[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ]): NatNext1.Support22[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
          ] = {
            if (len > 0) {
              val nextModel = model.next[Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any,Any].asInstanceOf[
                NatNext1.Support22[
                  M,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
                  AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,AppLike,
                  HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike
                ]
              ]
              appendImpl1(len - 1, nextModel)
            } else
              model
          }

          def simpleFunc1[U[_]]: ABCFunc[U[Any], HListLike, F[U]] = new ABCFunc[U[Any], HListLike, F[U]] {
            override def takeHead(m: F[U]): U[Any] =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeHead[U[Any], HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[U[Any], HListLike]]
              )
            override def takeTail(m: F[U]): HListLike =
              NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.takeTail[Any, HListLike](
                fromModel(m.asInstanceOf[F[({ type AnyF[_] = Any })#AnyF]]).asInstanceOf[AppLike[Any, HListLike]]
              )
            override def append(a: U[Any], b: HListLike): F[U] =
              toModel(NatNext5Self.extraAbstraction.natNext2Helper.hlistFunc.append[U[Any], HListLike](a, b)).asInstanceOf[F[U]]
          }

          sAppender.append[
            N1[Any],N2[Any],N3[Any],N4[Any],N5[Any],N6[Any],N7[Any],N8[Any],N9[Any],N10[Any],N11[Any],N12[Any],N13[Any],N14[Any],N15[Any],N16[Any],N17[Any],N18[Any],N19[Any],N20[Any],N21[Any],N22[Any],
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12],F[N13],F[N14],F[N15],F[N16],F[N17],F[N18],F[N19],F[N20],F[N21],F[N22]
          ](simpleFunc1[N1],simpleFunc1[N2],simpleFunc1[N3],simpleFunc1[N4],simpleFunc1[N5],simpleFunc1[N6],simpleFunc1[N7],simpleFunc1[N8],simpleFunc1[N9],simpleFunc1[N10],simpleFunc1[N11],simpleFunc1[N12],simpleFunc1[N13],simpleFunc1[N14],simpleFunc1[N15],simpleFunc1[N16],simpleFunc1[N17],simpleFunc1[N18],simpleFunc1[N19],simpleFunc1[N20],simpleFunc1[N21],simpleFunc1[N22])(tpGen.gen[Any], appendImpl1(autalLen, ap1).current)
        }
      }
    
        }
      }
    }
  