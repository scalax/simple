package net.scalax.simple.adt

import net.scalax.simple.ghdmzsk.ghdmzsk

trait ADTData[+N <: RuntimeNat, S <: AdtExtension] {
  def toGHDMZSK: ghdmzsk
}

object ADTData {

  def success[D, T <: RuntimeNat, S <: AdtExtension](data: D): ADTData[RuntimeData[D, T], S] = new ADTData[RuntimeData[D, T], S] {
    override val toGHDMZSK: ghdmzsk = builder.coproducter.success(data)
  }

  def copyTail[D, T <: RuntimeNat, S <: AdtExtension](tailGHDMZSK: ADTData[T, S]): ADTData[RuntimeData[D, T], S] =
    new ADTData[RuntimeData[D, T], S] {
      override val toGHDMZSK: ghdmzsk = builder.coproducter.appender.inputGHDMZSK(() => tailGHDMZSK.toGHDMZSK)
    }

  def zero[In, ST <: AdtExtension]: ADTData[RuntimeZero, ST] =
    new ADTData[RuntimeZero, ST] {
      override lazy val toGHDMZSK: ghdmzsk = builder.coproducter.success(AdtFunction.defalutValue[In])
    }
}
