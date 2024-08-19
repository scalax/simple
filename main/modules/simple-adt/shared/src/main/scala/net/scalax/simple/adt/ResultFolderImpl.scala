package net.scalax.simple.adt
package utils

import net.scalax.simple.ghdmzsk.ghdmzsk
import net.scalax.simple.adt.builder.producter_build

class ResultFolderImpl[Data, Tail[_] <: Any, Result](adtGhdmzsk: ghdmzsk, tailGhdmzsk: ghdmzsk, index: Int)
    extends ResultFolder[Data, Tail, Result] {

  override def apply[TD >: Result](f: Data => TD): Tail[TD] = {

    if (index == 1) {

      val getter: Any = TypeAdtGetter.getFromFunction(
        adtGhdmzsk,
        tailGhdmzsk.inputGHDMZSK(() => producter_build.appended(f).inputGHDMZSK(() => producter_build.zero))
      )
      getter.asInstanceOf[Tail[TD]]

    } else {

      val nextFuncGhdmzsk: ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(t: () => ghdmzsk): ghdmzsk = tailGhdmzsk.inputGHDMZSK(() => producter_build.appended(f).inputGHDMZSK(t))
      }

      val result = new ResultFolderImpl[Any, ({ type MX[A] = Any })#MX, Any](
        adtGhdmzsk = adtGhdmzsk,
        tailGhdmzsk = nextFuncGhdmzsk,
        index = index - 1
      )

      result.asInstanceOf[Tail[TD]]

    }

  }
}

object ResultFolderImpl {
  private val identityGhdmzsk: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(t: () => ghdmzsk): ghdmzsk = t()
  }
  def init[Data, Tail[_] <: Any, Result](adtGhdmzsk: ghdmzsk, index: Int): ResultFolderImpl[Data, Tail, Result] =
    new ResultFolderImpl[Data, Tail, Result](adtGhdmzsk = adtGhdmzsk, tailGhdmzsk = identityGhdmzsk, index = index)
}
