package net.scalax.simple.adt
package impl
package utils

import net.scalax.simple.ghdmzsk.ghdmzsk
import implemention.ADTGHDMZSK
import temp._
import Adt.{Status => ADTStatus}
import net.scalax.simple.adt.nat.{AdtNat, AdtNatPositive, AdtNatZero}

trait GenericUtilInstance:

  trait SimpleHList
  class SimpleHListPositive[T, Tail <: SimpleHList] extends SimpleHList
  class SimpleHListZero                             extends SimpleHList

  type SimpleHListAux[N <: AdtNat, O <: SimpleHList] = SimpleHListFromAdtNat[N]:
    type Out = O
  end SimpleHListAux

  trait SimpleHListFromAdtNat[N <: AdtNat]:
    type Out <: SimpleHList
  end SimpleHListFromAdtNat

  object SimpleHListFromAdtNat extends SimpleHListFromAdtNatImplicit1:
    inline given SimpleHListAux[AdtNatZero, SimpleHListZero] = null
  end SimpleHListFromAdtNat

  trait SimpleHListFromAdtNatImplicit1:
    inline given [Data, T <: AdtNat, O <: SimpleHList](using
      inline t1: SimpleHListAux[T, O]
    ): SimpleHListAux[AdtNatPositive[Data, T], SimpleHListPositive[Data, O]] = null
  end SimpleHListFromAdtNatImplicit1

end GenericUtilInstance
