package net.scalax.simple.nat.group01.number_04

import net.scalax.simple.core.App_1
import net.scalax.simple.ghdmzsk.ghdmzsk

import scala.annotation.tailrec

object `喵_Number_04` extends App_1 {

  def genNumber(c: Int): (ghdmzsk, ghdmzsk, ghdmzsk) = {
    lazy val (n1Pos, _): (ghdmzsk, ghdmzsk) = Number.genNumberImpl(positive = Number.number1S, zero = Number.number1T, count = c - 1)
    lazy val (n2Pos, _): (ghdmzsk, ghdmzsk) = Number.genNumberImpl(positive = Number.number3S, zero = Number.number1T, count = c)
    lazy val (n3Pos, _): (ghdmzsk, ghdmzsk) = Number.genNumberImpl(positive = Number.number3S, zero = Number.number3T, count = c)

    (n1Pos, n2Pos, n3Pos)
  }

  def count(except: Int, i1: Long): (Long, Long) = {
    val cGl: BigDecimal = BigDecimal(i1 - 1)
    var length1: Long   = 0
    var length2: Long   = 0

    val (n1, n2, n3) = genNumber(except)
    val gen          = () => n1.inputGHDMZSK(n2).inputGHDMZSK(n2).inputGHDMZSK(n2).inputGHDMZSK(n3)

    @tailrec
    def countImpl(num: () => ghdmzsk, needConitie: Long): Unit = {
      val newTail = num() match {
        case Number.AA(tail) =>
          length1 = length1 + 1
          tail
        case Number.BB(tail) =>
          length2 = length2 + 1
          tail
      }

      def r = BigDecimal(length1) / BigDecimal(length2)

      if (needConitie > 0)
        countImpl(newTail, needConitie = needConitie - 1)
      else if (length2 == 0)
        countImpl(newTail, needConitie = 10000)
      else if ((cGl - r).abs > BigDecimal("0.0001"))
        countImpl(newTail, needConitie = 10000)
    }

    countImpl(gen, 0)

    (length1, length2)
  }

  for (i <- 1 to 10) {
    val i1: Long       = i * i * i * i * i
    val (g1, g2)       = count(except = i, i1 = i1)
    val i2: BigDecimal = BigDecimal(i1 - 1)
    val r: BigDecimal  = BigDecimal(g1) / BigDecimal(g2)
    println(g1, g2)
    println(i, s"$i ^ 5 - 1", r)
    assert((i2 - r).abs < BigDecimal("0.001"))
  }

}
