package net.scalax.simple.adt
package impl

trait TypeAdtRuntimeApply[Poly] {

  def Options1[I1]: InnerTypeAdtClass.PrepareInnerApply1[I1, Poly] =
    InnerTypeAdtClass.HelperIOImpl1.asInstanceOf[InnerTypeAdtClass.PrepareInnerApply1[I1, Poly]]

  def Options2[I1, I2]: InnerTypeAdtClass.PrepareInnerApply2[I1, I2, Poly] =
    InnerTypeAdtClass.HelperIOImpl2.asInstanceOf[InnerTypeAdtClass.PrepareInnerApply2[I1, I2, Poly]]

  def Options3[I1, I2, I3]: InnerTypeAdtClass.PrepareInnerApply3[I1, I2, I3, Poly] =
    InnerTypeAdtClass.HelperIOImpl3.asInstanceOf[InnerTypeAdtClass.PrepareInnerApply3[I1, I2, I3, Poly]]

  def Options4[I1, I2, I3, I4]: InnerTypeAdtClass.PrepareInnerApply4[I1, I2, I3, I4, Poly] =
    InnerTypeAdtClass.HelperIOImpl4.asInstanceOf[InnerTypeAdtClass.PrepareInnerApply4[I1, I2, I3, I4, Poly]]

  def Options5[I1, I2, I3, I4, I5]: InnerTypeAdtClass.PrepareInnerApply5[I1, I2, I3, I4, I5, Poly] =
    InnerTypeAdtClass.HelperIOImpl5.asInstanceOf[InnerTypeAdtClass.PrepareInnerApply5[I1, I2, I3, I4, I5, Poly]]

  def Options6[I1, I2, I3, I4, I5, I6]: InnerTypeAdtClass.PrepareInnerApply6[I1, I2, I3, I4, I5, I6, Poly] =
    InnerTypeAdtClass.HelperIOImpl6.asInstanceOf[InnerTypeAdtClass.PrepareInnerApply6[I1, I2, I3, I4, I5, I6, Poly]]

  def Options7[I1, I2, I3, I4, I5, I6, I7]: InnerTypeAdtClass.PrepareInnerApply7[I1, I2, I3, I4, I5, I6, I7, Poly] =
    InnerTypeAdtClass.HelperIOImpl7.asInstanceOf[InnerTypeAdtClass.PrepareInnerApply7[I1, I2, I3, I4, I5, I6, I7, Poly]]

  def Options8[I1, I2, I3, I4, I5, I6, I7, I8]: InnerTypeAdtClass.PrepareInnerApply8[I1, I2, I3, I4, I5, I6, I7, I8, Poly] =
    InnerTypeAdtClass.HelperIOImpl8.asInstanceOf[InnerTypeAdtClass.PrepareInnerApply8[I1, I2, I3, I4, I5, I6, I7, I8, Poly]]

  def Options9[I1, I2, I3, I4, I5, I6, I7, I8, I9]: InnerTypeAdtClass.PrepareInnerApply9[I1, I2, I3, I4, I5, I6, I7, I8, I9, Poly] =
    InnerTypeAdtClass.HelperIOImpl9.asInstanceOf[InnerTypeAdtClass.PrepareInnerApply9[I1, I2, I3, I4, I5, I6, I7, I8, I9, Poly]]

  def Options10[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10]
    : InnerTypeAdtClass.PrepareInnerApply10[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, Poly] =
    InnerTypeAdtClass.HelperIOImpl10.asInstanceOf[InnerTypeAdtClass.PrepareInnerApply10[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, Poly]]

  def Options11[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11]
    : InnerTypeAdtClass.PrepareInnerApply11[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, Poly] =
    InnerTypeAdtClass.HelperIOImpl11.asInstanceOf[InnerTypeAdtClass.PrepareInnerApply11[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, Poly]]

  def Options12[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12]
    : InnerTypeAdtClass.PrepareInnerApply12[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, Poly] =
    InnerTypeAdtClass.HelperIOImpl12
      .asInstanceOf[InnerTypeAdtClass.PrepareInnerApply12[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, Poly]]

  def Options13[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13]
    : InnerTypeAdtClass.PrepareInnerApply13[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, Poly] =
    InnerTypeAdtClass.HelperIOImpl13
      .asInstanceOf[InnerTypeAdtClass.PrepareInnerApply13[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, Poly]]

  def Options14[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14]
    : InnerTypeAdtClass.PrepareInnerApply14[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, Poly] =
    InnerTypeAdtClass.HelperIOImpl14
      .asInstanceOf[InnerTypeAdtClass.PrepareInnerApply14[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, Poly]]

  def Options15[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15]
    : InnerTypeAdtClass.PrepareInnerApply15[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, Poly] =
    InnerTypeAdtClass.HelperIOImpl15
      .asInstanceOf[InnerTypeAdtClass.PrepareInnerApply15[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, Poly]]

  def Options16[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16]
    : InnerTypeAdtClass.PrepareInnerApply16[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, Poly] =
    InnerTypeAdtClass.HelperIOImpl16
      .asInstanceOf[InnerTypeAdtClass.PrepareInnerApply16[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, Poly]]

  def Options17[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17]
    : InnerTypeAdtClass.PrepareInnerApply17[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, Poly] =
    InnerTypeAdtClass.HelperIOImpl17
      .asInstanceOf[InnerTypeAdtClass.PrepareInnerApply17[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, Poly]]

  def Options18[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18]
    : InnerTypeAdtClass.PrepareInnerApply18[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, Poly] =
    InnerTypeAdtClass.HelperIOImpl18.asInstanceOf[
      InnerTypeAdtClass.PrepareInnerApply18[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, Poly]
    ]

  def Options19[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19]
    : InnerTypeAdtClass.PrepareInnerApply19[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, Poly] =
    InnerTypeAdtClass.HelperIOImpl19.asInstanceOf[
      InnerTypeAdtClass.PrepareInnerApply19[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, Poly]
    ]

  def Options20[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20]
    : InnerTypeAdtClass.PrepareInnerApply20[
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
      Poly
    ] =
    InnerTypeAdtClass.HelperIOImpl20.asInstanceOf[
      InnerTypeAdtClass.PrepareInnerApply20[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, Poly]
    ]

  def Options21[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21]
    : InnerTypeAdtClass.PrepareInnerApply21[
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
      Poly
    ] =
    InnerTypeAdtClass.HelperIOImpl21.asInstanceOf[InnerTypeAdtClass.PrepareInnerApply21[
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
      Poly
    ]]

  def Options22[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22]
    : InnerTypeAdtClass.PrepareInnerApply22[
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
      I22,
      Poly
    ] =
    InnerTypeAdtClass.HelperIOImpl22.asInstanceOf[InnerTypeAdtClass.PrepareInnerApply22[
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
      I22,
      Poly
    ]]

}
