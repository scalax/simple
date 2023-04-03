package net.scalax.simple.nat.number14

import net.scalax.simple.ghdmzsk.ghdmzsk

import scala.annotation.tailrec

object RunMain extends App {

  def count(num: () => ghdmzsk): (Long, Long) = {
    @tailrec
    def countImpl(num: () => ghdmzsk, tag1Impl: Long, tag2Impl: Long): (Long, Long) = {
      val r = num() match {
        case Number.AA(tail) =>
          (tail, tag1Impl + 1, tag2Impl)
        case Number.BB(tail) =>
          (tail, tag1Impl, tag2Impl + 1)
      }
      if (r._2 + r._3 < 100000000)
        countImpl(r._1, r._2, r._3)
      else (r._2, r._3)
    }
    countImpl(num, 0, 0)
  }

  val (g1, g2) = count(() => Number.n1Pos(() => Number.n2Pos)(() => Number.n4Pos)(() => Number.n3Pos))

  println(g1, g2)
  println(BigDecimal(g1) / BigDecimal(g2))

}
