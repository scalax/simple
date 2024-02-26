package net.scalax.simple.adt
package impl

import Adt.{Status => ADTStatus}
import temp._
import net.scalax.simple.adt.nat.{AdtNat, AdtNatPositive, AdtNatZero}

trait ADTPassedFunctionImpl extends ADTPassedFunction {
  implicit class extraFunctionAdt1[ParamType, I1, S <: ADTStatus](
    private val data: ADTData[AdtNatPositive[ParamType => I1, AdtNatZero], S]
  ) {

    private def adtApply[X: Adt.CoProducts1[*, I1]](t: X): Adt.CoProduct1[I1] = {
      Adt.CoProduct1[I1](t)
    }

    def apply(param: ParamType): ADTData[AdtNatPositive[I1, AdtNatZero], S] = new extra1(data).fold(s => adtApply(s.apply(param)))
  }

  implicit class extraFunctionAdt2[ParamType, I1, I2, S <: ADTStatus](
    private val data: ADTData[AdtNatPositive[ParamType => I2, AdtNatPositive[ParamType => I1, AdtNatZero]], S]
  ) {

    private def adtApply[X: Adt.CoProducts2[*, I1, I2]](t: X): Adt.CoProduct2[I1, I2] = {
      Adt.CoProduct2[I1, I2](t)
    }

    def apply(param: ParamType): ADTData[AdtNatPositive[I2, AdtNatPositive[I1, AdtNatZero]], S] =
      new extra2(data).fold(s => adtApply(s.apply(param)), s => adtApply(s.apply(param)))
  }

  implicit class extraFunctionAdt3[ParamType, I1, I2, I3, S <: ADTStatus](
    private val data: ADTData[
      AdtNatPositive[ParamType => I3, AdtNatPositive[ParamType => I2, AdtNatPositive[ParamType => I1, AdtNatZero]]],
      S
    ]
  ) {

    private def adtApply[X: Adt.CoProducts3[*, I1, I2, I3]](t: X): Adt.CoProduct3[I1, I2, I3] = {
      Adt.CoProduct3[I1, I2, I3](t)
    }

    def apply(param: ParamType): ADTData[AdtNatPositive[I3, AdtNatPositive[I2, AdtNatPositive[I1, AdtNatZero]]], S] =
      new extra3(data).fold(s => adtApply(s.apply(param)), s => adtApply(s.apply(param)), s => adtApply(s.apply(param)))
  }

  implicit class extraFunctionAdt4[ParamType, I1, I2, I3, I4, S <: ADTStatus](
    private val data: ADTData[AdtNatPositive[
      ParamType => I4,
      AdtNatPositive[ParamType => I3, AdtNatPositive[ParamType => I2, AdtNatPositive[ParamType => I1, AdtNatZero]]]
    ], S]
  ) {

    private def adtApply[X: Adt.CoProducts4[*, I1, I2, I3, I4]](t: X): Adt.CoProduct4[I1, I2, I3, I4] = {
      Adt.CoProduct4[I1, I2, I3, I4](t)
    }

    def apply(param: ParamType): ADTData[AdtNatPositive[I4, AdtNatPositive[I3, AdtNatPositive[I2, AdtNatPositive[I1, AdtNatZero]]]], S] =
      new extra4(data).fold(
        s => adtApply(s.apply(param)),
        s => adtApply(s.apply(param)),
        s => adtApply(s.apply(param)),
        s => adtApply(s.apply(param))
      )
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

    private def adtApply[X: Adt.CoProducts5[*, I1, I2, I3, I4, I5]](t: X): Adt.CoProduct5[I1, I2, I3, I4, I5] = {
      Adt.CoProduct5[I1, I2, I3, I4, I5](t)
    }

    def apply(
      param: ParamType
    ): ADTData[AdtNatPositive[I5, AdtNatPositive[I4, AdtNatPositive[I3, AdtNatPositive[I2, AdtNatPositive[I1, AdtNatZero]]]]], S] =
      new extra5(data).fold(
        s => adtApply(s.apply(param)),
        s => adtApply(s.apply(param)),
        s => adtApply(s.apply(param)),
        s => adtApply(s.apply(param)),
        s => adtApply(s.apply(param))
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

    private def adtApply[X: Adt.CoProducts6[*, I1, I2, I3, I4, I5, I6]](t: X): Adt.CoProduct6[I1, I2, I3, I4, I5, I6] = {
      Adt.CoProduct6[I1, I2, I3, I4, I5, I6](t)
    }

    def apply(param: ParamType): ADTData[
      AdtNatPositive[I6, AdtNatPositive[I5, AdtNatPositive[I4, AdtNatPositive[I3, AdtNatPositive[I2, AdtNatPositive[I1, AdtNatZero]]]]]],
      S
    ] = new extra6(data).fold(
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param))
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

    private def adtApply[X: Adt.CoProducts7[*, I1, I2, I3, I4, I5, I6, I7]](t: X): Adt.CoProduct7[I1, I2, I3, I4, I5, I6, I7] = {
      Adt.CoProduct7[I1, I2, I3, I4, I5, I6, I7](t)
    }

    def apply(param: ParamType): ADTData[AdtNatPositive[
      I7,
      AdtNatPositive[I6, AdtNatPositive[I5, AdtNatPositive[I4, AdtNatPositive[I3, AdtNatPositive[I2, AdtNatPositive[I1, AdtNatZero]]]]]]
    ], S] = new extra7(data).fold(
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param))
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

    private def adtApply[X: Adt.CoProducts8[*, I1, I2, I3, I4, I5, I6, I7, I8]](t: X): Adt.CoProduct8[I1, I2, I3, I4, I5, I6, I7, I8] = {
      Adt.CoProduct8[I1, I2, I3, I4, I5, I6, I7, I8](t)
    }

    def apply(param: ParamType): ADTData[
      AdtNatPositive[I8, AdtNatPositive[
        I7,
        AdtNatPositive[I6, AdtNatPositive[I5, AdtNatPositive[I4, AdtNatPositive[I3, AdtNatPositive[I2, AdtNatPositive[I1, AdtNatZero]]]]]]
      ]],
      S
    ] = new extra8(data).fold(
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param))
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

    private def adtApply[X: Adt.CoProducts9[*, I1, I2, I3, I4, I5, I6, I7, I8, I9]](
      t: X
    ): Adt.CoProduct9[I1, I2, I3, I4, I5, I6, I7, I8, I9] = {
      Adt.CoProduct9[I1, I2, I3, I4, I5, I6, I7, I8, I9](t)
    }

    def apply(param: ParamType): ADTData[
      AdtNatPositive[
        I9,
        AdtNatPositive[I8, AdtNatPositive[
          I7,
          AdtNatPositive[I6, AdtNatPositive[I5, AdtNatPositive[I4, AdtNatPositive[I3, AdtNatPositive[I2, AdtNatPositive[I1, AdtNatZero]]]]]]
        ]]
      ],
      S
    ] = new extra9(data).fold(
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param))
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

    private def adtApply[X: Adt.CoProducts10[*, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10]](
      t: X
    ): Adt.CoProduct10[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] = {
      Adt.CoProduct10[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10](t)
    }

    def apply(param: ParamType): ADTData[
      AdtNatPositive[
        I10,
        AdtNatPositive[
          I9,
          AdtNatPositive[I8, AdtNatPositive[I7, AdtNatPositive[
            I6,
            AdtNatPositive[I5, AdtNatPositive[I4, AdtNatPositive[I3, AdtNatPositive[I2, AdtNatPositive[I1, AdtNatZero]]]]]
          ]]]
        ]
      ],
      S
    ] = new extra10(data).fold(
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param))
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

    private def adtApply[X: Adt.CoProducts11[*, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11]](
      t: X
    ): Adt.CoProduct11[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] = {
      Adt.CoProduct11[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11](t)
    }

    def apply(param: ParamType): ADTData[
      AdtNatPositive[
        I11,
        AdtNatPositive[
          I10,
          AdtNatPositive[
            I9,
            AdtNatPositive[I8, AdtNatPositive[I7, AdtNatPositive[
              I6,
              AdtNatPositive[I5, AdtNatPositive[I4, AdtNatPositive[I3, AdtNatPositive[I2, AdtNatPositive[I1, AdtNatZero]]]]]
            ]]]
          ]
        ]
      ],
      S
    ] = new extra11(data).fold(
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param))
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

    private def adtApply[X: Adt.CoProducts12[*, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12]](
      t: X
    ): Adt.CoProduct12[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] = {
      Adt.CoProduct12[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12](t)
    }

    def apply(param: ParamType): ADTData[
      AdtNatPositive[
        I12,
        AdtNatPositive[
          I11,
          AdtNatPositive[
            I10,
            AdtNatPositive[
              I9,
              AdtNatPositive[I8, AdtNatPositive[I7, AdtNatPositive[
                I6,
                AdtNatPositive[I5, AdtNatPositive[I4, AdtNatPositive[I3, AdtNatPositive[I2, AdtNatPositive[I1, AdtNatZero]]]]]
              ]]]
            ]
          ]
        ]
      ],
      S
    ] = new extra12(data).fold(
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param))
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

    private def adtApply[X: Adt.CoProducts13[*, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13]](
      t: X
    ): Adt.CoProduct13[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] = {
      Adt.CoProduct13[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13](t)
    }

    def apply(param: ParamType): ADTData[
      AdtNatPositive[
        I13,
        AdtNatPositive[
          I12,
          AdtNatPositive[
            I11,
            AdtNatPositive[
              I10,
              AdtNatPositive[
                I9,
                AdtNatPositive[I8, AdtNatPositive[I7, AdtNatPositive[
                  I6,
                  AdtNatPositive[I5, AdtNatPositive[I4, AdtNatPositive[I3, AdtNatPositive[I2, AdtNatPositive[I1, AdtNatZero]]]]]
                ]]]
              ]
            ]
          ]
        ]
      ],
      S
    ] = new extra13(data).fold(
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param))
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

    private def adtApply[X: Adt.CoProducts14[*, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14]](
      t: X
    ): Adt.CoProduct14[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] = {
      Adt.CoProduct14[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14](t)
    }

    def apply(param: ParamType): ADTData[
      AdtNatPositive[
        I14,
        AdtNatPositive[
          I13,
          AdtNatPositive[
            I12,
            AdtNatPositive[
              I11,
              AdtNatPositive[
                I10,
                AdtNatPositive[
                  I9,
                  AdtNatPositive[I8, AdtNatPositive[I7, AdtNatPositive[
                    I6,
                    AdtNatPositive[I5, AdtNatPositive[I4, AdtNatPositive[I3, AdtNatPositive[I2, AdtNatPositive[I1, AdtNatZero]]]]]
                  ]]]
                ]
              ]
            ]
          ]
        ]
      ],
      S
    ] = new extra14(data).fold(
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param))
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

    private def adtApply[X: Adt.CoProducts15[*, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15]](
      t: X
    ): Adt.CoProduct15[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] = {
      Adt.CoProduct15[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15](t)
    }

    def apply(param: ParamType): ADTData[
      AdtNatPositive[
        I15,
        AdtNatPositive[
          I14,
          AdtNatPositive[
            I13,
            AdtNatPositive[
              I12,
              AdtNatPositive[
                I11,
                AdtNatPositive[
                  I10,
                  AdtNatPositive[
                    I9,
                    AdtNatPositive[I8, AdtNatPositive[I7, AdtNatPositive[
                      I6,
                      AdtNatPositive[I5, AdtNatPositive[I4, AdtNatPositive[I3, AdtNatPositive[I2, AdtNatPositive[I1, AdtNatZero]]]]]
                    ]]]
                  ]
                ]
              ]
            ]
          ]
        ]
      ],
      S
    ] = new extra15(data).fold(
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param))
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

    private def adtApply[X: Adt.CoProducts16[*, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16]](
      t: X
    ): Adt.CoProduct16[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] = {
      Adt.CoProduct16[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16](t)
    }

    def apply(param: ParamType): ADTData[
      AdtNatPositive[
        I16,
        AdtNatPositive[
          I15,
          AdtNatPositive[
            I14,
            AdtNatPositive[
              I13,
              AdtNatPositive[
                I12,
                AdtNatPositive[
                  I11,
                  AdtNatPositive[
                    I10,
                    AdtNatPositive[
                      I9,
                      AdtNatPositive[I8, AdtNatPositive[I7, AdtNatPositive[
                        I6,
                        AdtNatPositive[I5, AdtNatPositive[I4, AdtNatPositive[I3, AdtNatPositive[I2, AdtNatPositive[I1, AdtNatZero]]]]]
                      ]]]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ],
      S
    ] = new extra16(data).fold(
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param))
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

    private def adtApply[X: Adt.CoProducts17[*, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17]](
      t: X
    ): Adt.CoProduct17[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] = {
      Adt.CoProduct17[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17](t)
    }

    def apply(param: ParamType): ADTData[
      AdtNatPositive[
        I17,
        AdtNatPositive[
          I16,
          AdtNatPositive[
            I15,
            AdtNatPositive[
              I14,
              AdtNatPositive[
                I13,
                AdtNatPositive[
                  I12,
                  AdtNatPositive[
                    I11,
                    AdtNatPositive[
                      I10,
                      AdtNatPositive[
                        I9,
                        AdtNatPositive[I8, AdtNatPositive[I7, AdtNatPositive[
                          I6,
                          AdtNatPositive[I5, AdtNatPositive[I4, AdtNatPositive[I3, AdtNatPositive[I2, AdtNatPositive[I1, AdtNatZero]]]]]
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
      S
    ] = new extra17(data).fold(
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param))
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

    private def adtApply[X: Adt.CoProducts18[*, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18]](
      t: X
    ): Adt.CoProduct18[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] = {
      Adt.CoProduct18[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18](t)
    }

    def apply(param: ParamType): ADTData[
      AdtNatPositive[
        I18,
        AdtNatPositive[
          I17,
          AdtNatPositive[
            I16,
            AdtNatPositive[
              I15,
              AdtNatPositive[
                I14,
                AdtNatPositive[
                  I13,
                  AdtNatPositive[
                    I12,
                    AdtNatPositive[
                      I11,
                      AdtNatPositive[
                        I10,
                        AdtNatPositive[
                          I9,
                          AdtNatPositive[I8, AdtNatPositive[I7, AdtNatPositive[
                            I6,
                            AdtNatPositive[I5, AdtNatPositive[I4, AdtNatPositive[I3, AdtNatPositive[I2, AdtNatPositive[I1, AdtNatZero]]]]]
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
      S
    ] = new extra18(data).fold(
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param))
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

    private def adtApply[X: Adt.CoProducts19[*, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19]](
      t: X
    ): Adt.CoProduct19[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] = {
      Adt.CoProduct19[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19](t)
    }

    def apply(param: ParamType): ADTData[
      AdtNatPositive[
        I19,
        AdtNatPositive[
          I18,
          AdtNatPositive[
            I17,
            AdtNatPositive[
              I16,
              AdtNatPositive[
                I15,
                AdtNatPositive[
                  I14,
                  AdtNatPositive[
                    I13,
                    AdtNatPositive[
                      I12,
                      AdtNatPositive[
                        I11,
                        AdtNatPositive[
                          I10,
                          AdtNatPositive[
                            I9,
                            AdtNatPositive[I8, AdtNatPositive[I7, AdtNatPositive[
                              I6,
                              AdtNatPositive[I5, AdtNatPositive[I4, AdtNatPositive[I3, AdtNatPositive[I2, AdtNatPositive[I1, AdtNatZero]]]]]
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
      S
    ] = new extra19(data).fold(
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param))
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

    private def adtApply[X: Adt.CoProducts20[*, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20]](
      t: X
    ): Adt.CoProduct20[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] = {
      Adt.CoProduct20[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20](t)
    }

    def apply(param: ParamType): ADTData[
      AdtNatPositive[
        I20,
        AdtNatPositive[
          I19,
          AdtNatPositive[
            I18,
            AdtNatPositive[
              I17,
              AdtNatPositive[
                I16,
                AdtNatPositive[
                  I15,
                  AdtNatPositive[
                    I14,
                    AdtNatPositive[
                      I13,
                      AdtNatPositive[
                        I12,
                        AdtNatPositive[
                          I11,
                          AdtNatPositive[
                            I10,
                            AdtNatPositive[
                              I9,
                              AdtNatPositive[I8, AdtNatPositive[I7, AdtNatPositive[I6, AdtNatPositive[
                                I5,
                                AdtNatPositive[I4, AdtNatPositive[I3, AdtNatPositive[I2, AdtNatPositive[I1, AdtNatZero]]]]
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
      S
    ] = new extra20(data).fold(
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param))
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

    private def adtApply[
      X: Adt.CoProducts21[*, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21]
    ](t: X): Adt.CoProduct21[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] = {
      Adt.CoProduct21[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21](t)
    }

    def apply(param: ParamType): ADTData[
      AdtNatPositive[
        I21,
        AdtNatPositive[
          I20,
          AdtNatPositive[
            I19,
            AdtNatPositive[
              I18,
              AdtNatPositive[
                I17,
                AdtNatPositive[
                  I16,
                  AdtNatPositive[
                    I15,
                    AdtNatPositive[
                      I14,
                      AdtNatPositive[
                        I13,
                        AdtNatPositive[
                          I12,
                          AdtNatPositive[
                            I11,
                            AdtNatPositive[
                              I10,
                              AdtNatPositive[
                                I9,
                                AdtNatPositive[I8, AdtNatPositive[I7, AdtNatPositive[I6, AdtNatPositive[
                                  I5,
                                  AdtNatPositive[I4, AdtNatPositive[I3, AdtNatPositive[I2, AdtNatPositive[I1, AdtNatZero]]]]
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
      S
    ] = new extra21(data).fold(
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param))
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

    private def adtApply[
      X: Adt.CoProducts22[*, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22]
    ](t: X): Adt.CoProduct22[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22] = {
      Adt.CoProduct22[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22](t)
    }

    def apply(param: ParamType): ADTData[
      AdtNatPositive[
        I22,
        AdtNatPositive[
          I21,
          AdtNatPositive[
            I20,
            AdtNatPositive[
              I19,
              AdtNatPositive[
                I18,
                AdtNatPositive[
                  I17,
                  AdtNatPositive[
                    I16,
                    AdtNatPositive[
                      I15,
                      AdtNatPositive[
                        I14,
                        AdtNatPositive[
                          I13,
                          AdtNatPositive[
                            I12,
                            AdtNatPositive[
                              I11,
                              AdtNatPositive[
                                I10,
                                AdtNatPositive[
                                  I9,
                                  AdtNatPositive[I8, AdtNatPositive[I7, AdtNatPositive[I6, AdtNatPositive[
                                    I5,
                                    AdtNatPositive[I4, AdtNatPositive[I3, AdtNatPositive[I2, AdtNatPositive[I1, AdtNatZero]]]]
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
        ]
      ],
      S
    ] = new extra22(data).fold(
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param)),
      s => adtApply(s.apply(param))
    )
  }

}
