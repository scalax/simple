package net.scalax.simple.nat.adt
package impl

import shapeless._

trait HelperIOImplicit {
  import InnerTypeAdtClass._

  @inline implicit def helperIOImplicit2[A, I1, I2]: HelperIO.Aux[I1 :: I2 :: HNil, CusInnerApply2[I1, I2]] =
    HelperIOImpl2.asInstanceOf[HelperIO.Aux[I1 :: I2 :: HNil, CusInnerApply2[I1, I2]]]

  @inline implicit def helperIOImplicit3[A, I1, I2, I3]: HelperIO.Aux[I1 :: I2 :: I3 :: HNil, CusInnerApply3[I1, I2, I3]] =
    HelperIOImpl3.asInstanceOf[HelperIO.Aux[I1 :: I2 :: I3 :: HNil, CusInnerApply3[I1, I2, I3]]]

  @inline implicit def helperIOImplicit4[A, I1, I2, I3, I4]: HelperIO.Aux[I1 :: I2 :: I3 :: I4 :: HNil, CusInnerApply4[I1, I2, I3, I4]] =
    HelperIOImpl4.asInstanceOf[HelperIO.Aux[I1 :: I2 :: I3 :: I4 :: HNil, CusInnerApply4[I1, I2, I3, I4]]]

  @inline implicit def helperIOImplicit5[A, I1, I2, I3, I4, I5]
    : HelperIO.Aux[I1 :: I2 :: I3 :: I4 :: I5 :: HNil, CusInnerApply5[I1, I2, I3, I4, I5]] =
    HelperIOImpl5.asInstanceOf[HelperIO.Aux[I1 :: I2 :: I3 :: I4 :: I5 :: HNil, CusInnerApply5[I1, I2, I3, I4, I5]]]

  @inline implicit def helperIOImplicit6[A, I1, I2, I3, I4, I5, I6]
    : HelperIO.Aux[I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: HNil, CusInnerApply6[I1, I2, I3, I4, I5, I6]] =
    HelperIOImpl6.asInstanceOf[HelperIO.Aux[I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: HNil, CusInnerApply6[I1, I2, I3, I4, I5, I6]]]

  @inline implicit def helperIOImplicit7[A, I1, I2, I3, I4, I5, I6, I7]
    : HelperIO.Aux[I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: HNil, CusInnerApply7[I1, I2, I3, I4, I5, I6, I7]] =
    HelperIOImpl7.asInstanceOf[HelperIO.Aux[I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: HNil, CusInnerApply7[I1, I2, I3, I4, I5, I6, I7]]]

  @inline implicit def helperIOImplicit8[A, I1, I2, I3, I4, I5, I6, I7, I8]
    : HelperIO.Aux[I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: HNil, CusInnerApply8[I1, I2, I3, I4, I5, I6, I7, I8]] = HelperIOImpl8
    .asInstanceOf[HelperIO.Aux[I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: HNil, CusInnerApply8[I1, I2, I3, I4, I5, I6, I7, I8]]]

  @inline implicit def helperIOImplicit9[A, I1, I2, I3, I4, I5, I6, I7, I8, I9]
    : HelperIO.Aux[I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: HNil, CusInnerApply9[I1, I2, I3, I4, I5, I6, I7, I8, I9]] =
    HelperIOImpl9.asInstanceOf[
      HelperIO.Aux[I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: HNil, CusInnerApply9[I1, I2, I3, I4, I5, I6, I7, I8, I9]]
    ]

  @inline implicit def helperIOImplicit10[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10]: HelperIO.Aux[
    I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: HNil,
    CusInnerApply10[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10]
  ] = HelperIOImpl10.asInstanceOf[HelperIO.Aux[
    I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: HNil,
    CusInnerApply10[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10]
  ]]

  @inline implicit def helperIOImplicit11[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11]: HelperIO.Aux[
    I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: HNil,
    CusInnerApply11[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11]
  ] = HelperIOImpl11.asInstanceOf[HelperIO.Aux[
    I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: HNil,
    CusInnerApply11[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11]
  ]]

  @inline implicit def helperIOImplicit12[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12]: HelperIO.Aux[
    I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: HNil,
    CusInnerApply12[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12]
  ] = HelperIOImpl12.asInstanceOf[HelperIO.Aux[
    I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: HNil,
    CusInnerApply12[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12]
  ]]

  @inline implicit def helperIOImplicit13[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13]: HelperIO.Aux[
    I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: HNil,
    CusInnerApply13[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13]
  ] = HelperIOImpl13.asInstanceOf[HelperIO.Aux[
    I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: HNil,
    CusInnerApply13[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13]
  ]]

  @inline implicit def helperIOImplicit14[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14]: HelperIO.Aux[
    I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: HNil,
    CusInnerApply14[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14]
  ] = HelperIOImpl14.asInstanceOf[HelperIO.Aux[
    I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: HNil,
    CusInnerApply14[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14]
  ]]

  @inline implicit def helperIOImplicit15[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15]: HelperIO.Aux[
    I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: HNil,
    CusInnerApply15[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15]
  ] = HelperIOImpl15.asInstanceOf[HelperIO.Aux[
    I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: HNil,
    CusInnerApply15[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15]
  ]]

  @inline implicit def helperIOImplicit16[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16]: HelperIO.Aux[
    I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: I16 :: HNil,
    CusInnerApply16[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16]
  ] = HelperIOImpl16.asInstanceOf[HelperIO.Aux[
    I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: I16 :: HNil,
    CusInnerApply16[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16]
  ]]

  @inline implicit def helperIOImplicit17[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17]: HelperIO.Aux[
    I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: I16 :: I17 :: HNil,
    CusInnerApply17[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17]
  ] = HelperIOImpl17.asInstanceOf[HelperIO.Aux[
    I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: I16 :: I17 :: HNil,
    CusInnerApply17[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17]
  ]]

  @inline implicit def helperIOImplicit18[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18]: HelperIO.Aux[
    I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: I16 :: I17 :: I18 :: HNil,
    CusInnerApply18[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18]
  ] = HelperIOImpl18.asInstanceOf[HelperIO.Aux[
    I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: I16 :: I17 :: I18 :: HNil,
    CusInnerApply18[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18]
  ]]

  @inline implicit def helperIOImplicit19[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19]
    : HelperIO.Aux[
      I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: I16 :: I17 :: I18 :: I19 :: HNil,
      CusInnerApply19[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19]
    ] = HelperIOImpl19.asInstanceOf[HelperIO.Aux[
    I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: I16 :: I17 :: I18 :: I19 :: HNil,
    CusInnerApply19[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19]
  ]]

  @inline implicit def helperIOImplicit20[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20]
    : HelperIO.Aux[
      I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: I16 :: I17 :: I18 :: I19 :: I20 ::
        HNil,
      CusInnerApply20[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20]
    ] = HelperIOImpl20.asInstanceOf[HelperIO.Aux[
    I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: I16 :: I17 :: I18 :: I19 :: I20 :: HNil,
    CusInnerApply20[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20]
  ]]

  @inline implicit def helperIOImplicit21[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21]
    : HelperIO.Aux[
      I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: I16 :: I17 :: I18 :: I19 :: I20 ::
        I21 :: HNil,
      CusInnerApply21[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21]
    ] = HelperIOImpl21.asInstanceOf[HelperIO.Aux[
    I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: I16 :: I17 :: I18 :: I19 :: I20 ::
      I21 :: HNil,
    CusInnerApply21[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21]
  ]]

  @inline implicit def helperIOImplicit22[
    A,
    I1,
    I2,
    I3,
    I4,
    I5,
    I6,
    I7,
    I8,
    I9,
    I10,
    I11,
    I12,
    I13,
    I14,
    I15,
    I16,
    I17,
    I18,
    I19,
    I20,
    I21,
    I22
  ]: HelperIO.Aux[
    I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: I16 :: I17 :: I18 :: I19 :: I20 ::
      I21 :: I22 :: HNil,
    CusInnerApply22[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22]
  ] = HelperIOImpl22.asInstanceOf[HelperIO.Aux[
    I1 :: I2 :: I3 :: I4 :: I5 :: I6 :: I7 :: I8 :: I9 :: I10 :: I11 :: I12 :: I13 :: I14 :: I15 :: I16 :: I17 :: I18 :: I19 :: I20 ::
      I21 :: I22 :: HNil,
    CusInnerApply22[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22]
  ]]

}
