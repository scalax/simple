package net.scalax.simple.adt
package impl

import temp._
import Adt.{Status => ADTStatus}
import net.scalax.simple.adt.nat.{AdtNat, AdtNatPositive, AdtNatZero}

trait TypeAdtRuntimeApply {

  def CoProduct1Apply[
    I1
  ]: CoProduct1Apply[
    I1
  ] = ApplyFactory.build
  type CoProduct1Apply[
    I1
  ] = ApplyFactory[
    AdtNatPositive[I1, AdtNatZero]
  ]

  def CoProduct2Apply[
    I1,
    I2
  ]: CoProduct2Apply[
    I1,
    I2
  ] = ApplyFactory.build
  type CoProduct2Apply[
    I1,
    I2
  ] = ApplyFactory[
    AdtNatPositive[I1, AdtNatPositive[I2, AdtNatZero]]
  ]

  def CoProduct3Apply[
    I1,
    I2,
    I3
  ]: CoProduct3Apply[
    I1,
    I2,
    I3
  ] = ApplyFactory.build
  type CoProduct3Apply[
    I1,
    I2,
    I3
  ] = ApplyFactory[
    AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatZero]]]
  ]

  def CoProduct4Apply[
    I1,
    I2,
    I3,
    I4
  ]: CoProduct4Apply[
    I1,
    I2,
    I3,
    I4
  ] = ApplyFactory.build
  type CoProduct4Apply[
    I1,
    I2,
    I3,
    I4
  ] = ApplyFactory[
    AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatZero]]]]
  ]

  def CoProduct5Apply[
    I1,
    I2,
    I3,
    I4,
    I5
  ]: CoProduct5Apply[
    I1,
    I2,
    I3,
    I4,
    I5
  ] = ApplyFactory.build
  type CoProduct5Apply[
    I1,
    I2,
    I3,
    I4,
    I5
  ] = ApplyFactory[
    AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatZero]]]]]
  ]

  def CoProduct6Apply[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6
  ]: CoProduct6Apply[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6
  ] = ApplyFactory.build
  type CoProduct6Apply[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6
  ] = ApplyFactory[
    AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatZero]]]]]]
  ]

  def CoProduct7Apply[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6,
    I7
  ]: CoProduct7Apply[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6,
    I7
  ] = ApplyFactory.build
  type CoProduct7Apply[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6,
    I7
  ] = ApplyFactory[
    AdtNatPositive[
      I1,
      AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[I7, AdtNatZero]]]]]]
    ]
  ]

  def CoProduct8Apply[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6,
    I7,
    I8
  ]: CoProduct8Apply[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6,
    I7,
    I8
  ] = ApplyFactory.build
  type CoProduct8Apply[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6,
    I7,
    I8
  ] = ApplyFactory[
    AdtNatPositive[I1, AdtNatPositive[
      I2,
      AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[I7, AdtNatPositive[I8, AdtNatZero]]]]]]
    ]]
  ]

  def CoProduct9Apply[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6,
    I7,
    I8,
    I9
  ]: CoProduct9Apply[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6,
    I7,
    I8,
    I9
  ] = ApplyFactory.build
  type CoProduct9Apply[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6,
    I7,
    I8,
    I9
  ] = ApplyFactory[
    AdtNatPositive[
      I1,
      AdtNatPositive[I2, AdtNatPositive[
        I3,
        AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[I7, AdtNatPositive[I8, AdtNatPositive[I9, AdtNatZero]]]]]]
      ]]
    ]
  ]

  def CoProduct10Apply[
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
  ]: CoProduct10Apply[
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
  ] = ApplyFactory.build
  type CoProduct10Apply[
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
  ] = ApplyFactory[
    AdtNatPositive[
      I1,
      AdtNatPositive[
        I2,
        AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[
          I5,
          AdtNatPositive[I6, AdtNatPositive[I7, AdtNatPositive[I8, AdtNatPositive[I9, AdtNatPositive[I10, AdtNatZero]]]]]
        ]]]
      ]
    ]
  ]

  def CoProduct11Apply[
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
  ]: CoProduct11Apply[
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
  ] = ApplyFactory.build
  type CoProduct11Apply[
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
  ] = ApplyFactory[
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
    ]
  ]

  def CoProduct12Apply[
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
  ]: CoProduct12Apply[
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
  ] = ApplyFactory.build
  type CoProduct12Apply[
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
  ] = ApplyFactory[
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
    ]
  ]

  def CoProduct13Apply[
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
  ]: CoProduct13Apply[
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
  ] = ApplyFactory.build
  type CoProduct13Apply[
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
  ] = ApplyFactory[
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
    ]
  ]

  def CoProduct14Apply[
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
  ]: CoProduct14Apply[
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
  ] = ApplyFactory.build
  type CoProduct14Apply[
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
  ] = ApplyFactory[
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
    ]
  ]

  def CoProduct15Apply[
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
  ]: CoProduct15Apply[
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
  ] = ApplyFactory.build
  type CoProduct15Apply[
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
  ] = ApplyFactory[
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
    ]
  ]

  def CoProduct16Apply[
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
  ]: CoProduct16Apply[
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
  ] = ApplyFactory.build
  type CoProduct16Apply[
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
  ] = ApplyFactory[
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
    ]
  ]

  def CoProduct17Apply[
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
  ]: CoProduct17Apply[
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
  ] = ApplyFactory.build
  type CoProduct17Apply[
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
  ] = ApplyFactory[
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
    ]
  ]

  def CoProduct18Apply[
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
  ]: CoProduct18Apply[
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
  ] = ApplyFactory.build
  type CoProduct18Apply[
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
  ] = ApplyFactory[
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
    ]
  ]

  def CoProduct19Apply[
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
  ]: CoProduct19Apply[
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
  ] = ApplyFactory.build
  type CoProduct19Apply[
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
  ] = ApplyFactory[
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
    ]
  ]

  def CoProduct20Apply[
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
  ]: CoProduct20Apply[
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
  ] = ApplyFactory.build
  type CoProduct20Apply[
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
  ] = ApplyFactory[
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
    ]
  ]

  def CoProduct21Apply[
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
  ]: CoProduct21Apply[
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
  ] = ApplyFactory.build
  type CoProduct21Apply[
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
  ] = ApplyFactory[
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
    ]
  ]

  def CoProduct22Apply[
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
  ]: CoProduct22Apply[
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
  ] = ApplyFactory.build
  type CoProduct22Apply[
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
  ] = ApplyFactory[
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
    ]
  ]

}
