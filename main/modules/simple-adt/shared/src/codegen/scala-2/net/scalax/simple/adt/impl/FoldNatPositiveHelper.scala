package net.scalax.simple.adt
package impl

import net.scalax.simple.ghdmzsk.ghdmzsk

import implemention._
import net.scalax.simple.adt.{TypeAdt => InnerAdt}

object FoldNatPositiveHelper {

  abstract class FoldNatPositiveHelperWrap1[T1](
    override val dataInstance: Option[T1],
    override val isAlreadyOk: Boolean,
    override val tail: NatFuncZero
  ) extends NatFuncPositive[T1, NatFuncZero](dataInstance) {
    def dataImpl: Any
    def fold[U](func1: T1 => U): U = {
      val dataModel         = dataImpl
      val funcs             = List(func1)
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val data: (Any, Int)  = dataModel.asInstanceOf[(Any, Int)]
      val funcInstance = this
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => U]
      funcInstance(data._1)
    }
  }

  abstract class FoldNatPositiveHelperWrap2[T1, T2](
    override val dataInstance: Option[T1],
    override val isAlreadyOk: Boolean,
    override val tail: NatFuncPositive[T2, NatFuncZero]
  ) extends NatFuncPositive[T1, NatFuncPositive[T2, NatFuncZero]](dataInstance) {
    def dataImpl: Any
    def fold[U](func1: T1 => U, func2: T2 => U): U = {
      val dataModel         = dataImpl
      val funcs             = List(func1, func2)
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val data: (Any, Int)  = dataModel.asInstanceOf[(Any, Int)]
      val funcInstance = this
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => U]
      funcInstance(data._1)
    }
  }

  abstract class FoldNatPositiveHelperWrap3[T1, T2, T3](
    override val dataInstance: Option[T1],
    override val isAlreadyOk: Boolean,
    override val tail: NatFuncPositive[T2, NatFuncPositive[T3, NatFuncZero]]
  ) extends NatFuncPositive[T1, NatFuncPositive[T2, NatFuncPositive[T3, NatFuncZero]]](dataInstance) {
    def dataImpl: Any
    def fold[U](func1: T1 => U, func2: T2 => U, func3: T3 => U): U = {
      val dataModel         = dataImpl
      val funcs             = List(func1, func2, func3)
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val data: (Any, Int)  = dataModel.asInstanceOf[(Any, Int)]
      val funcInstance = this
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => U]
      funcInstance(data._1)
    }
  }

  abstract class FoldNatPositiveHelperWrap4[T1, T2, T3, T4](
    override val dataInstance: Option[T1],
    override val isAlreadyOk: Boolean,
    override val tail: NatFuncPositive[T2, NatFuncPositive[T3, NatFuncPositive[T4, NatFuncZero]]]
  ) extends NatFuncPositive[T1, NatFuncPositive[T2, NatFuncPositive[T3, NatFuncPositive[T4, NatFuncZero]]]](dataInstance) {
    def dataImpl: Any
    def fold[U](func1: T1 => U, func2: T2 => U, func3: T3 => U, func4: T4 => U): U = {
      val dataModel         = dataImpl
      val funcs             = List(func1, func2, func3, func4)
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val data: (Any, Int)  = dataModel.asInstanceOf[(Any, Int)]
      val funcInstance = this
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => U]
      funcInstance(data._1)
    }
  }

  abstract class FoldNatPositiveHelperWrap5[T1, T2, T3, T4, T5](
    override val dataInstance: Option[T1],
    override val isAlreadyOk: Boolean,
    override val tail: NatFuncPositive[T2, NatFuncPositive[T3, NatFuncPositive[T4, NatFuncPositive[T5, NatFuncZero]]]]
  ) extends NatFuncPositive[T1, NatFuncPositive[T2, NatFuncPositive[T3, NatFuncPositive[T4, NatFuncPositive[T5, NatFuncZero]]]]](
        dataInstance
      ) {
    def dataImpl: Any
    def fold[U](func1: T1 => U, func2: T2 => U, func3: T3 => U, func4: T4 => U, func5: T5 => U): U = {
      val dataModel         = dataImpl
      val funcs             = List(func1, func2, func3, func4, func5)
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val data: (Any, Int)  = dataModel.asInstanceOf[(Any, Int)]
      val funcInstance = this
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => U]
      funcInstance(data._1)
    }
  }

  abstract class FoldNatPositiveHelperWrap6[T1, T2, T3, T4, T5, T6](
    override val dataInstance: Option[T1],
    override val isAlreadyOk: Boolean,
    override val tail: NatFuncPositive[T2, NatFuncPositive[T3, NatFuncPositive[T4, NatFuncPositive[T5, NatFuncPositive[T6, NatFuncZero]]]]]
  ) extends NatFuncPositive[
        T1,
        NatFuncPositive[T2, NatFuncPositive[T3, NatFuncPositive[T4, NatFuncPositive[T5, NatFuncPositive[T6, NatFuncZero]]]]]
      ](dataInstance) {
    def dataImpl: Any
    def fold[U](func1: T1 => U, func2: T2 => U, func3: T3 => U, func4: T4 => U, func5: T5 => U, func6: T6 => U): U = {
      val dataModel         = dataImpl
      val funcs             = List(func1, func2, func3, func4, func5, func6)
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val data: (Any, Int)  = dataModel.asInstanceOf[(Any, Int)]
      val funcInstance = this
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => U]
      funcInstance(data._1)
    }
  }

  abstract class FoldNatPositiveHelperWrap7[T1, T2, T3, T4, T5, T6, T7](
    override val dataInstance: Option[T1],
    override val isAlreadyOk: Boolean,
    override val tail: NatFuncPositive[
      T2,
      NatFuncPositive[T3, NatFuncPositive[T4, NatFuncPositive[T5, NatFuncPositive[T6, NatFuncPositive[T7, NatFuncZero]]]]]
    ]
  ) extends NatFuncPositive[T1, NatFuncPositive[
        T2,
        NatFuncPositive[T3, NatFuncPositive[T4, NatFuncPositive[T5, NatFuncPositive[T6, NatFuncPositive[T7, NatFuncZero]]]]]
      ]](dataInstance) {
    def dataImpl: Any
    def fold[U](func1: T1 => U, func2: T2 => U, func3: T3 => U, func4: T4 => U, func5: T5 => U, func6: T6 => U, func7: T7 => U): U = {
      val dataModel         = dataImpl
      val funcs             = List(func1, func2, func3, func4, func5, func6, func7)
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val data: (Any, Int)  = dataModel.asInstanceOf[(Any, Int)]
      val funcInstance = this
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => U]
      funcInstance(data._1)
    }
  }

  abstract class FoldNatPositiveHelperWrap8[T1, T2, T3, T4, T5, T6, T7, T8](
    override val dataInstance: Option[T1],
    override val isAlreadyOk: Boolean,
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
    def dataImpl: Any
    def fold[U](
      func1: T1 => U,
      func2: T2 => U,
      func3: T3 => U,
      func4: T4 => U,
      func5: T5 => U,
      func6: T6 => U,
      func7: T7 => U,
      func8: T8 => U
    ): U = {
      val dataModel         = dataImpl
      val funcs             = List(func1, func2, func3, func4, func5, func6, func7, func8)
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val data: (Any, Int)  = dataModel.asInstanceOf[(Any, Int)]
      val funcInstance = this
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => U]
      funcInstance(data._1)
    }
  }

  abstract class FoldNatPositiveHelperWrap9[T1, T2, T3, T4, T5, T6, T7, T8, T9](
    override val dataInstance: Option[T1],
    override val isAlreadyOk: Boolean,
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
    def dataImpl: Any
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
    ): U = {
      val dataModel         = dataImpl
      val funcs             = List(func1, func2, func3, func4, func5, func6, func7, func8, func9)
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val data: (Any, Int)  = dataModel.asInstanceOf[(Any, Int)]
      val funcInstance = this
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => U]
      funcInstance(data._1)
    }
  }

  abstract class FoldNatPositiveHelperWrap10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10](
    override val dataInstance: Option[T1],
    override val isAlreadyOk: Boolean,
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
    def dataImpl: Any
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
    ): U = {
      val dataModel         = dataImpl
      val funcs             = List(func1, func2, func3, func4, func5, func6, func7, func8, func9, func10)
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val data: (Any, Int)  = dataModel.asInstanceOf[(Any, Int)]
      val funcInstance = this
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => U]
      funcInstance(data._1)
    }
  }

  abstract class FoldNatPositiveHelperWrap11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11](
    override val dataInstance: Option[T1],
    override val isAlreadyOk: Boolean,
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
    def dataImpl: Any
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
    ): U = {
      val dataModel         = dataImpl
      val funcs             = List(func1, func2, func3, func4, func5, func6, func7, func8, func9, func10, func11)
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val data: (Any, Int)  = dataModel.asInstanceOf[(Any, Int)]
      val funcInstance = this
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => U]
      funcInstance(data._1)
    }
  }

  abstract class FoldNatPositiveHelperWrap12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12](
    override val dataInstance: Option[T1],
    override val isAlreadyOk: Boolean,
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
    def dataImpl: Any
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
    ): U = {
      val dataModel         = dataImpl
      val funcs             = List(func1, func2, func3, func4, func5, func6, func7, func8, func9, func10, func11, func12)
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val data: (Any, Int)  = dataModel.asInstanceOf[(Any, Int)]
      val funcInstance = this
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => U]
      funcInstance(data._1)
    }
  }

  abstract class FoldNatPositiveHelperWrap13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13](
    override val dataInstance: Option[T1],
    override val isAlreadyOk: Boolean,
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
    def dataImpl: Any
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
    ): U = {
      val dataModel         = dataImpl
      val funcs             = List(func1, func2, func3, func4, func5, func6, func7, func8, func9, func10, func11, func12, func13)
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val data: (Any, Int)  = dataModel.asInstanceOf[(Any, Int)]
      val funcInstance = this
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => U]
      funcInstance(data._1)
    }
  }

  abstract class FoldNatPositiveHelperWrap14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14](
    override val dataInstance: Option[T1],
    override val isAlreadyOk: Boolean,
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
    def dataImpl: Any
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
    ): U = {
      val dataModel         = dataImpl
      val funcs             = List(func1, func2, func3, func4, func5, func6, func7, func8, func9, func10, func11, func12, func13, func14)
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val data: (Any, Int)  = dataModel.asInstanceOf[(Any, Int)]
      val funcInstance = this
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => U]
      funcInstance(data._1)
    }
  }

  abstract class FoldNatPositiveHelperWrap15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15](
    override val dataInstance: Option[T1],
    override val isAlreadyOk: Boolean,
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
    def dataImpl: Any
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
    ): U = {
      val dataModel = dataImpl
      val funcs     = List(func1, func2, func3, func4, func5, func6, func7, func8, func9, func10, func11, func12, func13, func14, func15)
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val data: (Any, Int)  = dataModel.asInstanceOf[(Any, Int)]
      val funcInstance = this
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => U]
      funcInstance(data._1)
    }
  }

  abstract class FoldNatPositiveHelperWrap16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16](
    override val dataInstance: Option[T1],
    override val isAlreadyOk: Boolean,
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
    def dataImpl: Any
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
    ): U = {
      val dataModel = dataImpl
      val funcs =
        List(func1, func2, func3, func4, func5, func6, func7, func8, func9, func10, func11, func12, func13, func14, func15, func16)
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val data: (Any, Int)  = dataModel.asInstanceOf[(Any, Int)]
      val funcInstance = this
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => U]
      funcInstance(data._1)
    }
  }

  abstract class FoldNatPositiveHelperWrap17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17](
    override val dataInstance: Option[T1],
    override val isAlreadyOk: Boolean,
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
    def dataImpl: Any
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
    ): U = {
      val dataModel = dataImpl
      val funcs =
        List(func1, func2, func3, func4, func5, func6, func7, func8, func9, func10, func11, func12, func13, func14, func15, func16, func17)
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val data: (Any, Int)  = dataModel.asInstanceOf[(Any, Int)]
      val funcInstance = this
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => U]
      funcInstance(data._1)
    }
  }

  abstract class FoldNatPositiveHelperWrap18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18](
    override val dataInstance: Option[T1],
    override val isAlreadyOk: Boolean,
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
    def dataImpl: Any
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
    ): U = {
      val dataModel = dataImpl
      val funcs = List(
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
      )
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val data: (Any, Int)  = dataModel.asInstanceOf[(Any, Int)]
      val funcInstance = this
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => U]
      funcInstance(data._1)
    }
  }

  abstract class FoldNatPositiveHelperWrap19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19](
    override val dataInstance: Option[T1],
    override val isAlreadyOk: Boolean,
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
    def dataImpl: Any
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
    ): U = {
      val dataModel = dataImpl
      val funcs = List(
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
      )
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val data: (Any, Int)  = dataModel.asInstanceOf[(Any, Int)]
      val funcInstance = this
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => U]
      funcInstance(data._1)
    }
  }

  abstract class FoldNatPositiveHelperWrap20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20](
    override val dataInstance: Option[T1],
    override val isAlreadyOk: Boolean,
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
    def dataImpl: Any
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
    ): U = {
      val dataModel = dataImpl
      val funcs = List(
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
      )
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val data: (Any, Int)  = dataModel.asInstanceOf[(Any, Int)]
      val funcInstance = this
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => U]
      funcInstance(data._1)
    }
  }

  abstract class FoldNatPositiveHelperWrap21[
    T1,
    T2,
    T3,
    T4,
    T5,
    T6,
    T7,
    T8,
    T9,
    T10,
    T11,
    T12,
    T13,
    T14,
    T15,
    T16,
    T17,
    T18,
    T19,
    T20,
    T21
  ](
    override val dataInstance: Option[T1],
    override val isAlreadyOk: Boolean,
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
    def dataImpl: Any
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
    ): U = {
      val dataModel = dataImpl
      val funcs = List(
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
      )
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val data: (Any, Int)  = dataModel.asInstanceOf[(Any, Int)]
      val funcInstance = this
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => U]
      funcInstance(data._1)
    }
  }

  abstract class FoldNatPositiveHelperWrap22[
    T1,
    T2,
    T3,
    T4,
    T5,
    T6,
    T7,
    T8,
    T9,
    T10,
    T11,
    T12,
    T13,
    T14,
    T15,
    T16,
    T17,
    T18,
    T19,
    T20,
    T21,
    T22
  ](
    override val dataInstance: Option[T1],
    override val isAlreadyOk: Boolean,
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
    def dataImpl: Any
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
    ): U = {
      val dataModel = dataImpl
      val funcs = List(
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
      )
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val data: (Any, Int)  = dataModel.asInstanceOf[(Any, Int)]
      val funcInstance = this
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => U]
      funcInstance(data._1)
    }
  }

}
