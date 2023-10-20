package net.scalax.simple.adt
package impl

import net.scalax.simple.ghdmzsk.ghdmzsk
import implemention.ADTGHDMZSK
import temp._
import Adt.{Status => ADTStatus}
import net.scalax.simple.adt.nat.{AdtNat, AdtNatPositive, AdtNatZero}

trait ADTPassedFunction {

  implicit class extra1[I1, S <: ADTStatus](private val data: ADTData[AdtNatPositive[I1, AdtNatZero], S]) {
    def fold[D](
      func1: I1 => D
    ): D = {
      val adtDataGHDMZSK = data.toGHDMZSK
      val dataInstance: Any = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.findADTData)
        .inputGHDMZSK(ADTGHDMZSK.identityGhdmzsk)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
      val funcs = List(
        func1
      )
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val funcInstance = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.cutInputFunctionByADTList)
        .inputGHDMZSK(listFunc)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra2[I1, I2, S <: ADTStatus](private val data: ADTData[AdtNatPositive[I1, AdtNatPositive[I2, AdtNatZero]], S]) {
    def fold[D](
      func1: I1 => D,
      func2: I2 => D
    ): D = {
      val adtDataGHDMZSK = data.toGHDMZSK
      val dataInstance: Any = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.findADTData)
        .inputGHDMZSK(ADTGHDMZSK.identityGhdmzsk)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
      val funcs = List(
        func1,
        func2
      )
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val funcInstance = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.cutInputFunctionByADTList)
        .inputGHDMZSK(listFunc)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra3[I1, I2, I3, S <: ADTStatus](
    private val data: ADTData[AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatZero]]], S]
  ) {
    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D
    ): D = {
      val adtDataGHDMZSK = data.toGHDMZSK
      val dataInstance: Any = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.findADTData)
        .inputGHDMZSK(ADTGHDMZSK.identityGhdmzsk)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
      val funcs = List(
        func1,
        func2,
        func3
      )
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val funcInstance = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.cutInputFunctionByADTList)
        .inputGHDMZSK(listFunc)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra4[I1, I2, I3, I4, S <: ADTStatus](
    private val data: ADTData[AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatZero]]]], S]
  ) {
    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D
    ): D = {
      val adtDataGHDMZSK = data.toGHDMZSK
      val dataInstance: Any = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.findADTData)
        .inputGHDMZSK(ADTGHDMZSK.identityGhdmzsk)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
      val funcs = List(
        func1,
        func2,
        func3,
        func4
      )
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val funcInstance = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.cutInputFunctionByADTList)
        .inputGHDMZSK(listFunc)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra5[I1, I2, I3, I4, I5, S <: ADTStatus](
    private val data: ADTData[
      AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatZero]]]]],
      S
    ]
  ) {
    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D
    ): D = {
      val adtDataGHDMZSK = data.toGHDMZSK
      val dataInstance: Any = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.findADTData)
        .inputGHDMZSK(ADTGHDMZSK.identityGhdmzsk)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
      val funcs = List(
        func1,
        func2,
        func3,
        func4,
        func5
      )
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val funcInstance = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.cutInputFunctionByADTList)
        .inputGHDMZSK(listFunc)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra6[I1, I2, I3, I4, I5, I6, S <: ADTStatus](
    private val data: ADTData[
      AdtNatPositive[I1, AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatZero]]]]]],
      S
    ]
  ) {
    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D
    ): D = {
      val adtDataGHDMZSK = data.toGHDMZSK
      val dataInstance: Any = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.findADTData)
        .inputGHDMZSK(ADTGHDMZSK.identityGhdmzsk)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
      val funcs = List(
        func1,
        func2,
        func3,
        func4,
        func5,
        func6
      )
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val funcInstance = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.cutInputFunctionByADTList)
        .inputGHDMZSK(listFunc)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra7[I1, I2, I3, I4, I5, I6, I7, S <: ADTStatus](
    private val data: ADTData[AdtNatPositive[
      I1,
      AdtNatPositive[I2, AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[I7, AdtNatZero]]]]]]
    ], S]
  ) {
    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D,
      func7: I7 => D
    ): D = {
      val adtDataGHDMZSK = data.toGHDMZSK
      val dataInstance: Any = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.findADTData)
        .inputGHDMZSK(ADTGHDMZSK.identityGhdmzsk)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
      val funcs = List(
        func1,
        func2,
        func3,
        func4,
        func5,
        func6,
        func7
      )
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val funcInstance = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.cutInputFunctionByADTList)
        .inputGHDMZSK(listFunc)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra8[I1, I2, I3, I4, I5, I6, I7, I8, S <: ADTStatus](
    private val data: ADTData[
      AdtNatPositive[I1, AdtNatPositive[
        I2,
        AdtNatPositive[I3, AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[I7, AdtNatPositive[I8, AdtNatZero]]]]]]
      ]],
      S
    ]
  ) {
    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D,
      func7: I7 => D,
      func8: I8 => D
    ): D = {
      val adtDataGHDMZSK = data.toGHDMZSK
      val dataInstance: Any = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.findADTData)
        .inputGHDMZSK(ADTGHDMZSK.identityGhdmzsk)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
      val funcs = List(
        func1,
        func2,
        func3,
        func4,
        func5,
        func6,
        func7,
        func8
      )
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val funcInstance = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.cutInputFunctionByADTList)
        .inputGHDMZSK(listFunc)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra9[I1, I2, I3, I4, I5, I6, I7, I8, I9, S <: ADTStatus](
    private val data: ADTData[
      AdtNatPositive[
        I1,
        AdtNatPositive[I2, AdtNatPositive[
          I3,
          AdtNatPositive[I4, AdtNatPositive[I5, AdtNatPositive[I6, AdtNatPositive[I7, AdtNatPositive[I8, AdtNatPositive[I9, AdtNatZero]]]]]]
        ]]
      ],
      S
    ]
  ) {
    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D,
      func7: I7 => D,
      func8: I8 => D,
      func9: I9 => D
    ): D = {
      val adtDataGHDMZSK = data.toGHDMZSK
      val dataInstance: Any = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.findADTData)
        .inputGHDMZSK(ADTGHDMZSK.identityGhdmzsk)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
      val funcs = List(
        func1,
        func2,
        func3,
        func4,
        func5,
        func6,
        func7,
        func8,
        func9
      )
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val funcInstance = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.cutInputFunctionByADTList)
        .inputGHDMZSK(listFunc)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra10[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, S <: ADTStatus](
    private val data: ADTData[
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
      S
    ]
  ) {
    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D,
      func7: I7 => D,
      func8: I8 => D,
      func9: I9 => D,
      func10: I10 => D
    ): D = {
      val adtDataGHDMZSK = data.toGHDMZSK
      val dataInstance: Any = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.findADTData)
        .inputGHDMZSK(ADTGHDMZSK.identityGhdmzsk)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
      val funcs = List(
        func1,
        func2,
        func3,
        func4,
        func5,
        func6,
        func7,
        func8,
        func9,
        func10
      )
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val funcInstance = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.cutInputFunctionByADTList)
        .inputGHDMZSK(listFunc)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra11[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, S <: ADTStatus](
    private val data: ADTData[
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
      S
    ]
  ) {
    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D,
      func7: I7 => D,
      func8: I8 => D,
      func9: I9 => D,
      func10: I10 => D,
      func11: I11 => D
    ): D = {
      val adtDataGHDMZSK = data.toGHDMZSK
      val dataInstance: Any = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.findADTData)
        .inputGHDMZSK(ADTGHDMZSK.identityGhdmzsk)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
      val funcs = List(
        func1,
        func2,
        func3,
        func4,
        func5,
        func6,
        func7,
        func8,
        func9,
        func10,
        func11
      )
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val funcInstance = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.cutInputFunctionByADTList)
        .inputGHDMZSK(listFunc)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra12[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, S <: ADTStatus](
    private val data: ADTData[
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
      S
    ]
  ) {
    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D,
      func7: I7 => D,
      func8: I8 => D,
      func9: I9 => D,
      func10: I10 => D,
      func11: I11 => D,
      func12: I12 => D
    ): D = {
      val adtDataGHDMZSK = data.toGHDMZSK
      val dataInstance: Any = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.findADTData)
        .inputGHDMZSK(ADTGHDMZSK.identityGhdmzsk)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
      val funcs = List(
        func1,
        func2,
        func3,
        func4,
        func5,
        func6,
        func7,
        func8,
        func9,
        func10,
        func11,
        func12
      )
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val funcInstance = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.cutInputFunctionByADTList)
        .inputGHDMZSK(listFunc)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra13[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, S <: ADTStatus](
    private val data: ADTData[
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
      S
    ]
  ) {
    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D,
      func7: I7 => D,
      func8: I8 => D,
      func9: I9 => D,
      func10: I10 => D,
      func11: I11 => D,
      func12: I12 => D,
      func13: I13 => D
    ): D = {
      val adtDataGHDMZSK = data.toGHDMZSK
      val dataInstance: Any = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.findADTData)
        .inputGHDMZSK(ADTGHDMZSK.identityGhdmzsk)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
      val funcs = List(
        func1,
        func2,
        func3,
        func4,
        func5,
        func6,
        func7,
        func8,
        func9,
        func10,
        func11,
        func12,
        func13
      )
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val funcInstance = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.cutInputFunctionByADTList)
        .inputGHDMZSK(listFunc)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra14[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, S <: ADTStatus](
    private val data: ADTData[
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
      S
    ]
  ) {
    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D,
      func7: I7 => D,
      func8: I8 => D,
      func9: I9 => D,
      func10: I10 => D,
      func11: I11 => D,
      func12: I12 => D,
      func13: I13 => D,
      func14: I14 => D
    ): D = {
      val adtDataGHDMZSK = data.toGHDMZSK
      val dataInstance: Any = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.findADTData)
        .inputGHDMZSK(ADTGHDMZSK.identityGhdmzsk)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
      val funcs = List(
        func1,
        func2,
        func3,
        func4,
        func5,
        func6,
        func7,
        func8,
        func9,
        func10,
        func11,
        func12,
        func13,
        func14
      )
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val funcInstance = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.cutInputFunctionByADTList)
        .inputGHDMZSK(listFunc)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra15[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, S <: ADTStatus](
    private val data: ADTData[
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
      S
    ]
  ) {
    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D,
      func7: I7 => D,
      func8: I8 => D,
      func9: I9 => D,
      func10: I10 => D,
      func11: I11 => D,
      func12: I12 => D,
      func13: I13 => D,
      func14: I14 => D,
      func15: I15 => D
    ): D = {
      val adtDataGHDMZSK = data.toGHDMZSK
      val dataInstance: Any = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.findADTData)
        .inputGHDMZSK(ADTGHDMZSK.identityGhdmzsk)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
      val funcs = List(
        func1,
        func2,
        func3,
        func4,
        func5,
        func6,
        func7,
        func8,
        func9,
        func10,
        func11,
        func12,
        func13,
        func14,
        func15
      )
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val funcInstance = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.cutInputFunctionByADTList)
        .inputGHDMZSK(listFunc)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra16[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, S <: ADTStatus](
    private val data: ADTData[
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
      S
    ]
  ) {
    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D,
      func7: I7 => D,
      func8: I8 => D,
      func9: I9 => D,
      func10: I10 => D,
      func11: I11 => D,
      func12: I12 => D,
      func13: I13 => D,
      func14: I14 => D,
      func15: I15 => D,
      func16: I16 => D
    ): D = {
      val adtDataGHDMZSK = data.toGHDMZSK
      val dataInstance: Any = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.findADTData)
        .inputGHDMZSK(ADTGHDMZSK.identityGhdmzsk)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
      val funcs = List(
        func1,
        func2,
        func3,
        func4,
        func5,
        func6,
        func7,
        func8,
        func9,
        func10,
        func11,
        func12,
        func13,
        func14,
        func15,
        func16
      )
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val funcInstance = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.cutInputFunctionByADTList)
        .inputGHDMZSK(listFunc)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra17[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, S <: ADTStatus](
    private val data: ADTData[
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
      S
    ]
  ) {
    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D,
      func7: I7 => D,
      func8: I8 => D,
      func9: I9 => D,
      func10: I10 => D,
      func11: I11 => D,
      func12: I12 => D,
      func13: I13 => D,
      func14: I14 => D,
      func15: I15 => D,
      func16: I16 => D,
      func17: I17 => D
    ): D = {
      val adtDataGHDMZSK = data.toGHDMZSK
      val dataInstance: Any = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.findADTData)
        .inputGHDMZSK(ADTGHDMZSK.identityGhdmzsk)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
      val funcs = List(
        func1,
        func2,
        func3,
        func4,
        func5,
        func6,
        func7,
        func8,
        func9,
        func10,
        func11,
        func12,
        func13,
        func14,
        func15,
        func16,
        func17
      )
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val funcInstance = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.cutInputFunctionByADTList)
        .inputGHDMZSK(listFunc)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra18[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, S <: ADTStatus](
    private val data: ADTData[
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
      S
    ]
  ) {
    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D,
      func7: I7 => D,
      func8: I8 => D,
      func9: I9 => D,
      func10: I10 => D,
      func11: I11 => D,
      func12: I12 => D,
      func13: I13 => D,
      func14: I14 => D,
      func15: I15 => D,
      func16: I16 => D,
      func17: I17 => D,
      func18: I18 => D
    ): D = {
      val adtDataGHDMZSK = data.toGHDMZSK
      val dataInstance: Any = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.findADTData)
        .inputGHDMZSK(ADTGHDMZSK.identityGhdmzsk)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
      val funcs = List(
        func1,
        func2,
        func3,
        func4,
        func5,
        func6,
        func7,
        func8,
        func9,
        func10,
        func11,
        func12,
        func13,
        func14,
        func15,
        func16,
        func17,
        func18
      )
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val funcInstance = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.cutInputFunctionByADTList)
        .inputGHDMZSK(listFunc)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra19[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, S <: ADTStatus](
    private val data: ADTData[
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
      S
    ]
  ) {
    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D,
      func7: I7 => D,
      func8: I8 => D,
      func9: I9 => D,
      func10: I10 => D,
      func11: I11 => D,
      func12: I12 => D,
      func13: I13 => D,
      func14: I14 => D,
      func15: I15 => D,
      func16: I16 => D,
      func17: I17 => D,
      func18: I18 => D,
      func19: I19 => D
    ): D = {
      val adtDataGHDMZSK = data.toGHDMZSK
      val dataInstance: Any = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.findADTData)
        .inputGHDMZSK(ADTGHDMZSK.identityGhdmzsk)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
      val funcs = List(
        func1,
        func2,
        func3,
        func4,
        func5,
        func6,
        func7,
        func8,
        func9,
        func10,
        func11,
        func12,
        func13,
        func14,
        func15,
        func16,
        func17,
        func18,
        func19
      )
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val funcInstance = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.cutInputFunctionByADTList)
        .inputGHDMZSK(listFunc)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra20[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, S <: ADTStatus](
    private val data: ADTData[
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
      S
    ]
  ) {
    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D,
      func7: I7 => D,
      func8: I8 => D,
      func9: I9 => D,
      func10: I10 => D,
      func11: I11 => D,
      func12: I12 => D,
      func13: I13 => D,
      func14: I14 => D,
      func15: I15 => D,
      func16: I16 => D,
      func17: I17 => D,
      func18: I18 => D,
      func19: I19 => D,
      func20: I20 => D
    ): D = {
      val adtDataGHDMZSK = data.toGHDMZSK
      val dataInstance: Any = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.findADTData)
        .inputGHDMZSK(ADTGHDMZSK.identityGhdmzsk)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
      val funcs = List(
        func1,
        func2,
        func3,
        func4,
        func5,
        func6,
        func7,
        func8,
        func9,
        func10,
        func11,
        func12,
        func13,
        func14,
        func15,
        func16,
        func17,
        func18,
        func19,
        func20
      )
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val funcInstance = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.cutInputFunctionByADTList)
        .inputGHDMZSK(listFunc)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra21[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, S <: ADTStatus](
    private val data: ADTData[
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
      S
    ]
  ) {
    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D,
      func7: I7 => D,
      func8: I8 => D,
      func9: I9 => D,
      func10: I10 => D,
      func11: I11 => D,
      func12: I12 => D,
      func13: I13 => D,
      func14: I14 => D,
      func15: I15 => D,
      func16: I16 => D,
      func17: I17 => D,
      func18: I18 => D,
      func19: I19 => D,
      func20: I20 => D,
      func21: I21 => D
    ): D = {
      val adtDataGHDMZSK = data.toGHDMZSK
      val dataInstance: Any = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.findADTData)
        .inputGHDMZSK(ADTGHDMZSK.identityGhdmzsk)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
      val funcs = List(
        func1,
        func2,
        func3,
        func4,
        func5,
        func6,
        func7,
        func8,
        func9,
        func10,
        func11,
        func12,
        func13,
        func14,
        func15,
        func16,
        func17,
        func18,
        func19,
        func20,
        func21
      )
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val funcInstance = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.cutInputFunctionByADTList)
        .inputGHDMZSK(listFunc)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra22[
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
    I22,
    S <: ADTStatus
  ](
    private val data: ADTData[
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
      S
    ]
  ) {
    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D,
      func5: I5 => D,
      func6: I6 => D,
      func7: I7 => D,
      func8: I8 => D,
      func9: I9 => D,
      func10: I10 => D,
      func11: I11 => D,
      func12: I12 => D,
      func13: I13 => D,
      func14: I14 => D,
      func15: I15 => D,
      func16: I16 => D,
      func17: I17 => D,
      func18: I18 => D,
      func19: I19 => D,
      func20: I20 => D,
      func21: I21 => D,
      func22: I22 => D
    ): D = {
      val adtDataGHDMZSK = data.toGHDMZSK
      val dataInstance: Any = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.findADTData)
        .inputGHDMZSK(ADTGHDMZSK.identityGhdmzsk)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
      val funcs = List(
        func1,
        func2,
        func3,
        func4,
        func5,
        func6,
        func7,
        func8,
        func9,
        func10,
        func11,
        func12,
        func13,
        func14,
        func15,
        func16,
        func17,
        func18,
        func19,
        func20,
        func21,
        func22
      )
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val funcInstance = adtDataGHDMZSK
        .inputGHDMZSK(ADTGHDMZSK.TakePropertyUtils.cutInputFunctionByADTList)
        .inputGHDMZSK(listFunc)
        .asInstanceOf[ADTGHDMZSK.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

}
