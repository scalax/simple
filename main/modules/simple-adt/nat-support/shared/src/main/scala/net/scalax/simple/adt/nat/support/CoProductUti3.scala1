package net.scalax.simple.adt.nat.support

trait FoldCoProductUtilN[CoLike1, ApCoProduct1[_, _ <: CoLike1] <: CoLike1, CoLike2, ApCoProduct2[_, _ <: CoLike2] <: CoLike2] {
  FoldCoProductUtilNSelf =>

  def hlistModelCompat: HListFunc[CoLike1, ApCoProduct1]
  def coproductModelCompat: CoProductFunc[CoLike2, ApCoProduct2]

  def paramSupport[TRU]: Parameter10NatSupport2[
    ({ type Func3[A, B] = A => B => Option[TRU] })#Func3,
    ({
      type FuncXM1[A, B, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20] = A => TRU
    })#FuncXM1,
    ({
      type FuncXM1[A, B, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20] = A
    })#FuncXM1,
    CoLike1,
    CoLike2,
    ApCoProduct1,
    ApCoProduct2
  ] = new Parameter10NatSupport2[
    ({ type Func3[A, B] = A => B => Option[TRU] })#Func3,
    ({
      type FuncXM1[A, B, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20] = A => TRU
    })#FuncXM1,
    ({
      type FuncXM1[A, B, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20] = A
    })#FuncXM1,
    CoLike1,
    CoLike2,
    ApCoProduct1,
    ApCoProduct2
  ] {
    final override val content: AppenderNatSupport2[
      ({ type Func3[A, B] = A => B => Option[TRU] })#Func3,
      CoLike1,
      CoLike2,
      ApCoProduct1,
      ApCoProduct2
    ] = new AppenderNatSupport2[
      ({ type Func3[A, B] = A => B => Option[TRU] })#Func3,
      CoLike1,
      CoLike2,
      ApCoProduct1,
      ApCoProduct2
    ] {
      final override def append[A, B, Co1 <: CoLike1, Co2 <: CoLike2](
        p1: A => B => Option[TRU],
        p2: Co1 => Co2 => Option[TRU]
      ): ApCoProduct1[A, Co1] => ApCoProduct2[B, Co2] => Option[TRU] = (a1: ApCoProduct1[A, Co1]) => {
        val valueA: A     = hlistModelCompat.takeHead[A, Co1](a1)
        val valueCo1: Co1 = hlistModelCompat.takeTail[A, Co1](a1)

        coproductModelCompat.fold[B, Co2, Option[TRU]]((valueB: B) => p1(valueA)(valueB), (valueCo2: Co2) => p2(valueCo1)(valueCo2))
      }
    }

    final override val typeGen: Type10Gen2[
      ({ type Func3[A, B] = A => B => Option[TRU] })#Func3,
      ({
        type FuncXM1[A, B, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20] = A => TRU
      })#FuncXM1,
      ({
        type FuncXM1[A, B, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20] = A
      })#FuncXM1
    ] = new Type10Gen2[
      ({ type Func3[A, B] = A => B => Option[TRU] })#Func3,
      ({
        type FuncXM1[A, B, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20] = A => TRU
      })#FuncXM1,
      ({
        type FuncXM1[A, B, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20] = A
      })#FuncXM1
    ] { ItemFuncSelf =>
      final override def gen10[A, B, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20]
        : (A => TRU) => A => Option[TRU] = (f: (A => TRU)) => f.andThen(Some.apply)
    }
  }

  def appendSupport[TRU, NItem, Co1 <: CoLike1, Co2 <: CoLike2](
    param1: Co1 => Co2 => Option[TRU]
  ): ApCoProduct1[NItem => TRU, Co1] => ApCoProduct2[NItem, Co2] => Option[TRU] = FoldCoProductUtilNSelf
    .paramSupport[TRU]
    .append10[NItem, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Co1, Co2](
      param1
    )

}
