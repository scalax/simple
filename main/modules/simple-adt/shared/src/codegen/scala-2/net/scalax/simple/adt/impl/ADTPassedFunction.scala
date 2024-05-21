package net.scalax.simple.adt
package impl

import net.scalax.simple.ghdmzsk.ghdmzsk
import temp._
import Adt.{Status => ADTStatus}
import net.scalax.simple.adt.{RuntimeData, RuntimeNat, RuntimeZero}
import builder.{coproducter, producter_build}

trait ADTPassedFunction {

  implicit class extra1[ParamType, I1, Poly1, SImpl <: ADTStatus](data1: ADTData[RuntimeData[I1, RuntimeZero], SImpl])
      extends ADTData[RuntimeData[I1, RuntimeZero], SImpl] {

    override def toGHDMZSK: ghdmzsk = data1.toGHDMZSK

    def fold[D](func1: I1 => D): D = {
      val func_link: ghdmzsk = producter_build.appended(func1).inputGHDMZSK(() => producter_build.zero)

      TypeAdtGetter.getFromFunction(data1.toGHDMZSK, func_link).asInstanceOf[D]
    }

  }

  implicit class extra2[ParamType, I1, I2, Poly1, Poly2, SImpl <: ADTStatus](
    data2: ADTData[RuntimeData[I2, RuntimeData[I1, RuntimeZero]], SImpl]
  ) extends ADTData[RuntimeData[I2, RuntimeData[I1, RuntimeZero]], SImpl] {

    override def toGHDMZSK: ghdmzsk = data2.toGHDMZSK

    def fold[D](func2: I2 => D, func1: I1 => D): D = {
      val func_link: ghdmzsk =
        producter_build.appended(func1).inputGHDMZSK(() => producter_build.appended(func2).inputGHDMZSK(() => producter_build.zero))

      TypeAdtGetter.getFromFunction(data2.toGHDMZSK, func_link).asInstanceOf[D]
    }

  }

  implicit class extra3[ParamType, I1, I2, I3, Poly1, Poly2, Poly3, SImpl <: ADTStatus](
    data3: ADTData[RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]], SImpl]
  ) extends ADTData[RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]], SImpl] {

    override def toGHDMZSK: ghdmzsk = data3.toGHDMZSK

    def fold[D](func3: I3 => D, func2: I2 => D, func1: I1 => D): D = {
      val func_link: ghdmzsk = producter_build
        .appended(func1)
        .inputGHDMZSK(() =>
          producter_build.appended(func2).inputGHDMZSK(() => producter_build.appended(func3).inputGHDMZSK(() => producter_build.zero))
        )

      TypeAdtGetter.getFromFunction(data3.toGHDMZSK, func_link).asInstanceOf[D]
    }

  }

  implicit class extra4[ParamType, I1, I2, I3, I4, Poly1, Poly2, Poly3, Poly4, SImpl <: ADTStatus](
    data4: ADTData[RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]], SImpl]
  ) extends ADTData[RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]], SImpl] {

    override def toGHDMZSK: ghdmzsk = data4.toGHDMZSK

    def fold[D](func4: I4 => D, func3: I3 => D, func2: I2 => D, func1: I1 => D): D = {
      val func_link: ghdmzsk = producter_build
        .appended(func1)
        .inputGHDMZSK(() =>
          producter_build
            .appended(func2)
            .inputGHDMZSK(() =>
              producter_build.appended(func3).inputGHDMZSK(() => producter_build.appended(func4).inputGHDMZSK(() => producter_build.zero))
            )
        )

      TypeAdtGetter.getFromFunction(data4.toGHDMZSK, func_link).asInstanceOf[D]
    }

  }

  implicit class extra5[ParamType, I1, I2, I3, I4, I5, Poly1, Poly2, Poly3, Poly4, Poly5, SImpl <: ADTStatus](
    data5: ADTData[RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]], SImpl]
  ) extends ADTData[RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]], SImpl] {

    override def toGHDMZSK: ghdmzsk = data5.toGHDMZSK

    def fold[D](func5: I5 => D, func4: I4 => D, func3: I3 => D, func2: I2 => D, func1: I1 => D): D = {
      val func_link: ghdmzsk = producter_build
        .appended(func1)
        .inputGHDMZSK(() =>
          producter_build
            .appended(func2)
            .inputGHDMZSK(() =>
              producter_build
                .appended(func3)
                .inputGHDMZSK(() =>
                  producter_build
                    .appended(func4)
                    .inputGHDMZSK(() => producter_build.appended(func5).inputGHDMZSK(() => producter_build.zero))
                )
            )
        )

      TypeAdtGetter.getFromFunction(data5.toGHDMZSK, func_link).asInstanceOf[D]
    }

  }

  implicit class extra6[ParamType, I1, I2, I3, I4, I5, I6, Poly1, Poly2, Poly3, Poly4, Poly5, Poly6, SImpl <: ADTStatus](
    data6: ADTData[RuntimeData[I6, RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]], SImpl]
  ) extends ADTData[
        RuntimeData[I6, RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]],
        SImpl
      ] {

    override def toGHDMZSK: ghdmzsk = data6.toGHDMZSK

    def fold[D](func6: I6 => D, func5: I5 => D, func4: I4 => D, func3: I3 => D, func2: I2 => D, func1: I1 => D): D = {
      val func_link: ghdmzsk = producter_build
        .appended(func1)
        .inputGHDMZSK(() =>
          producter_build
            .appended(func2)
            .inputGHDMZSK(() =>
              producter_build
                .appended(func3)
                .inputGHDMZSK(() =>
                  producter_build
                    .appended(func4)
                    .inputGHDMZSK(() =>
                      producter_build
                        .appended(func5)
                        .inputGHDMZSK(() => producter_build.appended(func6).inputGHDMZSK(() => producter_build.zero))
                    )
                )
            )
        )

      TypeAdtGetter.getFromFunction(data6.toGHDMZSK, func_link).asInstanceOf[D]
    }

  }

  implicit class extra7[ParamType, I1, I2, I3, I4, I5, I6, I7, Poly1, Poly2, Poly3, Poly4, Poly5, Poly6, Poly7, SImpl <: ADTStatus](
    data7: ADTData[
      RuntimeData[I7, RuntimeData[I6, RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]]],
      SImpl
    ]
  ) extends ADTData[
        RuntimeData[I7, RuntimeData[I6, RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]]],
        SImpl
      ] {

    override def toGHDMZSK: ghdmzsk = data7.toGHDMZSK

    def fold[D](func7: I7 => D, func6: I6 => D, func5: I5 => D, func4: I4 => D, func3: I3 => D, func2: I2 => D, func1: I1 => D): D = {
      val func_link: ghdmzsk = producter_build
        .appended(func1)
        .inputGHDMZSK(() =>
          producter_build
            .appended(func2)
            .inputGHDMZSK(() =>
              producter_build
                .appended(func3)
                .inputGHDMZSK(() =>
                  producter_build
                    .appended(func4)
                    .inputGHDMZSK(() =>
                      producter_build
                        .appended(func5)
                        .inputGHDMZSK(() =>
                          producter_build
                            .appended(func6)
                            .inputGHDMZSK(() => producter_build.appended(func7).inputGHDMZSK(() => producter_build.zero))
                        )
                    )
                )
            )
        )

      TypeAdtGetter.getFromFunction(data7.toGHDMZSK, func_link).asInstanceOf[D]
    }

  }

  implicit class extra8[
    ParamType,
    I1,
    I2,
    I3,
    I4,
    I5,
    I6,
    I7,
    I8,
    Poly1,
    Poly2,
    Poly3,
    Poly4,
    Poly5,
    Poly6,
    Poly7,
    Poly8,
    SImpl <: ADTStatus
  ](
    data8: ADTData[RuntimeData[
      I8,
      RuntimeData[I7, RuntimeData[I6, RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]]]
    ], SImpl]
  ) extends ADTData[RuntimeData[
        I8,
        RuntimeData[I7, RuntimeData[I6, RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]]]
      ], SImpl] {

    override def toGHDMZSK: ghdmzsk = data8.toGHDMZSK

    def fold[D](
      func8: I8 => D,
      func7: I7 => D,
      func6: I6 => D,
      func5: I5 => D,
      func4: I4 => D,
      func3: I3 => D,
      func2: I2 => D,
      func1: I1 => D
    ): D = {
      val func_link: ghdmzsk = producter_build
        .appended(func1)
        .inputGHDMZSK(() =>
          producter_build
            .appended(func2)
            .inputGHDMZSK(() =>
              producter_build
                .appended(func3)
                .inputGHDMZSK(() =>
                  producter_build
                    .appended(func4)
                    .inputGHDMZSK(() =>
                      producter_build
                        .appended(func5)
                        .inputGHDMZSK(() =>
                          producter_build
                            .appended(func6)
                            .inputGHDMZSK(() =>
                              producter_build
                                .appended(func7)
                                .inputGHDMZSK(() => producter_build.appended(func8).inputGHDMZSK(() => producter_build.zero))
                            )
                        )
                    )
                )
            )
        )

      TypeAdtGetter.getFromFunction(data8.toGHDMZSK, func_link).asInstanceOf[D]
    }

  }

  implicit class extra9[
    ParamType,
    I1,
    I2,
    I3,
    I4,
    I5,
    I6,
    I7,
    I8,
    I9,
    Poly1,
    Poly2,
    Poly3,
    Poly4,
    Poly5,
    Poly6,
    Poly7,
    Poly8,
    Poly9,
    SImpl <: ADTStatus
  ](
    data9: ADTData[
      RuntimeData[I9, RuntimeData[
        I8,
        RuntimeData[I7, RuntimeData[I6, RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]]]
      ]],
      SImpl
    ]
  ) extends ADTData[
        RuntimeData[I9, RuntimeData[
          I8,
          RuntimeData[I7, RuntimeData[I6, RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]]]
        ]],
        SImpl
      ] {

    override def toGHDMZSK: ghdmzsk = data9.toGHDMZSK

    def fold[D](
      func9: I9 => D,
      func8: I8 => D,
      func7: I7 => D,
      func6: I6 => D,
      func5: I5 => D,
      func4: I4 => D,
      func3: I3 => D,
      func2: I2 => D,
      func1: I1 => D
    ): D = {
      val func_link: ghdmzsk = producter_build
        .appended(func1)
        .inputGHDMZSK(() =>
          producter_build
            .appended(func2)
            .inputGHDMZSK(() =>
              producter_build
                .appended(func3)
                .inputGHDMZSK(() =>
                  producter_build
                    .appended(func4)
                    .inputGHDMZSK(() =>
                      producter_build
                        .appended(func5)
                        .inputGHDMZSK(() =>
                          producter_build
                            .appended(func6)
                            .inputGHDMZSK(() =>
                              producter_build
                                .appended(func7)
                                .inputGHDMZSK(() =>
                                  producter_build
                                    .appended(func8)
                                    .inputGHDMZSK(() => producter_build.appended(func9).inputGHDMZSK(() => producter_build.zero))
                                )
                            )
                        )
                    )
                )
            )
        )

      TypeAdtGetter.getFromFunction(data9.toGHDMZSK, func_link).asInstanceOf[D]
    }

  }

  implicit class extra10[
    ParamType,
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
    Poly1,
    Poly2,
    Poly3,
    Poly4,
    Poly5,
    Poly6,
    Poly7,
    Poly8,
    Poly9,
    Poly10,
    SImpl <: ADTStatus
  ](
    data10: ADTData[
      RuntimeData[
        I10,
        RuntimeData[I9, RuntimeData[
          I8,
          RuntimeData[I7, RuntimeData[I6, RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]]]
        ]]
      ],
      SImpl
    ]
  ) extends ADTData[
        RuntimeData[
          I10,
          RuntimeData[I9, RuntimeData[I8, RuntimeData[
            I7,
            RuntimeData[I6, RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]]
          ]]]
        ],
        SImpl
      ] {

    override def toGHDMZSK: ghdmzsk = data10.toGHDMZSK

    def fold[D](
      func10: I10 => D,
      func9: I9 => D,
      func8: I8 => D,
      func7: I7 => D,
      func6: I6 => D,
      func5: I5 => D,
      func4: I4 => D,
      func3: I3 => D,
      func2: I2 => D,
      func1: I1 => D
    ): D = {
      val func_link: ghdmzsk = producter_build
        .appended(func1)
        .inputGHDMZSK(() =>
          producter_build
            .appended(func2)
            .inputGHDMZSK(() =>
              producter_build
                .appended(func3)
                .inputGHDMZSK(() =>
                  producter_build
                    .appended(func4)
                    .inputGHDMZSK(() =>
                      producter_build
                        .appended(func5)
                        .inputGHDMZSK(() =>
                          producter_build
                            .appended(func6)
                            .inputGHDMZSK(() =>
                              producter_build
                                .appended(func7)
                                .inputGHDMZSK(() =>
                                  producter_build
                                    .appended(func8)
                                    .inputGHDMZSK(() =>
                                      producter_build
                                        .appended(func9)
                                        .inputGHDMZSK(() => producter_build.appended(func10).inputGHDMZSK(() => producter_build.zero))
                                    )
                                )
                            )
                        )
                    )
                )
            )
        )

      TypeAdtGetter.getFromFunction(data10.toGHDMZSK, func_link).asInstanceOf[D]
    }

  }

  implicit class extra11[
    ParamType,
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
    Poly1,
    Poly2,
    Poly3,
    Poly4,
    Poly5,
    Poly6,
    Poly7,
    Poly8,
    Poly9,
    Poly10,
    Poly11,
    SImpl <: ADTStatus
  ](
    data11: ADTData[
      RuntimeData[
        I11,
        RuntimeData[
          I10,
          RuntimeData[I9, RuntimeData[I8, RuntimeData[
            I7,
            RuntimeData[I6, RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]]
          ]]]
        ]
      ],
      SImpl
    ]
  ) extends ADTData[
        RuntimeData[
          I11,
          RuntimeData[
            I10,
            RuntimeData[I9, RuntimeData[I8, RuntimeData[
              I7,
              RuntimeData[I6, RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]]
            ]]]
          ]
        ],
        SImpl
      ] {

    override def toGHDMZSK: ghdmzsk = data11.toGHDMZSK

    def fold[D](
      func11: I11 => D,
      func10: I10 => D,
      func9: I9 => D,
      func8: I8 => D,
      func7: I7 => D,
      func6: I6 => D,
      func5: I5 => D,
      func4: I4 => D,
      func3: I3 => D,
      func2: I2 => D,
      func1: I1 => D
    ): D = {
      val func_link: ghdmzsk = producter_build
        .appended(func1)
        .inputGHDMZSK(() =>
          producter_build
            .appended(func2)
            .inputGHDMZSK(() =>
              producter_build
                .appended(func3)
                .inputGHDMZSK(() =>
                  producter_build
                    .appended(func4)
                    .inputGHDMZSK(() =>
                      producter_build
                        .appended(func5)
                        .inputGHDMZSK(() =>
                          producter_build
                            .appended(func6)
                            .inputGHDMZSK(() =>
                              producter_build
                                .appended(func7)
                                .inputGHDMZSK(() =>
                                  producter_build
                                    .appended(func8)
                                    .inputGHDMZSK(() =>
                                      producter_build
                                        .appended(func9)
                                        .inputGHDMZSK(() =>
                                          producter_build
                                            .appended(func10)
                                            .inputGHDMZSK(() => producter_build.appended(func11).inputGHDMZSK(() => producter_build.zero))
                                        )
                                    )
                                )
                            )
                        )
                    )
                )
            )
        )

      TypeAdtGetter.getFromFunction(data11.toGHDMZSK, func_link).asInstanceOf[D]
    }

  }

  implicit class extra12[
    ParamType,
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
    Poly1,
    Poly2,
    Poly3,
    Poly4,
    Poly5,
    Poly6,
    Poly7,
    Poly8,
    Poly9,
    Poly10,
    Poly11,
    Poly12,
    SImpl <: ADTStatus
  ](
    data12: ADTData[
      RuntimeData[
        I12,
        RuntimeData[
          I11,
          RuntimeData[
            I10,
            RuntimeData[I9, RuntimeData[I8, RuntimeData[
              I7,
              RuntimeData[I6, RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]]
            ]]]
          ]
        ]
      ],
      SImpl
    ]
  ) extends ADTData[
        RuntimeData[
          I12,
          RuntimeData[
            I11,
            RuntimeData[
              I10,
              RuntimeData[I9, RuntimeData[I8, RuntimeData[
                I7,
                RuntimeData[I6, RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]]
              ]]]
            ]
          ]
        ],
        SImpl
      ] {

    override def toGHDMZSK: ghdmzsk = data12.toGHDMZSK

    def fold[D](
      func12: I12 => D,
      func11: I11 => D,
      func10: I10 => D,
      func9: I9 => D,
      func8: I8 => D,
      func7: I7 => D,
      func6: I6 => D,
      func5: I5 => D,
      func4: I4 => D,
      func3: I3 => D,
      func2: I2 => D,
      func1: I1 => D
    ): D = {
      val func_link: ghdmzsk = producter_build
        .appended(func1)
        .inputGHDMZSK(() =>
          producter_build
            .appended(func2)
            .inputGHDMZSK(() =>
              producter_build
                .appended(func3)
                .inputGHDMZSK(() =>
                  producter_build
                    .appended(func4)
                    .inputGHDMZSK(() =>
                      producter_build
                        .appended(func5)
                        .inputGHDMZSK(() =>
                          producter_build
                            .appended(func6)
                            .inputGHDMZSK(() =>
                              producter_build
                                .appended(func7)
                                .inputGHDMZSK(() =>
                                  producter_build
                                    .appended(func8)
                                    .inputGHDMZSK(() =>
                                      producter_build
                                        .appended(func9)
                                        .inputGHDMZSK(() =>
                                          producter_build
                                            .appended(func10)
                                            .inputGHDMZSK(() =>
                                              producter_build
                                                .appended(func11)
                                                .inputGHDMZSK(() =>
                                                  producter_build.appended(func12).inputGHDMZSK(() => producter_build.zero)
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

      TypeAdtGetter.getFromFunction(data12.toGHDMZSK, func_link).asInstanceOf[D]
    }

  }

  implicit class extra13[
    ParamType,
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
    Poly1,
    Poly2,
    Poly3,
    Poly4,
    Poly5,
    Poly6,
    Poly7,
    Poly8,
    Poly9,
    Poly10,
    Poly11,
    Poly12,
    Poly13,
    SImpl <: ADTStatus
  ](
    data13: ADTData[
      RuntimeData[
        I13,
        RuntimeData[
          I12,
          RuntimeData[
            I11,
            RuntimeData[
              I10,
              RuntimeData[I9, RuntimeData[I8, RuntimeData[
                I7,
                RuntimeData[I6, RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]]
              ]]]
            ]
          ]
        ]
      ],
      SImpl
    ]
  ) extends ADTData[
        RuntimeData[
          I13,
          RuntimeData[
            I12,
            RuntimeData[
              I11,
              RuntimeData[
                I10,
                RuntimeData[I9, RuntimeData[I8, RuntimeData[
                  I7,
                  RuntimeData[I6, RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]]
                ]]]
              ]
            ]
          ]
        ],
        SImpl
      ] {

    override def toGHDMZSK: ghdmzsk = data13.toGHDMZSK

    def fold[D](
      func13: I13 => D,
      func12: I12 => D,
      func11: I11 => D,
      func10: I10 => D,
      func9: I9 => D,
      func8: I8 => D,
      func7: I7 => D,
      func6: I6 => D,
      func5: I5 => D,
      func4: I4 => D,
      func3: I3 => D,
      func2: I2 => D,
      func1: I1 => D
    ): D = {
      val func_link: ghdmzsk = producter_build
        .appended(func1)
        .inputGHDMZSK(() =>
          producter_build
            .appended(func2)
            .inputGHDMZSK(() =>
              producter_build
                .appended(func3)
                .inputGHDMZSK(() =>
                  producter_build
                    .appended(func4)
                    .inputGHDMZSK(() =>
                      producter_build
                        .appended(func5)
                        .inputGHDMZSK(() =>
                          producter_build
                            .appended(func6)
                            .inputGHDMZSK(() =>
                              producter_build
                                .appended(func7)
                                .inputGHDMZSK(() =>
                                  producter_build
                                    .appended(func8)
                                    .inputGHDMZSK(() =>
                                      producter_build
                                        .appended(func9)
                                        .inputGHDMZSK(() =>
                                          producter_build
                                            .appended(func10)
                                            .inputGHDMZSK(() =>
                                              producter_build
                                                .appended(func11)
                                                .inputGHDMZSK(() =>
                                                  producter_build
                                                    .appended(func12)
                                                    .inputGHDMZSK(() =>
                                                      producter_build.appended(func13).inputGHDMZSK(() => producter_build.zero)
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

      TypeAdtGetter.getFromFunction(data13.toGHDMZSK, func_link).asInstanceOf[D]
    }

  }

  implicit class extra14[
    ParamType,
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
    Poly1,
    Poly2,
    Poly3,
    Poly4,
    Poly5,
    Poly6,
    Poly7,
    Poly8,
    Poly9,
    Poly10,
    Poly11,
    Poly12,
    Poly13,
    Poly14,
    SImpl <: ADTStatus
  ](
    data14: ADTData[
      RuntimeData[
        I14,
        RuntimeData[
          I13,
          RuntimeData[
            I12,
            RuntimeData[
              I11,
              RuntimeData[
                I10,
                RuntimeData[I9, RuntimeData[I8, RuntimeData[
                  I7,
                  RuntimeData[I6, RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]]
                ]]]
              ]
            ]
          ]
        ]
      ],
      SImpl
    ]
  ) extends ADTData[
        RuntimeData[
          I14,
          RuntimeData[
            I13,
            RuntimeData[
              I12,
              RuntimeData[
                I11,
                RuntimeData[
                  I10,
                  RuntimeData[I9, RuntimeData[I8, RuntimeData[
                    I7,
                    RuntimeData[I6, RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]]
                  ]]]
                ]
              ]
            ]
          ]
        ],
        SImpl
      ] {

    override def toGHDMZSK: ghdmzsk = data14.toGHDMZSK

    def fold[D](
      func14: I14 => D,
      func13: I13 => D,
      func12: I12 => D,
      func11: I11 => D,
      func10: I10 => D,
      func9: I9 => D,
      func8: I8 => D,
      func7: I7 => D,
      func6: I6 => D,
      func5: I5 => D,
      func4: I4 => D,
      func3: I3 => D,
      func2: I2 => D,
      func1: I1 => D
    ): D = {
      val func_link: ghdmzsk = producter_build
        .appended(func1)
        .inputGHDMZSK(() =>
          producter_build
            .appended(func2)
            .inputGHDMZSK(() =>
              producter_build
                .appended(func3)
                .inputGHDMZSK(() =>
                  producter_build
                    .appended(func4)
                    .inputGHDMZSK(() =>
                      producter_build
                        .appended(func5)
                        .inputGHDMZSK(() =>
                          producter_build
                            .appended(func6)
                            .inputGHDMZSK(() =>
                              producter_build
                                .appended(func7)
                                .inputGHDMZSK(() =>
                                  producter_build
                                    .appended(func8)
                                    .inputGHDMZSK(() =>
                                      producter_build
                                        .appended(func9)
                                        .inputGHDMZSK(() =>
                                          producter_build
                                            .appended(func10)
                                            .inputGHDMZSK(() =>
                                              producter_build
                                                .appended(func11)
                                                .inputGHDMZSK(() =>
                                                  producter_build
                                                    .appended(func12)
                                                    .inputGHDMZSK(() =>
                                                      producter_build
                                                        .appended(func13)
                                                        .inputGHDMZSK(() =>
                                                          producter_build.appended(func14).inputGHDMZSK(() => producter_build.zero)
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

      TypeAdtGetter.getFromFunction(data14.toGHDMZSK, func_link).asInstanceOf[D]
    }

  }

  implicit class extra15[
    ParamType,
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
    Poly1,
    Poly2,
    Poly3,
    Poly4,
    Poly5,
    Poly6,
    Poly7,
    Poly8,
    Poly9,
    Poly10,
    Poly11,
    Poly12,
    Poly13,
    Poly14,
    Poly15,
    SImpl <: ADTStatus
  ](
    data15: ADTData[
      RuntimeData[
        I15,
        RuntimeData[
          I14,
          RuntimeData[
            I13,
            RuntimeData[
              I12,
              RuntimeData[
                I11,
                RuntimeData[
                  I10,
                  RuntimeData[I9, RuntimeData[I8, RuntimeData[
                    I7,
                    RuntimeData[I6, RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]]
                  ]]]
                ]
              ]
            ]
          ]
        ]
      ],
      SImpl
    ]
  ) extends ADTData[
        RuntimeData[
          I15,
          RuntimeData[
            I14,
            RuntimeData[
              I13,
              RuntimeData[
                I12,
                RuntimeData[
                  I11,
                  RuntimeData[
                    I10,
                    RuntimeData[I9, RuntimeData[I8, RuntimeData[
                      I7,
                      RuntimeData[I6, RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]]
                    ]]]
                  ]
                ]
              ]
            ]
          ]
        ],
        SImpl
      ] {

    override def toGHDMZSK: ghdmzsk = data15.toGHDMZSK

    def fold[D](
      func15: I15 => D,
      func14: I14 => D,
      func13: I13 => D,
      func12: I12 => D,
      func11: I11 => D,
      func10: I10 => D,
      func9: I9 => D,
      func8: I8 => D,
      func7: I7 => D,
      func6: I6 => D,
      func5: I5 => D,
      func4: I4 => D,
      func3: I3 => D,
      func2: I2 => D,
      func1: I1 => D
    ): D = {
      val func_link: ghdmzsk = producter_build
        .appended(func1)
        .inputGHDMZSK(() =>
          producter_build
            .appended(func2)
            .inputGHDMZSK(() =>
              producter_build
                .appended(func3)
                .inputGHDMZSK(() =>
                  producter_build
                    .appended(func4)
                    .inputGHDMZSK(() =>
                      producter_build
                        .appended(func5)
                        .inputGHDMZSK(() =>
                          producter_build
                            .appended(func6)
                            .inputGHDMZSK(() =>
                              producter_build
                                .appended(func7)
                                .inputGHDMZSK(() =>
                                  producter_build
                                    .appended(func8)
                                    .inputGHDMZSK(() =>
                                      producter_build
                                        .appended(func9)
                                        .inputGHDMZSK(() =>
                                          producter_build
                                            .appended(func10)
                                            .inputGHDMZSK(() =>
                                              producter_build
                                                .appended(func11)
                                                .inputGHDMZSK(() =>
                                                  producter_build
                                                    .appended(func12)
                                                    .inputGHDMZSK(() =>
                                                      producter_build
                                                        .appended(func13)
                                                        .inputGHDMZSK(() =>
                                                          producter_build
                                                            .appended(func14)
                                                            .inputGHDMZSK(() =>
                                                              producter_build.appended(func15).inputGHDMZSK(() => producter_build.zero)
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

      TypeAdtGetter.getFromFunction(data15.toGHDMZSK, func_link).asInstanceOf[D]
    }

  }

  implicit class extra16[
    ParamType,
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
    Poly1,
    Poly2,
    Poly3,
    Poly4,
    Poly5,
    Poly6,
    Poly7,
    Poly8,
    Poly9,
    Poly10,
    Poly11,
    Poly12,
    Poly13,
    Poly14,
    Poly15,
    Poly16,
    SImpl <: ADTStatus
  ](
    data16: ADTData[
      RuntimeData[
        I16,
        RuntimeData[
          I15,
          RuntimeData[
            I14,
            RuntimeData[
              I13,
              RuntimeData[
                I12,
                RuntimeData[
                  I11,
                  RuntimeData[
                    I10,
                    RuntimeData[I9, RuntimeData[I8, RuntimeData[
                      I7,
                      RuntimeData[I6, RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]]
                    ]]]
                  ]
                ]
              ]
            ]
          ]
        ]
      ],
      SImpl
    ]
  ) extends ADTData[
        RuntimeData[
          I16,
          RuntimeData[
            I15,
            RuntimeData[
              I14,
              RuntimeData[
                I13,
                RuntimeData[
                  I12,
                  RuntimeData[
                    I11,
                    RuntimeData[
                      I10,
                      RuntimeData[I9, RuntimeData[I8, RuntimeData[
                        I7,
                        RuntimeData[I6, RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]]
                      ]]]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ],
        SImpl
      ] {

    override def toGHDMZSK: ghdmzsk = data16.toGHDMZSK

    def fold[D](
      func16: I16 => D,
      func15: I15 => D,
      func14: I14 => D,
      func13: I13 => D,
      func12: I12 => D,
      func11: I11 => D,
      func10: I10 => D,
      func9: I9 => D,
      func8: I8 => D,
      func7: I7 => D,
      func6: I6 => D,
      func5: I5 => D,
      func4: I4 => D,
      func3: I3 => D,
      func2: I2 => D,
      func1: I1 => D
    ): D = {
      val func_link: ghdmzsk = producter_build
        .appended(func1)
        .inputGHDMZSK(() =>
          producter_build
            .appended(func2)
            .inputGHDMZSK(() =>
              producter_build
                .appended(func3)
                .inputGHDMZSK(() =>
                  producter_build
                    .appended(func4)
                    .inputGHDMZSK(() =>
                      producter_build
                        .appended(func5)
                        .inputGHDMZSK(() =>
                          producter_build
                            .appended(func6)
                            .inputGHDMZSK(() =>
                              producter_build
                                .appended(func7)
                                .inputGHDMZSK(() =>
                                  producter_build
                                    .appended(func8)
                                    .inputGHDMZSK(() =>
                                      producter_build
                                        .appended(func9)
                                        .inputGHDMZSK(() =>
                                          producter_build
                                            .appended(func10)
                                            .inputGHDMZSK(() =>
                                              producter_build
                                                .appended(func11)
                                                .inputGHDMZSK(() =>
                                                  producter_build
                                                    .appended(func12)
                                                    .inputGHDMZSK(() =>
                                                      producter_build
                                                        .appended(func13)
                                                        .inputGHDMZSK(() =>
                                                          producter_build
                                                            .appended(func14)
                                                            .inputGHDMZSK(() =>
                                                              producter_build
                                                                .appended(func15)
                                                                .inputGHDMZSK(() =>
                                                                  producter_build.appended(func16).inputGHDMZSK(() => producter_build.zero)
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

      TypeAdtGetter.getFromFunction(data16.toGHDMZSK, func_link).asInstanceOf[D]
    }

  }

  implicit class extra17[
    ParamType,
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
    Poly1,
    Poly2,
    Poly3,
    Poly4,
    Poly5,
    Poly6,
    Poly7,
    Poly8,
    Poly9,
    Poly10,
    Poly11,
    Poly12,
    Poly13,
    Poly14,
    Poly15,
    Poly16,
    Poly17,
    SImpl <: ADTStatus
  ](
    data17: ADTData[
      RuntimeData[
        I17,
        RuntimeData[
          I16,
          RuntimeData[
            I15,
            RuntimeData[
              I14,
              RuntimeData[
                I13,
                RuntimeData[
                  I12,
                  RuntimeData[
                    I11,
                    RuntimeData[
                      I10,
                      RuntimeData[I9, RuntimeData[I8, RuntimeData[
                        I7,
                        RuntimeData[I6, RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]]
                      ]]]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ],
      SImpl
    ]
  ) extends ADTData[
        RuntimeData[
          I17,
          RuntimeData[
            I16,
            RuntimeData[
              I15,
              RuntimeData[
                I14,
                RuntimeData[
                  I13,
                  RuntimeData[
                    I12,
                    RuntimeData[
                      I11,
                      RuntimeData[
                        I10,
                        RuntimeData[I9, RuntimeData[I8, RuntimeData[
                          I7,
                          RuntimeData[I6, RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]]
                        ]]]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ],
        SImpl
      ] {

    override def toGHDMZSK: ghdmzsk = data17.toGHDMZSK

    def fold[D](
      func17: I17 => D,
      func16: I16 => D,
      func15: I15 => D,
      func14: I14 => D,
      func13: I13 => D,
      func12: I12 => D,
      func11: I11 => D,
      func10: I10 => D,
      func9: I9 => D,
      func8: I8 => D,
      func7: I7 => D,
      func6: I6 => D,
      func5: I5 => D,
      func4: I4 => D,
      func3: I3 => D,
      func2: I2 => D,
      func1: I1 => D
    ): D = {
      val func_link: ghdmzsk = producter_build
        .appended(func1)
        .inputGHDMZSK(() =>
          producter_build
            .appended(func2)
            .inputGHDMZSK(() =>
              producter_build
                .appended(func3)
                .inputGHDMZSK(() =>
                  producter_build
                    .appended(func4)
                    .inputGHDMZSK(() =>
                      producter_build
                        .appended(func5)
                        .inputGHDMZSK(() =>
                          producter_build
                            .appended(func6)
                            .inputGHDMZSK(() =>
                              producter_build
                                .appended(func7)
                                .inputGHDMZSK(() =>
                                  producter_build
                                    .appended(func8)
                                    .inputGHDMZSK(() =>
                                      producter_build
                                        .appended(func9)
                                        .inputGHDMZSK(() =>
                                          producter_build
                                            .appended(func10)
                                            .inputGHDMZSK(() =>
                                              producter_build
                                                .appended(func11)
                                                .inputGHDMZSK(() =>
                                                  producter_build
                                                    .appended(func12)
                                                    .inputGHDMZSK(() =>
                                                      producter_build
                                                        .appended(func13)
                                                        .inputGHDMZSK(() =>
                                                          producter_build
                                                            .appended(func14)
                                                            .inputGHDMZSK(() =>
                                                              producter_build
                                                                .appended(func15)
                                                                .inputGHDMZSK(() =>
                                                                  producter_build
                                                                    .appended(func16)
                                                                    .inputGHDMZSK(() =>
                                                                      producter_build
                                                                        .appended(func17)
                                                                        .inputGHDMZSK(() => producter_build.zero)
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

      TypeAdtGetter.getFromFunction(data17.toGHDMZSK, func_link).asInstanceOf[D]
    }

  }

  implicit class extra18[
    ParamType,
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
    Poly1,
    Poly2,
    Poly3,
    Poly4,
    Poly5,
    Poly6,
    Poly7,
    Poly8,
    Poly9,
    Poly10,
    Poly11,
    Poly12,
    Poly13,
    Poly14,
    Poly15,
    Poly16,
    Poly17,
    Poly18,
    SImpl <: ADTStatus
  ](
    data18: ADTData[
      RuntimeData[
        I18,
        RuntimeData[
          I17,
          RuntimeData[
            I16,
            RuntimeData[
              I15,
              RuntimeData[
                I14,
                RuntimeData[
                  I13,
                  RuntimeData[
                    I12,
                    RuntimeData[
                      I11,
                      RuntimeData[
                        I10,
                        RuntimeData[I9, RuntimeData[I8, RuntimeData[
                          I7,
                          RuntimeData[I6, RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]]
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
      SImpl
    ]
  ) extends ADTData[
        RuntimeData[
          I18,
          RuntimeData[
            I17,
            RuntimeData[
              I16,
              RuntimeData[
                I15,
                RuntimeData[
                  I14,
                  RuntimeData[
                    I13,
                    RuntimeData[
                      I12,
                      RuntimeData[
                        I11,
                        RuntimeData[
                          I10,
                          RuntimeData[I9, RuntimeData[I8, RuntimeData[I7, RuntimeData[
                            I6,
                            RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]
                          ]]]]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ],
        SImpl
      ] {

    override def toGHDMZSK: ghdmzsk = data18.toGHDMZSK

    def fold[D](
      func18: I18 => D,
      func17: I17 => D,
      func16: I16 => D,
      func15: I15 => D,
      func14: I14 => D,
      func13: I13 => D,
      func12: I12 => D,
      func11: I11 => D,
      func10: I10 => D,
      func9: I9 => D,
      func8: I8 => D,
      func7: I7 => D,
      func6: I6 => D,
      func5: I5 => D,
      func4: I4 => D,
      func3: I3 => D,
      func2: I2 => D,
      func1: I1 => D
    ): D = {
      val func_link: ghdmzsk = producter_build
        .appended(func1)
        .inputGHDMZSK(() =>
          producter_build
            .appended(func2)
            .inputGHDMZSK(() =>
              producter_build
                .appended(func3)
                .inputGHDMZSK(() =>
                  producter_build
                    .appended(func4)
                    .inputGHDMZSK(() =>
                      producter_build
                        .appended(func5)
                        .inputGHDMZSK(() =>
                          producter_build
                            .appended(func6)
                            .inputGHDMZSK(() =>
                              producter_build
                                .appended(func7)
                                .inputGHDMZSK(() =>
                                  producter_build
                                    .appended(func8)
                                    .inputGHDMZSK(() =>
                                      producter_build
                                        .appended(func9)
                                        .inputGHDMZSK(() =>
                                          producter_build
                                            .appended(func10)
                                            .inputGHDMZSK(() =>
                                              producter_build
                                                .appended(func11)
                                                .inputGHDMZSK(() =>
                                                  producter_build
                                                    .appended(func12)
                                                    .inputGHDMZSK(() =>
                                                      producter_build
                                                        .appended(func13)
                                                        .inputGHDMZSK(() =>
                                                          producter_build
                                                            .appended(func14)
                                                            .inputGHDMZSK(() =>
                                                              producter_build
                                                                .appended(func15)
                                                                .inputGHDMZSK(() =>
                                                                  producter_build
                                                                    .appended(func16)
                                                                    .inputGHDMZSK(() =>
                                                                      producter_build
                                                                        .appended(func17)
                                                                        .inputGHDMZSK(() =>
                                                                          producter_build
                                                                            .appended(func18)
                                                                            .inputGHDMZSK(() => producter_build.zero)
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

      TypeAdtGetter.getFromFunction(data18.toGHDMZSK, func_link).asInstanceOf[D]
    }

  }

  implicit class extra19[
    ParamType,
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
    Poly1,
    Poly2,
    Poly3,
    Poly4,
    Poly5,
    Poly6,
    Poly7,
    Poly8,
    Poly9,
    Poly10,
    Poly11,
    Poly12,
    Poly13,
    Poly14,
    Poly15,
    Poly16,
    Poly17,
    Poly18,
    Poly19,
    SImpl <: ADTStatus
  ](
    data19: ADTData[
      RuntimeData[
        I19,
        RuntimeData[
          I18,
          RuntimeData[
            I17,
            RuntimeData[
              I16,
              RuntimeData[
                I15,
                RuntimeData[
                  I14,
                  RuntimeData[
                    I13,
                    RuntimeData[
                      I12,
                      RuntimeData[
                        I11,
                        RuntimeData[
                          I10,
                          RuntimeData[I9, RuntimeData[I8, RuntimeData[I7, RuntimeData[
                            I6,
                            RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]
                          ]]]]
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
      SImpl
    ]
  ) extends ADTData[
        RuntimeData[
          I19,
          RuntimeData[
            I18,
            RuntimeData[
              I17,
              RuntimeData[
                I16,
                RuntimeData[
                  I15,
                  RuntimeData[
                    I14,
                    RuntimeData[
                      I13,
                      RuntimeData[
                        I12,
                        RuntimeData[
                          I11,
                          RuntimeData[
                            I10,
                            RuntimeData[I9, RuntimeData[I8, RuntimeData[I7, RuntimeData[
                              I6,
                              RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]
                            ]]]]
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
        SImpl
      ] {

    override def toGHDMZSK: ghdmzsk = data19.toGHDMZSK

    def fold[D](
      func19: I19 => D,
      func18: I18 => D,
      func17: I17 => D,
      func16: I16 => D,
      func15: I15 => D,
      func14: I14 => D,
      func13: I13 => D,
      func12: I12 => D,
      func11: I11 => D,
      func10: I10 => D,
      func9: I9 => D,
      func8: I8 => D,
      func7: I7 => D,
      func6: I6 => D,
      func5: I5 => D,
      func4: I4 => D,
      func3: I3 => D,
      func2: I2 => D,
      func1: I1 => D
    ): D = {
      val func_link: ghdmzsk = producter_build
        .appended(func1)
        .inputGHDMZSK(() =>
          producter_build
            .appended(func2)
            .inputGHDMZSK(() =>
              producter_build
                .appended(func3)
                .inputGHDMZSK(() =>
                  producter_build
                    .appended(func4)
                    .inputGHDMZSK(() =>
                      producter_build
                        .appended(func5)
                        .inputGHDMZSK(() =>
                          producter_build
                            .appended(func6)
                            .inputGHDMZSK(() =>
                              producter_build
                                .appended(func7)
                                .inputGHDMZSK(() =>
                                  producter_build
                                    .appended(func8)
                                    .inputGHDMZSK(() =>
                                      producter_build
                                        .appended(func9)
                                        .inputGHDMZSK(() =>
                                          producter_build
                                            .appended(func10)
                                            .inputGHDMZSK(() =>
                                              producter_build
                                                .appended(func11)
                                                .inputGHDMZSK(() =>
                                                  producter_build
                                                    .appended(func12)
                                                    .inputGHDMZSK(() =>
                                                      producter_build
                                                        .appended(func13)
                                                        .inputGHDMZSK(() =>
                                                          producter_build
                                                            .appended(func14)
                                                            .inputGHDMZSK(() =>
                                                              producter_build
                                                                .appended(func15)
                                                                .inputGHDMZSK(() =>
                                                                  producter_build
                                                                    .appended(func16)
                                                                    .inputGHDMZSK(() =>
                                                                      producter_build
                                                                        .appended(func17)
                                                                        .inputGHDMZSK(() =>
                                                                          producter_build
                                                                            .appended(func18)
                                                                            .inputGHDMZSK(() =>
                                                                              producter_build
                                                                                .appended(func19)
                                                                                .inputGHDMZSK(() => producter_build.zero)
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

      TypeAdtGetter.getFromFunction(data19.toGHDMZSK, func_link).asInstanceOf[D]
    }

  }

  implicit class extra20[
    ParamType,
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
    Poly1,
    Poly2,
    Poly3,
    Poly4,
    Poly5,
    Poly6,
    Poly7,
    Poly8,
    Poly9,
    Poly10,
    Poly11,
    Poly12,
    Poly13,
    Poly14,
    Poly15,
    Poly16,
    Poly17,
    Poly18,
    Poly19,
    Poly20,
    SImpl <: ADTStatus
  ](
    data20: ADTData[
      RuntimeData[
        I20,
        RuntimeData[
          I19,
          RuntimeData[
            I18,
            RuntimeData[
              I17,
              RuntimeData[
                I16,
                RuntimeData[
                  I15,
                  RuntimeData[
                    I14,
                    RuntimeData[
                      I13,
                      RuntimeData[
                        I12,
                        RuntimeData[
                          I11,
                          RuntimeData[
                            I10,
                            RuntimeData[I9, RuntimeData[I8, RuntimeData[I7, RuntimeData[
                              I6,
                              RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]
                            ]]]]
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
      SImpl
    ]
  ) extends ADTData[
        RuntimeData[
          I20,
          RuntimeData[
            I19,
            RuntimeData[
              I18,
              RuntimeData[
                I17,
                RuntimeData[
                  I16,
                  RuntimeData[
                    I15,
                    RuntimeData[
                      I14,
                      RuntimeData[
                        I13,
                        RuntimeData[
                          I12,
                          RuntimeData[
                            I11,
                            RuntimeData[
                              I10,
                              RuntimeData[I9, RuntimeData[I8, RuntimeData[I7, RuntimeData[
                                I6,
                                RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]
                              ]]]]
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
        SImpl
      ] {

    override def toGHDMZSK: ghdmzsk = data20.toGHDMZSK

    def fold[D](
      func20: I20 => D,
      func19: I19 => D,
      func18: I18 => D,
      func17: I17 => D,
      func16: I16 => D,
      func15: I15 => D,
      func14: I14 => D,
      func13: I13 => D,
      func12: I12 => D,
      func11: I11 => D,
      func10: I10 => D,
      func9: I9 => D,
      func8: I8 => D,
      func7: I7 => D,
      func6: I6 => D,
      func5: I5 => D,
      func4: I4 => D,
      func3: I3 => D,
      func2: I2 => D,
      func1: I1 => D
    ): D = {
      val func_link: ghdmzsk = producter_build
        .appended(func1)
        .inputGHDMZSK(() =>
          producter_build
            .appended(func2)
            .inputGHDMZSK(() =>
              producter_build
                .appended(func3)
                .inputGHDMZSK(() =>
                  producter_build
                    .appended(func4)
                    .inputGHDMZSK(() =>
                      producter_build
                        .appended(func5)
                        .inputGHDMZSK(() =>
                          producter_build
                            .appended(func6)
                            .inputGHDMZSK(() =>
                              producter_build
                                .appended(func7)
                                .inputGHDMZSK(() =>
                                  producter_build
                                    .appended(func8)
                                    .inputGHDMZSK(() =>
                                      producter_build
                                        .appended(func9)
                                        .inputGHDMZSK(() =>
                                          producter_build
                                            .appended(func10)
                                            .inputGHDMZSK(() =>
                                              producter_build
                                                .appended(func11)
                                                .inputGHDMZSK(() =>
                                                  producter_build
                                                    .appended(func12)
                                                    .inputGHDMZSK(() =>
                                                      producter_build
                                                        .appended(func13)
                                                        .inputGHDMZSK(() =>
                                                          producter_build
                                                            .appended(func14)
                                                            .inputGHDMZSK(() =>
                                                              producter_build
                                                                .appended(func15)
                                                                .inputGHDMZSK(() =>
                                                                  producter_build
                                                                    .appended(func16)
                                                                    .inputGHDMZSK(() =>
                                                                      producter_build
                                                                        .appended(func17)
                                                                        .inputGHDMZSK(() =>
                                                                          producter_build
                                                                            .appended(func18)
                                                                            .inputGHDMZSK(() =>
                                                                              producter_build
                                                                                .appended(func19)
                                                                                .inputGHDMZSK(() =>
                                                                                  producter_build
                                                                                    .appended(func20)
                                                                                    .inputGHDMZSK(() => producter_build.zero)
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

      TypeAdtGetter.getFromFunction(data20.toGHDMZSK, func_link).asInstanceOf[D]
    }

  }

  implicit class extra21[
    ParamType,
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
    Poly1,
    Poly2,
    Poly3,
    Poly4,
    Poly5,
    Poly6,
    Poly7,
    Poly8,
    Poly9,
    Poly10,
    Poly11,
    Poly12,
    Poly13,
    Poly14,
    Poly15,
    Poly16,
    Poly17,
    Poly18,
    Poly19,
    Poly20,
    Poly21,
    SImpl <: ADTStatus
  ](
    data21: ADTData[
      RuntimeData[
        I21,
        RuntimeData[
          I20,
          RuntimeData[
            I19,
            RuntimeData[
              I18,
              RuntimeData[
                I17,
                RuntimeData[
                  I16,
                  RuntimeData[
                    I15,
                    RuntimeData[
                      I14,
                      RuntimeData[
                        I13,
                        RuntimeData[
                          I12,
                          RuntimeData[
                            I11,
                            RuntimeData[
                              I10,
                              RuntimeData[I9, RuntimeData[I8, RuntimeData[I7, RuntimeData[
                                I6,
                                RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]
                              ]]]]
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
      SImpl
    ]
  ) extends ADTData[
        RuntimeData[
          I21,
          RuntimeData[
            I20,
            RuntimeData[
              I19,
              RuntimeData[
                I18,
                RuntimeData[
                  I17,
                  RuntimeData[
                    I16,
                    RuntimeData[
                      I15,
                      RuntimeData[
                        I14,
                        RuntimeData[
                          I13,
                          RuntimeData[
                            I12,
                            RuntimeData[
                              I11,
                              RuntimeData[
                                I10,
                                RuntimeData[I9, RuntimeData[I8, RuntimeData[I7, RuntimeData[
                                  I6,
                                  RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]
                                ]]]]
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
        SImpl
      ] {

    override def toGHDMZSK: ghdmzsk = data21.toGHDMZSK

    def fold[D](
      func21: I21 => D,
      func20: I20 => D,
      func19: I19 => D,
      func18: I18 => D,
      func17: I17 => D,
      func16: I16 => D,
      func15: I15 => D,
      func14: I14 => D,
      func13: I13 => D,
      func12: I12 => D,
      func11: I11 => D,
      func10: I10 => D,
      func9: I9 => D,
      func8: I8 => D,
      func7: I7 => D,
      func6: I6 => D,
      func5: I5 => D,
      func4: I4 => D,
      func3: I3 => D,
      func2: I2 => D,
      func1: I1 => D
    ): D = {
      val func_link: ghdmzsk = producter_build
        .appended(func1)
        .inputGHDMZSK(() =>
          producter_build
            .appended(func2)
            .inputGHDMZSK(() =>
              producter_build
                .appended(func3)
                .inputGHDMZSK(() =>
                  producter_build
                    .appended(func4)
                    .inputGHDMZSK(() =>
                      producter_build
                        .appended(func5)
                        .inputGHDMZSK(() =>
                          producter_build
                            .appended(func6)
                            .inputGHDMZSK(() =>
                              producter_build
                                .appended(func7)
                                .inputGHDMZSK(() =>
                                  producter_build
                                    .appended(func8)
                                    .inputGHDMZSK(() =>
                                      producter_build
                                        .appended(func9)
                                        .inputGHDMZSK(() =>
                                          producter_build
                                            .appended(func10)
                                            .inputGHDMZSK(() =>
                                              producter_build
                                                .appended(func11)
                                                .inputGHDMZSK(() =>
                                                  producter_build
                                                    .appended(func12)
                                                    .inputGHDMZSK(() =>
                                                      producter_build
                                                        .appended(func13)
                                                        .inputGHDMZSK(() =>
                                                          producter_build
                                                            .appended(func14)
                                                            .inputGHDMZSK(() =>
                                                              producter_build
                                                                .appended(func15)
                                                                .inputGHDMZSK(() =>
                                                                  producter_build
                                                                    .appended(func16)
                                                                    .inputGHDMZSK(() =>
                                                                      producter_build
                                                                        .appended(func17)
                                                                        .inputGHDMZSK(() =>
                                                                          producter_build
                                                                            .appended(func18)
                                                                            .inputGHDMZSK(() =>
                                                                              producter_build
                                                                                .appended(func19)
                                                                                .inputGHDMZSK(() =>
                                                                                  producter_build
                                                                                    .appended(func20)
                                                                                    .inputGHDMZSK(() =>
                                                                                      producter_build
                                                                                        .appended(func21)
                                                                                        .inputGHDMZSK(() => producter_build.zero)
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

      TypeAdtGetter.getFromFunction(data21.toGHDMZSK, func_link).asInstanceOf[D]
    }

  }

  implicit class extra22[
    ParamType,
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
    Poly1,
    Poly2,
    Poly3,
    Poly4,
    Poly5,
    Poly6,
    Poly7,
    Poly8,
    Poly9,
    Poly10,
    Poly11,
    Poly12,
    Poly13,
    Poly14,
    Poly15,
    Poly16,
    Poly17,
    Poly18,
    Poly19,
    Poly20,
    Poly21,
    Poly22,
    SImpl <: ADTStatus
  ](
    data22: ADTData[
      RuntimeData[
        I22,
        RuntimeData[
          I21,
          RuntimeData[
            I20,
            RuntimeData[
              I19,
              RuntimeData[
                I18,
                RuntimeData[
                  I17,
                  RuntimeData[
                    I16,
                    RuntimeData[
                      I15,
                      RuntimeData[
                        I14,
                        RuntimeData[
                          I13,
                          RuntimeData[
                            I12,
                            RuntimeData[
                              I11,
                              RuntimeData[
                                I10,
                                RuntimeData[I9, RuntimeData[I8, RuntimeData[I7, RuntimeData[
                                  I6,
                                  RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]
                                ]]]]
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
      SImpl
    ]
  ) extends ADTData[
        RuntimeData[
          I22,
          RuntimeData[
            I21,
            RuntimeData[
              I20,
              RuntimeData[
                I19,
                RuntimeData[
                  I18,
                  RuntimeData[
                    I17,
                    RuntimeData[
                      I16,
                      RuntimeData[
                        I15,
                        RuntimeData[
                          I14,
                          RuntimeData[
                            I13,
                            RuntimeData[
                              I12,
                              RuntimeData[
                                I11,
                                RuntimeData[
                                  I10,
                                  RuntimeData[I9, RuntimeData[I8, RuntimeData[I7, RuntimeData[
                                    I6,
                                    RuntimeData[I5, RuntimeData[I4, RuntimeData[I3, RuntimeData[I2, RuntimeData[I1, RuntimeZero]]]]]
                                  ]]]]
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
        SImpl
      ] {

    override def toGHDMZSK: ghdmzsk = data22.toGHDMZSK

    def fold[D](
      func22: I22 => D,
      func21: I21 => D,
      func20: I20 => D,
      func19: I19 => D,
      func18: I18 => D,
      func17: I17 => D,
      func16: I16 => D,
      func15: I15 => D,
      func14: I14 => D,
      func13: I13 => D,
      func12: I12 => D,
      func11: I11 => D,
      func10: I10 => D,
      func9: I9 => D,
      func8: I8 => D,
      func7: I7 => D,
      func6: I6 => D,
      func5: I5 => D,
      func4: I4 => D,
      func3: I3 => D,
      func2: I2 => D,
      func1: I1 => D
    ): D = {
      val func_link: ghdmzsk = producter_build
        .appended(func1)
        .inputGHDMZSK(() =>
          producter_build
            .appended(func2)
            .inputGHDMZSK(() =>
              producter_build
                .appended(func3)
                .inputGHDMZSK(() =>
                  producter_build
                    .appended(func4)
                    .inputGHDMZSK(() =>
                      producter_build
                        .appended(func5)
                        .inputGHDMZSK(() =>
                          producter_build
                            .appended(func6)
                            .inputGHDMZSK(() =>
                              producter_build
                                .appended(func7)
                                .inputGHDMZSK(() =>
                                  producter_build
                                    .appended(func8)
                                    .inputGHDMZSK(() =>
                                      producter_build
                                        .appended(func9)
                                        .inputGHDMZSK(() =>
                                          producter_build
                                            .appended(func10)
                                            .inputGHDMZSK(() =>
                                              producter_build
                                                .appended(func11)
                                                .inputGHDMZSK(() =>
                                                  producter_build
                                                    .appended(func12)
                                                    .inputGHDMZSK(() =>
                                                      producter_build
                                                        .appended(func13)
                                                        .inputGHDMZSK(() =>
                                                          producter_build
                                                            .appended(func14)
                                                            .inputGHDMZSK(() =>
                                                              producter_build
                                                                .appended(func15)
                                                                .inputGHDMZSK(() =>
                                                                  producter_build
                                                                    .appended(func16)
                                                                    .inputGHDMZSK(() =>
                                                                      producter_build
                                                                        .appended(func17)
                                                                        .inputGHDMZSK(() =>
                                                                          producter_build
                                                                            .appended(func18)
                                                                            .inputGHDMZSK(() =>
                                                                              producter_build
                                                                                .appended(func19)
                                                                                .inputGHDMZSK(() =>
                                                                                  producter_build
                                                                                    .appended(func20)
                                                                                    .inputGHDMZSK(() =>
                                                                                      producter_build
                                                                                        .appended(func21)
                                                                                        .inputGHDMZSK(() =>
                                                                                          producter_build
                                                                                            .appended(func22)
                                                                                            .inputGHDMZSK(() => producter_build.zero)
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

      TypeAdtGetter.getFromFunction(data22.toGHDMZSK, func_link).asInstanceOf[D]
    }

  }

}
