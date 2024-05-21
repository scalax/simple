package net.scalax.simple.adt
package impl

import Adt.{Status => ADTStatus}
import temp._
import net.scalax.simple.adt.{RuntimeData, RuntimeNat, RuntimeZero}

trait ADTPassedFunctionImpl {
  implicit class extraFunctionAdt1[ParamType, I1, Poly1, S <: ADTStatus](
    private val data: ADTData[RuntimeData[Adt.Context[ParamType, I1, Poly1], RuntimeZero], S]
  ) {

    private val adtApply = Adt.CoProduct1[I1]

    def apply(param: ParamType): Adt.CoProduct1[I1] = ???
    /* new ADTStatus.Passed.extra1(data).foldLaw(s => adtApply.option1(s.input(param): I1): Adt.CoProduct1[I1]) */

  }

  implicit class extraFunctionAdt2[ParamType, I1, Poly1, I2, Poly2, S <: ADTStatus](
    private val data: ADTData[
      RuntimeData[Adt.Context[ParamType, I1, Poly1], RuntimeData[Adt.Context[ParamType, I2, Poly2], RuntimeZero]],
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct2[I1, I2]

    def apply(param: ParamType): Adt.CoProduct2[I1, I2] = ???
    /* new ADTStatus.Passed.extra2(data).foldLaw(s => adtApply.option1(s.input(param): I1): Adt.CoProduct2[I1,I2],s => adtApply.option2(s.input(param): I2): Adt.CoProduct2[I1,I2]) */

  }

  implicit class extraFunctionAdt3[ParamType, I1, Poly1, I2, Poly2, I3, Poly3, S <: ADTStatus](
    private val data: ADTData[RuntimeData[
      Adt.Context[ParamType, I1, Poly1],
      RuntimeData[Adt.Context[ParamType, I2, Poly2], RuntimeData[Adt.Context[ParamType, I3, Poly3], RuntimeZero]]
    ], S]
  ) {

    private val adtApply = Adt.CoProduct3[I1, I2, I3]

    def apply(param: ParamType): Adt.CoProduct3[I1, I2, I3] = ???
    /* new ADTStatus.Passed.extra3(data).foldLaw(s => adtApply.option1(s.input(param): I1): Adt.CoProduct3[I1,I2,I3],s => adtApply.option2(s.input(param): I2): Adt.CoProduct3[I1,I2,I3],s => adtApply.option3(s.input(param): I3): Adt.CoProduct3[I1,I2,I3]) */

  }

  implicit class extraFunctionAdt4[ParamType, I1, Poly1, I2, Poly2, I3, Poly3, I4, Poly4, S <: ADTStatus](
    private val data: ADTData[
      RuntimeData[
        Adt.Context[ParamType, I1, Poly1],
        RuntimeData[
          Adt.Context[ParamType, I2, Poly2],
          RuntimeData[Adt.Context[ParamType, I3, Poly3], RuntimeData[Adt.Context[ParamType, I4, Poly4], RuntimeZero]]
        ]
      ],
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct4[I1, I2, I3, I4]

    def apply(param: ParamType): Adt.CoProduct4[I1, I2, I3, I4] = ???
    /* new ADTStatus.Passed.extra4(data).foldLaw(s => adtApply.option1(s.input(param): I1): Adt.CoProduct4[I1,I2,I3,I4],s => adtApply.option2(s.input(param): I2): Adt.CoProduct4[I1,I2,I3,I4],s => adtApply.option3(s.input(param): I3): Adt.CoProduct4[I1,I2,I3,I4],s => adtApply.option4(s.input(param): I4): Adt.CoProduct4[I1,I2,I3,I4]) */

  }

  implicit class extraFunctionAdt5[ParamType, I1, Poly1, I2, Poly2, I3, Poly3, I4, Poly4, I5, Poly5, S <: ADTStatus](
    private val data: ADTData[
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
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct5[I1, I2, I3, I4, I5]

    def apply(param: ParamType): Adt.CoProduct5[I1, I2, I3, I4, I5] = ???
    /* new ADTStatus.Passed.extra5(data).foldLaw(s => adtApply.option1(s.input(param): I1): Adt.CoProduct5[I1,I2,I3,I4,I5],s => adtApply.option2(s.input(param): I2): Adt.CoProduct5[I1,I2,I3,I4,I5],s => adtApply.option3(s.input(param): I3): Adt.CoProduct5[I1,I2,I3,I4,I5],s => adtApply.option4(s.input(param): I4): Adt.CoProduct5[I1,I2,I3,I4,I5],s => adtApply.option5(s.input(param): I5): Adt.CoProduct5[I1,I2,I3,I4,I5]) */

  }

  implicit class extraFunctionAdt6[ParamType, I1, Poly1, I2, Poly2, I3, Poly3, I4, Poly4, I5, Poly5, I6, Poly6, S <: ADTStatus](
    private val data: ADTData[
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
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct6[I1, I2, I3, I4, I5, I6]

    def apply(param: ParamType): Adt.CoProduct6[I1, I2, I3, I4, I5, I6] = ???
    /* new ADTStatus.Passed.extra6(data).foldLaw(s => adtApply.option1(s.input(param): I1): Adt.CoProduct6[I1,I2,I3,I4,I5,I6],s => adtApply.option2(s.input(param): I2): Adt.CoProduct6[I1,I2,I3,I4,I5,I6],s => adtApply.option3(s.input(param): I3): Adt.CoProduct6[I1,I2,I3,I4,I5,I6],s => adtApply.option4(s.input(param): I4): Adt.CoProduct6[I1,I2,I3,I4,I5,I6],s => adtApply.option5(s.input(param): I5): Adt.CoProduct6[I1,I2,I3,I4,I5,I6],s => adtApply.option6(s.input(param): I6): Adt.CoProduct6[I1,I2,I3,I4,I5,I6]) */

  }

  implicit class extraFunctionAdt7[ParamType, I1, Poly1, I2, Poly2, I3, Poly3, I4, Poly4, I5, Poly5, I6, Poly6, I7, Poly7, S <: ADTStatus](
    private val data: ADTData[
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
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct7[I1, I2, I3, I4, I5, I6, I7]

    def apply(param: ParamType): Adt.CoProduct7[I1, I2, I3, I4, I5, I6, I7] = ???
    /* new ADTStatus.Passed.extra7(data).foldLaw(s => adtApply.option1(s.input(param): I1): Adt.CoProduct7[I1,I2,I3,I4,I5,I6,I7],s => adtApply.option2(s.input(param): I2): Adt.CoProduct7[I1,I2,I3,I4,I5,I6,I7],s => adtApply.option3(s.input(param): I3): Adt.CoProduct7[I1,I2,I3,I4,I5,I6,I7],s => adtApply.option4(s.input(param): I4): Adt.CoProduct7[I1,I2,I3,I4,I5,I6,I7],s => adtApply.option5(s.input(param): I5): Adt.CoProduct7[I1,I2,I3,I4,I5,I6,I7],s => adtApply.option6(s.input(param): I6): Adt.CoProduct7[I1,I2,I3,I4,I5,I6,I7],s => adtApply.option7(s.input(param): I7): Adt.CoProduct7[I1,I2,I3,I4,I5,I6,I7]) */

  }

  implicit class extraFunctionAdt8[
    ParamType,
    I1,
    Poly1,
    I2,
    Poly2,
    I3,
    Poly3,
    I4,
    Poly4,
    I5,
    Poly5,
    I6,
    Poly6,
    I7,
    Poly7,
    I8,
    Poly8,
    S <: ADTStatus
  ](
    private val data: ADTData[
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
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct8[I1, I2, I3, I4, I5, I6, I7, I8]

    def apply(param: ParamType): Adt.CoProduct8[I1, I2, I3, I4, I5, I6, I7, I8] = ???
    /* new ADTStatus.Passed.extra8(data).foldLaw(s => adtApply.option1(s.input(param): I1): Adt.CoProduct8[I1,I2,I3,I4,I5,I6,I7,I8],s => adtApply.option2(s.input(param): I2): Adt.CoProduct8[I1,I2,I3,I4,I5,I6,I7,I8],s => adtApply.option3(s.input(param): I3): Adt.CoProduct8[I1,I2,I3,I4,I5,I6,I7,I8],s => adtApply.option4(s.input(param): I4): Adt.CoProduct8[I1,I2,I3,I4,I5,I6,I7,I8],s => adtApply.option5(s.input(param): I5): Adt.CoProduct8[I1,I2,I3,I4,I5,I6,I7,I8],s => adtApply.option6(s.input(param): I6): Adt.CoProduct8[I1,I2,I3,I4,I5,I6,I7,I8],s => adtApply.option7(s.input(param): I7): Adt.CoProduct8[I1,I2,I3,I4,I5,I6,I7,I8],s => adtApply.option8(s.input(param): I8): Adt.CoProduct8[I1,I2,I3,I4,I5,I6,I7,I8]) */

  }

  implicit class extraFunctionAdt9[
    ParamType,
    I1,
    Poly1,
    I2,
    Poly2,
    I3,
    Poly3,
    I4,
    Poly4,
    I5,
    Poly5,
    I6,
    Poly6,
    I7,
    Poly7,
    I8,
    Poly8,
    I9,
    Poly9,
    S <: ADTStatus
  ](
    private val data: ADTData[
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
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct9[I1, I2, I3, I4, I5, I6, I7, I8, I9]

    def apply(param: ParamType): Adt.CoProduct9[I1, I2, I3, I4, I5, I6, I7, I8, I9] = ???
    /* new ADTStatus.Passed.extra9(data).foldLaw(s => adtApply.option1(s.input(param): I1): Adt.CoProduct9[I1,I2,I3,I4,I5,I6,I7,I8,I9],s => adtApply.option2(s.input(param): I2): Adt.CoProduct9[I1,I2,I3,I4,I5,I6,I7,I8,I9],s => adtApply.option3(s.input(param): I3): Adt.CoProduct9[I1,I2,I3,I4,I5,I6,I7,I8,I9],s => adtApply.option4(s.input(param): I4): Adt.CoProduct9[I1,I2,I3,I4,I5,I6,I7,I8,I9],s => adtApply.option5(s.input(param): I5): Adt.CoProduct9[I1,I2,I3,I4,I5,I6,I7,I8,I9],s => adtApply.option6(s.input(param): I6): Adt.CoProduct9[I1,I2,I3,I4,I5,I6,I7,I8,I9],s => adtApply.option7(s.input(param): I7): Adt.CoProduct9[I1,I2,I3,I4,I5,I6,I7,I8,I9],s => adtApply.option8(s.input(param): I8): Adt.CoProduct9[I1,I2,I3,I4,I5,I6,I7,I8,I9],s => adtApply.option9(s.input(param): I9): Adt.CoProduct9[I1,I2,I3,I4,I5,I6,I7,I8,I9]) */

  }

  implicit class extraFunctionAdt10[
    ParamType,
    I1,
    Poly1,
    I2,
    Poly2,
    I3,
    Poly3,
    I4,
    Poly4,
    I5,
    Poly5,
    I6,
    Poly6,
    I7,
    Poly7,
    I8,
    Poly8,
    I9,
    Poly9,
    I10,
    Poly10,
    S <: ADTStatus
  ](
    private val data: ADTData[
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
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct10[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10]

    def apply(param: ParamType): Adt.CoProduct10[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] = ???
    /* new ADTStatus.Passed.extra10(data).foldLaw(s => adtApply.option1(s.input(param): I1): Adt.CoProduct10[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10],s => adtApply.option2(s.input(param): I2): Adt.CoProduct10[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10],s => adtApply.option3(s.input(param): I3): Adt.CoProduct10[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10],s => adtApply.option4(s.input(param): I4): Adt.CoProduct10[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10],s => adtApply.option5(s.input(param): I5): Adt.CoProduct10[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10],s => adtApply.option6(s.input(param): I6): Adt.CoProduct10[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10],s => adtApply.option7(s.input(param): I7): Adt.CoProduct10[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10],s => adtApply.option8(s.input(param): I8): Adt.CoProduct10[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10],s => adtApply.option9(s.input(param): I9): Adt.CoProduct10[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10],s => adtApply.option10(s.input(param): I10): Adt.CoProduct10[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10]) */

  }

  implicit class extraFunctionAdt11[
    ParamType,
    I1,
    Poly1,
    I2,
    Poly2,
    I3,
    Poly3,
    I4,
    Poly4,
    I5,
    Poly5,
    I6,
    Poly6,
    I7,
    Poly7,
    I8,
    Poly8,
    I9,
    Poly9,
    I10,
    Poly10,
    I11,
    Poly11,
    S <: ADTStatus
  ](
    private val data: ADTData[
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
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct11[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11]

    def apply(param: ParamType): Adt.CoProduct11[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] = ???
    /* new ADTStatus.Passed.extra11(data).foldLaw(s => adtApply.option1(s.input(param): I1): Adt.CoProduct11[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11],s => adtApply.option2(s.input(param): I2): Adt.CoProduct11[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11],s => adtApply.option3(s.input(param): I3): Adt.CoProduct11[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11],s => adtApply.option4(s.input(param): I4): Adt.CoProduct11[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11],s => adtApply.option5(s.input(param): I5): Adt.CoProduct11[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11],s => adtApply.option6(s.input(param): I6): Adt.CoProduct11[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11],s => adtApply.option7(s.input(param): I7): Adt.CoProduct11[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11],s => adtApply.option8(s.input(param): I8): Adt.CoProduct11[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11],s => adtApply.option9(s.input(param): I9): Adt.CoProduct11[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11],s => adtApply.option10(s.input(param): I10): Adt.CoProduct11[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11],s => adtApply.option11(s.input(param): I11): Adt.CoProduct11[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11]) */

  }

  implicit class extraFunctionAdt12[
    ParamType,
    I1,
    Poly1,
    I2,
    Poly2,
    I3,
    Poly3,
    I4,
    Poly4,
    I5,
    Poly5,
    I6,
    Poly6,
    I7,
    Poly7,
    I8,
    Poly8,
    I9,
    Poly9,
    I10,
    Poly10,
    I11,
    Poly11,
    I12,
    Poly12,
    S <: ADTStatus
  ](
    private val data: ADTData[
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
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct12[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12]

    def apply(param: ParamType): Adt.CoProduct12[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] = ???
    /* new ADTStatus.Passed.extra12(data).foldLaw(s => adtApply.option1(s.input(param): I1): Adt.CoProduct12[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12],s => adtApply.option2(s.input(param): I2): Adt.CoProduct12[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12],s => adtApply.option3(s.input(param): I3): Adt.CoProduct12[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12],s => adtApply.option4(s.input(param): I4): Adt.CoProduct12[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12],s => adtApply.option5(s.input(param): I5): Adt.CoProduct12[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12],s => adtApply.option6(s.input(param): I6): Adt.CoProduct12[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12],s => adtApply.option7(s.input(param): I7): Adt.CoProduct12[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12],s => adtApply.option8(s.input(param): I8): Adt.CoProduct12[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12],s => adtApply.option9(s.input(param): I9): Adt.CoProduct12[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12],s => adtApply.option10(s.input(param): I10): Adt.CoProduct12[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12],s => adtApply.option11(s.input(param): I11): Adt.CoProduct12[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12],s => adtApply.option12(s.input(param): I12): Adt.CoProduct12[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12]) */

  }

  implicit class extraFunctionAdt13[
    ParamType,
    I1,
    Poly1,
    I2,
    Poly2,
    I3,
    Poly3,
    I4,
    Poly4,
    I5,
    Poly5,
    I6,
    Poly6,
    I7,
    Poly7,
    I8,
    Poly8,
    I9,
    Poly9,
    I10,
    Poly10,
    I11,
    Poly11,
    I12,
    Poly12,
    I13,
    Poly13,
    S <: ADTStatus
  ](
    private val data: ADTData[
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
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct13[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13]

    def apply(param: ParamType): Adt.CoProduct13[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] = ???
    /* new ADTStatus.Passed.extra13(data).foldLaw(s => adtApply.option1(s.input(param): I1): Adt.CoProduct13[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13],s => adtApply.option2(s.input(param): I2): Adt.CoProduct13[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13],s => adtApply.option3(s.input(param): I3): Adt.CoProduct13[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13],s => adtApply.option4(s.input(param): I4): Adt.CoProduct13[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13],s => adtApply.option5(s.input(param): I5): Adt.CoProduct13[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13],s => adtApply.option6(s.input(param): I6): Adt.CoProduct13[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13],s => adtApply.option7(s.input(param): I7): Adt.CoProduct13[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13],s => adtApply.option8(s.input(param): I8): Adt.CoProduct13[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13],s => adtApply.option9(s.input(param): I9): Adt.CoProduct13[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13],s => adtApply.option10(s.input(param): I10): Adt.CoProduct13[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13],s => adtApply.option11(s.input(param): I11): Adt.CoProduct13[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13],s => adtApply.option12(s.input(param): I12): Adt.CoProduct13[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13],s => adtApply.option13(s.input(param): I13): Adt.CoProduct13[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13]) */

  }

  implicit class extraFunctionAdt14[
    ParamType,
    I1,
    Poly1,
    I2,
    Poly2,
    I3,
    Poly3,
    I4,
    Poly4,
    I5,
    Poly5,
    I6,
    Poly6,
    I7,
    Poly7,
    I8,
    Poly8,
    I9,
    Poly9,
    I10,
    Poly10,
    I11,
    Poly11,
    I12,
    Poly12,
    I13,
    Poly13,
    I14,
    Poly14,
    S <: ADTStatus
  ](
    private val data: ADTData[
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
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct14[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14]

    def apply(param: ParamType): Adt.CoProduct14[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] = ???
    /* new ADTStatus.Passed.extra14(data).foldLaw(s => adtApply.option1(s.input(param): I1): Adt.CoProduct14[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14],s => adtApply.option2(s.input(param): I2): Adt.CoProduct14[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14],s => adtApply.option3(s.input(param): I3): Adt.CoProduct14[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14],s => adtApply.option4(s.input(param): I4): Adt.CoProduct14[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14],s => adtApply.option5(s.input(param): I5): Adt.CoProduct14[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14],s => adtApply.option6(s.input(param): I6): Adt.CoProduct14[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14],s => adtApply.option7(s.input(param): I7): Adt.CoProduct14[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14],s => adtApply.option8(s.input(param): I8): Adt.CoProduct14[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14],s => adtApply.option9(s.input(param): I9): Adt.CoProduct14[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14],s => adtApply.option10(s.input(param): I10): Adt.CoProduct14[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14],s => adtApply.option11(s.input(param): I11): Adt.CoProduct14[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14],s => adtApply.option12(s.input(param): I12): Adt.CoProduct14[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14],s => adtApply.option13(s.input(param): I13): Adt.CoProduct14[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14],s => adtApply.option14(s.input(param): I14): Adt.CoProduct14[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14]) */

  }

  implicit class extraFunctionAdt15[
    ParamType,
    I1,
    Poly1,
    I2,
    Poly2,
    I3,
    Poly3,
    I4,
    Poly4,
    I5,
    Poly5,
    I6,
    Poly6,
    I7,
    Poly7,
    I8,
    Poly8,
    I9,
    Poly9,
    I10,
    Poly10,
    I11,
    Poly11,
    I12,
    Poly12,
    I13,
    Poly13,
    I14,
    Poly14,
    I15,
    Poly15,
    S <: ADTStatus
  ](
    private val data: ADTData[
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
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct15[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15]

    def apply(param: ParamType): Adt.CoProduct15[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] = ???
    /* new ADTStatus.Passed.extra15(data).foldLaw(s => adtApply.option1(s.input(param): I1): Adt.CoProduct15[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15],s => adtApply.option2(s.input(param): I2): Adt.CoProduct15[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15],s => adtApply.option3(s.input(param): I3): Adt.CoProduct15[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15],s => adtApply.option4(s.input(param): I4): Adt.CoProduct15[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15],s => adtApply.option5(s.input(param): I5): Adt.CoProduct15[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15],s => adtApply.option6(s.input(param): I6): Adt.CoProduct15[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15],s => adtApply.option7(s.input(param): I7): Adt.CoProduct15[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15],s => adtApply.option8(s.input(param): I8): Adt.CoProduct15[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15],s => adtApply.option9(s.input(param): I9): Adt.CoProduct15[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15],s => adtApply.option10(s.input(param): I10): Adt.CoProduct15[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15],s => adtApply.option11(s.input(param): I11): Adt.CoProduct15[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15],s => adtApply.option12(s.input(param): I12): Adt.CoProduct15[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15],s => adtApply.option13(s.input(param): I13): Adt.CoProduct15[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15],s => adtApply.option14(s.input(param): I14): Adt.CoProduct15[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15],s => adtApply.option15(s.input(param): I15): Adt.CoProduct15[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15]) */

  }

  implicit class extraFunctionAdt16[
    ParamType,
    I1,
    Poly1,
    I2,
    Poly2,
    I3,
    Poly3,
    I4,
    Poly4,
    I5,
    Poly5,
    I6,
    Poly6,
    I7,
    Poly7,
    I8,
    Poly8,
    I9,
    Poly9,
    I10,
    Poly10,
    I11,
    Poly11,
    I12,
    Poly12,
    I13,
    Poly13,
    I14,
    Poly14,
    I15,
    Poly15,
    I16,
    Poly16,
    S <: ADTStatus
  ](
    private val data: ADTData[
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
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct16[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16]

    def apply(param: ParamType): Adt.CoProduct16[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] = ???
    /* new ADTStatus.Passed.extra16(data).foldLaw(s => adtApply.option1(s.input(param): I1): Adt.CoProduct16[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16],s => adtApply.option2(s.input(param): I2): Adt.CoProduct16[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16],s => adtApply.option3(s.input(param): I3): Adt.CoProduct16[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16],s => adtApply.option4(s.input(param): I4): Adt.CoProduct16[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16],s => adtApply.option5(s.input(param): I5): Adt.CoProduct16[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16],s => adtApply.option6(s.input(param): I6): Adt.CoProduct16[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16],s => adtApply.option7(s.input(param): I7): Adt.CoProduct16[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16],s => adtApply.option8(s.input(param): I8): Adt.CoProduct16[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16],s => adtApply.option9(s.input(param): I9): Adt.CoProduct16[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16],s => adtApply.option10(s.input(param): I10): Adt.CoProduct16[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16],s => adtApply.option11(s.input(param): I11): Adt.CoProduct16[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16],s => adtApply.option12(s.input(param): I12): Adt.CoProduct16[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16],s => adtApply.option13(s.input(param): I13): Adt.CoProduct16[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16],s => adtApply.option14(s.input(param): I14): Adt.CoProduct16[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16],s => adtApply.option15(s.input(param): I15): Adt.CoProduct16[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16],s => adtApply.option16(s.input(param): I16): Adt.CoProduct16[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16]) */

  }

  implicit class extraFunctionAdt17[
    ParamType,
    I1,
    Poly1,
    I2,
    Poly2,
    I3,
    Poly3,
    I4,
    Poly4,
    I5,
    Poly5,
    I6,
    Poly6,
    I7,
    Poly7,
    I8,
    Poly8,
    I9,
    Poly9,
    I10,
    Poly10,
    I11,
    Poly11,
    I12,
    Poly12,
    I13,
    Poly13,
    I14,
    Poly14,
    I15,
    Poly15,
    I16,
    Poly16,
    I17,
    Poly17,
    S <: ADTStatus
  ](
    private val data: ADTData[
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
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct17[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17]

    def apply(param: ParamType): Adt.CoProduct17[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] = ???
    /* new ADTStatus.Passed.extra17(data).foldLaw(s => adtApply.option1(s.input(param): I1): Adt.CoProduct17[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17],s => adtApply.option2(s.input(param): I2): Adt.CoProduct17[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17],s => adtApply.option3(s.input(param): I3): Adt.CoProduct17[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17],s => adtApply.option4(s.input(param): I4): Adt.CoProduct17[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17],s => adtApply.option5(s.input(param): I5): Adt.CoProduct17[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17],s => adtApply.option6(s.input(param): I6): Adt.CoProduct17[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17],s => adtApply.option7(s.input(param): I7): Adt.CoProduct17[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17],s => adtApply.option8(s.input(param): I8): Adt.CoProduct17[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17],s => adtApply.option9(s.input(param): I9): Adt.CoProduct17[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17],s => adtApply.option10(s.input(param): I10): Adt.CoProduct17[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17],s => adtApply.option11(s.input(param): I11): Adt.CoProduct17[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17],s => adtApply.option12(s.input(param): I12): Adt.CoProduct17[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17],s => adtApply.option13(s.input(param): I13): Adt.CoProduct17[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17],s => adtApply.option14(s.input(param): I14): Adt.CoProduct17[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17],s => adtApply.option15(s.input(param): I15): Adt.CoProduct17[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17],s => adtApply.option16(s.input(param): I16): Adt.CoProduct17[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17],s => adtApply.option17(s.input(param): I17): Adt.CoProduct17[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17]) */

  }

  implicit class extraFunctionAdt18[
    ParamType,
    I1,
    Poly1,
    I2,
    Poly2,
    I3,
    Poly3,
    I4,
    Poly4,
    I5,
    Poly5,
    I6,
    Poly6,
    I7,
    Poly7,
    I8,
    Poly8,
    I9,
    Poly9,
    I10,
    Poly10,
    I11,
    Poly11,
    I12,
    Poly12,
    I13,
    Poly13,
    I14,
    Poly14,
    I15,
    Poly15,
    I16,
    Poly16,
    I17,
    Poly17,
    I18,
    Poly18,
    S <: ADTStatus
  ](
    private val data: ADTData[
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
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct18[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18]

    def apply(param: ParamType): Adt.CoProduct18[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] = ???
    /* new ADTStatus.Passed.extra18(data).foldLaw(s => adtApply.option1(s.input(param): I1): Adt.CoProduct18[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18],s => adtApply.option2(s.input(param): I2): Adt.CoProduct18[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18],s => adtApply.option3(s.input(param): I3): Adt.CoProduct18[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18],s => adtApply.option4(s.input(param): I4): Adt.CoProduct18[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18],s => adtApply.option5(s.input(param): I5): Adt.CoProduct18[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18],s => adtApply.option6(s.input(param): I6): Adt.CoProduct18[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18],s => adtApply.option7(s.input(param): I7): Adt.CoProduct18[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18],s => adtApply.option8(s.input(param): I8): Adt.CoProduct18[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18],s => adtApply.option9(s.input(param): I9): Adt.CoProduct18[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18],s => adtApply.option10(s.input(param): I10): Adt.CoProduct18[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18],s => adtApply.option11(s.input(param): I11): Adt.CoProduct18[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18],s => adtApply.option12(s.input(param): I12): Adt.CoProduct18[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18],s => adtApply.option13(s.input(param): I13): Adt.CoProduct18[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18],s => adtApply.option14(s.input(param): I14): Adt.CoProduct18[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18],s => adtApply.option15(s.input(param): I15): Adt.CoProduct18[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18],s => adtApply.option16(s.input(param): I16): Adt.CoProduct18[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18],s => adtApply.option17(s.input(param): I17): Adt.CoProduct18[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18],s => adtApply.option18(s.input(param): I18): Adt.CoProduct18[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18]) */

  }

  implicit class extraFunctionAdt19[
    ParamType,
    I1,
    Poly1,
    I2,
    Poly2,
    I3,
    Poly3,
    I4,
    Poly4,
    I5,
    Poly5,
    I6,
    Poly6,
    I7,
    Poly7,
    I8,
    Poly8,
    I9,
    Poly9,
    I10,
    Poly10,
    I11,
    Poly11,
    I12,
    Poly12,
    I13,
    Poly13,
    I14,
    Poly14,
    I15,
    Poly15,
    I16,
    Poly16,
    I17,
    Poly17,
    I18,
    Poly18,
    I19,
    Poly19,
    S <: ADTStatus
  ](
    private val data: ADTData[
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
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct19[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19]

    def apply(param: ParamType): Adt.CoProduct19[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] = ???
    /* new ADTStatus.Passed.extra19(data).foldLaw(s => adtApply.option1(s.input(param): I1): Adt.CoProduct19[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19],s => adtApply.option2(s.input(param): I2): Adt.CoProduct19[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19],s => adtApply.option3(s.input(param): I3): Adt.CoProduct19[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19],s => adtApply.option4(s.input(param): I4): Adt.CoProduct19[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19],s => adtApply.option5(s.input(param): I5): Adt.CoProduct19[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19],s => adtApply.option6(s.input(param): I6): Adt.CoProduct19[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19],s => adtApply.option7(s.input(param): I7): Adt.CoProduct19[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19],s => adtApply.option8(s.input(param): I8): Adt.CoProduct19[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19],s => adtApply.option9(s.input(param): I9): Adt.CoProduct19[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19],s => adtApply.option10(s.input(param): I10): Adt.CoProduct19[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19],s => adtApply.option11(s.input(param): I11): Adt.CoProduct19[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19],s => adtApply.option12(s.input(param): I12): Adt.CoProduct19[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19],s => adtApply.option13(s.input(param): I13): Adt.CoProduct19[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19],s => adtApply.option14(s.input(param): I14): Adt.CoProduct19[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19],s => adtApply.option15(s.input(param): I15): Adt.CoProduct19[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19],s => adtApply.option16(s.input(param): I16): Adt.CoProduct19[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19],s => adtApply.option17(s.input(param): I17): Adt.CoProduct19[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19],s => adtApply.option18(s.input(param): I18): Adt.CoProduct19[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19],s => adtApply.option19(s.input(param): I19): Adt.CoProduct19[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19]) */

  }

  implicit class extraFunctionAdt20[
    ParamType,
    I1,
    Poly1,
    I2,
    Poly2,
    I3,
    Poly3,
    I4,
    Poly4,
    I5,
    Poly5,
    I6,
    Poly6,
    I7,
    Poly7,
    I8,
    Poly8,
    I9,
    Poly9,
    I10,
    Poly10,
    I11,
    Poly11,
    I12,
    Poly12,
    I13,
    Poly13,
    I14,
    Poly14,
    I15,
    Poly15,
    I16,
    Poly16,
    I17,
    Poly17,
    I18,
    Poly18,
    I19,
    Poly19,
    I20,
    Poly20,
    S <: ADTStatus
  ](
    private val data: ADTData[
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
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct20[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20]

    def apply(
      param: ParamType
    ): Adt.CoProduct20[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] = ???
    /* new ADTStatus.Passed.extra20(data).foldLaw(s => adtApply.option1(s.input(param): I1): Adt.CoProduct20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20],s => adtApply.option2(s.input(param): I2): Adt.CoProduct20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20],s => adtApply.option3(s.input(param): I3): Adt.CoProduct20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20],s => adtApply.option4(s.input(param): I4): Adt.CoProduct20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20],s => adtApply.option5(s.input(param): I5): Adt.CoProduct20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20],s => adtApply.option6(s.input(param): I6): Adt.CoProduct20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20],s => adtApply.option7(s.input(param): I7): Adt.CoProduct20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20],s => adtApply.option8(s.input(param): I8): Adt.CoProduct20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20],s => adtApply.option9(s.input(param): I9): Adt.CoProduct20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20],s => adtApply.option10(s.input(param): I10): Adt.CoProduct20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20],s => adtApply.option11(s.input(param): I11): Adt.CoProduct20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20],s => adtApply.option12(s.input(param): I12): Adt.CoProduct20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20],s => adtApply.option13(s.input(param): I13): Adt.CoProduct20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20],s => adtApply.option14(s.input(param): I14): Adt.CoProduct20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20],s => adtApply.option15(s.input(param): I15): Adt.CoProduct20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20],s => adtApply.option16(s.input(param): I16): Adt.CoProduct20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20],s => adtApply.option17(s.input(param): I17): Adt.CoProduct20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20],s => adtApply.option18(s.input(param): I18): Adt.CoProduct20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20],s => adtApply.option19(s.input(param): I19): Adt.CoProduct20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20],s => adtApply.option20(s.input(param): I20): Adt.CoProduct20[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20]) */

  }

  implicit class extraFunctionAdt21[
    ParamType,
    I1,
    Poly1,
    I2,
    Poly2,
    I3,
    Poly3,
    I4,
    Poly4,
    I5,
    Poly5,
    I6,
    Poly6,
    I7,
    Poly7,
    I8,
    Poly8,
    I9,
    Poly9,
    I10,
    Poly10,
    I11,
    Poly11,
    I12,
    Poly12,
    I13,
    Poly13,
    I14,
    Poly14,
    I15,
    Poly15,
    I16,
    Poly16,
    I17,
    Poly17,
    I18,
    Poly18,
    I19,
    Poly19,
    I20,
    Poly20,
    I21,
    Poly21,
    S <: ADTStatus
  ](
    private val data: ADTData[
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
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct21[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21]

    def apply(
      param: ParamType
    ): Adt.CoProduct21[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] = ???
    /* new ADTStatus.Passed.extra21(data).foldLaw(s => adtApply.option1(s.input(param): I1): Adt.CoProduct21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21],s => adtApply.option2(s.input(param): I2): Adt.CoProduct21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21],s => adtApply.option3(s.input(param): I3): Adt.CoProduct21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21],s => adtApply.option4(s.input(param): I4): Adt.CoProduct21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21],s => adtApply.option5(s.input(param): I5): Adt.CoProduct21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21],s => adtApply.option6(s.input(param): I6): Adt.CoProduct21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21],s => adtApply.option7(s.input(param): I7): Adt.CoProduct21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21],s => adtApply.option8(s.input(param): I8): Adt.CoProduct21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21],s => adtApply.option9(s.input(param): I9): Adt.CoProduct21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21],s => adtApply.option10(s.input(param): I10): Adt.CoProduct21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21],s => adtApply.option11(s.input(param): I11): Adt.CoProduct21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21],s => adtApply.option12(s.input(param): I12): Adt.CoProduct21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21],s => adtApply.option13(s.input(param): I13): Adt.CoProduct21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21],s => adtApply.option14(s.input(param): I14): Adt.CoProduct21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21],s => adtApply.option15(s.input(param): I15): Adt.CoProduct21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21],s => adtApply.option16(s.input(param): I16): Adt.CoProduct21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21],s => adtApply.option17(s.input(param): I17): Adt.CoProduct21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21],s => adtApply.option18(s.input(param): I18): Adt.CoProduct21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21],s => adtApply.option19(s.input(param): I19): Adt.CoProduct21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21],s => adtApply.option20(s.input(param): I20): Adt.CoProduct21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21],s => adtApply.option21(s.input(param): I21): Adt.CoProduct21[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21]) */

  }

  implicit class extraFunctionAdt22[
    ParamType,
    I1,
    Poly1,
    I2,
    Poly2,
    I3,
    Poly3,
    I4,
    Poly4,
    I5,
    Poly5,
    I6,
    Poly6,
    I7,
    Poly7,
    I8,
    Poly8,
    I9,
    Poly9,
    I10,
    Poly10,
    I11,
    Poly11,
    I12,
    Poly12,
    I13,
    Poly13,
    I14,
    Poly14,
    I15,
    Poly15,
    I16,
    Poly16,
    I17,
    Poly17,
    I18,
    Poly18,
    I19,
    Poly19,
    I20,
    Poly20,
    I21,
    Poly21,
    I22,
    Poly22,
    S <: ADTStatus
  ](
    private val data: ADTData[
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
      S
    ]
  ) {

    private val adtApply =
      Adt.CoProduct22[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22]

    def apply(
      param: ParamType
    ): Adt.CoProduct22[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22] = ???
    /* new ADTStatus.Passed.extra22(data).foldLaw(s => adtApply.option1(s.input(param): I1): Adt.CoProduct22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22],s => adtApply.option2(s.input(param): I2): Adt.CoProduct22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22],s => adtApply.option3(s.input(param): I3): Adt.CoProduct22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22],s => adtApply.option4(s.input(param): I4): Adt.CoProduct22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22],s => adtApply.option5(s.input(param): I5): Adt.CoProduct22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22],s => adtApply.option6(s.input(param): I6): Adt.CoProduct22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22],s => adtApply.option7(s.input(param): I7): Adt.CoProduct22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22],s => adtApply.option8(s.input(param): I8): Adt.CoProduct22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22],s => adtApply.option9(s.input(param): I9): Adt.CoProduct22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22],s => adtApply.option10(s.input(param): I10): Adt.CoProduct22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22],s => adtApply.option11(s.input(param): I11): Adt.CoProduct22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22],s => adtApply.option12(s.input(param): I12): Adt.CoProduct22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22],s => adtApply.option13(s.input(param): I13): Adt.CoProduct22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22],s => adtApply.option14(s.input(param): I14): Adt.CoProduct22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22],s => adtApply.option15(s.input(param): I15): Adt.CoProduct22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22],s => adtApply.option16(s.input(param): I16): Adt.CoProduct22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22],s => adtApply.option17(s.input(param): I17): Adt.CoProduct22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22],s => adtApply.option18(s.input(param): I18): Adt.CoProduct22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22],s => adtApply.option19(s.input(param): I19): Adt.CoProduct22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22],s => adtApply.option20(s.input(param): I20): Adt.CoProduct22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22],s => adtApply.option21(s.input(param): I21): Adt.CoProduct22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22],s => adtApply.option22(s.input(param): I22): Adt.CoProduct22[I1,I2,I3,I4,I5,I6,I7,I8,I9,I10,I11,I12,I13,I14,I15,I16,I17,I18,I19,I20,I21,I22]) */

  }

}
