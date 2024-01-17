package net.scalax.simple.codec
package decode.projection

import shapeless._

trait DataHList {
  type DataHead
  type DataTail <: DataHList
  type ToHList <: HList
  type AppendF[F[_[_]], U <: TypeHList[F]] <: DataHList with TypeHList[F]
}

/*trait MergeData[F[_[_]], TH <: TypeHList[F], DT <: DataHList] extends DataHList with TypeHList[F] {
  override type DataHead = TH#Head[DT#DataHead]
  override type Head[T]  = TH#Head[T]
  override type DataTail = MergeData[F, TH, DT#DataTail]
  override type Tail     = MergeData[F, TH#Tail, DT]
   override type ToHList  = TH#Head[DT#DataHead] :: DataTail#ToHList
}

trait MergeDataZero[F[_[_]], TH <: TypeHList[F]] extends MergeData[F, TH, DataHListZero] {
  override type DataHead = TH#Head[ZeroInstance]
  override type Head[T]  = TH#Head[T]
  override type DataTail = MergeData[F, TH, DataHListZero]
  override type Tail     = MergeData[F, TH#Tail, DataHListZero]
  override type ToHList  = HNil
}*/

trait DataHListZero extends DataHList {
  override type DataHead = ZeroInstance
  override type DataTail = DataHListZero
  override type ToHList  = HNil
}

trait DataHListPositive extends DataHList {
  override type DataHead
  override type DataTail <: DataHList
  override type ToHList = DataHead :: DataTail#ToHList
}
