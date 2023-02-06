package net.scalax.simple.adt
package impl

import CoreInstance._

object InnerTypeAdtClass {

  class PrepareInnerApply1[I1, Poly] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, NumberCountChild[I1, NumberCountZero], ConfirmSucceed, Poly]
    ): CusInnerApply1[I1] = new CusInnerApply1(adtList = v.value, data = data)
  }
  object HelperIOImpl1 extends PrepareInnerApply1[Any, Any]
  class CusInnerApply1[I1](adtList: Core2, data: Any) {
    @inline def fold[T](func1: I1 => T): T = {
      val result =
        adtList(() => FoldListAppender.append(data, func1.asInstanceOf[Any => Any], () => FoldListZero)).asInstanceOf[AdtConvertWrapper]
      result.result.asInstanceOf[TypeAdtGetter].runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply2[I1, I2, Poly] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, NumberCountChild[I1, NumberCountChild[I2, NumberCountZero]], ConfirmSucceed, Poly]
    ): CusInnerApply2[I1, I2] = new CusInnerApply2(adtList = v.value, data = data)
  }
  object HelperIOImpl2 extends PrepareInnerApply2[Any, Any, Any]
  class CusInnerApply2[I1, I2](adtList: Core2, data: Any) {
    @inline def fold[T](func1: I1 => T, func2: I2 => T): T = {
      val result = adtList(() =>
        FoldListAppender.append(
          data,
          func1.asInstanceOf[Any => Any],
          () => FoldListAppender.append(data, func2.asInstanceOf[Any => Any], () => FoldListZero)
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.asInstanceOf[TypeAdtGetter].runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply3[I1, I2, I3, Poly] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, NumberCountChild[
        I1,
        NumberCountChild[I2, NumberCountChild[I3, NumberCountZero]]
      ], ConfirmSucceed, Poly]
    ): CusInnerApply3[I1, I2, I3] = new CusInnerApply3(adtList = v.value, data = data)
  }
  object HelperIOImpl3 extends PrepareInnerApply3[Any, Any, Any, Any]
  class CusInnerApply3[I1, I2, I3](adtList: Core2, data: Any) {
    @inline def fold[T](func1: I1 => T, func2: I2 => T, func3: I3 => T): T = {
      val result = adtList(() =>
        FoldListAppender.append(
          data,
          func1.asInstanceOf[Any => Any],
          () =>
            FoldListAppender.append(
              data,
              func2.asInstanceOf[Any => Any],
              () => FoldListAppender.append(data, func3.asInstanceOf[Any => Any], () => FoldListZero)
            )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.asInstanceOf[TypeAdtGetter].runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply4[I1, I2, I3, I4, Poly] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, NumberCountChild[
        I1,
        NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[I4, NumberCountZero]]]
      ], ConfirmSucceed, Poly]
    ): CusInnerApply4[I1, I2, I3, I4] = new CusInnerApply4(adtList = v.value, data = data)
  }
  object HelperIOImpl4 extends PrepareInnerApply4[Any, Any, Any, Any, Any]
  class CusInnerApply4[I1, I2, I3, I4](adtList: Core2, data: Any) {
    @inline def fold[T](func1: I1 => T, func2: I2 => T, func3: I3 => T, func4: I4 => T): T = {
      val result = adtList(() =>
        FoldListAppender.append(
          data,
          func1.asInstanceOf[Any => Any],
          () =>
            FoldListAppender.append(
              data,
              func2.asInstanceOf[Any => Any],
              () =>
                FoldListAppender.append(
                  data,
                  func3.asInstanceOf[Any => Any],
                  () => FoldListAppender.append(data, func4.asInstanceOf[Any => Any], () => FoldListZero)
                )
            )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.asInstanceOf[TypeAdtGetter].runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply5[I1, I2, I3, I4, I5, Poly] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, NumberCountChild[
        I1,
        NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[I5, NumberCountZero]]]]
      ], ConfirmSucceed, Poly]
    ): CusInnerApply5[I1, I2, I3, I4, I5] = new CusInnerApply5(adtList = v.value, data = data)
  }
  object HelperIOImpl5 extends PrepareInnerApply5[Any, Any, Any, Any, Any, Any]
  class CusInnerApply5[I1, I2, I3, I4, I5](adtList: Core2, data: Any) {
    @inline def fold[T](func1: I1 => T, func2: I2 => T, func3: I3 => T, func4: I4 => T, func5: I5 => T): T = {
      val result = adtList(() =>
        FoldListAppender.append(
          data,
          func1.asInstanceOf[Any => Any],
          () =>
            FoldListAppender.append(
              data,
              func2.asInstanceOf[Any => Any],
              () =>
                FoldListAppender.append(
                  data,
                  func3.asInstanceOf[Any => Any],
                  () =>
                    FoldListAppender.append(
                      data,
                      func4.asInstanceOf[Any => Any],
                      () => FoldListAppender.append(data, func5.asInstanceOf[Any => Any], () => FoldListZero)
                    )
                )
            )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.asInstanceOf[TypeAdtGetter].runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply6[I1, I2, I3, I4, I5, I6, Poly] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, NumberCountChild[
        I1,
        NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[I6, NumberCountZero]]]]]
      ], ConfirmSucceed, Poly]
    ): CusInnerApply6[I1, I2, I3, I4, I5, I6] = new CusInnerApply6(adtList = v.value, data = data)
  }
  object HelperIOImpl6 extends PrepareInnerApply6[Any, Any, Any, Any, Any, Any, Any]
  class CusInnerApply6[I1, I2, I3, I4, I5, I6](adtList: Core2, data: Any) {
    @inline def fold[T](func1: I1 => T, func2: I2 => T, func3: I3 => T, func4: I4 => T, func5: I5 => T, func6: I6 => T): T = {
      val result = adtList(() =>
        FoldListAppender.append(
          data,
          func1.asInstanceOf[Any => Any],
          () =>
            FoldListAppender.append(
              data,
              func2.asInstanceOf[Any => Any],
              () =>
                FoldListAppender.append(
                  data,
                  func3.asInstanceOf[Any => Any],
                  () =>
                    FoldListAppender.append(
                      data,
                      func4.asInstanceOf[Any => Any],
                      () =>
                        FoldListAppender.append(
                          data,
                          func5.asInstanceOf[Any => Any],
                          () => FoldListAppender.append(data, func6.asInstanceOf[Any => Any], () => FoldListZero)
                        )
                    )
                )
            )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.asInstanceOf[TypeAdtGetter].runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply7[I1, I2, I3, I4, I5, I6, I7, Poly] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, NumberCountChild[I1, NumberCountChild[
        I2,
        NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[I7, NumberCountZero]]]]]
      ]], ConfirmSucceed, Poly]
    ): CusInnerApply7[I1, I2, I3, I4, I5, I6, I7] = new CusInnerApply7(adtList = v.value, data = data)
  }
  object HelperIOImpl7 extends PrepareInnerApply7[Any, Any, Any, Any, Any, Any, Any, Any]
  class CusInnerApply7[I1, I2, I3, I4, I5, I6, I7](adtList: Core2, data: Any) {
    @inline def fold[T](
      func1: I1 => T,
      func2: I2 => T,
      func3: I3 => T,
      func4: I4 => T,
      func5: I5 => T,
      func6: I6 => T,
      func7: I7 => T
    ): T = {
      val result = adtList(() =>
        FoldListAppender.append(
          data,
          func1.asInstanceOf[Any => Any],
          () =>
            FoldListAppender.append(
              data,
              func2.asInstanceOf[Any => Any],
              () =>
                FoldListAppender.append(
                  data,
                  func3.asInstanceOf[Any => Any],
                  () =>
                    FoldListAppender.append(
                      data,
                      func4.asInstanceOf[Any => Any],
                      () =>
                        FoldListAppender.append(
                          data,
                          func5.asInstanceOf[Any => Any],
                          () =>
                            FoldListAppender.append(
                              data,
                              func6.asInstanceOf[Any => Any],
                              () => FoldListAppender.append(data, func7.asInstanceOf[Any => Any], () => FoldListZero)
                            )
                        )
                    )
                )
            )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.asInstanceOf[TypeAdtGetter].runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply8[I1, I2, I3, I4, I5, I6, I7, I8, Poly] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, NumberCountChild[I1, NumberCountChild[I2, NumberCountChild[
        I3,
        NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[I7, NumberCountChild[I8, NumberCountZero]]]]]
      ]]], ConfirmSucceed, Poly]
    ): CusInnerApply8[I1, I2, I3, I4, I5, I6, I7, I8] = new CusInnerApply8(adtList = v.value, data = data)
  }
  object HelperIOImpl8 extends PrepareInnerApply8[Any, Any, Any, Any, Any, Any, Any, Any, Any]
  class CusInnerApply8[I1, I2, I3, I4, I5, I6, I7, I8](adtList: Core2, data: Any) {
    @inline def fold[T](
      func1: I1 => T,
      func2: I2 => T,
      func3: I3 => T,
      func4: I4 => T,
      func5: I5 => T,
      func6: I6 => T,
      func7: I7 => T,
      func8: I8 => T
    ): T = {
      val result = adtList(() =>
        FoldListAppender.append(
          data,
          func1.asInstanceOf[Any => Any],
          () =>
            FoldListAppender.append(
              data,
              func2.asInstanceOf[Any => Any],
              () =>
                FoldListAppender.append(
                  data,
                  func3.asInstanceOf[Any => Any],
                  () =>
                    FoldListAppender.append(
                      data,
                      func4.asInstanceOf[Any => Any],
                      () =>
                        FoldListAppender.append(
                          data,
                          func5.asInstanceOf[Any => Any],
                          () =>
                            FoldListAppender.append(
                              data,
                              func6.asInstanceOf[Any => Any],
                              () =>
                                FoldListAppender.append(
                                  data,
                                  func7.asInstanceOf[Any => Any],
                                  () => FoldListAppender.append(data, func8.asInstanceOf[Any => Any], () => FoldListZero)
                                )
                            )
                        )
                    )
                )
            )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.asInstanceOf[TypeAdtGetter].runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply9[I1, I2, I3, I4, I5, I6, I7, I8, I9, Poly] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, NumberCountChild[I1, NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[
        I4,
        NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[I7, NumberCountChild[I8, NumberCountChild[I9, NumberCountZero]]]]]
      ]]]], ConfirmSucceed, Poly]
    ): CusInnerApply9[I1, I2, I3, I4, I5, I6, I7, I8, I9] = new CusInnerApply9(adtList = v.value, data = data)
  }
  object HelperIOImpl9 extends PrepareInnerApply9[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]
  class CusInnerApply9[I1, I2, I3, I4, I5, I6, I7, I8, I9](adtList: Core2, data: Any) {
    @inline def fold[T](
      func1: I1 => T,
      func2: I2 => T,
      func3: I3 => T,
      func4: I4 => T,
      func5: I5 => T,
      func6: I6 => T,
      func7: I7 => T,
      func8: I8 => T,
      func9: I9 => T
    ): T = {
      val result = adtList(() =>
        FoldListAppender.append(
          data,
          func1.asInstanceOf[Any => Any],
          () =>
            FoldListAppender.append(
              data,
              func2.asInstanceOf[Any => Any],
              () =>
                FoldListAppender.append(
                  data,
                  func3.asInstanceOf[Any => Any],
                  () =>
                    FoldListAppender.append(
                      data,
                      func4.asInstanceOf[Any => Any],
                      () =>
                        FoldListAppender.append(
                          data,
                          func5.asInstanceOf[Any => Any],
                          () =>
                            FoldListAppender.append(
                              data,
                              func6.asInstanceOf[Any => Any],
                              () =>
                                FoldListAppender.append(
                                  data,
                                  func7.asInstanceOf[Any => Any],
                                  () =>
                                    FoldListAppender.append(
                                      data,
                                      func8.asInstanceOf[Any => Any],
                                      () => FoldListAppender.append(data, func9.asInstanceOf[Any => Any], () => FoldListZero)
                                    )
                                )
                            )
                        )
                    )
                )
            )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.asInstanceOf[TypeAdtGetter].runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply10[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, Poly] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, NumberCountChild[
        I1,
        NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[
          I5,
          NumberCountChild[I6, NumberCountChild[I7, NumberCountChild[I8, NumberCountChild[I9, NumberCountChild[I10, NumberCountZero]]]]]
        ]]]]
      ], ConfirmSucceed, Poly]
    ): CusInnerApply10[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] = new CusInnerApply10(adtList = v.value, data = data)
  }
  object HelperIOImpl10 extends PrepareInnerApply10[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]
  class CusInnerApply10[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10](adtList: Core2, data: Any) {
    @inline def fold[T](
      func1: I1 => T,
      func2: I2 => T,
      func3: I3 => T,
      func4: I4 => T,
      func5: I5 => T,
      func6: I6 => T,
      func7: I7 => T,
      func8: I8 => T,
      func9: I9 => T,
      func10: I10 => T
    ): T = {
      val result = adtList(() =>
        FoldListAppender.append(
          data,
          func1.asInstanceOf[Any => Any],
          () =>
            FoldListAppender.append(
              data,
              func2.asInstanceOf[Any => Any],
              () =>
                FoldListAppender.append(
                  data,
                  func3.asInstanceOf[Any => Any],
                  () =>
                    FoldListAppender.append(
                      data,
                      func4.asInstanceOf[Any => Any],
                      () =>
                        FoldListAppender.append(
                          data,
                          func5.asInstanceOf[Any => Any],
                          () =>
                            FoldListAppender.append(
                              data,
                              func6.asInstanceOf[Any => Any],
                              () =>
                                FoldListAppender.append(
                                  data,
                                  func7.asInstanceOf[Any => Any],
                                  () =>
                                    FoldListAppender.append(
                                      data,
                                      func8.asInstanceOf[Any => Any],
                                      () =>
                                        FoldListAppender.append(
                                          data,
                                          func9.asInstanceOf[Any => Any],
                                          () => FoldListAppender.append(data, func10.asInstanceOf[Any => Any], () => FoldListZero)
                                        )
                                    )
                                )
                            )
                        )
                    )
                )
            )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.asInstanceOf[TypeAdtGetter].runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply11[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, Poly] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, NumberCountChild[
        I1,
        NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[
          I6,
          NumberCountChild[I7, NumberCountChild[I8, NumberCountChild[I9, NumberCountChild[I10, NumberCountChild[I11, NumberCountZero]]]]]
        ]]]]]
      ], ConfirmSucceed, Poly]
    ): CusInnerApply11[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] = new CusInnerApply11(adtList = v.value, data = data)
  }
  object HelperIOImpl11 extends PrepareInnerApply11[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]
  class CusInnerApply11[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11](adtList: Core2, data: Any) {
    @inline def fold[T](
      func1: I1 => T,
      func2: I2 => T,
      func3: I3 => T,
      func4: I4 => T,
      func5: I5 => T,
      func6: I6 => T,
      func7: I7 => T,
      func8: I8 => T,
      func9: I9 => T,
      func10: I10 => T,
      func11: I11 => T
    ): T = {
      val result = adtList(() =>
        FoldListAppender.append(
          data,
          func1.asInstanceOf[Any => Any],
          () =>
            FoldListAppender.append(
              data,
              func2.asInstanceOf[Any => Any],
              () =>
                FoldListAppender.append(
                  data,
                  func3.asInstanceOf[Any => Any],
                  () =>
                    FoldListAppender.append(
                      data,
                      func4.asInstanceOf[Any => Any],
                      () =>
                        FoldListAppender.append(
                          data,
                          func5.asInstanceOf[Any => Any],
                          () =>
                            FoldListAppender.append(
                              data,
                              func6.asInstanceOf[Any => Any],
                              () =>
                                FoldListAppender.append(
                                  data,
                                  func7.asInstanceOf[Any => Any],
                                  () =>
                                    FoldListAppender.append(
                                      data,
                                      func8.asInstanceOf[Any => Any],
                                      () =>
                                        FoldListAppender.append(
                                          data,
                                          func9.asInstanceOf[Any => Any],
                                          () =>
                                            FoldListAppender.append(
                                              data,
                                              func10.asInstanceOf[Any => Any],
                                              () => FoldListAppender.append(data, func11.asInstanceOf[Any => Any], () => FoldListZero)
                                            )
                                        )
                                    )
                                )
                            )
                        )
                    )
                )
            )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.asInstanceOf[TypeAdtGetter].runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply12[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, Poly] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, NumberCountChild[
        I1,
        NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[
          I7,
          NumberCountChild[I8, NumberCountChild[I9, NumberCountChild[I10, NumberCountChild[I11, NumberCountChild[I12, NumberCountZero]]]]]
        ]]]]]]
      ], ConfirmSucceed, Poly]
    ): CusInnerApply12[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] = new CusInnerApply12(adtList = v.value, data = data)
  }
  object HelperIOImpl12 extends PrepareInnerApply12[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]
  class CusInnerApply12[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12](adtList: Core2, data: Any) {
    @inline def fold[T](
      func1: I1 => T,
      func2: I2 => T,
      func3: I3 => T,
      func4: I4 => T,
      func5: I5 => T,
      func6: I6 => T,
      func7: I7 => T,
      func8: I8 => T,
      func9: I9 => T,
      func10: I10 => T,
      func11: I11 => T,
      func12: I12 => T
    ): T = {
      val result = adtList(() =>
        FoldListAppender.append(
          data,
          func1.asInstanceOf[Any => Any],
          () =>
            FoldListAppender.append(
              data,
              func2.asInstanceOf[Any => Any],
              () =>
                FoldListAppender.append(
                  data,
                  func3.asInstanceOf[Any => Any],
                  () =>
                    FoldListAppender.append(
                      data,
                      func4.asInstanceOf[Any => Any],
                      () =>
                        FoldListAppender.append(
                          data,
                          func5.asInstanceOf[Any => Any],
                          () =>
                            FoldListAppender.append(
                              data,
                              func6.asInstanceOf[Any => Any],
                              () =>
                                FoldListAppender.append(
                                  data,
                                  func7.asInstanceOf[Any => Any],
                                  () =>
                                    FoldListAppender.append(
                                      data,
                                      func8.asInstanceOf[Any => Any],
                                      () =>
                                        FoldListAppender.append(
                                          data,
                                          func9.asInstanceOf[Any => Any],
                                          () =>
                                            FoldListAppender.append(
                                              data,
                                              func10.asInstanceOf[Any => Any],
                                              () =>
                                                FoldListAppender.append(
                                                  data,
                                                  func11.asInstanceOf[Any => Any],
                                                  () => FoldListAppender.append(data, func12.asInstanceOf[Any => Any], () => FoldListZero)
                                                )
                                            )
                                        )
                                    )
                                )
                            )
                        )
                    )
                )
            )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.asInstanceOf[TypeAdtGetter].runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply13[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, Poly] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, NumberCountChild[I1, NumberCountChild[
        I2,
        NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[I7, NumberCountChild[
          I8,
          NumberCountChild[I9, NumberCountChild[I10, NumberCountChild[I11, NumberCountChild[I12, NumberCountChild[I13, NumberCountZero]]]]]
        ]]]]]]
      ]], ConfirmSucceed, Poly]
    ): CusInnerApply13[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] = new CusInnerApply13(adtList = v.value, data = data)
  }
  object HelperIOImpl13 extends PrepareInnerApply13[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]
  class CusInnerApply13[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13](adtList: Core2, data: Any) {
    @inline def fold[T](
      func1: I1 => T,
      func2: I2 => T,
      func3: I3 => T,
      func4: I4 => T,
      func5: I5 => T,
      func6: I6 => T,
      func7: I7 => T,
      func8: I8 => T,
      func9: I9 => T,
      func10: I10 => T,
      func11: I11 => T,
      func12: I12 => T,
      func13: I13 => T
    ): T = {
      val result = adtList(() =>
        FoldListAppender.append(
          data,
          func1.asInstanceOf[Any => Any],
          () =>
            FoldListAppender.append(
              data,
              func2.asInstanceOf[Any => Any],
              () =>
                FoldListAppender.append(
                  data,
                  func3.asInstanceOf[Any => Any],
                  () =>
                    FoldListAppender.append(
                      data,
                      func4.asInstanceOf[Any => Any],
                      () =>
                        FoldListAppender.append(
                          data,
                          func5.asInstanceOf[Any => Any],
                          () =>
                            FoldListAppender.append(
                              data,
                              func6.asInstanceOf[Any => Any],
                              () =>
                                FoldListAppender.append(
                                  data,
                                  func7.asInstanceOf[Any => Any],
                                  () =>
                                    FoldListAppender.append(
                                      data,
                                      func8.asInstanceOf[Any => Any],
                                      () =>
                                        FoldListAppender.append(
                                          data,
                                          func9.asInstanceOf[Any => Any],
                                          () =>
                                            FoldListAppender.append(
                                              data,
                                              func10.asInstanceOf[Any => Any],
                                              () =>
                                                FoldListAppender.append(
                                                  data,
                                                  func11.asInstanceOf[Any => Any],
                                                  () =>
                                                    FoldListAppender.append(
                                                      data,
                                                      func12.asInstanceOf[Any => Any],
                                                      () =>
                                                        FoldListAppender.append(data, func13.asInstanceOf[Any => Any], () => FoldListZero)
                                                    )
                                                )
                                            )
                                        )
                                    )
                                )
                            )
                        )
                    )
                )
            )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.asInstanceOf[TypeAdtGetter].runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply14[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, Poly] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, NumberCountChild[I1, NumberCountChild[I2, NumberCountChild[
        I3,
        NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[I7, NumberCountChild[I8, NumberCountChild[
          I9,
          NumberCountChild[I10, NumberCountChild[I11, NumberCountChild[I12, NumberCountChild[I13, NumberCountChild[I14, NumberCountZero]]]]]
        ]]]]]]
      ]]], ConfirmSucceed, Poly]
    ): CusInnerApply14[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] = new CusInnerApply14(adtList = v.value, data = data)
  }
  object HelperIOImpl14 extends PrepareInnerApply14[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]
  class CusInnerApply14[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14](adtList: Core2, data: Any) {
    @inline def fold[T](
      func1: I1 => T,
      func2: I2 => T,
      func3: I3 => T,
      func4: I4 => T,
      func5: I5 => T,
      func6: I6 => T,
      func7: I7 => T,
      func8: I8 => T,
      func9: I9 => T,
      func10: I10 => T,
      func11: I11 => T,
      func12: I12 => T,
      func13: I13 => T,
      func14: I14 => T
    ): T = {
      val result = adtList(() =>
        FoldListAppender.append(
          data,
          func1.asInstanceOf[Any => Any],
          () =>
            FoldListAppender.append(
              data,
              func2.asInstanceOf[Any => Any],
              () =>
                FoldListAppender.append(
                  data,
                  func3.asInstanceOf[Any => Any],
                  () =>
                    FoldListAppender.append(
                      data,
                      func4.asInstanceOf[Any => Any],
                      () =>
                        FoldListAppender.append(
                          data,
                          func5.asInstanceOf[Any => Any],
                          () =>
                            FoldListAppender.append(
                              data,
                              func6.asInstanceOf[Any => Any],
                              () =>
                                FoldListAppender.append(
                                  data,
                                  func7.asInstanceOf[Any => Any],
                                  () =>
                                    FoldListAppender.append(
                                      data,
                                      func8.asInstanceOf[Any => Any],
                                      () =>
                                        FoldListAppender.append(
                                          data,
                                          func9.asInstanceOf[Any => Any],
                                          () =>
                                            FoldListAppender.append(
                                              data,
                                              func10.asInstanceOf[Any => Any],
                                              () =>
                                                FoldListAppender.append(
                                                  data,
                                                  func11.asInstanceOf[Any => Any],
                                                  () =>
                                                    FoldListAppender.append(
                                                      data,
                                                      func12.asInstanceOf[Any => Any],
                                                      () =>
                                                        FoldListAppender.append(
                                                          data,
                                                          func13.asInstanceOf[Any => Any],
                                                          () =>
                                                            FoldListAppender.append(
                                                              data,
                                                              func14.asInstanceOf[Any => Any],
                                                              () => FoldListZero
                                                            )
                                                        )
                                                    )
                                                )
                                            )
                                        )
                                    )
                                )
                            )
                        )
                    )
                )
            )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.asInstanceOf[TypeAdtGetter].runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply15[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, Poly] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, NumberCountChild[I1, NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[
        I4,
        NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[I7, NumberCountChild[I8, NumberCountChild[I9, NumberCountChild[
          I10,
          NumberCountChild[I11, NumberCountChild[I12, NumberCountChild[I13, NumberCountChild[I14, NumberCountChild[I15, NumberCountZero]]]]]
        ]]]]]]
      ]]]], ConfirmSucceed, Poly]
    ): CusInnerApply15[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] =
      new CusInnerApply15(adtList = v.value, data = data)
  }
  object HelperIOImpl15 extends PrepareInnerApply15[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]
  class CusInnerApply15[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15](adtList: Core2, data: Any) {
    @inline def fold[T](
      func1: I1 => T,
      func2: I2 => T,
      func3: I3 => T,
      func4: I4 => T,
      func5: I5 => T,
      func6: I6 => T,
      func7: I7 => T,
      func8: I8 => T,
      func9: I9 => T,
      func10: I10 => T,
      func11: I11 => T,
      func12: I12 => T,
      func13: I13 => T,
      func14: I14 => T,
      func15: I15 => T
    ): T = {
      val result = adtList(() =>
        FoldListAppender.append(
          data,
          func1.asInstanceOf[Any => Any],
          () =>
            FoldListAppender.append(
              data,
              func2.asInstanceOf[Any => Any],
              () =>
                FoldListAppender.append(
                  data,
                  func3.asInstanceOf[Any => Any],
                  () =>
                    FoldListAppender.append(
                      data,
                      func4.asInstanceOf[Any => Any],
                      () =>
                        FoldListAppender.append(
                          data,
                          func5.asInstanceOf[Any => Any],
                          () =>
                            FoldListAppender.append(
                              data,
                              func6.asInstanceOf[Any => Any],
                              () =>
                                FoldListAppender.append(
                                  data,
                                  func7.asInstanceOf[Any => Any],
                                  () =>
                                    FoldListAppender.append(
                                      data,
                                      func8.asInstanceOf[Any => Any],
                                      () =>
                                        FoldListAppender.append(
                                          data,
                                          func9.asInstanceOf[Any => Any],
                                          () =>
                                            FoldListAppender.append(
                                              data,
                                              func10.asInstanceOf[Any => Any],
                                              () =>
                                                FoldListAppender.append(
                                                  data,
                                                  func11.asInstanceOf[Any => Any],
                                                  () =>
                                                    FoldListAppender.append(
                                                      data,
                                                      func12.asInstanceOf[Any => Any],
                                                      () =>
                                                        FoldListAppender.append(
                                                          data,
                                                          func13.asInstanceOf[Any => Any],
                                                          () =>
                                                            FoldListAppender.append(
                                                              data,
                                                              func14.asInstanceOf[Any => Any],
                                                              () =>
                                                                FoldListAppender.append(
                                                                  data,
                                                                  func15.asInstanceOf[Any => Any],
                                                                  () => FoldListZero
                                                                )
                                                            )
                                                        )
                                                    )
                                                )
                                            )
                                        )
                                    )
                                )
                            )
                        )
                    )
                )
            )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.asInstanceOf[TypeAdtGetter].runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply16[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, Poly] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, NumberCountChild[
        I1,
        NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[
          I6,
          NumberCountChild[I7, NumberCountChild[I8, NumberCountChild[I9, NumberCountChild[I10, NumberCountChild[I11, NumberCountChild[
            I12,
            NumberCountChild[I13, NumberCountChild[I14, NumberCountChild[I15, NumberCountChild[I16, NumberCountZero]]]]
          ]]]]]]
        ]]]]]
      ], ConfirmSucceed, Poly]
    ): CusInnerApply16[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] =
      new CusInnerApply16(adtList = v.value, data = data)
  }
  object HelperIOImpl16 extends PrepareInnerApply16[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]
  class CusInnerApply16[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16](adtList: Core2, data: Any) {
    @inline def fold[T](
      func1: I1 => T,
      func2: I2 => T,
      func3: I3 => T,
      func4: I4 => T,
      func5: I5 => T,
      func6: I6 => T,
      func7: I7 => T,
      func8: I8 => T,
      func9: I9 => T,
      func10: I10 => T,
      func11: I11 => T,
      func12: I12 => T,
      func13: I13 => T,
      func14: I14 => T,
      func15: I15 => T,
      func16: I16 => T
    ): T = {
      val result = adtList(() =>
        FoldListAppender.append(
          data,
          func1.asInstanceOf[Any => Any],
          () =>
            FoldListAppender.append(
              data,
              func2.asInstanceOf[Any => Any],
              () =>
                FoldListAppender.append(
                  data,
                  func3.asInstanceOf[Any => Any],
                  () =>
                    FoldListAppender.append(
                      data,
                      func4.asInstanceOf[Any => Any],
                      () =>
                        FoldListAppender.append(
                          data,
                          func5.asInstanceOf[Any => Any],
                          () =>
                            FoldListAppender.append(
                              data,
                              func6.asInstanceOf[Any => Any],
                              () =>
                                FoldListAppender.append(
                                  data,
                                  func7.asInstanceOf[Any => Any],
                                  () =>
                                    FoldListAppender.append(
                                      data,
                                      func8.asInstanceOf[Any => Any],
                                      () =>
                                        FoldListAppender.append(
                                          data,
                                          func9.asInstanceOf[Any => Any],
                                          () =>
                                            FoldListAppender.append(
                                              data,
                                              func10.asInstanceOf[Any => Any],
                                              () =>
                                                FoldListAppender.append(
                                                  data,
                                                  func11.asInstanceOf[Any => Any],
                                                  () =>
                                                    FoldListAppender.append(
                                                      data,
                                                      func12.asInstanceOf[Any => Any],
                                                      () =>
                                                        FoldListAppender.append(
                                                          data,
                                                          func13.asInstanceOf[Any => Any],
                                                          () =>
                                                            FoldListAppender.append(
                                                              data,
                                                              func14.asInstanceOf[Any => Any],
                                                              () =>
                                                                FoldListAppender.append(
                                                                  data,
                                                                  func15.asInstanceOf[Any => Any],
                                                                  () =>
                                                                    FoldListAppender.append(
                                                                      data,
                                                                      func16.asInstanceOf[Any => Any],
                                                                      () => FoldListZero
                                                                    )
                                                                )
                                                            )
                                                        )
                                                    )
                                                )
                                            )
                                        )
                                    )
                                )
                            )
                        )
                    )
                )
            )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.asInstanceOf[TypeAdtGetter].runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply17[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, Poly] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, NumberCountChild[
        I1,
        NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[
          I7,
          NumberCountChild[I8, NumberCountChild[I9, NumberCountChild[I10, NumberCountChild[I11, NumberCountChild[I12, NumberCountChild[
            I13,
            NumberCountChild[I14, NumberCountChild[I15, NumberCountChild[I16, NumberCountChild[I17, NumberCountZero]]]]
          ]]]]]]
        ]]]]]]
      ], ConfirmSucceed, Poly]
    ): CusInnerApply17[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] =
      new CusInnerApply17(adtList = v.value, data = data)
  }
  object HelperIOImpl17
      extends PrepareInnerApply17[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]
  class CusInnerApply17[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17](adtList: Core2, data: Any) {
    @inline def fold[T](
      func1: I1 => T,
      func2: I2 => T,
      func3: I3 => T,
      func4: I4 => T,
      func5: I5 => T,
      func6: I6 => T,
      func7: I7 => T,
      func8: I8 => T,
      func9: I9 => T,
      func10: I10 => T,
      func11: I11 => T,
      func12: I12 => T,
      func13: I13 => T,
      func14: I14 => T,
      func15: I15 => T,
      func16: I16 => T,
      func17: I17 => T
    ): T = {
      val result = adtList(() =>
        FoldListAppender.append(
          data,
          func1.asInstanceOf[Any => Any],
          () =>
            FoldListAppender.append(
              data,
              func2.asInstanceOf[Any => Any],
              () =>
                FoldListAppender.append(
                  data,
                  func3.asInstanceOf[Any => Any],
                  () =>
                    FoldListAppender.append(
                      data,
                      func4.asInstanceOf[Any => Any],
                      () =>
                        FoldListAppender.append(
                          data,
                          func5.asInstanceOf[Any => Any],
                          () =>
                            FoldListAppender.append(
                              data,
                              func6.asInstanceOf[Any => Any],
                              () =>
                                FoldListAppender.append(
                                  data,
                                  func7.asInstanceOf[Any => Any],
                                  () =>
                                    FoldListAppender.append(
                                      data,
                                      func8.asInstanceOf[Any => Any],
                                      () =>
                                        FoldListAppender.append(
                                          data,
                                          func9.asInstanceOf[Any => Any],
                                          () =>
                                            FoldListAppender.append(
                                              data,
                                              func10.asInstanceOf[Any => Any],
                                              () =>
                                                FoldListAppender.append(
                                                  data,
                                                  func11.asInstanceOf[Any => Any],
                                                  () =>
                                                    FoldListAppender.append(
                                                      data,
                                                      func12.asInstanceOf[Any => Any],
                                                      () =>
                                                        FoldListAppender.append(
                                                          data,
                                                          func13.asInstanceOf[Any => Any],
                                                          () =>
                                                            FoldListAppender.append(
                                                              data,
                                                              func14.asInstanceOf[Any => Any],
                                                              () =>
                                                                FoldListAppender.append(
                                                                  data,
                                                                  func15.asInstanceOf[Any => Any],
                                                                  () =>
                                                                    FoldListAppender.append(
                                                                      data,
                                                                      func16.asInstanceOf[Any => Any],
                                                                      () =>
                                                                        FoldListAppender.append(
                                                                          data,
                                                                          func17.asInstanceOf[Any => Any],
                                                                          () => FoldListZero
                                                                        )
                                                                    )
                                                                )
                                                            )
                                                        )
                                                    )
                                                )
                                            )
                                        )
                                    )
                                )
                            )
                        )
                    )
                )
            )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.asInstanceOf[TypeAdtGetter].runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply18[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, Poly] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, NumberCountChild[I1, NumberCountChild[
        I2,
        NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[I7, NumberCountChild[
          I8,
          NumberCountChild[I9, NumberCountChild[I10, NumberCountChild[I11, NumberCountChild[I12, NumberCountChild[I13, NumberCountChild[
            I14,
            NumberCountChild[I15, NumberCountChild[I16, NumberCountChild[I17, NumberCountChild[I18, NumberCountZero]]]]
          ]]]]]]
        ]]]]]]
      ]], ConfirmSucceed, Poly]
    ): CusInnerApply18[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] =
      new CusInnerApply18(adtList = v.value, data = data)
  }
  object HelperIOImpl18
      extends PrepareInnerApply18[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]
  class CusInnerApply18[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18](adtList: Core2, data: Any) {
    @inline def fold[T](
      func1: I1 => T,
      func2: I2 => T,
      func3: I3 => T,
      func4: I4 => T,
      func5: I5 => T,
      func6: I6 => T,
      func7: I7 => T,
      func8: I8 => T,
      func9: I9 => T,
      func10: I10 => T,
      func11: I11 => T,
      func12: I12 => T,
      func13: I13 => T,
      func14: I14 => T,
      func15: I15 => T,
      func16: I16 => T,
      func17: I17 => T,
      func18: I18 => T
    ): T = {
      val result = adtList(() =>
        FoldListAppender.append(
          data,
          func1.asInstanceOf[Any => Any],
          () =>
            FoldListAppender.append(
              data,
              func2.asInstanceOf[Any => Any],
              () =>
                FoldListAppender.append(
                  data,
                  func3.asInstanceOf[Any => Any],
                  () =>
                    FoldListAppender.append(
                      data,
                      func4.asInstanceOf[Any => Any],
                      () =>
                        FoldListAppender.append(
                          data,
                          func5.asInstanceOf[Any => Any],
                          () =>
                            FoldListAppender.append(
                              data,
                              func6.asInstanceOf[Any => Any],
                              () =>
                                FoldListAppender.append(
                                  data,
                                  func7.asInstanceOf[Any => Any],
                                  () =>
                                    FoldListAppender.append(
                                      data,
                                      func8.asInstanceOf[Any => Any],
                                      () =>
                                        FoldListAppender.append(
                                          data,
                                          func9.asInstanceOf[Any => Any],
                                          () =>
                                            FoldListAppender.append(
                                              data,
                                              func10.asInstanceOf[Any => Any],
                                              () =>
                                                FoldListAppender.append(
                                                  data,
                                                  func11.asInstanceOf[Any => Any],
                                                  () =>
                                                    FoldListAppender.append(
                                                      data,
                                                      func12.asInstanceOf[Any => Any],
                                                      () =>
                                                        FoldListAppender.append(
                                                          data,
                                                          func13.asInstanceOf[Any => Any],
                                                          () =>
                                                            FoldListAppender.append(
                                                              data,
                                                              func14.asInstanceOf[Any => Any],
                                                              () =>
                                                                FoldListAppender.append(
                                                                  data,
                                                                  func15.asInstanceOf[Any => Any],
                                                                  () =>
                                                                    FoldListAppender.append(
                                                                      data,
                                                                      func16.asInstanceOf[Any => Any],
                                                                      () =>
                                                                        FoldListAppender.append(
                                                                          data,
                                                                          func17.asInstanceOf[Any => Any],
                                                                          () =>
                                                                            FoldListAppender.append(
                                                                              data,
                                                                              func18.asInstanceOf[Any => Any],
                                                                              () => FoldListZero
                                                                            )
                                                                        )
                                                                    )
                                                                )
                                                            )
                                                        )
                                                    )
                                                )
                                            )
                                        )
                                    )
                                )
                            )
                        )
                    )
                )
            )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.asInstanceOf[TypeAdtGetter].runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply19[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, Poly] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, NumberCountChild[I1, NumberCountChild[I2, NumberCountChild[
        I3,
        NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[I7, NumberCountChild[I8, NumberCountChild[
          I9,
          NumberCountChild[I10, NumberCountChild[I11, NumberCountChild[I12, NumberCountChild[I13, NumberCountChild[I14, NumberCountChild[
            I15,
            NumberCountChild[I16, NumberCountChild[I17, NumberCountChild[I18, NumberCountChild[I19, NumberCountZero]]]]
          ]]]]]]
        ]]]]]]
      ]]], ConfirmSucceed, Poly]
    ): CusInnerApply19[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] =
      new CusInnerApply19(adtList = v.value, data = data)
  }
  object HelperIOImpl19
      extends PrepareInnerApply19[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]
  class CusInnerApply19[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19](adtList: Core2, data: Any) {
    @inline def fold[T](
      func1: I1 => T,
      func2: I2 => T,
      func3: I3 => T,
      func4: I4 => T,
      func5: I5 => T,
      func6: I6 => T,
      func7: I7 => T,
      func8: I8 => T,
      func9: I9 => T,
      func10: I10 => T,
      func11: I11 => T,
      func12: I12 => T,
      func13: I13 => T,
      func14: I14 => T,
      func15: I15 => T,
      func16: I16 => T,
      func17: I17 => T,
      func18: I18 => T,
      func19: I19 => T
    ): T = {
      val result = adtList(() =>
        FoldListAppender.append(
          data,
          func1.asInstanceOf[Any => Any],
          () =>
            FoldListAppender.append(
              data,
              func2.asInstanceOf[Any => Any],
              () =>
                FoldListAppender.append(
                  data,
                  func3.asInstanceOf[Any => Any],
                  () =>
                    FoldListAppender.append(
                      data,
                      func4.asInstanceOf[Any => Any],
                      () =>
                        FoldListAppender.append(
                          data,
                          func5.asInstanceOf[Any => Any],
                          () =>
                            FoldListAppender.append(
                              data,
                              func6.asInstanceOf[Any => Any],
                              () =>
                                FoldListAppender.append(
                                  data,
                                  func7.asInstanceOf[Any => Any],
                                  () =>
                                    FoldListAppender.append(
                                      data,
                                      func8.asInstanceOf[Any => Any],
                                      () =>
                                        FoldListAppender.append(
                                          data,
                                          func9.asInstanceOf[Any => Any],
                                          () =>
                                            FoldListAppender.append(
                                              data,
                                              func10.asInstanceOf[Any => Any],
                                              () =>
                                                FoldListAppender.append(
                                                  data,
                                                  func11.asInstanceOf[Any => Any],
                                                  () =>
                                                    FoldListAppender.append(
                                                      data,
                                                      func12.asInstanceOf[Any => Any],
                                                      () =>
                                                        FoldListAppender.append(
                                                          data,
                                                          func13.asInstanceOf[Any => Any],
                                                          () =>
                                                            FoldListAppender.append(
                                                              data,
                                                              func14.asInstanceOf[Any => Any],
                                                              () =>
                                                                FoldListAppender.append(
                                                                  data,
                                                                  func15.asInstanceOf[Any => Any],
                                                                  () =>
                                                                    FoldListAppender.append(
                                                                      data,
                                                                      func16.asInstanceOf[Any => Any],
                                                                      () =>
                                                                        FoldListAppender.append(
                                                                          data,
                                                                          func17.asInstanceOf[Any => Any],
                                                                          () =>
                                                                            FoldListAppender.append(
                                                                              data,
                                                                              func18.asInstanceOf[Any => Any],
                                                                              () =>
                                                                                FoldListAppender.append(
                                                                                  data,
                                                                                  func19.asInstanceOf[Any => Any],
                                                                                  () => FoldListZero
                                                                                )
                                                                            )
                                                                        )
                                                                    )
                                                                )
                                                            )
                                                        )
                                                    )
                                                )
                                            )
                                        )
                                    )
                                )
                            )
                        )
                    )
                )
            )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.asInstanceOf[TypeAdtGetter].runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply20[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, Poly] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, NumberCountChild[I1, NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[
        I4,
        NumberCountChild[I5, NumberCountChild[I6, NumberCountChild[I7, NumberCountChild[I8, NumberCountChild[I9, NumberCountChild[
          I10,
          NumberCountChild[I11, NumberCountChild[I12, NumberCountChild[I13, NumberCountChild[I14, NumberCountChild[I15, NumberCountChild[
            I16,
            NumberCountChild[I17, NumberCountChild[I18, NumberCountChild[I19, NumberCountChild[I20, NumberCountZero]]]]
          ]]]]]]
        ]]]]]]
      ]]]], ConfirmSucceed, Poly]
    ): CusInnerApply20[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] =
      new CusInnerApply20(adtList = v.value, data = data)
  }
  object HelperIOImpl20
      extends PrepareInnerApply20[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]
  class CusInnerApply20[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20](
    adtList: Core2,
    data: Any
  ) {
    @inline def fold[T](
      func1: I1 => T,
      func2: I2 => T,
      func3: I3 => T,
      func4: I4 => T,
      func5: I5 => T,
      func6: I6 => T,
      func7: I7 => T,
      func8: I8 => T,
      func9: I9 => T,
      func10: I10 => T,
      func11: I11 => T,
      func12: I12 => T,
      func13: I13 => T,
      func14: I14 => T,
      func15: I15 => T,
      func16: I16 => T,
      func17: I17 => T,
      func18: I18 => T,
      func19: I19 => T,
      func20: I20 => T
    ): T = {
      val result = adtList(() =>
        FoldListAppender.append(
          data,
          func1.asInstanceOf[Any => Any],
          () =>
            FoldListAppender.append(
              data,
              func2.asInstanceOf[Any => Any],
              () =>
                FoldListAppender.append(
                  data,
                  func3.asInstanceOf[Any => Any],
                  () =>
                    FoldListAppender.append(
                      data,
                      func4.asInstanceOf[Any => Any],
                      () =>
                        FoldListAppender.append(
                          data,
                          func5.asInstanceOf[Any => Any],
                          () =>
                            FoldListAppender.append(
                              data,
                              func6.asInstanceOf[Any => Any],
                              () =>
                                FoldListAppender.append(
                                  data,
                                  func7.asInstanceOf[Any => Any],
                                  () =>
                                    FoldListAppender.append(
                                      data,
                                      func8.asInstanceOf[Any => Any],
                                      () =>
                                        FoldListAppender.append(
                                          data,
                                          func9.asInstanceOf[Any => Any],
                                          () =>
                                            FoldListAppender.append(
                                              data,
                                              func10.asInstanceOf[Any => Any],
                                              () =>
                                                FoldListAppender.append(
                                                  data,
                                                  func11.asInstanceOf[Any => Any],
                                                  () =>
                                                    FoldListAppender.append(
                                                      data,
                                                      func12.asInstanceOf[Any => Any],
                                                      () =>
                                                        FoldListAppender.append(
                                                          data,
                                                          func13.asInstanceOf[Any => Any],
                                                          () =>
                                                            FoldListAppender.append(
                                                              data,
                                                              func14.asInstanceOf[Any => Any],
                                                              () =>
                                                                FoldListAppender.append(
                                                                  data,
                                                                  func15.asInstanceOf[Any => Any],
                                                                  () =>
                                                                    FoldListAppender.append(
                                                                      data,
                                                                      func16.asInstanceOf[Any => Any],
                                                                      () =>
                                                                        FoldListAppender.append(
                                                                          data,
                                                                          func17.asInstanceOf[Any => Any],
                                                                          () =>
                                                                            FoldListAppender.append(
                                                                              data,
                                                                              func18.asInstanceOf[Any => Any],
                                                                              () =>
                                                                                FoldListAppender.append(
                                                                                  data,
                                                                                  func19.asInstanceOf[Any => Any],
                                                                                  () =>
                                                                                    FoldListAppender.append(
                                                                                      data,
                                                                                      func20.asInstanceOf[Any => Any],
                                                                                      () => FoldListZero
                                                                                    )
                                                                                )
                                                                            )
                                                                        )
                                                                    )
                                                                )
                                                            )
                                                        )
                                                    )
                                                )
                                            )
                                        )
                                    )
                                )
                            )
                        )
                    )
                )
            )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.asInstanceOf[TypeAdtGetter].runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply21[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, Poly] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, NumberCountChild[
        I1,
        NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[
          I5,
          NumberCountChild[I6, NumberCountChild[I7, NumberCountChild[I8, NumberCountChild[I9, NumberCountChild[I10, NumberCountChild[
            I11,
            NumberCountChild[I12, NumberCountChild[I13, NumberCountChild[I14, NumberCountChild[I15, NumberCountChild[I16, NumberCountChild[
              I17,
              NumberCountChild[I18, NumberCountChild[I19, NumberCountChild[I20, NumberCountChild[I21, NumberCountZero]]]]
            ]]]]]]
          ]]]]]]
        ]]]]
      ], ConfirmSucceed, Poly]
    ): CusInnerApply21[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] =
      new CusInnerApply21(adtList = v.value, data = data)
  }
  object HelperIOImpl21
      extends PrepareInnerApply21[
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any
      ]
  class CusInnerApply21[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21](
    adtList: Core2,
    data: Any
  ) {
    @inline def fold[T](
      func1: I1 => T,
      func2: I2 => T,
      func3: I3 => T,
      func4: I4 => T,
      func5: I5 => T,
      func6: I6 => T,
      func7: I7 => T,
      func8: I8 => T,
      func9: I9 => T,
      func10: I10 => T,
      func11: I11 => T,
      func12: I12 => T,
      func13: I13 => T,
      func14: I14 => T,
      func15: I15 => T,
      func16: I16 => T,
      func17: I17 => T,
      func18: I18 => T,
      func19: I19 => T,
      func20: I20 => T,
      func21: I21 => T
    ): T = {
      val result = adtList(() =>
        FoldListAppender.append(
          data,
          func1.asInstanceOf[Any => Any],
          () =>
            FoldListAppender.append(
              data,
              func2.asInstanceOf[Any => Any],
              () =>
                FoldListAppender.append(
                  data,
                  func3.asInstanceOf[Any => Any],
                  () =>
                    FoldListAppender.append(
                      data,
                      func4.asInstanceOf[Any => Any],
                      () =>
                        FoldListAppender.append(
                          data,
                          func5.asInstanceOf[Any => Any],
                          () =>
                            FoldListAppender.append(
                              data,
                              func6.asInstanceOf[Any => Any],
                              () =>
                                FoldListAppender.append(
                                  data,
                                  func7.asInstanceOf[Any => Any],
                                  () =>
                                    FoldListAppender.append(
                                      data,
                                      func8.asInstanceOf[Any => Any],
                                      () =>
                                        FoldListAppender.append(
                                          data,
                                          func9.asInstanceOf[Any => Any],
                                          () =>
                                            FoldListAppender.append(
                                              data,
                                              func10.asInstanceOf[Any => Any],
                                              () =>
                                                FoldListAppender.append(
                                                  data,
                                                  func11.asInstanceOf[Any => Any],
                                                  () =>
                                                    FoldListAppender.append(
                                                      data,
                                                      func12.asInstanceOf[Any => Any],
                                                      () =>
                                                        FoldListAppender.append(
                                                          data,
                                                          func13.asInstanceOf[Any => Any],
                                                          () =>
                                                            FoldListAppender.append(
                                                              data,
                                                              func14.asInstanceOf[Any => Any],
                                                              () =>
                                                                FoldListAppender.append(
                                                                  data,
                                                                  func15.asInstanceOf[Any => Any],
                                                                  () =>
                                                                    FoldListAppender.append(
                                                                      data,
                                                                      func16.asInstanceOf[Any => Any],
                                                                      () =>
                                                                        FoldListAppender.append(
                                                                          data,
                                                                          func17.asInstanceOf[Any => Any],
                                                                          () =>
                                                                            FoldListAppender.append(
                                                                              data,
                                                                              func18.asInstanceOf[Any => Any],
                                                                              () =>
                                                                                FoldListAppender.append(
                                                                                  data,
                                                                                  func19.asInstanceOf[Any => Any],
                                                                                  () =>
                                                                                    FoldListAppender.append(
                                                                                      data,
                                                                                      func20.asInstanceOf[Any => Any],
                                                                                      () =>
                                                                                        FoldListAppender.append(
                                                                                          data,
                                                                                          func21.asInstanceOf[Any => Any],
                                                                                          () => FoldListZero
                                                                                        )
                                                                                    )
                                                                                )
                                                                            )
                                                                        )
                                                                    )
                                                                )
                                                            )
                                                        )
                                                    )
                                                )
                                            )
                                        )
                                    )
                                )
                            )
                        )
                    )
                )
            )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.asInstanceOf[TypeAdtGetter].runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply22[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22, Poly] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, NumberCountChild[
        I1,
        NumberCountChild[I2, NumberCountChild[I3, NumberCountChild[I4, NumberCountChild[I5, NumberCountChild[
          I6,
          NumberCountChild[I7, NumberCountChild[I8, NumberCountChild[I9, NumberCountChild[I10, NumberCountChild[I11, NumberCountChild[
            I12,
            NumberCountChild[I13, NumberCountChild[I14, NumberCountChild[I15, NumberCountChild[I16, NumberCountChild[I17, NumberCountChild[
              I18,
              NumberCountChild[I19, NumberCountChild[I20, NumberCountChild[I21, NumberCountChild[I22, NumberCountZero]]]]
            ]]]]]]
          ]]]]]]
        ]]]]]
      ], ConfirmSucceed, Poly]
    ): CusInnerApply22[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22] =
      new CusInnerApply22(adtList = v.value, data = data)
  }
  object HelperIOImpl22
      extends PrepareInnerApply22[
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any,
        Any
      ]
  class CusInnerApply22[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22](
    adtList: Core2,
    data: Any
  ) {
    @inline def fold[T](
      func1: I1 => T,
      func2: I2 => T,
      func3: I3 => T,
      func4: I4 => T,
      func5: I5 => T,
      func6: I6 => T,
      func7: I7 => T,
      func8: I8 => T,
      func9: I9 => T,
      func10: I10 => T,
      func11: I11 => T,
      func12: I12 => T,
      func13: I13 => T,
      func14: I14 => T,
      func15: I15 => T,
      func16: I16 => T,
      func17: I17 => T,
      func18: I18 => T,
      func19: I19 => T,
      func20: I20 => T,
      func21: I21 => T,
      func22: I22 => T
    ): T = {
      val result = adtList(() =>
        FoldListAppender.append(
          data,
          func1.asInstanceOf[Any => Any],
          () =>
            FoldListAppender.append(
              data,
              func2.asInstanceOf[Any => Any],
              () =>
                FoldListAppender.append(
                  data,
                  func3.asInstanceOf[Any => Any],
                  () =>
                    FoldListAppender.append(
                      data,
                      func4.asInstanceOf[Any => Any],
                      () =>
                        FoldListAppender.append(
                          data,
                          func5.asInstanceOf[Any => Any],
                          () =>
                            FoldListAppender.append(
                              data,
                              func6.asInstanceOf[Any => Any],
                              () =>
                                FoldListAppender.append(
                                  data,
                                  func7.asInstanceOf[Any => Any],
                                  () =>
                                    FoldListAppender.append(
                                      data,
                                      func8.asInstanceOf[Any => Any],
                                      () =>
                                        FoldListAppender.append(
                                          data,
                                          func9.asInstanceOf[Any => Any],
                                          () =>
                                            FoldListAppender.append(
                                              data,
                                              func10.asInstanceOf[Any => Any],
                                              () =>
                                                FoldListAppender.append(
                                                  data,
                                                  func11.asInstanceOf[Any => Any],
                                                  () =>
                                                    FoldListAppender.append(
                                                      data,
                                                      func12.asInstanceOf[Any => Any],
                                                      () =>
                                                        FoldListAppender.append(
                                                          data,
                                                          func13.asInstanceOf[Any => Any],
                                                          () =>
                                                            FoldListAppender.append(
                                                              data,
                                                              func14.asInstanceOf[Any => Any],
                                                              () =>
                                                                FoldListAppender.append(
                                                                  data,
                                                                  func15.asInstanceOf[Any => Any],
                                                                  () =>
                                                                    FoldListAppender.append(
                                                                      data,
                                                                      func16.asInstanceOf[Any => Any],
                                                                      () =>
                                                                        FoldListAppender.append(
                                                                          data,
                                                                          func17.asInstanceOf[Any => Any],
                                                                          () =>
                                                                            FoldListAppender.append(
                                                                              data,
                                                                              func18.asInstanceOf[Any => Any],
                                                                              () =>
                                                                                FoldListAppender.append(
                                                                                  data,
                                                                                  func19.asInstanceOf[Any => Any],
                                                                                  () =>
                                                                                    FoldListAppender.append(
                                                                                      data,
                                                                                      func20.asInstanceOf[Any => Any],
                                                                                      () =>
                                                                                        FoldListAppender.append(
                                                                                          data,
                                                                                          func21.asInstanceOf[Any => Any],
                                                                                          () =>
                                                                                            FoldListAppender.append(
                                                                                              data,
                                                                                              func22.asInstanceOf[Any => Any],
                                                                                              () => FoldListZero
                                                                                            )
                                                                                        )
                                                                                    )
                                                                                )
                                                                            )
                                                                        )
                                                                    )
                                                                )
                                                            )
                                                        )
                                                    )
                                                )
                                            )
                                        )
                                    )
                                )
                            )
                        )
                    )
                )
            )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.asInstanceOf[TypeAdtGetter].runGetter(result.convert).asInstanceOf[T]
    }
  }

}
