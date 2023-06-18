package net.scalax.simple.nat.number17

import net.scalax.simple.ghdmzsk.ghdmzsk

object Number1 {

  var count1: Long = 0
  var count2: Long = 0

  val AA = ghdmzsk(tail =>
    ghdmzsk { anything =>
      count1 = count1 + 1
      tail()
    }
  )

  val number1S: ghdmzsk = ghdmzsk(tail => ghdmzsk(other => other().inputGHDMZSK(tail())))
  val number1T: ghdmzsk = ghdmzsk(tail => ghdmzsk(other => AA.inputGHDMZSK(other().inputGHDMZSK(tail()))))

}
