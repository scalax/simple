package net.scalax.simple.adt
package impl

import Adt.{Status => ADTStatus}
import temp._
import net.scalax.simple.adt.nat.{AdtNat, AdtNatPositive, AdtNatZero}

trait TypeAdtRuntimeApply {

  def CoProduct1[I1] =
    ApplyFactory.build[({ type F1[ParamType] = AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero] })#F1]
  type CoProduct1Apply[I1] =
    ApplyFactory[({ type F1[ParamType] = AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero] })#F1]

  def CoProduct2[I1, I2] = ApplyFactory.build[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I2, DefaultAdtContext.type],
        AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
      ]
    })#F1
  ]
  type CoProduct2Apply[I1, I2] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I2, DefaultAdtContext.type],
        AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
      ]
    })#F1
  ]

  def CoProduct3[I1, I2, I3] = ApplyFactory.build[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I3, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
        ]
      ]
    })#F1
  ]
  type CoProduct3Apply[I1, I2, I3] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I3, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
        ]
      ]
    })#F1
  ]

  def CoProduct4[I1, I2, I3, I4] = ApplyFactory.build[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I4, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I3, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I2, DefaultAdtContext.type],
            AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
          ]
        ]
      ]
    })#F1
  ]
  type CoProduct4Apply[I1, I2, I3, I4] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I4, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I3, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I2, DefaultAdtContext.type],
            AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
          ]
        ]
      ]
    })#F1
  ]

  def CoProduct5[I1, I2, I3, I4, I5] = ApplyFactory.build[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I5, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I4, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I2, DefaultAdtContext.type],
              AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
            ]
          ]
        ]
      ]
    })#F1
  ]
  type CoProduct5Apply[I1, I2, I3, I4, I5] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I5, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I4, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I2, DefaultAdtContext.type],
              AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
            ]
          ]
        ]
      ]
    })#F1
  ]

  def CoProduct6[I1, I2, I3, I4, I5, I6] = ApplyFactory.build[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I6, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I5, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I4, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I3, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I2, DefaultAdtContext.type],
                AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
              ]
            ]
          ]
        ]
      ]
    })#F1
  ]
  type CoProduct6Apply[I1, I2, I3, I4, I5, I6] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I6, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I5, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I4, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I3, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I2, DefaultAdtContext.type],
                AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
              ]
            ]
          ]
        ]
      ]
    })#F1
  ]

  def CoProduct7[I1, I2, I3, I4, I5, I6, I7] = ApplyFactory.build[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I7, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I6, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I5, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I3, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I2, DefaultAdtContext.type],
                  AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1
  ]
  type CoProduct7Apply[I1, I2, I3, I4, I5, I6, I7] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I7, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I6, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I5, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I3, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I2, DefaultAdtContext.type],
                  AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1
  ]

  def CoProduct8[I1, I2, I3, I4, I5, I6, I7, I8] = ApplyFactory.build[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I8, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I7, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I6, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I5, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I4, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I3, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I2, DefaultAdtContext.type],
                    AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1
  ]
  type CoProduct8Apply[I1, I2, I3, I4, I5, I6, I7, I8] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I8, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I7, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I6, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I5, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I4, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I3, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I2, DefaultAdtContext.type],
                    AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1
  ]

  def CoProduct9[I1, I2, I3, I4, I5, I6, I7, I8, I9] = ApplyFactory.build[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I9, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I8, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I7, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I6, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I4, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I3, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I2, DefaultAdtContext.type],
                      AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1
  ]
  type CoProduct9Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I9, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I8, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I7, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I6, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I4, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I3, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I2, DefaultAdtContext.type],
                      AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1
  ]

  def CoProduct10[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] = ApplyFactory.build[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I10, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I9, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I8, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I7, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I6, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I5, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I4, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I3, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I2, DefaultAdtContext.type],
                        AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1
  ]
  type CoProduct10Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I10, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I9, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I8, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I7, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I6, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I5, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I4, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I3, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I2, DefaultAdtContext.type],
                        AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1
  ]

  def CoProduct11[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] = ApplyFactory.build[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I11, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I10, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I9, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I8, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I7, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I5, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I4, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I3, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I2, DefaultAdtContext.type],
                          AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
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
    })#F1
  ]
  type CoProduct11Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I11, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I10, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I9, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I8, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I7, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I5, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I4, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I3, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I2, DefaultAdtContext.type],
                          AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
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
    })#F1
  ]

  def CoProduct12[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] = ApplyFactory.build[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I12, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I11, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I10, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I9, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I8, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I7, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I6, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I5, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I4, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I3, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I2, DefaultAdtContext.type],
                            AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
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
    })#F1
  ]
  type CoProduct12Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I12, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I11, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I10, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I9, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I8, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I7, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I6, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I5, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I4, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I3, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I2, DefaultAdtContext.type],
                            AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
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
    })#F1
  ]

  def CoProduct13[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] = ApplyFactory.build[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I13, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I12, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I11, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I10, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I9, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I8, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I7, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I6, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I5, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I4, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I3, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I2, DefaultAdtContext.type],
                              AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
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
    })#F1
  ]
  type CoProduct13Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I13, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I12, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I11, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I10, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I9, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I8, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I7, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I6, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I5, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I4, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I3, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I2, DefaultAdtContext.type],
                              AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
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
    })#F1
  ]

  def CoProduct14[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] = ApplyFactory.build[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I14, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I13, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I12, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I11, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I10, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I9, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I8, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I7, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I6, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I5, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I4, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I3, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I2, DefaultAdtContext.type],
                                AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
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
    })#F1
  ]
  type CoProduct14Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I14, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I13, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I12, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I11, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I10, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I9, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I8, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I7, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I6, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I5, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I4, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I3, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I2, DefaultAdtContext.type],
                                AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
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
    })#F1
  ]

  def CoProduct15[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] = ApplyFactory.build[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I15, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I14, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I13, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I12, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I11, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I10, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I9, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I8, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I7, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I6, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I5, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I4, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I3, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I2, DefaultAdtContext.type],
                                  AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
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
    })#F1
  ]
  type CoProduct15Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I15, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I14, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I13, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I12, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I11, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I10, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I9, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I8, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I7, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I6, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I5, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I4, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I3, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I2, DefaultAdtContext.type],
                                  AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
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
    })#F1
  ]

  def CoProduct16[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] = ApplyFactory.build[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I16, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I15, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I14, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I13, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I12, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I11, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I10, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I9, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I8, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I7, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I6, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I5, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I4, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I3, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I2, DefaultAdtContext.type],
                                    AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
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
    })#F1
  ]
  type CoProduct16Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I16, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I15, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I14, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I13, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I12, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I11, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I10, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I9, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I8, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I7, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I6, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I5, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I4, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I3, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I2, DefaultAdtContext.type],
                                    AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
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
    })#F1
  ]

  def CoProduct17[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] = ApplyFactory.build[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I17, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I16, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I15, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I14, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I13, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I12, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I11, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I10, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I9, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I8, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I7, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I6, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I4, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I3, DefaultAdtContext.type],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I2, DefaultAdtContext.type],
                                      AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
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
    })#F1
  ]
  type CoProduct17Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I17, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I16, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I15, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I14, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I13, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I12, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I11, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I10, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I9, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I8, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I7, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I6, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I4, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I3, DefaultAdtContext.type],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I2, DefaultAdtContext.type],
                                      AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
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
    })#F1
  ]

  def CoProduct18[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] = ApplyFactory.build[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I18, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I17, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I16, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I15, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I14, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I13, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I12, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I11, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I10, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I9, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I8, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I7, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I6, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I5, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I4, DefaultAdtContext.type],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I3, DefaultAdtContext.type],
                                      AdtNatPositive[
                                        Adt.Context[ParamType, I2, DefaultAdtContext.type],
                                        AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
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
      ]
    })#F1
  ]
  type CoProduct18Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I18, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I17, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I16, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I15, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I14, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I13, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I12, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I11, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I10, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I9, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I8, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I7, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I6, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I5, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I4, DefaultAdtContext.type],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I3, DefaultAdtContext.type],
                                      AdtNatPositive[
                                        Adt.Context[ParamType, I2, DefaultAdtContext.type],
                                        AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
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
      ]
    })#F1
  ]

  def CoProduct19[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] = ApplyFactory.build[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I19, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I18, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I17, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I16, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I15, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I14, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I13, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I12, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I11, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I10, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I9, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I8, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I7, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I5, DefaultAdtContext.type],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I4, DefaultAdtContext.type],
                                      AdtNatPositive[
                                        Adt.Context[ParamType, I3, DefaultAdtContext.type],
                                        AdtNatPositive[
                                          Adt.Context[ParamType, I2, DefaultAdtContext.type],
                                          AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
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
        ]
      ]
    })#F1
  ]
  type CoProduct19Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I19, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I18, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I17, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I16, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I15, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I14, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I13, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I12, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I11, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I10, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I9, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I8, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I7, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I5, DefaultAdtContext.type],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I4, DefaultAdtContext.type],
                                      AdtNatPositive[
                                        Adt.Context[ParamType, I3, DefaultAdtContext.type],
                                        AdtNatPositive[
                                          Adt.Context[ParamType, I2, DefaultAdtContext.type],
                                          AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
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
        ]
      ]
    })#F1
  ]

  def CoProduct20[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] = ApplyFactory.build[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I20, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I19, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I18, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I17, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I16, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I15, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I14, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I13, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I12, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I11, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I10, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I9, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I8, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I7, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I6, DefaultAdtContext.type],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I5, DefaultAdtContext.type],
                                      AdtNatPositive[
                                        Adt.Context[ParamType, I4, DefaultAdtContext.type],
                                        AdtNatPositive[
                                          Adt.Context[ParamType, I3, DefaultAdtContext.type],
                                          AdtNatPositive[
                                            Adt.Context[ParamType, I2, DefaultAdtContext.type],
                                            AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
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
          ]
        ]
      ]
    })#F1
  ]
  type CoProduct20Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I20, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I19, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I18, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I17, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I16, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I15, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I14, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I13, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I12, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I11, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I10, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I9, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I8, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I7, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I6, DefaultAdtContext.type],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I5, DefaultAdtContext.type],
                                      AdtNatPositive[
                                        Adt.Context[ParamType, I4, DefaultAdtContext.type],
                                        AdtNatPositive[
                                          Adt.Context[ParamType, I3, DefaultAdtContext.type],
                                          AdtNatPositive[
                                            Adt.Context[ParamType, I2, DefaultAdtContext.type],
                                            AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
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
          ]
        ]
      ]
    })#F1
  ]

  def CoProduct21[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] = ApplyFactory.build[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I21, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I20, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I19, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I18, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I17, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I16, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I15, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I14, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I13, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I12, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I11, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I10, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I9, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I8, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I7, DefaultAdtContext.type],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I6, DefaultAdtContext.type],
                                      AdtNatPositive[
                                        Adt.Context[ParamType, I5, DefaultAdtContext.type],
                                        AdtNatPositive[
                                          Adt.Context[ParamType, I4, DefaultAdtContext.type],
                                          AdtNatPositive[
                                            Adt.Context[ParamType, I3, DefaultAdtContext.type],
                                            AdtNatPositive[
                                              Adt.Context[ParamType, I2, DefaultAdtContext.type],
                                              AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
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
            ]
          ]
        ]
      ]
    })#F1
  ]
  type CoProduct21Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I21, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I20, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I19, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I18, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I17, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I16, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I15, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I14, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I13, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I12, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I11, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I10, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I9, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I8, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I7, DefaultAdtContext.type],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I6, DefaultAdtContext.type],
                                      AdtNatPositive[
                                        Adt.Context[ParamType, I5, DefaultAdtContext.type],
                                        AdtNatPositive[
                                          Adt.Context[ParamType, I4, DefaultAdtContext.type],
                                          AdtNatPositive[
                                            Adt.Context[ParamType, I3, DefaultAdtContext.type],
                                            AdtNatPositive[
                                              Adt.Context[ParamType, I2, DefaultAdtContext.type],
                                              AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
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
            ]
          ]
        ]
      ]
    })#F1
  ]

  def CoProduct22[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22] = ApplyFactory.build[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I22, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I21, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I20, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I19, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I18, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I17, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I16, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I15, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I14, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I13, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I12, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I11, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I10, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I9, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I8, DefaultAdtContext.type],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I7, DefaultAdtContext.type],
                                      AdtNatPositive[
                                        Adt.Context[ParamType, I6, DefaultAdtContext.type],
                                        AdtNatPositive[
                                          Adt.Context[ParamType, I5, DefaultAdtContext.type],
                                          AdtNatPositive[
                                            Adt.Context[ParamType, I4, DefaultAdtContext.type],
                                            AdtNatPositive[
                                              Adt.Context[ParamType, I3, DefaultAdtContext.type],
                                              AdtNatPositive[
                                                Adt.Context[ParamType, I2, DefaultAdtContext.type],
                                                AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
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
              ]
            ]
          ]
        ]
      ]
    })#F1
  ]
  type CoProduct22Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I22, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I21, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I20, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I19, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I18, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I17, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I16, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I15, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I14, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I13, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I12, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I11, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I10, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I9, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I8, DefaultAdtContext.type],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I7, DefaultAdtContext.type],
                                      AdtNatPositive[
                                        Adt.Context[ParamType, I6, DefaultAdtContext.type],
                                        AdtNatPositive[
                                          Adt.Context[ParamType, I5, DefaultAdtContext.type],
                                          AdtNatPositive[
                                            Adt.Context[ParamType, I4, DefaultAdtContext.type],
                                            AdtNatPositive[
                                              Adt.Context[ParamType, I3, DefaultAdtContext.type],
                                              AdtNatPositive[
                                                Adt.Context[ParamType, I2, DefaultAdtContext.type],
                                                AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero]
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
              ]
            ]
          ]
        ]
      ]
    })#F1
  ]

}
