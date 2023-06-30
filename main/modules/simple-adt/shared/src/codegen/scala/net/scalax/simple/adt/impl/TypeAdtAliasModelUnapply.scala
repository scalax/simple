package net.scalax.simple
package adt
package impl

import net.scalax.simple.adt.implemention.{NatFunc, NatFuncPositive, UnapplyInstance => UI}
import UI.{CountNatPositive => CP, PositiveTypeCounter => PC, UnapplyFuncPositive => UFP}

trait TypeAdtAliasModelUnapply {
  import TypeAdtAliasModelUnapplyImpl._
  val Option1: UI.UnapplyFuncZero = OptionNatImpl1.value

  val Option2: OptionNatImpl2 = OptionNatImpl2.value

  val Option3: OptionNatImpl3 = OptionNatImpl3.value

  val Option4: OptionNatImpl4 = OptionNatImpl4.value

  val Option5: OptionNatImpl5 = OptionNatImpl5.value

  val Option6: OptionNatImpl6 = OptionNatImpl6.value

  val Option7: OptionNatImpl7 = OptionNatImpl7.value

  val Option8: OptionNatImpl8 = OptionNatImpl8.value

  val Option9: OptionNatImpl9 = OptionNatImpl9.value

  val Option10: OptionNatImpl10 = OptionNatImpl10.value

  val Option11: OptionNatImpl11 = OptionNatImpl11.value

  val Option12: OptionNatImpl12 = OptionNatImpl12.value

  val Option13: OptionNatImpl13 = OptionNatImpl13.value

  val Option14: OptionNatImpl14 = OptionNatImpl14.value

  val Option15: OptionNatImpl15 = OptionNatImpl15.value

  val Option16: OptionNatImpl16 = OptionNatImpl16.value

  val Option17: OptionNatImpl17 = OptionNatImpl17.value

  val Option18: OptionNatImpl18 = OptionNatImpl18.value

  val Option19: OptionNatImpl19 = OptionNatImpl19.value

  val Option20: OptionNatImpl20 = OptionNatImpl20.value

  val Option21: OptionNatImpl21 = OptionNatImpl21.value

  val Option22: OptionNatImpl22 = OptionNatImpl22.value

  val Option23: OptionNatImpl23 = OptionNatImpl23.value

  val Option24: OptionNatImpl24 = OptionNatImpl24.value

  val Option25: OptionNatImpl25 = OptionNatImpl25.value

  val Option26: OptionNatImpl26 = OptionNatImpl26.value

  val Option27: OptionNatImpl27 = OptionNatImpl27.value

  val Option28: OptionNatImpl28 = OptionNatImpl28.value

  val Option29: OptionNatImpl29 = OptionNatImpl29.value

  val Option30: OptionNatImpl30 = OptionNatImpl30.value

}

object TypeAdtAliasModelUnapplyImpl {

  type OptionNatImpl1 = UI.UnapplyFuncZero
  object OptionNatImpl1 {
    val value: OptionNatImpl1 = UI.UnapplyFuncZero.value
  }

  class OptionNatImpl2 extends UFP[OptionNatImpl1] with PC[OptionNatImpl1] {
    self =>
    override type ThisType = OptionNatImpl2
    override val tail: OptionNatImpl1 = OptionNatImpl1.value
    override def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl2, U, Data]): Option[Data] = super.apply(u)
    override def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl2, U, Data]): Option[Data] =
      super.unapply(u)
  }
  object OptionNatImpl2 {
    val value: OptionNatImpl2 = new OptionNatImpl2

    implicit def positiveGetTail[T2Tail <: NatFunc, Data, TempData](implicit
      somethig_not_used: CP.Aux[OptionNatImpl1, T2Tail, Data]
    ): CP.Aux[OptionNatImpl2, NatFuncPositive[TempData, T2Tail], Data] =
      new CP[OptionNatImpl2, NatFuncPositive[TempData, T2Tail]] {
        override type DataType = Data
      }
  }

  class OptionNatImpl3 extends UFP[OptionNatImpl2] with PC[OptionNatImpl2] {
    self =>
    override type ThisType = OptionNatImpl3
    override val tail: OptionNatImpl2 = OptionNatImpl2.value
    override def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl3, U, Data]): Option[Data] = super.apply(u)
    override def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl3, U, Data]): Option[Data] =
      super.unapply(u)
  }
  object OptionNatImpl3 {
    val value: OptionNatImpl3 = new OptionNatImpl3

    implicit def positiveGetTail[T2Tail <: NatFunc, Data, TempData](implicit
      somethig_not_used: CP.Aux[OptionNatImpl2, T2Tail, Data]
    ): CP.Aux[OptionNatImpl3, NatFuncPositive[TempData, T2Tail], Data] =
      new CP[OptionNatImpl3, NatFuncPositive[TempData, T2Tail]] {
        override type DataType = Data
      }
  }

  class OptionNatImpl4 extends UFP[OptionNatImpl3] with PC[OptionNatImpl3] {
    self =>
    override type ThisType = OptionNatImpl4
    override val tail: OptionNatImpl3 = OptionNatImpl3.value
    override def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl4, U, Data]): Option[Data] = super.apply(u)
    override def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl4, U, Data]): Option[Data] =
      super.unapply(u)
  }
  object OptionNatImpl4 {
    val value: OptionNatImpl4 = new OptionNatImpl4

    implicit def positiveGetTail[T2Tail <: NatFunc, Data, TempData](implicit
      somethig_not_used: CP.Aux[OptionNatImpl3, T2Tail, Data]
    ): CP.Aux[OptionNatImpl4, NatFuncPositive[TempData, T2Tail], Data] =
      new CP[OptionNatImpl4, NatFuncPositive[TempData, T2Tail]] {
        override type DataType = Data
      }
  }

  class OptionNatImpl5 extends UFP[OptionNatImpl4] with PC[OptionNatImpl4] {
    self =>
    override type ThisType = OptionNatImpl5
    override val tail: OptionNatImpl4 = OptionNatImpl4.value
    override def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl5, U, Data]): Option[Data] = super.apply(u)
    override def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl5, U, Data]): Option[Data] =
      super.unapply(u)
  }
  object OptionNatImpl5 {
    val value: OptionNatImpl5 = new OptionNatImpl5

    implicit def positiveGetTail[T2Tail <: NatFunc, Data, TempData](implicit
      somethig_not_used: CP.Aux[OptionNatImpl4, T2Tail, Data]
    ): CP.Aux[OptionNatImpl5, NatFuncPositive[TempData, T2Tail], Data] =
      new CP[OptionNatImpl5, NatFuncPositive[TempData, T2Tail]] {
        override type DataType = Data
      }
  }

  class OptionNatImpl6 extends UFP[OptionNatImpl5] with PC[OptionNatImpl5] {
    self =>
    override type ThisType = OptionNatImpl6
    override val tail: OptionNatImpl5 = OptionNatImpl5.value
    override def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl6, U, Data]): Option[Data] = super.apply(u)
    override def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl6, U, Data]): Option[Data] =
      super.unapply(u)
  }
  object OptionNatImpl6 {
    val value: OptionNatImpl6 = new OptionNatImpl6

    implicit def positiveGetTail[T2Tail <: NatFunc, Data, TempData](implicit
      somethig_not_used: CP.Aux[OptionNatImpl5, T2Tail, Data]
    ): CP.Aux[OptionNatImpl6, NatFuncPositive[TempData, T2Tail], Data] =
      new CP[OptionNatImpl6, NatFuncPositive[TempData, T2Tail]] {
        override type DataType = Data
      }
  }

  class OptionNatImpl7 extends UFP[OptionNatImpl6] with PC[OptionNatImpl6] {
    self =>
    override type ThisType = OptionNatImpl7
    override val tail: OptionNatImpl6 = OptionNatImpl6.value
    override def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl7, U, Data]): Option[Data] = super.apply(u)
    override def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl7, U, Data]): Option[Data] =
      super.unapply(u)
  }
  object OptionNatImpl7 {
    val value: OptionNatImpl7 = new OptionNatImpl7

    implicit def positiveGetTail[T2Tail <: NatFunc, Data, TempData](implicit
      somethig_not_used: CP.Aux[OptionNatImpl6, T2Tail, Data]
    ): CP.Aux[OptionNatImpl7, NatFuncPositive[TempData, T2Tail], Data] =
      new CP[OptionNatImpl7, NatFuncPositive[TempData, T2Tail]] {
        override type DataType = Data
      }
  }

  class OptionNatImpl8 extends UFP[OptionNatImpl7] with PC[OptionNatImpl7] {
    self =>
    override type ThisType = OptionNatImpl8
    override val tail: OptionNatImpl7 = OptionNatImpl7.value
    override def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl8, U, Data]): Option[Data] = super.apply(u)
    override def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl8, U, Data]): Option[Data] =
      super.unapply(u)
  }
  object OptionNatImpl8 {
    val value: OptionNatImpl8 = new OptionNatImpl8

    implicit def positiveGetTail[T2Tail <: NatFunc, Data, TempData](implicit
      somethig_not_used: CP.Aux[OptionNatImpl7, T2Tail, Data]
    ): CP.Aux[OptionNatImpl8, NatFuncPositive[TempData, T2Tail], Data] =
      new CP[OptionNatImpl8, NatFuncPositive[TempData, T2Tail]] {
        override type DataType = Data
      }
  }

  class OptionNatImpl9 extends UFP[OptionNatImpl8] with PC[OptionNatImpl8] {
    self =>
    override type ThisType = OptionNatImpl9
    override val tail: OptionNatImpl8 = OptionNatImpl8.value
    override def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl9, U, Data]): Option[Data] = super.apply(u)
    override def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl9, U, Data]): Option[Data] =
      super.unapply(u)
  }
  object OptionNatImpl9 {
    val value: OptionNatImpl9 = new OptionNatImpl9

    implicit def positiveGetTail[T2Tail <: NatFunc, Data, TempData](implicit
      somethig_not_used: CP.Aux[OptionNatImpl8, T2Tail, Data]
    ): CP.Aux[OptionNatImpl9, NatFuncPositive[TempData, T2Tail], Data] =
      new CP[OptionNatImpl9, NatFuncPositive[TempData, T2Tail]] {
        override type DataType = Data
      }
  }

  class OptionNatImpl10 extends UFP[OptionNatImpl9] with PC[OptionNatImpl9] {
    self =>
    override type ThisType = OptionNatImpl10
    override val tail: OptionNatImpl9 = OptionNatImpl9.value
    override def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl10, U, Data]): Option[Data] =
      super.apply(u)
    override def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl10, U, Data]): Option[Data] =
      super.unapply(u)
  }
  object OptionNatImpl10 {
    val value: OptionNatImpl10 = new OptionNatImpl10

    implicit def positiveGetTail[T2Tail <: NatFunc, Data, TempData](implicit
      somethig_not_used: CP.Aux[OptionNatImpl9, T2Tail, Data]
    ): CP.Aux[OptionNatImpl10, NatFuncPositive[TempData, T2Tail], Data] =
      new CP[OptionNatImpl10, NatFuncPositive[TempData, T2Tail]] {
        override type DataType = Data
      }
  }

  class OptionNatImpl11 extends UFP[OptionNatImpl10] with PC[OptionNatImpl10] {
    self =>
    override type ThisType = OptionNatImpl11
    override val tail: OptionNatImpl10 = OptionNatImpl10.value
    override def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl11, U, Data]): Option[Data] =
      super.apply(u)
    override def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl11, U, Data]): Option[Data] =
      super.unapply(u)
  }
  object OptionNatImpl11 {
    val value: OptionNatImpl11 = new OptionNatImpl11

    implicit def positiveGetTail[T2Tail <: NatFunc, Data, TempData](implicit
      somethig_not_used: CP.Aux[OptionNatImpl10, T2Tail, Data]
    ): CP.Aux[OptionNatImpl11, NatFuncPositive[TempData, T2Tail], Data] =
      new CP[OptionNatImpl11, NatFuncPositive[TempData, T2Tail]] {
        override type DataType = Data
      }
  }

  class OptionNatImpl12 extends UFP[OptionNatImpl11] with PC[OptionNatImpl11] {
    self =>
    override type ThisType = OptionNatImpl12
    override val tail: OptionNatImpl11 = OptionNatImpl11.value
    override def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl12, U, Data]): Option[Data] =
      super.apply(u)
    override def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl12, U, Data]): Option[Data] =
      super.unapply(u)
  }
  object OptionNatImpl12 {
    val value: OptionNatImpl12 = new OptionNatImpl12

    implicit def positiveGetTail[T2Tail <: NatFunc, Data, TempData](implicit
      somethig_not_used: CP.Aux[OptionNatImpl11, T2Tail, Data]
    ): CP.Aux[OptionNatImpl12, NatFuncPositive[TempData, T2Tail], Data] =
      new CP[OptionNatImpl12, NatFuncPositive[TempData, T2Tail]] {
        override type DataType = Data
      }
  }

  class OptionNatImpl13 extends UFP[OptionNatImpl12] with PC[OptionNatImpl12] {
    self =>
    override type ThisType = OptionNatImpl13
    override val tail: OptionNatImpl12 = OptionNatImpl12.value
    override def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl13, U, Data]): Option[Data] =
      super.apply(u)
    override def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl13, U, Data]): Option[Data] =
      super.unapply(u)
  }
  object OptionNatImpl13 {
    val value: OptionNatImpl13 = new OptionNatImpl13

    implicit def positiveGetTail[T2Tail <: NatFunc, Data, TempData](implicit
      somethig_not_used: CP.Aux[OptionNatImpl12, T2Tail, Data]
    ): CP.Aux[OptionNatImpl13, NatFuncPositive[TempData, T2Tail], Data] =
      new CP[OptionNatImpl13, NatFuncPositive[TempData, T2Tail]] {
        override type DataType = Data
      }
  }

  class OptionNatImpl14 extends UFP[OptionNatImpl13] with PC[OptionNatImpl13] {
    self =>
    override type ThisType = OptionNatImpl14
    override val tail: OptionNatImpl13 = OptionNatImpl13.value
    override def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl14, U, Data]): Option[Data] =
      super.apply(u)
    override def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl14, U, Data]): Option[Data] =
      super.unapply(u)
  }
  object OptionNatImpl14 {
    val value: OptionNatImpl14 = new OptionNatImpl14

    implicit def positiveGetTail[T2Tail <: NatFunc, Data, TempData](implicit
      somethig_not_used: CP.Aux[OptionNatImpl13, T2Tail, Data]
    ): CP.Aux[OptionNatImpl14, NatFuncPositive[TempData, T2Tail], Data] =
      new CP[OptionNatImpl14, NatFuncPositive[TempData, T2Tail]] {
        override type DataType = Data
      }
  }

  class OptionNatImpl15 extends UFP[OptionNatImpl14] with PC[OptionNatImpl14] {
    self =>
    override type ThisType = OptionNatImpl15
    override val tail: OptionNatImpl14 = OptionNatImpl14.value
    override def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl15, U, Data]): Option[Data] =
      super.apply(u)
    override def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl15, U, Data]): Option[Data] =
      super.unapply(u)
  }
  object OptionNatImpl15 {
    val value: OptionNatImpl15 = new OptionNatImpl15

    implicit def positiveGetTail[T2Tail <: NatFunc, Data, TempData](implicit
      somethig_not_used: CP.Aux[OptionNatImpl14, T2Tail, Data]
    ): CP.Aux[OptionNatImpl15, NatFuncPositive[TempData, T2Tail], Data] =
      new CP[OptionNatImpl15, NatFuncPositive[TempData, T2Tail]] {
        override type DataType = Data
      }
  }

  class OptionNatImpl16 extends UFP[OptionNatImpl15] with PC[OptionNatImpl15] {
    self =>
    override type ThisType = OptionNatImpl16
    override val tail: OptionNatImpl15 = OptionNatImpl15.value
    override def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl16, U, Data]): Option[Data] =
      super.apply(u)
    override def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl16, U, Data]): Option[Data] =
      super.unapply(u)
  }
  object OptionNatImpl16 {
    val value: OptionNatImpl16 = new OptionNatImpl16

    implicit def positiveGetTail[T2Tail <: NatFunc, Data, TempData](implicit
      somethig_not_used: CP.Aux[OptionNatImpl15, T2Tail, Data]
    ): CP.Aux[OptionNatImpl16, NatFuncPositive[TempData, T2Tail], Data] =
      new CP[OptionNatImpl16, NatFuncPositive[TempData, T2Tail]] {
        override type DataType = Data
      }
  }

  class OptionNatImpl17 extends UFP[OptionNatImpl16] with PC[OptionNatImpl16] {
    self =>
    override type ThisType = OptionNatImpl17
    override val tail: OptionNatImpl16 = OptionNatImpl16.value
    override def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl17, U, Data]): Option[Data] =
      super.apply(u)
    override def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl17, U, Data]): Option[Data] =
      super.unapply(u)
  }
  object OptionNatImpl17 {
    val value: OptionNatImpl17 = new OptionNatImpl17

    implicit def positiveGetTail[T2Tail <: NatFunc, Data, TempData](implicit
      somethig_not_used: CP.Aux[OptionNatImpl16, T2Tail, Data]
    ): CP.Aux[OptionNatImpl17, NatFuncPositive[TempData, T2Tail], Data] =
      new CP[OptionNatImpl17, NatFuncPositive[TempData, T2Tail]] {
        override type DataType = Data
      }
  }

  class OptionNatImpl18 extends UFP[OptionNatImpl17] with PC[OptionNatImpl17] {
    self =>
    override type ThisType = OptionNatImpl18
    override val tail: OptionNatImpl17 = OptionNatImpl17.value
    override def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl18, U, Data]): Option[Data] =
      super.apply(u)
    override def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl18, U, Data]): Option[Data] =
      super.unapply(u)
  }
  object OptionNatImpl18 {
    val value: OptionNatImpl18 = new OptionNatImpl18

    implicit def positiveGetTail[T2Tail <: NatFunc, Data, TempData](implicit
      somethig_not_used: CP.Aux[OptionNatImpl17, T2Tail, Data]
    ): CP.Aux[OptionNatImpl18, NatFuncPositive[TempData, T2Tail], Data] =
      new CP[OptionNatImpl18, NatFuncPositive[TempData, T2Tail]] {
        override type DataType = Data
      }
  }

  class OptionNatImpl19 extends UFP[OptionNatImpl18] with PC[OptionNatImpl18] {
    self =>
    override type ThisType = OptionNatImpl19
    override val tail: OptionNatImpl18 = OptionNatImpl18.value
    override def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl19, U, Data]): Option[Data] =
      super.apply(u)
    override def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl19, U, Data]): Option[Data] =
      super.unapply(u)
  }
  object OptionNatImpl19 {
    val value: OptionNatImpl19 = new OptionNatImpl19

    implicit def positiveGetTail[T2Tail <: NatFunc, Data, TempData](implicit
      somethig_not_used: CP.Aux[OptionNatImpl18, T2Tail, Data]
    ): CP.Aux[OptionNatImpl19, NatFuncPositive[TempData, T2Tail], Data] =
      new CP[OptionNatImpl19, NatFuncPositive[TempData, T2Tail]] {
        override type DataType = Data
      }
  }

  class OptionNatImpl20 extends UFP[OptionNatImpl19] with PC[OptionNatImpl19] {
    self =>
    override type ThisType = OptionNatImpl20
    override val tail: OptionNatImpl19 = OptionNatImpl19.value
    override def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl20, U, Data]): Option[Data] =
      super.apply(u)
    override def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl20, U, Data]): Option[Data] =
      super.unapply(u)
  }
  object OptionNatImpl20 {
    val value: OptionNatImpl20 = new OptionNatImpl20

    implicit def positiveGetTail[T2Tail <: NatFunc, Data, TempData](implicit
      somethig_not_used: CP.Aux[OptionNatImpl19, T2Tail, Data]
    ): CP.Aux[OptionNatImpl20, NatFuncPositive[TempData, T2Tail], Data] =
      new CP[OptionNatImpl20, NatFuncPositive[TempData, T2Tail]] {
        override type DataType = Data
      }
  }

  class OptionNatImpl21 extends UFP[OptionNatImpl20] with PC[OptionNatImpl20] {
    self =>
    override type ThisType = OptionNatImpl21
    override val tail: OptionNatImpl20 = OptionNatImpl20.value
    override def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl21, U, Data]): Option[Data] =
      super.apply(u)
    override def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl21, U, Data]): Option[Data] =
      super.unapply(u)
  }
  object OptionNatImpl21 {
    val value: OptionNatImpl21 = new OptionNatImpl21

    implicit def positiveGetTail[T2Tail <: NatFunc, Data, TempData](implicit
      somethig_not_used: CP.Aux[OptionNatImpl20, T2Tail, Data]
    ): CP.Aux[OptionNatImpl21, NatFuncPositive[TempData, T2Tail], Data] =
      new CP[OptionNatImpl21, NatFuncPositive[TempData, T2Tail]] {
        override type DataType = Data
      }
  }

  class OptionNatImpl22 extends UFP[OptionNatImpl21] with PC[OptionNatImpl21] {
    self =>
    override type ThisType = OptionNatImpl22
    override val tail: OptionNatImpl21 = OptionNatImpl21.value
    override def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl22, U, Data]): Option[Data] =
      super.apply(u)
    override def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl22, U, Data]): Option[Data] =
      super.unapply(u)
  }
  object OptionNatImpl22 {
    val value: OptionNatImpl22 = new OptionNatImpl22

    implicit def positiveGetTail[T2Tail <: NatFunc, Data, TempData](implicit
      somethig_not_used: CP.Aux[OptionNatImpl21, T2Tail, Data]
    ): CP.Aux[OptionNatImpl22, NatFuncPositive[TempData, T2Tail], Data] =
      new CP[OptionNatImpl22, NatFuncPositive[TempData, T2Tail]] {
        override type DataType = Data
      }
  }

  class OptionNatImpl23 extends UFP[OptionNatImpl22] with PC[OptionNatImpl22] {
    self =>
    override type ThisType = OptionNatImpl23
    override val tail: OptionNatImpl22 = OptionNatImpl22.value
    override def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl23, U, Data]): Option[Data] =
      super.apply(u)
    override def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl23, U, Data]): Option[Data] =
      super.unapply(u)
  }
  object OptionNatImpl23 {
    val value: OptionNatImpl23 = new OptionNatImpl23

    implicit def positiveGetTail[T2Tail <: NatFunc, Data, TempData](implicit
      somethig_not_used: CP.Aux[OptionNatImpl22, T2Tail, Data]
    ): CP.Aux[OptionNatImpl23, NatFuncPositive[TempData, T2Tail], Data] =
      new CP[OptionNatImpl23, NatFuncPositive[TempData, T2Tail]] {
        override type DataType = Data
      }
  }

  class OptionNatImpl24 extends UFP[OptionNatImpl23] with PC[OptionNatImpl23] {
    self =>
    override type ThisType = OptionNatImpl24
    override val tail: OptionNatImpl23 = OptionNatImpl23.value
    override def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl24, U, Data]): Option[Data] =
      super.apply(u)
    override def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl24, U, Data]): Option[Data] =
      super.unapply(u)
  }
  object OptionNatImpl24 {
    val value: OptionNatImpl24 = new OptionNatImpl24

    implicit def positiveGetTail[T2Tail <: NatFunc, Data, TempData](implicit
      somethig_not_used: CP.Aux[OptionNatImpl23, T2Tail, Data]
    ): CP.Aux[OptionNatImpl24, NatFuncPositive[TempData, T2Tail], Data] =
      new CP[OptionNatImpl24, NatFuncPositive[TempData, T2Tail]] {
        override type DataType = Data
      }
  }

  class OptionNatImpl25 extends UFP[OptionNatImpl24] with PC[OptionNatImpl24] {
    self =>
    override type ThisType = OptionNatImpl25
    override val tail: OptionNatImpl24 = OptionNatImpl24.value
    override def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl25, U, Data]): Option[Data] =
      super.apply(u)
    override def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl25, U, Data]): Option[Data] =
      super.unapply(u)
  }
  object OptionNatImpl25 {
    val value: OptionNatImpl25 = new OptionNatImpl25

    implicit def positiveGetTail[T2Tail <: NatFunc, Data, TempData](implicit
      somethig_not_used: CP.Aux[OptionNatImpl24, T2Tail, Data]
    ): CP.Aux[OptionNatImpl25, NatFuncPositive[TempData, T2Tail], Data] =
      new CP[OptionNatImpl25, NatFuncPositive[TempData, T2Tail]] {
        override type DataType = Data
      }
  }

  class OptionNatImpl26 extends UFP[OptionNatImpl25] with PC[OptionNatImpl25] {
    self =>
    override type ThisType = OptionNatImpl26
    override val tail: OptionNatImpl25 = OptionNatImpl25.value
    override def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl26, U, Data]): Option[Data] =
      super.apply(u)
    override def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl26, U, Data]): Option[Data] =
      super.unapply(u)
  }
  object OptionNatImpl26 {
    val value: OptionNatImpl26 = new OptionNatImpl26

    implicit def positiveGetTail[T2Tail <: NatFunc, Data, TempData](implicit
      somethig_not_used: CP.Aux[OptionNatImpl25, T2Tail, Data]
    ): CP.Aux[OptionNatImpl26, NatFuncPositive[TempData, T2Tail], Data] =
      new CP[OptionNatImpl26, NatFuncPositive[TempData, T2Tail]] {
        override type DataType = Data
      }
  }

  class OptionNatImpl27 extends UFP[OptionNatImpl26] with PC[OptionNatImpl26] {
    self =>
    override type ThisType = OptionNatImpl27
    override val tail: OptionNatImpl26 = OptionNatImpl26.value
    override def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl27, U, Data]): Option[Data] =
      super.apply(u)
    override def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl27, U, Data]): Option[Data] =
      super.unapply(u)
  }
  object OptionNatImpl27 {
    val value: OptionNatImpl27 = new OptionNatImpl27

    implicit def positiveGetTail[T2Tail <: NatFunc, Data, TempData](implicit
      somethig_not_used: CP.Aux[OptionNatImpl26, T2Tail, Data]
    ): CP.Aux[OptionNatImpl27, NatFuncPositive[TempData, T2Tail], Data] =
      new CP[OptionNatImpl27, NatFuncPositive[TempData, T2Tail]] {
        override type DataType = Data
      }
  }

  class OptionNatImpl28 extends UFP[OptionNatImpl27] with PC[OptionNatImpl27] {
    self =>
    override type ThisType = OptionNatImpl28
    override val tail: OptionNatImpl27 = OptionNatImpl27.value
    override def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl28, U, Data]): Option[Data] =
      super.apply(u)
    override def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl28, U, Data]): Option[Data] =
      super.unapply(u)
  }
  object OptionNatImpl28 {
    val value: OptionNatImpl28 = new OptionNatImpl28

    implicit def positiveGetTail[T2Tail <: NatFunc, Data, TempData](implicit
      somethig_not_used: CP.Aux[OptionNatImpl27, T2Tail, Data]
    ): CP.Aux[OptionNatImpl28, NatFuncPositive[TempData, T2Tail], Data] =
      new CP[OptionNatImpl28, NatFuncPositive[TempData, T2Tail]] {
        override type DataType = Data
      }
  }

  class OptionNatImpl29 extends UFP[OptionNatImpl28] with PC[OptionNatImpl28] {
    self =>
    override type ThisType = OptionNatImpl29
    override val tail: OptionNatImpl28 = OptionNatImpl28.value
    override def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl29, U, Data]): Option[Data] =
      super.apply(u)
    override def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl29, U, Data]): Option[Data] =
      super.unapply(u)
  }
  object OptionNatImpl29 {
    val value: OptionNatImpl29 = new OptionNatImpl29

    implicit def positiveGetTail[T2Tail <: NatFunc, Data, TempData](implicit
      somethig_not_used: CP.Aux[OptionNatImpl28, T2Tail, Data]
    ): CP.Aux[OptionNatImpl29, NatFuncPositive[TempData, T2Tail], Data] =
      new CP[OptionNatImpl29, NatFuncPositive[TempData, T2Tail]] {
        override type DataType = Data
      }
  }

  class OptionNatImpl30 extends UFP[OptionNatImpl29] with PC[OptionNatImpl29] {
    self =>
    override type ThisType = OptionNatImpl30
    override val tail: OptionNatImpl29 = OptionNatImpl29.value
    override def apply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl30, U, Data]): Option[Data] =
      super.apply(u)
    override def unapply[U <: NatFunc, Data](u: U)(implicit somethig_not_used: CP.Aux[OptionNatImpl30, U, Data]): Option[Data] =
      super.unapply(u)
  }
  object OptionNatImpl30 {
    val value: OptionNatImpl30 = new OptionNatImpl30

    implicit def positiveGetTail[T2Tail <: NatFunc, Data, TempData](implicit
      somethig_not_used: CP.Aux[OptionNatImpl29, T2Tail, Data]
    ): CP.Aux[OptionNatImpl30, NatFuncPositive[TempData, T2Tail], Data] =
      new CP[OptionNatImpl30, NatFuncPositive[TempData, T2Tail]] {
        override type DataType = Data
      }
  }

}
