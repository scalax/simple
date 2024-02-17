package net.scalax.simple.codec
package decode.projection

import shapeless._

trait DecodeImplement {
  def implemention[THList <: TypeHList, DHList <: DataHList, M1[_ <: TypeHList]](m: M1[THList]): String
}

trait IdTypeHList extends TypeHList {
  override type TypeHead[T] = T
  override type TypeTail    = IdTypeHList
}

trait MonadMTypeHList[M1[_ <: TypeHList, _]] {
  def zip[TH <: TypeHList, T1, T2](ma: M1[TH, T1], ms: M1[TH, T2]): M1[TH, (T1, T2)]
  def map[TH <: TypeHList, T1, T2](fa: M1[IdTypeHList, T1] => M1[IdTypeHList, T2])(
    fb: M1[IdTypeHList, T2] => M1[IdTypeHList, T1]
  ): M1[TH, T1] => M1[TH, T2]
  def one[TH <: TypeHList, T]: M1[TH, T]
  def zero[TH <: TypeHList]: M1[TH, Unit]
}

trait ZipTypeHList[T1 <: DataHList, T2 <: DataHList] extends DataHList {
  override type DataType    = Tuple2[T1#DataType, T2#DataType]
  override type DataTail    = ZipTypeHList[T1#DataTail, T2#DataTail]
  override type UpToF[F[_]] = ZipTypeHList[T1#UpToF[F], T2#UpToF[F]]
}

/*trait FWrapH[FWrap[_], FHead[_], T <: TypeHList]
    extends PositiveTypeHList[({ type N[X] = FWrap[FHead[X]] })#N, FWrapH[FWrap, T#TypeHead, T#TypeTail]] {
  override type TypeHead[XX] = FWrap[FHead[XX]]
  override type TypeTail     = FWrapH[FWrap, T#TypeHead, T#TypeTail]
}*/

/*trait ZipTypeHF[T1 <: TypeHList, T2 <: TypeHList, UX, F[_[_]]] extends ZipTypeHList[T1#FillT[UX], T2#FillF[F]] with DataHList {
  override type DataType = Tuple2[T1#TypeHead[UX], F[T2#TypeHead]]
  override type DataTail = ZipTypeHF[T1#TypeTail, T2#TypeTail, UX, F]
  override type UpToF[F11[_]]
}*/

trait DFuncType[T1 <: DataHList, T2 <: DataHList] extends DataHList {
  override type DataType    = (T1#DataType => T2#DataType, T2#DataType => T1#DataType)
  override type DataTail    = DFuncType[T1#DataTail, T2#DataTail]
  override type UpToF[U[_]] = DFuncType[T1#UpToF[U], T2#UpToF[U]]

  def dataTail: DataTail

  def functionInstance: DataType = (funcitonIn1, funcitonIn2)

  def funcitonIn1: T1#DataType => T2#DataType = functionInstance._1
  def funcitonIn2: T2#DataType => T1#DataType = functionInstance._2
}

class DFuncTypeImpl[T1 <: DataHList, T2 <: DataHList](
  override val funcitonIn1: T1#DataType => T2#DataType,
  override val funcitonIn2: T2#DataType => T1#DataType,
  override val dataTail: DFuncType[T1#DataTail, T2#DataTail]
) extends DFuncType[T1, T2]

object DFuncTypeZero extends DFuncType[DataHListZero, DataHListZero] {
  self =>
  override def dataTail: DFuncTypeZero.type = self

  override val functionInstance: (ZeroInstance => ZeroInstance, ZeroInstance => ZeroInstance) = (identity, identity)
  override val funcitonIn1: ZeroInstance => ZeroInstance                                      = identity
  override val funcitonIn2: ZeroInstance => ZeroInstance                                      = identity
}

trait FunctionMTypeHList[M1[_ <: DataHList]] {
  def zip[T1 <: DataHList, T2 <: DataHList](ma: M1[T1], ms: M1[T2]): M1[ZipTypeHList[T1, T2]]
  def map[T1 <: DataHList, T2 <: DataHList](fa: DFuncType[T1, T2]): M1[T1] => M1[T2]
  def zero: M1[DataHListZero]
}

class DataHListUnit extends DataHList {
  override type DataType    = Unit
  override type DataTail    = DataHListUnit
  override type UpToF[F[_]] = DataHListUnit
}

trait ItemModelFuncion[X <: TypeHList, M[_ <: DataHList]] {
  def u[T]: M[X#FillT[T]]
}

trait FunctionModel[F[_[_]]] {
  def toM[X <: TypeHList, M2[_ <: DataHList]](m: FunctionMTypeHList[M2])(mx: ItemModelFuncion[X, M2]): M2[X#FillF[F]]
}

trait HListDataList extends DataHList {
  type DataType <: HList
  type DataTail <: HListDataList
  type UpToF[F[_]] <: HListDataList
}

trait HHDataHListPositive[H <: HList, T <: HListDataList] extends HListDataList {
  override type DataType = H
  override type DataTail = T
}

trait HHDataHListZero extends HListDataList {
  override type DataType = HNil
  override type DataTail = HHDataHListZero
}

object FunctionModel {
  trait FunctionModelImpl[F[_[_]] <: HList] {
    def toM[X <: TypeHList, M2[_ <: DataHList]](m: FunctionMTypeHList[M2])(mx: ItemModelFuncion[X, M2]): M2[X#FillF[F]]
  }

  def appendData[M[_ <: DataHList], T, U <: HListDataList](m: FunctionMTypeHList[M]): T = ???

  def append[F[_[_]] <: HList, UX](
    tail: FunctionModelImpl[F]
  ): FunctionModelImpl[({ type U1[T1[_]] = T1[UX] :: F[T1] })#U1] = new FunctionModelImpl[({ type U1[T1[_]] = T1[UX] :: F[T1] })#U1] {
    override def toM[X <: TypeHList, M2[_ <: DataHList]](m: FunctionMTypeHList[M2])(
      mx: ItemModelFuncion[X, M2]
    ): M2[X#FillF[({ type U1[T1[_]] = T1[UX] :: F[T1] })#U1]] = {
      val model1: M2[X#FillF[F]]                            = tail.toM(m)(mx)
      val model2: M2[ZipTypeHList[X#FillT[UX], X#FillF[F]]] = m.zip(mx.u[UX], model1)
      val dFuncType: DFuncType[ZipTypeHList[X#FillT[UX], X#FillF[F]], X#FillF[
        ({ type U1[T1[_]] = T1[UX] :: F[T1] })#U1
      ]] =
        new DFuncType[
          ZipTypeHList[X#FillT[UX], X#FillF[F]],
          X#FillF[({ type U1[T1[_]] = T1[UX] :: F[T1] })#U1]
        ] {
          override def dataTail
            : DFuncType[ZipTypeHList[X#FillT[UX], X#FillF[F]]#DataTail, X#FillF[({ type U1[T1[_]] = T1[UX] :: F[T1] })#U1]#DataTail] = ???

        }
      /*val model3: M2[ZipTypeHList[X#FillT[UX], X#FillF[F]]] => M2[X#FillF[({ type U1[T1[_]] = T1[UX] :: F[T1] })#U1]] =
        m.map[ZipTypeHList[X#FillT[UX], X#FillF[F]], X#FillF[({ type U1[T1[_]] = T1[UX] :: F[T1] })#U1]](
          dFuncType
        )
      model3(model2)*/
      ???
    }
  }
}