package net.scalax.simple.adt

import net.scalax.simple.adt.builder.DataTaker
import net.scalax.simple.ghdmzsk.ghdmzsk

object TypeAdtGetter {
  def getFromFunction(ghdFromADTData: ghdmzsk, ghdFromFunctionList: ghdmzsk): Any = {
    val function1: Any => Any = ghdFromADTData.inputGHDMZSK(() => ghdFromFunctionList).asInstanceOf[DataTaker].data.asInstanceOf[Any => Any]
    val data1                 = ghdFromADTData.inputGHDMZSK(() => ghdFromADTData).asInstanceOf[DataTaker].data

    function1(data1)
  }
}
