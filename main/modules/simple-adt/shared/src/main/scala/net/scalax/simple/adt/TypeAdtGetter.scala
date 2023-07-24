package net.scalax.simple.adt

import net.scalax.simple.adt.implemention.Disscure
import net.scalax.simple.ghdmzsk.ghdmzsk

object TypeAdtGetter {
  def fromList(list: List[Any => Any]): ghdmzsk = {
    def fromGhdmzsk(l: List[Any => Any]): ghdmzsk = {
      if (l.isEmpty) {
        def selfModel: ghdmzsk = Disscure.genImpl1(List.empty).inputGHDMZSK(selfModel)
        selfModel
      } else {
        Disscure.genImpl1(l.head).inputGHDMZSK(fromGhdmzsk(l.tail))
      }
    }

    fromGhdmzsk(list)
  }
}
