package net.scalax.simple.adt
package utils

trait Folder22TypeParam {
  trait Parameter0 {
    type Result[RE1] = RE1
  }

  trait Parameter1[I1] {
    type Result[RE1] = ResultFolder[I1, ({ type Result[RE2] = RE2 })#Result, RE1]
  }

  trait Parameter2[I1, I2] {
    type Result[RE1] = ResultFolder[I1, ({ type Result[RE2] = ResultFolder[I2, ({ type Result[RE3] = RE3 })#Result, RE2] })#Result, RE1]
  }

  trait Parameter3[I1, I2, I3] {
    type Result[RE1] = ResultFolder[
      I1,
      ({
        type Result[RE2] = ResultFolder[I2, ({ type Result[RE3] = ResultFolder[I3, ({ type Result[RE4] = RE4 })#Result, RE3] })#Result, RE2]
      })#Result,
      RE1
    ]
  }

  trait Parameter4[I1, I2, I3, I4] {
    type Result[RE1] = ResultFolder[
      I1,
      ({
        type Result[RE2] = ResultFolder[
          I2,
          ({
            type Result[RE3] =
              ResultFolder[I3, ({ type Result[RE4] = ResultFolder[I4, ({ type Result[RE5] = RE5 })#Result, RE4] })#Result, RE3]
          })#Result,
          RE2
        ]
      })#Result,
      RE1
    ]
  }

  trait Parameter5[I1, I2, I3, I4, I5] {
    type Result[RE1] = ResultFolder[
      I1,
      ({
        type Result[RE2] = ResultFolder[
          I2,
          ({
            type Result[RE3] = ResultFolder[
              I3,
              ({
                type Result[RE4] =
                  ResultFolder[I4, ({ type Result[RE5] = ResultFolder[I5, ({ type Result[RE6] = RE6 })#Result, RE5] })#Result, RE4]
              })#Result,
              RE3
            ]
          })#Result,
          RE2
        ]
      })#Result,
      RE1
    ]
  }

  trait Parameter6[I1, I2, I3, I4, I5, I6] {
    type Result[RE1] = ResultFolder[
      I1,
      ({
        type Result[RE2] = ResultFolder[
          I2,
          ({
            type Result[RE3] = ResultFolder[
              I3,
              ({
                type Result[RE4] = ResultFolder[
                  I4,
                  ({
                    type Result[RE5] =
                      ResultFolder[I5, ({ type Result[RE6] = ResultFolder[I6, ({ type Result[RE7] = RE7 })#Result, RE6] })#Result, RE5]
                  })#Result,
                  RE4
                ]
              })#Result,
              RE3
            ]
          })#Result,
          RE2
        ]
      })#Result,
      RE1
    ]
  }

  trait Parameter7[I1, I2, I3, I4, I5, I6, I7] {
    type Result[RE1] = ResultFolder[
      I1,
      ({
        type Result[RE2] = ResultFolder[
          I2,
          ({
            type Result[RE3] = ResultFolder[
              I3,
              ({
                type Result[RE4] = ResultFolder[
                  I4,
                  ({
                    type Result[RE5] = ResultFolder[
                      I5,
                      ({
                        type Result[RE6] =
                          ResultFolder[I6, ({ type Result[RE7] = ResultFolder[I7, ({ type Result[RE8] = RE8 })#Result, RE7] })#Result, RE6]
                      })#Result,
                      RE5
                    ]
                  })#Result,
                  RE4
                ]
              })#Result,
              RE3
            ]
          })#Result,
          RE2
        ]
      })#Result,
      RE1
    ]
  }

  trait Parameter8[I1, I2, I3, I4, I5, I6, I7, I8] {
    type Result[RE1] = ResultFolder[
      I1,
      ({
        type Result[RE2] = ResultFolder[
          I2,
          ({
            type Result[RE3] = ResultFolder[
              I3,
              ({
                type Result[RE4] = ResultFolder[
                  I4,
                  ({
                    type Result[RE5] = ResultFolder[
                      I5,
                      ({
                        type Result[RE6] = ResultFolder[
                          I6,
                          ({
                            type Result[RE7] = ResultFolder[
                              I7,
                              ({ type Result[RE8] = ResultFolder[I8, ({ type Result[RE9] = RE9 })#Result, RE8] })#Result,
                              RE7
                            ]
                          })#Result,
                          RE6
                        ]
                      })#Result,
                      RE5
                    ]
                  })#Result,
                  RE4
                ]
              })#Result,
              RE3
            ]
          })#Result,
          RE2
        ]
      })#Result,
      RE1
    ]
  }

  trait Parameter9[I1, I2, I3, I4, I5, I6, I7, I8, I9] {
    type Result[RE1] = ResultFolder[
      I1,
      ({
        type Result[RE2] = ResultFolder[
          I2,
          ({
            type Result[RE3] = ResultFolder[
              I3,
              ({
                type Result[RE4] = ResultFolder[
                  I4,
                  ({
                    type Result[RE5] = ResultFolder[
                      I5,
                      ({
                        type Result[RE6] = ResultFolder[
                          I6,
                          ({
                            type Result[RE7] = ResultFolder[
                              I7,
                              ({
                                type Result[RE8] = ResultFolder[
                                  I8,
                                  ({ type Result[RE9] = ResultFolder[I9, ({ type Result[RE10] = RE10 })#Result, RE9] })#Result,
                                  RE8
                                ]
                              })#Result,
                              RE7
                            ]
                          })#Result,
                          RE6
                        ]
                      })#Result,
                      RE5
                    ]
                  })#Result,
                  RE4
                ]
              })#Result,
              RE3
            ]
          })#Result,
          RE2
        ]
      })#Result,
      RE1
    ]
  }

  trait Parameter10[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] {
    type Result[RE1] = ResultFolder[
      I1,
      ({
        type Result[RE2] = ResultFolder[
          I2,
          ({
            type Result[RE3] = ResultFolder[
              I3,
              ({
                type Result[RE4] = ResultFolder[
                  I4,
                  ({
                    type Result[RE5] = ResultFolder[
                      I5,
                      ({
                        type Result[RE6] = ResultFolder[
                          I6,
                          ({
                            type Result[RE7] = ResultFolder[
                              I7,
                              ({
                                type Result[RE8] = ResultFolder[
                                  I8,
                                  ({
                                    type Result[RE9] = ResultFolder[
                                      I9,
                                      ({ type Result[RE10] = ResultFolder[I10, ({ type Result[RE11] = RE11 })#Result, RE10] })#Result,
                                      RE9
                                    ]
                                  })#Result,
                                  RE8
                                ]
                              })#Result,
                              RE7
                            ]
                          })#Result,
                          RE6
                        ]
                      })#Result,
                      RE5
                    ]
                  })#Result,
                  RE4
                ]
              })#Result,
              RE3
            ]
          })#Result,
          RE2
        ]
      })#Result,
      RE1
    ]
  }

  trait Parameter11[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] {
    type Result[RE1] = ResultFolder[
      I1,
      ({
        type Result[RE2] = ResultFolder[
          I2,
          ({
            type Result[RE3] = ResultFolder[
              I3,
              ({
                type Result[RE4] = ResultFolder[
                  I4,
                  ({
                    type Result[RE5] = ResultFolder[
                      I5,
                      ({
                        type Result[RE6] = ResultFolder[
                          I6,
                          ({
                            type Result[RE7] = ResultFolder[
                              I7,
                              ({
                                type Result[RE8] = ResultFolder[
                                  I8,
                                  ({
                                    type Result[RE9] = ResultFolder[
                                      I9,
                                      ({
                                        type Result[RE10] = ResultFolder[
                                          I10,
                                          ({ type Result[RE11] = ResultFolder[I11, ({ type Result[RE12] = RE12 })#Result, RE11] })#Result,
                                          RE10
                                        ]
                                      })#Result,
                                      RE9
                                    ]
                                  })#Result,
                                  RE8
                                ]
                              })#Result,
                              RE7
                            ]
                          })#Result,
                          RE6
                        ]
                      })#Result,
                      RE5
                    ]
                  })#Result,
                  RE4
                ]
              })#Result,
              RE3
            ]
          })#Result,
          RE2
        ]
      })#Result,
      RE1
    ]
  }

  trait Parameter12[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] {
    type Result[RE1] = ResultFolder[
      I1,
      ({
        type Result[RE2] = ResultFolder[
          I2,
          ({
            type Result[RE3] = ResultFolder[
              I3,
              ({
                type Result[RE4] = ResultFolder[
                  I4,
                  ({
                    type Result[RE5] = ResultFolder[
                      I5,
                      ({
                        type Result[RE6] = ResultFolder[
                          I6,
                          ({
                            type Result[RE7] = ResultFolder[
                              I7,
                              ({
                                type Result[RE8] = ResultFolder[
                                  I8,
                                  ({
                                    type Result[RE9] = ResultFolder[
                                      I9,
                                      ({
                                        type Result[RE10] = ResultFolder[
                                          I10,
                                          ({
                                            type Result[RE11] = ResultFolder[
                                              I11,
                                              ({
                                                type Result[RE12] = ResultFolder[I12, ({ type Result[RE13] = RE13 })#Result, RE12]
                                              })#Result,
                                              RE11
                                            ]
                                          })#Result,
                                          RE10
                                        ]
                                      })#Result,
                                      RE9
                                    ]
                                  })#Result,
                                  RE8
                                ]
                              })#Result,
                              RE7
                            ]
                          })#Result,
                          RE6
                        ]
                      })#Result,
                      RE5
                    ]
                  })#Result,
                  RE4
                ]
              })#Result,
              RE3
            ]
          })#Result,
          RE2
        ]
      })#Result,
      RE1
    ]
  }

  trait Parameter13[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] {
    type Result[RE1] = ResultFolder[
      I1,
      ({
        type Result[RE2] = ResultFolder[
          I2,
          ({
            type Result[RE3] = ResultFolder[
              I3,
              ({
                type Result[RE4] = ResultFolder[
                  I4,
                  ({
                    type Result[RE5] = ResultFolder[
                      I5,
                      ({
                        type Result[RE6] = ResultFolder[
                          I6,
                          ({
                            type Result[RE7] = ResultFolder[
                              I7,
                              ({
                                type Result[RE8] = ResultFolder[
                                  I8,
                                  ({
                                    type Result[RE9] = ResultFolder[
                                      I9,
                                      ({
                                        type Result[RE10] = ResultFolder[
                                          I10,
                                          ({
                                            type Result[RE11] = ResultFolder[
                                              I11,
                                              ({
                                                type Result[RE12] = ResultFolder[
                                                  I12,
                                                  ({
                                                    type Result[RE13] = ResultFolder[I13, ({ type Result[RE14] = RE14 })#Result, RE13]
                                                  })#Result,
                                                  RE12
                                                ]
                                              })#Result,
                                              RE11
                                            ]
                                          })#Result,
                                          RE10
                                        ]
                                      })#Result,
                                      RE9
                                    ]
                                  })#Result,
                                  RE8
                                ]
                              })#Result,
                              RE7
                            ]
                          })#Result,
                          RE6
                        ]
                      })#Result,
                      RE5
                    ]
                  })#Result,
                  RE4
                ]
              })#Result,
              RE3
            ]
          })#Result,
          RE2
        ]
      })#Result,
      RE1
    ]
  }

  trait Parameter14[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] {
    type Result[RE1] = ResultFolder[
      I1,
      ({
        type Result[RE2] = ResultFolder[
          I2,
          ({
            type Result[RE3] = ResultFolder[
              I3,
              ({
                type Result[RE4] = ResultFolder[
                  I4,
                  ({
                    type Result[RE5] = ResultFolder[
                      I5,
                      ({
                        type Result[RE6] = ResultFolder[
                          I6,
                          ({
                            type Result[RE7] = ResultFolder[
                              I7,
                              ({
                                type Result[RE8] = ResultFolder[
                                  I8,
                                  ({
                                    type Result[RE9] = ResultFolder[
                                      I9,
                                      ({
                                        type Result[RE10] = ResultFolder[
                                          I10,
                                          ({
                                            type Result[RE11] = ResultFolder[
                                              I11,
                                              ({
                                                type Result[RE12] = ResultFolder[
                                                  I12,
                                                  ({
                                                    type Result[RE13] = ResultFolder[
                                                      I13,
                                                      ({
                                                        type Result[RE14] = ResultFolder[I14, ({ type Result[RE15] = RE15 })#Result, RE14]
                                                      })#Result,
                                                      RE13
                                                    ]
                                                  })#Result,
                                                  RE12
                                                ]
                                              })#Result,
                                              RE11
                                            ]
                                          })#Result,
                                          RE10
                                        ]
                                      })#Result,
                                      RE9
                                    ]
                                  })#Result,
                                  RE8
                                ]
                              })#Result,
                              RE7
                            ]
                          })#Result,
                          RE6
                        ]
                      })#Result,
                      RE5
                    ]
                  })#Result,
                  RE4
                ]
              })#Result,
              RE3
            ]
          })#Result,
          RE2
        ]
      })#Result,
      RE1
    ]
  }

  trait Parameter15[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] {
    type Result[RE1] = ResultFolder[
      I1,
      ({
        type Result[RE2] = ResultFolder[
          I2,
          ({
            type Result[RE3] = ResultFolder[
              I3,
              ({
                type Result[RE4] = ResultFolder[
                  I4,
                  ({
                    type Result[RE5] = ResultFolder[
                      I5,
                      ({
                        type Result[RE6] = ResultFolder[
                          I6,
                          ({
                            type Result[RE7] = ResultFolder[
                              I7,
                              ({
                                type Result[RE8] = ResultFolder[
                                  I8,
                                  ({
                                    type Result[RE9] = ResultFolder[
                                      I9,
                                      ({
                                        type Result[RE10] = ResultFolder[
                                          I10,
                                          ({
                                            type Result[RE11] = ResultFolder[
                                              I11,
                                              ({
                                                type Result[RE12] = ResultFolder[
                                                  I12,
                                                  ({
                                                    type Result[RE13] = ResultFolder[
                                                      I13,
                                                      ({
                                                        type Result[RE14] = ResultFolder[
                                                          I14,
                                                          ({
                                                            type Result[RE15] =
                                                              ResultFolder[I15, ({ type Result[RE16] = RE16 })#Result, RE15]
                                                          })#Result,
                                                          RE14
                                                        ]
                                                      })#Result,
                                                      RE13
                                                    ]
                                                  })#Result,
                                                  RE12
                                                ]
                                              })#Result,
                                              RE11
                                            ]
                                          })#Result,
                                          RE10
                                        ]
                                      })#Result,
                                      RE9
                                    ]
                                  })#Result,
                                  RE8
                                ]
                              })#Result,
                              RE7
                            ]
                          })#Result,
                          RE6
                        ]
                      })#Result,
                      RE5
                    ]
                  })#Result,
                  RE4
                ]
              })#Result,
              RE3
            ]
          })#Result,
          RE2
        ]
      })#Result,
      RE1
    ]
  }

  trait Parameter16[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] {
    type Result[RE1] = ResultFolder[
      I1,
      ({
        type Result[RE2] = ResultFolder[
          I2,
          ({
            type Result[RE3] = ResultFolder[
              I3,
              ({
                type Result[RE4] = ResultFolder[
                  I4,
                  ({
                    type Result[RE5] = ResultFolder[
                      I5,
                      ({
                        type Result[RE6] = ResultFolder[
                          I6,
                          ({
                            type Result[RE7] = ResultFolder[
                              I7,
                              ({
                                type Result[RE8] = ResultFolder[
                                  I8,
                                  ({
                                    type Result[RE9] = ResultFolder[
                                      I9,
                                      ({
                                        type Result[RE10] = ResultFolder[
                                          I10,
                                          ({
                                            type Result[RE11] = ResultFolder[
                                              I11,
                                              ({
                                                type Result[RE12] = ResultFolder[
                                                  I12,
                                                  ({
                                                    type Result[RE13] = ResultFolder[
                                                      I13,
                                                      ({
                                                        type Result[RE14] = ResultFolder[
                                                          I14,
                                                          ({
                                                            type Result[RE15] = ResultFolder[
                                                              I15,
                                                              ({
                                                                type Result[RE16] =
                                                                  ResultFolder[I16, ({ type Result[RE17] = RE17 })#Result, RE16]
                                                              })#Result,
                                                              RE15
                                                            ]
                                                          })#Result,
                                                          RE14
                                                        ]
                                                      })#Result,
                                                      RE13
                                                    ]
                                                  })#Result,
                                                  RE12
                                                ]
                                              })#Result,
                                              RE11
                                            ]
                                          })#Result,
                                          RE10
                                        ]
                                      })#Result,
                                      RE9
                                    ]
                                  })#Result,
                                  RE8
                                ]
                              })#Result,
                              RE7
                            ]
                          })#Result,
                          RE6
                        ]
                      })#Result,
                      RE5
                    ]
                  })#Result,
                  RE4
                ]
              })#Result,
              RE3
            ]
          })#Result,
          RE2
        ]
      })#Result,
      RE1
    ]
  }

  trait Parameter17[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] {
    type Result[RE1] = ResultFolder[
      I1,
      ({
        type Result[RE2] = ResultFolder[
          I2,
          ({
            type Result[RE3] = ResultFolder[
              I3,
              ({
                type Result[RE4] = ResultFolder[
                  I4,
                  ({
                    type Result[RE5] = ResultFolder[
                      I5,
                      ({
                        type Result[RE6] = ResultFolder[
                          I6,
                          ({
                            type Result[RE7] = ResultFolder[
                              I7,
                              ({
                                type Result[RE8] = ResultFolder[
                                  I8,
                                  ({
                                    type Result[RE9] = ResultFolder[
                                      I9,
                                      ({
                                        type Result[RE10] = ResultFolder[
                                          I10,
                                          ({
                                            type Result[RE11] = ResultFolder[
                                              I11,
                                              ({
                                                type Result[RE12] = ResultFolder[
                                                  I12,
                                                  ({
                                                    type Result[RE13] = ResultFolder[
                                                      I13,
                                                      ({
                                                        type Result[RE14] = ResultFolder[
                                                          I14,
                                                          ({
                                                            type Result[RE15] = ResultFolder[
                                                              I15,
                                                              ({
                                                                type Result[RE16] = ResultFolder[
                                                                  I16,
                                                                  ({
                                                                    type Result[RE17] =
                                                                      ResultFolder[I17, ({ type Result[RE18] = RE18 })#Result, RE17]
                                                                  })#Result,
                                                                  RE16
                                                                ]
                                                              })#Result,
                                                              RE15
                                                            ]
                                                          })#Result,
                                                          RE14
                                                        ]
                                                      })#Result,
                                                      RE13
                                                    ]
                                                  })#Result,
                                                  RE12
                                                ]
                                              })#Result,
                                              RE11
                                            ]
                                          })#Result,
                                          RE10
                                        ]
                                      })#Result,
                                      RE9
                                    ]
                                  })#Result,
                                  RE8
                                ]
                              })#Result,
                              RE7
                            ]
                          })#Result,
                          RE6
                        ]
                      })#Result,
                      RE5
                    ]
                  })#Result,
                  RE4
                ]
              })#Result,
              RE3
            ]
          })#Result,
          RE2
        ]
      })#Result,
      RE1
    ]
  }

  trait Parameter18[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] {
    type Result[RE1] = ResultFolder[
      I1,
      ({
        type Result[RE2] = ResultFolder[
          I2,
          ({
            type Result[RE3] = ResultFolder[
              I3,
              ({
                type Result[RE4] = ResultFolder[
                  I4,
                  ({
                    type Result[RE5] = ResultFolder[
                      I5,
                      ({
                        type Result[RE6] = ResultFolder[
                          I6,
                          ({
                            type Result[RE7] = ResultFolder[
                              I7,
                              ({
                                type Result[RE8] = ResultFolder[
                                  I8,
                                  ({
                                    type Result[RE9] = ResultFolder[
                                      I9,
                                      ({
                                        type Result[RE10] = ResultFolder[
                                          I10,
                                          ({
                                            type Result[RE11] = ResultFolder[
                                              I11,
                                              ({
                                                type Result[RE12] = ResultFolder[
                                                  I12,
                                                  ({
                                                    type Result[RE13] = ResultFolder[
                                                      I13,
                                                      ({
                                                        type Result[RE14] = ResultFolder[
                                                          I14,
                                                          ({
                                                            type Result[RE15] = ResultFolder[
                                                              I15,
                                                              ({
                                                                type Result[RE16] = ResultFolder[
                                                                  I16,
                                                                  ({
                                                                    type Result[RE17] = ResultFolder[
                                                                      I17,
                                                                      ({
                                                                        type Result[RE18] =
                                                                          ResultFolder[I18, ({ type Result[RE19] = RE19 })#Result, RE18]
                                                                      })#Result,
                                                                      RE17
                                                                    ]
                                                                  })#Result,
                                                                  RE16
                                                                ]
                                                              })#Result,
                                                              RE15
                                                            ]
                                                          })#Result,
                                                          RE14
                                                        ]
                                                      })#Result,
                                                      RE13
                                                    ]
                                                  })#Result,
                                                  RE12
                                                ]
                                              })#Result,
                                              RE11
                                            ]
                                          })#Result,
                                          RE10
                                        ]
                                      })#Result,
                                      RE9
                                    ]
                                  })#Result,
                                  RE8
                                ]
                              })#Result,
                              RE7
                            ]
                          })#Result,
                          RE6
                        ]
                      })#Result,
                      RE5
                    ]
                  })#Result,
                  RE4
                ]
              })#Result,
              RE3
            ]
          })#Result,
          RE2
        ]
      })#Result,
      RE1
    ]
  }

  trait Parameter19[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] {
    type Result[RE1] = ResultFolder[
      I1,
      ({
        type Result[RE2] = ResultFolder[
          I2,
          ({
            type Result[RE3] = ResultFolder[
              I3,
              ({
                type Result[RE4] = ResultFolder[
                  I4,
                  ({
                    type Result[RE5] = ResultFolder[
                      I5,
                      ({
                        type Result[RE6] = ResultFolder[
                          I6,
                          ({
                            type Result[RE7] = ResultFolder[
                              I7,
                              ({
                                type Result[RE8] = ResultFolder[
                                  I8,
                                  ({
                                    type Result[RE9] = ResultFolder[
                                      I9,
                                      ({
                                        type Result[RE10] = ResultFolder[
                                          I10,
                                          ({
                                            type Result[RE11] = ResultFolder[
                                              I11,
                                              ({
                                                type Result[RE12] = ResultFolder[
                                                  I12,
                                                  ({
                                                    type Result[RE13] = ResultFolder[
                                                      I13,
                                                      ({
                                                        type Result[RE14] = ResultFolder[
                                                          I14,
                                                          ({
                                                            type Result[RE15] = ResultFolder[
                                                              I15,
                                                              ({
                                                                type Result[RE16] = ResultFolder[
                                                                  I16,
                                                                  ({
                                                                    type Result[RE17] = ResultFolder[
                                                                      I17,
                                                                      ({
                                                                        type Result[RE18] = ResultFolder[
                                                                          I18,
                                                                          ({
                                                                            type Result[RE19] =
                                                                              ResultFolder[I19, ({ type Result[RE20] = RE20 })#Result, RE19]
                                                                          })#Result,
                                                                          RE18
                                                                        ]
                                                                      })#Result,
                                                                      RE17
                                                                    ]
                                                                  })#Result,
                                                                  RE16
                                                                ]
                                                              })#Result,
                                                              RE15
                                                            ]
                                                          })#Result,
                                                          RE14
                                                        ]
                                                      })#Result,
                                                      RE13
                                                    ]
                                                  })#Result,
                                                  RE12
                                                ]
                                              })#Result,
                                              RE11
                                            ]
                                          })#Result,
                                          RE10
                                        ]
                                      })#Result,
                                      RE9
                                    ]
                                  })#Result,
                                  RE8
                                ]
                              })#Result,
                              RE7
                            ]
                          })#Result,
                          RE6
                        ]
                      })#Result,
                      RE5
                    ]
                  })#Result,
                  RE4
                ]
              })#Result,
              RE3
            ]
          })#Result,
          RE2
        ]
      })#Result,
      RE1
    ]
  }

  trait Parameter20[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] {
    type Result[RE1] = ResultFolder[
      I1,
      ({
        type Result[RE2] = ResultFolder[
          I2,
          ({
            type Result[RE3] = ResultFolder[
              I3,
              ({
                type Result[RE4] = ResultFolder[
                  I4,
                  ({
                    type Result[RE5] = ResultFolder[
                      I5,
                      ({
                        type Result[RE6] = ResultFolder[
                          I6,
                          ({
                            type Result[RE7] = ResultFolder[
                              I7,
                              ({
                                type Result[RE8] = ResultFolder[
                                  I8,
                                  ({
                                    type Result[RE9] = ResultFolder[
                                      I9,
                                      ({
                                        type Result[RE10] = ResultFolder[
                                          I10,
                                          ({
                                            type Result[RE11] = ResultFolder[
                                              I11,
                                              ({
                                                type Result[RE12] = ResultFolder[
                                                  I12,
                                                  ({
                                                    type Result[RE13] = ResultFolder[
                                                      I13,
                                                      ({
                                                        type Result[RE14] = ResultFolder[
                                                          I14,
                                                          ({
                                                            type Result[RE15] = ResultFolder[
                                                              I15,
                                                              ({
                                                                type Result[RE16] = ResultFolder[
                                                                  I16,
                                                                  ({
                                                                    type Result[RE17] = ResultFolder[
                                                                      I17,
                                                                      ({
                                                                        type Result[RE18] = ResultFolder[
                                                                          I18,
                                                                          ({
                                                                            type Result[RE19] = ResultFolder[
                                                                              I19,
                                                                              ({
                                                                                type Result[RE20] = ResultFolder[
                                                                                  I20,
                                                                                  ({ type Result[RE21] = RE21 })#Result,
                                                                                  RE20
                                                                                ]
                                                                              })#Result,
                                                                              RE19
                                                                            ]
                                                                          })#Result,
                                                                          RE18
                                                                        ]
                                                                      })#Result,
                                                                      RE17
                                                                    ]
                                                                  })#Result,
                                                                  RE16
                                                                ]
                                                              })#Result,
                                                              RE15
                                                            ]
                                                          })#Result,
                                                          RE14
                                                        ]
                                                      })#Result,
                                                      RE13
                                                    ]
                                                  })#Result,
                                                  RE12
                                                ]
                                              })#Result,
                                              RE11
                                            ]
                                          })#Result,
                                          RE10
                                        ]
                                      })#Result,
                                      RE9
                                    ]
                                  })#Result,
                                  RE8
                                ]
                              })#Result,
                              RE7
                            ]
                          })#Result,
                          RE6
                        ]
                      })#Result,
                      RE5
                    ]
                  })#Result,
                  RE4
                ]
              })#Result,
              RE3
            ]
          })#Result,
          RE2
        ]
      })#Result,
      RE1
    ]
  }

  trait Parameter21[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] {
    type Result[RE1] = ResultFolder[
      I1,
      ({
        type Result[RE2] = ResultFolder[
          I2,
          ({
            type Result[RE3] = ResultFolder[
              I3,
              ({
                type Result[RE4] = ResultFolder[
                  I4,
                  ({
                    type Result[RE5] = ResultFolder[
                      I5,
                      ({
                        type Result[RE6] = ResultFolder[
                          I6,
                          ({
                            type Result[RE7] = ResultFolder[
                              I7,
                              ({
                                type Result[RE8] = ResultFolder[
                                  I8,
                                  ({
                                    type Result[RE9] = ResultFolder[
                                      I9,
                                      ({
                                        type Result[RE10] = ResultFolder[
                                          I10,
                                          ({
                                            type Result[RE11] = ResultFolder[
                                              I11,
                                              ({
                                                type Result[RE12] = ResultFolder[
                                                  I12,
                                                  ({
                                                    type Result[RE13] = ResultFolder[
                                                      I13,
                                                      ({
                                                        type Result[RE14] = ResultFolder[
                                                          I14,
                                                          ({
                                                            type Result[RE15] = ResultFolder[
                                                              I15,
                                                              ({
                                                                type Result[RE16] = ResultFolder[
                                                                  I16,
                                                                  ({
                                                                    type Result[RE17] = ResultFolder[
                                                                      I17,
                                                                      ({
                                                                        type Result[RE18] = ResultFolder[
                                                                          I18,
                                                                          ({
                                                                            type Result[RE19] = ResultFolder[
                                                                              I19,
                                                                              ({
                                                                                type Result[RE20] = ResultFolder[
                                                                                  I20,
                                                                                  ({
                                                                                    type Result[RE21] = ResultFolder[
                                                                                      I21,
                                                                                      ({ type Result[RE22] = RE22 })#Result,
                                                                                      RE21
                                                                                    ]
                                                                                  })#Result,
                                                                                  RE20
                                                                                ]
                                                                              })#Result,
                                                                              RE19
                                                                            ]
                                                                          })#Result,
                                                                          RE18
                                                                        ]
                                                                      })#Result,
                                                                      RE17
                                                                    ]
                                                                  })#Result,
                                                                  RE16
                                                                ]
                                                              })#Result,
                                                              RE15
                                                            ]
                                                          })#Result,
                                                          RE14
                                                        ]
                                                      })#Result,
                                                      RE13
                                                    ]
                                                  })#Result,
                                                  RE12
                                                ]
                                              })#Result,
                                              RE11
                                            ]
                                          })#Result,
                                          RE10
                                        ]
                                      })#Result,
                                      RE9
                                    ]
                                  })#Result,
                                  RE8
                                ]
                              })#Result,
                              RE7
                            ]
                          })#Result,
                          RE6
                        ]
                      })#Result,
                      RE5
                    ]
                  })#Result,
                  RE4
                ]
              })#Result,
              RE3
            ]
          })#Result,
          RE2
        ]
      })#Result,
      RE1
    ]
  }

  trait Parameter22[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22] {
    type Result[RE1] = ResultFolder[
      I1,
      ({
        type Result[RE2] = ResultFolder[
          I2,
          ({
            type Result[RE3] = ResultFolder[
              I3,
              ({
                type Result[RE4] = ResultFolder[
                  I4,
                  ({
                    type Result[RE5] = ResultFolder[
                      I5,
                      ({
                        type Result[RE6] = ResultFolder[
                          I6,
                          ({
                            type Result[RE7] = ResultFolder[
                              I7,
                              ({
                                type Result[RE8] = ResultFolder[
                                  I8,
                                  ({
                                    type Result[RE9] = ResultFolder[
                                      I9,
                                      ({
                                        type Result[RE10] = ResultFolder[
                                          I10,
                                          ({
                                            type Result[RE11] = ResultFolder[
                                              I11,
                                              ({
                                                type Result[RE12] = ResultFolder[
                                                  I12,
                                                  ({
                                                    type Result[RE13] = ResultFolder[
                                                      I13,
                                                      ({
                                                        type Result[RE14] = ResultFolder[
                                                          I14,
                                                          ({
                                                            type Result[RE15] = ResultFolder[
                                                              I15,
                                                              ({
                                                                type Result[RE16] = ResultFolder[
                                                                  I16,
                                                                  ({
                                                                    type Result[RE17] = ResultFolder[
                                                                      I17,
                                                                      ({
                                                                        type Result[RE18] = ResultFolder[
                                                                          I18,
                                                                          ({
                                                                            type Result[RE19] = ResultFolder[
                                                                              I19,
                                                                              ({
                                                                                type Result[RE20] = ResultFolder[
                                                                                  I20,
                                                                                  ({
                                                                                    type Result[RE21] = ResultFolder[
                                                                                      I21,
                                                                                      ({
                                                                                        type Result[RE22] = ResultFolder[
                                                                                          I22,
                                                                                          ({ type Result[RE23] = RE23 })#Result,
                                                                                          RE22
                                                                                        ]
                                                                                      })#Result,
                                                                                      RE21
                                                                                    ]
                                                                                  })#Result,
                                                                                  RE20
                                                                                ]
                                                                              })#Result,
                                                                              RE19
                                                                            ]
                                                                          })#Result,
                                                                          RE18
                                                                        ]
                                                                      })#Result,
                                                                      RE17
                                                                    ]
                                                                  })#Result,
                                                                  RE16
                                                                ]
                                                              })#Result,
                                                              RE15
                                                            ]
                                                          })#Result,
                                                          RE14
                                                        ]
                                                      })#Result,
                                                      RE13
                                                    ]
                                                  })#Result,
                                                  RE12
                                                ]
                                              })#Result,
                                              RE11
                                            ]
                                          })#Result,
                                          RE10
                                        ]
                                      })#Result,
                                      RE9
                                    ]
                                  })#Result,
                                  RE8
                                ]
                              })#Result,
                              RE7
                            ]
                          })#Result,
                          RE6
                        ]
                      })#Result,
                      RE5
                    ]
                  })#Result,
                  RE4
                ]
              })#Result,
              RE3
            ]
          })#Result,
          RE2
        ]
      })#Result,
      RE1
    ]
  }
}
