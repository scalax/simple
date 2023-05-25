package net.scalax.simple
package adt
package impl

import implemention._

trait TypeAdtAlias {

  type Options1[A, I1]                        = TypeAdtApply.Aux[A, NatFuncPositive[I1, NatFuncZero], Adt.Status.Passed]
  type OptionsX1[A, Status <: Adt.Status, I1] = TypeAdtApply.Aux[A, NatFuncPositive[I1, NatFuncZero], Status]

  type Options2[A, I1, I2] = TypeAdtApply.Aux[A, NatFuncPositive[I1, NatFuncPositive[I2, NatFuncZero]], Adt.Status.Passed]
  type OptionsX2[A, Status <: Adt.Status, I1, I2] = TypeAdtApply.Aux[A, NatFuncPositive[I1, NatFuncPositive[I2, NatFuncZero]], Status]

  type Options3[A, I1, I2, I3] =
    TypeAdtApply.Aux[A, NatFuncPositive[I1, NatFuncPositive[I2, NatFuncPositive[I3, NatFuncZero]]], Adt.Status.Passed]
  type OptionsX3[A, Status <: Adt.Status, I1, I2, I3] =
    TypeAdtApply.Aux[A, NatFuncPositive[I1, NatFuncPositive[I2, NatFuncPositive[I3, NatFuncZero]]], Status]

  type Options4[A, I1, I2, I3, I4] =
    TypeAdtApply.Aux[A, NatFuncPositive[I1, NatFuncPositive[I2, NatFuncPositive[I3, NatFuncPositive[I4, NatFuncZero]]]], Adt.Status.Passed]
  type OptionsX4[A, Status <: Adt.Status, I1, I2, I3, I4] =
    TypeAdtApply.Aux[A, NatFuncPositive[I1, NatFuncPositive[I2, NatFuncPositive[I3, NatFuncPositive[I4, NatFuncZero]]]], Status]

  type Options5[A, I1, I2, I3, I4, I5] = TypeAdtApply.Aux[A, NatFuncPositive[
    I1,
    NatFuncPositive[I2, NatFuncPositive[I3, NatFuncPositive[I4, NatFuncPositive[I5, NatFuncZero]]]]
  ], Adt.Status.Passed]
  type OptionsX5[A, Status <: Adt.Status, I1, I2, I3, I4, I5] = TypeAdtApply.Aux[A, NatFuncPositive[
    I1,
    NatFuncPositive[I2, NatFuncPositive[I3, NatFuncPositive[I4, NatFuncPositive[I5, NatFuncZero]]]]
  ], Status]

  type Options6[A, I1, I2, I3, I4, I5, I6] = TypeAdtApply.Aux[
    A,
    NatFuncPositive[
      I1,
      NatFuncPositive[I2, NatFuncPositive[I3, NatFuncPositive[I4, NatFuncPositive[I5, NatFuncPositive[I6, NatFuncZero]]]]]
    ],
    Adt.Status.Passed
  ]
  type OptionsX6[A, Status <: Adt.Status, I1, I2, I3, I4, I5, I6] = TypeAdtApply.Aux[A, NatFuncPositive[
    I1,
    NatFuncPositive[I2, NatFuncPositive[I3, NatFuncPositive[I4, NatFuncPositive[I5, NatFuncPositive[I6, NatFuncZero]]]]]
  ], Status]

  type Options7[A, I1, I2, I3, I4, I5, I6, I7] = TypeAdtApply.Aux[
    A,
    NatFuncPositive[I1, NatFuncPositive[
      I2,
      NatFuncPositive[I3, NatFuncPositive[I4, NatFuncPositive[I5, NatFuncPositive[I6, NatFuncPositive[I7, NatFuncZero]]]]]
    ]],
    Adt.Status.Passed
  ]
  type OptionsX7[A, Status <: Adt.Status, I1, I2, I3, I4, I5, I6, I7] = TypeAdtApply.Aux[
    A,
    NatFuncPositive[I1, NatFuncPositive[
      I2,
      NatFuncPositive[I3, NatFuncPositive[I4, NatFuncPositive[I5, NatFuncPositive[I6, NatFuncPositive[I7, NatFuncZero]]]]]
    ]],
    Status
  ]

  type Options8[A, I1, I2, I3, I4, I5, I6, I7, I8] = TypeAdtApply.Aux[
    A,
    NatFuncPositive[
      I1,
      NatFuncPositive[I2, NatFuncPositive[
        I3,
        NatFuncPositive[I4, NatFuncPositive[I5, NatFuncPositive[I6, NatFuncPositive[I7, NatFuncPositive[I8, NatFuncZero]]]]]
      ]]
    ],
    Adt.Status.Passed
  ]
  type OptionsX8[A, Status <: Adt.Status, I1, I2, I3, I4, I5, I6, I7, I8] = TypeAdtApply.Aux[
    A,
    NatFuncPositive[
      I1,
      NatFuncPositive[I2, NatFuncPositive[
        I3,
        NatFuncPositive[I4, NatFuncPositive[I5, NatFuncPositive[I6, NatFuncPositive[I7, NatFuncPositive[I8, NatFuncZero]]]]]
      ]]
    ],
    Status
  ]

  type Options9[A, I1, I2, I3, I4, I5, I6, I7, I8, I9] = TypeAdtApply.Aux[
    A,
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
  type OptionsX9[A, Status <: Adt.Status, I1, I2, I3, I4, I5, I6, I7, I8, I9] = TypeAdtApply.Aux[
    A,
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
    Status
  ]

  type Options10[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] = TypeAdtApply.Aux[
    A,
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
  type OptionsX10[A, Status <: Adt.Status, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] = TypeAdtApply.Aux[
    A,
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
    Status
  ]

  type Options11[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] = TypeAdtApply.Aux[
    A,
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
  type OptionsX11[A, Status <: Adt.Status, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] = TypeAdtApply.Aux[
    A,
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
    Status
  ]

  type Options12[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] = TypeAdtApply.Aux[
    A,
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
  type OptionsX12[A, Status <: Adt.Status, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] = TypeAdtApply.Aux[
    A,
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
    Status
  ]

  type Options13[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] = TypeAdtApply.Aux[
    A,
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
    ],
    Adt.Status.Passed
  ]
  type OptionsX13[A, Status <: Adt.Status, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] = TypeAdtApply.Aux[
    A,
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
    ],
    Status
  ]

  type Options14[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] = TypeAdtApply.Aux[
    A,
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
  type OptionsX14[A, Status <: Adt.Status, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] = TypeAdtApply.Aux[
    A,
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
    Status
  ]

  type Options15[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] = TypeAdtApply.Aux[
    A,
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
  type OptionsX15[A, Status <: Adt.Status, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] = TypeAdtApply.Aux[
    A,
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
    Status
  ]

  type Options16[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] = TypeAdtApply.Aux[
    A,
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
  type OptionsX16[A, Status <: Adt.Status, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] = TypeAdtApply.Aux[
    A,
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
    Status
  ]

  type Options17[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] = TypeAdtApply.Aux[
    A,
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
  type OptionsX17[A, Status <: Adt.Status, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] = TypeAdtApply.Aux[
    A,
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
    Status
  ]

  type Options18[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] = TypeAdtApply.Aux[
    A,
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
  type OptionsX18[A, Status <: Adt.Status, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] =
    TypeAdtApply.Aux[
      A,
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
      Status
    ]

  type Options19[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] = TypeAdtApply.Aux[
    A,
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
  type OptionsX19[A, Status <: Adt.Status, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] =
    TypeAdtApply.Aux[
      A,
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
      Status
    ]

  type Options20[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] = TypeAdtApply.Aux[
    A,
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
  type OptionsX20[A, Status <: Adt.Status, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] =
    TypeAdtApply.Aux[
      A,
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
      Status
    ]

  type Options21[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] = TypeAdtApply.Aux[
    A,
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
  type OptionsX21[A, Status <: Adt.Status, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] =
    TypeAdtApply.Aux[
      A,
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
      Status
    ]

  type Options22[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22] = TypeAdtApply.Aux[
    A,
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
  type OptionsX22[
    A,
    Status <: Adt.Status,
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
  ] = TypeAdtApply.Aux[
    A,
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
    Status
  ]

}

object TypeAdtAlias extends TypeAdtAlias
