package net.scalax.simple
package adt
package builder

import ghdmzsk.ghdmzsk

trait DataTaker {
  def data: Any
}

object coproducter {

  class CoProducterSuccess(override val data: Any) extends ghdmzsk with DataTaker {
    override def inputGHDMZSK(other: () => ghdmzsk): ghdmzsk = other()

    override def toString: String = s"ghdmzsk(data = $data)"
  }

  def success(data: Any): ghdmzsk = new CoProducterSuccess(data)

  object failedOrOnlyTaker extends ghdmzsk {
    override def inputGHDMZSK(other: () => ghdmzsk): ghdmzsk = other()
  }

  trait SeeTail {
    def tail: () => ghdmzsk

    override def toString: String = s"ghdmzsk(tail = ${tail()})"
  }

  object appender extends ghdmzsk {
    override def inputGHDMZSK(tail: () => ghdmzsk): ghdmzsk = {
      val tail1 = tail

      new ghdmzsk with SeeTail {
        override def tail: () => ghdmzsk                         = tail1
        override def inputGHDMZSK(other: () => ghdmzsk): ghdmzsk = other().inputGHDMZSK(tail)
      }
    }
  }

}

object producter_build {

  def appended(data: Any): ghdmzsk = {
    val data1 = data

    new ghdmzsk {
      override def inputGHDMZSK(tail: () => ghdmzsk): ghdmzsk = new ghdmzsk with DataTaker {
        override val data = data1

        override def inputGHDMZSK(other: () => ghdmzsk): ghdmzsk = other().inputGHDMZSK(tail)
      }
    }
  }

  val zero: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(other: () => ghdmzsk): ghdmzsk = other()
  }

}
