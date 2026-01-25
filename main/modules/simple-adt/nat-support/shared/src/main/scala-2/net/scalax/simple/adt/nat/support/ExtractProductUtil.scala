package net.scalax.simple.adt
package nat
package support

import shapeless.HList

/*object ExtPro extends ExtractProductAbstraction[shapeless.HList, shapeless.::, shapeless.HNil] {
  override val hListFunc: HListFunc[shapeless.HList, shapeless.::] = HAppender
  override val zero: shapeless.HNil                                = shapeless.HNil
  override def runtimeCountSize(t: shapeless.HList): Int           = t.runtimeLength
  override def labelledItemToString(t: Any): String                = t.asInstanceOf[Symbol].name
}

object HAppender extends HListFunc[shapeless.HList, shapeless.::] {
  override def takeHead[Head, Tail <: shapeless.HList](m: shapeless.::[Head, Tail]): Head        = m.head
  override def takeTail[Head, Tail <: shapeless.HList](m: shapeless.::[Head, Tail]): Tail        = m.tail
  override def append[Head, Tail <: shapeless.HList](h: Head, t: Tail): shapeless.::[Head, Tail] = shapeless.::[Head, Tail](h, t)
}*/

object ExtractProductUtil extends NatNext5[shapeless.HList, shapeless.::, shapeless.HNil] {

  override object extraAbstraction
      extends NatNext4[shapeless.HList, shapeless.::, shapeless.HNil]
      with ExtractProductAbstraction[shapeless.HList, shapeless.::, shapeless.HNil] {
    extraAbstractionSelf =>

    override def runtimeCountSize(t: shapeless.HList): Int = t.runtimeLength
    override def labelledItemToString(t: Any): String      = t.asInstanceOf[Symbol].name

    override lazy val zeroInstance: shapeless.HNil = shapeless.HNil
    override object hListFunc extends HListFunc[shapeless.HList, shapeless.::] {
      override def takeHead[Head, Tail <: shapeless.HList](m: shapeless.::[Head, Tail]): Head        = m.head
      override def takeTail[Head, Tail <: shapeless.HList](m: shapeless.::[Head, Tail]): Tail        = m.tail
      override def append[Head, Tail <: shapeless.HList](h: Head, t: Tail): shapeless.::[Head, Tail] = shapeless.::[Head, Tail](h, t)

      private lazy val anyToABCFunc: ABCFunc[Any, HList, shapeless.::[Any, HList]] = super.toABCFunc[Any, HList]
      override def toABCFunc[Head, HCollecio <: HList]: ABCFunc[Head, HCollecio, shapeless.::[Head, HCollecio]] =
        anyToABCFunc.asInstanceOf[ABCFunc[Head, HCollecio, shapeless.::[Head, HCollecio]]]
    }

    override object natNext2Helper extends NatNext2Helper[shapeless.HList, shapeless.::] {
      override lazy val hlistFunc = extraAbstractionSelf.hListFunc
    }
  }
}
