package net.scalax.simple.adt
package impl

import implemention._

trait FoldNatPositiveHelper {

  class FoldNatPositiveHelperWrap1[T1](override val dataInstance: Option[T1], override val tail: NatFuncZero)
      extends NatFuncPositive[T1, NatFuncZero](dataInstance) {
    def foldOpt[U](func1: T1 => U): Option[U] = {
      FoldContext.empty.overrideOnce(this)(func1).option
    }
    def fold[U](func1: T1 => U): U = foldOpt(func1).get
  }

  class FoldNatPositiveHelperWrap2[T1, T2](override val dataInstance: Option[T1], override val tail: NatFuncPositive[T2, NatFuncZero])
      extends NatFuncPositive[T1, NatFuncPositive[T2, NatFuncZero]](dataInstance) {
    def foldOpt[U](func1: T1 => U, func2: T2 => U): Option[U] = {
      FoldContext.empty.overrideOnce(this)(func1).overrideOnce(this.tail)(func2).option
    }
    def fold[U](func1: T1 => U, func2: T2 => U): U = foldOpt(func1, func2).get
  }

  class FoldNatPositiveHelperWrap3[T1, T2, T3](
    override val dataInstance: Option[T1],
    override val tail: NatFuncPositive[T2, NatFuncPositive[T3, NatFuncZero]]
  ) extends NatFuncPositive[T1, NatFuncPositive[T2, NatFuncPositive[T3, NatFuncZero]]](dataInstance) {
    def foldOpt[U](func1: T1 => U, func2: T2 => U, func3: T3 => U): Option[U] = {
      FoldContext.empty.overrideOnce(this)(func1).overrideOnce(this.tail)(func2).overrideOnce(this.tail.tail)(func3).option
    }
    def fold[U](func1: T1 => U, func2: T2 => U, func3: T3 => U): U = foldOpt(func1, func2, func3).get
  }

  class FoldNatPositiveHelperWrap4[T1, T2, T3, T4](
    override val dataInstance: Option[T1],
    override val tail: NatFuncPositive[T2, NatFuncPositive[T3, NatFuncPositive[T4, NatFuncZero]]]
  ) extends NatFuncPositive[T1, NatFuncPositive[T2, NatFuncPositive[T3, NatFuncPositive[T4, NatFuncZero]]]](dataInstance) {
    def foldOpt[U](func1: T1 => U, func2: T2 => U, func3: T3 => U, func4: T4 => U): Option[U] = {
      FoldContext.empty
        .overrideOnce(this)(func1)
        .overrideOnce(this.tail)(func2)
        .overrideOnce(this.tail.tail)(func3)
        .overrideOnce(this.tail.tail.tail)(func4)
        .option
    }
    def fold[U](func1: T1 => U, func2: T2 => U, func3: T3 => U, func4: T4 => U): U = foldOpt(func1, func2, func3, func4).get
  }

  class FoldNatPositiveHelperWrap5[T1, T2, T3, T4, T5](
    override val dataInstance: Option[T1],
    override val tail: NatFuncPositive[T2, NatFuncPositive[T3, NatFuncPositive[T4, NatFuncPositive[T5, NatFuncZero]]]]
  ) extends NatFuncPositive[T1, NatFuncPositive[T2, NatFuncPositive[T3, NatFuncPositive[T4, NatFuncPositive[T5, NatFuncZero]]]]](
        dataInstance
      ) {
    def foldOpt[U](func1: T1 => U, func2: T2 => U, func3: T3 => U, func4: T4 => U, func5: T5 => U): Option[U] = {
      FoldContext.empty
        .overrideOnce(this)(func1)
        .overrideOnce(this.tail)(func2)
        .overrideOnce(this.tail.tail)(func3)
        .overrideOnce(this.tail.tail.tail)(func4)
        .overrideOnce(this.tail.tail.tail.tail)(func5)
        .option
    }
    def fold[U](func1: T1 => U, func2: T2 => U, func3: T3 => U, func4: T4 => U, func5: T5 => U): U =
      foldOpt(func1, func2, func3, func4, func5).get
  }

  class FoldNatPositiveHelperWrap6[T1, T2, T3, T4, T5, T6](
    override val dataInstance: Option[T1],
    override val tail: NatFuncPositive[T2, NatFuncPositive[T3, NatFuncPositive[T4, NatFuncPositive[T5, NatFuncPositive[T6, NatFuncZero]]]]]
  ) extends NatFuncPositive[
        T1,
        NatFuncPositive[T2, NatFuncPositive[T3, NatFuncPositive[T4, NatFuncPositive[T5, NatFuncPositive[T6, NatFuncZero]]]]]
      ](dataInstance) {
    def foldOpt[U](func1: T1 => U, func2: T2 => U, func3: T3 => U, func4: T4 => U, func5: T5 => U, func6: T6 => U): Option[U] = {
      FoldContext.empty
        .overrideOnce(this)(func1)
        .overrideOnce(this.tail)(func2)
        .overrideOnce(this.tail.tail)(func3)
        .overrideOnce(this.tail.tail.tail)(func4)
        .overrideOnce(this.tail.tail.tail.tail)(func5)
        .overrideOnce(this.tail.tail.tail.tail.tail)(func6)
        .option
    }
    def fold[U](func1: T1 => U, func2: T2 => U, func3: T3 => U, func4: T4 => U, func5: T5 => U, func6: T6 => U): U =
      foldOpt(func1, func2, func3, func4, func5, func6).get
  }

  class FoldNatPositiveHelperWrap7[T1, T2, T3, T4, T5, T6, T7](
    override val dataInstance: Option[T1],
    override val tail: NatFuncPositive[
      T2,
      NatFuncPositive[T3, NatFuncPositive[T4, NatFuncPositive[T5, NatFuncPositive[T6, NatFuncPositive[T7, NatFuncZero]]]]]
    ]
  ) extends NatFuncPositive[T1, NatFuncPositive[
        T2,
        NatFuncPositive[T3, NatFuncPositive[T4, NatFuncPositive[T5, NatFuncPositive[T6, NatFuncPositive[T7, NatFuncZero]]]]]
      ]](dataInstance) {
    def foldOpt[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U
    ): Option[U] = {
      FoldContext.empty
        .overrideOnce(this)(func1)
        .overrideOnce(this.tail)(func2)
        .overrideOnce(this.tail.tail)(func3)
        .overrideOnce(this.tail.tail.tail)(func4)
        .overrideOnce(this.tail.tail.tail.tail)(func5)
        .overrideOnce(this.tail.tail.tail.tail.tail)(func6)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail)(func7)
        .option
    }
    def fold[U](func1: T1 => U, func2: T2 => U, func3: T3 => U, func4: T4 => U, func5: T5 => U, func6: T6 => U, func7: T7 => U): U =
      foldOpt(func1, func2, func3, func4, func5, func6, func7).get
  }

  class FoldNatPositiveHelperWrap8[T1, T2, T3, T4, T5, T6, T7, T8](
    override val dataInstance: Option[T1],
    override val tail: NatFuncPositive[T2, NatFuncPositive[
      T3,
      NatFuncPositive[T4, NatFuncPositive[T5, NatFuncPositive[T6, NatFuncPositive[T7, NatFuncPositive[T8, NatFuncZero]]]]]
    ]]
  ) extends NatFuncPositive[
        T1,
        NatFuncPositive[T2, NatFuncPositive[
          T3,
          NatFuncPositive[T4, NatFuncPositive[T5, NatFuncPositive[T6, NatFuncPositive[T7, NatFuncPositive[T8, NatFuncZero]]]]]
        ]]
      ](dataInstance) {
    def foldOpt[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U,
      func8: T8 => U
    ): Option[U] = {
      FoldContext.empty
        .overrideOnce(this)(func1)
        .overrideOnce(this.tail)(func2)
        .overrideOnce(this.tail.tail)(func3)
        .overrideOnce(this.tail.tail.tail)(func4)
        .overrideOnce(this.tail.tail.tail.tail)(func5)
        .overrideOnce(this.tail.tail.tail.tail.tail)(func6)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail)(func7)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail)(func8)
        .option
    }
    def fold[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U,
      func8: T8 => U
    ): U = foldOpt(func1, func2, func3, func4, func5, func6, func7, func8).get
  }

  class FoldNatPositiveHelperWrap9[T1, T2, T3, T4, T5, T6, T7, T8, T9](
    override val dataInstance: Option[T1],
    override val tail: NatFuncPositive[
      T2,
      NatFuncPositive[T3, NatFuncPositive[
        T4,
        NatFuncPositive[T5, NatFuncPositive[T6, NatFuncPositive[T7, NatFuncPositive[T8, NatFuncPositive[T9, NatFuncZero]]]]]
      ]]
    ]
  ) extends NatFuncPositive[
        T1,
        NatFuncPositive[
          T2,
          NatFuncPositive[T3, NatFuncPositive[
            T4,
            NatFuncPositive[T5, NatFuncPositive[T6, NatFuncPositive[T7, NatFuncPositive[T8, NatFuncPositive[T9, NatFuncZero]]]]]
          ]]
        ]
      ](dataInstance) {
    def foldOpt[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U,
      func8: T8 => U,
      func9: T9 => U
    ): Option[U] = {
      FoldContext.empty
        .overrideOnce(this)(func1)
        .overrideOnce(this.tail)(func2)
        .overrideOnce(this.tail.tail)(func3)
        .overrideOnce(this.tail.tail.tail)(func4)
        .overrideOnce(this.tail.tail.tail.tail)(func5)
        .overrideOnce(this.tail.tail.tail.tail.tail)(func6)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail)(func7)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail)(func8)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail)(func9)
        .option
    }
    def fold[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U,
      func8: T8 => U,
      func9: T9 => U
    ): U = foldOpt(func1, func2, func3, func4, func5, func6, func7, func8, func9).get
  }

  class FoldNatPositiveHelperWrap10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10](
    override val dataInstance: Option[T1],
    override val tail: NatFuncPositive[
      T2,
      NatFuncPositive[
        T3,
        NatFuncPositive[T4, NatFuncPositive[
          T5,
          NatFuncPositive[T6, NatFuncPositive[T7, NatFuncPositive[T8, NatFuncPositive[T9, NatFuncPositive[T10, NatFuncZero]]]]]
        ]]
      ]
    ]
  ) extends NatFuncPositive[
        T1,
        NatFuncPositive[
          T2,
          NatFuncPositive[
            T3,
            NatFuncPositive[T4, NatFuncPositive[
              T5,
              NatFuncPositive[T6, NatFuncPositive[T7, NatFuncPositive[T8, NatFuncPositive[T9, NatFuncPositive[T10, NatFuncZero]]]]]
            ]]
          ]
        ]
      ](dataInstance) {
    def foldOpt[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U,
      func8: T8 => U,
      func9: T9 => U,
      func10: T10 => U
    ): Option[U] = {
      FoldContext.empty
        .overrideOnce(this)(func1)
        .overrideOnce(this.tail)(func2)
        .overrideOnce(this.tail.tail)(func3)
        .overrideOnce(this.tail.tail.tail)(func4)
        .overrideOnce(this.tail.tail.tail.tail)(func5)
        .overrideOnce(this.tail.tail.tail.tail.tail)(func6)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail)(func7)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail)(func8)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail)(func9)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func10)
        .option
    }
    def fold[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U,
      func8: T8 => U,
      func9: T9 => U,
      func10: T10 => U
    ): U = foldOpt(func1, func2, func3, func4, func5, func6, func7, func8, func9, func10).get
  }

  class FoldNatPositiveHelperWrap11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11](
    override val dataInstance: Option[T1],
    override val tail: NatFuncPositive[
      T2,
      NatFuncPositive[
        T3,
        NatFuncPositive[
          T4,
          NatFuncPositive[T5, NatFuncPositive[
            T6,
            NatFuncPositive[T7, NatFuncPositive[T8, NatFuncPositive[T9, NatFuncPositive[T10, NatFuncPositive[T11, NatFuncZero]]]]]
          ]]
        ]
      ]
    ]
  ) extends NatFuncPositive[
        T1,
        NatFuncPositive[
          T2,
          NatFuncPositive[
            T3,
            NatFuncPositive[
              T4,
              NatFuncPositive[T5, NatFuncPositive[
                T6,
                NatFuncPositive[T7, NatFuncPositive[T8, NatFuncPositive[T9, NatFuncPositive[T10, NatFuncPositive[T11, NatFuncZero]]]]]
              ]]
            ]
          ]
        ]
      ](dataInstance) {
    def foldOpt[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U,
      func8: T8 => U,
      func9: T9 => U,
      func10: T10 => U,
      func11: T11 => U
    ): Option[U] = {
      FoldContext.empty
        .overrideOnce(this)(func1)
        .overrideOnce(this.tail)(func2)
        .overrideOnce(this.tail.tail)(func3)
        .overrideOnce(this.tail.tail.tail)(func4)
        .overrideOnce(this.tail.tail.tail.tail)(func5)
        .overrideOnce(this.tail.tail.tail.tail.tail)(func6)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail)(func7)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail)(func8)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail)(func9)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func10)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func11)
        .option
    }
    def fold[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U,
      func8: T8 => U,
      func9: T9 => U,
      func10: T10 => U,
      func11: T11 => U
    ): U = foldOpt(func1, func2, func3, func4, func5, func6, func7, func8, func9, func10, func11).get
  }

  class FoldNatPositiveHelperWrap12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12](
    override val dataInstance: Option[T1],
    override val tail: NatFuncPositive[
      T2,
      NatFuncPositive[
        T3,
        NatFuncPositive[
          T4,
          NatFuncPositive[
            T5,
            NatFuncPositive[T6, NatFuncPositive[
              T7,
              NatFuncPositive[T8, NatFuncPositive[T9, NatFuncPositive[T10, NatFuncPositive[T11, NatFuncPositive[T12, NatFuncZero]]]]]
            ]]
          ]
        ]
      ]
    ]
  ) extends NatFuncPositive[
        T1,
        NatFuncPositive[
          T2,
          NatFuncPositive[
            T3,
            NatFuncPositive[
              T4,
              NatFuncPositive[
                T5,
                NatFuncPositive[T6, NatFuncPositive[
                  T7,
                  NatFuncPositive[T8, NatFuncPositive[T9, NatFuncPositive[T10, NatFuncPositive[T11, NatFuncPositive[T12, NatFuncZero]]]]]
                ]]
              ]
            ]
          ]
        ]
      ](dataInstance) {
    def foldOpt[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U,
      func8: T8 => U,
      func9: T9 => U,
      func10: T10 => U,
      func11: T11 => U,
      func12: T12 => U
    ): Option[U] = {
      FoldContext.empty
        .overrideOnce(this)(func1)
        .overrideOnce(this.tail)(func2)
        .overrideOnce(this.tail.tail)(func3)
        .overrideOnce(this.tail.tail.tail)(func4)
        .overrideOnce(this.tail.tail.tail.tail)(func5)
        .overrideOnce(this.tail.tail.tail.tail.tail)(func6)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail)(func7)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail)(func8)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail)(func9)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func10)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func11)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func12)
        .option
    }
    def fold[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U,
      func8: T8 => U,
      func9: T9 => U,
      func10: T10 => U,
      func11: T11 => U,
      func12: T12 => U
    ): U = foldOpt(func1, func2, func3, func4, func5, func6, func7, func8, func9, func10, func11, func12).get
  }

  class FoldNatPositiveHelperWrap13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13](
    override val dataInstance: Option[T1],
    override val tail: NatFuncPositive[
      T2,
      NatFuncPositive[
        T3,
        NatFuncPositive[
          T4,
          NatFuncPositive[
            T5,
            NatFuncPositive[
              T6,
              NatFuncPositive[T7, NatFuncPositive[
                T8,
                NatFuncPositive[T9, NatFuncPositive[T10, NatFuncPositive[T11, NatFuncPositive[T12, NatFuncPositive[T13, NatFuncZero]]]]]
              ]]
            ]
          ]
        ]
      ]
    ]
  ) extends NatFuncPositive[
        T1,
        NatFuncPositive[
          T2,
          NatFuncPositive[
            T3,
            NatFuncPositive[
              T4,
              NatFuncPositive[
                T5,
                NatFuncPositive[
                  T6,
                  NatFuncPositive[T7, NatFuncPositive[
                    T8,
                    NatFuncPositive[T9, NatFuncPositive[T10, NatFuncPositive[T11, NatFuncPositive[T12, NatFuncPositive[T13, NatFuncZero]]]]]
                  ]]
                ]
              ]
            ]
          ]
        ]
      ](dataInstance) {
    def foldOpt[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U,
      func8: T8 => U,
      func9: T9 => U,
      func10: T10 => U,
      func11: T11 => U,
      func12: T12 => U,
      func13: T13 => U
    ): Option[U] = {
      FoldContext.empty
        .overrideOnce(this)(func1)
        .overrideOnce(this.tail)(func2)
        .overrideOnce(this.tail.tail)(func3)
        .overrideOnce(this.tail.tail.tail)(func4)
        .overrideOnce(this.tail.tail.tail.tail)(func5)
        .overrideOnce(this.tail.tail.tail.tail.tail)(func6)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail)(func7)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail)(func8)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail)(func9)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func10)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func11)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func12)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func13)
        .option
    }
    def fold[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U,
      func8: T8 => U,
      func9: T9 => U,
      func10: T10 => U,
      func11: T11 => U,
      func12: T12 => U,
      func13: T13 => U
    ): U = foldOpt(func1, func2, func3, func4, func5, func6, func7, func8, func9, func10, func11, func12, func13).get
  }

  class FoldNatPositiveHelperWrap14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14](
    override val dataInstance: Option[T1],
    override val tail: NatFuncPositive[
      T2,
      NatFuncPositive[
        T3,
        NatFuncPositive[
          T4,
          NatFuncPositive[
            T5,
            NatFuncPositive[
              T6,
              NatFuncPositive[
                T7,
                NatFuncPositive[T8, NatFuncPositive[
                  T9,
                  NatFuncPositive[T10, NatFuncPositive[T11, NatFuncPositive[T12, NatFuncPositive[T13, NatFuncPositive[T14, NatFuncZero]]]]]
                ]]
              ]
            ]
          ]
        ]
      ]
    ]
  ) extends NatFuncPositive[
        T1,
        NatFuncPositive[
          T2,
          NatFuncPositive[
            T3,
            NatFuncPositive[
              T4,
              NatFuncPositive[
                T5,
                NatFuncPositive[
                  T6,
                  NatFuncPositive[
                    T7,
                    NatFuncPositive[T8, NatFuncPositive[T9, NatFuncPositive[
                      T10,
                      NatFuncPositive[T11, NatFuncPositive[T12, NatFuncPositive[T13, NatFuncPositive[T14, NatFuncZero]]]]
                    ]]]
                  ]
                ]
              ]
            ]
          ]
        ]
      ](dataInstance) {
    def foldOpt[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U,
      func8: T8 => U,
      func9: T9 => U,
      func10: T10 => U,
      func11: T11 => U,
      func12: T12 => U,
      func13: T13 => U,
      func14: T14 => U
    ): Option[U] = {
      FoldContext.empty
        .overrideOnce(this)(func1)
        .overrideOnce(this.tail)(func2)
        .overrideOnce(this.tail.tail)(func3)
        .overrideOnce(this.tail.tail.tail)(func4)
        .overrideOnce(this.tail.tail.tail.tail)(func5)
        .overrideOnce(this.tail.tail.tail.tail.tail)(func6)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail)(func7)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail)(func8)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail)(func9)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func10)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func11)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func12)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func13)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func14)
        .option
    }
    def fold[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U,
      func8: T8 => U,
      func9: T9 => U,
      func10: T10 => U,
      func11: T11 => U,
      func12: T12 => U,
      func13: T13 => U,
      func14: T14 => U
    ): U = foldOpt(func1, func2, func3, func4, func5, func6, func7, func8, func9, func10, func11, func12, func13, func14).get
  }

  class FoldNatPositiveHelperWrap15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15](
    override val dataInstance: Option[T1],
    override val tail: NatFuncPositive[
      T2,
      NatFuncPositive[
        T3,
        NatFuncPositive[
          T4,
          NatFuncPositive[
            T5,
            NatFuncPositive[
              T6,
              NatFuncPositive[
                T7,
                NatFuncPositive[
                  T8,
                  NatFuncPositive[T9, NatFuncPositive[T10, NatFuncPositive[
                    T11,
                    NatFuncPositive[T12, NatFuncPositive[T13, NatFuncPositive[T14, NatFuncPositive[T15, NatFuncZero]]]]
                  ]]]
                ]
              ]
            ]
          ]
        ]
      ]
    ]
  ) extends NatFuncPositive[
        T1,
        NatFuncPositive[
          T2,
          NatFuncPositive[
            T3,
            NatFuncPositive[
              T4,
              NatFuncPositive[
                T5,
                NatFuncPositive[
                  T6,
                  NatFuncPositive[
                    T7,
                    NatFuncPositive[
                      T8,
                      NatFuncPositive[T9, NatFuncPositive[T10, NatFuncPositive[
                        T11,
                        NatFuncPositive[T12, NatFuncPositive[T13, NatFuncPositive[T14, NatFuncPositive[T15, NatFuncZero]]]]
                      ]]]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ](dataInstance) {
    def foldOpt[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U,
      func8: T8 => U,
      func9: T9 => U,
      func10: T10 => U,
      func11: T11 => U,
      func12: T12 => U,
      func13: T13 => U,
      func14: T14 => U,
      func15: T15 => U
    ): Option[U] = {
      FoldContext.empty
        .overrideOnce(this)(func1)
        .overrideOnce(this.tail)(func2)
        .overrideOnce(this.tail.tail)(func3)
        .overrideOnce(this.tail.tail.tail)(func4)
        .overrideOnce(this.tail.tail.tail.tail)(func5)
        .overrideOnce(this.tail.tail.tail.tail.tail)(func6)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail)(func7)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail)(func8)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail)(func9)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func10)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func11)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func12)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func13)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func14)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func15)
        .option
    }
    def fold[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U,
      func8: T8 => U,
      func9: T9 => U,
      func10: T10 => U,
      func11: T11 => U,
      func12: T12 => U,
      func13: T13 => U,
      func14: T14 => U,
      func15: T15 => U
    ): U = foldOpt(func1, func2, func3, func4, func5, func6, func7, func8, func9, func10, func11, func12, func13, func14, func15).get
  }

  class FoldNatPositiveHelperWrap16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16](
    override val dataInstance: Option[T1],
    override val tail: NatFuncPositive[
      T2,
      NatFuncPositive[
        T3,
        NatFuncPositive[
          T4,
          NatFuncPositive[
            T5,
            NatFuncPositive[
              T6,
              NatFuncPositive[
                T7,
                NatFuncPositive[
                  T8,
                  NatFuncPositive[
                    T9,
                    NatFuncPositive[T10, NatFuncPositive[T11, NatFuncPositive[
                      T12,
                      NatFuncPositive[T13, NatFuncPositive[T14, NatFuncPositive[T15, NatFuncPositive[T16, NatFuncZero]]]]
                    ]]]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    ]
  ) extends NatFuncPositive[
        T1,
        NatFuncPositive[
          T2,
          NatFuncPositive[
            T3,
            NatFuncPositive[
              T4,
              NatFuncPositive[
                T5,
                NatFuncPositive[
                  T6,
                  NatFuncPositive[
                    T7,
                    NatFuncPositive[
                      T8,
                      NatFuncPositive[
                        T9,
                        NatFuncPositive[T10, NatFuncPositive[T11, NatFuncPositive[
                          T12,
                          NatFuncPositive[T13, NatFuncPositive[T14, NatFuncPositive[T15, NatFuncPositive[T16, NatFuncZero]]]]
                        ]]]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ](dataInstance) {
    def foldOpt[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U,
      func8: T8 => U,
      func9: T9 => U,
      func10: T10 => U,
      func11: T11 => U,
      func12: T12 => U,
      func13: T13 => U,
      func14: T14 => U,
      func15: T15 => U,
      func16: T16 => U
    ): Option[U] = {
      FoldContext.empty
        .overrideOnce(this)(func1)
        .overrideOnce(this.tail)(func2)
        .overrideOnce(this.tail.tail)(func3)
        .overrideOnce(this.tail.tail.tail)(func4)
        .overrideOnce(this.tail.tail.tail.tail)(func5)
        .overrideOnce(this.tail.tail.tail.tail.tail)(func6)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail)(func7)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail)(func8)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail)(func9)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func10)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func11)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func12)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func13)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func14)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func15)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func16)
        .option
    }
    def fold[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U,
      func8: T8 => U,
      func9: T9 => U,
      func10: T10 => U,
      func11: T11 => U,
      func12: T12 => U,
      func13: T13 => U,
      func14: T14 => U,
      func15: T15 => U,
      func16: T16 => U
    ): U =
      foldOpt(func1, func2, func3, func4, func5, func6, func7, func8, func9, func10, func11, func12, func13, func14, func15, func16).get
  }

  class FoldNatPositiveHelperWrap17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17](
    override val dataInstance: Option[T1],
    override val tail: NatFuncPositive[
      T2,
      NatFuncPositive[
        T3,
        NatFuncPositive[
          T4,
          NatFuncPositive[
            T5,
            NatFuncPositive[
              T6,
              NatFuncPositive[
                T7,
                NatFuncPositive[
                  T8,
                  NatFuncPositive[
                    T9,
                    NatFuncPositive[
                      T10,
                      NatFuncPositive[T11, NatFuncPositive[T12, NatFuncPositive[
                        T13,
                        NatFuncPositive[T14, NatFuncPositive[T15, NatFuncPositive[T16, NatFuncPositive[T17, NatFuncZero]]]]
                      ]]]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    ]
  ) extends NatFuncPositive[
        T1,
        NatFuncPositive[
          T2,
          NatFuncPositive[
            T3,
            NatFuncPositive[
              T4,
              NatFuncPositive[
                T5,
                NatFuncPositive[
                  T6,
                  NatFuncPositive[
                    T7,
                    NatFuncPositive[
                      T8,
                      NatFuncPositive[
                        T9,
                        NatFuncPositive[
                          T10,
                          NatFuncPositive[T11, NatFuncPositive[T12, NatFuncPositive[
                            T13,
                            NatFuncPositive[T14, NatFuncPositive[T15, NatFuncPositive[T16, NatFuncPositive[T17, NatFuncZero]]]]
                          ]]]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ](dataInstance) {
    def foldOpt[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U,
      func8: T8 => U,
      func9: T9 => U,
      func10: T10 => U,
      func11: T11 => U,
      func12: T12 => U,
      func13: T13 => U,
      func14: T14 => U,
      func15: T15 => U,
      func16: T16 => U,
      func17: T17 => U
    ): Option[U] = {
      FoldContext.empty
        .overrideOnce(this)(func1)
        .overrideOnce(this.tail)(func2)
        .overrideOnce(this.tail.tail)(func3)
        .overrideOnce(this.tail.tail.tail)(func4)
        .overrideOnce(this.tail.tail.tail.tail)(func5)
        .overrideOnce(this.tail.tail.tail.tail.tail)(func6)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail)(func7)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail)(func8)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail)(func9)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func10)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func11)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func12)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func13)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func14)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func15)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func16)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func17)
        .option
    }
    def fold[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U,
      func8: T8 => U,
      func9: T9 => U,
      func10: T10 => U,
      func11: T11 => U,
      func12: T12 => U,
      func13: T13 => U,
      func14: T14 => U,
      func15: T15 => U,
      func16: T16 => U,
      func17: T17 => U
    ): U = foldOpt(
      func1,
      func2,
      func3,
      func4,
      func5,
      func6,
      func7,
      func8,
      func9,
      func10,
      func11,
      func12,
      func13,
      func14,
      func15,
      func16,
      func17
    ).get
  }

  class FoldNatPositiveHelperWrap18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18](
    override val dataInstance: Option[T1],
    override val tail: NatFuncPositive[
      T2,
      NatFuncPositive[
        T3,
        NatFuncPositive[
          T4,
          NatFuncPositive[
            T5,
            NatFuncPositive[
              T6,
              NatFuncPositive[
                T7,
                NatFuncPositive[
                  T8,
                  NatFuncPositive[
                    T9,
                    NatFuncPositive[
                      T10,
                      NatFuncPositive[
                        T11,
                        NatFuncPositive[T12, NatFuncPositive[T13, NatFuncPositive[
                          T14,
                          NatFuncPositive[T15, NatFuncPositive[T16, NatFuncPositive[T17, NatFuncPositive[T18, NatFuncZero]]]]
                        ]]]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    ]
  ) extends NatFuncPositive[
        T1,
        NatFuncPositive[
          T2,
          NatFuncPositive[
            T3,
            NatFuncPositive[
              T4,
              NatFuncPositive[
                T5,
                NatFuncPositive[
                  T6,
                  NatFuncPositive[
                    T7,
                    NatFuncPositive[
                      T8,
                      NatFuncPositive[
                        T9,
                        NatFuncPositive[
                          T10,
                          NatFuncPositive[
                            T11,
                            NatFuncPositive[T12, NatFuncPositive[T13, NatFuncPositive[
                              T14,
                              NatFuncPositive[T15, NatFuncPositive[T16, NatFuncPositive[T17, NatFuncPositive[T18, NatFuncZero]]]]
                            ]]]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ](dataInstance) {
    def foldOpt[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U,
      func8: T8 => U,
      func9: T9 => U,
      func10: T10 => U,
      func11: T11 => U,
      func12: T12 => U,
      func13: T13 => U,
      func14: T14 => U,
      func15: T15 => U,
      func16: T16 => U,
      func17: T17 => U,
      func18: T18 => U
    ): Option[U] = {
      FoldContext.empty
        .overrideOnce(this)(func1)
        .overrideOnce(this.tail)(func2)
        .overrideOnce(this.tail.tail)(func3)
        .overrideOnce(this.tail.tail.tail)(func4)
        .overrideOnce(this.tail.tail.tail.tail)(func5)
        .overrideOnce(this.tail.tail.tail.tail.tail)(func6)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail)(func7)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail)(func8)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail)(func9)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func10)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func11)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func12)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func13)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func14)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func15)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func16)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func17)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func18)
        .option
    }
    def fold[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U,
      func8: T8 => U,
      func9: T9 => U,
      func10: T10 => U,
      func11: T11 => U,
      func12: T12 => U,
      func13: T13 => U,
      func14: T14 => U,
      func15: T15 => U,
      func16: T16 => U,
      func17: T17 => U,
      func18: T18 => U
    ): U = foldOpt(
      func1,
      func2,
      func3,
      func4,
      func5,
      func6,
      func7,
      func8,
      func9,
      func10,
      func11,
      func12,
      func13,
      func14,
      func15,
      func16,
      func17,
      func18
    ).get
  }

  class FoldNatPositiveHelperWrap19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19](
    override val dataInstance: Option[T1],
    override val tail: NatFuncPositive[
      T2,
      NatFuncPositive[
        T3,
        NatFuncPositive[
          T4,
          NatFuncPositive[
            T5,
            NatFuncPositive[
              T6,
              NatFuncPositive[
                T7,
                NatFuncPositive[
                  T8,
                  NatFuncPositive[
                    T9,
                    NatFuncPositive[
                      T10,
                      NatFuncPositive[
                        T11,
                        NatFuncPositive[
                          T12,
                          NatFuncPositive[T13, NatFuncPositive[T14, NatFuncPositive[
                            T15,
                            NatFuncPositive[T16, NatFuncPositive[T17, NatFuncPositive[T18, NatFuncPositive[T19, NatFuncZero]]]]
                          ]]]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    ]
  ) extends NatFuncPositive[
        T1,
        NatFuncPositive[
          T2,
          NatFuncPositive[
            T3,
            NatFuncPositive[
              T4,
              NatFuncPositive[
                T5,
                NatFuncPositive[
                  T6,
                  NatFuncPositive[
                    T7,
                    NatFuncPositive[
                      T8,
                      NatFuncPositive[
                        T9,
                        NatFuncPositive[
                          T10,
                          NatFuncPositive[
                            T11,
                            NatFuncPositive[
                              T12,
                              NatFuncPositive[T13, NatFuncPositive[T14, NatFuncPositive[
                                T15,
                                NatFuncPositive[T16, NatFuncPositive[T17, NatFuncPositive[T18, NatFuncPositive[T19, NatFuncZero]]]]
                              ]]]
                            ]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ](dataInstance) {
    def foldOpt[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U,
      func8: T8 => U,
      func9: T9 => U,
      func10: T10 => U,
      func11: T11 => U,
      func12: T12 => U,
      func13: T13 => U,
      func14: T14 => U,
      func15: T15 => U,
      func16: T16 => U,
      func17: T17 => U,
      func18: T18 => U,
      func19: T19 => U
    ): Option[U] = {
      FoldContext.empty
        .overrideOnce(this)(func1)
        .overrideOnce(this.tail)(func2)
        .overrideOnce(this.tail.tail)(func3)
        .overrideOnce(this.tail.tail.tail)(func4)
        .overrideOnce(this.tail.tail.tail.tail)(func5)
        .overrideOnce(this.tail.tail.tail.tail.tail)(func6)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail)(func7)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail)(func8)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail)(func9)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func10)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func11)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func12)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func13)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func14)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func15)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func16)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func17)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func18)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func19)
        .option
    }
    def fold[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U,
      func8: T8 => U,
      func9: T9 => U,
      func10: T10 => U,
      func11: T11 => U,
      func12: T12 => U,
      func13: T13 => U,
      func14: T14 => U,
      func15: T15 => U,
      func16: T16 => U,
      func17: T17 => U,
      func18: T18 => U,
      func19: T19 => U
    ): U = foldOpt(
      func1,
      func2,
      func3,
      func4,
      func5,
      func6,
      func7,
      func8,
      func9,
      func10,
      func11,
      func12,
      func13,
      func14,
      func15,
      func16,
      func17,
      func18,
      func19
    ).get
  }

  class FoldNatPositiveHelperWrap20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20](
    override val dataInstance: Option[T1],
    override val tail: NatFuncPositive[
      T2,
      NatFuncPositive[
        T3,
        NatFuncPositive[
          T4,
          NatFuncPositive[
            T5,
            NatFuncPositive[
              T6,
              NatFuncPositive[
                T7,
                NatFuncPositive[
                  T8,
                  NatFuncPositive[
                    T9,
                    NatFuncPositive[
                      T10,
                      NatFuncPositive[
                        T11,
                        NatFuncPositive[
                          T12,
                          NatFuncPositive[
                            T13,
                            NatFuncPositive[T14, NatFuncPositive[T15, NatFuncPositive[
                              T16,
                              NatFuncPositive[T17, NatFuncPositive[T18, NatFuncPositive[T19, NatFuncPositive[T20, NatFuncZero]]]]
                            ]]]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    ]
  ) extends NatFuncPositive[
        T1,
        NatFuncPositive[
          T2,
          NatFuncPositive[
            T3,
            NatFuncPositive[
              T4,
              NatFuncPositive[
                T5,
                NatFuncPositive[
                  T6,
                  NatFuncPositive[
                    T7,
                    NatFuncPositive[
                      T8,
                      NatFuncPositive[
                        T9,
                        NatFuncPositive[
                          T10,
                          NatFuncPositive[
                            T11,
                            NatFuncPositive[
                              T12,
                              NatFuncPositive[
                                T13,
                                NatFuncPositive[T14, NatFuncPositive[T15, NatFuncPositive[
                                  T16,
                                  NatFuncPositive[T17, NatFuncPositive[T18, NatFuncPositive[T19, NatFuncPositive[T20, NatFuncZero]]]]
                                ]]]
                              ]
                            ]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ](dataInstance) {
    def foldOpt[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U,
      func8: T8 => U,
      func9: T9 => U,
      func10: T10 => U,
      func11: T11 => U,
      func12: T12 => U,
      func13: T13 => U,
      func14: T14 => U,
      func15: T15 => U,
      func16: T16 => U,
      func17: T17 => U,
      func18: T18 => U,
      func19: T19 => U,
      func20: T20 => U
    ): Option[U] = {
      FoldContext.empty
        .overrideOnce(this)(func1)
        .overrideOnce(this.tail)(func2)
        .overrideOnce(this.tail.tail)(func3)
        .overrideOnce(this.tail.tail.tail)(func4)
        .overrideOnce(this.tail.tail.tail.tail)(func5)
        .overrideOnce(this.tail.tail.tail.tail.tail)(func6)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail)(func7)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail)(func8)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail)(func9)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func10)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func11)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func12)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func13)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func14)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func15)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func16)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func17)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func18)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func19)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func20)
        .option
    }
    def fold[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U,
      func8: T8 => U,
      func9: T9 => U,
      func10: T10 => U,
      func11: T11 => U,
      func12: T12 => U,
      func13: T13 => U,
      func14: T14 => U,
      func15: T15 => U,
      func16: T16 => U,
      func17: T17 => U,
      func18: T18 => U,
      func19: T19 => U,
      func20: T20 => U
    ): U = foldOpt(
      func1,
      func2,
      func3,
      func4,
      func5,
      func6,
      func7,
      func8,
      func9,
      func10,
      func11,
      func12,
      func13,
      func14,
      func15,
      func16,
      func17,
      func18,
      func19,
      func20
    ).get
  }

  class FoldNatPositiveHelperWrap21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21](
    override val dataInstance: Option[T1],
    override val tail: NatFuncPositive[
      T2,
      NatFuncPositive[
        T3,
        NatFuncPositive[
          T4,
          NatFuncPositive[
            T5,
            NatFuncPositive[
              T6,
              NatFuncPositive[
                T7,
                NatFuncPositive[
                  T8,
                  NatFuncPositive[
                    T9,
                    NatFuncPositive[
                      T10,
                      NatFuncPositive[
                        T11,
                        NatFuncPositive[
                          T12,
                          NatFuncPositive[
                            T13,
                            NatFuncPositive[
                              T14,
                              NatFuncPositive[T15, NatFuncPositive[T16, NatFuncPositive[
                                T17,
                                NatFuncPositive[T18, NatFuncPositive[T19, NatFuncPositive[T20, NatFuncPositive[T21, NatFuncZero]]]]
                              ]]]
                            ]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    ]
  ) extends NatFuncPositive[
        T1,
        NatFuncPositive[
          T2,
          NatFuncPositive[
            T3,
            NatFuncPositive[
              T4,
              NatFuncPositive[
                T5,
                NatFuncPositive[
                  T6,
                  NatFuncPositive[
                    T7,
                    NatFuncPositive[
                      T8,
                      NatFuncPositive[
                        T9,
                        NatFuncPositive[
                          T10,
                          NatFuncPositive[
                            T11,
                            NatFuncPositive[
                              T12,
                              NatFuncPositive[
                                T13,
                                NatFuncPositive[
                                  T14,
                                  NatFuncPositive[T15, NatFuncPositive[T16, NatFuncPositive[
                                    T17,
                                    NatFuncPositive[T18, NatFuncPositive[T19, NatFuncPositive[T20, NatFuncPositive[T21, NatFuncZero]]]]
                                  ]]]
                                ]
                              ]
                            ]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ](dataInstance) {
    def foldOpt[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U,
      func8: T8 => U,
      func9: T9 => U,
      func10: T10 => U,
      func11: T11 => U,
      func12: T12 => U,
      func13: T13 => U,
      func14: T14 => U,
      func15: T15 => U,
      func16: T16 => U,
      func17: T17 => U,
      func18: T18 => U,
      func19: T19 => U,
      func20: T20 => U,
      func21: T21 => U
    ): Option[U] = {
      FoldContext.empty
        .overrideOnce(this)(func1)
        .overrideOnce(this.tail)(func2)
        .overrideOnce(this.tail.tail)(func3)
        .overrideOnce(this.tail.tail.tail)(func4)
        .overrideOnce(this.tail.tail.tail.tail)(func5)
        .overrideOnce(this.tail.tail.tail.tail.tail)(func6)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail)(func7)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail)(func8)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail)(func9)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func10)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func11)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func12)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func13)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func14)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func15)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func16)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func17)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func18)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func19)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func20)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func21)
        .option
    }
    def fold[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U,
      func8: T8 => U,
      func9: T9 => U,
      func10: T10 => U,
      func11: T11 => U,
      func12: T12 => U,
      func13: T13 => U,
      func14: T14 => U,
      func15: T15 => U,
      func16: T16 => U,
      func17: T17 => U,
      func18: T18 => U,
      func19: T19 => U,
      func20: T20 => U,
      func21: T21 => U
    ): U = foldOpt(
      func1,
      func2,
      func3,
      func4,
      func5,
      func6,
      func7,
      func8,
      func9,
      func10,
      func11,
      func12,
      func13,
      func14,
      func15,
      func16,
      func17,
      func18,
      func19,
      func20,
      func21
    ).get
  }

  class FoldNatPositiveHelperWrap22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22](
    override val dataInstance: Option[T1],
    override val tail: NatFuncPositive[
      T2,
      NatFuncPositive[
        T3,
        NatFuncPositive[
          T4,
          NatFuncPositive[
            T5,
            NatFuncPositive[
              T6,
              NatFuncPositive[
                T7,
                NatFuncPositive[
                  T8,
                  NatFuncPositive[
                    T9,
                    NatFuncPositive[
                      T10,
                      NatFuncPositive[
                        T11,
                        NatFuncPositive[
                          T12,
                          NatFuncPositive[
                            T13,
                            NatFuncPositive[
                              T14,
                              NatFuncPositive[
                                T15,
                                NatFuncPositive[T16, NatFuncPositive[T17, NatFuncPositive[
                                  T18,
                                  NatFuncPositive[T19, NatFuncPositive[T20, NatFuncPositive[T21, NatFuncPositive[T22, NatFuncZero]]]]
                                ]]]
                              ]
                            ]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    ]
  ) extends NatFuncPositive[
        T1,
        NatFuncPositive[
          T2,
          NatFuncPositive[
            T3,
            NatFuncPositive[
              T4,
              NatFuncPositive[
                T5,
                NatFuncPositive[
                  T6,
                  NatFuncPositive[
                    T7,
                    NatFuncPositive[
                      T8,
                      NatFuncPositive[
                        T9,
                        NatFuncPositive[
                          T10,
                          NatFuncPositive[
                            T11,
                            NatFuncPositive[
                              T12,
                              NatFuncPositive[
                                T13,
                                NatFuncPositive[
                                  T14,
                                  NatFuncPositive[
                                    T15,
                                    NatFuncPositive[T16, NatFuncPositive[T17, NatFuncPositive[
                                      T18,
                                      NatFuncPositive[T19, NatFuncPositive[T20, NatFuncPositive[T21, NatFuncPositive[T22, NatFuncZero]]]]
                                    ]]]
                                  ]
                                ]
                              ]
                            ]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ](dataInstance) {
    def foldOpt[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U,
      func8: T8 => U,
      func9: T9 => U,
      func10: T10 => U,
      func11: T11 => U,
      func12: T12 => U,
      func13: T13 => U,
      func14: T14 => U,
      func15: T15 => U,
      func16: T16 => U,
      func17: T17 => U,
      func18: T18 => U,
      func19: T19 => U,
      func20: T20 => U,
      func21: T21 => U,
      func22: T22 => U
    ): Option[U] = {
      FoldContext.empty
        .overrideOnce(this)(func1)
        .overrideOnce(this.tail)(func2)
        .overrideOnce(this.tail.tail)(func3)
        .overrideOnce(this.tail.tail.tail)(func4)
        .overrideOnce(this.tail.tail.tail.tail)(func5)
        .overrideOnce(this.tail.tail.tail.tail.tail)(func6)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail)(func7)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail)(func8)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail)(func9)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func10)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func11)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func12)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func13)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func14)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func15)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func16)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func17)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func18)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func19)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func20)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func21)
        .overrideOnce(this.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail)(func22)
        .option
    }
    def fold[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U,
      func8: T8 => U,
      func9: T9 => U,
      func10: T10 => U,
      func11: T11 => U,
      func12: T12 => U,
      func13: T13 => U,
      func14: T14 => U,
      func15: T15 => U,
      func16: T16 => U,
      func17: T17 => U,
      func18: T18 => U,
      func19: T19 => U,
      func20: T20 => U,
      func21: T21 => U,
      func22: T22 => U
    ): U = foldOpt(
      func1,
      func2,
      func3,
      func4,
      func5,
      func6,
      func7,
      func8,
      func9,
      func10,
      func11,
      func12,
      func13,
      func14,
      func15,
      func16,
      func17,
      func18,
      func19,
      func20,
      func21,
      func22
    ).get
  }

}

object FoldNatPositiveHelper extends FoldNatPositiveHelper
