
    package net.scalax.simple.adt
    package nat
    package support

    
      object SimpleProduct1 {
        SimpleProduct1Self =>

        
      trait TypeGen[
        M[_],
        N1[_]
      ] extends Type10Gen1[
        M,
        ({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N1[M1] })#TypeX
      ] {
        TypeGen1Self =>
        def gen[Item1]: M[N1[Item1]]
        override final def gen10[Item1,Item2,Item3,Item4,Item5,Item6,Item7,Item8,Item9,Item10,Item11,Item12,Item13,Item14,Item15,Item16,Item17,Item18,Item19,Item20,Item21,Item22]: M[N1[Item1]] = TypeGen1Self.gen[Item1]
      }
    
        
      trait SimpleAppender[M[_]] extends SimpleAppender1Positive[M] with SimpleAppender1Zero[M]
    
        
      trait ProductAdapter[F[_[_]]] {
        def append[M[_], N1[_]]
          (typeGen: SimpleProduct1.TypeGen[M, N1], sAppender: SimpleProduct1.SimpleAppender[M])
          : M[F[N1]]
      }
    
      }
    

      object SimpleProduct2 {
        SimpleProduct2Self =>

        
      trait TypeGen[
        M[_,_],
        N1[_],N2[_]
      ] extends Type10Gen2[
        M,
        ({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N1[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N2[M1] })#TypeX
      ] {
        TypeGen2Self =>
        def gen[Item1]: M[N1[Item1],N2[Item1]]
        override final def gen10[Item1,Item2,Item3,Item4,Item5,Item6,Item7,Item8,Item9,Item10,Item11,Item12,Item13,Item14,Item15,Item16,Item17,Item18,Item19,Item20,Item21,Item22]: M[N1[Item1],N2[Item1]] = TypeGen2Self.gen[Item1]
      }
    
        
      trait SimpleAppender[M[_,_]] extends SimpleAppender2Positive[M] with SimpleAppender2Zero[M]
    
        
      trait ProductAdapter[F[_[_]]] {
        def append[M[_,_], N1[_],N2[_]]
          (typeGen: SimpleProduct2.TypeGen[M, N1,N2], sAppender: SimpleProduct2.SimpleAppender[M])
          : M[F[N1],F[N2]]
      }
    
      }
    

      object SimpleProduct3 {
        SimpleProduct3Self =>

        
      trait TypeGen[
        M[_,_,_],
        N1[_],N2[_],N3[_]
      ] extends Type10Gen3[
        M,
        ({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N1[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N2[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N3[M1] })#TypeX
      ] {
        TypeGen3Self =>
        def gen[Item1]: M[N1[Item1],N2[Item1],N3[Item1]]
        override final def gen10[Item1,Item2,Item3,Item4,Item5,Item6,Item7,Item8,Item9,Item10,Item11,Item12,Item13,Item14,Item15,Item16,Item17,Item18,Item19,Item20,Item21,Item22]: M[N1[Item1],N2[Item1],N3[Item1]] = TypeGen3Self.gen[Item1]
      }
    
        
      trait SimpleAppender[M[_,_,_]] extends SimpleAppender3Positive[M] with SimpleAppender3Zero[M]
    
        
      trait ProductAdapter[F[_[_]]] {
        def append[M[_,_,_], N1[_],N2[_],N3[_]]
          (typeGen: SimpleProduct3.TypeGen[M, N1,N2,N3], sAppender: SimpleProduct3.SimpleAppender[M])
          : M[F[N1],F[N2],F[N3]]
      }
    
      }
    

      object SimpleProduct4 {
        SimpleProduct4Self =>

        
      trait TypeGen[
        M[_,_,_,_],
        N1[_],N2[_],N3[_],N4[_]
      ] extends Type10Gen4[
        M,
        ({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N1[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N2[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N3[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N4[M1] })#TypeX
      ] {
        TypeGen4Self =>
        def gen[Item1]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1]]
        override final def gen10[Item1,Item2,Item3,Item4,Item5,Item6,Item7,Item8,Item9,Item10,Item11,Item12,Item13,Item14,Item15,Item16,Item17,Item18,Item19,Item20,Item21,Item22]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1]] = TypeGen4Self.gen[Item1]
      }
    
        
      trait SimpleAppender[M[_,_,_,_]] extends SimpleAppender4Positive[M] with SimpleAppender4Zero[M]
    
        
      trait ProductAdapter[F[_[_]]] {
        def append[M[_,_,_,_], N1[_],N2[_],N3[_],N4[_]]
          (typeGen: SimpleProduct4.TypeGen[M, N1,N2,N3,N4], sAppender: SimpleProduct4.SimpleAppender[M])
          : M[F[N1],F[N2],F[N3],F[N4]]
      }
    
      }
    

      object SimpleProduct5 {
        SimpleProduct5Self =>

        
      trait TypeGen[
        M[_,_,_,_,_],
        N1[_],N2[_],N3[_],N4[_],N5[_]
      ] extends Type10Gen5[
        M,
        ({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N1[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N2[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N3[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N4[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N5[M1] })#TypeX
      ] {
        TypeGen5Self =>
        def gen[Item1]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1]]
        override final def gen10[Item1,Item2,Item3,Item4,Item5,Item6,Item7,Item8,Item9,Item10,Item11,Item12,Item13,Item14,Item15,Item16,Item17,Item18,Item19,Item20,Item21,Item22]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1]] = TypeGen5Self.gen[Item1]
      }
    
        
      trait SimpleAppender[M[_,_,_,_,_]] extends SimpleAppender5Positive[M] with SimpleAppender5Zero[M]
    
        
      trait ProductAdapter[F[_[_]]] {
        def append[M[_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_]]
          (typeGen: SimpleProduct5.TypeGen[M, N1,N2,N3,N4,N5], sAppender: SimpleProduct5.SimpleAppender[M])
          : M[F[N1],F[N2],F[N3],F[N4],F[N5]]
      }
    
      }
    

      object SimpleProduct6 {
        SimpleProduct6Self =>

        
      trait TypeGen[
        M[_,_,_,_,_,_],
        N1[_],N2[_],N3[_],N4[_],N5[_],N6[_]
      ] extends Type10Gen6[
        M,
        ({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N1[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N2[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N3[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N4[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N5[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N6[M1] })#TypeX
      ] {
        TypeGen6Self =>
        def gen[Item1]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1]]
        override final def gen10[Item1,Item2,Item3,Item4,Item5,Item6,Item7,Item8,Item9,Item10,Item11,Item12,Item13,Item14,Item15,Item16,Item17,Item18,Item19,Item20,Item21,Item22]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1]] = TypeGen6Self.gen[Item1]
      }
    
        
      trait SimpleAppender[M[_,_,_,_,_,_]] extends SimpleAppender6Positive[M] with SimpleAppender6Zero[M]
    
        
      trait ProductAdapter[F[_[_]]] {
        def append[M[_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_]]
          (typeGen: SimpleProduct6.TypeGen[M, N1,N2,N3,N4,N5,N6], sAppender: SimpleProduct6.SimpleAppender[M])
          : M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6]]
      }
    
      }
    

      object SimpleProduct7 {
        SimpleProduct7Self =>

        
      trait TypeGen[
        M[_,_,_,_,_,_,_],
        N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_]
      ] extends Type10Gen7[
        M,
        ({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N1[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N2[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N3[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N4[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N5[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N6[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N7[M1] })#TypeX
      ] {
        TypeGen7Self =>
        def gen[Item1]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1]]
        override final def gen10[Item1,Item2,Item3,Item4,Item5,Item6,Item7,Item8,Item9,Item10,Item11,Item12,Item13,Item14,Item15,Item16,Item17,Item18,Item19,Item20,Item21,Item22]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1]] = TypeGen7Self.gen[Item1]
      }
    
        
      trait SimpleAppender[M[_,_,_,_,_,_,_]] extends SimpleAppender7Positive[M] with SimpleAppender7Zero[M]
    
        
      trait ProductAdapter[F[_[_]]] {
        def append[M[_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_]]
          (typeGen: SimpleProduct7.TypeGen[M, N1,N2,N3,N4,N5,N6,N7], sAppender: SimpleProduct7.SimpleAppender[M])
          : M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7]]
      }
    
      }
    

      object SimpleProduct8 {
        SimpleProduct8Self =>

        
      trait TypeGen[
        M[_,_,_,_,_,_,_,_],
        N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_]
      ] extends Type10Gen8[
        M,
        ({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N1[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N2[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N3[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N4[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N5[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N6[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N7[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N8[M1] })#TypeX
      ] {
        TypeGen8Self =>
        def gen[Item1]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1],N8[Item1]]
        override final def gen10[Item1,Item2,Item3,Item4,Item5,Item6,Item7,Item8,Item9,Item10,Item11,Item12,Item13,Item14,Item15,Item16,Item17,Item18,Item19,Item20,Item21,Item22]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1],N8[Item1]] = TypeGen8Self.gen[Item1]
      }
    
        
      trait SimpleAppender[M[_,_,_,_,_,_,_,_]] extends SimpleAppender8Positive[M] with SimpleAppender8Zero[M]
    
        
      trait ProductAdapter[F[_[_]]] {
        def append[M[_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_]]
          (typeGen: SimpleProduct8.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8], sAppender: SimpleProduct8.SimpleAppender[M])
          : M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8]]
      }
    
      }
    

      object SimpleProduct9 {
        SimpleProduct9Self =>

        
      trait TypeGen[
        M[_,_,_,_,_,_,_,_,_],
        N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_]
      ] extends Type10Gen9[
        M,
        ({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N1[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N2[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N3[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N4[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N5[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N6[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N7[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N8[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N9[M1] })#TypeX
      ] {
        TypeGen9Self =>
        def gen[Item1]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1],N8[Item1],N9[Item1]]
        override final def gen10[Item1,Item2,Item3,Item4,Item5,Item6,Item7,Item8,Item9,Item10,Item11,Item12,Item13,Item14,Item15,Item16,Item17,Item18,Item19,Item20,Item21,Item22]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1],N8[Item1],N9[Item1]] = TypeGen9Self.gen[Item1]
      }
    
        
      trait SimpleAppender[M[_,_,_,_,_,_,_,_,_]] extends SimpleAppender9Positive[M] with SimpleAppender9Zero[M]
    
        
      trait ProductAdapter[F[_[_]]] {
        def append[M[_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_]]
          (typeGen: SimpleProduct9.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9], sAppender: SimpleProduct9.SimpleAppender[M])
          : M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9]]
      }
    
      }
    

      object SimpleProduct10 {
        SimpleProduct10Self =>

        
      trait TypeGen[
        M[_,_,_,_,_,_,_,_,_,_],
        N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_]
      ] extends Type10Gen10[
        M,
        ({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N1[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N2[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N3[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N4[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N5[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N6[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N7[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N8[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N9[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N10[M1] })#TypeX
      ] {
        TypeGen10Self =>
        def gen[Item1]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1],N8[Item1],N9[Item1],N10[Item1]]
        override final def gen10[Item1,Item2,Item3,Item4,Item5,Item6,Item7,Item8,Item9,Item10,Item11,Item12,Item13,Item14,Item15,Item16,Item17,Item18,Item19,Item20,Item21,Item22]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1],N8[Item1],N9[Item1],N10[Item1]] = TypeGen10Self.gen[Item1]
      }
    
        
      trait SimpleAppender[M[_,_,_,_,_,_,_,_,_,_]] extends SimpleAppender10Positive[M] with SimpleAppender10Zero[M]
    
        
      trait ProductAdapter[F[_[_]]] {
        def append[M[_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_]]
          (typeGen: SimpleProduct10.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10], sAppender: SimpleProduct10.SimpleAppender[M])
          : M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10]]
      }
    
      }
    

      object SimpleProduct11 {
        SimpleProduct11Self =>

        
      trait TypeGen[
        M[_,_,_,_,_,_,_,_,_,_,_],
        N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_]
      ] extends Type10Gen11[
        M,
        ({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N1[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N2[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N3[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N4[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N5[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N6[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N7[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N8[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N9[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N10[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N11[M1] })#TypeX
      ] {
        TypeGen11Self =>
        def gen[Item1]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1],N8[Item1],N9[Item1],N10[Item1],N11[Item1]]
        override final def gen10[Item1,Item2,Item3,Item4,Item5,Item6,Item7,Item8,Item9,Item10,Item11,Item12,Item13,Item14,Item15,Item16,Item17,Item18,Item19,Item20,Item21,Item22]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1],N8[Item1],N9[Item1],N10[Item1],N11[Item1]] = TypeGen11Self.gen[Item1]
      }
    
        
      trait SimpleAppender[M[_,_,_,_,_,_,_,_,_,_,_]] extends SimpleAppender11Positive[M] with SimpleAppender11Zero[M]
    
        
      trait ProductAdapter[F[_[_]]] {
        def append[M[_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_]]
          (typeGen: SimpleProduct11.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11], sAppender: SimpleProduct11.SimpleAppender[M])
          : M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11]]
      }
    
      }
    

      object SimpleProduct12 {
        SimpleProduct12Self =>

        
      trait TypeGen[
        M[_,_,_,_,_,_,_,_,_,_,_,_],
        N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_]
      ] extends Type10Gen12[
        M,
        ({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N1[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N2[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N3[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N4[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N5[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N6[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N7[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N8[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N9[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N10[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N11[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N12[M1] })#TypeX
      ] {
        TypeGen12Self =>
        def gen[Item1]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1],N8[Item1],N9[Item1],N10[Item1],N11[Item1],N12[Item1]]
        override final def gen10[Item1,Item2,Item3,Item4,Item5,Item6,Item7,Item8,Item9,Item10,Item11,Item12,Item13,Item14,Item15,Item16,Item17,Item18,Item19,Item20,Item21,Item22]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1],N8[Item1],N9[Item1],N10[Item1],N11[Item1],N12[Item1]] = TypeGen12Self.gen[Item1]
      }
    
        
      trait SimpleAppender[M[_,_,_,_,_,_,_,_,_,_,_,_]] extends SimpleAppender12Positive[M] with SimpleAppender12Zero[M]
    
        
      trait ProductAdapter[F[_[_]]] {
        def append[M[_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_]]
          (typeGen: SimpleProduct12.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12], sAppender: SimpleProduct12.SimpleAppender[M])
          : M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12]]
      }
    
      }
    

      object SimpleProduct13 {
        SimpleProduct13Self =>

        
      trait TypeGen[
        M[_,_,_,_,_,_,_,_,_,_,_,_,_],
        N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_]
      ] extends Type10Gen13[
        M,
        ({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N1[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N2[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N3[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N4[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N5[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N6[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N7[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N8[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N9[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N10[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N11[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N12[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N13[M1] })#TypeX
      ] {
        TypeGen13Self =>
        def gen[Item1]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1],N8[Item1],N9[Item1],N10[Item1],N11[Item1],N12[Item1],N13[Item1]]
        override final def gen10[Item1,Item2,Item3,Item4,Item5,Item6,Item7,Item8,Item9,Item10,Item11,Item12,Item13,Item14,Item15,Item16,Item17,Item18,Item19,Item20,Item21,Item22]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1],N8[Item1],N9[Item1],N10[Item1],N11[Item1],N12[Item1],N13[Item1]] = TypeGen13Self.gen[Item1]
      }
    
        
      trait SimpleAppender[M[_,_,_,_,_,_,_,_,_,_,_,_,_]] extends SimpleAppender13Positive[M] with SimpleAppender13Zero[M]
    
        
      trait ProductAdapter[F[_[_]]] {
        def append[M[_,_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_]]
          (typeGen: SimpleProduct13.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13], sAppender: SimpleProduct13.SimpleAppender[M])
          : M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12],F[N13]]
      }
    
      }
    

      object SimpleProduct14 {
        SimpleProduct14Self =>

        
      trait TypeGen[
        M[_,_,_,_,_,_,_,_,_,_,_,_,_,_],
        N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_]
      ] extends Type10Gen14[
        M,
        ({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N1[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N2[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N3[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N4[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N5[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N6[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N7[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N8[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N9[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N10[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N11[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N12[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N13[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N14[M1] })#TypeX
      ] {
        TypeGen14Self =>
        def gen[Item1]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1],N8[Item1],N9[Item1],N10[Item1],N11[Item1],N12[Item1],N13[Item1],N14[Item1]]
        override final def gen10[Item1,Item2,Item3,Item4,Item5,Item6,Item7,Item8,Item9,Item10,Item11,Item12,Item13,Item14,Item15,Item16,Item17,Item18,Item19,Item20,Item21,Item22]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1],N8[Item1],N9[Item1],N10[Item1],N11[Item1],N12[Item1],N13[Item1],N14[Item1]] = TypeGen14Self.gen[Item1]
      }
    
        
      trait SimpleAppender[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_]] extends SimpleAppender14Positive[M] with SimpleAppender14Zero[M]
    
        
      trait ProductAdapter[F[_[_]]] {
        def append[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_]]
          (typeGen: SimpleProduct14.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14], sAppender: SimpleProduct14.SimpleAppender[M])
          : M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12],F[N13],F[N14]]
      }
    
      }
    

      object SimpleProduct15 {
        SimpleProduct15Self =>

        
      trait TypeGen[
        M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_],
        N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_]
      ] extends Type10Gen15[
        M,
        ({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N1[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N2[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N3[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N4[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N5[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N6[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N7[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N8[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N9[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N10[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N11[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N12[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N13[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N14[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N15[M1] })#TypeX
      ] {
        TypeGen15Self =>
        def gen[Item1]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1],N8[Item1],N9[Item1],N10[Item1],N11[Item1],N12[Item1],N13[Item1],N14[Item1],N15[Item1]]
        override final def gen10[Item1,Item2,Item3,Item4,Item5,Item6,Item7,Item8,Item9,Item10,Item11,Item12,Item13,Item14,Item15,Item16,Item17,Item18,Item19,Item20,Item21,Item22]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1],N8[Item1],N9[Item1],N10[Item1],N11[Item1],N12[Item1],N13[Item1],N14[Item1],N15[Item1]] = TypeGen15Self.gen[Item1]
      }
    
        
      trait SimpleAppender[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_]] extends SimpleAppender15Positive[M] with SimpleAppender15Zero[M]
    
        
      trait ProductAdapter[F[_[_]]] {
        def append[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_]]
          (typeGen: SimpleProduct15.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15], sAppender: SimpleProduct15.SimpleAppender[M])
          : M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12],F[N13],F[N14],F[N15]]
      }
    
      }
    

      object SimpleProduct16 {
        SimpleProduct16Self =>

        
      trait TypeGen[
        M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_],
        N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_],N16[_]
      ] extends Type10Gen16[
        M,
        ({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N1[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N2[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N3[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N4[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N5[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N6[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N7[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N8[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N9[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N10[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N11[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N12[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N13[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N14[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N15[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N16[M1] })#TypeX
      ] {
        TypeGen16Self =>
        def gen[Item1]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1],N8[Item1],N9[Item1],N10[Item1],N11[Item1],N12[Item1],N13[Item1],N14[Item1],N15[Item1],N16[Item1]]
        override final def gen10[Item1,Item2,Item3,Item4,Item5,Item6,Item7,Item8,Item9,Item10,Item11,Item12,Item13,Item14,Item15,Item16,Item17,Item18,Item19,Item20,Item21,Item22]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1],N8[Item1],N9[Item1],N10[Item1],N11[Item1],N12[Item1],N13[Item1],N14[Item1],N15[Item1],N16[Item1]] = TypeGen16Self.gen[Item1]
      }
    
        
      trait SimpleAppender[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_]] extends SimpleAppender16Positive[M] with SimpleAppender16Zero[M]
    
        
      trait ProductAdapter[F[_[_]]] {
        def append[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_],N16[_]]
          (typeGen: SimpleProduct16.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16], sAppender: SimpleProduct16.SimpleAppender[M])
          : M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12],F[N13],F[N14],F[N15],F[N16]]
      }
    
      }
    

      object SimpleProduct17 {
        SimpleProduct17Self =>

        
      trait TypeGen[
        M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_],
        N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_],N16[_],N17[_]
      ] extends Type10Gen17[
        M,
        ({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N1[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N2[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N3[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N4[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N5[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N6[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N7[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N8[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N9[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N10[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N11[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N12[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N13[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N14[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N15[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N16[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N17[M1] })#TypeX
      ] {
        TypeGen17Self =>
        def gen[Item1]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1],N8[Item1],N9[Item1],N10[Item1],N11[Item1],N12[Item1],N13[Item1],N14[Item1],N15[Item1],N16[Item1],N17[Item1]]
        override final def gen10[Item1,Item2,Item3,Item4,Item5,Item6,Item7,Item8,Item9,Item10,Item11,Item12,Item13,Item14,Item15,Item16,Item17,Item18,Item19,Item20,Item21,Item22]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1],N8[Item1],N9[Item1],N10[Item1],N11[Item1],N12[Item1],N13[Item1],N14[Item1],N15[Item1],N16[Item1],N17[Item1]] = TypeGen17Self.gen[Item1]
      }
    
        
      trait SimpleAppender[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_]] extends SimpleAppender17Positive[M] with SimpleAppender17Zero[M]
    
        
      trait ProductAdapter[F[_[_]]] {
        def append[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_],N16[_],N17[_]]
          (typeGen: SimpleProduct17.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17], sAppender: SimpleProduct17.SimpleAppender[M])
          : M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12],F[N13],F[N14],F[N15],F[N16],F[N17]]
      }
    
      }
    

      object SimpleProduct18 {
        SimpleProduct18Self =>

        
      trait TypeGen[
        M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_],
        N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_],N16[_],N17[_],N18[_]
      ] extends Type10Gen18[
        M,
        ({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N1[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N2[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N3[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N4[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N5[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N6[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N7[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N8[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N9[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N10[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N11[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N12[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N13[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N14[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N15[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N16[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N17[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N18[M1] })#TypeX
      ] {
        TypeGen18Self =>
        def gen[Item1]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1],N8[Item1],N9[Item1],N10[Item1],N11[Item1],N12[Item1],N13[Item1],N14[Item1],N15[Item1],N16[Item1],N17[Item1],N18[Item1]]
        override final def gen10[Item1,Item2,Item3,Item4,Item5,Item6,Item7,Item8,Item9,Item10,Item11,Item12,Item13,Item14,Item15,Item16,Item17,Item18,Item19,Item20,Item21,Item22]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1],N8[Item1],N9[Item1],N10[Item1],N11[Item1],N12[Item1],N13[Item1],N14[Item1],N15[Item1],N16[Item1],N17[Item1],N18[Item1]] = TypeGen18Self.gen[Item1]
      }
    
        
      trait SimpleAppender[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_]] extends SimpleAppender18Positive[M] with SimpleAppender18Zero[M]
    
        
      trait ProductAdapter[F[_[_]]] {
        def append[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_],N16[_],N17[_],N18[_]]
          (typeGen: SimpleProduct18.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18], sAppender: SimpleProduct18.SimpleAppender[M])
          : M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12],F[N13],F[N14],F[N15],F[N16],F[N17],F[N18]]
      }
    
      }
    

      object SimpleProduct19 {
        SimpleProduct19Self =>

        
      trait TypeGen[
        M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_],
        N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_],N16[_],N17[_],N18[_],N19[_]
      ] extends Type10Gen19[
        M,
        ({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N1[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N2[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N3[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N4[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N5[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N6[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N7[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N8[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N9[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N10[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N11[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N12[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N13[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N14[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N15[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N16[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N17[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N18[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N19[M1] })#TypeX
      ] {
        TypeGen19Self =>
        def gen[Item1]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1],N8[Item1],N9[Item1],N10[Item1],N11[Item1],N12[Item1],N13[Item1],N14[Item1],N15[Item1],N16[Item1],N17[Item1],N18[Item1],N19[Item1]]
        override final def gen10[Item1,Item2,Item3,Item4,Item5,Item6,Item7,Item8,Item9,Item10,Item11,Item12,Item13,Item14,Item15,Item16,Item17,Item18,Item19,Item20,Item21,Item22]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1],N8[Item1],N9[Item1],N10[Item1],N11[Item1],N12[Item1],N13[Item1],N14[Item1],N15[Item1],N16[Item1],N17[Item1],N18[Item1],N19[Item1]] = TypeGen19Self.gen[Item1]
      }
    
        
      trait SimpleAppender[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_]] extends SimpleAppender19Positive[M] with SimpleAppender19Zero[M]
    
        
      trait ProductAdapter[F[_[_]]] {
        def append[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_],N16[_],N17[_],N18[_],N19[_]]
          (typeGen: SimpleProduct19.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18,N19], sAppender: SimpleProduct19.SimpleAppender[M])
          : M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12],F[N13],F[N14],F[N15],F[N16],F[N17],F[N18],F[N19]]
      }
    
      }
    

      object SimpleProduct20 {
        SimpleProduct20Self =>

        
      trait TypeGen[
        M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_],
        N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_],N16[_],N17[_],N18[_],N19[_],N20[_]
      ] extends Type10Gen20[
        M,
        ({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N1[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N2[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N3[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N4[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N5[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N6[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N7[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N8[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N9[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N10[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N11[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N12[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N13[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N14[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N15[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N16[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N17[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N18[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N19[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N20[M1] })#TypeX
      ] {
        TypeGen20Self =>
        def gen[Item1]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1],N8[Item1],N9[Item1],N10[Item1],N11[Item1],N12[Item1],N13[Item1],N14[Item1],N15[Item1],N16[Item1],N17[Item1],N18[Item1],N19[Item1],N20[Item1]]
        override final def gen10[Item1,Item2,Item3,Item4,Item5,Item6,Item7,Item8,Item9,Item10,Item11,Item12,Item13,Item14,Item15,Item16,Item17,Item18,Item19,Item20,Item21,Item22]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1],N8[Item1],N9[Item1],N10[Item1],N11[Item1],N12[Item1],N13[Item1],N14[Item1],N15[Item1],N16[Item1],N17[Item1],N18[Item1],N19[Item1],N20[Item1]] = TypeGen20Self.gen[Item1]
      }
    
        
      trait SimpleAppender[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_]] extends SimpleAppender20Positive[M] with SimpleAppender20Zero[M]
    
        
      trait ProductAdapter[F[_[_]]] {
        def append[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_],N16[_],N17[_],N18[_],N19[_],N20[_]]
          (typeGen: SimpleProduct20.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18,N19,N20], sAppender: SimpleProduct20.SimpleAppender[M])
          : M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12],F[N13],F[N14],F[N15],F[N16],F[N17],F[N18],F[N19],F[N20]]
      }
    
      }
    

      object SimpleProduct21 {
        SimpleProduct21Self =>

        
      trait TypeGen[
        M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_],
        N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_],N16[_],N17[_],N18[_],N19[_],N20[_],N21[_]
      ] extends Type10Gen21[
        M,
        ({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N1[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N2[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N3[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N4[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N5[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N6[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N7[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N8[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N9[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N10[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N11[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N12[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N13[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N14[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N15[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N16[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N17[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N18[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N19[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N20[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N21[M1] })#TypeX
      ] {
        TypeGen21Self =>
        def gen[Item1]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1],N8[Item1],N9[Item1],N10[Item1],N11[Item1],N12[Item1],N13[Item1],N14[Item1],N15[Item1],N16[Item1],N17[Item1],N18[Item1],N19[Item1],N20[Item1],N21[Item1]]
        override final def gen10[Item1,Item2,Item3,Item4,Item5,Item6,Item7,Item8,Item9,Item10,Item11,Item12,Item13,Item14,Item15,Item16,Item17,Item18,Item19,Item20,Item21,Item22]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1],N8[Item1],N9[Item1],N10[Item1],N11[Item1],N12[Item1],N13[Item1],N14[Item1],N15[Item1],N16[Item1],N17[Item1],N18[Item1],N19[Item1],N20[Item1],N21[Item1]] = TypeGen21Self.gen[Item1]
      }
    
        
      trait SimpleAppender[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_]] extends SimpleAppender21Positive[M] with SimpleAppender21Zero[M]
    
        
      trait ProductAdapter[F[_[_]]] {
        def append[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_],N16[_],N17[_],N18[_],N19[_],N20[_],N21[_]]
          (typeGen: SimpleProduct21.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18,N19,N20,N21], sAppender: SimpleProduct21.SimpleAppender[M])
          : M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12],F[N13],F[N14],F[N15],F[N16],F[N17],F[N18],F[N19],F[N20],F[N21]]
      }
    
      }
    

      object SimpleProduct22 {
        SimpleProduct22Self =>

        
      trait TypeGen[
        M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_],
        N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_],N16[_],N17[_],N18[_],N19[_],N20[_],N21[_],N22[_]
      ] extends Type10Gen22[
        M,
        ({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N1[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N2[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N3[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N4[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N5[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N6[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N7[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N8[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N9[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N10[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N11[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N12[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N13[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N14[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N15[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N16[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N17[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N18[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N19[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N20[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N21[M1] })#TypeX,({ type TypeX[M1,M2,M3,M4,M5,M6,M7,M8,M9,M10,M11,M12,M13,M14,M15,M16,M17,M18,M19,M20,M21,M22] = N22[M1] })#TypeX
      ] {
        TypeGen22Self =>
        def gen[Item1]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1],N8[Item1],N9[Item1],N10[Item1],N11[Item1],N12[Item1],N13[Item1],N14[Item1],N15[Item1],N16[Item1],N17[Item1],N18[Item1],N19[Item1],N20[Item1],N21[Item1],N22[Item1]]
        override final def gen10[Item1,Item2,Item3,Item4,Item5,Item6,Item7,Item8,Item9,Item10,Item11,Item12,Item13,Item14,Item15,Item16,Item17,Item18,Item19,Item20,Item21,Item22]: M[N1[Item1],N2[Item1],N3[Item1],N4[Item1],N5[Item1],N6[Item1],N7[Item1],N8[Item1],N9[Item1],N10[Item1],N11[Item1],N12[Item1],N13[Item1],N14[Item1],N15[Item1],N16[Item1],N17[Item1],N18[Item1],N19[Item1],N20[Item1],N21[Item1],N22[Item1]] = TypeGen22Self.gen[Item1]
      }
    
        
      trait SimpleAppender[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_]] extends SimpleAppender22Positive[M] with SimpleAppender22Zero[M]
    
        
      trait ProductAdapter[F[_[_]]] {
        def append[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_],N16[_],N17[_],N18[_],N19[_],N20[_],N21[_],N22[_]]
          (typeGen: SimpleProduct22.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18,N19,N20,N21,N22], sAppender: SimpleProduct22.SimpleAppender[M])
          : M[F[N1],F[N2],F[N3],F[N4],F[N5],F[N6],F[N7],F[N8],F[N9],F[N10],F[N11],F[N12],F[N13],F[N14],F[N15],F[N16],F[N17],F[N18],F[N19],F[N20],F[N21],F[N22]]
      }
    
      }
    
  