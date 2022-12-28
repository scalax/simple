package net.scalax.simple.adt
package impl

trait TypeAdtAlias {

  type TypeOptions1[A, I1] = TypeAdt.Aux[A, NumberCountChild[I1, NumberCountZero], ConfirmSucceed]

  type TypeOptions2[A, I1, I2] = TypeAdt.Aux[A, NumberCountChild[I1, NumberCountChild[I2, NumberCountZero]], ConfirmSucceed]

  type TypeOptions3[A, I1, I2, I3] =
    TypeAdt.Aux[A, NumberCountChild[I1, NumberCountChild[I2, NumberCountChild[I3, NumberCountZero]]], ConfirmSucceed]

  type TypeOptions4[A, I1, I2, I3, I4] =
    TypeAdt.Aux[A, NumberCountChild[I1, NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[I4, NumberCountZero]]]], ConfirmSucceed]

  type TypeOptions5[A, I1, I2, I3, I4, I5] = TypeAdt.Aux[A, NumberCountChild[
    I1,
    NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[I5, NumberCountZero]]]]
  ], ConfirmSucceed]

  type TypeOptions6[A, I1, I2, I3, I4, I5, I6] = TypeAdt.Aux[A, NumberCountChild[
    I1,
    NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[I6, NumberCountZero]]]]]
  ], ConfirmSucceed]

  type TypeOptions7[A, I1, I2, I3, I4, I5, I6, I7] = TypeAdt.Aux[A, NumberCountChild[I1, NumberCountChild[
    I2,
    NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[I7, NumberCountZero]]]]]
  ]], ConfirmSucceed]

  type TypeOptions8[A, I1, I2, I3, I4, I5, I6, I7, I8] = TypeAdt.Aux[A, NumberCountChild[I1, NumberCountChild[I2, NumberCountChild[
    I3,
    NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[I7, NumberCountChild[I8, NumberCountZero]]]]]
  ]]], ConfirmSucceed]

  type TypeOptions9[A, I1, I2, I3, I4, I5, I6, I7, I8, I9] =
    TypeAdt.Aux[A, NumberCountChild[I1, NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[
      I4,
      NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[I7, NumberCountChild[I8, NumberCountChild[I9, NumberCountZero]]]]]
    ]]]], ConfirmSucceed]

  type TypeOptions10[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] =
    TypeAdt.Aux[A, NumberCountChild[I1, NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[
      I5,
      NumberCountChild[I6, NumberCountChild[I7, NumberCountChild[I8, NumberCountChild[I9, NumberCountChild[I10, NumberCountZero]]]]]
    ]]]]], ConfirmSucceed]

  type TypeOptions11[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] = TypeAdt.Aux[A, NumberCountChild[
    I1,
    NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[
      I6,
      NumberCountChild[I7, NumberCountChild[I8, NumberCountChild[I9, NumberCountChild[I10, NumberCountChild[I11, NumberCountZero]]]]]
    ]]]]]
  ], ConfirmSucceed]

  type TypeOptions12[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] = TypeAdt.Aux[A, NumberCountChild[
    I1,
    NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[
      I7,
      NumberCountChild[I8, NumberCountChild[I9, NumberCountChild[I10, NumberCountChild[I11, NumberCountChild[I12, NumberCountZero]]]]]
    ]]]]]]
  ], ConfirmSucceed]

  type TypeOptions13[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] = TypeAdt.Aux[A, NumberCountChild[I1, NumberCountChild[
    I2,
    NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[I7, NumberCountChild[
      I8,
      NumberCountChild[I9, NumberCountChild[I10, NumberCountChild[I11, NumberCountChild[I12, NumberCountChild[I13, NumberCountZero]]]]]
    ]]]]]]
  ]], ConfirmSucceed]

  type TypeOptions14[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] =
    TypeAdt.Aux[A, NumberCountChild[I1, NumberCountChild[I2, NumberCountChild[
      I3,
      NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[I7, NumberCountChild[I8, NumberCountChild[
        I9,
        NumberCountChild[I10, NumberCountChild[I11, NumberCountChild[I12, NumberCountChild[I13, NumberCountChild[I14, NumberCountZero]]]]]
      ]]]]]]
    ]]], ConfirmSucceed]

  type TypeOptions15[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] =
    TypeAdt.Aux[A, NumberCountChild[I1, NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[
      I4,
      NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[I7, NumberCountChild[I8, NumberCountChild[I9, NumberCountChild[
        I10,
        NumberCountChild[I11, NumberCountChild[I12, NumberCountChild[I13, NumberCountChild[I14, NumberCountChild[I15, NumberCountZero]]]]]
      ]]]]]]
    ]]]], ConfirmSucceed]

  type TypeOptions16[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] =
    TypeAdt.Aux[A, NumberCountChild[I1, NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[
      I5,
      NumberCountChild[I6, NumberCountChild[I7, NumberCountChild[I8, NumberCountChild[I9, NumberCountChild[I10, NumberCountChild[
        I11,
        NumberCountChild[I12, NumberCountChild[I13, NumberCountChild[I14, NumberCountChild[I15, NumberCountChild[I16, NumberCountZero]]]]]
      ]]]]]]
    ]]]]], ConfirmSucceed]

  type TypeOptions17[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] = TypeAdt.Aux[A, NumberCountChild[
    I1,
    NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[
      I6,
      NumberCountChild[I7, NumberCountChild[I8, NumberCountChild[I9, NumberCountChild[I10, NumberCountChild[I11, NumberCountChild[
        I12,
        NumberCountChild[I13, NumberCountChild[I14, NumberCountChild[I15, NumberCountChild[I16, NumberCountChild[I17, NumberCountZero]]]]]
      ]]]]]]
    ]]]]]
  ], ConfirmSucceed]

  type TypeOptions18[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] = TypeAdt.Aux[A, NumberCountChild[
    I1,
    NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[
      I7,
      NumberCountChild[I8, NumberCountChild[I9, NumberCountChild[I10, NumberCountChild[I11, NumberCountChild[I12, NumberCountChild[
        I13,
        NumberCountChild[I14, NumberCountChild[I15, NumberCountChild[I16, NumberCountChild[I17, NumberCountChild[I18, NumberCountZero]]]]]
      ]]]]]]
    ]]]]]]
  ], ConfirmSucceed]

  type TypeOptions19[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] =
    TypeAdt.Aux[A, NumberCountChild[I1, NumberCountChild[
      I2,
      NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[I7, NumberCountChild[
        I8,
        NumberCountChild[I9, NumberCountChild[I10, NumberCountChild[I11, NumberCountChild[I12, NumberCountChild[I13, NumberCountChild[
          I14,
          NumberCountChild[I15, NumberCountChild[I16, NumberCountChild[I17, NumberCountChild[I18, NumberCountChild[I19, NumberCountZero]]]]]
        ]]]]]]
      ]]]]]]
    ]], ConfirmSucceed]

  type TypeOptions20[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] =
    TypeAdt.Aux[A, NumberCountChild[I1, NumberCountChild[I2, NumberCountChild[
      I3,
      NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[I7, NumberCountChild[I8, NumberCountChild[
        I9,
        NumberCountChild[I10, NumberCountChild[I11, NumberCountChild[I12, NumberCountChild[I13, NumberCountChild[I14, NumberCountChild[
          I15,
          NumberCountChild[I16, NumberCountChild[I17, NumberCountChild[I18, NumberCountChild[I19, NumberCountChild[I20, NumberCountZero]]]]]
        ]]]]]]
      ]]]]]]
    ]]], ConfirmSucceed]

  type TypeOptions21[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] =
    TypeAdt.Aux[A, NumberCountChild[I1, NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[
      I4,
      NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[I7, NumberCountChild[I8, NumberCountChild[I9, NumberCountChild[
        I10,
        NumberCountChild[I11, NumberCountChild[I12, NumberCountChild[I13, NumberCountChild[I14, NumberCountChild[I15, NumberCountChild[
          I16,
          NumberCountChild[I17, NumberCountChild[I18, NumberCountChild[I19, NumberCountChild[I20, NumberCountChild[I21, NumberCountZero]]]]]
        ]]]]]]
      ]]]]]]
    ]]]], ConfirmSucceed]

  type TypeOptions22[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22] =
    TypeAdt.Aux[A, NumberCountChild[I1, NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[
      I5,
      NumberCountChild[I6, NumberCountChild[I7, NumberCountChild[I8, NumberCountChild[I9, NumberCountChild[I10, NumberCountChild[
        I11,
        NumberCountChild[I12, NumberCountChild[I13, NumberCountChild[I14, NumberCountChild[I15, NumberCountChild[I16, NumberCountChild[
          I17,
          NumberCountChild[I18, NumberCountChild[I19, NumberCountChild[I20, NumberCountChild[I21, NumberCountChild[I22, NumberCountZero]]]]]
        ]]]]]]
      ]]]]]]
    ]]]]], ConfirmSucceed]

}
