package net.scalax.simple.adt
package utils

import net.scalax.simple.ghdmzsk.ghdmzsk
import net.scalax.simple.adt.builder.producter_build

/*class ResultFolderImpl[Data, Tail[_] <: Any, Result](adtGhdmzsk: ghdmzsk, tailGhdmzsk: ghdmzsk, index: Int)
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

class ResultFolderBuilderPositive11(adtGhdmzsk: ghdmzsk, tailGhdmzsk: ResultFolderBuilder) extends ResultFolderBuilder {

  override def toResultFolder: ResultFolder[Any, ({ type MX[A] = Any })#MX, Any] = {
    val nextFuncGhdmzsk: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(t: () => ghdmzsk): ghdmzsk = tailGhdmzsk.inputGHDMZSK(() => producter_build.appended(f).inputGHDMZSK(t))
    }

    new ResultFolderImpl2[Any, ({ type MX[A] = Any })#MX, Any](
      adtGhdmzsk = adtGhdmzsk,
      tailGhdmzsk = t => producter_build.appended(f).inputGHDMZSK(() => t)
    )
  }

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
}*/

/*trait ResultFolderBuilder {
  def toGhdmzsk: ghdmzsk
  def toResultFolder: ResultFolderAny
}

class ResultFolderBuilderPositive(tail: ResultFolderBuilder) extends ResultFolderBuilder {
  /*override def toGhdmzsk(f: Any): ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(t: () => ghdmzsk): ghdmzsk = producter_build.appended(f).inputGHDMZSK(t)
  }*/
  override def toGhdmzsk: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(tail: () => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(t: () => ghdmzsk): ghdmzsk =
    }
  }

  override def toResultFolder: ResultFolderAny = new ResultFolderAny {
    override def ghd: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(t: () => ghdmzsk): ghdmzsk =
        tail.toResultFolder.ghd.inputGHDMZSK(() => producter_build.appended(f).inputGHDMZSK(t))
    }
    override def apply[TD >: Any](f: Any => TD): Any = tail.toResultFolder(producter_build.appended(f).inputGHDMZSK(() => g))
  }
}

class ResultFolderBuilderZero(adtGhdmzsk: ghdmzsk) extends ResultFolderBuilder {
  /*override def toGhdmzsk(f: Any): ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(t: () => ghdmzsk): ghdmzsk = producter_build.appended(f).inputGHDMZSK(t)
  }*/
  override def toGhdmzsk: ghdmzsk

  override def toResultFolder: ResultFolderAny = new ResultFolderAny {
    override def ghd: ghdmzsk
    override def apply[TD >: Any](f: Any => TD): Any = {
      TypeAdtGetter.getFromFunction(adtGhdmzsk, producter_build.appended(f).inputGHDMZSK(() => g))
    }
  }
}*/

/*object ResultFolderImpl {

  /*private def initImpl(adtGhdmzsk: ghdmzsk, index: Int): ResultFolderBuilder = {
    if (index > 0)
      new ResultFolderBuilderPositive(initImpl(adtGhdmzsk, index - 1))
    else
      new ResultFolderBuilderZero(adtGhdmzsk)
  }

  private def initImpl2(adtGhdmzsk: ghdmzsk, index: Int): ResultFolder[Any, ({ type MX[_] = Any })#MX, Any] = {
    val x = initImpl(adtGhdmzsk, index - 1)
    x.toResultFolder(producter_build.zero)
  }*/

  private def initImpl2(adtGhdmzsk: ghdmzsk, index: Int): ResultFolderAnyPositive = {
    new ResultFolderAnyPositive(
      adtGhdmzsk,
      new ghdmzsk {
        override def inputGHDMZSK(t: () => ghdmzsk): ghdmzsk = t()
      },
      index - 1
    )
  }

  def init[Data, Tail[_] <: Any, Result](adtGhdmzsk: ghdmzsk, index: Int): ResultFolder[Data, Tail, Result] =
    initImpl2(adtGhdmzsk, index).asInstanceOf[ResultFolder[Data, Tail, Result]]

}*/

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
