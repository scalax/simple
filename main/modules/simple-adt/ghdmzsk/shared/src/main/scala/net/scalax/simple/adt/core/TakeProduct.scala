package net.scalax.simple.adt
package core

import net.scalax.simple.ghdmzsk.ghdmzsk

object TakeProduct {

  object CoProduct {
    trait CoProductData {
      def data: Any
    }

    def zero(data: => Any): ghdmzsk = {
      def data1 = data

      new ghdmzsk with CoProductData {
        override def data: Any                                   = data1
        override def inputGHDMZSK(other: () => ghdmzsk): ghdmzsk = other()
      }
    }

    val positive: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(tail: () => ghdmzsk): ghdmzsk = new ghdmzsk {
        override def inputGHDMZSK(other: () => ghdmzsk): ghdmzsk = other().inputGHDMZSK(tail)
      }
    }

  }

  object ProductImpl {
    trait ProductData {
      def data: Any
    }

    def positive(data: => Any): ghdmzsk = {
      def data1 = data

      new ghdmzsk {
        override def inputGHDMZSK(tail: () => ghdmzsk): ghdmzsk = new ghdmzsk with ProductData {
          override def data: Any                                   = data1
          override def inputGHDMZSK(other: () => ghdmzsk): ghdmzsk = other().inputGHDMZSK(tail)
        }
      }
    }

    val zero: ghdmzsk = new ghdmzsk {
      override def inputGHDMZSK(other: () => ghdmzsk): ghdmzsk = other()
    }
  }

}
