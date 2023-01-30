package net.scalax.simple.adt
package impl

trait TypeAdtAlias {

  type Options1[A, I1] = TypeAdtApply.Aux[A, I1 *: EmptyTuple, ConfirmSucceed]

  type Options2[A, I1, I2] = TypeAdtApply.Aux[A, (I1, I2), ConfirmSucceed]

  type Options3[A, I1, I2, I3] = TypeAdtApply.Aux[A, (I1, I2, I3), ConfirmSucceed]

  type Options4[A, I1, I2, I3, I4] = TypeAdtApply.Aux[A, (I1, I2, I3, I4), ConfirmSucceed]

  type Options5[A, I1, I2, I3, I4, I5] = TypeAdtApply.Aux[A, (I1, I2, I3, I4, I5), ConfirmSucceed]

  type Options6[A, I1, I2, I3, I4, I5, I6] = TypeAdtApply.Aux[A, (I1, I2, I3, I4, I5, I6), ConfirmSucceed]

  type Options7[A, I1, I2, I3, I4, I5, I6, I7] = TypeAdtApply.Aux[A, (I1, I2, I3, I4, I5, I6, I7), ConfirmSucceed]

  type Options8[A, I1, I2, I3, I4, I5, I6, I7, I8] = TypeAdtApply.Aux[A, (I1, I2, I3, I4, I5, I6, I7, I8), ConfirmSucceed]

  type Options9[A, I1, I2, I3, I4, I5, I6, I7, I8, I9] = TypeAdtApply.Aux[A, (I1, I2, I3, I4, I5, I6, I7, I8, I9), ConfirmSucceed]

  type Options10[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] =
    TypeAdtApply.Aux[A, (I1, I2, I3, I4, I5, I6, I7, I8, I9, I10), ConfirmSucceed]

  type Options11[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] =
    TypeAdtApply.Aux[A, (I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11), ConfirmSucceed]

  type Options12[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] =
    TypeAdtApply.Aux[A, (I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12), ConfirmSucceed]

  type Options13[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] =
    TypeAdtApply.Aux[A, (I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13), ConfirmSucceed]

  type Options14[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] =
    TypeAdtApply.Aux[A, (I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14), ConfirmSucceed]

  type Options15[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] =
    TypeAdtApply.Aux[A, (I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15), ConfirmSucceed]

  type Options16[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] =
    TypeAdtApply.Aux[A, (I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16), ConfirmSucceed]

  type Options17[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] =
    TypeAdtApply.Aux[A, (I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17), ConfirmSucceed]

  type Options18[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] =
    TypeAdtApply.Aux[A, (I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18), ConfirmSucceed]

  type Options19[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] =
    TypeAdtApply.Aux[A, (I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19), ConfirmSucceed]

  type Options20[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] =
    TypeAdtApply.Aux[A, (I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20), ConfirmSucceed]

  type Options21[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] =
    TypeAdtApply.Aux[A, (I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21), ConfirmSucceed]

  type Options22[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22] = TypeAdtApply.Aux[
    A,
    (I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22),
    ConfirmSucceed
  ]

}
