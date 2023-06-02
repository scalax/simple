package net.scalax.simple
package adt
package impl

import implemention._

trait TypeAdtAliasModelUnapply {

  object Option1 {
    def unapply[I1, Tail <: NatFunc](i: NatFuncPositive[I1, Tail]): Option[I1] = i.dataInstance
  }

  object Option2 {
    def unapply[I1, I2, Tail <: NatFunc](i: NatFuncPositive[I1, NatFuncPositive[I2, Tail]]): Option[I2] = i.tail.dataInstance
  }

  object Option3 {
    def unapply[I1, I2, I3, Tail <: NatFunc](i: NatFuncPositive[I1, NatFuncPositive[I2, NatFuncPositive[I3, Tail]]]): Option[I3] =
      i.tail.tail.dataInstance
  }

  object Option4 {
    def unapply[I1, I2, I3, I4, Tail <: NatFunc](
      i: NatFuncPositive[I1, NatFuncPositive[I2, NatFuncPositive[I3, NatFuncPositive[I4, Tail]]]]
    ): Option[I4] = i.tail.tail.tail.dataInstance
  }

  object Option5 {
    def unapply[I1, I2, I3, I4, I5, Tail <: NatFunc](
      i: NatFuncPositive[I1, NatFuncPositive[I2, NatFuncPositive[I3, NatFuncPositive[I4, NatFuncPositive[I5, Tail]]]]]
    ): Option[I5] = i.tail.tail.tail.tail.dataInstance
  }

  object Option6 {
    def unapply[I1, I2, I3, I4, I5, I6, Tail <: NatFunc](
      i: NatFuncPositive[I1, NatFuncPositive[I2, NatFuncPositive[I3, NatFuncPositive[I4, NatFuncPositive[I5, NatFuncPositive[I6, Tail]]]]]]
    ): Option[I6] = i.tail.tail.tail.tail.tail.dataInstance
  }

  object Option7 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, Tail <: NatFunc](
      i: NatFuncPositive[
        I1,
        NatFuncPositive[I2, NatFuncPositive[I3, NatFuncPositive[I4, NatFuncPositive[I5, NatFuncPositive[I6, NatFuncPositive[I7, Tail]]]]]]
      ]
    ): Option[I7] = i.tail.tail.tail.tail.tail.tail.dataInstance
  }

  object Option8 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, I8, Tail <: NatFunc](
      i: NatFuncPositive[I1, NatFuncPositive[
        I2,
        NatFuncPositive[I3, NatFuncPositive[I4, NatFuncPositive[I5, NatFuncPositive[I6, NatFuncPositive[I7, NatFuncPositive[I8, Tail]]]]]]
      ]]
    ): Option[I8] = i.tail.tail.tail.tail.tail.tail.tail.dataInstance
  }

  object Option9 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, I8, I9, Tail <: NatFunc](
      i: NatFuncPositive[
        I1,
        NatFuncPositive[I2, NatFuncPositive[
          I3,
          NatFuncPositive[I4, NatFuncPositive[I5, NatFuncPositive[I6, NatFuncPositive[I7, NatFuncPositive[I8, NatFuncPositive[I9, Tail]]]]]]
        ]]
      ]
    ): Option[I9] = i.tail.tail.tail.tail.tail.tail.tail.tail.dataInstance
  }

  object Option10 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, Tail <: NatFunc](
      i: NatFuncPositive[
        I1,
        NatFuncPositive[
          I2,
          NatFuncPositive[I3, NatFuncPositive[I4, NatFuncPositive[
            I5,
            NatFuncPositive[I6, NatFuncPositive[I7, NatFuncPositive[I8, NatFuncPositive[I9, NatFuncPositive[I10, Tail]]]]]
          ]]]
        ]
      ]
    ): Option[I10] = i.tail.tail.tail.tail.tail.tail.tail.tail.tail.dataInstance
  }

  object Option11 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, Tail <: NatFunc](
      i: NatFuncPositive[
        I1,
        NatFuncPositive[
          I2,
          NatFuncPositive[
            I3,
            NatFuncPositive[I4, NatFuncPositive[I5, NatFuncPositive[
              I6,
              NatFuncPositive[I7, NatFuncPositive[I8, NatFuncPositive[I9, NatFuncPositive[I10, NatFuncPositive[I11, Tail]]]]]
            ]]]
          ]
        ]
      ]
    ): Option[I11] = i.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.dataInstance
  }

  object Option12 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, Tail <: NatFunc](
      i: NatFuncPositive[
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
                  NatFuncPositive[I8, NatFuncPositive[I9, NatFuncPositive[I10, NatFuncPositive[I11, NatFuncPositive[I12, Tail]]]]]
                ]]
              ]
            ]
          ]
        ]
      ]
    ): Option[I12] = i.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.dataInstance
  }

  object Option13 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, Tail <: NatFunc](
      i: NatFuncPositive[
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
                    NatFuncPositive[I9, NatFuncPositive[I10, NatFuncPositive[I11, NatFuncPositive[I12, NatFuncPositive[I13, Tail]]]]]
                  ]]
                ]
              ]
            ]
          ]
        ]
      ]
    ): Option[I13] = i.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.dataInstance
  }

  object Option14 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, Tail <: NatFunc](
      i: NatFuncPositive[
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
                    NatFuncPositive[I8, NatFuncPositive[
                      I9,
                      NatFuncPositive[I10, NatFuncPositive[I11, NatFuncPositive[I12, NatFuncPositive[I13, NatFuncPositive[I14, Tail]]]]]
                    ]]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    ): Option[I14] = i.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.dataInstance
  }

  object Option15 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, Tail <: NatFunc](
      i: NatFuncPositive[
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
                      NatFuncPositive[I9, NatFuncPositive[
                        I10,
                        NatFuncPositive[I11, NatFuncPositive[I12, NatFuncPositive[I13, NatFuncPositive[I14, NatFuncPositive[I15, Tail]]]]]
                      ]]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    ): Option[I15] = i.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.dataInstance
  }

  object Option16 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, Tail <: NatFunc](
      i: NatFuncPositive[
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
                        NatFuncPositive[I10, NatFuncPositive[
                          I11,
                          NatFuncPositive[I12, NatFuncPositive[I13, NatFuncPositive[I14, NatFuncPositive[I15, NatFuncPositive[I16, Tail]]]]]
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
    ): Option[I16] = i.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.dataInstance
  }

  object Option17 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, Tail <: NatFunc](
      i: NatFuncPositive[
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
                            NatFuncPositive[I14, NatFuncPositive[I15, NatFuncPositive[I16, NatFuncPositive[I17, Tail]]]]
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
    ): Option[I17] = i.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.dataInstance
  }

  object Option18 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, Tail <: NatFunc](
      i: NatFuncPositive[
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
                              NatFuncPositive[I15, NatFuncPositive[I16, NatFuncPositive[I17, NatFuncPositive[I18, Tail]]]]
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
    ): Option[I18] = i.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.dataInstance
  }

  object Option19 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, Tail <: NatFunc](
      i: NatFuncPositive[
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
                                NatFuncPositive[I16, NatFuncPositive[I17, NatFuncPositive[I18, NatFuncPositive[I19, Tail]]]]
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
    ): Option[I19] = i.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.dataInstance
  }

  object Option20 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, Tail <: NatFunc](
      i: NatFuncPositive[
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
                                  NatFuncPositive[I17, NatFuncPositive[I18, NatFuncPositive[I19, NatFuncPositive[I20, Tail]]]]
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
    ): Option[I20] = i.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.dataInstance
  }

  object Option21 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, Tail <: NatFunc](
      i: NatFuncPositive[
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
                                    NatFuncPositive[I18, NatFuncPositive[I19, NatFuncPositive[I20, NatFuncPositive[I21, Tail]]]]
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
    ): Option[I21] = i.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.dataInstance
  }

  object Option22 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22, Tail <: NatFunc](
      i: NatFuncPositive[
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
                                      NatFuncPositive[I19, NatFuncPositive[I20, NatFuncPositive[I21, NatFuncPositive[I22, Tail]]]]
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
    ): Option[I22] = i.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.dataInstance
  }

  object Option23 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22, I23, Tail <: NatFunc](
      i: NatFuncPositive[
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
                                    NatFuncPositive[
                                      I16,
                                      NatFuncPositive[I17, NatFuncPositive[I18, NatFuncPositive[
                                        I19,
                                        NatFuncPositive[I20, NatFuncPositive[I21, NatFuncPositive[I22, NatFuncPositive[I23, Tail]]]]
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
    ): Option[I23] =
      i.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.dataInstance
  }

  object Option24 {
    def unapply[
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
      I23,
      I24,
      Tail <: NatFunc
    ](
      i: NatFuncPositive[
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
                                    NatFuncPositive[
                                      I16,
                                      NatFuncPositive[
                                        I17,
                                        NatFuncPositive[I18, NatFuncPositive[I19, NatFuncPositive[
                                          I20,
                                          NatFuncPositive[I21, NatFuncPositive[I22, NatFuncPositive[I23, NatFuncPositive[I24, Tail]]]]
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
      ]
    ): Option[I24] =
      i.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.dataInstance
  }

  object Option25 {
    def unapply[
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
      I23,
      I24,
      I25,
      Tail <: NatFunc
    ](
      i: NatFuncPositive[
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
                                    NatFuncPositive[
                                      I16,
                                      NatFuncPositive[
                                        I17,
                                        NatFuncPositive[
                                          I18,
                                          NatFuncPositive[I19, NatFuncPositive[I20, NatFuncPositive[
                                            I21,
                                            NatFuncPositive[I22, NatFuncPositive[I23, NatFuncPositive[I24, NatFuncPositive[I25, Tail]]]]
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
        ]
      ]
    ): Option[I25] =
      i.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.dataInstance
  }

  object Option26 {
    def unapply[
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
      I23,
      I24,
      I25,
      I26,
      Tail <: NatFunc
    ](
      i: NatFuncPositive[
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
                                    NatFuncPositive[
                                      I16,
                                      NatFuncPositive[
                                        I17,
                                        NatFuncPositive[
                                          I18,
                                          NatFuncPositive[
                                            I19,
                                            NatFuncPositive[I20, NatFuncPositive[I21, NatFuncPositive[
                                              I22,
                                              NatFuncPositive[I23, NatFuncPositive[I24, NatFuncPositive[I25, NatFuncPositive[I26, Tail]]]]
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
          ]
        ]
      ]
    ): Option[I26] =
      i.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.dataInstance
  }

  object Option27 {
    def unapply[
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
      I23,
      I24,
      I25,
      I26,
      I27,
      Tail <: NatFunc
    ](
      i: NatFuncPositive[
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
                                    NatFuncPositive[
                                      I16,
                                      NatFuncPositive[
                                        I17,
                                        NatFuncPositive[
                                          I18,
                                          NatFuncPositive[
                                            I19,
                                            NatFuncPositive[
                                              I20,
                                              NatFuncPositive[I21, NatFuncPositive[I22, NatFuncPositive[
                                                I23,
                                                NatFuncPositive[I24, NatFuncPositive[I25, NatFuncPositive[I26, NatFuncPositive[I27, Tail]]]]
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
            ]
          ]
        ]
      ]
    ): Option[I27] =
      i.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.dataInstance
  }

  object Option28 {
    def unapply[
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
      I23,
      I24,
      I25,
      I26,
      I27,
      I28,
      Tail <: NatFunc
    ](
      i: NatFuncPositive[
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
                                    NatFuncPositive[
                                      I16,
                                      NatFuncPositive[
                                        I17,
                                        NatFuncPositive[
                                          I18,
                                          NatFuncPositive[
                                            I19,
                                            NatFuncPositive[
                                              I20,
                                              NatFuncPositive[
                                                I21,
                                                NatFuncPositive[I22, NatFuncPositive[I23, NatFuncPositive[I24, NatFuncPositive[
                                                  I25,
                                                  NatFuncPositive[I26, NatFuncPositive[I27, NatFuncPositive[I28, Tail]]]
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
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    ): Option[I28] =
      i.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.dataInstance
  }

  object Option29 {
    def unapply[
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
      I23,
      I24,
      I25,
      I26,
      I27,
      I28,
      I29,
      Tail <: NatFunc
    ](
      i: NatFuncPositive[
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
                                    NatFuncPositive[
                                      I16,
                                      NatFuncPositive[
                                        I17,
                                        NatFuncPositive[
                                          I18,
                                          NatFuncPositive[
                                            I19,
                                            NatFuncPositive[
                                              I20,
                                              NatFuncPositive[
                                                I21,
                                                NatFuncPositive[
                                                  I22,
                                                  NatFuncPositive[I23, NatFuncPositive[I24, NatFuncPositive[I25, NatFuncPositive[
                                                    I26,
                                                    NatFuncPositive[I27, NatFuncPositive[I28, NatFuncPositive[I29, Tail]]]
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
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    ): Option[I29] =
      i.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.dataInstance
  }

  object Option30 {
    def unapply[
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
      I23,
      I24,
      I25,
      I26,
      I27,
      I28,
      I29,
      I30,
      Tail <: NatFunc
    ](
      i: NatFuncPositive[
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
                                    NatFuncPositive[
                                      I16,
                                      NatFuncPositive[
                                        I17,
                                        NatFuncPositive[
                                          I18,
                                          NatFuncPositive[
                                            I19,
                                            NatFuncPositive[
                                              I20,
                                              NatFuncPositive[
                                                I21,
                                                NatFuncPositive[
                                                  I22,
                                                  NatFuncPositive[
                                                    I23,
                                                    NatFuncPositive[I24, NatFuncPositive[I25, NatFuncPositive[I26, NatFuncPositive[
                                                      I27,
                                                      NatFuncPositive[I28, NatFuncPositive[I29, NatFuncPositive[I30, Tail]]]
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
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    ): Option[I30] =
      i.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.tail.dataInstance
  }

}
