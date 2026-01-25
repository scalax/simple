
    package net.scalax.simple.adt
    package nat
    package support

    trait NatNext2Helper[HListLike, AppendLike[_, _ <: HListLike] <: HListLike] {
      NatNext2HelperSelf =>

      def hlistFunc: HListFunc[HListLike, AppendLike]

      
      def append1[M[_], T1, HCollection1 <: HListLike](
        appender1: SimpleAppender1Positive[M]
      )(
        head: M[T1],
        tail: M[HCollection1]
      ): M[AppendLike[T1, HCollection1]] =
        appender1.append[T1, HCollection1, AppendLike[T1, HCollection1]](
          NatNext2HelperSelf.hlistFunc.toABCFunc[T1, HCollection1]
        )(
          head,
          tail
        )
    

      def append2[M[_,_], T1,T2, HCollection1 <: HListLike,HCollection2 <: HListLike](
        appender2: SimpleAppender2Positive[M]
      )(
        head: M[T1,T2],
        tail: M[HCollection1,HCollection2]
      ): M[AppendLike[T1, HCollection1],AppendLike[T2, HCollection2]] =
        appender2.append[T1,T2, HCollection1,HCollection2, AppendLike[T1, HCollection1],AppendLike[T2, HCollection2]](
          NatNext2HelperSelf.hlistFunc.toABCFunc[T1, HCollection1],NatNext2HelperSelf.hlistFunc.toABCFunc[T2, HCollection2]
        )(
          head,
          tail
        )
    

      def append3[M[_,_,_], T1,T2,T3, HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike](
        appender3: SimpleAppender3Positive[M]
      )(
        head: M[T1,T2,T3],
        tail: M[HCollection1,HCollection2,HCollection3]
      ): M[AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3]] =
        appender3.append[T1,T2,T3, HCollection1,HCollection2,HCollection3, AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3]](
          NatNext2HelperSelf.hlistFunc.toABCFunc[T1, HCollection1],NatNext2HelperSelf.hlistFunc.toABCFunc[T2, HCollection2],NatNext2HelperSelf.hlistFunc.toABCFunc[T3, HCollection3]
        )(
          head,
          tail
        )
    

      def append4[M[_,_,_,_], T1,T2,T3,T4, HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike](
        appender4: SimpleAppender4Positive[M]
      )(
        head: M[T1,T2,T3,T4],
        tail: M[HCollection1,HCollection2,HCollection3,HCollection4]
      ): M[AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4]] =
        appender4.append[T1,T2,T3,T4, HCollection1,HCollection2,HCollection3,HCollection4, AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4]](
          NatNext2HelperSelf.hlistFunc.toABCFunc[T1, HCollection1],NatNext2HelperSelf.hlistFunc.toABCFunc[T2, HCollection2],NatNext2HelperSelf.hlistFunc.toABCFunc[T3, HCollection3],NatNext2HelperSelf.hlistFunc.toABCFunc[T4, HCollection4]
        )(
          head,
          tail
        )
    

      def append5[M[_,_,_,_,_], T1,T2,T3,T4,T5, HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike](
        appender5: SimpleAppender5Positive[M]
      )(
        head: M[T1,T2,T3,T4,T5],
        tail: M[HCollection1,HCollection2,HCollection3,HCollection4,HCollection5]
      ): M[AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5]] =
        appender5.append[T1,T2,T3,T4,T5, HCollection1,HCollection2,HCollection3,HCollection4,HCollection5, AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5]](
          NatNext2HelperSelf.hlistFunc.toABCFunc[T1, HCollection1],NatNext2HelperSelf.hlistFunc.toABCFunc[T2, HCollection2],NatNext2HelperSelf.hlistFunc.toABCFunc[T3, HCollection3],NatNext2HelperSelf.hlistFunc.toABCFunc[T4, HCollection4],NatNext2HelperSelf.hlistFunc.toABCFunc[T5, HCollection5]
        )(
          head,
          tail
        )
    

      def append6[M[_,_,_,_,_,_], T1,T2,T3,T4,T5,T6, HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike](
        appender6: SimpleAppender6Positive[M]
      )(
        head: M[T1,T2,T3,T4,T5,T6],
        tail: M[HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6]
      ): M[AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6]] =
        appender6.append[T1,T2,T3,T4,T5,T6, HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6, AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6]](
          NatNext2HelperSelf.hlistFunc.toABCFunc[T1, HCollection1],NatNext2HelperSelf.hlistFunc.toABCFunc[T2, HCollection2],NatNext2HelperSelf.hlistFunc.toABCFunc[T3, HCollection3],NatNext2HelperSelf.hlistFunc.toABCFunc[T4, HCollection4],NatNext2HelperSelf.hlistFunc.toABCFunc[T5, HCollection5],NatNext2HelperSelf.hlistFunc.toABCFunc[T6, HCollection6]
        )(
          head,
          tail
        )
    

      def append7[M[_,_,_,_,_,_,_], T1,T2,T3,T4,T5,T6,T7, HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike](
        appender7: SimpleAppender7Positive[M]
      )(
        head: M[T1,T2,T3,T4,T5,T6,T7],
        tail: M[HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7]
      ): M[AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7]] =
        appender7.append[T1,T2,T3,T4,T5,T6,T7, HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7, AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7]](
          NatNext2HelperSelf.hlistFunc.toABCFunc[T1, HCollection1],NatNext2HelperSelf.hlistFunc.toABCFunc[T2, HCollection2],NatNext2HelperSelf.hlistFunc.toABCFunc[T3, HCollection3],NatNext2HelperSelf.hlistFunc.toABCFunc[T4, HCollection4],NatNext2HelperSelf.hlistFunc.toABCFunc[T5, HCollection5],NatNext2HelperSelf.hlistFunc.toABCFunc[T6, HCollection6],NatNext2HelperSelf.hlistFunc.toABCFunc[T7, HCollection7]
        )(
          head,
          tail
        )
    

      def append8[M[_,_,_,_,_,_,_,_], T1,T2,T3,T4,T5,T6,T7,T8, HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike,HCollection8 <: HListLike](
        appender8: SimpleAppender8Positive[M]
      )(
        head: M[T1,T2,T3,T4,T5,T6,T7,T8],
        tail: M[HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8]
      ): M[AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7],AppendLike[T8, HCollection8]] =
        appender8.append[T1,T2,T3,T4,T5,T6,T7,T8, HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8, AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7],AppendLike[T8, HCollection8]](
          NatNext2HelperSelf.hlistFunc.toABCFunc[T1, HCollection1],NatNext2HelperSelf.hlistFunc.toABCFunc[T2, HCollection2],NatNext2HelperSelf.hlistFunc.toABCFunc[T3, HCollection3],NatNext2HelperSelf.hlistFunc.toABCFunc[T4, HCollection4],NatNext2HelperSelf.hlistFunc.toABCFunc[T5, HCollection5],NatNext2HelperSelf.hlistFunc.toABCFunc[T6, HCollection6],NatNext2HelperSelf.hlistFunc.toABCFunc[T7, HCollection7],NatNext2HelperSelf.hlistFunc.toABCFunc[T8, HCollection8]
        )(
          head,
          tail
        )
    

      def append9[M[_,_,_,_,_,_,_,_,_], T1,T2,T3,T4,T5,T6,T7,T8,T9, HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike,HCollection8 <: HListLike,HCollection9 <: HListLike](
        appender9: SimpleAppender9Positive[M]
      )(
        head: M[T1,T2,T3,T4,T5,T6,T7,T8,T9],
        tail: M[HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9]
      ): M[AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7],AppendLike[T8, HCollection8],AppendLike[T9, HCollection9]] =
        appender9.append[T1,T2,T3,T4,T5,T6,T7,T8,T9, HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9, AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7],AppendLike[T8, HCollection8],AppendLike[T9, HCollection9]](
          NatNext2HelperSelf.hlistFunc.toABCFunc[T1, HCollection1],NatNext2HelperSelf.hlistFunc.toABCFunc[T2, HCollection2],NatNext2HelperSelf.hlistFunc.toABCFunc[T3, HCollection3],NatNext2HelperSelf.hlistFunc.toABCFunc[T4, HCollection4],NatNext2HelperSelf.hlistFunc.toABCFunc[T5, HCollection5],NatNext2HelperSelf.hlistFunc.toABCFunc[T6, HCollection6],NatNext2HelperSelf.hlistFunc.toABCFunc[T7, HCollection7],NatNext2HelperSelf.hlistFunc.toABCFunc[T8, HCollection8],NatNext2HelperSelf.hlistFunc.toABCFunc[T9, HCollection9]
        )(
          head,
          tail
        )
    

      def append10[M[_,_,_,_,_,_,_,_,_,_], T1,T2,T3,T4,T5,T6,T7,T8,T9,T10, HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike,HCollection8 <: HListLike,HCollection9 <: HListLike,HCollection10 <: HListLike](
        appender10: SimpleAppender10Positive[M]
      )(
        head: M[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10],
        tail: M[HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10]
      ): M[AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7],AppendLike[T8, HCollection8],AppendLike[T9, HCollection9],AppendLike[T10, HCollection10]] =
        appender10.append[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10, HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10, AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7],AppendLike[T8, HCollection8],AppendLike[T9, HCollection9],AppendLike[T10, HCollection10]](
          NatNext2HelperSelf.hlistFunc.toABCFunc[T1, HCollection1],NatNext2HelperSelf.hlistFunc.toABCFunc[T2, HCollection2],NatNext2HelperSelf.hlistFunc.toABCFunc[T3, HCollection3],NatNext2HelperSelf.hlistFunc.toABCFunc[T4, HCollection4],NatNext2HelperSelf.hlistFunc.toABCFunc[T5, HCollection5],NatNext2HelperSelf.hlistFunc.toABCFunc[T6, HCollection6],NatNext2HelperSelf.hlistFunc.toABCFunc[T7, HCollection7],NatNext2HelperSelf.hlistFunc.toABCFunc[T8, HCollection8],NatNext2HelperSelf.hlistFunc.toABCFunc[T9, HCollection9],NatNext2HelperSelf.hlistFunc.toABCFunc[T10, HCollection10]
        )(
          head,
          tail
        )
    

      def append11[M[_,_,_,_,_,_,_,_,_,_,_], T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11, HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike,HCollection8 <: HListLike,HCollection9 <: HListLike,HCollection10 <: HListLike,HCollection11 <: HListLike](
        appender11: SimpleAppender11Positive[M]
      )(
        head: M[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11],
        tail: M[HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11]
      ): M[AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7],AppendLike[T8, HCollection8],AppendLike[T9, HCollection9],AppendLike[T10, HCollection10],AppendLike[T11, HCollection11]] =
        appender11.append[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11, HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11, AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7],AppendLike[T8, HCollection8],AppendLike[T9, HCollection9],AppendLike[T10, HCollection10],AppendLike[T11, HCollection11]](
          NatNext2HelperSelf.hlistFunc.toABCFunc[T1, HCollection1],NatNext2HelperSelf.hlistFunc.toABCFunc[T2, HCollection2],NatNext2HelperSelf.hlistFunc.toABCFunc[T3, HCollection3],NatNext2HelperSelf.hlistFunc.toABCFunc[T4, HCollection4],NatNext2HelperSelf.hlistFunc.toABCFunc[T5, HCollection5],NatNext2HelperSelf.hlistFunc.toABCFunc[T6, HCollection6],NatNext2HelperSelf.hlistFunc.toABCFunc[T7, HCollection7],NatNext2HelperSelf.hlistFunc.toABCFunc[T8, HCollection8],NatNext2HelperSelf.hlistFunc.toABCFunc[T9, HCollection9],NatNext2HelperSelf.hlistFunc.toABCFunc[T10, HCollection10],NatNext2HelperSelf.hlistFunc.toABCFunc[T11, HCollection11]
        )(
          head,
          tail
        )
    

      def append12[M[_,_,_,_,_,_,_,_,_,_,_,_], T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12, HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike,HCollection8 <: HListLike,HCollection9 <: HListLike,HCollection10 <: HListLike,HCollection11 <: HListLike,HCollection12 <: HListLike](
        appender12: SimpleAppender12Positive[M]
      )(
        head: M[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12],
        tail: M[HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12]
      ): M[AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7],AppendLike[T8, HCollection8],AppendLike[T9, HCollection9],AppendLike[T10, HCollection10],AppendLike[T11, HCollection11],AppendLike[T12, HCollection12]] =
        appender12.append[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12, HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12, AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7],AppendLike[T8, HCollection8],AppendLike[T9, HCollection9],AppendLike[T10, HCollection10],AppendLike[T11, HCollection11],AppendLike[T12, HCollection12]](
          NatNext2HelperSelf.hlistFunc.toABCFunc[T1, HCollection1],NatNext2HelperSelf.hlistFunc.toABCFunc[T2, HCollection2],NatNext2HelperSelf.hlistFunc.toABCFunc[T3, HCollection3],NatNext2HelperSelf.hlistFunc.toABCFunc[T4, HCollection4],NatNext2HelperSelf.hlistFunc.toABCFunc[T5, HCollection5],NatNext2HelperSelf.hlistFunc.toABCFunc[T6, HCollection6],NatNext2HelperSelf.hlistFunc.toABCFunc[T7, HCollection7],NatNext2HelperSelf.hlistFunc.toABCFunc[T8, HCollection8],NatNext2HelperSelf.hlistFunc.toABCFunc[T9, HCollection9],NatNext2HelperSelf.hlistFunc.toABCFunc[T10, HCollection10],NatNext2HelperSelf.hlistFunc.toABCFunc[T11, HCollection11],NatNext2HelperSelf.hlistFunc.toABCFunc[T12, HCollection12]
        )(
          head,
          tail
        )
    

      def append13[M[_,_,_,_,_,_,_,_,_,_,_,_,_], T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13, HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike,HCollection8 <: HListLike,HCollection9 <: HListLike,HCollection10 <: HListLike,HCollection11 <: HListLike,HCollection12 <: HListLike,HCollection13 <: HListLike](
        appender13: SimpleAppender13Positive[M]
      )(
        head: M[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13],
        tail: M[HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13]
      ): M[AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7],AppendLike[T8, HCollection8],AppendLike[T9, HCollection9],AppendLike[T10, HCollection10],AppendLike[T11, HCollection11],AppendLike[T12, HCollection12],AppendLike[T13, HCollection13]] =
        appender13.append[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13, HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13, AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7],AppendLike[T8, HCollection8],AppendLike[T9, HCollection9],AppendLike[T10, HCollection10],AppendLike[T11, HCollection11],AppendLike[T12, HCollection12],AppendLike[T13, HCollection13]](
          NatNext2HelperSelf.hlistFunc.toABCFunc[T1, HCollection1],NatNext2HelperSelf.hlistFunc.toABCFunc[T2, HCollection2],NatNext2HelperSelf.hlistFunc.toABCFunc[T3, HCollection3],NatNext2HelperSelf.hlistFunc.toABCFunc[T4, HCollection4],NatNext2HelperSelf.hlistFunc.toABCFunc[T5, HCollection5],NatNext2HelperSelf.hlistFunc.toABCFunc[T6, HCollection6],NatNext2HelperSelf.hlistFunc.toABCFunc[T7, HCollection7],NatNext2HelperSelf.hlistFunc.toABCFunc[T8, HCollection8],NatNext2HelperSelf.hlistFunc.toABCFunc[T9, HCollection9],NatNext2HelperSelf.hlistFunc.toABCFunc[T10, HCollection10],NatNext2HelperSelf.hlistFunc.toABCFunc[T11, HCollection11],NatNext2HelperSelf.hlistFunc.toABCFunc[T12, HCollection12],NatNext2HelperSelf.hlistFunc.toABCFunc[T13, HCollection13]
        )(
          head,
          tail
        )
    

      def append14[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_], T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14, HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike,HCollection8 <: HListLike,HCollection9 <: HListLike,HCollection10 <: HListLike,HCollection11 <: HListLike,HCollection12 <: HListLike,HCollection13 <: HListLike,HCollection14 <: HListLike](
        appender14: SimpleAppender14Positive[M]
      )(
        head: M[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14],
        tail: M[HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14]
      ): M[AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7],AppendLike[T8, HCollection8],AppendLike[T9, HCollection9],AppendLike[T10, HCollection10],AppendLike[T11, HCollection11],AppendLike[T12, HCollection12],AppendLike[T13, HCollection13],AppendLike[T14, HCollection14]] =
        appender14.append[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14, HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14, AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7],AppendLike[T8, HCollection8],AppendLike[T9, HCollection9],AppendLike[T10, HCollection10],AppendLike[T11, HCollection11],AppendLike[T12, HCollection12],AppendLike[T13, HCollection13],AppendLike[T14, HCollection14]](
          NatNext2HelperSelf.hlistFunc.toABCFunc[T1, HCollection1],NatNext2HelperSelf.hlistFunc.toABCFunc[T2, HCollection2],NatNext2HelperSelf.hlistFunc.toABCFunc[T3, HCollection3],NatNext2HelperSelf.hlistFunc.toABCFunc[T4, HCollection4],NatNext2HelperSelf.hlistFunc.toABCFunc[T5, HCollection5],NatNext2HelperSelf.hlistFunc.toABCFunc[T6, HCollection6],NatNext2HelperSelf.hlistFunc.toABCFunc[T7, HCollection7],NatNext2HelperSelf.hlistFunc.toABCFunc[T8, HCollection8],NatNext2HelperSelf.hlistFunc.toABCFunc[T9, HCollection9],NatNext2HelperSelf.hlistFunc.toABCFunc[T10, HCollection10],NatNext2HelperSelf.hlistFunc.toABCFunc[T11, HCollection11],NatNext2HelperSelf.hlistFunc.toABCFunc[T12, HCollection12],NatNext2HelperSelf.hlistFunc.toABCFunc[T13, HCollection13],NatNext2HelperSelf.hlistFunc.toABCFunc[T14, HCollection14]
        )(
          head,
          tail
        )
    

      def append15[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15, HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike,HCollection8 <: HListLike,HCollection9 <: HListLike,HCollection10 <: HListLike,HCollection11 <: HListLike,HCollection12 <: HListLike,HCollection13 <: HListLike,HCollection14 <: HListLike,HCollection15 <: HListLike](
        appender15: SimpleAppender15Positive[M]
      )(
        head: M[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15],
        tail: M[HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15]
      ): M[AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7],AppendLike[T8, HCollection8],AppendLike[T9, HCollection9],AppendLike[T10, HCollection10],AppendLike[T11, HCollection11],AppendLike[T12, HCollection12],AppendLike[T13, HCollection13],AppendLike[T14, HCollection14],AppendLike[T15, HCollection15]] =
        appender15.append[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15, HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15, AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7],AppendLike[T8, HCollection8],AppendLike[T9, HCollection9],AppendLike[T10, HCollection10],AppendLike[T11, HCollection11],AppendLike[T12, HCollection12],AppendLike[T13, HCollection13],AppendLike[T14, HCollection14],AppendLike[T15, HCollection15]](
          NatNext2HelperSelf.hlistFunc.toABCFunc[T1, HCollection1],NatNext2HelperSelf.hlistFunc.toABCFunc[T2, HCollection2],NatNext2HelperSelf.hlistFunc.toABCFunc[T3, HCollection3],NatNext2HelperSelf.hlistFunc.toABCFunc[T4, HCollection4],NatNext2HelperSelf.hlistFunc.toABCFunc[T5, HCollection5],NatNext2HelperSelf.hlistFunc.toABCFunc[T6, HCollection6],NatNext2HelperSelf.hlistFunc.toABCFunc[T7, HCollection7],NatNext2HelperSelf.hlistFunc.toABCFunc[T8, HCollection8],NatNext2HelperSelf.hlistFunc.toABCFunc[T9, HCollection9],NatNext2HelperSelf.hlistFunc.toABCFunc[T10, HCollection10],NatNext2HelperSelf.hlistFunc.toABCFunc[T11, HCollection11],NatNext2HelperSelf.hlistFunc.toABCFunc[T12, HCollection12],NatNext2HelperSelf.hlistFunc.toABCFunc[T13, HCollection13],NatNext2HelperSelf.hlistFunc.toABCFunc[T14, HCollection14],NatNext2HelperSelf.hlistFunc.toABCFunc[T15, HCollection15]
        )(
          head,
          tail
        )
    

      def append16[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16, HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike,HCollection8 <: HListLike,HCollection9 <: HListLike,HCollection10 <: HListLike,HCollection11 <: HListLike,HCollection12 <: HListLike,HCollection13 <: HListLike,HCollection14 <: HListLike,HCollection15 <: HListLike,HCollection16 <: HListLike](
        appender16: SimpleAppender16Positive[M]
      )(
        head: M[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16],
        tail: M[HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15,HCollection16]
      ): M[AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7],AppendLike[T8, HCollection8],AppendLike[T9, HCollection9],AppendLike[T10, HCollection10],AppendLike[T11, HCollection11],AppendLike[T12, HCollection12],AppendLike[T13, HCollection13],AppendLike[T14, HCollection14],AppendLike[T15, HCollection15],AppendLike[T16, HCollection16]] =
        appender16.append[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16, HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15,HCollection16, AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7],AppendLike[T8, HCollection8],AppendLike[T9, HCollection9],AppendLike[T10, HCollection10],AppendLike[T11, HCollection11],AppendLike[T12, HCollection12],AppendLike[T13, HCollection13],AppendLike[T14, HCollection14],AppendLike[T15, HCollection15],AppendLike[T16, HCollection16]](
          NatNext2HelperSelf.hlistFunc.toABCFunc[T1, HCollection1],NatNext2HelperSelf.hlistFunc.toABCFunc[T2, HCollection2],NatNext2HelperSelf.hlistFunc.toABCFunc[T3, HCollection3],NatNext2HelperSelf.hlistFunc.toABCFunc[T4, HCollection4],NatNext2HelperSelf.hlistFunc.toABCFunc[T5, HCollection5],NatNext2HelperSelf.hlistFunc.toABCFunc[T6, HCollection6],NatNext2HelperSelf.hlistFunc.toABCFunc[T7, HCollection7],NatNext2HelperSelf.hlistFunc.toABCFunc[T8, HCollection8],NatNext2HelperSelf.hlistFunc.toABCFunc[T9, HCollection9],NatNext2HelperSelf.hlistFunc.toABCFunc[T10, HCollection10],NatNext2HelperSelf.hlistFunc.toABCFunc[T11, HCollection11],NatNext2HelperSelf.hlistFunc.toABCFunc[T12, HCollection12],NatNext2HelperSelf.hlistFunc.toABCFunc[T13, HCollection13],NatNext2HelperSelf.hlistFunc.toABCFunc[T14, HCollection14],NatNext2HelperSelf.hlistFunc.toABCFunc[T15, HCollection15],NatNext2HelperSelf.hlistFunc.toABCFunc[T16, HCollection16]
        )(
          head,
          tail
        )
    

      def append17[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17, HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike,HCollection8 <: HListLike,HCollection9 <: HListLike,HCollection10 <: HListLike,HCollection11 <: HListLike,HCollection12 <: HListLike,HCollection13 <: HListLike,HCollection14 <: HListLike,HCollection15 <: HListLike,HCollection16 <: HListLike,HCollection17 <: HListLike](
        appender17: SimpleAppender17Positive[M]
      )(
        head: M[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17],
        tail: M[HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15,HCollection16,HCollection17]
      ): M[AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7],AppendLike[T8, HCollection8],AppendLike[T9, HCollection9],AppendLike[T10, HCollection10],AppendLike[T11, HCollection11],AppendLike[T12, HCollection12],AppendLike[T13, HCollection13],AppendLike[T14, HCollection14],AppendLike[T15, HCollection15],AppendLike[T16, HCollection16],AppendLike[T17, HCollection17]] =
        appender17.append[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17, HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15,HCollection16,HCollection17, AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7],AppendLike[T8, HCollection8],AppendLike[T9, HCollection9],AppendLike[T10, HCollection10],AppendLike[T11, HCollection11],AppendLike[T12, HCollection12],AppendLike[T13, HCollection13],AppendLike[T14, HCollection14],AppendLike[T15, HCollection15],AppendLike[T16, HCollection16],AppendLike[T17, HCollection17]](
          NatNext2HelperSelf.hlistFunc.toABCFunc[T1, HCollection1],NatNext2HelperSelf.hlistFunc.toABCFunc[T2, HCollection2],NatNext2HelperSelf.hlistFunc.toABCFunc[T3, HCollection3],NatNext2HelperSelf.hlistFunc.toABCFunc[T4, HCollection4],NatNext2HelperSelf.hlistFunc.toABCFunc[T5, HCollection5],NatNext2HelperSelf.hlistFunc.toABCFunc[T6, HCollection6],NatNext2HelperSelf.hlistFunc.toABCFunc[T7, HCollection7],NatNext2HelperSelf.hlistFunc.toABCFunc[T8, HCollection8],NatNext2HelperSelf.hlistFunc.toABCFunc[T9, HCollection9],NatNext2HelperSelf.hlistFunc.toABCFunc[T10, HCollection10],NatNext2HelperSelf.hlistFunc.toABCFunc[T11, HCollection11],NatNext2HelperSelf.hlistFunc.toABCFunc[T12, HCollection12],NatNext2HelperSelf.hlistFunc.toABCFunc[T13, HCollection13],NatNext2HelperSelf.hlistFunc.toABCFunc[T14, HCollection14],NatNext2HelperSelf.hlistFunc.toABCFunc[T15, HCollection15],NatNext2HelperSelf.hlistFunc.toABCFunc[T16, HCollection16],NatNext2HelperSelf.hlistFunc.toABCFunc[T17, HCollection17]
        )(
          head,
          tail
        )
    

      def append18[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18, HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike,HCollection8 <: HListLike,HCollection9 <: HListLike,HCollection10 <: HListLike,HCollection11 <: HListLike,HCollection12 <: HListLike,HCollection13 <: HListLike,HCollection14 <: HListLike,HCollection15 <: HListLike,HCollection16 <: HListLike,HCollection17 <: HListLike,HCollection18 <: HListLike](
        appender18: SimpleAppender18Positive[M]
      )(
        head: M[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18],
        tail: M[HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15,HCollection16,HCollection17,HCollection18]
      ): M[AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7],AppendLike[T8, HCollection8],AppendLike[T9, HCollection9],AppendLike[T10, HCollection10],AppendLike[T11, HCollection11],AppendLike[T12, HCollection12],AppendLike[T13, HCollection13],AppendLike[T14, HCollection14],AppendLike[T15, HCollection15],AppendLike[T16, HCollection16],AppendLike[T17, HCollection17],AppendLike[T18, HCollection18]] =
        appender18.append[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18, HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15,HCollection16,HCollection17,HCollection18, AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7],AppendLike[T8, HCollection8],AppendLike[T9, HCollection9],AppendLike[T10, HCollection10],AppendLike[T11, HCollection11],AppendLike[T12, HCollection12],AppendLike[T13, HCollection13],AppendLike[T14, HCollection14],AppendLike[T15, HCollection15],AppendLike[T16, HCollection16],AppendLike[T17, HCollection17],AppendLike[T18, HCollection18]](
          NatNext2HelperSelf.hlistFunc.toABCFunc[T1, HCollection1],NatNext2HelperSelf.hlistFunc.toABCFunc[T2, HCollection2],NatNext2HelperSelf.hlistFunc.toABCFunc[T3, HCollection3],NatNext2HelperSelf.hlistFunc.toABCFunc[T4, HCollection4],NatNext2HelperSelf.hlistFunc.toABCFunc[T5, HCollection5],NatNext2HelperSelf.hlistFunc.toABCFunc[T6, HCollection6],NatNext2HelperSelf.hlistFunc.toABCFunc[T7, HCollection7],NatNext2HelperSelf.hlistFunc.toABCFunc[T8, HCollection8],NatNext2HelperSelf.hlistFunc.toABCFunc[T9, HCollection9],NatNext2HelperSelf.hlistFunc.toABCFunc[T10, HCollection10],NatNext2HelperSelf.hlistFunc.toABCFunc[T11, HCollection11],NatNext2HelperSelf.hlistFunc.toABCFunc[T12, HCollection12],NatNext2HelperSelf.hlistFunc.toABCFunc[T13, HCollection13],NatNext2HelperSelf.hlistFunc.toABCFunc[T14, HCollection14],NatNext2HelperSelf.hlistFunc.toABCFunc[T15, HCollection15],NatNext2HelperSelf.hlistFunc.toABCFunc[T16, HCollection16],NatNext2HelperSelf.hlistFunc.toABCFunc[T17, HCollection17],NatNext2HelperSelf.hlistFunc.toABCFunc[T18, HCollection18]
        )(
          head,
          tail
        )
    

      def append19[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19, HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike,HCollection8 <: HListLike,HCollection9 <: HListLike,HCollection10 <: HListLike,HCollection11 <: HListLike,HCollection12 <: HListLike,HCollection13 <: HListLike,HCollection14 <: HListLike,HCollection15 <: HListLike,HCollection16 <: HListLike,HCollection17 <: HListLike,HCollection18 <: HListLike,HCollection19 <: HListLike](
        appender19: SimpleAppender19Positive[M]
      )(
        head: M[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19],
        tail: M[HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15,HCollection16,HCollection17,HCollection18,HCollection19]
      ): M[AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7],AppendLike[T8, HCollection8],AppendLike[T9, HCollection9],AppendLike[T10, HCollection10],AppendLike[T11, HCollection11],AppendLike[T12, HCollection12],AppendLike[T13, HCollection13],AppendLike[T14, HCollection14],AppendLike[T15, HCollection15],AppendLike[T16, HCollection16],AppendLike[T17, HCollection17],AppendLike[T18, HCollection18],AppendLike[T19, HCollection19]] =
        appender19.append[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19, HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15,HCollection16,HCollection17,HCollection18,HCollection19, AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7],AppendLike[T8, HCollection8],AppendLike[T9, HCollection9],AppendLike[T10, HCollection10],AppendLike[T11, HCollection11],AppendLike[T12, HCollection12],AppendLike[T13, HCollection13],AppendLike[T14, HCollection14],AppendLike[T15, HCollection15],AppendLike[T16, HCollection16],AppendLike[T17, HCollection17],AppendLike[T18, HCollection18],AppendLike[T19, HCollection19]](
          NatNext2HelperSelf.hlistFunc.toABCFunc[T1, HCollection1],NatNext2HelperSelf.hlistFunc.toABCFunc[T2, HCollection2],NatNext2HelperSelf.hlistFunc.toABCFunc[T3, HCollection3],NatNext2HelperSelf.hlistFunc.toABCFunc[T4, HCollection4],NatNext2HelperSelf.hlistFunc.toABCFunc[T5, HCollection5],NatNext2HelperSelf.hlistFunc.toABCFunc[T6, HCollection6],NatNext2HelperSelf.hlistFunc.toABCFunc[T7, HCollection7],NatNext2HelperSelf.hlistFunc.toABCFunc[T8, HCollection8],NatNext2HelperSelf.hlistFunc.toABCFunc[T9, HCollection9],NatNext2HelperSelf.hlistFunc.toABCFunc[T10, HCollection10],NatNext2HelperSelf.hlistFunc.toABCFunc[T11, HCollection11],NatNext2HelperSelf.hlistFunc.toABCFunc[T12, HCollection12],NatNext2HelperSelf.hlistFunc.toABCFunc[T13, HCollection13],NatNext2HelperSelf.hlistFunc.toABCFunc[T14, HCollection14],NatNext2HelperSelf.hlistFunc.toABCFunc[T15, HCollection15],NatNext2HelperSelf.hlistFunc.toABCFunc[T16, HCollection16],NatNext2HelperSelf.hlistFunc.toABCFunc[T17, HCollection17],NatNext2HelperSelf.hlistFunc.toABCFunc[T18, HCollection18],NatNext2HelperSelf.hlistFunc.toABCFunc[T19, HCollection19]
        )(
          head,
          tail
        )
    

      def append20[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20, HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike,HCollection8 <: HListLike,HCollection9 <: HListLike,HCollection10 <: HListLike,HCollection11 <: HListLike,HCollection12 <: HListLike,HCollection13 <: HListLike,HCollection14 <: HListLike,HCollection15 <: HListLike,HCollection16 <: HListLike,HCollection17 <: HListLike,HCollection18 <: HListLike,HCollection19 <: HListLike,HCollection20 <: HListLike](
        appender20: SimpleAppender20Positive[M]
      )(
        head: M[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20],
        tail: M[HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15,HCollection16,HCollection17,HCollection18,HCollection19,HCollection20]
      ): M[AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7],AppendLike[T8, HCollection8],AppendLike[T9, HCollection9],AppendLike[T10, HCollection10],AppendLike[T11, HCollection11],AppendLike[T12, HCollection12],AppendLike[T13, HCollection13],AppendLike[T14, HCollection14],AppendLike[T15, HCollection15],AppendLike[T16, HCollection16],AppendLike[T17, HCollection17],AppendLike[T18, HCollection18],AppendLike[T19, HCollection19],AppendLike[T20, HCollection20]] =
        appender20.append[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20, HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15,HCollection16,HCollection17,HCollection18,HCollection19,HCollection20, AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7],AppendLike[T8, HCollection8],AppendLike[T9, HCollection9],AppendLike[T10, HCollection10],AppendLike[T11, HCollection11],AppendLike[T12, HCollection12],AppendLike[T13, HCollection13],AppendLike[T14, HCollection14],AppendLike[T15, HCollection15],AppendLike[T16, HCollection16],AppendLike[T17, HCollection17],AppendLike[T18, HCollection18],AppendLike[T19, HCollection19],AppendLike[T20, HCollection20]](
          NatNext2HelperSelf.hlistFunc.toABCFunc[T1, HCollection1],NatNext2HelperSelf.hlistFunc.toABCFunc[T2, HCollection2],NatNext2HelperSelf.hlistFunc.toABCFunc[T3, HCollection3],NatNext2HelperSelf.hlistFunc.toABCFunc[T4, HCollection4],NatNext2HelperSelf.hlistFunc.toABCFunc[T5, HCollection5],NatNext2HelperSelf.hlistFunc.toABCFunc[T6, HCollection6],NatNext2HelperSelf.hlistFunc.toABCFunc[T7, HCollection7],NatNext2HelperSelf.hlistFunc.toABCFunc[T8, HCollection8],NatNext2HelperSelf.hlistFunc.toABCFunc[T9, HCollection9],NatNext2HelperSelf.hlistFunc.toABCFunc[T10, HCollection10],NatNext2HelperSelf.hlistFunc.toABCFunc[T11, HCollection11],NatNext2HelperSelf.hlistFunc.toABCFunc[T12, HCollection12],NatNext2HelperSelf.hlistFunc.toABCFunc[T13, HCollection13],NatNext2HelperSelf.hlistFunc.toABCFunc[T14, HCollection14],NatNext2HelperSelf.hlistFunc.toABCFunc[T15, HCollection15],NatNext2HelperSelf.hlistFunc.toABCFunc[T16, HCollection16],NatNext2HelperSelf.hlistFunc.toABCFunc[T17, HCollection17],NatNext2HelperSelf.hlistFunc.toABCFunc[T18, HCollection18],NatNext2HelperSelf.hlistFunc.toABCFunc[T19, HCollection19],NatNext2HelperSelf.hlistFunc.toABCFunc[T20, HCollection20]
        )(
          head,
          tail
        )
    

      def append21[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21, HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike,HCollection8 <: HListLike,HCollection9 <: HListLike,HCollection10 <: HListLike,HCollection11 <: HListLike,HCollection12 <: HListLike,HCollection13 <: HListLike,HCollection14 <: HListLike,HCollection15 <: HListLike,HCollection16 <: HListLike,HCollection17 <: HListLike,HCollection18 <: HListLike,HCollection19 <: HListLike,HCollection20 <: HListLike,HCollection21 <: HListLike](
        appender21: SimpleAppender21Positive[M]
      )(
        head: M[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21],
        tail: M[HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15,HCollection16,HCollection17,HCollection18,HCollection19,HCollection20,HCollection21]
      ): M[AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7],AppendLike[T8, HCollection8],AppendLike[T9, HCollection9],AppendLike[T10, HCollection10],AppendLike[T11, HCollection11],AppendLike[T12, HCollection12],AppendLike[T13, HCollection13],AppendLike[T14, HCollection14],AppendLike[T15, HCollection15],AppendLike[T16, HCollection16],AppendLike[T17, HCollection17],AppendLike[T18, HCollection18],AppendLike[T19, HCollection19],AppendLike[T20, HCollection20],AppendLike[T21, HCollection21]] =
        appender21.append[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21, HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15,HCollection16,HCollection17,HCollection18,HCollection19,HCollection20,HCollection21, AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7],AppendLike[T8, HCollection8],AppendLike[T9, HCollection9],AppendLike[T10, HCollection10],AppendLike[T11, HCollection11],AppendLike[T12, HCollection12],AppendLike[T13, HCollection13],AppendLike[T14, HCollection14],AppendLike[T15, HCollection15],AppendLike[T16, HCollection16],AppendLike[T17, HCollection17],AppendLike[T18, HCollection18],AppendLike[T19, HCollection19],AppendLike[T20, HCollection20],AppendLike[T21, HCollection21]](
          NatNext2HelperSelf.hlistFunc.toABCFunc[T1, HCollection1],NatNext2HelperSelf.hlistFunc.toABCFunc[T2, HCollection2],NatNext2HelperSelf.hlistFunc.toABCFunc[T3, HCollection3],NatNext2HelperSelf.hlistFunc.toABCFunc[T4, HCollection4],NatNext2HelperSelf.hlistFunc.toABCFunc[T5, HCollection5],NatNext2HelperSelf.hlistFunc.toABCFunc[T6, HCollection6],NatNext2HelperSelf.hlistFunc.toABCFunc[T7, HCollection7],NatNext2HelperSelf.hlistFunc.toABCFunc[T8, HCollection8],NatNext2HelperSelf.hlistFunc.toABCFunc[T9, HCollection9],NatNext2HelperSelf.hlistFunc.toABCFunc[T10, HCollection10],NatNext2HelperSelf.hlistFunc.toABCFunc[T11, HCollection11],NatNext2HelperSelf.hlistFunc.toABCFunc[T12, HCollection12],NatNext2HelperSelf.hlistFunc.toABCFunc[T13, HCollection13],NatNext2HelperSelf.hlistFunc.toABCFunc[T14, HCollection14],NatNext2HelperSelf.hlistFunc.toABCFunc[T15, HCollection15],NatNext2HelperSelf.hlistFunc.toABCFunc[T16, HCollection16],NatNext2HelperSelf.hlistFunc.toABCFunc[T17, HCollection17],NatNext2HelperSelf.hlistFunc.toABCFunc[T18, HCollection18],NatNext2HelperSelf.hlistFunc.toABCFunc[T19, HCollection19],NatNext2HelperSelf.hlistFunc.toABCFunc[T20, HCollection20],NatNext2HelperSelf.hlistFunc.toABCFunc[T21, HCollection21]
        )(
          head,
          tail
        )
    

      def append22[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22, HCollection1 <: HListLike,HCollection2 <: HListLike,HCollection3 <: HListLike,HCollection4 <: HListLike,HCollection5 <: HListLike,HCollection6 <: HListLike,HCollection7 <: HListLike,HCollection8 <: HListLike,HCollection9 <: HListLike,HCollection10 <: HListLike,HCollection11 <: HListLike,HCollection12 <: HListLike,HCollection13 <: HListLike,HCollection14 <: HListLike,HCollection15 <: HListLike,HCollection16 <: HListLike,HCollection17 <: HListLike,HCollection18 <: HListLike,HCollection19 <: HListLike,HCollection20 <: HListLike,HCollection21 <: HListLike,HCollection22 <: HListLike](
        appender22: SimpleAppender22Positive[M]
      )(
        head: M[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22],
        tail: M[HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15,HCollection16,HCollection17,HCollection18,HCollection19,HCollection20,HCollection21,HCollection22]
      ): M[AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7],AppendLike[T8, HCollection8],AppendLike[T9, HCollection9],AppendLike[T10, HCollection10],AppendLike[T11, HCollection11],AppendLike[T12, HCollection12],AppendLike[T13, HCollection13],AppendLike[T14, HCollection14],AppendLike[T15, HCollection15],AppendLike[T16, HCollection16],AppendLike[T17, HCollection17],AppendLike[T18, HCollection18],AppendLike[T19, HCollection19],AppendLike[T20, HCollection20],AppendLike[T21, HCollection21],AppendLike[T22, HCollection22]] =
        appender22.append[T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22, HCollection1,HCollection2,HCollection3,HCollection4,HCollection5,HCollection6,HCollection7,HCollection8,HCollection9,HCollection10,HCollection11,HCollection12,HCollection13,HCollection14,HCollection15,HCollection16,HCollection17,HCollection18,HCollection19,HCollection20,HCollection21,HCollection22, AppendLike[T1, HCollection1],AppendLike[T2, HCollection2],AppendLike[T3, HCollection3],AppendLike[T4, HCollection4],AppendLike[T5, HCollection5],AppendLike[T6, HCollection6],AppendLike[T7, HCollection7],AppendLike[T8, HCollection8],AppendLike[T9, HCollection9],AppendLike[T10, HCollection10],AppendLike[T11, HCollection11],AppendLike[T12, HCollection12],AppendLike[T13, HCollection13],AppendLike[T14, HCollection14],AppendLike[T15, HCollection15],AppendLike[T16, HCollection16],AppendLike[T17, HCollection17],AppendLike[T18, HCollection18],AppendLike[T19, HCollection19],AppendLike[T20, HCollection20],AppendLike[T21, HCollection21],AppendLike[T22, HCollection22]](
          NatNext2HelperSelf.hlistFunc.toABCFunc[T1, HCollection1],NatNext2HelperSelf.hlistFunc.toABCFunc[T2, HCollection2],NatNext2HelperSelf.hlistFunc.toABCFunc[T3, HCollection3],NatNext2HelperSelf.hlistFunc.toABCFunc[T4, HCollection4],NatNext2HelperSelf.hlistFunc.toABCFunc[T5, HCollection5],NatNext2HelperSelf.hlistFunc.toABCFunc[T6, HCollection6],NatNext2HelperSelf.hlistFunc.toABCFunc[T7, HCollection7],NatNext2HelperSelf.hlistFunc.toABCFunc[T8, HCollection8],NatNext2HelperSelf.hlistFunc.toABCFunc[T9, HCollection9],NatNext2HelperSelf.hlistFunc.toABCFunc[T10, HCollection10],NatNext2HelperSelf.hlistFunc.toABCFunc[T11, HCollection11],NatNext2HelperSelf.hlistFunc.toABCFunc[T12, HCollection12],NatNext2HelperSelf.hlistFunc.toABCFunc[T13, HCollection13],NatNext2HelperSelf.hlistFunc.toABCFunc[T14, HCollection14],NatNext2HelperSelf.hlistFunc.toABCFunc[T15, HCollection15],NatNext2HelperSelf.hlistFunc.toABCFunc[T16, HCollection16],NatNext2HelperSelf.hlistFunc.toABCFunc[T17, HCollection17],NatNext2HelperSelf.hlistFunc.toABCFunc[T18, HCollection18],NatNext2HelperSelf.hlistFunc.toABCFunc[T19, HCollection19],NatNext2HelperSelf.hlistFunc.toABCFunc[T20, HCollection20],NatNext2HelperSelf.hlistFunc.toABCFunc[T21, HCollection21],NatNext2HelperSelf.hlistFunc.toABCFunc[T22, HCollection22]
        )(
          head,
          tail
        )
    
    }
  