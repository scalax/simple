package net.scalax.simple
package adt
package builder

import ghdmzsk.ghdmzsk

trait DataTaker {
  def data: Any
}

object coproducter {

  def success(data: Any): ghdmzsk = {
    val data1 = data

    new ghdmzsk with DataTaker {
      override val data: Any = data1

      override def inputGHDMZSK(other: () => ghdmzsk): ghdmzsk = other()
    }
  }

  val failedOrOnlyTaker: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(other: () => ghdmzsk): ghdmzsk = other()
  }

  val appender: ghdmzsk = new ghdmzsk {
    override def inputGHDMZSK(tail: () => ghdmzsk): ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(other: () => ghdmzsk): ghdmzsk = other().inputGHDMZSK(tail)
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
