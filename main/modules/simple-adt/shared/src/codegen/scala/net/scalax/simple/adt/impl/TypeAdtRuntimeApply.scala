package net.scalax.simple.adt
package impl

import temp._
import Adt.{Status => ADTStatus}

trait TypeAdtRuntimeApply {

  def CoProducts1[
    I1
  ]: ApplyFactory[
    AdtNatPositive[I1, AdtNatZero]
  ] = ApplyFactory.build

  def CoProducts2[
    I1,
    I2
  ]: ApplyFactory[
    AdtNatPositive[I1, AdtNatPositive[I2, AdtNatZero]]
  ] = ApplyFactory.build

  def CoProducts3[
    I1,
    I2,
    I3
  ]: ApplyFactory[
    AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatZero]]]
  ] = ApplyFactory.build

  def CoProducts4[
    I1,
    I2,
    I3,
    I4
  ]: ApplyFactory[
    AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatZero]]]]
  ] = ApplyFactory.build

  def CoProducts5[
    I1,
    I2,
    I3,
    I4,
    I5
  ]: ApplyFactory[
    AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatZero]]]]]
  ] = ApplyFactory.build

  def CoProducts6[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6
  ]: ApplyFactory[
    AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatZero]]]]]]
  ] = ApplyFactory.build

  def CoProducts7[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6,
    I7
  ]: ApplyFactory[
    AdtNatPositive[I1, AdtNatPositive[
      I2,
      AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[I7, AdtNatZero]]]]]
    ]]
  ] = ApplyFactory.build

  def CoProducts8[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6,
    I7,
    I8
  ]: ApplyFactory[
    AdtNatPositive[I1, AdtNatPositive[
      I2,
      AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[I7, AdtNatPositive[I8, AdtNatZero]]]]]]
    ]]
  ] = ApplyFactory.build

  def CoProducts9[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6,
    I7,
    I8,
    I9
  ]: ApplyFactory[
    AdtNatPositive[
      I1,
      AdtNatPositive[I2, AdtNatPositive[
        I3,
        AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[I7, AdtNatPositive[I8, AdtNatPositive[I9, AdtNatZero]]]]]]
      ]]
    ]
  ] = ApplyFactory.build

  def CoProducts10[
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
  ]: ApplyFactory[
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
  ] = ApplyFactory.build

  def CoProducts11[
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
  ]: ApplyFactory[
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
  ] = ApplyFactory.build

  def CoProducts12[
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
  ]: ApplyFactory[
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
  ] = ApplyFactory.build

  def CoProducts13[
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
  ]: ApplyFactory[
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
  ] = ApplyFactory.build

  def CoProducts14[
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
  ]: ApplyFactory[
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
  ] = ApplyFactory.build

  def CoProducts15[
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
  ]: ApplyFactory[
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
  ] = ApplyFactory.build

  def CoProducts16[
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
  ]: ApplyFactory[
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
  ] = ApplyFactory.build

  def CoProducts17[
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
  ]: ApplyFactory[
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
  ] = ApplyFactory.build

  def CoProducts18[
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
  ]: ApplyFactory[
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
  ] = ApplyFactory.build

  def CoProducts19[
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
  ]: ApplyFactory[
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
  ] = ApplyFactory.build

  def CoProducts20[
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
  ]: ApplyFactory[
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
  ] = ApplyFactory.build

  def CoProducts21[
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
  ]: ApplyFactory[
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
  ] = ApplyFactory.build

  def CoProducts22[
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
  ]: ApplyFactory[
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
  ] = ApplyFactory.build

}
