package net.scalax.simple.adt
package impl

import Adt.{Status => ADTStatus}
import temp._
import net.scalax.simple.adt.nat.{AdtNat, AdtNatPositive, AdtNatZero}

trait TypeAdtRuntimeApply {

  def CoProduct1[I1]: CoProduct1Apply[I1] = new ApplyFactory[
    ({ type F1[ParamType] = AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero] })#F1,
    AdtNatPositive[I1, AdtNatZero]
  ] {
    override protected def cv[ParamType, S <: ADTStatus](
      a: ParamType,
      b: ADTData[AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero], S with ADTFunctionImplicitFetch.type]
    ): ADTData[AdtNatPositive[I1, AdtNatZero], ADTStatus.Passed.type] = {
      1
      ???
    }
  }
  type CoProduct1Apply[I1] = ApplyFactory[
    ({ type F1[ParamType] = AdtNatPositive[Adt.Context[ParamType, I1, DefaultAdtContext.type], AdtNatZero] })#F1,
    AdtNatPositive[I1, AdtNatZero]
  ]

  def CoProduct2[I1, I2]: CoProduct2Apply[I1, I2] = new ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[Adt.Context[ParamType, I2, DefaultAdtContext.type], AdtNatZero]
      ]
    })#F1,
    AdtNatPositive[I1, AdtNatPositive[I2, AdtNatZero]]
  ] {
    override protected def cv[ParamType, S <: ADTStatus](
      a: ParamType,
      b: ADTData[
        AdtNatPositive[
          Adt.Context[ParamType, I1, DefaultAdtContext.type],
          AdtNatPositive[Adt.Context[ParamType, I2, DefaultAdtContext.type], AdtNatZero]
        ],
        S with ADTFunctionImplicitFetch.type
      ]
    ): ADTData[AdtNatPositive[I1, AdtNatPositive[I2, AdtNatZero]], ADTStatus.Passed.type] = {
      1
      ???
    }
  }
  type CoProduct2Apply[I1, I2] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[Adt.Context[ParamType, I2, DefaultAdtContext.type], AdtNatZero]
      ]
    })#F1,
    AdtNatPositive[I1, AdtNatPositive[I2, AdtNatZero]]
  ]

  def CoProduct3[I1, I2, I3]: CoProduct3Apply[I1, I2, I3] = new ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[Adt.Context[ParamType, I3, DefaultAdtContext.type], AdtNatZero]
        ]
      ]
    })#F1,
    AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatZero]]]
  ] {
    override protected def cv[ParamType, S <: ADTStatus](
      a: ParamType,
      b: ADTData[
        AdtNatPositive[
          Adt.Context[ParamType, I1, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I2, DefaultAdtContext.type],
            AdtNatPositive[Adt.Context[ParamType, I3, DefaultAdtContext.type], AdtNatZero]
          ]
        ],
        S with ADTFunctionImplicitFetch.type
      ]
    ): ADTData[AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatZero]]], ADTStatus.Passed.type] = {
      1
      ???
    }
  }
  type CoProduct3Apply[I1, I2, I3] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[Adt.Context[ParamType, I3, DefaultAdtContext.type], AdtNatZero]
        ]
      ]
    })#F1,
    AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatZero]]]
  ]

  def CoProduct4[I1, I2, I3, I4]: CoProduct4Apply[I1, I2, I3, I4] = new ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[Adt.Context[ParamType, I4, DefaultAdtContext.type], AdtNatZero]
          ]
        ]
      ]
    })#F1,
    AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatZero]]]]
  ] {
    override protected def cv[ParamType, S <: ADTStatus](
      a: ParamType,
      b: ADTData[
        AdtNatPositive[
          Adt.Context[ParamType, I1, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I2, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I3, DefaultAdtContext.type],
              AdtNatPositive[Adt.Context[ParamType, I4, DefaultAdtContext.type], AdtNatZero]
            ]
          ]
        ],
        S with ADTFunctionImplicitFetch.type
      ]
    ): ADTData[AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatZero]]]], ADTStatus.Passed.type] = {
      1
      ???
    }
  }
  type CoProduct4Apply[I1, I2, I3, I4] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[Adt.Context[ParamType, I4, DefaultAdtContext.type], AdtNatZero]
          ]
        ]
      ]
    })#F1,
    AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatZero]]]]
  ]

  def CoProduct5[I1, I2, I3, I4, I5]: CoProduct5Apply[I1, I2, I3, I4, I5] = new ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[Adt.Context[ParamType, I5, DefaultAdtContext.type], AdtNatZero]
            ]
          ]
        ]
      ]
    })#F1,
    AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatZero]]]]]
  ] {
    override protected def cv[ParamType, S <: ADTStatus](
      a: ParamType,
      b: ADTData[
        AdtNatPositive[
          Adt.Context[ParamType, I1, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I2, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I3, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I4, DefaultAdtContext.type],
                AdtNatPositive[Adt.Context[ParamType, I5, DefaultAdtContext.type], AdtNatZero]
              ]
            ]
          ]
        ],
        S with ADTFunctionImplicitFetch.type
      ]
    ): ADTData[
      AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatZero]]]]],
      ADTStatus.Passed.type
    ] = {
      1
      ???
    }
  }
  type CoProduct5Apply[I1, I2, I3, I4, I5] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[Adt.Context[ParamType, I5, DefaultAdtContext.type], AdtNatZero]
            ]
          ]
        ]
      ]
    })#F1,
    AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatZero]]]]]
  ]

  def CoProduct6[I1, I2, I3, I4, I5, I6]: CoProduct6Apply[I1, I2, I3, I4, I5, I6] = new ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[Adt.Context[ParamType, I6, DefaultAdtContext.type], AdtNatZero]
              ]
            ]
          ]
        ]
      ]
    })#F1,
    AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatZero]]]]]]
  ] {
    override protected def cv[ParamType, S <: ADTStatus](
      a: ParamType,
      b: ADTData[
        AdtNatPositive[
          Adt.Context[ParamType, I1, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I2, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I3, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I4, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I5, DefaultAdtContext.type],
                  AdtNatPositive[Adt.Context[ParamType, I6, DefaultAdtContext.type], AdtNatZero]
                ]
              ]
            ]
          ]
        ],
        S with ADTFunctionImplicitFetch.type
      ]
    ): ADTData[
      AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatZero]]]]]],
      ADTStatus.Passed.type
    ] = {
      1
      ???
    }
  }
  type CoProduct6Apply[I1, I2, I3, I4, I5, I6] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[Adt.Context[ParamType, I6, DefaultAdtContext.type], AdtNatZero]
              ]
            ]
          ]
        ]
      ]
    })#F1,
    AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatZero]]]]]]
  ]

  def CoProduct7[I1, I2, I3, I4, I5, I6, I7]: CoProduct7Apply[I1, I2, I3, I4, I5, I6, I7] = new ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                  AdtNatPositive[Adt.Context[ParamType, I7, DefaultAdtContext.type], AdtNatZero]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1,
    AdtNatPositive[
      I1,
      AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[I7, AdtNatZero]]]]]]
    ]
  ] {
    override protected def cv[ParamType, S <: ADTStatus](
      a: ParamType,
      b: ADTData[
        AdtNatPositive[
          Adt.Context[ParamType, I1, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I2, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I3, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I4, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I5, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I6, DefaultAdtContext.type],
                    AdtNatPositive[Adt.Context[ParamType, I7, DefaultAdtContext.type], AdtNatZero]
                  ]
                ]
              ]
            ]
          ]
        ],
        S with ADTFunctionImplicitFetch.type
      ]
    ): ADTData[
      AdtNatPositive[I1, AdtNatPositive[
        I2,
        AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[I7, AdtNatZero]]]]]
      ]],
      ADTStatus.Passed.type
    ] = {
      1
      ???
    }
  }
  type CoProduct7Apply[I1, I2, I3, I4, I5, I6, I7] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                  AdtNatPositive[Adt.Context[ParamType, I7, DefaultAdtContext.type], AdtNatZero]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1,
    AdtNatPositive[
      I1,
      AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[I7, AdtNatZero]]]]]]
    ]
  ]

  def CoProduct8[I1, I2, I3, I4, I5, I6, I7, I8]: CoProduct8Apply[I1, I2, I3, I4, I5, I6, I7, I8] = new ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I7, DefaultAdtContext.type],
                    AdtNatPositive[Adt.Context[ParamType, I8, DefaultAdtContext.type], AdtNatZero]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1,
    AdtNatPositive[I1, AdtNatPositive[
      I2,
      AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[I7, AdtNatPositive[I8, AdtNatZero]]]]]]
    ]]
  ] {
    override protected def cv[ParamType, S <: ADTStatus](
      a: ParamType,
      b: ADTData[
        AdtNatPositive[
          Adt.Context[ParamType, I1, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I2, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I3, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I4, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I5, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I6, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I7, DefaultAdtContext.type],
                      AdtNatPositive[Adt.Context[ParamType, I8, DefaultAdtContext.type], AdtNatZero]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ],
        S with ADTFunctionImplicitFetch.type
      ]
    ): ADTData[
      AdtNatPositive[I1, AdtNatPositive[
        I2,
        AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[I7, AdtNatPositive[I8, AdtNatZero]]]]]]
      ]],
      ADTStatus.Passed.type
    ] = {
      1
      ???
    }
  }
  type CoProduct8Apply[I1, I2, I3, I4, I5, I6, I7, I8] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I7, DefaultAdtContext.type],
                    AdtNatPositive[Adt.Context[ParamType, I8, DefaultAdtContext.type], AdtNatZero]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1,
    AdtNatPositive[I1, AdtNatPositive[
      I2,
      AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[I7, AdtNatPositive[I8, AdtNatZero]]]]]]
    ]]
  ]

  def CoProduct9[I1, I2, I3, I4, I5, I6, I7, I8, I9]: CoProduct9Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9] = new ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I7, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I8, DefaultAdtContext.type],
                      AdtNatPositive[Adt.Context[ParamType, I9, DefaultAdtContext.type], AdtNatZero]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1,
    AdtNatPositive[
      I1,
      AdtNatPositive[I2, AdtNatPositive[
        I3,
        AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[I7, AdtNatPositive[I8, AdtNatPositive[I9, AdtNatZero]]]]]]
      ]]
    ]
  ] {
    override protected def cv[ParamType, S <: ADTStatus](
      a: ParamType,
      b: ADTData[
        AdtNatPositive[
          Adt.Context[ParamType, I1, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I2, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I3, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I4, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I5, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I6, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I7, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I8, DefaultAdtContext.type],
                        AdtNatPositive[Adt.Context[ParamType, I9, DefaultAdtContext.type], AdtNatZero]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ],
        S with ADTFunctionImplicitFetch.type
      ]
    ): ADTData[
      AdtNatPositive[
        I1,
        AdtNatPositive[I2, AdtNatPositive[
          I3,
          AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[I7, AdtNatPositive[I8, AdtNatPositive[I9, AdtNatZero]]]]]]
        ]]
      ],
      ADTStatus.Passed.type
    ] = {
      1
      ???
    }
  }
  type CoProduct9Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I7, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I8, DefaultAdtContext.type],
                      AdtNatPositive[Adt.Context[ParamType, I9, DefaultAdtContext.type], AdtNatZero]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1,
    AdtNatPositive[
      I1,
      AdtNatPositive[I2, AdtNatPositive[
        I3,
        AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[I7, AdtNatPositive[I8, AdtNatPositive[I9, AdtNatZero]]]]]]
      ]]
    ]
  ]

  def CoProduct10[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10]: CoProduct10Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] = new ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I7, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I8, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I9, DefaultAdtContext.type],
                        AdtNatPositive[Adt.Context[ParamType, I10, DefaultAdtContext.type], AdtNatZero]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1,
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
  ] {
    override protected def cv[ParamType, S <: ADTStatus](
      a: ParamType,
      b: ADTData[
        AdtNatPositive[
          Adt.Context[ParamType, I1, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I2, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I3, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I4, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I5, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I6, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I7, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I8, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I9, DefaultAdtContext.type],
                          AdtNatPositive[Adt.Context[ParamType, I10, DefaultAdtContext.type], AdtNatZero]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ],
        S with ADTFunctionImplicitFetch.type
      ]
    ): ADTData[
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
      ADTStatus.Passed.type
    ] = {
      1
      ???
    }
  }
  type CoProduct10Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I7, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I8, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I9, DefaultAdtContext.type],
                        AdtNatPositive[Adt.Context[ParamType, I10, DefaultAdtContext.type], AdtNatZero]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1,
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

  def CoProduct11[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11]: CoProduct11Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] =
    new ApplyFactory[
      ({
        type F1[ParamType] = AdtNatPositive[
          Adt.Context[ParamType, I1, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I2, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I3, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I4, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I5, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I6, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I7, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I8, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I9, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I10, DefaultAdtContext.type],
                            AdtNatPositive[Adt.Context[ParamType, I11, DefaultAdtContext.type], AdtNatZero]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      })#F1,
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
    ] {
      override protected def cv[ParamType, S <: ADTStatus](
        a: ParamType,
        b: ADTData[
          AdtNatPositive[
            Adt.Context[ParamType, I1, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I2, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I3, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I4, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I5, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I6, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I7, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I8, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I9, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I10, DefaultAdtContext.type],
                              AdtNatPositive[Adt.Context[ParamType, I11, DefaultAdtContext.type], AdtNatZero]
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
          S with ADTFunctionImplicitFetch.type
        ]
      ): ADTData[
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
        ADTStatus.Passed.type
      ] = {
        1
        ???
      }
    }
  type CoProduct11Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I7, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I8, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I9, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I10, DefaultAdtContext.type],
                          AdtNatPositive[Adt.Context[ParamType, I11, DefaultAdtContext.type], AdtNatZero]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1,
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

  def CoProduct12[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12]: CoProduct12Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] =
    new ApplyFactory[
      ({
        type F1[ParamType] = AdtNatPositive[
          Adt.Context[ParamType, I1, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I2, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I3, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I4, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I5, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I6, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I7, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I8, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I9, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I10, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I11, DefaultAdtContext.type],
                              AdtNatPositive[Adt.Context[ParamType, I12, DefaultAdtContext.type], AdtNatZero]
                            ]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      })#F1,
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
    ] {
      override protected def cv[ParamType, S <: ADTStatus](
        a: ParamType,
        b: ADTData[
          AdtNatPositive[
            Adt.Context[ParamType, I1, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I2, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I3, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I4, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I5, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I6, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I7, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I8, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I9, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I10, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I11, DefaultAdtContext.type],
                                AdtNatPositive[Adt.Context[ParamType, I12, DefaultAdtContext.type], AdtNatZero]
                              ]
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
          S with ADTFunctionImplicitFetch.type
        ]
      ): ADTData[
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
        ADTStatus.Passed.type
      ] = {
        1
        ???
      }
    }
  type CoProduct12Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I7, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I8, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I9, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I10, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I11, DefaultAdtContext.type],
                            AdtNatPositive[Adt.Context[ParamType, I12, DefaultAdtContext.type], AdtNatZero]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1,
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

  def CoProduct13[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13]
    : CoProduct13Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] = new ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I7, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I8, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I9, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I10, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I11, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I12, DefaultAdtContext.type],
                              AdtNatPositive[Adt.Context[ParamType, I13, DefaultAdtContext.type], AdtNatZero]
                            ]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1,
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
  ] {
    override protected def cv[ParamType, S <: ADTStatus](
      a: ParamType,
      b: ADTData[
        AdtNatPositive[
          Adt.Context[ParamType, I1, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I2, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I3, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I4, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I5, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I6, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I7, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I8, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I9, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I10, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I11, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I12, DefaultAdtContext.type],
                                AdtNatPositive[Adt.Context[ParamType, I13, DefaultAdtContext.type], AdtNatZero]
                              ]
                            ]
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
        S with ADTFunctionImplicitFetch.type
      ]
    ): ADTData[
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
      ADTStatus.Passed.type
    ] = {
      1
      ???
    }
  }
  type CoProduct13Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I7, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I8, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I9, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I10, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I11, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I12, DefaultAdtContext.type],
                              AdtNatPositive[Adt.Context[ParamType, I13, DefaultAdtContext.type], AdtNatZero]
                            ]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1,
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

  def CoProduct14[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14]
    : CoProduct14Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] = new ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I7, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I8, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I9, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I10, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I11, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I12, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I13, DefaultAdtContext.type],
                                AdtNatPositive[Adt.Context[ParamType, I14, DefaultAdtContext.type], AdtNatZero]
                              ]
                            ]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1,
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
  ] {
    override protected def cv[ParamType, S <: ADTStatus](
      a: ParamType,
      b: ADTData[
        AdtNatPositive[
          Adt.Context[ParamType, I1, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I2, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I3, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I4, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I5, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I6, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I7, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I8, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I9, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I10, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I11, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I12, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I13, DefaultAdtContext.type],
                                  AdtNatPositive[Adt.Context[ParamType, I14, DefaultAdtContext.type], AdtNatZero]
                                ]
                              ]
                            ]
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
        S with ADTFunctionImplicitFetch.type
      ]
    ): ADTData[
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
      ADTStatus.Passed.type
    ] = {
      1
      ???
    }
  }
  type CoProduct14Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I7, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I8, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I9, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I10, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I11, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I12, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I13, DefaultAdtContext.type],
                                AdtNatPositive[Adt.Context[ParamType, I14, DefaultAdtContext.type], AdtNatZero]
                              ]
                            ]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1,
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

  def CoProduct15[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15]
    : CoProduct15Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] = new ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I7, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I8, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I9, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I10, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I11, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I12, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I13, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I14, DefaultAdtContext.type],
                                  AdtNatPositive[Adt.Context[ParamType, I15, DefaultAdtContext.type], AdtNatZero]
                                ]
                              ]
                            ]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1,
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
  ] {
    override protected def cv[ParamType, S <: ADTStatus](
      a: ParamType,
      b: ADTData[
        AdtNatPositive[
          Adt.Context[ParamType, I1, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I2, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I3, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I4, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I5, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I6, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I7, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I8, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I9, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I10, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I11, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I12, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I13, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I14, DefaultAdtContext.type],
                                    AdtNatPositive[Adt.Context[ParamType, I15, DefaultAdtContext.type], AdtNatZero]
                                  ]
                                ]
                              ]
                            ]
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
        S with ADTFunctionImplicitFetch.type
      ]
    ): ADTData[
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
      ADTStatus.Passed.type
    ] = {
      1
      ???
    }
  }
  type CoProduct15Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I7, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I8, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I9, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I10, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I11, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I12, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I13, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I14, DefaultAdtContext.type],
                                  AdtNatPositive[Adt.Context[ParamType, I15, DefaultAdtContext.type], AdtNatZero]
                                ]
                              ]
                            ]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1,
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

  def CoProduct16[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16]
    : CoProduct16Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] = new ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I7, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I8, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I9, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I10, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I11, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I12, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I13, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I14, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I15, DefaultAdtContext.type],
                                    AdtNatPositive[Adt.Context[ParamType, I16, DefaultAdtContext.type], AdtNatZero]
                                  ]
                                ]
                              ]
                            ]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1,
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
  ] {
    override protected def cv[ParamType, S <: ADTStatus](
      a: ParamType,
      b: ADTData[
        AdtNatPositive[
          Adt.Context[ParamType, I1, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I2, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I3, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I4, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I5, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I6, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I7, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I8, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I9, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I10, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I11, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I12, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I13, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I14, DefaultAdtContext.type],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I15, DefaultAdtContext.type],
                                      AdtNatPositive[Adt.Context[ParamType, I16, DefaultAdtContext.type], AdtNatZero]
                                    ]
                                  ]
                                ]
                              ]
                            ]
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
        S with ADTFunctionImplicitFetch.type
      ]
    ): ADTData[
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
                        AdtNatPositive[I10, AdtNatPositive[I11, AdtNatPositive[
                          I12,
                          AdtNatPositive[I13, AdtNatPositive[I14, AdtNatPositive[I15, AdtNatPositive[I16, AdtNatZero]]]]
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
      ADTStatus.Passed.type
    ] = {
      1
      ???
    }
  }
  type CoProduct16Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I7, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I8, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I9, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I10, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I11, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I12, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I13, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I14, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I15, DefaultAdtContext.type],
                                    AdtNatPositive[Adt.Context[ParamType, I16, DefaultAdtContext.type], AdtNatZero]
                                  ]
                                ]
                              ]
                            ]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1,
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

  def CoProduct17[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17]
    : CoProduct17Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] = new ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I7, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I8, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I9, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I10, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I11, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I12, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I13, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I14, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I15, DefaultAdtContext.type],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I16, DefaultAdtContext.type],
                                      AdtNatPositive[Adt.Context[ParamType, I17, DefaultAdtContext.type], AdtNatZero]
                                    ]
                                  ]
                                ]
                              ]
                            ]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1,
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
  ] {
    override protected def cv[ParamType, S <: ADTStatus](
      a: ParamType,
      b: ADTData[
        AdtNatPositive[
          Adt.Context[ParamType, I1, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I2, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I3, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I4, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I5, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I6, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I7, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I8, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I9, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I10, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I11, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I12, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I13, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I14, DefaultAdtContext.type],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I15, DefaultAdtContext.type],
                                      AdtNatPositive[
                                        Adt.Context[ParamType, I16, DefaultAdtContext.type],
                                        AdtNatPositive[Adt.Context[ParamType, I17, DefaultAdtContext.type], AdtNatZero]
                                      ]
                                    ]
                                  ]
                                ]
                              ]
                            ]
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
        S with ADTFunctionImplicitFetch.type
      ]
    ): ADTData[
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
      ADTStatus.Passed.type
    ] = {
      1
      ???
    }
  }
  type CoProduct17Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I7, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I8, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I9, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I10, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I11, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I12, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I13, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I14, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I15, DefaultAdtContext.type],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I16, DefaultAdtContext.type],
                                      AdtNatPositive[Adt.Context[ParamType, I17, DefaultAdtContext.type], AdtNatZero]
                                    ]
                                  ]
                                ]
                              ]
                            ]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1,
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

  def CoProduct18[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18]
    : CoProduct18Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] = new ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I7, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I8, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I9, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I10, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I11, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I12, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I13, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I14, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I15, DefaultAdtContext.type],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I16, DefaultAdtContext.type],
                                      AdtNatPositive[
                                        Adt.Context[ParamType, I17, DefaultAdtContext.type],
                                        AdtNatPositive[Adt.Context[ParamType, I18, DefaultAdtContext.type], AdtNatZero]
                                      ]
                                    ]
                                  ]
                                ]
                              ]
                            ]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1,
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
  ] {
    override protected def cv[ParamType, S <: ADTStatus](
      a: ParamType,
      b: ADTData[
        AdtNatPositive[
          Adt.Context[ParamType, I1, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I2, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I3, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I4, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I5, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I6, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I7, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I8, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I9, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I10, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I11, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I12, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I13, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I14, DefaultAdtContext.type],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I15, DefaultAdtContext.type],
                                      AdtNatPositive[
                                        Adt.Context[ParamType, I16, DefaultAdtContext.type],
                                        AdtNatPositive[
                                          Adt.Context[ParamType, I17, DefaultAdtContext.type],
                                          AdtNatPositive[Adt.Context[ParamType, I18, DefaultAdtContext.type], AdtNatZero]
                                        ]
                                      ]
                                    ]
                                  ]
                                ]
                              ]
                            ]
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
        S with ADTFunctionImplicitFetch.type
      ]
    ): ADTData[
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
      ADTStatus.Passed.type
    ] = {
      1
      ???
    }
  }
  type CoProduct18Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I7, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I8, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I9, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I10, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I11, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I12, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I13, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I14, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I15, DefaultAdtContext.type],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I16, DefaultAdtContext.type],
                                      AdtNatPositive[
                                        Adt.Context[ParamType, I17, DefaultAdtContext.type],
                                        AdtNatPositive[Adt.Context[ParamType, I18, DefaultAdtContext.type], AdtNatZero]
                                      ]
                                    ]
                                  ]
                                ]
                              ]
                            ]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1,
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

  def CoProduct19[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19]
    : CoProduct19Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] = new ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I7, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I8, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I9, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I10, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I11, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I12, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I13, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I14, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I15, DefaultAdtContext.type],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I16, DefaultAdtContext.type],
                                      AdtNatPositive[
                                        Adt.Context[ParamType, I17, DefaultAdtContext.type],
                                        AdtNatPositive[
                                          Adt.Context[ParamType, I18, DefaultAdtContext.type],
                                          AdtNatPositive[Adt.Context[ParamType, I19, DefaultAdtContext.type], AdtNatZero]
                                        ]
                                      ]
                                    ]
                                  ]
                                ]
                              ]
                            ]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1,
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
  ] {
    override protected def cv[ParamType, S <: ADTStatus](
      a: ParamType,
      b: ADTData[
        AdtNatPositive[
          Adt.Context[ParamType, I1, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I2, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I3, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I4, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I5, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I6, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I7, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I8, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I9, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I10, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I11, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I12, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I13, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I14, DefaultAdtContext.type],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I15, DefaultAdtContext.type],
                                      AdtNatPositive[
                                        Adt.Context[ParamType, I16, DefaultAdtContext.type],
                                        AdtNatPositive[
                                          Adt.Context[ParamType, I17, DefaultAdtContext.type],
                                          AdtNatPositive[
                                            Adt.Context[ParamType, I18, DefaultAdtContext.type],
                                            AdtNatPositive[Adt.Context[ParamType, I19, DefaultAdtContext.type], AdtNatZero]
                                          ]
                                        ]
                                      ]
                                    ]
                                  ]
                                ]
                              ]
                            ]
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
        S with ADTFunctionImplicitFetch.type
      ]
    ): ADTData[
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
      ADTStatus.Passed.type
    ] = {
      1
      ???
    }
  }
  type CoProduct19Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I7, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I8, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I9, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I10, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I11, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I12, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I13, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I14, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I15, DefaultAdtContext.type],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I16, DefaultAdtContext.type],
                                      AdtNatPositive[
                                        Adt.Context[ParamType, I17, DefaultAdtContext.type],
                                        AdtNatPositive[
                                          Adt.Context[ParamType, I18, DefaultAdtContext.type],
                                          AdtNatPositive[Adt.Context[ParamType, I19, DefaultAdtContext.type], AdtNatZero]
                                        ]
                                      ]
                                    ]
                                  ]
                                ]
                              ]
                            ]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1,
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

  def CoProduct20[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20]
    : CoProduct20Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] = new ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I7, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I8, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I9, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I10, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I11, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I12, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I13, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I14, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I15, DefaultAdtContext.type],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I16, DefaultAdtContext.type],
                                      AdtNatPositive[
                                        Adt.Context[ParamType, I17, DefaultAdtContext.type],
                                        AdtNatPositive[
                                          Adt.Context[ParamType, I18, DefaultAdtContext.type],
                                          AdtNatPositive[
                                            Adt.Context[ParamType, I19, DefaultAdtContext.type],
                                            AdtNatPositive[Adt.Context[ParamType, I20, DefaultAdtContext.type], AdtNatZero]
                                          ]
                                        ]
                                      ]
                                    ]
                                  ]
                                ]
                              ]
                            ]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1,
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
  ] {
    override protected def cv[ParamType, S <: ADTStatus](
      a: ParamType,
      b: ADTData[
        AdtNatPositive[
          Adt.Context[ParamType, I1, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I2, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I3, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I4, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I5, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I6, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I7, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I8, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I9, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I10, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I11, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I12, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I13, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I14, DefaultAdtContext.type],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I15, DefaultAdtContext.type],
                                      AdtNatPositive[
                                        Adt.Context[ParamType, I16, DefaultAdtContext.type],
                                        AdtNatPositive[
                                          Adt.Context[ParamType, I17, DefaultAdtContext.type],
                                          AdtNatPositive[
                                            Adt.Context[ParamType, I18, DefaultAdtContext.type],
                                            AdtNatPositive[
                                              Adt.Context[ParamType, I19, DefaultAdtContext.type],
                                              AdtNatPositive[Adt.Context[ParamType, I20, DefaultAdtContext.type], AdtNatZero]
                                            ]
                                          ]
                                        ]
                                      ]
                                    ]
                                  ]
                                ]
                              ]
                            ]
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
        S with ADTFunctionImplicitFetch.type
      ]
    ): ADTData[
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
      ADTStatus.Passed.type
    ] = {
      1
      ???
    }
  }
  type CoProduct20Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I7, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I8, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I9, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I10, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I11, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I12, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I13, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I14, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I15, DefaultAdtContext.type],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I16, DefaultAdtContext.type],
                                      AdtNatPositive[
                                        Adt.Context[ParamType, I17, DefaultAdtContext.type],
                                        AdtNatPositive[
                                          Adt.Context[ParamType, I18, DefaultAdtContext.type],
                                          AdtNatPositive[
                                            Adt.Context[ParamType, I19, DefaultAdtContext.type],
                                            AdtNatPositive[Adt.Context[ParamType, I20, DefaultAdtContext.type], AdtNatZero]
                                          ]
                                        ]
                                      ]
                                    ]
                                  ]
                                ]
                              ]
                            ]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1,
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

  def CoProduct21[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21]
    : CoProduct21Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] = new ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I7, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I8, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I9, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I10, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I11, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I12, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I13, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I14, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I15, DefaultAdtContext.type],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I16, DefaultAdtContext.type],
                                      AdtNatPositive[
                                        Adt.Context[ParamType, I17, DefaultAdtContext.type],
                                        AdtNatPositive[
                                          Adt.Context[ParamType, I18, DefaultAdtContext.type],
                                          AdtNatPositive[
                                            Adt.Context[ParamType, I19, DefaultAdtContext.type],
                                            AdtNatPositive[
                                              Adt.Context[ParamType, I20, DefaultAdtContext.type],
                                              AdtNatPositive[Adt.Context[ParamType, I21, DefaultAdtContext.type], AdtNatZero]
                                            ]
                                          ]
                                        ]
                                      ]
                                    ]
                                  ]
                                ]
                              ]
                            ]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1,
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
  ] {
    override protected def cv[ParamType, S <: ADTStatus](
      a: ParamType,
      b: ADTData[
        AdtNatPositive[
          Adt.Context[ParamType, I1, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I2, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I3, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I4, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I5, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I6, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I7, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I8, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I9, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I10, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I11, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I12, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I13, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I14, DefaultAdtContext.type],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I15, DefaultAdtContext.type],
                                      AdtNatPositive[
                                        Adt.Context[ParamType, I16, DefaultAdtContext.type],
                                        AdtNatPositive[
                                          Adt.Context[ParamType, I17, DefaultAdtContext.type],
                                          AdtNatPositive[
                                            Adt.Context[ParamType, I18, DefaultAdtContext.type],
                                            AdtNatPositive[
                                              Adt.Context[ParamType, I19, DefaultAdtContext.type],
                                              AdtNatPositive[
                                                Adt.Context[ParamType, I20, DefaultAdtContext.type],
                                                AdtNatPositive[Adt.Context[ParamType, I21, DefaultAdtContext.type], AdtNatZero]
                                              ]
                                            ]
                                          ]
                                        ]
                                      ]
                                    ]
                                  ]
                                ]
                              ]
                            ]
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
        S with ADTFunctionImplicitFetch.type
      ]
    ): ADTData[
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
      ADTStatus.Passed.type
    ] = {
      1
      ???
    }
  }
  type CoProduct21Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I7, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I8, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I9, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I10, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I11, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I12, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I13, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I14, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I15, DefaultAdtContext.type],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I16, DefaultAdtContext.type],
                                      AdtNatPositive[
                                        Adt.Context[ParamType, I17, DefaultAdtContext.type],
                                        AdtNatPositive[
                                          Adt.Context[ParamType, I18, DefaultAdtContext.type],
                                          AdtNatPositive[
                                            Adt.Context[ParamType, I19, DefaultAdtContext.type],
                                            AdtNatPositive[
                                              Adt.Context[ParamType, I20, DefaultAdtContext.type],
                                              AdtNatPositive[Adt.Context[ParamType, I21, DefaultAdtContext.type], AdtNatZero]
                                            ]
                                          ]
                                        ]
                                      ]
                                    ]
                                  ]
                                ]
                              ]
                            ]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1,
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

  def CoProduct22[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22]
    : CoProduct22Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22] =
    new ApplyFactory[
      ({
        type F1[ParamType] = AdtNatPositive[
          Adt.Context[ParamType, I1, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I2, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I3, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I4, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I5, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I6, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I7, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I8, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I9, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I10, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I11, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I12, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I13, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I14, DefaultAdtContext.type],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I15, DefaultAdtContext.type],
                                      AdtNatPositive[
                                        Adt.Context[ParamType, I16, DefaultAdtContext.type],
                                        AdtNatPositive[
                                          Adt.Context[ParamType, I17, DefaultAdtContext.type],
                                          AdtNatPositive[
                                            Adt.Context[ParamType, I18, DefaultAdtContext.type],
                                            AdtNatPositive[
                                              Adt.Context[ParamType, I19, DefaultAdtContext.type],
                                              AdtNatPositive[
                                                Adt.Context[ParamType, I20, DefaultAdtContext.type],
                                                AdtNatPositive[
                                                  Adt.Context[ParamType, I21, DefaultAdtContext.type],
                                                  AdtNatPositive[Adt.Context[ParamType, I22, DefaultAdtContext.type], AdtNatZero]
                                                ]
                                              ]
                                            ]
                                          ]
                                        ]
                                      ]
                                    ]
                                  ]
                                ]
                              ]
                            ]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      })#F1,
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
    ] {
      override protected def cv[ParamType, S <: ADTStatus](
        a: ParamType,
        b: ADTData[
          AdtNatPositive[
            Adt.Context[ParamType, I1, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I2, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I3, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I4, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I5, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I6, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I7, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I8, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I9, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I10, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I11, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I12, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I13, DefaultAdtContext.type],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I14, DefaultAdtContext.type],
                                      AdtNatPositive[
                                        Adt.Context[ParamType, I15, DefaultAdtContext.type],
                                        AdtNatPositive[
                                          Adt.Context[ParamType, I16, DefaultAdtContext.type],
                                          AdtNatPositive[
                                            Adt.Context[ParamType, I17, DefaultAdtContext.type],
                                            AdtNatPositive[
                                              Adt.Context[ParamType, I18, DefaultAdtContext.type],
                                              AdtNatPositive[
                                                Adt.Context[ParamType, I19, DefaultAdtContext.type],
                                                AdtNatPositive[
                                                  Adt.Context[ParamType, I20, DefaultAdtContext.type],
                                                  AdtNatPositive[
                                                    Adt.Context[ParamType, I21, DefaultAdtContext.type],
                                                    AdtNatPositive[Adt.Context[ParamType, I22, DefaultAdtContext.type], AdtNatZero]
                                                  ]
                                                ]
                                              ]
                                            ]
                                          ]
                                        ]
                                      ]
                                    ]
                                  ]
                                ]
                              ]
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
          S with ADTFunctionImplicitFetch.type
        ]
      ): ADTData[
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
        ADTStatus.Passed.type
      ] = {
        1
        ???
      }
    }
  type CoProduct22Apply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22] = ApplyFactory[
    ({
      type F1[ParamType] = AdtNatPositive[
        Adt.Context[ParamType, I1, DefaultAdtContext.type],
        AdtNatPositive[
          Adt.Context[ParamType, I2, DefaultAdtContext.type],
          AdtNatPositive[
            Adt.Context[ParamType, I3, DefaultAdtContext.type],
            AdtNatPositive[
              Adt.Context[ParamType, I4, DefaultAdtContext.type],
              AdtNatPositive[
                Adt.Context[ParamType, I5, DefaultAdtContext.type],
                AdtNatPositive[
                  Adt.Context[ParamType, I6, DefaultAdtContext.type],
                  AdtNatPositive[
                    Adt.Context[ParamType, I7, DefaultAdtContext.type],
                    AdtNatPositive[
                      Adt.Context[ParamType, I8, DefaultAdtContext.type],
                      AdtNatPositive[
                        Adt.Context[ParamType, I9, DefaultAdtContext.type],
                        AdtNatPositive[
                          Adt.Context[ParamType, I10, DefaultAdtContext.type],
                          AdtNatPositive[
                            Adt.Context[ParamType, I11, DefaultAdtContext.type],
                            AdtNatPositive[
                              Adt.Context[ParamType, I12, DefaultAdtContext.type],
                              AdtNatPositive[
                                Adt.Context[ParamType, I13, DefaultAdtContext.type],
                                AdtNatPositive[
                                  Adt.Context[ParamType, I14, DefaultAdtContext.type],
                                  AdtNatPositive[
                                    Adt.Context[ParamType, I15, DefaultAdtContext.type],
                                    AdtNatPositive[
                                      Adt.Context[ParamType, I16, DefaultAdtContext.type],
                                      AdtNatPositive[
                                        Adt.Context[ParamType, I17, DefaultAdtContext.type],
                                        AdtNatPositive[
                                          Adt.Context[ParamType, I18, DefaultAdtContext.type],
                                          AdtNatPositive[
                                            Adt.Context[ParamType, I19, DefaultAdtContext.type],
                                            AdtNatPositive[
                                              Adt.Context[ParamType, I20, DefaultAdtContext.type],
                                              AdtNatPositive[
                                                Adt.Context[ParamType, I21, DefaultAdtContext.type],
                                                AdtNatPositive[Adt.Context[ParamType, I22, DefaultAdtContext.type], AdtNatZero]
                                              ]
                                            ]
                                          ]
                                        ]
                                      ]
                                    ]
                                  ]
                                ]
                              ]
                            ]
                          ]
                        ]
                      ]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    })#F1,
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
