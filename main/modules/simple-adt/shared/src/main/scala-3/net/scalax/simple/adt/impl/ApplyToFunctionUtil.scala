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

    trait ApplyD[Param <: Tuple, D] {
      def apply[Func1](using util.TupledFunction[Func1, Param => D]): Func1 = {
        val func1: Param => D = { od =>
          val func_link: ghdmzsk = toFuncFold(od)
          TypeAdtGetter.getFromFunction(data1.toGHDMZSK, func_link).asInstanceOf[D]
        }

        val tf = summon[util.TupledFunction[Func1, Param => D]]

        tf.untupled(func1)
      }
    }

    def except[D]: ApplyD[O[D], D] = new ApplyD[O[D], D] {
      //
    }
  end FunctionApplyInstance

end ApplyToFunc
