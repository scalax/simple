package net.scalax.simple.adt
package impl

import Adt.{Status => ADTStatus}
import temp._
import net.scalax.simple.adt.nat.{AdtNat, AdtNatPositive, AdtNatZero}

trait ADTPassedFunctionImpl extends ADTPassedFunction {
  implicit class extraFunctionAdt1[ParamType, I1, S <: ADTStatus](
    private val data: ADTData[AdtNatPositive[ParamType => I1, AdtNatZero], S]
  ) {

    private val adtApply = Adt.CoProduct1[I1]

    def apply(param: ParamType): Adt.CoProduct1[I1] =
      new extra1(data).fold(s => adtApply(s(param)))

  }

  implicit class extraFunctionAdt2[ParamType, I1, I2, S <: ADTStatus](
    private val data: ADTData[AdtNatPositive[ParamType => I2, AdtNatPositive[ParamType => I1, AdtNatZero]], S]
  ) {

    private val adtApply = Adt.CoProduct2[I1, I2]

    def apply(param: ParamType): Adt.CoProduct2[I1, I2] =
      new extra2(data).fold(s => adtApply(s(param)), s => adtApply(s(param)))

  }

  implicit class extraFunctionAdt3[ParamType, I1, I2, I3, S <: ADTStatus](
    private val data: ADTData[
      AdtNatPositive[ParamType => I3, AdtNatPositive[ParamType => I2, AdtNatPositive[ParamType => I1, AdtNatZero]]],
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct3[I1, I2, I3]

    def apply(param: ParamType): Adt.CoProduct3[I1, I2, I3] =
      new extra3(data).fold(s => adtApply(s(param)), s => adtApply(s(param)), s => adtApply(s(param)))

  }

  implicit class extraFunctionAdt4[ParamType, I1, I2, I3, I4, S <: ADTStatus](
    private val data: ADTData[AdtNatPositive[
      ParamType => I4,
      AdtNatPositive[ParamType => I3, AdtNatPositive[ParamType => I2, AdtNatPositive[ParamType => I1, AdtNatZero]]]
    ], S]
  ) {

    private val adtApply = Adt.CoProduct4[I1, I2, I3, I4]

    def apply(param: ParamType): Adt.CoProduct4[I1, I2, I3, I4] =
      new extra4(data).fold(s => adtApply(s(param)), s => adtApply(s(param)), s => adtApply(s(param)), s => adtApply(s(param)))

  }

  implicit class extraFunctionAdt5[ParamType, I1, I2, I3, I4, I5, S <: ADTStatus](
    private val data: ADTData[
      AdtNatPositive[ParamType => I5, AdtNatPositive[
        ParamType => I4,
        AdtNatPositive[ParamType => I3, AdtNatPositive[ParamType => I2, AdtNatPositive[ParamType => I1, AdtNatZero]]]
      ]],
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct5[I1, I2, I3, I4, I5]

    def apply(param: ParamType): Adt.CoProduct5[I1, I2, I3, I4, I5] =
      new extra5(data).fold(
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param))
      )

  }

  implicit class extraFunctionAdt6[ParamType, I1, I2, I3, I4, I5, I6, S <: ADTStatus](
    private val data: ADTData[
      AdtNatPositive[
        ParamType => I6,
        AdtNatPositive[ParamType => I5, AdtNatPositive[
          ParamType => I4,
          AdtNatPositive[ParamType => I3, AdtNatPositive[ParamType => I2, AdtNatPositive[ParamType => I1, AdtNatZero]]]
        ]]
      ],
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct6[I1, I2, I3, I4, I5, I6]

    def apply(param: ParamType): Adt.CoProduct6[I1, I2, I3, I4, I5, I6] =
      new extra6(data).fold(
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param))
      )

  }

  implicit class extraFunctionAdt7[ParamType, I1, I2, I3, I4, I5, I6, I7, S <: ADTStatus](
    private val data: ADTData[
      AdtNatPositive[
        ParamType => I7,
        AdtNatPositive[
          ParamType => I6,
          AdtNatPositive[ParamType => I5, AdtNatPositive[
            ParamType => I4,
            AdtNatPositive[ParamType => I3, AdtNatPositive[ParamType => I2, AdtNatPositive[ParamType => I1, AdtNatZero]]]
          ]]
        ]
      ],
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct7[I1, I2, I3, I4, I5, I6, I7]

    def apply(param: ParamType): Adt.CoProduct7[I1, I2, I3, I4, I5, I6, I7] =
      new extra7(data).fold(
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param))
      )

  }

  implicit class extraFunctionAdt8[ParamType, I1, I2, I3, I4, I5, I6, I7, I8, S <: ADTStatus](
    private val data: ADTData[
      AdtNatPositive[
        ParamType => I8,
        AdtNatPositive[
          ParamType => I7,
          AdtNatPositive[
            ParamType => I6,
            AdtNatPositive[ParamType => I5, AdtNatPositive[
              ParamType => I4,
              AdtNatPositive[ParamType => I3, AdtNatPositive[ParamType => I2, AdtNatPositive[ParamType => I1, AdtNatZero]]]
            ]]
          ]
        ]
      ],
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct8[I1, I2, I3, I4, I5, I6, I7, I8]

    def apply(param: ParamType): Adt.CoProduct8[I1, I2, I3, I4, I5, I6, I7, I8] =
      new extra8(data).fold(
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param))
      )

  }

  implicit class extraFunctionAdt9[ParamType, I1, I2, I3, I4, I5, I6, I7, I8, I9, S <: ADTStatus](
    private val data: ADTData[
      AdtNatPositive[
        ParamType => I9,
        AdtNatPositive[
          ParamType => I8,
          AdtNatPositive[
            ParamType => I7,
            AdtNatPositive[
              ParamType => I6,
              AdtNatPositive[ParamType => I5, AdtNatPositive[
                ParamType => I4,
                AdtNatPositive[ParamType => I3, AdtNatPositive[ParamType => I2, AdtNatPositive[ParamType => I1, AdtNatZero]]]
              ]]
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
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param))
      )

  }

  implicit class extraFunctionAdt10[ParamType, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, S <: ADTStatus](
    private val data: ADTData[
      AdtNatPositive[
        ParamType => I10,
        AdtNatPositive[
          ParamType => I9,
          AdtNatPositive[
            ParamType => I8,
            AdtNatPositive[
              ParamType => I7,
              AdtNatPositive[
                ParamType => I6,
                AdtNatPositive[ParamType => I5, AdtNatPositive[
                  ParamType => I4,
                  AdtNatPositive[ParamType => I3, AdtNatPositive[ParamType => I2, AdtNatPositive[ParamType => I1, AdtNatZero]]]
                ]]
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
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param))
      )

  }

  implicit class extraFunctionAdt11[ParamType, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, S <: ADTStatus](
    private val data: ADTData[
      AdtNatPositive[
        ParamType => I11,
        AdtNatPositive[
          ParamType => I10,
          AdtNatPositive[
            ParamType => I9,
            AdtNatPositive[
              ParamType => I8,
              AdtNatPositive[
                ParamType => I7,
                AdtNatPositive[
                  ParamType => I6,
                  AdtNatPositive[ParamType => I5, AdtNatPositive[
                    ParamType => I4,
                    AdtNatPositive[ParamType => I3, AdtNatPositive[ParamType => I2, AdtNatPositive[ParamType => I1, AdtNatZero]]]
                  ]]
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
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param))
      )

  }

  implicit class extraFunctionAdt12[ParamType, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, S <: ADTStatus](
    private val data: ADTData[
      AdtNatPositive[
        ParamType => I12,
        AdtNatPositive[
          ParamType => I11,
          AdtNatPositive[
            ParamType => I10,
            AdtNatPositive[
              ParamType => I9,
              AdtNatPositive[
                ParamType => I8,
                AdtNatPositive[
                  ParamType => I7,
                  AdtNatPositive[
                    ParamType => I6,
                    AdtNatPositive[ParamType => I5, AdtNatPositive[
                      ParamType => I4,
                      AdtNatPositive[ParamType => I3, AdtNatPositive[ParamType => I2, AdtNatPositive[ParamType => I1, AdtNatZero]]]
                    ]]
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
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param))
      )

  }

  implicit class extraFunctionAdt13[ParamType, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, S <: ADTStatus](
    private val data: ADTData[
      AdtNatPositive[
        ParamType => I13,
        AdtNatPositive[
          ParamType => I12,
          AdtNatPositive[
            ParamType => I11,
            AdtNatPositive[
              ParamType => I10,
              AdtNatPositive[
                ParamType => I9,
                AdtNatPositive[
                  ParamType => I8,
                  AdtNatPositive[
                    ParamType => I7,
                    AdtNatPositive[
                      ParamType => I6,
                      AdtNatPositive[ParamType => I5, AdtNatPositive[
                        ParamType => I4,
                        AdtNatPositive[ParamType => I3, AdtNatPositive[ParamType => I2, AdtNatPositive[ParamType => I1, AdtNatZero]]]
                      ]]
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
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param))
      )

  }

  implicit class extraFunctionAdt14[ParamType, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, S <: ADTStatus](
    private val data: ADTData[
      AdtNatPositive[
        ParamType => I14,
        AdtNatPositive[
          ParamType => I13,
          AdtNatPositive[
            ParamType => I12,
            AdtNatPositive[
              ParamType => I11,
              AdtNatPositive[
                ParamType => I10,
                AdtNatPositive[
                  ParamType => I9,
                  AdtNatPositive[
                    ParamType => I8,
                    AdtNatPositive[
                      ParamType => I7,
                      AdtNatPositive[
                        ParamType => I6,
                        AdtNatPositive[ParamType => I5, AdtNatPositive[
                          ParamType => I4,
                          AdtNatPositive[ParamType => I3, AdtNatPositive[ParamType => I2, AdtNatPositive[ParamType => I1, AdtNatZero]]]
                        ]]
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
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param))
      )

  }

  implicit class extraFunctionAdt15[ParamType, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, S <: ADTStatus](
    private val data: ADTData[
      AdtNatPositive[
        ParamType => I15,
        AdtNatPositive[
          ParamType => I14,
          AdtNatPositive[
            ParamType => I13,
            AdtNatPositive[
              ParamType => I12,
              AdtNatPositive[
                ParamType => I11,
                AdtNatPositive[
                  ParamType => I10,
                  AdtNatPositive[
                    ParamType => I9,
                    AdtNatPositive[
                      ParamType => I8,
                      AdtNatPositive[
                        ParamType => I7,
                        AdtNatPositive[
                          ParamType => I6,
                          AdtNatPositive[ParamType => I5, AdtNatPositive[
                            ParamType => I4,
                            AdtNatPositive[ParamType => I3, AdtNatPositive[ParamType => I2, AdtNatPositive[ParamType => I1, AdtNatZero]]]
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
      ],
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct15[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15]

    def apply(param: ParamType): Adt.CoProduct15[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] =
      new extra15(data).fold(
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param))
      )

  }

  implicit class extraFunctionAdt16[ParamType, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, S <: ADTStatus](
    private val data: ADTData[
      AdtNatPositive[
        ParamType => I16,
        AdtNatPositive[
          ParamType => I15,
          AdtNatPositive[
            ParamType => I14,
            AdtNatPositive[
              ParamType => I13,
              AdtNatPositive[
                ParamType => I12,
                AdtNatPositive[
                  ParamType => I11,
                  AdtNatPositive[
                    ParamType => I10,
                    AdtNatPositive[
                      ParamType => I9,
                      AdtNatPositive[
                        ParamType => I8,
                        AdtNatPositive[
                          ParamType => I7,
                          AdtNatPositive[
                            ParamType => I6,
                            AdtNatPositive[ParamType => I5, AdtNatPositive[
                              ParamType => I4,
                              AdtNatPositive[ParamType => I3, AdtNatPositive[ParamType => I2, AdtNatPositive[ParamType => I1, AdtNatZero]]]
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

    private val adtApply = Adt.CoProduct16[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16]

    def apply(param: ParamType): Adt.CoProduct16[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] =
      new extra16(data).fold(
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param))
      )

  }

  implicit class extraFunctionAdt17[ParamType, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, S <: ADTStatus](
    private val data: ADTData[
      AdtNatPositive[
        ParamType => I17,
        AdtNatPositive[
          ParamType => I16,
          AdtNatPositive[
            ParamType => I15,
            AdtNatPositive[
              ParamType => I14,
              AdtNatPositive[
                ParamType => I13,
                AdtNatPositive[
                  ParamType => I12,
                  AdtNatPositive[
                    ParamType => I11,
                    AdtNatPositive[
                      ParamType => I10,
                      AdtNatPositive[
                        ParamType => I9,
                        AdtNatPositive[
                          ParamType => I8,
                          AdtNatPositive[
                            ParamType => I7,
                            AdtNatPositive[
                              ParamType => I6,
                              AdtNatPositive[ParamType => I5, AdtNatPositive[ParamType => I4, AdtNatPositive[
                                ParamType => I3,
                                AdtNatPositive[ParamType => I2, AdtNatPositive[ParamType => I1, AdtNatZero]]
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
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct17[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17]

    def apply(param: ParamType): Adt.CoProduct17[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] =
      new extra17(data).fold(
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param))
      )

  }

  implicit class extraFunctionAdt18[
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
    S <: ADTStatus
  ](
    private val data: ADTData[
      AdtNatPositive[
        ParamType => I18,
        AdtNatPositive[
          ParamType => I17,
          AdtNatPositive[
            ParamType => I16,
            AdtNatPositive[
              ParamType => I15,
              AdtNatPositive[
                ParamType => I14,
                AdtNatPositive[
                  ParamType => I13,
                  AdtNatPositive[
                    ParamType => I12,
                    AdtNatPositive[
                      ParamType => I11,
                      AdtNatPositive[
                        ParamType => I10,
                        AdtNatPositive[
                          ParamType => I9,
                          AdtNatPositive[
                            ParamType => I8,
                            AdtNatPositive[
                              ParamType => I7,
                              AdtNatPositive[
                                ParamType => I6,
                                AdtNatPositive[ParamType => I5, AdtNatPositive[ParamType => I4, AdtNatPositive[
                                  ParamType => I3,
                                  AdtNatPositive[ParamType => I2, AdtNatPositive[ParamType => I1, AdtNatZero]]
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
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct18[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18]

    def apply(param: ParamType): Adt.CoProduct18[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] =
      new extra18(data).fold(
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param))
      )

  }

  implicit class extraFunctionAdt19[
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
    S <: ADTStatus
  ](
    private val data: ADTData[
      AdtNatPositive[
        ParamType => I19,
        AdtNatPositive[
          ParamType => I18,
          AdtNatPositive[
            ParamType => I17,
            AdtNatPositive[
              ParamType => I16,
              AdtNatPositive[
                ParamType => I15,
                AdtNatPositive[
                  ParamType => I14,
                  AdtNatPositive[
                    ParamType => I13,
                    AdtNatPositive[
                      ParamType => I12,
                      AdtNatPositive[
                        ParamType => I11,
                        AdtNatPositive[
                          ParamType => I10,
                          AdtNatPositive[
                            ParamType => I9,
                            AdtNatPositive[
                              ParamType => I8,
                              AdtNatPositive[
                                ParamType => I7,
                                AdtNatPositive[
                                  ParamType => I6,
                                  AdtNatPositive[ParamType => I5, AdtNatPositive[ParamType => I4, AdtNatPositive[
                                    ParamType => I3,
                                    AdtNatPositive[ParamType => I2, AdtNatPositive[ParamType => I1, AdtNatZero]]
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
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct19[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19]

    def apply(param: ParamType): Adt.CoProduct19[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] =
      new extra19(data).fold(
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param))
      )

  }

  implicit class extraFunctionAdt20[
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
    S <: ADTStatus
  ](
    private val data: ADTData[
      AdtNatPositive[
        ParamType => I20,
        AdtNatPositive[
          ParamType => I19,
          AdtNatPositive[
            ParamType => I18,
            AdtNatPositive[
              ParamType => I17,
              AdtNatPositive[
                ParamType => I16,
                AdtNatPositive[
                  ParamType => I15,
                  AdtNatPositive[
                    ParamType => I14,
                    AdtNatPositive[
                      ParamType => I13,
                      AdtNatPositive[
                        ParamType => I12,
                        AdtNatPositive[
                          ParamType => I11,
                          AdtNatPositive[
                            ParamType => I10,
                            AdtNatPositive[
                              ParamType => I9,
                              AdtNatPositive[
                                ParamType => I8,
                                AdtNatPositive[
                                  ParamType => I7,
                                  AdtNatPositive[
                                    ParamType => I6,
                                    AdtNatPositive[ParamType => I5, AdtNatPositive[ParamType => I4, AdtNatPositive[
                                      ParamType => I3,
                                      AdtNatPositive[ParamType => I2, AdtNatPositive[ParamType => I1, AdtNatZero]]
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
      S
    ]
  ) {

    private val adtApply = Adt.CoProduct20[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20]

    def apply(
      param: ParamType
    ): Adt.CoProduct20[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] =
      new extra20(data).fold(
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param))
      )

  }

  implicit class extraFunctionAdt21[
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
    S <: ADTStatus
  ](
    private val data: ADTData[
      AdtNatPositive[
        ParamType => I21,
        AdtNatPositive[
          ParamType => I20,
          AdtNatPositive[
            ParamType => I19,
            AdtNatPositive[
              ParamType => I18,
              AdtNatPositive[
                ParamType => I17,
                AdtNatPositive[
                  ParamType => I16,
                  AdtNatPositive[
                    ParamType => I15,
                    AdtNatPositive[
                      ParamType => I14,
                      AdtNatPositive[
                        ParamType => I13,
                        AdtNatPositive[
                          ParamType => I12,
                          AdtNatPositive[
                            ParamType => I11,
                            AdtNatPositive[
                              ParamType => I10,
                              AdtNatPositive[
                                ParamType => I9,
                                AdtNatPositive[
                                  ParamType => I8,
                                  AdtNatPositive[
                                    ParamType => I7,
                                    AdtNatPositive[
                                      ParamType => I6,
                                      AdtNatPositive[ParamType => I5, AdtNatPositive[ParamType => I4, AdtNatPositive[
                                        ParamType => I3,
                                        AdtNatPositive[ParamType => I2, AdtNatPositive[ParamType => I1, AdtNatZero]]
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
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param))
      )

  }

  implicit class extraFunctionAdt22[
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
    S <: ADTStatus
  ](
    private val data: ADTData[
      AdtNatPositive[
        ParamType => I22,
        AdtNatPositive[
          ParamType => I21,
          AdtNatPositive[
            ParamType => I20,
            AdtNatPositive[
              ParamType => I19,
              AdtNatPositive[
                ParamType => I18,
                AdtNatPositive[
                  ParamType => I17,
                  AdtNatPositive[
                    ParamType => I16,
                    AdtNatPositive[
                      ParamType => I15,
                      AdtNatPositive[
                        ParamType => I14,
                        AdtNatPositive[
                          ParamType => I13,
                          AdtNatPositive[
                            ParamType => I12,
                            AdtNatPositive[
                              ParamType => I11,
                              AdtNatPositive[
                                ParamType => I10,
                                AdtNatPositive[
                                  ParamType => I9,
                                  AdtNatPositive[
                                    ParamType => I8,
                                    AdtNatPositive[
                                      ParamType => I7,
                                      AdtNatPositive[
                                        ParamType => I6,
                                        AdtNatPositive[ParamType => I5, AdtNatPositive[ParamType => I4, AdtNatPositive[
                                          ParamType => I3,
                                          AdtNatPositive[ParamType => I2, AdtNatPositive[ParamType => I1, AdtNatZero]]
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
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param)),
        s => adtApply(s(param))
      )

  }

}
