
    package net.scalax.simple.adt
    package nat
    package support

    trait NatNext4[HListLike, AppendLike[_, _ <: HListLike] <: HListLike, ZeroLike <: HListLike] extends NatNext3[HListLike, AppendLike] {
      NatNext4Self =>

      def zeroInstance: ZeroLike

      object Impl2 {
        
      def Support1[
        M[_],
        T1[_]
      ](
        simpleAppender: SimpleProduct1.SimpleAppender[M],
        typeGen: SimpleProduct1.TypeGen[M, T1]
      ): NatNext1.Support1[
        M,
        HListLike,
        ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,
        ZeroLike
      ] = {
        val ctx = new NatNext4Self.Impl1.Support1Context[
          M,
          T1
        ](simpleAppender = simpleAppender, typeGen = typeGen)

        new ctx.SupportInstance[
          ZeroLike
        ] {
          override def current: M[
            ZeroLike
          ] = simpleAppender.zero[ZeroLike](NatNext4Self.zeroInstance)
        }
      }
    

      def Support2[
        M[_,_],
        T1[_],T2[_]
      ](
        simpleAppender: SimpleProduct2.SimpleAppender[M],
        typeGen: SimpleProduct2.TypeGen[M, T1,T2]
      ): NatNext1.Support2[
        M,
        HListLike,HListLike,
        ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,
        ZeroLike,ZeroLike
      ] = {
        val ctx = new NatNext4Self.Impl1.Support2Context[
          M,
          T1,T2
        ](simpleAppender = simpleAppender, typeGen = typeGen)

        new ctx.SupportInstance[
          ZeroLike,ZeroLike
        ] {
          override def current: M[
            ZeroLike,ZeroLike
          ] = simpleAppender.zero[ZeroLike,ZeroLike](NatNext4Self.zeroInstance,NatNext4Self.zeroInstance)
        }
      }
    

      def Support3[
        M[_,_,_],
        T1[_],T2[_],T3[_]
      ](
        simpleAppender: SimpleProduct3.SimpleAppender[M],
        typeGen: SimpleProduct3.TypeGen[M, T1,T2,T3]
      ): NatNext1.Support3[
        M,
        HListLike,HListLike,HListLike,
        ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,
        ZeroLike,ZeroLike,ZeroLike
      ] = {
        val ctx = new NatNext4Self.Impl1.Support3Context[
          M,
          T1,T2,T3
        ](simpleAppender = simpleAppender, typeGen = typeGen)

        new ctx.SupportInstance[
          ZeroLike,ZeroLike,ZeroLike
        ] {
          override def current: M[
            ZeroLike,ZeroLike,ZeroLike
          ] = simpleAppender.zero[ZeroLike,ZeroLike,ZeroLike](NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance)
        }
      }
    

      def Support4[
        M[_,_,_,_],
        T1[_],T2[_],T3[_],T4[_]
      ](
        simpleAppender: SimpleProduct4.SimpleAppender[M],
        typeGen: SimpleProduct4.TypeGen[M, T1,T2,T3,T4]
      ): NatNext1.Support4[
        M,
        HListLike,HListLike,HListLike,HListLike,
        ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,
        ZeroLike,ZeroLike,ZeroLike,ZeroLike
      ] = {
        val ctx = new NatNext4Self.Impl1.Support4Context[
          M,
          T1,T2,T3,T4
        ](simpleAppender = simpleAppender, typeGen = typeGen)

        new ctx.SupportInstance[
          ZeroLike,ZeroLike,ZeroLike,ZeroLike
        ] {
          override def current: M[
            ZeroLike,ZeroLike,ZeroLike,ZeroLike
          ] = simpleAppender.zero[ZeroLike,ZeroLike,ZeroLike,ZeroLike](NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance)
        }
      }
    

      def Support5[
        M[_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_]
      ](
        simpleAppender: SimpleProduct5.SimpleAppender[M],
        typeGen: SimpleProduct5.TypeGen[M, T1,T2,T3,T4,T5]
      ): NatNext1.Support5[
        M,
        HListLike,HListLike,HListLike,HListLike,HListLike,
        ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,
        ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
      ] = {
        val ctx = new NatNext4Self.Impl1.Support5Context[
          M,
          T1,T2,T3,T4,T5
        ](simpleAppender = simpleAppender, typeGen = typeGen)

        new ctx.SupportInstance[
          ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
        ] {
          override def current: M[
            ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
          ] = simpleAppender.zero[ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike](NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance)
        }
      }
    

      def Support6[
        M[_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_]
      ](
        simpleAppender: SimpleProduct6.SimpleAppender[M],
        typeGen: SimpleProduct6.TypeGen[M, T1,T2,T3,T4,T5,T6]
      ): NatNext1.Support6[
        M,
        HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
        ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,
        ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
      ] = {
        val ctx = new NatNext4Self.Impl1.Support6Context[
          M,
          T1,T2,T3,T4,T5,T6
        ](simpleAppender = simpleAppender, typeGen = typeGen)

        new ctx.SupportInstance[
          ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
        ] {
          override def current: M[
            ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
          ] = simpleAppender.zero[ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike](NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance)
        }
      }
    

      def Support7[
        M[_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_]
      ](
        simpleAppender: SimpleProduct7.SimpleAppender[M],
        typeGen: SimpleProduct7.TypeGen[M, T1,T2,T3,T4,T5,T6,T7]
      ): NatNext1.Support7[
        M,
        HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
        ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,
        ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
      ] = {
        val ctx = new NatNext4Self.Impl1.Support7Context[
          M,
          T1,T2,T3,T4,T5,T6,T7
        ](simpleAppender = simpleAppender, typeGen = typeGen)

        new ctx.SupportInstance[
          ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
        ] {
          override def current: M[
            ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
          ] = simpleAppender.zero[ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike](NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance)
        }
      }
    

      def Support8[
        M[_,_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_],T8[_]
      ](
        simpleAppender: SimpleProduct8.SimpleAppender[M],
        typeGen: SimpleProduct8.TypeGen[M, T1,T2,T3,T4,T5,T6,T7,T8]
      ): NatNext1.Support8[
        M,
        HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
        ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,
        ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
      ] = {
        val ctx = new NatNext4Self.Impl1.Support8Context[
          M,
          T1,T2,T3,T4,T5,T6,T7,T8
        ](simpleAppender = simpleAppender, typeGen = typeGen)

        new ctx.SupportInstance[
          ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
        ] {
          override def current: M[
            ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
          ] = simpleAppender.zero[ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike](NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance)
        }
      }
    

      def Support9[
        M[_,_,_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_],T8[_],T9[_]
      ](
        simpleAppender: SimpleProduct9.SimpleAppender[M],
        typeGen: SimpleProduct9.TypeGen[M, T1,T2,T3,T4,T5,T6,T7,T8,T9]
      ): NatNext1.Support9[
        M,
        HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
        ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,
        ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
      ] = {
        val ctx = new NatNext4Self.Impl1.Support9Context[
          M,
          T1,T2,T3,T4,T5,T6,T7,T8,T9
        ](simpleAppender = simpleAppender, typeGen = typeGen)

        new ctx.SupportInstance[
          ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
        ] {
          override def current: M[
            ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
          ] = simpleAppender.zero[ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike](NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance)
        }
      }
    

      def Support10[
        M[_,_,_,_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_],T8[_],T9[_],T10[_]
      ](
        simpleAppender: SimpleProduct10.SimpleAppender[M],
        typeGen: SimpleProduct10.TypeGen[M, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10]
      ): NatNext1.Support10[
        M,
        HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
        ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,
        ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
      ] = {
        val ctx = new NatNext4Self.Impl1.Support10Context[
          M,
          T1,T2,T3,T4,T5,T6,T7,T8,T9,T10
        ](simpleAppender = simpleAppender, typeGen = typeGen)

        new ctx.SupportInstance[
          ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
        ] {
          override def current: M[
            ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
          ] = simpleAppender.zero[ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike](NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance)
        }
      }
    

      def Support11[
        M[_,_,_,_,_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_],T8[_],T9[_],T10[_],T11[_]
      ](
        simpleAppender: SimpleProduct11.SimpleAppender[M],
        typeGen: SimpleProduct11.TypeGen[M, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11]
      ): NatNext1.Support11[
        M,
        HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
        ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,
        ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
      ] = {
        val ctx = new NatNext4Self.Impl1.Support11Context[
          M,
          T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11
        ](simpleAppender = simpleAppender, typeGen = typeGen)

        new ctx.SupportInstance[
          ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
        ] {
          override def current: M[
            ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
          ] = simpleAppender.zero[ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike](NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance)
        }
      }
    

      def Support12[
        M[_,_,_,_,_,_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_],T8[_],T9[_],T10[_],T11[_],T12[_]
      ](
        simpleAppender: SimpleProduct12.SimpleAppender[M],
        typeGen: SimpleProduct12.TypeGen[M, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12]
      ): NatNext1.Support12[
        M,
        HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
        ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,
        ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
      ] = {
        val ctx = new NatNext4Self.Impl1.Support12Context[
          M,
          T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12
        ](simpleAppender = simpleAppender, typeGen = typeGen)

        new ctx.SupportInstance[
          ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
        ] {
          override def current: M[
            ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
          ] = simpleAppender.zero[ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike](NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance)
        }
      }
    

      def Support13[
        M[_,_,_,_,_,_,_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_],T8[_],T9[_],T10[_],T11[_],T12[_],T13[_]
      ](
        simpleAppender: SimpleProduct13.SimpleAppender[M],
        typeGen: SimpleProduct13.TypeGen[M, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13]
      ): NatNext1.Support13[
        M,
        HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
        ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail]})#XUAPPendEach,
        ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
      ] = {
        val ctx = new NatNext4Self.Impl1.Support13Context[
          M,
          T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13
        ](simpleAppender = simpleAppender, typeGen = typeGen)

        new ctx.SupportInstance[
          ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
        ] {
          override def current: M[
            ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
          ] = simpleAppender.zero[ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike](NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance)
        }
      }
    

      def Support14[
        M[_,_,_,_,_,_,_,_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_],T8[_],T9[_],T10[_],T11[_],T12[_],T13[_],T14[_]
      ](
        simpleAppender: SimpleProduct14.SimpleAppender[M],
        typeGen: SimpleProduct14.TypeGen[M, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14]
      ): NatNext1.Support14[
        M,
        HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
        ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail]})#XUAPPendEach,
        ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
      ] = {
        val ctx = new NatNext4Self.Impl1.Support14Context[
          M,
          T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14
        ](simpleAppender = simpleAppender, typeGen = typeGen)

        new ctx.SupportInstance[
          ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
        ] {
          override def current: M[
            ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
          ] = simpleAppender.zero[ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike](NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance)
        }
      }
    

      def Support15[
        M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_],T8[_],T9[_],T10[_],T11[_],T12[_],T13[_],T14[_],T15[_]
      ](
        simpleAppender: SimpleProduct15.SimpleAppender[M],
        typeGen: SimpleProduct15.TypeGen[M, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15]
      ): NatNext1.Support15[
        M,
        HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
        ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail]})#XUAPPendEach,
        ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
      ] = {
        val ctx = new NatNext4Self.Impl1.Support15Context[
          M,
          T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15
        ](simpleAppender = simpleAppender, typeGen = typeGen)

        new ctx.SupportInstance[
          ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
        ] {
          override def current: M[
            ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
          ] = simpleAppender.zero[ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike](NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance)
        }
      }
    

      def Support16[
        M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_],T8[_],T9[_],T10[_],T11[_],T12[_],T13[_],T14[_],T15[_],T16[_]
      ](
        simpleAppender: SimpleProduct16.SimpleAppender[M],
        typeGen: SimpleProduct16.TypeGen[M, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16]
      ): NatNext1.Support16[
        M,
        HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
        ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T16[X12], Tail]})#XUAPPendEach,
        ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
      ] = {
        val ctx = new NatNext4Self.Impl1.Support16Context[
          M,
          T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16
        ](simpleAppender = simpleAppender, typeGen = typeGen)

        new ctx.SupportInstance[
          ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
        ] {
          override def current: M[
            ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
          ] = simpleAppender.zero[ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike](NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance)
        }
      }
    

      def Support17[
        M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_],T8[_],T9[_],T10[_],T11[_],T12[_],T13[_],T14[_],T15[_],T16[_],T17[_]
      ](
        simpleAppender: SimpleProduct17.SimpleAppender[M],
        typeGen: SimpleProduct17.TypeGen[M, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17]
      ): NatNext1.Support17[
        M,
        HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
        ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T16[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T17[X12], Tail]})#XUAPPendEach,
        ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
      ] = {
        val ctx = new NatNext4Self.Impl1.Support17Context[
          M,
          T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17
        ](simpleAppender = simpleAppender, typeGen = typeGen)

        new ctx.SupportInstance[
          ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
        ] {
          override def current: M[
            ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
          ] = simpleAppender.zero[ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike](NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance)
        }
      }
    

      def Support18[
        M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_],T8[_],T9[_],T10[_],T11[_],T12[_],T13[_],T14[_],T15[_],T16[_],T17[_],T18[_]
      ](
        simpleAppender: SimpleProduct18.SimpleAppender[M],
        typeGen: SimpleProduct18.TypeGen[M, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]
      ): NatNext1.Support18[
        M,
        HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
        ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T16[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T17[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T18[X12], Tail]})#XUAPPendEach,
        ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
      ] = {
        val ctx = new NatNext4Self.Impl1.Support18Context[
          M,
          T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18
        ](simpleAppender = simpleAppender, typeGen = typeGen)

        new ctx.SupportInstance[
          ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
        ] {
          override def current: M[
            ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
          ] = simpleAppender.zero[ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike](NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance)
        }
      }
    

      def Support19[
        M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_],T8[_],T9[_],T10[_],T11[_],T12[_],T13[_],T14[_],T15[_],T16[_],T17[_],T18[_],T19[_]
      ](
        simpleAppender: SimpleProduct19.SimpleAppender[M],
        typeGen: SimpleProduct19.TypeGen[M, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]
      ): NatNext1.Support19[
        M,
        HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
        ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T16[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T17[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T18[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T19[X12], Tail]})#XUAPPendEach,
        ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
      ] = {
        val ctx = new NatNext4Self.Impl1.Support19Context[
          M,
          T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19
        ](simpleAppender = simpleAppender, typeGen = typeGen)

        new ctx.SupportInstance[
          ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
        ] {
          override def current: M[
            ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
          ] = simpleAppender.zero[ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike](NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance)
        }
      }
    

      def Support20[
        M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_],T8[_],T9[_],T10[_],T11[_],T12[_],T13[_],T14[_],T15[_],T16[_],T17[_],T18[_],T19[_],T20[_]
      ](
        simpleAppender: SimpleProduct20.SimpleAppender[M],
        typeGen: SimpleProduct20.TypeGen[M, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]
      ): NatNext1.Support20[
        M,
        HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
        ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T16[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T17[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T18[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T19[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T20[X12], Tail]})#XUAPPendEach,
        ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
      ] = {
        val ctx = new NatNext4Self.Impl1.Support20Context[
          M,
          T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20
        ](simpleAppender = simpleAppender, typeGen = typeGen)

        new ctx.SupportInstance[
          ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
        ] {
          override def current: M[
            ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
          ] = simpleAppender.zero[ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike](NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance)
        }
      }
    

      def Support21[
        M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_],T8[_],T9[_],T10[_],T11[_],T12[_],T13[_],T14[_],T15[_],T16[_],T17[_],T18[_],T19[_],T20[_],T21[_]
      ](
        simpleAppender: SimpleProduct21.SimpleAppender[M],
        typeGen: SimpleProduct21.TypeGen[M, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]
      ): NatNext1.Support21[
        M,
        HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
        ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T16[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T17[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T18[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T19[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T20[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T21[X12], Tail]})#XUAPPendEach,
        ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
      ] = {
        val ctx = new NatNext4Self.Impl1.Support21Context[
          M,
          T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21
        ](simpleAppender = simpleAppender, typeGen = typeGen)

        new ctx.SupportInstance[
          ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
        ] {
          override def current: M[
            ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
          ] = simpleAppender.zero[ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike](NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance)
        }
      }
    

      def Support22[
        M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_],T8[_],T9[_],T10[_],T11[_],T12[_],T13[_],T14[_],T15[_],T16[_],T17[_],T18[_],T19[_],T20[_],T21[_],T22[_]
      ](
        simpleAppender: SimpleProduct22.SimpleAppender[M],
        typeGen: SimpleProduct22.TypeGen[M, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]
      ): NatNext1.Support22[
        M,
        HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
        ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T16[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T17[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T18[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T19[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T20[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T21[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T22[X12], Tail]})#XUAPPendEach,
        ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
      ] = {
        val ctx = new NatNext4Self.Impl1.Support22Context[
          M,
          T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22
        ](simpleAppender = simpleAppender, typeGen = typeGen)

        new ctx.SupportInstance[
          ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
        ] {
          override def current: M[
            ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike
          ] = simpleAppender.zero[ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike,ZeroLike](NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance,NatNext4Self.zeroInstance)
        }
      }
    
      }
    }
  