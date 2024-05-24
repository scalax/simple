package net.scalax.simple
package adt
package impl

import temp._

trait TypeAdtAliasModel {

  type CoProduct1[
    I1
  ] = ADTData[RuntimeData[I1, RuntimeZero], AdtExtension.Passed.type]
  type CoProductX1[ST <: AdtExtension, I1] = ADTData[RuntimeData[I1, RuntimeZero], ST]

  type CoProduct2[
    I1,
    I2
  ] = ADTData[RuntimeData[I1, RuntimeData[I2, RuntimeZero]], AdtExtension.Passed.type]
  type CoProductX2[ST <: AdtExtension, I1, I2] = ADTData[RuntimeData[I1, RuntimeData[I2, RuntimeZero]], ST]

  type CoProduct3[
    I1,
    I2,
    I3
  ] = ADTData[RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeZero]]], AdtExtension.Passed.type]
  type CoProductX3[ST <: AdtExtension, I1, I2, I3] = ADTData[RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeZero]]], ST]

  type CoProduct4[
    I1,
    I2,
    I3,
    I4
  ] = ADTData[RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeZero]]]], AdtExtension.Passed.type]
  type CoProductX4[ST <: AdtExtension, I1, I2, I3, I4] =
    ADTData[RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeZero]]]], ST]

  type CoProduct5[
    I1,
    I2,
    I3,
    I4,
    I5
  ] = ADTData[RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeZero]]]]], AdtExtension.Passed.type]
  type CoProductX5[ST <: AdtExtension, I1, I2, I3, I4, I5] =
    ADTData[RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeZero]]]]], ST]

  type CoProduct6[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6
  ] = ADTData[
    RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeData[I6, RuntimeZero]]]]]],
    AdtExtension.Passed.type
  ]
  type CoProductX6[ST <: AdtExtension, I1, I2, I3, I4, I5, I6] =
    ADTData[RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeData[I6, RuntimeZero]]]]]], ST]

  type CoProduct7[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6,
    I7
  ] = ADTData[
    RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeData[I6, RuntimeData[I7, RuntimeZero]]]]]]],
    AdtExtension.Passed.type
  ]
  type CoProductX7[ST <: AdtExtension, I1, I2, I3, I4, I5, I6, I7] = ADTData[
    RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeData[I6, RuntimeData[I7, RuntimeZero]]]]]]],
    ST
  ]

  type CoProduct8[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6,
    I7,
    I8
  ] = ADTData[
    RuntimeData[
      I1,
      RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeData[I6, RuntimeData[I7, RuntimeData[I8, RuntimeZero]]]]]]]
    ],
    AdtExtension.Passed.type
  ]
  type CoProductX8[ST <: AdtExtension, I1, I2, I3, I4, I5, I6, I7, I8] = ADTData[RuntimeData[
    I1,
    RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeData[I6, RuntimeData[I7, RuntimeData[I8, RuntimeZero]]]]]]]
  ], ST]

  type CoProduct9[
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
    RuntimeData[I1, RuntimeData[
      I2,
      RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeData[I6, RuntimeData[I7, RuntimeData[I8, RuntimeData[I9, RuntimeZero]]]]]]]
    ]],
    AdtExtension.Passed.type
  ]
  type CoProductX9[ST <: AdtExtension, I1, I2, I3, I4, I5, I6, I7, I8, I9] = ADTData[
    RuntimeData[I1, RuntimeData[
      I2,
      RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeData[I6, RuntimeData[I7, RuntimeData[I8, RuntimeData[I9, RuntimeZero]]]]]]]
    ]],
    ST
  ]

  type CoProduct10[
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
    RuntimeData[
      I1,
      RuntimeData[I2, RuntimeData[
        I3,
        RuntimeData[I4, RuntimeData[I5, RuntimeData[I6, RuntimeData[I7, RuntimeData[I8, RuntimeData[I9, RuntimeData[I10, RuntimeZero]]]]]]]
      ]]
    ],
    AdtExtension.Passed.type
  ]
  type CoProductX10[ST <: AdtExtension, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] = ADTData[
    RuntimeData[
      I1,
      RuntimeData[I2, RuntimeData[
        I3,
        RuntimeData[I4, RuntimeData[I5, RuntimeData[I6, RuntimeData[I7, RuntimeData[I8, RuntimeData[I9, RuntimeData[I10, RuntimeZero]]]]]]]
      ]]
    ],
    ST
  ]

  type CoProduct11[
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
    RuntimeData[
      I1,
      RuntimeData[
        I2,
        RuntimeData[I3, RuntimeData[I4, RuntimeData[
          I5,
          RuntimeData[I6, RuntimeData[I7, RuntimeData[I8, RuntimeData[I9, RuntimeData[I10, RuntimeData[I11, RuntimeZero]]]]]]
        ]]]
      ]
    ],
    AdtExtension.Passed.type
  ]
  type CoProductX11[ST <: AdtExtension, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] = ADTData[
    RuntimeData[
      I1,
      RuntimeData[
        I2,
        RuntimeData[I3, RuntimeData[I4, RuntimeData[
          I5,
          RuntimeData[I6, RuntimeData[I7, RuntimeData[I8, RuntimeData[I9, RuntimeData[I10, RuntimeData[I11, RuntimeZero]]]]]]
        ]]]
      ]
    ],
    ST
  ]

  type CoProduct12[
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
    RuntimeData[
      I1,
      RuntimeData[
        I2,
        RuntimeData[
          I3,
          RuntimeData[I4, RuntimeData[I5, RuntimeData[
            I6,
            RuntimeData[I7, RuntimeData[I8, RuntimeData[I9, RuntimeData[I10, RuntimeData[I11, RuntimeData[I12, RuntimeZero]]]]]]
          ]]]
        ]
      ]
    ],
    AdtExtension.Passed.type
  ]
  type CoProductX12[ST <: AdtExtension, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] = ADTData[
    RuntimeData[
      I1,
      RuntimeData[
        I2,
        RuntimeData[
          I3,
          RuntimeData[I4, RuntimeData[I5, RuntimeData[
            I6,
            RuntimeData[I7, RuntimeData[I8, RuntimeData[I9, RuntimeData[I10, RuntimeData[I11, RuntimeData[I12, RuntimeZero]]]]]]
          ]]]
        ]
      ]
    ],
    ST
  ]

  type CoProduct13[
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
    RuntimeData[
      I1,
      RuntimeData[
        I2,
        RuntimeData[
          I3,
          RuntimeData[
            I4,
            RuntimeData[I5, RuntimeData[I6, RuntimeData[
              I7,
              RuntimeData[I8, RuntimeData[I9, RuntimeData[I10, RuntimeData[I11, RuntimeData[I12, RuntimeData[I13, RuntimeZero]]]]]]
            ]]]
          ]
        ]
      ]
    ],
    AdtExtension.Passed.type
  ]
  type CoProductX13[ST <: AdtExtension, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] = ADTData[
    RuntimeData[
      I1,
      RuntimeData[
        I2,
        RuntimeData[
          I3,
          RuntimeData[
            I4,
            RuntimeData[I5, RuntimeData[I6, RuntimeData[
              I7,
              RuntimeData[I8, RuntimeData[I9, RuntimeData[I10, RuntimeData[I11, RuntimeData[I12, RuntimeData[I13, RuntimeZero]]]]]]
            ]]]
          ]
        ]
      ]
    ],
    ST
  ]

  type CoProduct14[
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
    RuntimeData[
      I1,
      RuntimeData[
        I2,
        RuntimeData[
          I3,
          RuntimeData[
            I4,
            RuntimeData[
              I5,
              RuntimeData[I6, RuntimeData[I7, RuntimeData[
                I8,
                RuntimeData[I9, RuntimeData[I10, RuntimeData[I11, RuntimeData[I12, RuntimeData[I13, RuntimeData[I14, RuntimeZero]]]]]]
              ]]]
            ]
          ]
        ]
      ]
    ],
    AdtExtension.Passed.type
  ]
  type CoProductX14[ST <: AdtExtension, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] = ADTData[
    RuntimeData[
      I1,
      RuntimeData[
        I2,
        RuntimeData[
          I3,
          RuntimeData[
            I4,
            RuntimeData[
              I5,
              RuntimeData[I6, RuntimeData[I7, RuntimeData[
                I8,
                RuntimeData[I9, RuntimeData[I10, RuntimeData[I11, RuntimeData[I12, RuntimeData[I13, RuntimeData[I14, RuntimeZero]]]]]]
              ]]]
            ]
          ]
        ]
      ]
    ],
    ST
  ]

  type CoProduct15[
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
    RuntimeData[
      I1,
      RuntimeData[
        I2,
        RuntimeData[
          I3,
          RuntimeData[
            I4,
            RuntimeData[
              I5,
              RuntimeData[
                I6,
                RuntimeData[I7, RuntimeData[I8, RuntimeData[
                  I9,
                  RuntimeData[I10, RuntimeData[I11, RuntimeData[I12, RuntimeData[I13, RuntimeData[I14, RuntimeData[I15, RuntimeZero]]]]]]
                ]]]
              ]
            ]
          ]
        ]
      ]
    ],
    AdtExtension.Passed.type
  ]
  type CoProductX15[ST <: AdtExtension, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] = ADTData[
    RuntimeData[
      I1,
      RuntimeData[
        I2,
        RuntimeData[
          I3,
          RuntimeData[
            I4,
            RuntimeData[
              I5,
              RuntimeData[
                I6,
                RuntimeData[I7, RuntimeData[I8, RuntimeData[
                  I9,
                  RuntimeData[I10, RuntimeData[I11, RuntimeData[I12, RuntimeData[I13, RuntimeData[I14, RuntimeData[I15, RuntimeZero]]]]]]
                ]]]
              ]
            ]
          ]
        ]
      ]
    ],
    ST
  ]

  type CoProduct16[
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
    RuntimeData[
      I1,
      RuntimeData[
        I2,
        RuntimeData[
          I3,
          RuntimeData[
            I4,
            RuntimeData[
              I5,
              RuntimeData[
                I6,
                RuntimeData[
                  I7,
                  RuntimeData[I8, RuntimeData[I9, RuntimeData[
                    I10,
                    RuntimeData[I11, RuntimeData[I12, RuntimeData[I13, RuntimeData[I14, RuntimeData[I15, RuntimeData[I16, RuntimeZero]]]]]]
                  ]]]
                ]
              ]
            ]
          ]
        ]
      ]
    ],
    AdtExtension.Passed.type
  ]
  type CoProductX16[ST <: AdtExtension, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] = ADTData[
    RuntimeData[
      I1,
      RuntimeData[
        I2,
        RuntimeData[
          I3,
          RuntimeData[
            I4,
            RuntimeData[
              I5,
              RuntimeData[
                I6,
                RuntimeData[
                  I7,
                  RuntimeData[I8, RuntimeData[I9, RuntimeData[
                    I10,
                    RuntimeData[I11, RuntimeData[I12, RuntimeData[I13, RuntimeData[I14, RuntimeData[I15, RuntimeData[I16, RuntimeZero]]]]]]
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

  type CoProduct17[
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
    RuntimeData[
      I1,
      RuntimeData[
        I2,
        RuntimeData[
          I3,
          RuntimeData[
            I4,
            RuntimeData[
              I5,
              RuntimeData[
                I6,
                RuntimeData[
                  I7,
                  RuntimeData[
                    I8,
                    RuntimeData[
                      I9,
                      RuntimeData[I10, RuntimeData[I11, RuntimeData[
                        I12,
                        RuntimeData[I13, RuntimeData[I14, RuntimeData[I15, RuntimeData[I16, RuntimeData[I17, RuntimeZero]]]]]
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
    AdtExtension.Passed.type
  ]
  type CoProductX17[ST <: AdtExtension, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] = ADTData[
    RuntimeData[
      I1,
      RuntimeData[
        I2,
        RuntimeData[
          I3,
          RuntimeData[
            I4,
            RuntimeData[
              I5,
              RuntimeData[
                I6,
                RuntimeData[
                  I7,
                  RuntimeData[
                    I8,
                    RuntimeData[
                      I9,
                      RuntimeData[I10, RuntimeData[I11, RuntimeData[
                        I12,
                        RuntimeData[I13, RuntimeData[I14, RuntimeData[I15, RuntimeData[I16, RuntimeData[I17, RuntimeZero]]]]]
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

  type CoProduct18[
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
    RuntimeData[
      I1,
      RuntimeData[
        I2,
        RuntimeData[
          I3,
          RuntimeData[
            I4,
            RuntimeData[
              I5,
              RuntimeData[
                I6,
                RuntimeData[
                  I7,
                  RuntimeData[
                    I8,
                    RuntimeData[
                      I9,
                      RuntimeData[
                        I10,
                        RuntimeData[I11, RuntimeData[I12, RuntimeData[
                          I13,
                          RuntimeData[I14, RuntimeData[I15, RuntimeData[I16, RuntimeData[I17, RuntimeData[I18, RuntimeZero]]]]]
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
    AdtExtension.Passed.type
  ]
  type CoProductX18[ST <: AdtExtension, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] = ADTData[
    RuntimeData[
      I1,
      RuntimeData[
        I2,
        RuntimeData[
          I3,
          RuntimeData[
            I4,
            RuntimeData[
              I5,
              RuntimeData[
                I6,
                RuntimeData[
                  I7,
                  RuntimeData[
                    I8,
                    RuntimeData[
                      I9,
                      RuntimeData[
                        I10,
                        RuntimeData[I11, RuntimeData[I12, RuntimeData[
                          I13,
                          RuntimeData[I14, RuntimeData[I15, RuntimeData[I16, RuntimeData[I17, RuntimeData[I18, RuntimeZero]]]]]
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

  type CoProduct19[
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
    RuntimeData[
      I1,
      RuntimeData[
        I2,
        RuntimeData[
          I3,
          RuntimeData[
            I4,
            RuntimeData[
              I5,
              RuntimeData[
                I6,
                RuntimeData[
                  I7,
                  RuntimeData[
                    I8,
                    RuntimeData[
                      I9,
                      RuntimeData[
                        I10,
                        RuntimeData[
                          I11,
                          RuntimeData[I12, RuntimeData[I13, RuntimeData[
                            I14,
                            RuntimeData[I15, RuntimeData[I16, RuntimeData[I17, RuntimeData[I18, RuntimeData[I19, RuntimeZero]]]]]
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
    AdtExtension.Passed.type
  ]
  type CoProductX19[ST <: AdtExtension, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] = ADTData[
    RuntimeData[
      I1,
      RuntimeData[
        I2,
        RuntimeData[
          I3,
          RuntimeData[
            I4,
            RuntimeData[
              I5,
              RuntimeData[
                I6,
                RuntimeData[
                  I7,
                  RuntimeData[
                    I8,
                    RuntimeData[
                      I9,
                      RuntimeData[
                        I10,
                        RuntimeData[
                          I11,
                          RuntimeData[I12, RuntimeData[I13, RuntimeData[
                            I14,
                            RuntimeData[I15, RuntimeData[I16, RuntimeData[I17, RuntimeData[I18, RuntimeData[I19, RuntimeZero]]]]]
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

  type CoProduct20[
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
    RuntimeData[
      I1,
      RuntimeData[
        I2,
        RuntimeData[
          I3,
          RuntimeData[
            I4,
            RuntimeData[
              I5,
              RuntimeData[
                I6,
                RuntimeData[
                  I7,
                  RuntimeData[
                    I8,
                    RuntimeData[
                      I9,
                      RuntimeData[
                        I10,
                        RuntimeData[
                          I11,
                          RuntimeData[
                            I12,
                            RuntimeData[I13, RuntimeData[I14, RuntimeData[
                              I15,
                              RuntimeData[I16, RuntimeData[I17, RuntimeData[I18, RuntimeData[I19, RuntimeData[I20, RuntimeZero]]]]]
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
    AdtExtension.Passed.type
  ]
  type CoProductX20[ST <: AdtExtension, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] =
    ADTData[
      RuntimeData[
        I1,
        RuntimeData[
          I2,
          RuntimeData[
            I3,
            RuntimeData[
              I4,
              RuntimeData[
                I5,
                RuntimeData[
                  I6,
                  RuntimeData[
                    I7,
                    RuntimeData[
                      I8,
                      RuntimeData[
                        I9,
                        RuntimeData[
                          I10,
                          RuntimeData[
                            I11,
                            RuntimeData[
                              I12,
                              RuntimeData[I13, RuntimeData[I14, RuntimeData[
                                I15,
                                RuntimeData[I16, RuntimeData[I17, RuntimeData[I18, RuntimeData[I19, RuntimeData[I20, RuntimeZero]]]]]
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

  type CoProduct21[
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
    RuntimeData[
      I1,
      RuntimeData[
        I2,
        RuntimeData[
          I3,
          RuntimeData[
            I4,
            RuntimeData[
              I5,
              RuntimeData[
                I6,
                RuntimeData[
                  I7,
                  RuntimeData[
                    I8,
                    RuntimeData[
                      I9,
                      RuntimeData[
                        I10,
                        RuntimeData[
                          I11,
                          RuntimeData[
                            I12,
                            RuntimeData[
                              I13,
                              RuntimeData[I14, RuntimeData[I15, RuntimeData[
                                I16,
                                RuntimeData[I17, RuntimeData[I18, RuntimeData[I19, RuntimeData[I20, RuntimeData[I21, RuntimeZero]]]]]
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
    AdtExtension.Passed.type
  ]
  type CoProductX21[ST <: AdtExtension, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] =
    ADTData[
      RuntimeData[
        I1,
        RuntimeData[
          I2,
          RuntimeData[
            I3,
            RuntimeData[
              I4,
              RuntimeData[
                I5,
                RuntimeData[
                  I6,
                  RuntimeData[
                    I7,
                    RuntimeData[
                      I8,
                      RuntimeData[
                        I9,
                        RuntimeData[
                          I10,
                          RuntimeData[
                            I11,
                            RuntimeData[
                              I12,
                              RuntimeData[
                                I13,
                                RuntimeData[I14, RuntimeData[I15, RuntimeData[
                                  I16,
                                  RuntimeData[I17, RuntimeData[I18, RuntimeData[I19, RuntimeData[I20, RuntimeData[I21, RuntimeZero]]]]]
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

  type CoProduct22[
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
    RuntimeData[
      I1,
      RuntimeData[
        I2,
        RuntimeData[
          I3,
          RuntimeData[
            I4,
            RuntimeData[
              I5,
              RuntimeData[
                I6,
                RuntimeData[
                  I7,
                  RuntimeData[
                    I8,
                    RuntimeData[
                      I9,
                      RuntimeData[
                        I10,
                        RuntimeData[
                          I11,
                          RuntimeData[
                            I12,
                            RuntimeData[
                              I13,
                              RuntimeData[
                                I14,
                                RuntimeData[I15, RuntimeData[I16, RuntimeData[
                                  I17,
                                  RuntimeData[I18, RuntimeData[I19, RuntimeData[I20, RuntimeData[I21, RuntimeData[I22, RuntimeZero]]]]]
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
    AdtExtension.Passed.type
  ]
  type CoProductX22[
    ST <: AdtExtension,
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
    RuntimeData[
      I1,
      RuntimeData[
        I2,
        RuntimeData[
          I3,
          RuntimeData[
            I4,
            RuntimeData[
              I5,
              RuntimeData[
                I6,
                RuntimeData[
                  I7,
                  RuntimeData[
                    I8,
                    RuntimeData[
                      I9,
                      RuntimeData[
                        I10,
                        RuntimeData[
                          I11,
                          RuntimeData[
                            I12,
                            RuntimeData[
                              I13,
                              RuntimeData[
                                I14,
                                RuntimeData[I15, RuntimeData[I16, RuntimeData[
                                  I17,
                                  RuntimeData[I18, RuntimeData[I19, RuntimeData[I20, RuntimeData[I21, RuntimeData[I22, RuntimeZero]]]]]
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

}
