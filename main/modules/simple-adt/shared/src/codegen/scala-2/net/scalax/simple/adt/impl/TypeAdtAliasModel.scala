package net.scalax.simple
package adt
package impl

import temp._
import temp.{Status => ADTStatus}

trait TypeAdtAliasModel {

  type Option1[
    I1
  ] = ADTData[AdtNatData[I1, AdtNatZero], ADTStatus.Passed]

  type Option2[
    I1,
    I2
  ] = ADTData[AdtNatData[I2, AdtNatData[I1, AdtNatZero]], ADTStatus.Passed]

  type Option3[
    I1,
    I2,
    I3
  ] = ADTData[AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]], ADTStatus.Passed]

  type Option4[
    I1,
    I2,
    I3,
    I4
  ] = ADTData[AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]], ADTStatus.Passed]

  type Option5[
    I1,
    I2,
    I3,
    I4,
    I5
  ] = ADTData[AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]], ADTStatus.Passed]

  type Option6[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6
  ] = ADTData[AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]], ADTStatus.Passed]

  type Option7[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6,
    I7
  ] = ADTData[
    AdtNatData[I7, AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]],
    ADTStatus.Passed
  ]

  type Option8[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6,
    I7,
    I8
  ] = ADTData[AdtNatData[
    I8,
    AdtNatData[I7, AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]]
  ], ADTStatus.Passed]

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
    AdtNatData[I9, AdtNatData[
      I8,
      AdtNatData[I7, AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]]
    ]],
    ADTStatus.Passed
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
    AdtNatData[I10, AdtNatData[I9, AdtNatData[
      I8,
      AdtNatData[I7, AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]]
    ]]],
    ADTStatus.Passed
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
    AdtNatData[
      I11,
      AdtNatData[I10, AdtNatData[I9, AdtNatData[
        I8,
        AdtNatData[I7, AdtNatData[I6, AdtNatData[I5, AdtNatData[I4, AdtNatData[I3, AdtNatData[I2, AdtNatData[I1, AdtNatZero]]]]]]]
      ]]]
    ],
    ADTStatus.Passed
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

}
