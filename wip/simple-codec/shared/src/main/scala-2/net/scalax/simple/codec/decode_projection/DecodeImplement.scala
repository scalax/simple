package net.scalax.simple.codec
package decode.projection

import shapeless._

trait DecodeImplement {
  def implemention[THList <: TypeHList, DHList <: DataHList, M1[_ <: TypeHList]](m: M1[THList]): String
}

trait ZipTypeHList[T1 <: TypeHList, T2 <: TypeHList] extends TypeHList {
  override type TypeHead[T] = Tuple2[T1#TypeHead[T], T2#TypeHead[T]]
  override type TypeTail    = ZipTypeHList[T1#TypeTail, T2#TypeTail]
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
