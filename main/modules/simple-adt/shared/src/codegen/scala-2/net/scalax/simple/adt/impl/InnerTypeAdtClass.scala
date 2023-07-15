package net.scalax.simple
package adt
package impl

import net.scalax.simple.ghdmzsk.ghdmzsk
import implemention._

object InnerTypeAdtClass {

  class PrepareInnerApply1[I1] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, NatFuncPositive[I1, NatFuncZero], Adt.Status.Passed]
    ): FoldNatPositiveHelper.FoldNatPositiveHelperWrap1[I1] = {
      val dataInstanceImpl = v.value(false)(data)
      new FoldNatPositiveHelper.FoldNatPositiveHelperWrap1(
        dataInstanceImpl.dataInstance,
        isAlreadyOk = dataInstanceImpl.isAlreadyOk,
        dataInstanceImpl.tail
      ) {
        override def dataImpl: Any = this
          .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
          .inputGHDMZSK(Disscure.identityGhdmzsk)
          .asInstanceOf[Disscure.GetValue]
          .value
        override def inputGHDMZSK(g: => ghdmzsk): ghdmzsk = dataInstanceImpl.inputGHDMZSK(g)
        override val index: Int                           = dataInstanceImpl.index
      }
    }
  }
  object HelperIOImpl1 extends PrepareInnerApply1[Any]

  class PrepareInnerApply2[I1, I2] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, NatFuncPositive[I1, NatFuncPositive[I2, NatFuncZero]], Adt.Status.Passed]
    ): FoldNatPositiveHelper.FoldNatPositiveHelperWrap2[I1, I2] = {
      val dataInstanceImpl = v.value(false)(data)
      new FoldNatPositiveHelper.FoldNatPositiveHelperWrap2(
        dataInstanceImpl.dataInstance,
        isAlreadyOk = dataInstanceImpl.isAlreadyOk,
        dataInstanceImpl.tail
      ) {
        override def dataImpl: Any = this
          .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
          .inputGHDMZSK(Disscure.identityGhdmzsk)
          .asInstanceOf[Disscure.GetValue]
          .value
        override def inputGHDMZSK(g: => ghdmzsk): ghdmzsk = dataInstanceImpl.inputGHDMZSK(g)
        override val index: Int                           = dataInstanceImpl.index
      }
    }
  }
  object HelperIOImpl2 extends PrepareInnerApply2[Any, Any]

  class PrepareInnerApply3[I1, I2, I3] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, NatFuncPositive[
        I1,
        NatFuncPositive[I2, NatFuncPositive[I3, NatFuncZero]]
      ], Adt.Status.Passed]
    ): FoldNatPositiveHelper.FoldNatPositiveHelperWrap3[I1, I2, I3] = {
      val dataInstanceImpl = v.value(false)(data)
      new FoldNatPositiveHelper.FoldNatPositiveHelperWrap3(
        dataInstanceImpl.dataInstance,
        isAlreadyOk = dataInstanceImpl.isAlreadyOk,
        dataInstanceImpl.tail
      ) {
        override def dataImpl: Any = this
          .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
          .inputGHDMZSK(Disscure.identityGhdmzsk)
          .asInstanceOf[Disscure.GetValue]
          .value
        override def inputGHDMZSK(g: => ghdmzsk): ghdmzsk = dataInstanceImpl.inputGHDMZSK(g)
        override val index: Int                           = dataInstanceImpl.index
      }
    }
  }
  object HelperIOImpl3 extends PrepareInnerApply3[Any, Any, Any]

  class PrepareInnerApply4[I1, I2, I3, I4] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, NatFuncPositive[
        I1,
        NatFuncPositive[I2, NatFuncPositive[I3, NatFuncPositive[I4, NatFuncZero]]]
      ], Adt.Status.Passed]
    ): FoldNatPositiveHelper.FoldNatPositiveHelperWrap4[I1, I2, I3, I4] = {
      val dataInstanceImpl = v.value(false)(data)
      new FoldNatPositiveHelper.FoldNatPositiveHelperWrap4(
        dataInstanceImpl.dataInstance,
        isAlreadyOk = dataInstanceImpl.isAlreadyOk,
        dataInstanceImpl.tail
      ) {
        override def dataImpl: Any = this
          .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
          .inputGHDMZSK(Disscure.identityGhdmzsk)
          .asInstanceOf[Disscure.GetValue]
          .value
        override def inputGHDMZSK(g: => ghdmzsk): ghdmzsk = dataInstanceImpl.inputGHDMZSK(g)
        override val index: Int                           = dataInstanceImpl.index
      }
    }
  }
  object HelperIOImpl4 extends PrepareInnerApply4[Any, Any, Any, Any]

  class PrepareInnerApply5[I1, I2, I3, I4, I5] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[T, NatFuncPositive[
        I1,
        NatFuncPositive[I2, NatFuncPositive[I3, NatFuncPositive[I4, NatFuncPositive[I5, NatFuncZero]]]]
      ], Adt.Status.Passed]
    ): FoldNatPositiveHelper.FoldNatPositiveHelperWrap5[I1, I2, I3, I4, I5] = {
      val dataInstanceImpl = v.value(false)(data)
      new FoldNatPositiveHelper.FoldNatPositiveHelperWrap5(
        dataInstanceImpl.dataInstance,
        isAlreadyOk = dataInstanceImpl.isAlreadyOk,
        dataInstanceImpl.tail
      ) {
        override def dataImpl: Any = this
          .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
          .inputGHDMZSK(Disscure.identityGhdmzsk)
          .asInstanceOf[Disscure.GetValue]
          .value
        override def inputGHDMZSK(g: => ghdmzsk): ghdmzsk = dataInstanceImpl.inputGHDMZSK(g)
        override val index: Int                           = dataInstanceImpl.index
      }
    }
  }
  object HelperIOImpl5 extends PrepareInnerApply5[Any, Any, Any, Any, Any]

  class PrepareInnerApply6[I1, I2, I3, I4, I5, I6] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[
        T,
        NatFuncPositive[
          I1,
          NatFuncPositive[I2, NatFuncPositive[I3, NatFuncPositive[I4, NatFuncPositive[I5, NatFuncPositive[I6, NatFuncZero]]]]]
        ],
        Adt.Status.Passed
      ]
    ): FoldNatPositiveHelper.FoldNatPositiveHelperWrap6[I1, I2, I3, I4, I5, I6] = {
      val dataInstanceImpl = v.value(false)(data)
      new FoldNatPositiveHelper.FoldNatPositiveHelperWrap6(
        dataInstanceImpl.dataInstance,
        isAlreadyOk = dataInstanceImpl.isAlreadyOk,
        dataInstanceImpl.tail
      ) {
        override def dataImpl: Any = this
          .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
          .inputGHDMZSK(Disscure.identityGhdmzsk)
          .asInstanceOf[Disscure.GetValue]
          .value
        override def inputGHDMZSK(g: => ghdmzsk): ghdmzsk = dataInstanceImpl.inputGHDMZSK(g)
        override val index: Int                           = dataInstanceImpl.index
      }
    }
  }
  object HelperIOImpl6 extends PrepareInnerApply6[Any, Any, Any, Any, Any, Any]

  class PrepareInnerApply7[I1, I2, I3, I4, I5, I6, I7] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[
        T,
        NatFuncPositive[I1, NatFuncPositive[
          I2,
          NatFuncPositive[I3, NatFuncPositive[I4, NatFuncPositive[I5, NatFuncPositive[I6, NatFuncPositive[I7, NatFuncZero]]]]]
        ]],
        Adt.Status.Passed
      ]
    ): FoldNatPositiveHelper.FoldNatPositiveHelperWrap7[I1, I2, I3, I4, I5, I6, I7] = {
      val dataInstanceImpl = v.value(false)(data)
      new FoldNatPositiveHelper.FoldNatPositiveHelperWrap7(
        dataInstanceImpl.dataInstance,
        isAlreadyOk = dataInstanceImpl.isAlreadyOk,
        dataInstanceImpl.tail
      ) {
        override def dataImpl: Any = this
          .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
          .inputGHDMZSK(Disscure.identityGhdmzsk)
          .asInstanceOf[Disscure.GetValue]
          .value
        override def inputGHDMZSK(g: => ghdmzsk): ghdmzsk = dataInstanceImpl.inputGHDMZSK(g)
        override val index: Int                           = dataInstanceImpl.index
      }
    }
  }
  object HelperIOImpl7 extends PrepareInnerApply7[Any, Any, Any, Any, Any, Any, Any]

  class PrepareInnerApply8[I1, I2, I3, I4, I5, I6, I7, I8] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[
        T,
        NatFuncPositive[
          I1,
          NatFuncPositive[I2, NatFuncPositive[
            I3,
            NatFuncPositive[I4, NatFuncPositive[I5, NatFuncPositive[I6, NatFuncPositive[I7, NatFuncPositive[I8, NatFuncZero]]]]]
          ]]
        ],
        Adt.Status.Passed
      ]
    ): FoldNatPositiveHelper.FoldNatPositiveHelperWrap8[I1, I2, I3, I4, I5, I6, I7, I8] = {
      val dataInstanceImpl = v.value(false)(data)
      new FoldNatPositiveHelper.FoldNatPositiveHelperWrap8(
        dataInstanceImpl.dataInstance,
        isAlreadyOk = dataInstanceImpl.isAlreadyOk,
        dataInstanceImpl.tail
      ) {
        override def dataImpl: Any = this
          .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
          .inputGHDMZSK(Disscure.identityGhdmzsk)
          .asInstanceOf[Disscure.GetValue]
          .value
        override def inputGHDMZSK(g: => ghdmzsk): ghdmzsk = dataInstanceImpl.inputGHDMZSK(g)
        override val index: Int                           = dataInstanceImpl.index
      }
    }
  }
  object HelperIOImpl8 extends PrepareInnerApply8[Any, Any, Any, Any, Any, Any, Any, Any]

  class PrepareInnerApply9[I1, I2, I3, I4, I5, I6, I7, I8, I9] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[
        T,
        NatFuncPositive[
          I1,
          NatFuncPositive[
            I2,
            NatFuncPositive[I3, NatFuncPositive[
              I4,
              NatFuncPositive[I5, NatFuncPositive[I6, NatFuncPositive[I7, NatFuncPositive[I8, NatFuncPositive[I9, NatFuncZero]]]]]
            ]]
          ]
        ],
        Adt.Status.Passed
      ]
    ): FoldNatPositiveHelper.FoldNatPositiveHelperWrap9[I1, I2, I3, I4, I5, I6, I7, I8, I9] = {
      val dataInstanceImpl = v.value(false)(data)
      new FoldNatPositiveHelper.FoldNatPositiveHelperWrap9(
        dataInstanceImpl.dataInstance,
        isAlreadyOk = dataInstanceImpl.isAlreadyOk,
        dataInstanceImpl.tail
      ) {
        override def dataImpl: Any = this
          .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
          .inputGHDMZSK(Disscure.identityGhdmzsk)
          .asInstanceOf[Disscure.GetValue]
          .value
        override def inputGHDMZSK(g: => ghdmzsk): ghdmzsk = dataInstanceImpl.inputGHDMZSK(g)
        override val index: Int                           = dataInstanceImpl.index
      }
    }
  }
  object HelperIOImpl9 extends PrepareInnerApply9[Any, Any, Any, Any, Any, Any, Any, Any, Any]

  class PrepareInnerApply10[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[
        T,
        NatFuncPositive[
          I1,
          NatFuncPositive[
            I2,
            NatFuncPositive[
              I3,
              NatFuncPositive[I4, NatFuncPositive[
                I5,
                NatFuncPositive[I6, NatFuncPositive[I7, NatFuncPositive[I8, NatFuncPositive[I9, NatFuncPositive[I10, NatFuncZero]]]]]
              ]]
            ]
          ]
        ],
        Adt.Status.Passed
      ]
    ): FoldNatPositiveHelper.FoldNatPositiveHelperWrap10[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] = {
      val dataInstanceImpl = v.value(false)(data)
      new FoldNatPositiveHelper.FoldNatPositiveHelperWrap10(
        dataInstanceImpl.dataInstance,
        isAlreadyOk = dataInstanceImpl.isAlreadyOk,
        dataInstanceImpl.tail
      ) {
        override def dataImpl: Any = this
          .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
          .inputGHDMZSK(Disscure.identityGhdmzsk)
          .asInstanceOf[Disscure.GetValue]
          .value
        override def inputGHDMZSK(g: => ghdmzsk): ghdmzsk = dataInstanceImpl.inputGHDMZSK(g)
        override val index: Int                           = dataInstanceImpl.index
      }
    }
  }
  object HelperIOImpl10 extends PrepareInnerApply10[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]

  class PrepareInnerApply11[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[
        T,
        NatFuncPositive[
          I1,
          NatFuncPositive[
            I2,
            NatFuncPositive[
              I3,
              NatFuncPositive[
                I4,
                NatFuncPositive[I5, NatFuncPositive[
                  I6,
                  NatFuncPositive[I7, NatFuncPositive[I8, NatFuncPositive[I9, NatFuncPositive[I10, NatFuncPositive[I11, NatFuncZero]]]]]
                ]]
              ]
            ]
          ]
        ],
        Adt.Status.Passed
      ]
    ): FoldNatPositiveHelper.FoldNatPositiveHelperWrap11[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] = {
      val dataInstanceImpl = v.value(false)(data)
      new FoldNatPositiveHelper.FoldNatPositiveHelperWrap11(
        dataInstanceImpl.dataInstance,
        isAlreadyOk = dataInstanceImpl.isAlreadyOk,
        dataInstanceImpl.tail
      ) {
        override def dataImpl: Any = this
          .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
          .inputGHDMZSK(Disscure.identityGhdmzsk)
          .asInstanceOf[Disscure.GetValue]
          .value
        override def inputGHDMZSK(g: => ghdmzsk): ghdmzsk = dataInstanceImpl.inputGHDMZSK(g)
        override val index: Int                           = dataInstanceImpl.index
      }
    }
  }
  object HelperIOImpl11 extends PrepareInnerApply11[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]

  class PrepareInnerApply12[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[
        T,
        NatFuncPositive[
          I1,
          NatFuncPositive[
            I2,
            NatFuncPositive[
              I3,
              NatFuncPositive[
                I4,
                NatFuncPositive[
                  I5,
                  NatFuncPositive[I6, NatFuncPositive[
                    I7,
                    NatFuncPositive[I8, NatFuncPositive[I9, NatFuncPositive[I10, NatFuncPositive[I11, NatFuncPositive[I12, NatFuncZero]]]]]
                  ]]
                ]
              ]
            ]
          ]
        ],
        Adt.Status.Passed
      ]
    ): FoldNatPositiveHelper.FoldNatPositiveHelperWrap12[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] = {
      val dataInstanceImpl = v.value(false)(data)
      new FoldNatPositiveHelper.FoldNatPositiveHelperWrap12(
        dataInstanceImpl.dataInstance,
        isAlreadyOk = dataInstanceImpl.isAlreadyOk,
        dataInstanceImpl.tail
      ) {
        override def dataImpl: Any = this
          .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
          .inputGHDMZSK(Disscure.identityGhdmzsk)
          .asInstanceOf[Disscure.GetValue]
          .value
        override def inputGHDMZSK(g: => ghdmzsk): ghdmzsk = dataInstanceImpl.inputGHDMZSK(g)
        override val index: Int                           = dataInstanceImpl.index
      }
    }
  }
  object HelperIOImpl12 extends PrepareInnerApply12[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]

  class PrepareInnerApply13[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[
        T,
        NatFuncPositive[
          I1,
          NatFuncPositive[
            I2,
            NatFuncPositive[
              I3,
              NatFuncPositive[
                I4,
                NatFuncPositive[
                  I5,
                  NatFuncPositive[
                    I6,
                    NatFuncPositive[I7, NatFuncPositive[I8, NatFuncPositive[
                      I9,
                      NatFuncPositive[I10, NatFuncPositive[I11, NatFuncPositive[I12, NatFuncPositive[I13, NatFuncZero]]]]
                    ]]]
                  ]
                ]
              ]
            ]
          ]
        ],
        Adt.Status.Passed
      ]
    ): FoldNatPositiveHelper.FoldNatPositiveHelperWrap13[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] = {
      val dataInstanceImpl = v.value(false)(data)
      new FoldNatPositiveHelper.FoldNatPositiveHelperWrap13(
        dataInstanceImpl.dataInstance,
        isAlreadyOk = dataInstanceImpl.isAlreadyOk,
        dataInstanceImpl.tail
      ) {
        override def dataImpl: Any = this
          .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
          .inputGHDMZSK(Disscure.identityGhdmzsk)
          .asInstanceOf[Disscure.GetValue]
          .value
        override def inputGHDMZSK(g: => ghdmzsk): ghdmzsk = dataInstanceImpl.inputGHDMZSK(g)
        override val index: Int                           = dataInstanceImpl.index
      }
    }
  }
  object HelperIOImpl13 extends PrepareInnerApply13[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]

  class PrepareInnerApply14[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[
        T,
        NatFuncPositive[
          I1,
          NatFuncPositive[
            I2,
            NatFuncPositive[
              I3,
              NatFuncPositive[
                I4,
                NatFuncPositive[
                  I5,
                  NatFuncPositive[
                    I6,
                    NatFuncPositive[
                      I7,
                      NatFuncPositive[I8, NatFuncPositive[I9, NatFuncPositive[
                        I10,
                        NatFuncPositive[I11, NatFuncPositive[I12, NatFuncPositive[I13, NatFuncPositive[I14, NatFuncZero]]]]
                      ]]]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ],
        Adt.Status.Passed
      ]
    ): FoldNatPositiveHelper.FoldNatPositiveHelperWrap14[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] = {
      val dataInstanceImpl = v.value(false)(data)
      new FoldNatPositiveHelper.FoldNatPositiveHelperWrap14(
        dataInstanceImpl.dataInstance,
        isAlreadyOk = dataInstanceImpl.isAlreadyOk,
        dataInstanceImpl.tail
      ) {
        override def dataImpl: Any = this
          .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
          .inputGHDMZSK(Disscure.identityGhdmzsk)
          .asInstanceOf[Disscure.GetValue]
          .value
        override def inputGHDMZSK(g: => ghdmzsk): ghdmzsk = dataInstanceImpl.inputGHDMZSK(g)
        override val index: Int                           = dataInstanceImpl.index
      }
    }
  }
  object HelperIOImpl14 extends PrepareInnerApply14[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]

  class PrepareInnerApply15[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[
        T,
        NatFuncPositive[
          I1,
          NatFuncPositive[
            I2,
            NatFuncPositive[
              I3,
              NatFuncPositive[
                I4,
                NatFuncPositive[
                  I5,
                  NatFuncPositive[
                    I6,
                    NatFuncPositive[
                      I7,
                      NatFuncPositive[
                        I8,
                        NatFuncPositive[I9, NatFuncPositive[I10, NatFuncPositive[
                          I11,
                          NatFuncPositive[I12, NatFuncPositive[I13, NatFuncPositive[I14, NatFuncPositive[I15, NatFuncZero]]]]
                        ]]]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ],
        Adt.Status.Passed
      ]
    ): FoldNatPositiveHelper.FoldNatPositiveHelperWrap15[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] = {
      val dataInstanceImpl = v.value(false)(data)
      new FoldNatPositiveHelper.FoldNatPositiveHelperWrap15(
        dataInstanceImpl.dataInstance,
        isAlreadyOk = dataInstanceImpl.isAlreadyOk,
        dataInstanceImpl.tail
      ) {
        override def dataImpl: Any = this
          .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
          .inputGHDMZSK(Disscure.identityGhdmzsk)
          .asInstanceOf[Disscure.GetValue]
          .value
        override def inputGHDMZSK(g: => ghdmzsk): ghdmzsk = dataInstanceImpl.inputGHDMZSK(g)
        override val index: Int                           = dataInstanceImpl.index
      }
    }
  }
  object HelperIOImpl15 extends PrepareInnerApply15[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]

  class PrepareInnerApply16[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[
        T,
        NatFuncPositive[
          I1,
          NatFuncPositive[
            I2,
            NatFuncPositive[
              I3,
              NatFuncPositive[
                I4,
                NatFuncPositive[
                  I5,
                  NatFuncPositive[
                    I6,
                    NatFuncPositive[
                      I7,
                      NatFuncPositive[
                        I8,
                        NatFuncPositive[
                          I9,
                          NatFuncPositive[I10, NatFuncPositive[I11, NatFuncPositive[
                            I12,
                            NatFuncPositive[I13, NatFuncPositive[I14, NatFuncPositive[I15, NatFuncPositive[I16, NatFuncZero]]]]
                          ]]]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ],
        Adt.Status.Passed
      ]
    ): FoldNatPositiveHelper.FoldNatPositiveHelperWrap16[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] = {
      val dataInstanceImpl = v.value(false)(data)
      new FoldNatPositiveHelper.FoldNatPositiveHelperWrap16(
        dataInstanceImpl.dataInstance,
        isAlreadyOk = dataInstanceImpl.isAlreadyOk,
        dataInstanceImpl.tail
      ) {
        override def dataImpl: Any = this
          .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
          .inputGHDMZSK(Disscure.identityGhdmzsk)
          .asInstanceOf[Disscure.GetValue]
          .value
        override def inputGHDMZSK(g: => ghdmzsk): ghdmzsk = dataInstanceImpl.inputGHDMZSK(g)
        override val index: Int                           = dataInstanceImpl.index
      }
    }
  }
  object HelperIOImpl16 extends PrepareInnerApply16[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]

  class PrepareInnerApply17[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[
        T,
        NatFuncPositive[
          I1,
          NatFuncPositive[
            I2,
            NatFuncPositive[
              I3,
              NatFuncPositive[
                I4,
                NatFuncPositive[
                  I5,
                  NatFuncPositive[
                    I6,
                    NatFuncPositive[
                      I7,
                      NatFuncPositive[
                        I8,
                        NatFuncPositive[
                          I9,
                          NatFuncPositive[
                            I10,
                            NatFuncPositive[I11, NatFuncPositive[I12, NatFuncPositive[
                              I13,
                              NatFuncPositive[I14, NatFuncPositive[I15, NatFuncPositive[I16, NatFuncPositive[I17, NatFuncZero]]]]
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
        ],
        Adt.Status.Passed
      ]
    ): FoldNatPositiveHelper.FoldNatPositiveHelperWrap17[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] = {
      val dataInstanceImpl = v.value(false)(data)
      new FoldNatPositiveHelper.FoldNatPositiveHelperWrap17(
        dataInstanceImpl.dataInstance,
        isAlreadyOk = dataInstanceImpl.isAlreadyOk,
        dataInstanceImpl.tail
      ) {
        override def dataImpl: Any = this
          .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
          .inputGHDMZSK(Disscure.identityGhdmzsk)
          .asInstanceOf[Disscure.GetValue]
          .value
        override def inputGHDMZSK(g: => ghdmzsk): ghdmzsk = dataInstanceImpl.inputGHDMZSK(g)
        override val index: Int                           = dataInstanceImpl.index
      }
    }
  }
  object HelperIOImpl17 extends PrepareInnerApply17[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]

  class PrepareInnerApply18[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[
        T,
        NatFuncPositive[
          I1,
          NatFuncPositive[
            I2,
            NatFuncPositive[
              I3,
              NatFuncPositive[
                I4,
                NatFuncPositive[
                  I5,
                  NatFuncPositive[
                    I6,
                    NatFuncPositive[
                      I7,
                      NatFuncPositive[
                        I8,
                        NatFuncPositive[
                          I9,
                          NatFuncPositive[
                            I10,
                            NatFuncPositive[
                              I11,
                              NatFuncPositive[I12, NatFuncPositive[I13, NatFuncPositive[
                                I14,
                                NatFuncPositive[I15, NatFuncPositive[I16, NatFuncPositive[I17, NatFuncPositive[I18, NatFuncZero]]]]
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
        ],
        Adt.Status.Passed
      ]
    ): FoldNatPositiveHelper.FoldNatPositiveHelperWrap18[
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
      I18
    ] = {
      val dataInstanceImpl = v.value(false)(data)
      new FoldNatPositiveHelper.FoldNatPositiveHelperWrap18(
        dataInstanceImpl.dataInstance,
        isAlreadyOk = dataInstanceImpl.isAlreadyOk,
        dataInstanceImpl.tail
      ) {
        override def dataImpl: Any = this
          .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
          .inputGHDMZSK(Disscure.identityGhdmzsk)
          .asInstanceOf[Disscure.GetValue]
          .value
        override def inputGHDMZSK(g: => ghdmzsk): ghdmzsk = dataInstanceImpl.inputGHDMZSK(g)
        override val index: Int                           = dataInstanceImpl.index
      }
    }
  }
  object HelperIOImpl18
      extends PrepareInnerApply18[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]

  class PrepareInnerApply19[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[
        T,
        NatFuncPositive[
          I1,
          NatFuncPositive[
            I2,
            NatFuncPositive[
              I3,
              NatFuncPositive[
                I4,
                NatFuncPositive[
                  I5,
                  NatFuncPositive[
                    I6,
                    NatFuncPositive[
                      I7,
                      NatFuncPositive[
                        I8,
                        NatFuncPositive[
                          I9,
                          NatFuncPositive[
                            I10,
                            NatFuncPositive[
                              I11,
                              NatFuncPositive[
                                I12,
                                NatFuncPositive[I13, NatFuncPositive[I14, NatFuncPositive[
                                  I15,
                                  NatFuncPositive[I16, NatFuncPositive[I17, NatFuncPositive[I18, NatFuncPositive[I19, NatFuncZero]]]]
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
        ],
        Adt.Status.Passed
      ]
    ): FoldNatPositiveHelper.FoldNatPositiveHelperWrap19[
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
      I19
    ] = {
      val dataInstanceImpl = v.value(false)(data)
      new FoldNatPositiveHelper.FoldNatPositiveHelperWrap19(
        dataInstanceImpl.dataInstance,
        isAlreadyOk = dataInstanceImpl.isAlreadyOk,
        dataInstanceImpl.tail
      ) {
        override def dataImpl: Any = this
          .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
          .inputGHDMZSK(Disscure.identityGhdmzsk)
          .asInstanceOf[Disscure.GetValue]
          .value
        override def inputGHDMZSK(g: => ghdmzsk): ghdmzsk = dataInstanceImpl.inputGHDMZSK(g)
        override val index: Int                           = dataInstanceImpl.index
      }
    }
  }
  object HelperIOImpl19
      extends PrepareInnerApply19[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]

  class PrepareInnerApply20[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[
        T,
        NatFuncPositive[
          I1,
          NatFuncPositive[
            I2,
            NatFuncPositive[
              I3,
              NatFuncPositive[
                I4,
                NatFuncPositive[
                  I5,
                  NatFuncPositive[
                    I6,
                    NatFuncPositive[
                      I7,
                      NatFuncPositive[
                        I8,
                        NatFuncPositive[
                          I9,
                          NatFuncPositive[
                            I10,
                            NatFuncPositive[
                              I11,
                              NatFuncPositive[
                                I12,
                                NatFuncPositive[
                                  I13,
                                  NatFuncPositive[I14, NatFuncPositive[I15, NatFuncPositive[
                                    I16,
                                    NatFuncPositive[I17, NatFuncPositive[I18, NatFuncPositive[I19, NatFuncPositive[I20, NatFuncZero]]]]
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
        ],
        Adt.Status.Passed
      ]
    ): FoldNatPositiveHelper.FoldNatPositiveHelperWrap20[
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
      I20
    ] = {
      val dataInstanceImpl = v.value(false)(data)
      new FoldNatPositiveHelper.FoldNatPositiveHelperWrap20(
        dataInstanceImpl.dataInstance,
        isAlreadyOk = dataInstanceImpl.isAlreadyOk,
        dataInstanceImpl.tail
      ) {
        override def dataImpl: Any = this
          .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
          .inputGHDMZSK(Disscure.identityGhdmzsk)
          .asInstanceOf[Disscure.GetValue]
          .value
        override def inputGHDMZSK(g: => ghdmzsk): ghdmzsk = dataInstanceImpl.inputGHDMZSK(g)
        override val index: Int                           = dataInstanceImpl.index
      }
    }
  }
  object HelperIOImpl20
      extends PrepareInnerApply20[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]

  class PrepareInnerApply21[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[
        T,
        NatFuncPositive[
          I1,
          NatFuncPositive[
            I2,
            NatFuncPositive[
              I3,
              NatFuncPositive[
                I4,
                NatFuncPositive[
                  I5,
                  NatFuncPositive[
                    I6,
                    NatFuncPositive[
                      I7,
                      NatFuncPositive[
                        I8,
                        NatFuncPositive[
                          I9,
                          NatFuncPositive[
                            I10,
                            NatFuncPositive[
                              I11,
                              NatFuncPositive[
                                I12,
                                NatFuncPositive[
                                  I13,
                                  NatFuncPositive[
                                    I14,
                                    NatFuncPositive[I15, NatFuncPositive[I16, NatFuncPositive[
                                      I17,
                                      NatFuncPositive[I18, NatFuncPositive[I19, NatFuncPositive[I20, NatFuncPositive[I21, NatFuncZero]]]]
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
        ],
        Adt.Status.Passed
      ]
    ): FoldNatPositiveHelper.FoldNatPositiveHelperWrap21[
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
      I21
    ] = {
      val dataInstanceImpl = v.value(false)(data)
      new FoldNatPositiveHelper.FoldNatPositiveHelperWrap21(
        dataInstanceImpl.dataInstance,
        isAlreadyOk = dataInstanceImpl.isAlreadyOk,
        dataInstanceImpl.tail
      ) {
        override def dataImpl: Any = this
          .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
          .inputGHDMZSK(Disscure.identityGhdmzsk)
          .asInstanceOf[Disscure.GetValue]
          .value
        override def inputGHDMZSK(g: => ghdmzsk): ghdmzsk = dataInstanceImpl.inputGHDMZSK(g)
        override val index: Int                           = dataInstanceImpl.index
      }
    }
  }
  object HelperIOImpl21
      extends PrepareInnerApply21[Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any]

  class PrepareInnerApply22[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22] {
    @inline def apply[T](data: T)(implicit
      v: net.scalax.simple.adt.TypeAdtApply.Aux[
        T,
        NatFuncPositive[
          I1,
          NatFuncPositive[
            I2,
            NatFuncPositive[
              I3,
              NatFuncPositive[
                I4,
                NatFuncPositive[
                  I5,
                  NatFuncPositive[
                    I6,
                    NatFuncPositive[
                      I7,
                      NatFuncPositive[
                        I8,
                        NatFuncPositive[
                          I9,
                          NatFuncPositive[
                            I10,
                            NatFuncPositive[
                              I11,
                              NatFuncPositive[
                                I12,
                                NatFuncPositive[
                                  I13,
                                  NatFuncPositive[
                                    I14,
                                    NatFuncPositive[
                                      I15,
                                      NatFuncPositive[I16, NatFuncPositive[I17, NatFuncPositive[
                                        I18,
                                        NatFuncPositive[I19, NatFuncPositive[I20, NatFuncPositive[I21, NatFuncPositive[I22, NatFuncZero]]]]
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
        ],
        Adt.Status.Passed
      ]
    ): FoldNatPositiveHelper.FoldNatPositiveHelperWrap22[
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
    ] = {
      val dataInstanceImpl = v.value(false)(data)
      new FoldNatPositiveHelper.FoldNatPositiveHelperWrap22(
        dataInstanceImpl.dataInstance,
        isAlreadyOk = dataInstanceImpl.isAlreadyOk,
        dataInstanceImpl.tail
      ) {
        override def dataImpl: Any = this
          .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
          .inputGHDMZSK(Disscure.identityGhdmzsk)
          .asInstanceOf[Disscure.GetValue]
          .value
        override def inputGHDMZSK(g: => ghdmzsk): ghdmzsk = dataInstanceImpl.inputGHDMZSK(g)
        override val index: Int                           = dataInstanceImpl.index
      }
    }
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

}
