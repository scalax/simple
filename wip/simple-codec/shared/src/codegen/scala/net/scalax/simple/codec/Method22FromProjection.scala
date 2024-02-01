package net.scalax.simple.codec

import decode.projection._
trait Monad1TypeLevel[M1[_]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  def zip[IA1, IB1](
    m1: M1[IA1],
    m2: M1[IB1]
  ): M1[(IA1, IB1)]

}
trait Monad2TypeLevel[M1[_, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  def zip[IA1, IA2, IB1, IB2](
    m1: M1[IA1, IA2],
    m2: M1[IB1, IB2]
  ): M1[(IA1, IB1), (IA2, IB2)]

}
trait Monad3TypeLevel[M1[_, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  def zip[IA1, IA2, IA3, IB1, IB2, IB3](
    m1: M1[IA1, IA2, IA3],
    m2: M1[IB1, IB2, IB3]
  ): M1[(IA1, IB1), (IA2, IB2), (IA3, IB3)]

}
trait Monad4TypeLevel[M1[_, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  def zip[IA1, IA2, IA3, IA4, IB1, IB2, IB3, IB4](
    m1: M1[IA1, IA2, IA3, IA4],
    m2: M1[IB1, IB2, IB3, IB4]
  ): M1[(IA1, IB1), (IA2, IB2), (IA3, IB3), (IA4, IB4)]

}
trait Monad5TypeLevel[M1[_, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  def zip[IA1, IA2, IA3, IA4, IA5, IB1, IB2, IB3, IB4, IB5](
    m1: M1[IA1, IA2, IA3, IA4, IA5],
    m2: M1[IB1, IB2, IB3, IB4, IB5]
  ): M1[(IA1, IB1), (IA2, IB2), (IA3, IB3), (IA4, IB4), (IA5, IB5)]

}
trait Monad6TypeLevel[M1[_, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  def zip[IA1, IA2, IA3, IA4, IA5, IA6, IB1, IB2, IB3, IB4, IB5, IB6](
    m1: M1[IA1, IA2, IA3, IA4, IA5, IA6],
    m2: M1[IB1, IB2, IB3, IB4, IB5, IB6]
  ): M1[(IA1, IB1), (IA2, IB2), (IA3, IB3), (IA4, IB4), (IA5, IB5), (IA6, IB6)]

}
trait Monad7TypeLevel[M1[_, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  def zip[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IB1, IB2, IB3, IB4, IB5, IB6, IB7](
    m1: M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7],
    m2: M1[IB1, IB2, IB3, IB4, IB5, IB6, IB7]
  ): M1[(IA1, IB1), (IA2, IB2), (IA3, IB3), (IA4, IB4), (IA5, IB5), (IA6, IB6), (IA7, IB7)]

}
trait Monad8TypeLevel[M1[_, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  def zip[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8](
    m1: M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8],
    m2: M1[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8]
  ): M1[(IA1, IB1), (IA2, IB2), (IA3, IB3), (IA4, IB4), (IA5, IB5), (IA6, IB6), (IA7, IB7), (IA8, IB8)]

}
trait Monad9TypeLevel[M1[_, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  def zip[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9](
    m1: M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9],
    m2: M1[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9]
  ): M1[(IA1, IB1), (IA2, IB2), (IA3, IB3), (IA4, IB4), (IA5, IB5), (IA6, IB6), (IA7, IB7), (IA8, IB8), (IA9, IB9)]

}
trait Monad10TypeLevel[M1[_, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  def zip[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10](
    m1: M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10],
    m2: M1[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10]
  ): M1[(IA1, IB1), (IA2, IB2), (IA3, IB3), (IA4, IB4), (IA5, IB5), (IA6, IB6), (IA7, IB7), (IA8, IB8), (IA9, IB9), (IA10, IB10)]

}
trait Monad11TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  def zip[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11](
    m1: M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11],
    m2: M1[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11]
  ): M1[
    (IA1, IB1),
    (IA2, IB2),
    (IA3, IB3),
    (IA4, IB4),
    (IA5, IB5),
    (IA6, IB6),
    (IA7, IB7),
    (IA8, IB8),
    (IA9, IB9),
    (IA10, IB10),
    (IA11, IB11)
  ]

}
trait Monad12TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  def zip[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12](
    m1: M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12],
    m2: M1[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12]
  ): M1[
    (IA1, IB1),
    (IA2, IB2),
    (IA3, IB3),
    (IA4, IB4),
    (IA5, IB5),
    (IA6, IB6),
    (IA7, IB7),
    (IA8, IB8),
    (IA9, IB9),
    (IA10, IB10),
    (IA11, IB11),
    (IA12, IB12)
  ]

}
trait Monad13TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  def zip[
    IA1,
    IA2,
    IA3,
    IA4,
    IA5,
    IA6,
    IA7,
    IA8,
    IA9,
    IA10,
    IA11,
    IA12,
    IA13,
    IB1,
    IB2,
    IB3,
    IB4,
    IB5,
    IB6,
    IB7,
    IB8,
    IB9,
    IB10,
    IB11,
    IB12,
    IB13
  ](
    m1: M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13],
    m2: M1[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13]
  ): M1[
    (IA1, IB1),
    (IA2, IB2),
    (IA3, IB3),
    (IA4, IB4),
    (IA5, IB5),
    (IA6, IB6),
    (IA7, IB7),
    (IA8, IB8),
    (IA9, IB9),
    (IA10, IB10),
    (IA11, IB11),
    (IA12, IB12),
    (IA13, IB13)
  ]

}
trait Monad14TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  def zip[
    IA1,
    IA2,
    IA3,
    IA4,
    IA5,
    IA6,
    IA7,
    IA8,
    IA9,
    IA10,
    IA11,
    IA12,
    IA13,
    IA14,
    IB1,
    IB2,
    IB3,
    IB4,
    IB5,
    IB6,
    IB7,
    IB8,
    IB9,
    IB10,
    IB11,
    IB12,
    IB13,
    IB14
  ](
    m1: M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14],
    m2: M1[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14]
  ): M1[
    (IA1, IB1),
    (IA2, IB2),
    (IA3, IB3),
    (IA4, IB4),
    (IA5, IB5),
    (IA6, IB6),
    (IA7, IB7),
    (IA8, IB8),
    (IA9, IB9),
    (IA10, IB10),
    (IA11, IB11),
    (IA12, IB12),
    (IA13, IB13),
    (IA14, IB14)
  ]

}
trait Monad15TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  def zip[
    IA1,
    IA2,
    IA3,
    IA4,
    IA5,
    IA6,
    IA7,
    IA8,
    IA9,
    IA10,
    IA11,
    IA12,
    IA13,
    IA14,
    IA15,
    IB1,
    IB2,
    IB3,
    IB4,
    IB5,
    IB6,
    IB7,
    IB8,
    IB9,
    IB10,
    IB11,
    IB12,
    IB13,
    IB14,
    IB15
  ](
    m1: M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15],
    m2: M1[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15]
  ): M1[
    (IA1, IB1),
    (IA2, IB2),
    (IA3, IB3),
    (IA4, IB4),
    (IA5, IB5),
    (IA6, IB6),
    (IA7, IB7),
    (IA8, IB8),
    (IA9, IB9),
    (IA10, IB10),
    (IA11, IB11),
    (IA12, IB12),
    (IA13, IB13),
    (IA14, IB14),
    (IA15, IB15)
  ]

}
trait Monad16TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  def zip[
    IA1,
    IA2,
    IA3,
    IA4,
    IA5,
    IA6,
    IA7,
    IA8,
    IA9,
    IA10,
    IA11,
    IA12,
    IA13,
    IA14,
    IA15,
    IA16,
    IB1,
    IB2,
    IB3,
    IB4,
    IB5,
    IB6,
    IB7,
    IB8,
    IB9,
    IB10,
    IB11,
    IB12,
    IB13,
    IB14,
    IB15,
    IB16
  ](
    m1: M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16],
    m2: M1[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15, IB16]
  ): M1[
    (IA1, IB1),
    (IA2, IB2),
    (IA3, IB3),
    (IA4, IB4),
    (IA5, IB5),
    (IA6, IB6),
    (IA7, IB7),
    (IA8, IB8),
    (IA9, IB9),
    (IA10, IB10),
    (IA11, IB11),
    (IA12, IB12),
    (IA13, IB13),
    (IA14, IB14),
    (IA15, IB15),
    (IA16, IB16)
  ]

}
trait Monad17TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  def zip[
    IA1,
    IA2,
    IA3,
    IA4,
    IA5,
    IA6,
    IA7,
    IA8,
    IA9,
    IA10,
    IA11,
    IA12,
    IA13,
    IA14,
    IA15,
    IA16,
    IA17,
    IB1,
    IB2,
    IB3,
    IB4,
    IB5,
    IB6,
    IB7,
    IB8,
    IB9,
    IB10,
    IB11,
    IB12,
    IB13,
    IB14,
    IB15,
    IB16,
    IB17
  ](
    m1: M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16, IA17],
    m2: M1[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15, IB16, IB17]
  ): M1[
    (IA1, IB1),
    (IA2, IB2),
    (IA3, IB3),
    (IA4, IB4),
    (IA5, IB5),
    (IA6, IB6),
    (IA7, IB7),
    (IA8, IB8),
    (IA9, IB9),
    (IA10, IB10),
    (IA11, IB11),
    (IA12, IB12),
    (IA13, IB13),
    (IA14, IB14),
    (IA15, IB15),
    (IA16, IB16),
    (IA17, IB17)
  ]

}
trait Monad18TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  def zip[
    IA1,
    IA2,
    IA3,
    IA4,
    IA5,
    IA6,
    IA7,
    IA8,
    IA9,
    IA10,
    IA11,
    IA12,
    IA13,
    IA14,
    IA15,
    IA16,
    IA17,
    IA18,
    IB1,
    IB2,
    IB3,
    IB4,
    IB5,
    IB6,
    IB7,
    IB8,
    IB9,
    IB10,
    IB11,
    IB12,
    IB13,
    IB14,
    IB15,
    IB16,
    IB17,
    IB18
  ](
    m1: M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16, IA17, IA18],
    m2: M1[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15, IB16, IB17, IB18]
  ): M1[
    (IA1, IB1),
    (IA2, IB2),
    (IA3, IB3),
    (IA4, IB4),
    (IA5, IB5),
    (IA6, IB6),
    (IA7, IB7),
    (IA8, IB8),
    (IA9, IB9),
    (IA10, IB10),
    (IA11, IB11),
    (IA12, IB12),
    (IA13, IB13),
    (IA14, IB14),
    (IA15, IB15),
    (IA16, IB16),
    (IA17, IB17),
    (IA18, IB18)
  ]

}
trait Monad19TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  def zip[
    IA1,
    IA2,
    IA3,
    IA4,
    IA5,
    IA6,
    IA7,
    IA8,
    IA9,
    IA10,
    IA11,
    IA12,
    IA13,
    IA14,
    IA15,
    IA16,
    IA17,
    IA18,
    IA19,
    IB1,
    IB2,
    IB3,
    IB4,
    IB5,
    IB6,
    IB7,
    IB8,
    IB9,
    IB10,
    IB11,
    IB12,
    IB13,
    IB14,
    IB15,
    IB16,
    IB17,
    IB18,
    IB19
  ](
    m1: M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16, IA17, IA18, IA19],
    m2: M1[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15, IB16, IB17, IB18, IB19]
  ): M1[
    (IA1, IB1),
    (IA2, IB2),
    (IA3, IB3),
    (IA4, IB4),
    (IA5, IB5),
    (IA6, IB6),
    (IA7, IB7),
    (IA8, IB8),
    (IA9, IB9),
    (IA10, IB10),
    (IA11, IB11),
    (IA12, IB12),
    (IA13, IB13),
    (IA14, IB14),
    (IA15, IB15),
    (IA16, IB16),
    (IA17, IB17),
    (IA18, IB18),
    (IA19, IB19)
  ]

}
trait Monad20TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  def zip[
    IA1,
    IA2,
    IA3,
    IA4,
    IA5,
    IA6,
    IA7,
    IA8,
    IA9,
    IA10,
    IA11,
    IA12,
    IA13,
    IA14,
    IA15,
    IA16,
    IA17,
    IA18,
    IA19,
    IA20,
    IB1,
    IB2,
    IB3,
    IB4,
    IB5,
    IB6,
    IB7,
    IB8,
    IB9,
    IB10,
    IB11,
    IB12,
    IB13,
    IB14,
    IB15,
    IB16,
    IB17,
    IB18,
    IB19,
    IB20
  ](
    m1: M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16, IA17, IA18, IA19, IA20],
    m2: M1[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15, IB16, IB17, IB18, IB19, IB20]
  ): M1[
    (IA1, IB1),
    (IA2, IB2),
    (IA3, IB3),
    (IA4, IB4),
    (IA5, IB5),
    (IA6, IB6),
    (IA7, IB7),
    (IA8, IB8),
    (IA9, IB9),
    (IA10, IB10),
    (IA11, IB11),
    (IA12, IB12),
    (IA13, IB13),
    (IA14, IB14),
    (IA15, IB15),
    (IA16, IB16),
    (IA17, IB17),
    (IA18, IB18),
    (IA19, IB19),
    (IA20, IB20)
  ]

}
trait Monad21TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  def zip[
    IA1,
    IA2,
    IA3,
    IA4,
    IA5,
    IA6,
    IA7,
    IA8,
    IA9,
    IA10,
    IA11,
    IA12,
    IA13,
    IA14,
    IA15,
    IA16,
    IA17,
    IA18,
    IA19,
    IA20,
    IA21,
    IB1,
    IB2,
    IB3,
    IB4,
    IB5,
    IB6,
    IB7,
    IB8,
    IB9,
    IB10,
    IB11,
    IB12,
    IB13,
    IB14,
    IB15,
    IB16,
    IB17,
    IB18,
    IB19,
    IB20,
    IB21
  ](
    m1: M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16, IA17, IA18, IA19, IA20, IA21],
    m2: M1[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15, IB16, IB17, IB18, IB19, IB20, IB21]
  ): M1[
    (IA1, IB1),
    (IA2, IB2),
    (IA3, IB3),
    (IA4, IB4),
    (IA5, IB5),
    (IA6, IB6),
    (IA7, IB7),
    (IA8, IB8),
    (IA9, IB9),
    (IA10, IB10),
    (IA11, IB11),
    (IA12, IB12),
    (IA13, IB13),
    (IA14, IB14),
    (IA15, IB15),
    (IA16, IB16),
    (IA17, IB17),
    (IA18, IB18),
    (IA19, IB19),
    (IA20, IB20),
    (IA21, IB21)
  ]

}
trait Monad22TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  def zip[
    IA1,
    IA2,
    IA3,
    IA4,
    IA5,
    IA6,
    IA7,
    IA8,
    IA9,
    IA10,
    IA11,
    IA12,
    IA13,
    IA14,
    IA15,
    IA16,
    IA17,
    IA18,
    IA19,
    IA20,
    IA21,
    IA22,
    IB1,
    IB2,
    IB3,
    IB4,
    IB5,
    IB6,
    IB7,
    IB8,
    IB9,
    IB10,
    IB11,
    IB12,
    IB13,
    IB14,
    IB15,
    IB16,
    IB17,
    IB18,
    IB19,
    IB20,
    IB21,
    IB22
  ](
    m1: M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16, IA17, IA18, IA19, IA20, IA21, IA22],
    m2: M1[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15, IB16, IB17, IB18, IB19, IB20, IB21, IB22]
  ): M1[
    (IA1, IB1),
    (IA2, IB2),
    (IA3, IB3),
    (IA4, IB4),
    (IA5, IB5),
    (IA6, IB6),
    (IA7, IB7),
    (IA8, IB8),
    (IA9, IB9),
    (IA10, IB10),
    (IA11, IB11),
    (IA12, IB12),
    (IA13, IB13),
    (IA14, IB14),
    (IA15, IB15),
    (IA16, IB16),
    (IA17, IB17),
    (IA18, IB18),
    (IA19, IB19),
    (IA20, IB20),
    (IA21, IB21),
    (IA22, IB22)
  ]

}
