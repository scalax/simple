package net.scalax.simple.adt
package impl

import implemention._

trait TypeAdtRuntimeApply {

  def Options1[I1]: FetchAdtApply[
    NatFuncPositive[I1, NatFuncZero]
  ] = FetchAdtApply.get

  def Options2[I1, I2]: FetchAdtApply[
    NatFuncPositive[I1, NatFuncPositive[I2, NatFuncZero]]
  ] = FetchAdtApply.get

  def Options3[I1, I2, I3]: FetchAdtApply[
    NatFuncPositive[I1, NatFuncPositive[I2, NatFuncPositive[I3, NatFuncZero]]]
  ] = FetchAdtApply.get

  def Options4[I1, I2, I3, I4]: FetchAdtApply[
    NatFuncPositive[I1, NatFuncPositive[I2, NatFuncPositive[I3, NatFuncPositive[I4, NatFuncZero]]]]
  ] = FetchAdtApply.get

  def Options5[I1, I2, I3, I4, I5]: FetchAdtApply[
    NatFuncPositive[I1, NatFuncPositive[I2, NatFuncPositive[I3, NatFuncPositive[I4, NatFuncPositive[I5, NatFuncZero]]]]]
  ] = FetchAdtApply.get

  def Options6[I1, I2, I3, I4, I5, I6]: FetchAdtApply[
    NatFuncPositive[I1, NatFuncPositive[
      I2,
      NatFuncPositive[I3, NatFuncPositive[I4, NatFuncPositive[I5, NatFuncPositive[I6, NatFuncZero]]]]
    ]]
  ] = FetchAdtApply.get

  def Options7[I1, I2, I3, I4, I5, I6, I7]: FetchAdtApply[
    NatFuncPositive[I1, NatFuncPositive[
      I2,
      NatFuncPositive[I3, NatFuncPositive[I4, NatFuncPositive[I5, NatFuncPositive[I6, NatFuncPositive[I7, NatFuncZero]]]]]
    ]]
  ] = FetchAdtApply.get

  def Options8[I1, I2, I3, I4, I5, I6, I7, I8]: FetchAdtApply[
    NatFuncPositive[
      I1,
      NatFuncPositive[I2, NatFuncPositive[
        I3,
        NatFuncPositive[I4, NatFuncPositive[I5, NatFuncPositive[I6, NatFuncPositive[I7, NatFuncPositive[I8, NatFuncZero]]]]]
      ]]
    ]
  ] = FetchAdtApply.get

  def Options9[I1, I2, I3, I4, I5, I6, I7, I8, I9]: FetchAdtApply[
    NatFuncPositive[
      I1,
      NatFuncPositive[
        I2,
        NatFuncPositive[I3, NatFuncPositive[
          I4,
          NatFuncPositive[I5, NatFuncPositive[I6, NatFuncPositive[I7, NatFuncPositive[I8, NatFuncPositive[I9, NatFuncZero]]]]]
        ]]
      ]
    ]
  ] = FetchAdtApply.get

  def Options10[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10]: FetchAdtApply[
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
    ]
  ] = FetchAdtApply.get

  def Options11[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11]: FetchAdtApply[
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
    ]
  ] = FetchAdtApply.get

  def Options12[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12]: FetchAdtApply[
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
    ]
  ] = FetchAdtApply.get

  def Options13[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13]: FetchAdtApply[
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
                NatFuncPositive[I7, NatFuncPositive[
                  I8,
                  NatFuncPositive[I9, NatFuncPositive[I10, NatFuncPositive[I11, NatFuncPositive[I12, NatFuncPositive[I13, NatFuncZero]]]]]
                ]]
              ]
            ]
          ]
        ]
      ]
    ]
  ] = FetchAdtApply.get

  def Options14[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14]: FetchAdtApply[
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
    ]
  ] = FetchAdtApply.get

  def Options15[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15]: FetchAdtApply[
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
    ]
  ] = FetchAdtApply.get

  def Options16[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16]: FetchAdtApply[
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
    ]
  ] = FetchAdtApply.get

  def Options17[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17]: FetchAdtApply[
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
    ]
  ] = FetchAdtApply.get

  def Options18[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18]: FetchAdtApply[
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
    ]
  ] = FetchAdtApply.get

  def Options19[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19]: FetchAdtApply[
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
    ]
  ] = FetchAdtApply.get

  def Options20[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20]: FetchAdtApply[
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
    ]
  ] = FetchAdtApply.get

  def Options21[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21]: FetchAdtApply[
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
    ]
  ] = FetchAdtApply.get

  def Options22[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22]: FetchAdtApply[
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
    ]
  ] = FetchAdtApply.get

}

object TypeAdtRuntimeApply extends TypeAdtRuntimeApply
