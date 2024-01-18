package net.scalax.simple.codec
package decode.projection

import shapeless._

trait DataHList {
  type DataHead
  type DataTail <: DataHList
  type ToHList <: HList
  type UpToF[F[_]] <: DataHListF[DataHead, F, DataTail]
}

trait DataHListPositive[H, T <: DataHList] extends DataHList {
  override type DataHead    = H
  override type DataTail    = T
  override type ToHList     = H :: T#ToHList
  override type UpToF[F[_]] = DataHListFPositive[DataHead, F, DataTail]
}

trait DataHListZero extends DataHList {
  override type DataHead    = ZeroInstance
  override type DataTail    = DataHListZero
  override type ToHList     = HNil
  override type UpToF[F[_]] = DataHListFZero[F]
}

trait DataHListF[H, F[_], Tail <: DataHList] extends DataHList {
  override type DataHead = F[H]
  override type DataTail <: DataHListF[Tail#DataHead, F, Tail]
  override type ToHList <: HList
}

trait DataHListFPositive[H, F[_], Tail <: DataHList] extends DataHListF[H, F, Tail] {
  override type DataHead = F[H]
  override type DataTail = DataHListF[Tail#DataHead, F, Tail]
  override type ToHList  = DataHead :: DataTail#ToHList
}

trait DataHListFZero[F[_]] extends DataHListF[ZeroInstance, F, DataHListZero] {
  override type DataHead = F[ZeroInstance]
  override type DataTail = DataHListFZero[F]
  override type ToHList  = HNil
}
