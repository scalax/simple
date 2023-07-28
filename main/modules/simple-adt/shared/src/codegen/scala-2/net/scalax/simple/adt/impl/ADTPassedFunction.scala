package net.scalax.simple.adt
package impl

import net.scalax.simple.ghdmzsk.ghdmzsk
import implemention._
import temp._
import temp.{Status => ADTStatus}

trait ADTPassedFunction {

  implicit class extra1[
    I1
  ](private val data: ADTData[AdtNatData[I1, AdtNatZero], ADTStatus.Passed]) {
    def fold[D](
      func1: I1 => D
    ): D = {
      val adtDataGHDMZSK = data.toGHDMZSK
      val dataInstance: Any = adtDataGHDMZSK
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead)))
        .inputGHDMZSK(Disscure.identityGhdmzsk)
        .asInstanceOf[Disscure.GetValue]
        .value
      val funcs = List(
        func1
      )
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val funcInstance = adtDataGHDMZSK
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra2[
    I1,
    I2
  ](private val data: ADTData[AdtNatData[I1, AdtNatData[I2, AdtNatZero]], ADTStatus.Passed]) {
    def fold[D](
      func1: I1 => D,
      func2: I2 => D
    ): D = {
      val adtDataGHDMZSK = data.toGHDMZSK
      val dataInstance: Any = adtDataGHDMZSK
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead)))
        .inputGHDMZSK(Disscure.identityGhdmzsk)
        .asInstanceOf[Disscure.GetValue]
        .value
      val funcs = List(
        func1,
        func2
      )
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val funcInstance = adtDataGHDMZSK
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra3[
    I1,
    I2,
    I3
  ](private val data: ADTData[AdtNatData[I1, AdtNatData[I2, AdtNatData[I3, AdtNatZero]]], ADTStatus.Passed]) {
    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D
    ): D = {
      val adtDataGHDMZSK = data.toGHDMZSK
      val dataInstance: Any = adtDataGHDMZSK
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead)))
        .inputGHDMZSK(Disscure.identityGhdmzsk)
        .asInstanceOf[Disscure.GetValue]
        .value
      val funcs = List(
        func1,
        func2,
        func3
      )
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val funcInstance = adtDataGHDMZSK
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra4[
    I1,
    I2,
    I3,
    I4
  ](private val data: ADTData[AdtNatData[I1, AdtNatData[I2, AdtNatData[I3, AdtNatData[I4, AdtNatZero]]]], ADTStatus.Passed]) {
    def fold[D](
      func1: I1 => D,
      func2: I2 => D,
      func3: I3 => D,
      func4: I4 => D
    ): D = {
      val adtDataGHDMZSK = data.toGHDMZSK
      val dataInstance: Any = adtDataGHDMZSK
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead)))
        .inputGHDMZSK(Disscure.identityGhdmzsk)
        .asInstanceOf[Disscure.GetValue]
        .value
      val funcs = List(
        func1,
        func2,
        func3,
        func4
      )
      val listFunc: ghdmzsk = TypeAdtGetter.fromList(funcs.asInstanceOf[List[Any => Any]])
      val funcInstance = adtDataGHDMZSK
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra5[
    I1,
    I2,
    I3,
    I4,
    I5
  ](
    private val data: ADTData[AdtNatData[I1, AdtNatData[I2, AdtNatData[I3, AdtNatData[I4, AdtNatData[I5, AdtNatZero]]]]], ADTStatus.Passed]
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead)))
        .inputGHDMZSK(Disscure.identityGhdmzsk)
        .asInstanceOf[Disscure.GetValue]
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra6[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6
  ](
    private val data: ADTData[
      AdtNatData[I1, AdtNatData[I2, AdtNatData[I3, AdtNatData[I4, AdtNatData[I5, AdtNatData[I6, AdtNatZero]]]]]],
      ADTStatus.Passed
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead)))
        .inputGHDMZSK(Disscure.identityGhdmzsk)
        .asInstanceOf[Disscure.GetValue]
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra7[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6,
    I7
  ](
    private val data: ADTData[
      AdtNatData[I1, AdtNatData[I2, AdtNatData[I3, AdtNatData[I4, AdtNatData[I5, AdtNatData[I6, AdtNatData[I7, AdtNatZero]]]]]]],
      ADTStatus.Passed
    ]
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead)))
        .inputGHDMZSK(Disscure.identityGhdmzsk)
        .asInstanceOf[Disscure.GetValue]
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra8[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6,
    I7,
    I8
  ](
    private val data: ADTData[AdtNatData[
      I1,
      AdtNatData[I2, AdtNatData[I3, AdtNatData[I4, AdtNatData[I5, AdtNatData[I6, AdtNatData[I7, AdtNatData[I8, AdtNatZero]]]]]]]
    ], ADTStatus.Passed]
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead)))
        .inputGHDMZSK(Disscure.identityGhdmzsk)
        .asInstanceOf[Disscure.GetValue]
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra9[
    I1,
    I2,
    I3,
    I4,
    I5,
    I6,
    I7,
    I8,
    I9
  ](
    private val data: ADTData[
      AdtNatData[I1, AdtNatData[
        I2,
        AdtNatData[I3, AdtNatData[I4, AdtNatData[I5, AdtNatData[I6, AdtNatData[I7, AdtNatData[I8, AdtNatData[I9, AdtNatZero]]]]]]]
      ]],
      ADTStatus.Passed
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead)))
        .inputGHDMZSK(Disscure.identityGhdmzsk)
        .asInstanceOf[Disscure.GetValue]
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra10[
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
  ](
    private val data: ADTData[
      AdtNatData[I1, AdtNatData[I2, AdtNatData[
        I3,
        AdtNatData[I4, AdtNatData[I5, AdtNatData[I6, AdtNatData[I7, AdtNatData[I8, AdtNatData[I9, AdtNatData[I10, AdtNatZero]]]]]]]
      ]]],
      ADTStatus.Passed
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead)))
        .inputGHDMZSK(Disscure.identityGhdmzsk)
        .asInstanceOf[Disscure.GetValue]
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra11[
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
  ](
    private val data: ADTData[
      AdtNatData[
        I1,
        AdtNatData[
          I2,
          AdtNatData[I3, AdtNatData[
            I4,
            AdtNatData[I5, AdtNatData[I6, AdtNatData[I7, AdtNatData[I8, AdtNatData[I9, AdtNatData[I10, AdtNatData[I11, AdtNatZero]]]]]]]
          ]]
        ]
      ],
      ADTStatus.Passed
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead)))
        .inputGHDMZSK(Disscure.identityGhdmzsk)
        .asInstanceOf[Disscure.GetValue]
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra12[
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
  ](
    private val data: ADTData[
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
      ],
      ADTStatus.Passed
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead)))
        .inputGHDMZSK(Disscure.identityGhdmzsk)
        .asInstanceOf[Disscure.GetValue]
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra13[
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
  ](
    private val data: ADTData[
      AdtNatData[
        I1,
        AdtNatData[
          I2,
          AdtNatData[
            I3,
            AdtNatData[
              I4,
              AdtNatData[I5, AdtNatData[I6, AdtNatData[
                I7,
                AdtNatData[I8, AdtNatData[I9, AdtNatData[I10, AdtNatData[I11, AdtNatData[I12, AdtNatData[I13, AdtNatZero]]]]]]
              ]]]
            ]
          ]
        ]
      ],
      ADTStatus.Passed
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead)))
        .inputGHDMZSK(Disscure.identityGhdmzsk)
        .asInstanceOf[Disscure.GetValue]
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra14[
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
  ](
    private val data: ADTData[
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
      ],
      ADTStatus.Passed
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead)))
        .inputGHDMZSK(Disscure.identityGhdmzsk)
        .asInstanceOf[Disscure.GetValue]
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra15[
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
  ](
    private val data: ADTData[
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
      ],
      ADTStatus.Passed
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead)))
        .inputGHDMZSK(Disscure.identityGhdmzsk)
        .asInstanceOf[Disscure.GetValue]
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra16[
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
  ](
    private val data: ADTData[
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
      ],
      ADTStatus.Passed
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead)))
        .inputGHDMZSK(Disscure.identityGhdmzsk)
        .asInstanceOf[Disscure.GetValue]
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra17[
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
  ](
    private val data: ADTData[
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
      ],
      ADTStatus.Passed
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead)))
        .inputGHDMZSK(Disscure.identityGhdmzsk)
        .asInstanceOf[Disscure.GetValue]
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra18[
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
  ](
    private val data: ADTData[
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
      ],
      ADTStatus.Passed
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead)))
        .inputGHDMZSK(Disscure.identityGhdmzsk)
        .asInstanceOf[Disscure.GetValue]
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra19[
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
  ](
    private val data: ADTData[
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
      ],
      ADTStatus.Passed
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead)))
        .inputGHDMZSK(Disscure.identityGhdmzsk)
        .asInstanceOf[Disscure.GetValue]
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra20[
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
  ](
    private val data: ADTData[
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
                            AdtNatData[I12, AdtNatData[I13, AdtNatData[I14, AdtNatData[
                              I15,
                              AdtNatData[I16, AdtNatData[I17, AdtNatData[I18, AdtNatData[I19, AdtNatData[I20, AdtNatZero]]]]]
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead)))
        .inputGHDMZSK(Disscure.identityGhdmzsk)
        .asInstanceOf[Disscure.GetValue]
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

  implicit class extra21[
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
  ](
    private val data: ADTData[
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
      ],
      ADTStatus.Passed
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead)))
        .inputGHDMZSK(Disscure.identityGhdmzsk)
        .asInstanceOf[Disscure.GetValue]
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
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
    I22
  ](
    private val data: ADTData[
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
      ],
      ADTStatus.Passed
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead)))
        .inputGHDMZSK(Disscure.identityGhdmzsk)
        .asInstanceOf[Disscure.GetValue]
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
        .inputGHDMZSK(Disscure.takeTail.inputGHDMZSK(Disscure.takeHead))
        .inputGHDMZSK(listFunc)
        .asInstanceOf[Disscure.GetValue]
        .value
        .asInstanceOf[Any => D]
      funcInstance(dataInstance)
    }
  }

}
