package net.scalax.simple.adt
package impl

import net.scalax.simple.ghdmzsk.ghdmzsk
import temp._
import Adt.{Status => ADTStatus}
import net.scalax.simple.adt.{RuntimeData, RuntimeNat, RuntimeZero}

trait ADTPassedFunction {

  implicit class extra1[ParamType, I1, Poly1, SImpl <: ADTStatus](
    data1: ADTData[RuntimeData[Adt.Context[ParamType, I1, Poly1], RuntimeZero], SImpl]
  ) {

    def fold[D](func1: I1 => D): D = ???

  }

  implicit class extra2[ParamType, I1, I2, Poly1, Poly2, SImpl <: ADTStatus](
    data2: ADTData[RuntimeData[Adt.Context[ParamType, I1, Poly1], RuntimeData[Adt.Context[ParamType, I2, Poly2], RuntimeZero]], SImpl]
  ) {

    def fold[D](func1: I1 => D, func2: I2 => D): D = ???

  }

  implicit class extra3[ParamType, I1, I2, I3, Poly1, Poly2, Poly3, SImpl <: ADTStatus](
    data3: ADTData[
      RuntimeData[
        Adt.Context[ParamType, I1, Poly1],
        RuntimeData[Adt.Context[ParamType, I2, Poly2], RuntimeData[Adt.Context[ParamType, I3, Poly3], RuntimeZero]]
      ],
      SImpl
    ]
  ) {

    def fold[D](func1: I1 => D, func2: I2 => D, func3: I3 => D): D = ???

  }

  implicit class extra4[ParamType, I1, I2, I3, I4, Poly1, Poly2, Poly3, Poly4, SImpl <: ADTStatus](
    data4: ADTData[
      RuntimeData[
        Adt.Context[ParamType, I1, Poly1],
        RuntimeData[
          Adt.Context[ParamType, I2, Poly2],
          RuntimeData[Adt.Context[ParamType, I3, Poly3], RuntimeData[Adt.Context[ParamType, I4, Poly4], RuntimeZero]]
        ]
      ],
      SImpl
    ]
  ) {

    def fold[D](func1: I1 => D, func2: I2 => D, func3: I3 => D, func4: I4 => D): D = ???

  }

  implicit class extra5[ParamType, I1, I2, I3, I4, I5, Poly1, Poly2, Poly3, Poly4, Poly5, SImpl <: ADTStatus](
    data5: ADTData[
      RuntimeData[
        Adt.Context[ParamType, I1, Poly1],
        RuntimeData[
          Adt.Context[ParamType, I2, Poly2],
          RuntimeData[
            Adt.Context[ParamType, I3, Poly3],
            RuntimeData[Adt.Context[ParamType, I4, Poly4], RuntimeData[Adt.Context[ParamType, I5, Poly5], RuntimeZero]]
          ]
        ]
      ],
      SImpl
    ]
  ) {

    def fold[D](func1: I1 => D, func2: I2 => D, func3: I3 => D, func4: I4 => D, func5: I5 => D): D = ???

  }

  implicit class extra6[ParamType, I1, I2, I3, I4, I5, I6, Poly1, Poly2, Poly3, Poly4, Poly5, Poly6, SImpl <: ADTStatus](
    data6: ADTData[
      RuntimeData[
        Adt.Context[ParamType, I1, Poly1],
        RuntimeData[
          Adt.Context[ParamType, I2, Poly2],
          RuntimeData[
            Adt.Context[ParamType, I3, Poly3],
            RuntimeData[
              Adt.Context[ParamType, I4, Poly4],
              RuntimeData[Adt.Context[ParamType, I5, Poly5], RuntimeData[Adt.Context[ParamType, I6, Poly6], RuntimeZero]]
            ]
          ]
        ]
      ],
      SImpl
    ]
  ) {

    def fold[D](func1: I1 => D, func2: I2 => D, func3: I3 => D, func4: I4 => D, func5: I5 => D, func6: I6 => D): D = ???

  }

  implicit class extra7[ParamType, I1, I2, I3, I4, I5, I6, I7, Poly1, Poly2, Poly3, Poly4, Poly5, Poly6, Poly7, SImpl <: ADTStatus](
    data7: ADTData[
      RuntimeData[
        Adt.Context[ParamType, I1, Poly1],
        RuntimeData[
          Adt.Context[ParamType, I2, Poly2],
          RuntimeData[
            Adt.Context[ParamType, I3, Poly3],
            RuntimeData[
              Adt.Context[ParamType, I4, Poly4],
              RuntimeData[
                Adt.Context[ParamType, I5, Poly5],
                RuntimeData[Adt.Context[ParamType, I6, Poly6], RuntimeData[Adt.Context[ParamType, I7, Poly7], RuntimeZero]]
              ]
            ]
          ]
        ]
      ],
      SImpl
    ]
  ) {

    def fold[D](func1: I1 => D, func2: I2 => D, func3: I3 => D, func4: I4 => D, func5: I5 => D, func6: I6 => D, func7: I7 => D): D = ???

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
    data8: ADTData[
      RuntimeData[
        Adt.Context[ParamType, I1, Poly1],
        RuntimeData[
          Adt.Context[ParamType, I2, Poly2],
          RuntimeData[
            Adt.Context[ParamType, I3, Poly3],
            RuntimeData[
              Adt.Context[ParamType, I4, Poly4],
              RuntimeData[
                Adt.Context[ParamType, I5, Poly5],
                RuntimeData[
                  Adt.Context[ParamType, I6, Poly6],
                  RuntimeData[Adt.Context[ParamType, I7, Poly7], RuntimeData[Adt.Context[ParamType, I8, Poly8], RuntimeZero]]
                ]
              ]
            ]
          ]
        ]
      ],
      SImpl
    ]
  ) {

    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D,
      func7: I7 => D,
      func8: I8 => D
    ): D = ???

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
      RuntimeData[
        Adt.Context[ParamType, I1, Poly1],
        RuntimeData[
          Adt.Context[ParamType, I2, Poly2],
          RuntimeData[
            Adt.Context[ParamType, I3, Poly3],
            RuntimeData[
              Adt.Context[ParamType, I4, Poly4],
              RuntimeData[
                Adt.Context[ParamType, I5, Poly5],
                RuntimeData[
                  Adt.Context[ParamType, I6, Poly6],
                  RuntimeData[
                    Adt.Context[ParamType, I7, Poly7],
                    RuntimeData[Adt.Context[ParamType, I8, Poly8], RuntimeData[Adt.Context[ParamType, I9, Poly9], RuntimeZero]]
                  ]
                ]
              ]
            ]
          ]
        ]
      ],
      SImpl
    ]
  ) {

    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D,
      func7: I7 => D,
      func8: I8 => D,
      func9: I9 => D
    ): D = ???

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
        Adt.Context[ParamType, I1, Poly1],
        RuntimeData[
          Adt.Context[ParamType, I2, Poly2],
          RuntimeData[
            Adt.Context[ParamType, I3, Poly3],
            RuntimeData[
              Adt.Context[ParamType, I4, Poly4],
              RuntimeData[
                Adt.Context[ParamType, I5, Poly5],
                RuntimeData[
                  Adt.Context[ParamType, I6, Poly6],
                  RuntimeData[
                    Adt.Context[ParamType, I7, Poly7],
                    RuntimeData[
                      Adt.Context[ParamType, I8, Poly8],
                      RuntimeData[Adt.Context[ParamType, I9, Poly9], RuntimeData[Adt.Context[ParamType, I10, Poly10], RuntimeZero]]
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
  ) {

    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D,
      func7: I7 => D,
      func8: I8 => D,
      func9: I9 => D,
      func10: I10 => D
    ): D = ???

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
        Adt.Context[ParamType, I1, Poly1],
        RuntimeData[
          Adt.Context[ParamType, I2, Poly2],
          RuntimeData[
            Adt.Context[ParamType, I3, Poly3],
            RuntimeData[
              Adt.Context[ParamType, I4, Poly4],
              RuntimeData[
                Adt.Context[ParamType, I5, Poly5],
                RuntimeData[
                  Adt.Context[ParamType, I6, Poly6],
                  RuntimeData[
                    Adt.Context[ParamType, I7, Poly7],
                    RuntimeData[
                      Adt.Context[ParamType, I8, Poly8],
                      RuntimeData[
                        Adt.Context[ParamType, I9, Poly9],
                        RuntimeData[Adt.Context[ParamType, I10, Poly10], RuntimeData[Adt.Context[ParamType, I11, Poly11], RuntimeZero]]
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
  ) {

    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D,
      func7: I7 => D,
      func8: I8 => D,
      func9: I9 => D,
      func10: I10 => D,
      func11: I11 => D
    ): D = ???

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
        Adt.Context[ParamType, I1, Poly1],
        RuntimeData[
          Adt.Context[ParamType, I2, Poly2],
          RuntimeData[
            Adt.Context[ParamType, I3, Poly3],
            RuntimeData[
              Adt.Context[ParamType, I4, Poly4],
              RuntimeData[
                Adt.Context[ParamType, I5, Poly5],
                RuntimeData[
                  Adt.Context[ParamType, I6, Poly6],
                  RuntimeData[
                    Adt.Context[ParamType, I7, Poly7],
                    RuntimeData[
                      Adt.Context[ParamType, I8, Poly8],
                      RuntimeData[
                        Adt.Context[ParamType, I9, Poly9],
                        RuntimeData[
                          Adt.Context[ParamType, I10, Poly10],
                          RuntimeData[Adt.Context[ParamType, I11, Poly11], RuntimeData[Adt.Context[ParamType, I12, Poly12], RuntimeZero]]
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
  ) {

    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D,
      func7: I7 => D,
      func8: I8 => D,
      func9: I9 => D,
      func10: I10 => D,
      func11: I11 => D,
      func12: I12 => D
    ): D = ???

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
        Adt.Context[ParamType, I1, Poly1],
        RuntimeData[
          Adt.Context[ParamType, I2, Poly2],
          RuntimeData[
            Adt.Context[ParamType, I3, Poly3],
            RuntimeData[
              Adt.Context[ParamType, I4, Poly4],
              RuntimeData[
                Adt.Context[ParamType, I5, Poly5],
                RuntimeData[
                  Adt.Context[ParamType, I6, Poly6],
                  RuntimeData[
                    Adt.Context[ParamType, I7, Poly7],
                    RuntimeData[
                      Adt.Context[ParamType, I8, Poly8],
                      RuntimeData[
                        Adt.Context[ParamType, I9, Poly9],
                        RuntimeData[
                          Adt.Context[ParamType, I10, Poly10],
                          RuntimeData[
                            Adt.Context[ParamType, I11, Poly11],
                            RuntimeData[Adt.Context[ParamType, I12, Poly12], RuntimeData[Adt.Context[ParamType, I13, Poly13], RuntimeZero]]
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
  ) {

    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D,
      func7: I7 => D,
      func8: I8 => D,
      func9: I9 => D,
      func10: I10 => D,
      func11: I11 => D,
      func12: I12 => D,
      func13: I13 => D
    ): D = ???

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
        Adt.Context[ParamType, I1, Poly1],
        RuntimeData[
          Adt.Context[ParamType, I2, Poly2],
          RuntimeData[
            Adt.Context[ParamType, I3, Poly3],
            RuntimeData[
              Adt.Context[ParamType, I4, Poly4],
              RuntimeData[
                Adt.Context[ParamType, I5, Poly5],
                RuntimeData[
                  Adt.Context[ParamType, I6, Poly6],
                  RuntimeData[
                    Adt.Context[ParamType, I7, Poly7],
                    RuntimeData[
                      Adt.Context[ParamType, I8, Poly8],
                      RuntimeData[
                        Adt.Context[ParamType, I9, Poly9],
                        RuntimeData[
                          Adt.Context[ParamType, I10, Poly10],
                          RuntimeData[
                            Adt.Context[ParamType, I11, Poly11],
                            RuntimeData[Adt.Context[ParamType, I12, Poly12], RuntimeData[
                              Adt.Context[ParamType, I13, Poly13],
                              RuntimeData[Adt.Context[ParamType, I14, Poly14], RuntimeZero]
                            ]]
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
  ) {

    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D,
      func7: I7 => D,
      func8: I8 => D,
      func9: I9 => D,
      func10: I10 => D,
      func11: I11 => D,
      func12: I12 => D,
      func13: I13 => D,
      func14: I14 => D
    ): D = ???

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
        Adt.Context[ParamType, I1, Poly1],
        RuntimeData[
          Adt.Context[ParamType, I2, Poly2],
          RuntimeData[
            Adt.Context[ParamType, I3, Poly3],
            RuntimeData[
              Adt.Context[ParamType, I4, Poly4],
              RuntimeData[
                Adt.Context[ParamType, I5, Poly5],
                RuntimeData[
                  Adt.Context[ParamType, I6, Poly6],
                  RuntimeData[
                    Adt.Context[ParamType, I7, Poly7],
                    RuntimeData[
                      Adt.Context[ParamType, I8, Poly8],
                      RuntimeData[
                        Adt.Context[ParamType, I9, Poly9],
                        RuntimeData[
                          Adt.Context[ParamType, I10, Poly10],
                          RuntimeData[
                            Adt.Context[ParamType, I11, Poly11],
                            RuntimeData[
                              Adt.Context[ParamType, I12, Poly12],
                              RuntimeData[Adt.Context[ParamType, I13, Poly13], RuntimeData[
                                Adt.Context[ParamType, I14, Poly14],
                                RuntimeData[Adt.Context[ParamType, I15, Poly15], RuntimeZero]
                              ]]
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
  ) {

    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D,
      func7: I7 => D,
      func8: I8 => D,
      func9: I9 => D,
      func10: I10 => D,
      func11: I11 => D,
      func12: I12 => D,
      func13: I13 => D,
      func14: I14 => D,
      func15: I15 => D
    ): D = ???

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
        Adt.Context[ParamType, I1, Poly1],
        RuntimeData[
          Adt.Context[ParamType, I2, Poly2],
          RuntimeData[
            Adt.Context[ParamType, I3, Poly3],
            RuntimeData[
              Adt.Context[ParamType, I4, Poly4],
              RuntimeData[
                Adt.Context[ParamType, I5, Poly5],
                RuntimeData[
                  Adt.Context[ParamType, I6, Poly6],
                  RuntimeData[
                    Adt.Context[ParamType, I7, Poly7],
                    RuntimeData[
                      Adt.Context[ParamType, I8, Poly8],
                      RuntimeData[
                        Adt.Context[ParamType, I9, Poly9],
                        RuntimeData[
                          Adt.Context[ParamType, I10, Poly10],
                          RuntimeData[
                            Adt.Context[ParamType, I11, Poly11],
                            RuntimeData[
                              Adt.Context[ParamType, I12, Poly12],
                              RuntimeData[
                                Adt.Context[ParamType, I13, Poly13],
                                RuntimeData[Adt.Context[ParamType, I14, Poly14], RuntimeData[
                                  Adt.Context[ParamType, I15, Poly15],
                                  RuntimeData[Adt.Context[ParamType, I16, Poly16], RuntimeZero]
                                ]]
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
  ) {

    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D,
      func7: I7 => D,
      func8: I8 => D,
      func9: I9 => D,
      func10: I10 => D,
      func11: I11 => D,
      func12: I12 => D,
      func13: I13 => D,
      func14: I14 => D,
      func15: I15 => D,
      func16: I16 => D
    ): D = ???

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
        Adt.Context[ParamType, I1, Poly1],
        RuntimeData[
          Adt.Context[ParamType, I2, Poly2],
          RuntimeData[
            Adt.Context[ParamType, I3, Poly3],
            RuntimeData[
              Adt.Context[ParamType, I4, Poly4],
              RuntimeData[
                Adt.Context[ParamType, I5, Poly5],
                RuntimeData[
                  Adt.Context[ParamType, I6, Poly6],
                  RuntimeData[
                    Adt.Context[ParamType, I7, Poly7],
                    RuntimeData[
                      Adt.Context[ParamType, I8, Poly8],
                      RuntimeData[
                        Adt.Context[ParamType, I9, Poly9],
                        RuntimeData[
                          Adt.Context[ParamType, I10, Poly10],
                          RuntimeData[
                            Adt.Context[ParamType, I11, Poly11],
                            RuntimeData[
                              Adt.Context[ParamType, I12, Poly12],
                              RuntimeData[
                                Adt.Context[ParamType, I13, Poly13],
                                RuntimeData[
                                  Adt.Context[ParamType, I14, Poly14],
                                  RuntimeData[Adt.Context[ParamType, I15, Poly15], RuntimeData[
                                    Adt.Context[ParamType, I16, Poly16],
                                    RuntimeData[Adt.Context[ParamType, I17, Poly17], RuntimeZero]
                                  ]]
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
      SImpl
    ]
  ) {

    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D,
      func7: I7 => D,
      func8: I8 => D,
      func9: I9 => D,
      func10: I10 => D,
      func11: I11 => D,
      func12: I12 => D,
      func13: I13 => D,
      func14: I14 => D,
      func15: I15 => D,
      func16: I16 => D,
      func17: I17 => D
    ): D = ???

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
        Adt.Context[ParamType, I1, Poly1],
        RuntimeData[
          Adt.Context[ParamType, I2, Poly2],
          RuntimeData[
            Adt.Context[ParamType, I3, Poly3],
            RuntimeData[
              Adt.Context[ParamType, I4, Poly4],
              RuntimeData[
                Adt.Context[ParamType, I5, Poly5],
                RuntimeData[
                  Adt.Context[ParamType, I6, Poly6],
                  RuntimeData[
                    Adt.Context[ParamType, I7, Poly7],
                    RuntimeData[
                      Adt.Context[ParamType, I8, Poly8],
                      RuntimeData[
                        Adt.Context[ParamType, I9, Poly9],
                        RuntimeData[
                          Adt.Context[ParamType, I10, Poly10],
                          RuntimeData[
                            Adt.Context[ParamType, I11, Poly11],
                            RuntimeData[
                              Adt.Context[ParamType, I12, Poly12],
                              RuntimeData[
                                Adt.Context[ParamType, I13, Poly13],
                                RuntimeData[
                                  Adt.Context[ParamType, I14, Poly14],
                                  RuntimeData[
                                    Adt.Context[ParamType, I15, Poly15],
                                    RuntimeData[Adt.Context[ParamType, I16, Poly16], RuntimeData[
                                      Adt.Context[ParamType, I17, Poly17],
                                      RuntimeData[Adt.Context[ParamType, I18, Poly18], RuntimeZero]
                                    ]]
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
      SImpl
    ]
  ) {

    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D,
      func7: I7 => D,
      func8: I8 => D,
      func9: I9 => D,
      func10: I10 => D,
      func11: I11 => D,
      func12: I12 => D,
      func13: I13 => D,
      func14: I14 => D,
      func15: I15 => D,
      func16: I16 => D,
      func17: I17 => D,
      func18: I18 => D
    ): D = ???

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
        Adt.Context[ParamType, I1, Poly1],
        RuntimeData[
          Adt.Context[ParamType, I2, Poly2],
          RuntimeData[
            Adt.Context[ParamType, I3, Poly3],
            RuntimeData[
              Adt.Context[ParamType, I4, Poly4],
              RuntimeData[
                Adt.Context[ParamType, I5, Poly5],
                RuntimeData[
                  Adt.Context[ParamType, I6, Poly6],
                  RuntimeData[
                    Adt.Context[ParamType, I7, Poly7],
                    RuntimeData[
                      Adt.Context[ParamType, I8, Poly8],
                      RuntimeData[
                        Adt.Context[ParamType, I9, Poly9],
                        RuntimeData[
                          Adt.Context[ParamType, I10, Poly10],
                          RuntimeData[
                            Adt.Context[ParamType, I11, Poly11],
                            RuntimeData[
                              Adt.Context[ParamType, I12, Poly12],
                              RuntimeData[
                                Adt.Context[ParamType, I13, Poly13],
                                RuntimeData[
                                  Adt.Context[ParamType, I14, Poly14],
                                  RuntimeData[
                                    Adt.Context[ParamType, I15, Poly15],
                                    RuntimeData[
                                      Adt.Context[ParamType, I16, Poly16],
                                      RuntimeData[Adt.Context[ParamType, I17, Poly17], RuntimeData[
                                        Adt.Context[ParamType, I18, Poly18],
                                        RuntimeData[Adt.Context[ParamType, I19, Poly19], RuntimeZero]
                                      ]]
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
        ]
      ],
      SImpl
    ]
  ) {

    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D,
      func7: I7 => D,
      func8: I8 => D,
      func9: I9 => D,
      func10: I10 => D,
      func11: I11 => D,
      func12: I12 => D,
      func13: I13 => D,
      func14: I14 => D,
      func15: I15 => D,
      func16: I16 => D,
      func17: I17 => D,
      func18: I18 => D,
      func19: I19 => D
    ): D = ???

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
        Adt.Context[ParamType, I1, Poly1],
        RuntimeData[
          Adt.Context[ParamType, I2, Poly2],
          RuntimeData[
            Adt.Context[ParamType, I3, Poly3],
            RuntimeData[
              Adt.Context[ParamType, I4, Poly4],
              RuntimeData[
                Adt.Context[ParamType, I5, Poly5],
                RuntimeData[
                  Adt.Context[ParamType, I6, Poly6],
                  RuntimeData[
                    Adt.Context[ParamType, I7, Poly7],
                    RuntimeData[
                      Adt.Context[ParamType, I8, Poly8],
                      RuntimeData[
                        Adt.Context[ParamType, I9, Poly9],
                        RuntimeData[
                          Adt.Context[ParamType, I10, Poly10],
                          RuntimeData[
                            Adt.Context[ParamType, I11, Poly11],
                            RuntimeData[
                              Adt.Context[ParamType, I12, Poly12],
                              RuntimeData[
                                Adt.Context[ParamType, I13, Poly13],
                                RuntimeData[
                                  Adt.Context[ParamType, I14, Poly14],
                                  RuntimeData[
                                    Adt.Context[ParamType, I15, Poly15],
                                    RuntimeData[
                                      Adt.Context[ParamType, I16, Poly16],
                                      RuntimeData[
                                        Adt.Context[ParamType, I17, Poly17],
                                        RuntimeData[Adt.Context[ParamType, I18, Poly18], RuntimeData[
                                          Adt.Context[ParamType, I19, Poly19],
                                          RuntimeData[Adt.Context[ParamType, I20, Poly20], RuntimeZero]
                                        ]]
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
          ]
        ]
      ],
      SImpl
    ]
  ) {

    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D,
      func7: I7 => D,
      func8: I8 => D,
      func9: I9 => D,
      func10: I10 => D,
      func11: I11 => D,
      func12: I12 => D,
      func13: I13 => D,
      func14: I14 => D,
      func15: I15 => D,
      func16: I16 => D,
      func17: I17 => D,
      func18: I18 => D,
      func19: I19 => D,
      func20: I20 => D
    ): D = ???

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
        Adt.Context[ParamType, I1, Poly1],
        RuntimeData[
          Adt.Context[ParamType, I2, Poly2],
          RuntimeData[
            Adt.Context[ParamType, I3, Poly3],
            RuntimeData[
              Adt.Context[ParamType, I4, Poly4],
              RuntimeData[
                Adt.Context[ParamType, I5, Poly5],
                RuntimeData[
                  Adt.Context[ParamType, I6, Poly6],
                  RuntimeData[
                    Adt.Context[ParamType, I7, Poly7],
                    RuntimeData[
                      Adt.Context[ParamType, I8, Poly8],
                      RuntimeData[
                        Adt.Context[ParamType, I9, Poly9],
                        RuntimeData[
                          Adt.Context[ParamType, I10, Poly10],
                          RuntimeData[
                            Adt.Context[ParamType, I11, Poly11],
                            RuntimeData[
                              Adt.Context[ParamType, I12, Poly12],
                              RuntimeData[
                                Adt.Context[ParamType, I13, Poly13],
                                RuntimeData[
                                  Adt.Context[ParamType, I14, Poly14],
                                  RuntimeData[
                                    Adt.Context[ParamType, I15, Poly15],
                                    RuntimeData[
                                      Adt.Context[ParamType, I16, Poly16],
                                      RuntimeData[
                                        Adt.Context[ParamType, I17, Poly17],
                                        RuntimeData[
                                          Adt.Context[ParamType, I18, Poly18],
                                          RuntimeData[Adt.Context[ParamType, I19, Poly19], RuntimeData[
                                            Adt.Context[ParamType, I20, Poly20],
                                            RuntimeData[Adt.Context[ParamType, I21, Poly21], RuntimeZero]
                                          ]]
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
            ]
          ]
        ]
      ],
      SImpl
    ]
  ) {

    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D,
      func7: I7 => D,
      func8: I8 => D,
      func9: I9 => D,
      func10: I10 => D,
      func11: I11 => D,
      func12: I12 => D,
      func13: I13 => D,
      func14: I14 => D,
      func15: I15 => D,
      func16: I16 => D,
      func17: I17 => D,
      func18: I18 => D,
      func19: I19 => D,
      func20: I20 => D,
      func21: I21 => D
    ): D = ???

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
        Adt.Context[ParamType, I1, Poly1],
        RuntimeData[
          Adt.Context[ParamType, I2, Poly2],
          RuntimeData[
            Adt.Context[ParamType, I3, Poly3],
            RuntimeData[
              Adt.Context[ParamType, I4, Poly4],
              RuntimeData[
                Adt.Context[ParamType, I5, Poly5],
                RuntimeData[
                  Adt.Context[ParamType, I6, Poly6],
                  RuntimeData[
                    Adt.Context[ParamType, I7, Poly7],
                    RuntimeData[
                      Adt.Context[ParamType, I8, Poly8],
                      RuntimeData[
                        Adt.Context[ParamType, I9, Poly9],
                        RuntimeData[
                          Adt.Context[ParamType, I10, Poly10],
                          RuntimeData[
                            Adt.Context[ParamType, I11, Poly11],
                            RuntimeData[
                              Adt.Context[ParamType, I12, Poly12],
                              RuntimeData[
                                Adt.Context[ParamType, I13, Poly13],
                                RuntimeData[
                                  Adt.Context[ParamType, I14, Poly14],
                                  RuntimeData[
                                    Adt.Context[ParamType, I15, Poly15],
                                    RuntimeData[
                                      Adt.Context[ParamType, I16, Poly16],
                                      RuntimeData[
                                        Adt.Context[ParamType, I17, Poly17],
                                        RuntimeData[
                                          Adt.Context[ParamType, I18, Poly18],
                                          RuntimeData[
                                            Adt.Context[ParamType, I19, Poly19],
                                            RuntimeData[Adt.Context[ParamType, I20, Poly20], RuntimeData[
                                              Adt.Context[ParamType, I21, Poly21],
                                              RuntimeData[Adt.Context[ParamType, I22, Poly22], RuntimeZero]
                                            ]]
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
              ]
            ]
          ]
        ]
      ],
      SImpl
    ]
  ) {

    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D,
      func7: I7 => D,
      func8: I8 => D,
      func9: I9 => D,
      func10: I10 => D,
      func11: I11 => D,
      func12: I12 => D,
      func13: I13 => D,
      func14: I14 => D,
      func15: I15 => D,
      func16: I16 => D,
      func17: I17 => D,
      func18: I18 => D,
      func19: I19 => D,
      func20: I20 => D,
      func21: I21 => D,
      func22: I22 => D
    ): D = ???

  }

}
