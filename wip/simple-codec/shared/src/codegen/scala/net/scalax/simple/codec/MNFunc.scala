package net.scalax.simple.codec

trait Monad0Apply[M[_]] {
  def zip[X0, TU0](
    in1: M[X0],
    in2: M[TU0]
  ): M[(X0, TU0)]
}

trait Monad1Apply[M[_, _]] {
  def zip[X0, X1, TU0, TU1](
    in1: M[X0, X1],
    in2: M[TU0, TU1]
  ): M[(X0, TU0), (X1, TU1)]
}

trait Monad2Apply[M[_, _, _]] {
  def zip[X0, X1, X2, TU0, TU1, TU2](
    in1: M[X0, X1, X2],
    in2: M[TU0, TU1, TU2]
  ): M[(X0, TU0), (X1, TU1), (X2, TU2)]
}

trait Monad3Apply[M[_, _, _, _]] {
  def zip[X0, X1, X2, X3, TU0, TU1, TU2, TU3](
    in1: M[X0, X1, X2, X3],
    in2: M[TU0, TU1, TU2, TU3]
  ): M[(X0, TU0), (X1, TU1), (X2, TU2), (X3, TU3)]
}

trait Monad4Apply[M[_, _, _, _, _]] {
  def zip[X0, X1, X2, X3, X4, TU0, TU1, TU2, TU3, TU4](
    in1: M[X0, X1, X2, X3, X4],
    in2: M[TU0, TU1, TU2, TU3, TU4]
  ): M[(X0, TU0), (X1, TU1), (X2, TU2), (X3, TU3), (X4, TU4)]
}

trait Monad5Apply[M[_, _, _, _, _, _]] {
  def zip[X0, X1, X2, X3, X4, X5, TU0, TU1, TU2, TU3, TU4, TU5](
    in1: M[X0, X1, X2, X3, X4, X5],
    in2: M[TU0, TU1, TU2, TU3, TU4, TU5]
  ): M[(X0, TU0), (X1, TU1), (X2, TU2), (X3, TU3), (X4, TU4), (X5, TU5)]
}

trait Monad6Apply[M[_, _, _, _, _, _, _]] {
  def zip[X0, X1, X2, X3, X4, X5, X6, TU0, TU1, TU2, TU3, TU4, TU5, TU6](
    in1: M[X0, X1, X2, X3, X4, X5, X6],
    in2: M[TU0, TU1, TU2, TU3, TU4, TU5, TU6]
  ): M[(X0, TU0), (X1, TU1), (X2, TU2), (X3, TU3), (X4, TU4), (X5, TU5), (X6, TU6)]
}

trait Monad7Apply[M[_, _, _, _, _, _, _, _]] {
  def zip[X0, X1, X2, X3, X4, X5, X6, X7, TU0, TU1, TU2, TU3, TU4, TU5, TU6, TU7](
    in1: M[X0, X1, X2, X3, X4, X5, X6, X7],
    in2: M[TU0, TU1, TU2, TU3, TU4, TU5, TU6, TU7]
  ): M[(X0, TU0), (X1, TU1), (X2, TU2), (X3, TU3), (X4, TU4), (X5, TU5), (X6, TU6), (X7, TU7)]
}

trait Monad8Apply[M[_, _, _, _, _, _, _, _, _]] {
  def zip[X0, X1, X2, X3, X4, X5, X6, X7, X8, TU0, TU1, TU2, TU3, TU4, TU5, TU6, TU7, TU8](
    in1: M[X0, X1, X2, X3, X4, X5, X6, X7, X8],
    in2: M[TU0, TU1, TU2, TU3, TU4, TU5, TU6, TU7, TU8]
  ): M[(X0, TU0), (X1, TU1), (X2, TU2), (X3, TU3), (X4, TU4), (X5, TU5), (X6, TU6), (X7, TU7), (X8, TU8)]
}

trait Monad9Apply[M[_, _, _, _, _, _, _, _, _, _]] {
  def zip[X0, X1, X2, X3, X4, X5, X6, X7, X8, X9, TU0, TU1, TU2, TU3, TU4, TU5, TU6, TU7, TU8, TU9](
    in1: M[X0, X1, X2, X3, X4, X5, X6, X7, X8, X9],
    in2: M[TU0, TU1, TU2, TU3, TU4, TU5, TU6, TU7, TU8, TU9]
  ): M[(X0, TU0), (X1, TU1), (X2, TU2), (X3, TU3), (X4, TU4), (X5, TU5), (X6, TU6), (X7, TU7), (X8, TU8), (X9, TU9)]
}

trait Monad10Apply[M[_, _, _, _, _, _, _, _, _, _, _]] {
  def zip[X0, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, TU0, TU1, TU2, TU3, TU4, TU5, TU6, TU7, TU8, TU9, TU10](
    in1: M[X0, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10],
    in2: M[TU0, TU1, TU2, TU3, TU4, TU5, TU6, TU7, TU8, TU9, TU10]
  ): M[(X0, TU0), (X1, TU1), (X2, TU2), (X3, TU3), (X4, TU4), (X5, TU5), (X6, TU6), (X7, TU7), (X8, TU8), (X9, TU9), (X10, TU10)]
}

trait Monad11Apply[M[_, _, _, _, _, _, _, _, _, _, _, _]] {
  def zip[X0, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, TU0, TU1, TU2, TU3, TU4, TU5, TU6, TU7, TU8, TU9, TU10, TU11](
    in1: M[X0, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11],
    in2: M[TU0, TU1, TU2, TU3, TU4, TU5, TU6, TU7, TU8, TU9, TU10, TU11]
  ): M[
    (X0, TU0),
    (X1, TU1),
    (X2, TU2),
    (X3, TU3),
    (X4, TU4),
    (X5, TU5),
    (X6, TU6),
    (X7, TU7),
    (X8, TU8),
    (X9, TU9),
    (X10, TU10),
    (X11, TU11)
  ]
}

trait Monad12Apply[M[_, _, _, _, _, _, _, _, _, _, _, _, _]] {
  def zip[X0, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, TU0, TU1, TU2, TU3, TU4, TU5, TU6, TU7, TU8, TU9, TU10, TU11, TU12](
    in1: M[X0, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12],
    in2: M[TU0, TU1, TU2, TU3, TU4, TU5, TU6, TU7, TU8, TU9, TU10, TU11, TU12]
  ): M[
    (X0, TU0),
    (X1, TU1),
    (X2, TU2),
    (X3, TU3),
    (X4, TU4),
    (X5, TU5),
    (X6, TU6),
    (X7, TU7),
    (X8, TU8),
    (X9, TU9),
    (X10, TU10),
    (X11, TU11),
    (X12, TU12)
  ]
}

trait Monad13Apply[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _]] {
  def zip[
    X0,
    X1,
    X2,
    X3,
    X4,
    X5,
    X6,
    X7,
    X8,
    X9,
    X10,
    X11,
    X12,
    X13,
    TU0,
    TU1,
    TU2,
    TU3,
    TU4,
    TU5,
    TU6,
    TU7,
    TU8,
    TU9,
    TU10,
    TU11,
    TU12,
    TU13
  ](
    in1: M[X0, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13],
    in2: M[TU0, TU1, TU2, TU3, TU4, TU5, TU6, TU7, TU8, TU9, TU10, TU11, TU12, TU13]
  ): M[
    (X0, TU0),
    (X1, TU1),
    (X2, TU2),
    (X3, TU3),
    (X4, TU4),
    (X5, TU5),
    (X6, TU6),
    (X7, TU7),
    (X8, TU8),
    (X9, TU9),
    (X10, TU10),
    (X11, TU11),
    (X12, TU12),
    (X13, TU13)
  ]
}

trait Monad14Apply[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {
  def zip[
    X0,
    X1,
    X2,
    X3,
    X4,
    X5,
    X6,
    X7,
    X8,
    X9,
    X10,
    X11,
    X12,
    X13,
    X14,
    TU0,
    TU1,
    TU2,
    TU3,
    TU4,
    TU5,
    TU6,
    TU7,
    TU8,
    TU9,
    TU10,
    TU11,
    TU12,
    TU13,
    TU14
  ](
    in1: M[X0, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14],
    in2: M[TU0, TU1, TU2, TU3, TU4, TU5, TU6, TU7, TU8, TU9, TU10, TU11, TU12, TU13, TU14]
  ): M[
    (X0, TU0),
    (X1, TU1),
    (X2, TU2),
    (X3, TU3),
    (X4, TU4),
    (X5, TU5),
    (X6, TU6),
    (X7, TU7),
    (X8, TU8),
    (X9, TU9),
    (X10, TU10),
    (X11, TU11),
    (X12, TU12),
    (X13, TU13),
    (X14, TU14)
  ]
}

trait Monad15Apply[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {
  def zip[
    X0,
    X1,
    X2,
    X3,
    X4,
    X5,
    X6,
    X7,
    X8,
    X9,
    X10,
    X11,
    X12,
    X13,
    X14,
    X15,
    TU0,
    TU1,
    TU2,
    TU3,
    TU4,
    TU5,
    TU6,
    TU7,
    TU8,
    TU9,
    TU10,
    TU11,
    TU12,
    TU13,
    TU14,
    TU15
  ](
    in1: M[X0, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15],
    in2: M[TU0, TU1, TU2, TU3, TU4, TU5, TU6, TU7, TU8, TU9, TU10, TU11, TU12, TU13, TU14, TU15]
  ): M[
    (X0, TU0),
    (X1, TU1),
    (X2, TU2),
    (X3, TU3),
    (X4, TU4),
    (X5, TU5),
    (X6, TU6),
    (X7, TU7),
    (X8, TU8),
    (X9, TU9),
    (X10, TU10),
    (X11, TU11),
    (X12, TU12),
    (X13, TU13),
    (X14, TU14),
    (X15, TU15)
  ]
}

trait Monad16Apply[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {
  def zip[
    X0,
    X1,
    X2,
    X3,
    X4,
    X5,
    X6,
    X7,
    X8,
    X9,
    X10,
    X11,
    X12,
    X13,
    X14,
    X15,
    X16,
    TU0,
    TU1,
    TU2,
    TU3,
    TU4,
    TU5,
    TU6,
    TU7,
    TU8,
    TU9,
    TU10,
    TU11,
    TU12,
    TU13,
    TU14,
    TU15,
    TU16
  ](
    in1: M[X0, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16],
    in2: M[TU0, TU1, TU2, TU3, TU4, TU5, TU6, TU7, TU8, TU9, TU10, TU11, TU12, TU13, TU14, TU15, TU16]
  ): M[
    (X0, TU0),
    (X1, TU1),
    (X2, TU2),
    (X3, TU3),
    (X4, TU4),
    (X5, TU5),
    (X6, TU6),
    (X7, TU7),
    (X8, TU8),
    (X9, TU9),
    (X10, TU10),
    (X11, TU11),
    (X12, TU12),
    (X13, TU13),
    (X14, TU14),
    (X15, TU15),
    (X16, TU16)
  ]
}

trait Monad17Apply[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {
  def zip[
    X0,
    X1,
    X2,
    X3,
    X4,
    X5,
    X6,
    X7,
    X8,
    X9,
    X10,
    X11,
    X12,
    X13,
    X14,
    X15,
    X16,
    X17,
    TU0,
    TU1,
    TU2,
    TU3,
    TU4,
    TU5,
    TU6,
    TU7,
    TU8,
    TU9,
    TU10,
    TU11,
    TU12,
    TU13,
    TU14,
    TU15,
    TU16,
    TU17
  ](
    in1: M[X0, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17],
    in2: M[TU0, TU1, TU2, TU3, TU4, TU5, TU6, TU7, TU8, TU9, TU10, TU11, TU12, TU13, TU14, TU15, TU16, TU17]
  ): M[
    (X0, TU0),
    (X1, TU1),
    (X2, TU2),
    (X3, TU3),
    (X4, TU4),
    (X5, TU5),
    (X6, TU6),
    (X7, TU7),
    (X8, TU8),
    (X9, TU9),
    (X10, TU10),
    (X11, TU11),
    (X12, TU12),
    (X13, TU13),
    (X14, TU14),
    (X15, TU15),
    (X16, TU16),
    (X17, TU17)
  ]
}

trait Monad18Apply[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {
  def zip[
    X0,
    X1,
    X2,
    X3,
    X4,
    X5,
    X6,
    X7,
    X8,
    X9,
    X10,
    X11,
    X12,
    X13,
    X14,
    X15,
    X16,
    X17,
    X18,
    TU0,
    TU1,
    TU2,
    TU3,
    TU4,
    TU5,
    TU6,
    TU7,
    TU8,
    TU9,
    TU10,
    TU11,
    TU12,
    TU13,
    TU14,
    TU15,
    TU16,
    TU17,
    TU18
  ](
    in1: M[X0, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18],
    in2: M[TU0, TU1, TU2, TU3, TU4, TU5, TU6, TU7, TU8, TU9, TU10, TU11, TU12, TU13, TU14, TU15, TU16, TU17, TU18]
  ): M[
    (X0, TU0),
    (X1, TU1),
    (X2, TU2),
    (X3, TU3),
    (X4, TU4),
    (X5, TU5),
    (X6, TU6),
    (X7, TU7),
    (X8, TU8),
    (X9, TU9),
    (X10, TU10),
    (X11, TU11),
    (X12, TU12),
    (X13, TU13),
    (X14, TU14),
    (X15, TU15),
    (X16, TU16),
    (X17, TU17),
    (X18, TU18)
  ]
}

trait Monad19Apply[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {
  def zip[
    X0,
    X1,
    X2,
    X3,
    X4,
    X5,
    X6,
    X7,
    X8,
    X9,
    X10,
    X11,
    X12,
    X13,
    X14,
    X15,
    X16,
    X17,
    X18,
    X19,
    TU0,
    TU1,
    TU2,
    TU3,
    TU4,
    TU5,
    TU6,
    TU7,
    TU8,
    TU9,
    TU10,
    TU11,
    TU12,
    TU13,
    TU14,
    TU15,
    TU16,
    TU17,
    TU18,
    TU19
  ](
    in1: M[X0, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19],
    in2: M[TU0, TU1, TU2, TU3, TU4, TU5, TU6, TU7, TU8, TU9, TU10, TU11, TU12, TU13, TU14, TU15, TU16, TU17, TU18, TU19]
  ): M[
    (X0, TU0),
    (X1, TU1),
    (X2, TU2),
    (X3, TU3),
    (X4, TU4),
    (X5, TU5),
    (X6, TU6),
    (X7, TU7),
    (X8, TU8),
    (X9, TU9),
    (X10, TU10),
    (X11, TU11),
    (X12, TU12),
    (X13, TU13),
    (X14, TU14),
    (X15, TU15),
    (X16, TU16),
    (X17, TU17),
    (X18, TU18),
    (X19, TU19)
  ]
}

trait Monad20Apply[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {
  def zip[
    X0,
    X1,
    X2,
    X3,
    X4,
    X5,
    X6,
    X7,
    X8,
    X9,
    X10,
    X11,
    X12,
    X13,
    X14,
    X15,
    X16,
    X17,
    X18,
    X19,
    X20,
    TU0,
    TU1,
    TU2,
    TU3,
    TU4,
    TU5,
    TU6,
    TU7,
    TU8,
    TU9,
    TU10,
    TU11,
    TU12,
    TU13,
    TU14,
    TU15,
    TU16,
    TU17,
    TU18,
    TU19,
    TU20
  ](
    in1: M[X0, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20],
    in2: M[TU0, TU1, TU2, TU3, TU4, TU5, TU6, TU7, TU8, TU9, TU10, TU11, TU12, TU13, TU14, TU15, TU16, TU17, TU18, TU19, TU20]
  ): M[
    (X0, TU0),
    (X1, TU1),
    (X2, TU2),
    (X3, TU3),
    (X4, TU4),
    (X5, TU5),
    (X6, TU6),
    (X7, TU7),
    (X8, TU8),
    (X9, TU9),
    (X10, TU10),
    (X11, TU11),
    (X12, TU12),
    (X13, TU13),
    (X14, TU14),
    (X15, TU15),
    (X16, TU16),
    (X17, TU17),
    (X18, TU18),
    (X19, TU19),
    (X20, TU20)
  ]
}

trait Monad21Apply[M[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {
  def zip[
    X0,
    X1,
    X2,
    X3,
    X4,
    X5,
    X6,
    X7,
    X8,
    X9,
    X10,
    X11,
    X12,
    X13,
    X14,
    X15,
    X16,
    X17,
    X18,
    X19,
    X20,
    X21,
    TU0,
    TU1,
    TU2,
    TU3,
    TU4,
    TU5,
    TU6,
    TU7,
    TU8,
    TU9,
    TU10,
    TU11,
    TU12,
    TU13,
    TU14,
    TU15,
    TU16,
    TU17,
    TU18,
    TU19,
    TU20,
    TU21
  ](
    in1: M[X0, X1, X2, X3, X4, X5, X6, X7, X8, X9, X10, X11, X12, X13, X14, X15, X16, X17, X18, X19, X20, X21],
    in2: M[TU0, TU1, TU2, TU3, TU4, TU5, TU6, TU7, TU8, TU9, TU10, TU11, TU12, TU13, TU14, TU15, TU16, TU17, TU18, TU19, TU20, TU21]
  ): M[
    (X0, TU0),
    (X1, TU1),
    (X2, TU2),
    (X3, TU3),
    (X4, TU4),
    (X5, TU5),
    (X6, TU6),
    (X7, TU7),
    (X8, TU8),
    (X9, TU9),
    (X10, TU10),
    (X11, TU11),
    (X12, TU12),
    (X13, TU13),
    (X14, TU14),
    (X15, TU15),
    (X16, TU16),
    (X17, TU17),
    (X18, TU18),
    (X19, TU19),
    (X20, TU20),
    (X21, TU21)
  ]
}
