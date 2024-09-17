package net.scalax.simple.adt
package utils

import net.scalax.simple.ghdmzsk.ghdmzsk
import net.scalax.simple.adt.builder.producter_build

trait ResultFolderAny extends ResultFolder[Any, ({ type MX[_] = Any })#MX, Any] {
  override def apply[TD >: Any](f: Any => TD): Any
}

class ResultFolderAnyPositive(adtGhdmzsk: ghdmzsk, tail: ghdmzsk, index: Int) extends ResultFolderAny {
  override def apply[TD >: Any](f: Any => TD): Any = {
    if (index > 0) {
      new ResultFolderAnyPositive(
        adtGhdmzsk = adtGhdmzsk,
        new ghdmzsk {
          override def inputGHDMZSK(t: () => ghdmzsk): ghdmzsk = tail.inputGHDMZSK(() => producter_build.appended(f).inputGHDMZSK(t))
        },
        index - 1
      )
    } else {
      TypeAdtGetter.getFromFunction(
        adtGhdmzsk,
        tail.inputGHDMZSK(() => producter_build.appended(f).inputGHDMZSK(() => producter_build.zero))
      )
    }
  }
}

object ResultFolderImpl {

  private val identityGhdmzsk: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(t: () => ghdmzsk): ghdmzsk = t()
  }

  private def initImpl2(adtGhdmzsk: ghdmzsk, index: Int): ResultFolderAny =
    new ResultFolderAnyPositive(adtGhdmzsk, identityGhdmzsk, index - 1)

  def init[Data, Tail[_] <: Any, Result](adtGhdmzsk: ghdmzsk, index: Int): ResultFolder[Data, Tail, Result] =
    initImpl2(adtGhdmzsk, index).asInstanceOf[ResultFolder[Data, Tail, Result]]

}
