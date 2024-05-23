package net.scalax.simple
package adt
package impl

import temp._
import Adt.{Status => ADTStatus}

trait TypeAdtAlias {

  type CoProducts1[A, I1] =
    ADTData[RuntimeData[Adt.Context[A, I1, DefaultAdtContext.type], RuntimeZero], ADTStatus.Passed.type with ADTFunctionImplicitFetch.type]

  type CoProductsX1[A, ST <: ADTStatus, I1] =
    TypeAdtApply[A, RuntimeData[Adt.Context[A, I1, DefaultAdtContext.type], RuntimeZero], ST with ADTFunctionImplicitFetch.type]

  type CoProducts2[A, I1, I2] = ADTData[
    RuntimeData[Adt.Context[A, I1, DefaultAdtContext.type], RuntimeData[Adt.Context[A, I2, DefaultAdtContext.type], RuntimeZero]],
    ADTStatus.Passed.type with ADTFunctionImplicitFetch.type
  ]

  type CoProductsX2[A, ST <: ADTStatus, I1, I2] = TypeAdtApply[
    A,
    RuntimeData[Adt.Context[A, I1, DefaultAdtContext.type], RuntimeData[Adt.Context[A, I2, DefaultAdtContext.type], RuntimeZero]],
    ST with ADTFunctionImplicitFetch.type
  ]

  type CoProducts3[A, I1, I2, I3] = ADTData[
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[Adt.Context[A, I2, DefaultAdtContext.type], RuntimeData[Adt.Context[A, I3, DefaultAdtContext.type], RuntimeZero]]
    ],
    ADTStatus.Passed.type with ADTFunctionImplicitFetch.type
  ]

  type CoProductsX3[A, ST <: ADTStatus, I1, I2, I3] = TypeAdtApply[
    A,
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[Adt.Context[A, I2, DefaultAdtContext.type], RuntimeData[Adt.Context[A, I3, DefaultAdtContext.type], RuntimeZero]]
    ],
    ST with ADTFunctionImplicitFetch.type
  ]

  type CoProducts4[A, I1, I2, I3, I4] = ADTData[
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[Adt.Context[A, I3, DefaultAdtContext.type], RuntimeData[Adt.Context[A, I4, DefaultAdtContext.type], RuntimeZero]]
      ]
    ],
    ADTStatus.Passed.type with ADTFunctionImplicitFetch.type
  ]

  type CoProductsX4[A, ST <: ADTStatus, I1, I2, I3, I4] = TypeAdtApply[
    A,
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[Adt.Context[A, I3, DefaultAdtContext.type], RuntimeData[Adt.Context[A, I4, DefaultAdtContext.type], RuntimeZero]]
      ]
    ],
    ST with ADTFunctionImplicitFetch.type
  ]

  type CoProducts5[A, I1, I2, I3, I4, I5] = ADTData[
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[Adt.Context[A, I4, DefaultAdtContext.type], RuntimeData[Adt.Context[A, I5, DefaultAdtContext.type], RuntimeZero]]
        ]
      ]
    ],
    ADTStatus.Passed.type with ADTFunctionImplicitFetch.type
  ]

  type CoProductsX5[A, ST <: ADTStatus, I1, I2, I3, I4, I5] = TypeAdtApply[
    A,
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[Adt.Context[A, I4, DefaultAdtContext.type], RuntimeData[Adt.Context[A, I5, DefaultAdtContext.type], RuntimeZero]]
        ]
      ]
    ],
    ST with ADTFunctionImplicitFetch.type
  ]

  type CoProducts6[A, I1, I2, I3, I4, I5, I6] = ADTData[
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I4, DefaultAdtContext.type],
            RuntimeData[Adt.Context[A, I5, DefaultAdtContext.type], RuntimeData[Adt.Context[A, I6, DefaultAdtContext.type], RuntimeZero]]
          ]
        ]
      ]
    ],
    ADTStatus.Passed.type with ADTFunctionImplicitFetch.type
  ]

  type CoProductsX6[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6] = TypeAdtApply[
    A,
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I4, DefaultAdtContext.type],
            RuntimeData[Adt.Context[A, I5, DefaultAdtContext.type], RuntimeData[Adt.Context[A, I6, DefaultAdtContext.type], RuntimeZero]]
          ]
        ]
      ]
    ],
    ST with ADTFunctionImplicitFetch.type
  ]

  type CoProducts7[A, I1, I2, I3, I4, I5, I6, I7] = ADTData[
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I4, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I5, DefaultAdtContext.type],
              RuntimeData[Adt.Context[A, I6, DefaultAdtContext.type], RuntimeData[Adt.Context[A, I7, DefaultAdtContext.type], RuntimeZero]]
            ]
          ]
        ]
      ]
    ],
    ADTStatus.Passed.type with ADTFunctionImplicitFetch.type
  ]

  type CoProductsX7[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7] = TypeAdtApply[
    A,
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I4, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I5, DefaultAdtContext.type],
              RuntimeData[Adt.Context[A, I6, DefaultAdtContext.type], RuntimeData[Adt.Context[A, I7, DefaultAdtContext.type], RuntimeZero]]
            ]
          ]
        ]
      ]
    ],
    ST with ADTFunctionImplicitFetch.type
  ]

  type CoProducts8[A, I1, I2, I3, I4, I5, I6, I7, I8] = ADTData[
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I4, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I5, DefaultAdtContext.type],
              RuntimeData[
                Adt.Context[A, I6, DefaultAdtContext.type],
                RuntimeData[
                  Adt.Context[A, I7, DefaultAdtContext.type],
                  RuntimeData[Adt.Context[A, I8, DefaultAdtContext.type], RuntimeZero]
                ]
              ]
            ]
          ]
        ]
      ]
    ],
    ADTStatus.Passed.type with ADTFunctionImplicitFetch.type
  ]

  type CoProductsX8[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8] = TypeAdtApply[
    A,
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I4, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I5, DefaultAdtContext.type],
              RuntimeData[
                Adt.Context[A, I6, DefaultAdtContext.type],
                RuntimeData[
                  Adt.Context[A, I7, DefaultAdtContext.type],
                  RuntimeData[Adt.Context[A, I8, DefaultAdtContext.type], RuntimeZero]
                ]
              ]
            ]
          ]
        ]
      ]
    ],
    ST with ADTFunctionImplicitFetch.type
  ]

  type CoProducts9[A, I1, I2, I3, I4, I5, I6, I7, I8, I9] = ADTData[
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I4, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I5, DefaultAdtContext.type],
              RuntimeData[
                Adt.Context[A, I6, DefaultAdtContext.type],
                RuntimeData[
                  Adt.Context[A, I7, DefaultAdtContext.type],
                  RuntimeData[
                    Adt.Context[A, I8, DefaultAdtContext.type],
                    RuntimeData[Adt.Context[A, I9, DefaultAdtContext.type], RuntimeZero]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    ],
    ADTStatus.Passed.type with ADTFunctionImplicitFetch.type
  ]

  type CoProductsX9[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9] = TypeAdtApply[
    A,
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I4, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I5, DefaultAdtContext.type],
              RuntimeData[
                Adt.Context[A, I6, DefaultAdtContext.type],
                RuntimeData[
                  Adt.Context[A, I7, DefaultAdtContext.type],
                  RuntimeData[
                    Adt.Context[A, I8, DefaultAdtContext.type],
                    RuntimeData[Adt.Context[A, I9, DefaultAdtContext.type], RuntimeZero]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    ],
    ST with ADTFunctionImplicitFetch.type
  ]

  type CoProducts10[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] = ADTData[
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I4, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I5, DefaultAdtContext.type],
              RuntimeData[
                Adt.Context[A, I6, DefaultAdtContext.type],
                RuntimeData[
                  Adt.Context[A, I7, DefaultAdtContext.type],
                  RuntimeData[
                    Adt.Context[A, I8, DefaultAdtContext.type],
                    RuntimeData[
                      Adt.Context[A, I9, DefaultAdtContext.type],
                      RuntimeData[Adt.Context[A, I10, DefaultAdtContext.type], RuntimeZero]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    ],
    ADTStatus.Passed.type with ADTFunctionImplicitFetch.type
  ]

  type CoProductsX10[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] = TypeAdtApply[
    A,
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I4, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I5, DefaultAdtContext.type],
              RuntimeData[
                Adt.Context[A, I6, DefaultAdtContext.type],
                RuntimeData[
                  Adt.Context[A, I7, DefaultAdtContext.type],
                  RuntimeData[
                    Adt.Context[A, I8, DefaultAdtContext.type],
                    RuntimeData[
                      Adt.Context[A, I9, DefaultAdtContext.type],
                      RuntimeData[Adt.Context[A, I10, DefaultAdtContext.type], RuntimeZero]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ]
      ]
    ],
    ST with ADTFunctionImplicitFetch.type
  ]

  type CoProducts11[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] = ADTData[
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I4, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I5, DefaultAdtContext.type],
              RuntimeData[
                Adt.Context[A, I6, DefaultAdtContext.type],
                RuntimeData[
                  Adt.Context[A, I7, DefaultAdtContext.type],
                  RuntimeData[
                    Adt.Context[A, I8, DefaultAdtContext.type],
                    RuntimeData[
                      Adt.Context[A, I9, DefaultAdtContext.type],
                      RuntimeData[
                        Adt.Context[A, I10, DefaultAdtContext.type],
                        RuntimeData[Adt.Context[A, I11, DefaultAdtContext.type], RuntimeZero]
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
    ADTStatus.Passed.type with ADTFunctionImplicitFetch.type
  ]

  type CoProductsX11[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] = TypeAdtApply[
    A,
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I4, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I5, DefaultAdtContext.type],
              RuntimeData[
                Adt.Context[A, I6, DefaultAdtContext.type],
                RuntimeData[
                  Adt.Context[A, I7, DefaultAdtContext.type],
                  RuntimeData[
                    Adt.Context[A, I8, DefaultAdtContext.type],
                    RuntimeData[
                      Adt.Context[A, I9, DefaultAdtContext.type],
                      RuntimeData[
                        Adt.Context[A, I10, DefaultAdtContext.type],
                        RuntimeData[Adt.Context[A, I11, DefaultAdtContext.type], RuntimeZero]
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
    ST with ADTFunctionImplicitFetch.type
  ]

  type CoProducts12[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] = ADTData[
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I4, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I5, DefaultAdtContext.type],
              RuntimeData[
                Adt.Context[A, I6, DefaultAdtContext.type],
                RuntimeData[
                  Adt.Context[A, I7, DefaultAdtContext.type],
                  RuntimeData[
                    Adt.Context[A, I8, DefaultAdtContext.type],
                    RuntimeData[
                      Adt.Context[A, I9, DefaultAdtContext.type],
                      RuntimeData[
                        Adt.Context[A, I10, DefaultAdtContext.type],
                        RuntimeData[
                          Adt.Context[A, I11, DefaultAdtContext.type],
                          RuntimeData[Adt.Context[A, I12, DefaultAdtContext.type], RuntimeZero]
                        ]
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
    ADTStatus.Passed.type with ADTFunctionImplicitFetch.type
  ]

  type CoProductsX12[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] = TypeAdtApply[
    A,
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I4, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I5, DefaultAdtContext.type],
              RuntimeData[
                Adt.Context[A, I6, DefaultAdtContext.type],
                RuntimeData[
                  Adt.Context[A, I7, DefaultAdtContext.type],
                  RuntimeData[
                    Adt.Context[A, I8, DefaultAdtContext.type],
                    RuntimeData[
                      Adt.Context[A, I9, DefaultAdtContext.type],
                      RuntimeData[
                        Adt.Context[A, I10, DefaultAdtContext.type],
                        RuntimeData[
                          Adt.Context[A, I11, DefaultAdtContext.type],
                          RuntimeData[Adt.Context[A, I12, DefaultAdtContext.type], RuntimeZero]
                        ]
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
    ST with ADTFunctionImplicitFetch.type
  ]

  type CoProducts13[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] = ADTData[
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I4, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I5, DefaultAdtContext.type],
              RuntimeData[
                Adt.Context[A, I6, DefaultAdtContext.type],
                RuntimeData[
                  Adt.Context[A, I7, DefaultAdtContext.type],
                  RuntimeData[
                    Adt.Context[A, I8, DefaultAdtContext.type],
                    RuntimeData[
                      Adt.Context[A, I9, DefaultAdtContext.type],
                      RuntimeData[
                        Adt.Context[A, I10, DefaultAdtContext.type],
                        RuntimeData[
                          Adt.Context[A, I11, DefaultAdtContext.type],
                          RuntimeData[
                            Adt.Context[A, I12, DefaultAdtContext.type],
                            RuntimeData[Adt.Context[A, I13, DefaultAdtContext.type], RuntimeZero]
                          ]
                        ]
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
    ADTStatus.Passed.type with ADTFunctionImplicitFetch.type
  ]

  type CoProductsX13[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] = TypeAdtApply[
    A,
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I4, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I5, DefaultAdtContext.type],
              RuntimeData[
                Adt.Context[A, I6, DefaultAdtContext.type],
                RuntimeData[
                  Adt.Context[A, I7, DefaultAdtContext.type],
                  RuntimeData[
                    Adt.Context[A, I8, DefaultAdtContext.type],
                    RuntimeData[
                      Adt.Context[A, I9, DefaultAdtContext.type],
                      RuntimeData[
                        Adt.Context[A, I10, DefaultAdtContext.type],
                        RuntimeData[
                          Adt.Context[A, I11, DefaultAdtContext.type],
                          RuntimeData[
                            Adt.Context[A, I12, DefaultAdtContext.type],
                            RuntimeData[Adt.Context[A, I13, DefaultAdtContext.type], RuntimeZero]
                          ]
                        ]
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
    ST with ADTFunctionImplicitFetch.type
  ]

  type CoProducts14[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] = ADTData[
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I4, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I5, DefaultAdtContext.type],
              RuntimeData[
                Adt.Context[A, I6, DefaultAdtContext.type],
                RuntimeData[
                  Adt.Context[A, I7, DefaultAdtContext.type],
                  RuntimeData[
                    Adt.Context[A, I8, DefaultAdtContext.type],
                    RuntimeData[
                      Adt.Context[A, I9, DefaultAdtContext.type],
                      RuntimeData[
                        Adt.Context[A, I10, DefaultAdtContext.type],
                        RuntimeData[
                          Adt.Context[A, I11, DefaultAdtContext.type],
                          RuntimeData[
                            Adt.Context[A, I12, DefaultAdtContext.type],
                            RuntimeData[
                              Adt.Context[A, I13, DefaultAdtContext.type],
                              RuntimeData[Adt.Context[A, I14, DefaultAdtContext.type], RuntimeZero]
                            ]
                          ]
                        ]
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
    ADTStatus.Passed.type with ADTFunctionImplicitFetch.type
  ]

  type CoProductsX14[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] = TypeAdtApply[
    A,
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I4, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I5, DefaultAdtContext.type],
              RuntimeData[
                Adt.Context[A, I6, DefaultAdtContext.type],
                RuntimeData[
                  Adt.Context[A, I7, DefaultAdtContext.type],
                  RuntimeData[
                    Adt.Context[A, I8, DefaultAdtContext.type],
                    RuntimeData[
                      Adt.Context[A, I9, DefaultAdtContext.type],
                      RuntimeData[
                        Adt.Context[A, I10, DefaultAdtContext.type],
                        RuntimeData[
                          Adt.Context[A, I11, DefaultAdtContext.type],
                          RuntimeData[
                            Adt.Context[A, I12, DefaultAdtContext.type],
                            RuntimeData[
                              Adt.Context[A, I13, DefaultAdtContext.type],
                              RuntimeData[Adt.Context[A, I14, DefaultAdtContext.type], RuntimeZero]
                            ]
                          ]
                        ]
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
    ST with ADTFunctionImplicitFetch.type
  ]

  type CoProducts15[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] = ADTData[
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I4, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I5, DefaultAdtContext.type],
              RuntimeData[
                Adt.Context[A, I6, DefaultAdtContext.type],
                RuntimeData[
                  Adt.Context[A, I7, DefaultAdtContext.type],
                  RuntimeData[
                    Adt.Context[A, I8, DefaultAdtContext.type],
                    RuntimeData[
                      Adt.Context[A, I9, DefaultAdtContext.type],
                      RuntimeData[
                        Adt.Context[A, I10, DefaultAdtContext.type],
                        RuntimeData[
                          Adt.Context[A, I11, DefaultAdtContext.type],
                          RuntimeData[
                            Adt.Context[A, I12, DefaultAdtContext.type],
                            RuntimeData[
                              Adt.Context[A, I13, DefaultAdtContext.type],
                              RuntimeData[
                                Adt.Context[A, I14, DefaultAdtContext.type],
                                RuntimeData[Adt.Context[A, I15, DefaultAdtContext.type], RuntimeZero]
                              ]
                            ]
                          ]
                        ]
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
    ADTStatus.Passed.type with ADTFunctionImplicitFetch.type
  ]

  type CoProductsX15[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] = TypeAdtApply[
    A,
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I4, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I5, DefaultAdtContext.type],
              RuntimeData[
                Adt.Context[A, I6, DefaultAdtContext.type],
                RuntimeData[
                  Adt.Context[A, I7, DefaultAdtContext.type],
                  RuntimeData[
                    Adt.Context[A, I8, DefaultAdtContext.type],
                    RuntimeData[
                      Adt.Context[A, I9, DefaultAdtContext.type],
                      RuntimeData[
                        Adt.Context[A, I10, DefaultAdtContext.type],
                        RuntimeData[
                          Adt.Context[A, I11, DefaultAdtContext.type],
                          RuntimeData[
                            Adt.Context[A, I12, DefaultAdtContext.type],
                            RuntimeData[
                              Adt.Context[A, I13, DefaultAdtContext.type],
                              RuntimeData[
                                Adt.Context[A, I14, DefaultAdtContext.type],
                                RuntimeData[Adt.Context[A, I15, DefaultAdtContext.type], RuntimeZero]
                              ]
                            ]
                          ]
                        ]
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
    ST with ADTFunctionImplicitFetch.type
  ]

  type CoProducts16[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] = ADTData[
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I4, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I5, DefaultAdtContext.type],
              RuntimeData[
                Adt.Context[A, I6, DefaultAdtContext.type],
                RuntimeData[
                  Adt.Context[A, I7, DefaultAdtContext.type],
                  RuntimeData[
                    Adt.Context[A, I8, DefaultAdtContext.type],
                    RuntimeData[
                      Adt.Context[A, I9, DefaultAdtContext.type],
                      RuntimeData[
                        Adt.Context[A, I10, DefaultAdtContext.type],
                        RuntimeData[
                          Adt.Context[A, I11, DefaultAdtContext.type],
                          RuntimeData[
                            Adt.Context[A, I12, DefaultAdtContext.type],
                            RuntimeData[
                              Adt.Context[A, I13, DefaultAdtContext.type],
                              RuntimeData[
                                Adt.Context[A, I14, DefaultAdtContext.type],
                                RuntimeData[
                                  Adt.Context[A, I15, DefaultAdtContext.type],
                                  RuntimeData[Adt.Context[A, I16, DefaultAdtContext.type], RuntimeZero]
                                ]
                              ]
                            ]
                          ]
                        ]
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
    ADTStatus.Passed.type with ADTFunctionImplicitFetch.type
  ]

  type CoProductsX16[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] = TypeAdtApply[
    A,
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I4, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I5, DefaultAdtContext.type],
              RuntimeData[
                Adt.Context[A, I6, DefaultAdtContext.type],
                RuntimeData[
                  Adt.Context[A, I7, DefaultAdtContext.type],
                  RuntimeData[
                    Adt.Context[A, I8, DefaultAdtContext.type],
                    RuntimeData[
                      Adt.Context[A, I9, DefaultAdtContext.type],
                      RuntimeData[
                        Adt.Context[A, I10, DefaultAdtContext.type],
                        RuntimeData[
                          Adt.Context[A, I11, DefaultAdtContext.type],
                          RuntimeData[
                            Adt.Context[A, I12, DefaultAdtContext.type],
                            RuntimeData[
                              Adt.Context[A, I13, DefaultAdtContext.type],
                              RuntimeData[
                                Adt.Context[A, I14, DefaultAdtContext.type],
                                RuntimeData[
                                  Adt.Context[A, I15, DefaultAdtContext.type],
                                  RuntimeData[Adt.Context[A, I16, DefaultAdtContext.type], RuntimeZero]
                                ]
                              ]
                            ]
                          ]
                        ]
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
    ST with ADTFunctionImplicitFetch.type
  ]

  type CoProducts17[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] = ADTData[
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I4, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I5, DefaultAdtContext.type],
              RuntimeData[
                Adt.Context[A, I6, DefaultAdtContext.type],
                RuntimeData[
                  Adt.Context[A, I7, DefaultAdtContext.type],
                  RuntimeData[
                    Adt.Context[A, I8, DefaultAdtContext.type],
                    RuntimeData[
                      Adt.Context[A, I9, DefaultAdtContext.type],
                      RuntimeData[
                        Adt.Context[A, I10, DefaultAdtContext.type],
                        RuntimeData[
                          Adt.Context[A, I11, DefaultAdtContext.type],
                          RuntimeData[
                            Adt.Context[A, I12, DefaultAdtContext.type],
                            RuntimeData[
                              Adt.Context[A, I13, DefaultAdtContext.type],
                              RuntimeData[
                                Adt.Context[A, I14, DefaultAdtContext.type],
                                RuntimeData[
                                  Adt.Context[A, I15, DefaultAdtContext.type],
                                  RuntimeData[
                                    Adt.Context[A, I16, DefaultAdtContext.type],
                                    RuntimeData[Adt.Context[A, I17, DefaultAdtContext.type], RuntimeZero]
                                  ]
                                ]
                              ]
                            ]
                          ]
                        ]
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
    ADTStatus.Passed.type with ADTFunctionImplicitFetch.type
  ]

  type CoProductsX17[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] = TypeAdtApply[
    A,
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I4, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I5, DefaultAdtContext.type],
              RuntimeData[
                Adt.Context[A, I6, DefaultAdtContext.type],
                RuntimeData[
                  Adt.Context[A, I7, DefaultAdtContext.type],
                  RuntimeData[
                    Adt.Context[A, I8, DefaultAdtContext.type],
                    RuntimeData[
                      Adt.Context[A, I9, DefaultAdtContext.type],
                      RuntimeData[
                        Adt.Context[A, I10, DefaultAdtContext.type],
                        RuntimeData[
                          Adt.Context[A, I11, DefaultAdtContext.type],
                          RuntimeData[
                            Adt.Context[A, I12, DefaultAdtContext.type],
                            RuntimeData[
                              Adt.Context[A, I13, DefaultAdtContext.type],
                              RuntimeData[
                                Adt.Context[A, I14, DefaultAdtContext.type],
                                RuntimeData[
                                  Adt.Context[A, I15, DefaultAdtContext.type],
                                  RuntimeData[
                                    Adt.Context[A, I16, DefaultAdtContext.type],
                                    RuntimeData[Adt.Context[A, I17, DefaultAdtContext.type], RuntimeZero]
                                  ]
                                ]
                              ]
                            ]
                          ]
                        ]
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
    ST with ADTFunctionImplicitFetch.type
  ]

  type CoProducts18[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] = ADTData[
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I4, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I5, DefaultAdtContext.type],
              RuntimeData[
                Adt.Context[A, I6, DefaultAdtContext.type],
                RuntimeData[
                  Adt.Context[A, I7, DefaultAdtContext.type],
                  RuntimeData[
                    Adt.Context[A, I8, DefaultAdtContext.type],
                    RuntimeData[
                      Adt.Context[A, I9, DefaultAdtContext.type],
                      RuntimeData[
                        Adt.Context[A, I10, DefaultAdtContext.type],
                        RuntimeData[
                          Adt.Context[A, I11, DefaultAdtContext.type],
                          RuntimeData[
                            Adt.Context[A, I12, DefaultAdtContext.type],
                            RuntimeData[
                              Adt.Context[A, I13, DefaultAdtContext.type],
                              RuntimeData[
                                Adt.Context[A, I14, DefaultAdtContext.type],
                                RuntimeData[
                                  Adt.Context[A, I15, DefaultAdtContext.type],
                                  RuntimeData[
                                    Adt.Context[A, I16, DefaultAdtContext.type],
                                    RuntimeData[
                                      Adt.Context[A, I17, DefaultAdtContext.type],
                                      RuntimeData[Adt.Context[A, I18, DefaultAdtContext.type], RuntimeZero]
                                    ]
                                  ]
                                ]
                              ]
                            ]
                          ]
                        ]
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
    ADTStatus.Passed.type with ADTFunctionImplicitFetch.type
  ]

  type CoProductsX18[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] = TypeAdtApply[
    A,
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I4, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I5, DefaultAdtContext.type],
              RuntimeData[
                Adt.Context[A, I6, DefaultAdtContext.type],
                RuntimeData[
                  Adt.Context[A, I7, DefaultAdtContext.type],
                  RuntimeData[
                    Adt.Context[A, I8, DefaultAdtContext.type],
                    RuntimeData[
                      Adt.Context[A, I9, DefaultAdtContext.type],
                      RuntimeData[
                        Adt.Context[A, I10, DefaultAdtContext.type],
                        RuntimeData[
                          Adt.Context[A, I11, DefaultAdtContext.type],
                          RuntimeData[
                            Adt.Context[A, I12, DefaultAdtContext.type],
                            RuntimeData[
                              Adt.Context[A, I13, DefaultAdtContext.type],
                              RuntimeData[
                                Adt.Context[A, I14, DefaultAdtContext.type],
                                RuntimeData[
                                  Adt.Context[A, I15, DefaultAdtContext.type],
                                  RuntimeData[
                                    Adt.Context[A, I16, DefaultAdtContext.type],
                                    RuntimeData[
                                      Adt.Context[A, I17, DefaultAdtContext.type],
                                      RuntimeData[Adt.Context[A, I18, DefaultAdtContext.type], RuntimeZero]
                                    ]
                                  ]
                                ]
                              ]
                            ]
                          ]
                        ]
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
    ST with ADTFunctionImplicitFetch.type
  ]

  type CoProducts19[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] = ADTData[
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I4, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I5, DefaultAdtContext.type],
              RuntimeData[
                Adt.Context[A, I6, DefaultAdtContext.type],
                RuntimeData[
                  Adt.Context[A, I7, DefaultAdtContext.type],
                  RuntimeData[
                    Adt.Context[A, I8, DefaultAdtContext.type],
                    RuntimeData[
                      Adt.Context[A, I9, DefaultAdtContext.type],
                      RuntimeData[
                        Adt.Context[A, I10, DefaultAdtContext.type],
                        RuntimeData[
                          Adt.Context[A, I11, DefaultAdtContext.type],
                          RuntimeData[
                            Adt.Context[A, I12, DefaultAdtContext.type],
                            RuntimeData[
                              Adt.Context[A, I13, DefaultAdtContext.type],
                              RuntimeData[
                                Adt.Context[A, I14, DefaultAdtContext.type],
                                RuntimeData[
                                  Adt.Context[A, I15, DefaultAdtContext.type],
                                  RuntimeData[
                                    Adt.Context[A, I16, DefaultAdtContext.type],
                                    RuntimeData[
                                      Adt.Context[A, I17, DefaultAdtContext.type],
                                      RuntimeData[
                                        Adt.Context[A, I18, DefaultAdtContext.type],
                                        RuntimeData[Adt.Context[A, I19, DefaultAdtContext.type], RuntimeZero]
                                      ]
                                    ]
                                  ]
                                ]
                              ]
                            ]
                          ]
                        ]
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
    ADTStatus.Passed.type with ADTFunctionImplicitFetch.type
  ]

  type CoProductsX19[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] =
    TypeAdtApply[
      A,
      RuntimeData[
        Adt.Context[A, I1, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I2, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I3, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I4, DefaultAdtContext.type],
              RuntimeData[
                Adt.Context[A, I5, DefaultAdtContext.type],
                RuntimeData[
                  Adt.Context[A, I6, DefaultAdtContext.type],
                  RuntimeData[
                    Adt.Context[A, I7, DefaultAdtContext.type],
                    RuntimeData[
                      Adt.Context[A, I8, DefaultAdtContext.type],
                      RuntimeData[
                        Adt.Context[A, I9, DefaultAdtContext.type],
                        RuntimeData[
                          Adt.Context[A, I10, DefaultAdtContext.type],
                          RuntimeData[
                            Adt.Context[A, I11, DefaultAdtContext.type],
                            RuntimeData[
                              Adt.Context[A, I12, DefaultAdtContext.type],
                              RuntimeData[
                                Adt.Context[A, I13, DefaultAdtContext.type],
                                RuntimeData[
                                  Adt.Context[A, I14, DefaultAdtContext.type],
                                  RuntimeData[
                                    Adt.Context[A, I15, DefaultAdtContext.type],
                                    RuntimeData[
                                      Adt.Context[A, I16, DefaultAdtContext.type],
                                      RuntimeData[
                                        Adt.Context[A, I17, DefaultAdtContext.type],
                                        RuntimeData[
                                          Adt.Context[A, I18, DefaultAdtContext.type],
                                          RuntimeData[Adt.Context[A, I19, DefaultAdtContext.type], RuntimeZero]
                                        ]
                                      ]
                                    ]
                                  ]
                                ]
                              ]
                            ]
                          ]
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
      ST with ADTFunctionImplicitFetch.type
    ]

  type CoProducts20[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] = ADTData[
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I4, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I5, DefaultAdtContext.type],
              RuntimeData[
                Adt.Context[A, I6, DefaultAdtContext.type],
                RuntimeData[
                  Adt.Context[A, I7, DefaultAdtContext.type],
                  RuntimeData[
                    Adt.Context[A, I8, DefaultAdtContext.type],
                    RuntimeData[
                      Adt.Context[A, I9, DefaultAdtContext.type],
                      RuntimeData[
                        Adt.Context[A, I10, DefaultAdtContext.type],
                        RuntimeData[
                          Adt.Context[A, I11, DefaultAdtContext.type],
                          RuntimeData[
                            Adt.Context[A, I12, DefaultAdtContext.type],
                            RuntimeData[
                              Adt.Context[A, I13, DefaultAdtContext.type],
                              RuntimeData[
                                Adt.Context[A, I14, DefaultAdtContext.type],
                                RuntimeData[
                                  Adt.Context[A, I15, DefaultAdtContext.type],
                                  RuntimeData[
                                    Adt.Context[A, I16, DefaultAdtContext.type],
                                    RuntimeData[
                                      Adt.Context[A, I17, DefaultAdtContext.type],
                                      RuntimeData[
                                        Adt.Context[A, I18, DefaultAdtContext.type],
                                        RuntimeData[
                                          Adt.Context[A, I19, DefaultAdtContext.type],
                                          RuntimeData[Adt.Context[A, I20, DefaultAdtContext.type], RuntimeZero]
                                        ]
                                      ]
                                    ]
                                  ]
                                ]
                              ]
                            ]
                          ]
                        ]
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
    ADTStatus.Passed.type with ADTFunctionImplicitFetch.type
  ]

  type CoProductsX20[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] =
    TypeAdtApply[
      A,
      RuntimeData[
        Adt.Context[A, I1, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I2, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I3, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I4, DefaultAdtContext.type],
              RuntimeData[
                Adt.Context[A, I5, DefaultAdtContext.type],
                RuntimeData[
                  Adt.Context[A, I6, DefaultAdtContext.type],
                  RuntimeData[
                    Adt.Context[A, I7, DefaultAdtContext.type],
                    RuntimeData[
                      Adt.Context[A, I8, DefaultAdtContext.type],
                      RuntimeData[
                        Adt.Context[A, I9, DefaultAdtContext.type],
                        RuntimeData[
                          Adt.Context[A, I10, DefaultAdtContext.type],
                          RuntimeData[
                            Adt.Context[A, I11, DefaultAdtContext.type],
                            RuntimeData[
                              Adt.Context[A, I12, DefaultAdtContext.type],
                              RuntimeData[
                                Adt.Context[A, I13, DefaultAdtContext.type],
                                RuntimeData[
                                  Adt.Context[A, I14, DefaultAdtContext.type],
                                  RuntimeData[
                                    Adt.Context[A, I15, DefaultAdtContext.type],
                                    RuntimeData[
                                      Adt.Context[A, I16, DefaultAdtContext.type],
                                      RuntimeData[
                                        Adt.Context[A, I17, DefaultAdtContext.type],
                                        RuntimeData[
                                          Adt.Context[A, I18, DefaultAdtContext.type],
                                          RuntimeData[
                                            Adt.Context[A, I19, DefaultAdtContext.type],
                                            RuntimeData[Adt.Context[A, I20, DefaultAdtContext.type], RuntimeZero]
                                          ]
                                        ]
                                      ]
                                    ]
                                  ]
                                ]
                              ]
                            ]
                          ]
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
      ST with ADTFunctionImplicitFetch.type
    ]

  type CoProducts21[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] = ADTData[
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I4, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I5, DefaultAdtContext.type],
              RuntimeData[
                Adt.Context[A, I6, DefaultAdtContext.type],
                RuntimeData[
                  Adt.Context[A, I7, DefaultAdtContext.type],
                  RuntimeData[
                    Adt.Context[A, I8, DefaultAdtContext.type],
                    RuntimeData[
                      Adt.Context[A, I9, DefaultAdtContext.type],
                      RuntimeData[
                        Adt.Context[A, I10, DefaultAdtContext.type],
                        RuntimeData[
                          Adt.Context[A, I11, DefaultAdtContext.type],
                          RuntimeData[
                            Adt.Context[A, I12, DefaultAdtContext.type],
                            RuntimeData[
                              Adt.Context[A, I13, DefaultAdtContext.type],
                              RuntimeData[
                                Adt.Context[A, I14, DefaultAdtContext.type],
                                RuntimeData[
                                  Adt.Context[A, I15, DefaultAdtContext.type],
                                  RuntimeData[
                                    Adt.Context[A, I16, DefaultAdtContext.type],
                                    RuntimeData[
                                      Adt.Context[A, I17, DefaultAdtContext.type],
                                      RuntimeData[
                                        Adt.Context[A, I18, DefaultAdtContext.type],
                                        RuntimeData[
                                          Adt.Context[A, I19, DefaultAdtContext.type],
                                          RuntimeData[
                                            Adt.Context[A, I20, DefaultAdtContext.type],
                                            RuntimeData[Adt.Context[A, I21, DefaultAdtContext.type], RuntimeZero]
                                          ]
                                        ]
                                      ]
                                    ]
                                  ]
                                ]
                              ]
                            ]
                          ]
                        ]
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
    ADTStatus.Passed.type with ADTFunctionImplicitFetch.type
  ]

  type CoProductsX21[A, ST <: ADTStatus, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] =
    TypeAdtApply[
      A,
      RuntimeData[
        Adt.Context[A, I1, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I2, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I3, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I4, DefaultAdtContext.type],
              RuntimeData[
                Adt.Context[A, I5, DefaultAdtContext.type],
                RuntimeData[
                  Adt.Context[A, I6, DefaultAdtContext.type],
                  RuntimeData[
                    Adt.Context[A, I7, DefaultAdtContext.type],
                    RuntimeData[
                      Adt.Context[A, I8, DefaultAdtContext.type],
                      RuntimeData[
                        Adt.Context[A, I9, DefaultAdtContext.type],
                        RuntimeData[
                          Adt.Context[A, I10, DefaultAdtContext.type],
                          RuntimeData[
                            Adt.Context[A, I11, DefaultAdtContext.type],
                            RuntimeData[
                              Adt.Context[A, I12, DefaultAdtContext.type],
                              RuntimeData[
                                Adt.Context[A, I13, DefaultAdtContext.type],
                                RuntimeData[
                                  Adt.Context[A, I14, DefaultAdtContext.type],
                                  RuntimeData[
                                    Adt.Context[A, I15, DefaultAdtContext.type],
                                    RuntimeData[
                                      Adt.Context[A, I16, DefaultAdtContext.type],
                                      RuntimeData[
                                        Adt.Context[A, I17, DefaultAdtContext.type],
                                        RuntimeData[
                                          Adt.Context[A, I18, DefaultAdtContext.type],
                                          RuntimeData[
                                            Adt.Context[A, I19, DefaultAdtContext.type],
                                            RuntimeData[
                                              Adt.Context[A, I20, DefaultAdtContext.type],
                                              RuntimeData[Adt.Context[A, I21, DefaultAdtContext.type], RuntimeZero]
                                            ]
                                          ]
                                        ]
                                      ]
                                    ]
                                  ]
                                ]
                              ]
                            ]
                          ]
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
      ST with ADTFunctionImplicitFetch.type
    ]

  type CoProducts22[A, I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22] = ADTData[
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I4, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I5, DefaultAdtContext.type],
              RuntimeData[
                Adt.Context[A, I6, DefaultAdtContext.type],
                RuntimeData[
                  Adt.Context[A, I7, DefaultAdtContext.type],
                  RuntimeData[
                    Adt.Context[A, I8, DefaultAdtContext.type],
                    RuntimeData[
                      Adt.Context[A, I9, DefaultAdtContext.type],
                      RuntimeData[
                        Adt.Context[A, I10, DefaultAdtContext.type],
                        RuntimeData[
                          Adt.Context[A, I11, DefaultAdtContext.type],
                          RuntimeData[
                            Adt.Context[A, I12, DefaultAdtContext.type],
                            RuntimeData[
                              Adt.Context[A, I13, DefaultAdtContext.type],
                              RuntimeData[
                                Adt.Context[A, I14, DefaultAdtContext.type],
                                RuntimeData[
                                  Adt.Context[A, I15, DefaultAdtContext.type],
                                  RuntimeData[
                                    Adt.Context[A, I16, DefaultAdtContext.type],
                                    RuntimeData[
                                      Adt.Context[A, I17, DefaultAdtContext.type],
                                      RuntimeData[
                                        Adt.Context[A, I18, DefaultAdtContext.type],
                                        RuntimeData[
                                          Adt.Context[A, I19, DefaultAdtContext.type],
                                          RuntimeData[
                                            Adt.Context[A, I20, DefaultAdtContext.type],
                                            RuntimeData[
                                              Adt.Context[A, I21, DefaultAdtContext.type],
                                              RuntimeData[Adt.Context[A, I22, DefaultAdtContext.type], RuntimeZero]
                                            ]
                                          ]
                                        ]
                                      ]
                                    ]
                                  ]
                                ]
                              ]
                            ]
                          ]
                        ]
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
    ADTStatus.Passed.type with ADTFunctionImplicitFetch.type
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
    RuntimeData[
      Adt.Context[A, I1, DefaultAdtContext.type],
      RuntimeData[
        Adt.Context[A, I2, DefaultAdtContext.type],
        RuntimeData[
          Adt.Context[A, I3, DefaultAdtContext.type],
          RuntimeData[
            Adt.Context[A, I4, DefaultAdtContext.type],
            RuntimeData[
              Adt.Context[A, I5, DefaultAdtContext.type],
              RuntimeData[
                Adt.Context[A, I6, DefaultAdtContext.type],
                RuntimeData[
                  Adt.Context[A, I7, DefaultAdtContext.type],
                  RuntimeData[
                    Adt.Context[A, I8, DefaultAdtContext.type],
                    RuntimeData[
                      Adt.Context[A, I9, DefaultAdtContext.type],
                      RuntimeData[
                        Adt.Context[A, I10, DefaultAdtContext.type],
                        RuntimeData[
                          Adt.Context[A, I11, DefaultAdtContext.type],
                          RuntimeData[
                            Adt.Context[A, I12, DefaultAdtContext.type],
                            RuntimeData[
                              Adt.Context[A, I13, DefaultAdtContext.type],
                              RuntimeData[
                                Adt.Context[A, I14, DefaultAdtContext.type],
                                RuntimeData[
                                  Adt.Context[A, I15, DefaultAdtContext.type],
                                  RuntimeData[
                                    Adt.Context[A, I16, DefaultAdtContext.type],
                                    RuntimeData[
                                      Adt.Context[A, I17, DefaultAdtContext.type],
                                      RuntimeData[
                                        Adt.Context[A, I18, DefaultAdtContext.type],
                                        RuntimeData[
                                          Adt.Context[A, I19, DefaultAdtContext.type],
                                          RuntimeData[
                                            Adt.Context[A, I20, DefaultAdtContext.type],
                                            RuntimeData[
                                              Adt.Context[A, I21, DefaultAdtContext.type],
                                              RuntimeData[Adt.Context[A, I22, DefaultAdtContext.type], RuntimeZero]
                                            ]
                                          ]
                                        ]
                                      ]
                                    ]
                                  ]
                                ]
                              ]
                            ]
                          ]
                        ]
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
    ST with ADTFunctionImplicitFetch.type
  ]

}
