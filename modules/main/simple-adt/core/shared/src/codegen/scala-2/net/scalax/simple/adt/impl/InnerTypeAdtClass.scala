package net.scalax.simple
package adt
package impl

import core.Core2

object InnerTypeAdtClass {

  class PrepareInnerApply1[I1] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, AdtAlias.AdtAppend[I1, AdtAlias.AdtZero], Adt.Status.Passed]
    ): CusInnerApply1[I1] = new CusInnerApply1(adtList = v.value, data = data)
  }
  object HelperIOImpl1 extends PrepareInnerApply1[Any]
  class CusInnerApply1[I1](adtList: Core2, data: Any) {
    @inline def fold[T](func1: I1 => T): T = {
      val result = adtList(() => FoldListAppender.appendAll(data, List(func1.asInstanceOf[Any => Any]))).asInstanceOf[AdtConvertWrapper]
      result.result.runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply2[I1, I2] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, AdtAlias.AdtAppend[I1, AdtAlias.AdtAppend[I2, AdtAlias.AdtZero]], Adt.Status.Passed]
    ): CusInnerApply2[I1, I2] = new CusInnerApply2(adtList = v.value, data = data)
  }
  object HelperIOImpl2 extends PrepareInnerApply2[Any, Any]
  class CusInnerApply2[I1, I2](adtList: Core2, data: Any) {
    @inline def fold[T](func1: I1 => T, func2: I2 => T): T = {
      val result = adtList(() => FoldListAppender.appendAll(data, List(func1.asInstanceOf[Any => Any], func2.asInstanceOf[Any => Any])))
        .asInstanceOf[AdtConvertWrapper]
      result.result.runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply3[I1, I2, I3] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, AdtAlias.AdtAppend[
        I1,
        AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[I3, AdtAlias.AdtZero]]
      ], Adt.Status.Passed]
    ): CusInnerApply3[I1, I2, I3] = new CusInnerApply3(adtList = v.value, data = data)
  }
  object HelperIOImpl3 extends PrepareInnerApply3[Any, Any, Any]
  class CusInnerApply3[I1, I2, I3](adtList: Core2, data: Any) {
    @inline def fold[T](func1: I1 => T, func2: I2 => T, func3: I3 => T): T = {
      val result = adtList(() =>
        FoldListAppender.appendAll(
          data,
          List(func1.asInstanceOf[Any => Any], func2.asInstanceOf[Any => Any], func3.asInstanceOf[Any => Any])
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply4[I1, I2, I3, I4] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, AdtAlias.AdtAppend[
        I1,
        AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[I3, AdtAlias.AdtAppend[I4, AdtAlias.AdtZero]]]
      ], Adt.Status.Passed]
    ): CusInnerApply4[I1, I2, I3, I4] = new CusInnerApply4(adtList = v.value, data = data)
  }
  object HelperIOImpl4 extends PrepareInnerApply4[Any, Any, Any, Any]
  class CusInnerApply4[I1, I2, I3, I4](adtList: Core2, data: Any) {
    @inline def fold[T](func1: I1 => T, func2: I2 => T, func3: I3 => T, func4: I4 => T): T = {
      val result = adtList(() =>
        FoldListAppender.appendAll(
          data,
          List(
            func1.asInstanceOf[Any => Any],
            func2.asInstanceOf[Any => Any],
            func3.asInstanceOf[Any => Any],
            func4.asInstanceOf[Any => Any]
          )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply5[I1, I2, I3, I4, I5] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, AdtAlias.AdtAppend[
        I1,
        AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[I3, AdtAlias.AdtAppend[I4, AdtAlias.AdtAppend[I5, AdtAlias.AdtZero]]]]
      ], Adt.Status.Passed]
    ): CusInnerApply5[I1, I2, I3, I4, I5] = new CusInnerApply5(adtList = v.value, data = data)
  }
  object HelperIOImpl5 extends PrepareInnerApply5[Any, Any, Any, Any, Any]
  class CusInnerApply5[I1, I2, I3, I4, I5](adtList: Core2, data: Any) {
    @inline def fold[T](func1: I1 => T, func2: I2 => T, func3: I3 => T, func4: I4 => T, func5: I5 => T): T = {
      val result = adtList(() =>
        FoldListAppender.appendAll(
          data,
          List(
            func1.asInstanceOf[Any => Any],
            func2.asInstanceOf[Any => Any],
            func3.asInstanceOf[Any => Any],
            func4.asInstanceOf[Any => Any],
            func5.asInstanceOf[Any => Any]
          )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply6[I1, I2, I3, I4, I5, I6] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, AdtAlias.AdtAppend[I1, AdtAlias.AdtAppend[
        I2,
        AdtAlias.AdtAppend[I3, AdtAlias.AdtAppend[I4, AdtAlias.AdtAppend[I5, AdtAlias.AdtAppend[I6, AdtAlias.AdtZero]]]]
      ]], Adt.Status.Passed]
    ): CusInnerApply6[I1, I2, I3, I4, I5, I6] = new CusInnerApply6(adtList = v.value, data = data)
  }
  object HelperIOImpl6 extends PrepareInnerApply6[Any, Any, Any, Any, Any, Any]
  class CusInnerApply6[I1, I2, I3, I4, I5, I6](adtList: Core2, data: Any) {
    @inline def fold[T](func1: I1 => T, func2: I2 => T, func3: I3 => T, func4: I4 => T, func5: I5 => T, func6: I6 => T): T = {
      val result = adtList(() =>
        FoldListAppender.appendAll(
          data,
          List(
            func1.asInstanceOf[Any => Any],
            func2.asInstanceOf[Any => Any],
            func3.asInstanceOf[Any => Any],
            func4.asInstanceOf[Any => Any],
            func5.asInstanceOf[Any => Any],
            func6.asInstanceOf[Any => Any]
          )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply7[I1, I2, I3, I4, I5, I6, I7] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, AdtAlias.AdtAppend[I1, AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[
        I3,
        AdtAlias.AdtAppend[I4, AdtAlias.AdtAppend[I5, AdtAlias.AdtAppend[I6, AdtAlias.AdtAppend[I7, AdtAlias.AdtZero]]]]
      ]]], Adt.Status.Passed]
    ): CusInnerApply7[I1, I2, I3, I4, I5, I6, I7] = new CusInnerApply7(adtList = v.value, data = data)
  }
  object HelperIOImpl7 extends PrepareInnerApply7[Any, Any, Any, Any, Any, Any, Any]
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
        FoldListAppender.appendAll(
          data,
          List(
            func1.asInstanceOf[Any => Any],
            func2.asInstanceOf[Any => Any],
            func3.asInstanceOf[Any => Any],
            func4.asInstanceOf[Any => Any],
            func5.asInstanceOf[Any => Any],
            func6.asInstanceOf[Any => Any],
            func7.asInstanceOf[Any => Any]
          )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply8[I1, I2, I3, I4, I5, I6, I7, I8] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, AdtAlias.AdtAppend[I1, AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[I3, AdtAlias.AdtAppend[
        I4,
        AdtAlias.AdtAppend[I5, AdtAlias.AdtAppend[I6, AdtAlias.AdtAppend[I7, AdtAlias.AdtAppend[I8, AdtAlias.AdtZero]]]]
      ]]]], Adt.Status.Passed]
    ): CusInnerApply8[I1, I2, I3, I4, I5, I6, I7, I8] = new CusInnerApply8(adtList = v.value, data = data)
  }
  object HelperIOImpl8 extends PrepareInnerApply8[Any, Any, Any, Any, Any, Any, Any, Any]
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
        FoldListAppender.appendAll(
          data,
          List(
            func1.asInstanceOf[Any => Any],
            func2.asInstanceOf[Any => Any],
            func3.asInstanceOf[Any => Any],
            func4.asInstanceOf[Any => Any],
            func5.asInstanceOf[Any => Any],
            func6.asInstanceOf[Any => Any],
            func7.asInstanceOf[Any => Any],
            func8.asInstanceOf[Any => Any]
          )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply9[I1, I2, I3, I4, I5, I6, I7, I8, I9] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, AdtAlias.AdtAppend[
        I1,
        AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[I3, AdtAlias.AdtAppend[I4, AdtAlias.AdtAppend[
          I5,
          AdtAlias.AdtAppend[I6, AdtAlias.AdtAppend[I7, AdtAlias.AdtAppend[I8, AdtAlias.AdtAppend[I9, AdtAlias.AdtZero]]]]
        ]]]]
      ], Adt.Status.Passed]
    ): CusInnerApply9[I1, I2, I3, I4, I5, I6, I7, I8, I9] = new CusInnerApply9(adtList = v.value, data = data)
  }
  object HelperIOImpl9 extends PrepareInnerApply9[Any, Any, Any, Any, Any, Any, Any, Any, Any]
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
        FoldListAppender.appendAll(
          data,
          List(
            func1.asInstanceOf[Any => Any],
            func2.asInstanceOf[Any => Any],
            func3.asInstanceOf[Any => Any],
            func4.asInstanceOf[Any => Any],
            func5.asInstanceOf[Any => Any],
            func6.asInstanceOf[Any => Any],
            func7.asInstanceOf[Any => Any],
            func8.asInstanceOf[Any => Any],
            func9.asInstanceOf[Any => Any]
          )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply10[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, AdtAlias.AdtAppend[
        I1,
        AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[I3, AdtAlias.AdtAppend[I4, AdtAlias.AdtAppend[I5, AdtAlias.AdtAppend[
          I6,
          AdtAlias.AdtAppend[I7, AdtAlias.AdtAppend[I8, AdtAlias.AdtAppend[I9, AdtAlias.AdtAppend[I10, AdtAlias.AdtZero]]]]
        ]]]]]
      ], Adt.Status.Passed]
    ): CusInnerApply10[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] = new CusInnerApply10(adtList = v.value, data = data)
  }
  object HelperIOImpl10 extends PrepareInnerApply10[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]
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
        FoldListAppender.appendAll(
          data,
          List(
            func1.asInstanceOf[Any => Any],
            func2.asInstanceOf[Any => Any],
            func3.asInstanceOf[Any => Any],
            func4.asInstanceOf[Any => Any],
            func5.asInstanceOf[Any => Any],
            func6.asInstanceOf[Any => Any],
            func7.asInstanceOf[Any => Any],
            func8.asInstanceOf[Any => Any],
            func9.asInstanceOf[Any => Any],
            func10.asInstanceOf[Any => Any]
          )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply11[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, AdtAlias.AdtAppend[I1, AdtAlias.AdtAppend[
        I2,
        AdtAlias.AdtAppend[I3, AdtAlias.AdtAppend[I4, AdtAlias.AdtAppend[I5, AdtAlias.AdtAppend[I6, AdtAlias.AdtAppend[
          I7,
          AdtAlias.AdtAppend[I8, AdtAlias.AdtAppend[I9, AdtAlias.AdtAppend[I10, AdtAlias.AdtAppend[I11, AdtAlias.AdtZero]]]]
        ]]]]]
      ]], Adt.Status.Passed]
    ): CusInnerApply11[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] = new CusInnerApply11(adtList = v.value, data = data)
  }
  object HelperIOImpl11 extends PrepareInnerApply11[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]
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
        FoldListAppender.appendAll(
          data,
          List(
            func1.asInstanceOf[Any => Any],
            func2.asInstanceOf[Any => Any],
            func3.asInstanceOf[Any => Any],
            func4.asInstanceOf[Any => Any],
            func5.asInstanceOf[Any => Any],
            func6.asInstanceOf[Any => Any],
            func7.asInstanceOf[Any => Any],
            func8.asInstanceOf[Any => Any],
            func9.asInstanceOf[Any => Any],
            func10.asInstanceOf[Any => Any],
            func11.asInstanceOf[Any => Any]
          )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply12[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, AdtAlias.AdtAppend[I1, AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[
        I3,
        AdtAlias.AdtAppend[I4, AdtAlias.AdtAppend[I5, AdtAlias.AdtAppend[I6, AdtAlias.AdtAppend[I7, AdtAlias.AdtAppend[
          I8,
          AdtAlias.AdtAppend[I9, AdtAlias.AdtAppend[I10, AdtAlias.AdtAppend[I11, AdtAlias.AdtAppend[I12, AdtAlias.AdtZero]]]]
        ]]]]]
      ]]], Adt.Status.Passed]
    ): CusInnerApply12[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] = new CusInnerApply12(adtList = v.value, data = data)
  }
  object HelperIOImpl12 extends PrepareInnerApply12[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]
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
        FoldListAppender.appendAll(
          data,
          List(
            func1.asInstanceOf[Any => Any],
            func2.asInstanceOf[Any => Any],
            func3.asInstanceOf[Any => Any],
            func4.asInstanceOf[Any => Any],
            func5.asInstanceOf[Any => Any],
            func6.asInstanceOf[Any => Any],
            func7.asInstanceOf[Any => Any],
            func8.asInstanceOf[Any => Any],
            func9.asInstanceOf[Any => Any],
            func10.asInstanceOf[Any => Any],
            func11.asInstanceOf[Any => Any],
            func12.asInstanceOf[Any => Any]
          )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply13[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, AdtAlias.AdtAppend[I1, AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[I3, AdtAlias.AdtAppend[
        I4,
        AdtAlias.AdtAppend[I5, AdtAlias.AdtAppend[I6, AdtAlias.AdtAppend[I7, AdtAlias.AdtAppend[I8, AdtAlias.AdtAppend[
          I9,
          AdtAlias.AdtAppend[I10, AdtAlias.AdtAppend[I11, AdtAlias.AdtAppend[I12, AdtAlias.AdtAppend[I13, AdtAlias.AdtZero]]]]
        ]]]]]
      ]]]], Adt.Status.Passed]
    ): CusInnerApply13[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] = new CusInnerApply13(adtList = v.value, data = data)
  }
  object HelperIOImpl13 extends PrepareInnerApply13[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]
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
        FoldListAppender.appendAll(
          data,
          List(
            func1.asInstanceOf[Any => Any],
            func2.asInstanceOf[Any => Any],
            func3.asInstanceOf[Any => Any],
            func4.asInstanceOf[Any => Any],
            func5.asInstanceOf[Any => Any],
            func6.asInstanceOf[Any => Any],
            func7.asInstanceOf[Any => Any],
            func8.asInstanceOf[Any => Any],
            func9.asInstanceOf[Any => Any],
            func10.asInstanceOf[Any => Any],
            func11.asInstanceOf[Any => Any],
            func12.asInstanceOf[Any => Any],
            func13.asInstanceOf[Any => Any]
          )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply14[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, AdtAlias.AdtAppend[
        I1,
        AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[I3, AdtAlias.AdtAppend[I4, AdtAlias.AdtAppend[
          I5,
          AdtAlias.AdtAppend[I6, AdtAlias.AdtAppend[I7, AdtAlias.AdtAppend[I8, AdtAlias.AdtAppend[I9, AdtAlias.AdtAppend[
            I10,
            AdtAlias.AdtAppend[I11, AdtAlias.AdtAppend[I12, AdtAlias.AdtAppend[I13, AdtAlias.AdtAppend[I14, AdtAlias.AdtZero]]]]
          ]]]]]
        ]]]]
      ], Adt.Status.Passed]
    ): CusInnerApply14[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] = new CusInnerApply14(adtList = v.value, data = data)
  }
  object HelperIOImpl14 extends PrepareInnerApply14[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]
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
        FoldListAppender.appendAll(
          data,
          List(
            func1.asInstanceOf[Any => Any],
            func2.asInstanceOf[Any => Any],
            func3.asInstanceOf[Any => Any],
            func4.asInstanceOf[Any => Any],
            func5.asInstanceOf[Any => Any],
            func6.asInstanceOf[Any => Any],
            func7.asInstanceOf[Any => Any],
            func8.asInstanceOf[Any => Any],
            func9.asInstanceOf[Any => Any],
            func10.asInstanceOf[Any => Any],
            func11.asInstanceOf[Any => Any],
            func12.asInstanceOf[Any => Any],
            func13.asInstanceOf[Any => Any],
            func14.asInstanceOf[Any => Any]
          )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply15[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, AdtAlias.AdtAppend[
        I1,
        AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[I3, AdtAlias.AdtAppend[I4, AdtAlias.AdtAppend[I5, AdtAlias.AdtAppend[
          I6,
          AdtAlias.AdtAppend[I7, AdtAlias.AdtAppend[I8, AdtAlias.AdtAppend[I9, AdtAlias.AdtAppend[I10, AdtAlias.AdtAppend[
            I11,
            AdtAlias.AdtAppend[I12, AdtAlias.AdtAppend[I13, AdtAlias.AdtAppend[I14, AdtAlias.AdtAppend[I15, AdtAlias.AdtZero]]]]
          ]]]]]
        ]]]]]
      ], Adt.Status.Passed]
    ): CusInnerApply15[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] =
      new CusInnerApply15(adtList = v.value, data = data)
  }
  object HelperIOImpl15 extends PrepareInnerApply15[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]
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
        FoldListAppender.appendAll(
          data,
          List(
            func1.asInstanceOf[Any => Any],
            func2.asInstanceOf[Any => Any],
            func3.asInstanceOf[Any => Any],
            func4.asInstanceOf[Any => Any],
            func5.asInstanceOf[Any => Any],
            func6.asInstanceOf[Any => Any],
            func7.asInstanceOf[Any => Any],
            func8.asInstanceOf[Any => Any],
            func9.asInstanceOf[Any => Any],
            func10.asInstanceOf[Any => Any],
            func11.asInstanceOf[Any => Any],
            func12.asInstanceOf[Any => Any],
            func13.asInstanceOf[Any => Any],
            func14.asInstanceOf[Any => Any],
            func15.asInstanceOf[Any => Any]
          )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply16[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, AdtAlias.AdtAppend[I1, AdtAlias.AdtAppend[
        I2,
        AdtAlias.AdtAppend[I3, AdtAlias.AdtAppend[I4, AdtAlias.AdtAppend[I5, AdtAlias.AdtAppend[I6, AdtAlias.AdtAppend[
          I7,
          AdtAlias.AdtAppend[I8, AdtAlias.AdtAppend[I9, AdtAlias.AdtAppend[I10, AdtAlias.AdtAppend[I11, AdtAlias.AdtAppend[
            I12,
            AdtAlias.AdtAppend[I13, AdtAlias.AdtAppend[I14, AdtAlias.AdtAppend[I15, AdtAlias.AdtAppend[I16, AdtAlias.AdtZero]]]]
          ]]]]]
        ]]]]]
      ]], Adt.Status.Passed]
    ): CusInnerApply16[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] =
      new CusInnerApply16(adtList = v.value, data = data)
  }
  object HelperIOImpl16 extends PrepareInnerApply16[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]
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
        FoldListAppender.appendAll(
          data,
          List(
            func1.asInstanceOf[Any => Any],
            func2.asInstanceOf[Any => Any],
            func3.asInstanceOf[Any => Any],
            func4.asInstanceOf[Any => Any],
            func5.asInstanceOf[Any => Any],
            func6.asInstanceOf[Any => Any],
            func7.asInstanceOf[Any => Any],
            func8.asInstanceOf[Any => Any],
            func9.asInstanceOf[Any => Any],
            func10.asInstanceOf[Any => Any],
            func11.asInstanceOf[Any => Any],
            func12.asInstanceOf[Any => Any],
            func13.asInstanceOf[Any => Any],
            func14.asInstanceOf[Any => Any],
            func15.asInstanceOf[Any => Any],
            func16.asInstanceOf[Any => Any]
          )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply17[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, AdtAlias.AdtAppend[I1, AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[
        I3,
        AdtAlias.AdtAppend[I4, AdtAlias.AdtAppend[I5, AdtAlias.AdtAppend[I6, AdtAlias.AdtAppend[I7, AdtAlias.AdtAppend[
          I8,
          AdtAlias.AdtAppend[I9, AdtAlias.AdtAppend[I10, AdtAlias.AdtAppend[I11, AdtAlias.AdtAppend[I12, AdtAlias.AdtAppend[
            I13,
            AdtAlias.AdtAppend[I14, AdtAlias.AdtAppend[I15, AdtAlias.AdtAppend[I16, AdtAlias.AdtAppend[I17, AdtAlias.AdtZero]]]]
          ]]]]]
        ]]]]]
      ]]], Adt.Status.Passed]
    ): CusInnerApply17[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] =
      new CusInnerApply17(adtList = v.value, data = data)
  }
  object HelperIOImpl17 extends PrepareInnerApply17[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]
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
        FoldListAppender.appendAll(
          data,
          List(
            func1.asInstanceOf[Any => Any],
            func2.asInstanceOf[Any => Any],
            func3.asInstanceOf[Any => Any],
            func4.asInstanceOf[Any => Any],
            func5.asInstanceOf[Any => Any],
            func6.asInstanceOf[Any => Any],
            func7.asInstanceOf[Any => Any],
            func8.asInstanceOf[Any => Any],
            func9.asInstanceOf[Any => Any],
            func10.asInstanceOf[Any => Any],
            func11.asInstanceOf[Any => Any],
            func12.asInstanceOf[Any => Any],
            func13.asInstanceOf[Any => Any],
            func14.asInstanceOf[Any => Any],
            func15.asInstanceOf[Any => Any],
            func16.asInstanceOf[Any => Any],
            func17.asInstanceOf[Any => Any]
          )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply18[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, AdtAlias.AdtAppend[I1, AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[I3, AdtAlias.AdtAppend[
        I4,
        AdtAlias.AdtAppend[I5, AdtAlias.AdtAppend[I6, AdtAlias.AdtAppend[I7, AdtAlias.AdtAppend[I8, AdtAlias.AdtAppend[
          I9,
          AdtAlias.AdtAppend[I10, AdtAlias.AdtAppend[I11, AdtAlias.AdtAppend[I12, AdtAlias.AdtAppend[I13, AdtAlias.AdtAppend[
            I14,
            AdtAlias.AdtAppend[I15, AdtAlias.AdtAppend[I16, AdtAlias.AdtAppend[I17, AdtAlias.AdtAppend[I18, AdtAlias.AdtZero]]]]
          ]]]]]
        ]]]]]
      ]]]], Adt.Status.Passed]
    ): CusInnerApply18[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] =
      new CusInnerApply18(adtList = v.value, data = data)
  }
  object HelperIOImpl18
      extends PrepareInnerApply18[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]
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
        FoldListAppender.appendAll(
          data,
          List(
            func1.asInstanceOf[Any => Any],
            func2.asInstanceOf[Any => Any],
            func3.asInstanceOf[Any => Any],
            func4.asInstanceOf[Any => Any],
            func5.asInstanceOf[Any => Any],
            func6.asInstanceOf[Any => Any],
            func7.asInstanceOf[Any => Any],
            func8.asInstanceOf[Any => Any],
            func9.asInstanceOf[Any => Any],
            func10.asInstanceOf[Any => Any],
            func11.asInstanceOf[Any => Any],
            func12.asInstanceOf[Any => Any],
            func13.asInstanceOf[Any => Any],
            func14.asInstanceOf[Any => Any],
            func15.asInstanceOf[Any => Any],
            func16.asInstanceOf[Any => Any],
            func17.asInstanceOf[Any => Any],
            func18.asInstanceOf[Any => Any]
          )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply19[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, AdtAlias.AdtAppend[
        I1,
        AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[I3, AdtAlias.AdtAppend[I4, AdtAlias.AdtAppend[
          I5,
          AdtAlias.AdtAppend[I6, AdtAlias.AdtAppend[I7, AdtAlias.AdtAppend[I8, AdtAlias.AdtAppend[I9, AdtAlias.AdtAppend[
            I10,
            AdtAlias.AdtAppend[I11, AdtAlias.AdtAppend[I12, AdtAlias.AdtAppend[I13, AdtAlias.AdtAppend[I14, AdtAlias.AdtAppend[
              I15,
              AdtAlias.AdtAppend[I16, AdtAlias.AdtAppend[I17, AdtAlias.AdtAppend[I18, AdtAlias.AdtAppend[I19, AdtAlias.AdtZero]]]]
            ]]]]]
          ]]]]]
        ]]]]
      ], Adt.Status.Passed]
    ): CusInnerApply19[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] =
      new CusInnerApply19(adtList = v.value, data = data)
  }
  object HelperIOImpl19
      extends PrepareInnerApply19[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]
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
        FoldListAppender.appendAll(
          data,
          List(
            func1.asInstanceOf[Any => Any],
            func2.asInstanceOf[Any => Any],
            func3.asInstanceOf[Any => Any],
            func4.asInstanceOf[Any => Any],
            func5.asInstanceOf[Any => Any],
            func6.asInstanceOf[Any => Any],
            func7.asInstanceOf[Any => Any],
            func8.asInstanceOf[Any => Any],
            func9.asInstanceOf[Any => Any],
            func10.asInstanceOf[Any => Any],
            func11.asInstanceOf[Any => Any],
            func12.asInstanceOf[Any => Any],
            func13.asInstanceOf[Any => Any],
            func14.asInstanceOf[Any => Any],
            func15.asInstanceOf[Any => Any],
            func16.asInstanceOf[Any => Any],
            func17.asInstanceOf[Any => Any],
            func18.asInstanceOf[Any => Any],
            func19.asInstanceOf[Any => Any]
          )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply20[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, AdtAlias.AdtAppend[
        I1,
        AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[I3, AdtAlias.AdtAppend[I4, AdtAlias.AdtAppend[I5, AdtAlias.AdtAppend[
          I6,
          AdtAlias.AdtAppend[I7, AdtAlias.AdtAppend[I8, AdtAlias.AdtAppend[I9, AdtAlias.AdtAppend[I10, AdtAlias.AdtAppend[
            I11,
            AdtAlias.AdtAppend[I12, AdtAlias.AdtAppend[I13, AdtAlias.AdtAppend[I14, AdtAlias.AdtAppend[I15, AdtAlias.AdtAppend[
              I16,
              AdtAlias.AdtAppend[I17, AdtAlias.AdtAppend[I18, AdtAlias.AdtAppend[I19, AdtAlias.AdtAppend[I20, AdtAlias.AdtZero]]]]
            ]]]]]
          ]]]]]
        ]]]]]
      ], Adt.Status.Passed]
    ): CusInnerApply20[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] =
      new CusInnerApply20(adtList = v.value, data = data)
  }
  object HelperIOImpl20
      extends PrepareInnerApply20[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]
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
        FoldListAppender.appendAll(
          data,
          List(
            func1.asInstanceOf[Any => Any],
            func2.asInstanceOf[Any => Any],
            func3.asInstanceOf[Any => Any],
            func4.asInstanceOf[Any => Any],
            func5.asInstanceOf[Any => Any],
            func6.asInstanceOf[Any => Any],
            func7.asInstanceOf[Any => Any],
            func8.asInstanceOf[Any => Any],
            func9.asInstanceOf[Any => Any],
            func10.asInstanceOf[Any => Any],
            func11.asInstanceOf[Any => Any],
            func12.asInstanceOf[Any => Any],
            func13.asInstanceOf[Any => Any],
            func14.asInstanceOf[Any => Any],
            func15.asInstanceOf[Any => Any],
            func16.asInstanceOf[Any => Any],
            func17.asInstanceOf[Any => Any],
            func18.asInstanceOf[Any => Any],
            func19.asInstanceOf[Any => Any],
            func20.asInstanceOf[Any => Any]
          )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply21[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, AdtAlias.AdtAppend[I1, AdtAlias.AdtAppend[
        I2,
        AdtAlias.AdtAppend[I3, AdtAlias.AdtAppend[I4, AdtAlias.AdtAppend[I5, AdtAlias.AdtAppend[I6, AdtAlias.AdtAppend[
          I7,
          AdtAlias.AdtAppend[I8, AdtAlias.AdtAppend[I9, AdtAlias.AdtAppend[I10, AdtAlias.AdtAppend[I11, AdtAlias.AdtAppend[
            I12,
            AdtAlias.AdtAppend[I13, AdtAlias.AdtAppend[I14, AdtAlias.AdtAppend[I15, AdtAlias.AdtAppend[I16, AdtAlias.AdtAppend[
              I17,
              AdtAlias.AdtAppend[I18, AdtAlias.AdtAppend[I19, AdtAlias.AdtAppend[I20, AdtAlias.AdtAppend[I21, AdtAlias.AdtZero]]]]
            ]]]]]
          ]]]]]
        ]]]]]
      ]], Adt.Status.Passed]
    ): CusInnerApply21[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] =
      new CusInnerApply21(adtList = v.value, data = data)
  }
  object HelperIOImpl21
      extends PrepareInnerApply21[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]
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
        FoldListAppender.appendAll(
          data,
          List(
            func1.asInstanceOf[Any => Any],
            func2.asInstanceOf[Any => Any],
            func3.asInstanceOf[Any => Any],
            func4.asInstanceOf[Any => Any],
            func5.asInstanceOf[Any => Any],
            func6.asInstanceOf[Any => Any],
            func7.asInstanceOf[Any => Any],
            func8.asInstanceOf[Any => Any],
            func9.asInstanceOf[Any => Any],
            func10.asInstanceOf[Any => Any],
            func11.asInstanceOf[Any => Any],
            func12.asInstanceOf[Any => Any],
            func13.asInstanceOf[Any => Any],
            func14.asInstanceOf[Any => Any],
            func15.asInstanceOf[Any => Any],
            func16.asInstanceOf[Any => Any],
            func17.asInstanceOf[Any => Any],
            func18.asInstanceOf[Any => Any],
            func19.asInstanceOf[Any => Any],
            func20.asInstanceOf[Any => Any],
            func21.asInstanceOf[Any => Any]
          )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.runGetter(result.convert).asInstanceOf[T]
    }
  }

  class PrepareInnerApply22[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, AdtAlias.AdtAppend[I1, AdtAlias.AdtAppend[I2, AdtAlias.AdtAppend[
        I3,
        AdtAlias.AdtAppend[I4, AdtAlias.AdtAppend[I5, AdtAlias.AdtAppend[I6, AdtAlias.AdtAppend[I7, AdtAlias.AdtAppend[
          I8,
          AdtAlias.AdtAppend[I9, AdtAlias.AdtAppend[I10, AdtAlias.AdtAppend[I11, AdtAlias.AdtAppend[I12, AdtAlias.AdtAppend[
            I13,
            AdtAlias.AdtAppend[I14, AdtAlias.AdtAppend[I15, AdtAlias.AdtAppend[I16, AdtAlias.AdtAppend[I17, AdtAlias.AdtAppend[
              I18,
              AdtAlias.AdtAppend[I19, AdtAlias.AdtAppend[I20, AdtAlias.AdtAppend[I21, AdtAlias.AdtAppend[I22, AdtAlias.AdtZero]]]]
            ]]]]]
          ]]]]]
        ]]]]]
      ]]], Adt.Status.Passed]
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
        FoldListAppender.appendAll(
          data,
          List(
            func1.asInstanceOf[Any => Any],
            func2.asInstanceOf[Any => Any],
            func3.asInstanceOf[Any => Any],
            func4.asInstanceOf[Any => Any],
            func5.asInstanceOf[Any => Any],
            func6.asInstanceOf[Any => Any],
            func7.asInstanceOf[Any => Any],
            func8.asInstanceOf[Any => Any],
            func9.asInstanceOf[Any => Any],
            func10.asInstanceOf[Any => Any],
            func11.asInstanceOf[Any => Any],
            func12.asInstanceOf[Any => Any],
            func13.asInstanceOf[Any => Any],
            func14.asInstanceOf[Any => Any],
            func15.asInstanceOf[Any => Any],
            func16.asInstanceOf[Any => Any],
            func17.asInstanceOf[Any => Any],
            func18.asInstanceOf[Any => Any],
            func19.asInstanceOf[Any => Any],
            func20.asInstanceOf[Any => Any],
            func21.asInstanceOf[Any => Any],
            func22.asInstanceOf[Any => Any]
          )
        )
      ).asInstanceOf[AdtConvertWrapper]
      result.result.runGetter(result.convert).asInstanceOf[T]
    }
  }

}
