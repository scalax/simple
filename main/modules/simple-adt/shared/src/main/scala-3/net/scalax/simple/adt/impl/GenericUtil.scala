package net.scalax.simple.adt
package utils

import net.scalax.simple.ghdmzsk.ghdmzsk
import temp._
import net.scalax.simple.adt.{RuntimeData, RuntimeNat, RuntimeZero}
import builder.{coproducter, producter_build}

object GenericUtil:

  trait SimpleHList
  class SimpleHListPositive[T, Tail <: SimpleHList] extends SimpleHList
  class SimpleHListZero                             extends SimpleHList

  trait MapType[N <: RuntimeNat, SH <: SimpleHList]

  object SimpleHList extends ImplementionFor1 {
    implicit val zero: MapType[RuntimeZero, SimpleHListZero] = new MapType[RuntimeZero, SimpleHListZero] {
      //
    }
  }

  trait ImplementionFor1 {
    implicit def positive[Data, N <: RuntimeNat, SH <: SimpleHList](implicit
      s: MapType[N, SH]
    ): MapType[RuntimeData[Data, N], SimpleHListPositive[Data, SH]] =
      new MapType[RuntimeData[Data, N], SimpleHListPositive[Data, SH]] {
        //

      }
  }

end GenericUtil
