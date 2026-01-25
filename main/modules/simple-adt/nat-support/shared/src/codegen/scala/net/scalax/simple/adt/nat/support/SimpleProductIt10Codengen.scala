
    package net.scalax.simple.adt
    package nat
    package support

    object SimpleProductIt10Codengen {
      SimpleProductIt10CodengenSelf =>

      def toItera[F[_[_]], T](spc: SimpleProductContextX[F]): SimpleProductContextX[({ type TPF[MXX[_]] = F[({ type XUU[_] = MXX[T] })#XUU] })#TPF] = {
        type TPF[MXX[_]] = F[({ type XUU[_] = MXX[T] })#XUU]
        new SimpleProductContextX[TPF] {
          
      override def simpleProduct1: SimpleProduct1.ProductAdapter[TPF] = new SimpleProduct1.ProductAdapter[TPF] {
        override def append[M[_], N1[_]]
          (
            typeGen: SimpleProduct1.TypeGen[M, N1],
            sAppender: SimpleProduct1.SimpleAppender[M])
          : M[TPF[({ type NXX[_] = N1[T] })#NXX]] =
            spc.simpleProduct1.append[M, ({ type NXX[_] = N1[T] })#NXX](
              new SimpleProduct1.TypeGen[M, ({ type NXX[_] = N1[T] })#NXX] {
                override def gen[U1]: M[N1[T]] = typeGen.gen[T]
              },
              sAppender
            )
      }
    

      override def simpleProduct2: SimpleProduct2.ProductAdapter[TPF] = new SimpleProduct2.ProductAdapter[TPF] {
        override def append[M[_,_], N1[_],N2[_]]
          (
            typeGen: SimpleProduct2.TypeGen[M, N1,N2],
            sAppender: SimpleProduct2.SimpleAppender[M])
          : M[TPF[({ type NXX[_] = N1[T] })#NXX],TPF[({ type NXX[_] = N2[T] })#NXX]] =
            spc.simpleProduct2.append[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX](
              new SimpleProduct2.TypeGen[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX] {
                override def gen[U1]: M[N1[T],N2[T]] = typeGen.gen[T]
              },
              sAppender
            )
      }
    

      override def simpleProduct3: SimpleProduct3.ProductAdapter[TPF] = new SimpleProduct3.ProductAdapter[TPF] {
        override def append[M[_,_,_], N1[_],N2[_],N3[_]]
          (
            typeGen: SimpleProduct3.TypeGen[M, N1,N2,N3],
            sAppender: SimpleProduct3.SimpleAppender[M])
          : M[TPF[({ type NXX[_] = N1[T] })#NXX],TPF[({ type NXX[_] = N2[T] })#NXX],TPF[({ type NXX[_] = N3[T] })#NXX]] =
            spc.simpleProduct3.append[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX](
              new SimpleProduct3.TypeGen[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX] {
                override def gen[U1]: M[N1[T],N2[T],N3[T]] = typeGen.gen[T]
              },
              sAppender
            )
      }
    

      override def simpleProduct4: SimpleProduct4.ProductAdapter[TPF] = new SimpleProduct4.ProductAdapter[TPF] {
        override def append[M[_,_,_,_], N1[_],N2[_],N3[_],N4[_]]
          (
            typeGen: SimpleProduct4.TypeGen[M, N1,N2,N3,N4],
            sAppender: SimpleProduct4.SimpleAppender[M])
          : M[TPF[({ type NXX[_] = N1[T] })#NXX],TPF[({ type NXX[_] = N2[T] })#NXX],TPF[({ type NXX[_] = N3[T] })#NXX],TPF[({ type NXX[_] = N4[T] })#NXX]] =
            spc.simpleProduct4.append[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX](
              new SimpleProduct4.TypeGen[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX] {
                override def gen[U1]: M[N1[T],N2[T],N3[T],N4[T]] = typeGen.gen[T]
              },
              sAppender
            )
      }
    

      override def simpleProduct5: SimpleProduct5.ProductAdapter[TPF] = new SimpleProduct5.ProductAdapter[TPF] {
        override def append[M[_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_]]
          (
            typeGen: SimpleProduct5.TypeGen[M, N1,N2,N3,N4,N5],
            sAppender: SimpleProduct5.SimpleAppender[M])
          : M[TPF[({ type NXX[_] = N1[T] })#NXX],TPF[({ type NXX[_] = N2[T] })#NXX],TPF[({ type NXX[_] = N3[T] })#NXX],TPF[({ type NXX[_] = N4[T] })#NXX],TPF[({ type NXX[_] = N5[T] })#NXX]] =
            spc.simpleProduct5.append[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX](
              new SimpleProduct5.TypeGen[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX] {
                override def gen[U1]: M[N1[T],N2[T],N3[T],N4[T],N5[T]] = typeGen.gen[T]
              },
              sAppender
            )
      }
    

      override def simpleProduct6: SimpleProduct6.ProductAdapter[TPF] = new SimpleProduct6.ProductAdapter[TPF] {
        override def append[M[_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_]]
          (
            typeGen: SimpleProduct6.TypeGen[M, N1,N2,N3,N4,N5,N6],
            sAppender: SimpleProduct6.SimpleAppender[M])
          : M[TPF[({ type NXX[_] = N1[T] })#NXX],TPF[({ type NXX[_] = N2[T] })#NXX],TPF[({ type NXX[_] = N3[T] })#NXX],TPF[({ type NXX[_] = N4[T] })#NXX],TPF[({ type NXX[_] = N5[T] })#NXX],TPF[({ type NXX[_] = N6[T] })#NXX]] =
            spc.simpleProduct6.append[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX](
              new SimpleProduct6.TypeGen[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX] {
                override def gen[U1]: M[N1[T],N2[T],N3[T],N4[T],N5[T],N6[T]] = typeGen.gen[T]
              },
              sAppender
            )
      }
    

      override def simpleProduct7: SimpleProduct7.ProductAdapter[TPF] = new SimpleProduct7.ProductAdapter[TPF] {
        override def append[M[_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_]]
          (
            typeGen: SimpleProduct7.TypeGen[M, N1,N2,N3,N4,N5,N6,N7],
            sAppender: SimpleProduct7.SimpleAppender[M])
          : M[TPF[({ type NXX[_] = N1[T] })#NXX],TPF[({ type NXX[_] = N2[T] })#NXX],TPF[({ type NXX[_] = N3[T] })#NXX],TPF[({ type NXX[_] = N4[T] })#NXX],TPF[({ type NXX[_] = N5[T] })#NXX],TPF[({ type NXX[_] = N6[T] })#NXX],TPF[({ type NXX[_] = N7[T] })#NXX]] =
            spc.simpleProduct7.append[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX](
              new SimpleProduct7.TypeGen[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX] {
                override def gen[U1]: M[N1[T],N2[T],N3[T],N4[T],N5[T],N6[T],N7[T]] = typeGen.gen[T]
              },
              sAppender
            )
      }
    

      override def simpleProduct8: SimpleProduct8.ProductAdapter[TPF] = new SimpleProduct8.ProductAdapter[TPF] {
        override def append[M[_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_]]
          (
            typeGen: SimpleProduct8.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8],
            sAppender: SimpleProduct8.SimpleAppender[M])
          : M[TPF[({ type NXX[_] = N1[T] })#NXX],TPF[({ type NXX[_] = N2[T] })#NXX],TPF[({ type NXX[_] = N3[T] })#NXX],TPF[({ type NXX[_] = N4[T] })#NXX],TPF[({ type NXX[_] = N5[T] })#NXX],TPF[({ type NXX[_] = N6[T] })#NXX],TPF[({ type NXX[_] = N7[T] })#NXX],TPF[({ type NXX[_] = N8[T] })#NXX]] =
            spc.simpleProduct8.append[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX,({ type NXX[_] = N8[T] })#NXX](
              new SimpleProduct8.TypeGen[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX,({ type NXX[_] = N8[T] })#NXX] {
                override def gen[U1]: M[N1[T],N2[T],N3[T],N4[T],N5[T],N6[T],N7[T],N8[T]] = typeGen.gen[T]
              },
              sAppender
            )
      }
    

      override def simpleProduct9: SimpleProduct9.ProductAdapter[TPF] = new SimpleProduct9.ProductAdapter[TPF] {
        override def append[M[_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_]]
          (
            typeGen: SimpleProduct9.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9],
            sAppender: SimpleProduct9.SimpleAppender[M])
          : M[TPF[({ type NXX[_] = N1[T] })#NXX],TPF[({ type NXX[_] = N2[T] })#NXX],TPF[({ type NXX[_] = N3[T] })#NXX],TPF[({ type NXX[_] = N4[T] })#NXX],TPF[({ type NXX[_] = N5[T] })#NXX],TPF[({ type NXX[_] = N6[T] })#NXX],TPF[({ type NXX[_] = N7[T] })#NXX],TPF[({ type NXX[_] = N8[T] })#NXX],TPF[({ type NXX[_] = N9[T] })#NXX]] =
            spc.simpleProduct9.append[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX,({ type NXX[_] = N8[T] })#NXX,({ type NXX[_] = N9[T] })#NXX](
              new SimpleProduct9.TypeGen[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX,({ type NXX[_] = N8[T] })#NXX,({ type NXX[_] = N9[T] })#NXX] {
                override def gen[U1]: M[N1[T],N2[T],N3[T],N4[T],N5[T],N6[T],N7[T],N8[T],N9[T]] = typeGen.gen[T]
              },
              sAppender
            )
      }
    

      override def simpleProduct10: SimpleProduct10.ProductAdapter[TPF] = new SimpleProduct10.ProductAdapter[TPF] {
        override def append[M[_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_]]
          (
            typeGen: SimpleProduct10.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10],
            sAppender: SimpleProduct10.SimpleAppender[M])
          : M[TPF[({ type NXX[_] = N1[T] })#NXX],TPF[({ type NXX[_] = N2[T] })#NXX],TPF[({ type NXX[_] = N3[T] })#NXX],TPF[({ type NXX[_] = N4[T] })#NXX],TPF[({ type NXX[_] = N5[T] })#NXX],TPF[({ type NXX[_] = N6[T] })#NXX],TPF[({ type NXX[_] = N7[T] })#NXX],TPF[({ type NXX[_] = N8[T] })#NXX],TPF[({ type NXX[_] = N9[T] })#NXX],TPF[({ type NXX[_] = N10[T] })#NXX]] =
            spc.simpleProduct10.append[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX,({ type NXX[_] = N8[T] })#NXX,({ type NXX[_] = N9[T] })#NXX,({ type NXX[_] = N10[T] })#NXX](
              new SimpleProduct10.TypeGen[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX,({ type NXX[_] = N8[T] })#NXX,({ type NXX[_] = N9[T] })#NXX,({ type NXX[_] = N10[T] })#NXX] {
                override def gen[U1]: M[N1[T],N2[T],N3[T],N4[T],N5[T],N6[T],N7[T],N8[T],N9[T],N10[T]] = typeGen.gen[T]
              },
              sAppender
            )
      }
    

      override def simpleProduct11: SimpleProduct11.ProductAdapter[TPF] = new SimpleProduct11.ProductAdapter[TPF] {
        override def append[M[_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_]]
          (
            typeGen: SimpleProduct11.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11],
            sAppender: SimpleProduct11.SimpleAppender[M])
          : M[TPF[({ type NXX[_] = N1[T] })#NXX],TPF[({ type NXX[_] = N2[T] })#NXX],TPF[({ type NXX[_] = N3[T] })#NXX],TPF[({ type NXX[_] = N4[T] })#NXX],TPF[({ type NXX[_] = N5[T] })#NXX],TPF[({ type NXX[_] = N6[T] })#NXX],TPF[({ type NXX[_] = N7[T] })#NXX],TPF[({ type NXX[_] = N8[T] })#NXX],TPF[({ type NXX[_] = N9[T] })#NXX],TPF[({ type NXX[_] = N10[T] })#NXX],TPF[({ type NXX[_] = N11[T] })#NXX]] =
            spc.simpleProduct11.append[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX,({ type NXX[_] = N8[T] })#NXX,({ type NXX[_] = N9[T] })#NXX,({ type NXX[_] = N10[T] })#NXX,({ type NXX[_] = N11[T] })#NXX](
              new SimpleProduct11.TypeGen[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX,({ type NXX[_] = N8[T] })#NXX,({ type NXX[_] = N9[T] })#NXX,({ type NXX[_] = N10[T] })#NXX,({ type NXX[_] = N11[T] })#NXX] {
                override def gen[U1]: M[N1[T],N2[T],N3[T],N4[T],N5[T],N6[T],N7[T],N8[T],N9[T],N10[T],N11[T]] = typeGen.gen[T]
              },
              sAppender
            )
      }
    

      override def simpleProduct12: SimpleProduct12.ProductAdapter[TPF] = new SimpleProduct12.ProductAdapter[TPF] {
        override def append[M[_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_]]
          (
            typeGen: SimpleProduct12.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12],
            sAppender: SimpleProduct12.SimpleAppender[M])
          : M[TPF[({ type NXX[_] = N1[T] })#NXX],TPF[({ type NXX[_] = N2[T] })#NXX],TPF[({ type NXX[_] = N3[T] })#NXX],TPF[({ type NXX[_] = N4[T] })#NXX],TPF[({ type NXX[_] = N5[T] })#NXX],TPF[({ type NXX[_] = N6[T] })#NXX],TPF[({ type NXX[_] = N7[T] })#NXX],TPF[({ type NXX[_] = N8[T] })#NXX],TPF[({ type NXX[_] = N9[T] })#NXX],TPF[({ type NXX[_] = N10[T] })#NXX],TPF[({ type NXX[_] = N11[T] })#NXX],TPF[({ type NXX[_] = N12[T] })#NXX]] =
            spc.simpleProduct12.append[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX,({ type NXX[_] = N8[T] })#NXX,({ type NXX[_] = N9[T] })#NXX,({ type NXX[_] = N10[T] })#NXX,({ type NXX[_] = N11[T] })#NXX,({ type NXX[_] = N12[T] })#NXX](
              new SimpleProduct12.TypeGen[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX,({ type NXX[_] = N8[T] })#NXX,({ type NXX[_] = N9[T] })#NXX,({ type NXX[_] = N10[T] })#NXX,({ type NXX[_] = N11[T] })#NXX,({ type NXX[_] = N12[T] })#NXX] {
                override def gen[U1]: M[N1[T],N2[T],N3[T],N4[T],N5[T],N6[T],N7[T],N8[T],N9[T],N10[T],N11[T],N12[T]] = typeGen.gen[T]
              },
              sAppender
            )
      }
    

      override def simpleProduct13: SimpleProduct13.ProductAdapter[TPF] = new SimpleProduct13.ProductAdapter[TPF] {
        override def append[M[_,_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_]]
          (
            typeGen: SimpleProduct13.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13],
            sAppender: SimpleProduct13.SimpleAppender[M])
          : M[TPF[({ type NXX[_] = N1[T] })#NXX],TPF[({ type NXX[_] = N2[T] })#NXX],TPF[({ type NXX[_] = N3[T] })#NXX],TPF[({ type NXX[_] = N4[T] })#NXX],TPF[({ type NXX[_] = N5[T] })#NXX],TPF[({ type NXX[_] = N6[T] })#NXX],TPF[({ type NXX[_] = N7[T] })#NXX],TPF[({ type NXX[_] = N8[T] })#NXX],TPF[({ type NXX[_] = N9[T] })#NXX],TPF[({ type NXX[_] = N10[T] })#NXX],TPF[({ type NXX[_] = N11[T] })#NXX],TPF[({ type NXX[_] = N12[T] })#NXX],TPF[({ type NXX[_] = N13[T] })#NXX]] =
            spc.simpleProduct13.append[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX,({ type NXX[_] = N8[T] })#NXX,({ type NXX[_] = N9[T] })#NXX,({ type NXX[_] = N10[T] })#NXX,({ type NXX[_] = N11[T] })#NXX,({ type NXX[_] = N12[T] })#NXX,({ type NXX[_] = N13[T] })#NXX](
              new SimpleProduct13.TypeGen[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX,({ type NXX[_] = N8[T] })#NXX,({ type NXX[_] = N9[T] })#NXX,({ type NXX[_] = N10[T] })#NXX,({ type NXX[_] = N11[T] })#NXX,({ type NXX[_] = N12[T] })#NXX,({ type NXX[_] = N13[T] })#NXX] {
                override def gen[U1]: M[N1[T],N2[T],N3[T],N4[T],N5[T],N6[T],N7[T],N8[T],N9[T],N10[T],N11[T],N12[T],N13[T]] = typeGen.gen[T]
              },
              sAppender
            )
      }
    

      override def simpleProduct14: SimpleProduct14.ProductAdapter[TPF] = new SimpleProduct14.ProductAdapter[TPF] {
        override def append[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_]]
          (
            typeGen: SimpleProduct14.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14],
            sAppender: SimpleProduct14.SimpleAppender[M])
          : M[TPF[({ type NXX[_] = N1[T] })#NXX],TPF[({ type NXX[_] = N2[T] })#NXX],TPF[({ type NXX[_] = N3[T] })#NXX],TPF[({ type NXX[_] = N4[T] })#NXX],TPF[({ type NXX[_] = N5[T] })#NXX],TPF[({ type NXX[_] = N6[T] })#NXX],TPF[({ type NXX[_] = N7[T] })#NXX],TPF[({ type NXX[_] = N8[T] })#NXX],TPF[({ type NXX[_] = N9[T] })#NXX],TPF[({ type NXX[_] = N10[T] })#NXX],TPF[({ type NXX[_] = N11[T] })#NXX],TPF[({ type NXX[_] = N12[T] })#NXX],TPF[({ type NXX[_] = N13[T] })#NXX],TPF[({ type NXX[_] = N14[T] })#NXX]] =
            spc.simpleProduct14.append[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX,({ type NXX[_] = N8[T] })#NXX,({ type NXX[_] = N9[T] })#NXX,({ type NXX[_] = N10[T] })#NXX,({ type NXX[_] = N11[T] })#NXX,({ type NXX[_] = N12[T] })#NXX,({ type NXX[_] = N13[T] })#NXX,({ type NXX[_] = N14[T] })#NXX](
              new SimpleProduct14.TypeGen[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX,({ type NXX[_] = N8[T] })#NXX,({ type NXX[_] = N9[T] })#NXX,({ type NXX[_] = N10[T] })#NXX,({ type NXX[_] = N11[T] })#NXX,({ type NXX[_] = N12[T] })#NXX,({ type NXX[_] = N13[T] })#NXX,({ type NXX[_] = N14[T] })#NXX] {
                override def gen[U1]: M[N1[T],N2[T],N3[T],N4[T],N5[T],N6[T],N7[T],N8[T],N9[T],N10[T],N11[T],N12[T],N13[T],N14[T]] = typeGen.gen[T]
              },
              sAppender
            )
      }
    

      override def simpleProduct15: SimpleProduct15.ProductAdapter[TPF] = new SimpleProduct15.ProductAdapter[TPF] {
        override def append[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_]]
          (
            typeGen: SimpleProduct15.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15],
            sAppender: SimpleProduct15.SimpleAppender[M])
          : M[TPF[({ type NXX[_] = N1[T] })#NXX],TPF[({ type NXX[_] = N2[T] })#NXX],TPF[({ type NXX[_] = N3[T] })#NXX],TPF[({ type NXX[_] = N4[T] })#NXX],TPF[({ type NXX[_] = N5[T] })#NXX],TPF[({ type NXX[_] = N6[T] })#NXX],TPF[({ type NXX[_] = N7[T] })#NXX],TPF[({ type NXX[_] = N8[T] })#NXX],TPF[({ type NXX[_] = N9[T] })#NXX],TPF[({ type NXX[_] = N10[T] })#NXX],TPF[({ type NXX[_] = N11[T] })#NXX],TPF[({ type NXX[_] = N12[T] })#NXX],TPF[({ type NXX[_] = N13[T] })#NXX],TPF[({ type NXX[_] = N14[T] })#NXX],TPF[({ type NXX[_] = N15[T] })#NXX]] =
            spc.simpleProduct15.append[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX,({ type NXX[_] = N8[T] })#NXX,({ type NXX[_] = N9[T] })#NXX,({ type NXX[_] = N10[T] })#NXX,({ type NXX[_] = N11[T] })#NXX,({ type NXX[_] = N12[T] })#NXX,({ type NXX[_] = N13[T] })#NXX,({ type NXX[_] = N14[T] })#NXX,({ type NXX[_] = N15[T] })#NXX](
              new SimpleProduct15.TypeGen[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX,({ type NXX[_] = N8[T] })#NXX,({ type NXX[_] = N9[T] })#NXX,({ type NXX[_] = N10[T] })#NXX,({ type NXX[_] = N11[T] })#NXX,({ type NXX[_] = N12[T] })#NXX,({ type NXX[_] = N13[T] })#NXX,({ type NXX[_] = N14[T] })#NXX,({ type NXX[_] = N15[T] })#NXX] {
                override def gen[U1]: M[N1[T],N2[T],N3[T],N4[T],N5[T],N6[T],N7[T],N8[T],N9[T],N10[T],N11[T],N12[T],N13[T],N14[T],N15[T]] = typeGen.gen[T]
              },
              sAppender
            )
      }
    

      override def simpleProduct16: SimpleProduct16.ProductAdapter[TPF] = new SimpleProduct16.ProductAdapter[TPF] {
        override def append[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_],N16[_]]
          (
            typeGen: SimpleProduct16.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16],
            sAppender: SimpleProduct16.SimpleAppender[M])
          : M[TPF[({ type NXX[_] = N1[T] })#NXX],TPF[({ type NXX[_] = N2[T] })#NXX],TPF[({ type NXX[_] = N3[T] })#NXX],TPF[({ type NXX[_] = N4[T] })#NXX],TPF[({ type NXX[_] = N5[T] })#NXX],TPF[({ type NXX[_] = N6[T] })#NXX],TPF[({ type NXX[_] = N7[T] })#NXX],TPF[({ type NXX[_] = N8[T] })#NXX],TPF[({ type NXX[_] = N9[T] })#NXX],TPF[({ type NXX[_] = N10[T] })#NXX],TPF[({ type NXX[_] = N11[T] })#NXX],TPF[({ type NXX[_] = N12[T] })#NXX],TPF[({ type NXX[_] = N13[T] })#NXX],TPF[({ type NXX[_] = N14[T] })#NXX],TPF[({ type NXX[_] = N15[T] })#NXX],TPF[({ type NXX[_] = N16[T] })#NXX]] =
            spc.simpleProduct16.append[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX,({ type NXX[_] = N8[T] })#NXX,({ type NXX[_] = N9[T] })#NXX,({ type NXX[_] = N10[T] })#NXX,({ type NXX[_] = N11[T] })#NXX,({ type NXX[_] = N12[T] })#NXX,({ type NXX[_] = N13[T] })#NXX,({ type NXX[_] = N14[T] })#NXX,({ type NXX[_] = N15[T] })#NXX,({ type NXX[_] = N16[T] })#NXX](
              new SimpleProduct16.TypeGen[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX,({ type NXX[_] = N8[T] })#NXX,({ type NXX[_] = N9[T] })#NXX,({ type NXX[_] = N10[T] })#NXX,({ type NXX[_] = N11[T] })#NXX,({ type NXX[_] = N12[T] })#NXX,({ type NXX[_] = N13[T] })#NXX,({ type NXX[_] = N14[T] })#NXX,({ type NXX[_] = N15[T] })#NXX,({ type NXX[_] = N16[T] })#NXX] {
                override def gen[U1]: M[N1[T],N2[T],N3[T],N4[T],N5[T],N6[T],N7[T],N8[T],N9[T],N10[T],N11[T],N12[T],N13[T],N14[T],N15[T],N16[T]] = typeGen.gen[T]
              },
              sAppender
            )
      }
    

      override def simpleProduct17: SimpleProduct17.ProductAdapter[TPF] = new SimpleProduct17.ProductAdapter[TPF] {
        override def append[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_],N16[_],N17[_]]
          (
            typeGen: SimpleProduct17.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17],
            sAppender: SimpleProduct17.SimpleAppender[M])
          : M[TPF[({ type NXX[_] = N1[T] })#NXX],TPF[({ type NXX[_] = N2[T] })#NXX],TPF[({ type NXX[_] = N3[T] })#NXX],TPF[({ type NXX[_] = N4[T] })#NXX],TPF[({ type NXX[_] = N5[T] })#NXX],TPF[({ type NXX[_] = N6[T] })#NXX],TPF[({ type NXX[_] = N7[T] })#NXX],TPF[({ type NXX[_] = N8[T] })#NXX],TPF[({ type NXX[_] = N9[T] })#NXX],TPF[({ type NXX[_] = N10[T] })#NXX],TPF[({ type NXX[_] = N11[T] })#NXX],TPF[({ type NXX[_] = N12[T] })#NXX],TPF[({ type NXX[_] = N13[T] })#NXX],TPF[({ type NXX[_] = N14[T] })#NXX],TPF[({ type NXX[_] = N15[T] })#NXX],TPF[({ type NXX[_] = N16[T] })#NXX],TPF[({ type NXX[_] = N17[T] })#NXX]] =
            spc.simpleProduct17.append[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX,({ type NXX[_] = N8[T] })#NXX,({ type NXX[_] = N9[T] })#NXX,({ type NXX[_] = N10[T] })#NXX,({ type NXX[_] = N11[T] })#NXX,({ type NXX[_] = N12[T] })#NXX,({ type NXX[_] = N13[T] })#NXX,({ type NXX[_] = N14[T] })#NXX,({ type NXX[_] = N15[T] })#NXX,({ type NXX[_] = N16[T] })#NXX,({ type NXX[_] = N17[T] })#NXX](
              new SimpleProduct17.TypeGen[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX,({ type NXX[_] = N8[T] })#NXX,({ type NXX[_] = N9[T] })#NXX,({ type NXX[_] = N10[T] })#NXX,({ type NXX[_] = N11[T] })#NXX,({ type NXX[_] = N12[T] })#NXX,({ type NXX[_] = N13[T] })#NXX,({ type NXX[_] = N14[T] })#NXX,({ type NXX[_] = N15[T] })#NXX,({ type NXX[_] = N16[T] })#NXX,({ type NXX[_] = N17[T] })#NXX] {
                override def gen[U1]: M[N1[T],N2[T],N3[T],N4[T],N5[T],N6[T],N7[T],N8[T],N9[T],N10[T],N11[T],N12[T],N13[T],N14[T],N15[T],N16[T],N17[T]] = typeGen.gen[T]
              },
              sAppender
            )
      }
    

      override def simpleProduct18: SimpleProduct18.ProductAdapter[TPF] = new SimpleProduct18.ProductAdapter[TPF] {
        override def append[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_],N16[_],N17[_],N18[_]]
          (
            typeGen: SimpleProduct18.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18],
            sAppender: SimpleProduct18.SimpleAppender[M])
          : M[TPF[({ type NXX[_] = N1[T] })#NXX],TPF[({ type NXX[_] = N2[T] })#NXX],TPF[({ type NXX[_] = N3[T] })#NXX],TPF[({ type NXX[_] = N4[T] })#NXX],TPF[({ type NXX[_] = N5[T] })#NXX],TPF[({ type NXX[_] = N6[T] })#NXX],TPF[({ type NXX[_] = N7[T] })#NXX],TPF[({ type NXX[_] = N8[T] })#NXX],TPF[({ type NXX[_] = N9[T] })#NXX],TPF[({ type NXX[_] = N10[T] })#NXX],TPF[({ type NXX[_] = N11[T] })#NXX],TPF[({ type NXX[_] = N12[T] })#NXX],TPF[({ type NXX[_] = N13[T] })#NXX],TPF[({ type NXX[_] = N14[T] })#NXX],TPF[({ type NXX[_] = N15[T] })#NXX],TPF[({ type NXX[_] = N16[T] })#NXX],TPF[({ type NXX[_] = N17[T] })#NXX],TPF[({ type NXX[_] = N18[T] })#NXX]] =
            spc.simpleProduct18.append[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX,({ type NXX[_] = N8[T] })#NXX,({ type NXX[_] = N9[T] })#NXX,({ type NXX[_] = N10[T] })#NXX,({ type NXX[_] = N11[T] })#NXX,({ type NXX[_] = N12[T] })#NXX,({ type NXX[_] = N13[T] })#NXX,({ type NXX[_] = N14[T] })#NXX,({ type NXX[_] = N15[T] })#NXX,({ type NXX[_] = N16[T] })#NXX,({ type NXX[_] = N17[T] })#NXX,({ type NXX[_] = N18[T] })#NXX](
              new SimpleProduct18.TypeGen[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX,({ type NXX[_] = N8[T] })#NXX,({ type NXX[_] = N9[T] })#NXX,({ type NXX[_] = N10[T] })#NXX,({ type NXX[_] = N11[T] })#NXX,({ type NXX[_] = N12[T] })#NXX,({ type NXX[_] = N13[T] })#NXX,({ type NXX[_] = N14[T] })#NXX,({ type NXX[_] = N15[T] })#NXX,({ type NXX[_] = N16[T] })#NXX,({ type NXX[_] = N17[T] })#NXX,({ type NXX[_] = N18[T] })#NXX] {
                override def gen[U1]: M[N1[T],N2[T],N3[T],N4[T],N5[T],N6[T],N7[T],N8[T],N9[T],N10[T],N11[T],N12[T],N13[T],N14[T],N15[T],N16[T],N17[T],N18[T]] = typeGen.gen[T]
              },
              sAppender
            )
      }
    

      override def simpleProduct19: SimpleProduct19.ProductAdapter[TPF] = new SimpleProduct19.ProductAdapter[TPF] {
        override def append[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_],N16[_],N17[_],N18[_],N19[_]]
          (
            typeGen: SimpleProduct19.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18,N19],
            sAppender: SimpleProduct19.SimpleAppender[M])
          : M[TPF[({ type NXX[_] = N1[T] })#NXX],TPF[({ type NXX[_] = N2[T] })#NXX],TPF[({ type NXX[_] = N3[T] })#NXX],TPF[({ type NXX[_] = N4[T] })#NXX],TPF[({ type NXX[_] = N5[T] })#NXX],TPF[({ type NXX[_] = N6[T] })#NXX],TPF[({ type NXX[_] = N7[T] })#NXX],TPF[({ type NXX[_] = N8[T] })#NXX],TPF[({ type NXX[_] = N9[T] })#NXX],TPF[({ type NXX[_] = N10[T] })#NXX],TPF[({ type NXX[_] = N11[T] })#NXX],TPF[({ type NXX[_] = N12[T] })#NXX],TPF[({ type NXX[_] = N13[T] })#NXX],TPF[({ type NXX[_] = N14[T] })#NXX],TPF[({ type NXX[_] = N15[T] })#NXX],TPF[({ type NXX[_] = N16[T] })#NXX],TPF[({ type NXX[_] = N17[T] })#NXX],TPF[({ type NXX[_] = N18[T] })#NXX],TPF[({ type NXX[_] = N19[T] })#NXX]] =
            spc.simpleProduct19.append[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX,({ type NXX[_] = N8[T] })#NXX,({ type NXX[_] = N9[T] })#NXX,({ type NXX[_] = N10[T] })#NXX,({ type NXX[_] = N11[T] })#NXX,({ type NXX[_] = N12[T] })#NXX,({ type NXX[_] = N13[T] })#NXX,({ type NXX[_] = N14[T] })#NXX,({ type NXX[_] = N15[T] })#NXX,({ type NXX[_] = N16[T] })#NXX,({ type NXX[_] = N17[T] })#NXX,({ type NXX[_] = N18[T] })#NXX,({ type NXX[_] = N19[T] })#NXX](
              new SimpleProduct19.TypeGen[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX,({ type NXX[_] = N8[T] })#NXX,({ type NXX[_] = N9[T] })#NXX,({ type NXX[_] = N10[T] })#NXX,({ type NXX[_] = N11[T] })#NXX,({ type NXX[_] = N12[T] })#NXX,({ type NXX[_] = N13[T] })#NXX,({ type NXX[_] = N14[T] })#NXX,({ type NXX[_] = N15[T] })#NXX,({ type NXX[_] = N16[T] })#NXX,({ type NXX[_] = N17[T] })#NXX,({ type NXX[_] = N18[T] })#NXX,({ type NXX[_] = N19[T] })#NXX] {
                override def gen[U1]: M[N1[T],N2[T],N3[T],N4[T],N5[T],N6[T],N7[T],N8[T],N9[T],N10[T],N11[T],N12[T],N13[T],N14[T],N15[T],N16[T],N17[T],N18[T],N19[T]] = typeGen.gen[T]
              },
              sAppender
            )
      }
    

      override def simpleProduct20: SimpleProduct20.ProductAdapter[TPF] = new SimpleProduct20.ProductAdapter[TPF] {
        override def append[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_],N16[_],N17[_],N18[_],N19[_],N20[_]]
          (
            typeGen: SimpleProduct20.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18,N19,N20],
            sAppender: SimpleProduct20.SimpleAppender[M])
          : M[TPF[({ type NXX[_] = N1[T] })#NXX],TPF[({ type NXX[_] = N2[T] })#NXX],TPF[({ type NXX[_] = N3[T] })#NXX],TPF[({ type NXX[_] = N4[T] })#NXX],TPF[({ type NXX[_] = N5[T] })#NXX],TPF[({ type NXX[_] = N6[T] })#NXX],TPF[({ type NXX[_] = N7[T] })#NXX],TPF[({ type NXX[_] = N8[T] })#NXX],TPF[({ type NXX[_] = N9[T] })#NXX],TPF[({ type NXX[_] = N10[T] })#NXX],TPF[({ type NXX[_] = N11[T] })#NXX],TPF[({ type NXX[_] = N12[T] })#NXX],TPF[({ type NXX[_] = N13[T] })#NXX],TPF[({ type NXX[_] = N14[T] })#NXX],TPF[({ type NXX[_] = N15[T] })#NXX],TPF[({ type NXX[_] = N16[T] })#NXX],TPF[({ type NXX[_] = N17[T] })#NXX],TPF[({ type NXX[_] = N18[T] })#NXX],TPF[({ type NXX[_] = N19[T] })#NXX],TPF[({ type NXX[_] = N20[T] })#NXX]] =
            spc.simpleProduct20.append[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX,({ type NXX[_] = N8[T] })#NXX,({ type NXX[_] = N9[T] })#NXX,({ type NXX[_] = N10[T] })#NXX,({ type NXX[_] = N11[T] })#NXX,({ type NXX[_] = N12[T] })#NXX,({ type NXX[_] = N13[T] })#NXX,({ type NXX[_] = N14[T] })#NXX,({ type NXX[_] = N15[T] })#NXX,({ type NXX[_] = N16[T] })#NXX,({ type NXX[_] = N17[T] })#NXX,({ type NXX[_] = N18[T] })#NXX,({ type NXX[_] = N19[T] })#NXX,({ type NXX[_] = N20[T] })#NXX](
              new SimpleProduct20.TypeGen[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX,({ type NXX[_] = N8[T] })#NXX,({ type NXX[_] = N9[T] })#NXX,({ type NXX[_] = N10[T] })#NXX,({ type NXX[_] = N11[T] })#NXX,({ type NXX[_] = N12[T] })#NXX,({ type NXX[_] = N13[T] })#NXX,({ type NXX[_] = N14[T] })#NXX,({ type NXX[_] = N15[T] })#NXX,({ type NXX[_] = N16[T] })#NXX,({ type NXX[_] = N17[T] })#NXX,({ type NXX[_] = N18[T] })#NXX,({ type NXX[_] = N19[T] })#NXX,({ type NXX[_] = N20[T] })#NXX] {
                override def gen[U1]: M[N1[T],N2[T],N3[T],N4[T],N5[T],N6[T],N7[T],N8[T],N9[T],N10[T],N11[T],N12[T],N13[T],N14[T],N15[T],N16[T],N17[T],N18[T],N19[T],N20[T]] = typeGen.gen[T]
              },
              sAppender
            )
      }
    

      override def simpleProduct21: SimpleProduct21.ProductAdapter[TPF] = new SimpleProduct21.ProductAdapter[TPF] {
        override def append[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_],N16[_],N17[_],N18[_],N19[_],N20[_],N21[_]]
          (
            typeGen: SimpleProduct21.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18,N19,N20,N21],
            sAppender: SimpleProduct21.SimpleAppender[M])
          : M[TPF[({ type NXX[_] = N1[T] })#NXX],TPF[({ type NXX[_] = N2[T] })#NXX],TPF[({ type NXX[_] = N3[T] })#NXX],TPF[({ type NXX[_] = N4[T] })#NXX],TPF[({ type NXX[_] = N5[T] })#NXX],TPF[({ type NXX[_] = N6[T] })#NXX],TPF[({ type NXX[_] = N7[T] })#NXX],TPF[({ type NXX[_] = N8[T] })#NXX],TPF[({ type NXX[_] = N9[T] })#NXX],TPF[({ type NXX[_] = N10[T] })#NXX],TPF[({ type NXX[_] = N11[T] })#NXX],TPF[({ type NXX[_] = N12[T] })#NXX],TPF[({ type NXX[_] = N13[T] })#NXX],TPF[({ type NXX[_] = N14[T] })#NXX],TPF[({ type NXX[_] = N15[T] })#NXX],TPF[({ type NXX[_] = N16[T] })#NXX],TPF[({ type NXX[_] = N17[T] })#NXX],TPF[({ type NXX[_] = N18[T] })#NXX],TPF[({ type NXX[_] = N19[T] })#NXX],TPF[({ type NXX[_] = N20[T] })#NXX],TPF[({ type NXX[_] = N21[T] })#NXX]] =
            spc.simpleProduct21.append[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX,({ type NXX[_] = N8[T] })#NXX,({ type NXX[_] = N9[T] })#NXX,({ type NXX[_] = N10[T] })#NXX,({ type NXX[_] = N11[T] })#NXX,({ type NXX[_] = N12[T] })#NXX,({ type NXX[_] = N13[T] })#NXX,({ type NXX[_] = N14[T] })#NXX,({ type NXX[_] = N15[T] })#NXX,({ type NXX[_] = N16[T] })#NXX,({ type NXX[_] = N17[T] })#NXX,({ type NXX[_] = N18[T] })#NXX,({ type NXX[_] = N19[T] })#NXX,({ type NXX[_] = N20[T] })#NXX,({ type NXX[_] = N21[T] })#NXX](
              new SimpleProduct21.TypeGen[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX,({ type NXX[_] = N8[T] })#NXX,({ type NXX[_] = N9[T] })#NXX,({ type NXX[_] = N10[T] })#NXX,({ type NXX[_] = N11[T] })#NXX,({ type NXX[_] = N12[T] })#NXX,({ type NXX[_] = N13[T] })#NXX,({ type NXX[_] = N14[T] })#NXX,({ type NXX[_] = N15[T] })#NXX,({ type NXX[_] = N16[T] })#NXX,({ type NXX[_] = N17[T] })#NXX,({ type NXX[_] = N18[T] })#NXX,({ type NXX[_] = N19[T] })#NXX,({ type NXX[_] = N20[T] })#NXX,({ type NXX[_] = N21[T] })#NXX] {
                override def gen[U1]: M[N1[T],N2[T],N3[T],N4[T],N5[T],N6[T],N7[T],N8[T],N9[T],N10[T],N11[T],N12[T],N13[T],N14[T],N15[T],N16[T],N17[T],N18[T],N19[T],N20[T],N21[T]] = typeGen.gen[T]
              },
              sAppender
            )
      }
    

      override def simpleProduct22: SimpleProduct22.ProductAdapter[TPF] = new SimpleProduct22.ProductAdapter[TPF] {
        override def append[M[_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_,_], N1[_],N2[_],N3[_],N4[_],N5[_],N6[_],N7[_],N8[_],N9[_],N10[_],N11[_],N12[_],N13[_],N14[_],N15[_],N16[_],N17[_],N18[_],N19[_],N20[_],N21[_],N22[_]]
          (
            typeGen: SimpleProduct22.TypeGen[M, N1,N2,N3,N4,N5,N6,N7,N8,N9,N10,N11,N12,N13,N14,N15,N16,N17,N18,N19,N20,N21,N22],
            sAppender: SimpleProduct22.SimpleAppender[M])
          : M[TPF[({ type NXX[_] = N1[T] })#NXX],TPF[({ type NXX[_] = N2[T] })#NXX],TPF[({ type NXX[_] = N3[T] })#NXX],TPF[({ type NXX[_] = N4[T] })#NXX],TPF[({ type NXX[_] = N5[T] })#NXX],TPF[({ type NXX[_] = N6[T] })#NXX],TPF[({ type NXX[_] = N7[T] })#NXX],TPF[({ type NXX[_] = N8[T] })#NXX],TPF[({ type NXX[_] = N9[T] })#NXX],TPF[({ type NXX[_] = N10[T] })#NXX],TPF[({ type NXX[_] = N11[T] })#NXX],TPF[({ type NXX[_] = N12[T] })#NXX],TPF[({ type NXX[_] = N13[T] })#NXX],TPF[({ type NXX[_] = N14[T] })#NXX],TPF[({ type NXX[_] = N15[T] })#NXX],TPF[({ type NXX[_] = N16[T] })#NXX],TPF[({ type NXX[_] = N17[T] })#NXX],TPF[({ type NXX[_] = N18[T] })#NXX],TPF[({ type NXX[_] = N19[T] })#NXX],TPF[({ type NXX[_] = N20[T] })#NXX],TPF[({ type NXX[_] = N21[T] })#NXX],TPF[({ type NXX[_] = N22[T] })#NXX]] =
            spc.simpleProduct22.append[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX,({ type NXX[_] = N8[T] })#NXX,({ type NXX[_] = N9[T] })#NXX,({ type NXX[_] = N10[T] })#NXX,({ type NXX[_] = N11[T] })#NXX,({ type NXX[_] = N12[T] })#NXX,({ type NXX[_] = N13[T] })#NXX,({ type NXX[_] = N14[T] })#NXX,({ type NXX[_] = N15[T] })#NXX,({ type NXX[_] = N16[T] })#NXX,({ type NXX[_] = N17[T] })#NXX,({ type NXX[_] = N18[T] })#NXX,({ type NXX[_] = N19[T] })#NXX,({ type NXX[_] = N20[T] })#NXX,({ type NXX[_] = N21[T] })#NXX,({ type NXX[_] = N22[T] })#NXX](
              new SimpleProduct22.TypeGen[M, ({ type NXX[_] = N1[T] })#NXX,({ type NXX[_] = N2[T] })#NXX,({ type NXX[_] = N3[T] })#NXX,({ type NXX[_] = N4[T] })#NXX,({ type NXX[_] = N5[T] })#NXX,({ type NXX[_] = N6[T] })#NXX,({ type NXX[_] = N7[T] })#NXX,({ type NXX[_] = N8[T] })#NXX,({ type NXX[_] = N9[T] })#NXX,({ type NXX[_] = N10[T] })#NXX,({ type NXX[_] = N11[T] })#NXX,({ type NXX[_] = N12[T] })#NXX,({ type NXX[_] = N13[T] })#NXX,({ type NXX[_] = N14[T] })#NXX,({ type NXX[_] = N15[T] })#NXX,({ type NXX[_] = N16[T] })#NXX,({ type NXX[_] = N17[T] })#NXX,({ type NXX[_] = N18[T] })#NXX,({ type NXX[_] = N19[T] })#NXX,({ type NXX[_] = N20[T] })#NXX,({ type NXX[_] = N21[T] })#NXX,({ type NXX[_] = N22[T] })#NXX] {
                override def gen[U1]: M[N1[T],N2[T],N3[T],N4[T],N5[T],N6[T],N7[T],N8[T],N9[T],N10[T],N11[T],N12[T],N13[T],N14[T],N15[T],N16[T],N17[T],N18[T],N19[T],N20[T],N21[T],N22[T]] = typeGen.gen[T]
              },
              sAppender
            )
      }
    
        }
      }

    }
  