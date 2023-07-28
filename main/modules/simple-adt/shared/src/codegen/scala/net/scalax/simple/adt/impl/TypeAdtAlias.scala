package net.scalax.simple
package adt
package impl

import implemention._
import temp._
import temp.{Status => ADTStatus}

trait TypeAdtAlias {

  type Options1[A, I1]                   = TypeAdtApply[A, AdtNatData[I1, AdtNatZero], ADTStatus.Passed]
  type OptionsX1[A, ST <: ADTStatus, I1] = TypeAdtApply[A, AdtNatData[I1, AdtNatZero], ST]

  type Options2[A, I1, I2]                   = TypeAdtApply[A, AdtNatData[I1, AdtNatData[I2, AdtNatZero]], ADTStatus.Passed]
  type OptionsX2[A, ST <: ADTStatus, I1, I2] = TypeAdtApply[A, AdtNatData[I1, AdtNatData[I2, AdtNatZero]], ST]

  type Options3[A, I1, I2, I3] = TypeAdtApply[A, AdtNatData[I1, AdtNatData[I2, AdtNatData[I3, AdtNatZero]]], ADTStatus.Passed]
  type OptionsX3[A, ST <: ADTStatus, I1, I2, I3] = TypeAdtApply[A, AdtNatData[I1, AdtNatData[I2, AdtNatData[I3, AdtNatZero]]], ST]

  type Options4[A, I1, I2, I3, I4] =
    TypeAdtApply[A, AdtNatData[I1, AdtNatData[I2, AdtNatData[I3, AdtNatData[I4, AdtNatZero]]]], ADTStatus.Passed]
  type OptionsX4[A, ST <: ADTStatus, I1, I2, I3, I4] =
    TypeAdtApply[A, AdtNatData[I1, AdtNatData[I2, AdtNatData[I3, AdtNatData[I4, AdtNatZero]]]], ST]

  type Options5[A, I1, I2, I3, I4, I5] =
    TypeAdtApply[A, AdtNatData[I1, AdtNatData[I2, AdtNatData[I3, AdtNatData[I4, AdtNatData[I5, AdtNatZero]]]]], ADTStatus.Passed]
  type OptionsX5[A, ST <: ADTStatus, I1, I2, I3, I4, I5] =
    TypeAdtApply[A, AdtNatData[I1, AdtNatData[I2, AdtNatData[I3, AdtNatData[I4, AdtNatData[I5, AdtNatZero]]]]], ST]

  type Options6[A, I1, I2, I3, I4, I5, I6] = TypeAdtApply[
    A,
    AdtNatData[I1, AdtNatData[I2, AdtNatData[I3, AdtNatData[I4, AdtNatData[I5, AdtNatData[I6, AdtNatZero]]]]]],
    ADTStatus.Passed
  ]
  type OptionsX6[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6] =
    TypeAdtApply[A, AdtNatData[I1, AdtNatData[I2, AdtNatData[I3, AdtNatData[I4, AdtNatData[I5, AdtNatData[I6, AdtNatZero]]]]]], ST]

  type Options7[A, I1, I2, I3, I4, I5, I6, I7] = TypeAdtApply[
    A,
    AdtNatData[I1, AdtNatData[I2, AdtNatData[I3, AdtNatData[I4, AdtNatData[I5, AdtNatData[I6, AdtNatData[I7, AdtNatZero]]]]]]],
    ADTStatus.Passed
  ]
  type OptionsX7[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7] = TypeAdtApply[
    A,
    AdtNatData[I1, AdtNatData[I2, AdtNatData[I3, AdtNatData[I4, AdtNatData[I5, AdtNatData[I6, AdtNatData[I7, AdtNatZero]]]]]]],
    ST
  ]

  type Options8[A, I1, I2, I3, I4, I5, I6, I7, I8] = TypeAdtApply[A, AdtNatData[
    I1,
    AdtNatData[I2, AdtNatData[I3, AdtNatData[I4, AdtNatData[I5, AdtNatData[I6, AdtNatData[I7, AdtNatData[I8, AdtNatZero]]]]]]]
  ], ADTStatus.Passed]
  type OptionsX8[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8] = TypeAdtApply[A, AdtNatData[
    I1,
    AdtNatData[I2, AdtNatData[I3, AdtNatData[I4, AdtNatData[I5, AdtNatData[I6, AdtNatData[I7, AdtNatData[I8, AdtNatZero]]]]]]]
  ], ST]

  type Options9[A, I1, I2, I3, I4, I5, I6, I7, I8, I9] = TypeAdtApply[
    A,
    AdtNatData[I1, AdtNatData[
      I2,
      AdtNatData[I3, AdtNatData[I4, AdtNatData[I5, AdtNatData[I6, AdtNatData[I7, AdtNatData[I8, AdtNatData[I9, AdtNatZero]]]]]]]
    ]],
    ADTStatus.Passed
  ]
  type OptionsX9[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9] = TypeAdtApply[
    A,
    AdtNatData[I1, AdtNatData[
      I2,
      AdtNatData[I3, AdtNatData[I4, AdtNatData[I5, AdtNatData[I6, AdtNatData[I7, AdtNatData[I8, AdtNatData[I9, AdtNatZero]]]]]]]
    ]],
    ST
  ]

  type Options10[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] = TypeAdtApply[
    A,
    AdtNatData[I1, AdtNatData[I2, AdtNatData[
      I3,
      AdtNatData[I4, AdtNatData[I5, AdtNatData[I6, AdtNatData[I7, AdtNatData[I8, AdtNatData[I9, AdtNatData[I10, AdtNatZero]]]]]]]
    ]]],
    ADTStatus.Passed
  ]
  type OptionsX10[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] = TypeAdtApply[
    A,
    AdtNatData[I1, AdtNatData[I2, AdtNatData[
      I3,
      AdtNatData[I4, AdtNatData[I5, AdtNatData[I6, AdtNatData[I7, AdtNatData[I8, AdtNatData[I9, AdtNatData[I10, AdtNatZero]]]]]]]
    ]]],
    ST
  ]

  type Options11[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] = TypeAdtApply[
    A,
    AdtNatData[
      I1,
      AdtNatData[
        I2,
        AdtNatData[I3, AdtNatData[
          I4,
          AdtNatData[I5, AdtNatData[I6, AdtNatData[I7, AdtNatData[I8, AdtNatData[I9, AdtNatData[I10, AdtNatData[I11, AdtNatZero]]]]]]]
        ]]
      ]
    ],
    ADTStatus.Passed
  ]
  type OptionsX11[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] = TypeAdtApply[
    A,
    AdtNatData[
      I1,
      AdtNatData[
        I2,
        AdtNatData[I3, AdtNatData[
          I4,
          AdtNatData[I5, AdtNatData[I6, AdtNatData[I7, AdtNatData[I8, AdtNatData[I9, AdtNatData[I10, AdtNatData[I11, AdtNatZero]]]]]]]
        ]]
      ]
    ],
    ST
  ]

  type Options12[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] = TypeAdtApply[
    A,
    AdtNatData[
      I1,
      AdtNatData[
        I2,
        AdtNatData[
          I3,
          AdtNatData[I4, AdtNatData[
            I5,
            AdtNatData[I6, AdtNatData[I7, AdtNatData[I8, AdtNatData[I9, AdtNatData[I10, AdtNatData[I11, AdtNatData[I12, AdtNatZero]]]]]]]
          ]]
        ]
      ]
    ],
    ADTStatus.Passed
  ]
  type OptionsX12[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] = TypeAdtApply[
    A,
    AdtNatData[
      I1,
      AdtNatData[
        I2,
        AdtNatData[
          I3,
          AdtNatData[I4, AdtNatData[
            I5,
            AdtNatData[I6, AdtNatData[I7, AdtNatData[I8, AdtNatData[I9, AdtNatData[I10, AdtNatData[I11, AdtNatData[I12, AdtNatZero]]]]]]]
          ]]
        ]
      ]
    ],
    ST
  ]

  type Options13[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] = TypeAdtApply[
    A,
    AdtNatData[
      I1,
      AdtNatData[
        I2,
        AdtNatData[
          I3,
          AdtNatData[
            I4,
            AdtNatData[I5, AdtNatData[
              I6,
              AdtNatData[I7, AdtNatData[I8, AdtNatData[I9, AdtNatData[I10, AdtNatData[I11, AdtNatData[I12, AdtNatData[I13, AdtNatZero]]]]]]]
            ]]
          ]
        ]
      ]
    ],
    ADTStatus.Passed
  ]
  type OptionsX13[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] = TypeAdtApply[
    A,
    AdtNatData[
      I1,
      AdtNatData[
        I2,
        AdtNatData[
          I3,
          AdtNatData[
            I4,
            AdtNatData[I5, AdtNatData[
              I6,
              AdtNatData[I7, AdtNatData[I8, AdtNatData[I9, AdtNatData[I10, AdtNatData[I11, AdtNatData[I12, AdtNatData[I13, AdtNatZero]]]]]]]
            ]]
          ]
        ]
      ]
    ],
    ST
  ]

  type Options14[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] = TypeAdtApply[
    A,
    AdtNatData[
      I1,
      AdtNatData[
        I2,
        AdtNatData[
          I3,
          AdtNatData[
            I4,
            AdtNatData[
              I5,
              AdtNatData[I6, AdtNatData[I7, AdtNatData[
                I8,
                AdtNatData[I9, AdtNatData[I10, AdtNatData[I11, AdtNatData[I12, AdtNatData[I13, AdtNatData[I14, AdtNatZero]]]]]]
              ]]]
            ]
          ]
        ]
      ]
    ],
    ADTStatus.Passed
  ]
  type OptionsX14[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] = TypeAdtApply[
    A,
    AdtNatData[
      I1,
      AdtNatData[
        I2,
        AdtNatData[
          I3,
          AdtNatData[
            I4,
            AdtNatData[
              I5,
              AdtNatData[I6, AdtNatData[I7, AdtNatData[
                I8,
                AdtNatData[I9, AdtNatData[I10, AdtNatData[I11, AdtNatData[I12, AdtNatData[I13, AdtNatData[I14, AdtNatZero]]]]]]
              ]]]
            ]
          ]
        ]
      ]
    ],
    ST
  ]

  type Options15[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] = TypeAdtApply[
    A,
    AdtNatData[
      I1,
      AdtNatData[
        I2,
        AdtNatData[
          I3,
          AdtNatData[
            I4,
            AdtNatData[
              I5,
              AdtNatData[
                I6,
                AdtNatData[I7, AdtNatData[I8, AdtNatData[
                  I9,
                  AdtNatData[I10, AdtNatData[I11, AdtNatData[I12, AdtNatData[I13, AdtNatData[I14, AdtNatData[I15, AdtNatZero]]]]]]
                ]]]
              ]
            ]
          ]
        ]
      ]
    ],
    ADTStatus.Passed
  ]
  type OptionsX15[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] = TypeAdtApply[
    A,
    AdtNatData[
      I1,
      AdtNatData[
        I2,
        AdtNatData[
          I3,
          AdtNatData[
            I4,
            AdtNatData[
              I5,
              AdtNatData[
                I6,
                AdtNatData[I7, AdtNatData[I8, AdtNatData[
                  I9,
                  AdtNatData[I10, AdtNatData[I11, AdtNatData[I12, AdtNatData[I13, AdtNatData[I14, AdtNatData[I15, AdtNatZero]]]]]]
                ]]]
              ]
            ]
          ]
        ]
      ]
    ],
    ST
  ]

  type Options16[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] = TypeAdtApply[
    A,
    AdtNatData[
      I1,
      AdtNatData[
        I2,
        AdtNatData[
          I3,
          AdtNatData[
            I4,
            AdtNatData[
              I5,
              AdtNatData[
                I6,
                AdtNatData[
                  I7,
                  AdtNatData[I8, AdtNatData[I9, AdtNatData[
                    I10,
                    AdtNatData[I11, AdtNatData[I12, AdtNatData[I13, AdtNatData[I14, AdtNatData[I15, AdtNatData[I16, AdtNatZero]]]]]]
                  ]]]
                ]
              ]
            ]
          ]
        ]
      ]
    ],
    ADTStatus.Passed
  ]
  type OptionsX16[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] = TypeAdtApply[
    A,
    AdtNatData[
      I1,
      AdtNatData[
        I2,
        AdtNatData[
          I3,
          AdtNatData[
            I4,
            AdtNatData[
              I5,
              AdtNatData[
                I6,
                AdtNatData[
                  I7,
                  AdtNatData[I8, AdtNatData[I9, AdtNatData[
                    I10,
                    AdtNatData[I11, AdtNatData[I12, AdtNatData[I13, AdtNatData[I14, AdtNatData[I15, AdtNatData[I16, AdtNatZero]]]]]]
                  ]]]
                ]
              ]
            ]
          ]
        ]
      ]
    ],
    ST
  ]

  type Options17[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] = TypeAdtApply[
    A,
    AdtNatData[
      I1,
      AdtNatData[
        I2,
        AdtNatData[
          I3,
          AdtNatData[
            I4,
            AdtNatData[
              I5,
              AdtNatData[
                I6,
                AdtNatData[
                  I7,
                  AdtNatData[
                    I8,
                    AdtNatData[I9, AdtNatData[I10, AdtNatData[
                      I11,
                      AdtNatData[I12, AdtNatData[I13, AdtNatData[I14, AdtNatData[I15, AdtNatData[I16, AdtNatData[I17, AdtNatZero]]]]]]
                    ]]]
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
  type OptionsX17[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] = TypeAdtApply[
    A,
    AdtNatData[
      I1,
      AdtNatData[
        I2,
        AdtNatData[
          I3,
          AdtNatData[
            I4,
            AdtNatData[
              I5,
              AdtNatData[
                I6,
                AdtNatData[
                  I7,
                  AdtNatData[
                    I8,
                    AdtNatData[I9, AdtNatData[I10, AdtNatData[
                      I11,
                      AdtNatData[I12, AdtNatData[I13, AdtNatData[I14, AdtNatData[I15, AdtNatData[I16, AdtNatData[I17, AdtNatZero]]]]]]
                    ]]]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    ],
    ST
  ]

  type Options18[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] = TypeAdtApply[
    A,
    AdtNatData[
      I1,
      AdtNatData[
        I2,
        AdtNatData[
          I3,
          AdtNatData[
            I4,
            AdtNatData[
              I5,
              AdtNatData[
                I6,
                AdtNatData[
                  I7,
                  AdtNatData[
                    I8,
                    AdtNatData[
                      I9,
                      AdtNatData[I10, AdtNatData[I11, AdtNatData[
                        I12,
                        AdtNatData[I13, AdtNatData[I14, AdtNatData[I15, AdtNatData[I16, AdtNatData[I17, AdtNatData[I18, AdtNatZero]]]]]]
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
    ADTStatus.Passed
  ]
  type OptionsX18[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] = TypeAdtApply[
    A,
    AdtNatData[
      I1,
      AdtNatData[
        I2,
        AdtNatData[
          I3,
          AdtNatData[
            I4,
            AdtNatData[
              I5,
              AdtNatData[
                I6,
                AdtNatData[
                  I7,
                  AdtNatData[
                    I8,
                    AdtNatData[
                      I9,
                      AdtNatData[I10, AdtNatData[I11, AdtNatData[
                        I12,
                        AdtNatData[I13, AdtNatData[I14, AdtNatData[I15, AdtNatData[I16, AdtNatData[I17, AdtNatData[I18, AdtNatZero]]]]]]
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
    ST
  ]

  type Options19[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] = TypeAdtApply[
    A,
    AdtNatData[
      I1,
      AdtNatData[
        I2,
        AdtNatData[
          I3,
          AdtNatData[
            I4,
            AdtNatData[
              I5,
              AdtNatData[
                I6,
                AdtNatData[
                  I7,
                  AdtNatData[
                    I8,
                    AdtNatData[
                      I9,
                      AdtNatData[
                        I10,
                        AdtNatData[I11, AdtNatData[I12, AdtNatData[
                          I13,
                          AdtNatData[I14, AdtNatData[I15, AdtNatData[I16, AdtNatData[I17, AdtNatData[I18, AdtNatData[I19, AdtNatZero]]]]]]
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
    ADTStatus.Passed
  ]
  type OptionsX19[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] = TypeAdtApply[
    A,
    AdtNatData[
      I1,
      AdtNatData[
        I2,
        AdtNatData[
          I3,
          AdtNatData[
            I4,
            AdtNatData[
              I5,
              AdtNatData[
                I6,
                AdtNatData[
                  I7,
                  AdtNatData[
                    I8,
                    AdtNatData[
                      I9,
                      AdtNatData[
                        I10,
                        AdtNatData[I11, AdtNatData[I12, AdtNatData[
                          I13,
                          AdtNatData[I14, AdtNatData[I15, AdtNatData[I16, AdtNatData[I17, AdtNatData[I18, AdtNatData[I19, AdtNatZero]]]]]]
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
    ST
  ]

  type Options20[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] = TypeAdtApply[
    A,
    AdtNatData[
      I1,
      AdtNatData[
        I2,
        AdtNatData[
          I3,
          AdtNatData[
            I4,
            AdtNatData[
              I5,
              AdtNatData[
                I6,
                AdtNatData[
                  I7,
                  AdtNatData[
                    I8,
                    AdtNatData[
                      I9,
                      AdtNatData[
                        I10,
                        AdtNatData[
                          I11,
                          AdtNatData[I12, AdtNatData[I13, AdtNatData[
                            I14,
                            AdtNatData[I15, AdtNatData[I16, AdtNatData[I17, AdtNatData[I18, AdtNatData[I19, AdtNatData[I20, AdtNatZero]]]]]]
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
    ADTStatus.Passed
  ]
  type OptionsX20[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] =
    TypeAdtApply[
      A,
      AdtNatData[
        I1,
        AdtNatData[
          I2,
          AdtNatData[
            I3,
            AdtNatData[
              I4,
              AdtNatData[
                I5,
                AdtNatData[
                  I6,
                  AdtNatData[
                    I7,
                    AdtNatData[
                      I8,
                      AdtNatData[
                        I9,
                        AdtNatData[
                          I10,
                          AdtNatData[
                            I11,
                            AdtNatData[I12, AdtNatData[I13, AdtNatData[I14, AdtNatData[
                              I15,
                              AdtNatData[I16, AdtNatData[I17, AdtNatData[I18, AdtNatData[I19, AdtNatData[I20, AdtNatZero]]]]]
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
      ST
    ]

  type Options21[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] = TypeAdtApply[
    A,
    AdtNatData[
      I1,
      AdtNatData[
        I2,
        AdtNatData[
          I3,
          AdtNatData[
            I4,
            AdtNatData[
              I5,
              AdtNatData[
                I6,
                AdtNatData[
                  I7,
                  AdtNatData[
                    I8,
                    AdtNatData[
                      I9,
                      AdtNatData[
                        I10,
                        AdtNatData[
                          I11,
                          AdtNatData[
                            I12,
                            AdtNatData[I13, AdtNatData[I14, AdtNatData[I15, AdtNatData[
                              I16,
                              AdtNatData[I17, AdtNatData[I18, AdtNatData[I19, AdtNatData[I20, AdtNatData[I21, AdtNatZero]]]]]
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
  type OptionsX21[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] =
    TypeAdtApply[
      A,
      AdtNatData[
        I1,
        AdtNatData[
          I2,
          AdtNatData[
            I3,
            AdtNatData[
              I4,
              AdtNatData[
                I5,
                AdtNatData[
                  I6,
                  AdtNatData[
                    I7,
                    AdtNatData[
                      I8,
                      AdtNatData[
                        I9,
                        AdtNatData[
                          I10,
                          AdtNatData[
                            I11,
                            AdtNatData[
                              I12,
                              AdtNatData[I13, AdtNatData[I14, AdtNatData[I15, AdtNatData[
                                I16,
                                AdtNatData[I17, AdtNatData[I18, AdtNatData[I19, AdtNatData[I20, AdtNatData[I21, AdtNatZero]]]]]
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
      ST
    ]

  type Options22[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22] = TypeAdtApply[
    A,
    AdtNatData[
      I1,
      AdtNatData[
        I2,
        AdtNatData[
          I3,
          AdtNatData[
            I4,
            AdtNatData[
              I5,
              AdtNatData[
                I6,
                AdtNatData[
                  I7,
                  AdtNatData[
                    I8,
                    AdtNatData[
                      I9,
                      AdtNatData[
                        I10,
                        AdtNatData[
                          I11,
                          AdtNatData[
                            I12,
                            AdtNatData[
                              I13,
                              AdtNatData[I14, AdtNatData[I15, AdtNatData[I16, AdtNatData[
                                I17,
                                AdtNatData[I18, AdtNatData[I19, AdtNatData[I20, AdtNatData[I21, AdtNatData[I22, AdtNatZero]]]]]
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
    ADTStatus.Passed
  ]
  type OptionsX22[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22] =
    TypeAdtApply[
      A,
      AdtNatData[
        I1,
        AdtNatData[
          I2,
          AdtNatData[
            I3,
            AdtNatData[
              I4,
              AdtNatData[
                I5,
                AdtNatData[
                  I6,
                  AdtNatData[
                    I7,
                    AdtNatData[
                      I8,
                      AdtNatData[
                        I9,
                        AdtNatData[
                          I10,
                          AdtNatData[
                            I11,
                            AdtNatData[
                              I12,
                              AdtNatData[
                                I13,
                                AdtNatData[I14, AdtNatData[I15, AdtNatData[I16, AdtNatData[
                                  I17,
                                  AdtNatData[I18, AdtNatData[I19, AdtNatData[I20, AdtNatData[I21, AdtNatData[I22, AdtNatZero]]]]]
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
      ST
    ]

}

object TypeAdtAlias extends TypeAdtAlias with TypeAdtAliasModel with TypeAdtAliasModelUnapply
