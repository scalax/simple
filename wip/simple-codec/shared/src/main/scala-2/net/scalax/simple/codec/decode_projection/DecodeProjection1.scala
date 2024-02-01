package net.scalax.simple.codec
package decode.projection

import shapeless._

trait DataHList {
  type DataType
  type DataTail <: DataHList
  type UpToF[F[_]] <: DataHList
}

trait DataHListPositive[H, T <: DataHList] extends DataHList {
  override type DataType    = H
  override type DataTail    = T
  override type UpToF[F[_]] = DataHListPositive[F[H], DataTail]
}

trait DataHListZero extends DataHList {
  override type DataType    = ZeroInstance
  override type DataTail    = DataHListZero
  override type UpToF[F[_]] = DataHListZero
}

/*trait DataHListF[F[_]] extends DataHList {
  override type DataType
  override type DataTail <: DataHListF[F]
  // override type ToHList <: HList
  override type UpToF[U[_]] <: DataHListF[U]
}

trait DataHListFPositive[H, F[_], Tail <: DataHList] extends DataHListF[F] with DataHListPositive[F[H], Tail#UpToF[F]] {
  override type DataType = F[H]
}

trait DataHListFZero[F[_]] extends DataHListF[F] with DataHListZero {
  override type DataType = ZeroInstance
  override type DataTail = DataHListFZero[F]
  // override type ToHList  = HNil
}*/

/*object AAAA {

  class Tag[T]

  type HList1 = DataHListPositive[String, DataHListPositive[
    List[String],
    DataHListPositive[List[Int], DataHListPositive[Long, DataHListZero]]
  ]]

  locally {
    val data1: Tag[HList1#ToHList] = new Tag[HList1#ToHList]

    val data2: Tag[String :: List[String] :: List[Int] :: Long :: HNil] = data1
  }

  locally {
    val data1: Tag[HList1#UpToF[List]#ToHList] =
      new Tag[HList1#UpToF[List]#ToHList]

    val data2: Tag[
      List[String] :: List[List[String]] :: List[List[Int]] :: List[Long] :: HNil
    ] = data1
  }

  locally {
    trait Param123[T]

    val data1: Tag[HList1#UpToF[Param123]#ToHList] =
      new Tag[HList1#UpToF[Param123]#ToHList]

    val data2: Tag[
      Param123[String] :: Param123[List[String]] ::
        Param123[
          List[Int]
        ] :: Param123[Long] :: HNil
    ] = data1

    val data3: Tag[HList1#UpToF[Param123]#UpToF[Param123]#ToHList] = new Tag[HList1#UpToF[Param123]#UpToF[Param123]#ToHList]

    val data4: Tag[
      Param123[Param123[String]] :: Param123[Param123[List[String]]] :: Param123[Param123[List[Int]]] :: Param123[Param123[Long]] :: HNil
    ] = data3

  }
}*/
