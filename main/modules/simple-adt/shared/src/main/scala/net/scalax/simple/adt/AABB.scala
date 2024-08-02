package net.scalax.simple.adt

import net.scalax.simple.adt.builder.DataTaker
import net.scalax.simple.ghdmzsk.ghdmzsk

object CCDD {

  trait P1[-Data]

  trait Positive2[+T, Tail <: P1[Data], -Data] extends P1[Data] {
    def folddd(f: T => Data): Tail
  }

  trait PZero3[-Data, Succeed] extends P1[Data] {
    def value[U <: Data](implicit cv: Succeed <:< ADTPassedFunction.type): U
  }

}
