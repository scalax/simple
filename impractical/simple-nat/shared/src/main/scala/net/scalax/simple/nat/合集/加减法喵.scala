package net.scalax.simple.nat.合集

import net.scalax.simple.ghdmzsk.ghdmzsk

import scala.annotation.tailrec

object 加减法喵 {

  def main(arr: Array[String]): Unit = {
    val num1: Int            = 281
    val num2: Int            = 68
    val num3: Int            = 349
    val num1GHDMZSK: ghdmzsk = 合集.gen(合集.nums.s1, 合集.nums.s5, num1)
    val num2GHDMZSK: ghdmzsk = 合集.gen(合集.nums.s1, 合集.nums.s3, num2)
    val num3GHDMZSK: ghdmzsk = 合集.gen(合集.nums.s6, 合集.nums.s4, num3)

    val execResultForInput: ghdmzsk = num1GHDMZSK.inputGHDMZSK(num2GHDMZSK).inputGHDMZSK(num3GHDMZSK)

    {
      @tailrec
      def forCountExec(forCount: ghdmzsk, long1: Long, long2: Long): Unit = {
        if ((long1 + long2) % 821L == 0L) {
          println(s"long1:$long1, long2: $long2, 临时结果: ${long1 - long2}")
          // assert((long1 - long2).abs < 2000)
        }

        val temp1: ghdmzsk = forCount.inputGHDMZSK(合集.testorLeft)

        if (forCount eq temp1) {
          forCountExec(temp1.inputGHDMZSK(合集.testorRight), long1 = long1 + 1, long2 = long2)
        } else {
          forCountExec(temp1, long1 = long1, long2 = long2 + 1)
        }
      }

      forCountExec(execResultForInput, 1, 1)
    }
  }

}
