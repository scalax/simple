package net.scalax.simple.nat.adt
package impl

import shapeless._

trait TypeAdtAlias {

  type TypeOptions1[A, I1]        = TypeAdt[A, I1 :: HNil, ConfirmSucceed]
  type TypeOptions1F[F[_], A, I1] = TypeAdt[F[A], I1 :: HNil, ConfirmSucceed]

  type TypeOptions2[A, I1, I2]        = TypeAdt[A, I1 :: I2 :: HNil, ConfirmSucceed]
  type TypeOptions2F[F[_], A, I1, I2] = TypeAdt[F[A], I1 :: I2 :: HNil, ConfirmSucceed]

  type TypeOptions3[A, I1, I2, I3]        = TypeAdt[A, I1 :: I2 :: I3 :: HNil, ConfirmSucceed]
  type TypeOptions3F[F[_], A, I1, I2, I3] = TypeAdt[F[A], I1 :: I2 :: I3 :: HNil, ConfirmSucceed]

  type TypeOptions4[A, I1, I2, I3, I4]        = TypeAdt[A, I1 :: I2 :: I3 :: I4 :: HNil, ConfirmSucceed]
  type TypeOptions4F[F[_], A, I1, I2, I3, I4] = TypeAdt[F[A], I1 :: I2 :: I3 :: I4 :: HNil, ConfirmSucceed]

  type TypeOptions5[A, I1, I2, I3, I4, I5]        = TypeAdt[A, I1 :: I2 :: I3 :: I4 :: I5 :: HNil, ConfirmSucceed]
  type TypeOptions5F[F[_], A, I1, I2, I3, I4, I5] = TypeAdt[F[A], I1 :: I2 :: I3 :: I4 :: I5 :: HNil, ConfirmSucceed]

  type TypeOptions6[A, I1, I2, I3, I4, I5, I6]        = TypeAdt[A, I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: HNil, ConfirmSucceed]
  type TypeOptions6F[F[_], A, I1, I2, I3, I4, I5, I6] = TypeAdt[F[A], I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: HNil, ConfirmSucceed]

  type TypeOptions7[A, I1, I2, I3, I4, I5, I6, I7]        = TypeAdt[A, I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: HNil, ConfirmSucceed]
  type TypeOptions7F[F[_], A, I1, I2, I3, I4, I5, I6, I7] = TypeAdt[F[A], I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: HNil, ConfirmSucceed]

  type TypeOptions8[A, I1, I2, I3, I4, I5, I6, I7, I8] = TypeAdt[A, I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: HNil, ConfirmSucceed]
  type TypeOptions8F[F[_], A, I1, I2, I3, I4, I5, I6, I7, I8] =
    TypeAdt[F[A], I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: HNil, ConfirmSucceed]

  type TypeOptions9[A, I1, I2, I3, I4, I5, I6, I7, I8, I9] =
    TypeAdt[A, I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: HNil, ConfirmSucceed]
  type TypeOptions9F[F[_], A, I1, I2, I3, I4, I5, I6, I7, I8, I9] =
    TypeAdt[F[A], I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: HNil, ConfirmSucceed]

  type TypeOptions10[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] =
    TypeAdt[A, I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: HNil, ConfirmSucceed]
  type TypeOptions10F[F[_], A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] =
    TypeAdt[F[A], I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: HNil, ConfirmSucceed]

  type TypeOptions11[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] =
    TypeAdt[A, I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: HNil, ConfirmSucceed]
  type TypeOptions11F[F[_], A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] =
    TypeAdt[F[A], I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: HNil, ConfirmSucceed]

  type TypeOptions12[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] =
    TypeAdt[A, I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: HNil, ConfirmSucceed]
  type TypeOptions12F[F[_], A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] =
    TypeAdt[F[A], I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: HNil, ConfirmSucceed]

  type TypeOptions13[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] =
    TypeAdt[A, I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: HNil, ConfirmSucceed]
  type TypeOptions13F[F[_], A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] =
    TypeAdt[F[A], I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: HNil, ConfirmSucceed]

  type TypeOptions14[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] =
    TypeAdt[A, I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: HNil, ConfirmSucceed]
  type TypeOptions14F[F[_], A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] =
    TypeAdt[F[A], I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: HNil, ConfirmSucceed]

  type TypeOptions15[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] =
    TypeAdt[A, I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: HNil, ConfirmSucceed]
  type TypeOptions15F[F[_], A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] =
    TypeAdt[F[A], I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: HNil, ConfirmSucceed]

  type TypeOptions16[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] =
    TypeAdt[A, I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: I16 :: HNil, ConfirmSucceed]
  type TypeOptions16F[F[_], A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] = TypeAdt[F[
    A
  ], I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: I16 :: HNil, ConfirmSucceed]

  type TypeOptions17[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] = TypeAdt[
    A,
    I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: I16 :: I17 :: HNil,
    ConfirmSucceed
  ]
  type TypeOptions17F[F[_], A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] = TypeAdt[F[
    A
  ], I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: I16 :: I17 :: HNil, ConfirmSucceed]

  type TypeOptions18[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] = TypeAdt[
    A,
    I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: I16 :: I17 :: I18 :: HNil,
    ConfirmSucceed
  ]
  type TypeOptions18F[F[_], A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] =
    TypeAdt[F[A], I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: I16 :: I17 :: I18 :: HNil, ConfirmSucceed]

  type TypeOptions19[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] = TypeAdt[
    A,
    I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: I16 :: I17 :: I18 :: I19 :: HNil,
    ConfirmSucceed
  ]
  type TypeOptions19F[F[_], A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] = TypeAdt[F[
    A
  ], I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: I16 :: I17 :: I18 :: I19 :: HNil, ConfirmSucceed]

  type TypeOptions20[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] = TypeAdt[
    A,
    I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: I16 :: I17 :: I18 :: I19 :: I20 :: HNil,
    ConfirmSucceed
  ]
  type TypeOptions20F[F[_], A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] = TypeAdt[F[
    A
  ], I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: I16 :: I17 :: I18 :: I19 :: I20 :: HNil, ConfirmSucceed]

  type TypeOptions21[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] = TypeAdt[
    A,
    I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: I16 :: I17 :: I18 :: I19 :: I20 ::
      I21 :: HNil,
    ConfirmSucceed
  ]
  type TypeOptions21F[F[_], A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] = TypeAdt[F[
    A
  ], I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: I16 :: I17 :: I18 :: I19 :: I20 :: I21 :: HNil, ConfirmSucceed]

  type TypeOptions22[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22] = TypeAdt[
    A,
    I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: I16 :: I17 :: I18 :: I19 :: I20 ::
      I21 :: I22 :: HNil,
    ConfirmSucceed
  ]
  type TypeOptions22F[F[_], A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22] =
    TypeAdt[
      F[A],
      I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: I16 :: I17 :: I18 :: I19 :: I20 ::
        I21 :: I22 :: HNil,
      ConfirmSucceed
    ]

}
