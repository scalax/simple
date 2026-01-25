
    package net.scalax.simple.adt
    package nat
    package support

    trait NatNext3[HListLike, AppendLike[_, _ <: HListLike] <: HListLike] {
      NatNext3Self =>

      def natNext2Helper: NatNext2Helper[HListLike, AppendLike]

      object Impl1 {
        
      class Support1Context[
        M[_],
        T1[_]
      ](
        simpleAppender: SimpleAppender1Positive[M],
        typeGen: SimpleProduct1.TypeGen[M, T1]
      ) {
        trait SupportInstance[
          HCollection1 <: HListLike
        ] extends NatNext1.Support1[
          M,
          HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,
          HCollection1
        ] {
          SupportSelf =>
          override def next[XPoint, X1,X2,X3,X4,X5,X6,X7,X8,X9,X10,X11,X12,X13,X14,X15,X16,X17,X18,X19,X20,X21]: NatNext1.Support1[
            M,
            HListLike,
            ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,
            AppendLike[T1[XPoint], HCollection1]
          ] = new SupportInstance[
            AppendLike[T1[XPoint], HCollection1]
          ] {
            override def current: M[
              AppendLike[T1[XPoint], HCollection1]
            ] = NatNext3Self.natNext2Helper.append1[
              M,
              T1[XPoint],
              HCollection1
            ](simpleAppender)(typeGen.gen[XPoint], SupportSelf.current)
          }
        }
      }
    

      class Support2Context[
        M[_,_],
        T1[_],T2[_]
      ](
        simpleAppender: SimpleAppender2Positive[M],
        typeGen: SimpleProduct2.TypeGen[M, T1,T2]
      ) {
        trait SupportInstance[
          HCollection1 <: HListLike,HCollection2 <: HListLike
        ] extends NatNext1.Support2[
          M,
          HListLike,HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,
          HCollection1,HCollection2
        ] {
          SupportSelf =>
          override def next[XPoint, X1,X2,X3,X4,X5,X6,X7,X8,X9,X10,X11,X12,X13,X14,X15,X16,X17,X18,X19,X20,X21]: NatNext1.Support2[
            M,
            HListLike,HListLike,
            ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2]
          ] = new SupportInstance[
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2]
          ] {
            override def current: M[
              AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2]
            ] = NatNext3Self.natNext2Helper.append2[
              M,
              T1[XPoint],T2[XPoint],
              HCollection1,HCollection2
            ](simpleAppender)(typeGen.gen[XPoint], SupportSelf.current)
          }
        }
      }
    

      class Support3Context[
        M[_,_,_],
        T1[_],T2[_],T3[_]
      ](
        simpleAppender: SimpleAppender3Positive[M],
        typeGen: SimpleProduct3.TypeGen[M, T1,T2,T3]
      ) {
        trait SupportInstance[
          HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike
        ] extends NatNext1.Support3[
          M,
          HListLike,HListLike,HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,
          HCollection1,HCollection2,HCollection3
        ] {
          SupportSelf =>
          override def next[XPoint, X1,X2,X3,X4,X5,X6,X7,X8,X9,X10,X11,X12,X13,X14,X15,X16,X17,X18,X19,X20,X21]: NatNext1.Support3[
            M,
            HListLike,HListLike,HListLike,
            ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3]
          ] = new SupportInstance[
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3]
          ] {
            override def current: M[
              AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3]
            ] = NatNext3Self.natNext2Helper.append3[
              M,
              T1[XPoint],T2[XPoint],T3[XPoint],
              HCollection1,HCollection2,HCollection3
            ](simpleAppender)(typeGen.gen[XPoint], SupportSelf.current)
          }
        }
      }
    

      class Support4Context[
        M[_,_,_,_],
        T1[_],T2[_],T3[_],T4[_]
      ](
        simpleAppender: SimpleAppender4Positive[M],
        typeGen: SimpleProduct4.TypeGen[M, T1,T2,T3,T4]
      ) {
        trait SupportInstance[
          HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike
        ] extends NatNext1.Support4[
          M,
          HListLike,HListLike,HListLike,HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,
          HCollection1,HCollection2,HCollection3,HCollection4
        ] {
          SupportSelf =>
          override def next[XPoint, X1,X2,X3,X4,X5,X6,X7,X8,X9,X10,X11,X12,X13,X14,X15,X16,X17,X18,X19,X20,X21]: NatNext1.Support4[
            M,
            HListLike,HListLike,HListLike,HListLike,
            ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4]
          ] = new SupportInstance[
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4]
          ] {
            override def current: M[
              AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4]
            ] = NatNext3Self.natNext2Helper.append4[
              M,
              T1[XPoint],T2[XPoint],T3[XPoint],T4[XPoint],
              HCollection1,HCollection2,HCollection3,HCollection4
            ](simpleAppender)(typeGen.gen[XPoint], SupportSelf.current)
          }
        }
      }
    

      class Support5Context[
        M[_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_]
      ](
        simpleAppender: SimpleAppender5Positive[M],
        typeGen: SimpleProduct5.TypeGen[M, T1,T2,T3,T4,T5]
      ) {
        trait SupportInstance[
          HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike
        ] extends NatNext1.Support5[
          M,
          HListLike,HListLike,HListLike,HListLike,HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,
          HCollection1,HCollection2,HCollection3,HCollection4,HCollection5
        ] {
          SupportSelf =>
          override def next[XPoint, X1,X2,X3,X4,X5,X6,X7,X8,X9,X10,X11,X12,X13,X14,X15,X16,X17,X18,X19,X20,X21]: NatNext1.Support5[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,
            ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5]
          ] = new SupportInstance[
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5]
          ] {
            override def current: M[
              AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5]
            ] = NatNext3Self.natNext2Helper.append5[
              M,
              T1[XPoint],T2[XPoint],T3[XPoint],T4[XPoint],T5[XPoint],
              HCollection1,HCollection2,HCollection3,HCollection4,HCollection5
            ](simpleAppender)(typeGen.gen[XPoint], SupportSelf.current)
          }
        }
      }
    

      class Support6Context[
        M[_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_]
      ](
        simpleAppender: SimpleAppender6Positive[M],
        typeGen: SimpleProduct6.TypeGen[M, T1,T2,T3,T4,T5,T6]
      ) {
        trait SupportInstance[
          HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike
        ] extends NatNext1.Support6[
          M,
          HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,
          HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6
        ] {
          SupportSelf =>
          override def next[XPoint, X1,X2,X3,X4,X5,X6,X7,X8,X9,X10,X11,X12,X13,X14,X15,X16,X17,X18,X19,X20,X21]: NatNext1.Support6[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6]
          ] = new SupportInstance[
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6]
          ] {
            override def current: M[
              AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6]
            ] = NatNext3Self.natNext2Helper.append6[
              M,
              T1[XPoint],T2[XPoint],T3[XPoint],T4[XPoint],T5[XPoint],T6[XPoint],
              HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6
            ](simpleAppender)(typeGen.gen[XPoint], SupportSelf.current)
          }
        }
      }
    

      class Support7Context[
        M[_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_]
      ](
        simpleAppender: SimpleAppender7Positive[M],
        typeGen: SimpleProduct7.TypeGen[M, T1,T2,T3,T4,T5,T6,T7]
      ) {
        trait SupportInstance[
          HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike
        ] extends NatNext1.Support7[
          M,
          HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,
          HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7
        ] {
          SupportSelf =>
          override def next[XPoint, X1,X2,X3,X4,X5,X6,X7,X8,X9,X10,X11,X12,X13,X14,X15,X16,X17,X18,X19,X20,X21]: NatNext1.Support7[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7]
          ] = new SupportInstance[
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7]
          ] {
            override def current: M[
              AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7]
            ] = NatNext3Self.natNext2Helper.append7[
              M,
              T1[XPoint],T2[XPoint],T3[XPoint],T4[XPoint],T5[XPoint],T6[XPoint],T7[XPoint],
              HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7
            ](simpleAppender)(typeGen.gen[XPoint], SupportSelf.current)
          }
        }
      }
    

      class Support8Context[
        M[_,_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_],T8[_]
      ](
        simpleAppender: SimpleAppender8Positive[M],
        typeGen: SimpleProduct8.TypeGen[M, T1,T2,T3,T4,T5,T6,T7,T8]
      ) {
        trait SupportInstance[
          HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike,HCollection8 <: HListLike
        ] extends NatNext1.Support8[
          M,
          HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,
          HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8
        ] {
          SupportSelf =>
          override def next[XPoint, X1,X2,X3,X4,X5,X6,X7,X8,X9,X10,X11,X12,X13,X14,X15,X16,X17,X18,X19,X20,X21]: NatNext1.Support8[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8]
          ] = new SupportInstance[
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8]
          ] {
            override def current: M[
              AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8]
            ] = NatNext3Self.natNext2Helper.append8[
              M,
              T1[XPoint],T2[XPoint],T3[XPoint],T4[XPoint],T5[XPoint],T6[XPoint],T7[XPoint],T8[XPoint],
              HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8
            ](simpleAppender)(typeGen.gen[XPoint], SupportSelf.current)
          }
        }
      }
    

      class Support9Context[
        M[_,_,_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_],T8[_],T9[_]
      ](
        simpleAppender: SimpleAppender9Positive[M],
        typeGen: SimpleProduct9.TypeGen[M, T1,T2,T3,T4,T5,T6,T7,T8,T9]
      ) {
        trait SupportInstance[
          HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike,HCollection8 <: HListLike,HCollection9 <: HListLike
        ] extends NatNext1.Support9[
          M,
          HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,
          HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9
        ] {
          SupportSelf =>
          override def next[XPoint, X1,X2,X3,X4,X5,X6,X7,X8,X9,X10,X11,X12,X13,X14,X15,X16,X17,X18,X19,X20,X21]: NatNext1.Support9[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9]
          ] = new SupportInstance[
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9]
          ] {
            override def current: M[
              AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9]
            ] = NatNext3Self.natNext2Helper.append9[
              M,
              T1[XPoint],T2[XPoint],T3[XPoint],T4[XPoint],T5[XPoint],T6[XPoint],T7[XPoint],T8[XPoint],T9[XPoint],
              HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9
            ](simpleAppender)(typeGen.gen[XPoint], SupportSelf.current)
          }
        }
      }
    

      class Support10Context[
        M[_,_,_,_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_],T8[_],T9[_],T10[_]
      ](
        simpleAppender: SimpleAppender10Positive[M],
        typeGen: SimpleProduct10.TypeGen[M, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10]
      ) {
        trait SupportInstance[
          HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike,HCollection8 <: HListLike,HCollection9 <: HListLike,HCollection10 <: HListLike
        ] extends NatNext1.Support10[
          M,
          HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,
          HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10
        ] {
          SupportSelf =>
          override def next[XPoint, X1,X2,X3,X4,X5,X6,X7,X8,X9,X10,X11,X12,X13,X14,X15,X16,X17,X18,X19,X20,X21]: NatNext1.Support10[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10]
          ] = new SupportInstance[
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10]
          ] {
            override def current: M[
              AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10]
            ] = NatNext3Self.natNext2Helper.append10[
              M,
              T1[XPoint],T2[XPoint],T3[XPoint],T4[XPoint],T5[XPoint],T6[XPoint],T7[XPoint],T8[XPoint],T9[XPoint],T10[XPoint],
              HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10
            ](simpleAppender)(typeGen.gen[XPoint], SupportSelf.current)
          }
        }
      }
    

      class Support11Context[
        M[_,_,_,_,_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_],T8[_],T9[_],T10[_],T11[_]
      ](
        simpleAppender: SimpleAppender11Positive[M],
        typeGen: SimpleProduct11.TypeGen[M, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11]
      ) {
        trait SupportInstance[
          HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike,HCollection8 <: HListLike,HCollection9 <: HListLike,HCollection10 <: HListLike,HCollection11 <: HListLike
        ] extends NatNext1.Support11[
          M,
          HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,
          HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11
        ] {
          SupportSelf =>
          override def next[XPoint, X1,X2,X3,X4,X5,X6,X7,X8,X9,X10,X11,X12,X13,X14,X15,X16,X17,X18,X19,X20,X21]: NatNext1.Support11[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11]
          ] = new SupportInstance[
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11]
          ] {
            override def current: M[
              AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11]
            ] = NatNext3Self.natNext2Helper.append11[
              M,
              T1[XPoint],T2[XPoint],T3[XPoint],T4[XPoint],T5[XPoint],T6[XPoint],T7[XPoint],T8[XPoint],T9[XPoint],T10[XPoint],T11[XPoint],
              HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11
            ](simpleAppender)(typeGen.gen[XPoint], SupportSelf.current)
          }
        }
      }
    

      class Support12Context[
        M[_,_,_,_,_,_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_],T8[_],T9[_],T10[_],T11[_],T12[_]
      ](
        simpleAppender: SimpleAppender12Positive[M],
        typeGen: SimpleProduct12.TypeGen[M, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12]
      ) {
        trait SupportInstance[
          HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike,HCollection8 <: HListLike,HCollection9 <: HListLike,HCollection10 <: HListLike,HCollection11 <: HListLike,HCollection12 <: HListLike
        ] extends NatNext1.Support12[
          M,
          HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,
          HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12
        ] {
          SupportSelf =>
          override def next[XPoint, X1,X2,X3,X4,X5,X6,X7,X8,X9,X10,X11,X12,X13,X14,X15,X16,X17,X18,X19,X20,X21]: NatNext1.Support12[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12]
          ] = new SupportInstance[
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12]
          ] {
            override def current: M[
              AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12]
            ] = NatNext3Self.natNext2Helper.append12[
              M,
              T1[XPoint],T2[XPoint],T3[XPoint],T4[XPoint],T5[XPoint],T6[XPoint],T7[XPoint],T8[XPoint],T9[XPoint],T10[XPoint],T11[XPoint],T12[XPoint],
              HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12
            ](simpleAppender)(typeGen.gen[XPoint], SupportSelf.current)
          }
        }
      }
    

      class Support13Context[
        M[_,_,_,_,_,_,_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_],T8[_],T9[_],T10[_],T11[_],T12[_],T13[_]
      ](
        simpleAppender: SimpleAppender13Positive[M],
        typeGen: SimpleProduct13.TypeGen[M, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13]
      ) {
        trait SupportInstance[
          HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike,HCollection8 <: HListLike,HCollection9 <: HListLike,HCollection10 <: HListLike,HCollection11 <: HListLike,HCollection12 <: HListLike,HCollection13 <: HListLike
        ] extends NatNext1.Support13[
          M,
          HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail]})#XUAPPendEach,
          HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13
        ] {
          SupportSelf =>
          override def next[XPoint, X1,X2,X3,X4,X5,X6,X7,X8,X9,X10,X11,X12,X13,X14,X15,X16,X17,X18,X19,X20,X21]: NatNext1.Support13[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail]})#XUAPPendEach,
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12],AppendLike[T13[XPoint], HCollection13]
          ] = new SupportInstance[
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12],AppendLike[T13[XPoint], HCollection13]
          ] {
            override def current: M[
              AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12],AppendLike[T13[XPoint], HCollection13]
            ] = NatNext3Self.natNext2Helper.append13[
              M,
              T1[XPoint],T2[XPoint],T3[XPoint],T4[XPoint],T5[XPoint],T6[XPoint],T7[XPoint],T8[XPoint],T9[XPoint],T10[XPoint],T11[XPoint],T12[XPoint],T13[XPoint],
              HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13
            ](simpleAppender)(typeGen.gen[XPoint], SupportSelf.current)
          }
        }
      }
    

      class Support14Context[
        M[_,_,_,_,_,_,_,_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_],T8[_],T9[_],T10[_],T11[_],T12[_],T13[_],T14[_]
      ](
        simpleAppender: SimpleAppender14Positive[M],
        typeGen: SimpleProduct14.TypeGen[M, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14]
      ) {
        trait SupportInstance[
          HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike,HCollection8 <: HListLike,HCollection9 <: HListLike,HCollection10 <: HListLike,HCollection11 <: HListLike,HCollection12 <: HListLike,HCollection13 <: HListLike,HCollection14 <: HListLike
        ] extends NatNext1.Support14[
          M,
          HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail]})#XUAPPendEach,
          HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14
        ] {
          SupportSelf =>
          override def next[XPoint, X1,X2,X3,X4,X5,X6,X7,X8,X9,X10,X11,X12,X13,X14,X15,X16,X17,X18,X19,X20,X21]: NatNext1.Support14[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail]})#XUAPPendEach,
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12],AppendLike[T13[XPoint], HCollection13],AppendLike[T14[XPoint], HCollection14]
          ] = new SupportInstance[
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12],AppendLike[T13[XPoint], HCollection13],AppendLike[T14[XPoint], HCollection14]
          ] {
            override def current: M[
              AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12],AppendLike[T13[XPoint], HCollection13],AppendLike[T14[XPoint], HCollection14]
            ] = NatNext3Self.natNext2Helper.append14[
              M,
              T1[XPoint],T2[XPoint],T3[XPoint],T4[XPoint],T5[XPoint],T6[XPoint],T7[XPoint],T8[XPoint],T9[XPoint],T10[XPoint],T11[XPoint],T12[XPoint],T13[XPoint],T14[XPoint],
              HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14
            ](simpleAppender)(typeGen.gen[XPoint], SupportSelf.current)
          }
        }
      }
    

      class Support15Context[
        M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_],T8[_],T9[_],T10[_],T11[_],T12[_],T13[_],T14[_],T15[_]
      ](
        simpleAppender: SimpleAppender15Positive[M],
        typeGen: SimpleProduct15.TypeGen[M, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15]
      ) {
        trait SupportInstance[
          HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike,HCollection8 <: HListLike,HCollection9 <: HListLike,HCollection10 <: HListLike,HCollection11 <: HListLike,HCollection12 <: HListLike,HCollection13 <: HListLike,HCollection14 <: HListLike,HCollection15 <: HListLike
        ] extends NatNext1.Support15[
          M,
          HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail]})#XUAPPendEach,
          HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15
        ] {
          SupportSelf =>
          override def next[XPoint, X1,X2,X3,X4,X5,X6,X7,X8,X9,X10,X11,X12,X13,X14,X15,X16,X17,X18,X19,X20,X21]: NatNext1.Support15[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail]})#XUAPPendEach,
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12],AppendLike[T13[XPoint], HCollection13],AppendLike[T14[XPoint], HCollection14],AppendLike[T15[XPoint], HCollection15]
          ] = new SupportInstance[
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12],AppendLike[T13[XPoint], HCollection13],AppendLike[T14[XPoint], HCollection14],AppendLike[T15[XPoint], HCollection15]
          ] {
            override def current: M[
              AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12],AppendLike[T13[XPoint], HCollection13],AppendLike[T14[XPoint], HCollection14],AppendLike[T15[XPoint], HCollection15]
            ] = NatNext3Self.natNext2Helper.append15[
              M,
              T1[XPoint],T2[XPoint],T3[XPoint],T4[XPoint],T5[XPoint],T6[XPoint],T7[XPoint],T8[XPoint],T9[XPoint],T10[XPoint],T11[XPoint],T12[XPoint],T13[XPoint],T14[XPoint],T15[XPoint],
              HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15
            ](simpleAppender)(typeGen.gen[XPoint], SupportSelf.current)
          }
        }
      }
    

      class Support16Context[
        M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_],T8[_],T9[_],T10[_],T11[_],T12[_],T13[_],T14[_],T15[_],T16[_]
      ](
        simpleAppender: SimpleAppender16Positive[M],
        typeGen: SimpleProduct16.TypeGen[M, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16]
      ) {
        trait SupportInstance[
          HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike,HCollection8 <: HListLike,HCollection9 <: HListLike,HCollection10 <: HListLike,HCollection11 <: HListLike,HCollection12 <: HListLike,HCollection13 <: HListLike,HCollection14 <: HListLike,HCollection15 <: HListLike,HCollection16 <: HListLike
        ] extends NatNext1.Support16[
          M,
          HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T16[X12], Tail]})#XUAPPendEach,
          HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15,HCollection16
        ] {
          SupportSelf =>
          override def next[XPoint, X1,X2,X3,X4,X5,X6,X7,X8,X9,X10,X11,X12,X13,X14,X15,X16,X17,X18,X19,X20,X21]: NatNext1.Support16[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T16[X12], Tail]})#XUAPPendEach,
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12],AppendLike[T13[XPoint], HCollection13],AppendLike[T14[XPoint], HCollection14],AppendLike[T15[XPoint], HCollection15],AppendLike[T16[XPoint], HCollection16]
          ] = new SupportInstance[
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12],AppendLike[T13[XPoint], HCollection13],AppendLike[T14[XPoint], HCollection14],AppendLike[T15[XPoint], HCollection15],AppendLike[T16[XPoint], HCollection16]
          ] {
            override def current: M[
              AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12],AppendLike[T13[XPoint], HCollection13],AppendLike[T14[XPoint], HCollection14],AppendLike[T15[XPoint], HCollection15],AppendLike[T16[XPoint], HCollection16]
            ] = NatNext3Self.natNext2Helper.append16[
              M,
              T1[XPoint],T2[XPoint],T3[XPoint],T4[XPoint],T5[XPoint],T6[XPoint],T7[XPoint],T8[XPoint],T9[XPoint],T10[XPoint],T11[XPoint],T12[XPoint],T13[XPoint],T14[XPoint],T15[XPoint],T16[XPoint],
              HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15,HCollection16
            ](simpleAppender)(typeGen.gen[XPoint], SupportSelf.current)
          }
        }
      }
    

      class Support17Context[
        M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_],T8[_],T9[_],T10[_],T11[_],T12[_],T13[_],T14[_],T15[_],T16[_],T17[_]
      ](
        simpleAppender: SimpleAppender17Positive[M],
        typeGen: SimpleProduct17.TypeGen[M, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17]
      ) {
        trait SupportInstance[
          HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike,HCollection8 <: HListLike,HCollection9 <: HListLike,HCollection10 <: HListLike,HCollection11 <: HListLike,HCollection12 <: HListLike,HCollection13 <: HListLike,HCollection14 <: HListLike,HCollection15 <: HListLike,HCollection16 <: HListLike,HCollection17 <: HListLike
        ] extends NatNext1.Support17[
          M,
          HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T16[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T17[X12], Tail]})#XUAPPendEach,
          HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15,HCollection16,HCollection17
        ] {
          SupportSelf =>
          override def next[XPoint, X1,X2,X3,X4,X5,X6,X7,X8,X9,X10,X11,X12,X13,X14,X15,X16,X17,X18,X19,X20,X21]: NatNext1.Support17[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T16[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T17[X12], Tail]})#XUAPPendEach,
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12],AppendLike[T13[XPoint], HCollection13],AppendLike[T14[XPoint], HCollection14],AppendLike[T15[XPoint], HCollection15],AppendLike[T16[XPoint], HCollection16],AppendLike[T17[XPoint], HCollection17]
          ] = new SupportInstance[
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12],AppendLike[T13[XPoint], HCollection13],AppendLike[T14[XPoint], HCollection14],AppendLike[T15[XPoint], HCollection15],AppendLike[T16[XPoint], HCollection16],AppendLike[T17[XPoint], HCollection17]
          ] {
            override def current: M[
              AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12],AppendLike[T13[XPoint], HCollection13],AppendLike[T14[XPoint], HCollection14],AppendLike[T15[XPoint], HCollection15],AppendLike[T16[XPoint], HCollection16],AppendLike[T17[XPoint], HCollection17]
            ] = NatNext3Self.natNext2Helper.append17[
              M,
              T1[XPoint],T2[XPoint],T3[XPoint],T4[XPoint],T5[XPoint],T6[XPoint],T7[XPoint],T8[XPoint],T9[XPoint],T10[XPoint],T11[XPoint],T12[XPoint],T13[XPoint],T14[XPoint],T15[XPoint],T16[XPoint],T17[XPoint],
              HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15,HCollection16,HCollection17
            ](simpleAppender)(typeGen.gen[XPoint], SupportSelf.current)
          }
        }
      }
    

      class Support18Context[
        M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_],T8[_],T9[_],T10[_],T11[_],T12[_],T13[_],T14[_],T15[_],T16[_],T17[_],T18[_]
      ](
        simpleAppender: SimpleAppender18Positive[M],
        typeGen: SimpleProduct18.TypeGen[M, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18]
      ) {
        trait SupportInstance[
          HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike,HCollection8 <: HListLike,HCollection9 <: HListLike,HCollection10 <: HListLike,HCollection11 <: HListLike,HCollection12 <: HListLike,HCollection13 <: HListLike,HCollection14 <: HListLike,HCollection15 <: HListLike,HCollection16 <: HListLike,HCollection17 <: HListLike,HCollection18 <: HListLike
        ] extends NatNext1.Support18[
          M,
          HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T16[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T17[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T18[X12], Tail]})#XUAPPendEach,
          HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15,HCollection16,HCollection17,HCollection18
        ] {
          SupportSelf =>
          override def next[XPoint, X1,X2,X3,X4,X5,X6,X7,X8,X9,X10,X11,X12,X13,X14,X15,X16,X17,X18,X19,X20,X21]: NatNext1.Support18[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T16[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T17[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T18[X12], Tail]})#XUAPPendEach,
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12],AppendLike[T13[XPoint], HCollection13],AppendLike[T14[XPoint], HCollection14],AppendLike[T15[XPoint], HCollection15],AppendLike[T16[XPoint], HCollection16],AppendLike[T17[XPoint], HCollection17],AppendLike[T18[XPoint], HCollection18]
          ] = new SupportInstance[
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12],AppendLike[T13[XPoint], HCollection13],AppendLike[T14[XPoint], HCollection14],AppendLike[T15[XPoint], HCollection15],AppendLike[T16[XPoint], HCollection16],AppendLike[T17[XPoint], HCollection17],AppendLike[T18[XPoint], HCollection18]
          ] {
            override def current: M[
              AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12],AppendLike[T13[XPoint], HCollection13],AppendLike[T14[XPoint], HCollection14],AppendLike[T15[XPoint], HCollection15],AppendLike[T16[XPoint], HCollection16],AppendLike[T17[XPoint], HCollection17],AppendLike[T18[XPoint], HCollection18]
            ] = NatNext3Self.natNext2Helper.append18[
              M,
              T1[XPoint],T2[XPoint],T3[XPoint],T4[XPoint],T5[XPoint],T6[XPoint],T7[XPoint],T8[XPoint],T9[XPoint],T10[XPoint],T11[XPoint],T12[XPoint],T13[XPoint],T14[XPoint],T15[XPoint],T16[XPoint],T17[XPoint],T18[XPoint],
              HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15,HCollection16,HCollection17,HCollection18
            ](simpleAppender)(typeGen.gen[XPoint], SupportSelf.current)
          }
        }
      }
    

      class Support19Context[
        M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_],T8[_],T9[_],T10[_],T11[_],T12[_],T13[_],T14[_],T15[_],T16[_],T17[_],T18[_],T19[_]
      ](
        simpleAppender: SimpleAppender19Positive[M],
        typeGen: SimpleProduct19.TypeGen[M, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19]
      ) {
        trait SupportInstance[
          HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike,HCollection8 <: HListLike,HCollection9 <: HListLike,HCollection10 <: HListLike,HCollection11 <: HListLike,HCollection12 <: HListLike,HCollection13 <: HListLike,HCollection14 <: HListLike,HCollection15 <: HListLike,HCollection16 <: HListLike,HCollection17 <: HListLike,HCollection18 <: HListLike,HCollection19 <: HListLike
        ] extends NatNext1.Support19[
          M,
          HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T16[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T17[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T18[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T19[X12], Tail]})#XUAPPendEach,
          HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15,HCollection16,HCollection17,HCollection18,HCollection19
        ] {
          SupportSelf =>
          override def next[XPoint, X1,X2,X3,X4,X5,X6,X7,X8,X9,X10,X11,X12,X13,X14,X15,X16,X17,X18,X19,X20,X21]: NatNext1.Support19[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T16[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T17[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T18[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T19[X12], Tail]})#XUAPPendEach,
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12],AppendLike[T13[XPoint], HCollection13],AppendLike[T14[XPoint], HCollection14],AppendLike[T15[XPoint], HCollection15],AppendLike[T16[XPoint], HCollection16],AppendLike[T17[XPoint], HCollection17],AppendLike[T18[XPoint], HCollection18],AppendLike[T19[XPoint], HCollection19]
          ] = new SupportInstance[
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12],AppendLike[T13[XPoint], HCollection13],AppendLike[T14[XPoint], HCollection14],AppendLike[T15[XPoint], HCollection15],AppendLike[T16[XPoint], HCollection16],AppendLike[T17[XPoint], HCollection17],AppendLike[T18[XPoint], HCollection18],AppendLike[T19[XPoint], HCollection19]
          ] {
            override def current: M[
              AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12],AppendLike[T13[XPoint], HCollection13],AppendLike[T14[XPoint], HCollection14],AppendLike[T15[XPoint], HCollection15],AppendLike[T16[XPoint], HCollection16],AppendLike[T17[XPoint], HCollection17],AppendLike[T18[XPoint], HCollection18],AppendLike[T19[XPoint], HCollection19]
            ] = NatNext3Self.natNext2Helper.append19[
              M,
              T1[XPoint],T2[XPoint],T3[XPoint],T4[XPoint],T5[XPoint],T6[XPoint],T7[XPoint],T8[XPoint],T9[XPoint],T10[XPoint],T11[XPoint],T12[XPoint],T13[XPoint],T14[XPoint],T15[XPoint],T16[XPoint],T17[XPoint],T18[XPoint],T19[XPoint],
              HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15,HCollection16,HCollection17,HCollection18,HCollection19
            ](simpleAppender)(typeGen.gen[XPoint], SupportSelf.current)
          }
        }
      }
    

      class Support20Context[
        M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_],T8[_],T9[_],T10[_],T11[_],T12[_],T13[_],T14[_],T15[_],T16[_],T17[_],T18[_],T19[_],T20[_]
      ](
        simpleAppender: SimpleAppender20Positive[M],
        typeGen: SimpleProduct20.TypeGen[M, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20]
      ) {
        trait SupportInstance[
          HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike,HCollection8 <: HListLike,HCollection9 <: HListLike,HCollection10 <: HListLike,HCollection11 <: HListLike,HCollection12 <: HListLike,HCollection13 <: HListLike,HCollection14 <: HListLike,HCollection15 <: HListLike,HCollection16 <: HListLike,HCollection17 <: HListLike,HCollection18 <: HListLike,HCollection19 <: HListLike,HCollection20 <: HListLike
        ] extends NatNext1.Support20[
          M,
          HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T16[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T17[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T18[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T19[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T20[X12], Tail]})#XUAPPendEach,
          HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15,HCollection16,HCollection17,HCollection18,HCollection19,HCollection20
        ] {
          SupportSelf =>
          override def next[XPoint, X1,X2,X3,X4,X5,X6,X7,X8,X9,X10,X11,X12,X13,X14,X15,X16,X17,X18,X19,X20,X21]: NatNext1.Support20[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T16[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T17[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T18[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T19[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T20[X12], Tail]})#XUAPPendEach,
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12],AppendLike[T13[XPoint], HCollection13],AppendLike[T14[XPoint], HCollection14],AppendLike[T15[XPoint], HCollection15],AppendLike[T16[XPoint], HCollection16],AppendLike[T17[XPoint], HCollection17],AppendLike[T18[XPoint], HCollection18],AppendLike[T19[XPoint], HCollection19],AppendLike[T20[XPoint], HCollection20]
          ] = new SupportInstance[
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12],AppendLike[T13[XPoint], HCollection13],AppendLike[T14[XPoint], HCollection14],AppendLike[T15[XPoint], HCollection15],AppendLike[T16[XPoint], HCollection16],AppendLike[T17[XPoint], HCollection17],AppendLike[T18[XPoint], HCollection18],AppendLike[T19[XPoint], HCollection19],AppendLike[T20[XPoint], HCollection20]
          ] {
            override def current: M[
              AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12],AppendLike[T13[XPoint], HCollection13],AppendLike[T14[XPoint], HCollection14],AppendLike[T15[XPoint], HCollection15],AppendLike[T16[XPoint], HCollection16],AppendLike[T17[XPoint], HCollection17],AppendLike[T18[XPoint], HCollection18],AppendLike[T19[XPoint], HCollection19],AppendLike[T20[XPoint], HCollection20]
            ] = NatNext3Self.natNext2Helper.append20[
              M,
              T1[XPoint],T2[XPoint],T3[XPoint],T4[XPoint],T5[XPoint],T6[XPoint],T7[XPoint],T8[XPoint],T9[XPoint],T10[XPoint],T11[XPoint],T12[XPoint],T13[XPoint],T14[XPoint],T15[XPoint],T16[XPoint],T17[XPoint],T18[XPoint],T19[XPoint],T20[XPoint],
              HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15,HCollection16,HCollection17,HCollection18,HCollection19,HCollection20
            ](simpleAppender)(typeGen.gen[XPoint], SupportSelf.current)
          }
        }
      }
    

      class Support21Context[
        M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_],T8[_],T9[_],T10[_],T11[_],T12[_],T13[_],T14[_],T15[_],T16[_],T17[_],T18[_],T19[_],T20[_],T21[_]
      ](
        simpleAppender: SimpleAppender21Positive[M],
        typeGen: SimpleProduct21.TypeGen[M, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21]
      ) {
        trait SupportInstance[
          HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike,HCollection8 <: HListLike,HCollection9 <: HListLike,HCollection10 <: HListLike,HCollection11 <: HListLike,HCollection12 <: HListLike,HCollection13 <: HListLike,HCollection14 <: HListLike,HCollection15 <: HListLike,HCollection16 <: HListLike,HCollection17 <: HListLike,HCollection18 <: HListLike,HCollection19 <: HListLike,HCollection20 <: HListLike,HCollection21 <: HListLike
        ] extends NatNext1.Support21[
          M,
          HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T16[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T17[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T18[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T19[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T20[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T21[X12], Tail]})#XUAPPendEach,
          HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15,HCollection16,HCollection17,HCollection18,HCollection19,HCollection20,HCollection21
        ] {
          SupportSelf =>
          override def next[XPoint, X1,X2,X3,X4,X5,X6,X7,X8,X9,X10,X11,X12,X13,X14,X15,X16,X17,X18,X19,X20,X21]: NatNext1.Support21[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T16[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T17[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T18[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T19[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T20[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T21[X12], Tail]})#XUAPPendEach,
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12],AppendLike[T13[XPoint], HCollection13],AppendLike[T14[XPoint], HCollection14],AppendLike[T15[XPoint], HCollection15],AppendLike[T16[XPoint], HCollection16],AppendLike[T17[XPoint], HCollection17],AppendLike[T18[XPoint], HCollection18],AppendLike[T19[XPoint], HCollection19],AppendLike[T20[XPoint], HCollection20],AppendLike[T21[XPoint], HCollection21]
          ] = new SupportInstance[
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12],AppendLike[T13[XPoint], HCollection13],AppendLike[T14[XPoint], HCollection14],AppendLike[T15[XPoint], HCollection15],AppendLike[T16[XPoint], HCollection16],AppendLike[T17[XPoint], HCollection17],AppendLike[T18[XPoint], HCollection18],AppendLike[T19[XPoint], HCollection19],AppendLike[T20[XPoint], HCollection20],AppendLike[T21[XPoint], HCollection21]
          ] {
            override def current: M[
              AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12],AppendLike[T13[XPoint], HCollection13],AppendLike[T14[XPoint], HCollection14],AppendLike[T15[XPoint], HCollection15],AppendLike[T16[XPoint], HCollection16],AppendLike[T17[XPoint], HCollection17],AppendLike[T18[XPoint], HCollection18],AppendLike[T19[XPoint], HCollection19],AppendLike[T20[XPoint], HCollection20],AppendLike[T21[XPoint], HCollection21]
            ] = NatNext3Self.natNext2Helper.append21[
              M,
              T1[XPoint],T2[XPoint],T3[XPoint],T4[XPoint],T5[XPoint],T6[XPoint],T7[XPoint],T8[XPoint],T9[XPoint],T10[XPoint],T11[XPoint],T12[XPoint],T13[XPoint],T14[XPoint],T15[XPoint],T16[XPoint],T17[XPoint],T18[XPoint],T19[XPoint],T20[XPoint],T21[XPoint],
              HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15,HCollection16,HCollection17,HCollection18,HCollection19,HCollection20,HCollection21
            ](simpleAppender)(typeGen.gen[XPoint], SupportSelf.current)
          }
        }
      }
    

      class Support22Context[
        M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_],
        T1[_],T2[_],T3[_],T4[_],T5[_],T6[_],T7[_],T8[_],T9[_],T10[_],T11[_],T12[_],T13[_],T14[_],T15[_],T16[_],T17[_],T18[_],T19[_],T20[_],T21[_],T22[_]
      ](
        simpleAppender: SimpleAppender22Positive[M],
        typeGen: SimpleProduct22.TypeGen[M, T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22]
      ) {
        trait SupportInstance[
          HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike,HCollection8 <: HListLike,HCollection9 <: HListLike,HCollection10 <: HListLike,HCollection11 <: HListLike,HCollection12 <: HListLike,HCollection13 <: HListLike,HCollection14 <: HListLike,HCollection15 <: HListLike,HCollection16 <: HListLike,HCollection17 <: HListLike,HCollection18 <: HListLike,HCollection19 <: HListLike,HCollection20 <: HListLike,HCollection21 <: HListLike,HCollection22 <: HListLike
        ] extends NatNext1.Support22[
          M,
          HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
          ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T16[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T17[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T18[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T19[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T20[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T21[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T22[X12], Tail]})#XUAPPendEach,
          HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15,HCollection16,HCollection17,HCollection18,HCollection19,HCollection20,HCollection21,HCollection22
        ] {
          SupportSelf =>
          override def next[XPoint, X1,X2,X3,X4,X5,X6,X7,X8,X9,X10,X11,X12,X13,X14,X15,X16,X17,X18,X19,X20,X21]: NatNext1.Support22[
            M,
            HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,HListLike,
            ({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T1[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T2[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T3[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T4[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T5[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T6[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T7[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T8[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T9[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T10[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T11[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T12[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T13[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T14[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T15[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T16[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T17[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T18[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T19[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T20[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T21[X12], Tail]})#XUAPPendEach,({ type XUAPPendEach[X12, Tail <: HListLike] = AppendLike[T22[X12], Tail]})#XUAPPendEach,
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12],AppendLike[T13[XPoint], HCollection13],AppendLike[T14[XPoint], HCollection14],AppendLike[T15[XPoint], HCollection15],AppendLike[T16[XPoint], HCollection16],AppendLike[T17[XPoint], HCollection17],AppendLike[T18[XPoint], HCollection18],AppendLike[T19[XPoint], HCollection19],AppendLike[T20[XPoint], HCollection20],AppendLike[T21[XPoint], HCollection21],AppendLike[T22[XPoint], HCollection22]
          ] = new SupportInstance[
            AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12],AppendLike[T13[XPoint], HCollection13],AppendLike[T14[XPoint], HCollection14],AppendLike[T15[XPoint], HCollection15],AppendLike[T16[XPoint], HCollection16],AppendLike[T17[XPoint], HCollection17],AppendLike[T18[XPoint], HCollection18],AppendLike[T19[XPoint], HCollection19],AppendLike[T20[XPoint], HCollection20],AppendLike[T21[XPoint], HCollection21],AppendLike[T22[XPoint], HCollection22]
          ] {
            override def current: M[
              AppendLike[T1[XPoint], HCollection1],AppendLike[T2[XPoint], HCollection2],AppendLike[T3[XPoint], HCollection3],AppendLike[T4[XPoint], HCollection4],AppendLike[T5[XPoint], HCollection5],AppendLike[T6[XPoint], HCollection6],AppendLike[T7[XPoint], HCollection7],AppendLike[T8[XPoint], HCollection8],AppendLike[T9[XPoint], HCollection9],AppendLike[T10[XPoint], HCollection10],AppendLike[T11[XPoint], HCollection11],AppendLike[T12[XPoint], HCollection12],AppendLike[T13[XPoint], HCollection13],AppendLike[T14[XPoint], HCollection14],AppendLike[T15[XPoint], HCollection15],AppendLike[T16[XPoint], HCollection16],AppendLike[T17[XPoint], HCollection17],AppendLike[T18[XPoint], HCollection18],AppendLike[T19[XPoint], HCollection19],AppendLike[T20[XPoint], HCollection20],AppendLike[T21[XPoint], HCollection21],AppendLike[T22[XPoint], HCollection22]
            ] = NatNext3Self.natNext2Helper.append22[
              M,
              T1[XPoint],T2[XPoint],T3[XPoint],T4[XPoint],T5[XPoint],T6[XPoint],T7[XPoint],T8[XPoint],T9[XPoint],T10[XPoint],T11[XPoint],T12[XPoint],T13[XPoint],T14[XPoint],T15[XPoint],T16[XPoint],T17[XPoint],T18[XPoint],T19[XPoint],T20[XPoint],T21[XPoint],T22[XPoint],
              HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15,HCollection16,HCollection17,HCollection18,HCollection19,HCollection20,HCollection21,HCollection22
            ](simpleAppender)(typeGen.gen[XPoint], SupportSelf.current)
          }
        }
      }
    
      }
    }
  