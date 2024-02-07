package net.scalax.simple.codec
package decode.projection

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

trait ItemModelFuncion[X <: TypeHList] {
  def u[T]: X#FillT[T]
}

trait FunctionModel[F[_[_]]] {
  def toM[X <: TypeHList, M2[_ <: DataHList]](m: FunctionMTypeHList[M2])(mx: ItemModelFuncion[X]): M2[X#FillF[F]]
}
