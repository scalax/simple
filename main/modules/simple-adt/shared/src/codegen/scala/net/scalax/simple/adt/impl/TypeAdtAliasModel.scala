package net.scalax.simple
package adt
package impl

import temp._
import Adt.{Status => ADTStatus}

trait TypeAdtAliasModel {

  type Option1[
    I1
  ] = ADTData[AdtNatPositive[I1, AdtNatZero], ADTStatus.Passed]
  type OptionX1[ST <: ADTStatus, I1] = ADTData[AdtNatPositive[I1, AdtNatZero], ST]

  type Option2[
    I1,
    I2
  ] = ADTData[AdtNatPositive[I1, AdtNatPositive[I2, AdtNatZero]], ADTStatus.Passed]
  type OptionX2[ST <: ADTStatus, I1, I2] = ADTData[AdtNatPositive[I1, AdtNatPositive[I2, AdtNatZero]], ST]

  type Option3[
    I1,
    I2,
    I3
  ] = ADTData[AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatZero]]], ADTStatus.Passed]
  type OptionX3[ST <: ADTStatus, I1, I2, I3] = ADTData[AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatZero]]], ST]

  type Option4[
    I1,
    I2,
    I3,
    I4
  ] = ADTData[AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatZero]]]], ADTStatus.Passed]
  type OptionX4[ST <: ADTStatus, I1, I2, I3, I4] =
    ADTData[AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatZero]]]], ST]

  type Option5[
    I1,
    I2,
    I3,
    I4,
    I5
  ] = ADTData[
    AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatZero]]]]],
    ADTStatus.Passed
  ]
  type OptionX5[ST <: ADTStatus, I1, I2, I3, I4, I5] =
    ADTData[AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatZero]]]]], ST]

  type Option6[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6
  ] = ADTData[
    AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatZero]]]]]],
    ADTStatus.Passed
  ]
  type OptionX6[ST <: ADTStatus, I1, I2, I3, I4, I5, I6] = ADTData[
    AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatZero]]]]]],
    ST
  ]

  type Option7[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6,
    I7
  ] = ADTData[
    AdtNatPositive[
      I1,
      AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[I7, AdtNatZero]]]]]]
    ],
    ADTStatus.Passed
  ]
  type OptionX7[ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7] = ADTData[AdtNatPositive[
    I1,
    AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[I7, AdtNatZero]]]]]]
  ], ST]

  type Option8[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6,
    I7,
    I8
  ] = ADTData[
    AdtNatPositive[I1, AdtNatPositive[
      I2,
      AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[I7, AdtNatPositive[I8, AdtNatZero]]]]]]
    ]],
    ADTStatus.Passed
  ]
  type OptionX8[ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8] = ADTData[
    AdtNatPositive[I1, AdtNatPositive[
      I2,
      AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[I7, AdtNatPositive[I8, AdtNatZero]]]]]]
    ]],
    ST
  ]

  type Option9[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6,
    I7,
    I8,
    I9
  ] = ADTData[
    AdtNatPositive[
      I1,
      AdtNatPositive[I2, AdtNatPositive[
        I3,
        AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[I7, AdtNatPositive[I8, AdtNatPositive[I9, AdtNatZero]]]]]]
      ]]
    ],
    ADTStatus.Passed
  ]
  type OptionX9[ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9] = ADTData[
    AdtNatPositive[
      I1,
      AdtNatPositive[I2, AdtNatPositive[
        I3,
        AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[I7, AdtNatPositive[I8, AdtNatPositive[I9, AdtNatZero]]]]]]
      ]]
    ],
    ST
  ]

  type Option10[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6,
    I7,
    I8,
    I9,
    I10
  ] = ADTData[
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
  type OptionX10[ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] = ADTData[
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

  type Option11[
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
    I11
  ] = ADTData[
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
  type OptionX11[ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] = ADTData[
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

  type Option12[
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
    I12
  ] = ADTData[
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
  type OptionX12[ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] = ADTData[
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

  type Option13[
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
    I13
  ] = ADTData[
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
  type OptionX13[ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] = ADTData[
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

  type Option14[
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
    I14
  ] = ADTData[
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
  type OptionX14[ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] = ADTData[
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

  type Option15[
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
    I15
  ] = ADTData[
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
  type OptionX15[ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] = ADTData[
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

  type Option16[
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
    I16
  ] = ADTData[
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
  type OptionX16[ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] = ADTData[
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

  type Option17[
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
    I17
  ] = ADTData[
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
  type OptionX17[ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] = ADTData[
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

  type Option18[
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
    I18
  ] = ADTData[
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
  type OptionX18[ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] = ADTData[
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

  type Option19[
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
    I19
  ] = ADTData[
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
  type OptionX19[ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] = ADTData[
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

  type Option20[
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
  ] = ADTData[
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
  type OptionX20[ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] = ADTData[
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

  type Option21[
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
  ] = ADTData[
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
  type OptionX21[ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] = ADTData[
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

  type Option22[
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
  ] = ADTData[
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
  type OptionX22[ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22] =
    ADTData[
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
