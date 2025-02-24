package net.scalax.simple.codec
package to_list_generic

import SimpleProductXImpl.NotHList
import NotHList.InputType

object ConvertM4Impl {
  type M4FType[M1[_], M2[_], M3[_], M4[_]] = NotHList.PositiveFType[M1, ConvertM3Impl.M3FType[M2, M3, M4]]

  type InputType4[T1, T2, T3, T4] = NotHList.PositiveInputType[T1, ConvertM3Impl.InputType3[T2, T3, T4]]

  object TypeGen {
    def from2[M2[_, _, _, _], M1[_], M3[_], M4[_], M5[_]](
      typeGen: SimpleProduct4.TypeGen[M2, M1, M3, M4, M5]
    ): NotHList.TypeGen[
      ({
        type TA[U <: InputType] =
          M2[
            InputType.TakeHead[U],
            InputType.TakeHead[InputType.TakeTail[U]],
            InputType.TakeHead[
              InputType.TakeTail[InputType.TakeTail[U]]
            ],
            InputType.TakeHead[
              InputType.TakeTail[InputType.TakeTail[InputType.TakeTail[U]]]
            ]
          ]
      })#TA,
      M4FType[M1, M3, M4, M5]
    ] = new NotHList.TypeGen[
      ({
        type TA[U <: InputType] =
          M2[
            InputType.TakeHead[U],
            InputType.TakeHead[InputType.TakeTail[U]],
            InputType.TakeHead[
              InputType.TakeTail[InputType.TakeTail[U]]
            ],
            InputType.TakeHead[
              InputType.TakeTail[InputType.TakeTail[InputType.TakeTail[U]]]
            ]
          ]
      })#TA,
      M4FType[M1, M3, M4, M5]
    ] {
      override def apply[T]: M2[M1[T], M3[T], M4[T], M5[T]] = typeGen[T]
    }
  }

  object AppendMonad {

    def from2[M2[_, _, _, _]](
      append: SimpleProduct4.AppendMonad[M2]
    ): SimpleProductXImpl.NotHList.AppendMonad[
      ({
        type TA[U <: SimpleProductXImpl.NotHList.InputType] =
          M2[
            InputType.TakeHead[U],
            InputType.TakeHead[InputType.TakeTail[U]],
            InputType.TakeHead[
              InputType.TakeTail[InputType.TakeTail[U]]
            ],
            InputType.TakeHead[
              InputType.TakeTail[InputType.TakeTail[InputType.TakeTail[U]]]
            ]
          ]
      })#TA
    ] = new SimpleProductXImpl.NotHList.AppendMonad[
      ({
        type TA[U <: SimpleProductXImpl.NotHList.InputType] =
          M2[
            InputType.TakeHead[U],
            InputType.TakeHead[InputType.TakeTail[U]],
            InputType.TakeHead[
              InputType.TakeTail[InputType.TakeTail[U]]
            ],
            InputType.TakeHead[
              InputType.TakeTail[InputType.TakeTail[InputType.TakeTail[U]]]
            ]
          ]
      })#TA
    ] {
      override def zip[
        A <: NotHList.InputType,
        B <: NotHList.InputType
      ](
        ma: M2[
          InputType.TakeHead[A],
          InputType.TakeHead[InputType.TakeTail[A]],
          InputType.TakeHead[
            InputType.TakeTail[InputType.TakeTail[A]]
          ],
          InputType.TakeHead[
            InputType.TakeTail[InputType.TakeTail[InputType.TakeTail[A]]]
          ]
        ],
        ms: M2[
          InputType.TakeHead[B],
          InputType.TakeHead[InputType.TakeTail[B]],
          InputType.TakeHead[
            InputType.TakeTail[InputType.TakeTail[B]]
          ],
          InputType.TakeHead[
            InputType.TakeTail[InputType.TakeTail[InputType.TakeTail[B]]]
          ]
        ]
      ): M2[
        InputType.TakeHead[NotHList.ZipInputType[A, B]],
        InputType.TakeHead[InputType.TakeTail[NotHList.ZipInputType[A, B]]],
        InputType.TakeHead[
          InputType.TakeTail[InputType.TakeTail[NotHList.ZipInputType[A, B]]]
        ],
        InputType.TakeHead[
          InputType.TakeTail[InputType.TakeTail[InputType.TakeTail[NotHList.ZipInputType[A, B]]]]
        ]
      ] = append.zip(ma, ms).asInstanceOf

      override def to[A <: NotHList.InputType, B <: NotHList.InputType](
        m1: M2[
          InputType.TakeHead[A],
          InputType.TakeHead[InputType.TakeTail[A]],
          InputType.TakeHead[
            InputType.TakeTail[InputType.TakeTail[A]]
          ],
          InputType.TakeHead[
            InputType.TakeTail[InputType.TakeTail[InputType.TakeTail[A]]]
          ]
        ]
      )(
        in1: NotHList.Mapper[A, B]
      ): M2[
        InputType.TakeHead[B],
        InputType.TakeHead[InputType.TakeTail[B]],
        InputType.TakeHead[
          InputType.TakeTail[InputType.TakeTail[B]]
        ],
        InputType.TakeHead[
          InputType.TakeTail[InputType.TakeTail[InputType.TakeTail[B]]]
        ]
      ] =
        append.to[
          InputType.TakeHead[A],
          InputType.TakeHead[InputType.TakeTail[A]],
          InputType.TakeHead[
            InputType.TakeTail[InputType.TakeTail[A]]
          ],
          InputType.TakeHead[
            InputType.TakeTail[InputType.TakeTail[InputType.TakeTail[A]]]
          ],
          InputType.TakeHead[B],
          InputType.TakeHead[InputType.TakeTail[B]],
          InputType.TakeHead[
            InputType.TakeTail[InputType.TakeTail[B]]
          ],
          InputType.TakeHead[
            InputType.TakeTail[InputType.TakeTail[InputType.TakeTail[B]]]
          ]
        ](m1)(
          in1 = in1.map,
          in2 = in1.nextMapper.map,
          in3 = in1.nextMapper.nextMapper.map,
          in4 = in1.nextMapper.nextMapper.nextMapper.map
        )(
          in5 = in1.reverseMap,
          in6 = in1.nextMapper.reverseMap,
          in7 = in1.nextMapper.nextMapper.reverseMap,
          in8 = in1.nextMapper.nextMapper.nextMapper.reverseMap
        )

      override def zero: M2[
        InputType.TakeHead[NotHList.ZeroInputType],
        InputType.TakeHead[InputType.TakeTail[NotHList.ZeroInputType]],
        InputType.TakeHead[
          InputType.TakeTail[InputType.TakeTail[NotHList.ZeroInputType]]
        ],
        InputType.TakeHead[
          InputType.TakeTail[InputType.TakeTail[InputType.TakeTail[NotHList.ZeroInputType]]]
        ]
      ] = append.zero.asInstanceOf
    }
  }

  object Appender {
    def to3[F[_[_]]](append: NotHList.Appender[F]): SimpleProduct4.Appender[F] = new SimpleProduct4.Appender[F] {
      override def toHList[M3[_, _, _, _], M1[_], M2[_], M4[_], M5[_]](
        monad: SimpleProduct4.AppendMonad[M3],
        func: SimpleProduct4.TypeGen[M3, M1, M2, M4, M5]
      ): M3[F[M1], F[M2], F[M4], F[M5]] = {
        val appendMonad: NotHList.AppendMonad[
          ({
            type TA[U <: NotHList.InputType] =
              M3[
                InputType.TakeHead[U],
                InputType.TakeHead[InputType.TakeTail[U]],
                InputType.TakeHead[
                  InputType.TakeTail[InputType.TakeTail[U]]
                ],
                InputType.TakeHead[
                  InputType.TakeTail[InputType.TakeTail[InputType.TakeTail[U]]]
                ]
              ]
          })#TA
        ] = AppendMonad.from2[M3](monad)

        val typeGen: NotHList.TypeGen[
          ({
            type TA[U <: NotHList.InputType] =
              M3[
                InputType.TakeHead[U],
                InputType.TakeHead[InputType.TakeTail[U]],
                InputType.TakeHead[
                  InputType.TakeTail[InputType.TakeTail[U]]
                ],
                InputType.TakeHead[
                  InputType.TakeTail[InputType.TakeTail[InputType.TakeTail[U]]]
                ]
              ]
          })#TA,
          M4FType[M1, M2, M4, M5]
        ] =
          TypeGen.from2[M3, M1, M2, M4, M5](func)

        append.toHList[
          ({
            type TA[U <: NotHList.InputType] =
              M3[
                InputType.TakeHead[U],
                InputType.TakeHead[InputType.TakeTail[U]],
                InputType.TakeHead[
                  InputType.TakeTail[InputType.TakeTail[U]]
                ],
                InputType.TakeHead[
                  InputType.TakeTail[InputType.TakeTail[InputType.TakeTail[U]]]
                ]
              ]
          })#TA,
          M4FType[M1, M2, M4, M5]
        ](appendMonad)(typeGen)
      }
    }
  }

}
