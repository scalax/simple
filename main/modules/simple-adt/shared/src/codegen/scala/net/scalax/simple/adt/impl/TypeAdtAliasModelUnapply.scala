package net.scalax.simple
package adt
package impl

import temp._
import Adt.{Status => ADTStatus}
import net.scalax.simple.ghdmzsk.ghdmzsk
import net.scalax.simple.adt.{RuntimeData, RuntimeNat, RuntimeZero}

trait TypeAdtAliasModelUnapply {

  object CoProduct1 {
    def unapply[I1, S <: ADTStatus](data: ADTData[RuntimeZero, S]): Option[I1] = {
      // val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => ADTGHDMZSK.TakePropertyUtils.cutADTListByIndex)
      // val model: ghdmzsk = dataInstance.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options1GHDMZSK)
      // model match {
      //     case u: ADTGHDMZSK.GetValue => Some(u.value.asInstanceOf[I1])
      //     case _ => Option.empty
      // }

      Option.empty
    }
  }

  object CoProduct2 {
    def unapply[I1, I2, S <: ADTStatus](data: ADTData[RuntimeData[I1, RuntimeZero], S]): Option[I2] = {
      // val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => ADTGHDMZSK.TakePropertyUtils.cutADTListByIndex)
      // val model: ghdmzsk = dataInstance.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options2GHDMZSK)
      // model match {
      //     case u: ADTGHDMZSK.GetValue => Some(u.value.asInstanceOf[I2])
      //     case _ => Option.empty
      // }

      Option.empty
    }
  }

  object CoProduct3 {
    def unapply[I1, I2, I3, S <: ADTStatus](data: ADTData[RuntimeData[I1, RuntimeData[I2, RuntimeZero]], S]): Option[I3] = {
      // val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => ADTGHDMZSK.TakePropertyUtils.cutADTListByIndex)
      // val model: ghdmzsk = dataInstance.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options3GHDMZSK)
      // model match {
      //     case u: ADTGHDMZSK.GetValue => Some(u.value.asInstanceOf[I3])
      //     case _ => Option.empty
      // }

      Option.empty
    }
  }

  object CoProduct4 {
    def unapply[I1, I2, I3, I4, S <: ADTStatus](
      data: ADTData[RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeZero]]], S]
    ): Option[I4] = {
      // val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => ADTGHDMZSK.TakePropertyUtils.cutADTListByIndex)
      // val model: ghdmzsk = dataInstance.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options4GHDMZSK)
      // model match {
      //     case u: ADTGHDMZSK.GetValue => Some(u.value.asInstanceOf[I4])
      //     case _ => Option.empty
      // }

      Option.empty
    }
  }

  object CoProduct5 {
    def unapply[I1, I2, I3, I4, I5, S <: ADTStatus](
      data: ADTData[RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeZero]]]], S]
    ): Option[I5] = {
      // val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => ADTGHDMZSK.TakePropertyUtils.cutADTListByIndex)
      // val model: ghdmzsk = dataInstance.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options5GHDMZSK)
      // model match {
      //     case u: ADTGHDMZSK.GetValue => Some(u.value.asInstanceOf[I5])
      //     case _ => Option.empty
      // }

      Option.empty
    }
  }

  object CoProduct6 {
    def unapply[I1, I2, I3, I4, I5, I6, S <: ADTStatus](
      data: ADTData[RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeZero]]]]], S]
    ): Option[I6] = {
      // val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => ADTGHDMZSK.TakePropertyUtils.cutADTListByIndex)
      // val model: ghdmzsk = dataInstance.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options6GHDMZSK)
      // model match {
      //     case u: ADTGHDMZSK.GetValue => Some(u.value.asInstanceOf[I6])
      //     case _ => Option.empty
      // }

      Option.empty
    }
  }

  object CoProduct7 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, S <: ADTStatus](
      data: ADTData[RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeData[I6, RuntimeZero]]]]]], S]
    ): Option[I7] = {
      // val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => ADTGHDMZSK.TakePropertyUtils.cutADTListByIndex)
      // val model: ghdmzsk = dataInstance.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options7GHDMZSK)
      // model match {
      //     case u: ADTGHDMZSK.GetValue => Some(u.value.asInstanceOf[I7])
      //     case _ => Option.empty
      // }

      Option.empty
    }
  }

  object CoProduct8 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, I8, S <: ADTStatus](
      data: ADTData[
        RuntimeData[I1, RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeData[I6, RuntimeData[I7, RuntimeZero]]]]]]],
        S
      ]
    ): Option[I8] = {
      // val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => ADTGHDMZSK.TakePropertyUtils.cutADTListByIndex)
      // val model: ghdmzsk = dataInstance.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options8GHDMZSK)
      // model match {
      //     case u: ADTGHDMZSK.GetValue => Some(u.value.asInstanceOf[I8])
      //     case _ => Option.empty
      // }

      Option.empty
    }
  }

  object CoProduct9 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, I8, I9, S <: ADTStatus](
      data: ADTData[RuntimeData[
        I1,
        RuntimeData[I2, RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeData[I6, RuntimeData[I7, RuntimeData[I8, RuntimeZero]]]]]]]
      ], S]
    ): Option[I9] = {
      // val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => ADTGHDMZSK.TakePropertyUtils.cutADTListByIndex)
      // val model: ghdmzsk = dataInstance.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options9GHDMZSK)
      // model match {
      //     case u: ADTGHDMZSK.GetValue => Some(u.value.asInstanceOf[I9])
      //     case _ => Option.empty
      // }

      Option.empty
    }
  }

  object CoProduct10 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, S <: ADTStatus](
      data: ADTData[
        RuntimeData[I1, RuntimeData[
          I2,
          RuntimeData[I3, RuntimeData[I4, RuntimeData[I5, RuntimeData[I6, RuntimeData[I7, RuntimeData[I8, RuntimeData[I9, RuntimeZero]]]]]]]
        ]],
        S
      ]
    ): Option[I10] = {
      // val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => ADTGHDMZSK.TakePropertyUtils.cutADTListByIndex)
      // val model: ghdmzsk = dataInstance.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options10GHDMZSK)
      // model match {
      //     case u: ADTGHDMZSK.GetValue => Some(u.value.asInstanceOf[I10])
      //     case _ => Option.empty
      // }

      Option.empty
    }
  }

  object CoProduct11 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, S <: ADTStatus](
      data: ADTData[
        RuntimeData[
          I1,
          RuntimeData[I2, RuntimeData[I3, RuntimeData[
            I4,
            RuntimeData[I5, RuntimeData[I6, RuntimeData[I7, RuntimeData[I8, RuntimeData[I9, RuntimeData[I10, RuntimeZero]]]]]]
          ]]]
        ],
        S
      ]
    ): Option[I11] = {
      // val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => ADTGHDMZSK.TakePropertyUtils.cutADTListByIndex)
      // val model: ghdmzsk = dataInstance.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options11GHDMZSK)
      // model match {
      //     case u: ADTGHDMZSK.GetValue => Some(u.value.asInstanceOf[I11])
      //     case _ => Option.empty
      // }

      Option.empty
    }
  }

  object CoProduct12 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, S <: ADTStatus](
      data: ADTData[
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
        S
      ]
    ): Option[I12] = {
      // val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => ADTGHDMZSK.TakePropertyUtils.cutADTListByIndex)
      // val model: ghdmzsk = dataInstance.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options12GHDMZSK)
      // model match {
      //     case u: ADTGHDMZSK.GetValue => Some(u.value.asInstanceOf[I12])
      //     case _ => Option.empty
      // }

      Option.empty
    }
  }

  object CoProduct13 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, S <: ADTStatus](
      data: ADTData[
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
        S
      ]
    ): Option[I13] = {
      // val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => ADTGHDMZSK.TakePropertyUtils.cutADTListByIndex)
      // val model: ghdmzsk = dataInstance.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options13GHDMZSK)
      // model match {
      //     case u: ADTGHDMZSK.GetValue => Some(u.value.asInstanceOf[I13])
      //     case _ => Option.empty
      // }

      Option.empty
    }
  }

  object CoProduct14 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, S <: ADTStatus](
      data: ADTData[
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
        S
      ]
    ): Option[I14] = {
      // val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => ADTGHDMZSK.TakePropertyUtils.cutADTListByIndex)
      // val model: ghdmzsk = dataInstance.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options14GHDMZSK)
      // model match {
      //     case u: ADTGHDMZSK.GetValue => Some(u.value.asInstanceOf[I14])
      //     case _ => Option.empty
      // }

      Option.empty
    }
  }

  object CoProduct15 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, S <: ADTStatus](
      data: ADTData[
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
        S
      ]
    ): Option[I15] = {
      // val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => ADTGHDMZSK.TakePropertyUtils.cutADTListByIndex)
      // val model: ghdmzsk = dataInstance.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options15GHDMZSK)
      // model match {
      //     case u: ADTGHDMZSK.GetValue => Some(u.value.asInstanceOf[I15])
      //     case _ => Option.empty
      // }

      Option.empty
    }
  }

  object CoProduct16 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, S <: ADTStatus](
      data: ADTData[
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
                    RuntimeData[I7, RuntimeData[I8, RuntimeData[I9, RuntimeData[
                      I10,
                      RuntimeData[I11, RuntimeData[I12, RuntimeData[I13, RuntimeData[I14, RuntimeData[I15, RuntimeZero]]]]]
                    ]]]]
                  ]
                ]
              ]
            ]
          ]
        ],
        S
      ]
    ): Option[I16] = {
      // val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => ADTGHDMZSK.TakePropertyUtils.cutADTListByIndex)
      // val model: ghdmzsk = dataInstance.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options16GHDMZSK)
      // model match {
      //     case u: ADTGHDMZSK.GetValue => Some(u.value.asInstanceOf[I16])
      //     case _ => Option.empty
      // }

      Option.empty
    }
  }

  object CoProduct17 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, S <: ADTStatus](
      data: ADTData[
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
                      RuntimeData[I8, RuntimeData[I9, RuntimeData[I10, RuntimeData[
                        I11,
                        RuntimeData[I12, RuntimeData[I13, RuntimeData[I14, RuntimeData[I15, RuntimeData[I16, RuntimeZero]]]]]
                      ]]]]
                    ]
                  ]
                ]
              ]
            ]
          ]
        ],
        S
      ]
    ): Option[I17] = {
      // val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => ADTGHDMZSK.TakePropertyUtils.cutADTListByIndex)
      // val model: ghdmzsk = dataInstance.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options17GHDMZSK)
      // model match {
      //     case u: ADTGHDMZSK.GetValue => Some(u.value.asInstanceOf[I17])
      //     case _ => Option.empty
      // }

      Option.empty
    }
  }

  object CoProduct18 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, S <: ADTStatus](
      data: ADTData[
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
        S
      ]
    ): Option[I18] = {
      // val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => ADTGHDMZSK.TakePropertyUtils.cutADTListByIndex)
      // val model: ghdmzsk = dataInstance.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options18GHDMZSK)
      // model match {
      //     case u: ADTGHDMZSK.GetValue => Some(u.value.asInstanceOf[I18])
      //     case _ => Option.empty
      // }

      Option.empty
    }
  }

  object CoProduct19 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, S <: ADTStatus](
      data: ADTData[
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
        S
      ]
    ): Option[I19] = {
      // val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => ADTGHDMZSK.TakePropertyUtils.cutADTListByIndex)
      // val model: ghdmzsk = dataInstance.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options19GHDMZSK)
      // model match {
      //     case u: ADTGHDMZSK.GetValue => Some(u.value.asInstanceOf[I19])
      //     case _ => Option.empty
      // }

      Option.empty
    }
  }

  object CoProduct20 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, S <: ADTStatus](
      data: ADTData[
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
        S
      ]
    ): Option[I20] = {
      // val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => ADTGHDMZSK.TakePropertyUtils.cutADTListByIndex)
      // val model: ghdmzsk = dataInstance.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options20GHDMZSK)
      // model match {
      //     case u: ADTGHDMZSK.GetValue => Some(u.value.asInstanceOf[I20])
      //     case _ => Option.empty
      // }

      Option.empty
    }
  }

  object CoProduct21 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, S <: ADTStatus](
      data: ADTData[
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
        S
      ]
    ): Option[I21] = {
      // val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => ADTGHDMZSK.TakePropertyUtils.cutADTListByIndex)
      // val model: ghdmzsk = dataInstance.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options21GHDMZSK)
      // model match {
      //     case u: ADTGHDMZSK.GetValue => Some(u.value.asInstanceOf[I21])
      //     case _ => Option.empty
      // }

      Option.empty
    }
  }

  object CoProduct22 {
    def unapply[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22, S <: ADTStatus](
      data: ADTData[
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
        S
      ]
    ): Option[I22] = {
      // val dataInstance: ghdmzsk = data.toGHDMZSK.inputGHDMZSK(() => ADTGHDMZSK.TakePropertyUtils.cutADTListByIndex)
      // val model: ghdmzsk = dataInstance.inputGHDMZSK(() => impl.TypeAdtAliasModelUnapplyGhdmzsk.options22GHDMZSK)
      // model match {
      //     case u: ADTGHDMZSK.GetValue => Some(u.value.asInstanceOf[I22])
      //     case _ => Option.empty
      // }

      Option.empty
    }
  }

}

package impl {
  object TypeAdtAliasModelUnapplyGhdmzsk {
    val options1GHDMZSK: ghdmzsk = ??? // ADTGHDMZSK.zeroPositive

    val options2GHDMZSK: ghdmzsk = ??? // ADTGHDMZSK.tempPositive.inputGHDMZSK(() => options1GHDMZSK)

    val options3GHDMZSK: ghdmzsk = ??? // ADTGHDMZSK.tempPositive.inputGHDMZSK(() => options2GHDMZSK)

    val options4GHDMZSK: ghdmzsk = ??? // ADTGHDMZSK.tempPositive.inputGHDMZSK(() => options3GHDMZSK)

    val options5GHDMZSK: ghdmzsk = ??? // ADTGHDMZSK.tempPositive.inputGHDMZSK(() => options4GHDMZSK)

    val options6GHDMZSK: ghdmzsk = ??? // ADTGHDMZSK.tempPositive.inputGHDMZSK(() => options5GHDMZSK)

    val options7GHDMZSK: ghdmzsk = ??? // ADTGHDMZSK.tempPositive.inputGHDMZSK(() => options6GHDMZSK)

    val options8GHDMZSK: ghdmzsk = ??? // ADTGHDMZSK.tempPositive.inputGHDMZSK(() => options7GHDMZSK)

    val options9GHDMZSK: ghdmzsk = ??? // ADTGHDMZSK.tempPositive.inputGHDMZSK(() => options8GHDMZSK)

    val options10GHDMZSK: ghdmzsk = ??? // ADTGHDMZSK.tempPositive.inputGHDMZSK(() => options9GHDMZSK)

    val options11GHDMZSK: ghdmzsk = ??? // ADTGHDMZSK.tempPositive.inputGHDMZSK(() => options10GHDMZSK)

    val options12GHDMZSK: ghdmzsk = ??? // ADTGHDMZSK.tempPositive.inputGHDMZSK(() => options11GHDMZSK)

    val options13GHDMZSK: ghdmzsk = ??? // ADTGHDMZSK.tempPositive.inputGHDMZSK(() => options12GHDMZSK)

    val options14GHDMZSK: ghdmzsk = ??? // ADTGHDMZSK.tempPositive.inputGHDMZSK(() => options13GHDMZSK)

    val options15GHDMZSK: ghdmzsk = ??? // ADTGHDMZSK.tempPositive.inputGHDMZSK(() => options14GHDMZSK)

    val options16GHDMZSK: ghdmzsk = ??? // ADTGHDMZSK.tempPositive.inputGHDMZSK(() => options15GHDMZSK)

    val options17GHDMZSK: ghdmzsk = ??? // ADTGHDMZSK.tempPositive.inputGHDMZSK(() => options16GHDMZSK)

    val options18GHDMZSK: ghdmzsk = ??? // ADTGHDMZSK.tempPositive.inputGHDMZSK(() => options17GHDMZSK)

    val options19GHDMZSK: ghdmzsk = ??? // ADTGHDMZSK.tempPositive.inputGHDMZSK(() => options18GHDMZSK)

    val options20GHDMZSK: ghdmzsk = ??? // ADTGHDMZSK.tempPositive.inputGHDMZSK(() => options19GHDMZSK)

    val options21GHDMZSK: ghdmzsk = ??? // ADTGHDMZSK.tempPositive.inputGHDMZSK(() => options20GHDMZSK)

    val options22GHDMZSK: ghdmzsk = ??? // ADTGHDMZSK.tempPositive.inputGHDMZSK(() => options21GHDMZSK)

  }
}
