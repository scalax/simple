package net.scalax.simple.adt

import net.scalax.simple.ghdmzsk.ghdmzsk
import temp._
import net.scalax.simple.adt.{RuntimeData, RuntimeNat, RuntimeZero}
import builder.{coproducter, producter_build}

trait ADTPassedFunctionImpl1 {

  /*implicit class extra1[ParamType, I1, ADTExtension](private val data1: ADTData[RuntimeData[I1, RuntimeZero], ADTExtension]) {

    def fold[D](func1: Tuple1[I1 => D]): D = {
      val func_link: ghdmzsk = producter_build.appended(func1._1).inputGHDMZSK(() => producter_build.zero)

      TypeAdtGetter.getFromFunction(data1.toGHDMZSK, func_link).asInstanceOf[D]
    }

  }*/

}
