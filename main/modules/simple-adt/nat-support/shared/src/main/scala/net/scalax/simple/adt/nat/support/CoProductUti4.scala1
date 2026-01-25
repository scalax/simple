package net.scalax.simple.adt.nat
package support

trait CoProductUti4[CoLike1, ApCoProduct1[_, _ <: CoLike1] <: CoLike1] {
  CoProductUti4Self =>

  def coproductModelCompat: CoProductFunc[CoLike1, ApCoProduct1]

  def paramSupport[TRU]: Parameter10NatSupport1[
    ({ type Func3[A] = A => Option[TRU] })#Func3,
    ({
      type FuncXM1[A, B, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20] = TRU
    })#FuncXM1,
    CoLike1,
    ApCoProduct1
  ] = new Parameter10NatSupport1[
    ({ type Func3[A] = A => Option[TRU] })#Func3,
    ({
      type FuncXM1[A, B, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20] = TRU
    })#FuncXM1,
    CoLike1,
    ApCoProduct1
  ] {
    final override val content: AppenderNatSupport1[
      ({ type Func3[A] = A => Option[TRU] })#Func3,
      CoLike1,
      ApCoProduct1
    ] = new AppenderNatSupport1[
      ({ type Func3[A] = A => Option[TRU] })#Func3,
      CoLike1,
      ApCoProduct1
    ] {
      final override def append[A, Co1 <: CoLike1](
        p1: A => Option[TRU],
        p2: Co1 => Option[TRU]
      ): ApCoProduct1[A, Co1] => Option[TRU] =
        coproductModelCompat.fold[A, Co1, Option[TRU]]((valueB: A) => p1(valueB), (valueCo2: Co1) => p2(valueCo2))
    }

    final override val typeGen: Type10Gen1[
      ({ type Func3[A] = A => Option[TRU] })#Func3,
      ({
        type FuncXM1[A, B, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20] = TRU
      })#FuncXM1
    ] = new Type10Gen1[
      ({ type Func3[A] = A => Option[TRU] })#Func3,
      ({
        type FuncXM1[A, B, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20] = TRU
      })#FuncXM1
    ] { ItemFuncSelf =>
      final override def gen10[A, B, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20]
        : TRU => Option[TRU] = Some.apply[TRU] _
    }
  }

  def appendSupport[TRU, NItem, Co1 <: CoLike1](
    param1: Co1 => Option[TRU]
  ): ApCoProduct1[TRU, Co1] => Option[TRU] = CoProductUti4Self
    .paramSupport[TRU]
    .append10[NItem, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Co1](
      param1
    )

}
