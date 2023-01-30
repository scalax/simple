package net.scalax.simple.adt
package impl

trait TypeAdtAlias {

  type Options1[A, I1] = TypeAdtApply.Aux[A, NumberCountChild[I1, NumberCountZero], ConfirmSucceed]

  type Options2[A, I1, I2] = TypeAdtApply.Aux[A, NumberCountChild[I1, NumberCountChild[I2, NumberCountZero]], ConfirmSucceed]

  type Options3[A, I1, I2, I3] =
    TypeAdtApply.Aux[A, NumberCountChild[I1, NumberCountChild[I2, NumberCountChild[I3, NumberCountZero]]], ConfirmSucceed]

  type Options4[A, I1, I2, I3, I4] = TypeAdtApply.Aux[A, NumberCountChild[
    I1,
    NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[I4, NumberCountZero]]]
  ], ConfirmSucceed]

  type Options5[A, I1, I2, I3, I4, I5] = TypeAdtApply.Aux[A, NumberCountChild[
    I1,
    NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[I5, NumberCountZero]]]]
  ], ConfirmSucceed]

  type Options6[A, I1, I2, I3, I4, I5, I6] = TypeAdtApply.Aux[A, NumberCountChild[
    I1,
    NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[I6, NumberCountZero]]]]]
  ], ConfirmSucceed]

  type Options7[A, I1, I2, I3, I4, I5, I6, I7] = TypeAdtApply.Aux[A, NumberCountChild[I1, NumberCountChild[
    I2,
    NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[I7, NumberCountZero]]]]]
  ]], ConfirmSucceed]

  type Options8[A, I1, I2, I3, I4, I5, I6, I7, I8] = TypeAdtApply.Aux[A, NumberCountChild[I1, NumberCountChild[I2, NumberCountChild[
    I3,
    NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[I7, NumberCountChild[I8, NumberCountZero]]]]]
  ]]], ConfirmSucceed]

  type Options9[A, I1, I2, I3, I4, I5, I6, I7, I8, I9] =
    TypeAdtApply.Aux[A, NumberCountChild[I1, NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[
      I4,
      NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[I7, NumberCountChild[I8, NumberCountChild[I9, NumberCountZero]]]]]
    ]]]], ConfirmSucceed]

  type Options10[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] =
    TypeAdtApply.Aux[A, NumberCountChild[I1, NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[
      I5,
      NumberCountChild[I6, NumberCountChild[I7, NumberCountChild[I8, NumberCountChild[I9, NumberCountChild[I10, NumberCountZero]]]]]
    ]]]]], ConfirmSucceed]

  type Options11[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] = TypeAdtApply.Aux[A, NumberCountChild[
    I1,
    NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[
      I6,
      NumberCountChild[I7, NumberCountChild[I8, NumberCountChild[I9, NumberCountChild[I10, NumberCountChild[I11, NumberCountZero]]]]]
    ]]]]]
  ], ConfirmSucceed]

  type Options12[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] = TypeAdtApply.Aux[A, NumberCountChild[
    I1,
    NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[
      I7,
      NumberCountChild[I8, NumberCountChild[I9, NumberCountChild[I10, NumberCountChild[I11, NumberCountChild[I12, NumberCountZero]]]]]
    ]]]]]]
  ], ConfirmSucceed]

  type Options13[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] = TypeAdtApply.Aux[A, NumberCountChild[I1, NumberCountChild[
    I2,
    NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[I7, NumberCountChild[
      I8,
      NumberCountChild[I9, NumberCountChild[I10, NumberCountChild[I11, NumberCountChild[I12, NumberCountChild[I13, NumberCountZero]]]]]
    ]]]]]]
  ]], ConfirmSucceed]

  type Options14[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] =
    TypeAdtApply.Aux[A, NumberCountChild[I1, NumberCountChild[I2, NumberCountChild[
      I3,
      NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[I7, NumberCountChild[I8, NumberCountChild[
        I9,
        NumberCountChild[I10, NumberCountChild[I11, NumberCountChild[I12, NumberCountChild[I13, NumberCountChild[I14, NumberCountZero]]]]]
      ]]]]]]
    ]]], ConfirmSucceed]

  type Options15[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] =
    TypeAdtApply.Aux[A, NumberCountChild[I1, NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[
      I4,
      NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[I7, NumberCountChild[I8, NumberCountChild[I9, NumberCountChild[
        I10,
        NumberCountChild[I11, NumberCountChild[I12, NumberCountChild[I13, NumberCountChild[I14, NumberCountChild[I15, NumberCountZero]]]]]
      ]]]]]]
    ]]]], ConfirmSucceed]

  type Options16[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] =
    TypeAdtApply.Aux[A, NumberCountChild[I1, NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[
      I5,
      NumberCountChild[I6, NumberCountChild[I7, NumberCountChild[I8, NumberCountChild[I9, NumberCountChild[I10, NumberCountChild[
        I11,
        NumberCountChild[I12, NumberCountChild[I13, NumberCountChild[I14, NumberCountChild[I15, NumberCountChild[I16, NumberCountZero]]]]]
      ]]]]]]
    ]]]]], ConfirmSucceed]

  type Options17[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] = TypeAdtApply.Aux[A, NumberCountChild[
    I1,
    NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[
      I6,
      NumberCountChild[I7, NumberCountChild[I8, NumberCountChild[I9, NumberCountChild[I10, NumberCountChild[I11, NumberCountChild[
        I12,
        NumberCountChild[I13, NumberCountChild[I14, NumberCountChild[I15, NumberCountChild[I16, NumberCountChild[I17, NumberCountZero]]]]]
      ]]]]]]
    ]]]]]
  ], ConfirmSucceed]

  type Options18[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] = TypeAdtApply.Aux[A, NumberCountChild[
    I1,
    NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[
      I7,
      NumberCountChild[I8, NumberCountChild[I9, NumberCountChild[I10, NumberCountChild[I11, NumberCountChild[I12, NumberCountChild[
        I13,
        NumberCountChild[I14, NumberCountChild[I15, NumberCountChild[I16, NumberCountChild[I17, NumberCountChild[I18, NumberCountZero]]]]]
      ]]]]]]
    ]]]]]]
  ], ConfirmSucceed]

  type Options19[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] =
    TypeAdtApply.Aux[A, NumberCountChild[I1, NumberCountChild[
      I2,
      NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[I7, NumberCountChild[
        I8,
        NumberCountChild[I9, NumberCountChild[I10, NumberCountChild[I11, NumberCountChild[I12, NumberCountChild[I13, NumberCountChild[
          I14,
          NumberCountChild[I15, NumberCountChild[I16, NumberCountChild[I17, NumberCountChild[I18, NumberCountChild[I19, NumberCountZero]]]]]
        ]]]]]]
      ]]]]]]
    ]], ConfirmSucceed]

  type Options20[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] =
    TypeAdtApply.Aux[A, NumberCountChild[I1, NumberCountChild[I2, NumberCountChild[
      I3,
      NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[I7, NumberCountChild[I8, NumberCountChild[
        I9,
        NumberCountChild[I10, NumberCountChild[I11, NumberCountChild[I12, NumberCountChild[I13, NumberCountChild[I14, NumberCountChild[
          I15,
          NumberCountChild[I16, NumberCountChild[I17, NumberCountChild[I18, NumberCountChild[I19, NumberCountChild[I20, NumberCountZero]]]]]
        ]]]]]]
      ]]]]]]
    ]]], ConfirmSucceed]

  type Options21[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] =
    TypeAdtApply.Aux[A, NumberCountChild[I1, NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[
      I4,
      NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[I7, NumberCountChild[I8, NumberCountChild[I9, NumberCountChild[
        I10,
        NumberCountChild[I11, NumberCountChild[I12, NumberCountChild[I13, NumberCountChild[I14, NumberCountChild[I15, NumberCountChild[
          I16,
          NumberCountChild[I17, NumberCountChild[I18, NumberCountChild[I19, NumberCountChild[I20, NumberCountChild[I21, NumberCountZero]]]]]
        ]]]]]]
      ]]]]]]
    ]]]], ConfirmSucceed]

  type Options22[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22] =
    TypeAdtApply.Aux[A, NumberCountChild[I1, NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[
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
