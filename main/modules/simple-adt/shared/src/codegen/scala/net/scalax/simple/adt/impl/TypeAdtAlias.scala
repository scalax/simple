package net.scalax.simple
package adt
package impl

import implemention._
import temp._
import Adt.{Status => ADTStatus}
import net.scalax.simple.adt.nat.{AdtNat, AdtNatPositive, AdtNatZero}

trait TypeAdtAlias {

  type CoProducts1[A, I1]                   = TypeAdtApply[A, AdtNatPositive[I1, AdtNatZero], ADTStatus.Passed]
  type CoProductsX1[A, ST <: ADTStatus, I1] = TypeAdtApply[A, AdtNatPositive[I1, AdtNatZero], ST]

  type CoProducts2[A, I1, I2]                   = TypeAdtApply[A, AdtNatPositive[I1, AdtNatPositive[I2, AdtNatZero]], ADTStatus.Passed]
  type CoProductsX2[A, ST <: ADTStatus, I1, I2] = TypeAdtApply[A, AdtNatPositive[I1, AdtNatPositive[I2, AdtNatZero]], ST]

  type CoProducts3[A, I1, I2, I3] =
    TypeAdtApply[A, AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatZero]]], ADTStatus.Passed]
  type CoProductsX3[A, ST <: ADTStatus, I1, I2, I3] =
    TypeAdtApply[A, AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatZero]]], ST]

  type CoProducts4[A, I1, I2, I3, I4] =
    TypeAdtApply[A, AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatZero]]]], ADTStatus.Passed]
  type CoProductsX4[A, ST <: ADTStatus, I1, I2, I3, I4] =
    TypeAdtApply[A, AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatZero]]]], ST]

  type CoProducts5[A, I1, I2, I3, I4, I5] = TypeAdtApply[
    A,
    AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatZero]]]]],
    ADTStatus.Passed
  ]
  type CoProductsX5[A, ST <: ADTStatus, I1, I2, I3, I4, I5] =
    TypeAdtApply[A, AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatZero]]]]], ST]

  type CoProducts6[A, I1, I2, I3, I4, I5, I6] = TypeAdtApply[
    A,
    AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatZero]]]]]],
    ADTStatus.Passed
  ]
  type CoProductsX6[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6] = TypeAdtApply[
    A,
    AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatZero]]]]]],
    ST
  ]

  type CoProducts7[A, I1, I2, I3, I4, I5, I6, I7] = TypeAdtApply[
    A,
    AdtNatPositive[
      I1,
      AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[I7, AdtNatZero]]]]]]
    ],
    ADTStatus.Passed
  ]
  type CoProductsX7[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7] = TypeAdtApply[A, AdtNatPositive[
    I1,
    AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[I7, AdtNatZero]]]]]]
  ], ST]

  type CoProducts8[A, I1, I2, I3, I4, I5, I6, I7, I8] = TypeAdtApply[
    A,
    AdtNatPositive[I1, AdtNatPositive[
      I2,
      AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[I7, AdtNatPositive[I8, AdtNatZero]]]]]]
    ]],
    ADTStatus.Passed
  ]
  type CoProductsX8[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8] = TypeAdtApply[
    A,
    AdtNatPositive[I1, AdtNatPositive[
      I2,
      AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[I7, AdtNatPositive[I8, AdtNatZero]]]]]]
    ]],
    ST
  ]

  type CoProducts9[A, I1, I2, I3, I4, I5, I6, I7, I8, I9] = TypeAdtApply[
    A,
    AdtNatPositive[
      I1,
      AdtNatPositive[I2, AdtNatPositive[
        I3,
        AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[I7, AdtNatPositive[I8, AdtNatPositive[I9, AdtNatZero]]]]]]
      ]]
    ],
    ADTStatus.Passed
  ]
  type CoProductsX9[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9] = TypeAdtApply[
    A,
    AdtNatPositive[
      I1,
      AdtNatPositive[I2, AdtNatPositive[
        I3,
        AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[I7, AdtNatPositive[I8, AdtNatPositive[I9, AdtNatZero]]]]]]
      ]]
    ],
    ST
  ]

  type CoProducts10[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] = TypeAdtApply[
    A,
    AdtNatPositive[
      I1,
      AdtNatPositive[
        I2,
        AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[
          I5,
          AdtNatPositive[I6, AdtNatPositive[I7, AdtNatPositive[I8, AdtNatPositive[I9, AdtNatPositive[I10, AdtNatZero]]]]]
        ]]]
      ]
    ],
    ADTStatus.Passed
  ]
  type CoProductsX10[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] = TypeAdtApply[
    A,
    AdtNatPositive[
      I1,
      AdtNatPositive[
        I2,
        AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[
          I5,
          AdtNatPositive[I6, AdtNatPositive[I7, AdtNatPositive[I8, AdtNatPositive[I9, AdtNatPositive[I10, AdtNatZero]]]]]
        ]]]
      ]
    ],
    ST
  ]

  type CoProducts11[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] = TypeAdtApply[
    A,
    AdtNatPositive[
      I1,
      AdtNatPositive[
        I2,
        AdtNatPositive[
          I3,
          AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[
            I6,
            AdtNatPositive[I7, AdtNatPositive[I8, AdtNatPositive[I9, AdtNatPositive[I10, AdtNatPositive[I11, AdtNatZero]]]]]
          ]]]
        ]
      ]
    ],
    ADTStatus.Passed
  ]
  type CoProductsX11[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] = TypeAdtApply[
    A,
    AdtNatPositive[
      I1,
      AdtNatPositive[
        I2,
        AdtNatPositive[
          I3,
          AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[
            I6,
            AdtNatPositive[I7, AdtNatPositive[I8, AdtNatPositive[I9, AdtNatPositive[I10, AdtNatPositive[I11, AdtNatZero]]]]]
          ]]]
        ]
      ]
    ],
    ST
  ]

  type CoProducts12[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] = TypeAdtApply[
    A,
    AdtNatPositive[
      I1,
      AdtNatPositive[
        I2,
        AdtNatPositive[
          I3,
          AdtNatPositive[
            I4,
            AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[
              I7,
              AdtNatPositive[I8, AdtNatPositive[I9, AdtNatPositive[I10, AdtNatPositive[I11, AdtNatPositive[I12, AdtNatZero]]]]]
            ]]]
          ]
        ]
      ]
    ],
    ADTStatus.Passed
  ]
  type CoProductsX12[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] = TypeAdtApply[
    A,
    AdtNatPositive[
      I1,
      AdtNatPositive[
        I2,
        AdtNatPositive[
          I3,
          AdtNatPositive[
            I4,
            AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[
              I7,
              AdtNatPositive[I8, AdtNatPositive[I9, AdtNatPositive[I10, AdtNatPositive[I11, AdtNatPositive[I12, AdtNatZero]]]]]
            ]]]
          ]
        ]
      ]
    ],
    ST
  ]

  type CoProducts13[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] = TypeAdtApply[
    A,
    AdtNatPositive[
      I1,
      AdtNatPositive[
        I2,
        AdtNatPositive[
          I3,
          AdtNatPositive[
            I4,
            AdtNatPositive[
              I5,
              AdtNatPositive[
                I6,
                AdtNatPositive[I7, AdtNatPositive[
                  I8,
                  AdtNatPositive[I9, AdtNatPositive[I10, AdtNatPositive[I11, AdtNatPositive[I12, AdtNatPositive[I13, AdtNatZero]]]]]
                ]]
              ]
            ]
          ]
        ]
      ]
    ],
    ADTStatus.Passed
  ]
  type CoProductsX13[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] = TypeAdtApply[
    A,
    AdtNatPositive[
      I1,
      AdtNatPositive[
        I2,
        AdtNatPositive[
          I3,
          AdtNatPositive[
            I4,
            AdtNatPositive[
              I5,
              AdtNatPositive[
                I6,
                AdtNatPositive[I7, AdtNatPositive[
                  I8,
                  AdtNatPositive[I9, AdtNatPositive[I10, AdtNatPositive[I11, AdtNatPositive[I12, AdtNatPositive[I13, AdtNatZero]]]]]
                ]]
              ]
            ]
          ]
        ]
      ]
    ],
    ST
  ]

  type CoProducts14[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] = TypeAdtApply[
    A,
    AdtNatPositive[
      I1,
      AdtNatPositive[
        I2,
        AdtNatPositive[
          I3,
          AdtNatPositive[
            I4,
            AdtNatPositive[
              I5,
              AdtNatPositive[
                I6,
                AdtNatPositive[
                  I7,
                  AdtNatPositive[I8, AdtNatPositive[
                    I9,
                    AdtNatPositive[I10, AdtNatPositive[I11, AdtNatPositive[I12, AdtNatPositive[I13, AdtNatPositive[I14, AdtNatZero]]]]]
                  ]]
                ]
              ]
            ]
          ]
        ]
      ]
    ],
    ADTStatus.Passed
  ]
  type CoProductsX14[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] = TypeAdtApply[
    A,
    AdtNatPositive[
      I1,
      AdtNatPositive[
        I2,
        AdtNatPositive[
          I3,
          AdtNatPositive[
            I4,
            AdtNatPositive[
              I5,
              AdtNatPositive[
                I6,
                AdtNatPositive[
                  I7,
                  AdtNatPositive[I8, AdtNatPositive[
                    I9,
                    AdtNatPositive[I10, AdtNatPositive[I11, AdtNatPositive[I12, AdtNatPositive[I13, AdtNatPositive[I14, AdtNatZero]]]]]
                  ]]
                ]
              ]
            ]
          ]
        ]
      ]
    ],
    ST
  ]

  type CoProducts15[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] = TypeAdtApply[
    A,
    AdtNatPositive[
      I1,
      AdtNatPositive[
        I2,
        AdtNatPositive[
          I3,
          AdtNatPositive[
            I4,
            AdtNatPositive[
              I5,
              AdtNatPositive[
                I6,
                AdtNatPositive[
                  I7,
                  AdtNatPositive[
                    I8,
                    AdtNatPositive[I9, AdtNatPositive[
                      I10,
                      AdtNatPositive[I11, AdtNatPositive[I12, AdtNatPositive[I13, AdtNatPositive[I14, AdtNatPositive[I15, AdtNatZero]]]]]
                    ]]
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
  type CoProductsX15[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] = TypeAdtApply[
    A,
    AdtNatPositive[
      I1,
      AdtNatPositive[
        I2,
        AdtNatPositive[
          I3,
          AdtNatPositive[
            I4,
            AdtNatPositive[
              I5,
              AdtNatPositive[
                I6,
                AdtNatPositive[
                  I7,
                  AdtNatPositive[
                    I8,
                    AdtNatPositive[I9, AdtNatPositive[
                      I10,
                      AdtNatPositive[I11, AdtNatPositive[I12, AdtNatPositive[I13, AdtNatPositive[I14, AdtNatPositive[I15, AdtNatZero]]]]]
                    ]]
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

  type CoProducts16[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] = TypeAdtApply[
    A,
    AdtNatPositive[
      I1,
      AdtNatPositive[
        I2,
        AdtNatPositive[
          I3,
          AdtNatPositive[
            I4,
            AdtNatPositive[
              I5,
              AdtNatPositive[
                I6,
                AdtNatPositive[
                  I7,
                  AdtNatPositive[
                    I8,
                    AdtNatPositive[
                      I9,
                      AdtNatPositive[I10, AdtNatPositive[
                        I11,
                        AdtNatPositive[I12, AdtNatPositive[I13, AdtNatPositive[I14, AdtNatPositive[I15, AdtNatPositive[I16, AdtNatZero]]]]]
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
    ADTStatus.Passed
  ]
  type CoProductsX16[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] = TypeAdtApply[
    A,
    AdtNatPositive[
      I1,
      AdtNatPositive[
        I2,
        AdtNatPositive[
          I3,
          AdtNatPositive[
            I4,
            AdtNatPositive[
              I5,
              AdtNatPositive[
                I6,
                AdtNatPositive[
                  I7,
                  AdtNatPositive[
                    I8,
                    AdtNatPositive[
                      I9,
                      AdtNatPositive[I10, AdtNatPositive[
                        I11,
                        AdtNatPositive[I12, AdtNatPositive[I13, AdtNatPositive[I14, AdtNatPositive[I15, AdtNatPositive[I16, AdtNatZero]]]]]
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
    ST
  ]

  type CoProducts17[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] = TypeAdtApply[
    A,
    AdtNatPositive[
      I1,
      AdtNatPositive[
        I2,
        AdtNatPositive[
          I3,
          AdtNatPositive[
            I4,
            AdtNatPositive[
              I5,
              AdtNatPositive[
                I6,
                AdtNatPositive[
                  I7,
                  AdtNatPositive[
                    I8,
                    AdtNatPositive[
                      I9,
                      AdtNatPositive[
                        I10,
                        AdtNatPositive[I11, AdtNatPositive[I12, AdtNatPositive[
                          I13,
                          AdtNatPositive[I14, AdtNatPositive[I15, AdtNatPositive[I16, AdtNatPositive[I17, AdtNatZero]]]]
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
  type CoProductsX17[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] = TypeAdtApply[
    A,
    AdtNatPositive[
      I1,
      AdtNatPositive[
        I2,
        AdtNatPositive[
          I3,
          AdtNatPositive[
            I4,
            AdtNatPositive[
              I5,
              AdtNatPositive[
                I6,
                AdtNatPositive[
                  I7,
                  AdtNatPositive[
                    I8,
                    AdtNatPositive[
                      I9,
                      AdtNatPositive[
                        I10,
                        AdtNatPositive[I11, AdtNatPositive[I12, AdtNatPositive[
                          I13,
                          AdtNatPositive[I14, AdtNatPositive[I15, AdtNatPositive[I16, AdtNatPositive[I17, AdtNatZero]]]]
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

  type CoProducts18[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] = TypeAdtApply[
    A,
    AdtNatPositive[
      I1,
      AdtNatPositive[
        I2,
        AdtNatPositive[
          I3,
          AdtNatPositive[
            I4,
            AdtNatPositive[
              I5,
              AdtNatPositive[
                I6,
                AdtNatPositive[
                  I7,
                  AdtNatPositive[
                    I8,
                    AdtNatPositive[
                      I9,
                      AdtNatPositive[
                        I10,
                        AdtNatPositive[
                          I11,
                          AdtNatPositive[I12, AdtNatPositive[I13, AdtNatPositive[
                            I14,
                            AdtNatPositive[I15, AdtNatPositive[I16, AdtNatPositive[I17, AdtNatPositive[I18, AdtNatZero]]]]
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
  type CoProductsX18[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] = TypeAdtApply[
    A,
    AdtNatPositive[
      I1,
      AdtNatPositive[
        I2,
        AdtNatPositive[
          I3,
          AdtNatPositive[
            I4,
            AdtNatPositive[
              I5,
              AdtNatPositive[
                I6,
                AdtNatPositive[
                  I7,
                  AdtNatPositive[
                    I8,
                    AdtNatPositive[
                      I9,
                      AdtNatPositive[
                        I10,
                        AdtNatPositive[
                          I11,
                          AdtNatPositive[I12, AdtNatPositive[I13, AdtNatPositive[
                            I14,
                            AdtNatPositive[I15, AdtNatPositive[I16, AdtNatPositive[I17, AdtNatPositive[I18, AdtNatZero]]]]
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
    ST
  ]

  type CoProducts19[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] = TypeAdtApply[
    A,
    AdtNatPositive[
      I1,
      AdtNatPositive[
        I2,
        AdtNatPositive[
          I3,
          AdtNatPositive[
            I4,
            AdtNatPositive[
              I5,
              AdtNatPositive[
                I6,
                AdtNatPositive[
                  I7,
                  AdtNatPositive[
                    I8,
                    AdtNatPositive[
                      I9,
                      AdtNatPositive[
                        I10,
                        AdtNatPositive[
                          I11,
                          AdtNatPositive[
                            I12,
                            AdtNatPositive[I13, AdtNatPositive[I14, AdtNatPositive[
                              I15,
                              AdtNatPositive[I16, AdtNatPositive[I17, AdtNatPositive[I18, AdtNatPositive[I19, AdtNatZero]]]]
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
    ADTStatus.Passed
  ]
  type CoProductsX19[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] =
    TypeAdtApply[
      A,
      AdtNatPositive[
        I1,
        AdtNatPositive[
          I2,
          AdtNatPositive[
            I3,
            AdtNatPositive[
              I4,
              AdtNatPositive[
                I5,
                AdtNatPositive[
                  I6,
                  AdtNatPositive[
                    I7,
                    AdtNatPositive[
                      I8,
                      AdtNatPositive[
                        I9,
                        AdtNatPositive[
                          I10,
                          AdtNatPositive[
                            I11,
                            AdtNatPositive[
                              I12,
                              AdtNatPositive[I13, AdtNatPositive[I14, AdtNatPositive[
                                I15,
                                AdtNatPositive[I16, AdtNatPositive[I17, AdtNatPositive[I18, AdtNatPositive[I19, AdtNatZero]]]]
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
      ST
    ]

  type CoProducts20[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] = TypeAdtApply[
    A,
    AdtNatPositive[
      I1,
      AdtNatPositive[
        I2,
        AdtNatPositive[
          I3,
          AdtNatPositive[
            I4,
            AdtNatPositive[
              I5,
              AdtNatPositive[
                I6,
                AdtNatPositive[
                  I7,
                  AdtNatPositive[
                    I8,
                    AdtNatPositive[
                      I9,
                      AdtNatPositive[
                        I10,
                        AdtNatPositive[
                          I11,
                          AdtNatPositive[
                            I12,
                            AdtNatPositive[
                              I13,
                              AdtNatPositive[I14, AdtNatPositive[I15, AdtNatPositive[
                                I16,
                                AdtNatPositive[I17, AdtNatPositive[I18, AdtNatPositive[I19, AdtNatPositive[I20, AdtNatZero]]]]
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
    ADTStatus.Passed
  ]
  type CoProductsX20[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] =
    TypeAdtApply[
      A,
      AdtNatPositive[
        I1,
        AdtNatPositive[
          I2,
          AdtNatPositive[
            I3,
            AdtNatPositive[
              I4,
              AdtNatPositive[
                I5,
                AdtNatPositive[
                  I6,
                  AdtNatPositive[
                    I7,
                    AdtNatPositive[
                      I8,
                      AdtNatPositive[
                        I9,
                        AdtNatPositive[
                          I10,
                          AdtNatPositive[
                            I11,
                            AdtNatPositive[
                              I12,
                              AdtNatPositive[
                                I13,
                                AdtNatPositive[I14, AdtNatPositive[I15, AdtNatPositive[
                                  I16,
                                  AdtNatPositive[I17, AdtNatPositive[I18, AdtNatPositive[I19, AdtNatPositive[I20, AdtNatZero]]]]
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
      ST
    ]

  type CoProducts21[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] = TypeAdtApply[
    A,
    AdtNatPositive[
      I1,
      AdtNatPositive[
        I2,
        AdtNatPositive[
          I3,
          AdtNatPositive[
            I4,
            AdtNatPositive[
              I5,
              AdtNatPositive[
                I6,
                AdtNatPositive[
                  I7,
                  AdtNatPositive[
                    I8,
                    AdtNatPositive[
                      I9,
                      AdtNatPositive[
                        I10,
                        AdtNatPositive[
                          I11,
                          AdtNatPositive[
                            I12,
                            AdtNatPositive[
                              I13,
                              AdtNatPositive[
                                I14,
                                AdtNatPositive[I15, AdtNatPositive[I16, AdtNatPositive[
                                  I17,
                                  AdtNatPositive[I18, AdtNatPositive[I19, AdtNatPositive[I20, AdtNatPositive[I21, AdtNatZero]]]]
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
    ADTStatus.Passed
  ]
  type CoProductsX21[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] =
    TypeAdtApply[
      A,
      AdtNatPositive[
        I1,
        AdtNatPositive[
          I2,
          AdtNatPositive[
            I3,
            AdtNatPositive[
              I4,
              AdtNatPositive[
                I5,
                AdtNatPositive[
                  I6,
                  AdtNatPositive[
                    I7,
                    AdtNatPositive[
                      I8,
                      AdtNatPositive[
                        I9,
                        AdtNatPositive[
                          I10,
                          AdtNatPositive[
                            I11,
                            AdtNatPositive[
                              I12,
                              AdtNatPositive[
                                I13,
                                AdtNatPositive[
                                  I14,
                                  AdtNatPositive[I15, AdtNatPositive[I16, AdtNatPositive[
                                    I17,
                                    AdtNatPositive[I18, AdtNatPositive[I19, AdtNatPositive[I20, AdtNatPositive[I21, AdtNatZero]]]]
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
      ST
    ]

  type CoProducts22[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22] = TypeAdtApply[
    A,
    AdtNatPositive[
      I1,
      AdtNatPositive[
        I2,
        AdtNatPositive[
          I3,
          AdtNatPositive[
            I4,
            AdtNatPositive[
              I5,
              AdtNatPositive[
                I6,
                AdtNatPositive[
                  I7,
                  AdtNatPositive[
                    I8,
                    AdtNatPositive[
                      I9,
                      AdtNatPositive[
                        I10,
                        AdtNatPositive[
                          I11,
                          AdtNatPositive[
                            I12,
                            AdtNatPositive[
                              I13,
                              AdtNatPositive[
                                I14,
                                AdtNatPositive[
                                  I15,
                                  AdtNatPositive[I16, AdtNatPositive[I17, AdtNatPositive[
                                    I18,
                                    AdtNatPositive[I19, AdtNatPositive[I20, AdtNatPositive[I21, AdtNatPositive[I22, AdtNatZero]]]]
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
    ADTStatus.Passed
  ]
  type CoProductsX22[
    A,
    ST <: ADTStatus,
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
    AdtNatPositive[
      I1,
      AdtNatPositive[
        I2,
        AdtNatPositive[
          I3,
          AdtNatPositive[
            I4,
            AdtNatPositive[
              I5,
              AdtNatPositive[
                I6,
                AdtNatPositive[
                  I7,
                  AdtNatPositive[
                    I8,
                    AdtNatPositive[
                      I9,
                      AdtNatPositive[
                        I10,
                        AdtNatPositive[
                          I11,
                          AdtNatPositive[
                            I12,
                            AdtNatPositive[
                              I13,
                              AdtNatPositive[
                                I14,
                                AdtNatPositive[
                                  I15,
                                  AdtNatPositive[I16, AdtNatPositive[I17, AdtNatPositive[
                                    I18,
                                    AdtNatPositive[I19, AdtNatPositive[I20, AdtNatPositive[I21, AdtNatPositive[I22, AdtNatZero]]]]
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
    ST
  ]

}
