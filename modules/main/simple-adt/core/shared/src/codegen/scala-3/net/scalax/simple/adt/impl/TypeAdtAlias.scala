package net.scalax.simple.adt
package impl

trait TypeAdtAlias {

  type Options1[A, I1] = TypeAdtApply.Aux[A, Tuple1[I1], ConfirmSucceed]

  type Options2[A, I1, I2] = TypeAdtApply.Aux[A, Tuple2[I1, I2], ConfirmSucceed]

  type Options3[A, I1, I2, I3] = TypeAdtApply.Aux[A, Tuple3[I1, I2, I3], ConfirmSucceed]

  type Options4[A, I1, I2, I3, I4] = TypeAdtApply.Aux[A, Tuple4[I1, I2, I3, I4], ConfirmSucceed]

  type Options5[A, I1, I2, I3, I4, I5] = TypeAdtApply.Aux[A, Tuple5[I1, I2, I3, I4, I5], ConfirmSucceed]

  type Options6[A, I1, I2, I3, I4, I5, I6] = TypeAdtApply.Aux[A, Tuple6[I1, I2, I3, I4, I5, I6], ConfirmSucceed]

  type Options7[A, I1, I2, I3, I4, I5, I6, I7] = TypeAdtApply.Aux[A, Tuple7[I1, I2, I3, I4, I5, I6, I7], ConfirmSucceed]

  type Options8[A, I1, I2, I3, I4, I5, I6, I7, I8] = TypeAdtApply.Aux[A, Tuple8[I1, I2, I3, I4, I5, I6, I7, I8], ConfirmSucceed]

  type Options9[A, I1, I2, I3, I4, I5, I6, I7, I8, I9] = TypeAdtApply.Aux[A, Tuple9[I1, I2, I3, I4, I5, I6, I7, I8, I9], ConfirmSucceed]

  type Options10[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] =
    TypeAdtApply.Aux[A, Tuple10[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10], ConfirmSucceed]

  type Options11[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] =
    TypeAdtApply.Aux[A, Tuple11[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11], ConfirmSucceed]

  type Options12[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] =
    TypeAdtApply.Aux[A, Tuple12[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12], ConfirmSucceed]

  type Options13[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] =
    TypeAdtApply.Aux[A, Tuple13[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13], ConfirmSucceed]

  type Options14[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] =
    TypeAdtApply.Aux[A, Tuple14[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14], ConfirmSucceed]

  type Options15[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] =
    TypeAdtApply.Aux[A, Tuple15[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15], ConfirmSucceed]

  type Options16[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] =
    TypeAdtApply.Aux[A, Tuple16[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16], ConfirmSucceed]

  type Options17[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] =
    TypeAdtApply.Aux[A, Tuple17[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17], ConfirmSucceed]

  type Options18[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] =
    TypeAdtApply.Aux[A, Tuple18[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18], ConfirmSucceed]

  type Options19[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] =
    TypeAdtApply.Aux[A, Tuple19[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19], ConfirmSucceed]

  type Options20[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] =
    TypeAdtApply.Aux[A, Tuple20[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20], ConfirmSucceed]

  type Options21[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] = TypeAdtApply.Aux[
    A,
    Tuple21[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21],
    ConfirmSucceed
  ]

  type Options22[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22] = TypeAdtApply.Aux[
    A,
    Tuple22[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22],
    ConfirmSucceed
  ]

}

trait TypeAdtRuntimeApply {

  def Options1[I1]: FetchAdtApply[Tuple1[I1]] = FetchAdtApply.get

  def Options2[I1, I2]: FetchAdtApply[Tuple2[I1, I2]] = FetchAdtApply.get

  def Options3[I1, I2, I3]: FetchAdtApply[Tuple3[I1, I2, I3]] = FetchAdtApply.get

  def Options4[I1, I2, I3, I4]: FetchAdtApply[Tuple4[I1, I2, I3, I4]] = FetchAdtApply.get

  def Options5[I1, I2, I3, I4, I5]: FetchAdtApply[Tuple5[I1, I2, I3, I4, I5]] = FetchAdtApply.get

  def Options6[I1, I2, I3, I4, I5, I6]: FetchAdtApply[Tuple6[I1, I2, I3, I4, I5, I6]] = FetchAdtApply.get

  def Options7[I1, I2, I3, I4, I5, I6, I7]: FetchAdtApply[Tuple7[I1, I2, I3, I4, I5, I6, I7]] = FetchAdtApply.get

  def Options8[I1, I2, I3, I4, I5, I6, I7, I8]: FetchAdtApply[Tuple8[I1, I2, I3, I4, I5, I6, I7, I8]] = FetchAdtApply.get

  def Options9[I1, I2, I3, I4, I5, I6, I7, I8, I9]: FetchAdtApply[Tuple9[I1, I2, I3, I4, I5, I6, I7, I8, I9]] = FetchAdtApply.get

  def Options10[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10]: FetchAdtApply[Tuple10[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10]] =
    FetchAdtApply.get

  def Options11[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11]: FetchAdtApply[Tuple11[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11]] =
    FetchAdtApply.get

  def Options12[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12]
    : FetchAdtApply[Tuple12[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12]] = FetchAdtApply.get

  def Options13[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13]
    : FetchAdtApply[Tuple13[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13]] = FetchAdtApply.get

  def Options14[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14]
    : FetchAdtApply[Tuple14[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14]] = FetchAdtApply.get

  def Options15[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15]
    : FetchAdtApply[Tuple15[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15]] = FetchAdtApply.get

  def Options16[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16]
    : FetchAdtApply[Tuple16[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16]] = FetchAdtApply.get

  def Options17[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17]
    : FetchAdtApply[Tuple17[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17]] = FetchAdtApply.get

  def Options18[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18]
    : FetchAdtApply[Tuple18[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18]] = FetchAdtApply.get

  def Options19[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19]
    : FetchAdtApply[Tuple19[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19]] = FetchAdtApply.get

  def Options20[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20]
    : FetchAdtApply[Tuple20[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20]] = FetchAdtApply.get

  def Options21[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21]
    : FetchAdtApply[Tuple21[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21]] =
    FetchAdtApply.get

  def Options22[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22]
    : FetchAdtApply[Tuple22[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22]] =
    FetchAdtApply.get

}
