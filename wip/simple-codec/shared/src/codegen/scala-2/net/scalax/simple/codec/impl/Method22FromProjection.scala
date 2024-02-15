package net.scalax.simple.codec

import decode.projection._

object TypeContext {

  trait MFrom1[I1] extends DataHList {
    override type DataType = I1
    override type DataTail = DataHListZero
  }

  trait MFrom2[I1, I2] extends DataHList {
    override type DataType = I1
    override type DataTail = MFrom1[I2]
  }

  trait MFrom3[I1, I2, I3] extends DataHList {
    override type DataType = I1
    override type DataTail = MFrom2[I2, I3]
  }

  trait MFrom4[I1, I2, I3, I4] extends DataHList {
    override type DataType = I1
    override type DataTail = MFrom3[I2, I3, I4]
  }

  trait MFrom5[I1, I2, I3, I4, I5] extends DataHList {
    override type DataType = I1
    override type DataTail = MFrom4[I2, I3, I4, I5]
  }

  trait MFrom6[I1, I2, I3, I4, I5, I6] extends DataHList {
    override type DataType = I1
    override type DataTail = MFrom5[I2, I3, I4, I5, I6]
  }

  trait MFrom7[I1, I2, I3, I4, I5, I6, I7] extends DataHList {
    override type DataType = I1
    override type DataTail = MFrom6[I2, I3, I4, I5, I6, I7]
  }

  trait MFrom8[I1, I2, I3, I4, I5, I6, I7, I8] extends DataHList {
    override type DataType = I1
    override type DataTail = MFrom7[I2, I3, I4, I5, I6, I7, I8]
  }

  trait MFrom9[I1, I2, I3, I4, I5, I6, I7, I8, I9] extends DataHList {
    override type DataType = I1
    override type DataTail = MFrom8[I2, I3, I4, I5, I6, I7, I8, I9]
  }

  trait MFrom10[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10] extends DataHList {
    override type DataType = I1
    override type DataTail = MFrom9[I2, I3, I4, I5, I6, I7, I8, I9, I10]
  }

  trait MFrom11[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11] extends DataHList {
    override type DataType = I1
    override type DataTail = MFrom10[I2, I3, I4, I5, I6, I7, I8, I9, I10, I11]
  }

  trait MFrom12[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12] extends DataHList {
    override type DataType = I1
    override type DataTail = MFrom11[I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12]
  }

  trait MFrom13[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13] extends DataHList {
    override type DataType = I1
    override type DataTail = MFrom12[I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13]
  }

  trait MFrom14[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14] extends DataHList {
    override type DataType = I1
    override type DataTail = MFrom13[I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14]
  }

  trait MFrom15[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15] extends DataHList {
    override type DataType = I1
    override type DataTail = MFrom14[I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15]
  }

  trait MFrom16[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16] extends DataHList {
    override type DataType = I1
    override type DataTail = MFrom15[I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16]
  }

  trait MFrom17[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17] extends DataHList {
    override type DataType = I1
    override type DataTail = MFrom16[I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17]
  }

  trait MFrom18[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18] extends DataHList {
    override type DataType = I1
    override type DataTail = MFrom17[I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18]
  }

  trait MFrom19[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19] extends DataHList {
    override type DataType = I1
    override type DataTail = MFrom18[I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19]
  }

  trait MFrom20[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20] extends DataHList {
    override type DataType = I1
    override type DataTail = MFrom19[I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20]
  }

  trait MFrom21[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21] extends DataHList {
    override type DataType = I1
    override type DataTail = MFrom20[I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21]
  }

  trait MFrom22[I1, I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22] extends DataHList {
    override type DataType = I1
    override type DataTail = MFrom21[I2, I3, I4, I5, I6, I7, I8, I9, I10, I11, I12, I13, I14, I15, I16, I17, I18, I19, I20, I21, I22]
  }

}

trait Monad1TypeLevel[M1[_]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  type MSelfFrom[TX <: DataHList] = M1[TX#DataType]

  def zip[
    IA1,
    IB1
  ](
    m1: M1[IA1],
    m2: M1[IB1]
  ): M1[(IA1, IB1)] = mImpl[MSelfFrom].zip[TypeContext.MFrom1[IA1], TypeContext.MFrom1[IB1]](m1, m2)

  def map[
    IA1,
    IB1
  ](
    ia1: IA1 => IB1
  )(
    ib1: IB1 => IA1
  ): M1[IA1] => M1[IB1] = mImpl[MSelfFrom].map[
    TypeContext.MFrom1[IA1],
    TypeContext.MFrom1[IB1]
  ](new DFuncTypeImpl[TypeContext.MFrom1[IA1], TypeContext.MFrom1[IB1]](ia1, ib1, DFuncTypeZero))

  def zero: M1[Unit] = map((_: ZeroInstance) => (): Unit)((_: Unit) => ZeroInstance.instance)(mImpl[MSelfFrom].zero)

}
trait Monad2TypeLevel[M1[_, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  type MSelfFrom[TX <: DataHList] = M1[TX#DataType, TX#DataTail#DataType]

  def zip[
    IA1,
    IA2,
    IB1,
    IB2
  ](
    m1: M1[IA1, IA2],
    m2: M1[IB1, IB2]
  ): M1[(IA1, IB1), (IA2, IB2)] = mImpl[MSelfFrom].zip[TypeContext.MFrom2[IA1, IA2], TypeContext.MFrom2[IB1, IB2]](m1, m2)

  def map[
    IA1,
    IA2,
    IB1,
    IB2
  ](
    ia1: IA1 => IB1,
    ia2: IA2 => IB2
  )(
    ib1: IB1 => IA1,
    ib2: IB2 => IA2
  ): M1[IA1, IA2] => M1[IB1, IB2] = mImpl[MSelfFrom].map[
    TypeContext.MFrom2[IA1, IA2],
    TypeContext.MFrom2[IB1, IB2]
  ](
    new DFuncTypeImpl[TypeContext.MFrom2[IA1, IA2], TypeContext.MFrom2[IB1, IB2]](
      ia1,
      ib1,
      new DFuncTypeImpl[TypeContext.MFrom2[IA1, IA2]#DataTail, TypeContext.MFrom2[IB1, IB2]#DataTail](ia2, ib2, DFuncTypeZero)
    )
  )

  def zero: M1[Unit, Unit] = map((_: ZeroInstance) => (): Unit, (_: ZeroInstance) => (): Unit)(
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance
  )(mImpl[MSelfFrom].zero)

}
trait Monad3TypeLevel[M1[_, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  type MSelfFrom[TX <: DataHList] = M1[TX#DataType, TX#DataTail#DataType, TX#DataTail#DataTail#DataType]

  def zip[
    IA1,
    IA2,
    IA3,
    IB1,
    IB2,
    IB3
  ](
    m1: M1[IA1, IA2, IA3],
    m2: M1[IB1, IB2, IB3]
  ): M1[(IA1, IB1), (IA2, IB2), (IA3, IB3)] =
    mImpl[MSelfFrom].zip[TypeContext.MFrom3[IA1, IA2, IA3], TypeContext.MFrom3[IB1, IB2, IB3]](m1, m2)

  def map[
    IA1,
    IA2,
    IA3,
    IB1,
    IB2,
    IB3
  ](
    ia1: IA1 => IB1,
    ia2: IA2 => IB2,
    ia3: IA3 => IB3
  )(
    ib1: IB1 => IA1,
    ib2: IB2 => IA2,
    ib3: IB3 => IA3
  ): M1[IA1, IA2, IA3] => M1[IB1, IB2, IB3] = mImpl[MSelfFrom].map[
    TypeContext.MFrom3[IA1, IA2, IA3],
    TypeContext.MFrom3[IB1, IB2, IB3]
  ](
    new DFuncTypeImpl[TypeContext.MFrom3[IA1, IA2, IA3], TypeContext.MFrom3[IB1, IB2, IB3]](
      ia1,
      ib1,
      new DFuncTypeImpl[TypeContext.MFrom3[IA1, IA2, IA3]#DataTail, TypeContext.MFrom3[IB1, IB2, IB3]#DataTail](
        ia2,
        ib2,
        new DFuncTypeImpl[TypeContext.MFrom3[IA1, IA2, IA3]#DataTail#DataTail, TypeContext.MFrom3[IB1, IB2, IB3]#DataTail#DataTail](
          ia3,
          ib3,
          DFuncTypeZero
        )
      )
    )
  )

  def zero: M1[Unit, Unit, Unit] = map((_: ZeroInstance) => (): Unit, (_: ZeroInstance) => (): Unit, (_: ZeroInstance) => (): Unit)(
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance
  )(mImpl[MSelfFrom].zero)

}
trait Monad4TypeLevel[M1[_, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  type MSelfFrom[TX <: DataHList] =
    M1[TX#DataType, TX#DataTail#DataType, TX#DataTail#DataTail#DataType, TX#DataTail#DataTail#DataTail#DataType]

  def zip[
    IA1,
    IA2,
    IA3,
    IA4,
    IB1,
    IB2,
    IB3,
    IB4
  ](
    m1: M1[IA1, IA2, IA3, IA4],
    m2: M1[IB1, IB2, IB3, IB4]
  ): M1[(IA1, IB1), (IA2, IB2), (IA3, IB3), (IA4, IB4)] =
    mImpl[MSelfFrom].zip[TypeContext.MFrom4[IA1, IA2, IA3, IA4], TypeContext.MFrom4[IB1, IB2, IB3, IB4]](m1, m2)

  def map[
    IA1,
    IA2,
    IA3,
    IA4,
    IB1,
    IB2,
    IB3,
    IB4
  ](
    ia1: IA1 => IB1,
    ia2: IA2 => IB2,
    ia3: IA3 => IB3,
    ia4: IA4 => IB4
  )(
    ib1: IB1 => IA1,
    ib2: IB2 => IA2,
    ib3: IB3 => IA3,
    ib4: IB4 => IA4
  ): M1[IA1, IA2, IA3, IA4] => M1[IB1, IB2, IB3, IB4] = mImpl[MSelfFrom].map[
    TypeContext.MFrom4[IA1, IA2, IA3, IA4],
    TypeContext.MFrom4[IB1, IB2, IB3, IB4]
  ](
    new DFuncTypeImpl[TypeContext.MFrom4[IA1, IA2, IA3, IA4], TypeContext.MFrom4[IB1, IB2, IB3, IB4]](
      ia1,
      ib1,
      new DFuncTypeImpl[TypeContext.MFrom4[IA1, IA2, IA3, IA4]#DataTail, TypeContext.MFrom4[IB1, IB2, IB3, IB4]#DataTail](
        ia2,
        ib2,
        new DFuncTypeImpl[
          TypeContext.MFrom4[IA1, IA2, IA3, IA4]#DataTail#DataTail,
          TypeContext.MFrom4[IB1, IB2, IB3, IB4]#DataTail#DataTail
        ](
          ia3,
          ib3,
          new DFuncTypeImpl[
            TypeContext.MFrom4[IA1, IA2, IA3, IA4]#DataTail#DataTail#DataTail,
            TypeContext.MFrom4[IB1, IB2, IB3, IB4]#DataTail#DataTail#DataTail
          ](ia4, ib4, DFuncTypeZero)
        )
      )
    )
  )

  def zero: M1[Unit, Unit, Unit, Unit] =
    map((_: ZeroInstance) => (): Unit, (_: ZeroInstance) => (): Unit, (_: ZeroInstance) => (): Unit, (_: ZeroInstance) => (): Unit)(
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance
    )(mImpl[MSelfFrom].zero)

}
trait Monad5TypeLevel[M1[_, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  type MSelfFrom[TX <: DataHList] = M1[
    TX#DataType,
    TX#DataTail#DataType,
    TX#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataType
  ]

  def zip[
    IA1,
    IA2,
    IA3,
    IA4,
    IA5,
    IB1,
    IB2,
    IB3,
    IB4,
    IB5
  ](
    m1: M1[IA1, IA2, IA3, IA4, IA5],
    m2: M1[IB1, IB2, IB3, IB4, IB5]
  ): M1[(IA1, IB1), (IA2, IB2), (IA3, IB3), (IA4, IB4), (IA5, IB5)] =
    mImpl[MSelfFrom].zip[TypeContext.MFrom5[IA1, IA2, IA3, IA4, IA5], TypeContext.MFrom5[IB1, IB2, IB3, IB4, IB5]](m1, m2)

  def map[
    IA1,
    IA2,
    IA3,
    IA4,
    IA5,
    IB1,
    IB2,
    IB3,
    IB4,
    IB5
  ](
    ia1: IA1 => IB1,
    ia2: IA2 => IB2,
    ia3: IA3 => IB3,
    ia4: IA4 => IB4,
    ia5: IA5 => IB5
  )(
    ib1: IB1 => IA1,
    ib2: IB2 => IA2,
    ib3: IB3 => IA3,
    ib4: IB4 => IA4,
    ib5: IB5 => IA5
  ): M1[IA1, IA2, IA3, IA4, IA5] => M1[IB1, IB2, IB3, IB4, IB5] = mImpl[MSelfFrom].map[
    TypeContext.MFrom5[IA1, IA2, IA3, IA4, IA5],
    TypeContext.MFrom5[IB1, IB2, IB3, IB4, IB5]
  ](
    new DFuncTypeImpl[TypeContext.MFrom5[IA1, IA2, IA3, IA4, IA5], TypeContext.MFrom5[IB1, IB2, IB3, IB4, IB5]](
      ia1,
      ib1,
      new DFuncTypeImpl[TypeContext.MFrom5[IA1, IA2, IA3, IA4, IA5]#DataTail, TypeContext.MFrom5[IB1, IB2, IB3, IB4, IB5]#DataTail](
        ia2,
        ib2,
        new DFuncTypeImpl[
          TypeContext.MFrom5[IA1, IA2, IA3, IA4, IA5]#DataTail#DataTail,
          TypeContext.MFrom5[IB1, IB2, IB3, IB4, IB5]#DataTail#DataTail
        ](
          ia3,
          ib3,
          new DFuncTypeImpl[
            TypeContext.MFrom5[IA1, IA2, IA3, IA4, IA5]#DataTail#DataTail#DataTail,
            TypeContext.MFrom5[IB1, IB2, IB3, IB4, IB5]#DataTail#DataTail#DataTail
          ](
            ia4,
            ib4,
            new DFuncTypeImpl[
              TypeContext.MFrom5[IA1, IA2, IA3, IA4, IA5]#DataTail#DataTail#DataTail#DataTail,
              TypeContext.MFrom5[IB1, IB2, IB3, IB4, IB5]#DataTail#DataTail#DataTail#DataTail
            ](ia5, ib5, DFuncTypeZero)
          )
        )
      )
    )
  )

  def zero: M1[Unit, Unit, Unit, Unit, Unit] = map(
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit
  )(
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance
  )(mImpl[MSelfFrom].zero)

}
trait Monad6TypeLevel[M1[_, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  type MSelfFrom[TX <: DataHList] = M1[
    TX#DataType,
    TX#DataTail#DataType,
    TX#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataType
  ]

  def zip[
    IA1,
    IA2,
    IA3,
    IA4,
    IA5,
    IA6,
    IB1,
    IB2,
    IB3,
    IB4,
    IB5,
    IB6
  ](
    m1: M1[IA1, IA2, IA3, IA4, IA5, IA6],
    m2: M1[IB1, IB2, IB3, IB4, IB5, IB6]
  ): M1[(IA1, IB1), (IA2, IB2), (IA3, IB3), (IA4, IB4), (IA5, IB5), (IA6, IB6)] =
    mImpl[MSelfFrom].zip[TypeContext.MFrom6[IA1, IA2, IA3, IA4, IA5, IA6], TypeContext.MFrom6[IB1, IB2, IB3, IB4, IB5, IB6]](m1, m2)

  def map[
    IA1,
    IA2,
    IA3,
    IA4,
    IA5,
    IA6,
    IB1,
    IB2,
    IB3,
    IB4,
    IB5,
    IB6
  ](
    ia1: IA1 => IB1,
    ia2: IA2 => IB2,
    ia3: IA3 => IB3,
    ia4: IA4 => IB4,
    ia5: IA5 => IB5,
    ia6: IA6 => IB6
  )(
    ib1: IB1 => IA1,
    ib2: IB2 => IA2,
    ib3: IB3 => IA3,
    ib4: IB4 => IA4,
    ib5: IB5 => IA5,
    ib6: IB6 => IA6
  ): M1[IA1, IA2, IA3, IA4, IA5, IA6] => M1[IB1, IB2, IB3, IB4, IB5, IB6] = mImpl[MSelfFrom].map[
    TypeContext.MFrom6[IA1, IA2, IA3, IA4, IA5, IA6],
    TypeContext.MFrom6[IB1, IB2, IB3, IB4, IB5, IB6]
  ](
    new DFuncTypeImpl[TypeContext.MFrom6[IA1, IA2, IA3, IA4, IA5, IA6], TypeContext.MFrom6[IB1, IB2, IB3, IB4, IB5, IB6]](
      ia1,
      ib1,
      new DFuncTypeImpl[
        TypeContext.MFrom6[IA1, IA2, IA3, IA4, IA5, IA6]#DataTail,
        TypeContext.MFrom6[IB1, IB2, IB3, IB4, IB5, IB6]#DataTail
      ](
        ia2,
        ib2,
        new DFuncTypeImpl[
          TypeContext.MFrom6[IA1, IA2, IA3, IA4, IA5, IA6]#DataTail#DataTail,
          TypeContext.MFrom6[IB1, IB2, IB3, IB4, IB5, IB6]#DataTail#DataTail
        ](
          ia3,
          ib3,
          new DFuncTypeImpl[
            TypeContext.MFrom6[IA1, IA2, IA3, IA4, IA5, IA6]#DataTail#DataTail#DataTail,
            TypeContext.MFrom6[IB1, IB2, IB3, IB4, IB5, IB6]#DataTail#DataTail#DataTail
          ](
            ia4,
            ib4,
            new DFuncTypeImpl[
              TypeContext.MFrom6[IA1, IA2, IA3, IA4, IA5, IA6]#DataTail#DataTail#DataTail#DataTail,
              TypeContext.MFrom6[IB1, IB2, IB3, IB4, IB5, IB6]#DataTail#DataTail#DataTail#DataTail
            ](
              ia5,
              ib5,
              new DFuncTypeImpl[
                TypeContext.MFrom6[IA1, IA2, IA3, IA4, IA5, IA6]#DataTail#DataTail#DataTail#DataTail#DataTail,
                TypeContext.MFrom6[IB1, IB2, IB3, IB4, IB5, IB6]#DataTail#DataTail#DataTail#DataTail#DataTail
              ](ia6, ib6, DFuncTypeZero)
            )
          )
        )
      )
    )
  )

  def zero: M1[Unit, Unit, Unit, Unit, Unit, Unit] = map(
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit
  )(
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance
  )(mImpl[MSelfFrom].zero)

}
trait Monad7TypeLevel[M1[_, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  type MSelfFrom[TX <: DataHList] = M1[
    TX#DataType,
    TX#DataTail#DataType,
    TX#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType
  ]

  def zip[
    IA1,
    IA2,
    IA3,
    IA4,
    IA5,
    IA6,
    IA7,
    IB1,
    IB2,
    IB3,
    IB4,
    IB5,
    IB6,
    IB7
  ](
    m1: M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7],
    m2: M1[IB1, IB2, IB3, IB4, IB5, IB6, IB7]
  ): M1[(IA1, IB1), (IA2, IB2), (IA3, IB3), (IA4, IB4), (IA5, IB5), (IA6, IB6), (IA7, IB7)] = mImpl[MSelfFrom]
    .zip[TypeContext.MFrom7[IA1, IA2, IA3, IA4, IA5, IA6, IA7], TypeContext.MFrom7[IB1, IB2, IB3, IB4, IB5, IB6, IB7]](m1, m2)

  def map[
    IA1,
    IA2,
    IA3,
    IA4,
    IA5,
    IA6,
    IA7,
    IB1,
    IB2,
    IB3,
    IB4,
    IB5,
    IB6,
    IB7
  ](
    ia1: IA1 => IB1,
    ia2: IA2 => IB2,
    ia3: IA3 => IB3,
    ia4: IA4 => IB4,
    ia5: IA5 => IB5,
    ia6: IA6 => IB6,
    ia7: IA7 => IB7
  )(
    ib1: IB1 => IA1,
    ib2: IB2 => IA2,
    ib3: IB3 => IA3,
    ib4: IB4 => IA4,
    ib5: IB5 => IA5,
    ib6: IB6 => IA6,
    ib7: IB7 => IA7
  ): M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7] => M1[IB1, IB2, IB3, IB4, IB5, IB6, IB7] = mImpl[MSelfFrom].map[
    TypeContext.MFrom7[IA1, IA2, IA3, IA4, IA5, IA6, IA7],
    TypeContext.MFrom7[IB1, IB2, IB3, IB4, IB5, IB6, IB7]
  ](
    new DFuncTypeImpl[TypeContext.MFrom7[IA1, IA2, IA3, IA4, IA5, IA6, IA7], TypeContext.MFrom7[IB1, IB2, IB3, IB4, IB5, IB6, IB7]](
      ia1,
      ib1,
      new DFuncTypeImpl[
        TypeContext.MFrom7[IA1, IA2, IA3, IA4, IA5, IA6, IA7]#DataTail,
        TypeContext.MFrom7[IB1, IB2, IB3, IB4, IB5, IB6, IB7]#DataTail
      ](
        ia2,
        ib2,
        new DFuncTypeImpl[
          TypeContext.MFrom7[IA1, IA2, IA3, IA4, IA5, IA6, IA7]#DataTail#DataTail,
          TypeContext.MFrom7[IB1, IB2, IB3, IB4, IB5, IB6, IB7]#DataTail#DataTail
        ](
          ia3,
          ib3,
          new DFuncTypeImpl[
            TypeContext.MFrom7[IA1, IA2, IA3, IA4, IA5, IA6, IA7]#DataTail#DataTail#DataTail,
            TypeContext.MFrom7[IB1, IB2, IB3, IB4, IB5, IB6, IB7]#DataTail#DataTail#DataTail
          ](
            ia4,
            ib4,
            new DFuncTypeImpl[
              TypeContext.MFrom7[IA1, IA2, IA3, IA4, IA5, IA6, IA7]#DataTail#DataTail#DataTail#DataTail,
              TypeContext.MFrom7[IB1, IB2, IB3, IB4, IB5, IB6, IB7]#DataTail#DataTail#DataTail#DataTail
            ](
              ia5,
              ib5,
              new DFuncTypeImpl[
                TypeContext.MFrom7[IA1, IA2, IA3, IA4, IA5, IA6, IA7]#DataTail#DataTail#DataTail#DataTail#DataTail,
                TypeContext.MFrom7[IB1, IB2, IB3, IB4, IB5, IB6, IB7]#DataTail#DataTail#DataTail#DataTail#DataTail
              ](
                ia6,
                ib6,
                new DFuncTypeImpl[
                  TypeContext.MFrom7[IA1, IA2, IA3, IA4, IA5, IA6, IA7]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                  TypeContext.MFrom7[IB1, IB2, IB3, IB4, IB5, IB6, IB7]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                ](ia7, ib7, DFuncTypeZero)
              )
            )
          )
        )
      )
    )
  )

  def zero: M1[Unit, Unit, Unit, Unit, Unit, Unit, Unit] = map(
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit
  )(
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance
  )(mImpl[MSelfFrom].zero)

}
trait Monad8TypeLevel[M1[_, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  type MSelfFrom[TX <: DataHList] = M1[
    TX#DataType,
    TX#DataTail#DataType,
    TX#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType
  ]

  def zip[
    IA1,
    IA2,
    IA3,
    IA4,
    IA5,
    IA6,
    IA7,
    IA8,
    IB1,
    IB2,
    IB3,
    IB4,
    IB5,
    IB6,
    IB7,
    IB8
  ](
    m1: M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8],
    m2: M1[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8]
  ): M1[(IA1, IB1), (IA2, IB2), (IA3, IB3), (IA4, IB4), (IA5, IB5), (IA6, IB6), (IA7, IB7), (IA8, IB8)] = mImpl[MSelfFrom]
    .zip[TypeContext.MFrom8[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8], TypeContext.MFrom8[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8]](m1, m2)

  def map[
    IA1,
    IA2,
    IA3,
    IA4,
    IA5,
    IA6,
    IA7,
    IA8,
    IB1,
    IB2,
    IB3,
    IB4,
    IB5,
    IB6,
    IB7,
    IB8
  ](
    ia1: IA1 => IB1,
    ia2: IA2 => IB2,
    ia3: IA3 => IB3,
    ia4: IA4 => IB4,
    ia5: IA5 => IB5,
    ia6: IA6 => IB6,
    ia7: IA7 => IB7,
    ia8: IA8 => IB8
  )(
    ib1: IB1 => IA1,
    ib2: IB2 => IA2,
    ib3: IB3 => IA3,
    ib4: IB4 => IA4,
    ib5: IB5 => IA5,
    ib6: IB6 => IA6,
    ib7: IB7 => IA7,
    ib8: IB8 => IA8
  ): M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8] => M1[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8] = mImpl[MSelfFrom].map[
    TypeContext.MFrom8[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8],
    TypeContext.MFrom8[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8]
  ](
    new DFuncTypeImpl[
      TypeContext.MFrom8[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8],
      TypeContext.MFrom8[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8]
    ](
      ia1,
      ib1,
      new DFuncTypeImpl[
        TypeContext.MFrom8[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8]#DataTail,
        TypeContext.MFrom8[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8]#DataTail
      ](
        ia2,
        ib2,
        new DFuncTypeImpl[
          TypeContext.MFrom8[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8]#DataTail#DataTail,
          TypeContext.MFrom8[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8]#DataTail#DataTail
        ](
          ia3,
          ib3,
          new DFuncTypeImpl[
            TypeContext.MFrom8[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8]#DataTail#DataTail#DataTail,
            TypeContext.MFrom8[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8]#DataTail#DataTail#DataTail
          ](
            ia4,
            ib4,
            new DFuncTypeImpl[
              TypeContext.MFrom8[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8]#DataTail#DataTail#DataTail#DataTail,
              TypeContext.MFrom8[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8]#DataTail#DataTail#DataTail#DataTail
            ](
              ia5,
              ib5,
              new DFuncTypeImpl[
                TypeContext.MFrom8[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8]#DataTail#DataTail#DataTail#DataTail#DataTail,
                TypeContext.MFrom8[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8]#DataTail#DataTail#DataTail#DataTail#DataTail
              ](
                ia6,
                ib6,
                new DFuncTypeImpl[
                  TypeContext.MFrom8[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                  TypeContext.MFrom8[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                ](
                  ia7,
                  ib7,
                  new DFuncTypeImpl[
                    TypeContext.MFrom8[
                      IA1,
                      IA2,
                      IA3,
                      IA4,
                      IA5,
                      IA6,
                      IA7,
                      IA8
                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                    TypeContext.MFrom8[
                      IB1,
                      IB2,
                      IB3,
                      IB4,
                      IB5,
                      IB6,
                      IB7,
                      IB8
                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                  ](ia8, ib8, DFuncTypeZero)
                )
              )
            )
          )
        )
      )
    )
  )

  def zero: M1[Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit] = map(
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit
  )(
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance
  )(mImpl[MSelfFrom].zero)

}
trait Monad9TypeLevel[M1[_, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  type MSelfFrom[TX <: DataHList] = M1[
    TX#DataType,
    TX#DataTail#DataType,
    TX#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType
  ]

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
    IB1,
    IB2,
    IB3,
    IB4,
    IB5,
    IB6,
    IB7,
    IB8,
    IB9
  ](
    m1: M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9],
    m2: M1[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9]
  ): M1[(IA1, IB1), (IA2, IB2), (IA3, IB3), (IA4, IB4), (IA5, IB5), (IA6, IB6), (IA7, IB7), (IA8, IB8), (IA9, IB9)] = mImpl[MSelfFrom]
    .zip[TypeContext.MFrom9[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9], TypeContext.MFrom9[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9]](
      m1,
      m2
    )

  def map[
    IA1,
    IA2,
    IA3,
    IA4,
    IA5,
    IA6,
    IA7,
    IA8,
    IA9,
    IB1,
    IB2,
    IB3,
    IB4,
    IB5,
    IB6,
    IB7,
    IB8,
    IB9
  ](
    ia1: IA1 => IB1,
    ia2: IA2 => IB2,
    ia3: IA3 => IB3,
    ia4: IA4 => IB4,
    ia5: IA5 => IB5,
    ia6: IA6 => IB6,
    ia7: IA7 => IB7,
    ia8: IA8 => IB8,
    ia9: IA9 => IB9
  )(
    ib1: IB1 => IA1,
    ib2: IB2 => IA2,
    ib3: IB3 => IA3,
    ib4: IB4 => IA4,
    ib5: IB5 => IA5,
    ib6: IB6 => IA6,
    ib7: IB7 => IA7,
    ib8: IB8 => IA8,
    ib9: IB9 => IA9
  ): M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9] => M1[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9] = mImpl[MSelfFrom].map[
    TypeContext.MFrom9[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9],
    TypeContext.MFrom9[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9]
  ](
    new DFuncTypeImpl[
      TypeContext.MFrom9[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9],
      TypeContext.MFrom9[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9]
    ](
      ia1,
      ib1,
      new DFuncTypeImpl[
        TypeContext.MFrom9[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9]#DataTail,
        TypeContext.MFrom9[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9]#DataTail
      ](
        ia2,
        ib2,
        new DFuncTypeImpl[
          TypeContext.MFrom9[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9]#DataTail#DataTail,
          TypeContext.MFrom9[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9]#DataTail#DataTail
        ](
          ia3,
          ib3,
          new DFuncTypeImpl[
            TypeContext.MFrom9[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9]#DataTail#DataTail#DataTail,
            TypeContext.MFrom9[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9]#DataTail#DataTail#DataTail
          ](
            ia4,
            ib4,
            new DFuncTypeImpl[
              TypeContext.MFrom9[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9]#DataTail#DataTail#DataTail#DataTail,
              TypeContext.MFrom9[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9]#DataTail#DataTail#DataTail#DataTail
            ](
              ia5,
              ib5,
              new DFuncTypeImpl[
                TypeContext.MFrom9[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9]#DataTail#DataTail#DataTail#DataTail#DataTail,
                TypeContext.MFrom9[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9]#DataTail#DataTail#DataTail#DataTail#DataTail
              ](
                ia6,
                ib6,
                new DFuncTypeImpl[
                  TypeContext.MFrom9[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                  TypeContext.MFrom9[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                ](
                  ia7,
                  ib7,
                  new DFuncTypeImpl[
                    TypeContext.MFrom9[
                      IA1,
                      IA2,
                      IA3,
                      IA4,
                      IA5,
                      IA6,
                      IA7,
                      IA8,
                      IA9
                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                    TypeContext.MFrom9[
                      IB1,
                      IB2,
                      IB3,
                      IB4,
                      IB5,
                      IB6,
                      IB7,
                      IB8,
                      IB9
                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                  ](
                    ia8,
                    ib8,
                    new DFuncTypeImpl[
                      TypeContext.MFrom9[
                        IA1,
                        IA2,
                        IA3,
                        IA4,
                        IA5,
                        IA6,
                        IA7,
                        IA8,
                        IA9
                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                      TypeContext.MFrom9[
                        IB1,
                        IB2,
                        IB3,
                        IB4,
                        IB5,
                        IB6,
                        IB7,
                        IB8,
                        IB9
                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                    ](ia9, ib9, DFuncTypeZero)
                  )
                )
              )
            )
          )
        )
      )
    )
  )

  def zero: M1[Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit] = map(
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit
  )(
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance
  )(mImpl[MSelfFrom].zero)

}
trait Monad10TypeLevel[M1[_, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  type MSelfFrom[TX <: DataHList] = M1[
    TX#DataType,
    TX#DataTail#DataType,
    TX#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType
  ]

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
    IB1,
    IB2,
    IB3,
    IB4,
    IB5,
    IB6,
    IB7,
    IB8,
    IB9,
    IB10
  ](
    m1: M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10],
    m2: M1[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10]
  ): M1[(IA1, IB1), (IA2, IB2), (IA3, IB3), (IA4, IB4), (IA5, IB5), (IA6, IB6), (IA7, IB7), (IA8, IB8), (IA9, IB9), (IA10, IB10)] =
    mImpl[MSelfFrom].zip[TypeContext.MFrom10[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10], TypeContext.MFrom10[
      IB1,
      IB2,
      IB3,
      IB4,
      IB5,
      IB6,
      IB7,
      IB8,
      IB9,
      IB10
    ]](m1, m2)

  def map[
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
    IB1,
    IB2,
    IB3,
    IB4,
    IB5,
    IB6,
    IB7,
    IB8,
    IB9,
    IB10
  ](
    ia1: IA1 => IB1,
    ia2: IA2 => IB2,
    ia3: IA3 => IB3,
    ia4: IA4 => IB4,
    ia5: IA5 => IB5,
    ia6: IA6 => IB6,
    ia7: IA7 => IB7,
    ia8: IA8 => IB8,
    ia9: IA9 => IB9,
    ia10: IA10 => IB10
  )(
    ib1: IB1 => IA1,
    ib2: IB2 => IA2,
    ib3: IB3 => IA3,
    ib4: IB4 => IA4,
    ib5: IB5 => IA5,
    ib6: IB6 => IA6,
    ib7: IB7 => IA7,
    ib8: IB8 => IA8,
    ib9: IB9 => IA9,
    ib10: IB10 => IA10
  ): M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10] => M1[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10] = mImpl[MSelfFrom].map[
    TypeContext.MFrom10[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10],
    TypeContext.MFrom10[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10]
  ](
    new DFuncTypeImpl[
      TypeContext.MFrom10[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10],
      TypeContext.MFrom10[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10]
    ](
      ia1,
      ib1,
      new DFuncTypeImpl[
        TypeContext.MFrom10[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10]#DataTail,
        TypeContext.MFrom10[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10]#DataTail
      ](
        ia2,
        ib2,
        new DFuncTypeImpl[
          TypeContext.MFrom10[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10]#DataTail#DataTail,
          TypeContext.MFrom10[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10]#DataTail#DataTail
        ](
          ia3,
          ib3,
          new DFuncTypeImpl[
            TypeContext.MFrom10[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10]#DataTail#DataTail#DataTail,
            TypeContext.MFrom10[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10]#DataTail#DataTail#DataTail
          ](
            ia4,
            ib4,
            new DFuncTypeImpl[
              TypeContext.MFrom10[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10]#DataTail#DataTail#DataTail#DataTail,
              TypeContext.MFrom10[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10]#DataTail#DataTail#DataTail#DataTail
            ](
              ia5,
              ib5,
              new DFuncTypeImpl[
                TypeContext.MFrom10[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10]#DataTail#DataTail#DataTail#DataTail#DataTail,
                TypeContext.MFrom10[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10]#DataTail#DataTail#DataTail#DataTail#DataTail
              ](
                ia6,
                ib6,
                new DFuncTypeImpl[
                  TypeContext.MFrom10[
                    IA1,
                    IA2,
                    IA3,
                    IA4,
                    IA5,
                    IA6,
                    IA7,
                    IA8,
                    IA9,
                    IA10
                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                  TypeContext.MFrom10[
                    IB1,
                    IB2,
                    IB3,
                    IB4,
                    IB5,
                    IB6,
                    IB7,
                    IB8,
                    IB9,
                    IB10
                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                ](
                  ia7,
                  ib7,
                  new DFuncTypeImpl[
                    TypeContext.MFrom10[
                      IA1,
                      IA2,
                      IA3,
                      IA4,
                      IA5,
                      IA6,
                      IA7,
                      IA8,
                      IA9,
                      IA10
                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                    TypeContext.MFrom10[
                      IB1,
                      IB2,
                      IB3,
                      IB4,
                      IB5,
                      IB6,
                      IB7,
                      IB8,
                      IB9,
                      IB10
                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                  ](
                    ia8,
                    ib8,
                    new DFuncTypeImpl[
                      TypeContext.MFrom10[
                        IA1,
                        IA2,
                        IA3,
                        IA4,
                        IA5,
                        IA6,
                        IA7,
                        IA8,
                        IA9,
                        IA10
                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                      TypeContext.MFrom10[
                        IB1,
                        IB2,
                        IB3,
                        IB4,
                        IB5,
                        IB6,
                        IB7,
                        IB8,
                        IB9,
                        IB10
                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                    ](
                      ia9,
                      ib9,
                      new DFuncTypeImpl[
                        TypeContext.MFrom10[
                          IA1,
                          IA2,
                          IA3,
                          IA4,
                          IA5,
                          IA6,
                          IA7,
                          IA8,
                          IA9,
                          IA10
                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                        TypeContext.MFrom10[
                          IB1,
                          IB2,
                          IB3,
                          IB4,
                          IB5,
                          IB6,
                          IB7,
                          IB8,
                          IB9,
                          IB10
                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                      ](ia10, ib10, DFuncTypeZero)
                    )
                  )
                )
              )
            )
          )
        )
      )
    )
  )

  def zero: M1[Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit] = map(
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit
  )(
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance
  )(mImpl[MSelfFrom].zero)

}
trait Monad11TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  type MSelfFrom[TX <: DataHList] = M1[
    TX#DataType,
    TX#DataTail#DataType,
    TX#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType
  ]

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
    IB11
  ](
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
  ] = mImpl[MSelfFrom].zip[TypeContext.MFrom11[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11], TypeContext.MFrom11[
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
    IB11
  ]](m1, m2)

  def map[
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
    IB11
  ](
    ia1: IA1 => IB1,
    ia2: IA2 => IB2,
    ia3: IA3 => IB3,
    ia4: IA4 => IB4,
    ia5: IA5 => IB5,
    ia6: IA6 => IB6,
    ia7: IA7 => IB7,
    ia8: IA8 => IB8,
    ia9: IA9 => IB9,
    ia10: IA10 => IB10,
    ia11: IA11 => IB11
  )(
    ib1: IB1 => IA1,
    ib2: IB2 => IA2,
    ib3: IB3 => IA3,
    ib4: IB4 => IA4,
    ib5: IB5 => IA5,
    ib6: IB6 => IA6,
    ib7: IB7 => IA7,
    ib8: IB8 => IA8,
    ib9: IB9 => IA9,
    ib10: IB10 => IA10,
    ib11: IB11 => IA11
  ): M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11] => M1[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11] =
    mImpl[MSelfFrom].map[
      TypeContext.MFrom11[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11],
      TypeContext.MFrom11[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11]
    ](
      new DFuncTypeImpl[
        TypeContext.MFrom11[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11],
        TypeContext.MFrom11[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11]
      ](
        ia1,
        ib1,
        new DFuncTypeImpl[
          TypeContext.MFrom11[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11]#DataTail,
          TypeContext.MFrom11[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11]#DataTail
        ](
          ia2,
          ib2,
          new DFuncTypeImpl[
            TypeContext.MFrom11[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11]#DataTail#DataTail,
            TypeContext.MFrom11[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11]#DataTail#DataTail
          ](
            ia3,
            ib3,
            new DFuncTypeImpl[
              TypeContext.MFrom11[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11]#DataTail#DataTail#DataTail,
              TypeContext.MFrom11[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11]#DataTail#DataTail#DataTail
            ](
              ia4,
              ib4,
              new DFuncTypeImpl[
                TypeContext.MFrom11[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11]#DataTail#DataTail#DataTail#DataTail,
                TypeContext.MFrom11[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11]#DataTail#DataTail#DataTail#DataTail
              ](
                ia5,
                ib5,
                new DFuncTypeImpl[
                  TypeContext.MFrom11[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11]#DataTail#DataTail#DataTail#DataTail#DataTail,
                  TypeContext.MFrom11[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11]#DataTail#DataTail#DataTail#DataTail#DataTail
                ](
                  ia6,
                  ib6,
                  new DFuncTypeImpl[
                    TypeContext.MFrom11[
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
                      IA11
                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                    TypeContext.MFrom11[
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
                      IB11
                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                  ](
                    ia7,
                    ib7,
                    new DFuncTypeImpl[
                      TypeContext.MFrom11[
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
                        IA11
                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                      TypeContext.MFrom11[
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
                        IB11
                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                    ](
                      ia8,
                      ib8,
                      new DFuncTypeImpl[
                        TypeContext.MFrom11[
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
                          IA11
                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                        TypeContext.MFrom11[
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
                          IB11
                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                      ](
                        ia9,
                        ib9,
                        new DFuncTypeImpl[
                          TypeContext.MFrom11[
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
                            IA11
                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                          TypeContext.MFrom11[
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
                            IB11
                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                        ](
                          ia10,
                          ib10,
                          new DFuncTypeImpl[
                            TypeContext.MFrom11[
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
                              IA11
                            ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                            TypeContext.MFrom11[
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
                              IB11
                            ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                          ](ia11, ib11, DFuncTypeZero)
                        )
                      )
                    )
                  )
                )
              )
            )
          )
        )
      )
    )

  def zero: M1[Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit] = map(
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit
  )(
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance
  )(mImpl[MSelfFrom].zero)

}
trait Monad12TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  type MSelfFrom[TX <: DataHList] = M1[
    TX#DataType,
    TX#DataTail#DataType,
    TX#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType
  ]

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
    IB12
  ](
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
  ] = mImpl[MSelfFrom].zip[TypeContext.MFrom12[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12], TypeContext.MFrom12[
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
    IB12
  ]](m1, m2)

  def map[
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
    IB12
  ](
    ia1: IA1 => IB1,
    ia2: IA2 => IB2,
    ia3: IA3 => IB3,
    ia4: IA4 => IB4,
    ia5: IA5 => IB5,
    ia6: IA6 => IB6,
    ia7: IA7 => IB7,
    ia8: IA8 => IB8,
    ia9: IA9 => IB9,
    ia10: IA10 => IB10,
    ia11: IA11 => IB11,
    ia12: IA12 => IB12
  )(
    ib1: IB1 => IA1,
    ib2: IB2 => IA2,
    ib3: IB3 => IA3,
    ib4: IB4 => IA4,
    ib5: IB5 => IA5,
    ib6: IB6 => IA6,
    ib7: IB7 => IA7,
    ib8: IB8 => IA8,
    ib9: IB9 => IA9,
    ib10: IB10 => IA10,
    ib11: IB11 => IA11,
    ib12: IB12 => IA12
  ): M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12] => M1[
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
    IB12
  ] = mImpl[MSelfFrom].map[
    TypeContext.MFrom12[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12],
    TypeContext.MFrom12[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12]
  ](
    new DFuncTypeImpl[
      TypeContext.MFrom12[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12],
      TypeContext.MFrom12[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12]
    ](
      ia1,
      ib1,
      new DFuncTypeImpl[
        TypeContext.MFrom12[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12]#DataTail,
        TypeContext.MFrom12[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12]#DataTail
      ](
        ia2,
        ib2,
        new DFuncTypeImpl[
          TypeContext.MFrom12[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12]#DataTail#DataTail,
          TypeContext.MFrom12[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12]#DataTail#DataTail
        ](
          ia3,
          ib3,
          new DFuncTypeImpl[
            TypeContext.MFrom12[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12]#DataTail#DataTail#DataTail,
            TypeContext.MFrom12[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12]#DataTail#DataTail#DataTail
          ](
            ia4,
            ib4,
            new DFuncTypeImpl[
              TypeContext.MFrom12[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12]#DataTail#DataTail#DataTail#DataTail,
              TypeContext.MFrom12[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12]#DataTail#DataTail#DataTail#DataTail
            ](
              ia5,
              ib5,
              new DFuncTypeImpl[
                TypeContext.MFrom12[
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
                  IA12
                ]#DataTail#DataTail#DataTail#DataTail#DataTail,
                TypeContext.MFrom12[
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
                  IB12
                ]#DataTail#DataTail#DataTail#DataTail#DataTail
              ](
                ia6,
                ib6,
                new DFuncTypeImpl[
                  TypeContext.MFrom12[
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
                    IA12
                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                  TypeContext.MFrom12[
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
                    IB12
                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                ](
                  ia7,
                  ib7,
                  new DFuncTypeImpl[
                    TypeContext.MFrom12[
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
                      IA12
                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                    TypeContext.MFrom12[
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
                      IB12
                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                  ](
                    ia8,
                    ib8,
                    new DFuncTypeImpl[
                      TypeContext.MFrom12[
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
                        IA12
                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                      TypeContext.MFrom12[
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
                        IB12
                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                    ](
                      ia9,
                      ib9,
                      new DFuncTypeImpl[
                        TypeContext.MFrom12[
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
                          IA12
                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                        TypeContext.MFrom12[
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
                          IB12
                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                      ](
                        ia10,
                        ib10,
                        new DFuncTypeImpl[
                          TypeContext.MFrom12[
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
                            IA12
                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                          TypeContext.MFrom12[
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
                            IB12
                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                        ](
                          ia11,
                          ib11,
                          new DFuncTypeImpl[
                            TypeContext.MFrom12[
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
                              IA12
                            ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                            TypeContext.MFrom12[
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
                              IB12
                            ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                          ](ia12, ib12, DFuncTypeZero)
                        )
                      )
                    )
                  )
                )
              )
            )
          )
        )
      )
    )
  )

  def zero: M1[Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit] = map(
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit
  )(
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance
  )(mImpl[MSelfFrom].zero)

}
trait Monad13TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  type MSelfFrom[TX <: DataHList] = M1[
    TX#DataType,
    TX#DataTail#DataType,
    TX#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType
  ]

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
  ] = mImpl[MSelfFrom].zip[
    TypeContext.MFrom13[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13],
    TypeContext.MFrom13[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13]
  ](m1, m2)

  def map[
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
    ia1: IA1 => IB1,
    ia2: IA2 => IB2,
    ia3: IA3 => IB3,
    ia4: IA4 => IB4,
    ia5: IA5 => IB5,
    ia6: IA6 => IB6,
    ia7: IA7 => IB7,
    ia8: IA8 => IB8,
    ia9: IA9 => IB9,
    ia10: IA10 => IB10,
    ia11: IA11 => IB11,
    ia12: IA12 => IB12,
    ia13: IA13 => IB13
  )(
    ib1: IB1 => IA1,
    ib2: IB2 => IA2,
    ib3: IB3 => IA3,
    ib4: IB4 => IA4,
    ib5: IB5 => IA5,
    ib6: IB6 => IA6,
    ib7: IB7 => IA7,
    ib8: IB8 => IA8,
    ib9: IB9 => IA9,
    ib10: IB10 => IA10,
    ib11: IB11 => IA11,
    ib12: IB12 => IA12,
    ib13: IB13 => IA13
  ): M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13] => M1[
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
  ] = mImpl[MSelfFrom].map[
    TypeContext.MFrom13[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13],
    TypeContext.MFrom13[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13]
  ](
    new DFuncTypeImpl[
      TypeContext.MFrom13[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13],
      TypeContext.MFrom13[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13]
    ](
      ia1,
      ib1,
      new DFuncTypeImpl[
        TypeContext.MFrom13[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13]#DataTail,
        TypeContext.MFrom13[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13]#DataTail
      ](
        ia2,
        ib2,
        new DFuncTypeImpl[
          TypeContext.MFrom13[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13]#DataTail#DataTail,
          TypeContext.MFrom13[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13]#DataTail#DataTail
        ](
          ia3,
          ib3,
          new DFuncTypeImpl[
            TypeContext.MFrom13[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13]#DataTail#DataTail#DataTail,
            TypeContext.MFrom13[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13]#DataTail#DataTail#DataTail
          ](
            ia4,
            ib4,
            new DFuncTypeImpl[
              TypeContext.MFrom13[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13]#DataTail#DataTail#DataTail#DataTail,
              TypeContext.MFrom13[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13]#DataTail#DataTail#DataTail#DataTail
            ](
              ia5,
              ib5,
              new DFuncTypeImpl[
                TypeContext.MFrom13[
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
                  IA13
                ]#DataTail#DataTail#DataTail#DataTail#DataTail,
                TypeContext.MFrom13[
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
                ]#DataTail#DataTail#DataTail#DataTail#DataTail
              ](
                ia6,
                ib6,
                new DFuncTypeImpl[
                  TypeContext.MFrom13[
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
                    IA13
                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                  TypeContext.MFrom13[
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
                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                ](
                  ia7,
                  ib7,
                  new DFuncTypeImpl[
                    TypeContext.MFrom13[
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
                      IA13
                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                    TypeContext.MFrom13[
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
                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                  ](
                    ia8,
                    ib8,
                    new DFuncTypeImpl[
                      TypeContext.MFrom13[
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
                        IA13
                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                      TypeContext.MFrom13[
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
                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                    ](
                      ia9,
                      ib9,
                      new DFuncTypeImpl[
                        TypeContext.MFrom13[
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
                          IA13
                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                        TypeContext.MFrom13[
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
                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                      ](
                        ia10,
                        ib10,
                        new DFuncTypeImpl[
                          TypeContext.MFrom13[
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
                            IA13
                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                          TypeContext.MFrom13[
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
                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                        ](
                          ia11,
                          ib11,
                          new DFuncTypeImpl[
                            TypeContext.MFrom13[
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
                              IA13
                            ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                            TypeContext.MFrom13[
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
                            ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                          ](
                            ia12,
                            ib12,
                            new DFuncTypeImpl[
                              TypeContext.MFrom13[
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
                                IA13
                              ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                              TypeContext.MFrom13[
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
                              ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                            ](ia13, ib13, DFuncTypeZero)
                          )
                        )
                      )
                    )
                  )
                )
              )
            )
          )
        )
      )
    )
  )

  def zero: M1[Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit] = map(
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit
  )(
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance
  )(mImpl[MSelfFrom].zero)

}
trait Monad14TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  type MSelfFrom[TX <: DataHList] = M1[
    TX#DataType,
    TX#DataTail#DataType,
    TX#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType
  ]

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
  ] = mImpl[MSelfFrom].zip[
    TypeContext.MFrom14[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14],
    TypeContext.MFrom14[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14]
  ](m1, m2)

  def map[
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
    ia1: IA1 => IB1,
    ia2: IA2 => IB2,
    ia3: IA3 => IB3,
    ia4: IA4 => IB4,
    ia5: IA5 => IB5,
    ia6: IA6 => IB6,
    ia7: IA7 => IB7,
    ia8: IA8 => IB8,
    ia9: IA9 => IB9,
    ia10: IA10 => IB10,
    ia11: IA11 => IB11,
    ia12: IA12 => IB12,
    ia13: IA13 => IB13,
    ia14: IA14 => IB14
  )(
    ib1: IB1 => IA1,
    ib2: IB2 => IA2,
    ib3: IB3 => IA3,
    ib4: IB4 => IA4,
    ib5: IB5 => IA5,
    ib6: IB6 => IA6,
    ib7: IB7 => IA7,
    ib8: IB8 => IA8,
    ib9: IB9 => IA9,
    ib10: IB10 => IA10,
    ib11: IB11 => IA11,
    ib12: IB12 => IA12,
    ib13: IB13 => IA13,
    ib14: IB14 => IA14
  ): M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14] => M1[
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
  ] = mImpl[MSelfFrom].map[
    TypeContext.MFrom14[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14],
    TypeContext.MFrom14[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14]
  ](
    new DFuncTypeImpl[
      TypeContext.MFrom14[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14],
      TypeContext.MFrom14[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14]
    ](
      ia1,
      ib1,
      new DFuncTypeImpl[
        TypeContext.MFrom14[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14]#DataTail,
        TypeContext.MFrom14[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14]#DataTail
      ](
        ia2,
        ib2,
        new DFuncTypeImpl[
          TypeContext.MFrom14[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14]#DataTail#DataTail,
          TypeContext.MFrom14[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14]#DataTail#DataTail
        ](
          ia3,
          ib3,
          new DFuncTypeImpl[
            TypeContext.MFrom14[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14]#DataTail#DataTail#DataTail,
            TypeContext.MFrom14[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14]#DataTail#DataTail#DataTail
          ](
            ia4,
            ib4,
            new DFuncTypeImpl[
              TypeContext.MFrom14[
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
                IA14
              ]#DataTail#DataTail#DataTail#DataTail,
              TypeContext.MFrom14[
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
              ]#DataTail#DataTail#DataTail#DataTail
            ](
              ia5,
              ib5,
              new DFuncTypeImpl[
                TypeContext.MFrom14[
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
                  IA14
                ]#DataTail#DataTail#DataTail#DataTail#DataTail,
                TypeContext.MFrom14[
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
                ]#DataTail#DataTail#DataTail#DataTail#DataTail
              ](
                ia6,
                ib6,
                new DFuncTypeImpl[
                  TypeContext.MFrom14[
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
                    IA14
                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                  TypeContext.MFrom14[
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
                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                ](
                  ia7,
                  ib7,
                  new DFuncTypeImpl[
                    TypeContext.MFrom14[
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
                      IA14
                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                    TypeContext.MFrom14[
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
                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                  ](
                    ia8,
                    ib8,
                    new DFuncTypeImpl[
                      TypeContext.MFrom14[
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
                        IA14
                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                      TypeContext.MFrom14[
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
                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                    ](
                      ia9,
                      ib9,
                      new DFuncTypeImpl[
                        TypeContext.MFrom14[
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
                          IA14
                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                        TypeContext.MFrom14[
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
                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                      ](
                        ia10,
                        ib10,
                        new DFuncTypeImpl[
                          TypeContext.MFrom14[
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
                            IA14
                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                          TypeContext.MFrom14[
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
                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                        ](
                          ia11,
                          ib11,
                          new DFuncTypeImpl[
                            TypeContext.MFrom14[
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
                              IA14
                            ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                            TypeContext.MFrom14[
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
                            ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                          ](
                            ia12,
                            ib12,
                            new DFuncTypeImpl[
                              TypeContext.MFrom14[
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
                                IA14
                              ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                              TypeContext.MFrom14[
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
                              ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                            ](
                              ia13,
                              ib13,
                              new DFuncTypeImpl[
                                TypeContext.MFrom14[
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
                                  IA14
                                ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                TypeContext.MFrom14[
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
                                ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                              ](ia14, ib14, DFuncTypeZero)
                            )
                          )
                        )
                      )
                    )
                  )
                )
              )
            )
          )
        )
      )
    )
  )

  def zero: M1[Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit] = map(
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit
  )(
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance
  )(mImpl[MSelfFrom].zero)

}
trait Monad15TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  type MSelfFrom[TX <: DataHList] = M1[
    TX#DataType,
    TX#DataTail#DataType,
    TX#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType
  ]

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
  ] = mImpl[MSelfFrom].zip[
    TypeContext.MFrom15[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15],
    TypeContext.MFrom15[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15]
  ](m1, m2)

  def map[
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
    ia1: IA1 => IB1,
    ia2: IA2 => IB2,
    ia3: IA3 => IB3,
    ia4: IA4 => IB4,
    ia5: IA5 => IB5,
    ia6: IA6 => IB6,
    ia7: IA7 => IB7,
    ia8: IA8 => IB8,
    ia9: IA9 => IB9,
    ia10: IA10 => IB10,
    ia11: IA11 => IB11,
    ia12: IA12 => IB12,
    ia13: IA13 => IB13,
    ia14: IA14 => IB14,
    ia15: IA15 => IB15
  )(
    ib1: IB1 => IA1,
    ib2: IB2 => IA2,
    ib3: IB3 => IA3,
    ib4: IB4 => IA4,
    ib5: IB5 => IA5,
    ib6: IB6 => IA6,
    ib7: IB7 => IA7,
    ib8: IB8 => IA8,
    ib9: IB9 => IA9,
    ib10: IB10 => IA10,
    ib11: IB11 => IA11,
    ib12: IB12 => IA12,
    ib13: IB13 => IA13,
    ib14: IB14 => IA14,
    ib15: IB15 => IA15
  ): M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15] => M1[
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
  ] = mImpl[MSelfFrom].map[
    TypeContext.MFrom15[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15],
    TypeContext.MFrom15[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15]
  ](
    new DFuncTypeImpl[
      TypeContext.MFrom15[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15],
      TypeContext.MFrom15[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15]
    ](
      ia1,
      ib1,
      new DFuncTypeImpl[
        TypeContext.MFrom15[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15]#DataTail,
        TypeContext.MFrom15[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15]#DataTail
      ](
        ia2,
        ib2,
        new DFuncTypeImpl[
          TypeContext.MFrom15[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15]#DataTail#DataTail,
          TypeContext.MFrom15[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15]#DataTail#DataTail
        ](
          ia3,
          ib3,
          new DFuncTypeImpl[
            TypeContext.MFrom15[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15]#DataTail#DataTail#DataTail,
            TypeContext.MFrom15[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15]#DataTail#DataTail#DataTail
          ](
            ia4,
            ib4,
            new DFuncTypeImpl[
              TypeContext.MFrom15[
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
                IA15
              ]#DataTail#DataTail#DataTail#DataTail,
              TypeContext.MFrom15[
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
              ]#DataTail#DataTail#DataTail#DataTail
            ](
              ia5,
              ib5,
              new DFuncTypeImpl[
                TypeContext.MFrom15[
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
                  IA15
                ]#DataTail#DataTail#DataTail#DataTail#DataTail,
                TypeContext.MFrom15[
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
                ]#DataTail#DataTail#DataTail#DataTail#DataTail
              ](
                ia6,
                ib6,
                new DFuncTypeImpl[
                  TypeContext.MFrom15[
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
                    IA15
                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                  TypeContext.MFrom15[
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
                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                ](
                  ia7,
                  ib7,
                  new DFuncTypeImpl[
                    TypeContext.MFrom15[
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
                      IA15
                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                    TypeContext.MFrom15[
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
                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                  ](
                    ia8,
                    ib8,
                    new DFuncTypeImpl[
                      TypeContext.MFrom15[
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
                        IA15
                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                      TypeContext.MFrom15[
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
                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                    ](
                      ia9,
                      ib9,
                      new DFuncTypeImpl[
                        TypeContext.MFrom15[
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
                          IA15
                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                        TypeContext.MFrom15[
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
                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                      ](
                        ia10,
                        ib10,
                        new DFuncTypeImpl[
                          TypeContext.MFrom15[
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
                            IA15
                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                          TypeContext.MFrom15[
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
                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                        ](
                          ia11,
                          ib11,
                          new DFuncTypeImpl[
                            TypeContext.MFrom15[
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
                              IA15
                            ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                            TypeContext.MFrom15[
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
                            ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                          ](
                            ia12,
                            ib12,
                            new DFuncTypeImpl[
                              TypeContext.MFrom15[
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
                                IA15
                              ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                              TypeContext.MFrom15[
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
                              ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                            ](
                              ia13,
                              ib13,
                              new DFuncTypeImpl[
                                TypeContext.MFrom15[
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
                                  IA15
                                ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                TypeContext.MFrom15[
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
                                ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                              ](
                                ia14,
                                ib14,
                                new DFuncTypeImpl[
                                  TypeContext.MFrom15[
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
                                    IA15
                                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                  TypeContext.MFrom15[
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
                                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                ](ia15, ib15, DFuncTypeZero)
                              )
                            )
                          )
                        )
                      )
                    )
                  )
                )
              )
            )
          )
        )
      )
    )
  )

  def zero: M1[Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit] = map(
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit
  )(
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance
  )(mImpl[MSelfFrom].zero)

}
trait Monad16TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  type MSelfFrom[TX <: DataHList] = M1[
    TX#DataType,
    TX#DataTail#DataType,
    TX#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType
  ]

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
  ] = mImpl[MSelfFrom].zip[
    TypeContext.MFrom16[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16],
    TypeContext.MFrom16[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15, IB16]
  ](m1, m2)

  def map[
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
    ia1: IA1 => IB1,
    ia2: IA2 => IB2,
    ia3: IA3 => IB3,
    ia4: IA4 => IB4,
    ia5: IA5 => IB5,
    ia6: IA6 => IB6,
    ia7: IA7 => IB7,
    ia8: IA8 => IB8,
    ia9: IA9 => IB9,
    ia10: IA10 => IB10,
    ia11: IA11 => IB11,
    ia12: IA12 => IB12,
    ia13: IA13 => IB13,
    ia14: IA14 => IB14,
    ia15: IA15 => IB15,
    ia16: IA16 => IB16
  )(
    ib1: IB1 => IA1,
    ib2: IB2 => IA2,
    ib3: IB3 => IA3,
    ib4: IB4 => IA4,
    ib5: IB5 => IA5,
    ib6: IB6 => IA6,
    ib7: IB7 => IA7,
    ib8: IB8 => IA8,
    ib9: IB9 => IA9,
    ib10: IB10 => IA10,
    ib11: IB11 => IA11,
    ib12: IB12 => IA12,
    ib13: IB13 => IA13,
    ib14: IB14 => IA14,
    ib15: IB15 => IA15,
    ib16: IB16 => IA16
  ): M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16] => M1[
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
  ] = mImpl[MSelfFrom].map[
    TypeContext.MFrom16[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16],
    TypeContext.MFrom16[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15, IB16]
  ](
    new DFuncTypeImpl[
      TypeContext.MFrom16[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16],
      TypeContext.MFrom16[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15, IB16]
    ](
      ia1,
      ib1,
      new DFuncTypeImpl[
        TypeContext.MFrom16[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16]#DataTail,
        TypeContext.MFrom16[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15, IB16]#DataTail
      ](
        ia2,
        ib2,
        new DFuncTypeImpl[
          TypeContext.MFrom16[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16]#DataTail#DataTail,
          TypeContext.MFrom16[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15, IB16]#DataTail#DataTail
        ](
          ia3,
          ib3,
          new DFuncTypeImpl[
            TypeContext.MFrom16[
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
              IA16
            ]#DataTail#DataTail#DataTail,
            TypeContext.MFrom16[
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
            ]#DataTail#DataTail#DataTail
          ](
            ia4,
            ib4,
            new DFuncTypeImpl[
              TypeContext.MFrom16[
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
                IA16
              ]#DataTail#DataTail#DataTail#DataTail,
              TypeContext.MFrom16[
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
              ]#DataTail#DataTail#DataTail#DataTail
            ](
              ia5,
              ib5,
              new DFuncTypeImpl[
                TypeContext.MFrom16[
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
                  IA16
                ]#DataTail#DataTail#DataTail#DataTail#DataTail,
                TypeContext.MFrom16[
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
                ]#DataTail#DataTail#DataTail#DataTail#DataTail
              ](
                ia6,
                ib6,
                new DFuncTypeImpl[
                  TypeContext.MFrom16[
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
                    IA16
                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                  TypeContext.MFrom16[
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
                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                ](
                  ia7,
                  ib7,
                  new DFuncTypeImpl[
                    TypeContext.MFrom16[
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
                      IA16
                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                    TypeContext.MFrom16[
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
                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                  ](
                    ia8,
                    ib8,
                    new DFuncTypeImpl[
                      TypeContext.MFrom16[
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
                        IA16
                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                      TypeContext.MFrom16[
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
                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                    ](
                      ia9,
                      ib9,
                      new DFuncTypeImpl[
                        TypeContext.MFrom16[
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
                          IA16
                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                        TypeContext.MFrom16[
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
                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                      ](
                        ia10,
                        ib10,
                        new DFuncTypeImpl[
                          TypeContext.MFrom16[
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
                            IA16
                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                          TypeContext.MFrom16[
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
                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                        ](
                          ia11,
                          ib11,
                          new DFuncTypeImpl[
                            TypeContext.MFrom16[
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
                              IA16
                            ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                            TypeContext.MFrom16[
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
                            ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                          ](
                            ia12,
                            ib12,
                            new DFuncTypeImpl[
                              TypeContext.MFrom16[
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
                                IA16
                              ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                              TypeContext.MFrom16[
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
                              ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                            ](
                              ia13,
                              ib13,
                              new DFuncTypeImpl[
                                TypeContext.MFrom16[
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
                                  IA16
                                ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                TypeContext.MFrom16[
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
                                ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                              ](
                                ia14,
                                ib14,
                                new DFuncTypeImpl[
                                  TypeContext.MFrom16[
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
                                    IA16
                                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                  TypeContext.MFrom16[
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
                                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                ](
                                  ia15,
                                  ib15,
                                  new DFuncTypeImpl[
                                    TypeContext.MFrom16[
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
                                      IA16
                                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                    TypeContext.MFrom16[
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
                                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                  ](ia16, ib16, DFuncTypeZero)
                                )
                              )
                            )
                          )
                        )
                      )
                    )
                  )
                )
              )
            )
          )
        )
      )
    )
  )

  def zero: M1[Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit] = map(
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit
  )(
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance
  )(mImpl[MSelfFrom].zero)

}
trait Monad17TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  type MSelfFrom[TX <: DataHList] = M1[
    TX#DataType,
    TX#DataTail#DataType,
    TX#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType
  ]

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
  ] = mImpl[MSelfFrom].zip[
    TypeContext.MFrom17[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16, IA17],
    TypeContext.MFrom17[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15, IB16, IB17]
  ](m1, m2)

  def map[
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
    ia1: IA1 => IB1,
    ia2: IA2 => IB2,
    ia3: IA3 => IB3,
    ia4: IA4 => IB4,
    ia5: IA5 => IB5,
    ia6: IA6 => IB6,
    ia7: IA7 => IB7,
    ia8: IA8 => IB8,
    ia9: IA9 => IB9,
    ia10: IA10 => IB10,
    ia11: IA11 => IB11,
    ia12: IA12 => IB12,
    ia13: IA13 => IB13,
    ia14: IA14 => IB14,
    ia15: IA15 => IB15,
    ia16: IA16 => IB16,
    ia17: IA17 => IB17
  )(
    ib1: IB1 => IA1,
    ib2: IB2 => IA2,
    ib3: IB3 => IA3,
    ib4: IB4 => IA4,
    ib5: IB5 => IA5,
    ib6: IB6 => IA6,
    ib7: IB7 => IA7,
    ib8: IB8 => IA8,
    ib9: IB9 => IA9,
    ib10: IB10 => IA10,
    ib11: IB11 => IA11,
    ib12: IB12 => IA12,
    ib13: IB13 => IA13,
    ib14: IB14 => IA14,
    ib15: IB15 => IA15,
    ib16: IB16 => IA16,
    ib17: IB17 => IA17
  ): M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16, IA17] => M1[
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
  ] = mImpl[MSelfFrom].map[
    TypeContext.MFrom17[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16, IA17],
    TypeContext.MFrom17[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15, IB16, IB17]
  ](
    new DFuncTypeImpl[
      TypeContext.MFrom17[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16, IA17],
      TypeContext.MFrom17[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15, IB16, IB17]
    ](
      ia1,
      ib1,
      new DFuncTypeImpl[
        TypeContext.MFrom17[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16, IA17]#DataTail,
        TypeContext.MFrom17[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15, IB16, IB17]#DataTail
      ](
        ia2,
        ib2,
        new DFuncTypeImpl[
          TypeContext.MFrom17[
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
            IA17
          ]#DataTail#DataTail,
          TypeContext.MFrom17[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15, IB16, IB17]#DataTail#DataTail
        ](
          ia3,
          ib3,
          new DFuncTypeImpl[
            TypeContext.MFrom17[
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
              IA17
            ]#DataTail#DataTail#DataTail,
            TypeContext.MFrom17[
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
            ]#DataTail#DataTail#DataTail
          ](
            ia4,
            ib4,
            new DFuncTypeImpl[
              TypeContext.MFrom17[
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
                IA17
              ]#DataTail#DataTail#DataTail#DataTail,
              TypeContext.MFrom17[
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
              ]#DataTail#DataTail#DataTail#DataTail
            ](
              ia5,
              ib5,
              new DFuncTypeImpl[
                TypeContext.MFrom17[
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
                  IA17
                ]#DataTail#DataTail#DataTail#DataTail#DataTail,
                TypeContext.MFrom17[
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
                ]#DataTail#DataTail#DataTail#DataTail#DataTail
              ](
                ia6,
                ib6,
                new DFuncTypeImpl[
                  TypeContext.MFrom17[
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
                    IA17
                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                  TypeContext.MFrom17[
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
                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                ](
                  ia7,
                  ib7,
                  new DFuncTypeImpl[
                    TypeContext.MFrom17[
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
                      IA17
                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                    TypeContext.MFrom17[
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
                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                  ](
                    ia8,
                    ib8,
                    new DFuncTypeImpl[
                      TypeContext.MFrom17[
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
                        IA17
                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                      TypeContext.MFrom17[
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
                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                    ](
                      ia9,
                      ib9,
                      new DFuncTypeImpl[
                        TypeContext.MFrom17[
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
                          IA17
                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                        TypeContext.MFrom17[
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
                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                      ](
                        ia10,
                        ib10,
                        new DFuncTypeImpl[
                          TypeContext.MFrom17[
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
                            IA17
                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                          TypeContext.MFrom17[
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
                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                        ](
                          ia11,
                          ib11,
                          new DFuncTypeImpl[
                            TypeContext.MFrom17[
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
                              IA17
                            ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                            TypeContext.MFrom17[
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
                            ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                          ](
                            ia12,
                            ib12,
                            new DFuncTypeImpl[
                              TypeContext.MFrom17[
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
                                IA17
                              ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                              TypeContext.MFrom17[
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
                              ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                            ](
                              ia13,
                              ib13,
                              new DFuncTypeImpl[
                                TypeContext.MFrom17[
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
                                  IA17
                                ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                TypeContext.MFrom17[
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
                                ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                              ](
                                ia14,
                                ib14,
                                new DFuncTypeImpl[
                                  TypeContext.MFrom17[
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
                                    IA17
                                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                  TypeContext.MFrom17[
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
                                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                ](
                                  ia15,
                                  ib15,
                                  new DFuncTypeImpl[
                                    TypeContext.MFrom17[
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
                                      IA17
                                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                    TypeContext.MFrom17[
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
                                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                  ](
                                    ia16,
                                    ib16,
                                    new DFuncTypeImpl[
                                      TypeContext.MFrom17[
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
                                        IA17
                                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                      TypeContext.MFrom17[
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
                                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                    ](ia17, ib17, DFuncTypeZero)
                                  )
                                )
                              )
                            )
                          )
                        )
                      )
                    )
                  )
                )
              )
            )
          )
        )
      )
    )
  )

  def zero: M1[Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit] = map(
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit
  )(
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance
  )(mImpl[MSelfFrom].zero)

}
trait Monad18TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  type MSelfFrom[TX <: DataHList] = M1[
    TX#DataType,
    TX#DataTail#DataType,
    TX#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType
  ]

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
  ] = mImpl[MSelfFrom].zip[
    TypeContext.MFrom18[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16, IA17, IA18],
    TypeContext.MFrom18[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15, IB16, IB17, IB18]
  ](m1, m2)

  def map[
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
    ia1: IA1 => IB1,
    ia2: IA2 => IB2,
    ia3: IA3 => IB3,
    ia4: IA4 => IB4,
    ia5: IA5 => IB5,
    ia6: IA6 => IB6,
    ia7: IA7 => IB7,
    ia8: IA8 => IB8,
    ia9: IA9 => IB9,
    ia10: IA10 => IB10,
    ia11: IA11 => IB11,
    ia12: IA12 => IB12,
    ia13: IA13 => IB13,
    ia14: IA14 => IB14,
    ia15: IA15 => IB15,
    ia16: IA16 => IB16,
    ia17: IA17 => IB17,
    ia18: IA18 => IB18
  )(
    ib1: IB1 => IA1,
    ib2: IB2 => IA2,
    ib3: IB3 => IA3,
    ib4: IB4 => IA4,
    ib5: IB5 => IA5,
    ib6: IB6 => IA6,
    ib7: IB7 => IA7,
    ib8: IB8 => IA8,
    ib9: IB9 => IA9,
    ib10: IB10 => IA10,
    ib11: IB11 => IA11,
    ib12: IB12 => IA12,
    ib13: IB13 => IA13,
    ib14: IB14 => IA14,
    ib15: IB15 => IA15,
    ib16: IB16 => IA16,
    ib17: IB17 => IA17,
    ib18: IB18 => IA18
  ): M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16, IA17, IA18] => M1[
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
  ] = mImpl[MSelfFrom].map[
    TypeContext.MFrom18[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16, IA17, IA18],
    TypeContext.MFrom18[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15, IB16, IB17, IB18]
  ](
    new DFuncTypeImpl[
      TypeContext.MFrom18[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16, IA17, IA18],
      TypeContext.MFrom18[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15, IB16, IB17, IB18]
    ](
      ia1,
      ib1,
      new DFuncTypeImpl[
        TypeContext.MFrom18[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16, IA17, IA18]#DataTail,
        TypeContext.MFrom18[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15, IB16, IB17, IB18]#DataTail
      ](
        ia2,
        ib2,
        new DFuncTypeImpl[
          TypeContext.MFrom18[
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
            IA18
          ]#DataTail#DataTail,
          TypeContext.MFrom18[
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
          ]#DataTail#DataTail
        ](
          ia3,
          ib3,
          new DFuncTypeImpl[
            TypeContext.MFrom18[
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
              IA18
            ]#DataTail#DataTail#DataTail,
            TypeContext.MFrom18[
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
            ]#DataTail#DataTail#DataTail
          ](
            ia4,
            ib4,
            new DFuncTypeImpl[
              TypeContext.MFrom18[
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
                IA18
              ]#DataTail#DataTail#DataTail#DataTail,
              TypeContext.MFrom18[
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
              ]#DataTail#DataTail#DataTail#DataTail
            ](
              ia5,
              ib5,
              new DFuncTypeImpl[
                TypeContext.MFrom18[
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
                  IA18
                ]#DataTail#DataTail#DataTail#DataTail#DataTail,
                TypeContext.MFrom18[
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
                ]#DataTail#DataTail#DataTail#DataTail#DataTail
              ](
                ia6,
                ib6,
                new DFuncTypeImpl[
                  TypeContext.MFrom18[
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
                    IA18
                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                  TypeContext.MFrom18[
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
                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                ](
                  ia7,
                  ib7,
                  new DFuncTypeImpl[
                    TypeContext.MFrom18[
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
                      IA18
                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                    TypeContext.MFrom18[
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
                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                  ](
                    ia8,
                    ib8,
                    new DFuncTypeImpl[
                      TypeContext.MFrom18[
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
                        IA18
                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                      TypeContext.MFrom18[
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
                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                    ](
                      ia9,
                      ib9,
                      new DFuncTypeImpl[
                        TypeContext.MFrom18[
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
                          IA18
                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                        TypeContext.MFrom18[
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
                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                      ](
                        ia10,
                        ib10,
                        new DFuncTypeImpl[
                          TypeContext.MFrom18[
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
                            IA18
                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                          TypeContext.MFrom18[
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
                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                        ](
                          ia11,
                          ib11,
                          new DFuncTypeImpl[
                            TypeContext.MFrom18[
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
                              IA18
                            ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                            TypeContext.MFrom18[
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
                            ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                          ](
                            ia12,
                            ib12,
                            new DFuncTypeImpl[
                              TypeContext.MFrom18[
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
                                IA18
                              ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                              TypeContext.MFrom18[
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
                              ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                            ](
                              ia13,
                              ib13,
                              new DFuncTypeImpl[
                                TypeContext.MFrom18[
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
                                  IA18
                                ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                TypeContext.MFrom18[
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
                                ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                              ](
                                ia14,
                                ib14,
                                new DFuncTypeImpl[
                                  TypeContext.MFrom18[
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
                                    IA18
                                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                  TypeContext.MFrom18[
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
                                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                ](
                                  ia15,
                                  ib15,
                                  new DFuncTypeImpl[
                                    TypeContext.MFrom18[
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
                                      IA18
                                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                    TypeContext.MFrom18[
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
                                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                  ](
                                    ia16,
                                    ib16,
                                    new DFuncTypeImpl[
                                      TypeContext.MFrom18[
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
                                        IA18
                                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                      TypeContext.MFrom18[
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
                                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                    ](
                                      ia17,
                                      ib17,
                                      new DFuncTypeImpl[
                                        TypeContext.MFrom18[
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
                                          IA18
                                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                        TypeContext.MFrom18[
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
                                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                      ](ia18, ib18, DFuncTypeZero)
                                    )
                                  )
                                )
                              )
                            )
                          )
                        )
                      )
                    )
                  )
                )
              )
            )
          )
        )
      )
    )
  )

  def zero: M1[Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit] = map(
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit
  )(
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance
  )(mImpl[MSelfFrom].zero)

}
trait Monad19TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  type MSelfFrom[TX <: DataHList] = M1[
    TX#DataType,
    TX#DataTail#DataType,
    TX#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType
  ]

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
  ] = mImpl[MSelfFrom].zip[
    TypeContext.MFrom19[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16, IA17, IA18, IA19],
    TypeContext.MFrom19[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15, IB16, IB17, IB18, IB19]
  ](m1, m2)

  def map[
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
    ia1: IA1 => IB1,
    ia2: IA2 => IB2,
    ia3: IA3 => IB3,
    ia4: IA4 => IB4,
    ia5: IA5 => IB5,
    ia6: IA6 => IB6,
    ia7: IA7 => IB7,
    ia8: IA8 => IB8,
    ia9: IA9 => IB9,
    ia10: IA10 => IB10,
    ia11: IA11 => IB11,
    ia12: IA12 => IB12,
    ia13: IA13 => IB13,
    ia14: IA14 => IB14,
    ia15: IA15 => IB15,
    ia16: IA16 => IB16,
    ia17: IA17 => IB17,
    ia18: IA18 => IB18,
    ia19: IA19 => IB19
  )(
    ib1: IB1 => IA1,
    ib2: IB2 => IA2,
    ib3: IB3 => IA3,
    ib4: IB4 => IA4,
    ib5: IB5 => IA5,
    ib6: IB6 => IA6,
    ib7: IB7 => IA7,
    ib8: IB8 => IA8,
    ib9: IB9 => IA9,
    ib10: IB10 => IA10,
    ib11: IB11 => IA11,
    ib12: IB12 => IA12,
    ib13: IB13 => IA13,
    ib14: IB14 => IA14,
    ib15: IB15 => IA15,
    ib16: IB16 => IA16,
    ib17: IB17 => IA17,
    ib18: IB18 => IA18,
    ib19: IB19 => IA19
  ): M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16, IA17, IA18, IA19] => M1[
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
  ] = mImpl[MSelfFrom].map[
    TypeContext.MFrom19[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16, IA17, IA18, IA19],
    TypeContext.MFrom19[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15, IB16, IB17, IB18, IB19]
  ](
    new DFuncTypeImpl[
      TypeContext.MFrom19[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16, IA17, IA18, IA19],
      TypeContext.MFrom19[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15, IB16, IB17, IB18, IB19]
    ](
      ia1,
      ib1,
      new DFuncTypeImpl[
        TypeContext.MFrom19[
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
          IA19
        ]#DataTail,
        TypeContext.MFrom19[
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
        ]#DataTail
      ](
        ia2,
        ib2,
        new DFuncTypeImpl[
          TypeContext.MFrom19[
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
            IA19
          ]#DataTail#DataTail,
          TypeContext.MFrom19[
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
          ]#DataTail#DataTail
        ](
          ia3,
          ib3,
          new DFuncTypeImpl[
            TypeContext.MFrom19[
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
              IA19
            ]#DataTail#DataTail#DataTail,
            TypeContext.MFrom19[
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
            ]#DataTail#DataTail#DataTail
          ](
            ia4,
            ib4,
            new DFuncTypeImpl[
              TypeContext.MFrom19[
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
                IA19
              ]#DataTail#DataTail#DataTail#DataTail,
              TypeContext.MFrom19[
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
              ]#DataTail#DataTail#DataTail#DataTail
            ](
              ia5,
              ib5,
              new DFuncTypeImpl[
                TypeContext.MFrom19[
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
                  IA19
                ]#DataTail#DataTail#DataTail#DataTail#DataTail,
                TypeContext.MFrom19[
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
                ]#DataTail#DataTail#DataTail#DataTail#DataTail
              ](
                ia6,
                ib6,
                new DFuncTypeImpl[
                  TypeContext.MFrom19[
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
                    IA19
                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                  TypeContext.MFrom19[
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
                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                ](
                  ia7,
                  ib7,
                  new DFuncTypeImpl[
                    TypeContext.MFrom19[
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
                      IA19
                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                    TypeContext.MFrom19[
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
                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                  ](
                    ia8,
                    ib8,
                    new DFuncTypeImpl[
                      TypeContext.MFrom19[
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
                        IA19
                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                      TypeContext.MFrom19[
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
                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                    ](
                      ia9,
                      ib9,
                      new DFuncTypeImpl[
                        TypeContext.MFrom19[
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
                          IA19
                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                        TypeContext.MFrom19[
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
                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                      ](
                        ia10,
                        ib10,
                        new DFuncTypeImpl[
                          TypeContext.MFrom19[
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
                            IA19
                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                          TypeContext.MFrom19[
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
                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                        ](
                          ia11,
                          ib11,
                          new DFuncTypeImpl[
                            TypeContext.MFrom19[
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
                              IA19
                            ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                            TypeContext.MFrom19[
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
                            ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                          ](
                            ia12,
                            ib12,
                            new DFuncTypeImpl[
                              TypeContext.MFrom19[
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
                                IA19
                              ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                              TypeContext.MFrom19[
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
                              ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                            ](
                              ia13,
                              ib13,
                              new DFuncTypeImpl[
                                TypeContext.MFrom19[
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
                                  IA19
                                ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                TypeContext.MFrom19[
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
                                ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                              ](
                                ia14,
                                ib14,
                                new DFuncTypeImpl[
                                  TypeContext.MFrom19[
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
                                    IA19
                                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                  TypeContext.MFrom19[
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
                                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                ](
                                  ia15,
                                  ib15,
                                  new DFuncTypeImpl[
                                    TypeContext.MFrom19[
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
                                      IA19
                                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                    TypeContext.MFrom19[
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
                                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                  ](
                                    ia16,
                                    ib16,
                                    new DFuncTypeImpl[
                                      TypeContext.MFrom19[
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
                                        IA19
                                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                      TypeContext.MFrom19[
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
                                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                    ](
                                      ia17,
                                      ib17,
                                      new DFuncTypeImpl[
                                        TypeContext.MFrom19[
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
                                          IA19
                                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                        TypeContext.MFrom19[
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
                                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                      ](
                                        ia18,
                                        ib18,
                                        new DFuncTypeImpl[
                                          TypeContext.MFrom19[
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
                                            IA19
                                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                          TypeContext.MFrom19[
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
                                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                        ](ia19, ib19, DFuncTypeZero)
                                      )
                                    )
                                  )
                                )
                              )
                            )
                          )
                        )
                      )
                    )
                  )
                )
              )
            )
          )
        )
      )
    )
  )

  def zero: M1[Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit] = map(
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit
  )(
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance
  )(mImpl[MSelfFrom].zero)

}
trait Monad20TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  type MSelfFrom[TX <: DataHList] = M1[
    TX#DataType,
    TX#DataTail#DataType,
    TX#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType
  ]

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
  ] = mImpl[MSelfFrom].zip[
    TypeContext.MFrom20[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16, IA17, IA18, IA19, IA20],
    TypeContext.MFrom20[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15, IB16, IB17, IB18, IB19, IB20]
  ](m1, m2)

  def map[
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
    ia1: IA1 => IB1,
    ia2: IA2 => IB2,
    ia3: IA3 => IB3,
    ia4: IA4 => IB4,
    ia5: IA5 => IB5,
    ia6: IA6 => IB6,
    ia7: IA7 => IB7,
    ia8: IA8 => IB8,
    ia9: IA9 => IB9,
    ia10: IA10 => IB10,
    ia11: IA11 => IB11,
    ia12: IA12 => IB12,
    ia13: IA13 => IB13,
    ia14: IA14 => IB14,
    ia15: IA15 => IB15,
    ia16: IA16 => IB16,
    ia17: IA17 => IB17,
    ia18: IA18 => IB18,
    ia19: IA19 => IB19,
    ia20: IA20 => IB20
  )(
    ib1: IB1 => IA1,
    ib2: IB2 => IA2,
    ib3: IB3 => IA3,
    ib4: IB4 => IA4,
    ib5: IB5 => IA5,
    ib6: IB6 => IA6,
    ib7: IB7 => IA7,
    ib8: IB8 => IA8,
    ib9: IB9 => IA9,
    ib10: IB10 => IA10,
    ib11: IB11 => IA11,
    ib12: IB12 => IA12,
    ib13: IB13 => IA13,
    ib14: IB14 => IA14,
    ib15: IB15 => IA15,
    ib16: IB16 => IA16,
    ib17: IB17 => IA17,
    ib18: IB18 => IA18,
    ib19: IB19 => IA19,
    ib20: IB20 => IA20
  ): M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16, IA17, IA18, IA19, IA20] => M1[
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
  ] = mImpl[MSelfFrom].map[
    TypeContext.MFrom20[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16, IA17, IA18, IA19, IA20],
    TypeContext.MFrom20[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15, IB16, IB17, IB18, IB19, IB20]
  ](
    new DFuncTypeImpl[
      TypeContext.MFrom20[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16, IA17, IA18, IA19, IA20],
      TypeContext.MFrom20[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15, IB16, IB17, IB18, IB19, IB20]
    ](
      ia1,
      ib1,
      new DFuncTypeImpl[
        TypeContext.MFrom20[
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
          IA20
        ]#DataTail,
        TypeContext.MFrom20[
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
        ]#DataTail
      ](
        ia2,
        ib2,
        new DFuncTypeImpl[
          TypeContext.MFrom20[
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
            IA20
          ]#DataTail#DataTail,
          TypeContext.MFrom20[
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
          ]#DataTail#DataTail
        ](
          ia3,
          ib3,
          new DFuncTypeImpl[
            TypeContext.MFrom20[
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
              IA20
            ]#DataTail#DataTail#DataTail,
            TypeContext.MFrom20[
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
            ]#DataTail#DataTail#DataTail
          ](
            ia4,
            ib4,
            new DFuncTypeImpl[
              TypeContext.MFrom20[
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
                IA20
              ]#DataTail#DataTail#DataTail#DataTail,
              TypeContext.MFrom20[
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
              ]#DataTail#DataTail#DataTail#DataTail
            ](
              ia5,
              ib5,
              new DFuncTypeImpl[
                TypeContext.MFrom20[
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
                  IA20
                ]#DataTail#DataTail#DataTail#DataTail#DataTail,
                TypeContext.MFrom20[
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
                ]#DataTail#DataTail#DataTail#DataTail#DataTail
              ](
                ia6,
                ib6,
                new DFuncTypeImpl[
                  TypeContext.MFrom20[
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
                    IA20
                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                  TypeContext.MFrom20[
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
                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                ](
                  ia7,
                  ib7,
                  new DFuncTypeImpl[
                    TypeContext.MFrom20[
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
                      IA20
                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                    TypeContext.MFrom20[
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
                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                  ](
                    ia8,
                    ib8,
                    new DFuncTypeImpl[
                      TypeContext.MFrom20[
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
                        IA20
                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                      TypeContext.MFrom20[
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
                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                    ](
                      ia9,
                      ib9,
                      new DFuncTypeImpl[
                        TypeContext.MFrom20[
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
                          IA20
                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                        TypeContext.MFrom20[
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
                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                      ](
                        ia10,
                        ib10,
                        new DFuncTypeImpl[
                          TypeContext.MFrom20[
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
                            IA20
                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                          TypeContext.MFrom20[
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
                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                        ](
                          ia11,
                          ib11,
                          new DFuncTypeImpl[
                            TypeContext.MFrom20[
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
                              IA20
                            ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                            TypeContext.MFrom20[
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
                            ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                          ](
                            ia12,
                            ib12,
                            new DFuncTypeImpl[
                              TypeContext.MFrom20[
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
                                IA20
                              ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                              TypeContext.MFrom20[
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
                              ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                            ](
                              ia13,
                              ib13,
                              new DFuncTypeImpl[
                                TypeContext.MFrom20[
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
                                  IA20
                                ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                TypeContext.MFrom20[
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
                                ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                              ](
                                ia14,
                                ib14,
                                new DFuncTypeImpl[
                                  TypeContext.MFrom20[
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
                                    IA20
                                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                  TypeContext.MFrom20[
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
                                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                ](
                                  ia15,
                                  ib15,
                                  new DFuncTypeImpl[
                                    TypeContext.MFrom20[
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
                                      IA20
                                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                    TypeContext.MFrom20[
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
                                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                  ](
                                    ia16,
                                    ib16,
                                    new DFuncTypeImpl[
                                      TypeContext.MFrom20[
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
                                        IA20
                                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                      TypeContext.MFrom20[
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
                                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                    ](
                                      ia17,
                                      ib17,
                                      new DFuncTypeImpl[
                                        TypeContext.MFrom20[
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
                                          IA20
                                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                        TypeContext.MFrom20[
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
                                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                      ](
                                        ia18,
                                        ib18,
                                        new DFuncTypeImpl[
                                          TypeContext.MFrom20[
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
                                            IA20
                                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                          TypeContext.MFrom20[
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
                                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                        ](
                                          ia19,
                                          ib19,
                                          new DFuncTypeImpl[
                                            TypeContext.MFrom20[
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
                                              IA20
                                            ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                            TypeContext.MFrom20[
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
                                            ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                          ](ia20, ib20, DFuncTypeZero)
                                        )
                                      )
                                    )
                                  )
                                )
                              )
                            )
                          )
                        )
                      )
                    )
                  )
                )
              )
            )
          )
        )
      )
    )
  )

  def zero: M1[Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit] =
    map(
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit
    )(
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance
    )(mImpl[MSelfFrom].zero)

}
trait Monad21TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  type MSelfFrom[TX <: DataHList] = M1[
    TX#DataType,
    TX#DataTail#DataType,
    TX#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType
  ]

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
  ] = mImpl[MSelfFrom].zip[
    TypeContext.MFrom21[
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
      IA21
    ],
    TypeContext.MFrom21[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15, IB16, IB17, IB18, IB19, IB20, IB21]
  ](m1, m2)

  def map[
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
    ia1: IA1 => IB1,
    ia2: IA2 => IB2,
    ia3: IA3 => IB3,
    ia4: IA4 => IB4,
    ia5: IA5 => IB5,
    ia6: IA6 => IB6,
    ia7: IA7 => IB7,
    ia8: IA8 => IB8,
    ia9: IA9 => IB9,
    ia10: IA10 => IB10,
    ia11: IA11 => IB11,
    ia12: IA12 => IB12,
    ia13: IA13 => IB13,
    ia14: IA14 => IB14,
    ia15: IA15 => IB15,
    ia16: IA16 => IB16,
    ia17: IA17 => IB17,
    ia18: IA18 => IB18,
    ia19: IA19 => IB19,
    ia20: IA20 => IB20,
    ia21: IA21 => IB21
  )(
    ib1: IB1 => IA1,
    ib2: IB2 => IA2,
    ib3: IB3 => IA3,
    ib4: IB4 => IA4,
    ib5: IB5 => IA5,
    ib6: IB6 => IA6,
    ib7: IB7 => IA7,
    ib8: IB8 => IA8,
    ib9: IB9 => IA9,
    ib10: IB10 => IA10,
    ib11: IB11 => IA11,
    ib12: IB12 => IA12,
    ib13: IB13 => IA13,
    ib14: IB14 => IA14,
    ib15: IB15 => IA15,
    ib16: IB16 => IA16,
    ib17: IB17 => IA17,
    ib18: IB18 => IA18,
    ib19: IB19 => IA19,
    ib20: IB20 => IA20,
    ib21: IB21 => IA21
  ): M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16, IA17, IA18, IA19, IA20, IA21] => M1[
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
  ] = mImpl[MSelfFrom].map[
    TypeContext.MFrom21[
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
      IA21
    ],
    TypeContext.MFrom21[IB1, IB2, IB3, IB4, IB5, IB6, IB7, IB8, IB9, IB10, IB11, IB12, IB13, IB14, IB15, IB16, IB17, IB18, IB19, IB20, IB21]
  ](
    new DFuncTypeImpl[
      TypeContext.MFrom21[
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
        IA21
      ],
      TypeContext.MFrom21[
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
      ]
    ](
      ia1,
      ib1,
      new DFuncTypeImpl[
        TypeContext.MFrom21[
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
          IA21
        ]#DataTail,
        TypeContext.MFrom21[
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
        ]#DataTail
      ](
        ia2,
        ib2,
        new DFuncTypeImpl[
          TypeContext.MFrom21[
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
            IA21
          ]#DataTail#DataTail,
          TypeContext.MFrom21[
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
          ]#DataTail#DataTail
        ](
          ia3,
          ib3,
          new DFuncTypeImpl[
            TypeContext.MFrom21[
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
              IA21
            ]#DataTail#DataTail#DataTail,
            TypeContext.MFrom21[
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
            ]#DataTail#DataTail#DataTail
          ](
            ia4,
            ib4,
            new DFuncTypeImpl[
              TypeContext.MFrom21[
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
                IA21
              ]#DataTail#DataTail#DataTail#DataTail,
              TypeContext.MFrom21[
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
              ]#DataTail#DataTail#DataTail#DataTail
            ](
              ia5,
              ib5,
              new DFuncTypeImpl[
                TypeContext.MFrom21[
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
                  IA21
                ]#DataTail#DataTail#DataTail#DataTail#DataTail,
                TypeContext.MFrom21[
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
                ]#DataTail#DataTail#DataTail#DataTail#DataTail
              ](
                ia6,
                ib6,
                new DFuncTypeImpl[
                  TypeContext.MFrom21[
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
                    IA21
                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                  TypeContext.MFrom21[
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
                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                ](
                  ia7,
                  ib7,
                  new DFuncTypeImpl[
                    TypeContext.MFrom21[
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
                      IA21
                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                    TypeContext.MFrom21[
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
                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                  ](
                    ia8,
                    ib8,
                    new DFuncTypeImpl[
                      TypeContext.MFrom21[
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
                        IA21
                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                      TypeContext.MFrom21[
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
                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                    ](
                      ia9,
                      ib9,
                      new DFuncTypeImpl[
                        TypeContext.MFrom21[
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
                          IA21
                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                        TypeContext.MFrom21[
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
                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                      ](
                        ia10,
                        ib10,
                        new DFuncTypeImpl[
                          TypeContext.MFrom21[
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
                            IA21
                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                          TypeContext.MFrom21[
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
                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                        ](
                          ia11,
                          ib11,
                          new DFuncTypeImpl[
                            TypeContext.MFrom21[
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
                              IA21
                            ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                            TypeContext.MFrom21[
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
                            ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                          ](
                            ia12,
                            ib12,
                            new DFuncTypeImpl[
                              TypeContext.MFrom21[
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
                                IA21
                              ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                              TypeContext.MFrom21[
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
                              ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                            ](
                              ia13,
                              ib13,
                              new DFuncTypeImpl[
                                TypeContext.MFrom21[
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
                                  IA21
                                ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                TypeContext.MFrom21[
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
                                ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                              ](
                                ia14,
                                ib14,
                                new DFuncTypeImpl[
                                  TypeContext.MFrom21[
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
                                    IA21
                                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                  TypeContext.MFrom21[
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
                                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                ](
                                  ia15,
                                  ib15,
                                  new DFuncTypeImpl[
                                    TypeContext.MFrom21[
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
                                      IA21
                                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                    TypeContext.MFrom21[
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
                                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                  ](
                                    ia16,
                                    ib16,
                                    new DFuncTypeImpl[
                                      TypeContext.MFrom21[
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
                                        IA21
                                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                      TypeContext.MFrom21[
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
                                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                    ](
                                      ia17,
                                      ib17,
                                      new DFuncTypeImpl[
                                        TypeContext.MFrom21[
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
                                          IA21
                                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                        TypeContext.MFrom21[
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
                                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                      ](
                                        ia18,
                                        ib18,
                                        new DFuncTypeImpl[
                                          TypeContext.MFrom21[
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
                                            IA21
                                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                          TypeContext.MFrom21[
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
                                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                        ](
                                          ia19,
                                          ib19,
                                          new DFuncTypeImpl[
                                            TypeContext.MFrom21[
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
                                              IA21
                                            ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                            TypeContext.MFrom21[
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
                                            ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                          ](
                                            ia20,
                                            ib20,
                                            new DFuncTypeImpl[
                                              TypeContext.MFrom21[
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
                                                IA21
                                              ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                              TypeContext.MFrom21[
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
                                              ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                            ](ia21, ib21, DFuncTypeZero)
                                          )
                                        )
                                      )
                                    )
                                  )
                                )
                              )
                            )
                          )
                        )
                      )
                    )
                  )
                )
              )
            )
          )
        )
      )
    )
  )

  def zero
    : M1[Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit, Unit] =
    map(
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit,
      (_: ZeroInstance) => (): Unit
    )(
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance,
      (_: Unit) => ZeroInstance.instance
    )(mImpl[MSelfFrom].zero)

}
trait Monad22TypeLevel[M1[_, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _, _]] {

  def mImpl[M2[_ <: DataHList]]: FunctionMTypeHList[M2]

  type MSelfFrom[TX <: DataHList] = M1[
    TX#DataType,
    TX#DataTail#DataType,
    TX#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType,
    TX#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataType
  ]

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
  ] = mImpl[MSelfFrom].zip[
    TypeContext.MFrom22[
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
      IA22
    ],
    TypeContext.MFrom22[
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
    ]
  ](m1, m2)

  def map[
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
    ia1: IA1 => IB1,
    ia2: IA2 => IB2,
    ia3: IA3 => IB3,
    ia4: IA4 => IB4,
    ia5: IA5 => IB5,
    ia6: IA6 => IB6,
    ia7: IA7 => IB7,
    ia8: IA8 => IB8,
    ia9: IA9 => IB9,
    ia10: IA10 => IB10,
    ia11: IA11 => IB11,
    ia12: IA12 => IB12,
    ia13: IA13 => IB13,
    ia14: IA14 => IB14,
    ia15: IA15 => IB15,
    ia16: IA16 => IB16,
    ia17: IA17 => IB17,
    ia18: IA18 => IB18,
    ia19: IA19 => IB19,
    ia20: IA20 => IB20,
    ia21: IA21 => IB21,
    ia22: IA22 => IB22
  )(
    ib1: IB1 => IA1,
    ib2: IB2 => IA2,
    ib3: IB3 => IA3,
    ib4: IB4 => IA4,
    ib5: IB5 => IA5,
    ib6: IB6 => IA6,
    ib7: IB7 => IA7,
    ib8: IB8 => IA8,
    ib9: IB9 => IA9,
    ib10: IB10 => IA10,
    ib11: IB11 => IA11,
    ib12: IB12 => IA12,
    ib13: IB13 => IA13,
    ib14: IB14 => IA14,
    ib15: IB15 => IA15,
    ib16: IB16 => IA16,
    ib17: IB17 => IA17,
    ib18: IB18 => IA18,
    ib19: IB19 => IA19,
    ib20: IB20 => IA20,
    ib21: IB21 => IA21,
    ib22: IB22 => IA22
  ): M1[IA1, IA2, IA3, IA4, IA5, IA6, IA7, IA8, IA9, IA10, IA11, IA12, IA13, IA14, IA15, IA16, IA17, IA18, IA19, IA20, IA21, IA22] => M1[
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
  ] = mImpl[MSelfFrom].map[
    TypeContext.MFrom22[
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
      IA22
    ],
    TypeContext.MFrom22[
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
    ]
  ](
    new DFuncTypeImpl[
      TypeContext.MFrom22[
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
        IA22
      ],
      TypeContext.MFrom22[
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
      ]
    ](
      ia1,
      ib1,
      new DFuncTypeImpl[
        TypeContext.MFrom22[
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
          IA22
        ]#DataTail,
        TypeContext.MFrom22[
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
        ]#DataTail
      ](
        ia2,
        ib2,
        new DFuncTypeImpl[
          TypeContext.MFrom22[
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
            IA22
          ]#DataTail#DataTail,
          TypeContext.MFrom22[
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
          ]#DataTail#DataTail
        ](
          ia3,
          ib3,
          new DFuncTypeImpl[
            TypeContext.MFrom22[
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
              IA22
            ]#DataTail#DataTail#DataTail,
            TypeContext.MFrom22[
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
            ]#DataTail#DataTail#DataTail
          ](
            ia4,
            ib4,
            new DFuncTypeImpl[
              TypeContext.MFrom22[
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
                IA22
              ]#DataTail#DataTail#DataTail#DataTail,
              TypeContext.MFrom22[
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
              ]#DataTail#DataTail#DataTail#DataTail
            ](
              ia5,
              ib5,
              new DFuncTypeImpl[
                TypeContext.MFrom22[
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
                  IA22
                ]#DataTail#DataTail#DataTail#DataTail#DataTail,
                TypeContext.MFrom22[
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
                ]#DataTail#DataTail#DataTail#DataTail#DataTail
              ](
                ia6,
                ib6,
                new DFuncTypeImpl[
                  TypeContext.MFrom22[
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
                    IA22
                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                  TypeContext.MFrom22[
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
                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                ](
                  ia7,
                  ib7,
                  new DFuncTypeImpl[
                    TypeContext.MFrom22[
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
                      IA22
                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                    TypeContext.MFrom22[
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
                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                  ](
                    ia8,
                    ib8,
                    new DFuncTypeImpl[
                      TypeContext.MFrom22[
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
                        IA22
                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                      TypeContext.MFrom22[
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
                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                    ](
                      ia9,
                      ib9,
                      new DFuncTypeImpl[
                        TypeContext.MFrom22[
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
                          IA22
                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                        TypeContext.MFrom22[
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
                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                      ](
                        ia10,
                        ib10,
                        new DFuncTypeImpl[
                          TypeContext.MFrom22[
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
                            IA22
                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                          TypeContext.MFrom22[
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
                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                        ](
                          ia11,
                          ib11,
                          new DFuncTypeImpl[
                            TypeContext.MFrom22[
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
                              IA22
                            ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                            TypeContext.MFrom22[
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
                            ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                          ](
                            ia12,
                            ib12,
                            new DFuncTypeImpl[
                              TypeContext.MFrom22[
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
                                IA22
                              ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                              TypeContext.MFrom22[
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
                              ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                            ](
                              ia13,
                              ib13,
                              new DFuncTypeImpl[
                                TypeContext.MFrom22[
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
                                  IA22
                                ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                TypeContext.MFrom22[
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
                                ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                              ](
                                ia14,
                                ib14,
                                new DFuncTypeImpl[
                                  TypeContext.MFrom22[
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
                                    IA22
                                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                  TypeContext.MFrom22[
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
                                  ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                ](
                                  ia15,
                                  ib15,
                                  new DFuncTypeImpl[
                                    TypeContext.MFrom22[
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
                                      IA22
                                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                    TypeContext.MFrom22[
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
                                    ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                  ](
                                    ia16,
                                    ib16,
                                    new DFuncTypeImpl[
                                      TypeContext.MFrom22[
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
                                        IA22
                                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                      TypeContext.MFrom22[
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
                                      ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                    ](
                                      ia17,
                                      ib17,
                                      new DFuncTypeImpl[
                                        TypeContext.MFrom22[
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
                                          IA22
                                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                        TypeContext.MFrom22[
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
                                        ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                      ](
                                        ia18,
                                        ib18,
                                        new DFuncTypeImpl[
                                          TypeContext.MFrom22[
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
                                            IA22
                                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                          TypeContext.MFrom22[
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
                                          ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                        ](
                                          ia19,
                                          ib19,
                                          new DFuncTypeImpl[
                                            TypeContext.MFrom22[
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
                                              IA22
                                            ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                            TypeContext.MFrom22[
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
                                            ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                          ](
                                            ia20,
                                            ib20,
                                            new DFuncTypeImpl[
                                              TypeContext.MFrom22[
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
                                                IA22
                                              ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                              TypeContext.MFrom22[
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
                                              ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                            ](
                                              ia21,
                                              ib21,
                                              new DFuncTypeImpl[
                                                TypeContext.MFrom22[
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
                                                  IA22
                                                ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail,
                                                TypeContext.MFrom22[
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
                                                ]#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail#DataTail
                                              ](ia22, ib22, DFuncTypeZero)
                                            )
                                          )
                                        )
                                      )
                                    )
                                  )
                                )
                              )
                            )
                          )
                        )
                      )
                    )
                  )
                )
              )
            )
          )
        )
      )
    )
  )

  def zero: M1[
    Unit,
    Unit,
    Unit,
    Unit,
    Unit,
    Unit,
    Unit,
    Unit,
    Unit,
    Unit,
    Unit,
    Unit,
    Unit,
    Unit,
    Unit,
    Unit,
    Unit,
    Unit,
    Unit,
    Unit,
    Unit,
    Unit
  ] = map(
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit,
    (_: ZeroInstance) => (): Unit
  )(
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance,
    (_: Unit) => ZeroInstance.instance
  )(mImpl[MSelfFrom].zero)

}
