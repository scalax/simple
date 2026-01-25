package net.scalax.simple.adt
package utils

import net.scalax.simple.ghdmzsk.ghdmzsk
import net.scalax.simple.adt.builder.producter_build

trait ResultFolderAny extends ResultFolder[Any, ({ type MX[_] = Any })#MX, Any] {
  override def apply[TD >: Any](f: Any => TD): Any
}

trait ResultFolderBuilder {
  def toResultFolder(adtGhdmzsk: ghdmzsk, tailGhdmzsk: ghdmzsk): Any
}

case class ResultFolderBuilderPositive(tail: ResultFolderBuilder) extends ResultFolderBuilder {
  override def toResultFolder(adtGhdmzsk: ghdmzsk, tailGhdmzsk: ghdmzsk): Any =
    new ResultFolderAny {
      override def apply[TD >: Any](f: Any => TD): Any = tail.toResultFolder(
        adtGhdmzsk,
        new ghdmzsk {
          override def inputGHDMZSK(t: () => ghdmzsk): ghdmzsk = tailGhdmzsk.inputGHDMZSK(() => producter_build.appended(f).inputGHDMZSK(t))
        }
      )
    }
}

object ResultFolderBuilderZero extends ResultFolderBuilder {
  override def toResultFolder(adtGhdmzsk: ghdmzsk, tailGhdmzsk: ghdmzsk): Any =
    TypeAdtGetter.getFromFunction(adtGhdmzsk, tailGhdmzsk.inputGHDMZSK(() => producter_build.zero))
}

object ResultFolderBuilder {

  val identityGhdmzsk: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(t: () => ghdmzsk): ghdmzsk = t()
  }

}
