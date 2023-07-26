package net.scalax.simple
package adt
package impl

import implemention._
import temp._
import temp.{Status => ADTStatus}

trait TypeAdtAlias {

  type Options1[A, I1]                              = TypeAdtApply[A, AdtNatData[I1, AdtNatZero], ADTStatus.Passed]
  type OptionsX1[A, Status <: ADTStatus.Passed, I1] = TypeAdtApply[A, AdtNatData[I1, AdtNatZero], Status]

  type Options2[A, I1, I2]                              = TypeAdtApply[A, AdtNatData[I2, AdtNatData[I1, AdtNatZero]], ADTStatus.Passed]
  type OptionsX2[A, Status <: ADTStatus.Passed, I1, I2] = TypeAdtApply[A, AdtNatData[I2, AdtNatData[I1, AdtNatZero]], Status]

  type Options3[A, I1, I2, I3] = TypeAdtApply[A, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]], ADTStatus.Passed]
  type OptionsX3[A, Status <: ADTStatus.Passed, I1, I2, I3] =
    TypeAdtApply[A, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]], Status]

  type Options4[A, I1, I2, I3, I4] =
    TypeAdtApply[A, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]], ADTStatus.Passed]
  type OptionsX4[A, Status <: ADTStatus.Passed, I1, I2, I3, I4] =
    TypeAdtApply[A, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]], Status]

  type Options5[A, I1, I2, I3, I4, I5] =
    TypeAdtApply[A, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]], ADTStatus.Passed]
  type OptionsX5[A, Status <: ADTStatus.Passed, I1, I2, I3, I4, I5] =
    TypeAdtApply[A, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]], Status]

  type Options6[A, I1, I2, I3, I4, I5, I6] = TypeAdtApply[
    A,
    AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]],
    ADTStatus.Passed
  ]
  type OptionsX6[A, Status <: ADTStatus.Passed, I1, I2, I3, I4, I5, I6] =
    TypeAdtApply[A, AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]], Status]

  type Options7[A, I1, I2, I3, I4, I5, I6, I7] = TypeAdtApply[
    A,
    AdtNatData[I7, AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]],
    ADTStatus.Passed
  ]
  type OptionsX7[A, Status <: ADTStatus.Passed, I1, I2, I3, I4, I5, I6, I7] = TypeAdtApply[
    A,
    AdtNatData[I7, AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]],
    Status
  ]

  type Options8[A, I1, I2, I3, I4, I5, I6, I7, I8] = TypeAdtApply[A, AdtNatData[
    I8,
    AdtNatData[I7, AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]]
  ], ADTStatus.Passed]
  type OptionsX8[A, Status <: ADTStatus.Passed, I1, I2, I3, I4, I5, I6, I7, I8] = TypeAdtApply[A, AdtNatData[
    I8,
    AdtNatData[I7, AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]]
  ], Status]

  type Options9[A, I1, I2, I3, I4, I5, I6, I7, I8, I9] = TypeAdtApply[
    A,
    AdtNatData[I9, AdtNatData[
      I8,
      AdtNatData[I7, AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]]
    ]],
    ADTStatus.Passed
  ]
  type OptionsX9[A, Status <: ADTStatus.Passed, I1, I2, I3, I4, I5, I6, I7, I8, I9] = TypeAdtApply[
    A,
    AdtNatData[I9, AdtNatData[
      I8,
      AdtNatData[I7, AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]]
    ]],
    Status
  ]

  type Options10[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] = TypeAdtApply[
    A,
    AdtNatData[I10, AdtNatData[I9, AdtNatData[
      I8,
      AdtNatData[I7, AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]]
    ]]],
    ADTStatus.Passed
  ]
  type OptionsX10[A, Status <: ADTStatus.Passed, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] = TypeAdtApply[
    A,
    AdtNatData[I10, AdtNatData[I9, AdtNatData[
      I8,
      AdtNatData[I7, AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]]
    ]]],
    Status
  ]

  type Options11[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] = TypeAdtApply[
    A,
    AdtNatData[
      I11,
      AdtNatData[I10, AdtNatData[I9, AdtNatData[
        I8,
        AdtNatData[I7, AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]]
      ]]]
    ],
    ADTStatus.Passed
  ]
  type OptionsX11[A, Status <: ADTStatus.Passed, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] = TypeAdtApply[
    A,
    AdtNatData[
      I11,
      AdtNatData[I10, AdtNatData[I9, AdtNatData[
        I8,
        AdtNatData[I7, AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]]
      ]]]
    ],
    Status
  ]

  type Options12[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] = TypeAdtApply[
    A,
    AdtNatData[
      I12,
      AdtNatData[
        I11,
        AdtNatData[I10, AdtNatData[I9, AdtNatData[
          I8,
          AdtNatData[I7, AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]]
        ]]]
      ]
    ],
    ADTStatus.Passed
  ]
  type OptionsX12[A, Status <: ADTStatus.Passed, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] = TypeAdtApply[
    A,
    AdtNatData[
      I12,
      AdtNatData[
        I11,
        AdtNatData[I10, AdtNatData[I9, AdtNatData[
          I8,
          AdtNatData[I7, AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]]
        ]]]
      ]
    ],
    Status
  ]

  type Options13[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] = TypeAdtApply[
    A,
    AdtNatData[
      I13,
      AdtNatData[
        I12,
        AdtNatData[
          I11,
          AdtNatData[I10, AdtNatData[I9, AdtNatData[
            I8,
            AdtNatData[I7, AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]]
          ]]]
        ]
      ]
    ],
    ADTStatus.Passed
  ]
  type OptionsX13[A, Status <: ADTStatus.Passed, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] = TypeAdtApply[
    A,
    AdtNatData[
      I13,
      AdtNatData[
        I12,
        AdtNatData[
          I11,
          AdtNatData[I10, AdtNatData[I9, AdtNatData[
            I8,
            AdtNatData[I7, AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]]
          ]]]
        ]
      ]
    ],
    Status
  ]

  type Options14[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] = TypeAdtApply[
    A,
    AdtNatData[
      I14,
      AdtNatData[
        I13,
        AdtNatData[
          I12,
          AdtNatData[
            I11,
            AdtNatData[I10, AdtNatData[I9, AdtNatData[
              I8,
              AdtNatData[I7, AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]]
            ]]]
          ]
        ]
      ]
    ],
    ADTStatus.Passed
  ]
  type OptionsX14[A, Status <: ADTStatus.Passed, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] = TypeAdtApply[
    A,
    AdtNatData[
      I14,
      AdtNatData[
        I13,
        AdtNatData[
          I12,
          AdtNatData[
            I11,
            AdtNatData[I10, AdtNatData[I9, AdtNatData[
              I8,
              AdtNatData[I7, AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]]
            ]]]
          ]
        ]
      ]
    ],
    Status
  ]

  type Options15[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] = TypeAdtApply[
    A,
    AdtNatData[
      I15,
      AdtNatData[
        I14,
        AdtNatData[
          I13,
          AdtNatData[
            I12,
            AdtNatData[
              I11,
              AdtNatData[I10, AdtNatData[I9, AdtNatData[
                I8,
                AdtNatData[I7, AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]]
              ]]]
            ]
          ]
        ]
      ]
    ],
    ADTStatus.Passed
  ]
  type OptionsX15[A, Status <: ADTStatus.Passed, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] = TypeAdtApply[
    A,
    AdtNatData[
      I15,
      AdtNatData[
        I14,
        AdtNatData[
          I13,
          AdtNatData[
            I12,
            AdtNatData[
              I11,
              AdtNatData[I10, AdtNatData[I9, AdtNatData[
                I8,
                AdtNatData[I7, AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]]
              ]]]
            ]
          ]
        ]
      ]
    ],
    Status
  ]

  type Options16[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] = TypeAdtApply[
    A,
    AdtNatData[
      I16,
      AdtNatData[
        I15,
        AdtNatData[
          I14,
          AdtNatData[
            I13,
            AdtNatData[
              I12,
              AdtNatData[
                I11,
                AdtNatData[I10, AdtNatData[I9, AdtNatData[
                  I8,
                  AdtNatData[I7, AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]]
                ]]]
              ]
            ]
          ]
        ]
      ]
    ],
    ADTStatus.Passed
  ]
  type OptionsX16[A, Status <: ADTStatus.Passed, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] = TypeAdtApply[
    A,
    AdtNatData[
      I16,
      AdtNatData[
        I15,
        AdtNatData[
          I14,
          AdtNatData[
            I13,
            AdtNatData[
              I12,
              AdtNatData[
                I11,
                AdtNatData[I10, AdtNatData[I9, AdtNatData[
                  I8,
                  AdtNatData[I7, AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]]
                ]]]
              ]
            ]
          ]
        ]
      ]
    ],
    Status
  ]

  type Options17[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] = TypeAdtApply[
    A,
    AdtNatData[
      I17,
      AdtNatData[
        I16,
        AdtNatData[
          I15,
          AdtNatData[
            I14,
            AdtNatData[
              I13,
              AdtNatData[
                I12,
                AdtNatData[
                  I11,
                  AdtNatData[I10, AdtNatData[I9, AdtNatData[I8, AdtNatData[
                    I7,
                    AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]
                  ]]]]
                ]
              ]
            ]
          ]
        ]
      ]
    ],
    ADTStatus.Passed
  ]
  type OptionsX17[A, Status <: ADTStatus.Passed, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] = TypeAdtApply[
    A,
    AdtNatData[
      I17,
      AdtNatData[
        I16,
        AdtNatData[
          I15,
          AdtNatData[
            I14,
            AdtNatData[
              I13,
              AdtNatData[
                I12,
                AdtNatData[
                  I11,
                  AdtNatData[I10, AdtNatData[I9, AdtNatData[I8, AdtNatData[
                    I7,
                    AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]
                  ]]]]
                ]
              ]
            ]
          ]
        ]
      ]
    ],
    Status
  ]

  type Options18[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] = TypeAdtApply[
    A,
    AdtNatData[
      I18,
      AdtNatData[
        I17,
        AdtNatData[
          I16,
          AdtNatData[
            I15,
            AdtNatData[
              I14,
              AdtNatData[
                I13,
                AdtNatData[
                  I12,
                  AdtNatData[
                    I11,
                    AdtNatData[I10, AdtNatData[I9, AdtNatData[I8, AdtNatData[
                      I7,
                      AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]
                    ]]]]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    ],
    ADTStatus.Passed
  ]
  type OptionsX18[A, Status <: ADTStatus.Passed, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] =
    TypeAdtApply[
      A,
      AdtNatData[
        I18,
        AdtNatData[
          I17,
          AdtNatData[
            I16,
            AdtNatData[
              I15,
              AdtNatData[
                I14,
                AdtNatData[
                  I13,
                  AdtNatData[
                    I12,
                    AdtNatData[
                      I11,
                      AdtNatData[I10, AdtNatData[I9, AdtNatData[I8, AdtNatData[
                        I7,
                        AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]
                      ]]]]
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

  type Options19[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] = TypeAdtApply[
    A,
    AdtNatData[
      I19,
      AdtNatData[
        I18,
        AdtNatData[
          I17,
          AdtNatData[
            I16,
            AdtNatData[
              I15,
              AdtNatData[
                I14,
                AdtNatData[
                  I13,
                  AdtNatData[
                    I12,
                    AdtNatData[
                      I11,
                      AdtNatData[I10, AdtNatData[I9, AdtNatData[I8, AdtNatData[
                        I7,
                        AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]
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
    ADTStatus.Passed
  ]
  type OptionsX19[A, Status <: ADTStatus.Passed, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] =
    TypeAdtApply[
      A,
      AdtNatData[
        I19,
        AdtNatData[
          I18,
          AdtNatData[
            I17,
            AdtNatData[
              I16,
              AdtNatData[
                I15,
                AdtNatData[
                  I14,
                  AdtNatData[
                    I13,
                    AdtNatData[
                      I12,
                      AdtNatData[
                        I11,
                        AdtNatData[I10, AdtNatData[I9, AdtNatData[I8, AdtNatData[
                          I7,
                          AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]
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
      Status
    ]

  type Options20[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] = TypeAdtApply[
    A,
    AdtNatData[
      I20,
      AdtNatData[
        I19,
        AdtNatData[
          I18,
          AdtNatData[
            I17,
            AdtNatData[
              I16,
              AdtNatData[
                I15,
                AdtNatData[
                  I14,
                  AdtNatData[
                    I13,
                    AdtNatData[
                      I12,
                      AdtNatData[
                        I11,
                        AdtNatData[I10, AdtNatData[I9, AdtNatData[I8, AdtNatData[
                          I7,
                          AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]
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
    ADTStatus.Passed
  ]
  type OptionsX20[
    A,
    Status <: ADTStatus.Passed,
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
    I20
  ] = TypeAdtApply[
    A,
    AdtNatData[
      I20,
      AdtNatData[
        I19,
        AdtNatData[
          I18,
          AdtNatData[
            I17,
            AdtNatData[
              I16,
              AdtNatData[
                I15,
                AdtNatData[
                  I14,
                  AdtNatData[
                    I13,
                    AdtNatData[
                      I12,
                      AdtNatData[
                        I11,
                        AdtNatData[I10, AdtNatData[I9, AdtNatData[I8, AdtNatData[
                          I7,
                          AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]
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
    Status
  ]

  type Options21[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] = TypeAdtApply[
    A,
    AdtNatData[
      I21,
      AdtNatData[
        I20,
        AdtNatData[
          I19,
          AdtNatData[
            I18,
            AdtNatData[
              I17,
              AdtNatData[
                I16,
                AdtNatData[
                  I15,
                  AdtNatData[
                    I14,
                    AdtNatData[
                      I13,
                      AdtNatData[
                        I12,
                        AdtNatData[
                          I11,
                          AdtNatData[I10, AdtNatData[I9, AdtNatData[I8, AdtNatData[
                            I7,
                            AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]
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
    ADTStatus.Passed
  ]
  type OptionsX21[
    A,
    Status <: ADTStatus.Passed,
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
    I21
  ] = TypeAdtApply[
    A,
    AdtNatData[
      I21,
      AdtNatData[
        I20,
        AdtNatData[
          I19,
          AdtNatData[
            I18,
            AdtNatData[
              I17,
              AdtNatData[
                I16,
                AdtNatData[
                  I15,
                  AdtNatData[
                    I14,
                    AdtNatData[
                      I13,
                      AdtNatData[
                        I12,
                        AdtNatData[
                          I11,
                          AdtNatData[I10, AdtNatData[I9, AdtNatData[I8, AdtNatData[
                            I7,
                            AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]
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
    Status
  ]

  type Options22[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22] = TypeAdtApply[
    A,
    AdtNatData[
      I22,
      AdtNatData[
        I21,
        AdtNatData[
          I20,
          AdtNatData[
            I19,
            AdtNatData[
              I18,
              AdtNatData[
                I17,
                AdtNatData[
                  I16,
                  AdtNatData[
                    I15,
                    AdtNatData[
                      I14,
                      AdtNatData[
                        I13,
                        AdtNatData[
                          I12,
                          AdtNatData[
                            I11,
                            AdtNatData[I10, AdtNatData[I9, AdtNatData[I8, AdtNatData[
                              I7,
                              AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]
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
    ADTStatus.Passed
  ]
  type OptionsX22[
    A,
    Status <: ADTStatus.Passed,
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
  ] = TypeAdtApply[
    A,
    AdtNatData[
      I22,
      AdtNatData[
        I21,
        AdtNatData[
          I20,
          AdtNatData[
            I19,
            AdtNatData[
              I18,
              AdtNatData[
                I17,
                AdtNatData[
                  I16,
                  AdtNatData[
                    I15,
                    AdtNatData[
                      I14,
                      AdtNatData[
                        I13,
                        AdtNatData[
                          I12,
                          AdtNatData[
                            I11,
                            AdtNatData[I10, AdtNatData[I9, AdtNatData[I8, AdtNatData[
                              I7,
                              AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]
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
    Status
  ]

}

object TypeAdtAlias extends TypeAdtAlias with TypeAdtAliasModel with TypeAdtAliasModelUnapply
