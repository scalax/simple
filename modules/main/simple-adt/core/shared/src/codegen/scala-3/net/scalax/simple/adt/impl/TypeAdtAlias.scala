package net.scalax.simple.adt
package impl

trait TypeAdtAlias {

  type TypeOptions1[A, I1] = TypeAdt.Aux[A, I1 *: EmptyTuple, ConfirmSucceed]

  type TypeOptions2[A, I1, I2] = TypeAdt.Aux[A, (I1, I2), ConfirmSucceed]

  type TypeOptions3[A, I1, I2, I3] = TypeAdt.Aux[A, (I1, I2, I3), ConfirmSucceed]

  type TypeOptions4[A, I1, I2, I3, I4] = TypeAdt.Aux[A, (I1, I2, I3, I4), ConfirmSucceed]

  type TypeOptions5[A, I1, I2, I3, I4, I5] = TypeAdt.Aux[A, (I1, I2, I3, I4, I5), ConfirmSucceed]

  type TypeOptions6[A, I1, I2, I3, I4, I5, I6] = TypeAdt.Aux[A, (I1, I2, I3, I4, I5, I6), ConfirmSucceed]

  type TypeOptions7[A, I1, I2, I3, I4, I5, I6, I7] = TypeAdt.Aux[A, (I1, I2, I3, I4, I5, I6, I7), ConfirmSucceed]

  type TypeOptions8[A, I1, I2, I3, I4, I5, I6, I7, I8] = TypeAdt.Aux[A, (I1, I2, I3, I4, I5, I6, I7, I8), ConfirmSucceed]

  type TypeOptions9[A, I1, I2, I3, I4, I5, I6, I7, I8, I9] = TypeAdt.Aux[A, (I1, I2, I3, I4, I5, I6, I7, I8, I9), ConfirmSucceed]

  type TypeOptions10[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] = TypeAdt.Aux[A, (I1, I2, I3, I4, I5, I6, I7, I8, I9, I10), ConfirmSucceed]

  type TypeOptions11[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] =
    TypeAdt.Aux[A, (I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11), ConfirmSucceed]

  type TypeOptions12[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] =
    TypeAdt.Aux[A, (I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12), ConfirmSucceed]

  type TypeOptions13[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] =
    TypeAdt.Aux[A, (I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13), ConfirmSucceed]

  type TypeOptions14[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] =
    TypeAdt.Aux[A, (I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14), ConfirmSucceed]

  type TypeOptions15[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] =
    TypeAdt.Aux[A, (I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15), ConfirmSucceed]

  type TypeOptions16[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] =
    TypeAdt.Aux[A, (I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16), ConfirmSucceed]

  type TypeOptions17[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] =
    TypeAdt.Aux[A, (I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17), ConfirmSucceed]

  type TypeOptions18[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] =
    TypeAdt.Aux[A, (I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18), ConfirmSucceed]

  type TypeOptions19[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] =
    TypeAdt.Aux[A, (I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19), ConfirmSucceed]

  type TypeOptions20[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] =
    TypeAdt.Aux[A, (I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20), ConfirmSucceed]

  type TypeOptions21[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] =
    TypeAdt.Aux[A, (I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21), ConfirmSucceed]

  type TypeOptions22[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22] =
    TypeAdt.Aux[A, (I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22), ConfirmSucceed]

}
