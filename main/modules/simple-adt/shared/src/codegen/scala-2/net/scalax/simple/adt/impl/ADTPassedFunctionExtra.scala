package net.scalax.simple.adt
package impl

import Adt.{Status => ADTStatus}
import temp._
import net.scalax.simple.adt.nat.{AdtNat, AdtNatPositive, AdtNatZero}

trait ADTPassedFunctionImpl extends ADTPassedFunction {
  implicit class extraFunctionAdt1[ParamType, I1, Poly1, S <: ADTStatus](
    private val data: ADTData[AdtNatPositive[Adt.Context[ParamType, I1, Poly1], AdtNatZero], S]
  ) {

    private val adtApply = Adt.CoProduct1[I1]

    def apply(param: ParamType): Adt.CoProduct1[I1] =
      new extra1(data).fold(s => adtApply(s.input(param)))

  }

  implicit class extraFunctionAdt2[ParamType, I1, Poly1, I2, Poly2, S <: ADTStatus](
    private val data: ADTData[
      AdtNatPositive[Adt.Context[ParamType, I2, Poly2], AdtNatPositive[Adt.Context[ParamType, I1, Poly1], AdtNatZero]],
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct2[I1, I2]

    def apply(param: ParamType): Adt.CoProduct2[I1, I2] =
      new extra2(data).fold(s => adtApply(s.input(param)), s => adtApply(s.input(param)))

  }

  implicit class extraFunctionAdt3[ParamType, I1, Poly1, I2, Poly2, I3, Poly3, S <: ADTStatus](
    private val data: ADTData[
      AdtNatPositive[
        Adt.Context[ParamType, I3, Poly3],
        AdtNatPositive[Adt.Context[ParamType, I2, Poly2], AdtNatPositive[Adt.Context[ParamType, I1, Poly1], AdtNatZero]]
      ],
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct3[I1, I2, I3]

    def apply(param: ParamType): Adt.CoProduct3[I1, I2, I3] =
      new extra3(data).fold(s => adtApply(s.input(param)), s => adtApply(s.input(param)), s => adtApply(s.input(param)))

  }

  implicit class extraFunctionAdt4[ParamType, I1, Poly1, I2, Poly2, I3, Poly3, I4, Poly4, S <: ADTStatus](
    private val data: ADTData[
      AdtNatPositive[
        Adt.Context[ParamType, I4, Poly4],
        AdtNatPositive[
          Adt.Context[ParamType, I3, Poly3],
          AdtNatPositive[Adt.Context[ParamType, I2, Poly2], AdtNatPositive[Adt.Context[ParamType, I1, Poly1], AdtNatZero]]
        ]
      ],
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct4[I1, I2, I3, I4]

    def apply(param: ParamType): Adt.CoProduct4[I1, I2, I3, I4] =
      new extra4(data).fold(
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param))
      )

  }

  implicit class extraFunctionAdt5[ParamType, I1, Poly1, I2, Poly2, I3, Poly3, I4, Poly4, I5, Poly5, S <: ADTStatus](
    private val data: ADTData[
      AdtNatPositive[
        Adt.Context[ParamType, I5, Poly5],
        AdtNatPositive[
          Adt.Context[ParamType, I4, Poly4],
          AdtNatPositive[
            Adt.Context[ParamType, I3, Poly3],
            AdtNatPositive[Adt.Context[ParamType, I2, Poly2], AdtNatPositive[Adt.Context[ParamType, I1, Poly1], AdtNatZero]]
          ]
        ]
      ],
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct5[I1, I2, I3, I4, I5]

    def apply(param: ParamType): Adt.CoProduct5[I1, I2, I3, I4, I5] =
      new extra5(data).fold(
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param))
      )

  }

  implicit class extraFunctionAdt6[ParamType, I1, Poly1, I2, Poly2, I3, Poly3, I4, Poly4, I5, Poly5, I6, Poly6, S <: ADTStatus](
    private val data: ADTData[
      AdtNatPositive[
        Adt.Context[ParamType, I6, Poly6],
        AdtNatPositive[
          Adt.Context[ParamType, I5, Poly5],
          AdtNatPositive[
            Adt.Context[ParamType, I4, Poly4],
            AdtNatPositive[
              Adt.Context[ParamType, I3, Poly3],
              AdtNatPositive[Adt.Context[ParamType, I2, Poly2], AdtNatPositive[Adt.Context[ParamType, I1, Poly1], AdtNatZero]]
            ]
          ]
        ]
      ],
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct6[I1, I2, I3, I4, I5, I6]

    def apply(param: ParamType): Adt.CoProduct6[I1, I2, I3, I4, I5, I6] =
      new extra6(data).fold(
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param))
      )

  }

  implicit class extraFunctionAdt7[ParamType, I1, Poly1, I2, Poly2, I3, Poly3, I4, Poly4, I5, Poly5, I6, Poly6, I7, Poly7, S <: ADTStatus](
    private val data: ADTData[
      AdtNatPositive[
        Adt.Context[ParamType, I7, Poly7],
        AdtNatPositive[
          Adt.Context[ParamType, I6, Poly6],
          AdtNatPositive[
            Adt.Context[ParamType, I5, Poly5],
            AdtNatPositive[
              Adt.Context[ParamType, I4, Poly4],
              AdtNatPositive[
                Adt.Context[ParamType, I3, Poly3],
                AdtNatPositive[Adt.Context[ParamType, I2, Poly2], AdtNatPositive[Adt.Context[ParamType, I1, Poly1], AdtNatZero]]
              ]
            ]
          ]
        ]
      ],
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct7[I1, I2, I3, I4, I5, I6, I7]

    def apply(param: ParamType): Adt.CoProduct7[I1, I2, I3, I4, I5, I6, I7] =
      new extra7(data).fold(
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param))
      )

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
      AdtNatPositive[
        Adt.Context[ParamType, I8, Poly8],
        AdtNatPositive[
          Adt.Context[ParamType, I7, Poly7],
          AdtNatPositive[
            Adt.Context[ParamType, I6, Poly6],
            AdtNatPositive[
              Adt.Context[ParamType, I5, Poly5],
              AdtNatPositive[
                Adt.Context[ParamType, I4, Poly4],
                AdtNatPositive[
                  Adt.Context[ParamType, I3, Poly3],
                  AdtNatPositive[Adt.Context[ParamType, I2, Poly2], AdtNatPositive[Adt.Context[ParamType, I1, Poly1], AdtNatZero]]
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

    def apply(param: ParamType): Adt.CoProduct8[I1, I2, I3, I4, I5, I6, I7, I8] =
      new extra8(data).fold(
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param))
      )

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
      AdtNatPositive[
        Adt.Context[ParamType, I9, Poly9],
        AdtNatPositive[
          Adt.Context[ParamType, I8, Poly8],
          AdtNatPositive[
            Adt.Context[ParamType, I7, Poly7],
            AdtNatPositive[
              Adt.Context[ParamType, I6, Poly6],
              AdtNatPositive[
                Adt.Context[ParamType, I5, Poly5],
                AdtNatPositive[
                  Adt.Context[ParamType, I4, Poly4],
                  AdtNatPositive[
                    Adt.Context[ParamType, I3, Poly3],
                    AdtNatPositive[Adt.Context[ParamType, I2, Poly2], AdtNatPositive[Adt.Context[ParamType, I1, Poly1], AdtNatZero]]
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

    def apply(param: ParamType): Adt.CoProduct9[I1, I2, I3, I4, I5, I6, I7, I8, I9] =
      new extra9(data).fold(
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param))
      )

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
      AdtNatPositive[
        Adt.Context[ParamType, I10, Poly10],
        AdtNatPositive[
          Adt.Context[ParamType, I9, Poly9],
          AdtNatPositive[
            Adt.Context[ParamType, I8, Poly8],
            AdtNatPositive[
              Adt.Context[ParamType, I7, Poly7],
              AdtNatPositive[
                Adt.Context[ParamType, I6, Poly6],
                AdtNatPositive[
                  Adt.Context[ParamType, I5, Poly5],
                  AdtNatPositive[
                    Adt.Context[ParamType, I4, Poly4],
                    AdtNatPositive[
                      Adt.Context[ParamType, I3, Poly3],
                      AdtNatPositive[Adt.Context[ParamType, I2, Poly2], AdtNatPositive[Adt.Context[ParamType, I1, Poly1], AdtNatZero]]
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

    def apply(param: ParamType): Adt.CoProduct10[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] =
      new extra10(data).fold(
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param))
      )

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
      AdtNatPositive[
        Adt.Context[ParamType, I11, Poly11],
        AdtNatPositive[
          Adt.Context[ParamType, I10, Poly10],
          AdtNatPositive[
            Adt.Context[ParamType, I9, Poly9],
            AdtNatPositive[
              Adt.Context[ParamType, I8, Poly8],
              AdtNatPositive[
                Adt.Context[ParamType, I7, Poly7],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, Poly6],
                  AdtNatPositive[
                    Adt.Context[ParamType, I5, Poly5],
                    AdtNatPositive[
                      Adt.Context[ParamType, I4, Poly4],
                      AdtNatPositive[
                        Adt.Context[ParamType, I3, Poly3],
                        AdtNatPositive[Adt.Context[ParamType, I2, Poly2], AdtNatPositive[Adt.Context[ParamType, I1, Poly1], AdtNatZero]]
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

    def apply(param: ParamType): Adt.CoProduct11[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] =
      new extra11(data).fold(
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param))
      )

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
      AdtNatPositive[
        Adt.Context[ParamType, I12, Poly12],
        AdtNatPositive[
          Adt.Context[ParamType, I11, Poly11],
          AdtNatPositive[
            Adt.Context[ParamType, I10, Poly10],
            AdtNatPositive[
              Adt.Context[ParamType, I9, Poly9],
              AdtNatPositive[
                Adt.Context[ParamType, I8, Poly8],
                AdtNatPositive[
                  Adt.Context[ParamType, I7, Poly7],
                  AdtNatPositive[
                    Adt.Context[ParamType, I6, Poly6],
                    AdtNatPositive[
                      Adt.Context[ParamType, I5, Poly5],
                      AdtNatPositive[
                        Adt.Context[ParamType, I4, Poly4],
                        AdtNatPositive[
                          Adt.Context[ParamType, I3, Poly3],
                          AdtNatPositive[Adt.Context[ParamType, I2, Poly2], AdtNatPositive[Adt.Context[ParamType, I1, Poly1], AdtNatZero]]
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

    def apply(param: ParamType): Adt.CoProduct12[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] =
      new extra12(data).fold(
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param))
      )

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
      AdtNatPositive[
        Adt.Context[ParamType, I13, Poly13],
        AdtNatPositive[
          Adt.Context[ParamType, I12, Poly12],
          AdtNatPositive[
            Adt.Context[ParamType, I11, Poly11],
            AdtNatPositive[
              Adt.Context[ParamType, I10, Poly10],
              AdtNatPositive[
                Adt.Context[ParamType, I9, Poly9],
                AdtNatPositive[
                  Adt.Context[ParamType, I8, Poly8],
                  AdtNatPositive[
                    Adt.Context[ParamType, I7, Poly7],
                    AdtNatPositive[
                      Adt.Context[ParamType, I6, Poly6],
                      AdtNatPositive[
                        Adt.Context[ParamType, I5, Poly5],
                        AdtNatPositive[
                          Adt.Context[ParamType, I4, Poly4],
                          AdtNatPositive[
                            Adt.Context[ParamType, I3, Poly3],
                            AdtNatPositive[Adt.Context[ParamType, I2, Poly2], AdtNatPositive[Adt.Context[ParamType, I1, Poly1], AdtNatZero]]
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

    def apply(param: ParamType): Adt.CoProduct13[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] =
      new extra13(data).fold(
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param))
      )

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
      AdtNatPositive[
        Adt.Context[ParamType, I14, Poly14],
        AdtNatPositive[
          Adt.Context[ParamType, I13, Poly13],
          AdtNatPositive[
            Adt.Context[ParamType, I12, Poly12],
            AdtNatPositive[
              Adt.Context[ParamType, I11, Poly11],
              AdtNatPositive[
                Adt.Context[ParamType, I10, Poly10],
                AdtNatPositive[
                  Adt.Context[ParamType, I9, Poly9],
                  AdtNatPositive[
                    Adt.Context[ParamType, I8, Poly8],
                    AdtNatPositive[
                      Adt.Context[ParamType, I7, Poly7],
                      AdtNatPositive[
                        Adt.Context[ParamType, I6, Poly6],
                        AdtNatPositive[
                          Adt.Context[ParamType, I5, Poly5],
                          AdtNatPositive[
                            Adt.Context[ParamType, I4, Poly4],
                            AdtNatPositive[Adt.Context[ParamType, I3, Poly3], AdtNatPositive[
                              Adt.Context[ParamType, I2, Poly2],
                              AdtNatPositive[Adt.Context[ParamType, I1, Poly1], AdtNatZero]
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

    def apply(param: ParamType): Adt.CoProduct14[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] =
      new extra14(data).fold(
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param))
      )

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
      AdtNatPositive[
        Adt.Context[ParamType, I15, Poly15],
        AdtNatPositive[
          Adt.Context[ParamType, I14, Poly14],
          AdtNatPositive[
            Adt.Context[ParamType, I13, Poly13],
            AdtNatPositive[
              Adt.Context[ParamType, I12, Poly12],
              AdtNatPositive[
                Adt.Context[ParamType, I11, Poly11],
                AdtNatPositive[
                  Adt.Context[ParamType, I10, Poly10],
                  AdtNatPositive[
                    Adt.Context[ParamType, I9, Poly9],
                    AdtNatPositive[
                      Adt.Context[ParamType, I8, Poly8],
                      AdtNatPositive[
                        Adt.Context[ParamType, I7, Poly7],
                        AdtNatPositive[
                          Adt.Context[ParamType, I6, Poly6],
                          AdtNatPositive[
                            Adt.Context[ParamType, I5, Poly5],
                            AdtNatPositive[
                              Adt.Context[ParamType, I4, Poly4],
                              AdtNatPositive[Adt.Context[ParamType, I3, Poly3], AdtNatPositive[
                                Adt.Context[ParamType, I2, Poly2],
                                AdtNatPositive[Adt.Context[ParamType, I1, Poly1], AdtNatZero]
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

    def apply(param: ParamType): Adt.CoProduct15[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] =
      new extra15(data).fold(
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param))
      )

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
      AdtNatPositive[
        Adt.Context[ParamType, I16, Poly16],
        AdtNatPositive[
          Adt.Context[ParamType, I15, Poly15],
          AdtNatPositive[
            Adt.Context[ParamType, I14, Poly14],
            AdtNatPositive[
              Adt.Context[ParamType, I13, Poly13],
              AdtNatPositive[
                Adt.Context[ParamType, I12, Poly12],
                AdtNatPositive[
                  Adt.Context[ParamType, I11, Poly11],
                  AdtNatPositive[
                    Adt.Context[ParamType, I10, Poly10],
                    AdtNatPositive[
                      Adt.Context[ParamType, I9, Poly9],
                      AdtNatPositive[
                        Adt.Context[ParamType, I8, Poly8],
                        AdtNatPositive[
                          Adt.Context[ParamType, I7, Poly7],
                          AdtNatPositive[
                            Adt.Context[ParamType, I6, Poly6],
                            AdtNatPositive[
                              Adt.Context[ParamType, I5, Poly5],
                              AdtNatPositive[
                                Adt.Context[ParamType, I4, Poly4],
                                AdtNatPositive[Adt.Context[ParamType, I3, Poly3], AdtNatPositive[
                                  Adt.Context[ParamType, I2, Poly2],
                                  AdtNatPositive[Adt.Context[ParamType, I1, Poly1], AdtNatZero]
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

    def apply(param: ParamType): Adt.CoProduct16[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] =
      new extra16(data).fold(
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param))
      )

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
      AdtNatPositive[
        Adt.Context[ParamType, I17, Poly17],
        AdtNatPositive[
          Adt.Context[ParamType, I16, Poly16],
          AdtNatPositive[
            Adt.Context[ParamType, I15, Poly15],
            AdtNatPositive[
              Adt.Context[ParamType, I14, Poly14],
              AdtNatPositive[
                Adt.Context[ParamType, I13, Poly13],
                AdtNatPositive[
                  Adt.Context[ParamType, I12, Poly12],
                  AdtNatPositive[
                    Adt.Context[ParamType, I11, Poly11],
                    AdtNatPositive[
                      Adt.Context[ParamType, I10, Poly10],
                      AdtNatPositive[
                        Adt.Context[ParamType, I9, Poly9],
                        AdtNatPositive[
                          Adt.Context[ParamType, I8, Poly8],
                          AdtNatPositive[
                            Adt.Context[ParamType, I7, Poly7],
                            AdtNatPositive[
                              Adt.Context[ParamType, I6, Poly6],
                              AdtNatPositive[
                                Adt.Context[ParamType, I5, Poly5],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I4, Poly4],
                                  AdtNatPositive[Adt.Context[ParamType, I3, Poly3], AdtNatPositive[
                                    Adt.Context[ParamType, I2, Poly2],
                                    AdtNatPositive[Adt.Context[ParamType, I1, Poly1], AdtNatZero]
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

    def apply(param: ParamType): Adt.CoProduct17[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] =
      new extra17(data).fold(
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param))
      )

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
      AdtNatPositive[
        Adt.Context[ParamType, I18, Poly18],
        AdtNatPositive[
          Adt.Context[ParamType, I17, Poly17],
          AdtNatPositive[
            Adt.Context[ParamType, I16, Poly16],
            AdtNatPositive[
              Adt.Context[ParamType, I15, Poly15],
              AdtNatPositive[
                Adt.Context[ParamType, I14, Poly14],
                AdtNatPositive[
                  Adt.Context[ParamType, I13, Poly13],
                  AdtNatPositive[
                    Adt.Context[ParamType, I12, Poly12],
                    AdtNatPositive[
                      Adt.Context[ParamType, I11, Poly11],
                      AdtNatPositive[
                        Adt.Context[ParamType, I10, Poly10],
                        AdtNatPositive[
                          Adt.Context[ParamType, I9, Poly9],
                          AdtNatPositive[
                            Adt.Context[ParamType, I8, Poly8],
                            AdtNatPositive[
                              Adt.Context[ParamType, I7, Poly7],
                              AdtNatPositive[
                                Adt.Context[ParamType, I6, Poly6],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I5, Poly5],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I4, Poly4],
                                    AdtNatPositive[Adt.Context[ParamType, I3, Poly3], AdtNatPositive[
                                      Adt.Context[ParamType, I2, Poly2],
                                      AdtNatPositive[Adt.Context[ParamType, I1, Poly1], AdtNatZero]
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

    def apply(param: ParamType): Adt.CoProduct18[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] =
      new extra18(data).fold(
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param))
      )

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
      AdtNatPositive[
        Adt.Context[ParamType, I19, Poly19],
        AdtNatPositive[
          Adt.Context[ParamType, I18, Poly18],
          AdtNatPositive[
            Adt.Context[ParamType, I17, Poly17],
            AdtNatPositive[
              Adt.Context[ParamType, I16, Poly16],
              AdtNatPositive[
                Adt.Context[ParamType, I15, Poly15],
                AdtNatPositive[
                  Adt.Context[ParamType, I14, Poly14],
                  AdtNatPositive[
                    Adt.Context[ParamType, I13, Poly13],
                    AdtNatPositive[
                      Adt.Context[ParamType, I12, Poly12],
                      AdtNatPositive[
                        Adt.Context[ParamType, I11, Poly11],
                        AdtNatPositive[
                          Adt.Context[ParamType, I10, Poly10],
                          AdtNatPositive[
                            Adt.Context[ParamType, I9, Poly9],
                            AdtNatPositive[
                              Adt.Context[ParamType, I8, Poly8],
                              AdtNatPositive[
                                Adt.Context[ParamType, I7, Poly7],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I6, Poly6],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I5, Poly5],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I4, Poly4],
                                      AdtNatPositive[Adt.Context[ParamType, I3, Poly3], AdtNatPositive[
                                        Adt.Context[ParamType, I2, Poly2],
                                        AdtNatPositive[Adt.Context[ParamType, I1, Poly1], AdtNatZero]
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

    def apply(param: ParamType): Adt.CoProduct19[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] =
      new extra19(data).fold(
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param))
      )

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
      AdtNatPositive[
        Adt.Context[ParamType, I20, Poly20],
        AdtNatPositive[
          Adt.Context[ParamType, I19, Poly19],
          AdtNatPositive[
            Adt.Context[ParamType, I18, Poly18],
            AdtNatPositive[
              Adt.Context[ParamType, I17, Poly17],
              AdtNatPositive[
                Adt.Context[ParamType, I16, Poly16],
                AdtNatPositive[
                  Adt.Context[ParamType, I15, Poly15],
                  AdtNatPositive[
                    Adt.Context[ParamType, I14, Poly14],
                    AdtNatPositive[
                      Adt.Context[ParamType, I13, Poly13],
                      AdtNatPositive[
                        Adt.Context[ParamType, I12, Poly12],
                        AdtNatPositive[
                          Adt.Context[ParamType, I11, Poly11],
                          AdtNatPositive[
                            Adt.Context[ParamType, I10, Poly10],
                            AdtNatPositive[
                              Adt.Context[ParamType, I9, Poly9],
                              AdtNatPositive[
                                Adt.Context[ParamType, I8, Poly8],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I7, Poly7],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I6, Poly6],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I5, Poly5],
                                      AdtNatPositive[
                                        Adt.Context[ParamType, I4, Poly4],
                                        AdtNatPositive[Adt.Context[ParamType, I3, Poly3], AdtNatPositive[
                                          Adt.Context[ParamType, I2, Poly2],
                                          AdtNatPositive[Adt.Context[ParamType, I1, Poly1], AdtNatZero]
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
    ): Adt.CoProduct20[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] =
      new extra20(data).fold(
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param))
      )

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
      AdtNatPositive[
        Adt.Context[ParamType, I21, Poly21],
        AdtNatPositive[
          Adt.Context[ParamType, I20, Poly20],
          AdtNatPositive[
            Adt.Context[ParamType, I19, Poly19],
            AdtNatPositive[
              Adt.Context[ParamType, I18, Poly18],
              AdtNatPositive[
                Adt.Context[ParamType, I17, Poly17],
                AdtNatPositive[
                  Adt.Context[ParamType, I16, Poly16],
                  AdtNatPositive[
                    Adt.Context[ParamType, I15, Poly15],
                    AdtNatPositive[
                      Adt.Context[ParamType, I14, Poly14],
                      AdtNatPositive[
                        Adt.Context[ParamType, I13, Poly13],
                        AdtNatPositive[
                          Adt.Context[ParamType, I12, Poly12],
                          AdtNatPositive[
                            Adt.Context[ParamType, I11, Poly11],
                            AdtNatPositive[
                              Adt.Context[ParamType, I10, Poly10],
                              AdtNatPositive[
                                Adt.Context[ParamType, I9, Poly9],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I8, Poly8],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I7, Poly7],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I6, Poly6],
                                      AdtNatPositive[
                                        Adt.Context[ParamType, I5, Poly5],
                                        AdtNatPositive[
                                          Adt.Context[ParamType, I4, Poly4],
                                          AdtNatPositive[Adt.Context[ParamType, I3, Poly3], AdtNatPositive[
                                            Adt.Context[ParamType, I2, Poly2],
                                            AdtNatPositive[Adt.Context[ParamType, I1, Poly1], AdtNatZero]
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
    ): Adt.CoProduct21[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] =
      new extra21(data).fold(
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param))
      )

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
      AdtNatPositive[
        Adt.Context[ParamType, I22, Poly22],
        AdtNatPositive[
          Adt.Context[ParamType, I21, Poly21],
          AdtNatPositive[
            Adt.Context[ParamType, I20, Poly20],
            AdtNatPositive[
              Adt.Context[ParamType, I19, Poly19],
              AdtNatPositive[
                Adt.Context[ParamType, I18, Poly18],
                AdtNatPositive[
                  Adt.Context[ParamType, I17, Poly17],
                  AdtNatPositive[
                    Adt.Context[ParamType, I16, Poly16],
                    AdtNatPositive[
                      Adt.Context[ParamType, I15, Poly15],
                      AdtNatPositive[
                        Adt.Context[ParamType, I14, Poly14],
                        AdtNatPositive[
                          Adt.Context[ParamType, I13, Poly13],
                          AdtNatPositive[
                            Adt.Context[ParamType, I12, Poly12],
                            AdtNatPositive[
                              Adt.Context[ParamType, I11, Poly11],
                              AdtNatPositive[
                                Adt.Context[ParamType, I10, Poly10],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I9, Poly9],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I8, Poly8],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I7, Poly7],
                                      AdtNatPositive[
                                        Adt.Context[ParamType, I6, Poly6],
                                        AdtNatPositive[
                                          Adt.Context[ParamType, I5, Poly5],
                                          AdtNatPositive[
                                            Adt.Context[ParamType, I4, Poly4],
                                            AdtNatPositive[Adt.Context[ParamType, I3, Poly3], AdtNatPositive[
                                              Adt.Context[ParamType, I2, Poly2],
                                              AdtNatPositive[Adt.Context[ParamType, I1, Poly1], AdtNatZero]
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
    ): Adt.CoProduct22[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22] =
      new extra22(data).fold(
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param)),
        s => adtApply(s.input(param))
      )

  }

}
