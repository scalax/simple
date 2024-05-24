package net.scalax.simple.adt

import net.scalax.simple.ghdmzsk.ghdmzsk

trait ADTData[+N <: RuntimeNat, ADTExtension] {
  def toGHDMZSK: ghdmzsk
}

object ADTData {

  def success[D, T <: RuntimeNat, ADTExtension](data: D): ADTData[RuntimeData[D, T], ADTExtension] =
    new ADTData[RuntimeData[D, T], ADTExtension] {
      override val toGHDMZSK: ghdmzsk = builder.coproducter.success(data)
    }

  def copyTail[D, T <: RuntimeNat, ADTExtension](tailGHDMZSK: ADTData[T, ADTExtension]): ADTData[RuntimeData[D, T], ADTExtension] =
    new ADTData[RuntimeData[D, T], ADTExtension] {
      override val toGHDMZSK: ghdmzsk = builder.coproducter.appender.inputGHDMZSK(() => tailGHDMZSK.toGHDMZSK)
    }

  def zero[In, ADTExtension]: ADTData[RuntimeZero, ADTExtension] =
    new ADTData[RuntimeZero, ADTExtension] {
      override lazy val toGHDMZSK: ghdmzsk = builder.coproducter.success(AdtFunction.defalutValue[In])
    }
}
