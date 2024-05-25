package net.scalax.simple.adt
package utils

import net.scalax.simple.ghdmzsk.ghdmzsk
import temp._
import builder.{coproducter, producter_build}

object ApplyToFunc:

  import GenericUtil._

  type ToFunctionTuple[t <: SimpleHList, r] <: Tuple = t match
    case SimpleHListZero              => EmptyTuple
    case SimpleHListPositive[d, tail] => (d => r) *: ToFunctionTuple[tail, r]
  end ToFunctionTuple

  private def toFuncFold(tup: Tuple): ghdmzsk = tup match {
    case h *: tail  => producter_build.appended(h).inputGHDMZSK(() => toFuncFold(tail))
    case EmptyTuple => producter_build.zero
  }

  class FunctionApplyInstance[O[U] <: Tuple, ADTExtension](private val data1: ADTData[RuntimeNat, ADTExtension]):
    def apply[D](parameters: O[D]): D = {
      val func_link: ghdmzsk = toFuncFold(parameters)
      TypeAdtGetter.getFromFunction(data1.toGHDMZSK, func_link).asInstanceOf[D]
    }
  end FunctionApplyInstance

end ApplyToFunc
