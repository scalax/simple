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
  override type DataTail = ZipTypeHList[T1#DataTail, T2#DataTail]
  override type UpToF[F[_]] <: DataHListF[F]
}

trait ZipDataHListF[F[_], T1 <: DataHListF[F], T2 <: DataHListF[F]] extends DataHListF[F] {
  override type DataType    = Tuple2[T1#DataType, T2#DataType]
  override type DataTail    = ZipDataHListF[F, T1#DataTail, T2#DataTail]
  override type UpToF[U[_]] = ZipDataHListF[U, T1#UpToF[U], T2#UpToF[U]]
}

trait FunctionMTypeHList[M1[_ <: DataHList]] {
  def zip[T1 <: DataHList, T2 <: DataHList](ma: M1[T1], ms: M1[T2]): M1[ZipTypeHList[T1, T2]]
  def map[T1 <: DataHList, T2 <: DataHList](fa: T1#ToHList => T2#ToHList)(fb: T2#ToHList => T1#ToHList): M1[T1] => M1[T2]
  def one[T1 <: DataHList]: M1[T1]
  def zero: M1[DataHListZero]
}
