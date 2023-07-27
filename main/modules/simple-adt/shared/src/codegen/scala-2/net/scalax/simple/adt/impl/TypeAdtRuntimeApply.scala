package net.scalax.simple.adt
package impl

import temp._
import temp.{Status => ADTStatus}

trait TypeAdtRuntimeApply {

  def Options1[
    I1
  ]: ApplyFactory[
    AdtNatData[I1, AdtNatZero]
  ] = ApplyFactory.apply

  def Options2[
    I1,
    I2
  ]: ApplyFactory[
    AdtNatData[I1, AdtNatData[I2, AdtNatZero]]
  ] = ApplyFactory.apply

  def Options3[
    I1,
    I2,
    I3
  ]: ApplyFactory[
    AdtNatData[I1, AdtNatData[I2, AdtNatData[I3, AdtNatZero]]]
  ] = ApplyFactory.apply

  def Options4[
    I1,
    I2,
    I3,
    I4
  ]: ApplyFactory[
    AdtNatData[I1, AdtNatData[I2, AdtNatData[I3, AdtNatData[I4, AdtNatZero]]]]
  ] = ApplyFactory.apply

  def Options5[
    I1,
    I2,
    I3,
    I4,
    I5
  ]: ApplyFactory[
    AdtNatData[I1, AdtNatData[I2, AdtNatData[I3, AdtNatData[I4, AdtNatData[I5, AdtNatZero]]]]]
  ] = ApplyFactory.apply

  def Options6[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6
  ]: ApplyFactory[
    AdtNatData[I1, AdtNatData[I2, AdtNatData[I3, AdtNatData[I4, AdtNatData[I5, AdtNatData[I6, AdtNatZero]]]]]]
  ] = ApplyFactory.apply

  def Options7[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6,
    I7
  ]: ApplyFactory[
    AdtNatData[I1, AdtNatData[I2, AdtNatData[I3, AdtNatData[I4, AdtNatData[I5, AdtNatData[I6, AdtNatData[I7, AdtNatZero]]]]]]]
  ] = ApplyFactory.apply

  def Options8[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6,
    I7,
    I8
  ]: ApplyFactory[
    AdtNatData[I1, AdtNatData[
      I2,
      AdtNatData[I3, AdtNatData[I4, AdtNatData[I5, AdtNatData[I6, AdtNatData[I7, AdtNatData[I8, AdtNatZero]]]]]]
    ]]
  ] = ApplyFactory.apply

  def Options9[
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
    AdtNatData[I1, AdtNatData[
      I2,
      AdtNatData[I3, AdtNatData[I4, AdtNatData[I5, AdtNatData[I6, AdtNatData[I7, AdtNatData[I8, AdtNatData[I9, AdtNatZero]]]]]]]
    ]]
  ] = ApplyFactory.apply

  def Options10[
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
    AdtNatData[I1, AdtNatData[I2, AdtNatData[
      I3,
      AdtNatData[I4, AdtNatData[I5, AdtNatData[I6, AdtNatData[I7, AdtNatData[I8, AdtNatData[I9, AdtNatData[I10, AdtNatZero]]]]]]]
    ]]]
  ] = ApplyFactory.apply

  def Options11[
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
    AdtNatData[
      I1,
      AdtNatData[
        I2,
        AdtNatData[I3, AdtNatData[
          I4,
          AdtNatData[I5, AdtNatData[I6, AdtNatData[I7, AdtNatData[I8, AdtNatData[I9, AdtNatData[I10, AdtNatData[I11, AdtNatZero]]]]]]]
        ]]
      ]
    ]
  ] = ApplyFactory.apply

  def Options12[
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
    ]
  ] = ApplyFactory.apply

  def Options13[
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
    ]
  ] = ApplyFactory.apply

  def Options14[
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
    ]
  ] = ApplyFactory.apply

  def Options15[
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
    ]
  ] = ApplyFactory.apply

  def Options16[
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
    ]
  ] = ApplyFactory.apply

  def Options17[
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
    ]
  ] = ApplyFactory.apply

  def Options18[
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
    ]
  ] = ApplyFactory.apply

  def Options19[
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
    ]
  ] = ApplyFactory.apply

  def Options20[
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
    ]
  ] = ApplyFactory.apply

  def Options21[
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
    ]
  ] = ApplyFactory.apply

  def Options22[
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
    ]
  ] = ApplyFactory.apply

}

object TypeAdtRuntimeApply extends TypeAdtRuntimeApply
