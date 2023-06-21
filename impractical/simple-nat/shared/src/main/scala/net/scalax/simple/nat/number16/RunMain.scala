package net.scalax.simple.nat.number16

import net.scalax.simple.ghdmzsk.ghdmzsk

import scala.annotation.tailrec

object RunMain {

  println("aabbcc" * 100)
  println("58795-" * 100)

  val anythingNumber: ghdmzsk = ghdmzsk(t => t())

  def count(number: => ghdmzsk): Long = {
    Number1.count1 = 0
    Number1.count2 = 0
    @tailrec
    def countImpl(c: => ghdmzsk): Long = {
      val nextTail = c.inputGHDMZSK(anythingNumber)
      countImpl(nextTail)
    }
    try countImpl(number)
    catch {
      case e: StackOverflowError =>
    }
    Number1.count1 + Number1.count2
  }

  lazy val zeroGhdmzsk: ghdmzsk = Number1.number1S.inputGHDMZSK(zeroGhdmzsk)

  def numT(i: Int): ghdmzsk = {
    if (i > 0) {
      val num1Result: ghdmzsk = numT(i - 1)
      Number1.number1T.inputGHDMZSK(num1Result)
    } else
      zeroGhdmzsk
  }

  def main(arr: Array[String]): Unit = {
    for {
      i1 <- 0 to 20
      i2 <- 0 to 20
    } yield {
      lazy val num1Count: ghdmzsk = numT(i1)
      lazy val num2Count: ghdmzsk = numT(i2)

      val except: BigDecimal = BigDecimal(i1) + BigDecimal(i2)
      val r1                 = count(num1Count.inputGHDMZSK(num2Count))

      println(i1, '+', i2, '=', except, r1)
      assert(r1 == i1 + i2)
    }
  }

}
