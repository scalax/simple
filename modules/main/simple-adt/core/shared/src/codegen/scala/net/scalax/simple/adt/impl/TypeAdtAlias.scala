package net.scalax.simple.adt
package impl

trait TypeAdtAlias[ConfirmResult <: AdtStatus] {

  type Options1[A, I1] = TypeAdtApply.Aux[A, AdtAlias.AdtAppend[I1, AdtAlias.AdtZero], ConfirmResult]

  type Options2[A, I1, I2] = TypeAdtApply.Aux[A, AdtAlias.AdtAppend[I1, AdtAlias.AdtAppend[I2, AdtAlias.AdtZero]], ConfirmResult]

  type Options3[A, I1, I2, I3] =
    TypeAdtApply.Aux[A, AdtAlias.AdtAppend[I1, AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[I3, AdtAlias.AdtZero]]], ConfirmResult]

  type Options4[A, I1, I2, I3, I4] = TypeAdtApply.Aux[
    A,
    AdtAlias.AdtAppend[I1, AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[I3, AdtAlias.AdtAppend[I4, AdtAlias.AdtZero]]]],
    ConfirmResult
  ]

  type Options5[A, I1, I2, I3, I4, I5] = TypeAdtApply.Aux[A, AdtAlias.AdtAppend[
    I1,
    AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[I3, AdtAlias.AdtAppend[I4, AdtAlias.AdtAppend[I5, AdtAlias.AdtZero]]]]
  ], ConfirmResult]

  type Options6[A, I1, I2, I3, I4, I5, I6] = TypeAdtApply.Aux[A, AdtAlias.AdtAppend[
    I1,
    AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[I3, AdtAlias.AdtAppend[I4, AdtAlias.AdtAppend[I5, AdtAlias.AdtAppend[I6, AdtAlias.AdtZero]]]]]
  ], ConfirmResult]

  type Options7[A, I1, I2, I3, I4, I5, I6, I7] = TypeAdtApply.Aux[A, AdtAlias.AdtAppend[I1, AdtAlias.AdtAppend[
    I2,
    AdtAlias.AdtAppend[I3, AdtAlias.AdtAppend[I4, AdtAlias.AdtAppend[I5, AdtAlias.AdtAppend[I6, AdtAlias.AdtAppend[I7, AdtAlias.AdtZero]]]]]
  ]], ConfirmResult]

  type Options8[A, I1, I2, I3, I4, I5, I6, I7, I8] = TypeAdtApply.Aux[A, AdtAlias.AdtAppend[I1, AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[
    I3,
    AdtAlias.AdtAppend[I4, AdtAlias.AdtAppend[I5, AdtAlias.AdtAppend[I6, AdtAlias.AdtAppend[I7, AdtAlias.AdtAppend[I8, AdtAlias.AdtZero]]]]]
  ]]], ConfirmResult]

  type Options9[A, I1, I2, I3, I4, I5, I6, I7, I8, I9] =
    TypeAdtApply.Aux[A, AdtAlias.AdtAppend[I1, AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[I3, AdtAlias.AdtAppend[I4, AdtAlias.AdtAppend[
      I5,
      AdtAlias.AdtAppend[I6, AdtAlias.AdtAppend[I7, AdtAlias.AdtAppend[I8, AdtAlias.AdtAppend[I9, AdtAlias.AdtZero]]]]
    ]]]]], ConfirmResult]

  type Options10[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] = TypeAdtApply.Aux[
    A,
    AdtAlias.AdtAppend[I1, AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[I3, AdtAlias.AdtAppend[I4, AdtAlias.AdtAppend[I5, AdtAlias.AdtAppend[
      I6,
      AdtAlias.AdtAppend[I7, AdtAlias.AdtAppend[I8, AdtAlias.AdtAppend[I9, AdtAlias.AdtAppend[I10, AdtAlias.AdtZero]]]]
    ]]]]]],
    ConfirmResult
  ]

  type Options11[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] = TypeAdtApply.Aux[A, AdtAlias.AdtAppend[
    I1,
    AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[I3, AdtAlias.AdtAppend[I4, AdtAlias.AdtAppend[I5, AdtAlias.AdtAppend[I6, AdtAlias.AdtAppend[
      I7,
      AdtAlias.AdtAppend[I8, AdtAlias.AdtAppend[I9, AdtAlias.AdtAppend[I10, AdtAlias.AdtAppend[I11, AdtAlias.AdtZero]]]]
    ]]]]]]
  ], ConfirmResult]

  type Options12[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] = TypeAdtApply.Aux[A, AdtAlias.AdtAppend[I1, AdtAlias.AdtAppend[
    I2,
    AdtAlias.AdtAppend[I3, AdtAlias.AdtAppend[I4, AdtAlias.AdtAppend[I5, AdtAlias.AdtAppend[I6, AdtAlias.AdtAppend[I7, AdtAlias.AdtAppend[
      I8,
      AdtAlias.AdtAppend[I9, AdtAlias.AdtAppend[I10, AdtAlias.AdtAppend[I11, AdtAlias.AdtAppend[I12, AdtAlias.AdtZero]]]]
    ]]]]]]
  ]], ConfirmResult]

  type Options13[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] =
    TypeAdtApply.Aux[A, AdtAlias.AdtAppend[I1, AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[
      I3,
      AdtAlias.AdtAppend[I4, AdtAlias.AdtAppend[I5, AdtAlias.AdtAppend[I6, AdtAlias.AdtAppend[I7, AdtAlias.AdtAppend[I8, AdtAlias.AdtAppend[
        I9,
        AdtAlias.AdtAppend[I10, AdtAlias.AdtAppend[I11, AdtAlias.AdtAppend[I12, AdtAlias.AdtAppend[I13, AdtAlias.AdtZero]]]]
      ]]]]]]
    ]]], ConfirmResult]

  type Options14[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] =
    TypeAdtApply.Aux[A, AdtAlias.AdtAppend[I1, AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[I3, AdtAlias.AdtAppend[
      I4,
      AdtAlias.AdtAppend[I5, AdtAlias.AdtAppend[I6, AdtAlias.AdtAppend[I7, AdtAlias.AdtAppend[I8, AdtAlias.AdtAppend[I9, AdtAlias.AdtAppend[
        I10,
        AdtAlias.AdtAppend[I11, AdtAlias.AdtAppend[I12, AdtAlias.AdtAppend[I13, AdtAlias.AdtAppend[I14, AdtAlias.AdtZero]]]]
      ]]]]]]
    ]]]], ConfirmResult]

  type Options15[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] = TypeAdtApply.Aux[
    A,
    AdtAlias.AdtAppend[I1, AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[I3, AdtAlias.AdtAppend[I4, AdtAlias.AdtAppend[I5, AdtAlias.AdtAppend[
      I6,
      AdtAlias.AdtAppend[I7, AdtAlias.AdtAppend[I8, AdtAlias.AdtAppend[I9, AdtAlias.AdtAppend[I10, AdtAlias.AdtAppend[
        I11,
        AdtAlias.AdtAppend[I12, AdtAlias.AdtAppend[I13, AdtAlias.AdtAppend[I14, AdtAlias.AdtAppend[I15, AdtAlias.AdtZero]]]]
      ]]]]]
    ]]]]]],
    ConfirmResult
  ]

  type Options16[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] = TypeAdtApply.Aux[A, AdtAlias.AdtAppend[
    I1,
    AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[I3, AdtAlias.AdtAppend[I4, AdtAlias.AdtAppend[I5, AdtAlias.AdtAppend[I6, AdtAlias.AdtAppend[
      I7,
      AdtAlias.AdtAppend[I8, AdtAlias.AdtAppend[I9, AdtAlias.AdtAppend[I10, AdtAlias.AdtAppend[I11, AdtAlias.AdtAppend[
        I12,
        AdtAlias.AdtAppend[I13, AdtAlias.AdtAppend[I14, AdtAlias.AdtAppend[I15, AdtAlias.AdtAppend[I16, AdtAlias.AdtZero]]]]
      ]]]]]
    ]]]]]]
  ], ConfirmResult]

  type Options17[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] =
    TypeAdtApply.Aux[A, AdtAlias.AdtAppend[I1, AdtAlias.AdtAppend[
      I2,
      AdtAlias.AdtAppend[I3, AdtAlias.AdtAppend[I4, AdtAlias.AdtAppend[I5, AdtAlias.AdtAppend[I6, AdtAlias.AdtAppend[I7, AdtAlias.AdtAppend[
        I8,
        AdtAlias.AdtAppend[I9, AdtAlias.AdtAppend[I10, AdtAlias.AdtAppend[I11, AdtAlias.AdtAppend[I12, AdtAlias.AdtAppend[
          I13,
          AdtAlias.AdtAppend[I14, AdtAlias.AdtAppend[I15, AdtAlias.AdtAppend[I16, AdtAlias.AdtAppend[I17, AdtAlias.AdtZero]]]]
        ]]]]]
      ]]]]]]
    ]], ConfirmResult]

  type Options18[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] =
    TypeAdtApply.Aux[A, AdtAlias.AdtAppend[I1, AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[
      I3,
      AdtAlias.AdtAppend[I4, AdtAlias.AdtAppend[I5, AdtAlias.AdtAppend[I6, AdtAlias.AdtAppend[I7, AdtAlias.AdtAppend[I8, AdtAlias.AdtAppend[
        I9,
        AdtAlias.AdtAppend[I10, AdtAlias.AdtAppend[I11, AdtAlias.AdtAppend[I12, AdtAlias.AdtAppend[I13, AdtAlias.AdtAppend[
          I14,
          AdtAlias.AdtAppend[I15, AdtAlias.AdtAppend[I16, AdtAlias.AdtAppend[I17, AdtAlias.AdtAppend[I18, AdtAlias.AdtZero]]]]
        ]]]]]
      ]]]]]]
    ]]], ConfirmResult]

  type Options19[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] =
    TypeAdtApply.Aux[A, AdtAlias.AdtAppend[I1, AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[I3, AdtAlias.AdtAppend[
      I4,
      AdtAlias.AdtAppend[I5, AdtAlias.AdtAppend[I6, AdtAlias.AdtAppend[I7, AdtAlias.AdtAppend[I8, AdtAlias.AdtAppend[I9, AdtAlias.AdtAppend[
        I10,
        AdtAlias.AdtAppend[I11, AdtAlias.AdtAppend[I12, AdtAlias.AdtAppend[I13, AdtAlias.AdtAppend[I14, AdtAlias.AdtAppend[
          I15,
          AdtAlias.AdtAppend[I16, AdtAlias.AdtAppend[I17, AdtAlias.AdtAppend[I18, AdtAlias.AdtAppend[I19, AdtAlias.AdtZero]]]]
        ]]]]]
      ]]]]]]
    ]]]], ConfirmResult]

  type Options20[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] = TypeAdtApply.Aux[
    A,
    AdtAlias.AdtAppend[I1, AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[I3, AdtAlias.AdtAppend[I4, AdtAlias.AdtAppend[I5, AdtAlias.AdtAppend[
      I6,
      AdtAlias.AdtAppend[I7, AdtAlias.AdtAppend[I8, AdtAlias.AdtAppend[I9, AdtAlias.AdtAppend[I10, AdtAlias.AdtAppend[
        I11,
        AdtAlias.AdtAppend[I12, AdtAlias.AdtAppend[I13, AdtAlias.AdtAppend[I14, AdtAlias.AdtAppend[I15, AdtAlias.AdtAppend[
          I16,
          AdtAlias.AdtAppend[I17, AdtAlias.AdtAppend[I18, AdtAlias.AdtAppend[I19, AdtAlias.AdtAppend[I20, AdtAlias.AdtZero]]]]
        ]]]]]
      ]]]]]
    ]]]]]],
    ConfirmResult
  ]

  type Options21[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] =
    TypeAdtApply.Aux[A, AdtAlias.AdtAppend[
      I1,
      AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[I3, AdtAlias.AdtAppend[I4, AdtAlias.AdtAppend[I5, AdtAlias.AdtAppend[I6, AdtAlias.AdtAppend[
        I7,
        AdtAlias.AdtAppend[I8, AdtAlias.AdtAppend[I9, AdtAlias.AdtAppend[I10, AdtAlias.AdtAppend[I11, AdtAlias.AdtAppend[
          I12,
          AdtAlias.AdtAppend[I13, AdtAlias.AdtAppend[I14, AdtAlias.AdtAppend[I15, AdtAlias.AdtAppend[I16, AdtAlias.AdtAppend[
            I17,
            AdtAlias.AdtAppend[I18, AdtAlias.AdtAppend[I19, AdtAlias.AdtAppend[I20, AdtAlias.AdtAppend[I21, AdtAlias.AdtZero]]]]
          ]]]]]
        ]]]]]
      ]]]]]]
    ], ConfirmResult]

  type Options22[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22] =
    TypeAdtApply.Aux[A, AdtAlias.AdtAppend[I1, AdtAlias.AdtAppend[
      I2,
      AdtAlias.AdtAppend[I3, AdtAlias.AdtAppend[I4, AdtAlias.AdtAppend[I5, AdtAlias.AdtAppend[I6, AdtAlias.AdtAppend[I7, AdtAlias.AdtAppend[
        I8,
        AdtAlias.AdtAppend[I9, AdtAlias.AdtAppend[I10, AdtAlias.AdtAppend[I11, AdtAlias.AdtAppend[I12, AdtAlias.AdtAppend[
          I13,
          AdtAlias.AdtAppend[I14, AdtAlias.AdtAppend[I15, AdtAlias.AdtAppend[I16, AdtAlias.AdtAppend[I17, AdtAlias.AdtAppend[
            I18,
            AdtAlias.AdtAppend[I19, AdtAlias.AdtAppend[I20, AdtAlias.AdtAppend[I21, AdtAlias.AdtAppend[I22, AdtAlias.AdtZero]]]]
          ]]]]]
        ]]]]]
      ]]]]]]
    ]], ConfirmResult]

}
